package com.kschool.kafka;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;



public class FactoriaKpi {

 private static long idevent=7000;

   private String[] sistemas= {"MVP","SMPH","TOL","SSO","SMPH","SMPH","MVP","MVP","SSO","SMPH"};
   private String[] estado= {"OK","KO","OK","OK","OK"};
   private String[] operaciones= {"I-LOGADOPARTICULARES","I-LOGADOSIEBEL","I-LOGADOPARTICULARES", "I-CONTARIFA","I-ACTTARIFA","I-COMPRA-MOVIL","I-COMPRA-MOVIL","I-CONCONSUMO","I-CONCONSUMO","I-LOGADOSIEBEL","I-LOGADOSIEBEL"};
   private String[] tCliente= {"CLIENTEPOSPAGO","CLIENTEPREPAGO","CLIENTEPOSPAGO","EMPRESA","PERFIL_MICROEMPRESA","CLIENTEPOSPAGO","PERFIL_MICROEMPRESA"};
  
     private Properties properties;
    public static final String KPI_DATE_PATTERN = "YYYY-MM-dd'T'HH:mm:ss.SSS";
    
     public  FactoriaKpi(){
         properties= getFactoriaKpiConfig();
     } // default
    
    public  FactoriaKpi(long iniIdEvent){
        idevent = iniIdEvent;
    }
   
    public Kpi getKpi(){
        Kpi newKpi =  new Kpi();
       
       
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, -2);
        long millisTime = calendar.getTimeInMillis();
        long millis =millisTime % 10000;
        long lSystem =millisTime % sistemas.length;
        long lestado =millisTime % estado.length;
        long loperaciones =millisTime % operaciones.length;
        long ltCliente =millisTime % tCliente.length;
       
        String smillis =String.valueOf(millis);
        Date date =  calendar.getTime();
        String initdate = this.toString(date, KPI_DATE_PATTERN)+"Z";
     
        newKpi.setIdevent(String.valueOf(idevent++));
        newKpi.setInitdate(initdate);
        int iSystem= Integer.parseInt(String.valueOf(lSystem));
        String system = sistemas[iSystem];
        newKpi.setSys_namet(system);
       
        int iEstado= Integer.parseInt(String.valueOf(lestado));
        String sEstado = estado[iEstado];
        newKpi.setState(sEstado);
       
        int iOpe= Integer.parseInt(String.valueOf(loperaciones));
        String sOperaciones = operaciones[iOpe];
        newKpi.setOp_namet(sOperaciones);
       
        newKpi.setOpt_namet(properties.getProperty("OPT_NAMET"));
       
        newKpi.setSender(properties.getProperty("SENDER"));
       
        newKpi.setLength(smillis);
        newKpi.setUsername(String.valueOf("6"+smillis+smillis));
   
        int iltCliente= Integer.parseInt(String.valueOf(ltCliente));
        String sltCliente = tCliente[iltCliente];
        newKpi.setTc_namet(sltCliente);
       
        newKpi.setMastersystemerror("null");
        newKpi.setMdwerror("null");
        newKpi.setFunctionalerror("null");
       
        if ("KO".equals(sEstado)){
            long ierror =millisTime % 3;
            if (ierror==0)         newKpi.setMastersystemerror("COERROR-Maste-"+ierror);
            if (ierror==1)         newKpi.setMdwerror("COERROR-Mdwerror"+ierror);
            if (ierror==2)         newKpi.setFunctionalerror("COERROR-Functional"+ierror);
               
        } 
        return newKpi;
    }
   
     private Properties getFactoriaKpiConfig(){
        Properties properties = new Properties();
   
        properties.put("OPT_NAMET", "Consulta");
        properties.put("SENDER", "Middleware");
        properties.put("USERNAME", "612123123");
       
       
        return properties;
     }
     
     public  String toString(Date date, String pattern)
        {
            String fecha = null;
            try
            {
                if(date!=null && pattern!=null && pattern.trim().length()>0)
                {
                    DateFormat df = new SimpleDateFormat(pattern);
                    df.setTimeZone(TimeZone.getTimeZone("Europe/Madrid"));
                    fecha = df.format(date);
                }
            }
            catch(Exception e)
            {
                 System.out.println("No se puede convertir la fecha");
            }
            return fecha;
        }
}
//IDEVENT,INITDATE,SYS_NAMET,OP_NAMET,OPT_NAMET,SENDER,LENGTH,USERNAME,CT_NAMET,STATE,FUNCTIONALERROR,MASTERSYSTEMERROR,MDWERROR
//5623151,11/01/2016 16:01:13,MVP,I-OBTENERLINEASCUENTA,Consulta,Middleware,690,99999422E,AUTORIZADO,OK,null,null,null