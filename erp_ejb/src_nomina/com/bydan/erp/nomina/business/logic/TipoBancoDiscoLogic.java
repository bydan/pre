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
import com.bydan.erp.nomina.util.TipoBancoDiscoConstantesFunciones;
import com.bydan.erp.nomina.util.TipoBancoDiscoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoBancoDiscoParameterGeneral;
import com.bydan.erp.nomina.business.entity.TipoBancoDisco;
//import com.bydan.erp.nomina.business.logic.TipoBancoDiscoLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class TipoBancoDiscoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoBancoDiscoLogic.class);
	
	protected TipoBancoDiscoDataAccess tipobancodiscoDataAccess; 	
	protected TipoBancoDisco tipobancodisco;
	protected List<TipoBancoDisco> tipobancodiscos;
	protected Object tipobancodiscoObject;	
	protected List<Object> tipobancodiscosObject;
	
	public static ClassValidator<TipoBancoDisco> tipobancodiscoValidator = new ClassValidator<TipoBancoDisco>(TipoBancoDisco.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
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
	
	
	
	
	public  TipoBancoDiscoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipobancodiscoDataAccess = new TipoBancoDiscoDataAccess();
			
			this.tipobancodiscos= new ArrayList<TipoBancoDisco>();
			this.tipobancodisco= new TipoBancoDisco();
			
			this.tipobancodiscoObject=new Object();
			this.tipobancodiscosObject=new ArrayList<Object>();
				
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
			
			this.tipobancodiscoDataAccess.setConnexionType(this.connexionType);
			this.tipobancodiscoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoBancoDiscoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipobancodiscoDataAccess = new TipoBancoDiscoDataAccess();
			this.tipobancodiscos= new ArrayList<TipoBancoDisco>();
			this.tipobancodisco= new TipoBancoDisco();
			this.tipobancodiscoObject=new Object();
			this.tipobancodiscosObject=new ArrayList<Object>();
			
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
			
			this.tipobancodiscoDataAccess.setConnexionType(this.connexionType);
			this.tipobancodiscoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoBancoDisco getTipoBancoDisco() throws Exception {	
		//TipoBancoDiscoLogicAdditional.checkTipoBancoDiscoToGet(tipobancodisco,this.datosCliente,this.arrDatoGeneral);
		//TipoBancoDiscoLogicAdditional.updateTipoBancoDiscoToGet(tipobancodisco,this.arrDatoGeneral);
		
		return tipobancodisco;
	}
		
	public void setTipoBancoDisco(TipoBancoDisco newTipoBancoDisco) {
		this.tipobancodisco = newTipoBancoDisco;
	}
	
	public TipoBancoDiscoDataAccess getTipoBancoDiscoDataAccess() {
		return tipobancodiscoDataAccess;
	}
	
	public void setTipoBancoDiscoDataAccess(TipoBancoDiscoDataAccess newtipobancodiscoDataAccess) {
		this.tipobancodiscoDataAccess = newtipobancodiscoDataAccess;
	}
	
	public List<TipoBancoDisco> getTipoBancoDiscos() throws Exception {		
		this.quitarTipoBancoDiscosNulos();
		
		//TipoBancoDiscoLogicAdditional.checkTipoBancoDiscoToGets(tipobancodiscos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoBancoDisco tipobancodiscoLocal: tipobancodiscos ) {
			//TipoBancoDiscoLogicAdditional.updateTipoBancoDiscoToGet(tipobancodiscoLocal,this.arrDatoGeneral);
		}
		
		return tipobancodiscos;
	}
	
	public void setTipoBancoDiscos(List<TipoBancoDisco> newTipoBancoDiscos) {
		this.tipobancodiscos = newTipoBancoDiscos;
	}
	
	public Object getTipoBancoDiscoObject() {	
		this.tipobancodiscoObject=this.tipobancodiscoDataAccess.getEntityObject();
		return this.tipobancodiscoObject;
	}
		
	public void setTipoBancoDiscoObject(Object newTipoBancoDiscoObject) {
		this.tipobancodiscoObject = newTipoBancoDiscoObject;
	}
	
	public List<Object> getTipoBancoDiscosObject() {		
		this.tipobancodiscosObject=this.tipobancodiscoDataAccess.getEntitiesObject();
		return this.tipobancodiscosObject;
	}
		
	public void setTipoBancoDiscosObject(List<Object> newTipoBancoDiscosObject) {
		this.tipobancodiscosObject = newTipoBancoDiscosObject;
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
		
		if(this.tipobancodiscoDataAccess!=null) {
			this.tipobancodiscoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoDisco.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipobancodiscoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipobancodiscoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipobancodisco = new  TipoBancoDisco();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoDisco.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipobancodisco=tipobancodiscoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipobancodisco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoBancoDiscoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoDisco(this.tipobancodisco);
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
		tipobancodisco = new  TipoBancoDisco();
		  		  
        try {
			
			tipobancodisco=tipobancodiscoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipobancodisco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoBancoDiscoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoDisco(this.tipobancodisco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipobancodisco = new  TipoBancoDisco();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoDisco.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipobancodisco=tipobancodiscoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipobancodisco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoBancoDiscoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoDisco(this.tipobancodisco);
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
		tipobancodisco = new  TipoBancoDisco();
		  		  
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
		tipobancodisco = new  TipoBancoDisco();
		  		  
        try {
			
			tipobancodisco=tipobancodiscoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipobancodisco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoBancoDiscoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoDisco(this.tipobancodisco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipobancodisco = new  TipoBancoDisco();
		  		  
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
		tipobancodisco = new  TipoBancoDisco();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoDisco.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipobancodiscoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipobancodisco = new  TipoBancoDisco();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipobancodiscoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipobancodisco = new  TipoBancoDisco();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoDisco.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipobancodiscoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipobancodisco = new  TipoBancoDisco();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipobancodiscoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipobancodisco = new  TipoBancoDisco();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoDisco.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipobancodiscoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipobancodisco = new  TipoBancoDisco();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipobancodiscoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipobancodiscos = new  ArrayList<TipoBancoDisco>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoDisco.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoBancoDiscoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancodiscos=tipobancodiscoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoBancoDisco(tipobancodiscos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoDiscoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoDisco(this.tipobancodiscos);
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
		tipobancodiscos = new  ArrayList<TipoBancoDisco>();
		  		  
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
		tipobancodiscos = new  ArrayList<TipoBancoDisco>();
		  		  
        try {			
			TipoBancoDiscoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancodiscos=tipobancodiscoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoBancoDisco(tipobancodiscos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoDiscoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoDisco(this.tipobancodiscos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipobancodiscos = new  ArrayList<TipoBancoDisco>();
		  		  
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
		tipobancodiscos = new  ArrayList<TipoBancoDisco>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoDisco.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoBancoDiscoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancodiscos=tipobancodiscoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoBancoDisco(tipobancodiscos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoDiscoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoDisco(this.tipobancodiscos);
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
		tipobancodiscos = new  ArrayList<TipoBancoDisco>();
		  		  
        try {
			TipoBancoDiscoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancodiscos=tipobancodiscoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoBancoDisco(tipobancodiscos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoDiscoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoDisco(this.tipobancodiscos);
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
		tipobancodiscos = new  ArrayList<TipoBancoDisco>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoDisco.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoBancoDiscoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancodiscos=tipobancodiscoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoBancoDisco(tipobancodiscos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoDiscoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoDisco(this.tipobancodiscos);
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
		tipobancodiscos = new  ArrayList<TipoBancoDisco>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoBancoDiscoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancodiscos=tipobancodiscoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoBancoDisco(tipobancodiscos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoDiscoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoDisco(this.tipobancodiscos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipobancodisco = new  TipoBancoDisco();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoDisco.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoBancoDiscoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancodisco=tipobancodiscoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoBancoDisco(tipobancodisco);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoDiscoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoDisco(this.tipobancodisco);
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
		tipobancodisco = new  TipoBancoDisco();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoBancoDiscoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancodisco=tipobancodiscoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoBancoDisco(tipobancodisco);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoDiscoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoDisco(this.tipobancodisco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoBancoDiscosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipobancodiscos = new  ArrayList<TipoBancoDisco>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoDisco.class.getSimpleName()+"-getTodosTipoBancoDiscosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoBancoDiscoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancodiscos=tipobancodiscoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoBancoDisco(tipobancodiscos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoDiscoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoDisco(this.tipobancodiscos);
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
	
	public  void  getTodosTipoBancoDiscos(String sFinalQuery,Pagination pagination)throws Exception {
		tipobancodiscos = new  ArrayList<TipoBancoDisco>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoBancoDiscoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancodiscos=tipobancodiscoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoBancoDisco(tipobancodiscos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoDiscoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoDisco(this.tipobancodiscos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoBancoDisco(TipoBancoDisco tipobancodisco) throws Exception {
		Boolean estaValidado=false;
		
		if(tipobancodisco.getIsNew() || tipobancodisco.getIsChanged()) { 
			this.invalidValues = tipobancodiscoValidator.getInvalidValues(tipobancodisco);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipobancodisco);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoBancoDisco(List<TipoBancoDisco> TipoBancoDiscos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoBancoDisco tipobancodiscoLocal:tipobancodiscos) {				
			estaValidadoObjeto=this.validarGuardarTipoBancoDisco(tipobancodiscoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoBancoDisco(List<TipoBancoDisco> TipoBancoDiscos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoBancoDisco(tipobancodiscos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoBancoDisco(TipoBancoDisco TipoBancoDisco) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoBancoDisco(tipobancodisco)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoBancoDisco tipobancodisco) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipobancodisco.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoBancoDiscoConstantesFunciones.getTipoBancoDiscoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipobancodisco","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoBancoDiscoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoBancoDiscoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoBancoDiscoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoDisco.class.getSimpleName()+"-saveTipoBancoDiscoWithConnection");connexion.begin();			
			
			//TipoBancoDiscoLogicAdditional.checkTipoBancoDiscoToSave(this.tipobancodisco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoBancoDiscoLogicAdditional.updateTipoBancoDiscoToSave(this.tipobancodisco,this.arrDatoGeneral);
			
			TipoBancoDiscoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipobancodisco,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoBancoDisco();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoBancoDisco(this.tipobancodisco)) {
				TipoBancoDiscoDataAccess.save(this.tipobancodisco, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipobancodisco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoBancoDiscoLogicAdditional.checkTipoBancoDiscoToSaveAfter(this.tipobancodisco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoBancoDisco();
			
			connexion.commit();			
			
			if(this.tipobancodisco.getIsDeleted()) {
				this.tipobancodisco=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoBancoDisco()throws Exception {	
		try {	
			
			//TipoBancoDiscoLogicAdditional.checkTipoBancoDiscoToSave(this.tipobancodisco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoBancoDiscoLogicAdditional.updateTipoBancoDiscoToSave(this.tipobancodisco,this.arrDatoGeneral);
			
			TipoBancoDiscoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipobancodisco,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoBancoDisco(this.tipobancodisco)) {			
				TipoBancoDiscoDataAccess.save(this.tipobancodisco, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipobancodisco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoBancoDiscoLogicAdditional.checkTipoBancoDiscoToSaveAfter(this.tipobancodisco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipobancodisco.getIsDeleted()) {
				this.tipobancodisco=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoBancoDiscosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoDisco.class.getSimpleName()+"-saveTipoBancoDiscosWithConnection");connexion.begin();			
			
			//TipoBancoDiscoLogicAdditional.checkTipoBancoDiscoToSaves(tipobancodiscos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoBancoDiscos();
			
			Boolean validadoTodosTipoBancoDisco=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoBancoDisco tipobancodiscoLocal:tipobancodiscos) {		
				if(tipobancodiscoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoBancoDiscoLogicAdditional.updateTipoBancoDiscoToSave(tipobancodiscoLocal,this.arrDatoGeneral);
	        	
				TipoBancoDiscoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipobancodiscoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoBancoDisco(tipobancodiscoLocal)) {
					TipoBancoDiscoDataAccess.save(tipobancodiscoLocal, connexion);				
				} else {
					validadoTodosTipoBancoDisco=false;
				}
			}
			
			if(!validadoTodosTipoBancoDisco) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoBancoDiscoLogicAdditional.checkTipoBancoDiscoToSavesAfter(tipobancodiscos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoBancoDiscos();
			
			connexion.commit();		
			
			this.quitarTipoBancoDiscosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoBancoDiscos()throws Exception {				
		 try {	
			//TipoBancoDiscoLogicAdditional.checkTipoBancoDiscoToSaves(tipobancodiscos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoBancoDisco=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoBancoDisco tipobancodiscoLocal:tipobancodiscos) {				
				if(tipobancodiscoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoBancoDiscoLogicAdditional.updateTipoBancoDiscoToSave(tipobancodiscoLocal,this.arrDatoGeneral);
	        	
				TipoBancoDiscoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipobancodiscoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoBancoDisco(tipobancodiscoLocal)) {				
					TipoBancoDiscoDataAccess.save(tipobancodiscoLocal, connexion);				
				} else {
					validadoTodosTipoBancoDisco=false;
				}
			}
			
			if(!validadoTodosTipoBancoDisco) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoBancoDiscoLogicAdditional.checkTipoBancoDiscoToSavesAfter(tipobancodiscos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoBancoDiscosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoBancoDiscoParameterReturnGeneral procesarAccionTipoBancoDiscos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoBancoDisco> tipobancodiscos,TipoBancoDiscoParameterReturnGeneral tipobancodiscoParameterGeneral)throws Exception {
		 try {	
			TipoBancoDiscoParameterReturnGeneral tipobancodiscoReturnGeneral=new TipoBancoDiscoParameterReturnGeneral();
	
			
			return tipobancodiscoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoBancoDiscoParameterReturnGeneral procesarAccionTipoBancoDiscosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoBancoDisco> tipobancodiscos,TipoBancoDiscoParameterReturnGeneral tipobancodiscoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoDisco.class.getSimpleName()+"-procesarAccionTipoBancoDiscosWithConnection");connexion.begin();			
			
			TipoBancoDiscoParameterReturnGeneral tipobancodiscoReturnGeneral=new TipoBancoDiscoParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipobancodiscoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoBancoDiscoParameterReturnGeneral procesarEventosTipoBancoDiscos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoBancoDisco> tipobancodiscos,TipoBancoDisco tipobancodisco,TipoBancoDiscoParameterReturnGeneral tipobancodiscoParameterGeneral,Boolean isEsNuevoTipoBancoDisco,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoBancoDiscoParameterReturnGeneral tipobancodiscoReturnGeneral=new TipoBancoDiscoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipobancodiscoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipobancodiscoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoBancoDiscoParameterReturnGeneral procesarEventosTipoBancoDiscosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoBancoDisco> tipobancodiscos,TipoBancoDisco tipobancodisco,TipoBancoDiscoParameterReturnGeneral tipobancodiscoParameterGeneral,Boolean isEsNuevoTipoBancoDisco,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoDisco.class.getSimpleName()+"-procesarEventosTipoBancoDiscosWithConnection");connexion.begin();			
			
			TipoBancoDiscoParameterReturnGeneral tipobancodiscoReturnGeneral=new TipoBancoDiscoParameterReturnGeneral();
	
			tipobancodiscoReturnGeneral.setTipoBancoDisco(tipobancodisco);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipobancodiscoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipobancodiscoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoBancoDiscoParameterReturnGeneral procesarImportacionTipoBancoDiscosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoBancoDiscoParameterReturnGeneral tipobancodiscoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoDisco.class.getSimpleName()+"-procesarImportacionTipoBancoDiscosWithConnection");connexion.begin();			
			
			TipoBancoDiscoParameterReturnGeneral tipobancodiscoReturnGeneral=new TipoBancoDiscoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipobancodiscos=new ArrayList<TipoBancoDisco>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipobancodisco=new TipoBancoDisco();
				
				
				if(conColumnasBase) {this.tipobancodisco.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipobancodisco.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipobancodisco.setcodigo(arrColumnas[iColumn++]);
				this.tipobancodisco.setnombre(arrColumnas[iColumn++]);
				
				this.tipobancodiscos.add(this.tipobancodisco);
			}
			
			this.saveTipoBancoDiscos();
			
			this.connexion.commit();
			
			tipobancodiscoReturnGeneral.setConRetornoEstaProcesado(true);
			tipobancodiscoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipobancodiscoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoBancoDiscosEliminados() throws Exception {				
		
		List<TipoBancoDisco> tipobancodiscosAux= new ArrayList<TipoBancoDisco>();
		
		for(TipoBancoDisco tipobancodisco:tipobancodiscos) {
			if(!tipobancodisco.getIsDeleted()) {
				tipobancodiscosAux.add(tipobancodisco);
			}
		}
		
		tipobancodiscos=tipobancodiscosAux;
	}
	
	public void quitarTipoBancoDiscosNulos() throws Exception {				
		
		List<TipoBancoDisco> tipobancodiscosAux= new ArrayList<TipoBancoDisco>();
		
		for(TipoBancoDisco tipobancodisco : this.tipobancodiscos) {
			if(tipobancodisco==null) {
				tipobancodiscosAux.add(tipobancodisco);
			}
		}
		
		//this.tipobancodiscos=tipobancodiscosAux;
		
		this.tipobancodiscos.removeAll(tipobancodiscosAux);
	}
	
	public void getSetVersionRowTipoBancoDiscoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipobancodisco.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipobancodisco.getIsDeleted() || (tipobancodisco.getIsChanged()&&!tipobancodisco.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipobancodiscoDataAccess.getSetVersionRowTipoBancoDisco(connexion,tipobancodisco.getId());
				
				if(!tipobancodisco.getVersionRow().equals(timestamp)) {	
					tipobancodisco.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipobancodisco.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoBancoDisco()throws Exception {	
		
		if(tipobancodisco.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipobancodisco.getIsDeleted() || (tipobancodisco.getIsChanged()&&!tipobancodisco.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipobancodiscoDataAccess.getSetVersionRowTipoBancoDisco(connexion,tipobancodisco.getId());
			
			try {							
				if(!tipobancodisco.getVersionRow().equals(timestamp)) {	
					tipobancodisco.setVersionRow(timestamp);
				}
				
				tipobancodisco.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoBancoDiscosWithConnection()throws Exception {	
		if(tipobancodiscos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoBancoDisco tipobancodiscoAux:tipobancodiscos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipobancodiscoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipobancodiscoAux.getIsDeleted() || (tipobancodiscoAux.getIsChanged()&&!tipobancodiscoAux.getIsNew())) {
						
						timestamp=tipobancodiscoDataAccess.getSetVersionRowTipoBancoDisco(connexion,tipobancodiscoAux.getId());
						
						if(!tipobancodisco.getVersionRow().equals(timestamp)) {	
							tipobancodiscoAux.setVersionRow(timestamp);
						}
								
						tipobancodiscoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoBancoDiscos()throws Exception {	
		if(tipobancodiscos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoBancoDisco tipobancodiscoAux:tipobancodiscos) {
					if(tipobancodiscoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipobancodiscoAux.getIsDeleted() || (tipobancodiscoAux.getIsChanged()&&!tipobancodiscoAux.getIsNew())) {
						
						timestamp=tipobancodiscoDataAccess.getSetVersionRowTipoBancoDisco(connexion,tipobancodiscoAux.getId());
						
						if(!tipobancodiscoAux.getVersionRow().equals(timestamp)) {	
							tipobancodiscoAux.setVersionRow(timestamp);
						}
						
													
						tipobancodiscoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	
	public void deepLoad(TipoBancoDisco tipobancodisco,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		
		
		try {
			//TipoBancoDiscoLogicAdditional.updateTipoBancoDiscoToGet(tipobancodisco,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoBancoDisco tipobancodisco,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
				
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoBancoDisco.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipobancodisco,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoBancoDiscoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoDisco(tipobancodisco);
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
			this.deepLoad(this.tipobancodisco,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoBancoDiscoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoDisco(this.tipobancodisco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoBancoDisco.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipobancodiscos!=null) {
				for(TipoBancoDisco tipobancodisco:tipobancodiscos) {
					this.deepLoad(tipobancodisco,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoBancoDiscoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoDisco(tipobancodiscos);
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
			if(tipobancodiscos!=null) {
				for(TipoBancoDisco tipobancodisco:tipobancodiscos) {
					this.deepLoad(tipobancodisco,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoBancoDiscoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoDisco(tipobancodiscos);
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
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoBancoDiscoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoBancoDiscoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoBancoDisco tipobancodisco,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoBancoDiscoConstantesFunciones.ISCONAUDITORIA) {
				if(tipobancodisco.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoBancoDiscoDataAccess.TABLENAME, tipobancodisco.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoBancoDiscoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoBancoDiscoLogic.registrarAuditoriaDetallesTipoBancoDisco(connexion,tipobancodisco,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipobancodisco.getIsDeleted()) {
					/*if(!tipobancodisco.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoBancoDiscoDataAccess.TABLENAME, tipobancodisco.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoBancoDiscoLogic.registrarAuditoriaDetallesTipoBancoDisco(connexion,tipobancodisco,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoBancoDiscoDataAccess.TABLENAME, tipobancodisco.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipobancodisco.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoBancoDiscoDataAccess.TABLENAME, tipobancodisco.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoBancoDiscoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoBancoDiscoLogic.registrarAuditoriaDetallesTipoBancoDisco(connexion,tipobancodisco,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoBancoDisco(Connexion connexion,TipoBancoDisco tipobancodisco)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipobancodisco.getIsNew()||!tipobancodisco.getcodigo().equals(tipobancodisco.getTipoBancoDiscoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipobancodisco.getTipoBancoDiscoOriginal().getcodigo()!=null)
				{
					strValorActual=tipobancodisco.getTipoBancoDiscoOriginal().getcodigo();
				}
				if(tipobancodisco.getcodigo()!=null)
				{
					strValorNuevo=tipobancodisco.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoBancoDiscoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipobancodisco.getIsNew()||!tipobancodisco.getnombre().equals(tipobancodisco.getTipoBancoDiscoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipobancodisco.getTipoBancoDiscoOriginal().getnombre()!=null)
				{
					strValorActual=tipobancodisco.getTipoBancoDiscoOriginal().getnombre();
				}
				if(tipobancodisco.getnombre()!=null)
				{
					strValorNuevo=tipobancodisco.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoBancoDiscoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoBancoDisco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoBancoDiscoConstantesFunciones.getClassesForeignKeysOfTipoBancoDisco(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoBancoDisco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoBancoDiscoConstantesFunciones.getClassesRelationshipsOfTipoBancoDisco(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}
