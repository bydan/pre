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
package com.bydan.erp.contabilidad.business.logic;

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
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.contabilidad.util.TipoGrupoFlujoCajaConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoGrupoFlujoCajaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoGrupoFlujoCajaParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.TipoGrupoFlujoCaja;
//import com.bydan.erp.contabilidad.business.logic.TipoGrupoFlujoCajaLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.sris.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.puntoventa.business.logic.*;
import com.bydan.erp.activosfijos.business.logic.*;
import com.bydan.erp.importaciones.business.logic.*;
import com.bydan.erp.produccion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.produccion.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoGrupoFlujoCajaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoGrupoFlujoCajaLogic.class);
	
	protected TipoGrupoFlujoCajaDataAccess tipogrupoflujocajaDataAccess; 	
	protected TipoGrupoFlujoCaja tipogrupoflujocaja;
	protected List<TipoGrupoFlujoCaja> tipogrupoflujocajas;
	protected Object tipogrupoflujocajaObject;	
	protected List<Object> tipogrupoflujocajasObject;
	
	public static ClassValidator<TipoGrupoFlujoCaja> tipogrupoflujocajaValidator = new ClassValidator<TipoGrupoFlujoCaja>(TipoGrupoFlujoCaja.class);	
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
	
	
	
	
	public  TipoGrupoFlujoCajaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipogrupoflujocajaDataAccess = new TipoGrupoFlujoCajaDataAccess();
			
			this.tipogrupoflujocajas= new ArrayList<TipoGrupoFlujoCaja>();
			this.tipogrupoflujocaja= new TipoGrupoFlujoCaja();
			
			this.tipogrupoflujocajaObject=new Object();
			this.tipogrupoflujocajasObject=new ArrayList<Object>();
				
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
			
			this.tipogrupoflujocajaDataAccess.setConnexionType(this.connexionType);
			this.tipogrupoflujocajaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoGrupoFlujoCajaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipogrupoflujocajaDataAccess = new TipoGrupoFlujoCajaDataAccess();
			this.tipogrupoflujocajas= new ArrayList<TipoGrupoFlujoCaja>();
			this.tipogrupoflujocaja= new TipoGrupoFlujoCaja();
			this.tipogrupoflujocajaObject=new Object();
			this.tipogrupoflujocajasObject=new ArrayList<Object>();
			
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
			
			this.tipogrupoflujocajaDataAccess.setConnexionType(this.connexionType);
			this.tipogrupoflujocajaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoGrupoFlujoCaja getTipoGrupoFlujoCaja() throws Exception {	
		//TipoGrupoFlujoCajaLogicAdditional.checkTipoGrupoFlujoCajaToGet(tipogrupoflujocaja,this.datosCliente,this.arrDatoGeneral);
		//TipoGrupoFlujoCajaLogicAdditional.updateTipoGrupoFlujoCajaToGet(tipogrupoflujocaja,this.arrDatoGeneral);
		
		return tipogrupoflujocaja;
	}
		
	public void setTipoGrupoFlujoCaja(TipoGrupoFlujoCaja newTipoGrupoFlujoCaja) {
		this.tipogrupoflujocaja = newTipoGrupoFlujoCaja;
	}
	
	public TipoGrupoFlujoCajaDataAccess getTipoGrupoFlujoCajaDataAccess() {
		return tipogrupoflujocajaDataAccess;
	}
	
	public void setTipoGrupoFlujoCajaDataAccess(TipoGrupoFlujoCajaDataAccess newtipogrupoflujocajaDataAccess) {
		this.tipogrupoflujocajaDataAccess = newtipogrupoflujocajaDataAccess;
	}
	
	public List<TipoGrupoFlujoCaja> getTipoGrupoFlujoCajas() throws Exception {		
		this.quitarTipoGrupoFlujoCajasNulos();
		
		//TipoGrupoFlujoCajaLogicAdditional.checkTipoGrupoFlujoCajaToGets(tipogrupoflujocajas,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoGrupoFlujoCaja tipogrupoflujocajaLocal: tipogrupoflujocajas ) {
			//TipoGrupoFlujoCajaLogicAdditional.updateTipoGrupoFlujoCajaToGet(tipogrupoflujocajaLocal,this.arrDatoGeneral);
		}
		
		return tipogrupoflujocajas;
	}
	
	public void setTipoGrupoFlujoCajas(List<TipoGrupoFlujoCaja> newTipoGrupoFlujoCajas) {
		this.tipogrupoflujocajas = newTipoGrupoFlujoCajas;
	}
	
	public Object getTipoGrupoFlujoCajaObject() {	
		this.tipogrupoflujocajaObject=this.tipogrupoflujocajaDataAccess.getEntityObject();
		return this.tipogrupoflujocajaObject;
	}
		
	public void setTipoGrupoFlujoCajaObject(Object newTipoGrupoFlujoCajaObject) {
		this.tipogrupoflujocajaObject = newTipoGrupoFlujoCajaObject;
	}
	
	public List<Object> getTipoGrupoFlujoCajasObject() {		
		this.tipogrupoflujocajasObject=this.tipogrupoflujocajaDataAccess.getEntitiesObject();
		return this.tipogrupoflujocajasObject;
	}
		
	public void setTipoGrupoFlujoCajasObject(List<Object> newTipoGrupoFlujoCajasObject) {
		this.tipogrupoflujocajasObject = newTipoGrupoFlujoCajasObject;
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
		
		if(this.tipogrupoflujocajaDataAccess!=null) {
			this.tipogrupoflujocajaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFlujoCaja.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipogrupoflujocajaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipogrupoflujocajaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipogrupoflujocaja = new  TipoGrupoFlujoCaja();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFlujoCaja.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipogrupoflujocaja=tipogrupoflujocajaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogrupoflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGrupoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFlujoCaja(this.tipogrupoflujocaja);
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
		tipogrupoflujocaja = new  TipoGrupoFlujoCaja();
		  		  
        try {
			
			tipogrupoflujocaja=tipogrupoflujocajaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogrupoflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGrupoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFlujoCaja(this.tipogrupoflujocaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipogrupoflujocaja = new  TipoGrupoFlujoCaja();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFlujoCaja.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipogrupoflujocaja=tipogrupoflujocajaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogrupoflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGrupoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFlujoCaja(this.tipogrupoflujocaja);
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
		tipogrupoflujocaja = new  TipoGrupoFlujoCaja();
		  		  
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
		tipogrupoflujocaja = new  TipoGrupoFlujoCaja();
		  		  
        try {
			
			tipogrupoflujocaja=tipogrupoflujocajaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogrupoflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGrupoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFlujoCaja(this.tipogrupoflujocaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipogrupoflujocaja = new  TipoGrupoFlujoCaja();
		  		  
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
		tipogrupoflujocaja = new  TipoGrupoFlujoCaja();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFlujoCaja.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipogrupoflujocajaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipogrupoflujocaja = new  TipoGrupoFlujoCaja();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipogrupoflujocajaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipogrupoflujocaja = new  TipoGrupoFlujoCaja();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFlujoCaja.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipogrupoflujocajaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipogrupoflujocaja = new  TipoGrupoFlujoCaja();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipogrupoflujocajaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipogrupoflujocaja = new  TipoGrupoFlujoCaja();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFlujoCaja.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipogrupoflujocajaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipogrupoflujocaja = new  TipoGrupoFlujoCaja();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipogrupoflujocajaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipogrupoflujocajas = new  ArrayList<TipoGrupoFlujoCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFlujoCaja.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoGrupoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoflujocajas=tipogrupoflujocajaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGrupoFlujoCaja(tipogrupoflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFlujoCaja(this.tipogrupoflujocajas);
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
		tipogrupoflujocajas = new  ArrayList<TipoGrupoFlujoCaja>();
		  		  
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
		tipogrupoflujocajas = new  ArrayList<TipoGrupoFlujoCaja>();
		  		  
        try {			
			TipoGrupoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoflujocajas=tipogrupoflujocajaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoGrupoFlujoCaja(tipogrupoflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFlujoCaja(this.tipogrupoflujocajas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipogrupoflujocajas = new  ArrayList<TipoGrupoFlujoCaja>();
		  		  
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
		tipogrupoflujocajas = new  ArrayList<TipoGrupoFlujoCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFlujoCaja.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoGrupoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoflujocajas=tipogrupoflujocajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGrupoFlujoCaja(tipogrupoflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFlujoCaja(this.tipogrupoflujocajas);
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
		tipogrupoflujocajas = new  ArrayList<TipoGrupoFlujoCaja>();
		  		  
        try {
			TipoGrupoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoflujocajas=tipogrupoflujocajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGrupoFlujoCaja(tipogrupoflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFlujoCaja(this.tipogrupoflujocajas);
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
		tipogrupoflujocajas = new  ArrayList<TipoGrupoFlujoCaja>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFlujoCaja.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGrupoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoflujocajas=tipogrupoflujocajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGrupoFlujoCaja(tipogrupoflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFlujoCaja(this.tipogrupoflujocajas);
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
		tipogrupoflujocajas = new  ArrayList<TipoGrupoFlujoCaja>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGrupoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoflujocajas=tipogrupoflujocajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGrupoFlujoCaja(tipogrupoflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFlujoCaja(this.tipogrupoflujocajas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipogrupoflujocaja = new  TipoGrupoFlujoCaja();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFlujoCaja.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGrupoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoflujocaja=tipogrupoflujocajaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGrupoFlujoCaja(tipogrupoflujocaja);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFlujoCaja(this.tipogrupoflujocaja);
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
		tipogrupoflujocaja = new  TipoGrupoFlujoCaja();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGrupoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoflujocaja=tipogrupoflujocajaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGrupoFlujoCaja(tipogrupoflujocaja);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFlujoCaja(this.tipogrupoflujocaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoGrupoFlujoCajasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipogrupoflujocajas = new  ArrayList<TipoGrupoFlujoCaja>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFlujoCaja.class.getSimpleName()+"-getTodosTipoGrupoFlujoCajasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGrupoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoflujocajas=tipogrupoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoGrupoFlujoCaja(tipogrupoflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFlujoCaja(this.tipogrupoflujocajas);
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
	
	public  void  getTodosTipoGrupoFlujoCajas(String sFinalQuery,Pagination pagination)throws Exception {
		tipogrupoflujocajas = new  ArrayList<TipoGrupoFlujoCaja>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGrupoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoflujocajas=tipogrupoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoGrupoFlujoCaja(tipogrupoflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFlujoCaja(this.tipogrupoflujocajas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoGrupoFlujoCaja(TipoGrupoFlujoCaja tipogrupoflujocaja) throws Exception {
		Boolean estaValidado=false;
		
		if(tipogrupoflujocaja.getIsNew() || tipogrupoflujocaja.getIsChanged()) { 
			this.invalidValues = tipogrupoflujocajaValidator.getInvalidValues(tipogrupoflujocaja);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipogrupoflujocaja);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoGrupoFlujoCaja(List<TipoGrupoFlujoCaja> TipoGrupoFlujoCajas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoGrupoFlujoCaja tipogrupoflujocajaLocal:tipogrupoflujocajas) {				
			estaValidadoObjeto=this.validarGuardarTipoGrupoFlujoCaja(tipogrupoflujocajaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoGrupoFlujoCaja(List<TipoGrupoFlujoCaja> TipoGrupoFlujoCajas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoGrupoFlujoCaja(tipogrupoflujocajas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoGrupoFlujoCaja(TipoGrupoFlujoCaja TipoGrupoFlujoCaja) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoGrupoFlujoCaja(tipogrupoflujocaja)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoGrupoFlujoCaja tipogrupoflujocaja) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipogrupoflujocaja.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoGrupoFlujoCajaConstantesFunciones.getTipoGrupoFlujoCajaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipogrupoflujocaja","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoGrupoFlujoCajaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoGrupoFlujoCajaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoGrupoFlujoCajaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFlujoCaja.class.getSimpleName()+"-saveTipoGrupoFlujoCajaWithConnection");connexion.begin();			
			
			//TipoGrupoFlujoCajaLogicAdditional.checkTipoGrupoFlujoCajaToSave(this.tipogrupoflujocaja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoGrupoFlujoCajaLogicAdditional.updateTipoGrupoFlujoCajaToSave(this.tipogrupoflujocaja,this.arrDatoGeneral);
			
			TipoGrupoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipogrupoflujocaja,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoGrupoFlujoCaja();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoGrupoFlujoCaja(this.tipogrupoflujocaja)) {
				TipoGrupoFlujoCajaDataAccess.save(this.tipogrupoflujocaja, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipogrupoflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoGrupoFlujoCajaLogicAdditional.checkTipoGrupoFlujoCajaToSaveAfter(this.tipogrupoflujocaja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoGrupoFlujoCaja();
			
			connexion.commit();			
			
			if(this.tipogrupoflujocaja.getIsDeleted()) {
				this.tipogrupoflujocaja=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoGrupoFlujoCaja()throws Exception {	
		try {	
			
			//TipoGrupoFlujoCajaLogicAdditional.checkTipoGrupoFlujoCajaToSave(this.tipogrupoflujocaja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoGrupoFlujoCajaLogicAdditional.updateTipoGrupoFlujoCajaToSave(this.tipogrupoflujocaja,this.arrDatoGeneral);
			
			TipoGrupoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipogrupoflujocaja,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoGrupoFlujoCaja(this.tipogrupoflujocaja)) {			
				TipoGrupoFlujoCajaDataAccess.save(this.tipogrupoflujocaja, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipogrupoflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoGrupoFlujoCajaLogicAdditional.checkTipoGrupoFlujoCajaToSaveAfter(this.tipogrupoflujocaja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipogrupoflujocaja.getIsDeleted()) {
				this.tipogrupoflujocaja=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoGrupoFlujoCajasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFlujoCaja.class.getSimpleName()+"-saveTipoGrupoFlujoCajasWithConnection");connexion.begin();			
			
			//TipoGrupoFlujoCajaLogicAdditional.checkTipoGrupoFlujoCajaToSaves(tipogrupoflujocajas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoGrupoFlujoCajas();
			
			Boolean validadoTodosTipoGrupoFlujoCaja=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoGrupoFlujoCaja tipogrupoflujocajaLocal:tipogrupoflujocajas) {		
				if(tipogrupoflujocajaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoGrupoFlujoCajaLogicAdditional.updateTipoGrupoFlujoCajaToSave(tipogrupoflujocajaLocal,this.arrDatoGeneral);
	        	
				TipoGrupoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipogrupoflujocajaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoGrupoFlujoCaja(tipogrupoflujocajaLocal)) {
					TipoGrupoFlujoCajaDataAccess.save(tipogrupoflujocajaLocal, connexion);				
				} else {
					validadoTodosTipoGrupoFlujoCaja=false;
				}
			}
			
			if(!validadoTodosTipoGrupoFlujoCaja) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoGrupoFlujoCajaLogicAdditional.checkTipoGrupoFlujoCajaToSavesAfter(tipogrupoflujocajas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoGrupoFlujoCajas();
			
			connexion.commit();		
			
			this.quitarTipoGrupoFlujoCajasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoGrupoFlujoCajas()throws Exception {				
		 try {	
			//TipoGrupoFlujoCajaLogicAdditional.checkTipoGrupoFlujoCajaToSaves(tipogrupoflujocajas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoGrupoFlujoCaja=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoGrupoFlujoCaja tipogrupoflujocajaLocal:tipogrupoflujocajas) {				
				if(tipogrupoflujocajaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoGrupoFlujoCajaLogicAdditional.updateTipoGrupoFlujoCajaToSave(tipogrupoflujocajaLocal,this.arrDatoGeneral);
	        	
				TipoGrupoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipogrupoflujocajaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoGrupoFlujoCaja(tipogrupoflujocajaLocal)) {				
					TipoGrupoFlujoCajaDataAccess.save(tipogrupoflujocajaLocal, connexion);				
				} else {
					validadoTodosTipoGrupoFlujoCaja=false;
				}
			}
			
			if(!validadoTodosTipoGrupoFlujoCaja) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoGrupoFlujoCajaLogicAdditional.checkTipoGrupoFlujoCajaToSavesAfter(tipogrupoflujocajas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoGrupoFlujoCajasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoGrupoFlujoCajaParameterReturnGeneral procesarAccionTipoGrupoFlujoCajas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoGrupoFlujoCaja> tipogrupoflujocajas,TipoGrupoFlujoCajaParameterReturnGeneral tipogrupoflujocajaParameterGeneral)throws Exception {
		 try {	
			TipoGrupoFlujoCajaParameterReturnGeneral tipogrupoflujocajaReturnGeneral=new TipoGrupoFlujoCajaParameterReturnGeneral();
	
			
			return tipogrupoflujocajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoGrupoFlujoCajaParameterReturnGeneral procesarAccionTipoGrupoFlujoCajasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoGrupoFlujoCaja> tipogrupoflujocajas,TipoGrupoFlujoCajaParameterReturnGeneral tipogrupoflujocajaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFlujoCaja.class.getSimpleName()+"-procesarAccionTipoGrupoFlujoCajasWithConnection");connexion.begin();			
			
			TipoGrupoFlujoCajaParameterReturnGeneral tipogrupoflujocajaReturnGeneral=new TipoGrupoFlujoCajaParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipogrupoflujocajaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoGrupoFlujoCajaParameterReturnGeneral procesarEventosTipoGrupoFlujoCajas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoGrupoFlujoCaja> tipogrupoflujocajas,TipoGrupoFlujoCaja tipogrupoflujocaja,TipoGrupoFlujoCajaParameterReturnGeneral tipogrupoflujocajaParameterGeneral,Boolean isEsNuevoTipoGrupoFlujoCaja,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoGrupoFlujoCajaParameterReturnGeneral tipogrupoflujocajaReturnGeneral=new TipoGrupoFlujoCajaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipogrupoflujocajaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipogrupoflujocajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoGrupoFlujoCajaParameterReturnGeneral procesarEventosTipoGrupoFlujoCajasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoGrupoFlujoCaja> tipogrupoflujocajas,TipoGrupoFlujoCaja tipogrupoflujocaja,TipoGrupoFlujoCajaParameterReturnGeneral tipogrupoflujocajaParameterGeneral,Boolean isEsNuevoTipoGrupoFlujoCaja,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFlujoCaja.class.getSimpleName()+"-procesarEventosTipoGrupoFlujoCajasWithConnection");connexion.begin();			
			
			TipoGrupoFlujoCajaParameterReturnGeneral tipogrupoflujocajaReturnGeneral=new TipoGrupoFlujoCajaParameterReturnGeneral();
	
			tipogrupoflujocajaReturnGeneral.setTipoGrupoFlujoCaja(tipogrupoflujocaja);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipogrupoflujocajaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipogrupoflujocajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoGrupoFlujoCajaParameterReturnGeneral procesarImportacionTipoGrupoFlujoCajasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoGrupoFlujoCajaParameterReturnGeneral tipogrupoflujocajaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFlujoCaja.class.getSimpleName()+"-procesarImportacionTipoGrupoFlujoCajasWithConnection");connexion.begin();			
			
			TipoGrupoFlujoCajaParameterReturnGeneral tipogrupoflujocajaReturnGeneral=new TipoGrupoFlujoCajaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipogrupoflujocajas=new ArrayList<TipoGrupoFlujoCaja>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipogrupoflujocaja=new TipoGrupoFlujoCaja();
				
				
				if(conColumnasBase) {this.tipogrupoflujocaja.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipogrupoflujocaja.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipogrupoflujocaja.setcodigo(arrColumnas[iColumn++]);
				this.tipogrupoflujocaja.setnombre(arrColumnas[iColumn++]);
				
				this.tipogrupoflujocajas.add(this.tipogrupoflujocaja);
			}
			
			this.saveTipoGrupoFlujoCajas();
			
			this.connexion.commit();
			
			tipogrupoflujocajaReturnGeneral.setConRetornoEstaProcesado(true);
			tipogrupoflujocajaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipogrupoflujocajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoGrupoFlujoCajasEliminados() throws Exception {				
		
		List<TipoGrupoFlujoCaja> tipogrupoflujocajasAux= new ArrayList<TipoGrupoFlujoCaja>();
		
		for(TipoGrupoFlujoCaja tipogrupoflujocaja:tipogrupoflujocajas) {
			if(!tipogrupoflujocaja.getIsDeleted()) {
				tipogrupoflujocajasAux.add(tipogrupoflujocaja);
			}
		}
		
		tipogrupoflujocajas=tipogrupoflujocajasAux;
	}
	
	public void quitarTipoGrupoFlujoCajasNulos() throws Exception {				
		
		List<TipoGrupoFlujoCaja> tipogrupoflujocajasAux= new ArrayList<TipoGrupoFlujoCaja>();
		
		for(TipoGrupoFlujoCaja tipogrupoflujocaja : this.tipogrupoflujocajas) {
			if(tipogrupoflujocaja==null) {
				tipogrupoflujocajasAux.add(tipogrupoflujocaja);
			}
		}
		
		//this.tipogrupoflujocajas=tipogrupoflujocajasAux;
		
		this.tipogrupoflujocajas.removeAll(tipogrupoflujocajasAux);
	}
	
	public void getSetVersionRowTipoGrupoFlujoCajaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipogrupoflujocaja.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipogrupoflujocaja.getIsDeleted() || (tipogrupoflujocaja.getIsChanged()&&!tipogrupoflujocaja.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipogrupoflujocajaDataAccess.getSetVersionRowTipoGrupoFlujoCaja(connexion,tipogrupoflujocaja.getId());
				
				if(!tipogrupoflujocaja.getVersionRow().equals(timestamp)) {	
					tipogrupoflujocaja.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipogrupoflujocaja.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoGrupoFlujoCaja()throws Exception {	
		
		if(tipogrupoflujocaja.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipogrupoflujocaja.getIsDeleted() || (tipogrupoflujocaja.getIsChanged()&&!tipogrupoflujocaja.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipogrupoflujocajaDataAccess.getSetVersionRowTipoGrupoFlujoCaja(connexion,tipogrupoflujocaja.getId());
			
			try {							
				if(!tipogrupoflujocaja.getVersionRow().equals(timestamp)) {	
					tipogrupoflujocaja.setVersionRow(timestamp);
				}
				
				tipogrupoflujocaja.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoGrupoFlujoCajasWithConnection()throws Exception {	
		if(tipogrupoflujocajas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoGrupoFlujoCaja tipogrupoflujocajaAux:tipogrupoflujocajas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipogrupoflujocajaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipogrupoflujocajaAux.getIsDeleted() || (tipogrupoflujocajaAux.getIsChanged()&&!tipogrupoflujocajaAux.getIsNew())) {
						
						timestamp=tipogrupoflujocajaDataAccess.getSetVersionRowTipoGrupoFlujoCaja(connexion,tipogrupoflujocajaAux.getId());
						
						if(!tipogrupoflujocaja.getVersionRow().equals(timestamp)) {	
							tipogrupoflujocajaAux.setVersionRow(timestamp);
						}
								
						tipogrupoflujocajaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoGrupoFlujoCajas()throws Exception {	
		if(tipogrupoflujocajas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoGrupoFlujoCaja tipogrupoflujocajaAux:tipogrupoflujocajas) {
					if(tipogrupoflujocajaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipogrupoflujocajaAux.getIsDeleted() || (tipogrupoflujocajaAux.getIsChanged()&&!tipogrupoflujocajaAux.getIsNew())) {
						
						timestamp=tipogrupoflujocajaDataAccess.getSetVersionRowTipoGrupoFlujoCaja(connexion,tipogrupoflujocajaAux.getId());
						
						if(!tipogrupoflujocajaAux.getVersionRow().equals(timestamp)) {	
							tipogrupoflujocajaAux.setVersionRow(timestamp);
						}
						
													
						tipogrupoflujocajaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoGrupoFlujoCajaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			LineaFlujoCajaLogic lineaflujocajaLogic=new LineaFlujoCajaLogic();
			CentroActividadLogic centroactividadLogic=new CentroActividadLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFlujoCaja.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoGrupoFlujoCajaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(LineaFlujoCaja.class));
			classes.add(new Classe(CentroActividad.class));
											
			

			lineaflujocajaLogic.setConnexion(this.getConnexion());
			lineaflujocajaLogic.setDatosCliente(this.datosCliente);
			lineaflujocajaLogic.setIsConRefrescarForeignKeys(true);

			centroactividadLogic.setConnexion(this.getConnexion());
			centroactividadLogic.setDatosCliente(this.datosCliente);
			centroactividadLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoGrupoFlujoCaja tipogrupoflujocaja:this.tipogrupoflujocajas) {
				

				classes=new ArrayList<Classe>();
				classes=LineaFlujoCajaConstantesFunciones.getClassesForeignKeysOfLineaFlujoCaja(new ArrayList<Classe>(),DeepLoadType.NONE);

				lineaflujocajaLogic.setLineaFlujoCajas(tipogrupoflujocaja.lineaflujocajas);
				lineaflujocajaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CentroActividadConstantesFunciones.getClassesForeignKeysOfCentroActividad(new ArrayList<Classe>(),DeepLoadType.NONE);

				centroactividadLogic.setCentroActividads(tipogrupoflujocaja.centroactividads);
				centroactividadLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoGrupoFlujoCaja tipogrupoflujocaja,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoGrupoFlujoCajaLogicAdditional.updateTipoGrupoFlujoCajaToGet(tipogrupoflujocaja,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipogrupoflujocaja.setLineaFlujoCajas(tipogrupoflujocajaDataAccess.getLineaFlujoCajas(connexion,tipogrupoflujocaja));
		tipogrupoflujocaja.setCentroActividads(tipogrupoflujocajaDataAccess.getCentroActividads(connexion,tipogrupoflujocaja));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(LineaFlujoCaja.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipogrupoflujocaja.setLineaFlujoCajas(tipogrupoflujocajaDataAccess.getLineaFlujoCajas(connexion,tipogrupoflujocaja));

				if(this.isConDeep) {
					LineaFlujoCajaLogic lineaflujocajaLogic= new LineaFlujoCajaLogic(this.connexion);
					lineaflujocajaLogic.setLineaFlujoCajas(tipogrupoflujocaja.getLineaFlujoCajas());
					ArrayList<Classe> classesLocal=LineaFlujoCajaConstantesFunciones.getClassesForeignKeysOfLineaFlujoCaja(new ArrayList<Classe>(),DeepLoadType.NONE);
					lineaflujocajaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(lineaflujocajaLogic.getLineaFlujoCajas());
					tipogrupoflujocaja.setLineaFlujoCajas(lineaflujocajaLogic.getLineaFlujoCajas());
				}

				continue;
			}

			if(clas.clas.equals(CentroActividad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipogrupoflujocaja.setCentroActividads(tipogrupoflujocajaDataAccess.getCentroActividads(connexion,tipogrupoflujocaja));

				if(this.isConDeep) {
					CentroActividadLogic centroactividadLogic= new CentroActividadLogic(this.connexion);
					centroactividadLogic.setCentroActividads(tipogrupoflujocaja.getCentroActividads());
					ArrayList<Classe> classesLocal=CentroActividadConstantesFunciones.getClassesForeignKeysOfCentroActividad(new ArrayList<Classe>(),DeepLoadType.NONE);
					centroactividadLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CentroActividadConstantesFunciones.refrescarForeignKeysDescripcionesCentroActividad(centroactividadLogic.getCentroActividads());
					tipogrupoflujocaja.setCentroActividads(centroactividadLogic.getCentroActividads());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(LineaFlujoCaja.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(LineaFlujoCaja.class));
			tipogrupoflujocaja.setLineaFlujoCajas(tipogrupoflujocajaDataAccess.getLineaFlujoCajas(connexion,tipogrupoflujocaja));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroActividad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CentroActividad.class));
			tipogrupoflujocaja.setCentroActividads(tipogrupoflujocajaDataAccess.getCentroActividads(connexion,tipogrupoflujocaja));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tipogrupoflujocaja.setLineaFlujoCajas(tipogrupoflujocajaDataAccess.getLineaFlujoCajas(connexion,tipogrupoflujocaja));

		for(LineaFlujoCaja lineaflujocaja:tipogrupoflujocaja.getLineaFlujoCajas()) {
			LineaFlujoCajaLogic lineaflujocajaLogic= new LineaFlujoCajaLogic(connexion);
			lineaflujocajaLogic.deepLoad(lineaflujocaja,isDeep,deepLoadType,clases);
		}

		tipogrupoflujocaja.setCentroActividads(tipogrupoflujocajaDataAccess.getCentroActividads(connexion,tipogrupoflujocaja));

		for(CentroActividad centroactividad:tipogrupoflujocaja.getCentroActividads()) {
			CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
			centroactividadLogic.deepLoad(centroactividad,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(LineaFlujoCaja.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipogrupoflujocaja.setLineaFlujoCajas(tipogrupoflujocajaDataAccess.getLineaFlujoCajas(connexion,tipogrupoflujocaja));

				for(LineaFlujoCaja lineaflujocaja:tipogrupoflujocaja.getLineaFlujoCajas()) {
					LineaFlujoCajaLogic lineaflujocajaLogic= new LineaFlujoCajaLogic(connexion);
					lineaflujocajaLogic.deepLoad(lineaflujocaja,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CentroActividad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipogrupoflujocaja.setCentroActividads(tipogrupoflujocajaDataAccess.getCentroActividads(connexion,tipogrupoflujocaja));

				for(CentroActividad centroactividad:tipogrupoflujocaja.getCentroActividads()) {
					CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
					centroactividadLogic.deepLoad(centroactividad,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(LineaFlujoCaja.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(LineaFlujoCaja.class));
			tipogrupoflujocaja.setLineaFlujoCajas(tipogrupoflujocajaDataAccess.getLineaFlujoCajas(connexion,tipogrupoflujocaja));

			for(LineaFlujoCaja lineaflujocaja:tipogrupoflujocaja.getLineaFlujoCajas()) {
				LineaFlujoCajaLogic lineaflujocajaLogic= new LineaFlujoCajaLogic(connexion);
				lineaflujocajaLogic.deepLoad(lineaflujocaja,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroActividad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CentroActividad.class));
			tipogrupoflujocaja.setCentroActividads(tipogrupoflujocajaDataAccess.getCentroActividads(connexion,tipogrupoflujocaja));

			for(CentroActividad centroactividad:tipogrupoflujocaja.getCentroActividads()) {
				CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
				centroactividadLogic.deepLoad(centroactividad,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoGrupoFlujoCaja tipogrupoflujocaja,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoGrupoFlujoCaja.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipogrupoflujocaja,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoGrupoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFlujoCaja(tipogrupoflujocaja);
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
			this.deepLoad(this.tipogrupoflujocaja,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoGrupoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFlujoCaja(this.tipogrupoflujocaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoGrupoFlujoCaja.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipogrupoflujocajas!=null) {
				for(TipoGrupoFlujoCaja tipogrupoflujocaja:tipogrupoflujocajas) {
					this.deepLoad(tipogrupoflujocaja,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoGrupoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFlujoCaja(tipogrupoflujocajas);
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
			if(tipogrupoflujocajas!=null) {
				for(TipoGrupoFlujoCaja tipogrupoflujocaja:tipogrupoflujocajas) {
					this.deepLoad(tipogrupoflujocaja,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoGrupoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFlujoCaja(tipogrupoflujocajas);
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
	
	
	public void getTipoGrupoFlujoCajasBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoGrupoFlujoCajaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoGrupoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogrupoflujocajas=tipogrupoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGrupoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFlujoCaja(this.tipogrupoflujocajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoGrupoFlujoCajasBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoGrupoFlujoCajaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoGrupoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogrupoflujocajas=tipogrupoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGrupoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFlujoCaja(this.tipogrupoflujocajas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoGrupoFlujoCajasBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoGrupoFlujoCajaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoGrupoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogrupoflujocajas=tipogrupoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGrupoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFlujoCaja(this.tipogrupoflujocajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoGrupoFlujoCajasBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoGrupoFlujoCajaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoGrupoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogrupoflujocajas=tipogrupoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGrupoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFlujoCaja(this.tipogrupoflujocajas);
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
			if(TipoGrupoFlujoCajaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGrupoFlujoCajaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoGrupoFlujoCaja tipogrupoflujocaja,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoGrupoFlujoCajaConstantesFunciones.ISCONAUDITORIA) {
				if(tipogrupoflujocaja.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGrupoFlujoCajaDataAccess.TABLENAME, tipogrupoflujocaja.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoGrupoFlujoCajaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoGrupoFlujoCajaLogic.registrarAuditoriaDetallesTipoGrupoFlujoCaja(connexion,tipogrupoflujocaja,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipogrupoflujocaja.getIsDeleted()) {
					/*if(!tipogrupoflujocaja.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoGrupoFlujoCajaDataAccess.TABLENAME, tipogrupoflujocaja.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoGrupoFlujoCajaLogic.registrarAuditoriaDetallesTipoGrupoFlujoCaja(connexion,tipogrupoflujocaja,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGrupoFlujoCajaDataAccess.TABLENAME, tipogrupoflujocaja.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipogrupoflujocaja.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGrupoFlujoCajaDataAccess.TABLENAME, tipogrupoflujocaja.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoGrupoFlujoCajaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoGrupoFlujoCajaLogic.registrarAuditoriaDetallesTipoGrupoFlujoCaja(connexion,tipogrupoflujocaja,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoGrupoFlujoCaja(Connexion connexion,TipoGrupoFlujoCaja tipogrupoflujocaja)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipogrupoflujocaja.getIsNew()||!tipogrupoflujocaja.getcodigo().equals(tipogrupoflujocaja.getTipoGrupoFlujoCajaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogrupoflujocaja.getTipoGrupoFlujoCajaOriginal().getcodigo()!=null)
				{
					strValorActual=tipogrupoflujocaja.getTipoGrupoFlujoCajaOriginal().getcodigo();
				}
				if(tipogrupoflujocaja.getcodigo()!=null)
				{
					strValorNuevo=tipogrupoflujocaja.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGrupoFlujoCajaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipogrupoflujocaja.getIsNew()||!tipogrupoflujocaja.getnombre().equals(tipogrupoflujocaja.getTipoGrupoFlujoCajaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogrupoflujocaja.getTipoGrupoFlujoCajaOriginal().getnombre()!=null)
				{
					strValorActual=tipogrupoflujocaja.getTipoGrupoFlujoCajaOriginal().getnombre();
				}
				if(tipogrupoflujocaja.getnombre()!=null)
				{
					strValorNuevo=tipogrupoflujocaja.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGrupoFlujoCajaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoGrupoFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoGrupoFlujoCajaConstantesFunciones.getClassesForeignKeysOfTipoGrupoFlujoCaja(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGrupoFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoGrupoFlujoCajaConstantesFunciones.getClassesRelationshipsOfTipoGrupoFlujoCaja(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}
