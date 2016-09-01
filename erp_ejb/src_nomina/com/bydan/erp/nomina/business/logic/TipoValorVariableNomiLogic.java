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
import com.bydan.erp.nomina.util.TipoValorVariableNomiConstantesFunciones;
import com.bydan.erp.nomina.util.TipoValorVariableNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoValorVariableNomiParameterGeneral;
import com.bydan.erp.nomina.business.entity.TipoValorVariableNomi;
import com.bydan.erp.nomina.business.logic.TipoValorVariableNomiLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class TipoValorVariableNomiLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoValorVariableNomiLogic.class);
	
	protected TipoValorVariableNomiDataAccess tipovalorvariablenomiDataAccess; 	
	protected TipoValorVariableNomi tipovalorvariablenomi;
	protected List<TipoValorVariableNomi> tipovalorvariablenomis;
	protected Object tipovalorvariablenomiObject;	
	protected List<Object> tipovalorvariablenomisObject;
	
	public static ClassValidator<TipoValorVariableNomi> tipovalorvariablenomiValidator = new ClassValidator<TipoValorVariableNomi>(TipoValorVariableNomi.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoValorVariableNomiLogicAdditional tipovalorvariablenomiLogicAdditional=null;
	
	public TipoValorVariableNomiLogicAdditional getTipoValorVariableNomiLogicAdditional() {
		return this.tipovalorvariablenomiLogicAdditional;
	}
	
	public void setTipoValorVariableNomiLogicAdditional(TipoValorVariableNomiLogicAdditional tipovalorvariablenomiLogicAdditional) {
		try {
			this.tipovalorvariablenomiLogicAdditional=tipovalorvariablenomiLogicAdditional;
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
	
	
	
	
	public  TipoValorVariableNomiLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipovalorvariablenomiDataAccess = new TipoValorVariableNomiDataAccess();
			
			this.tipovalorvariablenomis= new ArrayList<TipoValorVariableNomi>();
			this.tipovalorvariablenomi= new TipoValorVariableNomi();
			
			this.tipovalorvariablenomiObject=new Object();
			this.tipovalorvariablenomisObject=new ArrayList<Object>();
				
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
			
			this.tipovalorvariablenomiDataAccess.setConnexionType(this.connexionType);
			this.tipovalorvariablenomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoValorVariableNomiLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipovalorvariablenomiDataAccess = new TipoValorVariableNomiDataAccess();
			this.tipovalorvariablenomis= new ArrayList<TipoValorVariableNomi>();
			this.tipovalorvariablenomi= new TipoValorVariableNomi();
			this.tipovalorvariablenomiObject=new Object();
			this.tipovalorvariablenomisObject=new ArrayList<Object>();
			
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
			
			this.tipovalorvariablenomiDataAccess.setConnexionType(this.connexionType);
			this.tipovalorvariablenomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoValorVariableNomi getTipoValorVariableNomi() throws Exception {	
		TipoValorVariableNomiLogicAdditional.checkTipoValorVariableNomiToGet(tipovalorvariablenomi,this.datosCliente,this.arrDatoGeneral);
		TipoValorVariableNomiLogicAdditional.updateTipoValorVariableNomiToGet(tipovalorvariablenomi,this.arrDatoGeneral);
		
		return tipovalorvariablenomi;
	}
		
	public void setTipoValorVariableNomi(TipoValorVariableNomi newTipoValorVariableNomi) {
		this.tipovalorvariablenomi = newTipoValorVariableNomi;
	}
	
	public TipoValorVariableNomiDataAccess getTipoValorVariableNomiDataAccess() {
		return tipovalorvariablenomiDataAccess;
	}
	
	public void setTipoValorVariableNomiDataAccess(TipoValorVariableNomiDataAccess newtipovalorvariablenomiDataAccess) {
		this.tipovalorvariablenomiDataAccess = newtipovalorvariablenomiDataAccess;
	}
	
	public List<TipoValorVariableNomi> getTipoValorVariableNomis() throws Exception {		
		this.quitarTipoValorVariableNomisNulos();
		
		TipoValorVariableNomiLogicAdditional.checkTipoValorVariableNomiToGets(tipovalorvariablenomis,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoValorVariableNomi tipovalorvariablenomiLocal: tipovalorvariablenomis ) {
			TipoValorVariableNomiLogicAdditional.updateTipoValorVariableNomiToGet(tipovalorvariablenomiLocal,this.arrDatoGeneral);
		}
		
		return tipovalorvariablenomis;
	}
	
	public void setTipoValorVariableNomis(List<TipoValorVariableNomi> newTipoValorVariableNomis) {
		this.tipovalorvariablenomis = newTipoValorVariableNomis;
	}
	
	public Object getTipoValorVariableNomiObject() {	
		this.tipovalorvariablenomiObject=this.tipovalorvariablenomiDataAccess.getEntityObject();
		return this.tipovalorvariablenomiObject;
	}
		
	public void setTipoValorVariableNomiObject(Object newTipoValorVariableNomiObject) {
		this.tipovalorvariablenomiObject = newTipoValorVariableNomiObject;
	}
	
	public List<Object> getTipoValorVariableNomisObject() {		
		this.tipovalorvariablenomisObject=this.tipovalorvariablenomiDataAccess.getEntitiesObject();
		return this.tipovalorvariablenomisObject;
	}
		
	public void setTipoValorVariableNomisObject(List<Object> newTipoValorVariableNomisObject) {
		this.tipovalorvariablenomisObject = newTipoValorVariableNomisObject;
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
		
		if(this.tipovalorvariablenomiDataAccess!=null) {
			this.tipovalorvariablenomiDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValorVariableNomi.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipovalorvariablenomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipovalorvariablenomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipovalorvariablenomi = new  TipoValorVariableNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValorVariableNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipovalorvariablenomi=tipovalorvariablenomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipovalorvariablenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoValorVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoValorVariableNomi(this.tipovalorvariablenomi);
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
		tipovalorvariablenomi = new  TipoValorVariableNomi();
		  		  
        try {
			
			tipovalorvariablenomi=tipovalorvariablenomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipovalorvariablenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoValorVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoValorVariableNomi(this.tipovalorvariablenomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipovalorvariablenomi = new  TipoValorVariableNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValorVariableNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipovalorvariablenomi=tipovalorvariablenomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipovalorvariablenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoValorVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoValorVariableNomi(this.tipovalorvariablenomi);
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
		tipovalorvariablenomi = new  TipoValorVariableNomi();
		  		  
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
		tipovalorvariablenomi = new  TipoValorVariableNomi();
		  		  
        try {
			
			tipovalorvariablenomi=tipovalorvariablenomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipovalorvariablenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoValorVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoValorVariableNomi(this.tipovalorvariablenomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipovalorvariablenomi = new  TipoValorVariableNomi();
		  		  
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
		tipovalorvariablenomi = new  TipoValorVariableNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValorVariableNomi.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipovalorvariablenomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipovalorvariablenomi = new  TipoValorVariableNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipovalorvariablenomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipovalorvariablenomi = new  TipoValorVariableNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValorVariableNomi.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipovalorvariablenomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipovalorvariablenomi = new  TipoValorVariableNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipovalorvariablenomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipovalorvariablenomi = new  TipoValorVariableNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValorVariableNomi.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipovalorvariablenomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipovalorvariablenomi = new  TipoValorVariableNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipovalorvariablenomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipovalorvariablenomis = new  ArrayList<TipoValorVariableNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValorVariableNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoValorVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovalorvariablenomis=tipovalorvariablenomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoValorVariableNomi(tipovalorvariablenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoValorVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoValorVariableNomi(this.tipovalorvariablenomis);
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
		tipovalorvariablenomis = new  ArrayList<TipoValorVariableNomi>();
		  		  
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
		tipovalorvariablenomis = new  ArrayList<TipoValorVariableNomi>();
		  		  
        try {			
			TipoValorVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovalorvariablenomis=tipovalorvariablenomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoValorVariableNomi(tipovalorvariablenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoValorVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoValorVariableNomi(this.tipovalorvariablenomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipovalorvariablenomis = new  ArrayList<TipoValorVariableNomi>();
		  		  
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
		tipovalorvariablenomis = new  ArrayList<TipoValorVariableNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValorVariableNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoValorVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovalorvariablenomis=tipovalorvariablenomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoValorVariableNomi(tipovalorvariablenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoValorVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoValorVariableNomi(this.tipovalorvariablenomis);
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
		tipovalorvariablenomis = new  ArrayList<TipoValorVariableNomi>();
		  		  
        try {
			TipoValorVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovalorvariablenomis=tipovalorvariablenomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoValorVariableNomi(tipovalorvariablenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoValorVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoValorVariableNomi(this.tipovalorvariablenomis);
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
		tipovalorvariablenomis = new  ArrayList<TipoValorVariableNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValorVariableNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoValorVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovalorvariablenomis=tipovalorvariablenomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoValorVariableNomi(tipovalorvariablenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoValorVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoValorVariableNomi(this.tipovalorvariablenomis);
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
		tipovalorvariablenomis = new  ArrayList<TipoValorVariableNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoValorVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovalorvariablenomis=tipovalorvariablenomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoValorVariableNomi(tipovalorvariablenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoValorVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoValorVariableNomi(this.tipovalorvariablenomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipovalorvariablenomi = new  TipoValorVariableNomi();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValorVariableNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoValorVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovalorvariablenomi=tipovalorvariablenomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoValorVariableNomi(tipovalorvariablenomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoValorVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoValorVariableNomi(this.tipovalorvariablenomi);
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
		tipovalorvariablenomi = new  TipoValorVariableNomi();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoValorVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovalorvariablenomi=tipovalorvariablenomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoValorVariableNomi(tipovalorvariablenomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoValorVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoValorVariableNomi(this.tipovalorvariablenomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipovalorvariablenomis = new  ArrayList<TipoValorVariableNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValorVariableNomi.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoValorVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovalorvariablenomis=tipovalorvariablenomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoValorVariableNomi(tipovalorvariablenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoValorVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoValorVariableNomi(this.tipovalorvariablenomis);
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
		tipovalorvariablenomis = new  ArrayList<TipoValorVariableNomi>();
		  		  
        try {
			TipoValorVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovalorvariablenomis=tipovalorvariablenomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoValorVariableNomi(tipovalorvariablenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoValorVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoValorVariableNomi(this.tipovalorvariablenomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoValorVariableNomisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipovalorvariablenomis = new  ArrayList<TipoValorVariableNomi>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValorVariableNomi.class.getSimpleName()+"-getTodosTipoValorVariableNomisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoValorVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovalorvariablenomis=tipovalorvariablenomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoValorVariableNomi(tipovalorvariablenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoValorVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoValorVariableNomi(this.tipovalorvariablenomis);
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
	
	public  void  getTodosTipoValorVariableNomis(String sFinalQuery,Pagination pagination)throws Exception {
		tipovalorvariablenomis = new  ArrayList<TipoValorVariableNomi>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoValorVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovalorvariablenomis=tipovalorvariablenomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoValorVariableNomi(tipovalorvariablenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoValorVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoValorVariableNomi(this.tipovalorvariablenomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoValorVariableNomi(TipoValorVariableNomi tipovalorvariablenomi) throws Exception {
		Boolean estaValidado=false;
		
		if(tipovalorvariablenomi.getIsNew() || tipovalorvariablenomi.getIsChanged()) { 
			this.invalidValues = tipovalorvariablenomiValidator.getInvalidValues(tipovalorvariablenomi);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipovalorvariablenomi);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoValorVariableNomi(List<TipoValorVariableNomi> TipoValorVariableNomis) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoValorVariableNomi tipovalorvariablenomiLocal:tipovalorvariablenomis) {				
			estaValidadoObjeto=this.validarGuardarTipoValorVariableNomi(tipovalorvariablenomiLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoValorVariableNomi(List<TipoValorVariableNomi> TipoValorVariableNomis) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoValorVariableNomi(tipovalorvariablenomis)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoValorVariableNomi(TipoValorVariableNomi TipoValorVariableNomi) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoValorVariableNomi(tipovalorvariablenomi)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoValorVariableNomi tipovalorvariablenomi) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipovalorvariablenomi.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoValorVariableNomiConstantesFunciones.getTipoValorVariableNomiLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipovalorvariablenomi","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoValorVariableNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoValorVariableNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoValorVariableNomiWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValorVariableNomi.class.getSimpleName()+"-saveTipoValorVariableNomiWithConnection");connexion.begin();			
			
			TipoValorVariableNomiLogicAdditional.checkTipoValorVariableNomiToSave(this.tipovalorvariablenomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoValorVariableNomiLogicAdditional.updateTipoValorVariableNomiToSave(this.tipovalorvariablenomi,this.arrDatoGeneral);
			
			TipoValorVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipovalorvariablenomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoValorVariableNomi();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoValorVariableNomi(this.tipovalorvariablenomi)) {
				TipoValorVariableNomiDataAccess.save(this.tipovalorvariablenomi, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipovalorvariablenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoValorVariableNomiLogicAdditional.checkTipoValorVariableNomiToSaveAfter(this.tipovalorvariablenomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoValorVariableNomi();
			
			connexion.commit();			
			
			if(this.tipovalorvariablenomi.getIsDeleted()) {
				this.tipovalorvariablenomi=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoValorVariableNomi()throws Exception {	
		try {	
			
			TipoValorVariableNomiLogicAdditional.checkTipoValorVariableNomiToSave(this.tipovalorvariablenomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoValorVariableNomiLogicAdditional.updateTipoValorVariableNomiToSave(this.tipovalorvariablenomi,this.arrDatoGeneral);
			
			TipoValorVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipovalorvariablenomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoValorVariableNomi(this.tipovalorvariablenomi)) {			
				TipoValorVariableNomiDataAccess.save(this.tipovalorvariablenomi, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipovalorvariablenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoValorVariableNomiLogicAdditional.checkTipoValorVariableNomiToSaveAfter(this.tipovalorvariablenomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipovalorvariablenomi.getIsDeleted()) {
				this.tipovalorvariablenomi=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoValorVariableNomisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValorVariableNomi.class.getSimpleName()+"-saveTipoValorVariableNomisWithConnection");connexion.begin();			
			
			TipoValorVariableNomiLogicAdditional.checkTipoValorVariableNomiToSaves(tipovalorvariablenomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoValorVariableNomis();
			
			Boolean validadoTodosTipoValorVariableNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoValorVariableNomi tipovalorvariablenomiLocal:tipovalorvariablenomis) {		
				if(tipovalorvariablenomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoValorVariableNomiLogicAdditional.updateTipoValorVariableNomiToSave(tipovalorvariablenomiLocal,this.arrDatoGeneral);
	        	
				TipoValorVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipovalorvariablenomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoValorVariableNomi(tipovalorvariablenomiLocal)) {
					TipoValorVariableNomiDataAccess.save(tipovalorvariablenomiLocal, connexion);				
				} else {
					validadoTodosTipoValorVariableNomi=false;
				}
			}
			
			if(!validadoTodosTipoValorVariableNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoValorVariableNomiLogicAdditional.checkTipoValorVariableNomiToSavesAfter(tipovalorvariablenomis,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoValorVariableNomis();
			
			connexion.commit();		
			
			this.quitarTipoValorVariableNomisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoValorVariableNomis()throws Exception {				
		 try {	
			TipoValorVariableNomiLogicAdditional.checkTipoValorVariableNomiToSaves(tipovalorvariablenomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoValorVariableNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoValorVariableNomi tipovalorvariablenomiLocal:tipovalorvariablenomis) {				
				if(tipovalorvariablenomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoValorVariableNomiLogicAdditional.updateTipoValorVariableNomiToSave(tipovalorvariablenomiLocal,this.arrDatoGeneral);
	        	
				TipoValorVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipovalorvariablenomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoValorVariableNomi(tipovalorvariablenomiLocal)) {				
					TipoValorVariableNomiDataAccess.save(tipovalorvariablenomiLocal, connexion);				
				} else {
					validadoTodosTipoValorVariableNomi=false;
				}
			}
			
			if(!validadoTodosTipoValorVariableNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoValorVariableNomiLogicAdditional.checkTipoValorVariableNomiToSavesAfter(tipovalorvariablenomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoValorVariableNomisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoValorVariableNomiParameterReturnGeneral procesarAccionTipoValorVariableNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoValorVariableNomi> tipovalorvariablenomis,TipoValorVariableNomiParameterReturnGeneral tipovalorvariablenomiParameterGeneral)throws Exception {
		 try {	
			TipoValorVariableNomiParameterReturnGeneral tipovalorvariablenomiReturnGeneral=new TipoValorVariableNomiParameterReturnGeneral();
	
			TipoValorVariableNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipovalorvariablenomis,tipovalorvariablenomiParameterGeneral,tipovalorvariablenomiReturnGeneral);
			
			return tipovalorvariablenomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoValorVariableNomiParameterReturnGeneral procesarAccionTipoValorVariableNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoValorVariableNomi> tipovalorvariablenomis,TipoValorVariableNomiParameterReturnGeneral tipovalorvariablenomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValorVariableNomi.class.getSimpleName()+"-procesarAccionTipoValorVariableNomisWithConnection");connexion.begin();			
			
			TipoValorVariableNomiParameterReturnGeneral tipovalorvariablenomiReturnGeneral=new TipoValorVariableNomiParameterReturnGeneral();
	
			TipoValorVariableNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipovalorvariablenomis,tipovalorvariablenomiParameterGeneral,tipovalorvariablenomiReturnGeneral);
			
			this.connexion.commit();
			
			return tipovalorvariablenomiReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoValorVariableNomiParameterReturnGeneral procesarEventosTipoValorVariableNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoValorVariableNomi> tipovalorvariablenomis,TipoValorVariableNomi tipovalorvariablenomi,TipoValorVariableNomiParameterReturnGeneral tipovalorvariablenomiParameterGeneral,Boolean isEsNuevoTipoValorVariableNomi,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoValorVariableNomiParameterReturnGeneral tipovalorvariablenomiReturnGeneral=new TipoValorVariableNomiParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipovalorvariablenomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoValorVariableNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipovalorvariablenomis,tipovalorvariablenomi,tipovalorvariablenomiParameterGeneral,tipovalorvariablenomiReturnGeneral,isEsNuevoTipoValorVariableNomi,clases);
			
			return tipovalorvariablenomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoValorVariableNomiParameterReturnGeneral procesarEventosTipoValorVariableNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoValorVariableNomi> tipovalorvariablenomis,TipoValorVariableNomi tipovalorvariablenomi,TipoValorVariableNomiParameterReturnGeneral tipovalorvariablenomiParameterGeneral,Boolean isEsNuevoTipoValorVariableNomi,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValorVariableNomi.class.getSimpleName()+"-procesarEventosTipoValorVariableNomisWithConnection");connexion.begin();			
			
			TipoValorVariableNomiParameterReturnGeneral tipovalorvariablenomiReturnGeneral=new TipoValorVariableNomiParameterReturnGeneral();
	
			tipovalorvariablenomiReturnGeneral.setTipoValorVariableNomi(tipovalorvariablenomi);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipovalorvariablenomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoValorVariableNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipovalorvariablenomis,tipovalorvariablenomi,tipovalorvariablenomiParameterGeneral,tipovalorvariablenomiReturnGeneral,isEsNuevoTipoValorVariableNomi,clases);
			
			this.connexion.commit();
			
			return tipovalorvariablenomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoValorVariableNomiParameterReturnGeneral procesarImportacionTipoValorVariableNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoValorVariableNomiParameterReturnGeneral tipovalorvariablenomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValorVariableNomi.class.getSimpleName()+"-procesarImportacionTipoValorVariableNomisWithConnection");connexion.begin();			
			
			TipoValorVariableNomiParameterReturnGeneral tipovalorvariablenomiReturnGeneral=new TipoValorVariableNomiParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipovalorvariablenomis=new ArrayList<TipoValorVariableNomi>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipovalorvariablenomi=new TipoValorVariableNomi();
				
				
				if(conColumnasBase) {this.tipovalorvariablenomi.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipovalorvariablenomi.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipovalorvariablenomi.setcodigo(arrColumnas[iColumn++]);
				this.tipovalorvariablenomi.setnombre(arrColumnas[iColumn++]);
				
				this.tipovalorvariablenomis.add(this.tipovalorvariablenomi);
			}
			
			this.saveTipoValorVariableNomis();
			
			this.connexion.commit();
			
			tipovalorvariablenomiReturnGeneral.setConRetornoEstaProcesado(true);
			tipovalorvariablenomiReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipovalorvariablenomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoValorVariableNomisEliminados() throws Exception {				
		
		List<TipoValorVariableNomi> tipovalorvariablenomisAux= new ArrayList<TipoValorVariableNomi>();
		
		for(TipoValorVariableNomi tipovalorvariablenomi:tipovalorvariablenomis) {
			if(!tipovalorvariablenomi.getIsDeleted()) {
				tipovalorvariablenomisAux.add(tipovalorvariablenomi);
			}
		}
		
		tipovalorvariablenomis=tipovalorvariablenomisAux;
	}
	
	public void quitarTipoValorVariableNomisNulos() throws Exception {				
		
		List<TipoValorVariableNomi> tipovalorvariablenomisAux= new ArrayList<TipoValorVariableNomi>();
		
		for(TipoValorVariableNomi tipovalorvariablenomi : this.tipovalorvariablenomis) {
			if(tipovalorvariablenomi==null) {
				tipovalorvariablenomisAux.add(tipovalorvariablenomi);
			}
		}
		
		//this.tipovalorvariablenomis=tipovalorvariablenomisAux;
		
		this.tipovalorvariablenomis.removeAll(tipovalorvariablenomisAux);
	}
	
	public void getSetVersionRowTipoValorVariableNomiWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipovalorvariablenomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipovalorvariablenomi.getIsDeleted() || (tipovalorvariablenomi.getIsChanged()&&!tipovalorvariablenomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipovalorvariablenomiDataAccess.getSetVersionRowTipoValorVariableNomi(connexion,tipovalorvariablenomi.getId());
				
				if(!tipovalorvariablenomi.getVersionRow().equals(timestamp)) {	
					tipovalorvariablenomi.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipovalorvariablenomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoValorVariableNomi()throws Exception {	
		
		if(tipovalorvariablenomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipovalorvariablenomi.getIsDeleted() || (tipovalorvariablenomi.getIsChanged()&&!tipovalorvariablenomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipovalorvariablenomiDataAccess.getSetVersionRowTipoValorVariableNomi(connexion,tipovalorvariablenomi.getId());
			
			try {							
				if(!tipovalorvariablenomi.getVersionRow().equals(timestamp)) {	
					tipovalorvariablenomi.setVersionRow(timestamp);
				}
				
				tipovalorvariablenomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoValorVariableNomisWithConnection()throws Exception {	
		if(tipovalorvariablenomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoValorVariableNomi tipovalorvariablenomiAux:tipovalorvariablenomis) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipovalorvariablenomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipovalorvariablenomiAux.getIsDeleted() || (tipovalorvariablenomiAux.getIsChanged()&&!tipovalorvariablenomiAux.getIsNew())) {
						
						timestamp=tipovalorvariablenomiDataAccess.getSetVersionRowTipoValorVariableNomi(connexion,tipovalorvariablenomiAux.getId());
						
						if(!tipovalorvariablenomi.getVersionRow().equals(timestamp)) {	
							tipovalorvariablenomiAux.setVersionRow(timestamp);
						}
								
						tipovalorvariablenomiAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoValorVariableNomis()throws Exception {	
		if(tipovalorvariablenomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoValorVariableNomi tipovalorvariablenomiAux:tipovalorvariablenomis) {
					if(tipovalorvariablenomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipovalorvariablenomiAux.getIsDeleted() || (tipovalorvariablenomiAux.getIsChanged()&&!tipovalorvariablenomiAux.getIsNew())) {
						
						timestamp=tipovalorvariablenomiDataAccess.getSetVersionRowTipoValorVariableNomi(connexion,tipovalorvariablenomiAux.getId());
						
						if(!tipovalorvariablenomiAux.getVersionRow().equals(timestamp)) {	
							tipovalorvariablenomiAux.setVersionRow(timestamp);
						}
						
													
						tipovalorvariablenomiAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoValorVariableNomiWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			VariableNomiLogic variablenomiLogic=new VariableNomiLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoValorVariableNomi.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoValorVariableNomiWithConnection");connexion.begin();
			
			
			classes.add(new Classe(VariableNomi.class));
											
			

			variablenomiLogic.setConnexion(this.getConnexion());
			variablenomiLogic.setDatosCliente(this.datosCliente);
			variablenomiLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoValorVariableNomi tipovalorvariablenomi:this.tipovalorvariablenomis) {
				

				classes=new ArrayList<Classe>();
				classes=VariableNomiConstantesFunciones.getClassesForeignKeysOfVariableNomi(new ArrayList<Classe>(),DeepLoadType.NONE);

				variablenomiLogic.setVariableNomis(tipovalorvariablenomi.variablenomis);
				variablenomiLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoValorVariableNomi tipovalorvariablenomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoValorVariableNomiLogicAdditional.updateTipoValorVariableNomiToGet(tipovalorvariablenomi,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipovalorvariablenomi.setVariableNomis(tipovalorvariablenomiDataAccess.getVariableNomis(connexion,tipovalorvariablenomi));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(VariableNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipovalorvariablenomi.setVariableNomis(tipovalorvariablenomiDataAccess.getVariableNomis(connexion,tipovalorvariablenomi));

				if(this.isConDeep) {
					VariableNomiLogic variablenomiLogic= new VariableNomiLogic(this.connexion);
					variablenomiLogic.setVariableNomis(tipovalorvariablenomi.getVariableNomis());
					ArrayList<Classe> classesLocal=VariableNomiConstantesFunciones.getClassesForeignKeysOfVariableNomi(new ArrayList<Classe>(),DeepLoadType.NONE);
					variablenomiLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					VariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesVariableNomi(variablenomiLogic.getVariableNomis());
					tipovalorvariablenomi.setVariableNomis(variablenomiLogic.getVariableNomis());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(VariableNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(VariableNomi.class));
			tipovalorvariablenomi.setVariableNomis(tipovalorvariablenomiDataAccess.getVariableNomis(connexion,tipovalorvariablenomi));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tipovalorvariablenomi.setVariableNomis(tipovalorvariablenomiDataAccess.getVariableNomis(connexion,tipovalorvariablenomi));

		for(VariableNomi variablenomi:tipovalorvariablenomi.getVariableNomis()) {
			VariableNomiLogic variablenomiLogic= new VariableNomiLogic(connexion);
			variablenomiLogic.deepLoad(variablenomi,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(VariableNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipovalorvariablenomi.setVariableNomis(tipovalorvariablenomiDataAccess.getVariableNomis(connexion,tipovalorvariablenomi));

				for(VariableNomi variablenomi:tipovalorvariablenomi.getVariableNomis()) {
					VariableNomiLogic variablenomiLogic= new VariableNomiLogic(connexion);
					variablenomiLogic.deepLoad(variablenomi,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(VariableNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(VariableNomi.class));
			tipovalorvariablenomi.setVariableNomis(tipovalorvariablenomiDataAccess.getVariableNomis(connexion,tipovalorvariablenomi));

			for(VariableNomi variablenomi:tipovalorvariablenomi.getVariableNomis()) {
				VariableNomiLogic variablenomiLogic= new VariableNomiLogic(connexion);
				variablenomiLogic.deepLoad(variablenomi,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoValorVariableNomi tipovalorvariablenomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoValorVariableNomiLogicAdditional.updateTipoValorVariableNomiToSave(tipovalorvariablenomi,this.arrDatoGeneral);
			
TipoValorVariableNomiDataAccess.save(tipovalorvariablenomi, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(VariableNomi variablenomi:tipovalorvariablenomi.getVariableNomis()) {
			variablenomi.setid_tipo_valor_variable_nomi(tipovalorvariablenomi.getId());
			VariableNomiDataAccess.save(variablenomi,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(VariableNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(VariableNomi variablenomi:tipovalorvariablenomi.getVariableNomis()) {
					variablenomi.setid_tipo_valor_variable_nomi(tipovalorvariablenomi.getId());
					VariableNomiDataAccess.save(variablenomi,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(VariableNomi variablenomi:tipovalorvariablenomi.getVariableNomis()) {
			VariableNomiLogic variablenomiLogic= new VariableNomiLogic(connexion);
			variablenomi.setid_tipo_valor_variable_nomi(tipovalorvariablenomi.getId());
			VariableNomiDataAccess.save(variablenomi,connexion);
			variablenomiLogic.deepSave(variablenomi,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(VariableNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(VariableNomi variablenomi:tipovalorvariablenomi.getVariableNomis()) {
					VariableNomiLogic variablenomiLogic= new VariableNomiLogic(connexion);
					variablenomi.setid_tipo_valor_variable_nomi(tipovalorvariablenomi.getId());
					VariableNomiDataAccess.save(variablenomi,connexion);
					variablenomiLogic.deepSave(variablenomi,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoValorVariableNomi.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipovalorvariablenomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoValorVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoValorVariableNomi(tipovalorvariablenomi);
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
			this.deepLoad(this.tipovalorvariablenomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoValorVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoValorVariableNomi(this.tipovalorvariablenomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoValorVariableNomi.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipovalorvariablenomis!=null) {
				for(TipoValorVariableNomi tipovalorvariablenomi:tipovalorvariablenomis) {
					this.deepLoad(tipovalorvariablenomi,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoValorVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoValorVariableNomi(tipovalorvariablenomis);
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
			if(tipovalorvariablenomis!=null) {
				for(TipoValorVariableNomi tipovalorvariablenomi:tipovalorvariablenomis) {
					this.deepLoad(tipovalorvariablenomi,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoValorVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoValorVariableNomi(tipovalorvariablenomis);
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
			this.getNewConnexionToDeep(TipoValorVariableNomi.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipovalorvariablenomi,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoValorVariableNomi.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipovalorvariablenomis!=null) {
				for(TipoValorVariableNomi tipovalorvariablenomi:tipovalorvariablenomis) {
					this.deepSave(tipovalorvariablenomi,isDeep,deepLoadType,clases);
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
			if(tipovalorvariablenomis!=null) {
				for(TipoValorVariableNomi tipovalorvariablenomi:tipovalorvariablenomis) {
					this.deepSave(tipovalorvariablenomi,isDeep,deepLoadType,clases);
				}		
			}
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
			if(TipoValorVariableNomiConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoValorVariableNomiDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoValorVariableNomi tipovalorvariablenomi,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoValorVariableNomiConstantesFunciones.ISCONAUDITORIA) {
				if(tipovalorvariablenomi.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoValorVariableNomiDataAccess.TABLENAME, tipovalorvariablenomi.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoValorVariableNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoValorVariableNomiLogic.registrarAuditoriaDetallesTipoValorVariableNomi(connexion,tipovalorvariablenomi,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipovalorvariablenomi.getIsDeleted()) {
					/*if(!tipovalorvariablenomi.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoValorVariableNomiDataAccess.TABLENAME, tipovalorvariablenomi.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoValorVariableNomiLogic.registrarAuditoriaDetallesTipoValorVariableNomi(connexion,tipovalorvariablenomi,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoValorVariableNomiDataAccess.TABLENAME, tipovalorvariablenomi.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipovalorvariablenomi.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoValorVariableNomiDataAccess.TABLENAME, tipovalorvariablenomi.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoValorVariableNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoValorVariableNomiLogic.registrarAuditoriaDetallesTipoValorVariableNomi(connexion,tipovalorvariablenomi,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoValorVariableNomi(Connexion connexion,TipoValorVariableNomi tipovalorvariablenomi)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipovalorvariablenomi.getIsNew()||!tipovalorvariablenomi.getcodigo().equals(tipovalorvariablenomi.getTipoValorVariableNomiOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipovalorvariablenomi.getTipoValorVariableNomiOriginal().getcodigo()!=null)
				{
					strValorActual=tipovalorvariablenomi.getTipoValorVariableNomiOriginal().getcodigo();
				}
				if(tipovalorvariablenomi.getcodigo()!=null)
				{
					strValorNuevo=tipovalorvariablenomi.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoValorVariableNomiConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipovalorvariablenomi.getIsNew()||!tipovalorvariablenomi.getnombre().equals(tipovalorvariablenomi.getTipoValorVariableNomiOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipovalorvariablenomi.getTipoValorVariableNomiOriginal().getnombre()!=null)
				{
					strValorActual=tipovalorvariablenomi.getTipoValorVariableNomiOriginal().getnombre();
				}
				if(tipovalorvariablenomi.getnombre()!=null)
				{
					strValorNuevo=tipovalorvariablenomi.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoValorVariableNomiConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoValorVariableNomiRelacionesWithConnection(TipoValorVariableNomi tipovalorvariablenomi,List<VariableNomi> variablenomis) throws Exception {

		if(!tipovalorvariablenomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoValorVariableNomiRelacionesBase(tipovalorvariablenomi,variablenomis,true);
		}
	}

	public void saveTipoValorVariableNomiRelaciones(TipoValorVariableNomi tipovalorvariablenomi,List<VariableNomi> variablenomis)throws Exception {

		if(!tipovalorvariablenomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoValorVariableNomiRelacionesBase(tipovalorvariablenomi,variablenomis,false);
		}
	}

	public void saveTipoValorVariableNomiRelacionesBase(TipoValorVariableNomi tipovalorvariablenomi,List<VariableNomi> variablenomis,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoValorVariableNomi-saveRelacionesWithConnection");}
	
			tipovalorvariablenomi.setVariableNomis(variablenomis);

			this.setTipoValorVariableNomi(tipovalorvariablenomi);

				if((tipovalorvariablenomi.getIsNew()||tipovalorvariablenomi.getIsChanged())&&!tipovalorvariablenomi.getIsDeleted()) {
					this.saveTipoValorVariableNomi();
					this.saveTipoValorVariableNomiRelacionesDetalles(variablenomis);

				} else if(tipovalorvariablenomi.getIsDeleted()) {
					this.saveTipoValorVariableNomiRelacionesDetalles(variablenomis);
					this.saveTipoValorVariableNomi();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			VariableNomiConstantesFunciones.InicializarGeneralEntityAuxiliaresVariableNomis(variablenomis,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoValorVariableNomiRelacionesDetalles(List<VariableNomi> variablenomis)throws Exception {
		try {
	

			Long idTipoValorVariableNomiActual=this.getTipoValorVariableNomi().getId();

			VariableNomiLogic variablenomiLogic_Desde_TipoValorVariableNomi=new VariableNomiLogic();
			variablenomiLogic_Desde_TipoValorVariableNomi.setVariableNomis(variablenomis);

			variablenomiLogic_Desde_TipoValorVariableNomi.setConnexion(this.getConnexion());
			variablenomiLogic_Desde_TipoValorVariableNomi.setDatosCliente(this.datosCliente);

			for(VariableNomi variablenomi_Desde_TipoValorVariableNomi:variablenomiLogic_Desde_TipoValorVariableNomi.getVariableNomis()) {
				variablenomi_Desde_TipoValorVariableNomi.setid_tipo_valor_variable_nomi(idTipoValorVariableNomiActual);
			}

			variablenomiLogic_Desde_TipoValorVariableNomi.saveVariableNomis();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoValorVariableNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoValorVariableNomiConstantesFunciones.getClassesForeignKeysOfTipoValorVariableNomi(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoValorVariableNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoValorVariableNomiConstantesFunciones.getClassesRelationshipsOfTipoValorVariableNomi(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
