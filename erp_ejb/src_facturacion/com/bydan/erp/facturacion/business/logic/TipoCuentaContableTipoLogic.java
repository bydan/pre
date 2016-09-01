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
package com.bydan.erp.facturacion.business.logic;

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
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.facturacion.util.TipoCuentaContableTipoConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoCuentaContableTipoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoCuentaContableTipoParameterGeneral;
import com.bydan.erp.facturacion.business.entity.TipoCuentaContableTipo;
import com.bydan.erp.facturacion.business.logic.TipoCuentaContableTipoLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class TipoCuentaContableTipoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoCuentaContableTipoLogic.class);
	
	protected TipoCuentaContableTipoDataAccess tipocuentacontabletipoDataAccess; 	
	protected TipoCuentaContableTipo tipocuentacontabletipo;
	protected List<TipoCuentaContableTipo> tipocuentacontabletipos;
	protected Object tipocuentacontabletipoObject;	
	protected List<Object> tipocuentacontabletiposObject;
	
	public static ClassValidator<TipoCuentaContableTipo> tipocuentacontabletipoValidator = new ClassValidator<TipoCuentaContableTipo>(TipoCuentaContableTipo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoCuentaContableTipoLogicAdditional tipocuentacontabletipoLogicAdditional=null;
	
	public TipoCuentaContableTipoLogicAdditional getTipoCuentaContableTipoLogicAdditional() {
		return this.tipocuentacontabletipoLogicAdditional;
	}
	
	public void setTipoCuentaContableTipoLogicAdditional(TipoCuentaContableTipoLogicAdditional tipocuentacontabletipoLogicAdditional) {
		try {
			this.tipocuentacontabletipoLogicAdditional=tipocuentacontabletipoLogicAdditional;
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
	
	
	
	
	public  TipoCuentaContableTipoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipocuentacontabletipoDataAccess = new TipoCuentaContableTipoDataAccess();
			
			this.tipocuentacontabletipos= new ArrayList<TipoCuentaContableTipo>();
			this.tipocuentacontabletipo= new TipoCuentaContableTipo();
			
			this.tipocuentacontabletipoObject=new Object();
			this.tipocuentacontabletiposObject=new ArrayList<Object>();
				
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
			
			this.tipocuentacontabletipoDataAccess.setConnexionType(this.connexionType);
			this.tipocuentacontabletipoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoCuentaContableTipoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipocuentacontabletipoDataAccess = new TipoCuentaContableTipoDataAccess();
			this.tipocuentacontabletipos= new ArrayList<TipoCuentaContableTipo>();
			this.tipocuentacontabletipo= new TipoCuentaContableTipo();
			this.tipocuentacontabletipoObject=new Object();
			this.tipocuentacontabletiposObject=new ArrayList<Object>();
			
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
			
			this.tipocuentacontabletipoDataAccess.setConnexionType(this.connexionType);
			this.tipocuentacontabletipoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoCuentaContableTipo getTipoCuentaContableTipo() throws Exception {	
		TipoCuentaContableTipoLogicAdditional.checkTipoCuentaContableTipoToGet(tipocuentacontabletipo,this.datosCliente,this.arrDatoGeneral);
		TipoCuentaContableTipoLogicAdditional.updateTipoCuentaContableTipoToGet(tipocuentacontabletipo,this.arrDatoGeneral);
		
		return tipocuentacontabletipo;
	}
		
	public void setTipoCuentaContableTipo(TipoCuentaContableTipo newTipoCuentaContableTipo) {
		this.tipocuentacontabletipo = newTipoCuentaContableTipo;
	}
	
	public TipoCuentaContableTipoDataAccess getTipoCuentaContableTipoDataAccess() {
		return tipocuentacontabletipoDataAccess;
	}
	
	public void setTipoCuentaContableTipoDataAccess(TipoCuentaContableTipoDataAccess newtipocuentacontabletipoDataAccess) {
		this.tipocuentacontabletipoDataAccess = newtipocuentacontabletipoDataAccess;
	}
	
	public List<TipoCuentaContableTipo> getTipoCuentaContableTipos() throws Exception {		
		this.quitarTipoCuentaContableTiposNulos();
		
		TipoCuentaContableTipoLogicAdditional.checkTipoCuentaContableTipoToGets(tipocuentacontabletipos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoCuentaContableTipo tipocuentacontabletipoLocal: tipocuentacontabletipos ) {
			TipoCuentaContableTipoLogicAdditional.updateTipoCuentaContableTipoToGet(tipocuentacontabletipoLocal,this.arrDatoGeneral);
		}
		
		return tipocuentacontabletipos;
	}
	
	public void setTipoCuentaContableTipos(List<TipoCuentaContableTipo> newTipoCuentaContableTipos) {
		this.tipocuentacontabletipos = newTipoCuentaContableTipos;
	}
	
	public Object getTipoCuentaContableTipoObject() {	
		this.tipocuentacontabletipoObject=this.tipocuentacontabletipoDataAccess.getEntityObject();
		return this.tipocuentacontabletipoObject;
	}
		
	public void setTipoCuentaContableTipoObject(Object newTipoCuentaContableTipoObject) {
		this.tipocuentacontabletipoObject = newTipoCuentaContableTipoObject;
	}
	
	public List<Object> getTipoCuentaContableTiposObject() {		
		this.tipocuentacontabletiposObject=this.tipocuentacontabletipoDataAccess.getEntitiesObject();
		return this.tipocuentacontabletiposObject;
	}
		
	public void setTipoCuentaContableTiposObject(List<Object> newTipoCuentaContableTiposObject) {
		this.tipocuentacontabletiposObject = newTipoCuentaContableTiposObject;
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
		
		if(this.tipocuentacontabletipoDataAccess!=null) {
			this.tipocuentacontabletipoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaContableTipo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipocuentacontabletipoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipocuentacontabletipoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipocuentacontabletipo = new  TipoCuentaContableTipo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaContableTipo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocuentacontabletipo=tipocuentacontabletipoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocuentacontabletipo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaContableTipo(this.tipocuentacontabletipo);
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
		tipocuentacontabletipo = new  TipoCuentaContableTipo();
		  		  
        try {
			
			tipocuentacontabletipo=tipocuentacontabletipoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocuentacontabletipo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaContableTipo(this.tipocuentacontabletipo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipocuentacontabletipo = new  TipoCuentaContableTipo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaContableTipo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocuentacontabletipo=tipocuentacontabletipoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocuentacontabletipo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaContableTipo(this.tipocuentacontabletipo);
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
		tipocuentacontabletipo = new  TipoCuentaContableTipo();
		  		  
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
		tipocuentacontabletipo = new  TipoCuentaContableTipo();
		  		  
        try {
			
			tipocuentacontabletipo=tipocuentacontabletipoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocuentacontabletipo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaContableTipo(this.tipocuentacontabletipo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipocuentacontabletipo = new  TipoCuentaContableTipo();
		  		  
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
		tipocuentacontabletipo = new  TipoCuentaContableTipo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaContableTipo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipocuentacontabletipoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocuentacontabletipo = new  TipoCuentaContableTipo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipocuentacontabletipoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocuentacontabletipo = new  TipoCuentaContableTipo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaContableTipo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipocuentacontabletipoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocuentacontabletipo = new  TipoCuentaContableTipo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipocuentacontabletipoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocuentacontabletipo = new  TipoCuentaContableTipo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaContableTipo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipocuentacontabletipoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocuentacontabletipo = new  TipoCuentaContableTipo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipocuentacontabletipoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipocuentacontabletipos = new  ArrayList<TipoCuentaContableTipo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaContableTipo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoCuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentacontabletipos=tipocuentacontabletipoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCuentaContableTipo(tipocuentacontabletipos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaContableTipo(this.tipocuentacontabletipos);
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
		tipocuentacontabletipos = new  ArrayList<TipoCuentaContableTipo>();
		  		  
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
		tipocuentacontabletipos = new  ArrayList<TipoCuentaContableTipo>();
		  		  
        try {			
			TipoCuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentacontabletipos=tipocuentacontabletipoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoCuentaContableTipo(tipocuentacontabletipos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaContableTipo(this.tipocuentacontabletipos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipocuentacontabletipos = new  ArrayList<TipoCuentaContableTipo>();
		  		  
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
		tipocuentacontabletipos = new  ArrayList<TipoCuentaContableTipo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaContableTipo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoCuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentacontabletipos=tipocuentacontabletipoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCuentaContableTipo(tipocuentacontabletipos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaContableTipo(this.tipocuentacontabletipos);
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
		tipocuentacontabletipos = new  ArrayList<TipoCuentaContableTipo>();
		  		  
        try {
			TipoCuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentacontabletipos=tipocuentacontabletipoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCuentaContableTipo(tipocuentacontabletipos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaContableTipo(this.tipocuentacontabletipos);
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
		tipocuentacontabletipos = new  ArrayList<TipoCuentaContableTipo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaContableTipo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentacontabletipos=tipocuentacontabletipoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCuentaContableTipo(tipocuentacontabletipos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaContableTipo(this.tipocuentacontabletipos);
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
		tipocuentacontabletipos = new  ArrayList<TipoCuentaContableTipo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentacontabletipos=tipocuentacontabletipoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCuentaContableTipo(tipocuentacontabletipos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaContableTipo(this.tipocuentacontabletipos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipocuentacontabletipo = new  TipoCuentaContableTipo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaContableTipo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentacontabletipo=tipocuentacontabletipoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCuentaContableTipo(tipocuentacontabletipo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaContableTipo(this.tipocuentacontabletipo);
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
		tipocuentacontabletipo = new  TipoCuentaContableTipo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentacontabletipo=tipocuentacontabletipoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCuentaContableTipo(tipocuentacontabletipo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaContableTipo(this.tipocuentacontabletipo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipocuentacontabletipos = new  ArrayList<TipoCuentaContableTipo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaContableTipo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoCuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentacontabletipos=tipocuentacontabletipoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCuentaContableTipo(tipocuentacontabletipos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaContableTipo(this.tipocuentacontabletipos);
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
		tipocuentacontabletipos = new  ArrayList<TipoCuentaContableTipo>();
		  		  
        try {
			TipoCuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentacontabletipos=tipocuentacontabletipoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCuentaContableTipo(tipocuentacontabletipos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaContableTipo(this.tipocuentacontabletipos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoCuentaContableTiposWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipocuentacontabletipos = new  ArrayList<TipoCuentaContableTipo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaContableTipo.class.getSimpleName()+"-getTodosTipoCuentaContableTiposWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentacontabletipos=tipocuentacontabletipoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoCuentaContableTipo(tipocuentacontabletipos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaContableTipo(this.tipocuentacontabletipos);
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
	
	public  void  getTodosTipoCuentaContableTipos(String sFinalQuery,Pagination pagination)throws Exception {
		tipocuentacontabletipos = new  ArrayList<TipoCuentaContableTipo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentacontabletipos=tipocuentacontabletipoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoCuentaContableTipo(tipocuentacontabletipos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaContableTipo(this.tipocuentacontabletipos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoCuentaContableTipo(TipoCuentaContableTipo tipocuentacontabletipo) throws Exception {
		Boolean estaValidado=false;
		
		if(tipocuentacontabletipo.getIsNew() || tipocuentacontabletipo.getIsChanged()) { 
			this.invalidValues = tipocuentacontabletipoValidator.getInvalidValues(tipocuentacontabletipo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipocuentacontabletipo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoCuentaContableTipo(List<TipoCuentaContableTipo> TipoCuentaContableTipos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoCuentaContableTipo tipocuentacontabletipoLocal:tipocuentacontabletipos) {				
			estaValidadoObjeto=this.validarGuardarTipoCuentaContableTipo(tipocuentacontabletipoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoCuentaContableTipo(List<TipoCuentaContableTipo> TipoCuentaContableTipos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoCuentaContableTipo(tipocuentacontabletipos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoCuentaContableTipo(TipoCuentaContableTipo TipoCuentaContableTipo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoCuentaContableTipo(tipocuentacontabletipo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoCuentaContableTipo tipocuentacontabletipo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipocuentacontabletipo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoCuentaContableTipoConstantesFunciones.getTipoCuentaContableTipoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipocuentacontabletipo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoCuentaContableTipoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoCuentaContableTipoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoCuentaContableTipoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaContableTipo.class.getSimpleName()+"-saveTipoCuentaContableTipoWithConnection");connexion.begin();			
			
			TipoCuentaContableTipoLogicAdditional.checkTipoCuentaContableTipoToSave(this.tipocuentacontabletipo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoCuentaContableTipoLogicAdditional.updateTipoCuentaContableTipoToSave(this.tipocuentacontabletipo,this.arrDatoGeneral);
			
			TipoCuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocuentacontabletipo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoCuentaContableTipo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoCuentaContableTipo(this.tipocuentacontabletipo)) {
				TipoCuentaContableTipoDataAccess.save(this.tipocuentacontabletipo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipocuentacontabletipo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoCuentaContableTipoLogicAdditional.checkTipoCuentaContableTipoToSaveAfter(this.tipocuentacontabletipo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoCuentaContableTipo();
			
			connexion.commit();			
			
			if(this.tipocuentacontabletipo.getIsDeleted()) {
				this.tipocuentacontabletipo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoCuentaContableTipo()throws Exception {	
		try {	
			
			TipoCuentaContableTipoLogicAdditional.checkTipoCuentaContableTipoToSave(this.tipocuentacontabletipo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoCuentaContableTipoLogicAdditional.updateTipoCuentaContableTipoToSave(this.tipocuentacontabletipo,this.arrDatoGeneral);
			
			TipoCuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocuentacontabletipo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoCuentaContableTipo(this.tipocuentacontabletipo)) {			
				TipoCuentaContableTipoDataAccess.save(this.tipocuentacontabletipo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipocuentacontabletipo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoCuentaContableTipoLogicAdditional.checkTipoCuentaContableTipoToSaveAfter(this.tipocuentacontabletipo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipocuentacontabletipo.getIsDeleted()) {
				this.tipocuentacontabletipo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoCuentaContableTiposWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaContableTipo.class.getSimpleName()+"-saveTipoCuentaContableTiposWithConnection");connexion.begin();			
			
			TipoCuentaContableTipoLogicAdditional.checkTipoCuentaContableTipoToSaves(tipocuentacontabletipos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoCuentaContableTipos();
			
			Boolean validadoTodosTipoCuentaContableTipo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoCuentaContableTipo tipocuentacontabletipoLocal:tipocuentacontabletipos) {		
				if(tipocuentacontabletipoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoCuentaContableTipoLogicAdditional.updateTipoCuentaContableTipoToSave(tipocuentacontabletipoLocal,this.arrDatoGeneral);
	        	
				TipoCuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocuentacontabletipoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoCuentaContableTipo(tipocuentacontabletipoLocal)) {
					TipoCuentaContableTipoDataAccess.save(tipocuentacontabletipoLocal, connexion);				
				} else {
					validadoTodosTipoCuentaContableTipo=false;
				}
			}
			
			if(!validadoTodosTipoCuentaContableTipo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoCuentaContableTipoLogicAdditional.checkTipoCuentaContableTipoToSavesAfter(tipocuentacontabletipos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoCuentaContableTipos();
			
			connexion.commit();		
			
			this.quitarTipoCuentaContableTiposEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoCuentaContableTipos()throws Exception {				
		 try {	
			TipoCuentaContableTipoLogicAdditional.checkTipoCuentaContableTipoToSaves(tipocuentacontabletipos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoCuentaContableTipo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoCuentaContableTipo tipocuentacontabletipoLocal:tipocuentacontabletipos) {				
				if(tipocuentacontabletipoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoCuentaContableTipoLogicAdditional.updateTipoCuentaContableTipoToSave(tipocuentacontabletipoLocal,this.arrDatoGeneral);
	        	
				TipoCuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocuentacontabletipoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoCuentaContableTipo(tipocuentacontabletipoLocal)) {				
					TipoCuentaContableTipoDataAccess.save(tipocuentacontabletipoLocal, connexion);				
				} else {
					validadoTodosTipoCuentaContableTipo=false;
				}
			}
			
			if(!validadoTodosTipoCuentaContableTipo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoCuentaContableTipoLogicAdditional.checkTipoCuentaContableTipoToSavesAfter(tipocuentacontabletipos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoCuentaContableTiposEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoCuentaContableTipoParameterReturnGeneral procesarAccionTipoCuentaContableTipos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoCuentaContableTipo> tipocuentacontabletipos,TipoCuentaContableTipoParameterReturnGeneral tipocuentacontabletipoParameterGeneral)throws Exception {
		 try {	
			TipoCuentaContableTipoParameterReturnGeneral tipocuentacontabletipoReturnGeneral=new TipoCuentaContableTipoParameterReturnGeneral();
	
			TipoCuentaContableTipoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipocuentacontabletipos,tipocuentacontabletipoParameterGeneral,tipocuentacontabletipoReturnGeneral);
			
			return tipocuentacontabletipoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoCuentaContableTipoParameterReturnGeneral procesarAccionTipoCuentaContableTiposWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoCuentaContableTipo> tipocuentacontabletipos,TipoCuentaContableTipoParameterReturnGeneral tipocuentacontabletipoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaContableTipo.class.getSimpleName()+"-procesarAccionTipoCuentaContableTiposWithConnection");connexion.begin();			
			
			TipoCuentaContableTipoParameterReturnGeneral tipocuentacontabletipoReturnGeneral=new TipoCuentaContableTipoParameterReturnGeneral();
	
			TipoCuentaContableTipoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipocuentacontabletipos,tipocuentacontabletipoParameterGeneral,tipocuentacontabletipoReturnGeneral);
			
			this.connexion.commit();
			
			return tipocuentacontabletipoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoCuentaContableTipoParameterReturnGeneral procesarEventosTipoCuentaContableTipos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoCuentaContableTipo> tipocuentacontabletipos,TipoCuentaContableTipo tipocuentacontabletipo,TipoCuentaContableTipoParameterReturnGeneral tipocuentacontabletipoParameterGeneral,Boolean isEsNuevoTipoCuentaContableTipo,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoCuentaContableTipoParameterReturnGeneral tipocuentacontabletipoReturnGeneral=new TipoCuentaContableTipoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocuentacontabletipoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoCuentaContableTipoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipocuentacontabletipos,tipocuentacontabletipo,tipocuentacontabletipoParameterGeneral,tipocuentacontabletipoReturnGeneral,isEsNuevoTipoCuentaContableTipo,clases);
			
			return tipocuentacontabletipoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoCuentaContableTipoParameterReturnGeneral procesarEventosTipoCuentaContableTiposWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoCuentaContableTipo> tipocuentacontabletipos,TipoCuentaContableTipo tipocuentacontabletipo,TipoCuentaContableTipoParameterReturnGeneral tipocuentacontabletipoParameterGeneral,Boolean isEsNuevoTipoCuentaContableTipo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaContableTipo.class.getSimpleName()+"-procesarEventosTipoCuentaContableTiposWithConnection");connexion.begin();			
			
			TipoCuentaContableTipoParameterReturnGeneral tipocuentacontabletipoReturnGeneral=new TipoCuentaContableTipoParameterReturnGeneral();
	
			tipocuentacontabletipoReturnGeneral.setTipoCuentaContableTipo(tipocuentacontabletipo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocuentacontabletipoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoCuentaContableTipoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipocuentacontabletipos,tipocuentacontabletipo,tipocuentacontabletipoParameterGeneral,tipocuentacontabletipoReturnGeneral,isEsNuevoTipoCuentaContableTipo,clases);
			
			this.connexion.commit();
			
			return tipocuentacontabletipoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoCuentaContableTipoParameterReturnGeneral procesarImportacionTipoCuentaContableTiposWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoCuentaContableTipoParameterReturnGeneral tipocuentacontabletipoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaContableTipo.class.getSimpleName()+"-procesarImportacionTipoCuentaContableTiposWithConnection");connexion.begin();			
			
			TipoCuentaContableTipoParameterReturnGeneral tipocuentacontabletipoReturnGeneral=new TipoCuentaContableTipoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipocuentacontabletipos=new ArrayList<TipoCuentaContableTipo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipocuentacontabletipo=new TipoCuentaContableTipo();
				
				
				if(conColumnasBase) {this.tipocuentacontabletipo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipocuentacontabletipo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipocuentacontabletipo.setnombre(arrColumnas[iColumn++]);
				
				this.tipocuentacontabletipos.add(this.tipocuentacontabletipo);
			}
			
			this.saveTipoCuentaContableTipos();
			
			this.connexion.commit();
			
			tipocuentacontabletipoReturnGeneral.setConRetornoEstaProcesado(true);
			tipocuentacontabletipoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipocuentacontabletipoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoCuentaContableTiposEliminados() throws Exception {				
		
		List<TipoCuentaContableTipo> tipocuentacontabletiposAux= new ArrayList<TipoCuentaContableTipo>();
		
		for(TipoCuentaContableTipo tipocuentacontabletipo:tipocuentacontabletipos) {
			if(!tipocuentacontabletipo.getIsDeleted()) {
				tipocuentacontabletiposAux.add(tipocuentacontabletipo);
			}
		}
		
		tipocuentacontabletipos=tipocuentacontabletiposAux;
	}
	
	public void quitarTipoCuentaContableTiposNulos() throws Exception {				
		
		List<TipoCuentaContableTipo> tipocuentacontabletiposAux= new ArrayList<TipoCuentaContableTipo>();
		
		for(TipoCuentaContableTipo tipocuentacontabletipo : this.tipocuentacontabletipos) {
			if(tipocuentacontabletipo==null) {
				tipocuentacontabletiposAux.add(tipocuentacontabletipo);
			}
		}
		
		//this.tipocuentacontabletipos=tipocuentacontabletiposAux;
		
		this.tipocuentacontabletipos.removeAll(tipocuentacontabletiposAux);
	}
	
	public void getSetVersionRowTipoCuentaContableTipoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipocuentacontabletipo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipocuentacontabletipo.getIsDeleted() || (tipocuentacontabletipo.getIsChanged()&&!tipocuentacontabletipo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipocuentacontabletipoDataAccess.getSetVersionRowTipoCuentaContableTipo(connexion,tipocuentacontabletipo.getId());
				
				if(!tipocuentacontabletipo.getVersionRow().equals(timestamp)) {	
					tipocuentacontabletipo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipocuentacontabletipo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoCuentaContableTipo()throws Exception {	
		
		if(tipocuentacontabletipo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipocuentacontabletipo.getIsDeleted() || (tipocuentacontabletipo.getIsChanged()&&!tipocuentacontabletipo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipocuentacontabletipoDataAccess.getSetVersionRowTipoCuentaContableTipo(connexion,tipocuentacontabletipo.getId());
			
			try {							
				if(!tipocuentacontabletipo.getVersionRow().equals(timestamp)) {	
					tipocuentacontabletipo.setVersionRow(timestamp);
				}
				
				tipocuentacontabletipo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoCuentaContableTiposWithConnection()throws Exception {	
		if(tipocuentacontabletipos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoCuentaContableTipo tipocuentacontabletipoAux:tipocuentacontabletipos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipocuentacontabletipoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocuentacontabletipoAux.getIsDeleted() || (tipocuentacontabletipoAux.getIsChanged()&&!tipocuentacontabletipoAux.getIsNew())) {
						
						timestamp=tipocuentacontabletipoDataAccess.getSetVersionRowTipoCuentaContableTipo(connexion,tipocuentacontabletipoAux.getId());
						
						if(!tipocuentacontabletipo.getVersionRow().equals(timestamp)) {	
							tipocuentacontabletipoAux.setVersionRow(timestamp);
						}
								
						tipocuentacontabletipoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoCuentaContableTipos()throws Exception {	
		if(tipocuentacontabletipos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoCuentaContableTipo tipocuentacontabletipoAux:tipocuentacontabletipos) {
					if(tipocuentacontabletipoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocuentacontabletipoAux.getIsDeleted() || (tipocuentacontabletipoAux.getIsChanged()&&!tipocuentacontabletipoAux.getIsNew())) {
						
						timestamp=tipocuentacontabletipoDataAccess.getSetVersionRowTipoCuentaContableTipo(connexion,tipocuentacontabletipoAux.getId());
						
						if(!tipocuentacontabletipoAux.getVersionRow().equals(timestamp)) {	
							tipocuentacontabletipoAux.setVersionRow(timestamp);
						}
						
													
						tipocuentacontabletipoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoCuentaContableTipoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			CuentaContableTipoLogic cuentacontabletipoLogic=new CuentaContableTipoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaContableTipo.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoCuentaContableTipoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(CuentaContableTipo.class));
											
			

			cuentacontabletipoLogic.setConnexion(this.getConnexion());
			cuentacontabletipoLogic.setDatosCliente(this.datosCliente);
			cuentacontabletipoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoCuentaContableTipo tipocuentacontabletipo:this.tipocuentacontabletipos) {
				

				classes=new ArrayList<Classe>();
				classes=CuentaContableTipoConstantesFunciones.getClassesForeignKeysOfCuentaContableTipo(new ArrayList<Classe>(),DeepLoadType.NONE);

				cuentacontabletipoLogic.setCuentaContableTipos(tipocuentacontabletipo.cuentacontabletipos);
				cuentacontabletipoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoCuentaContableTipo tipocuentacontabletipo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoCuentaContableTipoLogicAdditional.updateTipoCuentaContableTipoToGet(tipocuentacontabletipo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipocuentacontabletipo.setCuentaContableTipos(tipocuentacontabletipoDataAccess.getCuentaContableTipos(connexion,tipocuentacontabletipo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContableTipo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocuentacontabletipo.setCuentaContableTipos(tipocuentacontabletipoDataAccess.getCuentaContableTipos(connexion,tipocuentacontabletipo));

				if(this.isConDeep) {
					CuentaContableTipoLogic cuentacontabletipoLogic= new CuentaContableTipoLogic(this.connexion);
					cuentacontabletipoLogic.setCuentaContableTipos(tipocuentacontabletipo.getCuentaContableTipos());
					ArrayList<Classe> classesLocal=CuentaContableTipoConstantesFunciones.getClassesForeignKeysOfCuentaContableTipo(new ArrayList<Classe>(),DeepLoadType.NONE);
					cuentacontabletipoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(cuentacontabletipoLogic.getCuentaContableTipos());
					tipocuentacontabletipo.setCuentaContableTipos(cuentacontabletipoLogic.getCuentaContableTipos());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContableTipo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CuentaContableTipo.class));
			tipocuentacontabletipo.setCuentaContableTipos(tipocuentacontabletipoDataAccess.getCuentaContableTipos(connexion,tipocuentacontabletipo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tipocuentacontabletipo.setCuentaContableTipos(tipocuentacontabletipoDataAccess.getCuentaContableTipos(connexion,tipocuentacontabletipo));

		for(CuentaContableTipo cuentacontabletipo:tipocuentacontabletipo.getCuentaContableTipos()) {
			CuentaContableTipoLogic cuentacontabletipoLogic= new CuentaContableTipoLogic(connexion);
			cuentacontabletipoLogic.deepLoad(cuentacontabletipo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContableTipo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocuentacontabletipo.setCuentaContableTipos(tipocuentacontabletipoDataAccess.getCuentaContableTipos(connexion,tipocuentacontabletipo));

				for(CuentaContableTipo cuentacontabletipo:tipocuentacontabletipo.getCuentaContableTipos()) {
					CuentaContableTipoLogic cuentacontabletipoLogic= new CuentaContableTipoLogic(connexion);
					cuentacontabletipoLogic.deepLoad(cuentacontabletipo,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContableTipo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CuentaContableTipo.class));
			tipocuentacontabletipo.setCuentaContableTipos(tipocuentacontabletipoDataAccess.getCuentaContableTipos(connexion,tipocuentacontabletipo));

			for(CuentaContableTipo cuentacontabletipo:tipocuentacontabletipo.getCuentaContableTipos()) {
				CuentaContableTipoLogic cuentacontabletipoLogic= new CuentaContableTipoLogic(connexion);
				cuentacontabletipoLogic.deepLoad(cuentacontabletipo,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoCuentaContableTipo tipocuentacontabletipo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoCuentaContableTipoLogicAdditional.updateTipoCuentaContableTipoToSave(tipocuentacontabletipo,this.arrDatoGeneral);
			
TipoCuentaContableTipoDataAccess.save(tipocuentacontabletipo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(CuentaContableTipo cuentacontabletipo:tipocuentacontabletipo.getCuentaContableTipos()) {
			cuentacontabletipo.setid_tipo_cuenta_contable_tipo(tipocuentacontabletipo.getId());
			CuentaContableTipoDataAccess.save(cuentacontabletipo,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(CuentaContableTipo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CuentaContableTipo cuentacontabletipo:tipocuentacontabletipo.getCuentaContableTipos()) {
					cuentacontabletipo.setid_tipo_cuenta_contable_tipo(tipocuentacontabletipo.getId());
					CuentaContableTipoDataAccess.save(cuentacontabletipo,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(CuentaContableTipo cuentacontabletipo:tipocuentacontabletipo.getCuentaContableTipos()) {
			CuentaContableTipoLogic cuentacontabletipoLogic= new CuentaContableTipoLogic(connexion);
			cuentacontabletipo.setid_tipo_cuenta_contable_tipo(tipocuentacontabletipo.getId());
			CuentaContableTipoDataAccess.save(cuentacontabletipo,connexion);
			cuentacontabletipoLogic.deepSave(cuentacontabletipo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(CuentaContableTipo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CuentaContableTipo cuentacontabletipo:tipocuentacontabletipo.getCuentaContableTipos()) {
					CuentaContableTipoLogic cuentacontabletipoLogic= new CuentaContableTipoLogic(connexion);
					cuentacontabletipo.setid_tipo_cuenta_contable_tipo(tipocuentacontabletipo.getId());
					CuentaContableTipoDataAccess.save(cuentacontabletipo,connexion);
					cuentacontabletipoLogic.deepSave(cuentacontabletipo,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoCuentaContableTipo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipocuentacontabletipo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoCuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaContableTipo(tipocuentacontabletipo);
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
			this.deepLoad(this.tipocuentacontabletipo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoCuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaContableTipo(this.tipocuentacontabletipo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoCuentaContableTipo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipocuentacontabletipos!=null) {
				for(TipoCuentaContableTipo tipocuentacontabletipo:tipocuentacontabletipos) {
					this.deepLoad(tipocuentacontabletipo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoCuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaContableTipo(tipocuentacontabletipos);
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
			if(tipocuentacontabletipos!=null) {
				for(TipoCuentaContableTipo tipocuentacontabletipo:tipocuentacontabletipos) {
					this.deepLoad(tipocuentacontabletipo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoCuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaContableTipo(tipocuentacontabletipos);
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
			this.getNewConnexionToDeep(TipoCuentaContableTipo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipocuentacontabletipo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoCuentaContableTipo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipocuentacontabletipos!=null) {
				for(TipoCuentaContableTipo tipocuentacontabletipo:tipocuentacontabletipos) {
					this.deepSave(tipocuentacontabletipo,isDeep,deepLoadType,clases);
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
			if(tipocuentacontabletipos!=null) {
				for(TipoCuentaContableTipo tipocuentacontabletipo:tipocuentacontabletipos) {
					this.deepSave(tipocuentacontabletipo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoCuentaContableTiposBusquedaPorIdWithConnection(String sFinalQuery,Pagination pagination,Long id)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaContableTipo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,TipoCuentaContableTipoConstantesFunciones.ID,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			TipoCuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorId","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocuentacontabletipos=tipocuentacontabletipoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoCuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaContableTipo(this.tipocuentacontabletipos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoCuentaContableTiposBusquedaPorId(String sFinalQuery,Pagination pagination,Long id)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,TipoCuentaContableTipoConstantesFunciones.ID,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			TipoCuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorId","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocuentacontabletipos=tipocuentacontabletipoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoCuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaContableTipo(this.tipocuentacontabletipos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoCuentaContableTiposBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaContableTipo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoCuentaContableTipoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoCuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocuentacontabletipos=tipocuentacontabletipoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoCuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaContableTipo(this.tipocuentacontabletipos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoCuentaContableTiposBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoCuentaContableTipoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoCuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocuentacontabletipos=tipocuentacontabletipoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoCuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaContableTipo(this.tipocuentacontabletipos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoCuentaContableTipoPorNombreWithConnection(String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaContableTipo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoCuentaContableTipoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipocuentacontabletipo=tipocuentacontabletipoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipocuentacontabletipo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoCuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaContableTipo(this.tipocuentacontabletipo);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoCuentaContableTipoPorNombre(String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoCuentaContableTipoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipocuentacontabletipo=tipocuentacontabletipoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipocuentacontabletipo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoCuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaContableTipo(this.tipocuentacontabletipo);
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
			if(TipoCuentaContableTipoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCuentaContableTipoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoCuentaContableTipo tipocuentacontabletipo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoCuentaContableTipoConstantesFunciones.ISCONAUDITORIA) {
				if(tipocuentacontabletipo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCuentaContableTipoDataAccess.TABLENAME, tipocuentacontabletipo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoCuentaContableTipoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoCuentaContableTipoLogic.registrarAuditoriaDetallesTipoCuentaContableTipo(connexion,tipocuentacontabletipo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipocuentacontabletipo.getIsDeleted()) {
					/*if(!tipocuentacontabletipo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoCuentaContableTipoDataAccess.TABLENAME, tipocuentacontabletipo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoCuentaContableTipoLogic.registrarAuditoriaDetallesTipoCuentaContableTipo(connexion,tipocuentacontabletipo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCuentaContableTipoDataAccess.TABLENAME, tipocuentacontabletipo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipocuentacontabletipo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCuentaContableTipoDataAccess.TABLENAME, tipocuentacontabletipo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoCuentaContableTipoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoCuentaContableTipoLogic.registrarAuditoriaDetallesTipoCuentaContableTipo(connexion,tipocuentacontabletipo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoCuentaContableTipo(Connexion connexion,TipoCuentaContableTipo tipocuentacontabletipo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipocuentacontabletipo.getIsNew()||!tipocuentacontabletipo.getnombre().equals(tipocuentacontabletipo.getTipoCuentaContableTipoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocuentacontabletipo.getTipoCuentaContableTipoOriginal().getnombre()!=null)
				{
					strValorActual=tipocuentacontabletipo.getTipoCuentaContableTipoOriginal().getnombre();
				}
				if(tipocuentacontabletipo.getnombre()!=null)
				{
					strValorNuevo=tipocuentacontabletipo.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCuentaContableTipoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoCuentaContableTipoRelacionesWithConnection(TipoCuentaContableTipo tipocuentacontabletipo,List<CuentaContableTipo> cuentacontabletipos) throws Exception {

		if(!tipocuentacontabletipo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoCuentaContableTipoRelacionesBase(tipocuentacontabletipo,cuentacontabletipos,true);
		}
	}

	public void saveTipoCuentaContableTipoRelaciones(TipoCuentaContableTipo tipocuentacontabletipo,List<CuentaContableTipo> cuentacontabletipos)throws Exception {

		if(!tipocuentacontabletipo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoCuentaContableTipoRelacionesBase(tipocuentacontabletipo,cuentacontabletipos,false);
		}
	}

	public void saveTipoCuentaContableTipoRelacionesBase(TipoCuentaContableTipo tipocuentacontabletipo,List<CuentaContableTipo> cuentacontabletipos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoCuentaContableTipo-saveRelacionesWithConnection");}
	
			tipocuentacontabletipo.setCuentaContableTipos(cuentacontabletipos);

			this.setTipoCuentaContableTipo(tipocuentacontabletipo);

				if((tipocuentacontabletipo.getIsNew()||tipocuentacontabletipo.getIsChanged())&&!tipocuentacontabletipo.getIsDeleted()) {
					this.saveTipoCuentaContableTipo();
					this.saveTipoCuentaContableTipoRelacionesDetalles(cuentacontabletipos);

				} else if(tipocuentacontabletipo.getIsDeleted()) {
					this.saveTipoCuentaContableTipoRelacionesDetalles(cuentacontabletipos);
					this.saveTipoCuentaContableTipo();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			CuentaContableTipoConstantesFunciones.InicializarGeneralEntityAuxiliaresCuentaContableTipos(cuentacontabletipos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoCuentaContableTipoRelacionesDetalles(List<CuentaContableTipo> cuentacontabletipos)throws Exception {
		try {
	

			Long idTipoCuentaContableTipoActual=this.getTipoCuentaContableTipo().getId();

			CuentaContableTipoLogic cuentacontabletipoLogic_Desde_TipoCuentaContableTipo=new CuentaContableTipoLogic();
			cuentacontabletipoLogic_Desde_TipoCuentaContableTipo.setCuentaContableTipos(cuentacontabletipos);

			cuentacontabletipoLogic_Desde_TipoCuentaContableTipo.setConnexion(this.getConnexion());
			cuentacontabletipoLogic_Desde_TipoCuentaContableTipo.setDatosCliente(this.datosCliente);

			for(CuentaContableTipo cuentacontabletipo_Desde_TipoCuentaContableTipo:cuentacontabletipoLogic_Desde_TipoCuentaContableTipo.getCuentaContableTipos()) {
				cuentacontabletipo_Desde_TipoCuentaContableTipo.setid_tipo_cuenta_contable_tipo(idTipoCuentaContableTipoActual);
			}

			cuentacontabletipoLogic_Desde_TipoCuentaContableTipo.saveCuentaContableTipos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCuentaContableTipo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoCuentaContableTipoConstantesFunciones.getClassesForeignKeysOfTipoCuentaContableTipo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCuentaContableTipo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoCuentaContableTipoConstantesFunciones.getClassesRelationshipsOfTipoCuentaContableTipo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
