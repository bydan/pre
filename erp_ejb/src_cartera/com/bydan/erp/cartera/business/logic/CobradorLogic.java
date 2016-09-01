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
package com.bydan.erp.cartera.business.logic;

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
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.cartera.util.CobradorConstantesFunciones;
import com.bydan.erp.cartera.util.CobradorParameterReturnGeneral;
//import com.bydan.erp.cartera.util.CobradorParameterGeneral;
import com.bydan.erp.cartera.business.entity.Cobrador;
import com.bydan.erp.cartera.business.logic.CobradorLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class CobradorLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CobradorLogic.class);
	
	protected CobradorDataAccess cobradorDataAccess; 	
	protected Cobrador cobrador;
	protected List<Cobrador> cobradors;
	protected Object cobradorObject;	
	protected List<Object> cobradorsObject;
	
	public static ClassValidator<Cobrador> cobradorValidator = new ClassValidator<Cobrador>(Cobrador.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CobradorLogicAdditional cobradorLogicAdditional=null;
	
	public CobradorLogicAdditional getCobradorLogicAdditional() {
		return this.cobradorLogicAdditional;
	}
	
	public void setCobradorLogicAdditional(CobradorLogicAdditional cobradorLogicAdditional) {
		try {
			this.cobradorLogicAdditional=cobradorLogicAdditional;
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
	
	
	
	
	public  CobradorLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.cobradorDataAccess = new CobradorDataAccess();
			
			this.cobradors= new ArrayList<Cobrador>();
			this.cobrador= new Cobrador();
			
			this.cobradorObject=new Object();
			this.cobradorsObject=new ArrayList<Object>();
				
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
			
			this.cobradorDataAccess.setConnexionType(this.connexionType);
			this.cobradorDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CobradorLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.cobradorDataAccess = new CobradorDataAccess();
			this.cobradors= new ArrayList<Cobrador>();
			this.cobrador= new Cobrador();
			this.cobradorObject=new Object();
			this.cobradorsObject=new ArrayList<Object>();
			
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
			
			this.cobradorDataAccess.setConnexionType(this.connexionType);
			this.cobradorDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Cobrador getCobrador() throws Exception {	
		CobradorLogicAdditional.checkCobradorToGet(cobrador,this.datosCliente,this.arrDatoGeneral);
		CobradorLogicAdditional.updateCobradorToGet(cobrador,this.arrDatoGeneral);
		
		return cobrador;
	}
		
	public void setCobrador(Cobrador newCobrador) {
		this.cobrador = newCobrador;
	}
	
	public CobradorDataAccess getCobradorDataAccess() {
		return cobradorDataAccess;
	}
	
	public void setCobradorDataAccess(CobradorDataAccess newcobradorDataAccess) {
		this.cobradorDataAccess = newcobradorDataAccess;
	}
	
	public List<Cobrador> getCobradors() throws Exception {		
		this.quitarCobradorsNulos();
		
		CobradorLogicAdditional.checkCobradorToGets(cobradors,this.datosCliente,this.arrDatoGeneral);
		
		for (Cobrador cobradorLocal: cobradors ) {
			CobradorLogicAdditional.updateCobradorToGet(cobradorLocal,this.arrDatoGeneral);
		}
		
		return cobradors;
	}
	
	public void setCobradors(List<Cobrador> newCobradors) {
		this.cobradors = newCobradors;
	}
	
	public Object getCobradorObject() {	
		this.cobradorObject=this.cobradorDataAccess.getEntityObject();
		return this.cobradorObject;
	}
		
	public void setCobradorObject(Object newCobradorObject) {
		this.cobradorObject = newCobradorObject;
	}
	
	public List<Object> getCobradorsObject() {		
		this.cobradorsObject=this.cobradorDataAccess.getEntitiesObject();
		return this.cobradorsObject;
	}
		
	public void setCobradorsObject(List<Object> newCobradorsObject) {
		this.cobradorsObject = newCobradorsObject;
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
		
		if(this.cobradorDataAccess!=null) {
			this.cobradorDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cobrador.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			cobradorDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			cobradorDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		cobrador = new  Cobrador();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cobrador.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cobrador=cobradorDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cobrador,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CobradorConstantesFunciones.refrescarForeignKeysDescripcionesCobrador(this.cobrador);
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
		cobrador = new  Cobrador();
		  		  
        try {
			
			cobrador=cobradorDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cobrador,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CobradorConstantesFunciones.refrescarForeignKeysDescripcionesCobrador(this.cobrador);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		cobrador = new  Cobrador();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cobrador.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cobrador=cobradorDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cobrador,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CobradorConstantesFunciones.refrescarForeignKeysDescripcionesCobrador(this.cobrador);
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
		cobrador = new  Cobrador();
		  		  
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
		cobrador = new  Cobrador();
		  		  
        try {
			
			cobrador=cobradorDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cobrador,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CobradorConstantesFunciones.refrescarForeignKeysDescripcionesCobrador(this.cobrador);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		cobrador = new  Cobrador();
		  		  
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
		cobrador = new  Cobrador();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cobrador.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =cobradorDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cobrador = new  Cobrador();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=cobradorDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cobrador = new  Cobrador();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cobrador.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =cobradorDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cobrador = new  Cobrador();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=cobradorDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cobrador = new  Cobrador();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cobrador.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =cobradorDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cobrador = new  Cobrador();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=cobradorDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cobradors = new  ArrayList<Cobrador>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cobrador.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CobradorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobradors=cobradorDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCobrador(cobradors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CobradorConstantesFunciones.refrescarForeignKeysDescripcionesCobrador(this.cobradors);
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
		cobradors = new  ArrayList<Cobrador>();
		  		  
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
		cobradors = new  ArrayList<Cobrador>();
		  		  
        try {			
			CobradorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobradors=cobradorDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCobrador(cobradors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CobradorConstantesFunciones.refrescarForeignKeysDescripcionesCobrador(this.cobradors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		cobradors = new  ArrayList<Cobrador>();
		  		  
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
		cobradors = new  ArrayList<Cobrador>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cobrador.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CobradorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobradors=cobradorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCobrador(cobradors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CobradorConstantesFunciones.refrescarForeignKeysDescripcionesCobrador(this.cobradors);
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
		cobradors = new  ArrayList<Cobrador>();
		  		  
        try {
			CobradorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobradors=cobradorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCobrador(cobradors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CobradorConstantesFunciones.refrescarForeignKeysDescripcionesCobrador(this.cobradors);
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
		cobradors = new  ArrayList<Cobrador>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cobrador.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CobradorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobradors=cobradorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCobrador(cobradors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CobradorConstantesFunciones.refrescarForeignKeysDescripcionesCobrador(this.cobradors);
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
		cobradors = new  ArrayList<Cobrador>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CobradorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobradors=cobradorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCobrador(cobradors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CobradorConstantesFunciones.refrescarForeignKeysDescripcionesCobrador(this.cobradors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		cobrador = new  Cobrador();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cobrador.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CobradorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrador=cobradorDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCobrador(cobrador);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CobradorConstantesFunciones.refrescarForeignKeysDescripcionesCobrador(this.cobrador);
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
		cobrador = new  Cobrador();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CobradorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobrador=cobradorDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCobrador(cobrador);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CobradorConstantesFunciones.refrescarForeignKeysDescripcionesCobrador(this.cobrador);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cobradors = new  ArrayList<Cobrador>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cobrador.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CobradorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobradors=cobradorDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCobrador(cobradors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CobradorConstantesFunciones.refrescarForeignKeysDescripcionesCobrador(this.cobradors);
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
		cobradors = new  ArrayList<Cobrador>();
		  		  
        try {
			CobradorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobradors=cobradorDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCobrador(cobradors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CobradorConstantesFunciones.refrescarForeignKeysDescripcionesCobrador(this.cobradors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCobradorsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		cobradors = new  ArrayList<Cobrador>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cobrador.class.getSimpleName()+"-getTodosCobradorsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CobradorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobradors=cobradorDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCobrador(cobradors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CobradorConstantesFunciones.refrescarForeignKeysDescripcionesCobrador(this.cobradors);
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
	
	public  void  getTodosCobradors(String sFinalQuery,Pagination pagination)throws Exception {
		cobradors = new  ArrayList<Cobrador>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CobradorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cobradors=cobradorDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCobrador(cobradors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CobradorConstantesFunciones.refrescarForeignKeysDescripcionesCobrador(this.cobradors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCobrador(Cobrador cobrador) throws Exception {
		Boolean estaValidado=false;
		
		if(cobrador.getIsNew() || cobrador.getIsChanged()) { 
			this.invalidValues = cobradorValidator.getInvalidValues(cobrador);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(cobrador);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCobrador(List<Cobrador> Cobradors) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Cobrador cobradorLocal:cobradors) {				
			estaValidadoObjeto=this.validarGuardarCobrador(cobradorLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCobrador(List<Cobrador> Cobradors) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCobrador(cobradors)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCobrador(Cobrador Cobrador) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCobrador(cobrador)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Cobrador cobrador) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+cobrador.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CobradorConstantesFunciones.getCobradorLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"cobrador","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CobradorConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CobradorConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCobradorWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cobrador.class.getSimpleName()+"-saveCobradorWithConnection");connexion.begin();			
			
			CobradorLogicAdditional.checkCobradorToSave(this.cobrador,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CobradorLogicAdditional.updateCobradorToSave(this.cobrador,this.arrDatoGeneral);
			
			CobradorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cobrador,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCobrador();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCobrador(this.cobrador)) {
				CobradorDataAccess.save(this.cobrador, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.cobrador,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CobradorLogicAdditional.checkCobradorToSaveAfter(this.cobrador,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCobrador();
			
			connexion.commit();			
			
			if(this.cobrador.getIsDeleted()) {
				this.cobrador=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCobrador()throws Exception {	
		try {	
			
			CobradorLogicAdditional.checkCobradorToSave(this.cobrador,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CobradorLogicAdditional.updateCobradorToSave(this.cobrador,this.arrDatoGeneral);
			
			CobradorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cobrador,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCobrador(this.cobrador)) {			
				CobradorDataAccess.save(this.cobrador, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.cobrador,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CobradorLogicAdditional.checkCobradorToSaveAfter(this.cobrador,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.cobrador.getIsDeleted()) {
				this.cobrador=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCobradorsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cobrador.class.getSimpleName()+"-saveCobradorsWithConnection");connexion.begin();			
			
			CobradorLogicAdditional.checkCobradorToSaves(cobradors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCobradors();
			
			Boolean validadoTodosCobrador=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Cobrador cobradorLocal:cobradors) {		
				if(cobradorLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CobradorLogicAdditional.updateCobradorToSave(cobradorLocal,this.arrDatoGeneral);
	        	
				CobradorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cobradorLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCobrador(cobradorLocal)) {
					CobradorDataAccess.save(cobradorLocal, connexion);				
				} else {
					validadoTodosCobrador=false;
				}
			}
			
			if(!validadoTodosCobrador) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CobradorLogicAdditional.checkCobradorToSavesAfter(cobradors,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCobradors();
			
			connexion.commit();		
			
			this.quitarCobradorsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCobradors()throws Exception {				
		 try {	
			CobradorLogicAdditional.checkCobradorToSaves(cobradors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCobrador=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Cobrador cobradorLocal:cobradors) {				
				if(cobradorLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CobradorLogicAdditional.updateCobradorToSave(cobradorLocal,this.arrDatoGeneral);
	        	
				CobradorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cobradorLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCobrador(cobradorLocal)) {				
					CobradorDataAccess.save(cobradorLocal, connexion);				
				} else {
					validadoTodosCobrador=false;
				}
			}
			
			if(!validadoTodosCobrador) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CobradorLogicAdditional.checkCobradorToSavesAfter(cobradors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCobradorsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CobradorParameterReturnGeneral procesarAccionCobradors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Cobrador> cobradors,CobradorParameterReturnGeneral cobradorParameterGeneral)throws Exception {
		 try {	
			CobradorParameterReturnGeneral cobradorReturnGeneral=new CobradorParameterReturnGeneral();
	
			CobradorLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cobradors,cobradorParameterGeneral,cobradorReturnGeneral);
			
			return cobradorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CobradorParameterReturnGeneral procesarAccionCobradorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Cobrador> cobradors,CobradorParameterReturnGeneral cobradorParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cobrador.class.getSimpleName()+"-procesarAccionCobradorsWithConnection");connexion.begin();			
			
			CobradorParameterReturnGeneral cobradorReturnGeneral=new CobradorParameterReturnGeneral();
	
			CobradorLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cobradors,cobradorParameterGeneral,cobradorReturnGeneral);
			
			this.connexion.commit();
			
			return cobradorReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CobradorParameterReturnGeneral procesarEventosCobradors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Cobrador> cobradors,Cobrador cobrador,CobradorParameterReturnGeneral cobradorParameterGeneral,Boolean isEsNuevoCobrador,ArrayList<Classe> clases)throws Exception {
		 try {	
			CobradorParameterReturnGeneral cobradorReturnGeneral=new CobradorParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cobradorReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CobradorLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cobradors,cobrador,cobradorParameterGeneral,cobradorReturnGeneral,isEsNuevoCobrador,clases);
			
			return cobradorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CobradorParameterReturnGeneral procesarEventosCobradorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Cobrador> cobradors,Cobrador cobrador,CobradorParameterReturnGeneral cobradorParameterGeneral,Boolean isEsNuevoCobrador,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cobrador.class.getSimpleName()+"-procesarEventosCobradorsWithConnection");connexion.begin();			
			
			CobradorParameterReturnGeneral cobradorReturnGeneral=new CobradorParameterReturnGeneral();
	
			cobradorReturnGeneral.setCobrador(cobrador);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cobradorReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CobradorLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cobradors,cobrador,cobradorParameterGeneral,cobradorReturnGeneral,isEsNuevoCobrador,clases);
			
			this.connexion.commit();
			
			return cobradorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CobradorParameterReturnGeneral procesarImportacionCobradorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CobradorParameterReturnGeneral cobradorParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cobrador.class.getSimpleName()+"-procesarImportacionCobradorsWithConnection");connexion.begin();			
			
			CobradorParameterReturnGeneral cobradorReturnGeneral=new CobradorParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.cobradors=new ArrayList<Cobrador>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.cobrador=new Cobrador();
				
				
				if(conColumnasBase) {this.cobrador.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.cobrador.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.cobrador.setidentificacion(arrColumnas[iColumn++]);
				this.cobrador.setapellido(arrColumnas[iColumn++]);
				this.cobrador.setnombre(arrColumnas[iColumn++]);
				this.cobrador.setdireccion(arrColumnas[iColumn++]);
				this.cobrador.settelefono(arrColumnas[iColumn++]);
				
				this.cobradors.add(this.cobrador);
			}
			
			this.saveCobradors();
			
			this.connexion.commit();
			
			cobradorReturnGeneral.setConRetornoEstaProcesado(true);
			cobradorReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return cobradorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCobradorsEliminados() throws Exception {				
		
		List<Cobrador> cobradorsAux= new ArrayList<Cobrador>();
		
		for(Cobrador cobrador:cobradors) {
			if(!cobrador.getIsDeleted()) {
				cobradorsAux.add(cobrador);
			}
		}
		
		cobradors=cobradorsAux;
	}
	
	public void quitarCobradorsNulos() throws Exception {				
		
		List<Cobrador> cobradorsAux= new ArrayList<Cobrador>();
		
		for(Cobrador cobrador : this.cobradors) {
			if(cobrador==null) {
				cobradorsAux.add(cobrador);
			}
		}
		
		//this.cobradors=cobradorsAux;
		
		this.cobradors.removeAll(cobradorsAux);
	}
	
	public void getSetVersionRowCobradorWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(cobrador.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((cobrador.getIsDeleted() || (cobrador.getIsChanged()&&!cobrador.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=cobradorDataAccess.getSetVersionRowCobrador(connexion,cobrador.getId());
				
				if(!cobrador.getVersionRow().equals(timestamp)) {	
					cobrador.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				cobrador.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCobrador()throws Exception {	
		
		if(cobrador.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((cobrador.getIsDeleted() || (cobrador.getIsChanged()&&!cobrador.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=cobradorDataAccess.getSetVersionRowCobrador(connexion,cobrador.getId());
			
			try {							
				if(!cobrador.getVersionRow().equals(timestamp)) {	
					cobrador.setVersionRow(timestamp);
				}
				
				cobrador.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCobradorsWithConnection()throws Exception {	
		if(cobradors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Cobrador cobradorAux:cobradors) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(cobradorAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cobradorAux.getIsDeleted() || (cobradorAux.getIsChanged()&&!cobradorAux.getIsNew())) {
						
						timestamp=cobradorDataAccess.getSetVersionRowCobrador(connexion,cobradorAux.getId());
						
						if(!cobrador.getVersionRow().equals(timestamp)) {	
							cobradorAux.setVersionRow(timestamp);
						}
								
						cobradorAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCobradors()throws Exception {	
		if(cobradors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Cobrador cobradorAux:cobradors) {
					if(cobradorAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cobradorAux.getIsDeleted() || (cobradorAux.getIsChanged()&&!cobradorAux.getIsNew())) {
						
						timestamp=cobradorDataAccess.getSetVersionRowCobrador(connexion,cobradorAux.getId());
						
						if(!cobradorAux.getVersionRow().equals(timestamp)) {	
							cobradorAux.setVersionRow(timestamp);
						}
						
													
						cobradorAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CobradorParameterReturnGeneral cargarCombosLoteForeignKeyCobradorWithConnection(String finalQueryGlobalTipoIdentificacion) throws Exception {
		CobradorParameterReturnGeneral  cobradorReturnGeneral =new CobradorParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cobrador.class.getSimpleName()+"-cargarCombosLoteForeignKeyCobradorWithConnection");connexion.begin();
			
			cobradorReturnGeneral =new CobradorParameterReturnGeneral();
			
			

			List<TipoIdentificacion> tipoidentificacionsForeignKey=new ArrayList<TipoIdentificacion>();
			TipoIdentificacionLogic tipoidentificacionLogic=new TipoIdentificacionLogic();
			tipoidentificacionLogic.setConnexion(this.connexion);
			tipoidentificacionLogic.getTipoIdentificacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIdentificacion.equals("NONE")) {
				tipoidentificacionLogic.getTodosTipoIdentificacions(finalQueryGlobalTipoIdentificacion,new Pagination());
				tipoidentificacionsForeignKey=tipoidentificacionLogic.getTipoIdentificacions();
			}

			cobradorReturnGeneral.settipoidentificacionsForeignKey(tipoidentificacionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return cobradorReturnGeneral;
	}
	
	public CobradorParameterReturnGeneral cargarCombosLoteForeignKeyCobrador(String finalQueryGlobalTipoIdentificacion) throws Exception {
		CobradorParameterReturnGeneral  cobradorReturnGeneral =new CobradorParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			cobradorReturnGeneral =new CobradorParameterReturnGeneral();
			
			

			List<TipoIdentificacion> tipoidentificacionsForeignKey=new ArrayList<TipoIdentificacion>();
			TipoIdentificacionLogic tipoidentificacionLogic=new TipoIdentificacionLogic();
			tipoidentificacionLogic.setConnexion(this.connexion);
			tipoidentificacionLogic.getTipoIdentificacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIdentificacion.equals("NONE")) {
				tipoidentificacionLogic.getTodosTipoIdentificacions(finalQueryGlobalTipoIdentificacion,new Pagination());
				tipoidentificacionsForeignKey=tipoidentificacionLogic.getTipoIdentificacions();
			}

			cobradorReturnGeneral.settipoidentificacionsForeignKey(tipoidentificacionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return cobradorReturnGeneral;
	}
	
	
	public void deepLoad(Cobrador cobrador,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CobradorLogicAdditional.updateCobradorToGet(cobrador,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cobrador.setTipoIdentificacion(cobradorDataAccess.getTipoIdentificacion(connexion,cobrador));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIdentificacion.class)) {
				cobrador.setTipoIdentificacion(cobradorDataAccess.getTipoIdentificacion(connexion,cobrador));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIdentificacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrador.setTipoIdentificacion(cobradorDataAccess.getTipoIdentificacion(connexion,cobrador));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cobrador.setTipoIdentificacion(cobradorDataAccess.getTipoIdentificacion(connexion,cobrador));
		TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
		tipoidentificacionLogic.deepLoad(cobrador.getTipoIdentificacion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIdentificacion.class)) {
				cobrador.setTipoIdentificacion(cobradorDataAccess.getTipoIdentificacion(connexion,cobrador));
				TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
				tipoidentificacionLogic.deepLoad(cobrador.getTipoIdentificacion(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIdentificacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cobrador.setTipoIdentificacion(cobradorDataAccess.getTipoIdentificacion(connexion,cobrador));
			TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
			tipoidentificacionLogic.deepLoad(cobrador.getTipoIdentificacion(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Cobrador cobrador,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CobradorLogicAdditional.updateCobradorToSave(cobrador,this.arrDatoGeneral);
			
CobradorDataAccess.save(cobrador, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		TipoIdentificacionDataAccess.save(cobrador.getTipoIdentificacion(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIdentificacion.class)) {
				TipoIdentificacionDataAccess.save(cobrador.getTipoIdentificacion(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		TipoIdentificacionDataAccess.save(cobrador.getTipoIdentificacion(),connexion);
		TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
		tipoidentificacionLogic.deepLoad(cobrador.getTipoIdentificacion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIdentificacion.class)) {
				TipoIdentificacionDataAccess.save(cobrador.getTipoIdentificacion(),connexion);
				TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
				tipoidentificacionLogic.deepSave(cobrador.getTipoIdentificacion(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(Cobrador.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(cobrador,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CobradorConstantesFunciones.refrescarForeignKeysDescripcionesCobrador(cobrador);
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
			this.deepLoad(this.cobrador,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CobradorConstantesFunciones.refrescarForeignKeysDescripcionesCobrador(this.cobrador);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Cobrador.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(cobradors!=null) {
				for(Cobrador cobrador:cobradors) {
					this.deepLoad(cobrador,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CobradorConstantesFunciones.refrescarForeignKeysDescripcionesCobrador(cobradors);
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
			if(cobradors!=null) {
				for(Cobrador cobrador:cobradors) {
					this.deepLoad(cobrador,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CobradorConstantesFunciones.refrescarForeignKeysDescripcionesCobrador(cobradors);
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
			this.getNewConnexionToDeep(Cobrador.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(cobrador,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Cobrador.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(cobradors!=null) {
				for(Cobrador cobrador:cobradors) {
					this.deepSave(cobrador,isDeep,deepLoadType,clases);
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
			if(cobradors!=null) {
				for(Cobrador cobrador:cobradors) {
					this.deepSave(cobrador,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCobradorsFK_IdTipoIdentificacionWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_identificacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cobrador.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIdentificacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIdentificacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_identificacion,CobradorConstantesFunciones.IDTIPOIDENTIFICACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIdentificacion);

			CobradorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoIdentificacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cobradors=cobradorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CobradorConstantesFunciones.refrescarForeignKeysDescripcionesCobrador(this.cobradors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCobradorsFK_IdTipoIdentificacion(String sFinalQuery,Pagination pagination,Long id_tipo_identificacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIdentificacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIdentificacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_identificacion,CobradorConstantesFunciones.IDTIPOIDENTIFICACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIdentificacion);

			CobradorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoIdentificacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cobradors=cobradorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CobradorConstantesFunciones.refrescarForeignKeysDescripcionesCobrador(this.cobradors);
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
			if(CobradorConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CobradorDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Cobrador cobrador,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CobradorConstantesFunciones.ISCONAUDITORIA) {
				if(cobrador.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CobradorDataAccess.TABLENAME, cobrador.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CobradorConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CobradorLogic.registrarAuditoriaDetallesCobrador(connexion,cobrador,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(cobrador.getIsDeleted()) {
					/*if(!cobrador.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CobradorDataAccess.TABLENAME, cobrador.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CobradorLogic.registrarAuditoriaDetallesCobrador(connexion,cobrador,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CobradorDataAccess.TABLENAME, cobrador.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(cobrador.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CobradorDataAccess.TABLENAME, cobrador.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CobradorConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CobradorLogic.registrarAuditoriaDetallesCobrador(connexion,cobrador,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCobrador(Connexion connexion,Cobrador cobrador)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(cobrador.getIsNew()||!cobrador.getid_tipo_identificacion().equals(cobrador.getCobradorOriginal().getid_tipo_identificacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cobrador.getCobradorOriginal().getid_tipo_identificacion()!=null)
				{
					strValorActual=cobrador.getCobradorOriginal().getid_tipo_identificacion().toString();
				}
				if(cobrador.getid_tipo_identificacion()!=null)
				{
					strValorNuevo=cobrador.getid_tipo_identificacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CobradorConstantesFunciones.IDTIPOIDENTIFICACION,strValorActual,strValorNuevo);
			}	
			
			if(cobrador.getIsNew()||!cobrador.getidentificacion().equals(cobrador.getCobradorOriginal().getidentificacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cobrador.getCobradorOriginal().getidentificacion()!=null)
				{
					strValorActual=cobrador.getCobradorOriginal().getidentificacion();
				}
				if(cobrador.getidentificacion()!=null)
				{
					strValorNuevo=cobrador.getidentificacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CobradorConstantesFunciones.IDENTIFICACION,strValorActual,strValorNuevo);
			}	
			
			if(cobrador.getIsNew()||!cobrador.getapellido().equals(cobrador.getCobradorOriginal().getapellido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cobrador.getCobradorOriginal().getapellido()!=null)
				{
					strValorActual=cobrador.getCobradorOriginal().getapellido();
				}
				if(cobrador.getapellido()!=null)
				{
					strValorNuevo=cobrador.getapellido() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CobradorConstantesFunciones.APELLIDO,strValorActual,strValorNuevo);
			}	
			
			if(cobrador.getIsNew()||!cobrador.getnombre().equals(cobrador.getCobradorOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cobrador.getCobradorOriginal().getnombre()!=null)
				{
					strValorActual=cobrador.getCobradorOriginal().getnombre();
				}
				if(cobrador.getnombre()!=null)
				{
					strValorNuevo=cobrador.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CobradorConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(cobrador.getIsNew()||!cobrador.getdireccion().equals(cobrador.getCobradorOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cobrador.getCobradorOriginal().getdireccion()!=null)
				{
					strValorActual=cobrador.getCobradorOriginal().getdireccion();
				}
				if(cobrador.getdireccion()!=null)
				{
					strValorNuevo=cobrador.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CobradorConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(cobrador.getIsNew()||!cobrador.gettelefono().equals(cobrador.getCobradorOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cobrador.getCobradorOriginal().gettelefono()!=null)
				{
					strValorActual=cobrador.getCobradorOriginal().gettelefono();
				}
				if(cobrador.gettelefono()!=null)
				{
					strValorNuevo=cobrador.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CobradorConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCobradorRelacionesWithConnection(Cobrador cobrador) throws Exception {

		if(!cobrador.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCobradorRelacionesBase(cobrador,true);
		}
	}

	public void saveCobradorRelaciones(Cobrador cobrador)throws Exception {

		if(!cobrador.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCobradorRelacionesBase(cobrador,false);
		}
	}

	public void saveCobradorRelacionesBase(Cobrador cobrador,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Cobrador-saveRelacionesWithConnection");}
	

			this.setCobrador(cobrador);

			if(CobradorLogicAdditional.validarSaveRelaciones(cobrador,this)) {

				CobradorLogicAdditional.updateRelacionesToSave(cobrador,this);

				if((cobrador.getIsNew()||cobrador.getIsChanged())&&!cobrador.getIsDeleted()) {
					this.saveCobrador();
					this.saveCobradorRelacionesDetalles();

				} else if(cobrador.getIsDeleted()) {
					this.saveCobradorRelacionesDetalles();
					this.saveCobrador();
				}

				CobradorLogicAdditional.updateRelacionesToSaveAfter(cobrador,this);

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
	
	
	private void saveCobradorRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCobrador(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CobradorConstantesFunciones.getClassesForeignKeysOfCobrador(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrador(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CobradorConstantesFunciones.getClassesRelationshipsOfCobrador(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
