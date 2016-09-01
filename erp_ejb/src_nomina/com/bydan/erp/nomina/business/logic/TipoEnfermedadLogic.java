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
import com.bydan.erp.nomina.util.TipoEnfermedadConstantesFunciones;
import com.bydan.erp.nomina.util.TipoEnfermedadParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoEnfermedadParameterGeneral;
import com.bydan.erp.nomina.business.entity.TipoEnfermedad;
import com.bydan.erp.nomina.business.logic.TipoEnfermedadLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoEnfermedadLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoEnfermedadLogic.class);
	
	protected TipoEnfermedadDataAccess tipoenfermedadDataAccess; 	
	protected TipoEnfermedad tipoenfermedad;
	protected List<TipoEnfermedad> tipoenfermedads;
	protected Object tipoenfermedadObject;	
	protected List<Object> tipoenfermedadsObject;
	
	public static ClassValidator<TipoEnfermedad> tipoenfermedadValidator = new ClassValidator<TipoEnfermedad>(TipoEnfermedad.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoEnfermedadLogicAdditional tipoenfermedadLogicAdditional=null;
	
	public TipoEnfermedadLogicAdditional getTipoEnfermedadLogicAdditional() {
		return this.tipoenfermedadLogicAdditional;
	}
	
	public void setTipoEnfermedadLogicAdditional(TipoEnfermedadLogicAdditional tipoenfermedadLogicAdditional) {
		try {
			this.tipoenfermedadLogicAdditional=tipoenfermedadLogicAdditional;
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
	
	
	
	
	public  TipoEnfermedadLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoenfermedadDataAccess = new TipoEnfermedadDataAccess();
			
			this.tipoenfermedads= new ArrayList<TipoEnfermedad>();
			this.tipoenfermedad= new TipoEnfermedad();
			
			this.tipoenfermedadObject=new Object();
			this.tipoenfermedadsObject=new ArrayList<Object>();
				
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
			
			this.tipoenfermedadDataAccess.setConnexionType(this.connexionType);
			this.tipoenfermedadDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoEnfermedadLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoenfermedadDataAccess = new TipoEnfermedadDataAccess();
			this.tipoenfermedads= new ArrayList<TipoEnfermedad>();
			this.tipoenfermedad= new TipoEnfermedad();
			this.tipoenfermedadObject=new Object();
			this.tipoenfermedadsObject=new ArrayList<Object>();
			
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
			
			this.tipoenfermedadDataAccess.setConnexionType(this.connexionType);
			this.tipoenfermedadDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoEnfermedad getTipoEnfermedad() throws Exception {	
		TipoEnfermedadLogicAdditional.checkTipoEnfermedadToGet(tipoenfermedad,this.datosCliente,this.arrDatoGeneral);
		TipoEnfermedadLogicAdditional.updateTipoEnfermedadToGet(tipoenfermedad,this.arrDatoGeneral);
		
		return tipoenfermedad;
	}
		
	public void setTipoEnfermedad(TipoEnfermedad newTipoEnfermedad) {
		this.tipoenfermedad = newTipoEnfermedad;
	}
	
	public TipoEnfermedadDataAccess getTipoEnfermedadDataAccess() {
		return tipoenfermedadDataAccess;
	}
	
	public void setTipoEnfermedadDataAccess(TipoEnfermedadDataAccess newtipoenfermedadDataAccess) {
		this.tipoenfermedadDataAccess = newtipoenfermedadDataAccess;
	}
	
	public List<TipoEnfermedad> getTipoEnfermedads() throws Exception {		
		this.quitarTipoEnfermedadsNulos();
		
		TipoEnfermedadLogicAdditional.checkTipoEnfermedadToGets(tipoenfermedads,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoEnfermedad tipoenfermedadLocal: tipoenfermedads ) {
			TipoEnfermedadLogicAdditional.updateTipoEnfermedadToGet(tipoenfermedadLocal,this.arrDatoGeneral);
		}
		
		return tipoenfermedads;
	}
	
	public void setTipoEnfermedads(List<TipoEnfermedad> newTipoEnfermedads) {
		this.tipoenfermedads = newTipoEnfermedads;
	}
	
	public Object getTipoEnfermedadObject() {	
		this.tipoenfermedadObject=this.tipoenfermedadDataAccess.getEntityObject();
		return this.tipoenfermedadObject;
	}
		
	public void setTipoEnfermedadObject(Object newTipoEnfermedadObject) {
		this.tipoenfermedadObject = newTipoEnfermedadObject;
	}
	
	public List<Object> getTipoEnfermedadsObject() {		
		this.tipoenfermedadsObject=this.tipoenfermedadDataAccess.getEntitiesObject();
		return this.tipoenfermedadsObject;
	}
		
	public void setTipoEnfermedadsObject(List<Object> newTipoEnfermedadsObject) {
		this.tipoenfermedadsObject = newTipoEnfermedadsObject;
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
		
		if(this.tipoenfermedadDataAccess!=null) {
			this.tipoenfermedadDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEnfermedad.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoenfermedadDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoenfermedadDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoenfermedad = new  TipoEnfermedad();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEnfermedad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoenfermedad=tipoenfermedadDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoenfermedad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoEnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesTipoEnfermedad(this.tipoenfermedad);
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
		tipoenfermedad = new  TipoEnfermedad();
		  		  
        try {
			
			tipoenfermedad=tipoenfermedadDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoenfermedad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoEnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesTipoEnfermedad(this.tipoenfermedad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoenfermedad = new  TipoEnfermedad();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEnfermedad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoenfermedad=tipoenfermedadDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoenfermedad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoEnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesTipoEnfermedad(this.tipoenfermedad);
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
		tipoenfermedad = new  TipoEnfermedad();
		  		  
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
		tipoenfermedad = new  TipoEnfermedad();
		  		  
        try {
			
			tipoenfermedad=tipoenfermedadDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoenfermedad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoEnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesTipoEnfermedad(this.tipoenfermedad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoenfermedad = new  TipoEnfermedad();
		  		  
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
		tipoenfermedad = new  TipoEnfermedad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEnfermedad.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoenfermedadDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoenfermedad = new  TipoEnfermedad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoenfermedadDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoenfermedad = new  TipoEnfermedad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEnfermedad.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoenfermedadDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoenfermedad = new  TipoEnfermedad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoenfermedadDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoenfermedad = new  TipoEnfermedad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEnfermedad.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoenfermedadDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoenfermedad = new  TipoEnfermedad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoenfermedadDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoenfermedads = new  ArrayList<TipoEnfermedad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEnfermedad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoEnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoenfermedads=tipoenfermedadDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoEnfermedad(tipoenfermedads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesTipoEnfermedad(this.tipoenfermedads);
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
		tipoenfermedads = new  ArrayList<TipoEnfermedad>();
		  		  
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
		tipoenfermedads = new  ArrayList<TipoEnfermedad>();
		  		  
        try {			
			TipoEnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoenfermedads=tipoenfermedadDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoEnfermedad(tipoenfermedads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesTipoEnfermedad(this.tipoenfermedads);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoenfermedads = new  ArrayList<TipoEnfermedad>();
		  		  
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
		tipoenfermedads = new  ArrayList<TipoEnfermedad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEnfermedad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoEnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoenfermedads=tipoenfermedadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoEnfermedad(tipoenfermedads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesTipoEnfermedad(this.tipoenfermedads);
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
		tipoenfermedads = new  ArrayList<TipoEnfermedad>();
		  		  
        try {
			TipoEnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoenfermedads=tipoenfermedadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoEnfermedad(tipoenfermedads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesTipoEnfermedad(this.tipoenfermedads);
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
		tipoenfermedads = new  ArrayList<TipoEnfermedad>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEnfermedad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoEnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoenfermedads=tipoenfermedadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoEnfermedad(tipoenfermedads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesTipoEnfermedad(this.tipoenfermedads);
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
		tipoenfermedads = new  ArrayList<TipoEnfermedad>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoEnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoenfermedads=tipoenfermedadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoEnfermedad(tipoenfermedads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesTipoEnfermedad(this.tipoenfermedads);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoenfermedad = new  TipoEnfermedad();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEnfermedad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoEnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoenfermedad=tipoenfermedadDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoEnfermedad(tipoenfermedad);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesTipoEnfermedad(this.tipoenfermedad);
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
		tipoenfermedad = new  TipoEnfermedad();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoEnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoenfermedad=tipoenfermedadDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoEnfermedad(tipoenfermedad);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesTipoEnfermedad(this.tipoenfermedad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoenfermedads = new  ArrayList<TipoEnfermedad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEnfermedad.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoEnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoenfermedads=tipoenfermedadDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoEnfermedad(tipoenfermedads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesTipoEnfermedad(this.tipoenfermedads);
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
		tipoenfermedads = new  ArrayList<TipoEnfermedad>();
		  		  
        try {
			TipoEnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoenfermedads=tipoenfermedadDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoEnfermedad(tipoenfermedads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesTipoEnfermedad(this.tipoenfermedads);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoEnfermedadsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoenfermedads = new  ArrayList<TipoEnfermedad>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEnfermedad.class.getSimpleName()+"-getTodosTipoEnfermedadsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoEnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoenfermedads=tipoenfermedadDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoEnfermedad(tipoenfermedads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesTipoEnfermedad(this.tipoenfermedads);
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
	
	public  void  getTodosTipoEnfermedads(String sFinalQuery,Pagination pagination)throws Exception {
		tipoenfermedads = new  ArrayList<TipoEnfermedad>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoEnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoenfermedads=tipoenfermedadDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoEnfermedad(tipoenfermedads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesTipoEnfermedad(this.tipoenfermedads);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoEnfermedad(TipoEnfermedad tipoenfermedad) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoenfermedad.getIsNew() || tipoenfermedad.getIsChanged()) { 
			this.invalidValues = tipoenfermedadValidator.getInvalidValues(tipoenfermedad);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoenfermedad);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoEnfermedad(List<TipoEnfermedad> TipoEnfermedads) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoEnfermedad tipoenfermedadLocal:tipoenfermedads) {				
			estaValidadoObjeto=this.validarGuardarTipoEnfermedad(tipoenfermedadLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoEnfermedad(List<TipoEnfermedad> TipoEnfermedads) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoEnfermedad(tipoenfermedads)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoEnfermedad(TipoEnfermedad TipoEnfermedad) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoEnfermedad(tipoenfermedad)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoEnfermedad tipoenfermedad) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoenfermedad.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoEnfermedadConstantesFunciones.getTipoEnfermedadLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoenfermedad","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoEnfermedadConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoEnfermedadConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoEnfermedadWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEnfermedad.class.getSimpleName()+"-saveTipoEnfermedadWithConnection");connexion.begin();			
			
			TipoEnfermedadLogicAdditional.checkTipoEnfermedadToSave(this.tipoenfermedad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoEnfermedadLogicAdditional.updateTipoEnfermedadToSave(this.tipoenfermedad,this.arrDatoGeneral);
			
			TipoEnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoenfermedad,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoEnfermedad();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoEnfermedad(this.tipoenfermedad)) {
				TipoEnfermedadDataAccess.save(this.tipoenfermedad, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoenfermedad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoEnfermedadLogicAdditional.checkTipoEnfermedadToSaveAfter(this.tipoenfermedad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoEnfermedad();
			
			connexion.commit();			
			
			if(this.tipoenfermedad.getIsDeleted()) {
				this.tipoenfermedad=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoEnfermedad()throws Exception {	
		try {	
			
			TipoEnfermedadLogicAdditional.checkTipoEnfermedadToSave(this.tipoenfermedad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoEnfermedadLogicAdditional.updateTipoEnfermedadToSave(this.tipoenfermedad,this.arrDatoGeneral);
			
			TipoEnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoenfermedad,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoEnfermedad(this.tipoenfermedad)) {			
				TipoEnfermedadDataAccess.save(this.tipoenfermedad, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoenfermedad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoEnfermedadLogicAdditional.checkTipoEnfermedadToSaveAfter(this.tipoenfermedad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoenfermedad.getIsDeleted()) {
				this.tipoenfermedad=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoEnfermedadsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEnfermedad.class.getSimpleName()+"-saveTipoEnfermedadsWithConnection");connexion.begin();			
			
			TipoEnfermedadLogicAdditional.checkTipoEnfermedadToSaves(tipoenfermedads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoEnfermedads();
			
			Boolean validadoTodosTipoEnfermedad=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoEnfermedad tipoenfermedadLocal:tipoenfermedads) {		
				if(tipoenfermedadLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoEnfermedadLogicAdditional.updateTipoEnfermedadToSave(tipoenfermedadLocal,this.arrDatoGeneral);
	        	
				TipoEnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoenfermedadLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoEnfermedad(tipoenfermedadLocal)) {
					TipoEnfermedadDataAccess.save(tipoenfermedadLocal, connexion);				
				} else {
					validadoTodosTipoEnfermedad=false;
				}
			}
			
			if(!validadoTodosTipoEnfermedad) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoEnfermedadLogicAdditional.checkTipoEnfermedadToSavesAfter(tipoenfermedads,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoEnfermedads();
			
			connexion.commit();		
			
			this.quitarTipoEnfermedadsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoEnfermedads()throws Exception {				
		 try {	
			TipoEnfermedadLogicAdditional.checkTipoEnfermedadToSaves(tipoenfermedads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoEnfermedad=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoEnfermedad tipoenfermedadLocal:tipoenfermedads) {				
				if(tipoenfermedadLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoEnfermedadLogicAdditional.updateTipoEnfermedadToSave(tipoenfermedadLocal,this.arrDatoGeneral);
	        	
				TipoEnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoenfermedadLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoEnfermedad(tipoenfermedadLocal)) {				
					TipoEnfermedadDataAccess.save(tipoenfermedadLocal, connexion);				
				} else {
					validadoTodosTipoEnfermedad=false;
				}
			}
			
			if(!validadoTodosTipoEnfermedad) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoEnfermedadLogicAdditional.checkTipoEnfermedadToSavesAfter(tipoenfermedads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoEnfermedadsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoEnfermedadParameterReturnGeneral procesarAccionTipoEnfermedads(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoEnfermedad> tipoenfermedads,TipoEnfermedadParameterReturnGeneral tipoenfermedadParameterGeneral)throws Exception {
		 try {	
			TipoEnfermedadParameterReturnGeneral tipoenfermedadReturnGeneral=new TipoEnfermedadParameterReturnGeneral();
	
			TipoEnfermedadLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoenfermedads,tipoenfermedadParameterGeneral,tipoenfermedadReturnGeneral);
			
			return tipoenfermedadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoEnfermedadParameterReturnGeneral procesarAccionTipoEnfermedadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoEnfermedad> tipoenfermedads,TipoEnfermedadParameterReturnGeneral tipoenfermedadParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEnfermedad.class.getSimpleName()+"-procesarAccionTipoEnfermedadsWithConnection");connexion.begin();			
			
			TipoEnfermedadParameterReturnGeneral tipoenfermedadReturnGeneral=new TipoEnfermedadParameterReturnGeneral();
	
			TipoEnfermedadLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoenfermedads,tipoenfermedadParameterGeneral,tipoenfermedadReturnGeneral);
			
			this.connexion.commit();
			
			return tipoenfermedadReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoEnfermedadParameterReturnGeneral procesarEventosTipoEnfermedads(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoEnfermedad> tipoenfermedads,TipoEnfermedad tipoenfermedad,TipoEnfermedadParameterReturnGeneral tipoenfermedadParameterGeneral,Boolean isEsNuevoTipoEnfermedad,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoEnfermedadParameterReturnGeneral tipoenfermedadReturnGeneral=new TipoEnfermedadParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoenfermedadReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoEnfermedadLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoenfermedads,tipoenfermedad,tipoenfermedadParameterGeneral,tipoenfermedadReturnGeneral,isEsNuevoTipoEnfermedad,clases);
			
			return tipoenfermedadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoEnfermedadParameterReturnGeneral procesarEventosTipoEnfermedadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoEnfermedad> tipoenfermedads,TipoEnfermedad tipoenfermedad,TipoEnfermedadParameterReturnGeneral tipoenfermedadParameterGeneral,Boolean isEsNuevoTipoEnfermedad,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEnfermedad.class.getSimpleName()+"-procesarEventosTipoEnfermedadsWithConnection");connexion.begin();			
			
			TipoEnfermedadParameterReturnGeneral tipoenfermedadReturnGeneral=new TipoEnfermedadParameterReturnGeneral();
	
			tipoenfermedadReturnGeneral.setTipoEnfermedad(tipoenfermedad);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoenfermedadReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoEnfermedadLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoenfermedads,tipoenfermedad,tipoenfermedadParameterGeneral,tipoenfermedadReturnGeneral,isEsNuevoTipoEnfermedad,clases);
			
			this.connexion.commit();
			
			return tipoenfermedadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoEnfermedadParameterReturnGeneral procesarImportacionTipoEnfermedadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoEnfermedadParameterReturnGeneral tipoenfermedadParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEnfermedad.class.getSimpleName()+"-procesarImportacionTipoEnfermedadsWithConnection");connexion.begin();			
			
			TipoEnfermedadParameterReturnGeneral tipoenfermedadReturnGeneral=new TipoEnfermedadParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoenfermedads=new ArrayList<TipoEnfermedad>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoenfermedad=new TipoEnfermedad();
				
				
				if(conColumnasBase) {this.tipoenfermedad.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoenfermedad.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoenfermedad.setcodigo(arrColumnas[iColumn++]);
				this.tipoenfermedad.setnombre(arrColumnas[iColumn++]);
				
				this.tipoenfermedads.add(this.tipoenfermedad);
			}
			
			this.saveTipoEnfermedads();
			
			this.connexion.commit();
			
			tipoenfermedadReturnGeneral.setConRetornoEstaProcesado(true);
			tipoenfermedadReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoenfermedadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoEnfermedadsEliminados() throws Exception {				
		
		List<TipoEnfermedad> tipoenfermedadsAux= new ArrayList<TipoEnfermedad>();
		
		for(TipoEnfermedad tipoenfermedad:tipoenfermedads) {
			if(!tipoenfermedad.getIsDeleted()) {
				tipoenfermedadsAux.add(tipoenfermedad);
			}
		}
		
		tipoenfermedads=tipoenfermedadsAux;
	}
	
	public void quitarTipoEnfermedadsNulos() throws Exception {				
		
		List<TipoEnfermedad> tipoenfermedadsAux= new ArrayList<TipoEnfermedad>();
		
		for(TipoEnfermedad tipoenfermedad : this.tipoenfermedads) {
			if(tipoenfermedad==null) {
				tipoenfermedadsAux.add(tipoenfermedad);
			}
		}
		
		//this.tipoenfermedads=tipoenfermedadsAux;
		
		this.tipoenfermedads.removeAll(tipoenfermedadsAux);
	}
	
	public void getSetVersionRowTipoEnfermedadWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoenfermedad.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoenfermedad.getIsDeleted() || (tipoenfermedad.getIsChanged()&&!tipoenfermedad.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoenfermedadDataAccess.getSetVersionRowTipoEnfermedad(connexion,tipoenfermedad.getId());
				
				if(!tipoenfermedad.getVersionRow().equals(timestamp)) {	
					tipoenfermedad.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoenfermedad.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoEnfermedad()throws Exception {	
		
		if(tipoenfermedad.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoenfermedad.getIsDeleted() || (tipoenfermedad.getIsChanged()&&!tipoenfermedad.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoenfermedadDataAccess.getSetVersionRowTipoEnfermedad(connexion,tipoenfermedad.getId());
			
			try {							
				if(!tipoenfermedad.getVersionRow().equals(timestamp)) {	
					tipoenfermedad.setVersionRow(timestamp);
				}
				
				tipoenfermedad.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoEnfermedadsWithConnection()throws Exception {	
		if(tipoenfermedads!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoEnfermedad tipoenfermedadAux:tipoenfermedads) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoenfermedadAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoenfermedadAux.getIsDeleted() || (tipoenfermedadAux.getIsChanged()&&!tipoenfermedadAux.getIsNew())) {
						
						timestamp=tipoenfermedadDataAccess.getSetVersionRowTipoEnfermedad(connexion,tipoenfermedadAux.getId());
						
						if(!tipoenfermedad.getVersionRow().equals(timestamp)) {	
							tipoenfermedadAux.setVersionRow(timestamp);
						}
								
						tipoenfermedadAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoEnfermedads()throws Exception {	
		if(tipoenfermedads!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoEnfermedad tipoenfermedadAux:tipoenfermedads) {
					if(tipoenfermedadAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoenfermedadAux.getIsDeleted() || (tipoenfermedadAux.getIsChanged()&&!tipoenfermedadAux.getIsNew())) {
						
						timestamp=tipoenfermedadDataAccess.getSetVersionRowTipoEnfermedad(connexion,tipoenfermedadAux.getId());
						
						if(!tipoenfermedadAux.getVersionRow().equals(timestamp)) {	
							tipoenfermedadAux.setVersionRow(timestamp);
						}
						
													
						tipoenfermedadAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoEnfermedadParameterReturnGeneral cargarCombosLoteForeignKeyTipoEnfermedadWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoEnfermedadParameterReturnGeneral  tipoenfermedadReturnGeneral =new TipoEnfermedadParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEnfermedad.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoEnfermedadWithConnection");connexion.begin();
			
			tipoenfermedadReturnGeneral =new TipoEnfermedadParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoenfermedadReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipoenfermedadReturnGeneral;
	}
	
	public TipoEnfermedadParameterReturnGeneral cargarCombosLoteForeignKeyTipoEnfermedad(String finalQueryGlobalEmpresa) throws Exception {
		TipoEnfermedadParameterReturnGeneral  tipoenfermedadReturnGeneral =new TipoEnfermedadParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipoenfermedadReturnGeneral =new TipoEnfermedadParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoenfermedadReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipoenfermedadReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoEnfermedadWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			EnfermedadLogic enfermedadLogic=new EnfermedadLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEnfermedad.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoEnfermedadWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Enfermedad.class));
											
			

			enfermedadLogic.setConnexion(this.getConnexion());
			enfermedadLogic.setDatosCliente(this.datosCliente);
			enfermedadLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoEnfermedad tipoenfermedad:this.tipoenfermedads) {
				

				classes=new ArrayList<Classe>();
				classes=EnfermedadConstantesFunciones.getClassesForeignKeysOfEnfermedad(new ArrayList<Classe>(),DeepLoadType.NONE);

				enfermedadLogic.setEnfermedads(tipoenfermedad.enfermedads);
				enfermedadLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoEnfermedad tipoenfermedad,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoEnfermedadLogicAdditional.updateTipoEnfermedadToGet(tipoenfermedad,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoenfermedad.setEmpresa(tipoenfermedadDataAccess.getEmpresa(connexion,tipoenfermedad));
		tipoenfermedad.setEnfermedads(tipoenfermedadDataAccess.getEnfermedads(connexion,tipoenfermedad));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoenfermedad.setEmpresa(tipoenfermedadDataAccess.getEmpresa(connexion,tipoenfermedad));
				continue;
			}

			if(clas.clas.equals(Enfermedad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoenfermedad.setEnfermedads(tipoenfermedadDataAccess.getEnfermedads(connexion,tipoenfermedad));

				if(this.isConDeep) {
					EnfermedadLogic enfermedadLogic= new EnfermedadLogic(this.connexion);
					enfermedadLogic.setEnfermedads(tipoenfermedad.getEnfermedads());
					ArrayList<Classe> classesLocal=EnfermedadConstantesFunciones.getClassesForeignKeysOfEnfermedad(new ArrayList<Classe>(),DeepLoadType.NONE);
					enfermedadLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesEnfermedad(enfermedadLogic.getEnfermedads());
					tipoenfermedad.setEnfermedads(enfermedadLogic.getEnfermedads());
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
			tipoenfermedad.setEmpresa(tipoenfermedadDataAccess.getEmpresa(connexion,tipoenfermedad));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Enfermedad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Enfermedad.class));
			tipoenfermedad.setEnfermedads(tipoenfermedadDataAccess.getEnfermedads(connexion,tipoenfermedad));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoenfermedad.setEmpresa(tipoenfermedadDataAccess.getEmpresa(connexion,tipoenfermedad));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoenfermedad.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipoenfermedad.setEnfermedads(tipoenfermedadDataAccess.getEnfermedads(connexion,tipoenfermedad));

		for(Enfermedad enfermedad:tipoenfermedad.getEnfermedads()) {
			EnfermedadLogic enfermedadLogic= new EnfermedadLogic(connexion);
			enfermedadLogic.deepLoad(enfermedad,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoenfermedad.setEmpresa(tipoenfermedadDataAccess.getEmpresa(connexion,tipoenfermedad));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipoenfermedad.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Enfermedad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoenfermedad.setEnfermedads(tipoenfermedadDataAccess.getEnfermedads(connexion,tipoenfermedad));

				for(Enfermedad enfermedad:tipoenfermedad.getEnfermedads()) {
					EnfermedadLogic enfermedadLogic= new EnfermedadLogic(connexion);
					enfermedadLogic.deepLoad(enfermedad,isDeep,deepLoadType,clases);
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
			tipoenfermedad.setEmpresa(tipoenfermedadDataAccess.getEmpresa(connexion,tipoenfermedad));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipoenfermedad.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Enfermedad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Enfermedad.class));
			tipoenfermedad.setEnfermedads(tipoenfermedadDataAccess.getEnfermedads(connexion,tipoenfermedad));

			for(Enfermedad enfermedad:tipoenfermedad.getEnfermedads()) {
				EnfermedadLogic enfermedadLogic= new EnfermedadLogic(connexion);
				enfermedadLogic.deepLoad(enfermedad,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoEnfermedad tipoenfermedad,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoEnfermedadLogicAdditional.updateTipoEnfermedadToSave(tipoenfermedad,this.arrDatoGeneral);
			
TipoEnfermedadDataAccess.save(tipoenfermedad, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoenfermedad.getEmpresa(),connexion);

		for(Enfermedad enfermedad:tipoenfermedad.getEnfermedads()) {
			enfermedad.setid_tipo_enfermedad(tipoenfermedad.getId());
			EnfermedadDataAccess.save(enfermedad,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoenfermedad.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(Enfermedad.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Enfermedad enfermedad:tipoenfermedad.getEnfermedads()) {
					enfermedad.setid_tipo_enfermedad(tipoenfermedad.getId());
					EnfermedadDataAccess.save(enfermedad,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoenfermedad.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoenfermedad.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(Enfermedad enfermedad:tipoenfermedad.getEnfermedads()) {
			EnfermedadLogic enfermedadLogic= new EnfermedadLogic(connexion);
			enfermedad.setid_tipo_enfermedad(tipoenfermedad.getId());
			EnfermedadDataAccess.save(enfermedad,connexion);
			enfermedadLogic.deepSave(enfermedad,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoenfermedad.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipoenfermedad.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Enfermedad.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Enfermedad enfermedad:tipoenfermedad.getEnfermedads()) {
					EnfermedadLogic enfermedadLogic= new EnfermedadLogic(connexion);
					enfermedad.setid_tipo_enfermedad(tipoenfermedad.getId());
					EnfermedadDataAccess.save(enfermedad,connexion);
					enfermedadLogic.deepSave(enfermedad,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoEnfermedad.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoenfermedad,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoEnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesTipoEnfermedad(tipoenfermedad);
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
			this.deepLoad(this.tipoenfermedad,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoEnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesTipoEnfermedad(this.tipoenfermedad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoEnfermedad.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoenfermedads!=null) {
				for(TipoEnfermedad tipoenfermedad:tipoenfermedads) {
					this.deepLoad(tipoenfermedad,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoEnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesTipoEnfermedad(tipoenfermedads);
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
			if(tipoenfermedads!=null) {
				for(TipoEnfermedad tipoenfermedad:tipoenfermedads) {
					this.deepLoad(tipoenfermedad,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoEnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesTipoEnfermedad(tipoenfermedads);
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
			this.getNewConnexionToDeep(TipoEnfermedad.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipoenfermedad,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoEnfermedad.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipoenfermedads!=null) {
				for(TipoEnfermedad tipoenfermedad:tipoenfermedads) {
					this.deepSave(tipoenfermedad,isDeep,deepLoadType,clases);
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
			if(tipoenfermedads!=null) {
				for(TipoEnfermedad tipoenfermedad:tipoenfermedads) {
					this.deepSave(tipoenfermedad,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoEnfermedadsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEnfermedad.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoEnfermedadConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoEnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoenfermedads=tipoenfermedadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoEnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesTipoEnfermedad(this.tipoenfermedads);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoEnfermedadsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoEnfermedadConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoEnfermedadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoenfermedads=tipoenfermedadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoEnfermedadConstantesFunciones.refrescarForeignKeysDescripcionesTipoEnfermedad(this.tipoenfermedads);
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
			if(TipoEnfermedadConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoEnfermedadDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoEnfermedad tipoenfermedad,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoEnfermedadConstantesFunciones.ISCONAUDITORIA) {
				if(tipoenfermedad.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoEnfermedadDataAccess.TABLENAME, tipoenfermedad.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoEnfermedadConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoEnfermedadLogic.registrarAuditoriaDetallesTipoEnfermedad(connexion,tipoenfermedad,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoenfermedad.getIsDeleted()) {
					/*if(!tipoenfermedad.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoEnfermedadDataAccess.TABLENAME, tipoenfermedad.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoEnfermedadLogic.registrarAuditoriaDetallesTipoEnfermedad(connexion,tipoenfermedad,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoEnfermedadDataAccess.TABLENAME, tipoenfermedad.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoenfermedad.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoEnfermedadDataAccess.TABLENAME, tipoenfermedad.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoEnfermedadConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoEnfermedadLogic.registrarAuditoriaDetallesTipoEnfermedad(connexion,tipoenfermedad,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoEnfermedad(Connexion connexion,TipoEnfermedad tipoenfermedad)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoenfermedad.getIsNew()||!tipoenfermedad.getid_empresa().equals(tipoenfermedad.getTipoEnfermedadOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoenfermedad.getTipoEnfermedadOriginal().getid_empresa()!=null)
				{
					strValorActual=tipoenfermedad.getTipoEnfermedadOriginal().getid_empresa().toString();
				}
				if(tipoenfermedad.getid_empresa()!=null)
				{
					strValorNuevo=tipoenfermedad.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoEnfermedadConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipoenfermedad.getIsNew()||!tipoenfermedad.getcodigo().equals(tipoenfermedad.getTipoEnfermedadOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoenfermedad.getTipoEnfermedadOriginal().getcodigo()!=null)
				{
					strValorActual=tipoenfermedad.getTipoEnfermedadOriginal().getcodigo();
				}
				if(tipoenfermedad.getcodigo()!=null)
				{
					strValorNuevo=tipoenfermedad.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoEnfermedadConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoenfermedad.getIsNew()||!tipoenfermedad.getnombre().equals(tipoenfermedad.getTipoEnfermedadOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoenfermedad.getTipoEnfermedadOriginal().getnombre()!=null)
				{
					strValorActual=tipoenfermedad.getTipoEnfermedadOriginal().getnombre();
				}
				if(tipoenfermedad.getnombre()!=null)
				{
					strValorNuevo=tipoenfermedad.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoEnfermedadConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoEnfermedadRelacionesWithConnection(TipoEnfermedad tipoenfermedad,List<Enfermedad> enfermedads) throws Exception {

		if(!tipoenfermedad.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoEnfermedadRelacionesBase(tipoenfermedad,enfermedads,true);
		}
	}

	public void saveTipoEnfermedadRelaciones(TipoEnfermedad tipoenfermedad,List<Enfermedad> enfermedads)throws Exception {

		if(!tipoenfermedad.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoEnfermedadRelacionesBase(tipoenfermedad,enfermedads,false);
		}
	}

	public void saveTipoEnfermedadRelacionesBase(TipoEnfermedad tipoenfermedad,List<Enfermedad> enfermedads,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoEnfermedad-saveRelacionesWithConnection");}
	
			tipoenfermedad.setEnfermedads(enfermedads);

			this.setTipoEnfermedad(tipoenfermedad);

			if(TipoEnfermedadLogicAdditional.validarSaveRelaciones(tipoenfermedad,this)) {

				TipoEnfermedadLogicAdditional.updateRelacionesToSave(tipoenfermedad,this);

				if((tipoenfermedad.getIsNew()||tipoenfermedad.getIsChanged())&&!tipoenfermedad.getIsDeleted()) {
					this.saveTipoEnfermedad();
					this.saveTipoEnfermedadRelacionesDetalles(enfermedads);

				} else if(tipoenfermedad.getIsDeleted()) {
					this.saveTipoEnfermedadRelacionesDetalles(enfermedads);
					this.saveTipoEnfermedad();
				}

				TipoEnfermedadLogicAdditional.updateRelacionesToSaveAfter(tipoenfermedad,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			EnfermedadConstantesFunciones.InicializarGeneralEntityAuxiliaresEnfermedads(enfermedads,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoEnfermedadRelacionesDetalles(List<Enfermedad> enfermedads)throws Exception {
		try {
	

			Long idTipoEnfermedadActual=this.getTipoEnfermedad().getId();

			EnfermedadLogic enfermedadLogic_Desde_TipoEnfermedad=new EnfermedadLogic();
			enfermedadLogic_Desde_TipoEnfermedad.setEnfermedads(enfermedads);

			enfermedadLogic_Desde_TipoEnfermedad.setConnexion(this.getConnexion());
			enfermedadLogic_Desde_TipoEnfermedad.setDatosCliente(this.datosCliente);

			for(Enfermedad enfermedad_Desde_TipoEnfermedad:enfermedadLogic_Desde_TipoEnfermedad.getEnfermedads()) {
				enfermedad_Desde_TipoEnfermedad.setid_tipo_enfermedad(idTipoEnfermedadActual);

				enfermedadLogic_Desde_TipoEnfermedad.setEnfermedad(enfermedad_Desde_TipoEnfermedad);
				enfermedadLogic_Desde_TipoEnfermedad.saveEnfermedad();

				Long idEnfermedadActual=enfermedad_Desde_TipoEnfermedad.getId();

				EmpleadoEnferLogic empleadoenferLogic_Desde_Enfermedad=new EmpleadoEnferLogic();

				if(enfermedad_Desde_TipoEnfermedad.getEmpleadoEnfers()==null){
					enfermedad_Desde_TipoEnfermedad.setEmpleadoEnfers(new ArrayList<EmpleadoEnfer>());
				}

				empleadoenferLogic_Desde_Enfermedad.setEmpleadoEnfers(enfermedad_Desde_TipoEnfermedad.getEmpleadoEnfers());

				empleadoenferLogic_Desde_Enfermedad.setConnexion(this.getConnexion());
				empleadoenferLogic_Desde_Enfermedad.setDatosCliente(this.datosCliente);

				for(EmpleadoEnfer empleadoenfer_Desde_Enfermedad:empleadoenferLogic_Desde_Enfermedad.getEmpleadoEnfers()) {
					empleadoenfer_Desde_Enfermedad.setid_enfermedad(idEnfermedadActual);
				}

				empleadoenferLogic_Desde_Enfermedad.saveEmpleadoEnfers();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoEnfermedad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoEnfermedadConstantesFunciones.getClassesForeignKeysOfTipoEnfermedad(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoEnfermedad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoEnfermedadConstantesFunciones.getClassesRelationshipsOfTipoEnfermedad(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
