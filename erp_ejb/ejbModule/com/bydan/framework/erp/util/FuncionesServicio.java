package com.bydan.framework.erp.util;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.bydan.erp.activosfijos.business.logic.ActivosFijosLogic;
import com.bydan.erp.cartera.business.logic.CarteraLogic;
import com.bydan.erp.comisiones.business.logic.ComisionesLogic;
import com.bydan.erp.contabilidad.business.logic.ContabilidadLogic;
import com.bydan.erp.facturacion.business.logic.FacturacionLogic;
import com.bydan.erp.importaciones.business.logic.ImportacionesLogic;
import com.bydan.erp.inventario.business.logic.InventarioLogic;
import com.bydan.erp.nomina.business.logic.NominaLogic;
import com.bydan.erp.produccion.business.logic.ProduccionLogic;
import com.bydan.erp.puntoventa.business.logic.PuntoVentaLogic;
import com.bydan.erp.seguridad.business.logic.SeguridadLogic;
import com.bydan.erp.sris.business.logic.SrisLogic;
import com.bydan.erp.tesoreria.business.logic.TesoreriaLogic;
import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;

@SuppressWarnings("unused")
public class FuncionesServicio {
	
	public static void PublicarServicioRmi(SecurityManager securityManager,String sNameServicio,String sNameServicioCompleto,Integer iCount, Remote remoteInterface,Remote objectSessionRemote) throws Exception { 
		//,Class<?> clas
		
		if (System.getSecurityManager() == null) {
            System.setSecurityManager(securityManager);
        }
		
        try {
        	
        	//System.out.println(System.getProperty("java.rmi.server.codebase"));
        	
        	Registry registry = LocateRegistry.getRegistry(Constantes.SSERVICIO_RMI_IP,Constantes.SSERVICIO_RMI_PORT);                                 	
                        
            registry.rebind(sNameServicio, remoteInterface);
            
            System.out.println(iCount+") Servicio "+sNameServicioCompleto + " Inicializado.... ");
            
        } catch (Exception e) {
           e.printStackTrace();
           
           throw e;
        }
	}
	
	public static Remote GetServicioRmi(String sNameServicio) throws Exception {
		//,Class<?> clas
		
		Remote remoteInterface=null;//new Remote();
		
        if (System.getSecurityManager() == null) {
        	SecurityManager securityManager=new SecurityManager();
        	
            System.setSecurityManager(securityManager);
        }
        
        try {
        	        	        	
            Registry registry = LocateRegistry.getRegistry(Constantes.SSERVICIO_RMI_IP,Constantes.SSERVICIO_RMI_PORT);
            
            remoteInterface = registry.lookup(sNameServicio);
                                               
        } catch (Exception e) {
           e.printStackTrace();
           
           throw e;
        }
        
        return remoteInterface;
    }  
	
	/*
	 public static void main(String[] args) {
	        if (System.getSecurityManager() == null) {
	            System.setSecurityManager(new SecurityManager());
	        }
	        try {
	        	
	        	//System.err.println(System.getProperty("user.dir"));
	        	
	        	System.out.println(System.getProperty("java.rmi.server.codebase"));//, pathToCodebase);
	        	
	            String name = "Calcular";
	            
	            Calcular calcular = new Calcular();
	            
	            CalcularInterface calcularStub = (CalcularInterface) UnicastRemoteObject.exportObject(calcular, 0);
	            
	            Registry registry = LocateRegistry.getRegistry("127.0.0.1",1099);
	            
	            registry.rebind(name, calcularStub);
	            
	            System.out.println("Calcular bound");
	            
	        } catch (Exception e) {
	            System.err.println("Calcular Excepcion:");
	            e.printStackTrace();
	        }
	    } 
	*/ 	
	
	public static void main(String[] args) {
		SecurityManager securityManager=new SecurityManager();
		DatoGeneralMinimo datoGeneralMinimo=new DatoGeneralMinimo();
		Boolean conReportesProcesos=true;
		
		double dStart = 0; 
		double dEnd = 0; 
		double dDif = 0; 
		double dDifSeg = 0; 
		
		dStart=(double)System.currentTimeMillis();
		
		 if (System.getSecurityManager() == null) {
			 System.setSecurityManager(securityManager);
	     }
		 
		 /*
		 ActivosFijosLogic.PublicarServiciosRmiActivosFijos(securityManager,datoGeneralMinimo,conReportesProcesos);
		 CarteraLogic.PublicarServiciosRmiCartera(securityManager,datoGeneralMinimo,conReportesProcesos);			
		 ComisionesLogic.PublicarServiciosRmiComisiones(securityManager,datoGeneralMinimo,conReportesProcesos);
		 ContabilidadLogic.PublicarServiciosRmiContabilidad(securityManager,datoGeneralMinimo,conReportesProcesos);
		 FacturacionLogic.PublicarServiciosRmiFacturacion(securityManager,datoGeneralMinimo,conReportesProcesos);
		 ImportacionesLogic.PublicarServiciosRmiImportaciones(securityManager,datoGeneralMinimo,conReportesProcesos);
		 InventarioLogic.PublicarServiciosRmiInventario(securityManager,datoGeneralMinimo,conReportesProcesos);		 
		 NominaLogic.PublicarServiciosRmiNomina(securityManager,datoGeneralMinimo,conReportesProcesos);			
		 ProduccionLogic.PublicarServiciosRmiProduccion(securityManager,datoGeneralMinimo,conReportesProcesos);		 
		 */
		 
		//PuntoVentaLogic.PublicarServiciosRmiPuntoVenta(securityManager,datoGeneralMinimo,conReportesProcesos);			
		 
		 //SeguridadLogic.PublicarServiciosRmiSeguridad(securityManager,datoGeneralMinimo,conReportesProcesos);
		 /*
		 SrisLogic.PublicarServiciosRmiSris(securityManager,datoGeneralMinimo,conReportesProcesos);		 
		 TesoreriaLogic.PublicarServiciosRmiTesoreria(securityManager,datoGeneralMinimo,conReportesProcesos);
		 */
		 
		 dEnd =(double)System.currentTimeMillis();
		 
		 dDif=dEnd - dStart;
		 dDifSeg=dDif / 1000;
		 
		 System.out.println("Tiempo Carga Servicios RMI: " + dDif + "(ms) --> " + dDifSeg + "(seg)");
	}
}
