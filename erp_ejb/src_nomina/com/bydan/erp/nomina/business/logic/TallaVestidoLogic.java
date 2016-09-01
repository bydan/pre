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
import com.bydan.erp.nomina.util.TallaVestidoConstantesFunciones;
import com.bydan.erp.nomina.util.TallaVestidoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TallaVestidoParameterGeneral;
import com.bydan.erp.nomina.business.entity.TallaVestido;
import com.bydan.erp.nomina.business.logic.TallaVestidoLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TallaVestidoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TallaVestidoLogic.class);
	
	protected TallaVestidoDataAccess tallavestidoDataAccess; 	
	protected TallaVestido tallavestido;
	protected List<TallaVestido> tallavestidos;
	protected Object tallavestidoObject;	
	protected List<Object> tallavestidosObject;
	
	public static ClassValidator<TallaVestido> tallavestidoValidator = new ClassValidator<TallaVestido>(TallaVestido.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TallaVestidoLogicAdditional tallavestidoLogicAdditional=null;
	
	public TallaVestidoLogicAdditional getTallaVestidoLogicAdditional() {
		return this.tallavestidoLogicAdditional;
	}
	
	public void setTallaVestidoLogicAdditional(TallaVestidoLogicAdditional tallavestidoLogicAdditional) {
		try {
			this.tallavestidoLogicAdditional=tallavestidoLogicAdditional;
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
	
	
	
	
	public  TallaVestidoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tallavestidoDataAccess = new TallaVestidoDataAccess();
			
			this.tallavestidos= new ArrayList<TallaVestido>();
			this.tallavestido= new TallaVestido();
			
			this.tallavestidoObject=new Object();
			this.tallavestidosObject=new ArrayList<Object>();
				
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
			
			this.tallavestidoDataAccess.setConnexionType(this.connexionType);
			this.tallavestidoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TallaVestidoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tallavestidoDataAccess = new TallaVestidoDataAccess();
			this.tallavestidos= new ArrayList<TallaVestido>();
			this.tallavestido= new TallaVestido();
			this.tallavestidoObject=new Object();
			this.tallavestidosObject=new ArrayList<Object>();
			
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
			
			this.tallavestidoDataAccess.setConnexionType(this.connexionType);
			this.tallavestidoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TallaVestido getTallaVestido() throws Exception {	
		TallaVestidoLogicAdditional.checkTallaVestidoToGet(tallavestido,this.datosCliente,this.arrDatoGeneral);
		TallaVestidoLogicAdditional.updateTallaVestidoToGet(tallavestido,this.arrDatoGeneral);
		
		return tallavestido;
	}
		
	public void setTallaVestido(TallaVestido newTallaVestido) {
		this.tallavestido = newTallaVestido;
	}
	
	public TallaVestidoDataAccess getTallaVestidoDataAccess() {
		return tallavestidoDataAccess;
	}
	
	public void setTallaVestidoDataAccess(TallaVestidoDataAccess newtallavestidoDataAccess) {
		this.tallavestidoDataAccess = newtallavestidoDataAccess;
	}
	
	public List<TallaVestido> getTallaVestidos() throws Exception {		
		this.quitarTallaVestidosNulos();
		
		TallaVestidoLogicAdditional.checkTallaVestidoToGets(tallavestidos,this.datosCliente,this.arrDatoGeneral);
		
		for (TallaVestido tallavestidoLocal: tallavestidos ) {
			TallaVestidoLogicAdditional.updateTallaVestidoToGet(tallavestidoLocal,this.arrDatoGeneral);
		}
		
		return tallavestidos;
	}
	
	public void setTallaVestidos(List<TallaVestido> newTallaVestidos) {
		this.tallavestidos = newTallaVestidos;
	}
	
	public Object getTallaVestidoObject() {	
		this.tallavestidoObject=this.tallavestidoDataAccess.getEntityObject();
		return this.tallavestidoObject;
	}
		
	public void setTallaVestidoObject(Object newTallaVestidoObject) {
		this.tallavestidoObject = newTallaVestidoObject;
	}
	
	public List<Object> getTallaVestidosObject() {		
		this.tallavestidosObject=this.tallavestidoDataAccess.getEntitiesObject();
		return this.tallavestidosObject;
	}
		
	public void setTallaVestidosObject(List<Object> newTallaVestidosObject) {
		this.tallavestidosObject = newTallaVestidosObject;
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
		
		if(this.tallavestidoDataAccess!=null) {
			this.tallavestidoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TallaVestido.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tallavestidoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tallavestidoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tallavestido = new  TallaVestido();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TallaVestido.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tallavestido=tallavestidoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tallavestido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TallaVestidoConstantesFunciones.refrescarForeignKeysDescripcionesTallaVestido(this.tallavestido);
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
		tallavestido = new  TallaVestido();
		  		  
        try {
			
			tallavestido=tallavestidoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tallavestido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TallaVestidoConstantesFunciones.refrescarForeignKeysDescripcionesTallaVestido(this.tallavestido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tallavestido = new  TallaVestido();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TallaVestido.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tallavestido=tallavestidoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tallavestido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TallaVestidoConstantesFunciones.refrescarForeignKeysDescripcionesTallaVestido(this.tallavestido);
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
		tallavestido = new  TallaVestido();
		  		  
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
		tallavestido = new  TallaVestido();
		  		  
        try {
			
			tallavestido=tallavestidoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tallavestido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TallaVestidoConstantesFunciones.refrescarForeignKeysDescripcionesTallaVestido(this.tallavestido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tallavestido = new  TallaVestido();
		  		  
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
		tallavestido = new  TallaVestido();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TallaVestido.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tallavestidoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tallavestido = new  TallaVestido();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tallavestidoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tallavestido = new  TallaVestido();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TallaVestido.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tallavestidoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tallavestido = new  TallaVestido();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tallavestidoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tallavestido = new  TallaVestido();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TallaVestido.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tallavestidoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tallavestido = new  TallaVestido();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tallavestidoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tallavestidos = new  ArrayList<TallaVestido>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TallaVestido.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TallaVestidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tallavestidos=tallavestidoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTallaVestido(tallavestidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TallaVestidoConstantesFunciones.refrescarForeignKeysDescripcionesTallaVestido(this.tallavestidos);
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
		tallavestidos = new  ArrayList<TallaVestido>();
		  		  
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
		tallavestidos = new  ArrayList<TallaVestido>();
		  		  
        try {			
			TallaVestidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tallavestidos=tallavestidoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTallaVestido(tallavestidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TallaVestidoConstantesFunciones.refrescarForeignKeysDescripcionesTallaVestido(this.tallavestidos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tallavestidos = new  ArrayList<TallaVestido>();
		  		  
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
		tallavestidos = new  ArrayList<TallaVestido>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TallaVestido.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TallaVestidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tallavestidos=tallavestidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTallaVestido(tallavestidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TallaVestidoConstantesFunciones.refrescarForeignKeysDescripcionesTallaVestido(this.tallavestidos);
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
		tallavestidos = new  ArrayList<TallaVestido>();
		  		  
        try {
			TallaVestidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tallavestidos=tallavestidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTallaVestido(tallavestidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TallaVestidoConstantesFunciones.refrescarForeignKeysDescripcionesTallaVestido(this.tallavestidos);
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
		tallavestidos = new  ArrayList<TallaVestido>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TallaVestido.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TallaVestidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tallavestidos=tallavestidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTallaVestido(tallavestidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TallaVestidoConstantesFunciones.refrescarForeignKeysDescripcionesTallaVestido(this.tallavestidos);
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
		tallavestidos = new  ArrayList<TallaVestido>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TallaVestidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tallavestidos=tallavestidoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTallaVestido(tallavestidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TallaVestidoConstantesFunciones.refrescarForeignKeysDescripcionesTallaVestido(this.tallavestidos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tallavestido = new  TallaVestido();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TallaVestido.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TallaVestidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tallavestido=tallavestidoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTallaVestido(tallavestido);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TallaVestidoConstantesFunciones.refrescarForeignKeysDescripcionesTallaVestido(this.tallavestido);
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
		tallavestido = new  TallaVestido();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TallaVestidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tallavestido=tallavestidoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTallaVestido(tallavestido);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TallaVestidoConstantesFunciones.refrescarForeignKeysDescripcionesTallaVestido(this.tallavestido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tallavestidos = new  ArrayList<TallaVestido>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TallaVestido.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TallaVestidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tallavestidos=tallavestidoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTallaVestido(tallavestidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TallaVestidoConstantesFunciones.refrescarForeignKeysDescripcionesTallaVestido(this.tallavestidos);
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
		tallavestidos = new  ArrayList<TallaVestido>();
		  		  
        try {
			TallaVestidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tallavestidos=tallavestidoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTallaVestido(tallavestidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TallaVestidoConstantesFunciones.refrescarForeignKeysDescripcionesTallaVestido(this.tallavestidos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTallaVestidosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tallavestidos = new  ArrayList<TallaVestido>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TallaVestido.class.getSimpleName()+"-getTodosTallaVestidosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TallaVestidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tallavestidos=tallavestidoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTallaVestido(tallavestidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TallaVestidoConstantesFunciones.refrescarForeignKeysDescripcionesTallaVestido(this.tallavestidos);
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
	
	public  void  getTodosTallaVestidos(String sFinalQuery,Pagination pagination)throws Exception {
		tallavestidos = new  ArrayList<TallaVestido>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TallaVestidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tallavestidos=tallavestidoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTallaVestido(tallavestidos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TallaVestidoConstantesFunciones.refrescarForeignKeysDescripcionesTallaVestido(this.tallavestidos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTallaVestido(TallaVestido tallavestido) throws Exception {
		Boolean estaValidado=false;
		
		if(tallavestido.getIsNew() || tallavestido.getIsChanged()) { 
			this.invalidValues = tallavestidoValidator.getInvalidValues(tallavestido);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tallavestido);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTallaVestido(List<TallaVestido> TallaVestidos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TallaVestido tallavestidoLocal:tallavestidos) {				
			estaValidadoObjeto=this.validarGuardarTallaVestido(tallavestidoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTallaVestido(List<TallaVestido> TallaVestidos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTallaVestido(tallavestidos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTallaVestido(TallaVestido TallaVestido) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTallaVestido(tallavestido)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TallaVestido tallavestido) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tallavestido.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TallaVestidoConstantesFunciones.getTallaVestidoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tallavestido","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TallaVestidoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TallaVestidoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTallaVestidoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TallaVestido.class.getSimpleName()+"-saveTallaVestidoWithConnection");connexion.begin();			
			
			TallaVestidoLogicAdditional.checkTallaVestidoToSave(this.tallavestido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TallaVestidoLogicAdditional.updateTallaVestidoToSave(this.tallavestido,this.arrDatoGeneral);
			
			TallaVestidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tallavestido,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTallaVestido();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTallaVestido(this.tallavestido)) {
				TallaVestidoDataAccess.save(this.tallavestido, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tallavestido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TallaVestidoLogicAdditional.checkTallaVestidoToSaveAfter(this.tallavestido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTallaVestido();
			
			connexion.commit();			
			
			if(this.tallavestido.getIsDeleted()) {
				this.tallavestido=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTallaVestido()throws Exception {	
		try {	
			
			TallaVestidoLogicAdditional.checkTallaVestidoToSave(this.tallavestido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TallaVestidoLogicAdditional.updateTallaVestidoToSave(this.tallavestido,this.arrDatoGeneral);
			
			TallaVestidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tallavestido,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTallaVestido(this.tallavestido)) {			
				TallaVestidoDataAccess.save(this.tallavestido, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tallavestido,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TallaVestidoLogicAdditional.checkTallaVestidoToSaveAfter(this.tallavestido,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tallavestido.getIsDeleted()) {
				this.tallavestido=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTallaVestidosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TallaVestido.class.getSimpleName()+"-saveTallaVestidosWithConnection");connexion.begin();			
			
			TallaVestidoLogicAdditional.checkTallaVestidoToSaves(tallavestidos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTallaVestidos();
			
			Boolean validadoTodosTallaVestido=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TallaVestido tallavestidoLocal:tallavestidos) {		
				if(tallavestidoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TallaVestidoLogicAdditional.updateTallaVestidoToSave(tallavestidoLocal,this.arrDatoGeneral);
	        	
				TallaVestidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tallavestidoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTallaVestido(tallavestidoLocal)) {
					TallaVestidoDataAccess.save(tallavestidoLocal, connexion);				
				} else {
					validadoTodosTallaVestido=false;
				}
			}
			
			if(!validadoTodosTallaVestido) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TallaVestidoLogicAdditional.checkTallaVestidoToSavesAfter(tallavestidos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTallaVestidos();
			
			connexion.commit();		
			
			this.quitarTallaVestidosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTallaVestidos()throws Exception {				
		 try {	
			TallaVestidoLogicAdditional.checkTallaVestidoToSaves(tallavestidos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTallaVestido=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TallaVestido tallavestidoLocal:tallavestidos) {				
				if(tallavestidoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TallaVestidoLogicAdditional.updateTallaVestidoToSave(tallavestidoLocal,this.arrDatoGeneral);
	        	
				TallaVestidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tallavestidoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTallaVestido(tallavestidoLocal)) {				
					TallaVestidoDataAccess.save(tallavestidoLocal, connexion);				
				} else {
					validadoTodosTallaVestido=false;
				}
			}
			
			if(!validadoTodosTallaVestido) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TallaVestidoLogicAdditional.checkTallaVestidoToSavesAfter(tallavestidos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTallaVestidosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TallaVestidoParameterReturnGeneral procesarAccionTallaVestidos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TallaVestido> tallavestidos,TallaVestidoParameterReturnGeneral tallavestidoParameterGeneral)throws Exception {
		 try {	
			TallaVestidoParameterReturnGeneral tallavestidoReturnGeneral=new TallaVestidoParameterReturnGeneral();
	
			TallaVestidoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tallavestidos,tallavestidoParameterGeneral,tallavestidoReturnGeneral);
			
			return tallavestidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TallaVestidoParameterReturnGeneral procesarAccionTallaVestidosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TallaVestido> tallavestidos,TallaVestidoParameterReturnGeneral tallavestidoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TallaVestido.class.getSimpleName()+"-procesarAccionTallaVestidosWithConnection");connexion.begin();			
			
			TallaVestidoParameterReturnGeneral tallavestidoReturnGeneral=new TallaVestidoParameterReturnGeneral();
	
			TallaVestidoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tallavestidos,tallavestidoParameterGeneral,tallavestidoReturnGeneral);
			
			this.connexion.commit();
			
			return tallavestidoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TallaVestidoParameterReturnGeneral procesarEventosTallaVestidos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TallaVestido> tallavestidos,TallaVestido tallavestido,TallaVestidoParameterReturnGeneral tallavestidoParameterGeneral,Boolean isEsNuevoTallaVestido,ArrayList<Classe> clases)throws Exception {
		 try {	
			TallaVestidoParameterReturnGeneral tallavestidoReturnGeneral=new TallaVestidoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tallavestidoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TallaVestidoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tallavestidos,tallavestido,tallavestidoParameterGeneral,tallavestidoReturnGeneral,isEsNuevoTallaVestido,clases);
			
			return tallavestidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TallaVestidoParameterReturnGeneral procesarEventosTallaVestidosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TallaVestido> tallavestidos,TallaVestido tallavestido,TallaVestidoParameterReturnGeneral tallavestidoParameterGeneral,Boolean isEsNuevoTallaVestido,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TallaVestido.class.getSimpleName()+"-procesarEventosTallaVestidosWithConnection");connexion.begin();			
			
			TallaVestidoParameterReturnGeneral tallavestidoReturnGeneral=new TallaVestidoParameterReturnGeneral();
	
			tallavestidoReturnGeneral.setTallaVestido(tallavestido);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tallavestidoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TallaVestidoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tallavestidos,tallavestido,tallavestidoParameterGeneral,tallavestidoReturnGeneral,isEsNuevoTallaVestido,clases);
			
			this.connexion.commit();
			
			return tallavestidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TallaVestidoParameterReturnGeneral procesarImportacionTallaVestidosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TallaVestidoParameterReturnGeneral tallavestidoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TallaVestido.class.getSimpleName()+"-procesarImportacionTallaVestidosWithConnection");connexion.begin();			
			
			TallaVestidoParameterReturnGeneral tallavestidoReturnGeneral=new TallaVestidoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tallavestidos=new ArrayList<TallaVestido>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tallavestido=new TallaVestido();
				
				
				if(conColumnasBase) {this.tallavestido.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tallavestido.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tallavestido.settalla(Double.parseDouble(arrColumnas[iColumn++]));
				this.tallavestido.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.tallavestido.setdescripcion(arrColumnas[iColumn++]);
				
				this.tallavestidos.add(this.tallavestido);
			}
			
			this.saveTallaVestidos();
			
			this.connexion.commit();
			
			tallavestidoReturnGeneral.setConRetornoEstaProcesado(true);
			tallavestidoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tallavestidoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTallaVestidosEliminados() throws Exception {				
		
		List<TallaVestido> tallavestidosAux= new ArrayList<TallaVestido>();
		
		for(TallaVestido tallavestido:tallavestidos) {
			if(!tallavestido.getIsDeleted()) {
				tallavestidosAux.add(tallavestido);
			}
		}
		
		tallavestidos=tallavestidosAux;
	}
	
	public void quitarTallaVestidosNulos() throws Exception {				
		
		List<TallaVestido> tallavestidosAux= new ArrayList<TallaVestido>();
		
		for(TallaVestido tallavestido : this.tallavestidos) {
			if(tallavestido==null) {
				tallavestidosAux.add(tallavestido);
			}
		}
		
		//this.tallavestidos=tallavestidosAux;
		
		this.tallavestidos.removeAll(tallavestidosAux);
	}
	
	public void getSetVersionRowTallaVestidoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tallavestido.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tallavestido.getIsDeleted() || (tallavestido.getIsChanged()&&!tallavestido.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tallavestidoDataAccess.getSetVersionRowTallaVestido(connexion,tallavestido.getId());
				
				if(!tallavestido.getVersionRow().equals(timestamp)) {	
					tallavestido.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tallavestido.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTallaVestido()throws Exception {	
		
		if(tallavestido.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tallavestido.getIsDeleted() || (tallavestido.getIsChanged()&&!tallavestido.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tallavestidoDataAccess.getSetVersionRowTallaVestido(connexion,tallavestido.getId());
			
			try {							
				if(!tallavestido.getVersionRow().equals(timestamp)) {	
					tallavestido.setVersionRow(timestamp);
				}
				
				tallavestido.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTallaVestidosWithConnection()throws Exception {	
		if(tallavestidos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TallaVestido tallavestidoAux:tallavestidos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tallavestidoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tallavestidoAux.getIsDeleted() || (tallavestidoAux.getIsChanged()&&!tallavestidoAux.getIsNew())) {
						
						timestamp=tallavestidoDataAccess.getSetVersionRowTallaVestido(connexion,tallavestidoAux.getId());
						
						if(!tallavestido.getVersionRow().equals(timestamp)) {	
							tallavestidoAux.setVersionRow(timestamp);
						}
								
						tallavestidoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTallaVestidos()throws Exception {	
		if(tallavestidos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TallaVestido tallavestidoAux:tallavestidos) {
					if(tallavestidoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tallavestidoAux.getIsDeleted() || (tallavestidoAux.getIsChanged()&&!tallavestidoAux.getIsNew())) {
						
						timestamp=tallavestidoDataAccess.getSetVersionRowTallaVestido(connexion,tallavestidoAux.getId());
						
						if(!tallavestidoAux.getVersionRow().equals(timestamp)) {	
							tallavestidoAux.setVersionRow(timestamp);
						}
						
													
						tallavestidoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TallaVestidoParameterReturnGeneral cargarCombosLoteForeignKeyTallaVestidoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalVestimenta) throws Exception {
		TallaVestidoParameterReturnGeneral  tallavestidoReturnGeneral =new TallaVestidoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TallaVestido.class.getSimpleName()+"-cargarCombosLoteForeignKeyTallaVestidoWithConnection");connexion.begin();
			
			tallavestidoReturnGeneral =new TallaVestidoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tallavestidoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			tallavestidoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Vestimenta> vestimentasForeignKey=new ArrayList<Vestimenta>();
			VestimentaLogic vestimentaLogic=new VestimentaLogic();
			vestimentaLogic.setConnexion(this.connexion);
			vestimentaLogic.getVestimentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVestimenta.equals("NONE")) {
				vestimentaLogic.getTodosVestimentas(finalQueryGlobalVestimenta,new Pagination());
				vestimentasForeignKey=vestimentaLogic.getVestimentas();
			}

			tallavestidoReturnGeneral.setvestimentasForeignKey(vestimentasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tallavestidoReturnGeneral;
	}
	
	public TallaVestidoParameterReturnGeneral cargarCombosLoteForeignKeyTallaVestido(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalVestimenta) throws Exception {
		TallaVestidoParameterReturnGeneral  tallavestidoReturnGeneral =new TallaVestidoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tallavestidoReturnGeneral =new TallaVestidoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tallavestidoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			tallavestidoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Vestimenta> vestimentasForeignKey=new ArrayList<Vestimenta>();
			VestimentaLogic vestimentaLogic=new VestimentaLogic();
			vestimentaLogic.setConnexion(this.connexion);
			vestimentaLogic.getVestimentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVestimenta.equals("NONE")) {
				vestimentaLogic.getTodosVestimentas(finalQueryGlobalVestimenta,new Pagination());
				vestimentasForeignKey=vestimentaLogic.getVestimentas();
			}

			tallavestidoReturnGeneral.setvestimentasForeignKey(vestimentasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tallavestidoReturnGeneral;
	}
	
	
	public void deepLoad(TallaVestido tallavestido,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TallaVestidoLogicAdditional.updateTallaVestidoToGet(tallavestido,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tallavestido.setEmpresa(tallavestidoDataAccess.getEmpresa(connexion,tallavestido));
		tallavestido.setEmpleado(tallavestidoDataAccess.getEmpleado(connexion,tallavestido));
		tallavestido.setVestimenta(tallavestidoDataAccess.getVestimenta(connexion,tallavestido));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tallavestido.setEmpresa(tallavestidoDataAccess.getEmpresa(connexion,tallavestido));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				tallavestido.setEmpleado(tallavestidoDataAccess.getEmpleado(connexion,tallavestido));
				continue;
			}

			if(clas.clas.equals(Vestimenta.class)) {
				tallavestido.setVestimenta(tallavestidoDataAccess.getVestimenta(connexion,tallavestido));
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
			tallavestido.setEmpresa(tallavestidoDataAccess.getEmpresa(connexion,tallavestido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tallavestido.setEmpleado(tallavestidoDataAccess.getEmpleado(connexion,tallavestido));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vestimenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tallavestido.setVestimenta(tallavestidoDataAccess.getVestimenta(connexion,tallavestido));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tallavestido.setEmpresa(tallavestidoDataAccess.getEmpresa(connexion,tallavestido));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tallavestido.getEmpresa(),isDeep,deepLoadType,clases);
				
		tallavestido.setEmpleado(tallavestidoDataAccess.getEmpleado(connexion,tallavestido));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(tallavestido.getEmpleado(),isDeep,deepLoadType,clases);
				
		tallavestido.setVestimenta(tallavestidoDataAccess.getVestimenta(connexion,tallavestido));
		VestimentaLogic vestimentaLogic= new VestimentaLogic(connexion);
		vestimentaLogic.deepLoad(tallavestido.getVestimenta(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tallavestido.setEmpresa(tallavestidoDataAccess.getEmpresa(connexion,tallavestido));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tallavestido.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				tallavestido.setEmpleado(tallavestidoDataAccess.getEmpleado(connexion,tallavestido));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(tallavestido.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vestimenta.class)) {
				tallavestido.setVestimenta(tallavestidoDataAccess.getVestimenta(connexion,tallavestido));
				VestimentaLogic vestimentaLogic= new VestimentaLogic(connexion);
				vestimentaLogic.deepLoad(tallavestido.getVestimenta(),isDeep,deepLoadType,clases);				
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
			tallavestido.setEmpresa(tallavestidoDataAccess.getEmpresa(connexion,tallavestido));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tallavestido.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tallavestido.setEmpleado(tallavestidoDataAccess.getEmpleado(connexion,tallavestido));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(tallavestido.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Vestimenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tallavestido.setVestimenta(tallavestidoDataAccess.getVestimenta(connexion,tallavestido));
			VestimentaLogic vestimentaLogic= new VestimentaLogic(connexion);
			vestimentaLogic.deepLoad(tallavestido.getVestimenta(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TallaVestido tallavestido,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TallaVestidoLogicAdditional.updateTallaVestidoToSave(tallavestido,this.arrDatoGeneral);
			
TallaVestidoDataAccess.save(tallavestido, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tallavestido.getEmpresa(),connexion);

		EmpleadoDataAccess.save(tallavestido.getEmpleado(),connexion);

		VestimentaDataAccess.save(tallavestido.getVestimenta(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tallavestido.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(tallavestido.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Vestimenta.class)) {
				VestimentaDataAccess.save(tallavestido.getVestimenta(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tallavestido.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tallavestido.getEmpresa(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(tallavestido.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(tallavestido.getEmpleado(),isDeep,deepLoadType,clases);
				

		VestimentaDataAccess.save(tallavestido.getVestimenta(),connexion);
		VestimentaLogic vestimentaLogic= new VestimentaLogic(connexion);
		vestimentaLogic.deepLoad(tallavestido.getVestimenta(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tallavestido.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tallavestido.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(tallavestido.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(tallavestido.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vestimenta.class)) {
				VestimentaDataAccess.save(tallavestido.getVestimenta(),connexion);
				VestimentaLogic vestimentaLogic= new VestimentaLogic(connexion);
				vestimentaLogic.deepSave(tallavestido.getVestimenta(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(TallaVestido.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tallavestido,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TallaVestidoConstantesFunciones.refrescarForeignKeysDescripcionesTallaVestido(tallavestido);
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
			this.deepLoad(this.tallavestido,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TallaVestidoConstantesFunciones.refrescarForeignKeysDescripcionesTallaVestido(this.tallavestido);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TallaVestido.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tallavestidos!=null) {
				for(TallaVestido tallavestido:tallavestidos) {
					this.deepLoad(tallavestido,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TallaVestidoConstantesFunciones.refrescarForeignKeysDescripcionesTallaVestido(tallavestidos);
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
			if(tallavestidos!=null) {
				for(TallaVestido tallavestido:tallavestidos) {
					this.deepLoad(tallavestido,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TallaVestidoConstantesFunciones.refrescarForeignKeysDescripcionesTallaVestido(tallavestidos);
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
			this.getNewConnexionToDeep(TallaVestido.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tallavestido,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TallaVestido.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tallavestidos!=null) {
				for(TallaVestido tallavestido:tallavestidos) {
					this.deepSave(tallavestido,isDeep,deepLoadType,clases);
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
			if(tallavestidos!=null) {
				for(TallaVestido tallavestido:tallavestidos) {
					this.deepSave(tallavestido,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTallaVestidosFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TallaVestido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,TallaVestidoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			TallaVestidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tallavestidos=tallavestidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TallaVestidoConstantesFunciones.refrescarForeignKeysDescripcionesTallaVestido(this.tallavestidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTallaVestidosFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,TallaVestidoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			TallaVestidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tallavestidos=tallavestidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TallaVestidoConstantesFunciones.refrescarForeignKeysDescripcionesTallaVestido(this.tallavestidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTallaVestidosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TallaVestido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TallaVestidoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TallaVestidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tallavestidos=tallavestidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TallaVestidoConstantesFunciones.refrescarForeignKeysDescripcionesTallaVestido(this.tallavestidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTallaVestidosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TallaVestidoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TallaVestidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tallavestidos=tallavestidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TallaVestidoConstantesFunciones.refrescarForeignKeysDescripcionesTallaVestido(this.tallavestidos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTallaVestidosFK_IdVestimentaWithConnection(String sFinalQuery,Pagination pagination,Long id_vestimenta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TallaVestido.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVestimenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVestimenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vestimenta,TallaVestidoConstantesFunciones.IDVESTIMENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVestimenta);

			TallaVestidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVestimenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tallavestidos=tallavestidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TallaVestidoConstantesFunciones.refrescarForeignKeysDescripcionesTallaVestido(this.tallavestidos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTallaVestidosFK_IdVestimenta(String sFinalQuery,Pagination pagination,Long id_vestimenta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVestimenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVestimenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vestimenta,TallaVestidoConstantesFunciones.IDVESTIMENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVestimenta);

			TallaVestidoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVestimenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tallavestidos=tallavestidoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TallaVestidoConstantesFunciones.refrescarForeignKeysDescripcionesTallaVestido(this.tallavestidos);
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
			if(TallaVestidoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TallaVestidoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TallaVestido tallavestido,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TallaVestidoConstantesFunciones.ISCONAUDITORIA) {
				if(tallavestido.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TallaVestidoDataAccess.TABLENAME, tallavestido.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TallaVestidoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TallaVestidoLogic.registrarAuditoriaDetallesTallaVestido(connexion,tallavestido,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tallavestido.getIsDeleted()) {
					/*if(!tallavestido.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TallaVestidoDataAccess.TABLENAME, tallavestido.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TallaVestidoLogic.registrarAuditoriaDetallesTallaVestido(connexion,tallavestido,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TallaVestidoDataAccess.TABLENAME, tallavestido.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tallavestido.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TallaVestidoDataAccess.TABLENAME, tallavestido.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TallaVestidoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TallaVestidoLogic.registrarAuditoriaDetallesTallaVestido(connexion,tallavestido,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTallaVestido(Connexion connexion,TallaVestido tallavestido)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tallavestido.getIsNew()||!tallavestido.getid_empresa().equals(tallavestido.getTallaVestidoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tallavestido.getTallaVestidoOriginal().getid_empresa()!=null)
				{
					strValorActual=tallavestido.getTallaVestidoOriginal().getid_empresa().toString();
				}
				if(tallavestido.getid_empresa()!=null)
				{
					strValorNuevo=tallavestido.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TallaVestidoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tallavestido.getIsNew()||!tallavestido.getid_empleado().equals(tallavestido.getTallaVestidoOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tallavestido.getTallaVestidoOriginal().getid_empleado()!=null)
				{
					strValorActual=tallavestido.getTallaVestidoOriginal().getid_empleado().toString();
				}
				if(tallavestido.getid_empleado()!=null)
				{
					strValorNuevo=tallavestido.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TallaVestidoConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(tallavestido.getIsNew()||!tallavestido.getid_vestimenta().equals(tallavestido.getTallaVestidoOriginal().getid_vestimenta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tallavestido.getTallaVestidoOriginal().getid_vestimenta()!=null)
				{
					strValorActual=tallavestido.getTallaVestidoOriginal().getid_vestimenta().toString();
				}
				if(tallavestido.getid_vestimenta()!=null)
				{
					strValorNuevo=tallavestido.getid_vestimenta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TallaVestidoConstantesFunciones.IDVESTIMENTA,strValorActual,strValorNuevo);
			}	
			
			if(tallavestido.getIsNew()||!tallavestido.gettalla().equals(tallavestido.getTallaVestidoOriginal().gettalla()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tallavestido.getTallaVestidoOriginal().gettalla()!=null)
				{
					strValorActual=tallavestido.getTallaVestidoOriginal().gettalla().toString();
				}
				if(tallavestido.gettalla()!=null)
				{
					strValorNuevo=tallavestido.gettalla().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TallaVestidoConstantesFunciones.TALLA,strValorActual,strValorNuevo);
			}	
			
			if(tallavestido.getIsNew()||!tallavestido.getcantidad().equals(tallavestido.getTallaVestidoOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tallavestido.getTallaVestidoOriginal().getcantidad()!=null)
				{
					strValorActual=tallavestido.getTallaVestidoOriginal().getcantidad().toString();
				}
				if(tallavestido.getcantidad()!=null)
				{
					strValorNuevo=tallavestido.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TallaVestidoConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(tallavestido.getIsNew()||!tallavestido.getdescripcion().equals(tallavestido.getTallaVestidoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tallavestido.getTallaVestidoOriginal().getdescripcion()!=null)
				{
					strValorActual=tallavestido.getTallaVestidoOriginal().getdescripcion();
				}
				if(tallavestido.getdescripcion()!=null)
				{
					strValorNuevo=tallavestido.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TallaVestidoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTallaVestidoRelacionesWithConnection(TallaVestido tallavestido) throws Exception {

		if(!tallavestido.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTallaVestidoRelacionesBase(tallavestido,true);
		}
	}

	public void saveTallaVestidoRelaciones(TallaVestido tallavestido)throws Exception {

		if(!tallavestido.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTallaVestidoRelacionesBase(tallavestido,false);
		}
	}

	public void saveTallaVestidoRelacionesBase(TallaVestido tallavestido,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TallaVestido-saveRelacionesWithConnection");}
	

			this.setTallaVestido(tallavestido);

			if(TallaVestidoLogicAdditional.validarSaveRelaciones(tallavestido,this)) {

				TallaVestidoLogicAdditional.updateRelacionesToSave(tallavestido,this);

				if((tallavestido.getIsNew()||tallavestido.getIsChanged())&&!tallavestido.getIsDeleted()) {
					this.saveTallaVestido();
					this.saveTallaVestidoRelacionesDetalles();

				} else if(tallavestido.getIsDeleted()) {
					this.saveTallaVestidoRelacionesDetalles();
					this.saveTallaVestido();
				}

				TallaVestidoLogicAdditional.updateRelacionesToSaveAfter(tallavestido,this);

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
	
	
	private void saveTallaVestidoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTallaVestido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TallaVestidoConstantesFunciones.getClassesForeignKeysOfTallaVestido(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTallaVestido(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TallaVestidoConstantesFunciones.getClassesRelationshipsOfTallaVestido(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
