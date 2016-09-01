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
package com.bydan.erp.produccion.business.logic;

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
import com.bydan.erp.produccion.util.*;
import com.bydan.erp.produccion.util.ParametroProduConstantesFunciones;
import com.bydan.erp.produccion.util.ParametroProduParameterReturnGeneral;
//import com.bydan.erp.produccion.util.ParametroProduParameterGeneral;
import com.bydan.erp.produccion.business.entity.ParametroProdu;
import com.bydan.erp.produccion.business.logic.ParametroProduLogicAdditional;
import com.bydan.erp.produccion.business.dataaccess.*;
import com.bydan.erp.produccion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class ParametroProduLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ParametroProduLogic.class);
	
	protected ParametroProduDataAccess parametroproduDataAccess; 	
	protected ParametroProdu parametroprodu;
	protected List<ParametroProdu> parametroprodus;
	protected Object parametroproduObject;	
	protected List<Object> parametroprodusObject;
	
	public static ClassValidator<ParametroProdu> parametroproduValidator = new ClassValidator<ParametroProdu>(ParametroProdu.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ParametroProduLogicAdditional parametroproduLogicAdditional=null;
	
	public ParametroProduLogicAdditional getParametroProduLogicAdditional() {
		return this.parametroproduLogicAdditional;
	}
	
	public void setParametroProduLogicAdditional(ParametroProduLogicAdditional parametroproduLogicAdditional) {
		try {
			this.parametroproduLogicAdditional=parametroproduLogicAdditional;
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
	
	
	
	
	public  ParametroProduLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.parametroproduDataAccess = new ParametroProduDataAccess();
			
			this.parametroprodus= new ArrayList<ParametroProdu>();
			this.parametroprodu= new ParametroProdu();
			
			this.parametroproduObject=new Object();
			this.parametroprodusObject=new ArrayList<Object>();
				
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
			
			this.parametroproduDataAccess.setConnexionType(this.connexionType);
			this.parametroproduDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ParametroProduLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.parametroproduDataAccess = new ParametroProduDataAccess();
			this.parametroprodus= new ArrayList<ParametroProdu>();
			this.parametroprodu= new ParametroProdu();
			this.parametroproduObject=new Object();
			this.parametroprodusObject=new ArrayList<Object>();
			
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
			
			this.parametroproduDataAccess.setConnexionType(this.connexionType);
			this.parametroproduDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ParametroProdu getParametroProdu() throws Exception {	
		ParametroProduLogicAdditional.checkParametroProduToGet(parametroprodu,this.datosCliente,this.arrDatoGeneral);
		ParametroProduLogicAdditional.updateParametroProduToGet(parametroprodu,this.arrDatoGeneral);
		
		return parametroprodu;
	}
		
	public void setParametroProdu(ParametroProdu newParametroProdu) {
		this.parametroprodu = newParametroProdu;
	}
	
	public ParametroProduDataAccess getParametroProduDataAccess() {
		return parametroproduDataAccess;
	}
	
	public void setParametroProduDataAccess(ParametroProduDataAccess newparametroproduDataAccess) {
		this.parametroproduDataAccess = newparametroproduDataAccess;
	}
	
	public List<ParametroProdu> getParametroProdus() throws Exception {		
		this.quitarParametroProdusNulos();
		
		ParametroProduLogicAdditional.checkParametroProduToGets(parametroprodus,this.datosCliente,this.arrDatoGeneral);
		
		for (ParametroProdu parametroproduLocal: parametroprodus ) {
			ParametroProduLogicAdditional.updateParametroProduToGet(parametroproduLocal,this.arrDatoGeneral);
		}
		
		return parametroprodus;
	}
	
	public void setParametroProdus(List<ParametroProdu> newParametroProdus) {
		this.parametroprodus = newParametroProdus;
	}
	
	public Object getParametroProduObject() {	
		this.parametroproduObject=this.parametroproduDataAccess.getEntityObject();
		return this.parametroproduObject;
	}
		
	public void setParametroProduObject(Object newParametroProduObject) {
		this.parametroproduObject = newParametroProduObject;
	}
	
	public List<Object> getParametroProdusObject() {		
		this.parametroprodusObject=this.parametroproduDataAccess.getEntitiesObject();
		return this.parametroprodusObject;
	}
		
	public void setParametroProdusObject(List<Object> newParametroProdusObject) {
		this.parametroprodusObject = newParametroProdusObject;
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
		
		if(this.parametroproduDataAccess!=null) {
			this.parametroproduDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroProdu.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			parametroproduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			parametroproduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		parametroprodu = new  ParametroProdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametroprodu=parametroproduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(this.parametroprodu);
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
		parametroprodu = new  ParametroProdu();
		  		  
        try {
			
			parametroprodu=parametroproduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(this.parametroprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		parametroprodu = new  ParametroProdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametroprodu=parametroproduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(this.parametroprodu);
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
		parametroprodu = new  ParametroProdu();
		  		  
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
		parametroprodu = new  ParametroProdu();
		  		  
        try {
			
			parametroprodu=parametroproduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(this.parametroprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		parametroprodu = new  ParametroProdu();
		  		  
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
		parametroprodu = new  ParametroProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroProdu.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =parametroproduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametroprodu = new  ParametroProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=parametroproduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametroprodu = new  ParametroProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroProdu.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =parametroproduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametroprodu = new  ParametroProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=parametroproduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametroprodu = new  ParametroProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroProdu.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =parametroproduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametroprodu = new  ParametroProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=parametroproduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametroprodus = new  ArrayList<ParametroProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ParametroProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroprodus=parametroproduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroProdu(parametroprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(this.parametroprodus);
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
		parametroprodus = new  ArrayList<ParametroProdu>();
		  		  
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
		parametroprodus = new  ArrayList<ParametroProdu>();
		  		  
        try {			
			ParametroProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroprodus=parametroproduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarParametroProdu(parametroprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(this.parametroprodus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		parametroprodus = new  ArrayList<ParametroProdu>();
		  		  
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
		parametroprodus = new  ArrayList<ParametroProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ParametroProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroprodus=parametroproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroProdu(parametroprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(this.parametroprodus);
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
		parametroprodus = new  ArrayList<ParametroProdu>();
		  		  
        try {
			ParametroProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroprodus=parametroproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroProdu(parametroprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(this.parametroprodus);
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
		parametroprodus = new  ArrayList<ParametroProdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroprodus=parametroproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroProdu(parametroprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(this.parametroprodus);
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
		parametroprodus = new  ArrayList<ParametroProdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroprodus=parametroproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroProdu(parametroprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(this.parametroprodus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		parametroprodu = new  ParametroProdu();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroprodu=parametroproduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroProdu(parametroprodu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(this.parametroprodu);
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
		parametroprodu = new  ParametroProdu();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroprodu=parametroproduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroProdu(parametroprodu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(this.parametroprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametroprodus = new  ArrayList<ParametroProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroProdu.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ParametroProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroprodus=parametroproduDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroProdu(parametroprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(this.parametroprodus);
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
		parametroprodus = new  ArrayList<ParametroProdu>();
		  		  
        try {
			ParametroProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroprodus=parametroproduDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroProdu(parametroprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(this.parametroprodus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosParametroProdusWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		parametroprodus = new  ArrayList<ParametroProdu>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroProdu.class.getSimpleName()+"-getTodosParametroProdusWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroprodus=parametroproduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroProdu(parametroprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(this.parametroprodus);
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
	
	public  void  getTodosParametroProdus(String sFinalQuery,Pagination pagination)throws Exception {
		parametroprodus = new  ArrayList<ParametroProdu>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroprodus=parametroproduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroProdu(parametroprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(this.parametroprodus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarParametroProdu(ParametroProdu parametroprodu) throws Exception {
		Boolean estaValidado=false;
		
		if(parametroprodu.getIsNew() || parametroprodu.getIsChanged()) { 
			this.invalidValues = parametroproduValidator.getInvalidValues(parametroprodu);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(parametroprodu);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarParametroProdu(List<ParametroProdu> ParametroProdus) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ParametroProdu parametroproduLocal:parametroprodus) {				
			estaValidadoObjeto=this.validarGuardarParametroProdu(parametroproduLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarParametroProdu(List<ParametroProdu> ParametroProdus) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroProdu(parametroprodus)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarParametroProdu(ParametroProdu ParametroProdu) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroProdu(parametroprodu)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ParametroProdu parametroprodu) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+parametroprodu.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ParametroProduConstantesFunciones.getParametroProduLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"parametroprodu","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ParametroProduConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ParametroProduConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveParametroProduWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroProdu.class.getSimpleName()+"-saveParametroProduWithConnection");connexion.begin();			
			
			ParametroProduLogicAdditional.checkParametroProduToSave(this.parametroprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroProduLogicAdditional.updateParametroProduToSave(this.parametroprodu,this.arrDatoGeneral);
			
			ParametroProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametroprodu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowParametroProdu();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroProdu(this.parametroprodu)) {
				ParametroProduDataAccess.save(this.parametroprodu, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.parametroprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroProduLogicAdditional.checkParametroProduToSaveAfter(this.parametroprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroProdu();
			
			connexion.commit();			
			
			if(this.parametroprodu.getIsDeleted()) {
				this.parametroprodu=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveParametroProdu()throws Exception {	
		try {	
			
			ParametroProduLogicAdditional.checkParametroProduToSave(this.parametroprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroProduLogicAdditional.updateParametroProduToSave(this.parametroprodu,this.arrDatoGeneral);
			
			ParametroProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametroprodu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroProdu(this.parametroprodu)) {			
				ParametroProduDataAccess.save(this.parametroprodu, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.parametroprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroProduLogicAdditional.checkParametroProduToSaveAfter(this.parametroprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.parametroprodu.getIsDeleted()) {
				this.parametroprodu=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveParametroProdusWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroProdu.class.getSimpleName()+"-saveParametroProdusWithConnection");connexion.begin();			
			
			ParametroProduLogicAdditional.checkParametroProduToSaves(parametroprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowParametroProdus();
			
			Boolean validadoTodosParametroProdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroProdu parametroproduLocal:parametroprodus) {		
				if(parametroproduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroProduLogicAdditional.updateParametroProduToSave(parametroproduLocal,this.arrDatoGeneral);
	        	
				ParametroProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametroproduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroProdu(parametroproduLocal)) {
					ParametroProduDataAccess.save(parametroproduLocal, connexion);				
				} else {
					validadoTodosParametroProdu=false;
				}
			}
			
			if(!validadoTodosParametroProdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroProduLogicAdditional.checkParametroProduToSavesAfter(parametroprodus,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroProdus();
			
			connexion.commit();		
			
			this.quitarParametroProdusEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveParametroProdus()throws Exception {				
		 try {	
			ParametroProduLogicAdditional.checkParametroProduToSaves(parametroprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosParametroProdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroProdu parametroproduLocal:parametroprodus) {				
				if(parametroproduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroProduLogicAdditional.updateParametroProduToSave(parametroproduLocal,this.arrDatoGeneral);
	        	
				ParametroProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametroproduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroProdu(parametroproduLocal)) {				
					ParametroProduDataAccess.save(parametroproduLocal, connexion);				
				} else {
					validadoTodosParametroProdu=false;
				}
			}
			
			if(!validadoTodosParametroProdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroProduLogicAdditional.checkParametroProduToSavesAfter(parametroprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarParametroProdusEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroProduParameterReturnGeneral procesarAccionParametroProdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroProdu> parametroprodus,ParametroProduParameterReturnGeneral parametroproduParameterGeneral)throws Exception {
		 try {	
			ParametroProduParameterReturnGeneral parametroproduReturnGeneral=new ParametroProduParameterReturnGeneral();
	
			ParametroProduLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametroprodus,parametroproduParameterGeneral,parametroproduReturnGeneral);
			
			return parametroproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroProduParameterReturnGeneral procesarAccionParametroProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroProdu> parametroprodus,ParametroProduParameterReturnGeneral parametroproduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroProdu.class.getSimpleName()+"-procesarAccionParametroProdusWithConnection");connexion.begin();			
			
			ParametroProduParameterReturnGeneral parametroproduReturnGeneral=new ParametroProduParameterReturnGeneral();
	
			ParametroProduLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametroprodus,parametroproduParameterGeneral,parametroproduReturnGeneral);
			
			this.connexion.commit();
			
			return parametroproduReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroProduParameterReturnGeneral procesarEventosParametroProdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroProdu> parametroprodus,ParametroProdu parametroprodu,ParametroProduParameterReturnGeneral parametroproduParameterGeneral,Boolean isEsNuevoParametroProdu,ArrayList<Classe> clases)throws Exception {
		 try {	
			ParametroProduParameterReturnGeneral parametroproduReturnGeneral=new ParametroProduParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametroproduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroProduLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametroprodus,parametroprodu,parametroproduParameterGeneral,parametroproduReturnGeneral,isEsNuevoParametroProdu,clases);
			
			return parametroproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ParametroProduParameterReturnGeneral procesarEventosParametroProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroProdu> parametroprodus,ParametroProdu parametroprodu,ParametroProduParameterReturnGeneral parametroproduParameterGeneral,Boolean isEsNuevoParametroProdu,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroProdu.class.getSimpleName()+"-procesarEventosParametroProdusWithConnection");connexion.begin();			
			
			ParametroProduParameterReturnGeneral parametroproduReturnGeneral=new ParametroProduParameterReturnGeneral();
	
			parametroproduReturnGeneral.setParametroProdu(parametroprodu);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametroproduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroProduLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametroprodus,parametroprodu,parametroproduParameterGeneral,parametroproduReturnGeneral,isEsNuevoParametroProdu,clases);
			
			this.connexion.commit();
			
			return parametroproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroProduParameterReturnGeneral procesarImportacionParametroProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ParametroProduParameterReturnGeneral parametroproduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroProdu.class.getSimpleName()+"-procesarImportacionParametroProdusWithConnection");connexion.begin();			
			
			ParametroProduParameterReturnGeneral parametroproduReturnGeneral=new ParametroProduParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.parametroprodus=new ArrayList<ParametroProdu>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.parametroprodu=new ParametroProdu();
				
				
				if(conColumnasBase) {this.parametroprodu.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.parametroprodu.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.parametroprodu.setcon_relacion_porcentaje(Long.parseLong(arrColumnas[iColumn++]));
			this.parametroprodu.setdescripcion(arrColumnas[iColumn++]);
				
				this.parametroprodus.add(this.parametroprodu);
			}
			
			this.saveParametroProdus();
			
			this.connexion.commit();
			
			parametroproduReturnGeneral.setConRetornoEstaProcesado(true);
			parametroproduReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return parametroproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarParametroProdusEliminados() throws Exception {				
		
		List<ParametroProdu> parametroprodusAux= new ArrayList<ParametroProdu>();
		
		for(ParametroProdu parametroprodu:parametroprodus) {
			if(!parametroprodu.getIsDeleted()) {
				parametroprodusAux.add(parametroprodu);
			}
		}
		
		parametroprodus=parametroprodusAux;
	}
	
	public void quitarParametroProdusNulos() throws Exception {				
		
		List<ParametroProdu> parametroprodusAux= new ArrayList<ParametroProdu>();
		
		for(ParametroProdu parametroprodu : this.parametroprodus) {
			if(parametroprodu==null) {
				parametroprodusAux.add(parametroprodu);
			}
		}
		
		//this.parametroprodus=parametroprodusAux;
		
		this.parametroprodus.removeAll(parametroprodusAux);
	}
	
	public void getSetVersionRowParametroProduWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(parametroprodu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((parametroprodu.getIsDeleted() || (parametroprodu.getIsChanged()&&!parametroprodu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=parametroproduDataAccess.getSetVersionRowParametroProdu(connexion,parametroprodu.getId());
				
				if(!parametroprodu.getVersionRow().equals(timestamp)) {	
					parametroprodu.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				parametroprodu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowParametroProdu()throws Exception {	
		
		if(parametroprodu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((parametroprodu.getIsDeleted() || (parametroprodu.getIsChanged()&&!parametroprodu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=parametroproduDataAccess.getSetVersionRowParametroProdu(connexion,parametroprodu.getId());
			
			try {							
				if(!parametroprodu.getVersionRow().equals(timestamp)) {	
					parametroprodu.setVersionRow(timestamp);
				}
				
				parametroprodu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowParametroProdusWithConnection()throws Exception {	
		if(parametroprodus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ParametroProdu parametroproduAux:parametroprodus) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(parametroproduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametroproduAux.getIsDeleted() || (parametroproduAux.getIsChanged()&&!parametroproduAux.getIsNew())) {
						
						timestamp=parametroproduDataAccess.getSetVersionRowParametroProdu(connexion,parametroproduAux.getId());
						
						if(!parametroprodu.getVersionRow().equals(timestamp)) {	
							parametroproduAux.setVersionRow(timestamp);
						}
								
						parametroproduAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowParametroProdus()throws Exception {	
		if(parametroprodus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ParametroProdu parametroproduAux:parametroprodus) {
					if(parametroproduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametroproduAux.getIsDeleted() || (parametroproduAux.getIsChanged()&&!parametroproduAux.getIsNew())) {
						
						timestamp=parametroproduDataAccess.getSetVersionRowParametroProdu(connexion,parametroproduAux.getId());
						
						if(!parametroproduAux.getVersionRow().equals(timestamp)) {	
							parametroproduAux.setVersionRow(timestamp);
						}
						
													
						parametroproduAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ParametroProduParameterReturnGeneral cargarCombosLoteForeignKeyParametroProduWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalBodegaMateriaPrima,String finalQueryGlobalTransaccion,String finalQueryGlobalTransaccionEgreso) throws Exception {
		ParametroProduParameterReturnGeneral  parametroproduReturnGeneral =new ParametroProduParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroProdu.class.getSimpleName()+"-cargarCombosLoteForeignKeyParametroProduWithConnection");connexion.begin();
			
			parametroproduReturnGeneral =new ParametroProduParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametroproduReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			parametroproduReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			parametroproduReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Bodega> bodegamateriaprimasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegamateriaprimaLogic=new BodegaLogic();
			bodegamateriaprimaLogic.setConnexion(this.connexion);
			bodegamateriaprimaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodegaMateriaPrima.equals("NONE")) {
				bodegamateriaprimaLogic.getTodosBodegas(finalQueryGlobalBodegaMateriaPrima,new Pagination());
				bodegamateriaprimasForeignKey=bodegamateriaprimaLogic.getBodegas();
			}

			parametroproduReturnGeneral.setbodegamateriaprimasForeignKey(bodegamateriaprimasForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			parametroproduReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<Transaccion> transaccionegresosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionegresoLogic=new TransaccionLogic();
			transaccionegresoLogic.setConnexion(this.connexion);
			transaccionegresoLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionEgreso.equals("NONE")) {
				transaccionegresoLogic.getTodosTransaccions(finalQueryGlobalTransaccionEgreso,new Pagination());
				transaccionegresosForeignKey=transaccionegresoLogic.getTransaccions();
			}

			parametroproduReturnGeneral.settransaccionegresosForeignKey(transaccionegresosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return parametroproduReturnGeneral;
	}
	
	public ParametroProduParameterReturnGeneral cargarCombosLoteForeignKeyParametroProdu(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalBodegaMateriaPrima,String finalQueryGlobalTransaccion,String finalQueryGlobalTransaccionEgreso) throws Exception {
		ParametroProduParameterReturnGeneral  parametroproduReturnGeneral =new ParametroProduParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			parametroproduReturnGeneral =new ParametroProduParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametroproduReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			parametroproduReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			parametroproduReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Bodega> bodegamateriaprimasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegamateriaprimaLogic=new BodegaLogic();
			bodegamateriaprimaLogic.setConnexion(this.connexion);
			bodegamateriaprimaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodegaMateriaPrima.equals("NONE")) {
				bodegamateriaprimaLogic.getTodosBodegas(finalQueryGlobalBodegaMateriaPrima,new Pagination());
				bodegamateriaprimasForeignKey=bodegamateriaprimaLogic.getBodegas();
			}

			parametroproduReturnGeneral.setbodegamateriaprimasForeignKey(bodegamateriaprimasForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			parametroproduReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<Transaccion> transaccionegresosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionegresoLogic=new TransaccionLogic();
			transaccionegresoLogic.setConnexion(this.connexion);
			transaccionegresoLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionEgreso.equals("NONE")) {
				transaccionegresoLogic.getTodosTransaccions(finalQueryGlobalTransaccionEgreso,new Pagination());
				transaccionegresosForeignKey=transaccionegresoLogic.getTransaccions();
			}

			parametroproduReturnGeneral.settransaccionegresosForeignKey(transaccionegresosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return parametroproduReturnGeneral;
	}
	
	
	public void deepLoad(ParametroProdu parametroprodu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ParametroProduLogicAdditional.updateParametroProduToGet(parametroprodu,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametroprodu.setEmpresa(parametroproduDataAccess.getEmpresa(connexion,parametroprodu));
		parametroprodu.setSucursal(parametroproduDataAccess.getSucursal(connexion,parametroprodu));
		parametroprodu.setBodega(parametroproduDataAccess.getBodega(connexion,parametroprodu));
		parametroprodu.setBodegaMateriaPrima(parametroproduDataAccess.getBodegaMateriaPrima(connexion,parametroprodu));
		parametroprodu.setTransaccion(parametroproduDataAccess.getTransaccion(connexion,parametroprodu));
		parametroprodu.setTransaccionEgreso(parametroproduDataAccess.getTransaccionEgreso(connexion,parametroprodu));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametroprodu.setEmpresa(parametroproduDataAccess.getEmpresa(connexion,parametroprodu));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametroprodu.setSucursal(parametroproduDataAccess.getSucursal(connexion,parametroprodu));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				parametroprodu.setBodega(parametroproduDataAccess.getBodega(connexion,parametroprodu));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				parametroprodu.setBodegaMateriaPrima(parametroproduDataAccess.getBodegaMateriaPrima(connexion,parametroprodu));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametroprodu.setTransaccion(parametroproduDataAccess.getTransaccion(connexion,parametroprodu));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametroprodu.setTransaccionEgreso(parametroproduDataAccess.getTransaccionEgreso(connexion,parametroprodu));
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
			parametroprodu.setEmpresa(parametroproduDataAccess.getEmpresa(connexion,parametroprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroprodu.setSucursal(parametroproduDataAccess.getSucursal(connexion,parametroprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroprodu.setBodega(parametroproduDataAccess.getBodega(connexion,parametroprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroprodu.setBodegaMateriaPrima(parametroproduDataAccess.getBodegaMateriaPrima(connexion,parametroprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroprodu.setTransaccion(parametroproduDataAccess.getTransaccion(connexion,parametroprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroprodu.setTransaccionEgreso(parametroproduDataAccess.getTransaccionEgreso(connexion,parametroprodu));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametroprodu.setEmpresa(parametroproduDataAccess.getEmpresa(connexion,parametroprodu));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametroprodu.getEmpresa(),isDeep,deepLoadType,clases);
				
		parametroprodu.setSucursal(parametroproduDataAccess.getSucursal(connexion,parametroprodu));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(parametroprodu.getSucursal(),isDeep,deepLoadType,clases);
				
		parametroprodu.setBodega(parametroproduDataAccess.getBodega(connexion,parametroprodu));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(parametroprodu.getBodega(),isDeep,deepLoadType,clases);
				
		parametroprodu.setBodegaMateriaPrima(parametroproduDataAccess.getBodegaMateriaPrima(connexion,parametroprodu));
		BodegaLogic bodegamateriaprimaLogic= new BodegaLogic(connexion);
		bodegamateriaprimaLogic.deepLoad(parametroprodu.getBodegaMateriaPrima(),isDeep,deepLoadType,clases);
				
		parametroprodu.setTransaccion(parametroproduDataAccess.getTransaccion(connexion,parametroprodu));
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(parametroprodu.getTransaccion(),isDeep,deepLoadType,clases);
				
		parametroprodu.setTransaccionEgreso(parametroproduDataAccess.getTransaccionEgreso(connexion,parametroprodu));
		TransaccionLogic transaccionegresoLogic= new TransaccionLogic(connexion);
		transaccionegresoLogic.deepLoad(parametroprodu.getTransaccionEgreso(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametroprodu.setEmpresa(parametroproduDataAccess.getEmpresa(connexion,parametroprodu));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(parametroprodu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametroprodu.setSucursal(parametroproduDataAccess.getSucursal(connexion,parametroprodu));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(parametroprodu.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				parametroprodu.setBodega(parametroproduDataAccess.getBodega(connexion,parametroprodu));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(parametroprodu.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				parametroprodu.setBodegaMateriaPrima(parametroproduDataAccess.getBodegaMateriaPrima(connexion,parametroprodu));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(parametroprodu.getBodegaMateriaPrima(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametroprodu.setTransaccion(parametroproduDataAccess.getTransaccion(connexion,parametroprodu));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(parametroprodu.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametroprodu.setTransaccionEgreso(parametroproduDataAccess.getTransaccionEgreso(connexion,parametroprodu));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(parametroprodu.getTransaccionEgreso(),isDeep,deepLoadType,clases);				
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
			parametroprodu.setEmpresa(parametroproduDataAccess.getEmpresa(connexion,parametroprodu));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(parametroprodu.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroprodu.setSucursal(parametroproduDataAccess.getSucursal(connexion,parametroprodu));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(parametroprodu.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroprodu.setBodega(parametroproduDataAccess.getBodega(connexion,parametroprodu));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(parametroprodu.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroprodu.setBodegaMateriaPrima(parametroproduDataAccess.getBodegaMateriaPrima(connexion,parametroprodu));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(parametroprodu.getBodegaMateriaPrima(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroprodu.setTransaccion(parametroproduDataAccess.getTransaccion(connexion,parametroprodu));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(parametroprodu.getTransaccion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroprodu.setTransaccionEgreso(parametroproduDataAccess.getTransaccionEgreso(connexion,parametroprodu));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(parametroprodu.getTransaccionEgreso(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ParametroProdu parametroprodu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ParametroProduLogicAdditional.updateParametroProduToSave(parametroprodu,this.arrDatoGeneral);
			
ParametroProduDataAccess.save(parametroprodu, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametroprodu.getEmpresa(),connexion);

		SucursalDataAccess.save(parametroprodu.getSucursal(),connexion);

		BodegaDataAccess.save(parametroprodu.getBodega(),connexion);

		BodegaDataAccess.save(parametroprodu.getBodegaMateriaPrima(),connexion);

		TransaccionDataAccess.save(parametroprodu.getTransaccion(),connexion);

		TransaccionDataAccess.save(parametroprodu.getTransaccionEgreso(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametroprodu.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametroprodu.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(parametroprodu.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(parametroprodu.getBodegaMateriaPrima(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametroprodu.getTransaccion(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametroprodu.getTransaccionEgreso(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametroprodu.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametroprodu.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(parametroprodu.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(parametroprodu.getSucursal(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(parametroprodu.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(parametroprodu.getBodega(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(parametroprodu.getBodegaMateriaPrima(),connexion);
		BodegaLogic bodegamateriaprimaLogic= new BodegaLogic(connexion);
		bodegamateriaprimaLogic.deepLoad(parametroprodu.getBodegaMateriaPrima(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(parametroprodu.getTransaccion(),connexion);
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(parametroprodu.getTransaccion(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(parametroprodu.getTransaccionEgreso(),connexion);
		TransaccionLogic transaccionegresoLogic= new TransaccionLogic(connexion);
		transaccionegresoLogic.deepLoad(parametroprodu.getTransaccionEgreso(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametroprodu.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(parametroprodu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametroprodu.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(parametroprodu.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(parametroprodu.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(parametroprodu.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(parametroprodu.getBodegaMateriaPrima(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(parametroprodu.getBodegaMateriaPrima(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametroprodu.getTransaccion(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(parametroprodu.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametroprodu.getTransaccionEgreso(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(parametroprodu.getTransaccionEgreso(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ParametroProdu.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(parametroprodu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(parametroprodu);
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
			this.deepLoad(this.parametroprodu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(this.parametroprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParametroProdu.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(parametroprodus!=null) {
				for(ParametroProdu parametroprodu:parametroprodus) {
					this.deepLoad(parametroprodu,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(parametroprodus);
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
			if(parametroprodus!=null) {
				for(ParametroProdu parametroprodu:parametroprodus) {
					this.deepLoad(parametroprodu,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(parametroprodus);
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
			this.getNewConnexionToDeep(ParametroProdu.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(parametroprodu,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ParametroProdu.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(parametroprodus!=null) {
				for(ParametroProdu parametroprodu:parametroprodus) {
					this.deepSave(parametroprodu,isDeep,deepLoadType,clases);
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
			if(parametroprodus!=null) {
				for(ParametroProdu parametroprodu:parametroprodus) {
					this.deepSave(parametroprodu,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getParametroProdusFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,ParametroProduConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ParametroProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroprodus=parametroproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(this.parametroprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroProdusFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,ParametroProduConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ParametroProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroprodus=parametroproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(this.parametroprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroProdusFK_IdBodegaMateriaPrimaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega_materia_prima)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodegaMateriaPrima= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodegaMateriaPrima.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega_materia_prima,ParametroProduConstantesFunciones.IDBODEGAMATERIAPRIMA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodegaMateriaPrima);

			ParametroProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaMateriaPrima","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroprodus=parametroproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(this.parametroprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroProdusFK_IdBodegaMateriaPrima(String sFinalQuery,Pagination pagination,Long id_bodega_materia_prima)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodegaMateriaPrima= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodegaMateriaPrima.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega_materia_prima,ParametroProduConstantesFunciones.IDBODEGAMATERIAPRIMA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodegaMateriaPrima);

			ParametroProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaMateriaPrima","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroprodus=parametroproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(this.parametroprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroProdusFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroProduConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroprodus=parametroproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(this.parametroprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroProdusFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroProduConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroprodus=parametroproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(this.parametroprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroProdusFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ParametroProduConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParametroProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroprodus=parametroproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(this.parametroprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroProdusFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ParametroProduConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParametroProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroprodus=parametroproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(this.parametroprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroProdusFK_IdTransaccionWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,ParametroProduConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			ParametroProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroprodus=parametroproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(this.parametroprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroProdusFK_IdTransaccion(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,ParametroProduConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			ParametroProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroprodus=parametroproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(this.parametroprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroProdusFK_IdTransaccionEgresoWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_egreso)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionEgreso= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionEgreso.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_egreso,ParametroProduConstantesFunciones.IDTRANSACCIONEGRESO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionEgreso);

			ParametroProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionEgreso","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroprodus=parametroproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(this.parametroprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroProdusFK_IdTransaccionEgreso(String sFinalQuery,Pagination pagination,Long id_transaccion_egreso)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionEgreso= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionEgreso.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_egreso,ParametroProduConstantesFunciones.IDTRANSACCIONEGRESO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionEgreso);

			ParametroProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionEgreso","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroprodus=parametroproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroProduConstantesFunciones.refrescarForeignKeysDescripcionesParametroProdu(this.parametroprodus);
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
			if(ParametroProduConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroProduDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ParametroProdu parametroprodu,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParametroProduConstantesFunciones.ISCONAUDITORIA) {
				if(parametroprodu.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroProduDataAccess.TABLENAME, parametroprodu.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroProduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroProduLogic.registrarAuditoriaDetallesParametroProdu(connexion,parametroprodu,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(parametroprodu.getIsDeleted()) {
					/*if(!parametroprodu.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ParametroProduDataAccess.TABLENAME, parametroprodu.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ParametroProduLogic.registrarAuditoriaDetallesParametroProdu(connexion,parametroprodu,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroProduDataAccess.TABLENAME, parametroprodu.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(parametroprodu.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroProduDataAccess.TABLENAME, parametroprodu.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroProduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroProduLogic.registrarAuditoriaDetallesParametroProdu(connexion,parametroprodu,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesParametroProdu(Connexion connexion,ParametroProdu parametroprodu)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(parametroprodu.getIsNew()||!parametroprodu.getid_empresa().equals(parametroprodu.getParametroProduOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroprodu.getParametroProduOriginal().getid_empresa()!=null)
				{
					strValorActual=parametroprodu.getParametroProduOriginal().getid_empresa().toString();
				}
				if(parametroprodu.getid_empresa()!=null)
				{
					strValorNuevo=parametroprodu.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroProduConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(parametroprodu.getIsNew()||!parametroprodu.getid_sucursal().equals(parametroprodu.getParametroProduOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroprodu.getParametroProduOriginal().getid_sucursal()!=null)
				{
					strValorActual=parametroprodu.getParametroProduOriginal().getid_sucursal().toString();
				}
				if(parametroprodu.getid_sucursal()!=null)
				{
					strValorNuevo=parametroprodu.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroProduConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(parametroprodu.getIsNew()||!parametroprodu.getid_bodega().equals(parametroprodu.getParametroProduOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroprodu.getParametroProduOriginal().getid_bodega()!=null)
				{
					strValorActual=parametroprodu.getParametroProduOriginal().getid_bodega().toString();
				}
				if(parametroprodu.getid_bodega()!=null)
				{
					strValorNuevo=parametroprodu.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroProduConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(parametroprodu.getIsNew()||!parametroprodu.getid_bodega_materia_prima().equals(parametroprodu.getParametroProduOriginal().getid_bodega_materia_prima()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroprodu.getParametroProduOriginal().getid_bodega_materia_prima()!=null)
				{
					strValorActual=parametroprodu.getParametroProduOriginal().getid_bodega_materia_prima().toString();
				}
				if(parametroprodu.getid_bodega_materia_prima()!=null)
				{
					strValorNuevo=parametroprodu.getid_bodega_materia_prima().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroProduConstantesFunciones.IDBODEGAMATERIAPRIMA,strValorActual,strValorNuevo);
			}	
			
			if(parametroprodu.getIsNew()||!parametroprodu.getid_transaccion().equals(parametroprodu.getParametroProduOriginal().getid_transaccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroprodu.getParametroProduOriginal().getid_transaccion()!=null)
				{
					strValorActual=parametroprodu.getParametroProduOriginal().getid_transaccion().toString();
				}
				if(parametroprodu.getid_transaccion()!=null)
				{
					strValorNuevo=parametroprodu.getid_transaccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroProduConstantesFunciones.IDTRANSACCION,strValorActual,strValorNuevo);
			}	
			
			if(parametroprodu.getIsNew()||!parametroprodu.getid_transaccion_egreso().equals(parametroprodu.getParametroProduOriginal().getid_transaccion_egreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroprodu.getParametroProduOriginal().getid_transaccion_egreso()!=null)
				{
					strValorActual=parametroprodu.getParametroProduOriginal().getid_transaccion_egreso().toString();
				}
				if(parametroprodu.getid_transaccion_egreso()!=null)
				{
					strValorNuevo=parametroprodu.getid_transaccion_egreso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroProduConstantesFunciones.IDTRANSACCIONEGRESO,strValorActual,strValorNuevo);
			}	
			
			if(parametroprodu.getIsNew()||!parametroprodu.getcon_relacion_porcentaje().equals(parametroprodu.getParametroProduOriginal().getcon_relacion_porcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroprodu.getParametroProduOriginal().getcon_relacion_porcentaje()!=null)
				{
					strValorActual=parametroprodu.getParametroProduOriginal().getcon_relacion_porcentaje().toString();
				}
				if(parametroprodu.getcon_relacion_porcentaje()!=null)
				{
					strValorNuevo=parametroprodu.getcon_relacion_porcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroProduConstantesFunciones.CONRELACIONPORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(parametroprodu.getIsNew()||!parametroprodu.getdescripcion().equals(parametroprodu.getParametroProduOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroprodu.getParametroProduOriginal().getdescripcion()!=null)
				{
					strValorActual=parametroprodu.getParametroProduOriginal().getdescripcion();
				}
				if(parametroprodu.getdescripcion()!=null)
				{
					strValorNuevo=parametroprodu.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroProduConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveParametroProduRelacionesWithConnection(ParametroProdu parametroprodu) throws Exception {

		if(!parametroprodu.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroProduRelacionesBase(parametroprodu,true);
		}
	}

	public void saveParametroProduRelaciones(ParametroProdu parametroprodu)throws Exception {

		if(!parametroprodu.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroProduRelacionesBase(parametroprodu,false);
		}
	}

	public void saveParametroProduRelacionesBase(ParametroProdu parametroprodu,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ParametroProdu-saveRelacionesWithConnection");}
	

			this.setParametroProdu(parametroprodu);

			if(ParametroProduLogicAdditional.validarSaveRelaciones(parametroprodu,this)) {

				ParametroProduLogicAdditional.updateRelacionesToSave(parametroprodu,this);

				if((parametroprodu.getIsNew()||parametroprodu.getIsChanged())&&!parametroprodu.getIsDeleted()) {
					this.saveParametroProdu();
					this.saveParametroProduRelacionesDetalles();

				} else if(parametroprodu.getIsDeleted()) {
					this.saveParametroProduRelacionesDetalles();
					this.saveParametroProdu();
				}

				ParametroProduLogicAdditional.updateRelacionesToSaveAfter(parametroprodu,this);

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
	
	
	private void saveParametroProduRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfParametroProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroProduConstantesFunciones.getClassesForeignKeysOfParametroProdu(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroProduConstantesFunciones.getClassesRelationshipsOfParametroProdu(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
