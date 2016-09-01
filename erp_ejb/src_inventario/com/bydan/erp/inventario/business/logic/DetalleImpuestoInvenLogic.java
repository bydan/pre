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
package com.bydan.erp.inventario.business.logic;

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
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.inventario.util.DetalleImpuestoInvenConstantesFunciones;
import com.bydan.erp.inventario.util.DetalleImpuestoInvenParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DetalleImpuestoInvenParameterGeneral;
import com.bydan.erp.inventario.business.entity.DetalleImpuestoInven;
import com.bydan.erp.inventario.business.logic.DetalleImpuestoInvenLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class DetalleImpuestoInvenLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleImpuestoInvenLogic.class);
	
	protected DetalleImpuestoInvenDataAccess detalleimpuestoinvenDataAccess; 	
	protected DetalleImpuestoInven detalleimpuestoinven;
	protected List<DetalleImpuestoInven> detalleimpuestoinvens;
	protected Object detalleimpuestoinvenObject;	
	protected List<Object> detalleimpuestoinvensObject;
	
	public static ClassValidator<DetalleImpuestoInven> detalleimpuestoinvenValidator = new ClassValidator<DetalleImpuestoInven>(DetalleImpuestoInven.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleImpuestoInvenLogicAdditional detalleimpuestoinvenLogicAdditional=null;
	
	public DetalleImpuestoInvenLogicAdditional getDetalleImpuestoInvenLogicAdditional() {
		return this.detalleimpuestoinvenLogicAdditional;
	}
	
	public void setDetalleImpuestoInvenLogicAdditional(DetalleImpuestoInvenLogicAdditional detalleimpuestoinvenLogicAdditional) {
		try {
			this.detalleimpuestoinvenLogicAdditional=detalleimpuestoinvenLogicAdditional;
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
	
	
	
	
	public  DetalleImpuestoInvenLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detalleimpuestoinvenDataAccess = new DetalleImpuestoInvenDataAccess();
			
			this.detalleimpuestoinvens= new ArrayList<DetalleImpuestoInven>();
			this.detalleimpuestoinven= new DetalleImpuestoInven();
			
			this.detalleimpuestoinvenObject=new Object();
			this.detalleimpuestoinvensObject=new ArrayList<Object>();
				
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
			
			this.detalleimpuestoinvenDataAccess.setConnexionType(this.connexionType);
			this.detalleimpuestoinvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleImpuestoInvenLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detalleimpuestoinvenDataAccess = new DetalleImpuestoInvenDataAccess();
			this.detalleimpuestoinvens= new ArrayList<DetalleImpuestoInven>();
			this.detalleimpuestoinven= new DetalleImpuestoInven();
			this.detalleimpuestoinvenObject=new Object();
			this.detalleimpuestoinvensObject=new ArrayList<Object>();
			
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
			
			this.detalleimpuestoinvenDataAccess.setConnexionType(this.connexionType);
			this.detalleimpuestoinvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleImpuestoInven getDetalleImpuestoInven() throws Exception {	
		DetalleImpuestoInvenLogicAdditional.checkDetalleImpuestoInvenToGet(detalleimpuestoinven,this.datosCliente,this.arrDatoGeneral);
		DetalleImpuestoInvenLogicAdditional.updateDetalleImpuestoInvenToGet(detalleimpuestoinven,this.arrDatoGeneral);
		
		return detalleimpuestoinven;
	}
		
	public void setDetalleImpuestoInven(DetalleImpuestoInven newDetalleImpuestoInven) {
		this.detalleimpuestoinven = newDetalleImpuestoInven;
	}
	
	public DetalleImpuestoInvenDataAccess getDetalleImpuestoInvenDataAccess() {
		return detalleimpuestoinvenDataAccess;
	}
	
	public void setDetalleImpuestoInvenDataAccess(DetalleImpuestoInvenDataAccess newdetalleimpuestoinvenDataAccess) {
		this.detalleimpuestoinvenDataAccess = newdetalleimpuestoinvenDataAccess;
	}
	
	public List<DetalleImpuestoInven> getDetalleImpuestoInvens() throws Exception {		
		this.quitarDetalleImpuestoInvensNulos();
		
		DetalleImpuestoInvenLogicAdditional.checkDetalleImpuestoInvenToGets(detalleimpuestoinvens,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleImpuestoInven detalleimpuestoinvenLocal: detalleimpuestoinvens ) {
			DetalleImpuestoInvenLogicAdditional.updateDetalleImpuestoInvenToGet(detalleimpuestoinvenLocal,this.arrDatoGeneral);
		}
		
		return detalleimpuestoinvens;
	}
	
	public void setDetalleImpuestoInvens(List<DetalleImpuestoInven> newDetalleImpuestoInvens) {
		this.detalleimpuestoinvens = newDetalleImpuestoInvens;
	}
	
	public Object getDetalleImpuestoInvenObject() {	
		this.detalleimpuestoinvenObject=this.detalleimpuestoinvenDataAccess.getEntityObject();
		return this.detalleimpuestoinvenObject;
	}
		
	public void setDetalleImpuestoInvenObject(Object newDetalleImpuestoInvenObject) {
		this.detalleimpuestoinvenObject = newDetalleImpuestoInvenObject;
	}
	
	public List<Object> getDetalleImpuestoInvensObject() {		
		this.detalleimpuestoinvensObject=this.detalleimpuestoinvenDataAccess.getEntitiesObject();
		return this.detalleimpuestoinvensObject;
	}
		
	public void setDetalleImpuestoInvensObject(List<Object> newDetalleImpuestoInvensObject) {
		this.detalleimpuestoinvensObject = newDetalleImpuestoInvensObject;
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
		
		if(this.detalleimpuestoinvenDataAccess!=null) {
			this.detalleimpuestoinvenDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleImpuestoInven.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detalleimpuestoinvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detalleimpuestoinvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detalleimpuestoinven = new  DetalleImpuestoInven();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleImpuestoInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleimpuestoinven=detalleimpuestoinvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleimpuestoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(this.detalleimpuestoinven);
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
		detalleimpuestoinven = new  DetalleImpuestoInven();
		  		  
        try {
			
			detalleimpuestoinven=detalleimpuestoinvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleimpuestoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(this.detalleimpuestoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detalleimpuestoinven = new  DetalleImpuestoInven();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleImpuestoInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleimpuestoinven=detalleimpuestoinvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleimpuestoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(this.detalleimpuestoinven);
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
		detalleimpuestoinven = new  DetalleImpuestoInven();
		  		  
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
		detalleimpuestoinven = new  DetalleImpuestoInven();
		  		  
        try {
			
			detalleimpuestoinven=detalleimpuestoinvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleimpuestoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(this.detalleimpuestoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detalleimpuestoinven = new  DetalleImpuestoInven();
		  		  
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
		detalleimpuestoinven = new  DetalleImpuestoInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleImpuestoInven.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detalleimpuestoinvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleimpuestoinven = new  DetalleImpuestoInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detalleimpuestoinvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleimpuestoinven = new  DetalleImpuestoInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleImpuestoInven.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detalleimpuestoinvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleimpuestoinven = new  DetalleImpuestoInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detalleimpuestoinvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleimpuestoinven = new  DetalleImpuestoInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleImpuestoInven.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detalleimpuestoinvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleimpuestoinven = new  DetalleImpuestoInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detalleimpuestoinvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleimpuestoinvens = new  ArrayList<DetalleImpuestoInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleImpuestoInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleimpuestoinvens=detalleimpuestoinvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleImpuestoInven(detalleimpuestoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(this.detalleimpuestoinvens);
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
		detalleimpuestoinvens = new  ArrayList<DetalleImpuestoInven>();
		  		  
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
		detalleimpuestoinvens = new  ArrayList<DetalleImpuestoInven>();
		  		  
        try {			
			DetalleImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleimpuestoinvens=detalleimpuestoinvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleImpuestoInven(detalleimpuestoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(this.detalleimpuestoinvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detalleimpuestoinvens = new  ArrayList<DetalleImpuestoInven>();
		  		  
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
		detalleimpuestoinvens = new  ArrayList<DetalleImpuestoInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleImpuestoInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleimpuestoinvens=detalleimpuestoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleImpuestoInven(detalleimpuestoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(this.detalleimpuestoinvens);
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
		detalleimpuestoinvens = new  ArrayList<DetalleImpuestoInven>();
		  		  
        try {
			DetalleImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleimpuestoinvens=detalleimpuestoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleImpuestoInven(detalleimpuestoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(this.detalleimpuestoinvens);
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
		detalleimpuestoinvens = new  ArrayList<DetalleImpuestoInven>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleImpuestoInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleimpuestoinvens=detalleimpuestoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleImpuestoInven(detalleimpuestoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(this.detalleimpuestoinvens);
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
		detalleimpuestoinvens = new  ArrayList<DetalleImpuestoInven>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleimpuestoinvens=detalleimpuestoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleImpuestoInven(detalleimpuestoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(this.detalleimpuestoinvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detalleimpuestoinven = new  DetalleImpuestoInven();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleImpuestoInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleimpuestoinven=detalleimpuestoinvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleImpuestoInven(detalleimpuestoinven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(this.detalleimpuestoinven);
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
		detalleimpuestoinven = new  DetalleImpuestoInven();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleimpuestoinven=detalleimpuestoinvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleImpuestoInven(detalleimpuestoinven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(this.detalleimpuestoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleimpuestoinvens = new  ArrayList<DetalleImpuestoInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleImpuestoInven.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleimpuestoinvens=detalleimpuestoinvenDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleImpuestoInven(detalleimpuestoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(this.detalleimpuestoinvens);
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
		detalleimpuestoinvens = new  ArrayList<DetalleImpuestoInven>();
		  		  
        try {
			DetalleImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleimpuestoinvens=detalleimpuestoinvenDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleImpuestoInven(detalleimpuestoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(this.detalleimpuestoinvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleImpuestoInvensWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detalleimpuestoinvens = new  ArrayList<DetalleImpuestoInven>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleImpuestoInven.class.getSimpleName()+"-getTodosDetalleImpuestoInvensWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleimpuestoinvens=detalleimpuestoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleImpuestoInven(detalleimpuestoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(this.detalleimpuestoinvens);
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
	
	public  void  getTodosDetalleImpuestoInvens(String sFinalQuery,Pagination pagination)throws Exception {
		detalleimpuestoinvens = new  ArrayList<DetalleImpuestoInven>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleimpuestoinvens=detalleimpuestoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleImpuestoInven(detalleimpuestoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(this.detalleimpuestoinvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleImpuestoInven(DetalleImpuestoInven detalleimpuestoinven) throws Exception {
		Boolean estaValidado=false;
		
		if(detalleimpuestoinven.getIsNew() || detalleimpuestoinven.getIsChanged()) { 
			this.invalidValues = detalleimpuestoinvenValidator.getInvalidValues(detalleimpuestoinven);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detalleimpuestoinven);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleImpuestoInven(List<DetalleImpuestoInven> DetalleImpuestoInvens) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleImpuestoInven detalleimpuestoinvenLocal:detalleimpuestoinvens) {				
			estaValidadoObjeto=this.validarGuardarDetalleImpuestoInven(detalleimpuestoinvenLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleImpuestoInven(List<DetalleImpuestoInven> DetalleImpuestoInvens) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleImpuestoInven(detalleimpuestoinvens)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleImpuestoInven(DetalleImpuestoInven DetalleImpuestoInven) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleImpuestoInven(detalleimpuestoinven)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleImpuestoInven detalleimpuestoinven) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detalleimpuestoinven.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleImpuestoInvenConstantesFunciones.getDetalleImpuestoInvenLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detalleimpuestoinven","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleImpuestoInvenConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleImpuestoInvenConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleImpuestoInvenWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleImpuestoInven.class.getSimpleName()+"-saveDetalleImpuestoInvenWithConnection");connexion.begin();			
			
			DetalleImpuestoInvenLogicAdditional.checkDetalleImpuestoInvenToSave(this.detalleimpuestoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleImpuestoInvenLogicAdditional.updateDetalleImpuestoInvenToSave(this.detalleimpuestoinven,this.arrDatoGeneral);
			
			DetalleImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleimpuestoinven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleImpuestoInven();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleImpuestoInven(this.detalleimpuestoinven)) {
				DetalleImpuestoInvenDataAccess.save(this.detalleimpuestoinven, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detalleimpuestoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleImpuestoInvenLogicAdditional.checkDetalleImpuestoInvenToSaveAfter(this.detalleimpuestoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleImpuestoInven();
			
			connexion.commit();			
			
			if(this.detalleimpuestoinven.getIsDeleted()) {
				this.detalleimpuestoinven=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleImpuestoInven()throws Exception {	
		try {	
			
			DetalleImpuestoInvenLogicAdditional.checkDetalleImpuestoInvenToSave(this.detalleimpuestoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleImpuestoInvenLogicAdditional.updateDetalleImpuestoInvenToSave(this.detalleimpuestoinven,this.arrDatoGeneral);
			
			DetalleImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleimpuestoinven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleImpuestoInven(this.detalleimpuestoinven)) {			
				DetalleImpuestoInvenDataAccess.save(this.detalleimpuestoinven, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detalleimpuestoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleImpuestoInvenLogicAdditional.checkDetalleImpuestoInvenToSaveAfter(this.detalleimpuestoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detalleimpuestoinven.getIsDeleted()) {
				this.detalleimpuestoinven=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleImpuestoInvensWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleImpuestoInven.class.getSimpleName()+"-saveDetalleImpuestoInvensWithConnection");connexion.begin();			
			
			DetalleImpuestoInvenLogicAdditional.checkDetalleImpuestoInvenToSaves(detalleimpuestoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleImpuestoInvens();
			
			Boolean validadoTodosDetalleImpuestoInven=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleImpuestoInven detalleimpuestoinvenLocal:detalleimpuestoinvens) {		
				if(detalleimpuestoinvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleImpuestoInvenLogicAdditional.updateDetalleImpuestoInvenToSave(detalleimpuestoinvenLocal,this.arrDatoGeneral);
	        	
				DetalleImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleimpuestoinvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleImpuestoInven(detalleimpuestoinvenLocal)) {
					DetalleImpuestoInvenDataAccess.save(detalleimpuestoinvenLocal, connexion);				
				} else {
					validadoTodosDetalleImpuestoInven=false;
				}
			}
			
			if(!validadoTodosDetalleImpuestoInven) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleImpuestoInvenLogicAdditional.checkDetalleImpuestoInvenToSavesAfter(detalleimpuestoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleImpuestoInvens();
			
			connexion.commit();		
			
			this.quitarDetalleImpuestoInvensEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleImpuestoInvens()throws Exception {				
		 try {	
			DetalleImpuestoInvenLogicAdditional.checkDetalleImpuestoInvenToSaves(detalleimpuestoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleImpuestoInven=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleImpuestoInven detalleimpuestoinvenLocal:detalleimpuestoinvens) {				
				if(detalleimpuestoinvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleImpuestoInvenLogicAdditional.updateDetalleImpuestoInvenToSave(detalleimpuestoinvenLocal,this.arrDatoGeneral);
	        	
				DetalleImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleimpuestoinvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleImpuestoInven(detalleimpuestoinvenLocal)) {				
					DetalleImpuestoInvenDataAccess.save(detalleimpuestoinvenLocal, connexion);				
				} else {
					validadoTodosDetalleImpuestoInven=false;
				}
			}
			
			if(!validadoTodosDetalleImpuestoInven) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleImpuestoInvenLogicAdditional.checkDetalleImpuestoInvenToSavesAfter(detalleimpuestoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleImpuestoInvensEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleImpuestoInvenParameterReturnGeneral procesarAccionDetalleImpuestoInvens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleImpuestoInven> detalleimpuestoinvens,DetalleImpuestoInvenParameterReturnGeneral detalleimpuestoinvenParameterGeneral)throws Exception {
		 try {	
			DetalleImpuestoInvenParameterReturnGeneral detalleimpuestoinvenReturnGeneral=new DetalleImpuestoInvenParameterReturnGeneral();
	
			DetalleImpuestoInvenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleimpuestoinvens,detalleimpuestoinvenParameterGeneral,detalleimpuestoinvenReturnGeneral);
			
			return detalleimpuestoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleImpuestoInvenParameterReturnGeneral procesarAccionDetalleImpuestoInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleImpuestoInven> detalleimpuestoinvens,DetalleImpuestoInvenParameterReturnGeneral detalleimpuestoinvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleImpuestoInven.class.getSimpleName()+"-procesarAccionDetalleImpuestoInvensWithConnection");connexion.begin();			
			
			DetalleImpuestoInvenParameterReturnGeneral detalleimpuestoinvenReturnGeneral=new DetalleImpuestoInvenParameterReturnGeneral();
	
			DetalleImpuestoInvenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleimpuestoinvens,detalleimpuestoinvenParameterGeneral,detalleimpuestoinvenReturnGeneral);
			
			this.connexion.commit();
			
			return detalleimpuestoinvenReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleImpuestoInvenParameterReturnGeneral procesarEventosDetalleImpuestoInvens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleImpuestoInven> detalleimpuestoinvens,DetalleImpuestoInven detalleimpuestoinven,DetalleImpuestoInvenParameterReturnGeneral detalleimpuestoinvenParameterGeneral,Boolean isEsNuevoDetalleImpuestoInven,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleImpuestoInvenParameterReturnGeneral detalleimpuestoinvenReturnGeneral=new DetalleImpuestoInvenParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleimpuestoinvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleImpuestoInvenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleimpuestoinvens,detalleimpuestoinven,detalleimpuestoinvenParameterGeneral,detalleimpuestoinvenReturnGeneral,isEsNuevoDetalleImpuestoInven,clases);
			
			return detalleimpuestoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleImpuestoInvenParameterReturnGeneral procesarEventosDetalleImpuestoInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleImpuestoInven> detalleimpuestoinvens,DetalleImpuestoInven detalleimpuestoinven,DetalleImpuestoInvenParameterReturnGeneral detalleimpuestoinvenParameterGeneral,Boolean isEsNuevoDetalleImpuestoInven,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleImpuestoInven.class.getSimpleName()+"-procesarEventosDetalleImpuestoInvensWithConnection");connexion.begin();			
			
			DetalleImpuestoInvenParameterReturnGeneral detalleimpuestoinvenReturnGeneral=new DetalleImpuestoInvenParameterReturnGeneral();
	
			detalleimpuestoinvenReturnGeneral.setDetalleImpuestoInven(detalleimpuestoinven);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleimpuestoinvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleImpuestoInvenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleimpuestoinvens,detalleimpuestoinven,detalleimpuestoinvenParameterGeneral,detalleimpuestoinvenReturnGeneral,isEsNuevoDetalleImpuestoInven,clases);
			
			this.connexion.commit();
			
			return detalleimpuestoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleImpuestoInvenParameterReturnGeneral procesarImportacionDetalleImpuestoInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleImpuestoInvenParameterReturnGeneral detalleimpuestoinvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleImpuestoInven.class.getSimpleName()+"-procesarImportacionDetalleImpuestoInvensWithConnection");connexion.begin();			
			
			DetalleImpuestoInvenParameterReturnGeneral detalleimpuestoinvenReturnGeneral=new DetalleImpuestoInvenParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detalleimpuestoinvens=new ArrayList<DetalleImpuestoInven>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detalleimpuestoinven=new DetalleImpuestoInven();
				
				
				if(conColumnasBase) {this.detalleimpuestoinven.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detalleimpuestoinven.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detalleimpuestoinven.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleimpuestoinven.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleimpuestoinven.setdescripcion(arrColumnas[iColumn++]);
				
				this.detalleimpuestoinvens.add(this.detalleimpuestoinven);
			}
			
			this.saveDetalleImpuestoInvens();
			
			this.connexion.commit();
			
			detalleimpuestoinvenReturnGeneral.setConRetornoEstaProcesado(true);
			detalleimpuestoinvenReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detalleimpuestoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleImpuestoInvensEliminados() throws Exception {				
		
		List<DetalleImpuestoInven> detalleimpuestoinvensAux= new ArrayList<DetalleImpuestoInven>();
		
		for(DetalleImpuestoInven detalleimpuestoinven:detalleimpuestoinvens) {
			if(!detalleimpuestoinven.getIsDeleted()) {
				detalleimpuestoinvensAux.add(detalleimpuestoinven);
			}
		}
		
		detalleimpuestoinvens=detalleimpuestoinvensAux;
	}
	
	public void quitarDetalleImpuestoInvensNulos() throws Exception {				
		
		List<DetalleImpuestoInven> detalleimpuestoinvensAux= new ArrayList<DetalleImpuestoInven>();
		
		for(DetalleImpuestoInven detalleimpuestoinven : this.detalleimpuestoinvens) {
			if(detalleimpuestoinven==null) {
				detalleimpuestoinvensAux.add(detalleimpuestoinven);
			}
		}
		
		//this.detalleimpuestoinvens=detalleimpuestoinvensAux;
		
		this.detalleimpuestoinvens.removeAll(detalleimpuestoinvensAux);
	}
	
	public void getSetVersionRowDetalleImpuestoInvenWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detalleimpuestoinven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detalleimpuestoinven.getIsDeleted() || (detalleimpuestoinven.getIsChanged()&&!detalleimpuestoinven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detalleimpuestoinvenDataAccess.getSetVersionRowDetalleImpuestoInven(connexion,detalleimpuestoinven.getId());
				
				if(!detalleimpuestoinven.getVersionRow().equals(timestamp)) {	
					detalleimpuestoinven.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detalleimpuestoinven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleImpuestoInven()throws Exception {	
		
		if(detalleimpuestoinven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detalleimpuestoinven.getIsDeleted() || (detalleimpuestoinven.getIsChanged()&&!detalleimpuestoinven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detalleimpuestoinvenDataAccess.getSetVersionRowDetalleImpuestoInven(connexion,detalleimpuestoinven.getId());
			
			try {							
				if(!detalleimpuestoinven.getVersionRow().equals(timestamp)) {	
					detalleimpuestoinven.setVersionRow(timestamp);
				}
				
				detalleimpuestoinven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleImpuestoInvensWithConnection()throws Exception {	
		if(detalleimpuestoinvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleImpuestoInven detalleimpuestoinvenAux:detalleimpuestoinvens) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detalleimpuestoinvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleimpuestoinvenAux.getIsDeleted() || (detalleimpuestoinvenAux.getIsChanged()&&!detalleimpuestoinvenAux.getIsNew())) {
						
						timestamp=detalleimpuestoinvenDataAccess.getSetVersionRowDetalleImpuestoInven(connexion,detalleimpuestoinvenAux.getId());
						
						if(!detalleimpuestoinven.getVersionRow().equals(timestamp)) {	
							detalleimpuestoinvenAux.setVersionRow(timestamp);
						}
								
						detalleimpuestoinvenAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleImpuestoInvens()throws Exception {	
		if(detalleimpuestoinvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleImpuestoInven detalleimpuestoinvenAux:detalleimpuestoinvens) {
					if(detalleimpuestoinvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleimpuestoinvenAux.getIsDeleted() || (detalleimpuestoinvenAux.getIsChanged()&&!detalleimpuestoinvenAux.getIsNew())) {
						
						timestamp=detalleimpuestoinvenDataAccess.getSetVersionRowDetalleImpuestoInven(connexion,detalleimpuestoinvenAux.getId());
						
						if(!detalleimpuestoinvenAux.getVersionRow().equals(timestamp)) {	
							detalleimpuestoinvenAux.setVersionRow(timestamp);
						}
						
													
						detalleimpuestoinvenAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleImpuestoInvenParameterReturnGeneral cargarCombosLoteForeignKeyDetalleImpuestoInvenWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalImpuestoInven) throws Exception {
		DetalleImpuestoInvenParameterReturnGeneral  detalleimpuestoinvenReturnGeneral =new DetalleImpuestoInvenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleImpuestoInven.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleImpuestoInvenWithConnection");connexion.begin();
			
			detalleimpuestoinvenReturnGeneral =new DetalleImpuestoInvenParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleimpuestoinvenReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleimpuestoinvenReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detalleimpuestoinvenReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detalleimpuestoinvenReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<ImpuestoInven> impuestoinvensForeignKey=new ArrayList<ImpuestoInven>();
			ImpuestoInvenLogic impuestoinvenLogic=new ImpuestoInvenLogic();
			impuestoinvenLogic.setConnexion(this.connexion);
			impuestoinvenLogic.getImpuestoInvenDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalImpuestoInven.equals("NONE")) {
				impuestoinvenLogic.getTodosImpuestoInvens(finalQueryGlobalImpuestoInven,new Pagination());
				impuestoinvensForeignKey=impuestoinvenLogic.getImpuestoInvens();
			}

			detalleimpuestoinvenReturnGeneral.setimpuestoinvensForeignKey(impuestoinvensForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detalleimpuestoinvenReturnGeneral;
	}
	
	public DetalleImpuestoInvenParameterReturnGeneral cargarCombosLoteForeignKeyDetalleImpuestoInven(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalImpuestoInven) throws Exception {
		DetalleImpuestoInvenParameterReturnGeneral  detalleimpuestoinvenReturnGeneral =new DetalleImpuestoInvenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detalleimpuestoinvenReturnGeneral =new DetalleImpuestoInvenParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleimpuestoinvenReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleimpuestoinvenReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detalleimpuestoinvenReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detalleimpuestoinvenReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<ImpuestoInven> impuestoinvensForeignKey=new ArrayList<ImpuestoInven>();
			ImpuestoInvenLogic impuestoinvenLogic=new ImpuestoInvenLogic();
			impuestoinvenLogic.setConnexion(this.connexion);
			impuestoinvenLogic.getImpuestoInvenDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalImpuestoInven.equals("NONE")) {
				impuestoinvenLogic.getTodosImpuestoInvens(finalQueryGlobalImpuestoInven,new Pagination());
				impuestoinvensForeignKey=impuestoinvenLogic.getImpuestoInvens();
			}

			detalleimpuestoinvenReturnGeneral.setimpuestoinvensForeignKey(impuestoinvensForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detalleimpuestoinvenReturnGeneral;
	}
	
	
	public void deepLoad(DetalleImpuestoInven detalleimpuestoinven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleImpuestoInvenLogicAdditional.updateDetalleImpuestoInvenToGet(detalleimpuestoinven,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleimpuestoinven.setEmpresa(detalleimpuestoinvenDataAccess.getEmpresa(connexion,detalleimpuestoinven));
		detalleimpuestoinven.setSucursal(detalleimpuestoinvenDataAccess.getSucursal(connexion,detalleimpuestoinven));
		detalleimpuestoinven.setBodega(detalleimpuestoinvenDataAccess.getBodega(connexion,detalleimpuestoinven));
		detalleimpuestoinven.setProducto(detalleimpuestoinvenDataAccess.getProducto(connexion,detalleimpuestoinven));
		detalleimpuestoinven.setImpuestoInven(detalleimpuestoinvenDataAccess.getImpuestoInven(connexion,detalleimpuestoinven));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalleimpuestoinven.setEmpresa(detalleimpuestoinvenDataAccess.getEmpresa(connexion,detalleimpuestoinven));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleimpuestoinven.setSucursal(detalleimpuestoinvenDataAccess.getSucursal(connexion,detalleimpuestoinven));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detalleimpuestoinven.setBodega(detalleimpuestoinvenDataAccess.getBodega(connexion,detalleimpuestoinven));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detalleimpuestoinven.setProducto(detalleimpuestoinvenDataAccess.getProducto(connexion,detalleimpuestoinven));
				continue;
			}

			if(clas.clas.equals(ImpuestoInven.class)) {
				detalleimpuestoinven.setImpuestoInven(detalleimpuestoinvenDataAccess.getImpuestoInven(connexion,detalleimpuestoinven));
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
			detalleimpuestoinven.setEmpresa(detalleimpuestoinvenDataAccess.getEmpresa(connexion,detalleimpuestoinven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleimpuestoinven.setSucursal(detalleimpuestoinvenDataAccess.getSucursal(connexion,detalleimpuestoinven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleimpuestoinven.setBodega(detalleimpuestoinvenDataAccess.getBodega(connexion,detalleimpuestoinven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleimpuestoinven.setProducto(detalleimpuestoinvenDataAccess.getProducto(connexion,detalleimpuestoinven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ImpuestoInven.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleimpuestoinven.setImpuestoInven(detalleimpuestoinvenDataAccess.getImpuestoInven(connexion,detalleimpuestoinven));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleimpuestoinven.setEmpresa(detalleimpuestoinvenDataAccess.getEmpresa(connexion,detalleimpuestoinven));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleimpuestoinven.getEmpresa(),isDeep,deepLoadType,clases);
				
		detalleimpuestoinven.setSucursal(detalleimpuestoinvenDataAccess.getSucursal(connexion,detalleimpuestoinven));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalleimpuestoinven.getSucursal(),isDeep,deepLoadType,clases);
				
		detalleimpuestoinven.setBodega(detalleimpuestoinvenDataAccess.getBodega(connexion,detalleimpuestoinven));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detalleimpuestoinven.getBodega(),isDeep,deepLoadType,clases);
				
		detalleimpuestoinven.setProducto(detalleimpuestoinvenDataAccess.getProducto(connexion,detalleimpuestoinven));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detalleimpuestoinven.getProducto(),isDeep,deepLoadType,clases);
				
		detalleimpuestoinven.setImpuestoInven(detalleimpuestoinvenDataAccess.getImpuestoInven(connexion,detalleimpuestoinven));
		ImpuestoInvenLogic impuestoinvenLogic= new ImpuestoInvenLogic(connexion);
		impuestoinvenLogic.deepLoad(detalleimpuestoinven.getImpuestoInven(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalleimpuestoinven.setEmpresa(detalleimpuestoinvenDataAccess.getEmpresa(connexion,detalleimpuestoinven));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detalleimpuestoinven.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleimpuestoinven.setSucursal(detalleimpuestoinvenDataAccess.getSucursal(connexion,detalleimpuestoinven));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detalleimpuestoinven.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detalleimpuestoinven.setBodega(detalleimpuestoinvenDataAccess.getBodega(connexion,detalleimpuestoinven));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(detalleimpuestoinven.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detalleimpuestoinven.setProducto(detalleimpuestoinvenDataAccess.getProducto(connexion,detalleimpuestoinven));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(detalleimpuestoinven.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ImpuestoInven.class)) {
				detalleimpuestoinven.setImpuestoInven(detalleimpuestoinvenDataAccess.getImpuestoInven(connexion,detalleimpuestoinven));
				ImpuestoInvenLogic impuestoinvenLogic= new ImpuestoInvenLogic(connexion);
				impuestoinvenLogic.deepLoad(detalleimpuestoinven.getImpuestoInven(),isDeep,deepLoadType,clases);				
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
			detalleimpuestoinven.setEmpresa(detalleimpuestoinvenDataAccess.getEmpresa(connexion,detalleimpuestoinven));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detalleimpuestoinven.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleimpuestoinven.setSucursal(detalleimpuestoinvenDataAccess.getSucursal(connexion,detalleimpuestoinven));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detalleimpuestoinven.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleimpuestoinven.setBodega(detalleimpuestoinvenDataAccess.getBodega(connexion,detalleimpuestoinven));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(detalleimpuestoinven.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleimpuestoinven.setProducto(detalleimpuestoinvenDataAccess.getProducto(connexion,detalleimpuestoinven));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(detalleimpuestoinven.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(ImpuestoInven.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleimpuestoinven.setImpuestoInven(detalleimpuestoinvenDataAccess.getImpuestoInven(connexion,detalleimpuestoinven));
			ImpuestoInvenLogic impuestoinvenLogic= new ImpuestoInvenLogic(connexion);
			impuestoinvenLogic.deepLoad(detalleimpuestoinven.getImpuestoInven(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleImpuestoInven detalleimpuestoinven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleImpuestoInvenLogicAdditional.updateDetalleImpuestoInvenToSave(detalleimpuestoinven,this.arrDatoGeneral);
			
DetalleImpuestoInvenDataAccess.save(detalleimpuestoinven, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalleimpuestoinven.getEmpresa(),connexion);

		SucursalDataAccess.save(detalleimpuestoinven.getSucursal(),connexion);

		BodegaDataAccess.save(detalleimpuestoinven.getBodega(),connexion);

		ProductoDataAccess.save(detalleimpuestoinven.getProducto(),connexion);

		ImpuestoInvenDataAccess.save(detalleimpuestoinven.getImpuestoInven(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleimpuestoinven.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleimpuestoinven.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detalleimpuestoinven.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detalleimpuestoinven.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(ImpuestoInven.class)) {
				ImpuestoInvenDataAccess.save(detalleimpuestoinven.getImpuestoInven(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalleimpuestoinven.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleimpuestoinven.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detalleimpuestoinven.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalleimpuestoinven.getSucursal(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(detalleimpuestoinven.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detalleimpuestoinven.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(detalleimpuestoinven.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detalleimpuestoinven.getProducto(),isDeep,deepLoadType,clases);
				

		ImpuestoInvenDataAccess.save(detalleimpuestoinven.getImpuestoInven(),connexion);
		ImpuestoInvenLogic impuestoinvenLogic= new ImpuestoInvenLogic(connexion);
		impuestoinvenLogic.deepLoad(detalleimpuestoinven.getImpuestoInven(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleimpuestoinven.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detalleimpuestoinven.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleimpuestoinven.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detalleimpuestoinven.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detalleimpuestoinven.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(detalleimpuestoinven.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detalleimpuestoinven.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(detalleimpuestoinven.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ImpuestoInven.class)) {
				ImpuestoInvenDataAccess.save(detalleimpuestoinven.getImpuestoInven(),connexion);
				ImpuestoInvenLogic impuestoinvenLogic= new ImpuestoInvenLogic(connexion);
				impuestoinvenLogic.deepSave(detalleimpuestoinven.getImpuestoInven(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleImpuestoInven.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detalleimpuestoinven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(detalleimpuestoinven);
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
			this.deepLoad(this.detalleimpuestoinven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(this.detalleimpuestoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleImpuestoInven.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detalleimpuestoinvens!=null) {
				for(DetalleImpuestoInven detalleimpuestoinven:detalleimpuestoinvens) {
					this.deepLoad(detalleimpuestoinven,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(detalleimpuestoinvens);
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
			if(detalleimpuestoinvens!=null) {
				for(DetalleImpuestoInven detalleimpuestoinven:detalleimpuestoinvens) {
					this.deepLoad(detalleimpuestoinven,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(detalleimpuestoinvens);
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
			this.getNewConnexionToDeep(DetalleImpuestoInven.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detalleimpuestoinven,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleImpuestoInven.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detalleimpuestoinvens!=null) {
				for(DetalleImpuestoInven detalleimpuestoinven:detalleimpuestoinvens) {
					this.deepSave(detalleimpuestoinven,isDeep,deepLoadType,clases);
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
			if(detalleimpuestoinvens!=null) {
				for(DetalleImpuestoInven detalleimpuestoinven:detalleimpuestoinvens) {
					this.deepSave(detalleimpuestoinven,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleImpuestoInvensFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleImpuestoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetalleImpuestoInvenConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetalleImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleimpuestoinvens=detalleimpuestoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(this.detalleimpuestoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleImpuestoInvensFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetalleImpuestoInvenConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetalleImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleimpuestoinvens=detalleimpuestoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(this.detalleimpuestoinvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleImpuestoInvensFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleImpuestoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleImpuestoInvenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleimpuestoinvens=detalleimpuestoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(this.detalleimpuestoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleImpuestoInvensFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleImpuestoInvenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleimpuestoinvens=detalleimpuestoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(this.detalleimpuestoinvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleImpuestoInvensFK_IdImpuestoInvenWithConnection(String sFinalQuery,Pagination pagination,Long id_impuesto_inven)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleImpuestoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidImpuestoInven= new ParameterSelectionGeneral();
			parameterSelectionGeneralidImpuestoInven.setParameterSelectionGeneralEqual(ParameterType.LONG,id_impuesto_inven,DetalleImpuestoInvenConstantesFunciones.IDIMPUESTOINVEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidImpuestoInven);

			DetalleImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdImpuestoInven","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleimpuestoinvens=detalleimpuestoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(this.detalleimpuestoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleImpuestoInvensFK_IdImpuestoInven(String sFinalQuery,Pagination pagination,Long id_impuesto_inven)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidImpuestoInven= new ParameterSelectionGeneral();
			parameterSelectionGeneralidImpuestoInven.setParameterSelectionGeneralEqual(ParameterType.LONG,id_impuesto_inven,DetalleImpuestoInvenConstantesFunciones.IDIMPUESTOINVEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidImpuestoInven);

			DetalleImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdImpuestoInven","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleimpuestoinvens=detalleimpuestoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(this.detalleimpuestoinvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleImpuestoInvensFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleImpuestoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleImpuestoInvenConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleimpuestoinvens=detalleimpuestoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(this.detalleimpuestoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleImpuestoInvensFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleImpuestoInvenConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleimpuestoinvens=detalleimpuestoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(this.detalleimpuestoinvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleImpuestoInvensFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleImpuestoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleImpuestoInvenConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleimpuestoinvens=detalleimpuestoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(this.detalleimpuestoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleImpuestoInvensFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleImpuestoInvenConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleImpuestoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleimpuestoinvens=detalleimpuestoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleImpuestoInvenConstantesFunciones.refrescarForeignKeysDescripcionesDetalleImpuestoInven(this.detalleimpuestoinvens);
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
			if(DetalleImpuestoInvenConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleImpuestoInvenDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleImpuestoInven detalleimpuestoinven,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleImpuestoInvenConstantesFunciones.ISCONAUDITORIA) {
				if(detalleimpuestoinven.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleImpuestoInvenDataAccess.TABLENAME, detalleimpuestoinven.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleImpuestoInvenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleImpuestoInvenLogic.registrarAuditoriaDetallesDetalleImpuestoInven(connexion,detalleimpuestoinven,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detalleimpuestoinven.getIsDeleted()) {
					/*if(!detalleimpuestoinven.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleImpuestoInvenDataAccess.TABLENAME, detalleimpuestoinven.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleImpuestoInvenLogic.registrarAuditoriaDetallesDetalleImpuestoInven(connexion,detalleimpuestoinven,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleImpuestoInvenDataAccess.TABLENAME, detalleimpuestoinven.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detalleimpuestoinven.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleImpuestoInvenDataAccess.TABLENAME, detalleimpuestoinven.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleImpuestoInvenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleImpuestoInvenLogic.registrarAuditoriaDetallesDetalleImpuestoInven(connexion,detalleimpuestoinven,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleImpuestoInven(Connexion connexion,DetalleImpuestoInven detalleimpuestoinven)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detalleimpuestoinven.getIsNew()||!detalleimpuestoinven.getid_empresa().equals(detalleimpuestoinven.getDetalleImpuestoInvenOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleimpuestoinven.getDetalleImpuestoInvenOriginal().getid_empresa()!=null)
				{
					strValorActual=detalleimpuestoinven.getDetalleImpuestoInvenOriginal().getid_empresa().toString();
				}
				if(detalleimpuestoinven.getid_empresa()!=null)
				{
					strValorNuevo=detalleimpuestoinven.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleImpuestoInvenConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detalleimpuestoinven.getIsNew()||!detalleimpuestoinven.getid_sucursal().equals(detalleimpuestoinven.getDetalleImpuestoInvenOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleimpuestoinven.getDetalleImpuestoInvenOriginal().getid_sucursal()!=null)
				{
					strValorActual=detalleimpuestoinven.getDetalleImpuestoInvenOriginal().getid_sucursal().toString();
				}
				if(detalleimpuestoinven.getid_sucursal()!=null)
				{
					strValorNuevo=detalleimpuestoinven.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleImpuestoInvenConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detalleimpuestoinven.getIsNew()||!detalleimpuestoinven.getid_bodega().equals(detalleimpuestoinven.getDetalleImpuestoInvenOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleimpuestoinven.getDetalleImpuestoInvenOriginal().getid_bodega()!=null)
				{
					strValorActual=detalleimpuestoinven.getDetalleImpuestoInvenOriginal().getid_bodega().toString();
				}
				if(detalleimpuestoinven.getid_bodega()!=null)
				{
					strValorNuevo=detalleimpuestoinven.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleImpuestoInvenConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(detalleimpuestoinven.getIsNew()||!detalleimpuestoinven.getid_producto().equals(detalleimpuestoinven.getDetalleImpuestoInvenOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleimpuestoinven.getDetalleImpuestoInvenOriginal().getid_producto()!=null)
				{
					strValorActual=detalleimpuestoinven.getDetalleImpuestoInvenOriginal().getid_producto().toString();
				}
				if(detalleimpuestoinven.getid_producto()!=null)
				{
					strValorNuevo=detalleimpuestoinven.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleImpuestoInvenConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleimpuestoinven.getIsNew()||!detalleimpuestoinven.getid_impuesto_inven().equals(detalleimpuestoinven.getDetalleImpuestoInvenOriginal().getid_impuesto_inven()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleimpuestoinven.getDetalleImpuestoInvenOriginal().getid_impuesto_inven()!=null)
				{
					strValorActual=detalleimpuestoinven.getDetalleImpuestoInvenOriginal().getid_impuesto_inven().toString();
				}
				if(detalleimpuestoinven.getid_impuesto_inven()!=null)
				{
					strValorNuevo=detalleimpuestoinven.getid_impuesto_inven().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleImpuestoInvenConstantesFunciones.IDIMPUESTOINVEN,strValorActual,strValorNuevo);
			}	
			
			if(detalleimpuestoinven.getIsNew()||!detalleimpuestoinven.getporcentaje().equals(detalleimpuestoinven.getDetalleImpuestoInvenOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleimpuestoinven.getDetalleImpuestoInvenOriginal().getporcentaje()!=null)
				{
					strValorActual=detalleimpuestoinven.getDetalleImpuestoInvenOriginal().getporcentaje().toString();
				}
				if(detalleimpuestoinven.getporcentaje()!=null)
				{
					strValorNuevo=detalleimpuestoinven.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleImpuestoInvenConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(detalleimpuestoinven.getIsNew()||!detalleimpuestoinven.getvalor().equals(detalleimpuestoinven.getDetalleImpuestoInvenOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleimpuestoinven.getDetalleImpuestoInvenOriginal().getvalor()!=null)
				{
					strValorActual=detalleimpuestoinven.getDetalleImpuestoInvenOriginal().getvalor().toString();
				}
				if(detalleimpuestoinven.getvalor()!=null)
				{
					strValorNuevo=detalleimpuestoinven.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleImpuestoInvenConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(detalleimpuestoinven.getIsNew()||!detalleimpuestoinven.getdescripcion().equals(detalleimpuestoinven.getDetalleImpuestoInvenOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleimpuestoinven.getDetalleImpuestoInvenOriginal().getdescripcion()!=null)
				{
					strValorActual=detalleimpuestoinven.getDetalleImpuestoInvenOriginal().getdescripcion();
				}
				if(detalleimpuestoinven.getdescripcion()!=null)
				{
					strValorNuevo=detalleimpuestoinven.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleImpuestoInvenConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleImpuestoInvenRelacionesWithConnection(DetalleImpuestoInven detalleimpuestoinven) throws Exception {

		if(!detalleimpuestoinven.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleImpuestoInvenRelacionesBase(detalleimpuestoinven,true);
		}
	}

	public void saveDetalleImpuestoInvenRelaciones(DetalleImpuestoInven detalleimpuestoinven)throws Exception {

		if(!detalleimpuestoinven.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleImpuestoInvenRelacionesBase(detalleimpuestoinven,false);
		}
	}

	public void saveDetalleImpuestoInvenRelacionesBase(DetalleImpuestoInven detalleimpuestoinven,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleImpuestoInven-saveRelacionesWithConnection");}
	

			this.setDetalleImpuestoInven(detalleimpuestoinven);

			if(DetalleImpuestoInvenLogicAdditional.validarSaveRelaciones(detalleimpuestoinven,this)) {

				DetalleImpuestoInvenLogicAdditional.updateRelacionesToSave(detalleimpuestoinven,this);

				if((detalleimpuestoinven.getIsNew()||detalleimpuestoinven.getIsChanged())&&!detalleimpuestoinven.getIsDeleted()) {
					this.saveDetalleImpuestoInven();
					this.saveDetalleImpuestoInvenRelacionesDetalles();

				} else if(detalleimpuestoinven.getIsDeleted()) {
					this.saveDetalleImpuestoInvenRelacionesDetalles();
					this.saveDetalleImpuestoInven();
				}

				DetalleImpuestoInvenLogicAdditional.updateRelacionesToSaveAfter(detalleimpuestoinven,this);

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
	
	
	private void saveDetalleImpuestoInvenRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleImpuestoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleImpuestoInvenConstantesFunciones.getClassesForeignKeysOfDetalleImpuestoInven(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleImpuestoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleImpuestoInvenConstantesFunciones.getClassesRelationshipsOfDetalleImpuestoInven(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
