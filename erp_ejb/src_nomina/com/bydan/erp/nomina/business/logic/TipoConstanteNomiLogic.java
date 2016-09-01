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
import com.bydan.erp.nomina.util.TipoConstanteNomiConstantesFunciones;
import com.bydan.erp.nomina.util.TipoConstanteNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoConstanteNomiParameterGeneral;
import com.bydan.erp.nomina.business.entity.TipoConstanteNomi;
import com.bydan.erp.nomina.business.logic.TipoConstanteNomiLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoConstanteNomiLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoConstanteNomiLogic.class);
	
	protected TipoConstanteNomiDataAccess tipoconstantenomiDataAccess; 	
	protected TipoConstanteNomi tipoconstantenomi;
	protected List<TipoConstanteNomi> tipoconstantenomis;
	protected Object tipoconstantenomiObject;	
	protected List<Object> tipoconstantenomisObject;
	
	public static ClassValidator<TipoConstanteNomi> tipoconstantenomiValidator = new ClassValidator<TipoConstanteNomi>(TipoConstanteNomi.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoConstanteNomiLogicAdditional tipoconstantenomiLogicAdditional=null;
	
	public TipoConstanteNomiLogicAdditional getTipoConstanteNomiLogicAdditional() {
		return this.tipoconstantenomiLogicAdditional;
	}
	
	public void setTipoConstanteNomiLogicAdditional(TipoConstanteNomiLogicAdditional tipoconstantenomiLogicAdditional) {
		try {
			this.tipoconstantenomiLogicAdditional=tipoconstantenomiLogicAdditional;
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
	
	
	
	
	public  TipoConstanteNomiLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoconstantenomiDataAccess = new TipoConstanteNomiDataAccess();
			
			this.tipoconstantenomis= new ArrayList<TipoConstanteNomi>();
			this.tipoconstantenomi= new TipoConstanteNomi();
			
			this.tipoconstantenomiObject=new Object();
			this.tipoconstantenomisObject=new ArrayList<Object>();
				
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
			
			this.tipoconstantenomiDataAccess.setConnexionType(this.connexionType);
			this.tipoconstantenomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoConstanteNomiLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoconstantenomiDataAccess = new TipoConstanteNomiDataAccess();
			this.tipoconstantenomis= new ArrayList<TipoConstanteNomi>();
			this.tipoconstantenomi= new TipoConstanteNomi();
			this.tipoconstantenomiObject=new Object();
			this.tipoconstantenomisObject=new ArrayList<Object>();
			
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
			
			this.tipoconstantenomiDataAccess.setConnexionType(this.connexionType);
			this.tipoconstantenomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoConstanteNomi getTipoConstanteNomi() throws Exception {	
		TipoConstanteNomiLogicAdditional.checkTipoConstanteNomiToGet(tipoconstantenomi,this.datosCliente,this.arrDatoGeneral);
		TipoConstanteNomiLogicAdditional.updateTipoConstanteNomiToGet(tipoconstantenomi,this.arrDatoGeneral);
		
		return tipoconstantenomi;
	}
		
	public void setTipoConstanteNomi(TipoConstanteNomi newTipoConstanteNomi) {
		this.tipoconstantenomi = newTipoConstanteNomi;
	}
	
	public TipoConstanteNomiDataAccess getTipoConstanteNomiDataAccess() {
		return tipoconstantenomiDataAccess;
	}
	
	public void setTipoConstanteNomiDataAccess(TipoConstanteNomiDataAccess newtipoconstantenomiDataAccess) {
		this.tipoconstantenomiDataAccess = newtipoconstantenomiDataAccess;
	}
	
	public List<TipoConstanteNomi> getTipoConstanteNomis() throws Exception {		
		this.quitarTipoConstanteNomisNulos();
		
		TipoConstanteNomiLogicAdditional.checkTipoConstanteNomiToGets(tipoconstantenomis,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoConstanteNomi tipoconstantenomiLocal: tipoconstantenomis ) {
			TipoConstanteNomiLogicAdditional.updateTipoConstanteNomiToGet(tipoconstantenomiLocal,this.arrDatoGeneral);
		}
		
		return tipoconstantenomis;
	}
	
	public void setTipoConstanteNomis(List<TipoConstanteNomi> newTipoConstanteNomis) {
		this.tipoconstantenomis = newTipoConstanteNomis;
	}
	
	public Object getTipoConstanteNomiObject() {	
		this.tipoconstantenomiObject=this.tipoconstantenomiDataAccess.getEntityObject();
		return this.tipoconstantenomiObject;
	}
		
	public void setTipoConstanteNomiObject(Object newTipoConstanteNomiObject) {
		this.tipoconstantenomiObject = newTipoConstanteNomiObject;
	}
	
	public List<Object> getTipoConstanteNomisObject() {		
		this.tipoconstantenomisObject=this.tipoconstantenomiDataAccess.getEntitiesObject();
		return this.tipoconstantenomisObject;
	}
		
	public void setTipoConstanteNomisObject(List<Object> newTipoConstanteNomisObject) {
		this.tipoconstantenomisObject = newTipoConstanteNomisObject;
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
		
		if(this.tipoconstantenomiDataAccess!=null) {
			this.tipoconstantenomiDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConstanteNomi.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoconstantenomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoconstantenomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoconstantenomi = new  TipoConstanteNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConstanteNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoconstantenomi=tipoconstantenomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoconstantenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoConstanteNomi(this.tipoconstantenomi);
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
		tipoconstantenomi = new  TipoConstanteNomi();
		  		  
        try {
			
			tipoconstantenomi=tipoconstantenomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoconstantenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoConstanteNomi(this.tipoconstantenomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoconstantenomi = new  TipoConstanteNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConstanteNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoconstantenomi=tipoconstantenomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoconstantenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoConstanteNomi(this.tipoconstantenomi);
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
		tipoconstantenomi = new  TipoConstanteNomi();
		  		  
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
		tipoconstantenomi = new  TipoConstanteNomi();
		  		  
        try {
			
			tipoconstantenomi=tipoconstantenomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoconstantenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoConstanteNomi(this.tipoconstantenomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoconstantenomi = new  TipoConstanteNomi();
		  		  
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
		tipoconstantenomi = new  TipoConstanteNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConstanteNomi.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoconstantenomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoconstantenomi = new  TipoConstanteNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoconstantenomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoconstantenomi = new  TipoConstanteNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConstanteNomi.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoconstantenomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoconstantenomi = new  TipoConstanteNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoconstantenomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoconstantenomi = new  TipoConstanteNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConstanteNomi.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoconstantenomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoconstantenomi = new  TipoConstanteNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoconstantenomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoconstantenomis = new  ArrayList<TipoConstanteNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConstanteNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconstantenomis=tipoconstantenomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoConstanteNomi(tipoconstantenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoConstanteNomi(this.tipoconstantenomis);
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
		tipoconstantenomis = new  ArrayList<TipoConstanteNomi>();
		  		  
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
		tipoconstantenomis = new  ArrayList<TipoConstanteNomi>();
		  		  
        try {			
			TipoConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconstantenomis=tipoconstantenomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoConstanteNomi(tipoconstantenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoConstanteNomi(this.tipoconstantenomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoconstantenomis = new  ArrayList<TipoConstanteNomi>();
		  		  
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
		tipoconstantenomis = new  ArrayList<TipoConstanteNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConstanteNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconstantenomis=tipoconstantenomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoConstanteNomi(tipoconstantenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoConstanteNomi(this.tipoconstantenomis);
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
		tipoconstantenomis = new  ArrayList<TipoConstanteNomi>();
		  		  
        try {
			TipoConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconstantenomis=tipoconstantenomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoConstanteNomi(tipoconstantenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoConstanteNomi(this.tipoconstantenomis);
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
		tipoconstantenomis = new  ArrayList<TipoConstanteNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConstanteNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconstantenomis=tipoconstantenomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoConstanteNomi(tipoconstantenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoConstanteNomi(this.tipoconstantenomis);
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
		tipoconstantenomis = new  ArrayList<TipoConstanteNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconstantenomis=tipoconstantenomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoConstanteNomi(tipoconstantenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoConstanteNomi(this.tipoconstantenomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoconstantenomi = new  TipoConstanteNomi();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConstanteNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconstantenomi=tipoconstantenomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoConstanteNomi(tipoconstantenomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoConstanteNomi(this.tipoconstantenomi);
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
		tipoconstantenomi = new  TipoConstanteNomi();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconstantenomi=tipoconstantenomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoConstanteNomi(tipoconstantenomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoConstanteNomi(this.tipoconstantenomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoconstantenomis = new  ArrayList<TipoConstanteNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConstanteNomi.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconstantenomis=tipoconstantenomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoConstanteNomi(tipoconstantenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoConstanteNomi(this.tipoconstantenomis);
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
		tipoconstantenomis = new  ArrayList<TipoConstanteNomi>();
		  		  
        try {
			TipoConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconstantenomis=tipoconstantenomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoConstanteNomi(tipoconstantenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoConstanteNomi(this.tipoconstantenomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoConstanteNomisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoconstantenomis = new  ArrayList<TipoConstanteNomi>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConstanteNomi.class.getSimpleName()+"-getTodosTipoConstanteNomisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconstantenomis=tipoconstantenomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoConstanteNomi(tipoconstantenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoConstanteNomi(this.tipoconstantenomis);
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
	
	public  void  getTodosTipoConstanteNomis(String sFinalQuery,Pagination pagination)throws Exception {
		tipoconstantenomis = new  ArrayList<TipoConstanteNomi>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconstantenomis=tipoconstantenomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoConstanteNomi(tipoconstantenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoConstanteNomi(this.tipoconstantenomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoConstanteNomi(TipoConstanteNomi tipoconstantenomi) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoconstantenomi.getIsNew() || tipoconstantenomi.getIsChanged()) { 
			this.invalidValues = tipoconstantenomiValidator.getInvalidValues(tipoconstantenomi);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoconstantenomi);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoConstanteNomi(List<TipoConstanteNomi> TipoConstanteNomis) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoConstanteNomi tipoconstantenomiLocal:tipoconstantenomis) {				
			estaValidadoObjeto=this.validarGuardarTipoConstanteNomi(tipoconstantenomiLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoConstanteNomi(List<TipoConstanteNomi> TipoConstanteNomis) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoConstanteNomi(tipoconstantenomis)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoConstanteNomi(TipoConstanteNomi TipoConstanteNomi) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoConstanteNomi(tipoconstantenomi)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoConstanteNomi tipoconstantenomi) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoconstantenomi.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoConstanteNomiConstantesFunciones.getTipoConstanteNomiLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoconstantenomi","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoConstanteNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoConstanteNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoConstanteNomiWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConstanteNomi.class.getSimpleName()+"-saveTipoConstanteNomiWithConnection");connexion.begin();			
			
			TipoConstanteNomiLogicAdditional.checkTipoConstanteNomiToSave(this.tipoconstantenomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoConstanteNomiLogicAdditional.updateTipoConstanteNomiToSave(this.tipoconstantenomi,this.arrDatoGeneral);
			
			TipoConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoconstantenomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoConstanteNomi();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoConstanteNomi(this.tipoconstantenomi)) {
				TipoConstanteNomiDataAccess.save(this.tipoconstantenomi, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoconstantenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoConstanteNomiLogicAdditional.checkTipoConstanteNomiToSaveAfter(this.tipoconstantenomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoConstanteNomi();
			
			connexion.commit();			
			
			if(this.tipoconstantenomi.getIsDeleted()) {
				this.tipoconstantenomi=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoConstanteNomi()throws Exception {	
		try {	
			
			TipoConstanteNomiLogicAdditional.checkTipoConstanteNomiToSave(this.tipoconstantenomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoConstanteNomiLogicAdditional.updateTipoConstanteNomiToSave(this.tipoconstantenomi,this.arrDatoGeneral);
			
			TipoConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoconstantenomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoConstanteNomi(this.tipoconstantenomi)) {			
				TipoConstanteNomiDataAccess.save(this.tipoconstantenomi, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoconstantenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoConstanteNomiLogicAdditional.checkTipoConstanteNomiToSaveAfter(this.tipoconstantenomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoconstantenomi.getIsDeleted()) {
				this.tipoconstantenomi=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoConstanteNomisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConstanteNomi.class.getSimpleName()+"-saveTipoConstanteNomisWithConnection");connexion.begin();			
			
			TipoConstanteNomiLogicAdditional.checkTipoConstanteNomiToSaves(tipoconstantenomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoConstanteNomis();
			
			Boolean validadoTodosTipoConstanteNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoConstanteNomi tipoconstantenomiLocal:tipoconstantenomis) {		
				if(tipoconstantenomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoConstanteNomiLogicAdditional.updateTipoConstanteNomiToSave(tipoconstantenomiLocal,this.arrDatoGeneral);
	        	
				TipoConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoconstantenomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoConstanteNomi(tipoconstantenomiLocal)) {
					TipoConstanteNomiDataAccess.save(tipoconstantenomiLocal, connexion);				
				} else {
					validadoTodosTipoConstanteNomi=false;
				}
			}
			
			if(!validadoTodosTipoConstanteNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoConstanteNomiLogicAdditional.checkTipoConstanteNomiToSavesAfter(tipoconstantenomis,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoConstanteNomis();
			
			connexion.commit();		
			
			this.quitarTipoConstanteNomisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoConstanteNomis()throws Exception {				
		 try {	
			TipoConstanteNomiLogicAdditional.checkTipoConstanteNomiToSaves(tipoconstantenomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoConstanteNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoConstanteNomi tipoconstantenomiLocal:tipoconstantenomis) {				
				if(tipoconstantenomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoConstanteNomiLogicAdditional.updateTipoConstanteNomiToSave(tipoconstantenomiLocal,this.arrDatoGeneral);
	        	
				TipoConstanteNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoconstantenomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoConstanteNomi(tipoconstantenomiLocal)) {				
					TipoConstanteNomiDataAccess.save(tipoconstantenomiLocal, connexion);				
				} else {
					validadoTodosTipoConstanteNomi=false;
				}
			}
			
			if(!validadoTodosTipoConstanteNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoConstanteNomiLogicAdditional.checkTipoConstanteNomiToSavesAfter(tipoconstantenomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoConstanteNomisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoConstanteNomiParameterReturnGeneral procesarAccionTipoConstanteNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoConstanteNomi> tipoconstantenomis,TipoConstanteNomiParameterReturnGeneral tipoconstantenomiParameterGeneral)throws Exception {
		 try {	
			TipoConstanteNomiParameterReturnGeneral tipoconstantenomiReturnGeneral=new TipoConstanteNomiParameterReturnGeneral();
	
			TipoConstanteNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoconstantenomis,tipoconstantenomiParameterGeneral,tipoconstantenomiReturnGeneral);
			
			return tipoconstantenomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoConstanteNomiParameterReturnGeneral procesarAccionTipoConstanteNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoConstanteNomi> tipoconstantenomis,TipoConstanteNomiParameterReturnGeneral tipoconstantenomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConstanteNomi.class.getSimpleName()+"-procesarAccionTipoConstanteNomisWithConnection");connexion.begin();			
			
			TipoConstanteNomiParameterReturnGeneral tipoconstantenomiReturnGeneral=new TipoConstanteNomiParameterReturnGeneral();
	
			TipoConstanteNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoconstantenomis,tipoconstantenomiParameterGeneral,tipoconstantenomiReturnGeneral);
			
			this.connexion.commit();
			
			return tipoconstantenomiReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoConstanteNomiParameterReturnGeneral procesarEventosTipoConstanteNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoConstanteNomi> tipoconstantenomis,TipoConstanteNomi tipoconstantenomi,TipoConstanteNomiParameterReturnGeneral tipoconstantenomiParameterGeneral,Boolean isEsNuevoTipoConstanteNomi,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoConstanteNomiParameterReturnGeneral tipoconstantenomiReturnGeneral=new TipoConstanteNomiParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoconstantenomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoConstanteNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoconstantenomis,tipoconstantenomi,tipoconstantenomiParameterGeneral,tipoconstantenomiReturnGeneral,isEsNuevoTipoConstanteNomi,clases);
			
			return tipoconstantenomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoConstanteNomiParameterReturnGeneral procesarEventosTipoConstanteNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoConstanteNomi> tipoconstantenomis,TipoConstanteNomi tipoconstantenomi,TipoConstanteNomiParameterReturnGeneral tipoconstantenomiParameterGeneral,Boolean isEsNuevoTipoConstanteNomi,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConstanteNomi.class.getSimpleName()+"-procesarEventosTipoConstanteNomisWithConnection");connexion.begin();			
			
			TipoConstanteNomiParameterReturnGeneral tipoconstantenomiReturnGeneral=new TipoConstanteNomiParameterReturnGeneral();
	
			tipoconstantenomiReturnGeneral.setTipoConstanteNomi(tipoconstantenomi);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoconstantenomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoConstanteNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoconstantenomis,tipoconstantenomi,tipoconstantenomiParameterGeneral,tipoconstantenomiReturnGeneral,isEsNuevoTipoConstanteNomi,clases);
			
			this.connexion.commit();
			
			return tipoconstantenomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoConstanteNomiParameterReturnGeneral procesarImportacionTipoConstanteNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoConstanteNomiParameterReturnGeneral tipoconstantenomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConstanteNomi.class.getSimpleName()+"-procesarImportacionTipoConstanteNomisWithConnection");connexion.begin();			
			
			TipoConstanteNomiParameterReturnGeneral tipoconstantenomiReturnGeneral=new TipoConstanteNomiParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoconstantenomis=new ArrayList<TipoConstanteNomi>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoconstantenomi=new TipoConstanteNomi();
				
				
				if(conColumnasBase) {this.tipoconstantenomi.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoconstantenomi.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoconstantenomi.setcodigo(arrColumnas[iColumn++]);
				this.tipoconstantenomi.setnombre(arrColumnas[iColumn++]);
				
				this.tipoconstantenomis.add(this.tipoconstantenomi);
			}
			
			this.saveTipoConstanteNomis();
			
			this.connexion.commit();
			
			tipoconstantenomiReturnGeneral.setConRetornoEstaProcesado(true);
			tipoconstantenomiReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoconstantenomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoConstanteNomisEliminados() throws Exception {				
		
		List<TipoConstanteNomi> tipoconstantenomisAux= new ArrayList<TipoConstanteNomi>();
		
		for(TipoConstanteNomi tipoconstantenomi:tipoconstantenomis) {
			if(!tipoconstantenomi.getIsDeleted()) {
				tipoconstantenomisAux.add(tipoconstantenomi);
			}
		}
		
		tipoconstantenomis=tipoconstantenomisAux;
	}
	
	public void quitarTipoConstanteNomisNulos() throws Exception {				
		
		List<TipoConstanteNomi> tipoconstantenomisAux= new ArrayList<TipoConstanteNomi>();
		
		for(TipoConstanteNomi tipoconstantenomi : this.tipoconstantenomis) {
			if(tipoconstantenomi==null) {
				tipoconstantenomisAux.add(tipoconstantenomi);
			}
		}
		
		//this.tipoconstantenomis=tipoconstantenomisAux;
		
		this.tipoconstantenomis.removeAll(tipoconstantenomisAux);
	}
	
	public void getSetVersionRowTipoConstanteNomiWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoconstantenomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoconstantenomi.getIsDeleted() || (tipoconstantenomi.getIsChanged()&&!tipoconstantenomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoconstantenomiDataAccess.getSetVersionRowTipoConstanteNomi(connexion,tipoconstantenomi.getId());
				
				if(!tipoconstantenomi.getVersionRow().equals(timestamp)) {	
					tipoconstantenomi.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoconstantenomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoConstanteNomi()throws Exception {	
		
		if(tipoconstantenomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoconstantenomi.getIsDeleted() || (tipoconstantenomi.getIsChanged()&&!tipoconstantenomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoconstantenomiDataAccess.getSetVersionRowTipoConstanteNomi(connexion,tipoconstantenomi.getId());
			
			try {							
				if(!tipoconstantenomi.getVersionRow().equals(timestamp)) {	
					tipoconstantenomi.setVersionRow(timestamp);
				}
				
				tipoconstantenomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoConstanteNomisWithConnection()throws Exception {	
		if(tipoconstantenomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoConstanteNomi tipoconstantenomiAux:tipoconstantenomis) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoconstantenomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoconstantenomiAux.getIsDeleted() || (tipoconstantenomiAux.getIsChanged()&&!tipoconstantenomiAux.getIsNew())) {
						
						timestamp=tipoconstantenomiDataAccess.getSetVersionRowTipoConstanteNomi(connexion,tipoconstantenomiAux.getId());
						
						if(!tipoconstantenomi.getVersionRow().equals(timestamp)) {	
							tipoconstantenomiAux.setVersionRow(timestamp);
						}
								
						tipoconstantenomiAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoConstanteNomis()throws Exception {	
		if(tipoconstantenomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoConstanteNomi tipoconstantenomiAux:tipoconstantenomis) {
					if(tipoconstantenomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoconstantenomiAux.getIsDeleted() || (tipoconstantenomiAux.getIsChanged()&&!tipoconstantenomiAux.getIsNew())) {
						
						timestamp=tipoconstantenomiDataAccess.getSetVersionRowTipoConstanteNomi(connexion,tipoconstantenomiAux.getId());
						
						if(!tipoconstantenomiAux.getVersionRow().equals(timestamp)) {	
							tipoconstantenomiAux.setVersionRow(timestamp);
						}
						
													
						tipoconstantenomiAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoConstanteNomiWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ConstanteNomiLogic constantenomiLogic=new ConstanteNomiLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConstanteNomi.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoConstanteNomiWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ConstanteNomi.class));
											
			

			constantenomiLogic.setConnexion(this.getConnexion());
			constantenomiLogic.setDatosCliente(this.datosCliente);
			constantenomiLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoConstanteNomi tipoconstantenomi:this.tipoconstantenomis) {
				

				classes=new ArrayList<Classe>();
				classes=ConstanteNomiConstantesFunciones.getClassesForeignKeysOfConstanteNomi(new ArrayList<Classe>(),DeepLoadType.NONE);

				constantenomiLogic.setConstanteNomis(tipoconstantenomi.constantenomis);
				constantenomiLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoConstanteNomi tipoconstantenomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoConstanteNomiLogicAdditional.updateTipoConstanteNomiToGet(tipoconstantenomi,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoconstantenomi.setConstanteNomis(tipoconstantenomiDataAccess.getConstanteNomis(connexion,tipoconstantenomi));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ConstanteNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoconstantenomi.setConstanteNomis(tipoconstantenomiDataAccess.getConstanteNomis(connexion,tipoconstantenomi));

				if(this.isConDeep) {
					ConstanteNomiLogic constantenomiLogic= new ConstanteNomiLogic(this.connexion);
					constantenomiLogic.setConstanteNomis(tipoconstantenomi.getConstanteNomis());
					ArrayList<Classe> classesLocal=ConstanteNomiConstantesFunciones.getClassesForeignKeysOfConstanteNomi(new ArrayList<Classe>(),DeepLoadType.NONE);
					constantenomiLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesConstanteNomi(constantenomiLogic.getConstanteNomis());
					tipoconstantenomi.setConstanteNomis(constantenomiLogic.getConstanteNomis());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ConstanteNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ConstanteNomi.class));
			tipoconstantenomi.setConstanteNomis(tipoconstantenomiDataAccess.getConstanteNomis(connexion,tipoconstantenomi));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tipoconstantenomi.setConstanteNomis(tipoconstantenomiDataAccess.getConstanteNomis(connexion,tipoconstantenomi));

		for(ConstanteNomi constantenomi:tipoconstantenomi.getConstanteNomis()) {
			ConstanteNomiLogic constantenomiLogic= new ConstanteNomiLogic(connexion);
			constantenomiLogic.deepLoad(constantenomi,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ConstanteNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoconstantenomi.setConstanteNomis(tipoconstantenomiDataAccess.getConstanteNomis(connexion,tipoconstantenomi));

				for(ConstanteNomi constantenomi:tipoconstantenomi.getConstanteNomis()) {
					ConstanteNomiLogic constantenomiLogic= new ConstanteNomiLogic(connexion);
					constantenomiLogic.deepLoad(constantenomi,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ConstanteNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ConstanteNomi.class));
			tipoconstantenomi.setConstanteNomis(tipoconstantenomiDataAccess.getConstanteNomis(connexion,tipoconstantenomi));

			for(ConstanteNomi constantenomi:tipoconstantenomi.getConstanteNomis()) {
				ConstanteNomiLogic constantenomiLogic= new ConstanteNomiLogic(connexion);
				constantenomiLogic.deepLoad(constantenomi,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoConstanteNomi tipoconstantenomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoConstanteNomiLogicAdditional.updateTipoConstanteNomiToSave(tipoconstantenomi,this.arrDatoGeneral);
			
TipoConstanteNomiDataAccess.save(tipoconstantenomi, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(ConstanteNomi constantenomi:tipoconstantenomi.getConstanteNomis()) {
			constantenomi.setid_tipo_constante_nomi(tipoconstantenomi.getId());
			ConstanteNomiDataAccess.save(constantenomi,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(ConstanteNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ConstanteNomi constantenomi:tipoconstantenomi.getConstanteNomis()) {
					constantenomi.setid_tipo_constante_nomi(tipoconstantenomi.getId());
					ConstanteNomiDataAccess.save(constantenomi,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(ConstanteNomi constantenomi:tipoconstantenomi.getConstanteNomis()) {
			ConstanteNomiLogic constantenomiLogic= new ConstanteNomiLogic(connexion);
			constantenomi.setid_tipo_constante_nomi(tipoconstantenomi.getId());
			ConstanteNomiDataAccess.save(constantenomi,connexion);
			constantenomiLogic.deepSave(constantenomi,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(ConstanteNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ConstanteNomi constantenomi:tipoconstantenomi.getConstanteNomis()) {
					ConstanteNomiLogic constantenomiLogic= new ConstanteNomiLogic(connexion);
					constantenomi.setid_tipo_constante_nomi(tipoconstantenomi.getId());
					ConstanteNomiDataAccess.save(constantenomi,connexion);
					constantenomiLogic.deepSave(constantenomi,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoConstanteNomi.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoconstantenomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoConstanteNomi(tipoconstantenomi);
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
			this.deepLoad(this.tipoconstantenomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoConstanteNomi(this.tipoconstantenomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoConstanteNomi.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoconstantenomis!=null) {
				for(TipoConstanteNomi tipoconstantenomi:tipoconstantenomis) {
					this.deepLoad(tipoconstantenomi,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoConstanteNomi(tipoconstantenomis);
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
			if(tipoconstantenomis!=null) {
				for(TipoConstanteNomi tipoconstantenomi:tipoconstantenomis) {
					this.deepLoad(tipoconstantenomi,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoConstanteNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoConstanteNomi(tipoconstantenomis);
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
			this.getNewConnexionToDeep(TipoConstanteNomi.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipoconstantenomi,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoConstanteNomi.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipoconstantenomis!=null) {
				for(TipoConstanteNomi tipoconstantenomi:tipoconstantenomis) {
					this.deepSave(tipoconstantenomi,isDeep,deepLoadType,clases);
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
			if(tipoconstantenomis!=null) {
				for(TipoConstanteNomi tipoconstantenomi:tipoconstantenomis) {
					this.deepSave(tipoconstantenomi,isDeep,deepLoadType,clases);
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
			if(TipoConstanteNomiConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoConstanteNomiDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoConstanteNomi tipoconstantenomi,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoConstanteNomiConstantesFunciones.ISCONAUDITORIA) {
				if(tipoconstantenomi.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoConstanteNomiDataAccess.TABLENAME, tipoconstantenomi.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoConstanteNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoConstanteNomiLogic.registrarAuditoriaDetallesTipoConstanteNomi(connexion,tipoconstantenomi,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoconstantenomi.getIsDeleted()) {
					/*if(!tipoconstantenomi.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoConstanteNomiDataAccess.TABLENAME, tipoconstantenomi.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoConstanteNomiLogic.registrarAuditoriaDetallesTipoConstanteNomi(connexion,tipoconstantenomi,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoConstanteNomiDataAccess.TABLENAME, tipoconstantenomi.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoconstantenomi.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoConstanteNomiDataAccess.TABLENAME, tipoconstantenomi.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoConstanteNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoConstanteNomiLogic.registrarAuditoriaDetallesTipoConstanteNomi(connexion,tipoconstantenomi,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoConstanteNomi(Connexion connexion,TipoConstanteNomi tipoconstantenomi)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoconstantenomi.getIsNew()||!tipoconstantenomi.getcodigo().equals(tipoconstantenomi.getTipoConstanteNomiOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoconstantenomi.getTipoConstanteNomiOriginal().getcodigo()!=null)
				{
					strValorActual=tipoconstantenomi.getTipoConstanteNomiOriginal().getcodigo();
				}
				if(tipoconstantenomi.getcodigo()!=null)
				{
					strValorNuevo=tipoconstantenomi.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoConstanteNomiConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoconstantenomi.getIsNew()||!tipoconstantenomi.getnombre().equals(tipoconstantenomi.getTipoConstanteNomiOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoconstantenomi.getTipoConstanteNomiOriginal().getnombre()!=null)
				{
					strValorActual=tipoconstantenomi.getTipoConstanteNomiOriginal().getnombre();
				}
				if(tipoconstantenomi.getnombre()!=null)
				{
					strValorNuevo=tipoconstantenomi.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoConstanteNomiConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoConstanteNomiRelacionesWithConnection(TipoConstanteNomi tipoconstantenomi,List<ConstanteNomi> constantenomis) throws Exception {

		if(!tipoconstantenomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoConstanteNomiRelacionesBase(tipoconstantenomi,constantenomis,true);
		}
	}

	public void saveTipoConstanteNomiRelaciones(TipoConstanteNomi tipoconstantenomi,List<ConstanteNomi> constantenomis)throws Exception {

		if(!tipoconstantenomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoConstanteNomiRelacionesBase(tipoconstantenomi,constantenomis,false);
		}
	}

	public void saveTipoConstanteNomiRelacionesBase(TipoConstanteNomi tipoconstantenomi,List<ConstanteNomi> constantenomis,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoConstanteNomi-saveRelacionesWithConnection");}
	
			tipoconstantenomi.setConstanteNomis(constantenomis);

			this.setTipoConstanteNomi(tipoconstantenomi);

				if((tipoconstantenomi.getIsNew()||tipoconstantenomi.getIsChanged())&&!tipoconstantenomi.getIsDeleted()) {
					this.saveTipoConstanteNomi();
					this.saveTipoConstanteNomiRelacionesDetalles(constantenomis);

				} else if(tipoconstantenomi.getIsDeleted()) {
					this.saveTipoConstanteNomiRelacionesDetalles(constantenomis);
					this.saveTipoConstanteNomi();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ConstanteNomiConstantesFunciones.InicializarGeneralEntityAuxiliaresConstanteNomis(constantenomis,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoConstanteNomiRelacionesDetalles(List<ConstanteNomi> constantenomis)throws Exception {
		try {
	

			Long idTipoConstanteNomiActual=this.getTipoConstanteNomi().getId();

			ConstanteNomiLogic constantenomiLogic_Desde_TipoConstanteNomi=new ConstanteNomiLogic();
			constantenomiLogic_Desde_TipoConstanteNomi.setConstanteNomis(constantenomis);

			constantenomiLogic_Desde_TipoConstanteNomi.setConnexion(this.getConnexion());
			constantenomiLogic_Desde_TipoConstanteNomi.setDatosCliente(this.datosCliente);

			for(ConstanteNomi constantenomi_Desde_TipoConstanteNomi:constantenomiLogic_Desde_TipoConstanteNomi.getConstanteNomis()) {
				constantenomi_Desde_TipoConstanteNomi.setid_tipo_constante_nomi(idTipoConstanteNomiActual);

				constantenomiLogic_Desde_TipoConstanteNomi.setConstanteNomi(constantenomi_Desde_TipoConstanteNomi);
				constantenomiLogic_Desde_TipoConstanteNomi.saveConstanteNomi();

				Long idConstanteNomiActual=constantenomi_Desde_TipoConstanteNomi.getId();

				EmpleadoConstanteLogic empleadoconstanteLogic_Desde_ConstanteNomi=new EmpleadoConstanteLogic();

				if(constantenomi_Desde_TipoConstanteNomi.getEmpleadoConstantes()==null){
					constantenomi_Desde_TipoConstanteNomi.setEmpleadoConstantes(new ArrayList<EmpleadoConstante>());
				}

				empleadoconstanteLogic_Desde_ConstanteNomi.setEmpleadoConstantes(constantenomi_Desde_TipoConstanteNomi.getEmpleadoConstantes());

				empleadoconstanteLogic_Desde_ConstanteNomi.setConnexion(this.getConnexion());
				empleadoconstanteLogic_Desde_ConstanteNomi.setDatosCliente(this.datosCliente);

				for(EmpleadoConstante empleadoconstante_Desde_ConstanteNomi:empleadoconstanteLogic_Desde_ConstanteNomi.getEmpleadoConstantes()) {
					empleadoconstante_Desde_ConstanteNomi.setid_constante_nomi(idConstanteNomiActual);
				}

				empleadoconstanteLogic_Desde_ConstanteNomi.saveEmpleadoConstantes();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoConstanteNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoConstanteNomiConstantesFunciones.getClassesForeignKeysOfTipoConstanteNomi(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoConstanteNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoConstanteNomiConstantesFunciones.getClassesRelationshipsOfTipoConstanteNomi(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
