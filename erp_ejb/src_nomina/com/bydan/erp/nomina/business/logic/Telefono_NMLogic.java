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
import com.bydan.erp.nomina.util.Telefono_NMConstantesFunciones;
import com.bydan.erp.nomina.util.Telefono_NMParameterReturnGeneral;
//import com.bydan.erp.nomina.util.Telefono_NMParameterGeneral;
import com.bydan.erp.nomina.business.entity.Telefono_NM;
import com.bydan.erp.nomina.business.logic.Telefono_NMLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class Telefono_NMLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(Telefono_NMLogic.class);
	
	protected Telefono_NMDataAccess telefono_nmDataAccess; 	
	protected Telefono_NM telefono_nm;
	protected List<Telefono_NM> telefono_nms;
	protected Object telefono_nmObject;	
	protected List<Object> telefono_nmsObject;
	
	public static ClassValidator<Telefono_NM> telefono_nmValidator = new ClassValidator<Telefono_NM>(Telefono_NM.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected Telefono_NMLogicAdditional telefono_nmLogicAdditional=null;
	
	public Telefono_NMLogicAdditional getTelefono_NMLogicAdditional() {
		return this.telefono_nmLogicAdditional;
	}
	
	public void setTelefono_NMLogicAdditional(Telefono_NMLogicAdditional telefono_nmLogicAdditional) {
		try {
			this.telefono_nmLogicAdditional=telefono_nmLogicAdditional;
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
	
	
	
	
	public  Telefono_NMLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.telefono_nmDataAccess = new Telefono_NMDataAccess();
			
			this.telefono_nms= new ArrayList<Telefono_NM>();
			this.telefono_nm= new Telefono_NM();
			
			this.telefono_nmObject=new Object();
			this.telefono_nmsObject=new ArrayList<Object>();
				
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
			
			this.telefono_nmDataAccess.setConnexionType(this.connexionType);
			this.telefono_nmDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  Telefono_NMLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.telefono_nmDataAccess = new Telefono_NMDataAccess();
			this.telefono_nms= new ArrayList<Telefono_NM>();
			this.telefono_nm= new Telefono_NM();
			this.telefono_nmObject=new Object();
			this.telefono_nmsObject=new ArrayList<Object>();
			
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
			
			this.telefono_nmDataAccess.setConnexionType(this.connexionType);
			this.telefono_nmDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Telefono_NM getTelefono_NM() throws Exception {	
		Telefono_NMLogicAdditional.checkTelefono_NMToGet(telefono_nm,this.datosCliente,this.arrDatoGeneral);
		Telefono_NMLogicAdditional.updateTelefono_NMToGet(telefono_nm,this.arrDatoGeneral);
		
		return telefono_nm;
	}
		
	public void setTelefono_NM(Telefono_NM newTelefono_NM) {
		this.telefono_nm = newTelefono_NM;
	}
	
	public Telefono_NMDataAccess getTelefono_NMDataAccess() {
		return telefono_nmDataAccess;
	}
	
	public void setTelefono_NMDataAccess(Telefono_NMDataAccess newtelefono_nmDataAccess) {
		this.telefono_nmDataAccess = newtelefono_nmDataAccess;
	}
	
	public List<Telefono_NM> getTelefono_NMs() throws Exception {		
		this.quitarTelefono_NMsNulos();
		
		Telefono_NMLogicAdditional.checkTelefono_NMToGets(telefono_nms,this.datosCliente,this.arrDatoGeneral);
		
		for (Telefono_NM telefono_nmLocal: telefono_nms ) {
			Telefono_NMLogicAdditional.updateTelefono_NMToGet(telefono_nmLocal,this.arrDatoGeneral);
		}
		
		return telefono_nms;
	}
	
	public void setTelefono_NMs(List<Telefono_NM> newTelefono_NMs) {
		this.telefono_nms = newTelefono_NMs;
	}
	
	public Object getTelefono_NMObject() {	
		this.telefono_nmObject=this.telefono_nmDataAccess.getEntityObject();
		return this.telefono_nmObject;
	}
		
	public void setTelefono_NMObject(Object newTelefono_NMObject) {
		this.telefono_nmObject = newTelefono_NMObject;
	}
	
	public List<Object> getTelefono_NMsObject() {		
		this.telefono_nmsObject=this.telefono_nmDataAccess.getEntitiesObject();
		return this.telefono_nmsObject;
	}
		
	public void setTelefono_NMsObject(List<Object> newTelefono_NMsObject) {
		this.telefono_nmsObject = newTelefono_NMsObject;
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
		
		if(this.telefono_nmDataAccess!=null) {
			this.telefono_nmDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Telefono_NM.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			telefono_nmDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			telefono_nmDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		telefono_nm = new  Telefono_NM();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Telefono_NM.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			telefono_nm=telefono_nmDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.telefono_nm,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				Telefono_NMConstantesFunciones.refrescarForeignKeysDescripcionesTelefono_NM(this.telefono_nm);
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
		telefono_nm = new  Telefono_NM();
		  		  
        try {
			
			telefono_nm=telefono_nmDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.telefono_nm,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				Telefono_NMConstantesFunciones.refrescarForeignKeysDescripcionesTelefono_NM(this.telefono_nm);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		telefono_nm = new  Telefono_NM();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Telefono_NM.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			telefono_nm=telefono_nmDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.telefono_nm,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				Telefono_NMConstantesFunciones.refrescarForeignKeysDescripcionesTelefono_NM(this.telefono_nm);
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
		telefono_nm = new  Telefono_NM();
		  		  
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
		telefono_nm = new  Telefono_NM();
		  		  
        try {
			
			telefono_nm=telefono_nmDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.telefono_nm,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				Telefono_NMConstantesFunciones.refrescarForeignKeysDescripcionesTelefono_NM(this.telefono_nm);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		telefono_nm = new  Telefono_NM();
		  		  
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
		telefono_nm = new  Telefono_NM();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Telefono_NM.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =telefono_nmDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		telefono_nm = new  Telefono_NM();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=telefono_nmDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		telefono_nm = new  Telefono_NM();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Telefono_NM.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =telefono_nmDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		telefono_nm = new  Telefono_NM();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=telefono_nmDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		telefono_nm = new  Telefono_NM();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Telefono_NM.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =telefono_nmDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		telefono_nm = new  Telefono_NM();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=telefono_nmDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		telefono_nms = new  ArrayList<Telefono_NM>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Telefono_NM.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			Telefono_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			telefono_nms=telefono_nmDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTelefono_NM(telefono_nms);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				Telefono_NMConstantesFunciones.refrescarForeignKeysDescripcionesTelefono_NM(this.telefono_nms);
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
		telefono_nms = new  ArrayList<Telefono_NM>();
		  		  
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
		telefono_nms = new  ArrayList<Telefono_NM>();
		  		  
        try {			
			Telefono_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			telefono_nms=telefono_nmDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTelefono_NM(telefono_nms);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				Telefono_NMConstantesFunciones.refrescarForeignKeysDescripcionesTelefono_NM(this.telefono_nms);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		telefono_nms = new  ArrayList<Telefono_NM>();
		  		  
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
		telefono_nms = new  ArrayList<Telefono_NM>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Telefono_NM.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			Telefono_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			telefono_nms=telefono_nmDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTelefono_NM(telefono_nms);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				Telefono_NMConstantesFunciones.refrescarForeignKeysDescripcionesTelefono_NM(this.telefono_nms);
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
		telefono_nms = new  ArrayList<Telefono_NM>();
		  		  
        try {
			Telefono_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			telefono_nms=telefono_nmDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTelefono_NM(telefono_nms);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				Telefono_NMConstantesFunciones.refrescarForeignKeysDescripcionesTelefono_NM(this.telefono_nms);
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
		telefono_nms = new  ArrayList<Telefono_NM>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Telefono_NM.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			Telefono_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			telefono_nms=telefono_nmDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTelefono_NM(telefono_nms);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				Telefono_NMConstantesFunciones.refrescarForeignKeysDescripcionesTelefono_NM(this.telefono_nms);
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
		telefono_nms = new  ArrayList<Telefono_NM>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			Telefono_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			telefono_nms=telefono_nmDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTelefono_NM(telefono_nms);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				Telefono_NMConstantesFunciones.refrescarForeignKeysDescripcionesTelefono_NM(this.telefono_nms);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		telefono_nm = new  Telefono_NM();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Telefono_NM.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			Telefono_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			telefono_nm=telefono_nmDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTelefono_NM(telefono_nm);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				Telefono_NMConstantesFunciones.refrescarForeignKeysDescripcionesTelefono_NM(this.telefono_nm);
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
		telefono_nm = new  Telefono_NM();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			Telefono_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			telefono_nm=telefono_nmDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTelefono_NM(telefono_nm);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				Telefono_NMConstantesFunciones.refrescarForeignKeysDescripcionesTelefono_NM(this.telefono_nm);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		telefono_nms = new  ArrayList<Telefono_NM>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Telefono_NM.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			Telefono_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			telefono_nms=telefono_nmDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTelefono_NM(telefono_nms);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				Telefono_NMConstantesFunciones.refrescarForeignKeysDescripcionesTelefono_NM(this.telefono_nms);
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
		telefono_nms = new  ArrayList<Telefono_NM>();
		  		  
        try {
			Telefono_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			telefono_nms=telefono_nmDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTelefono_NM(telefono_nms);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				Telefono_NMConstantesFunciones.refrescarForeignKeysDescripcionesTelefono_NM(this.telefono_nms);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTelefono_NMsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		telefono_nms = new  ArrayList<Telefono_NM>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Telefono_NM.class.getSimpleName()+"-getTodosTelefono_NMsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			Telefono_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			telefono_nms=telefono_nmDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTelefono_NM(telefono_nms);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				Telefono_NMConstantesFunciones.refrescarForeignKeysDescripcionesTelefono_NM(this.telefono_nms);
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
	
	public  void  getTodosTelefono_NMs(String sFinalQuery,Pagination pagination)throws Exception {
		telefono_nms = new  ArrayList<Telefono_NM>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			Telefono_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			telefono_nms=telefono_nmDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTelefono_NM(telefono_nms);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				Telefono_NMConstantesFunciones.refrescarForeignKeysDescripcionesTelefono_NM(this.telefono_nms);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTelefono_NM(Telefono_NM telefono_nm) throws Exception {
		Boolean estaValidado=false;
		
		if(telefono_nm.getIsNew() || telefono_nm.getIsChanged()) { 
			this.invalidValues = telefono_nmValidator.getInvalidValues(telefono_nm);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(telefono_nm);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTelefono_NM(List<Telefono_NM> Telefono_NMs) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Telefono_NM telefono_nmLocal:telefono_nms) {				
			estaValidadoObjeto=this.validarGuardarTelefono_NM(telefono_nmLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTelefono_NM(List<Telefono_NM> Telefono_NMs) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTelefono_NM(telefono_nms)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTelefono_NM(Telefono_NM Telefono_NM) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTelefono_NM(telefono_nm)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Telefono_NM telefono_nm) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+telefono_nm.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=Telefono_NMConstantesFunciones.getTelefono_NMLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"telefono_nm","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(Telefono_NMConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(Telefono_NMConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTelefono_NMWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Telefono_NM.class.getSimpleName()+"-saveTelefono_NMWithConnection");connexion.begin();			
			
			Telefono_NMLogicAdditional.checkTelefono_NMToSave(this.telefono_nm,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Telefono_NMLogicAdditional.updateTelefono_NMToSave(this.telefono_nm,this.arrDatoGeneral);
			
			Telefono_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.telefono_nm,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTelefono_NM();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTelefono_NM(this.telefono_nm)) {
				Telefono_NMDataAccess.save(this.telefono_nm, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.telefono_nm,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			Telefono_NMLogicAdditional.checkTelefono_NMToSaveAfter(this.telefono_nm,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTelefono_NM();
			
			connexion.commit();			
			
			if(this.telefono_nm.getIsDeleted()) {
				this.telefono_nm=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTelefono_NM()throws Exception {	
		try {	
			
			Telefono_NMLogicAdditional.checkTelefono_NMToSave(this.telefono_nm,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Telefono_NMLogicAdditional.updateTelefono_NMToSave(this.telefono_nm,this.arrDatoGeneral);
			
			Telefono_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.telefono_nm,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTelefono_NM(this.telefono_nm)) {			
				Telefono_NMDataAccess.save(this.telefono_nm, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.telefono_nm,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			Telefono_NMLogicAdditional.checkTelefono_NMToSaveAfter(this.telefono_nm,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.telefono_nm.getIsDeleted()) {
				this.telefono_nm=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTelefono_NMsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Telefono_NM.class.getSimpleName()+"-saveTelefono_NMsWithConnection");connexion.begin();			
			
			Telefono_NMLogicAdditional.checkTelefono_NMToSaves(telefono_nms,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTelefono_NMs();
			
			Boolean validadoTodosTelefono_NM=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Telefono_NM telefono_nmLocal:telefono_nms) {		
				if(telefono_nmLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				Telefono_NMLogicAdditional.updateTelefono_NMToSave(telefono_nmLocal,this.arrDatoGeneral);
	        	
				Telefono_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),telefono_nmLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTelefono_NM(telefono_nmLocal)) {
					Telefono_NMDataAccess.save(telefono_nmLocal, connexion);				
				} else {
					validadoTodosTelefono_NM=false;
				}
			}
			
			if(!validadoTodosTelefono_NM) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			Telefono_NMLogicAdditional.checkTelefono_NMToSavesAfter(telefono_nms,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTelefono_NMs();
			
			connexion.commit();		
			
			this.quitarTelefono_NMsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTelefono_NMs()throws Exception {				
		 try {	
			Telefono_NMLogicAdditional.checkTelefono_NMToSaves(telefono_nms,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTelefono_NM=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Telefono_NM telefono_nmLocal:telefono_nms) {				
				if(telefono_nmLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				Telefono_NMLogicAdditional.updateTelefono_NMToSave(telefono_nmLocal,this.arrDatoGeneral);
	        	
				Telefono_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),telefono_nmLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTelefono_NM(telefono_nmLocal)) {				
					Telefono_NMDataAccess.save(telefono_nmLocal, connexion);				
				} else {
					validadoTodosTelefono_NM=false;
				}
			}
			
			if(!validadoTodosTelefono_NM) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			Telefono_NMLogicAdditional.checkTelefono_NMToSavesAfter(telefono_nms,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTelefono_NMsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public Telefono_NMParameterReturnGeneral procesarAccionTelefono_NMs(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Telefono_NM> telefono_nms,Telefono_NMParameterReturnGeneral telefono_nmParameterGeneral)throws Exception {
		 try {	
			Telefono_NMParameterReturnGeneral telefono_nmReturnGeneral=new Telefono_NMParameterReturnGeneral();
	
			Telefono_NMLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,telefono_nms,telefono_nmParameterGeneral,telefono_nmReturnGeneral);
			
			return telefono_nmReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public Telefono_NMParameterReturnGeneral procesarAccionTelefono_NMsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Telefono_NM> telefono_nms,Telefono_NMParameterReturnGeneral telefono_nmParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Telefono_NM.class.getSimpleName()+"-procesarAccionTelefono_NMsWithConnection");connexion.begin();			
			
			Telefono_NMParameterReturnGeneral telefono_nmReturnGeneral=new Telefono_NMParameterReturnGeneral();
	
			Telefono_NMLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,telefono_nms,telefono_nmParameterGeneral,telefono_nmReturnGeneral);
			
			this.connexion.commit();
			
			return telefono_nmReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public Telefono_NMParameterReturnGeneral procesarEventosTelefono_NMs(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Telefono_NM> telefono_nms,Telefono_NM telefono_nm,Telefono_NMParameterReturnGeneral telefono_nmParameterGeneral,Boolean isEsNuevoTelefono_NM,ArrayList<Classe> clases)throws Exception {
		 try {	
			Telefono_NMParameterReturnGeneral telefono_nmReturnGeneral=new Telefono_NMParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				telefono_nmReturnGeneral.setConRecargarPropiedades(true);
			}
			
			Telefono_NMLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,telefono_nms,telefono_nm,telefono_nmParameterGeneral,telefono_nmReturnGeneral,isEsNuevoTelefono_NM,clases);
			
			return telefono_nmReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public Telefono_NMParameterReturnGeneral procesarEventosTelefono_NMsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Telefono_NM> telefono_nms,Telefono_NM telefono_nm,Telefono_NMParameterReturnGeneral telefono_nmParameterGeneral,Boolean isEsNuevoTelefono_NM,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Telefono_NM.class.getSimpleName()+"-procesarEventosTelefono_NMsWithConnection");connexion.begin();			
			
			Telefono_NMParameterReturnGeneral telefono_nmReturnGeneral=new Telefono_NMParameterReturnGeneral();
	
			telefono_nmReturnGeneral.setTelefono_NM(telefono_nm);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				telefono_nmReturnGeneral.setConRecargarPropiedades(true);
			}
			
			Telefono_NMLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,telefono_nms,telefono_nm,telefono_nmParameterGeneral,telefono_nmReturnGeneral,isEsNuevoTelefono_NM,clases);
			
			this.connexion.commit();
			
			return telefono_nmReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public Telefono_NMParameterReturnGeneral procesarImportacionTelefono_NMsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,Telefono_NMParameterReturnGeneral telefono_nmParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Telefono_NM.class.getSimpleName()+"-procesarImportacionTelefono_NMsWithConnection");connexion.begin();			
			
			Telefono_NMParameterReturnGeneral telefono_nmReturnGeneral=new Telefono_NMParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.telefono_nms=new ArrayList<Telefono_NM>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.telefono_nm=new Telefono_NM();
				
				
				if(conColumnasBase) {this.telefono_nm.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.telefono_nm.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.telefono_nm.settelefono(arrColumnas[iColumn++]);
				
				this.telefono_nms.add(this.telefono_nm);
			}
			
			this.saveTelefono_NMs();
			
			this.connexion.commit();
			
			telefono_nmReturnGeneral.setConRetornoEstaProcesado(true);
			telefono_nmReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return telefono_nmReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTelefono_NMsEliminados() throws Exception {				
		
		List<Telefono_NM> telefono_nmsAux= new ArrayList<Telefono_NM>();
		
		for(Telefono_NM telefono_nm:telefono_nms) {
			if(!telefono_nm.getIsDeleted()) {
				telefono_nmsAux.add(telefono_nm);
			}
		}
		
		telefono_nms=telefono_nmsAux;
	}
	
	public void quitarTelefono_NMsNulos() throws Exception {				
		
		List<Telefono_NM> telefono_nmsAux= new ArrayList<Telefono_NM>();
		
		for(Telefono_NM telefono_nm : this.telefono_nms) {
			if(telefono_nm==null) {
				telefono_nmsAux.add(telefono_nm);
			}
		}
		
		//this.telefono_nms=telefono_nmsAux;
		
		this.telefono_nms.removeAll(telefono_nmsAux);
	}
	
	public void getSetVersionRowTelefono_NMWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(telefono_nm.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((telefono_nm.getIsDeleted() || (telefono_nm.getIsChanged()&&!telefono_nm.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=telefono_nmDataAccess.getSetVersionRowTelefono_NM(connexion,telefono_nm.getId());
				
				if(!telefono_nm.getVersionRow().equals(timestamp)) {	
					telefono_nm.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				telefono_nm.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTelefono_NM()throws Exception {	
		
		if(telefono_nm.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((telefono_nm.getIsDeleted() || (telefono_nm.getIsChanged()&&!telefono_nm.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=telefono_nmDataAccess.getSetVersionRowTelefono_NM(connexion,telefono_nm.getId());
			
			try {							
				if(!telefono_nm.getVersionRow().equals(timestamp)) {	
					telefono_nm.setVersionRow(timestamp);
				}
				
				telefono_nm.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTelefono_NMsWithConnection()throws Exception {	
		if(telefono_nms!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Telefono_NM telefono_nmAux:telefono_nms) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(telefono_nmAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(telefono_nmAux.getIsDeleted() || (telefono_nmAux.getIsChanged()&&!telefono_nmAux.getIsNew())) {
						
						timestamp=telefono_nmDataAccess.getSetVersionRowTelefono_NM(connexion,telefono_nmAux.getId());
						
						if(!telefono_nm.getVersionRow().equals(timestamp)) {	
							telefono_nmAux.setVersionRow(timestamp);
						}
								
						telefono_nmAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTelefono_NMs()throws Exception {	
		if(telefono_nms!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Telefono_NM telefono_nmAux:telefono_nms) {
					if(telefono_nmAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(telefono_nmAux.getIsDeleted() || (telefono_nmAux.getIsChanged()&&!telefono_nmAux.getIsNew())) {
						
						timestamp=telefono_nmDataAccess.getSetVersionRowTelefono_NM(connexion,telefono_nmAux.getId());
						
						if(!telefono_nmAux.getVersionRow().equals(timestamp)) {	
							telefono_nmAux.setVersionRow(timestamp);
						}
						
													
						telefono_nmAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public Telefono_NMParameterReturnGeneral cargarCombosLoteForeignKeyTelefono_NMWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado) throws Exception {
		Telefono_NMParameterReturnGeneral  telefono_nmReturnGeneral =new Telefono_NMParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Telefono_NM.class.getSimpleName()+"-cargarCombosLoteForeignKeyTelefono_NMWithConnection");connexion.begin();
			
			telefono_nmReturnGeneral =new Telefono_NMParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			telefono_nmReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			telefono_nmReturnGeneral.setempleadosForeignKey(empleadosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return telefono_nmReturnGeneral;
	}
	
	public Telefono_NMParameterReturnGeneral cargarCombosLoteForeignKeyTelefono_NM(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado) throws Exception {
		Telefono_NMParameterReturnGeneral  telefono_nmReturnGeneral =new Telefono_NMParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			telefono_nmReturnGeneral =new Telefono_NMParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			telefono_nmReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			telefono_nmReturnGeneral.setempleadosForeignKey(empleadosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return telefono_nmReturnGeneral;
	}
	
	
	public void deepLoad(Telefono_NM telefono_nm,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			Telefono_NMLogicAdditional.updateTelefono_NMToGet(telefono_nm,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		telefono_nm.setEmpresa(telefono_nmDataAccess.getEmpresa(connexion,telefono_nm));
		telefono_nm.setEmpleado(telefono_nmDataAccess.getEmpleado(connexion,telefono_nm));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				telefono_nm.setEmpresa(telefono_nmDataAccess.getEmpresa(connexion,telefono_nm));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				telefono_nm.setEmpleado(telefono_nmDataAccess.getEmpleado(connexion,telefono_nm));
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
			telefono_nm.setEmpresa(telefono_nmDataAccess.getEmpresa(connexion,telefono_nm));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			telefono_nm.setEmpleado(telefono_nmDataAccess.getEmpleado(connexion,telefono_nm));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		telefono_nm.setEmpresa(telefono_nmDataAccess.getEmpresa(connexion,telefono_nm));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(telefono_nm.getEmpresa(),isDeep,deepLoadType,clases);
				
		telefono_nm.setEmpleado(telefono_nmDataAccess.getEmpleado(connexion,telefono_nm));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(telefono_nm.getEmpleado(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				telefono_nm.setEmpresa(telefono_nmDataAccess.getEmpresa(connexion,telefono_nm));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(telefono_nm.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				telefono_nm.setEmpleado(telefono_nmDataAccess.getEmpleado(connexion,telefono_nm));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(telefono_nm.getEmpleado(),isDeep,deepLoadType,clases);				
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
			telefono_nm.setEmpresa(telefono_nmDataAccess.getEmpresa(connexion,telefono_nm));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(telefono_nm.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			telefono_nm.setEmpleado(telefono_nmDataAccess.getEmpleado(connexion,telefono_nm));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(telefono_nm.getEmpleado(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Telefono_NM telefono_nm,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			Telefono_NMLogicAdditional.updateTelefono_NMToSave(telefono_nm,this.arrDatoGeneral);
			
Telefono_NMDataAccess.save(telefono_nm, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(telefono_nm.getEmpresa(),connexion);

		EmpleadoDataAccess.save(telefono_nm.getEmpleado(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(telefono_nm.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(telefono_nm.getEmpleado(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(telefono_nm.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(telefono_nm.getEmpresa(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(telefono_nm.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(telefono_nm.getEmpleado(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(telefono_nm.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(telefono_nm.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(telefono_nm.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(telefono_nm.getEmpleado(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(Telefono_NM.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(telefono_nm,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				Telefono_NMConstantesFunciones.refrescarForeignKeysDescripcionesTelefono_NM(telefono_nm);
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
			this.deepLoad(this.telefono_nm,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				Telefono_NMConstantesFunciones.refrescarForeignKeysDescripcionesTelefono_NM(this.telefono_nm);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Telefono_NM.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(telefono_nms!=null) {
				for(Telefono_NM telefono_nm:telefono_nms) {
					this.deepLoad(telefono_nm,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					Telefono_NMConstantesFunciones.refrescarForeignKeysDescripcionesTelefono_NM(telefono_nms);
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
			if(telefono_nms!=null) {
				for(Telefono_NM telefono_nm:telefono_nms) {
					this.deepLoad(telefono_nm,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					Telefono_NMConstantesFunciones.refrescarForeignKeysDescripcionesTelefono_NM(telefono_nms);
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
			this.getNewConnexionToDeep(Telefono_NM.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(telefono_nm,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Telefono_NM.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(telefono_nms!=null) {
				for(Telefono_NM telefono_nm:telefono_nms) {
					this.deepSave(telefono_nm,isDeep,deepLoadType,clases);
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
			if(telefono_nms!=null) {
				for(Telefono_NM telefono_nm:telefono_nms) {
					this.deepSave(telefono_nm,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTelefono_NMsFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Telefono_NM.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,Telefono_NMConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			Telefono_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			telefono_nms=telefono_nmDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				Telefono_NMConstantesFunciones.refrescarForeignKeysDescripcionesTelefono_NM(this.telefono_nms);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTelefono_NMsFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,Telefono_NMConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			Telefono_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			telefono_nms=telefono_nmDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				Telefono_NMConstantesFunciones.refrescarForeignKeysDescripcionesTelefono_NM(this.telefono_nms);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTelefono_NMsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Telefono_NM.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,Telefono_NMConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			Telefono_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			telefono_nms=telefono_nmDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				Telefono_NMConstantesFunciones.refrescarForeignKeysDescripcionesTelefono_NM(this.telefono_nms);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTelefono_NMsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,Telefono_NMConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			Telefono_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			telefono_nms=telefono_nmDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				Telefono_NMConstantesFunciones.refrescarForeignKeysDescripcionesTelefono_NM(this.telefono_nms);
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
			if(Telefono_NMConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,Telefono_NMDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Telefono_NM telefono_nm,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(Telefono_NMConstantesFunciones.ISCONAUDITORIA) {
				if(telefono_nm.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,Telefono_NMDataAccess.TABLENAME, telefono_nm.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(Telefono_NMConstantesFunciones.ISCONAUDITORIADETALLE) {
						////Telefono_NMLogic.registrarAuditoriaDetallesTelefono_NM(connexion,telefono_nm,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(telefono_nm.getIsDeleted()) {
					/*if(!telefono_nm.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,Telefono_NMDataAccess.TABLENAME, telefono_nm.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////Telefono_NMLogic.registrarAuditoriaDetallesTelefono_NM(connexion,telefono_nm,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,Telefono_NMDataAccess.TABLENAME, telefono_nm.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(telefono_nm.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,Telefono_NMDataAccess.TABLENAME, telefono_nm.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(Telefono_NMConstantesFunciones.ISCONAUDITORIADETALLE) {
						////Telefono_NMLogic.registrarAuditoriaDetallesTelefono_NM(connexion,telefono_nm,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTelefono_NM(Connexion connexion,Telefono_NM telefono_nm)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(telefono_nm.getIsNew()||!telefono_nm.getid_empresa().equals(telefono_nm.getTelefono_NMOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(telefono_nm.getTelefono_NMOriginal().getid_empresa()!=null)
				{
					strValorActual=telefono_nm.getTelefono_NMOriginal().getid_empresa().toString();
				}
				if(telefono_nm.getid_empresa()!=null)
				{
					strValorNuevo=telefono_nm.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),Telefono_NMConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(telefono_nm.getIsNew()||!telefono_nm.getid_empleado().equals(telefono_nm.getTelefono_NMOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(telefono_nm.getTelefono_NMOriginal().getid_empleado()!=null)
				{
					strValorActual=telefono_nm.getTelefono_NMOriginal().getid_empleado().toString();
				}
				if(telefono_nm.getid_empleado()!=null)
				{
					strValorNuevo=telefono_nm.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),Telefono_NMConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(telefono_nm.getIsNew()||!telefono_nm.gettelefono().equals(telefono_nm.getTelefono_NMOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(telefono_nm.getTelefono_NMOriginal().gettelefono()!=null)
				{
					strValorActual=telefono_nm.getTelefono_NMOriginal().gettelefono();
				}
				if(telefono_nm.gettelefono()!=null)
				{
					strValorNuevo=telefono_nm.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),Telefono_NMConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTelefono_NMRelacionesWithConnection(Telefono_NM telefono_nm) throws Exception {

		if(!telefono_nm.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTelefono_NMRelacionesBase(telefono_nm,true);
		}
	}

	public void saveTelefono_NMRelaciones(Telefono_NM telefono_nm)throws Exception {

		if(!telefono_nm.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTelefono_NMRelacionesBase(telefono_nm,false);
		}
	}

	public void saveTelefono_NMRelacionesBase(Telefono_NM telefono_nm,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Telefono_NM-saveRelacionesWithConnection");}
	

			this.setTelefono_NM(telefono_nm);

			if(Telefono_NMLogicAdditional.validarSaveRelaciones(telefono_nm,this)) {

				Telefono_NMLogicAdditional.updateRelacionesToSave(telefono_nm,this);

				if((telefono_nm.getIsNew()||telefono_nm.getIsChanged())&&!telefono_nm.getIsDeleted()) {
					this.saveTelefono_NM();
					this.saveTelefono_NMRelacionesDetalles();

				} else if(telefono_nm.getIsDeleted()) {
					this.saveTelefono_NMRelacionesDetalles();
					this.saveTelefono_NM();
				}

				Telefono_NMLogicAdditional.updateRelacionesToSaveAfter(telefono_nm,this);

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
	
	
	private void saveTelefono_NMRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTelefono_NM(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=Telefono_NMConstantesFunciones.getClassesForeignKeysOfTelefono_NM(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTelefono_NM(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=Telefono_NMConstantesFunciones.getClassesRelationshipsOfTelefono_NM(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
