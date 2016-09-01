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
import com.bydan.erp.cartera.util.TipoNivelEduConstantesFunciones;
import com.bydan.erp.cartera.util.TipoNivelEduParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoNivelEduParameterGeneral;
import com.bydan.erp.cartera.business.entity.TipoNivelEdu;
import com.bydan.erp.cartera.business.logic.TipoNivelEduLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.sris.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.puntoventa.business.logic.*;
import com.bydan.erp.activosfijos.business.logic.*;
import com.bydan.erp.importaciones.business.logic.*;
import com.bydan.erp.produccion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.produccion.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoNivelEduLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoNivelEduLogic.class);
	
	protected TipoNivelEduDataAccess tiponiveleduDataAccess; 	
	protected TipoNivelEdu tiponiveledu;
	protected List<TipoNivelEdu> tiponiveledus;
	protected Object tiponiveleduObject;	
	protected List<Object> tiponiveledusObject;
	
	public static ClassValidator<TipoNivelEdu> tiponiveleduValidator = new ClassValidator<TipoNivelEdu>(TipoNivelEdu.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoNivelEduLogicAdditional tiponiveleduLogicAdditional=null;
	
	public TipoNivelEduLogicAdditional getTipoNivelEduLogicAdditional() {
		return this.tiponiveleduLogicAdditional;
	}
	
	public void setTipoNivelEduLogicAdditional(TipoNivelEduLogicAdditional tiponiveleduLogicAdditional) {
		try {
			this.tiponiveleduLogicAdditional=tiponiveleduLogicAdditional;
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
	
	
	
	
	public  TipoNivelEduLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tiponiveleduDataAccess = new TipoNivelEduDataAccess();
			
			this.tiponiveledus= new ArrayList<TipoNivelEdu>();
			this.tiponiveledu= new TipoNivelEdu();
			
			this.tiponiveleduObject=new Object();
			this.tiponiveledusObject=new ArrayList<Object>();
				
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
			
			this.tiponiveleduDataAccess.setConnexionType(this.connexionType);
			this.tiponiveleduDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoNivelEduLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tiponiveleduDataAccess = new TipoNivelEduDataAccess();
			this.tiponiveledus= new ArrayList<TipoNivelEdu>();
			this.tiponiveledu= new TipoNivelEdu();
			this.tiponiveleduObject=new Object();
			this.tiponiveledusObject=new ArrayList<Object>();
			
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
			
			this.tiponiveleduDataAccess.setConnexionType(this.connexionType);
			this.tiponiveleduDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoNivelEdu getTipoNivelEdu() throws Exception {	
		TipoNivelEduLogicAdditional.checkTipoNivelEduToGet(tiponiveledu,this.datosCliente,this.arrDatoGeneral);
		TipoNivelEduLogicAdditional.updateTipoNivelEduToGet(tiponiveledu,this.arrDatoGeneral);
		
		return tiponiveledu;
	}
		
	public void setTipoNivelEdu(TipoNivelEdu newTipoNivelEdu) {
		this.tiponiveledu = newTipoNivelEdu;
	}
	
	public TipoNivelEduDataAccess getTipoNivelEduDataAccess() {
		return tiponiveleduDataAccess;
	}
	
	public void setTipoNivelEduDataAccess(TipoNivelEduDataAccess newtiponiveleduDataAccess) {
		this.tiponiveleduDataAccess = newtiponiveleduDataAccess;
	}
	
	public List<TipoNivelEdu> getTipoNivelEdus() throws Exception {		
		this.quitarTipoNivelEdusNulos();
		
		TipoNivelEduLogicAdditional.checkTipoNivelEduToGets(tiponiveledus,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoNivelEdu tiponiveleduLocal: tiponiveledus ) {
			TipoNivelEduLogicAdditional.updateTipoNivelEduToGet(tiponiveleduLocal,this.arrDatoGeneral);
		}
		
		return tiponiveledus;
	}
	
	public void setTipoNivelEdus(List<TipoNivelEdu> newTipoNivelEdus) {
		this.tiponiveledus = newTipoNivelEdus;
	}
	
	public Object getTipoNivelEduObject() {	
		this.tiponiveleduObject=this.tiponiveleduDataAccess.getEntityObject();
		return this.tiponiveleduObject;
	}
		
	public void setTipoNivelEduObject(Object newTipoNivelEduObject) {
		this.tiponiveleduObject = newTipoNivelEduObject;
	}
	
	public List<Object> getTipoNivelEdusObject() {		
		this.tiponiveledusObject=this.tiponiveleduDataAccess.getEntitiesObject();
		return this.tiponiveledusObject;
	}
		
	public void setTipoNivelEdusObject(List<Object> newTipoNivelEdusObject) {
		this.tiponiveledusObject = newTipoNivelEdusObject;
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
		
		if(this.tiponiveleduDataAccess!=null) {
			this.tiponiveleduDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNivelEdu.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tiponiveleduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tiponiveleduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tiponiveledu = new  TipoNivelEdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNivelEdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiponiveledu=tiponiveleduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiponiveledu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoNivelEduConstantesFunciones.refrescarForeignKeysDescripcionesTipoNivelEdu(this.tiponiveledu);
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
		tiponiveledu = new  TipoNivelEdu();
		  		  
        try {
			
			tiponiveledu=tiponiveleduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiponiveledu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoNivelEduConstantesFunciones.refrescarForeignKeysDescripcionesTipoNivelEdu(this.tiponiveledu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tiponiveledu = new  TipoNivelEdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNivelEdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiponiveledu=tiponiveleduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiponiveledu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoNivelEduConstantesFunciones.refrescarForeignKeysDescripcionesTipoNivelEdu(this.tiponiveledu);
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
		tiponiveledu = new  TipoNivelEdu();
		  		  
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
		tiponiveledu = new  TipoNivelEdu();
		  		  
        try {
			
			tiponiveledu=tiponiveleduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiponiveledu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoNivelEduConstantesFunciones.refrescarForeignKeysDescripcionesTipoNivelEdu(this.tiponiveledu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tiponiveledu = new  TipoNivelEdu();
		  		  
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
		tiponiveledu = new  TipoNivelEdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNivelEdu.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tiponiveleduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiponiveledu = new  TipoNivelEdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tiponiveleduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiponiveledu = new  TipoNivelEdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNivelEdu.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tiponiveleduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiponiveledu = new  TipoNivelEdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tiponiveleduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiponiveledu = new  TipoNivelEdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNivelEdu.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tiponiveleduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiponiveledu = new  TipoNivelEdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tiponiveleduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiponiveledus = new  ArrayList<TipoNivelEdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNivelEdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoNivelEduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponiveledus=tiponiveleduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoNivelEdu(tiponiveledus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNivelEduConstantesFunciones.refrescarForeignKeysDescripcionesTipoNivelEdu(this.tiponiveledus);
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
		tiponiveledus = new  ArrayList<TipoNivelEdu>();
		  		  
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
		tiponiveledus = new  ArrayList<TipoNivelEdu>();
		  		  
        try {			
			TipoNivelEduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponiveledus=tiponiveleduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoNivelEdu(tiponiveledus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNivelEduConstantesFunciones.refrescarForeignKeysDescripcionesTipoNivelEdu(this.tiponiveledus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tiponiveledus = new  ArrayList<TipoNivelEdu>();
		  		  
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
		tiponiveledus = new  ArrayList<TipoNivelEdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNivelEdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoNivelEduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponiveledus=tiponiveleduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoNivelEdu(tiponiveledus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNivelEduConstantesFunciones.refrescarForeignKeysDescripcionesTipoNivelEdu(this.tiponiveledus);
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
		tiponiveledus = new  ArrayList<TipoNivelEdu>();
		  		  
        try {
			TipoNivelEduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponiveledus=tiponiveleduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoNivelEdu(tiponiveledus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNivelEduConstantesFunciones.refrescarForeignKeysDescripcionesTipoNivelEdu(this.tiponiveledus);
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
		tiponiveledus = new  ArrayList<TipoNivelEdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNivelEdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoNivelEduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponiveledus=tiponiveleduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoNivelEdu(tiponiveledus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNivelEduConstantesFunciones.refrescarForeignKeysDescripcionesTipoNivelEdu(this.tiponiveledus);
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
		tiponiveledus = new  ArrayList<TipoNivelEdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoNivelEduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponiveledus=tiponiveleduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoNivelEdu(tiponiveledus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNivelEduConstantesFunciones.refrescarForeignKeysDescripcionesTipoNivelEdu(this.tiponiveledus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tiponiveledu = new  TipoNivelEdu();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNivelEdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoNivelEduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponiveledu=tiponiveleduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoNivelEdu(tiponiveledu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNivelEduConstantesFunciones.refrescarForeignKeysDescripcionesTipoNivelEdu(this.tiponiveledu);
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
		tiponiveledu = new  TipoNivelEdu();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoNivelEduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponiveledu=tiponiveleduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoNivelEdu(tiponiveledu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNivelEduConstantesFunciones.refrescarForeignKeysDescripcionesTipoNivelEdu(this.tiponiveledu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiponiveledus = new  ArrayList<TipoNivelEdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNivelEdu.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoNivelEduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponiveledus=tiponiveleduDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoNivelEdu(tiponiveledus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNivelEduConstantesFunciones.refrescarForeignKeysDescripcionesTipoNivelEdu(this.tiponiveledus);
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
		tiponiveledus = new  ArrayList<TipoNivelEdu>();
		  		  
        try {
			TipoNivelEduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponiveledus=tiponiveleduDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoNivelEdu(tiponiveledus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNivelEduConstantesFunciones.refrescarForeignKeysDescripcionesTipoNivelEdu(this.tiponiveledus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoNivelEdusWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tiponiveledus = new  ArrayList<TipoNivelEdu>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNivelEdu.class.getSimpleName()+"-getTodosTipoNivelEdusWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoNivelEduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponiveledus=tiponiveleduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoNivelEdu(tiponiveledus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNivelEduConstantesFunciones.refrescarForeignKeysDescripcionesTipoNivelEdu(this.tiponiveledus);
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
	
	public  void  getTodosTipoNivelEdus(String sFinalQuery,Pagination pagination)throws Exception {
		tiponiveledus = new  ArrayList<TipoNivelEdu>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoNivelEduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponiveledus=tiponiveleduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoNivelEdu(tiponiveledus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNivelEduConstantesFunciones.refrescarForeignKeysDescripcionesTipoNivelEdu(this.tiponiveledus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoNivelEdu(TipoNivelEdu tiponiveledu) throws Exception {
		Boolean estaValidado=false;
		
		if(tiponiveledu.getIsNew() || tiponiveledu.getIsChanged()) { 
			this.invalidValues = tiponiveleduValidator.getInvalidValues(tiponiveledu);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tiponiveledu);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoNivelEdu(List<TipoNivelEdu> TipoNivelEdus) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoNivelEdu tiponiveleduLocal:tiponiveledus) {				
			estaValidadoObjeto=this.validarGuardarTipoNivelEdu(tiponiveleduLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoNivelEdu(List<TipoNivelEdu> TipoNivelEdus) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoNivelEdu(tiponiveledus)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoNivelEdu(TipoNivelEdu TipoNivelEdu) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoNivelEdu(tiponiveledu)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoNivelEdu tiponiveledu) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tiponiveledu.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoNivelEduConstantesFunciones.getTipoNivelEduLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tiponiveledu","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoNivelEduConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoNivelEduConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoNivelEduWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNivelEdu.class.getSimpleName()+"-saveTipoNivelEduWithConnection");connexion.begin();			
			
			TipoNivelEduLogicAdditional.checkTipoNivelEduToSave(this.tiponiveledu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoNivelEduLogicAdditional.updateTipoNivelEduToSave(this.tiponiveledu,this.arrDatoGeneral);
			
			TipoNivelEduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiponiveledu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoNivelEdu();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoNivelEdu(this.tiponiveledu)) {
				TipoNivelEduDataAccess.save(this.tiponiveledu, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tiponiveledu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoNivelEduLogicAdditional.checkTipoNivelEduToSaveAfter(this.tiponiveledu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoNivelEdu();
			
			connexion.commit();			
			
			if(this.tiponiveledu.getIsDeleted()) {
				this.tiponiveledu=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoNivelEdu()throws Exception {	
		try {	
			
			TipoNivelEduLogicAdditional.checkTipoNivelEduToSave(this.tiponiveledu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoNivelEduLogicAdditional.updateTipoNivelEduToSave(this.tiponiveledu,this.arrDatoGeneral);
			
			TipoNivelEduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiponiveledu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoNivelEdu(this.tiponiveledu)) {			
				TipoNivelEduDataAccess.save(this.tiponiveledu, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tiponiveledu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoNivelEduLogicAdditional.checkTipoNivelEduToSaveAfter(this.tiponiveledu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tiponiveledu.getIsDeleted()) {
				this.tiponiveledu=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoNivelEdusWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNivelEdu.class.getSimpleName()+"-saveTipoNivelEdusWithConnection");connexion.begin();			
			
			TipoNivelEduLogicAdditional.checkTipoNivelEduToSaves(tiponiveledus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoNivelEdus();
			
			Boolean validadoTodosTipoNivelEdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoNivelEdu tiponiveleduLocal:tiponiveledus) {		
				if(tiponiveleduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoNivelEduLogicAdditional.updateTipoNivelEduToSave(tiponiveleduLocal,this.arrDatoGeneral);
	        	
				TipoNivelEduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiponiveleduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoNivelEdu(tiponiveleduLocal)) {
					TipoNivelEduDataAccess.save(tiponiveleduLocal, connexion);				
				} else {
					validadoTodosTipoNivelEdu=false;
				}
			}
			
			if(!validadoTodosTipoNivelEdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoNivelEduLogicAdditional.checkTipoNivelEduToSavesAfter(tiponiveledus,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoNivelEdus();
			
			connexion.commit();		
			
			this.quitarTipoNivelEdusEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoNivelEdus()throws Exception {				
		 try {	
			TipoNivelEduLogicAdditional.checkTipoNivelEduToSaves(tiponiveledus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoNivelEdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoNivelEdu tiponiveleduLocal:tiponiveledus) {				
				if(tiponiveleduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoNivelEduLogicAdditional.updateTipoNivelEduToSave(tiponiveleduLocal,this.arrDatoGeneral);
	        	
				TipoNivelEduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiponiveleduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoNivelEdu(tiponiveleduLocal)) {				
					TipoNivelEduDataAccess.save(tiponiveleduLocal, connexion);				
				} else {
					validadoTodosTipoNivelEdu=false;
				}
			}
			
			if(!validadoTodosTipoNivelEdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoNivelEduLogicAdditional.checkTipoNivelEduToSavesAfter(tiponiveledus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoNivelEdusEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoNivelEduParameterReturnGeneral procesarAccionTipoNivelEdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoNivelEdu> tiponiveledus,TipoNivelEduParameterReturnGeneral tiponiveleduParameterGeneral)throws Exception {
		 try {	
			TipoNivelEduParameterReturnGeneral tiponiveleduReturnGeneral=new TipoNivelEduParameterReturnGeneral();
	
			TipoNivelEduLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tiponiveledus,tiponiveleduParameterGeneral,tiponiveleduReturnGeneral);
			
			return tiponiveleduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoNivelEduParameterReturnGeneral procesarAccionTipoNivelEdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoNivelEdu> tiponiveledus,TipoNivelEduParameterReturnGeneral tiponiveleduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNivelEdu.class.getSimpleName()+"-procesarAccionTipoNivelEdusWithConnection");connexion.begin();			
			
			TipoNivelEduParameterReturnGeneral tiponiveleduReturnGeneral=new TipoNivelEduParameterReturnGeneral();
	
			TipoNivelEduLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tiponiveledus,tiponiveleduParameterGeneral,tiponiveleduReturnGeneral);
			
			this.connexion.commit();
			
			return tiponiveleduReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoNivelEduParameterReturnGeneral procesarEventosTipoNivelEdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoNivelEdu> tiponiveledus,TipoNivelEdu tiponiveledu,TipoNivelEduParameterReturnGeneral tiponiveleduParameterGeneral,Boolean isEsNuevoTipoNivelEdu,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoNivelEduParameterReturnGeneral tiponiveleduReturnGeneral=new TipoNivelEduParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiponiveleduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoNivelEduLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tiponiveledus,tiponiveledu,tiponiveleduParameterGeneral,tiponiveleduReturnGeneral,isEsNuevoTipoNivelEdu,clases);
			
			return tiponiveleduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoNivelEduParameterReturnGeneral procesarEventosTipoNivelEdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoNivelEdu> tiponiveledus,TipoNivelEdu tiponiveledu,TipoNivelEduParameterReturnGeneral tiponiveleduParameterGeneral,Boolean isEsNuevoTipoNivelEdu,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNivelEdu.class.getSimpleName()+"-procesarEventosTipoNivelEdusWithConnection");connexion.begin();			
			
			TipoNivelEduParameterReturnGeneral tiponiveleduReturnGeneral=new TipoNivelEduParameterReturnGeneral();
	
			tiponiveleduReturnGeneral.setTipoNivelEdu(tiponiveledu);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiponiveleduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoNivelEduLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tiponiveledus,tiponiveledu,tiponiveleduParameterGeneral,tiponiveleduReturnGeneral,isEsNuevoTipoNivelEdu,clases);
			
			this.connexion.commit();
			
			return tiponiveleduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoNivelEduParameterReturnGeneral procesarImportacionTipoNivelEdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoNivelEduParameterReturnGeneral tiponiveleduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNivelEdu.class.getSimpleName()+"-procesarImportacionTipoNivelEdusWithConnection");connexion.begin();			
			
			TipoNivelEduParameterReturnGeneral tiponiveleduReturnGeneral=new TipoNivelEduParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tiponiveledus=new ArrayList<TipoNivelEdu>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tiponiveledu=new TipoNivelEdu();
				
				
				if(conColumnasBase) {this.tiponiveledu.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tiponiveledu.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tiponiveledu.setcodigo(arrColumnas[iColumn++]);
				this.tiponiveledu.setnombre(arrColumnas[iColumn++]);
				this.tiponiveledu.setes_defecto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.tiponiveledus.add(this.tiponiveledu);
			}
			
			this.saveTipoNivelEdus();
			
			this.connexion.commit();
			
			tiponiveleduReturnGeneral.setConRetornoEstaProcesado(true);
			tiponiveleduReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tiponiveleduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoNivelEdusEliminados() throws Exception {				
		
		List<TipoNivelEdu> tiponiveledusAux= new ArrayList<TipoNivelEdu>();
		
		for(TipoNivelEdu tiponiveledu:tiponiveledus) {
			if(!tiponiveledu.getIsDeleted()) {
				tiponiveledusAux.add(tiponiveledu);
			}
		}
		
		tiponiveledus=tiponiveledusAux;
	}
	
	public void quitarTipoNivelEdusNulos() throws Exception {				
		
		List<TipoNivelEdu> tiponiveledusAux= new ArrayList<TipoNivelEdu>();
		
		for(TipoNivelEdu tiponiveledu : this.tiponiveledus) {
			if(tiponiveledu==null) {
				tiponiveledusAux.add(tiponiveledu);
			}
		}
		
		//this.tiponiveledus=tiponiveledusAux;
		
		this.tiponiveledus.removeAll(tiponiveledusAux);
	}
	
	public void getSetVersionRowTipoNivelEduWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tiponiveledu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tiponiveledu.getIsDeleted() || (tiponiveledu.getIsChanged()&&!tiponiveledu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tiponiveleduDataAccess.getSetVersionRowTipoNivelEdu(connexion,tiponiveledu.getId());
				
				if(!tiponiveledu.getVersionRow().equals(timestamp)) {	
					tiponiveledu.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tiponiveledu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoNivelEdu()throws Exception {	
		
		if(tiponiveledu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tiponiveledu.getIsDeleted() || (tiponiveledu.getIsChanged()&&!tiponiveledu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tiponiveleduDataAccess.getSetVersionRowTipoNivelEdu(connexion,tiponiveledu.getId());
			
			try {							
				if(!tiponiveledu.getVersionRow().equals(timestamp)) {	
					tiponiveledu.setVersionRow(timestamp);
				}
				
				tiponiveledu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoNivelEdusWithConnection()throws Exception {	
		if(tiponiveledus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoNivelEdu tiponiveleduAux:tiponiveledus) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tiponiveleduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiponiveleduAux.getIsDeleted() || (tiponiveleduAux.getIsChanged()&&!tiponiveleduAux.getIsNew())) {
						
						timestamp=tiponiveleduDataAccess.getSetVersionRowTipoNivelEdu(connexion,tiponiveleduAux.getId());
						
						if(!tiponiveledu.getVersionRow().equals(timestamp)) {	
							tiponiveleduAux.setVersionRow(timestamp);
						}
								
						tiponiveleduAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoNivelEdus()throws Exception {	
		if(tiponiveledus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoNivelEdu tiponiveleduAux:tiponiveledus) {
					if(tiponiveleduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiponiveleduAux.getIsDeleted() || (tiponiveleduAux.getIsChanged()&&!tiponiveleduAux.getIsNew())) {
						
						timestamp=tiponiveleduDataAccess.getSetVersionRowTipoNivelEdu(connexion,tiponiveleduAux.getId());
						
						if(!tiponiveleduAux.getVersionRow().equals(timestamp)) {	
							tiponiveleduAux.setVersionRow(timestamp);
						}
						
													
						tiponiveleduAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoNivelEduParameterReturnGeneral cargarCombosLoteForeignKeyTipoNivelEduWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoNivelEduParameterReturnGeneral  tiponiveleduReturnGeneral =new TipoNivelEduParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNivelEdu.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoNivelEduWithConnection");connexion.begin();
			
			tiponiveleduReturnGeneral =new TipoNivelEduParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tiponiveleduReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tiponiveleduReturnGeneral;
	}
	
	public TipoNivelEduParameterReturnGeneral cargarCombosLoteForeignKeyTipoNivelEdu(String finalQueryGlobalEmpresa) throws Exception {
		TipoNivelEduParameterReturnGeneral  tiponiveleduReturnGeneral =new TipoNivelEduParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tiponiveleduReturnGeneral =new TipoNivelEduParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tiponiveleduReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tiponiveleduReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoNivelEduWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ClienteLogic clienteLogic=new ClienteLogic();
			SubClienteLogic subclienteLogic=new SubClienteLogic();
			ParametroCarteraDefectoLogic parametrocarteradefectoLogic=new ParametroCarteraDefectoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNivelEdu.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoNivelEduWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Cliente.class));
			classes.add(new Classe(SubCliente.class));
			classes.add(new Classe(ParametroCarteraDefecto.class));
											
			

			clienteLogic.setConnexion(this.getConnexion());
			clienteLogic.setDatosCliente(this.datosCliente);
			clienteLogic.setIsConRefrescarForeignKeys(true);

			subclienteLogic.setConnexion(this.getConnexion());
			subclienteLogic.setDatosCliente(this.datosCliente);
			subclienteLogic.setIsConRefrescarForeignKeys(true);

			parametrocarteradefectoLogic.setConnexion(this.getConnexion());
			parametrocarteradefectoLogic.setDatosCliente(this.datosCliente);
			parametrocarteradefectoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoNivelEdu tiponiveledu:this.tiponiveledus) {
				

				classes=new ArrayList<Classe>();
				classes=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				clienteLogic.setClientes(tiponiveledu.clientes);
				clienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=SubClienteConstantesFunciones.getClassesForeignKeysOfSubCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				subclienteLogic.setSubClientes(tiponiveledu.subclientes);
				subclienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ParametroCarteraDefectoConstantesFunciones.getClassesForeignKeysOfParametroCarteraDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametrocarteradefectoLogic.setParametroCarteraDefectos(tiponiveledu.parametrocarteradefectos);
				parametrocarteradefectoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoNivelEdu tiponiveledu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoNivelEduLogicAdditional.updateTipoNivelEduToGet(tiponiveledu,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tiponiveledu.setEmpresa(tiponiveleduDataAccess.getEmpresa(connexion,tiponiveledu));
		tiponiveledu.setClientes(tiponiveleduDataAccess.getClientes(connexion,tiponiveledu));
		tiponiveledu.setSubClientes(tiponiveleduDataAccess.getSubClientes(connexion,tiponiveledu));
		tiponiveledu.setParametroCarteraDefectos(tiponiveleduDataAccess.getParametroCarteraDefectos(connexion,tiponiveledu));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tiponiveledu.setEmpresa(tiponiveleduDataAccess.getEmpresa(connexion,tiponiveledu));
				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiponiveledu.setClientes(tiponiveleduDataAccess.getClientes(connexion,tiponiveledu));

				if(this.isConDeep) {
					ClienteLogic clienteLogic= new ClienteLogic(this.connexion);
					clienteLogic.setClientes(tiponiveledu.getClientes());
					ArrayList<Classe> classesLocal=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					clienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(clienteLogic.getClientes());
					tiponiveledu.setClientes(clienteLogic.getClientes());
				}

				continue;
			}

			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiponiveledu.setSubClientes(tiponiveleduDataAccess.getSubClientes(connexion,tiponiveledu));

				if(this.isConDeep) {
					SubClienteLogic subclienteLogic= new SubClienteLogic(this.connexion);
					subclienteLogic.setSubClientes(tiponiveledu.getSubClientes());
					ArrayList<Classe> classesLocal=SubClienteConstantesFunciones.getClassesForeignKeysOfSubCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					subclienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(subclienteLogic.getSubClientes());
					tiponiveledu.setSubClientes(subclienteLogic.getSubClientes());
				}

				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiponiveledu.setParametroCarteraDefectos(tiponiveleduDataAccess.getParametroCarteraDefectos(connexion,tiponiveledu));

				if(this.isConDeep) {
					ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(this.connexion);
					parametrocarteradefectoLogic.setParametroCarteraDefectos(tiponiveledu.getParametroCarteraDefectos());
					ArrayList<Classe> classesLocal=ParametroCarteraDefectoConstantesFunciones.getClassesForeignKeysOfParametroCarteraDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametrocarteradefectoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(parametrocarteradefectoLogic.getParametroCarteraDefectos());
					tiponiveledu.setParametroCarteraDefectos(parametrocarteradefectoLogic.getParametroCarteraDefectos());
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
			tiponiveledu.setEmpresa(tiponiveleduDataAccess.getEmpresa(connexion,tiponiveledu));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Cliente.class));
			tiponiveledu.setClientes(tiponiveleduDataAccess.getClientes(connexion,tiponiveledu));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SubCliente.class));
			tiponiveledu.setSubClientes(tiponiveleduDataAccess.getSubClientes(connexion,tiponiveledu));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroCarteraDefecto.class));
			tiponiveledu.setParametroCarteraDefectos(tiponiveleduDataAccess.getParametroCarteraDefectos(connexion,tiponiveledu));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tiponiveledu.setEmpresa(tiponiveleduDataAccess.getEmpresa(connexion,tiponiveledu));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tiponiveledu.getEmpresa(),isDeep,deepLoadType,clases);
				

		tiponiveledu.setClientes(tiponiveleduDataAccess.getClientes(connexion,tiponiveledu));

		for(Cliente cliente:tiponiveledu.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
		}

		tiponiveledu.setSubClientes(tiponiveleduDataAccess.getSubClientes(connexion,tiponiveledu));

		for(SubCliente subcliente:tiponiveledu.getSubClientes()) {
			SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
			subclienteLogic.deepLoad(subcliente,isDeep,deepLoadType,clases);
		}

		tiponiveledu.setParametroCarteraDefectos(tiponiveleduDataAccess.getParametroCarteraDefectos(connexion,tiponiveledu));

		for(ParametroCarteraDefecto parametrocarteradefecto:tiponiveledu.getParametroCarteraDefectos()) {
			ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
			parametrocarteradefectoLogic.deepLoad(parametrocarteradefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tiponiveledu.setEmpresa(tiponiveleduDataAccess.getEmpresa(connexion,tiponiveledu));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tiponiveledu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiponiveledu.setClientes(tiponiveleduDataAccess.getClientes(connexion,tiponiveledu));

				for(Cliente cliente:tiponiveledu.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiponiveledu.setSubClientes(tiponiveleduDataAccess.getSubClientes(connexion,tiponiveledu));

				for(SubCliente subcliente:tiponiveledu.getSubClientes()) {
					SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
					subclienteLogic.deepLoad(subcliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiponiveledu.setParametroCarteraDefectos(tiponiveleduDataAccess.getParametroCarteraDefectos(connexion,tiponiveledu));

				for(ParametroCarteraDefecto parametrocarteradefecto:tiponiveledu.getParametroCarteraDefectos()) {
					ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
					parametrocarteradefectoLogic.deepLoad(parametrocarteradefecto,isDeep,deepLoadType,clases);
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
			tiponiveledu.setEmpresa(tiponiveleduDataAccess.getEmpresa(connexion,tiponiveledu));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tiponiveledu.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Cliente.class));
			tiponiveledu.setClientes(tiponiveleduDataAccess.getClientes(connexion,tiponiveledu));

			for(Cliente cliente:tiponiveledu.getClientes()) {
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SubCliente.class));
			tiponiveledu.setSubClientes(tiponiveleduDataAccess.getSubClientes(connexion,tiponiveledu));

			for(SubCliente subcliente:tiponiveledu.getSubClientes()) {
				SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
				subclienteLogic.deepLoad(subcliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroCarteraDefecto.class));
			tiponiveledu.setParametroCarteraDefectos(tiponiveleduDataAccess.getParametroCarteraDefectos(connexion,tiponiveledu));

			for(ParametroCarteraDefecto parametrocarteradefecto:tiponiveledu.getParametroCarteraDefectos()) {
				ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
				parametrocarteradefectoLogic.deepLoad(parametrocarteradefecto,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoNivelEdu tiponiveledu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoNivelEduLogicAdditional.updateTipoNivelEduToSave(tiponiveledu,this.arrDatoGeneral);
			
TipoNivelEduDataAccess.save(tiponiveledu, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tiponiveledu.getEmpresa(),connexion);

		for(Cliente cliente:tiponiveledu.getClientes()) {
			cliente.setid_tipo_nivel_edu(tiponiveledu.getId());
			ClienteDataAccess.save(cliente,connexion);
		}

		for(SubCliente subcliente:tiponiveledu.getSubClientes()) {
			subcliente.setid_tipo_nivel_edu(tiponiveledu.getId());
			SubClienteDataAccess.save(subcliente,connexion);
		}

		for(ParametroCarteraDefecto parametrocarteradefecto:tiponiveledu.getParametroCarteraDefectos()) {
			parametrocarteradefecto.setid_tipo_nivel_edu(tiponiveledu.getId());
			ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tiponiveledu.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:tiponiveledu.getClientes()) {
					cliente.setid_tipo_nivel_edu(tiponiveledu.getId());
					ClienteDataAccess.save(cliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SubCliente subcliente:tiponiveledu.getSubClientes()) {
					subcliente.setid_tipo_nivel_edu(tiponiveledu.getId());
					SubClienteDataAccess.save(subcliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroCarteraDefecto parametrocarteradefecto:tiponiveledu.getParametroCarteraDefectos()) {
					parametrocarteradefecto.setid_tipo_nivel_edu(tiponiveledu.getId());
					ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tiponiveledu.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tiponiveledu.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(Cliente cliente:tiponiveledu.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			cliente.setid_tipo_nivel_edu(tiponiveledu.getId());
			ClienteDataAccess.save(cliente,connexion);
			clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
		}

		for(SubCliente subcliente:tiponiveledu.getSubClientes()) {
			SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
			subcliente.setid_tipo_nivel_edu(tiponiveledu.getId());
			SubClienteDataAccess.save(subcliente,connexion);
			subclienteLogic.deepSave(subcliente,isDeep,deepLoadType,clases);
		}

		for(ParametroCarteraDefecto parametrocarteradefecto:tiponiveledu.getParametroCarteraDefectos()) {
			ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
			parametrocarteradefecto.setid_tipo_nivel_edu(tiponiveledu.getId());
			ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
			parametrocarteradefectoLogic.deepSave(parametrocarteradefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tiponiveledu.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tiponiveledu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:tiponiveledu.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					cliente.setid_tipo_nivel_edu(tiponiveledu.getId());
					ClienteDataAccess.save(cliente,connexion);
					clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SubCliente subcliente:tiponiveledu.getSubClientes()) {
					SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
					subcliente.setid_tipo_nivel_edu(tiponiveledu.getId());
					SubClienteDataAccess.save(subcliente,connexion);
					subclienteLogic.deepSave(subcliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroCarteraDefecto parametrocarteradefecto:tiponiveledu.getParametroCarteraDefectos()) {
					ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
					parametrocarteradefecto.setid_tipo_nivel_edu(tiponiveledu.getId());
					ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
					parametrocarteradefectoLogic.deepSave(parametrocarteradefecto,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoNivelEdu.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tiponiveledu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoNivelEduConstantesFunciones.refrescarForeignKeysDescripcionesTipoNivelEdu(tiponiveledu);
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
			this.deepLoad(this.tiponiveledu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoNivelEduConstantesFunciones.refrescarForeignKeysDescripcionesTipoNivelEdu(this.tiponiveledu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoNivelEdu.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tiponiveledus!=null) {
				for(TipoNivelEdu tiponiveledu:tiponiveledus) {
					this.deepLoad(tiponiveledu,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoNivelEduConstantesFunciones.refrescarForeignKeysDescripcionesTipoNivelEdu(tiponiveledus);
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
			if(tiponiveledus!=null) {
				for(TipoNivelEdu tiponiveledu:tiponiveledus) {
					this.deepLoad(tiponiveledu,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoNivelEduConstantesFunciones.refrescarForeignKeysDescripcionesTipoNivelEdu(tiponiveledus);
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
			this.getNewConnexionToDeep(TipoNivelEdu.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tiponiveledu,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoNivelEdu.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tiponiveledus!=null) {
				for(TipoNivelEdu tiponiveledu:tiponiveledus) {
					this.deepSave(tiponiveledu,isDeep,deepLoadType,clases);
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
			if(tiponiveledus!=null) {
				for(TipoNivelEdu tiponiveledu:tiponiveledus) {
					this.deepSave(tiponiveledu,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoNivelEdusFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNivelEdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoNivelEduConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoNivelEduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiponiveledus=tiponiveleduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoNivelEduConstantesFunciones.refrescarForeignKeysDescripcionesTipoNivelEdu(this.tiponiveledus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoNivelEdusFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoNivelEduConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoNivelEduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiponiveledus=tiponiveleduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoNivelEduConstantesFunciones.refrescarForeignKeysDescripcionesTipoNivelEdu(this.tiponiveledus);
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
			if(TipoNivelEduConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoNivelEduDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoNivelEdu tiponiveledu,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoNivelEduConstantesFunciones.ISCONAUDITORIA) {
				if(tiponiveledu.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoNivelEduDataAccess.TABLENAME, tiponiveledu.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoNivelEduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoNivelEduLogic.registrarAuditoriaDetallesTipoNivelEdu(connexion,tiponiveledu,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tiponiveledu.getIsDeleted()) {
					/*if(!tiponiveledu.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoNivelEduDataAccess.TABLENAME, tiponiveledu.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoNivelEduLogic.registrarAuditoriaDetallesTipoNivelEdu(connexion,tiponiveledu,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoNivelEduDataAccess.TABLENAME, tiponiveledu.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tiponiveledu.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoNivelEduDataAccess.TABLENAME, tiponiveledu.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoNivelEduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoNivelEduLogic.registrarAuditoriaDetallesTipoNivelEdu(connexion,tiponiveledu,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoNivelEdu(Connexion connexion,TipoNivelEdu tiponiveledu)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tiponiveledu.getIsNew()||!tiponiveledu.getid_empresa().equals(tiponiveledu.getTipoNivelEduOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiponiveledu.getTipoNivelEduOriginal().getid_empresa()!=null)
				{
					strValorActual=tiponiveledu.getTipoNivelEduOriginal().getid_empresa().toString();
				}
				if(tiponiveledu.getid_empresa()!=null)
				{
					strValorNuevo=tiponiveledu.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoNivelEduConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tiponiveledu.getIsNew()||!tiponiveledu.getcodigo().equals(tiponiveledu.getTipoNivelEduOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiponiveledu.getTipoNivelEduOriginal().getcodigo()!=null)
				{
					strValorActual=tiponiveledu.getTipoNivelEduOriginal().getcodigo();
				}
				if(tiponiveledu.getcodigo()!=null)
				{
					strValorNuevo=tiponiveledu.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoNivelEduConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tiponiveledu.getIsNew()||!tiponiveledu.getnombre().equals(tiponiveledu.getTipoNivelEduOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiponiveledu.getTipoNivelEduOriginal().getnombre()!=null)
				{
					strValorActual=tiponiveledu.getTipoNivelEduOriginal().getnombre();
				}
				if(tiponiveledu.getnombre()!=null)
				{
					strValorNuevo=tiponiveledu.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoNivelEduConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tiponiveledu.getIsNew()||!tiponiveledu.getes_defecto().equals(tiponiveledu.getTipoNivelEduOriginal().getes_defecto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiponiveledu.getTipoNivelEduOriginal().getes_defecto()!=null)
				{
					strValorActual=tiponiveledu.getTipoNivelEduOriginal().getes_defecto().toString();
				}
				if(tiponiveledu.getes_defecto()!=null)
				{
					strValorNuevo=tiponiveledu.getes_defecto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoNivelEduConstantesFunciones.ESDEFECTO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoNivelEduRelacionesWithConnection(TipoNivelEdu tiponiveledu,List<Cliente> clientes,List<SubCliente> subclientes,List<ParametroCarteraDefecto> parametrocarteradefectos) throws Exception {

		if(!tiponiveledu.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoNivelEduRelacionesBase(tiponiveledu,clientes,subclientes,parametrocarteradefectos,true);
		}
	}

	public void saveTipoNivelEduRelaciones(TipoNivelEdu tiponiveledu,List<Cliente> clientes,List<SubCliente> subclientes,List<ParametroCarteraDefecto> parametrocarteradefectos)throws Exception {

		if(!tiponiveledu.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoNivelEduRelacionesBase(tiponiveledu,clientes,subclientes,parametrocarteradefectos,false);
		}
	}

	public void saveTipoNivelEduRelacionesBase(TipoNivelEdu tiponiveledu,List<Cliente> clientes,List<SubCliente> subclientes,List<ParametroCarteraDefecto> parametrocarteradefectos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoNivelEdu-saveRelacionesWithConnection");}
	
			tiponiveledu.setClientes(clientes);
			tiponiveledu.setSubClientes(subclientes);
			tiponiveledu.setParametroCarteraDefectos(parametrocarteradefectos);

			this.setTipoNivelEdu(tiponiveledu);

			if(TipoNivelEduLogicAdditional.validarSaveRelaciones(tiponiveledu,this)) {

				TipoNivelEduLogicAdditional.updateRelacionesToSave(tiponiveledu,this);

				if((tiponiveledu.getIsNew()||tiponiveledu.getIsChanged())&&!tiponiveledu.getIsDeleted()) {
					this.saveTipoNivelEdu();
					this.saveTipoNivelEduRelacionesDetalles(clientes,subclientes,parametrocarteradefectos);

				} else if(tiponiveledu.getIsDeleted()) {
					this.saveTipoNivelEduRelacionesDetalles(clientes,subclientes,parametrocarteradefectos);
					this.saveTipoNivelEdu();
				}

				TipoNivelEduLogicAdditional.updateRelacionesToSaveAfter(tiponiveledu,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresClientes(clientes,true,true);
			SubClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresSubClientes(subclientes,true,true);
			ParametroCarteraDefectoConstantesFunciones.InicializarGeneralEntityAuxiliaresParametroCarteraDefectos(parametrocarteradefectos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoNivelEduRelacionesDetalles(List<Cliente> clientes,List<SubCliente> subclientes,List<ParametroCarteraDefecto> parametrocarteradefectos)throws Exception {
		try {
	

			Long idTipoNivelEduActual=this.getTipoNivelEdu().getId();

			ClienteLogic clienteLogic_Desde_TipoNivelEdu=new ClienteLogic();
			clienteLogic_Desde_TipoNivelEdu.setClientes(clientes);

			clienteLogic_Desde_TipoNivelEdu.setConnexion(this.getConnexion());
			clienteLogic_Desde_TipoNivelEdu.setDatosCliente(this.datosCliente);

			for(Cliente cliente_Desde_TipoNivelEdu:clienteLogic_Desde_TipoNivelEdu.getClientes()) {
				cliente_Desde_TipoNivelEdu.setid_tipo_nivel_edu(idTipoNivelEduActual);

				clienteLogic_Desde_TipoNivelEdu.setCliente(cliente_Desde_TipoNivelEdu);
				clienteLogic_Desde_TipoNivelEdu.saveCliente();
			}


			SubClienteLogic subclienteLogic_Desde_TipoNivelEdu=new SubClienteLogic();
			subclienteLogic_Desde_TipoNivelEdu.setSubClientes(subclientes);

			subclienteLogic_Desde_TipoNivelEdu.setConnexion(this.getConnexion());
			subclienteLogic_Desde_TipoNivelEdu.setDatosCliente(this.datosCliente);

			for(SubCliente subcliente_Desde_TipoNivelEdu:subclienteLogic_Desde_TipoNivelEdu.getSubClientes()) {
				subcliente_Desde_TipoNivelEdu.setid_tipo_nivel_edu(idTipoNivelEduActual);

				subclienteLogic_Desde_TipoNivelEdu.setSubCliente(subcliente_Desde_TipoNivelEdu);
				subclienteLogic_Desde_TipoNivelEdu.saveSubCliente();
			}


			ParametroCarteraDefectoLogic parametrocarteradefectoLogic_Desde_TipoNivelEdu=new ParametroCarteraDefectoLogic();
			parametrocarteradefectoLogic_Desde_TipoNivelEdu.setParametroCarteraDefectos(parametrocarteradefectos);

			parametrocarteradefectoLogic_Desde_TipoNivelEdu.setConnexion(this.getConnexion());
			parametrocarteradefectoLogic_Desde_TipoNivelEdu.setDatosCliente(this.datosCliente);

			for(ParametroCarteraDefecto parametrocarteradefecto_Desde_TipoNivelEdu:parametrocarteradefectoLogic_Desde_TipoNivelEdu.getParametroCarteraDefectos()) {
				parametrocarteradefecto_Desde_TipoNivelEdu.setid_tipo_nivel_edu(idTipoNivelEduActual);
			}

			parametrocarteradefectoLogic_Desde_TipoNivelEdu.saveParametroCarteraDefectos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoNivelEdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoNivelEduConstantesFunciones.getClassesForeignKeysOfTipoNivelEdu(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoNivelEdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoNivelEduConstantesFunciones.getClassesRelationshipsOfTipoNivelEdu(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
