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
package com.bydan.erp.nomina.business.logic;

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
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.nomina.util.EnfermedadConstantesFunciones;
import com.bydan.erp.nomina.util.EnfermedadParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EnfermedadParameterGeneral;
import com.bydan.erp.nomina.business.entity.Enfermedad;
import com.bydan.erp.nomina.business.logic.EnfermedadLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class EnfermedadLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EnfermedadLogic.class);
	
	protected EnfermedadDataAccess enfermedadDataAccess; 	
	protected Enfermedad enfermedad;
	protected List<Enfermedad> enfermedads;
	protected Object enfermedadObject;	
	protected List<Object> enfermedadsObject;
	
	public static ClassValidator<Enfermedad> enfermedadValidator = new ClassValidator<Enfermedad>(Enfermedad.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EnfermedadLogicAdditional enfermedadLogicAdditional=null;
	
	public EnfermedadLogicAdditional getEnfermedadLogicAdditional() {
		return this.enfermedadLogicAdditional;
	}
	
	public void setEnfermedadLogicAdditional(EnfermedadLogicAdditional enfermedadLogicAdditional) {
		try {
			this.enfermedadLogicAdditional=enfermedadLogicAdditional;
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
	
	
	
	
	public  EnfermedadLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.enfermedadDataAccess = new EnfermedadDataAccess();
			
			this.enfermedads= new ArrayList<Enfermedad>();
			this.enfermedad= new Enfermedad();
			
			this.enfermedadObject=new Object();
			this.enfermedadsObject=new ArrayList<Object>();
				
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
			
			this.enfermedadDataAccess.setConnexionType(this.connexionType);
			this.enfermedadDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EnfermedadLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.enfermedadDataAccess = new EnfermedadDataAccess();
			this.enfermedads= new ArrayList<Enfermedad>();
			this.enfermedad= new Enfermedad();
			this.enfermedadObject=new Object();
			this.enfermedadsObject=new ArrayList<Object>();
			
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
			
			this.enfermedadDataAccess.setConnexionType(this.connexionType);
			this.enfermedadDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Enfermedad getEnfermedad() throws Exception {	
		EnfermedadLogicAdditional.checkEnfermedadToGet(enfermedad,this.datosCliente,this.arrDatoGeneral);
		EnfermedadLogicAdditional.updateEnfermedadToGet(enfermedad,this.arrDatoGeneral);
		
		return enfermedad;
	}
		
	public void setEnfermedad(Enfermedad newEnfermedad) {
		this.enfermedad = newEnfermedad;
	}
	
	public EnfermedadDataAccess getEnfermedadDataAccess() {
		return enfermedadDataAccess;
	}
	
	public void setEnfermedadDataAccess(EnfermedadDataAccess newenfermedadDataAccess) {
		this.enfermedadDataAccess = newenfermedadDataAccess;
	}
	
	public List<Enfermedad> getEnfermedads() throws Exception {		
		this.quitarEnfermedadsNulos();
		
		EnfermedadLogicAdditional.checkEnfermedadToGets(enfermedads,this.datosCliente,this.arrDatoGeneral);
		
		for (Enfermedad enfermedadLocal: enfermedads ) {
			EnfermedadLogicAdditional.updateEnfermedadToGet(enfermedadLocal,this.arrDatoGeneral);
		}
		
		return enfermedads;
	}
	
	public void setEnfermedads(List<Enfermedad> newEnfermedads) {
		this.enfermedads = newEnfermedads;
	}
	
	public Object getEnfermedadObject() {	
		this.enfermedadObject=this.enfermedadDataAccess.getEntityObject();
		return this.enfermedadObject;
	}
		
	public void setEnfermedadObject(Object newEnfermedadObject) {
		this.enfermedadObject = newEnfermedadObject;
	}
	
	public List<Object> getEnfermedadsObject() {		
		this.enfermedadsObject=this.enfermedadDataAccess.getEntitiesObject();
		return this.enfermedadsObject;
	}
		
	public void setEnfermedadsObject(List<Object> newEnfermedadsObject) {
		this.enfermedadsObject = newEnfermedadsObject;
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
		
		if(this.enfermedadDataAccess!=null) {
			this.enfermedadDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Enfermedad.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			enfermedadDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			enfermedadDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		enfermedad = new  Enfermedad();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Enfermedad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			enfermedad=enfermedadDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.enfermedad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesEnfermedad(this.enfermedad);
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
		enfermedad = new  Enfermedad();
		  		  
        try {
			
			enfermedad=enfermedadDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.enfermedad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesEnfermedad(this.enfermedad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		enfermedad = new  Enfermedad();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Enfermedad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			enfermedad=enfermedadDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.enfermedad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesEnfermedad(this.enfermedad);
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
		enfermedad = new  Enfermedad();
		  		  
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
		enfermedad = new  Enfermedad();
		  		  
        try {
			
			enfermedad=enfermedadDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.enfermedad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesEnfermedad(this.enfermedad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		enfermedad = new  Enfermedad();
		  		  
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
		enfermedad = new  Enfermedad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Enfermedad.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =enfermedadDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		enfermedad = new  Enfermedad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=enfermedadDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		enfermedad = new  Enfermedad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Enfermedad.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =enfermedadDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		enfermedad = new  Enfermedad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=enfermedadDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		enfermedad = new  Enfermedad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Enfermedad.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =enfermedadDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		enfermedad = new  Enfermedad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=enfermedadDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		enfermedads = new  ArrayList<Enfermedad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Enfermedad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			enfermedads=enfermedadDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEnfermedad(enfermedads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesEnfermedad(this.enfermedads);
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
		enfermedads = new  ArrayList<Enfermedad>();
		  		  
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
		enfermedads = new  ArrayList<Enfermedad>();
		  		  
        try {			
			EnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			enfermedads=enfermedadDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEnfermedad(enfermedads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesEnfermedad(this.enfermedads);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		enfermedads = new  ArrayList<Enfermedad>();
		  		  
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
		enfermedads = new  ArrayList<Enfermedad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Enfermedad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			enfermedads=enfermedadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEnfermedad(enfermedads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesEnfermedad(this.enfermedads);
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
		enfermedads = new  ArrayList<Enfermedad>();
		  		  
        try {
			EnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			enfermedads=enfermedadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEnfermedad(enfermedads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesEnfermedad(this.enfermedads);
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
		enfermedads = new  ArrayList<Enfermedad>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Enfermedad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			enfermedads=enfermedadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEnfermedad(enfermedads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesEnfermedad(this.enfermedads);
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
		enfermedads = new  ArrayList<Enfermedad>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			enfermedads=enfermedadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEnfermedad(enfermedads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesEnfermedad(this.enfermedads);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		enfermedad = new  Enfermedad();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Enfermedad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			enfermedad=enfermedadDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEnfermedad(enfermedad);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesEnfermedad(this.enfermedad);
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
		enfermedad = new  Enfermedad();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			enfermedad=enfermedadDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEnfermedad(enfermedad);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesEnfermedad(this.enfermedad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		enfermedads = new  ArrayList<Enfermedad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Enfermedad.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			enfermedads=enfermedadDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEnfermedad(enfermedads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesEnfermedad(this.enfermedads);
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
		enfermedads = new  ArrayList<Enfermedad>();
		  		  
        try {
			EnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			enfermedads=enfermedadDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEnfermedad(enfermedads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesEnfermedad(this.enfermedads);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEnfermedadsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		enfermedads = new  ArrayList<Enfermedad>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Enfermedad.class.getSimpleName()+"-getTodosEnfermedadsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			enfermedads=enfermedadDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEnfermedad(enfermedads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesEnfermedad(this.enfermedads);
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
	
	public  void  getTodosEnfermedads(String sFinalQuery,Pagination pagination)throws Exception {
		enfermedads = new  ArrayList<Enfermedad>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			enfermedads=enfermedadDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEnfermedad(enfermedads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesEnfermedad(this.enfermedads);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEnfermedad(Enfermedad enfermedad) throws Exception {
		Boolean estaValidado=false;
		
		if(enfermedad.getIsNew() || enfermedad.getIsChanged()) { 
			this.invalidValues = enfermedadValidator.getInvalidValues(enfermedad);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(enfermedad);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEnfermedad(List<Enfermedad> Enfermedads) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Enfermedad enfermedadLocal:enfermedads) {				
			estaValidadoObjeto=this.validarGuardarEnfermedad(enfermedadLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEnfermedad(List<Enfermedad> Enfermedads) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEnfermedad(enfermedads)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEnfermedad(Enfermedad Enfermedad) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEnfermedad(enfermedad)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Enfermedad enfermedad) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+enfermedad.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EnfermedadConstantesFunciones.getEnfermedadLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"enfermedad","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EnfermedadConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EnfermedadConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEnfermedadWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Enfermedad.class.getSimpleName()+"-saveEnfermedadWithConnection");connexion.begin();			
			
			EnfermedadLogicAdditional.checkEnfermedadToSave(this.enfermedad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EnfermedadLogicAdditional.updateEnfermedadToSave(this.enfermedad,this.arrDatoGeneral);
			
			EnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.enfermedad,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEnfermedad();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEnfermedad(this.enfermedad)) {
				EnfermedadDataAccess.save(this.enfermedad, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.enfermedad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EnfermedadLogicAdditional.checkEnfermedadToSaveAfter(this.enfermedad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEnfermedad();
			
			connexion.commit();			
			
			if(this.enfermedad.getIsDeleted()) {
				this.enfermedad=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEnfermedad()throws Exception {	
		try {	
			
			EnfermedadLogicAdditional.checkEnfermedadToSave(this.enfermedad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EnfermedadLogicAdditional.updateEnfermedadToSave(this.enfermedad,this.arrDatoGeneral);
			
			EnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.enfermedad,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEnfermedad(this.enfermedad)) {			
				EnfermedadDataAccess.save(this.enfermedad, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.enfermedad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EnfermedadLogicAdditional.checkEnfermedadToSaveAfter(this.enfermedad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.enfermedad.getIsDeleted()) {
				this.enfermedad=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEnfermedadsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Enfermedad.class.getSimpleName()+"-saveEnfermedadsWithConnection");connexion.begin();			
			
			EnfermedadLogicAdditional.checkEnfermedadToSaves(enfermedads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEnfermedads();
			
			Boolean validadoTodosEnfermedad=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Enfermedad enfermedadLocal:enfermedads) {		
				if(enfermedadLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EnfermedadLogicAdditional.updateEnfermedadToSave(enfermedadLocal,this.arrDatoGeneral);
	        	
				EnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),enfermedadLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEnfermedad(enfermedadLocal)) {
					EnfermedadDataAccess.save(enfermedadLocal, connexion);				
				} else {
					validadoTodosEnfermedad=false;
				}
			}
			
			if(!validadoTodosEnfermedad) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EnfermedadLogicAdditional.checkEnfermedadToSavesAfter(enfermedads,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEnfermedads();
			
			connexion.commit();		
			
			this.quitarEnfermedadsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEnfermedads()throws Exception {				
		 try {	
			EnfermedadLogicAdditional.checkEnfermedadToSaves(enfermedads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEnfermedad=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Enfermedad enfermedadLocal:enfermedads) {				
				if(enfermedadLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EnfermedadLogicAdditional.updateEnfermedadToSave(enfermedadLocal,this.arrDatoGeneral);
	        	
				EnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),enfermedadLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEnfermedad(enfermedadLocal)) {				
					EnfermedadDataAccess.save(enfermedadLocal, connexion);				
				} else {
					validadoTodosEnfermedad=false;
				}
			}
			
			if(!validadoTodosEnfermedad) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EnfermedadLogicAdditional.checkEnfermedadToSavesAfter(enfermedads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEnfermedadsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EnfermedadParameterReturnGeneral procesarAccionEnfermedads(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Enfermedad> enfermedads,EnfermedadParameterReturnGeneral enfermedadParameterGeneral)throws Exception {
		 try {	
			EnfermedadParameterReturnGeneral enfermedadReturnGeneral=new EnfermedadParameterReturnGeneral();
	
			EnfermedadLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,enfermedads,enfermedadParameterGeneral,enfermedadReturnGeneral);
			
			return enfermedadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EnfermedadParameterReturnGeneral procesarAccionEnfermedadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Enfermedad> enfermedads,EnfermedadParameterReturnGeneral enfermedadParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Enfermedad.class.getSimpleName()+"-procesarAccionEnfermedadsWithConnection");connexion.begin();			
			
			EnfermedadParameterReturnGeneral enfermedadReturnGeneral=new EnfermedadParameterReturnGeneral();
	
			EnfermedadLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,enfermedads,enfermedadParameterGeneral,enfermedadReturnGeneral);
			
			this.connexion.commit();
			
			return enfermedadReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EnfermedadParameterReturnGeneral procesarEventosEnfermedads(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Enfermedad> enfermedads,Enfermedad enfermedad,EnfermedadParameterReturnGeneral enfermedadParameterGeneral,Boolean isEsNuevoEnfermedad,ArrayList<Classe> clases)throws Exception {
		 try {	
			EnfermedadParameterReturnGeneral enfermedadReturnGeneral=new EnfermedadParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				enfermedadReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EnfermedadLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,enfermedads,enfermedad,enfermedadParameterGeneral,enfermedadReturnGeneral,isEsNuevoEnfermedad,clases);
			
			return enfermedadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EnfermedadParameterReturnGeneral procesarEventosEnfermedadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Enfermedad> enfermedads,Enfermedad enfermedad,EnfermedadParameterReturnGeneral enfermedadParameterGeneral,Boolean isEsNuevoEnfermedad,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Enfermedad.class.getSimpleName()+"-procesarEventosEnfermedadsWithConnection");connexion.begin();			
			
			EnfermedadParameterReturnGeneral enfermedadReturnGeneral=new EnfermedadParameterReturnGeneral();
	
			enfermedadReturnGeneral.setEnfermedad(enfermedad);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				enfermedadReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EnfermedadLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,enfermedads,enfermedad,enfermedadParameterGeneral,enfermedadReturnGeneral,isEsNuevoEnfermedad,clases);
			
			this.connexion.commit();
			
			return enfermedadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EnfermedadParameterReturnGeneral procesarImportacionEnfermedadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EnfermedadParameterReturnGeneral enfermedadParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Enfermedad.class.getSimpleName()+"-procesarImportacionEnfermedadsWithConnection");connexion.begin();			
			
			EnfermedadParameterReturnGeneral enfermedadReturnGeneral=new EnfermedadParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.enfermedads=new ArrayList<Enfermedad>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.enfermedad=new Enfermedad();
				
				
				if(conColumnasBase) {this.enfermedad.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.enfermedad.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.enfermedad.setnombre(arrColumnas[iColumn++]);
				this.enfermedad.setdescripcion(arrColumnas[iColumn++]);
				
				this.enfermedads.add(this.enfermedad);
			}
			
			this.saveEnfermedads();
			
			this.connexion.commit();
			
			enfermedadReturnGeneral.setConRetornoEstaProcesado(true);
			enfermedadReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return enfermedadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEnfermedadsEliminados() throws Exception {				
		
		List<Enfermedad> enfermedadsAux= new ArrayList<Enfermedad>();
		
		for(Enfermedad enfermedad:enfermedads) {
			if(!enfermedad.getIsDeleted()) {
				enfermedadsAux.add(enfermedad);
			}
		}
		
		enfermedads=enfermedadsAux;
	}
	
	public void quitarEnfermedadsNulos() throws Exception {				
		
		List<Enfermedad> enfermedadsAux= new ArrayList<Enfermedad>();
		
		for(Enfermedad enfermedad : this.enfermedads) {
			if(enfermedad==null) {
				enfermedadsAux.add(enfermedad);
			}
		}
		
		//this.enfermedads=enfermedadsAux;
		
		this.enfermedads.removeAll(enfermedadsAux);
	}
	
	public void getSetVersionRowEnfermedadWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(enfermedad.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((enfermedad.getIsDeleted() || (enfermedad.getIsChanged()&&!enfermedad.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=enfermedadDataAccess.getSetVersionRowEnfermedad(connexion,enfermedad.getId());
				
				if(!enfermedad.getVersionRow().equals(timestamp)) {	
					enfermedad.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				enfermedad.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEnfermedad()throws Exception {	
		
		if(enfermedad.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((enfermedad.getIsDeleted() || (enfermedad.getIsChanged()&&!enfermedad.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=enfermedadDataAccess.getSetVersionRowEnfermedad(connexion,enfermedad.getId());
			
			try {							
				if(!enfermedad.getVersionRow().equals(timestamp)) {	
					enfermedad.setVersionRow(timestamp);
				}
				
				enfermedad.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEnfermedadsWithConnection()throws Exception {	
		if(enfermedads!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Enfermedad enfermedadAux:enfermedads) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(enfermedadAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(enfermedadAux.getIsDeleted() || (enfermedadAux.getIsChanged()&&!enfermedadAux.getIsNew())) {
						
						timestamp=enfermedadDataAccess.getSetVersionRowEnfermedad(connexion,enfermedadAux.getId());
						
						if(!enfermedad.getVersionRow().equals(timestamp)) {	
							enfermedadAux.setVersionRow(timestamp);
						}
								
						enfermedadAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEnfermedads()throws Exception {	
		if(enfermedads!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Enfermedad enfermedadAux:enfermedads) {
					if(enfermedadAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(enfermedadAux.getIsDeleted() || (enfermedadAux.getIsChanged()&&!enfermedadAux.getIsNew())) {
						
						timestamp=enfermedadDataAccess.getSetVersionRowEnfermedad(connexion,enfermedadAux.getId());
						
						if(!enfermedadAux.getVersionRow().equals(timestamp)) {	
							enfermedadAux.setVersionRow(timestamp);
						}
						
													
						enfermedadAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public EnfermedadParameterReturnGeneral cargarCombosLoteForeignKeyEnfermedadWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoEnfermedad) throws Exception {
		EnfermedadParameterReturnGeneral  enfermedadReturnGeneral =new EnfermedadParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Enfermedad.class.getSimpleName()+"-cargarCombosLoteForeignKeyEnfermedadWithConnection");connexion.begin();
			
			enfermedadReturnGeneral =new EnfermedadParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			enfermedadReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoEnfermedad> tipoenfermedadsForeignKey=new ArrayList<TipoEnfermedad>();
			TipoEnfermedadLogic tipoenfermedadLogic=new TipoEnfermedadLogic();
			tipoenfermedadLogic.setConnexion(this.connexion);
			tipoenfermedadLogic.getTipoEnfermedadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoEnfermedad.equals("NONE")) {
				tipoenfermedadLogic.getTodosTipoEnfermedads(finalQueryGlobalTipoEnfermedad,new Pagination());
				tipoenfermedadsForeignKey=tipoenfermedadLogic.getTipoEnfermedads();
			}

			enfermedadReturnGeneral.settipoenfermedadsForeignKey(tipoenfermedadsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return enfermedadReturnGeneral;
	}
	
	public EnfermedadParameterReturnGeneral cargarCombosLoteForeignKeyEnfermedad(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoEnfermedad) throws Exception {
		EnfermedadParameterReturnGeneral  enfermedadReturnGeneral =new EnfermedadParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			enfermedadReturnGeneral =new EnfermedadParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			enfermedadReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoEnfermedad> tipoenfermedadsForeignKey=new ArrayList<TipoEnfermedad>();
			TipoEnfermedadLogic tipoenfermedadLogic=new TipoEnfermedadLogic();
			tipoenfermedadLogic.setConnexion(this.connexion);
			tipoenfermedadLogic.getTipoEnfermedadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoEnfermedad.equals("NONE")) {
				tipoenfermedadLogic.getTodosTipoEnfermedads(finalQueryGlobalTipoEnfermedad,new Pagination());
				tipoenfermedadsForeignKey=tipoenfermedadLogic.getTipoEnfermedads();
			}

			enfermedadReturnGeneral.settipoenfermedadsForeignKey(tipoenfermedadsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return enfermedadReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyEnfermedadWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			EmpleadoEnferLogic empleadoenferLogic=new EmpleadoEnferLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Enfermedad.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEnfermedadWithConnection");connexion.begin();
			
			
			classes.add(new Classe(EmpleadoEnfer.class));
											
			

			empleadoenferLogic.setConnexion(this.getConnexion());
			empleadoenferLogic.setDatosCliente(this.datosCliente);
			empleadoenferLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Enfermedad enfermedad:this.enfermedads) {
				

				classes=new ArrayList<Classe>();
				classes=EmpleadoEnferConstantesFunciones.getClassesForeignKeysOfEmpleadoEnfer(new ArrayList<Classe>(),DeepLoadType.NONE);

				empleadoenferLogic.setEmpleadoEnfers(enfermedad.empleadoenfers);
				empleadoenferLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			}
			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
	}
	
	public void deepLoad(Enfermedad enfermedad,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EnfermedadLogicAdditional.updateEnfermedadToGet(enfermedad,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		enfermedad.setEmpresa(enfermedadDataAccess.getEmpresa(connexion,enfermedad));
		enfermedad.setTipoEnfermedad(enfermedadDataAccess.getTipoEnfermedad(connexion,enfermedad));
		enfermedad.setEmpleadoEnfers(enfermedadDataAccess.getEmpleadoEnfers(connexion,enfermedad));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				enfermedad.setEmpresa(enfermedadDataAccess.getEmpresa(connexion,enfermedad));
				continue;
			}

			if(clas.clas.equals(TipoEnfermedad.class)) {
				enfermedad.setTipoEnfermedad(enfermedadDataAccess.getTipoEnfermedad(connexion,enfermedad));
				continue;
			}

			if(clas.clas.equals(EmpleadoEnfer.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				enfermedad.setEmpleadoEnfers(enfermedadDataAccess.getEmpleadoEnfers(connexion,enfermedad));

				if(this.isConDeep) {
					EmpleadoEnferLogic empleadoenferLogic= new EmpleadoEnferLogic(this.connexion);
					empleadoenferLogic.setEmpleadoEnfers(enfermedad.getEmpleadoEnfers());
					ArrayList<Classe> classesLocal=EmpleadoEnferConstantesFunciones.getClassesForeignKeysOfEmpleadoEnfer(new ArrayList<Classe>(),DeepLoadType.NONE);
					empleadoenferLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EmpleadoEnferConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoEnfer(empleadoenferLogic.getEmpleadoEnfers());
					enfermedad.setEmpleadoEnfers(empleadoenferLogic.getEmpleadoEnfers());
				}

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
			enfermedad.setEmpresa(enfermedadDataAccess.getEmpresa(connexion,enfermedad));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoEnfermedad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			enfermedad.setTipoEnfermedad(enfermedadDataAccess.getTipoEnfermedad(connexion,enfermedad));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoEnfer.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoEnfer.class));
			enfermedad.setEmpleadoEnfers(enfermedadDataAccess.getEmpleadoEnfers(connexion,enfermedad));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		enfermedad.setEmpresa(enfermedadDataAccess.getEmpresa(connexion,enfermedad));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(enfermedad.getEmpresa(),isDeep,deepLoadType,clases);
				
		enfermedad.setTipoEnfermedad(enfermedadDataAccess.getTipoEnfermedad(connexion,enfermedad));
		TipoEnfermedadLogic tipoenfermedadLogic= new TipoEnfermedadLogic(connexion);
		tipoenfermedadLogic.deepLoad(enfermedad.getTipoEnfermedad(),isDeep,deepLoadType,clases);
				

		enfermedad.setEmpleadoEnfers(enfermedadDataAccess.getEmpleadoEnfers(connexion,enfermedad));

		for(EmpleadoEnfer empleadoenfer:enfermedad.getEmpleadoEnfers()) {
			EmpleadoEnferLogic empleadoenferLogic= new EmpleadoEnferLogic(connexion);
			empleadoenferLogic.deepLoad(empleadoenfer,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				enfermedad.setEmpresa(enfermedadDataAccess.getEmpresa(connexion,enfermedad));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(enfermedad.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoEnfermedad.class)) {
				enfermedad.setTipoEnfermedad(enfermedadDataAccess.getTipoEnfermedad(connexion,enfermedad));
				TipoEnfermedadLogic tipoenfermedadLogic= new TipoEnfermedadLogic(connexion);
				tipoenfermedadLogic.deepLoad(enfermedad.getTipoEnfermedad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EmpleadoEnfer.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				enfermedad.setEmpleadoEnfers(enfermedadDataAccess.getEmpleadoEnfers(connexion,enfermedad));

				for(EmpleadoEnfer empleadoenfer:enfermedad.getEmpleadoEnfers()) {
					EmpleadoEnferLogic empleadoenferLogic= new EmpleadoEnferLogic(connexion);
					empleadoenferLogic.deepLoad(empleadoenfer,isDeep,deepLoadType,clases);
				}
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
			enfermedad.setEmpresa(enfermedadDataAccess.getEmpresa(connexion,enfermedad));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(enfermedad.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoEnfermedad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			enfermedad.setTipoEnfermedad(enfermedadDataAccess.getTipoEnfermedad(connexion,enfermedad));
			TipoEnfermedadLogic tipoenfermedadLogic= new TipoEnfermedadLogic(connexion);
			tipoenfermedadLogic.deepLoad(enfermedad.getTipoEnfermedad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoEnfer.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoEnfer.class));
			enfermedad.setEmpleadoEnfers(enfermedadDataAccess.getEmpleadoEnfers(connexion,enfermedad));

			for(EmpleadoEnfer empleadoenfer:enfermedad.getEmpleadoEnfers()) {
				EmpleadoEnferLogic empleadoenferLogic= new EmpleadoEnferLogic(connexion);
				empleadoenferLogic.deepLoad(empleadoenfer,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Enfermedad enfermedad,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EnfermedadLogicAdditional.updateEnfermedadToSave(enfermedad,this.arrDatoGeneral);
			
EnfermedadDataAccess.save(enfermedad, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(enfermedad.getEmpresa(),connexion);

		TipoEnfermedadDataAccess.save(enfermedad.getTipoEnfermedad(),connexion);

		for(EmpleadoEnfer empleadoenfer:enfermedad.getEmpleadoEnfers()) {
			empleadoenfer.setid_enfermedad(enfermedad.getId());
			EmpleadoEnferDataAccess.save(empleadoenfer,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(enfermedad.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoEnfermedad.class)) {
				TipoEnfermedadDataAccess.save(enfermedad.getTipoEnfermedad(),connexion);
				continue;
			}


			if(clas.clas.equals(EmpleadoEnfer.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoEnfer empleadoenfer:enfermedad.getEmpleadoEnfers()) {
					empleadoenfer.setid_enfermedad(enfermedad.getId());
					EmpleadoEnferDataAccess.save(empleadoenfer,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(enfermedad.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(enfermedad.getEmpresa(),isDeep,deepLoadType,clases);
				

		TipoEnfermedadDataAccess.save(enfermedad.getTipoEnfermedad(),connexion);
		TipoEnfermedadLogic tipoenfermedadLogic= new TipoEnfermedadLogic(connexion);
		tipoenfermedadLogic.deepLoad(enfermedad.getTipoEnfermedad(),isDeep,deepLoadType,clases);
				

		for(EmpleadoEnfer empleadoenfer:enfermedad.getEmpleadoEnfers()) {
			EmpleadoEnferLogic empleadoenferLogic= new EmpleadoEnferLogic(connexion);
			empleadoenfer.setid_enfermedad(enfermedad.getId());
			EmpleadoEnferDataAccess.save(empleadoenfer,connexion);
			empleadoenferLogic.deepSave(empleadoenfer,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(enfermedad.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(enfermedad.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoEnfermedad.class)) {
				TipoEnfermedadDataAccess.save(enfermedad.getTipoEnfermedad(),connexion);
				TipoEnfermedadLogic tipoenfermedadLogic= new TipoEnfermedadLogic(connexion);
				tipoenfermedadLogic.deepSave(enfermedad.getTipoEnfermedad(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(EmpleadoEnfer.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoEnfer empleadoenfer:enfermedad.getEmpleadoEnfers()) {
					EmpleadoEnferLogic empleadoenferLogic= new EmpleadoEnferLogic(connexion);
					empleadoenfer.setid_enfermedad(enfermedad.getId());
					EmpleadoEnferDataAccess.save(empleadoenfer,connexion);
					empleadoenferLogic.deepSave(empleadoenfer,isDeep,deepLoadType,clases);
				}
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
			this.getNewConnexionToDeep(Enfermedad.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(enfermedad,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesEnfermedad(enfermedad);
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
			this.deepLoad(this.enfermedad,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesEnfermedad(this.enfermedad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Enfermedad.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(enfermedads!=null) {
				for(Enfermedad enfermedad:enfermedads) {
					this.deepLoad(enfermedad,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesEnfermedad(enfermedads);
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
			if(enfermedads!=null) {
				for(Enfermedad enfermedad:enfermedads) {
					this.deepLoad(enfermedad,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesEnfermedad(enfermedads);
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
			this.getNewConnexionToDeep(Enfermedad.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(enfermedad,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Enfermedad.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(enfermedads!=null) {
				for(Enfermedad enfermedad:enfermedads) {
					this.deepSave(enfermedad,isDeep,deepLoadType,clases);
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
			if(enfermedads!=null) {
				for(Enfermedad enfermedad:enfermedads) {
					this.deepSave(enfermedad,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEnfermedadsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Enfermedad.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EnfermedadConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			enfermedads=enfermedadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesEnfermedad(this.enfermedads);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEnfermedadsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EnfermedadConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			enfermedads=enfermedadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesEnfermedad(this.enfermedads);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEnfermedadsFK_IdTipoEnfermedadWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_enfermedad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Enfermedad.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoEnfermedad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoEnfermedad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_enfermedad,EnfermedadConstantesFunciones.IDTIPOENFERMEDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoEnfermedad);

			EnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoEnfermedad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			enfermedads=enfermedadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesEnfermedad(this.enfermedads);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEnfermedadsFK_IdTipoEnfermedad(String sFinalQuery,Pagination pagination,Long id_tipo_enfermedad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoEnfermedad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoEnfermedad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_enfermedad,EnfermedadConstantesFunciones.IDTIPOENFERMEDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoEnfermedad);

			EnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoEnfermedad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			enfermedads=enfermedadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesEnfermedad(this.enfermedads);
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
			if(EnfermedadConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EnfermedadDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Enfermedad enfermedad,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EnfermedadConstantesFunciones.ISCONAUDITORIA) {
				if(enfermedad.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EnfermedadDataAccess.TABLENAME, enfermedad.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EnfermedadConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EnfermedadLogic.registrarAuditoriaDetallesEnfermedad(connexion,enfermedad,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(enfermedad.getIsDeleted()) {
					/*if(!enfermedad.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EnfermedadDataAccess.TABLENAME, enfermedad.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EnfermedadLogic.registrarAuditoriaDetallesEnfermedad(connexion,enfermedad,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EnfermedadDataAccess.TABLENAME, enfermedad.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(enfermedad.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EnfermedadDataAccess.TABLENAME, enfermedad.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EnfermedadConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EnfermedadLogic.registrarAuditoriaDetallesEnfermedad(connexion,enfermedad,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEnfermedad(Connexion connexion,Enfermedad enfermedad)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(enfermedad.getIsNew()||!enfermedad.getid_empresa().equals(enfermedad.getEnfermedadOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(enfermedad.getEnfermedadOriginal().getid_empresa()!=null)
				{
					strValorActual=enfermedad.getEnfermedadOriginal().getid_empresa().toString();
				}
				if(enfermedad.getid_empresa()!=null)
				{
					strValorNuevo=enfermedad.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EnfermedadConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(enfermedad.getIsNew()||!enfermedad.getid_tipo_enfermedad().equals(enfermedad.getEnfermedadOriginal().getid_tipo_enfermedad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(enfermedad.getEnfermedadOriginal().getid_tipo_enfermedad()!=null)
				{
					strValorActual=enfermedad.getEnfermedadOriginal().getid_tipo_enfermedad().toString();
				}
				if(enfermedad.getid_tipo_enfermedad()!=null)
				{
					strValorNuevo=enfermedad.getid_tipo_enfermedad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EnfermedadConstantesFunciones.IDTIPOENFERMEDAD,strValorActual,strValorNuevo);
			}	
			
			if(enfermedad.getIsNew()||!enfermedad.getnombre().equals(enfermedad.getEnfermedadOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(enfermedad.getEnfermedadOriginal().getnombre()!=null)
				{
					strValorActual=enfermedad.getEnfermedadOriginal().getnombre();
				}
				if(enfermedad.getnombre()!=null)
				{
					strValorNuevo=enfermedad.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EnfermedadConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(enfermedad.getIsNew()||!enfermedad.getdescripcion().equals(enfermedad.getEnfermedadOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(enfermedad.getEnfermedadOriginal().getdescripcion()!=null)
				{
					strValorActual=enfermedad.getEnfermedadOriginal().getdescripcion();
				}
				if(enfermedad.getdescripcion()!=null)
				{
					strValorNuevo=enfermedad.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EnfermedadConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEnfermedadRelacionesWithConnection(Enfermedad enfermedad,List<EmpleadoEnfer> empleadoenfers) throws Exception {

		if(!enfermedad.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEnfermedadRelacionesBase(enfermedad,empleadoenfers,true);
		}
	}

	public void saveEnfermedadRelaciones(Enfermedad enfermedad,List<EmpleadoEnfer> empleadoenfers)throws Exception {

		if(!enfermedad.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEnfermedadRelacionesBase(enfermedad,empleadoenfers,false);
		}
	}

	public void saveEnfermedadRelacionesBase(Enfermedad enfermedad,List<EmpleadoEnfer> empleadoenfers,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Enfermedad-saveRelacionesWithConnection");}
	
			enfermedad.setEmpleadoEnfers(empleadoenfers);

			this.setEnfermedad(enfermedad);

			if(EnfermedadLogicAdditional.validarSaveRelaciones(enfermedad,this)) {

				EnfermedadLogicAdditional.updateRelacionesToSave(enfermedad,this);

				if((enfermedad.getIsNew()||enfermedad.getIsChanged())&&!enfermedad.getIsDeleted()) {
					this.saveEnfermedad();
					this.saveEnfermedadRelacionesDetalles(empleadoenfers);

				} else if(enfermedad.getIsDeleted()) {
					this.saveEnfermedadRelacionesDetalles(empleadoenfers);
					this.saveEnfermedad();
				}

				EnfermedadLogicAdditional.updateRelacionesToSaveAfter(enfermedad,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			EmpleadoEnferConstantesFunciones.InicializarGeneralEntityAuxiliaresEmpleadoEnfers(empleadoenfers,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEnfermedadRelacionesDetalles(List<EmpleadoEnfer> empleadoenfers)throws Exception {
		try {
	

			Long idEnfermedadActual=this.getEnfermedad().getId();

			EmpleadoEnferLogic empleadoenferLogic_Desde_Enfermedad=new EmpleadoEnferLogic();
			empleadoenferLogic_Desde_Enfermedad.setEmpleadoEnfers(empleadoenfers);

			empleadoenferLogic_Desde_Enfermedad.setConnexion(this.getConnexion());
			empleadoenferLogic_Desde_Enfermedad.setDatosCliente(this.datosCliente);

			for(EmpleadoEnfer empleadoenfer_Desde_Enfermedad:empleadoenferLogic_Desde_Enfermedad.getEmpleadoEnfers()) {
				empleadoenfer_Desde_Enfermedad.setid_enfermedad(idEnfermedadActual);
			}

			empleadoenferLogic_Desde_Enfermedad.saveEmpleadoEnfers();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEnfermedad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EnfermedadConstantesFunciones.getClassesForeignKeysOfEnfermedad(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEnfermedad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EnfermedadConstantesFunciones.getClassesRelationshipsOfEnfermedad(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
