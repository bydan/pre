/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.comisiones.business.logic;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.util.Date;
import java.util.Calendar;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;


//VALIDACION
import org.hibernate.validator.ClassValidator;
import org.hibernate.validator.InvalidValue;

import com.bydan.framework.ConstantesCommon;
import com.bydan.framework.erp.business.entity.GeneralEntityLogic;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.DatoGeneralMaximo;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.comisiones.util.ComisionVentaCobroConstantesFunciones;
import com.bydan.erp.comisiones.util.ComisionVentaCobroParameterReturnGeneral;
//import com.bydan.erp.comisiones.util.ComisionVentaCobroParameterGeneral;
import com.bydan.erp.comisiones.business.entity.ComisionVentaCobro;
import com.bydan.erp.comisiones.business.logic.ComisionVentaCobroLogicAdditional;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.comisiones.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class ComisionVentaCobroLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ComisionVentaCobroLogic.class);
	
	protected ComisionVentaCobroDataAccess comisionventacobroDataAccess; 	
	protected ComisionVentaCobro comisionventacobro;
	protected List<ComisionVentaCobro> comisionventacobros;
	protected Object comisionventacobroObject;	
	protected List<Object> comisionventacobrosObject;
	
	public static ClassValidator<ComisionVentaCobro> comisionventacobroValidator = new ClassValidator<ComisionVentaCobro>(ComisionVentaCobro.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ComisionVentaCobroLogicAdditional comisionventacobroLogicAdditional=null;
	
	public ComisionVentaCobroLogicAdditional getComisionVentaCobroLogicAdditional() {
		return this.comisionventacobroLogicAdditional;
	}
	
	public void setComisionVentaCobroLogicAdditional(ComisionVentaCobroLogicAdditional comisionventacobroLogicAdditional) {
		try {
			this.comisionventacobroLogicAdditional=comisionventacobroLogicAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	/*
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
	
	protected DatosDeep datosDeep;
	protected Boolean isConDeep=false;
	*/
	
	
	
	
	public  ComisionVentaCobroLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.comisionventacobroDataAccess = new ComisionVentaCobroDataAccess();
			
			this.comisionventacobros= new ArrayList<ComisionVentaCobro>();
			this.comisionventacobro= new ComisionVentaCobro();
			
			this.comisionventacobroObject=new Object();
			this.comisionventacobrosObject=new ArrayList<Object>();
				
			/*
			this.connexion=new Connexion();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			this.datosDeep=new DatosDeep();
			this.isConDeep=false;
			*/
			
			this.comisionventacobroDataAccess.setConnexionType(this.connexionType);
			this.comisionventacobroDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ComisionVentaCobroLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.comisionventacobroDataAccess = new ComisionVentaCobroDataAccess();
			this.comisionventacobros= new ArrayList<ComisionVentaCobro>();
			this.comisionventacobro= new ComisionVentaCobro();
			this.comisionventacobroObject=new Object();
			this.comisionventacobrosObject=new ArrayList<Object>();
			
			/*
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			this.datosDeep=new DatosDeep();
			this.isConDeep=false;
			*/
			
			this.comisionventacobroDataAccess.setConnexionType(this.connexionType);
			this.comisionventacobroDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ComisionVentaCobro getComisionVentaCobro() throws Exception {	
		ComisionVentaCobroLogicAdditional.checkComisionVentaCobroToGet(comisionventacobro,this.datosCliente,this.arrDatoGeneral);
		ComisionVentaCobroLogicAdditional.updateComisionVentaCobroToGet(comisionventacobro,this.arrDatoGeneral);
		
		return comisionventacobro;
	}
		
	public void setComisionVentaCobro(ComisionVentaCobro newComisionVentaCobro) {
		this.comisionventacobro = newComisionVentaCobro;
	}
	
	public ComisionVentaCobroDataAccess getComisionVentaCobroDataAccess() {
		return comisionventacobroDataAccess;
	}
	
	public void setComisionVentaCobroDataAccess(ComisionVentaCobroDataAccess newcomisionventacobroDataAccess) {
		this.comisionventacobroDataAccess = newcomisionventacobroDataAccess;
	}
	
	public List<ComisionVentaCobro> getComisionVentaCobros() throws Exception {		
		this.quitarComisionVentaCobrosNulos();
		
		ComisionVentaCobroLogicAdditional.checkComisionVentaCobroToGets(comisionventacobros,this.datosCliente,this.arrDatoGeneral);
		
		for (ComisionVentaCobro comisionventacobroLocal: comisionventacobros ) {
			ComisionVentaCobroLogicAdditional.updateComisionVentaCobroToGet(comisionventacobroLocal,this.arrDatoGeneral);
		}
		
		return comisionventacobros;
	}
	
	public void setComisionVentaCobros(List<ComisionVentaCobro> newComisionVentaCobros) {
		this.comisionventacobros = newComisionVentaCobros;
	}
	
	public Object getComisionVentaCobroObject() {	
		this.comisionventacobroObject=this.comisionventacobroDataAccess.getEntityObject();
		return this.comisionventacobroObject;
	}
		
	public void setComisionVentaCobroObject(Object newComisionVentaCobroObject) {
		this.comisionventacobroObject = newComisionVentaCobroObject;
	}
	
	public List<Object> getComisionVentaCobrosObject() {		
		this.comisionventacobrosObject=this.comisionventacobroDataAccess.getEntitiesObject();
		return this.comisionventacobrosObject;
	}
		
	public void setComisionVentaCobrosObject(List<Object> newComisionVentaCobrosObject) {
		this.comisionventacobrosObject = newComisionVentaCobrosObject;
	}
	
	/*
	public Connexion getConnexion() {
		return this.connexion;		
	}
	
	public void setConnexion(Connexion newConnexion) {
		this.connexion=newConnexion;		
	}
	
	public DatosCliente getDatosCliente() {
		return datosCliente;
	}
	*/
	
	public void setDatosCliente(DatosCliente datosCliente) {		
		this.datosCliente = datosCliente;
		
		if(this.comisionventacobroDataAccess!=null) {
			this.comisionventacobroDataAccess.setDatosCliente(datosCliente);
		}
	}
	
	/*
	public DatosDeep getDatosDeep() {
		return this.datosDeep;
	}

	public void setDatosDeep(DatosDeep datosDeep) {
		this.datosDeep = datosDeep;
	}
	
	public void setDatosDeepFromDatosCliente() {
		this.datosDeep = this.datosCliente.getDatosDeep();
		this.isConDeep=this.datosCliente.getIsConDeep();
	}
	
	public Boolean getIsConDeep() {
		return this.isConDeep;
	}

	public void setIsConDeep(Boolean isConDeep) {
		this.isConDeep = isConDeep;
	}
	
	public ArrayList<DatoGeneral> getArrDatoGeneral() {
		return arrDatoGeneral;
	}

	public void setArrDatoGeneral(ArrayList<DatoGeneral> arrDatoGeneral) {
		this.arrDatoGeneral = arrDatoGeneral;
	}
	
	public ConnexionType getConnexionType() {
		return connexionType;
	}

	public void setConnexionType(ConnexionType connexionType) {
		this.connexionType = connexionType;
	}


	public ParameterDbType getParameterDbType() {
		return parameterDbType;
	}

	public void setParameterDbType(ParameterDbType parameterDbType) {
		this.parameterDbType = parameterDbType;
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	*/
	
			
	public void setDatosDeepParametros(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String strTituloMensaje) {
		this.datosDeep.setIsDeep(isDeep);
		this.datosDeep.setDeepLoadType(deepLoadType);
		this.datosDeep.setClases(clases);
		this.datosDeep.setSTituloMensaje(strTituloMensaje);
	}
	
	public InvalidValue[] getInvalidValues() {
		return invalidValues;
	}

	public void setInvalidValues(InvalidValue[] invalidValues) {
		this.invalidValues = invalidValues;
	}
	
	public StringBuilder getStringBuilder() {
		return this.stringBuilder;
	}

	public void setStringBuilder(StringBuilder stringBuilder) {
		this.stringBuilder = stringBuilder;
	}
	
	public Boolean getConMostrarMensajesStringBuilder() {
		return this.conMostrarMensajesStringBuilder;
	}

	public void setConMostrarMensajesStringBuilder(Boolean conMostrarMensajesStringBuilder) {
		this.conMostrarMensajesStringBuilder = conMostrarMensajesStringBuilder;
	}	
	
			
	
	public void getNewConnexionToDeep()throws Exception {
		//this.getNewConnexionToDeep();
		try	{
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,"");connexion.begin();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void getNewConnexionToDeep(String sDetalle)throws Exception {
		try	{
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,sDetalle);connexion.begin();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void commitNewConnexionToDeep()throws Exception {
		try	{
			this.connexion.commit();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void rollbackNewConnexionToDeep()throws Exception {
		try	{
			this.connexion.rollback();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void closeNewConnexionToDeep()throws Exception {
		try	{
			this.connexion.close();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public  void executeQueryWithConnection(String sQueryExecute) throws Exception {
		try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionVentaCobro.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			comisionventacobroDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
			connexion.commit();
						
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public  void executeQuery(String sQueryExecute) throws Exception {
		try {			
			comisionventacobroDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		comisionventacobro = new  ComisionVentaCobro();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionVentaCobro.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			comisionventacobro=comisionventacobroDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.comisionventacobro,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(this.comisionventacobro);
			}
			
			connexion.commit();
						
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public  void getEntity(Long id) throws Exception {
		comisionventacobro = new  ComisionVentaCobro();
		  		  
        try {
			
			comisionventacobro=comisionventacobroDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.comisionventacobro,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(this.comisionventacobro);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		comisionventacobro = new  ComisionVentaCobro();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionVentaCobro.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			comisionventacobro=comisionventacobroDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.comisionventacobro,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(this.comisionventacobro);
			}
			
			connexion.commit();
						
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public  void getEntityWithConnection(String sFinalQuery) throws Exception {
		comisionventacobro = new  ComisionVentaCobro();
		  		  
        try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntityWithConnection(queryWhereSelectParameters);
			
		} catch(Exception e) {
			throw e;
			
      	} finally {
					
		}
	}
	
	public  void getEntity(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		comisionventacobro = new  ComisionVentaCobro();
		  		  
        try {
			
			comisionventacobro=comisionventacobroDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.comisionventacobro,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(this.comisionventacobro);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		comisionventacobro = new  ComisionVentaCobro();
		  		  
        try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntity(queryWhereSelectParameters);
			
		} catch(Exception e) {
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		comisionventacobro = new  ComisionVentaCobro();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionVentaCobro.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =comisionventacobroDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return datoGeneralMinimo;
	}
	
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		comisionventacobro = new  ComisionVentaCobro();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=comisionventacobroDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		comisionventacobro = new  ComisionVentaCobro();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionVentaCobro.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =comisionventacobroDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		comisionventacobro = new  ComisionVentaCobro();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=comisionventacobroDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		comisionventacobro = new  ComisionVentaCobro();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionVentaCobro.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =comisionventacobroDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return datoGeneralMaximos;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		comisionventacobro = new  ComisionVentaCobro();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=comisionventacobroDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		comisionventacobros = new  ArrayList<ComisionVentaCobro>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionVentaCobro.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ComisionVentaCobroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionventacobros=comisionventacobroDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionVentaCobro(comisionventacobros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(this.comisionventacobros);
			}
			
			connexion.commit();			
			
		} catch(Exception e) {
			connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();	
		}
	}
	
	public  void getEntitiesWithConnection(String sFinalQuery)throws Exception {	
		comisionventacobros = new  ArrayList<ComisionVentaCobro>();
		  		  
        try {
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntitiesWithConnection(queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			throw e;
			
      	} finally {
		}
	}
	
	public  void getEntities(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		comisionventacobros = new  ArrayList<ComisionVentaCobro>();
		  		  
        try {			
			ComisionVentaCobroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionventacobros=comisionventacobroDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarComisionVentaCobro(comisionventacobros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(this.comisionventacobros);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		comisionventacobros = new  ArrayList<ComisionVentaCobro>();
		  		  
        try {			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntities(queryWhereSelectParameters);    	       	 			
		
		} catch(Exception e) {	
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		comisionventacobros = new  ArrayList<ComisionVentaCobro>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionVentaCobro.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ComisionVentaCobroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionventacobros=comisionventacobroDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionVentaCobro(comisionventacobros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(this.comisionventacobros);
			}
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntities(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		comisionventacobros = new  ArrayList<ComisionVentaCobro>();
		  		  
        try {
			ComisionVentaCobroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionventacobros=comisionventacobroDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionVentaCobro(comisionventacobros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(this.comisionventacobros);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	/**
	* Trae cualquier tipo de query select
	* @conMapGenerico  Si es true, trae todo como objeto generico, Si es false trae query en campos de la clase, usando unicamente los determinados en listColumns y deepLoadType
	* @deepLoadType  Si conMapGenerico es false trae query select con las columnas de listColumns, incluyento o excludendo deacuerdo a deepLoadType
	*/
	public void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		comisionventacobros = new  ArrayList<ComisionVentaCobro>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionVentaCobro.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionVentaCobroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionventacobros=comisionventacobroDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarComisionVentaCobro(comisionventacobros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(this.comisionventacobros);
			}
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntities(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		comisionventacobros = new  ArrayList<ComisionVentaCobro>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionVentaCobroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionventacobros=comisionventacobroDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarComisionVentaCobro(comisionventacobros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(this.comisionventacobros);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		comisionventacobro = new  ComisionVentaCobro();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionVentaCobro.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionVentaCobroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionventacobro=comisionventacobroDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarComisionVentaCobro(comisionventacobro);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(this.comisionventacobro);
			}
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntity(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		comisionventacobro = new  ComisionVentaCobro();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionVentaCobroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionventacobro=comisionventacobroDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarComisionVentaCobro(comisionventacobro);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(this.comisionventacobro);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		comisionventacobros = new  ArrayList<ComisionVentaCobro>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionVentaCobro.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ComisionVentaCobroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionventacobros=comisionventacobroDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionVentaCobro(comisionventacobros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(this.comisionventacobros);
			}
			
			connexion.commit();			
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntitiesSimpleQueryBuild(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		comisionventacobros = new  ArrayList<ComisionVentaCobro>();
		  		  
        try {
			ComisionVentaCobroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionventacobros=comisionventacobroDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarComisionVentaCobro(comisionventacobros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(this.comisionventacobros);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosComisionVentaCobrosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		comisionventacobros = new  ArrayList<ComisionVentaCobro>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionVentaCobro.class.getSimpleName()+"-getTodosComisionVentaCobrosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionVentaCobroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionventacobros=comisionventacobroDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarComisionVentaCobro(comisionventacobros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(this.comisionventacobros);
			}
			
			connexion.commit();			
			
		} catch(Exception e) {	
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}		
	}
	
	public  void  getTodosComisionVentaCobros(String sFinalQuery,Pagination pagination)throws Exception {
		comisionventacobros = new  ArrayList<ComisionVentaCobro>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ComisionVentaCobroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			comisionventacobros=comisionventacobroDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarComisionVentaCobro(comisionventacobros);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(this.comisionventacobros);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarComisionVentaCobro(ComisionVentaCobro comisionventacobro) throws Exception {
		Boolean estaValidado=false;
		
		if(comisionventacobro.getIsNew() || comisionventacobro.getIsChanged()) { 
			this.invalidValues = comisionventacobroValidator.getInvalidValues(comisionventacobro);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(comisionventacobro);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarComisionVentaCobro(List<ComisionVentaCobro> ComisionVentaCobros) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ComisionVentaCobro comisionventacobroLocal:comisionventacobros) {				
			estaValidadoObjeto=this.validarGuardarComisionVentaCobro(comisionventacobroLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarComisionVentaCobro(List<ComisionVentaCobro> ComisionVentaCobros) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarComisionVentaCobro(comisionventacobros)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarComisionVentaCobro(ComisionVentaCobro ComisionVentaCobro) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarComisionVentaCobro(comisionventacobro)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ComisionVentaCobro comisionventacobro) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+comisionventacobro.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ComisionVentaCobroConstantesFunciones.getComisionVentaCobroLabelDesdeNombre(invalidValue.getPropertyName());
			sMensajeCampo=invalidValue.getMessage();
			
			sMensaje+="\r\n"+sCampo+"->"+sMensajeCampo;
			
			//MOSTRAR CAMPOS INVALIDOS
        }
				
		if(!sMensaje.equals("")) {
			this.stringBuilder.append(sMensaje);	
		}		
	}	
	
	public void manejarMensajesStringBuilder(String sMensajeExcepcion) throws Exception {
		String sMensajeDetalleExcepcion="";
		
		sMensajeDetalleExcepcion=this.stringBuilder.toString();
		
		if(!sMensajeDetalleExcepcion.equals("")) {
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"comisionventacobro","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ComisionVentaCobroConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ComisionVentaCobroConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveComisionVentaCobroWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionVentaCobro.class.getSimpleName()+"-saveComisionVentaCobroWithConnection");connexion.begin();			
			
			ComisionVentaCobroLogicAdditional.checkComisionVentaCobroToSave(this.comisionventacobro,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ComisionVentaCobroLogicAdditional.updateComisionVentaCobroToSave(this.comisionventacobro,this.arrDatoGeneral);
			
			ComisionVentaCobroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.comisionventacobro,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowComisionVentaCobro();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarComisionVentaCobro(this.comisionventacobro)) {
				ComisionVentaCobroDataAccess.save(this.comisionventacobro, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.comisionventacobro,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ComisionVentaCobroLogicAdditional.checkComisionVentaCobroToSaveAfter(this.comisionventacobro,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowComisionVentaCobro();
			
			connexion.commit();			
			
			if(this.comisionventacobro.getIsDeleted()) {
				this.comisionventacobro=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveComisionVentaCobro()throws Exception {	
		try {	
			
			ComisionVentaCobroLogicAdditional.checkComisionVentaCobroToSave(this.comisionventacobro,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ComisionVentaCobroLogicAdditional.updateComisionVentaCobroToSave(this.comisionventacobro,this.arrDatoGeneral);
			
			ComisionVentaCobroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.comisionventacobro,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarComisionVentaCobro(this.comisionventacobro)) {			
				ComisionVentaCobroDataAccess.save(this.comisionventacobro, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.comisionventacobro,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ComisionVentaCobroLogicAdditional.checkComisionVentaCobroToSaveAfter(this.comisionventacobro,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.comisionventacobro.getIsDeleted()) {
				this.comisionventacobro=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveComisionVentaCobrosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionVentaCobro.class.getSimpleName()+"-saveComisionVentaCobrosWithConnection");connexion.begin();			
			
			ComisionVentaCobroLogicAdditional.checkComisionVentaCobroToSaves(comisionventacobros,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowComisionVentaCobros();
			
			Boolean validadoTodosComisionVentaCobro=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ComisionVentaCobro comisionventacobroLocal:comisionventacobros) {		
				if(comisionventacobroLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ComisionVentaCobroLogicAdditional.updateComisionVentaCobroToSave(comisionventacobroLocal,this.arrDatoGeneral);
	        	
				ComisionVentaCobroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),comisionventacobroLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarComisionVentaCobro(comisionventacobroLocal)) {
					ComisionVentaCobroDataAccess.save(comisionventacobroLocal, connexion);				
				} else {
					validadoTodosComisionVentaCobro=false;
				}
			}
			
			if(!validadoTodosComisionVentaCobro) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ComisionVentaCobroLogicAdditional.checkComisionVentaCobroToSavesAfter(comisionventacobros,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowComisionVentaCobros();
			
			connexion.commit();		
			
			this.quitarComisionVentaCobrosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveComisionVentaCobros()throws Exception {				
		 try {	
			ComisionVentaCobroLogicAdditional.checkComisionVentaCobroToSaves(comisionventacobros,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosComisionVentaCobro=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ComisionVentaCobro comisionventacobroLocal:comisionventacobros) {				
				if(comisionventacobroLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ComisionVentaCobroLogicAdditional.updateComisionVentaCobroToSave(comisionventacobroLocal,this.arrDatoGeneral);
	        	
				ComisionVentaCobroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),comisionventacobroLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarComisionVentaCobro(comisionventacobroLocal)) {				
					ComisionVentaCobroDataAccess.save(comisionventacobroLocal, connexion);				
				} else {
					validadoTodosComisionVentaCobro=false;
				}
			}
			
			if(!validadoTodosComisionVentaCobro) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ComisionVentaCobroLogicAdditional.checkComisionVentaCobroToSavesAfter(comisionventacobros,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarComisionVentaCobrosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ComisionVentaCobroParameterReturnGeneral procesarAccionComisionVentaCobros(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ComisionVentaCobro> comisionventacobros,ComisionVentaCobroParameterReturnGeneral comisionventacobroParameterGeneral)throws Exception {
		 try {	
			ComisionVentaCobroParameterReturnGeneral comisionventacobroReturnGeneral=new ComisionVentaCobroParameterReturnGeneral();
	
			ComisionVentaCobroLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,comisionventacobros,comisionventacobroParameterGeneral,comisionventacobroReturnGeneral);
			
			return comisionventacobroReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ComisionVentaCobroParameterReturnGeneral procesarAccionComisionVentaCobrosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ComisionVentaCobro> comisionventacobros,ComisionVentaCobroParameterReturnGeneral comisionventacobroParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionVentaCobro.class.getSimpleName()+"-procesarAccionComisionVentaCobrosWithConnection");connexion.begin();			
			
			ComisionVentaCobroParameterReturnGeneral comisionventacobroReturnGeneral=new ComisionVentaCobroParameterReturnGeneral();
	
			ComisionVentaCobroLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,comisionventacobros,comisionventacobroParameterGeneral,comisionventacobroReturnGeneral);
			
			this.connexion.commit();
			
			return comisionventacobroReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ComisionVentaCobroParameterReturnGeneral procesarEventosComisionVentaCobros(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ComisionVentaCobro> comisionventacobros,ComisionVentaCobro comisionventacobro,ComisionVentaCobroParameterReturnGeneral comisionventacobroParameterGeneral,Boolean isEsNuevoComisionVentaCobro,ArrayList<Classe> clases)throws Exception {
		 try {	
			ComisionVentaCobroParameterReturnGeneral comisionventacobroReturnGeneral=new ComisionVentaCobroParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				comisionventacobroReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ComisionVentaCobroLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,comisionventacobros,comisionventacobro,comisionventacobroParameterGeneral,comisionventacobroReturnGeneral,isEsNuevoComisionVentaCobro,clases);
			
			return comisionventacobroReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ComisionVentaCobroParameterReturnGeneral procesarEventosComisionVentaCobrosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ComisionVentaCobro> comisionventacobros,ComisionVentaCobro comisionventacobro,ComisionVentaCobroParameterReturnGeneral comisionventacobroParameterGeneral,Boolean isEsNuevoComisionVentaCobro,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionVentaCobro.class.getSimpleName()+"-procesarEventosComisionVentaCobrosWithConnection");connexion.begin();			
			
			ComisionVentaCobroParameterReturnGeneral comisionventacobroReturnGeneral=new ComisionVentaCobroParameterReturnGeneral();
	
			comisionventacobroReturnGeneral.setComisionVentaCobro(comisionventacobro);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				comisionventacobroReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ComisionVentaCobroLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,comisionventacobros,comisionventacobro,comisionventacobroParameterGeneral,comisionventacobroReturnGeneral,isEsNuevoComisionVentaCobro,clases);
			
			this.connexion.commit();
			
			return comisionventacobroReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ComisionVentaCobroParameterReturnGeneral procesarImportacionComisionVentaCobrosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ComisionVentaCobroParameterReturnGeneral comisionventacobroParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionVentaCobro.class.getSimpleName()+"-procesarImportacionComisionVentaCobrosWithConnection");connexion.begin();			
			
			ComisionVentaCobroParameterReturnGeneral comisionventacobroReturnGeneral=new ComisionVentaCobroParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.comisionventacobros=new ArrayList<ComisionVentaCobro>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.comisionventacobro=new ComisionVentaCobro();
				
				
				if(conColumnasBase) {this.comisionventacobro.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.comisionventacobro.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.comisionventacobro.setnumero_factura(arrColumnas[iColumn++]);
				this.comisionventacobro.setfecha_pago(Funciones.ConvertToDate(arrColumnas[iColumn++]));
			this.comisionventacobro.setnombre_cliente(arrColumnas[iColumn++]);
				this.comisionventacobro.setnumero_comprobante(arrColumnas[iColumn++]);
				this.comisionventacobro.setestado(arrColumnas[iColumn++]);
				this.comisionventacobro.settotal_factura(Double.parseDouble(arrColumnas[iColumn++]));
				this.comisionventacobro.settotal_abono(Double.parseDouble(arrColumnas[iColumn++]));
				this.comisionventacobro.setporcentaje_comision(Double.parseDouble(arrColumnas[iColumn++]));
				this.comisionventacobro.settotal_comision_cobro(Double.parseDouble(arrColumnas[iColumn++]));
				this.comisionventacobro.setnumero_dias(Integer.parseInt(arrColumnas[iColumn++]));
				
				this.comisionventacobros.add(this.comisionventacobro);
			}
			
			this.saveComisionVentaCobros();
			
			this.connexion.commit();
			
			comisionventacobroReturnGeneral.setConRetornoEstaProcesado(true);
			comisionventacobroReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return comisionventacobroReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarComisionVentaCobrosEliminados() throws Exception {				
		
		List<ComisionVentaCobro> comisionventacobrosAux= new ArrayList<ComisionVentaCobro>();
		
		for(ComisionVentaCobro comisionventacobro:comisionventacobros) {
			if(!comisionventacobro.getIsDeleted()) {
				comisionventacobrosAux.add(comisionventacobro);
			}
		}
		
		comisionventacobros=comisionventacobrosAux;
	}
	
	public void quitarComisionVentaCobrosNulos() throws Exception {				
		
		List<ComisionVentaCobro> comisionventacobrosAux= new ArrayList<ComisionVentaCobro>();
		
		for(ComisionVentaCobro comisionventacobro : this.comisionventacobros) {
			if(comisionventacobro==null) {
				comisionventacobrosAux.add(comisionventacobro);
			}
		}
		
		//this.comisionventacobros=comisionventacobrosAux;
		
		this.comisionventacobros.removeAll(comisionventacobrosAux);
	}
	
	public void getSetVersionRowComisionVentaCobroWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(comisionventacobro.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((comisionventacobro.getIsDeleted() || (comisionventacobro.getIsChanged()&&!comisionventacobro.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=comisionventacobroDataAccess.getSetVersionRowComisionVentaCobro(connexion,comisionventacobro.getId());
				
				if(!comisionventacobro.getVersionRow().equals(timestamp)) {	
					comisionventacobro.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				comisionventacobro.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowComisionVentaCobro()throws Exception {	
		
		if(comisionventacobro.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((comisionventacobro.getIsDeleted() || (comisionventacobro.getIsChanged()&&!comisionventacobro.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=comisionventacobroDataAccess.getSetVersionRowComisionVentaCobro(connexion,comisionventacobro.getId());
			
			try {							
				if(!comisionventacobro.getVersionRow().equals(timestamp)) {	
					comisionventacobro.setVersionRow(timestamp);
				}
				
				comisionventacobro.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowComisionVentaCobrosWithConnection()throws Exception {	
		if(comisionventacobros!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ComisionVentaCobro comisionventacobroAux:comisionventacobros) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(comisionventacobroAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(comisionventacobroAux.getIsDeleted() || (comisionventacobroAux.getIsChanged()&&!comisionventacobroAux.getIsNew())) {
						
						timestamp=comisionventacobroDataAccess.getSetVersionRowComisionVentaCobro(connexion,comisionventacobroAux.getId());
						
						if(!comisionventacobro.getVersionRow().equals(timestamp)) {	
							comisionventacobroAux.setVersionRow(timestamp);
						}
								
						comisionventacobroAux.setIsChangedAuxiliar(false);														
					//}
				}
				
				connexion.commit();									
				
			} catch(Exception e) {
				connexion.rollback();							
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowComisionVentaCobros()throws Exception {	
		if(comisionventacobros!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ComisionVentaCobro comisionventacobroAux:comisionventacobros) {
					if(comisionventacobroAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(comisionventacobroAux.getIsDeleted() || (comisionventacobroAux.getIsChanged()&&!comisionventacobroAux.getIsNew())) {
						
						timestamp=comisionventacobroDataAccess.getSetVersionRowComisionVentaCobro(connexion,comisionventacobroAux.getId());
						
						if(!comisionventacobroAux.getVersionRow().equals(timestamp)) {	
							comisionventacobroAux.setVersionRow(timestamp);
						}
						
													
						comisionventacobroAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ComisionVentaCobroParameterReturnGeneral cargarCombosLoteForeignKeyComisionVentaCobroWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalVendedor,String finalQueryGlobalFactura) throws Exception {
		ComisionVentaCobroParameterReturnGeneral  comisionventacobroReturnGeneral =new ComisionVentaCobroParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionVentaCobro.class.getSimpleName()+"-cargarCombosLoteForeignKeyComisionVentaCobroWithConnection");connexion.begin();
			
			comisionventacobroReturnGeneral =new ComisionVentaCobroParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			comisionventacobroReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			comisionventacobroReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			comisionventacobroReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			comisionventacobroReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			comisionventacobroReturnGeneral.setfacturasForeignKey(facturasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return comisionventacobroReturnGeneral;
	}
	
	public ComisionVentaCobroParameterReturnGeneral cargarCombosLoteForeignKeyComisionVentaCobro(String finalQueryGlobalEmpresa,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalVendedor,String finalQueryGlobalFactura) throws Exception {
		ComisionVentaCobroParameterReturnGeneral  comisionventacobroReturnGeneral =new ComisionVentaCobroParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			comisionventacobroReturnGeneral =new ComisionVentaCobroParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			comisionventacobroReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			comisionventacobroReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			comisionventacobroReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			comisionventacobroReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			comisionventacobroReturnGeneral.setfacturasForeignKey(facturasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return comisionventacobroReturnGeneral;
	}
	
	
	public void deepLoad(ComisionVentaCobro comisionventacobro,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ComisionVentaCobroLogicAdditional.updateComisionVentaCobroToGet(comisionventacobro,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		comisionventacobro.setEmpresa(comisionventacobroDataAccess.getEmpresa(connexion,comisionventacobro));
		comisionventacobro.setEjercicio(comisionventacobroDataAccess.getEjercicio(connexion,comisionventacobro));
		comisionventacobro.setPeriodo(comisionventacobroDataAccess.getPeriodo(connexion,comisionventacobro));
		comisionventacobro.setVendedor(comisionventacobroDataAccess.getVendedor(connexion,comisionventacobro));
		comisionventacobro.setFactura(comisionventacobroDataAccess.getFactura(connexion,comisionventacobro));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				comisionventacobro.setEmpresa(comisionventacobroDataAccess.getEmpresa(connexion,comisionventacobro));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				comisionventacobro.setEjercicio(comisionventacobroDataAccess.getEjercicio(connexion,comisionventacobro));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				comisionventacobro.setPeriodo(comisionventacobroDataAccess.getPeriodo(connexion,comisionventacobro));
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				comisionventacobro.setVendedor(comisionventacobroDataAccess.getVendedor(connexion,comisionventacobro));
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				comisionventacobro.setFactura(comisionventacobroDataAccess.getFactura(connexion,comisionventacobro));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionventacobro.setEmpresa(comisionventacobroDataAccess.getEmpresa(connexion,comisionventacobro));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionventacobro.setEjercicio(comisionventacobroDataAccess.getEjercicio(connexion,comisionventacobro));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionventacobro.setPeriodo(comisionventacobroDataAccess.getPeriodo(connexion,comisionventacobro));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionventacobro.setVendedor(comisionventacobroDataAccess.getVendedor(connexion,comisionventacobro));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionventacobro.setFactura(comisionventacobroDataAccess.getFactura(connexion,comisionventacobro));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		comisionventacobro.setEmpresa(comisionventacobroDataAccess.getEmpresa(connexion,comisionventacobro));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(comisionventacobro.getEmpresa(),isDeep,deepLoadType,clases);
				
		comisionventacobro.setEjercicio(comisionventacobroDataAccess.getEjercicio(connexion,comisionventacobro));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(comisionventacobro.getEjercicio(),isDeep,deepLoadType,clases);
				
		comisionventacobro.setPeriodo(comisionventacobroDataAccess.getPeriodo(connexion,comisionventacobro));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(comisionventacobro.getPeriodo(),isDeep,deepLoadType,clases);
				
		comisionventacobro.setVendedor(comisionventacobroDataAccess.getVendedor(connexion,comisionventacobro));
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(comisionventacobro.getVendedor(),isDeep,deepLoadType,clases);
				
		comisionventacobro.setFactura(comisionventacobroDataAccess.getFactura(connexion,comisionventacobro));
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(comisionventacobro.getFactura(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				comisionventacobro.setEmpresa(comisionventacobroDataAccess.getEmpresa(connexion,comisionventacobro));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(comisionventacobro.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				comisionventacobro.setEjercicio(comisionventacobroDataAccess.getEjercicio(connexion,comisionventacobro));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(comisionventacobro.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				comisionventacobro.setPeriodo(comisionventacobroDataAccess.getPeriodo(connexion,comisionventacobro));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(comisionventacobro.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				comisionventacobro.setVendedor(comisionventacobroDataAccess.getVendedor(connexion,comisionventacobro));
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepLoad(comisionventacobro.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				comisionventacobro.setFactura(comisionventacobroDataAccess.getFactura(connexion,comisionventacobro));
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(comisionventacobro.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionventacobro.setEmpresa(comisionventacobroDataAccess.getEmpresa(connexion,comisionventacobro));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(comisionventacobro.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionventacobro.setEjercicio(comisionventacobroDataAccess.getEjercicio(connexion,comisionventacobro));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(comisionventacobro.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionventacobro.setPeriodo(comisionventacobroDataAccess.getPeriodo(connexion,comisionventacobro));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(comisionventacobro.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionventacobro.setVendedor(comisionventacobroDataAccess.getVendedor(connexion,comisionventacobro));
			VendedorLogic vendedorLogic= new VendedorLogic(connexion);
			vendedorLogic.deepLoad(comisionventacobro.getVendedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			comisionventacobro.setFactura(comisionventacobroDataAccess.getFactura(connexion,comisionventacobro));
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(comisionventacobro.getFactura(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ComisionVentaCobro comisionventacobro,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ComisionVentaCobroLogicAdditional.updateComisionVentaCobroToSave(comisionventacobro,this.arrDatoGeneral);
			
ComisionVentaCobroDataAccess.save(comisionventacobro, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(comisionventacobro.getEmpresa(),connexion);

		EjercicioDataAccess.save(comisionventacobro.getEjercicio(),connexion);

		PeriodoDataAccess.save(comisionventacobro.getPeriodo(),connexion);

		VendedorDataAccess.save(comisionventacobro.getVendedor(),connexion);

		FacturaDataAccess.save(comisionventacobro.getFactura(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(comisionventacobro.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(comisionventacobro.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(comisionventacobro.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(comisionventacobro.getVendedor(),connexion);
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(comisionventacobro.getFactura(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(comisionventacobro.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(comisionventacobro.getEmpresa(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(comisionventacobro.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(comisionventacobro.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(comisionventacobro.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(comisionventacobro.getPeriodo(),isDeep,deepLoadType,clases);
				

		VendedorDataAccess.save(comisionventacobro.getVendedor(),connexion);
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(comisionventacobro.getVendedor(),isDeep,deepLoadType,clases);
				

		FacturaDataAccess.save(comisionventacobro.getFactura(),connexion);
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(comisionventacobro.getFactura(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(comisionventacobro.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(comisionventacobro.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(comisionventacobro.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(comisionventacobro.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(comisionventacobro.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(comisionventacobro.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(comisionventacobro.getVendedor(),connexion);
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepSave(comisionventacobro.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(comisionventacobro.getFactura(),connexion);
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepSave(comisionventacobro.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}

	}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ComisionVentaCobro.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(comisionventacobro,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(comisionventacobro);
			}
			
			this.connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepLoad(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.deepLoad(this.comisionventacobro,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(this.comisionventacobro);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ComisionVentaCobro.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(comisionventacobros!=null) {
				for(ComisionVentaCobro comisionventacobro:comisionventacobros) {
					this.deepLoad(comisionventacobro,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(comisionventacobros);
				}
			}
			
			this.connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepLoads(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {			
			if(comisionventacobros!=null) {
				for(ComisionVentaCobro comisionventacobro:comisionventacobros) {
					this.deepLoad(comisionventacobro,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(comisionventacobros);
				}	
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
		
	public void deepSaveWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {	
			this.getNewConnexionToDeep(ComisionVentaCobro.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(comisionventacobro,isDeep,deepLoadType,clases);	
			
			this.connexion.commit();
		} catch(Exception e) {			
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepSavesWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {			
			this.getNewConnexionToDeep(ComisionVentaCobro.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(comisionventacobros!=null) {
				for(ComisionVentaCobro comisionventacobro:comisionventacobros) {
					this.deepSave(comisionventacobro,isDeep,deepLoadType,clases);
				}
			}
			this.connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		}finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepSaves(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {	
			if(comisionventacobros!=null) {
				for(ComisionVentaCobro comisionventacobro:comisionventacobros) {
					this.deepSave(comisionventacobro,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getComisionVentaCobrosFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionVentaCobro.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,ComisionVentaCobroConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			ComisionVentaCobroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionventacobros=comisionventacobroDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(this.comisionventacobros);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionVentaCobrosFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,ComisionVentaCobroConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			ComisionVentaCobroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionventacobros=comisionventacobroDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(this.comisionventacobros);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComisionVentaCobrosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionVentaCobro.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ComisionVentaCobroConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ComisionVentaCobroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionventacobros=comisionventacobroDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(this.comisionventacobros);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionVentaCobrosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ComisionVentaCobroConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ComisionVentaCobroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionventacobros=comisionventacobroDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(this.comisionventacobros);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComisionVentaCobrosFK_IdFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionVentaCobro.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,ComisionVentaCobroConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			ComisionVentaCobroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionventacobros=comisionventacobroDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(this.comisionventacobros);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionVentaCobrosFK_IdFactura(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,ComisionVentaCobroConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			ComisionVentaCobroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionventacobros=comisionventacobroDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(this.comisionventacobros);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComisionVentaCobrosFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionVentaCobro.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,ComisionVentaCobroConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			ComisionVentaCobroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionventacobros=comisionventacobroDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(this.comisionventacobros);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionVentaCobrosFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,ComisionVentaCobroConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			ComisionVentaCobroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionventacobros=comisionventacobroDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(this.comisionventacobros);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getComisionVentaCobrosFK_IdVendedorWithConnection(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ComisionVentaCobro.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,ComisionVentaCobroConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			ComisionVentaCobroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionventacobros=comisionventacobroDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(this.comisionventacobros);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getComisionVentaCobrosFK_IdVendedor(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,ComisionVentaCobroConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			ComisionVentaCobroLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			comisionventacobros=comisionventacobroDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ComisionVentaCobroConstantesFunciones.refrescarForeignKeysDescripcionesComisionVentaCobro(this.comisionventacobros);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ComisionVentaCobroConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ComisionVentaCobroDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ComisionVentaCobro comisionventacobro,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ComisionVentaCobroConstantesFunciones.ISCONAUDITORIA) {
				if(comisionventacobro.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ComisionVentaCobroDataAccess.TABLENAME, comisionventacobro.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ComisionVentaCobroConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ComisionVentaCobroLogic.registrarAuditoriaDetallesComisionVentaCobro(connexion,comisionventacobro,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(comisionventacobro.getIsDeleted()) {
					/*if(!comisionventacobro.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ComisionVentaCobroDataAccess.TABLENAME, comisionventacobro.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ComisionVentaCobroLogic.registrarAuditoriaDetallesComisionVentaCobro(connexion,comisionventacobro,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ComisionVentaCobroDataAccess.TABLENAME, comisionventacobro.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(comisionventacobro.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ComisionVentaCobroDataAccess.TABLENAME, comisionventacobro.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ComisionVentaCobroConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ComisionVentaCobroLogic.registrarAuditoriaDetallesComisionVentaCobro(connexion,comisionventacobro,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesComisionVentaCobro(Connexion connexion,ComisionVentaCobro comisionventacobro)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(comisionventacobro.getIsNew()||!comisionventacobro.getid_empresa().equals(comisionventacobro.getComisionVentaCobroOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionventacobro.getComisionVentaCobroOriginal().getid_empresa()!=null)
				{
					strValorActual=comisionventacobro.getComisionVentaCobroOriginal().getid_empresa().toString();
				}
				if(comisionventacobro.getid_empresa()!=null)
				{
					strValorNuevo=comisionventacobro.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionVentaCobroConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(comisionventacobro.getIsNew()||!comisionventacobro.getid_ejercicio().equals(comisionventacobro.getComisionVentaCobroOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionventacobro.getComisionVentaCobroOriginal().getid_ejercicio()!=null)
				{
					strValorActual=comisionventacobro.getComisionVentaCobroOriginal().getid_ejercicio().toString();
				}
				if(comisionventacobro.getid_ejercicio()!=null)
				{
					strValorNuevo=comisionventacobro.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionVentaCobroConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(comisionventacobro.getIsNew()||!comisionventacobro.getid_periodo().equals(comisionventacobro.getComisionVentaCobroOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionventacobro.getComisionVentaCobroOriginal().getid_periodo()!=null)
				{
					strValorActual=comisionventacobro.getComisionVentaCobroOriginal().getid_periodo().toString();
				}
				if(comisionventacobro.getid_periodo()!=null)
				{
					strValorNuevo=comisionventacobro.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionVentaCobroConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(comisionventacobro.getIsNew()||!comisionventacobro.getid_vendedor().equals(comisionventacobro.getComisionVentaCobroOriginal().getid_vendedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionventacobro.getComisionVentaCobroOriginal().getid_vendedor()!=null)
				{
					strValorActual=comisionventacobro.getComisionVentaCobroOriginal().getid_vendedor().toString();
				}
				if(comisionventacobro.getid_vendedor()!=null)
				{
					strValorNuevo=comisionventacobro.getid_vendedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionVentaCobroConstantesFunciones.IDVENDEDOR,strValorActual,strValorNuevo);
			}	
			
			if(comisionventacobro.getIsNew()||!comisionventacobro.getid_factura().equals(comisionventacobro.getComisionVentaCobroOriginal().getid_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionventacobro.getComisionVentaCobroOriginal().getid_factura()!=null)
				{
					strValorActual=comisionventacobro.getComisionVentaCobroOriginal().getid_factura().toString();
				}
				if(comisionventacobro.getid_factura()!=null)
				{
					strValorNuevo=comisionventacobro.getid_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionVentaCobroConstantesFunciones.IDFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(comisionventacobro.getIsNew()||!comisionventacobro.getnumero_factura().equals(comisionventacobro.getComisionVentaCobroOriginal().getnumero_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionventacobro.getComisionVentaCobroOriginal().getnumero_factura()!=null)
				{
					strValorActual=comisionventacobro.getComisionVentaCobroOriginal().getnumero_factura();
				}
				if(comisionventacobro.getnumero_factura()!=null)
				{
					strValorNuevo=comisionventacobro.getnumero_factura() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionVentaCobroConstantesFunciones.NUMEROFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(comisionventacobro.getIsNew()||!comisionventacobro.getfecha_pago().equals(comisionventacobro.getComisionVentaCobroOriginal().getfecha_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionventacobro.getComisionVentaCobroOriginal().getfecha_pago()!=null)
				{
					strValorActual=comisionventacobro.getComisionVentaCobroOriginal().getfecha_pago().toString();
				}
				if(comisionventacobro.getfecha_pago()!=null)
				{
					strValorNuevo=comisionventacobro.getfecha_pago().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionVentaCobroConstantesFunciones.FECHAPAGO,strValorActual,strValorNuevo);
			}	
			
			if(comisionventacobro.getIsNew()||!comisionventacobro.getnombre_cliente().equals(comisionventacobro.getComisionVentaCobroOriginal().getnombre_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionventacobro.getComisionVentaCobroOriginal().getnombre_cliente()!=null)
				{
					strValorActual=comisionventacobro.getComisionVentaCobroOriginal().getnombre_cliente();
				}
				if(comisionventacobro.getnombre_cliente()!=null)
				{
					strValorNuevo=comisionventacobro.getnombre_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionVentaCobroConstantesFunciones.NOMBRECLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(comisionventacobro.getIsNew()||!comisionventacobro.getnumero_comprobante().equals(comisionventacobro.getComisionVentaCobroOriginal().getnumero_comprobante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionventacobro.getComisionVentaCobroOriginal().getnumero_comprobante()!=null)
				{
					strValorActual=comisionventacobro.getComisionVentaCobroOriginal().getnumero_comprobante();
				}
				if(comisionventacobro.getnumero_comprobante()!=null)
				{
					strValorNuevo=comisionventacobro.getnumero_comprobante() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionVentaCobroConstantesFunciones.NUMEROCOMPROBANTE,strValorActual,strValorNuevo);
			}	
			
			if(comisionventacobro.getIsNew()||!comisionventacobro.getestado().equals(comisionventacobro.getComisionVentaCobroOriginal().getestado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionventacobro.getComisionVentaCobroOriginal().getestado()!=null)
				{
					strValorActual=comisionventacobro.getComisionVentaCobroOriginal().getestado();
				}
				if(comisionventacobro.getestado()!=null)
				{
					strValorNuevo=comisionventacobro.getestado() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionVentaCobroConstantesFunciones.ESTADO,strValorActual,strValorNuevo);
			}	
			
			if(comisionventacobro.getIsNew()||!comisionventacobro.gettotal_factura().equals(comisionventacobro.getComisionVentaCobroOriginal().gettotal_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionventacobro.getComisionVentaCobroOriginal().gettotal_factura()!=null)
				{
					strValorActual=comisionventacobro.getComisionVentaCobroOriginal().gettotal_factura().toString();
				}
				if(comisionventacobro.gettotal_factura()!=null)
				{
					strValorNuevo=comisionventacobro.gettotal_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionVentaCobroConstantesFunciones.TOTALFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(comisionventacobro.getIsNew()||!comisionventacobro.gettotal_abono().equals(comisionventacobro.getComisionVentaCobroOriginal().gettotal_abono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionventacobro.getComisionVentaCobroOriginal().gettotal_abono()!=null)
				{
					strValorActual=comisionventacobro.getComisionVentaCobroOriginal().gettotal_abono().toString();
				}
				if(comisionventacobro.gettotal_abono()!=null)
				{
					strValorNuevo=comisionventacobro.gettotal_abono().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionVentaCobroConstantesFunciones.TOTALABONO,strValorActual,strValorNuevo);
			}	
			
			if(comisionventacobro.getIsNew()||!comisionventacobro.getporcentaje_comision().equals(comisionventacobro.getComisionVentaCobroOriginal().getporcentaje_comision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionventacobro.getComisionVentaCobroOriginal().getporcentaje_comision()!=null)
				{
					strValorActual=comisionventacobro.getComisionVentaCobroOriginal().getporcentaje_comision().toString();
				}
				if(comisionventacobro.getporcentaje_comision()!=null)
				{
					strValorNuevo=comisionventacobro.getporcentaje_comision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionVentaCobroConstantesFunciones.PORCENTAJECOMISION,strValorActual,strValorNuevo);
			}	
			
			if(comisionventacobro.getIsNew()||!comisionventacobro.gettotal_comision_cobro().equals(comisionventacobro.getComisionVentaCobroOriginal().gettotal_comision_cobro()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionventacobro.getComisionVentaCobroOriginal().gettotal_comision_cobro()!=null)
				{
					strValorActual=comisionventacobro.getComisionVentaCobroOriginal().gettotal_comision_cobro().toString();
				}
				if(comisionventacobro.gettotal_comision_cobro()!=null)
				{
					strValorNuevo=comisionventacobro.gettotal_comision_cobro().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionVentaCobroConstantesFunciones.TOTALCOMISIONCOBRO,strValorActual,strValorNuevo);
			}	
			
			if(comisionventacobro.getIsNew()||!comisionventacobro.getnumero_dias().equals(comisionventacobro.getComisionVentaCobroOriginal().getnumero_dias()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(comisionventacobro.getComisionVentaCobroOriginal().getnumero_dias()!=null)
				{
					strValorActual=comisionventacobro.getComisionVentaCobroOriginal().getnumero_dias().toString();
				}
				if(comisionventacobro.getnumero_dias()!=null)
				{
					strValorNuevo=comisionventacobro.getnumero_dias().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ComisionVentaCobroConstantesFunciones.NUMERODIAS,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveComisionVentaCobroRelacionesWithConnection(ComisionVentaCobro comisionventacobro) throws Exception {

		if(!comisionventacobro.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveComisionVentaCobroRelacionesBase(comisionventacobro,true);
		}
	}

	public void saveComisionVentaCobroRelaciones(ComisionVentaCobro comisionventacobro)throws Exception {

		if(!comisionventacobro.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveComisionVentaCobroRelacionesBase(comisionventacobro,false);
		}
	}

	public void saveComisionVentaCobroRelacionesBase(ComisionVentaCobro comisionventacobro,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ComisionVentaCobro-saveRelacionesWithConnection");}
	

			this.setComisionVentaCobro(comisionventacobro);

			if(ComisionVentaCobroLogicAdditional.validarSaveRelaciones(comisionventacobro,this)) {

				ComisionVentaCobroLogicAdditional.updateRelacionesToSave(comisionventacobro,this);

				if((comisionventacobro.getIsNew()||comisionventacobro.getIsChanged())&&!comisionventacobro.getIsDeleted()) {
					this.saveComisionVentaCobro();
					this.saveComisionVentaCobroRelacionesDetalles();

				} else if(comisionventacobro.getIsDeleted()) {
					this.saveComisionVentaCobroRelacionesDetalles();
					this.saveComisionVentaCobro();
				}

				ComisionVentaCobroLogicAdditional.updateRelacionesToSaveAfter(comisionventacobro,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveComisionVentaCobroRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfComisionVentaCobro(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ComisionVentaCobroConstantesFunciones.getClassesForeignKeysOfComisionVentaCobro(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfComisionVentaCobro(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ComisionVentaCobroConstantesFunciones.getClassesRelationshipsOfComisionVentaCobro(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
