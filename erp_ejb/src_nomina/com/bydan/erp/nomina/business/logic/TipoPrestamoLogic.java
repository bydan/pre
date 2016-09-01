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
import com.bydan.erp.nomina.util.TipoPrestamoConstantesFunciones;
import com.bydan.erp.nomina.util.TipoPrestamoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoPrestamoParameterGeneral;
import com.bydan.erp.nomina.business.entity.TipoPrestamo;
import com.bydan.erp.nomina.business.logic.TipoPrestamoLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoPrestamoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoPrestamoLogic.class);
	
	protected TipoPrestamoDataAccess tipoprestamoDataAccess; 	
	protected TipoPrestamo tipoprestamo;
	protected List<TipoPrestamo> tipoprestamos;
	protected Object tipoprestamoObject;	
	protected List<Object> tipoprestamosObject;
	
	public static ClassValidator<TipoPrestamo> tipoprestamoValidator = new ClassValidator<TipoPrestamo>(TipoPrestamo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoPrestamoLogicAdditional tipoprestamoLogicAdditional=null;
	
	public TipoPrestamoLogicAdditional getTipoPrestamoLogicAdditional() {
		return this.tipoprestamoLogicAdditional;
	}
	
	public void setTipoPrestamoLogicAdditional(TipoPrestamoLogicAdditional tipoprestamoLogicAdditional) {
		try {
			this.tipoprestamoLogicAdditional=tipoprestamoLogicAdditional;
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
	
	
	
	
	public  TipoPrestamoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoprestamoDataAccess = new TipoPrestamoDataAccess();
			
			this.tipoprestamos= new ArrayList<TipoPrestamo>();
			this.tipoprestamo= new TipoPrestamo();
			
			this.tipoprestamoObject=new Object();
			this.tipoprestamosObject=new ArrayList<Object>();
				
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
			
			this.tipoprestamoDataAccess.setConnexionType(this.connexionType);
			this.tipoprestamoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoPrestamoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoprestamoDataAccess = new TipoPrestamoDataAccess();
			this.tipoprestamos= new ArrayList<TipoPrestamo>();
			this.tipoprestamo= new TipoPrestamo();
			this.tipoprestamoObject=new Object();
			this.tipoprestamosObject=new ArrayList<Object>();
			
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
			
			this.tipoprestamoDataAccess.setConnexionType(this.connexionType);
			this.tipoprestamoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoPrestamo getTipoPrestamo() throws Exception {	
		TipoPrestamoLogicAdditional.checkTipoPrestamoToGet(tipoprestamo,this.datosCliente,this.arrDatoGeneral);
		TipoPrestamoLogicAdditional.updateTipoPrestamoToGet(tipoprestamo,this.arrDatoGeneral);
		
		return tipoprestamo;
	}
		
	public void setTipoPrestamo(TipoPrestamo newTipoPrestamo) {
		this.tipoprestamo = newTipoPrestamo;
	}
	
	public TipoPrestamoDataAccess getTipoPrestamoDataAccess() {
		return tipoprestamoDataAccess;
	}
	
	public void setTipoPrestamoDataAccess(TipoPrestamoDataAccess newtipoprestamoDataAccess) {
		this.tipoprestamoDataAccess = newtipoprestamoDataAccess;
	}
	
	public List<TipoPrestamo> getTipoPrestamos() throws Exception {		
		this.quitarTipoPrestamosNulos();
		
		TipoPrestamoLogicAdditional.checkTipoPrestamoToGets(tipoprestamos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoPrestamo tipoprestamoLocal: tipoprestamos ) {
			TipoPrestamoLogicAdditional.updateTipoPrestamoToGet(tipoprestamoLocal,this.arrDatoGeneral);
		}
		
		return tipoprestamos;
	}
	
	public void setTipoPrestamos(List<TipoPrestamo> newTipoPrestamos) {
		this.tipoprestamos = newTipoPrestamos;
	}
	
	public Object getTipoPrestamoObject() {	
		this.tipoprestamoObject=this.tipoprestamoDataAccess.getEntityObject();
		return this.tipoprestamoObject;
	}
		
	public void setTipoPrestamoObject(Object newTipoPrestamoObject) {
		this.tipoprestamoObject = newTipoPrestamoObject;
	}
	
	public List<Object> getTipoPrestamosObject() {		
		this.tipoprestamosObject=this.tipoprestamoDataAccess.getEntitiesObject();
		return this.tipoprestamosObject;
	}
		
	public void setTipoPrestamosObject(List<Object> newTipoPrestamosObject) {
		this.tipoprestamosObject = newTipoPrestamosObject;
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
		
		if(this.tipoprestamoDataAccess!=null) {
			this.tipoprestamoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrestamo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoprestamoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoprestamoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoprestamo = new  TipoPrestamo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrestamo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoprestamo=tipoprestamoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprestamo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrestamo(this.tipoprestamo);
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
		tipoprestamo = new  TipoPrestamo();
		  		  
        try {
			
			tipoprestamo=tipoprestamoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprestamo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrestamo(this.tipoprestamo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoprestamo = new  TipoPrestamo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrestamo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoprestamo=tipoprestamoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprestamo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrestamo(this.tipoprestamo);
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
		tipoprestamo = new  TipoPrestamo();
		  		  
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
		tipoprestamo = new  TipoPrestamo();
		  		  
        try {
			
			tipoprestamo=tipoprestamoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprestamo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrestamo(this.tipoprestamo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoprestamo = new  TipoPrestamo();
		  		  
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
		tipoprestamo = new  TipoPrestamo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrestamo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoprestamoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoprestamo = new  TipoPrestamo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoprestamoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoprestamo = new  TipoPrestamo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrestamo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoprestamoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoprestamo = new  TipoPrestamo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoprestamoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoprestamo = new  TipoPrestamo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrestamo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoprestamoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoprestamo = new  TipoPrestamo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoprestamoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoprestamos = new  ArrayList<TipoPrestamo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrestamo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprestamos=tipoprestamoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoPrestamo(tipoprestamos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrestamo(this.tipoprestamos);
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
		tipoprestamos = new  ArrayList<TipoPrestamo>();
		  		  
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
		tipoprestamos = new  ArrayList<TipoPrestamo>();
		  		  
        try {			
			TipoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprestamos=tipoprestamoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoPrestamo(tipoprestamos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrestamo(this.tipoprestamos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoprestamos = new  ArrayList<TipoPrestamo>();
		  		  
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
		tipoprestamos = new  ArrayList<TipoPrestamo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrestamo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprestamos=tipoprestamoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoPrestamo(tipoprestamos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrestamo(this.tipoprestamos);
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
		tipoprestamos = new  ArrayList<TipoPrestamo>();
		  		  
        try {
			TipoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprestamos=tipoprestamoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoPrestamo(tipoprestamos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrestamo(this.tipoprestamos);
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
		tipoprestamos = new  ArrayList<TipoPrestamo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrestamo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprestamos=tipoprestamoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoPrestamo(tipoprestamos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrestamo(this.tipoprestamos);
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
		tipoprestamos = new  ArrayList<TipoPrestamo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprestamos=tipoprestamoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoPrestamo(tipoprestamos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrestamo(this.tipoprestamos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoprestamo = new  TipoPrestamo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrestamo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprestamo=tipoprestamoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoPrestamo(tipoprestamo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrestamo(this.tipoprestamo);
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
		tipoprestamo = new  TipoPrestamo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprestamo=tipoprestamoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoPrestamo(tipoprestamo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrestamo(this.tipoprestamo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoprestamos = new  ArrayList<TipoPrestamo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrestamo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprestamos=tipoprestamoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoPrestamo(tipoprestamos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrestamo(this.tipoprestamos);
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
		tipoprestamos = new  ArrayList<TipoPrestamo>();
		  		  
        try {
			TipoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprestamos=tipoprestamoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoPrestamo(tipoprestamos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrestamo(this.tipoprestamos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoPrestamosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoprestamos = new  ArrayList<TipoPrestamo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrestamo.class.getSimpleName()+"-getTodosTipoPrestamosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprestamos=tipoprestamoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoPrestamo(tipoprestamos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrestamo(this.tipoprestamos);
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
	
	public  void  getTodosTipoPrestamos(String sFinalQuery,Pagination pagination)throws Exception {
		tipoprestamos = new  ArrayList<TipoPrestamo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprestamos=tipoprestamoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoPrestamo(tipoprestamos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrestamo(this.tipoprestamos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoPrestamo(TipoPrestamo tipoprestamo) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoprestamo.getIsNew() || tipoprestamo.getIsChanged()) { 
			this.invalidValues = tipoprestamoValidator.getInvalidValues(tipoprestamo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoprestamo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoPrestamo(List<TipoPrestamo> TipoPrestamos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoPrestamo tipoprestamoLocal:tipoprestamos) {				
			estaValidadoObjeto=this.validarGuardarTipoPrestamo(tipoprestamoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoPrestamo(List<TipoPrestamo> TipoPrestamos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoPrestamo(tipoprestamos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoPrestamo(TipoPrestamo TipoPrestamo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoPrestamo(tipoprestamo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoPrestamo tipoprestamo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoprestamo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoPrestamoConstantesFunciones.getTipoPrestamoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoprestamo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoPrestamoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoPrestamoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoPrestamoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrestamo.class.getSimpleName()+"-saveTipoPrestamoWithConnection");connexion.begin();			
			
			TipoPrestamoLogicAdditional.checkTipoPrestamoToSave(this.tipoprestamo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoPrestamoLogicAdditional.updateTipoPrestamoToSave(this.tipoprestamo,this.arrDatoGeneral);
			
			TipoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoprestamo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoPrestamo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoPrestamo(this.tipoprestamo)) {
				TipoPrestamoDataAccess.save(this.tipoprestamo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoprestamo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoPrestamoLogicAdditional.checkTipoPrestamoToSaveAfter(this.tipoprestamo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoPrestamo();
			
			connexion.commit();			
			
			if(this.tipoprestamo.getIsDeleted()) {
				this.tipoprestamo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoPrestamo()throws Exception {	
		try {	
			
			TipoPrestamoLogicAdditional.checkTipoPrestamoToSave(this.tipoprestamo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoPrestamoLogicAdditional.updateTipoPrestamoToSave(this.tipoprestamo,this.arrDatoGeneral);
			
			TipoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoprestamo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoPrestamo(this.tipoprestamo)) {			
				TipoPrestamoDataAccess.save(this.tipoprestamo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoprestamo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoPrestamoLogicAdditional.checkTipoPrestamoToSaveAfter(this.tipoprestamo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoprestamo.getIsDeleted()) {
				this.tipoprestamo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoPrestamosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrestamo.class.getSimpleName()+"-saveTipoPrestamosWithConnection");connexion.begin();			
			
			TipoPrestamoLogicAdditional.checkTipoPrestamoToSaves(tipoprestamos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoPrestamos();
			
			Boolean validadoTodosTipoPrestamo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoPrestamo tipoprestamoLocal:tipoprestamos) {		
				if(tipoprestamoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoPrestamoLogicAdditional.updateTipoPrestamoToSave(tipoprestamoLocal,this.arrDatoGeneral);
	        	
				TipoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoprestamoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoPrestamo(tipoprestamoLocal)) {
					TipoPrestamoDataAccess.save(tipoprestamoLocal, connexion);				
				} else {
					validadoTodosTipoPrestamo=false;
				}
			}
			
			if(!validadoTodosTipoPrestamo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoPrestamoLogicAdditional.checkTipoPrestamoToSavesAfter(tipoprestamos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoPrestamos();
			
			connexion.commit();		
			
			this.quitarTipoPrestamosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoPrestamos()throws Exception {				
		 try {	
			TipoPrestamoLogicAdditional.checkTipoPrestamoToSaves(tipoprestamos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoPrestamo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoPrestamo tipoprestamoLocal:tipoprestamos) {				
				if(tipoprestamoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoPrestamoLogicAdditional.updateTipoPrestamoToSave(tipoprestamoLocal,this.arrDatoGeneral);
	        	
				TipoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoprestamoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoPrestamo(tipoprestamoLocal)) {				
					TipoPrestamoDataAccess.save(tipoprestamoLocal, connexion);				
				} else {
					validadoTodosTipoPrestamo=false;
				}
			}
			
			if(!validadoTodosTipoPrestamo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoPrestamoLogicAdditional.checkTipoPrestamoToSavesAfter(tipoprestamos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoPrestamosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoPrestamoParameterReturnGeneral procesarAccionTipoPrestamos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoPrestamo> tipoprestamos,TipoPrestamoParameterReturnGeneral tipoprestamoParameterGeneral)throws Exception {
		 try {	
			TipoPrestamoParameterReturnGeneral tipoprestamoReturnGeneral=new TipoPrestamoParameterReturnGeneral();
	
			TipoPrestamoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoprestamos,tipoprestamoParameterGeneral,tipoprestamoReturnGeneral);
			
			return tipoprestamoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoPrestamoParameterReturnGeneral procesarAccionTipoPrestamosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoPrestamo> tipoprestamos,TipoPrestamoParameterReturnGeneral tipoprestamoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrestamo.class.getSimpleName()+"-procesarAccionTipoPrestamosWithConnection");connexion.begin();			
			
			TipoPrestamoParameterReturnGeneral tipoprestamoReturnGeneral=new TipoPrestamoParameterReturnGeneral();
	
			TipoPrestamoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoprestamos,tipoprestamoParameterGeneral,tipoprestamoReturnGeneral);
			
			this.connexion.commit();
			
			return tipoprestamoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoPrestamoParameterReturnGeneral procesarEventosTipoPrestamos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoPrestamo> tipoprestamos,TipoPrestamo tipoprestamo,TipoPrestamoParameterReturnGeneral tipoprestamoParameterGeneral,Boolean isEsNuevoTipoPrestamo,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoPrestamoParameterReturnGeneral tipoprestamoReturnGeneral=new TipoPrestamoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoprestamoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoPrestamoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoprestamos,tipoprestamo,tipoprestamoParameterGeneral,tipoprestamoReturnGeneral,isEsNuevoTipoPrestamo,clases);
			
			return tipoprestamoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoPrestamoParameterReturnGeneral procesarEventosTipoPrestamosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoPrestamo> tipoprestamos,TipoPrestamo tipoprestamo,TipoPrestamoParameterReturnGeneral tipoprestamoParameterGeneral,Boolean isEsNuevoTipoPrestamo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrestamo.class.getSimpleName()+"-procesarEventosTipoPrestamosWithConnection");connexion.begin();			
			
			TipoPrestamoParameterReturnGeneral tipoprestamoReturnGeneral=new TipoPrestamoParameterReturnGeneral();
	
			tipoprestamoReturnGeneral.setTipoPrestamo(tipoprestamo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoprestamoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoPrestamoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoprestamos,tipoprestamo,tipoprestamoParameterGeneral,tipoprestamoReturnGeneral,isEsNuevoTipoPrestamo,clases);
			
			this.connexion.commit();
			
			return tipoprestamoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoPrestamoParameterReturnGeneral procesarImportacionTipoPrestamosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoPrestamoParameterReturnGeneral tipoprestamoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrestamo.class.getSimpleName()+"-procesarImportacionTipoPrestamosWithConnection");connexion.begin();			
			
			TipoPrestamoParameterReturnGeneral tipoprestamoReturnGeneral=new TipoPrestamoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoprestamos=new ArrayList<TipoPrestamo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoprestamo=new TipoPrestamo();
				
				
				if(conColumnasBase) {this.tipoprestamo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoprestamo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoprestamo.setcodigo(arrColumnas[iColumn++]);
				this.tipoprestamo.setnombre(arrColumnas[iColumn++]);
				this.tipoprestamo.setcon_pago(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.tipoprestamos.add(this.tipoprestamo);
			}
			
			this.saveTipoPrestamos();
			
			this.connexion.commit();
			
			tipoprestamoReturnGeneral.setConRetornoEstaProcesado(true);
			tipoprestamoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoprestamoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoPrestamosEliminados() throws Exception {				
		
		List<TipoPrestamo> tipoprestamosAux= new ArrayList<TipoPrestamo>();
		
		for(TipoPrestamo tipoprestamo:tipoprestamos) {
			if(!tipoprestamo.getIsDeleted()) {
				tipoprestamosAux.add(tipoprestamo);
			}
		}
		
		tipoprestamos=tipoprestamosAux;
	}
	
	public void quitarTipoPrestamosNulos() throws Exception {				
		
		List<TipoPrestamo> tipoprestamosAux= new ArrayList<TipoPrestamo>();
		
		for(TipoPrestamo tipoprestamo : this.tipoprestamos) {
			if(tipoprestamo==null) {
				tipoprestamosAux.add(tipoprestamo);
			}
		}
		
		//this.tipoprestamos=tipoprestamosAux;
		
		this.tipoprestamos.removeAll(tipoprestamosAux);
	}
	
	public void getSetVersionRowTipoPrestamoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoprestamo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoprestamo.getIsDeleted() || (tipoprestamo.getIsChanged()&&!tipoprestamo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoprestamoDataAccess.getSetVersionRowTipoPrestamo(connexion,tipoprestamo.getId());
				
				if(!tipoprestamo.getVersionRow().equals(timestamp)) {	
					tipoprestamo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoprestamo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoPrestamo()throws Exception {	
		
		if(tipoprestamo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoprestamo.getIsDeleted() || (tipoprestamo.getIsChanged()&&!tipoprestamo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoprestamoDataAccess.getSetVersionRowTipoPrestamo(connexion,tipoprestamo.getId());
			
			try {							
				if(!tipoprestamo.getVersionRow().equals(timestamp)) {	
					tipoprestamo.setVersionRow(timestamp);
				}
				
				tipoprestamo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoPrestamosWithConnection()throws Exception {	
		if(tipoprestamos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoPrestamo tipoprestamoAux:tipoprestamos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoprestamoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoprestamoAux.getIsDeleted() || (tipoprestamoAux.getIsChanged()&&!tipoprestamoAux.getIsNew())) {
						
						timestamp=tipoprestamoDataAccess.getSetVersionRowTipoPrestamo(connexion,tipoprestamoAux.getId());
						
						if(!tipoprestamo.getVersionRow().equals(timestamp)) {	
							tipoprestamoAux.setVersionRow(timestamp);
						}
								
						tipoprestamoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoPrestamos()throws Exception {	
		if(tipoprestamos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoPrestamo tipoprestamoAux:tipoprestamos) {
					if(tipoprestamoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoprestamoAux.getIsDeleted() || (tipoprestamoAux.getIsChanged()&&!tipoprestamoAux.getIsNew())) {
						
						timestamp=tipoprestamoDataAccess.getSetVersionRowTipoPrestamo(connexion,tipoprestamoAux.getId());
						
						if(!tipoprestamoAux.getVersionRow().equals(timestamp)) {	
							tipoprestamoAux.setVersionRow(timestamp);
						}
						
													
						tipoprestamoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoPrestamoParameterReturnGeneral cargarCombosLoteForeignKeyTipoPrestamoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalRubroEmplea,String finalQueryGlobalCuentaContable) throws Exception {
		TipoPrestamoParameterReturnGeneral  tipoprestamoReturnGeneral =new TipoPrestamoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrestamo.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoPrestamoWithConnection");connexion.begin();
			
			tipoprestamoReturnGeneral =new TipoPrestamoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoprestamoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<RubroEmplea> rubroempleasForeignKey=new ArrayList<RubroEmplea>();
			RubroEmpleaLogic rubroempleaLogic=new RubroEmpleaLogic();
			rubroempleaLogic.setConnexion(this.connexion);
			rubroempleaLogic.getRubroEmpleaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRubroEmplea.equals("NONE")) {
				rubroempleaLogic.getTodosRubroEmpleas(finalQueryGlobalRubroEmplea,new Pagination());
				rubroempleasForeignKey=rubroempleaLogic.getRubroEmpleas();
			}

			tipoprestamoReturnGeneral.setrubroempleasForeignKey(rubroempleasForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			tipoprestamoReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipoprestamoReturnGeneral;
	}
	
	public TipoPrestamoParameterReturnGeneral cargarCombosLoteForeignKeyTipoPrestamo(String finalQueryGlobalEmpresa,String finalQueryGlobalRubroEmplea,String finalQueryGlobalCuentaContable) throws Exception {
		TipoPrestamoParameterReturnGeneral  tipoprestamoReturnGeneral =new TipoPrestamoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipoprestamoReturnGeneral =new TipoPrestamoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoprestamoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<RubroEmplea> rubroempleasForeignKey=new ArrayList<RubroEmplea>();
			RubroEmpleaLogic rubroempleaLogic=new RubroEmpleaLogic();
			rubroempleaLogic.setConnexion(this.connexion);
			rubroempleaLogic.getRubroEmpleaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRubroEmplea.equals("NONE")) {
				rubroempleaLogic.getTodosRubroEmpleas(finalQueryGlobalRubroEmplea,new Pagination());
				rubroempleasForeignKey=rubroempleaLogic.getRubroEmpleas();
			}

			tipoprestamoReturnGeneral.setrubroempleasForeignKey(rubroempleasForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			tipoprestamoReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipoprestamoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoPrestamoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			PrestamoLogic prestamoLogic=new PrestamoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrestamo.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoPrestamoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Prestamo.class));
											
			

			prestamoLogic.setConnexion(this.getConnexion());
			prestamoLogic.setDatosCliente(this.datosCliente);
			prestamoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoPrestamo tipoprestamo:this.tipoprestamos) {
				

				classes=new ArrayList<Classe>();
				classes=PrestamoConstantesFunciones.getClassesForeignKeysOfPrestamo(new ArrayList<Classe>(),DeepLoadType.NONE);

				prestamoLogic.setPrestamos(tipoprestamo.prestamos);
				prestamoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoPrestamo tipoprestamo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoPrestamoLogicAdditional.updateTipoPrestamoToGet(tipoprestamo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoprestamo.setEmpresa(tipoprestamoDataAccess.getEmpresa(connexion,tipoprestamo));
		tipoprestamo.setRubroEmplea(tipoprestamoDataAccess.getRubroEmplea(connexion,tipoprestamo));
		tipoprestamo.setCuentaContable(tipoprestamoDataAccess.getCuentaContable(connexion,tipoprestamo));
		tipoprestamo.setPrestamos(tipoprestamoDataAccess.getPrestamos(connexion,tipoprestamo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoprestamo.setEmpresa(tipoprestamoDataAccess.getEmpresa(connexion,tipoprestamo));
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				tipoprestamo.setRubroEmplea(tipoprestamoDataAccess.getRubroEmplea(connexion,tipoprestamo));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tipoprestamo.setCuentaContable(tipoprestamoDataAccess.getCuentaContable(connexion,tipoprestamo));
				continue;
			}

			if(clas.clas.equals(Prestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprestamo.setPrestamos(tipoprestamoDataAccess.getPrestamos(connexion,tipoprestamo));

				if(this.isConDeep) {
					PrestamoLogic prestamoLogic= new PrestamoLogic(this.connexion);
					prestamoLogic.setPrestamos(tipoprestamo.getPrestamos());
					ArrayList<Classe> classesLocal=PrestamoConstantesFunciones.getClassesForeignKeysOfPrestamo(new ArrayList<Classe>(),DeepLoadType.NONE);
					prestamoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(prestamoLogic.getPrestamos());
					tipoprestamo.setPrestamos(prestamoLogic.getPrestamos());
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
			tipoprestamo.setEmpresa(tipoprestamoDataAccess.getEmpresa(connexion,tipoprestamo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmplea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipoprestamo.setRubroEmplea(tipoprestamoDataAccess.getRubroEmplea(connexion,tipoprestamo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipoprestamo.setCuentaContable(tipoprestamoDataAccess.getCuentaContable(connexion,tipoprestamo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Prestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Prestamo.class));
			tipoprestamo.setPrestamos(tipoprestamoDataAccess.getPrestamos(connexion,tipoprestamo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoprestamo.setEmpresa(tipoprestamoDataAccess.getEmpresa(connexion,tipoprestamo));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoprestamo.getEmpresa(),isDeep,deepLoadType,clases);
				
		tipoprestamo.setRubroEmplea(tipoprestamoDataAccess.getRubroEmplea(connexion,tipoprestamo));
		RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
		rubroempleaLogic.deepLoad(tipoprestamo.getRubroEmplea(),isDeep,deepLoadType,clases);
				
		tipoprestamo.setCuentaContable(tipoprestamoDataAccess.getCuentaContable(connexion,tipoprestamo));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(tipoprestamo.getCuentaContable(),isDeep,deepLoadType,clases);
				

		tipoprestamo.setPrestamos(tipoprestamoDataAccess.getPrestamos(connexion,tipoprestamo));

		for(Prestamo prestamo:tipoprestamo.getPrestamos()) {
			PrestamoLogic prestamoLogic= new PrestamoLogic(connexion);
			prestamoLogic.deepLoad(prestamo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoprestamo.setEmpresa(tipoprestamoDataAccess.getEmpresa(connexion,tipoprestamo));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipoprestamo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				tipoprestamo.setRubroEmplea(tipoprestamoDataAccess.getRubroEmplea(connexion,tipoprestamo));
				RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
				rubroempleaLogic.deepLoad(tipoprestamo.getRubroEmplea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tipoprestamo.setCuentaContable(tipoprestamoDataAccess.getCuentaContable(connexion,tipoprestamo));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(tipoprestamo.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Prestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprestamo.setPrestamos(tipoprestamoDataAccess.getPrestamos(connexion,tipoprestamo));

				for(Prestamo prestamo:tipoprestamo.getPrestamos()) {
					PrestamoLogic prestamoLogic= new PrestamoLogic(connexion);
					prestamoLogic.deepLoad(prestamo,isDeep,deepLoadType,clases);
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
			tipoprestamo.setEmpresa(tipoprestamoDataAccess.getEmpresa(connexion,tipoprestamo));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipoprestamo.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmplea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipoprestamo.setRubroEmplea(tipoprestamoDataAccess.getRubroEmplea(connexion,tipoprestamo));
			RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
			rubroempleaLogic.deepLoad(tipoprestamo.getRubroEmplea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipoprestamo.setCuentaContable(tipoprestamoDataAccess.getCuentaContable(connexion,tipoprestamo));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(tipoprestamo.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Prestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Prestamo.class));
			tipoprestamo.setPrestamos(tipoprestamoDataAccess.getPrestamos(connexion,tipoprestamo));

			for(Prestamo prestamo:tipoprestamo.getPrestamos()) {
				PrestamoLogic prestamoLogic= new PrestamoLogic(connexion);
				prestamoLogic.deepLoad(prestamo,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoPrestamo tipoprestamo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoPrestamoLogicAdditional.updateTipoPrestamoToSave(tipoprestamo,this.arrDatoGeneral);
			
TipoPrestamoDataAccess.save(tipoprestamo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoprestamo.getEmpresa(),connexion);

		RubroEmpleaDataAccess.save(tipoprestamo.getRubroEmplea(),connexion);

		CuentaContableDataAccess.save(tipoprestamo.getCuentaContable(),connexion);

		for(Prestamo prestamo:tipoprestamo.getPrestamos()) {
			prestamo.setid_tipo_prestamo(tipoprestamo.getId());
			PrestamoDataAccess.save(prestamo,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoprestamo.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				RubroEmpleaDataAccess.save(tipoprestamo.getRubroEmplea(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tipoprestamo.getCuentaContable(),connexion);
				continue;
			}


			if(clas.clas.equals(Prestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Prestamo prestamo:tipoprestamo.getPrestamos()) {
					prestamo.setid_tipo_prestamo(tipoprestamo.getId());
					PrestamoDataAccess.save(prestamo,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoprestamo.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoprestamo.getEmpresa(),isDeep,deepLoadType,clases);
				

		RubroEmpleaDataAccess.save(tipoprestamo.getRubroEmplea(),connexion);
		RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
		rubroempleaLogic.deepLoad(tipoprestamo.getRubroEmplea(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(tipoprestamo.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(tipoprestamo.getCuentaContable(),isDeep,deepLoadType,clases);
				

		for(Prestamo prestamo:tipoprestamo.getPrestamos()) {
			PrestamoLogic prestamoLogic= new PrestamoLogic(connexion);
			prestamo.setid_tipo_prestamo(tipoprestamo.getId());
			PrestamoDataAccess.save(prestamo,connexion);
			prestamoLogic.deepSave(prestamo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoprestamo.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipoprestamo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				RubroEmpleaDataAccess.save(tipoprestamo.getRubroEmplea(),connexion);
				RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
				rubroempleaLogic.deepSave(tipoprestamo.getRubroEmplea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tipoprestamo.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(tipoprestamo.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Prestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Prestamo prestamo:tipoprestamo.getPrestamos()) {
					PrestamoLogic prestamoLogic= new PrestamoLogic(connexion);
					prestamo.setid_tipo_prestamo(tipoprestamo.getId());
					PrestamoDataAccess.save(prestamo,connexion);
					prestamoLogic.deepSave(prestamo,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoPrestamo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoprestamo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrestamo(tipoprestamo);
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
			this.deepLoad(this.tipoprestamo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrestamo(this.tipoprestamo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoPrestamo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoprestamos!=null) {
				for(TipoPrestamo tipoprestamo:tipoprestamos) {
					this.deepLoad(tipoprestamo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrestamo(tipoprestamos);
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
			if(tipoprestamos!=null) {
				for(TipoPrestamo tipoprestamo:tipoprestamos) {
					this.deepLoad(tipoprestamo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrestamo(tipoprestamos);
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
			this.getNewConnexionToDeep(TipoPrestamo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipoprestamo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoPrestamo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipoprestamos!=null) {
				for(TipoPrestamo tipoprestamo:tipoprestamos) {
					this.deepSave(tipoprestamo,isDeep,deepLoadType,clases);
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
			if(tipoprestamos!=null) {
				for(TipoPrestamo tipoprestamo:tipoprestamos) {
					this.deepSave(tipoprestamo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoPrestamosFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrestamo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,TipoPrestamoConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			TipoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoprestamos=tipoprestamoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrestamo(this.tipoprestamos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoPrestamosFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,TipoPrestamoConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			TipoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoprestamos=tipoprestamoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrestamo(this.tipoprestamos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoPrestamosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrestamo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoPrestamoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoprestamos=tipoprestamoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrestamo(this.tipoprestamos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoPrestamosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoPrestamoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoprestamos=tipoprestamoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrestamo(this.tipoprestamos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoPrestamosFK_IdTipoPrestamoWithConnection(String sFinalQuery,Pagination pagination,Long id_rubro_emplea)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrestamo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRubroEmplea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRubroEmplea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_rubro_emplea,TipoPrestamoConstantesFunciones.IDRUBROEMPLEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRubroEmplea);

			TipoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrestamo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoprestamos=tipoprestamoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrestamo(this.tipoprestamos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoPrestamosFK_IdTipoPrestamo(String sFinalQuery,Pagination pagination,Long id_rubro_emplea)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRubroEmplea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRubroEmplea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_rubro_emplea,TipoPrestamoConstantesFunciones.IDRUBROEMPLEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRubroEmplea);

			TipoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrestamo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoprestamos=tipoprestamoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrestamo(this.tipoprestamos);
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
			if(TipoPrestamoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoPrestamoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoPrestamo tipoprestamo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoPrestamoConstantesFunciones.ISCONAUDITORIA) {
				if(tipoprestamo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoPrestamoDataAccess.TABLENAME, tipoprestamo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoPrestamoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoPrestamoLogic.registrarAuditoriaDetallesTipoPrestamo(connexion,tipoprestamo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoprestamo.getIsDeleted()) {
					/*if(!tipoprestamo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoPrestamoDataAccess.TABLENAME, tipoprestamo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoPrestamoLogic.registrarAuditoriaDetallesTipoPrestamo(connexion,tipoprestamo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoPrestamoDataAccess.TABLENAME, tipoprestamo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoprestamo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoPrestamoDataAccess.TABLENAME, tipoprestamo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoPrestamoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoPrestamoLogic.registrarAuditoriaDetallesTipoPrestamo(connexion,tipoprestamo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoPrestamo(Connexion connexion,TipoPrestamo tipoprestamo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoprestamo.getIsNew()||!tipoprestamo.getid_empresa().equals(tipoprestamo.getTipoPrestamoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprestamo.getTipoPrestamoOriginal().getid_empresa()!=null)
				{
					strValorActual=tipoprestamo.getTipoPrestamoOriginal().getid_empresa().toString();
				}
				if(tipoprestamo.getid_empresa()!=null)
				{
					strValorNuevo=tipoprestamo.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoPrestamoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipoprestamo.getIsNew()||!tipoprestamo.getid_rubro_emplea().equals(tipoprestamo.getTipoPrestamoOriginal().getid_rubro_emplea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprestamo.getTipoPrestamoOriginal().getid_rubro_emplea()!=null)
				{
					strValorActual=tipoprestamo.getTipoPrestamoOriginal().getid_rubro_emplea().toString();
				}
				if(tipoprestamo.getid_rubro_emplea()!=null)
				{
					strValorNuevo=tipoprestamo.getid_rubro_emplea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoPrestamoConstantesFunciones.IDRUBROEMPLEA,strValorActual,strValorNuevo);
			}	
			
			if(tipoprestamo.getIsNew()||!tipoprestamo.getid_cuenta_contable().equals(tipoprestamo.getTipoPrestamoOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprestamo.getTipoPrestamoOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=tipoprestamo.getTipoPrestamoOriginal().getid_cuenta_contable().toString();
				}
				if(tipoprestamo.getid_cuenta_contable()!=null)
				{
					strValorNuevo=tipoprestamo.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoPrestamoConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(tipoprestamo.getIsNew()||!tipoprestamo.getcodigo().equals(tipoprestamo.getTipoPrestamoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprestamo.getTipoPrestamoOriginal().getcodigo()!=null)
				{
					strValorActual=tipoprestamo.getTipoPrestamoOriginal().getcodigo();
				}
				if(tipoprestamo.getcodigo()!=null)
				{
					strValorNuevo=tipoprestamo.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoPrestamoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoprestamo.getIsNew()||!tipoprestamo.getnombre().equals(tipoprestamo.getTipoPrestamoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprestamo.getTipoPrestamoOriginal().getnombre()!=null)
				{
					strValorActual=tipoprestamo.getTipoPrestamoOriginal().getnombre();
				}
				if(tipoprestamo.getnombre()!=null)
				{
					strValorNuevo=tipoprestamo.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoPrestamoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipoprestamo.getIsNew()||!tipoprestamo.getcon_pago().equals(tipoprestamo.getTipoPrestamoOriginal().getcon_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprestamo.getTipoPrestamoOriginal().getcon_pago()!=null)
				{
					strValorActual=tipoprestamo.getTipoPrestamoOriginal().getcon_pago().toString();
				}
				if(tipoprestamo.getcon_pago()!=null)
				{
					strValorNuevo=tipoprestamo.getcon_pago().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoPrestamoConstantesFunciones.CONPAGO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoPrestamoRelacionesWithConnection(TipoPrestamo tipoprestamo,List<Prestamo> prestamos) throws Exception {

		if(!tipoprestamo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoPrestamoRelacionesBase(tipoprestamo,prestamos,true);
		}
	}

	public void saveTipoPrestamoRelaciones(TipoPrestamo tipoprestamo,List<Prestamo> prestamos)throws Exception {

		if(!tipoprestamo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoPrestamoRelacionesBase(tipoprestamo,prestamos,false);
		}
	}

	public void saveTipoPrestamoRelacionesBase(TipoPrestamo tipoprestamo,List<Prestamo> prestamos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoPrestamo-saveRelacionesWithConnection");}
	
			tipoprestamo.setPrestamos(prestamos);

			this.setTipoPrestamo(tipoprestamo);

			if(TipoPrestamoLogicAdditional.validarSaveRelaciones(tipoprestamo,this)) {

				TipoPrestamoLogicAdditional.updateRelacionesToSave(tipoprestamo,this);

				if((tipoprestamo.getIsNew()||tipoprestamo.getIsChanged())&&!tipoprestamo.getIsDeleted()) {
					this.saveTipoPrestamo();
					this.saveTipoPrestamoRelacionesDetalles(prestamos);

				} else if(tipoprestamo.getIsDeleted()) {
					this.saveTipoPrestamoRelacionesDetalles(prestamos);
					this.saveTipoPrestamo();
				}

				TipoPrestamoLogicAdditional.updateRelacionesToSaveAfter(tipoprestamo,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			PrestamoConstantesFunciones.InicializarGeneralEntityAuxiliaresPrestamos(prestamos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoPrestamoRelacionesDetalles(List<Prestamo> prestamos)throws Exception {
		try {
	

			Long idTipoPrestamoActual=this.getTipoPrestamo().getId();

			PrestamoLogic prestamoLogic_Desde_TipoPrestamo=new PrestamoLogic();
			prestamoLogic_Desde_TipoPrestamo.setPrestamos(prestamos);

			prestamoLogic_Desde_TipoPrestamo.setConnexion(this.getConnexion());
			prestamoLogic_Desde_TipoPrestamo.setDatosCliente(this.datosCliente);

			for(Prestamo prestamo_Desde_TipoPrestamo:prestamoLogic_Desde_TipoPrestamo.getPrestamos()) {
				prestamo_Desde_TipoPrestamo.setid_tipo_prestamo(idTipoPrestamoActual);

				prestamoLogic_Desde_TipoPrestamo.setPrestamo(prestamo_Desde_TipoPrestamo);
				prestamoLogic_Desde_TipoPrestamo.savePrestamo();

				Long idPrestamoActual=prestamo_Desde_TipoPrestamo.getId();

				AbonoPrestamoLogic abonoprestamoLogic_Desde_Prestamo=new AbonoPrestamoLogic();

				if(prestamo_Desde_TipoPrestamo.getAbonoPrestamos()==null){
					prestamo_Desde_TipoPrestamo.setAbonoPrestamos(new ArrayList<AbonoPrestamo>());
				}

				abonoprestamoLogic_Desde_Prestamo.setAbonoPrestamos(prestamo_Desde_TipoPrestamo.getAbonoPrestamos());

				abonoprestamoLogic_Desde_Prestamo.setConnexion(this.getConnexion());
				abonoprestamoLogic_Desde_Prestamo.setDatosCliente(this.datosCliente);

				for(AbonoPrestamo abonoprestamo_Desde_Prestamo:abonoprestamoLogic_Desde_Prestamo.getAbonoPrestamos()) {
					abonoprestamo_Desde_Prestamo.setid_prestamo(idPrestamoActual);
				}

				abonoprestamoLogic_Desde_Prestamo.saveAbonoPrestamos();

				CuotaLogic cuotaLogic_Desde_Prestamo=new CuotaLogic();

				if(prestamo_Desde_TipoPrestamo.getCuotas()==null){
					prestamo_Desde_TipoPrestamo.setCuotas(new ArrayList<Cuota>());
				}

				cuotaLogic_Desde_Prestamo.setCuotas(prestamo_Desde_TipoPrestamo.getCuotas());

				cuotaLogic_Desde_Prestamo.setConnexion(this.getConnexion());
				cuotaLogic_Desde_Prestamo.setDatosCliente(this.datosCliente);

				for(Cuota cuota_Desde_Prestamo:cuotaLogic_Desde_Prestamo.getCuotas()) {
					cuota_Desde_Prestamo.setid_prestamo(idPrestamoActual);
				}

				cuotaLogic_Desde_Prestamo.saveCuotas();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoPrestamo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoPrestamoConstantesFunciones.getClassesForeignKeysOfTipoPrestamo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPrestamo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoPrestamoConstantesFunciones.getClassesRelationshipsOfTipoPrestamo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
