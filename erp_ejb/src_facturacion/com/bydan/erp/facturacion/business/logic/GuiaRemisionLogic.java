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
import com.bydan.erp.facturacion.util.GuiaRemisionConstantesFunciones;
import com.bydan.erp.facturacion.util.GuiaRemisionParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.GuiaRemisionParameterGeneral;
import com.bydan.erp.facturacion.business.entity.GuiaRemision;
import com.bydan.erp.facturacion.business.logic.GuiaRemisionLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class GuiaRemisionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(GuiaRemisionLogic.class);
	
	protected GuiaRemisionDataAccess guiaremisionDataAccess; 	
	protected GuiaRemision guiaremision;
	protected List<GuiaRemision> guiaremisions;
	protected Object guiaremisionObject;	
	protected List<Object> guiaremisionsObject;
	
	public static ClassValidator<GuiaRemision> guiaremisionValidator = new ClassValidator<GuiaRemision>(GuiaRemision.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected GuiaRemisionLogicAdditional guiaremisionLogicAdditional=null;
	
	public GuiaRemisionLogicAdditional getGuiaRemisionLogicAdditional() {
		return this.guiaremisionLogicAdditional;
	}
	
	public void setGuiaRemisionLogicAdditional(GuiaRemisionLogicAdditional guiaremisionLogicAdditional) {
		try {
			this.guiaremisionLogicAdditional=guiaremisionLogicAdditional;
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
	
	
	
	
	public  GuiaRemisionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.guiaremisionDataAccess = new GuiaRemisionDataAccess();
			
			this.guiaremisions= new ArrayList<GuiaRemision>();
			this.guiaremision= new GuiaRemision();
			
			this.guiaremisionObject=new Object();
			this.guiaremisionsObject=new ArrayList<Object>();
				
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
			
			this.guiaremisionDataAccess.setConnexionType(this.connexionType);
			this.guiaremisionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  GuiaRemisionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.guiaremisionDataAccess = new GuiaRemisionDataAccess();
			this.guiaremisions= new ArrayList<GuiaRemision>();
			this.guiaremision= new GuiaRemision();
			this.guiaremisionObject=new Object();
			this.guiaremisionsObject=new ArrayList<Object>();
			
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
			
			this.guiaremisionDataAccess.setConnexionType(this.connexionType);
			this.guiaremisionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public GuiaRemision getGuiaRemision() throws Exception {	
		GuiaRemisionLogicAdditional.checkGuiaRemisionToGet(guiaremision,this.datosCliente,this.arrDatoGeneral);
		GuiaRemisionLogicAdditional.updateGuiaRemisionToGet(guiaremision,this.arrDatoGeneral);
		
		return guiaremision;
	}
		
	public void setGuiaRemision(GuiaRemision newGuiaRemision) {
		this.guiaremision = newGuiaRemision;
	}
	
	public GuiaRemisionDataAccess getGuiaRemisionDataAccess() {
		return guiaremisionDataAccess;
	}
	
	public void setGuiaRemisionDataAccess(GuiaRemisionDataAccess newguiaremisionDataAccess) {
		this.guiaremisionDataAccess = newguiaremisionDataAccess;
	}
	
	public List<GuiaRemision> getGuiaRemisions() throws Exception {		
		this.quitarGuiaRemisionsNulos();
		
		GuiaRemisionLogicAdditional.checkGuiaRemisionToGets(guiaremisions,this.datosCliente,this.arrDatoGeneral);
		
		for (GuiaRemision guiaremisionLocal: guiaremisions ) {
			GuiaRemisionLogicAdditional.updateGuiaRemisionToGet(guiaremisionLocal,this.arrDatoGeneral);
		}
		
		return guiaremisions;
	}
	
	public void setGuiaRemisions(List<GuiaRemision> newGuiaRemisions) {
		this.guiaremisions = newGuiaRemisions;
	}
	
	public Object getGuiaRemisionObject() {	
		this.guiaremisionObject=this.guiaremisionDataAccess.getEntityObject();
		return this.guiaremisionObject;
	}
		
	public void setGuiaRemisionObject(Object newGuiaRemisionObject) {
		this.guiaremisionObject = newGuiaRemisionObject;
	}
	
	public List<Object> getGuiaRemisionsObject() {		
		this.guiaremisionsObject=this.guiaremisionDataAccess.getEntitiesObject();
		return this.guiaremisionsObject;
	}
		
	public void setGuiaRemisionsObject(List<Object> newGuiaRemisionsObject) {
		this.guiaremisionsObject = newGuiaRemisionsObject;
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
		
		if(this.guiaremisionDataAccess!=null) {
			this.guiaremisionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			guiaremisionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			guiaremisionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		guiaremision = new  GuiaRemision();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			guiaremision=guiaremisionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.guiaremision,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremision);
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
		guiaremision = new  GuiaRemision();
		  		  
        try {
			
			guiaremision=guiaremisionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.guiaremision,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremision);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		guiaremision = new  GuiaRemision();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			guiaremision=guiaremisionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.guiaremision,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremision);
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
		guiaremision = new  GuiaRemision();
		  		  
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
		guiaremision = new  GuiaRemision();
		  		  
        try {
			
			guiaremision=guiaremisionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.guiaremision,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremision);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		guiaremision = new  GuiaRemision();
		  		  
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
		guiaremision = new  GuiaRemision();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =guiaremisionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		guiaremision = new  GuiaRemision();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=guiaremisionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		guiaremision = new  GuiaRemision();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =guiaremisionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		guiaremision = new  GuiaRemision();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=guiaremisionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		guiaremision = new  GuiaRemision();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =guiaremisionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		guiaremision = new  GuiaRemision();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=guiaremisionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		guiaremisions = new  ArrayList<GuiaRemision>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			guiaremisions=guiaremisionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGuiaRemision(guiaremisions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
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
		guiaremisions = new  ArrayList<GuiaRemision>();
		  		  
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
		guiaremisions = new  ArrayList<GuiaRemision>();
		  		  
        try {			
			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			guiaremisions=guiaremisionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarGuiaRemision(guiaremisions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		guiaremisions = new  ArrayList<GuiaRemision>();
		  		  
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
		guiaremisions = new  ArrayList<GuiaRemision>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			guiaremisions=guiaremisionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGuiaRemision(guiaremisions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
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
		guiaremisions = new  ArrayList<GuiaRemision>();
		  		  
        try {
			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			guiaremisions=guiaremisionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGuiaRemision(guiaremisions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
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
		guiaremisions = new  ArrayList<GuiaRemision>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			guiaremisions=guiaremisionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGuiaRemision(guiaremisions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
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
		guiaremisions = new  ArrayList<GuiaRemision>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			guiaremisions=guiaremisionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGuiaRemision(guiaremisions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		guiaremision = new  GuiaRemision();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			guiaremision=guiaremisionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGuiaRemision(guiaremision);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremision);
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
		guiaremision = new  GuiaRemision();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			guiaremision=guiaremisionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGuiaRemision(guiaremision);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremision);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		guiaremisions = new  ArrayList<GuiaRemision>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			guiaremisions=guiaremisionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGuiaRemision(guiaremisions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
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
		guiaremisions = new  ArrayList<GuiaRemision>();
		  		  
        try {
			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			guiaremisions=guiaremisionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGuiaRemision(guiaremisions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosGuiaRemisionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		guiaremisions = new  ArrayList<GuiaRemision>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getTodosGuiaRemisionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarGuiaRemision(guiaremisions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
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
	
	public  void  getTodosGuiaRemisions(String sFinalQuery,Pagination pagination)throws Exception {
		guiaremisions = new  ArrayList<GuiaRemision>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarGuiaRemision(guiaremisions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarGuiaRemision(GuiaRemision guiaremision) throws Exception {
		Boolean estaValidado=false;
		
		if(guiaremision.getIsNew() || guiaremision.getIsChanged()) { 
			this.invalidValues = guiaremisionValidator.getInvalidValues(guiaremision);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(guiaremision);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarGuiaRemision(List<GuiaRemision> GuiaRemisions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(GuiaRemision guiaremisionLocal:guiaremisions) {				
			estaValidadoObjeto=this.validarGuardarGuiaRemision(guiaremisionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarGuiaRemision(List<GuiaRemision> GuiaRemisions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarGuiaRemision(guiaremisions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarGuiaRemision(GuiaRemision GuiaRemision) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarGuiaRemision(guiaremision)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(GuiaRemision guiaremision) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+guiaremision.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=GuiaRemisionConstantesFunciones.getGuiaRemisionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"guiaremision","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(GuiaRemisionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(GuiaRemisionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveGuiaRemisionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-saveGuiaRemisionWithConnection");connexion.begin();			
			
			GuiaRemisionLogicAdditional.checkGuiaRemisionToSave(this.guiaremision,this.datosCliente,connexion,this.arrDatoGeneral);
			
			GuiaRemisionLogicAdditional.updateGuiaRemisionToSave(this.guiaremision,this.arrDatoGeneral);
			
			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.guiaremision,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowGuiaRemision();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarGuiaRemision(this.guiaremision)) {
				GuiaRemisionDataAccess.save(this.guiaremision, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.guiaremision,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			GuiaRemisionLogicAdditional.checkGuiaRemisionToSaveAfter(this.guiaremision,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowGuiaRemision();
			
			connexion.commit();			
			
			if(this.guiaremision.getIsDeleted()) {
				this.guiaremision=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveGuiaRemision()throws Exception {	
		try {	
			
			GuiaRemisionLogicAdditional.checkGuiaRemisionToSave(this.guiaremision,this.datosCliente,connexion,this.arrDatoGeneral);
			
			GuiaRemisionLogicAdditional.updateGuiaRemisionToSave(this.guiaremision,this.arrDatoGeneral);
			
			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.guiaremision,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarGuiaRemision(this.guiaremision)) {			
				GuiaRemisionDataAccess.save(this.guiaremision, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.guiaremision,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			GuiaRemisionLogicAdditional.checkGuiaRemisionToSaveAfter(this.guiaremision,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.guiaremision.getIsDeleted()) {
				this.guiaremision=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveGuiaRemisionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-saveGuiaRemisionsWithConnection");connexion.begin();			
			
			GuiaRemisionLogicAdditional.checkGuiaRemisionToSaves(guiaremisions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowGuiaRemisions();
			
			Boolean validadoTodosGuiaRemision=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(GuiaRemision guiaremisionLocal:guiaremisions) {		
				if(guiaremisionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				GuiaRemisionLogicAdditional.updateGuiaRemisionToSave(guiaremisionLocal,this.arrDatoGeneral);
	        	
				GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),guiaremisionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarGuiaRemision(guiaremisionLocal)) {
					GuiaRemisionDataAccess.save(guiaremisionLocal, connexion);				
				} else {
					validadoTodosGuiaRemision=false;
				}
			}
			
			if(!validadoTodosGuiaRemision) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			GuiaRemisionLogicAdditional.checkGuiaRemisionToSavesAfter(guiaremisions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowGuiaRemisions();
			
			connexion.commit();		
			
			this.quitarGuiaRemisionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveGuiaRemisions()throws Exception {				
		 try {	
			GuiaRemisionLogicAdditional.checkGuiaRemisionToSaves(guiaremisions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosGuiaRemision=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(GuiaRemision guiaremisionLocal:guiaremisions) {				
				if(guiaremisionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				GuiaRemisionLogicAdditional.updateGuiaRemisionToSave(guiaremisionLocal,this.arrDatoGeneral);
	        	
				GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),guiaremisionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarGuiaRemision(guiaremisionLocal)) {				
					GuiaRemisionDataAccess.save(guiaremisionLocal, connexion);				
				} else {
					validadoTodosGuiaRemision=false;
				}
			}
			
			if(!validadoTodosGuiaRemision) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			GuiaRemisionLogicAdditional.checkGuiaRemisionToSavesAfter(guiaremisions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarGuiaRemisionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public GuiaRemisionParameterReturnGeneral procesarAccionGuiaRemisions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<GuiaRemision> guiaremisions,GuiaRemisionParameterReturnGeneral guiaremisionParameterGeneral)throws Exception {
		 try {	
			GuiaRemisionParameterReturnGeneral guiaremisionReturnGeneral=new GuiaRemisionParameterReturnGeneral();
	
			GuiaRemisionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,guiaremisions,guiaremisionParameterGeneral,guiaremisionReturnGeneral);
			
			return guiaremisionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public GuiaRemisionParameterReturnGeneral procesarAccionGuiaRemisionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<GuiaRemision> guiaremisions,GuiaRemisionParameterReturnGeneral guiaremisionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-procesarAccionGuiaRemisionsWithConnection");connexion.begin();			
			
			GuiaRemisionParameterReturnGeneral guiaremisionReturnGeneral=new GuiaRemisionParameterReturnGeneral();
	
			GuiaRemisionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,guiaremisions,guiaremisionParameterGeneral,guiaremisionReturnGeneral);
			
			this.connexion.commit();
			
			return guiaremisionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public GuiaRemisionParameterReturnGeneral procesarEventosGuiaRemisions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<GuiaRemision> guiaremisions,GuiaRemision guiaremision,GuiaRemisionParameterReturnGeneral guiaremisionParameterGeneral,Boolean isEsNuevoGuiaRemision,ArrayList<Classe> clases)throws Exception {
		 try {	
			GuiaRemisionParameterReturnGeneral guiaremisionReturnGeneral=new GuiaRemisionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				guiaremisionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			GuiaRemisionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,guiaremisions,guiaremision,guiaremisionParameterGeneral,guiaremisionReturnGeneral,isEsNuevoGuiaRemision,clases);
			
			return guiaremisionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public GuiaRemisionParameterReturnGeneral procesarEventosGuiaRemisionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<GuiaRemision> guiaremisions,GuiaRemision guiaremision,GuiaRemisionParameterReturnGeneral guiaremisionParameterGeneral,Boolean isEsNuevoGuiaRemision,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-procesarEventosGuiaRemisionsWithConnection");connexion.begin();			
			
			GuiaRemisionParameterReturnGeneral guiaremisionReturnGeneral=new GuiaRemisionParameterReturnGeneral();
	
			guiaremisionReturnGeneral.setGuiaRemision(guiaremision);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				guiaremisionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			GuiaRemisionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,guiaremisions,guiaremision,guiaremisionParameterGeneral,guiaremisionReturnGeneral,isEsNuevoGuiaRemision,clases);
			
			this.connexion.commit();
			
			return guiaremisionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public GuiaRemisionParameterReturnGeneral procesarImportacionGuiaRemisionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,GuiaRemisionParameterReturnGeneral guiaremisionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-procesarImportacionGuiaRemisionsWithConnection");connexion.begin();			
			
			GuiaRemisionParameterReturnGeneral guiaremisionReturnGeneral=new GuiaRemisionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.guiaremisions=new ArrayList<GuiaRemision>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.guiaremision=new GuiaRemision();
				
				
				if(conColumnasBase) {this.guiaremision.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.guiaremision.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.guiaremision.setsecuencial(arrColumnas[iColumn++]);
				this.guiaremision.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.guiaremision.setnumero_camion(arrColumnas[iColumn++]);
				this.guiaremision.setidentificacion(arrColumnas[iColumn++]);
				this.guiaremision.setfecha_origen(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.guiaremision.setfecha_destino(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.guiaremision.settransporte_codigo(arrColumnas[iColumn++]);
				this.guiaremision.setcantidad_bultos(Integer.parseInt(arrColumnas[iColumn++]));
				//this.guiaremision.sethora_inicio(arrColumnas[iColumn++]);
				//this.guiaremision.sethora_fin(arrColumnas[iColumn++]);
				this.guiaremision.setcupo(Double.parseDouble(arrColumnas[iColumn++]));
				this.guiaremision.setsaldo(Double.parseDouble(arrColumnas[iColumn++]));
				this.guiaremision.setdocumento(Double.parseDouble(arrColumnas[iColumn++]));
				this.guiaremision.setdisponible(Double.parseDouble(arrColumnas[iColumn++]));
			this.guiaremision.setdescripcion(arrColumnas[iColumn++]);
				this.guiaremision.settotal_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.guiaremision.settotal_sin_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.guiaremision.setdescuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.guiaremision.setflete(Double.parseDouble(arrColumnas[iColumn++]));
				this.guiaremision.setotro(Double.parseDouble(arrColumnas[iColumn++]));
				this.guiaremision.setfinanciamiento(Double.parseDouble(arrColumnas[iColumn++]));
				this.guiaremision.setiva(Double.parseDouble(arrColumnas[iColumn++]));
				this.guiaremision.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.guiaremisions.add(this.guiaremision);
			}
			
			this.saveGuiaRemisions();
			
			this.connexion.commit();
			
			guiaremisionReturnGeneral.setConRetornoEstaProcesado(true);
			guiaremisionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return guiaremisionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarGuiaRemisionsEliminados() throws Exception {				
		
		List<GuiaRemision> guiaremisionsAux= new ArrayList<GuiaRemision>();
		
		for(GuiaRemision guiaremision:guiaremisions) {
			if(!guiaremision.getIsDeleted()) {
				guiaremisionsAux.add(guiaremision);
			}
		}
		
		guiaremisions=guiaremisionsAux;
	}
	
	public void quitarGuiaRemisionsNulos() throws Exception {				
		
		List<GuiaRemision> guiaremisionsAux= new ArrayList<GuiaRemision>();
		
		for(GuiaRemision guiaremision : this.guiaremisions) {
			if(guiaremision==null) {
				guiaremisionsAux.add(guiaremision);
			}
		}
		
		//this.guiaremisions=guiaremisionsAux;
		
		this.guiaremisions.removeAll(guiaremisionsAux);
	}
	
	public void getSetVersionRowGuiaRemisionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(guiaremision.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((guiaremision.getIsDeleted() || (guiaremision.getIsChanged()&&!guiaremision.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=guiaremisionDataAccess.getSetVersionRowGuiaRemision(connexion,guiaremision.getId());
				
				if(!guiaremision.getVersionRow().equals(timestamp)) {	
					guiaremision.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				guiaremision.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowGuiaRemision()throws Exception {	
		
		if(guiaremision.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((guiaremision.getIsDeleted() || (guiaremision.getIsChanged()&&!guiaremision.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=guiaremisionDataAccess.getSetVersionRowGuiaRemision(connexion,guiaremision.getId());
			
			try {							
				if(!guiaremision.getVersionRow().equals(timestamp)) {	
					guiaremision.setVersionRow(timestamp);
				}
				
				guiaremision.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowGuiaRemisionsWithConnection()throws Exception {	
		if(guiaremisions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(GuiaRemision guiaremisionAux:guiaremisions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(guiaremisionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(guiaremisionAux.getIsDeleted() || (guiaremisionAux.getIsChanged()&&!guiaremisionAux.getIsNew())) {
						
						timestamp=guiaremisionDataAccess.getSetVersionRowGuiaRemision(connexion,guiaremisionAux.getId());
						
						if(!guiaremision.getVersionRow().equals(timestamp)) {	
							guiaremisionAux.setVersionRow(timestamp);
						}
								
						guiaremisionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowGuiaRemisions()throws Exception {	
		if(guiaremisions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(GuiaRemision guiaremisionAux:guiaremisions) {
					if(guiaremisionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(guiaremisionAux.getIsDeleted() || (guiaremisionAux.getIsChanged()&&!guiaremisionAux.getIsNew())) {
						
						timestamp=guiaremisionDataAccess.getSetVersionRowGuiaRemision(connexion,guiaremisionAux.getId());
						
						if(!guiaremisionAux.getVersionRow().equals(timestamp)) {	
							guiaremisionAux.setVersionRow(timestamp);
						}
						
													
						guiaremisionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public GuiaRemisionParameterReturnGeneral cargarCombosLoteForeignKeyGuiaRemisionWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalUsuario,String finalQueryGlobalFormato,String finalQueryGlobalTipoPrecio,String finalQueryGlobalMoneda,String finalQueryGlobalCliente,String finalQueryGlobalVendedor,String finalQueryGlobalFactura,String finalQueryGlobalTransportista,String finalQueryGlobalConsultor,String finalQueryGlobalTransporte,String finalQueryGlobalSubCliente,String finalQueryGlobalEmpleado,String finalQueryGlobalCiudadOrigen,String finalQueryGlobalCiudadDestino,String finalQueryGlobalTipoLlamada,String finalQueryGlobalTipoCambio) throws Exception {
		GuiaRemisionParameterReturnGeneral  guiaremisionReturnGeneral =new GuiaRemisionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-cargarCombosLoteForeignKeyGuiaRemisionWithConnection");connexion.begin();
			
			guiaremisionReturnGeneral =new GuiaRemisionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			guiaremisionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			guiaremisionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			guiaremisionReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			guiaremisionReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			guiaremisionReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			guiaremisionReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			guiaremisionReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			guiaremisionReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			guiaremisionReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			guiaremisionReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			guiaremisionReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<Transportista> transportistasForeignKey=new ArrayList<Transportista>();
			TransportistaLogic transportistaLogic=new TransportistaLogic();
			transportistaLogic.setConnexion(this.connexion);
			transportistaLogic.getTransportistaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransportista.equals("NONE")) {
				transportistaLogic.getTodosTransportistas(finalQueryGlobalTransportista,new Pagination());
				transportistasForeignKey=transportistaLogic.getTransportistas();
			}

			guiaremisionReturnGeneral.settransportistasForeignKey(transportistasForeignKey);


			List<Consultor> consultorsForeignKey=new ArrayList<Consultor>();
			ConsultorLogic consultorLogic=new ConsultorLogic();
			consultorLogic.setConnexion(this.connexion);
			consultorLogic.getConsultorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalConsultor.equals("NONE")) {
				consultorLogic.getTodosConsultors(finalQueryGlobalConsultor,new Pagination());
				consultorsForeignKey=consultorLogic.getConsultors();
			}

			guiaremisionReturnGeneral.setconsultorsForeignKey(consultorsForeignKey);


			List<Transporte> transportesForeignKey=new ArrayList<Transporte>();
			TransporteLogic transporteLogic=new TransporteLogic();
			transporteLogic.setConnexion(this.connexion);
			transporteLogic.getTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransporte.equals("NONE")) {
				transporteLogic.getTodosTransportes(finalQueryGlobalTransporte,new Pagination());
				transportesForeignKey=transporteLogic.getTransportes();
			}

			guiaremisionReturnGeneral.settransportesForeignKey(transportesForeignKey);


			List<SubCliente> subclientesForeignKey=new ArrayList<SubCliente>();
			SubClienteLogic subclienteLogic=new SubClienteLogic();
			subclienteLogic.setConnexion(this.connexion);
			subclienteLogic.getSubClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSubCliente.equals("NONE")) {
				subclienteLogic.getTodosSubClientes(finalQueryGlobalSubCliente,new Pagination());
				subclientesForeignKey=subclienteLogic.getSubClientes();
			}

			guiaremisionReturnGeneral.setsubclientesForeignKey(subclientesForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			guiaremisionReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Ciudad> ciudadorigensForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadorigenLogic=new CiudadLogic();
			ciudadorigenLogic.setConnexion(this.connexion);
			ciudadorigenLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudadOrigen.equals("NONE")) {
				ciudadorigenLogic.getTodosCiudads(finalQueryGlobalCiudadOrigen,new Pagination());
				ciudadorigensForeignKey=ciudadorigenLogic.getCiudads();
			}

			guiaremisionReturnGeneral.setciudadorigensForeignKey(ciudadorigensForeignKey);


			List<Ciudad> ciudaddestinosForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudaddestinoLogic=new CiudadLogic();
			ciudaddestinoLogic.setConnexion(this.connexion);
			ciudaddestinoLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudadDestino.equals("NONE")) {
				ciudaddestinoLogic.getTodosCiudads(finalQueryGlobalCiudadDestino,new Pagination());
				ciudaddestinosForeignKey=ciudaddestinoLogic.getCiudads();
			}

			guiaremisionReturnGeneral.setciudaddestinosForeignKey(ciudaddestinosForeignKey);


			List<TipoLlamada> tipollamadasForeignKey=new ArrayList<TipoLlamada>();
			TipoLlamadaLogic tipollamadaLogic=new TipoLlamadaLogic();
			tipollamadaLogic.setConnexion(this.connexion);
			tipollamadaLogic.getTipoLlamadaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoLlamada.equals("NONE")) {
				tipollamadaLogic.getTodosTipoLlamadas(finalQueryGlobalTipoLlamada,new Pagination());
				tipollamadasForeignKey=tipollamadaLogic.getTipoLlamadas();
			}

			guiaremisionReturnGeneral.settipollamadasForeignKey(tipollamadasForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			guiaremisionReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return guiaremisionReturnGeneral;
	}
	
	public GuiaRemisionParameterReturnGeneral cargarCombosLoteForeignKeyGuiaRemision(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalUsuario,String finalQueryGlobalFormato,String finalQueryGlobalTipoPrecio,String finalQueryGlobalMoneda,String finalQueryGlobalCliente,String finalQueryGlobalVendedor,String finalQueryGlobalFactura,String finalQueryGlobalTransportista,String finalQueryGlobalConsultor,String finalQueryGlobalTransporte,String finalQueryGlobalSubCliente,String finalQueryGlobalEmpleado,String finalQueryGlobalCiudadOrigen,String finalQueryGlobalCiudadDestino,String finalQueryGlobalTipoLlamada,String finalQueryGlobalTipoCambio) throws Exception {
		GuiaRemisionParameterReturnGeneral  guiaremisionReturnGeneral =new GuiaRemisionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			guiaremisionReturnGeneral =new GuiaRemisionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			guiaremisionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			guiaremisionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			guiaremisionReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			guiaremisionReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			guiaremisionReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			guiaremisionReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			guiaremisionReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			guiaremisionReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			guiaremisionReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			guiaremisionReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			guiaremisionReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<Transportista> transportistasForeignKey=new ArrayList<Transportista>();
			TransportistaLogic transportistaLogic=new TransportistaLogic();
			transportistaLogic.setConnexion(this.connexion);
			transportistaLogic.getTransportistaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransportista.equals("NONE")) {
				transportistaLogic.getTodosTransportistas(finalQueryGlobalTransportista,new Pagination());
				transportistasForeignKey=transportistaLogic.getTransportistas();
			}

			guiaremisionReturnGeneral.settransportistasForeignKey(transportistasForeignKey);


			List<Consultor> consultorsForeignKey=new ArrayList<Consultor>();
			ConsultorLogic consultorLogic=new ConsultorLogic();
			consultorLogic.setConnexion(this.connexion);
			consultorLogic.getConsultorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalConsultor.equals("NONE")) {
				consultorLogic.getTodosConsultors(finalQueryGlobalConsultor,new Pagination());
				consultorsForeignKey=consultorLogic.getConsultors();
			}

			guiaremisionReturnGeneral.setconsultorsForeignKey(consultorsForeignKey);


			List<Transporte> transportesForeignKey=new ArrayList<Transporte>();
			TransporteLogic transporteLogic=new TransporteLogic();
			transporteLogic.setConnexion(this.connexion);
			transporteLogic.getTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransporte.equals("NONE")) {
				transporteLogic.getTodosTransportes(finalQueryGlobalTransporte,new Pagination());
				transportesForeignKey=transporteLogic.getTransportes();
			}

			guiaremisionReturnGeneral.settransportesForeignKey(transportesForeignKey);


			List<SubCliente> subclientesForeignKey=new ArrayList<SubCliente>();
			SubClienteLogic subclienteLogic=new SubClienteLogic();
			subclienteLogic.setConnexion(this.connexion);
			subclienteLogic.getSubClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSubCliente.equals("NONE")) {
				subclienteLogic.getTodosSubClientes(finalQueryGlobalSubCliente,new Pagination());
				subclientesForeignKey=subclienteLogic.getSubClientes();
			}

			guiaremisionReturnGeneral.setsubclientesForeignKey(subclientesForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			guiaremisionReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Ciudad> ciudadorigensForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadorigenLogic=new CiudadLogic();
			ciudadorigenLogic.setConnexion(this.connexion);
			ciudadorigenLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudadOrigen.equals("NONE")) {
				ciudadorigenLogic.getTodosCiudads(finalQueryGlobalCiudadOrigen,new Pagination());
				ciudadorigensForeignKey=ciudadorigenLogic.getCiudads();
			}

			guiaremisionReturnGeneral.setciudadorigensForeignKey(ciudadorigensForeignKey);


			List<Ciudad> ciudaddestinosForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudaddestinoLogic=new CiudadLogic();
			ciudaddestinoLogic.setConnexion(this.connexion);
			ciudaddestinoLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudadDestino.equals("NONE")) {
				ciudaddestinoLogic.getTodosCiudads(finalQueryGlobalCiudadDestino,new Pagination());
				ciudaddestinosForeignKey=ciudaddestinoLogic.getCiudads();
			}

			guiaremisionReturnGeneral.setciudaddestinosForeignKey(ciudaddestinosForeignKey);


			List<TipoLlamada> tipollamadasForeignKey=new ArrayList<TipoLlamada>();
			TipoLlamadaLogic tipollamadaLogic=new TipoLlamadaLogic();
			tipollamadaLogic.setConnexion(this.connexion);
			tipollamadaLogic.getTipoLlamadaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoLlamada.equals("NONE")) {
				tipollamadaLogic.getTodosTipoLlamadas(finalQueryGlobalTipoLlamada,new Pagination());
				tipollamadasForeignKey=tipollamadaLogic.getTipoLlamadas();
			}

			guiaremisionReturnGeneral.settipollamadasForeignKey(tipollamadasForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			guiaremisionReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return guiaremisionReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyGuiaRemisionWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleGuiaRemisionLogic detalleguiaremisionLogic=new DetalleGuiaRemisionLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyGuiaRemisionWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleGuiaRemision.class));
											
			

			detalleguiaremisionLogic.setConnexion(this.getConnexion());
			detalleguiaremisionLogic.setDatosCliente(this.datosCliente);
			detalleguiaremisionLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(GuiaRemision guiaremision:this.guiaremisions) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleGuiaRemisionConstantesFunciones.getClassesForeignKeysOfDetalleGuiaRemision(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleguiaremisionLogic.setDetalleGuiaRemisions(guiaremision.detalleguiaremisions);
				detalleguiaremisionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(GuiaRemision guiaremision,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			GuiaRemisionLogicAdditional.updateGuiaRemisionToGet(guiaremision,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		guiaremision.setEmpresa(guiaremisionDataAccess.getEmpresa(connexion,guiaremision));
		guiaremision.setSucursal(guiaremisionDataAccess.getSucursal(connexion,guiaremision));
		guiaremision.setEjercicio(guiaremisionDataAccess.getEjercicio(connexion,guiaremision));
		guiaremision.setPeriodo(guiaremisionDataAccess.getPeriodo(connexion,guiaremision));
		guiaremision.setUsuario(guiaremisionDataAccess.getUsuario(connexion,guiaremision));
		guiaremision.setFormato(guiaremisionDataAccess.getFormato(connexion,guiaremision));
		guiaremision.setTipoPrecio(guiaremisionDataAccess.getTipoPrecio(connexion,guiaremision));
		guiaremision.setMoneda(guiaremisionDataAccess.getMoneda(connexion,guiaremision));
		guiaremision.setCliente(guiaremisionDataAccess.getCliente(connexion,guiaremision));
		guiaremision.setVendedor(guiaremisionDataAccess.getVendedor(connexion,guiaremision));
		guiaremision.setFactura(guiaremisionDataAccess.getFactura(connexion,guiaremision));
		guiaremision.setTransportista(guiaremisionDataAccess.getTransportista(connexion,guiaremision));
		guiaremision.setConsultor(guiaremisionDataAccess.getConsultor(connexion,guiaremision));
		guiaremision.setTransporte(guiaremisionDataAccess.getTransporte(connexion,guiaremision));
		guiaremision.setSubCliente(guiaremisionDataAccess.getSubCliente(connexion,guiaremision));
		guiaremision.setEmpleado(guiaremisionDataAccess.getEmpleado(connexion,guiaremision));
		guiaremision.setCiudadOrigen(guiaremisionDataAccess.getCiudadOrigen(connexion,guiaremision));
		guiaremision.setCiudadDestino(guiaremisionDataAccess.getCiudadDestino(connexion,guiaremision));
		guiaremision.setTipoLlamada(guiaremisionDataAccess.getTipoLlamada(connexion,guiaremision));
		guiaremision.setTipoCambio(guiaremisionDataAccess.getTipoCambio(connexion,guiaremision));
		guiaremision.setDetalleGuiaRemisions(guiaremisionDataAccess.getDetalleGuiaRemisions(connexion,guiaremision));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				guiaremision.setEmpresa(guiaremisionDataAccess.getEmpresa(connexion,guiaremision));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				guiaremision.setSucursal(guiaremisionDataAccess.getSucursal(connexion,guiaremision));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				guiaremision.setEjercicio(guiaremisionDataAccess.getEjercicio(connexion,guiaremision));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				guiaremision.setPeriodo(guiaremisionDataAccess.getPeriodo(connexion,guiaremision));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				guiaremision.setUsuario(guiaremisionDataAccess.getUsuario(connexion,guiaremision));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				guiaremision.setFormato(guiaremisionDataAccess.getFormato(connexion,guiaremision));
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				guiaremision.setTipoPrecio(guiaremisionDataAccess.getTipoPrecio(connexion,guiaremision));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				guiaremision.setMoneda(guiaremisionDataAccess.getMoneda(connexion,guiaremision));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				guiaremision.setCliente(guiaremisionDataAccess.getCliente(connexion,guiaremision));
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				guiaremision.setVendedor(guiaremisionDataAccess.getVendedor(connexion,guiaremision));
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				guiaremision.setFactura(guiaremisionDataAccess.getFactura(connexion,guiaremision));
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				guiaremision.setTransportista(guiaremisionDataAccess.getTransportista(connexion,guiaremision));
				continue;
			}

			if(clas.clas.equals(Consultor.class)) {
				guiaremision.setConsultor(guiaremisionDataAccess.getConsultor(connexion,guiaremision));
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				guiaremision.setTransporte(guiaremisionDataAccess.getTransporte(connexion,guiaremision));
				continue;
			}

			if(clas.clas.equals(SubCliente.class)) {
				guiaremision.setSubCliente(guiaremisionDataAccess.getSubCliente(connexion,guiaremision));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				guiaremision.setEmpleado(guiaremisionDataAccess.getEmpleado(connexion,guiaremision));
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				guiaremision.setCiudadOrigen(guiaremisionDataAccess.getCiudadOrigen(connexion,guiaremision));
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				guiaremision.setCiudadDestino(guiaremisionDataAccess.getCiudadDestino(connexion,guiaremision));
				continue;
			}

			if(clas.clas.equals(TipoLlamada.class)) {
				guiaremision.setTipoLlamada(guiaremisionDataAccess.getTipoLlamada(connexion,guiaremision));
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				guiaremision.setTipoCambio(guiaremisionDataAccess.getTipoCambio(connexion,guiaremision));
				continue;
			}

			if(clas.clas.equals(DetalleGuiaRemision.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				guiaremision.setDetalleGuiaRemisions(guiaremisionDataAccess.getDetalleGuiaRemisions(connexion,guiaremision));

				if(this.isConDeep) {
					DetalleGuiaRemisionLogic detalleguiaremisionLogic= new DetalleGuiaRemisionLogic(this.connexion);
					detalleguiaremisionLogic.setDetalleGuiaRemisions(guiaremision.getDetalleGuiaRemisions());
					ArrayList<Classe> classesLocal=DetalleGuiaRemisionConstantesFunciones.getClassesForeignKeysOfDetalleGuiaRemision(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleguiaremisionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleGuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleGuiaRemision(detalleguiaremisionLogic.getDetalleGuiaRemisions());
					guiaremision.setDetalleGuiaRemisions(detalleguiaremisionLogic.getDetalleGuiaRemisions());
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
			guiaremision.setEmpresa(guiaremisionDataAccess.getEmpresa(connexion,guiaremision));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setSucursal(guiaremisionDataAccess.getSucursal(connexion,guiaremision));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setEjercicio(guiaremisionDataAccess.getEjercicio(connexion,guiaremision));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setPeriodo(guiaremisionDataAccess.getPeriodo(connexion,guiaremision));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setUsuario(guiaremisionDataAccess.getUsuario(connexion,guiaremision));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setFormato(guiaremisionDataAccess.getFormato(connexion,guiaremision));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setTipoPrecio(guiaremisionDataAccess.getTipoPrecio(connexion,guiaremision));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setMoneda(guiaremisionDataAccess.getMoneda(connexion,guiaremision));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setCliente(guiaremisionDataAccess.getCliente(connexion,guiaremision));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setVendedor(guiaremisionDataAccess.getVendedor(connexion,guiaremision));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setFactura(guiaremisionDataAccess.getFactura(connexion,guiaremision));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transportista.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setTransportista(guiaremisionDataAccess.getTransportista(connexion,guiaremision));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Consultor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setConsultor(guiaremisionDataAccess.getConsultor(connexion,guiaremision));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setTransporte(guiaremisionDataAccess.getTransporte(connexion,guiaremision));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SubCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setSubCliente(guiaremisionDataAccess.getSubCliente(connexion,guiaremision));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setEmpleado(guiaremisionDataAccess.getEmpleado(connexion,guiaremision));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setCiudadOrigen(guiaremisionDataAccess.getCiudadOrigen(connexion,guiaremision));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setCiudadDestino(guiaremisionDataAccess.getCiudadDestino(connexion,guiaremision));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoLlamada.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setTipoLlamada(guiaremisionDataAccess.getTipoLlamada(connexion,guiaremision));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setTipoCambio(guiaremisionDataAccess.getTipoCambio(connexion,guiaremision));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleGuiaRemision.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleGuiaRemision.class));
			guiaremision.setDetalleGuiaRemisions(guiaremisionDataAccess.getDetalleGuiaRemisions(connexion,guiaremision));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		guiaremision.setEmpresa(guiaremisionDataAccess.getEmpresa(connexion,guiaremision));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(guiaremision.getEmpresa(),isDeep,deepLoadType,clases);
				
		guiaremision.setSucursal(guiaremisionDataAccess.getSucursal(connexion,guiaremision));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(guiaremision.getSucursal(),isDeep,deepLoadType,clases);
				
		guiaremision.setEjercicio(guiaremisionDataAccess.getEjercicio(connexion,guiaremision));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(guiaremision.getEjercicio(),isDeep,deepLoadType,clases);
				
		guiaremision.setPeriodo(guiaremisionDataAccess.getPeriodo(connexion,guiaremision));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(guiaremision.getPeriodo(),isDeep,deepLoadType,clases);
				
		guiaremision.setUsuario(guiaremisionDataAccess.getUsuario(connexion,guiaremision));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(guiaremision.getUsuario(),isDeep,deepLoadType,clases);
				
		guiaremision.setFormato(guiaremisionDataAccess.getFormato(connexion,guiaremision));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(guiaremision.getFormato(),isDeep,deepLoadType,clases);
				
		guiaremision.setTipoPrecio(guiaremisionDataAccess.getTipoPrecio(connexion,guiaremision));
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(guiaremision.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		guiaremision.setMoneda(guiaremisionDataAccess.getMoneda(connexion,guiaremision));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(guiaremision.getMoneda(),isDeep,deepLoadType,clases);
				
		guiaremision.setCliente(guiaremisionDataAccess.getCliente(connexion,guiaremision));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(guiaremision.getCliente(),isDeep,deepLoadType,clases);
				
		guiaremision.setVendedor(guiaremisionDataAccess.getVendedor(connexion,guiaremision));
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(guiaremision.getVendedor(),isDeep,deepLoadType,clases);
				
		guiaremision.setFactura(guiaremisionDataAccess.getFactura(connexion,guiaremision));
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(guiaremision.getFactura(),isDeep,deepLoadType,clases);
				
		guiaremision.setTransportista(guiaremisionDataAccess.getTransportista(connexion,guiaremision));
		TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
		transportistaLogic.deepLoad(guiaremision.getTransportista(),isDeep,deepLoadType,clases);
				
		guiaremision.setConsultor(guiaremisionDataAccess.getConsultor(connexion,guiaremision));
		ConsultorLogic consultorLogic= new ConsultorLogic(connexion);
		consultorLogic.deepLoad(guiaremision.getConsultor(),isDeep,deepLoadType,clases);
				
		guiaremision.setTransporte(guiaremisionDataAccess.getTransporte(connexion,guiaremision));
		TransporteLogic transporteLogic= new TransporteLogic(connexion);
		transporteLogic.deepLoad(guiaremision.getTransporte(),isDeep,deepLoadType,clases);
				
		guiaremision.setSubCliente(guiaremisionDataAccess.getSubCliente(connexion,guiaremision));
		SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
		subclienteLogic.deepLoad(guiaremision.getSubCliente(),isDeep,deepLoadType,clases);
				
		guiaremision.setEmpleado(guiaremisionDataAccess.getEmpleado(connexion,guiaremision));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(guiaremision.getEmpleado(),isDeep,deepLoadType,clases);
				
		guiaremision.setCiudadOrigen(guiaremisionDataAccess.getCiudadOrigen(connexion,guiaremision));
		CiudadLogic ciudadorigenLogic= new CiudadLogic(connexion);
		ciudadorigenLogic.deepLoad(guiaremision.getCiudadOrigen(),isDeep,deepLoadType,clases);
				
		guiaremision.setCiudadDestino(guiaremisionDataAccess.getCiudadDestino(connexion,guiaremision));
		CiudadLogic ciudaddestinoLogic= new CiudadLogic(connexion);
		ciudaddestinoLogic.deepLoad(guiaremision.getCiudadDestino(),isDeep,deepLoadType,clases);
				
		guiaremision.setTipoLlamada(guiaremisionDataAccess.getTipoLlamada(connexion,guiaremision));
		TipoLlamadaLogic tipollamadaLogic= new TipoLlamadaLogic(connexion);
		tipollamadaLogic.deepLoad(guiaremision.getTipoLlamada(),isDeep,deepLoadType,clases);
				
		guiaremision.setTipoCambio(guiaremisionDataAccess.getTipoCambio(connexion,guiaremision));
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(guiaremision.getTipoCambio(),isDeep,deepLoadType,clases);
				

		guiaremision.setDetalleGuiaRemisions(guiaremisionDataAccess.getDetalleGuiaRemisions(connexion,guiaremision));

		for(DetalleGuiaRemision detalleguiaremision:guiaremision.getDetalleGuiaRemisions()) {
			DetalleGuiaRemisionLogic detalleguiaremisionLogic= new DetalleGuiaRemisionLogic(connexion);
			detalleguiaremisionLogic.deepLoad(detalleguiaremision,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				guiaremision.setEmpresa(guiaremisionDataAccess.getEmpresa(connexion,guiaremision));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(guiaremision.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				guiaremision.setSucursal(guiaremisionDataAccess.getSucursal(connexion,guiaremision));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(guiaremision.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				guiaremision.setEjercicio(guiaremisionDataAccess.getEjercicio(connexion,guiaremision));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(guiaremision.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				guiaremision.setPeriodo(guiaremisionDataAccess.getPeriodo(connexion,guiaremision));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(guiaremision.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				guiaremision.setUsuario(guiaremisionDataAccess.getUsuario(connexion,guiaremision));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(guiaremision.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				guiaremision.setFormato(guiaremisionDataAccess.getFormato(connexion,guiaremision));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(guiaremision.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				guiaremision.setTipoPrecio(guiaremisionDataAccess.getTipoPrecio(connexion,guiaremision));
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepLoad(guiaremision.getTipoPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				guiaremision.setMoneda(guiaremisionDataAccess.getMoneda(connexion,guiaremision));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(guiaremision.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				guiaremision.setCliente(guiaremisionDataAccess.getCliente(connexion,guiaremision));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(guiaremision.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				guiaremision.setVendedor(guiaremisionDataAccess.getVendedor(connexion,guiaremision));
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepLoad(guiaremision.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				guiaremision.setFactura(guiaremisionDataAccess.getFactura(connexion,guiaremision));
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(guiaremision.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				guiaremision.setTransportista(guiaremisionDataAccess.getTransportista(connexion,guiaremision));
				TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
				transportistaLogic.deepLoad(guiaremision.getTransportista(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Consultor.class)) {
				guiaremision.setConsultor(guiaremisionDataAccess.getConsultor(connexion,guiaremision));
				ConsultorLogic consultorLogic= new ConsultorLogic(connexion);
				consultorLogic.deepLoad(guiaremision.getConsultor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				guiaremision.setTransporte(guiaremisionDataAccess.getTransporte(connexion,guiaremision));
				TransporteLogic transporteLogic= new TransporteLogic(connexion);
				transporteLogic.deepLoad(guiaremision.getTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(SubCliente.class)) {
				guiaremision.setSubCliente(guiaremisionDataAccess.getSubCliente(connexion,guiaremision));
				SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
				subclienteLogic.deepLoad(guiaremision.getSubCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				guiaremision.setEmpleado(guiaremisionDataAccess.getEmpleado(connexion,guiaremision));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(guiaremision.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				guiaremision.setCiudadOrigen(guiaremisionDataAccess.getCiudadOrigen(connexion,guiaremision));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(guiaremision.getCiudadOrigen(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				guiaremision.setCiudadDestino(guiaremisionDataAccess.getCiudadDestino(connexion,guiaremision));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(guiaremision.getCiudadDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoLlamada.class)) {
				guiaremision.setTipoLlamada(guiaremisionDataAccess.getTipoLlamada(connexion,guiaremision));
				TipoLlamadaLogic tipollamadaLogic= new TipoLlamadaLogic(connexion);
				tipollamadaLogic.deepLoad(guiaremision.getTipoLlamada(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				guiaremision.setTipoCambio(guiaremisionDataAccess.getTipoCambio(connexion,guiaremision));
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepLoad(guiaremision.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleGuiaRemision.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				guiaremision.setDetalleGuiaRemisions(guiaremisionDataAccess.getDetalleGuiaRemisions(connexion,guiaremision));

				for(DetalleGuiaRemision detalleguiaremision:guiaremision.getDetalleGuiaRemisions()) {
					DetalleGuiaRemisionLogic detalleguiaremisionLogic= new DetalleGuiaRemisionLogic(connexion);
					detalleguiaremisionLogic.deepLoad(detalleguiaremision,isDeep,deepLoadType,clases);
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
			guiaremision.setEmpresa(guiaremisionDataAccess.getEmpresa(connexion,guiaremision));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(guiaremision.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setSucursal(guiaremisionDataAccess.getSucursal(connexion,guiaremision));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(guiaremision.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setEjercicio(guiaremisionDataAccess.getEjercicio(connexion,guiaremision));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(guiaremision.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setPeriodo(guiaremisionDataAccess.getPeriodo(connexion,guiaremision));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(guiaremision.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setUsuario(guiaremisionDataAccess.getUsuario(connexion,guiaremision));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(guiaremision.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setFormato(guiaremisionDataAccess.getFormato(connexion,guiaremision));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(guiaremision.getFormato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setTipoPrecio(guiaremisionDataAccess.getTipoPrecio(connexion,guiaremision));
			TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
			tipoprecioLogic.deepLoad(guiaremision.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setMoneda(guiaremisionDataAccess.getMoneda(connexion,guiaremision));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(guiaremision.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setCliente(guiaremisionDataAccess.getCliente(connexion,guiaremision));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(guiaremision.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setVendedor(guiaremisionDataAccess.getVendedor(connexion,guiaremision));
			VendedorLogic vendedorLogic= new VendedorLogic(connexion);
			vendedorLogic.deepLoad(guiaremision.getVendedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setFactura(guiaremisionDataAccess.getFactura(connexion,guiaremision));
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(guiaremision.getFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transportista.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setTransportista(guiaremisionDataAccess.getTransportista(connexion,guiaremision));
			TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
			transportistaLogic.deepLoad(guiaremision.getTransportista(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Consultor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setConsultor(guiaremisionDataAccess.getConsultor(connexion,guiaremision));
			ConsultorLogic consultorLogic= new ConsultorLogic(connexion);
			consultorLogic.deepLoad(guiaremision.getConsultor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setTransporte(guiaremisionDataAccess.getTransporte(connexion,guiaremision));
			TransporteLogic transporteLogic= new TransporteLogic(connexion);
			transporteLogic.deepLoad(guiaremision.getTransporte(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(SubCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setSubCliente(guiaremisionDataAccess.getSubCliente(connexion,guiaremision));
			SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
			subclienteLogic.deepLoad(guiaremision.getSubCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setEmpleado(guiaremisionDataAccess.getEmpleado(connexion,guiaremision));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(guiaremision.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setCiudadOrigen(guiaremisionDataAccess.getCiudadOrigen(connexion,guiaremision));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(guiaremision.getCiudadOrigen(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setCiudadDestino(guiaremisionDataAccess.getCiudadDestino(connexion,guiaremision));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(guiaremision.getCiudadDestino(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoLlamada.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setTipoLlamada(guiaremisionDataAccess.getTipoLlamada(connexion,guiaremision));
			TipoLlamadaLogic tipollamadaLogic= new TipoLlamadaLogic(connexion);
			tipollamadaLogic.deepLoad(guiaremision.getTipoLlamada(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			guiaremision.setTipoCambio(guiaremisionDataAccess.getTipoCambio(connexion,guiaremision));
			TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
			tipocambioLogic.deepLoad(guiaremision.getTipoCambio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleGuiaRemision.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleGuiaRemision.class));
			guiaremision.setDetalleGuiaRemisions(guiaremisionDataAccess.getDetalleGuiaRemisions(connexion,guiaremision));

			for(DetalleGuiaRemision detalleguiaremision:guiaremision.getDetalleGuiaRemisions()) {
				DetalleGuiaRemisionLogic detalleguiaremisionLogic= new DetalleGuiaRemisionLogic(connexion);
				detalleguiaremisionLogic.deepLoad(detalleguiaremision,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(GuiaRemision guiaremision,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			GuiaRemisionLogicAdditional.updateGuiaRemisionToSave(guiaremision,this.arrDatoGeneral);
			
GuiaRemisionDataAccess.save(guiaremision, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(guiaremision.getEmpresa(),connexion);

		SucursalDataAccess.save(guiaremision.getSucursal(),connexion);

		EjercicioDataAccess.save(guiaremision.getEjercicio(),connexion);

		PeriodoDataAccess.save(guiaremision.getPeriodo(),connexion);

		UsuarioDataAccess.save(guiaremision.getUsuario(),connexion);

		FormatoDataAccess.save(guiaremision.getFormato(),connexion);

		TipoPrecioDataAccess.save(guiaremision.getTipoPrecio(),connexion);

		MonedaDataAccess.save(guiaremision.getMoneda(),connexion);

		ClienteDataAccess.save(guiaremision.getCliente(),connexion);

		VendedorDataAccess.save(guiaremision.getVendedor(),connexion);

		FacturaDataAccess.save(guiaremision.getFactura(),connexion);

		TransportistaDataAccess.save(guiaremision.getTransportista(),connexion);

		ConsultorDataAccess.save(guiaremision.getConsultor(),connexion);

		TransporteDataAccess.save(guiaremision.getTransporte(),connexion);

		SubClienteDataAccess.save(guiaremision.getSubCliente(),connexion);

		EmpleadoDataAccess.save(guiaremision.getEmpleado(),connexion);

		CiudadDataAccess.save(guiaremision.getCiudadOrigen(),connexion);

		CiudadDataAccess.save(guiaremision.getCiudadDestino(),connexion);

		TipoLlamadaDataAccess.save(guiaremision.getTipoLlamada(),connexion);

		TipoCambioDataAccess.save(guiaremision.getTipoCambio(),connexion);

		for(DetalleGuiaRemision detalleguiaremision:guiaremision.getDetalleGuiaRemisions()) {
			detalleguiaremision.setid_guia_remision(guiaremision.getId());
			DetalleGuiaRemisionDataAccess.save(detalleguiaremision,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(guiaremision.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(guiaremision.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(guiaremision.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(guiaremision.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(guiaremision.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(guiaremision.getFormato(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(guiaremision.getTipoPrecio(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(guiaremision.getMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(guiaremision.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(guiaremision.getVendedor(),connexion);
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(guiaremision.getFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				TransportistaDataAccess.save(guiaremision.getTransportista(),connexion);
				continue;
			}

			if(clas.clas.equals(Consultor.class)) {
				ConsultorDataAccess.save(guiaremision.getConsultor(),connexion);
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				TransporteDataAccess.save(guiaremision.getTransporte(),connexion);
				continue;
			}

			if(clas.clas.equals(SubCliente.class)) {
				SubClienteDataAccess.save(guiaremision.getSubCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(guiaremision.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(guiaremision.getCiudadOrigen(),connexion);
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(guiaremision.getCiudadDestino(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoLlamada.class)) {
				TipoLlamadaDataAccess.save(guiaremision.getTipoLlamada(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(guiaremision.getTipoCambio(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleGuiaRemision.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleGuiaRemision detalleguiaremision:guiaremision.getDetalleGuiaRemisions()) {
					detalleguiaremision.setid_guia_remision(guiaremision.getId());
					DetalleGuiaRemisionDataAccess.save(detalleguiaremision,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(guiaremision.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(guiaremision.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(guiaremision.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(guiaremision.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(guiaremision.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(guiaremision.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(guiaremision.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(guiaremision.getPeriodo(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(guiaremision.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(guiaremision.getUsuario(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(guiaremision.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(guiaremision.getFormato(),isDeep,deepLoadType,clases);
				

		TipoPrecioDataAccess.save(guiaremision.getTipoPrecio(),connexion);
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(guiaremision.getTipoPrecio(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(guiaremision.getMoneda(),connexion);
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(guiaremision.getMoneda(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(guiaremision.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(guiaremision.getCliente(),isDeep,deepLoadType,clases);
				

		VendedorDataAccess.save(guiaremision.getVendedor(),connexion);
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(guiaremision.getVendedor(),isDeep,deepLoadType,clases);
				

		FacturaDataAccess.save(guiaremision.getFactura(),connexion);
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(guiaremision.getFactura(),isDeep,deepLoadType,clases);
				

		TransportistaDataAccess.save(guiaremision.getTransportista(),connexion);
		TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
		transportistaLogic.deepLoad(guiaremision.getTransportista(),isDeep,deepLoadType,clases);
				

		ConsultorDataAccess.save(guiaremision.getConsultor(),connexion);
		ConsultorLogic consultorLogic= new ConsultorLogic(connexion);
		consultorLogic.deepLoad(guiaremision.getConsultor(),isDeep,deepLoadType,clases);
				

		TransporteDataAccess.save(guiaremision.getTransporte(),connexion);
		TransporteLogic transporteLogic= new TransporteLogic(connexion);
		transporteLogic.deepLoad(guiaremision.getTransporte(),isDeep,deepLoadType,clases);
				

		SubClienteDataAccess.save(guiaremision.getSubCliente(),connexion);
		SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
		subclienteLogic.deepLoad(guiaremision.getSubCliente(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(guiaremision.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(guiaremision.getEmpleado(),isDeep,deepLoadType,clases);
				

		CiudadDataAccess.save(guiaremision.getCiudadOrigen(),connexion);
		CiudadLogic ciudadorigenLogic= new CiudadLogic(connexion);
		ciudadorigenLogic.deepLoad(guiaremision.getCiudadOrigen(),isDeep,deepLoadType,clases);
				

		CiudadDataAccess.save(guiaremision.getCiudadDestino(),connexion);
		CiudadLogic ciudaddestinoLogic= new CiudadLogic(connexion);
		ciudaddestinoLogic.deepLoad(guiaremision.getCiudadDestino(),isDeep,deepLoadType,clases);
				

		TipoLlamadaDataAccess.save(guiaremision.getTipoLlamada(),connexion);
		TipoLlamadaLogic tipollamadaLogic= new TipoLlamadaLogic(connexion);
		tipollamadaLogic.deepLoad(guiaremision.getTipoLlamada(),isDeep,deepLoadType,clases);
				

		TipoCambioDataAccess.save(guiaremision.getTipoCambio(),connexion);
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(guiaremision.getTipoCambio(),isDeep,deepLoadType,clases);
				

		for(DetalleGuiaRemision detalleguiaremision:guiaremision.getDetalleGuiaRemisions()) {
			DetalleGuiaRemisionLogic detalleguiaremisionLogic= new DetalleGuiaRemisionLogic(connexion);
			detalleguiaremision.setid_guia_remision(guiaremision.getId());
			DetalleGuiaRemisionDataAccess.save(detalleguiaremision,connexion);
			detalleguiaremisionLogic.deepSave(detalleguiaremision,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(guiaremision.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(guiaremision.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(guiaremision.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(guiaremision.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(guiaremision.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(guiaremision.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(guiaremision.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(guiaremision.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(guiaremision.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(guiaremision.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(guiaremision.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(guiaremision.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(guiaremision.getTipoPrecio(),connexion);
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepSave(guiaremision.getTipoPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(guiaremision.getMoneda(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(guiaremision.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(guiaremision.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(guiaremision.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(guiaremision.getVendedor(),connexion);
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepSave(guiaremision.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(guiaremision.getFactura(),connexion);
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepSave(guiaremision.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				TransportistaDataAccess.save(guiaremision.getTransportista(),connexion);
				TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
				transportistaLogic.deepSave(guiaremision.getTransportista(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Consultor.class)) {
				ConsultorDataAccess.save(guiaremision.getConsultor(),connexion);
				ConsultorLogic consultorLogic= new ConsultorLogic(connexion);
				consultorLogic.deepSave(guiaremision.getConsultor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				TransporteDataAccess.save(guiaremision.getTransporte(),connexion);
				TransporteLogic transporteLogic= new TransporteLogic(connexion);
				transporteLogic.deepSave(guiaremision.getTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(SubCliente.class)) {
				SubClienteDataAccess.save(guiaremision.getSubCliente(),connexion);
				SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
				subclienteLogic.deepSave(guiaremision.getSubCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(guiaremision.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(guiaremision.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(guiaremision.getCiudadOrigen(),connexion);
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepSave(guiaremision.getCiudadOrigen(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(guiaremision.getCiudadDestino(),connexion);
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepSave(guiaremision.getCiudadDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoLlamada.class)) {
				TipoLlamadaDataAccess.save(guiaremision.getTipoLlamada(),connexion);
				TipoLlamadaLogic tipollamadaLogic= new TipoLlamadaLogic(connexion);
				tipollamadaLogic.deepSave(guiaremision.getTipoLlamada(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(guiaremision.getTipoCambio(),connexion);
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepSave(guiaremision.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleGuiaRemision.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleGuiaRemision detalleguiaremision:guiaremision.getDetalleGuiaRemisions()) {
					DetalleGuiaRemisionLogic detalleguiaremisionLogic= new DetalleGuiaRemisionLogic(connexion);
					detalleguiaremision.setid_guia_remision(guiaremision.getId());
					DetalleGuiaRemisionDataAccess.save(detalleguiaremision,connexion);
					detalleguiaremisionLogic.deepSave(detalleguiaremision,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(GuiaRemision.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(guiaremision,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(guiaremision);
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
			this.deepLoad(this.guiaremision,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremision);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(GuiaRemision.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(guiaremisions!=null) {
				for(GuiaRemision guiaremision:guiaremisions) {
					this.deepLoad(guiaremision,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(guiaremisions);
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
			if(guiaremisions!=null) {
				for(GuiaRemision guiaremision:guiaremisions) {
					this.deepLoad(guiaremision,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(guiaremisions);
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
			this.getNewConnexionToDeep(GuiaRemision.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(guiaremision,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(GuiaRemision.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(guiaremisions!=null) {
				for(GuiaRemision guiaremision:guiaremisions) {
					this.deepSave(guiaremision,isDeep,deepLoadType,clases);
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
			if(guiaremisions!=null) {
				for(GuiaRemision guiaremision:guiaremisions) {
					this.deepSave(guiaremision,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getGuiaRemisionsFK_IdCiudadDestinoWithConnection(String sFinalQuery,Pagination pagination,Long id_ciudad_destino)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudadDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudadDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad_destino,GuiaRemisionConstantesFunciones.IDCIUDADDESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudadDestino);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudadDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGuiaRemisionsFK_IdCiudadDestino(String sFinalQuery,Pagination pagination,Long id_ciudad_destino)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudadDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudadDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad_destino,GuiaRemisionConstantesFunciones.IDCIUDADDESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudadDestino);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudadDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGuiaRemisionsFK_IdCiudadOrigenWithConnection(String sFinalQuery,Pagination pagination,Long id_ciudad_origen)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudadOrigen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudadOrigen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad_origen,GuiaRemisionConstantesFunciones.IDCIUDADORIGEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudadOrigen);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudadOrigen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGuiaRemisionsFK_IdCiudadOrigen(String sFinalQuery,Pagination pagination,Long id_ciudad_origen)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudadOrigen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudadOrigen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad_origen,GuiaRemisionConstantesFunciones.IDCIUDADORIGEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudadOrigen);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudadOrigen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGuiaRemisionsFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,GuiaRemisionConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGuiaRemisionsFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,GuiaRemisionConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGuiaRemisionsFK_IdConsultorWithConnection(String sFinalQuery,Pagination pagination,Long id_consultor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidConsultor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidConsultor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_consultor,GuiaRemisionConstantesFunciones.IDCONSULTOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidConsultor);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdConsultor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGuiaRemisionsFK_IdConsultor(String sFinalQuery,Pagination pagination,Long id_consultor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidConsultor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidConsultor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_consultor,GuiaRemisionConstantesFunciones.IDCONSULTOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidConsultor);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdConsultor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGuiaRemisionsFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,GuiaRemisionConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGuiaRemisionsFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,GuiaRemisionConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGuiaRemisionsFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,GuiaRemisionConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGuiaRemisionsFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,GuiaRemisionConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGuiaRemisionsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,GuiaRemisionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGuiaRemisionsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,GuiaRemisionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGuiaRemisionsFK_IdFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,GuiaRemisionConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGuiaRemisionsFK_IdFactura(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,GuiaRemisionConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGuiaRemisionsFK_IdFormatoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,GuiaRemisionConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGuiaRemisionsFK_IdFormato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,GuiaRemisionConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGuiaRemisionsFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,GuiaRemisionConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGuiaRemisionsFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,GuiaRemisionConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGuiaRemisionsFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,GuiaRemisionConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGuiaRemisionsFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,GuiaRemisionConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGuiaRemisionsFK_IdSubClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_sub_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSubCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSubCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sub_cliente,GuiaRemisionConstantesFunciones.IDSUBCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSubCliente);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSubCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGuiaRemisionsFK_IdSubCliente(String sFinalQuery,Pagination pagination,Long id_sub_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSubCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSubCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sub_cliente,GuiaRemisionConstantesFunciones.IDSUBCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSubCliente);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSubCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGuiaRemisionsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,GuiaRemisionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGuiaRemisionsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,GuiaRemisionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGuiaRemisionsFK_IdTipoCambioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,GuiaRemisionConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGuiaRemisionsFK_IdTipoCambio(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,GuiaRemisionConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGuiaRemisionsFK_IdTipoLlamadaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_llamada)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoLlamada= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoLlamada.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_llamada,GuiaRemisionConstantesFunciones.IDTIPOLLAMADA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoLlamada);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoLlamada","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGuiaRemisionsFK_IdTipoLlamada(String sFinalQuery,Pagination pagination,Long id_tipo_llamada)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoLlamada= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoLlamada.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_llamada,GuiaRemisionConstantesFunciones.IDTIPOLLAMADA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoLlamada);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoLlamada","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGuiaRemisionsFK_IdTipoPrecioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,GuiaRemisionConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGuiaRemisionsFK_IdTipoPrecio(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,GuiaRemisionConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGuiaRemisionsFK_IdTransporteWithConnection(String sFinalQuery,Pagination pagination,Long id_transporte)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transporte,GuiaRemisionConstantesFunciones.IDTRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransporte);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGuiaRemisionsFK_IdTransporte(String sFinalQuery,Pagination pagination,Long id_transporte)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transporte,GuiaRemisionConstantesFunciones.IDTRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransporte);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGuiaRemisionsFK_IdTransportistaWithConnection(String sFinalQuery,Pagination pagination,Long id_transportista)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransportista= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransportista.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transportista,GuiaRemisionConstantesFunciones.IDTRANSPORTISTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransportista);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransportista","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGuiaRemisionsFK_IdTransportista(String sFinalQuery,Pagination pagination,Long id_transportista)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransportista= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransportista.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transportista,GuiaRemisionConstantesFunciones.IDTRANSPORTISTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransportista);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransportista","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGuiaRemisionsFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,GuiaRemisionConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGuiaRemisionsFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,GuiaRemisionConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGuiaRemisionsFK_IdVendedorWithConnection(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GuiaRemision.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,GuiaRemisionConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGuiaRemisionsFK_IdVendedor(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,GuiaRemisionConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			GuiaRemisionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(this.guiaremisions);
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
			if(GuiaRemisionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,GuiaRemisionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,GuiaRemision guiaremision,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(GuiaRemisionConstantesFunciones.ISCONAUDITORIA) {
				if(guiaremision.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GuiaRemisionDataAccess.TABLENAME, guiaremision.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(GuiaRemisionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////GuiaRemisionLogic.registrarAuditoriaDetallesGuiaRemision(connexion,guiaremision,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(guiaremision.getIsDeleted()) {
					/*if(!guiaremision.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,GuiaRemisionDataAccess.TABLENAME, guiaremision.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////GuiaRemisionLogic.registrarAuditoriaDetallesGuiaRemision(connexion,guiaremision,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GuiaRemisionDataAccess.TABLENAME, guiaremision.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(guiaremision.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GuiaRemisionDataAccess.TABLENAME, guiaremision.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(GuiaRemisionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////GuiaRemisionLogic.registrarAuditoriaDetallesGuiaRemision(connexion,guiaremision,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesGuiaRemision(Connexion connexion,GuiaRemision guiaremision)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(guiaremision.getIsNew()||!guiaremision.getid_empresa().equals(guiaremision.getGuiaRemisionOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getid_empresa()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getid_empresa().toString();
				}
				if(guiaremision.getid_empresa()!=null)
				{
					strValorNuevo=guiaremision.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getid_sucursal().equals(guiaremision.getGuiaRemisionOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getid_sucursal()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getid_sucursal().toString();
				}
				if(guiaremision.getid_sucursal()!=null)
				{
					strValorNuevo=guiaremision.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getid_ejercicio().equals(guiaremision.getGuiaRemisionOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getid_ejercicio()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getid_ejercicio().toString();
				}
				if(guiaremision.getid_ejercicio()!=null)
				{
					strValorNuevo=guiaremision.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getid_periodo().equals(guiaremision.getGuiaRemisionOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getid_periodo()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getid_periodo().toString();
				}
				if(guiaremision.getid_periodo()!=null)
				{
					strValorNuevo=guiaremision.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getid_usuario().equals(guiaremision.getGuiaRemisionOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getid_usuario()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getid_usuario().toString();
				}
				if(guiaremision.getid_usuario()!=null)
				{
					strValorNuevo=guiaremision.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getsecuencial().equals(guiaremision.getGuiaRemisionOriginal().getsecuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getsecuencial()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getsecuencial();
				}
				if(guiaremision.getsecuencial()!=null)
				{
					strValorNuevo=guiaremision.getsecuencial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.SECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getfecha_emision().equals(guiaremision.getGuiaRemisionOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getfecha_emision()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getfecha_emision().toString();
				}
				if(guiaremision.getfecha_emision()!=null)
				{
					strValorNuevo=guiaremision.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getid_formato().equals(guiaremision.getGuiaRemisionOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getid_formato()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getid_formato().toString();
				}
				if(guiaremision.getid_formato()!=null)
				{
					strValorNuevo=guiaremision.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getid_tipo_precio().equals(guiaremision.getGuiaRemisionOriginal().getid_tipo_precio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getid_tipo_precio()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getid_tipo_precio().toString();
				}
				if(guiaremision.getid_tipo_precio()!=null)
				{
					strValorNuevo=guiaremision.getid_tipo_precio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.IDTIPOPRECIO,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getid_moneda().equals(guiaremision.getGuiaRemisionOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getid_moneda()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getid_moneda().toString();
				}
				if(guiaremision.getid_moneda()!=null)
				{
					strValorNuevo=guiaremision.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getnumero_camion().equals(guiaremision.getGuiaRemisionOriginal().getnumero_camion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getnumero_camion()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getnumero_camion();
				}
				if(guiaremision.getnumero_camion()!=null)
				{
					strValorNuevo=guiaremision.getnumero_camion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.NUMEROCAMION,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getid_cliente().equals(guiaremision.getGuiaRemisionOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getid_cliente()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getid_cliente().toString();
				}
				if(guiaremision.getid_cliente()!=null)
				{
					strValorNuevo=guiaremision.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getid_vendedor().equals(guiaremision.getGuiaRemisionOriginal().getid_vendedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getid_vendedor()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getid_vendedor().toString();
				}
				if(guiaremision.getid_vendedor()!=null)
				{
					strValorNuevo=guiaremision.getid_vendedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.IDVENDEDOR,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getid_factura().equals(guiaremision.getGuiaRemisionOriginal().getid_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getid_factura()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getid_factura().toString();
				}
				if(guiaremision.getid_factura()!=null)
				{
					strValorNuevo=guiaremision.getid_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.IDFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getid_transportista().equals(guiaremision.getGuiaRemisionOriginal().getid_transportista()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getid_transportista()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getid_transportista().toString();
				}
				if(guiaremision.getid_transportista()!=null)
				{
					strValorNuevo=guiaremision.getid_transportista().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.IDTRANSPORTISTA,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getidentificacion().equals(guiaremision.getGuiaRemisionOriginal().getidentificacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getidentificacion()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getidentificacion();
				}
				if(guiaremision.getidentificacion()!=null)
				{
					strValorNuevo=guiaremision.getidentificacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.IDENTIFICACION,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getfecha_origen().equals(guiaremision.getGuiaRemisionOriginal().getfecha_origen()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getfecha_origen()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getfecha_origen().toString();
				}
				if(guiaremision.getfecha_origen()!=null)
				{
					strValorNuevo=guiaremision.getfecha_origen().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.FECHAORIGEN,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getfecha_destino().equals(guiaremision.getGuiaRemisionOriginal().getfecha_destino()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getfecha_destino()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getfecha_destino().toString();
				}
				if(guiaremision.getfecha_destino()!=null)
				{
					strValorNuevo=guiaremision.getfecha_destino().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.FECHADESTINO,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.gettransporte_codigo().equals(guiaremision.getGuiaRemisionOriginal().gettransporte_codigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().gettransporte_codigo()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().gettransporte_codigo();
				}
				if(guiaremision.gettransporte_codigo()!=null)
				{
					strValorNuevo=guiaremision.gettransporte_codigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.TRANSPORTECODIGO,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getcantidad_bultos().equals(guiaremision.getGuiaRemisionOriginal().getcantidad_bultos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getcantidad_bultos()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getcantidad_bultos().toString();
				}
				if(guiaremision.getcantidad_bultos()!=null)
				{
					strValorNuevo=guiaremision.getcantidad_bultos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.CANTIDADBULTOS,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getid_consultor().equals(guiaremision.getGuiaRemisionOriginal().getid_consultor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getid_consultor()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getid_consultor().toString();
				}
				if(guiaremision.getid_consultor()!=null)
				{
					strValorNuevo=guiaremision.getid_consultor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.IDCONSULTOR,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getid_transporte().equals(guiaremision.getGuiaRemisionOriginal().getid_transporte()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getid_transporte()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getid_transporte().toString();
				}
				if(guiaremision.getid_transporte()!=null)
				{
					strValorNuevo=guiaremision.getid_transporte().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.IDTRANSPORTE,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getid_sub_cliente().equals(guiaremision.getGuiaRemisionOriginal().getid_sub_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getid_sub_cliente()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getid_sub_cliente().toString();
				}
				if(guiaremision.getid_sub_cliente()!=null)
				{
					strValorNuevo=guiaremision.getid_sub_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.IDSUBCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getid_empleado().equals(guiaremision.getGuiaRemisionOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getid_empleado()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getid_empleado().toString();
				}
				if(guiaremision.getid_empleado()!=null)
				{
					strValorNuevo=guiaremision.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getid_ciudad_origen().equals(guiaremision.getGuiaRemisionOriginal().getid_ciudad_origen()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getid_ciudad_origen()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getid_ciudad_origen().toString();
				}
				if(guiaremision.getid_ciudad_origen()!=null)
				{
					strValorNuevo=guiaremision.getid_ciudad_origen().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.IDCIUDADORIGEN,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getid_ciudad_destino().equals(guiaremision.getGuiaRemisionOriginal().getid_ciudad_destino()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getid_ciudad_destino()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getid_ciudad_destino().toString();
				}
				if(guiaremision.getid_ciudad_destino()!=null)
				{
					strValorNuevo=guiaremision.getid_ciudad_destino().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.IDCIUDADDESTINO,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getid_tipo_llamada().equals(guiaremision.getGuiaRemisionOriginal().getid_tipo_llamada()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getid_tipo_llamada()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getid_tipo_llamada().toString();
				}
				if(guiaremision.getid_tipo_llamada()!=null)
				{
					strValorNuevo=guiaremision.getid_tipo_llamada().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.IDTIPOLLAMADA,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.gethora_inicio().equals(guiaremision.getGuiaRemisionOriginal().gethora_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().gethora_inicio()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().gethora_inicio().toString();
				}
				if(guiaremision.gethora_inicio()!=null)
				{
					strValorNuevo=guiaremision.gethora_inicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.HORAINICIO,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.gethora_fin().equals(guiaremision.getGuiaRemisionOriginal().gethora_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().gethora_fin()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().gethora_fin().toString();
				}
				if(guiaremision.gethora_fin()!=null)
				{
					strValorNuevo=guiaremision.gethora_fin().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.HORAFIN,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getcupo().equals(guiaremision.getGuiaRemisionOriginal().getcupo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getcupo()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getcupo().toString();
				}
				if(guiaremision.getcupo()!=null)
				{
					strValorNuevo=guiaremision.getcupo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.CUPO,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getsaldo().equals(guiaremision.getGuiaRemisionOriginal().getsaldo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getsaldo()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getsaldo().toString();
				}
				if(guiaremision.getsaldo()!=null)
				{
					strValorNuevo=guiaremision.getsaldo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.SALDO,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getdocumento().equals(guiaremision.getGuiaRemisionOriginal().getdocumento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getdocumento()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getdocumento().toString();
				}
				if(guiaremision.getdocumento()!=null)
				{
					strValorNuevo=guiaremision.getdocumento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.DOCUMENTO,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getdisponible().equals(guiaremision.getGuiaRemisionOriginal().getdisponible()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getdisponible()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getdisponible().toString();
				}
				if(guiaremision.getdisponible()!=null)
				{
					strValorNuevo=guiaremision.getdisponible().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.DISPONIBLE,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getdescripcion().equals(guiaremision.getGuiaRemisionOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getdescripcion()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getdescripcion();
				}
				if(guiaremision.getdescripcion()!=null)
				{
					strValorNuevo=guiaremision.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.gettotal_iva().equals(guiaremision.getGuiaRemisionOriginal().gettotal_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().gettotal_iva()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().gettotal_iva().toString();
				}
				if(guiaremision.gettotal_iva()!=null)
				{
					strValorNuevo=guiaremision.gettotal_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.TOTALIVA,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.gettotal_sin_iva().equals(guiaremision.getGuiaRemisionOriginal().gettotal_sin_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().gettotal_sin_iva()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().gettotal_sin_iva().toString();
				}
				if(guiaremision.gettotal_sin_iva()!=null)
				{
					strValorNuevo=guiaremision.gettotal_sin_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.TOTALSINIVA,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getdescuento().equals(guiaremision.getGuiaRemisionOriginal().getdescuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getdescuento()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getdescuento().toString();
				}
				if(guiaremision.getdescuento()!=null)
				{
					strValorNuevo=guiaremision.getdescuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.DESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getflete().equals(guiaremision.getGuiaRemisionOriginal().getflete()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getflete()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getflete().toString();
				}
				if(guiaremision.getflete()!=null)
				{
					strValorNuevo=guiaremision.getflete().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.FLETE,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getotro().equals(guiaremision.getGuiaRemisionOriginal().getotro()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getotro()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getotro().toString();
				}
				if(guiaremision.getotro()!=null)
				{
					strValorNuevo=guiaremision.getotro().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.OTRO,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getfinanciamiento().equals(guiaremision.getGuiaRemisionOriginal().getfinanciamiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getfinanciamiento()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getfinanciamiento().toString();
				}
				if(guiaremision.getfinanciamiento()!=null)
				{
					strValorNuevo=guiaremision.getfinanciamiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.FINANCIAMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getiva().equals(guiaremision.getGuiaRemisionOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getiva()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getiva().toString();
				}
				if(guiaremision.getiva()!=null)
				{
					strValorNuevo=guiaremision.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.gettotal().equals(guiaremision.getGuiaRemisionOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().gettotal()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().gettotal().toString();
				}
				if(guiaremision.gettotal()!=null)
				{
					strValorNuevo=guiaremision.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getmonto_retencion().equals(guiaremision.getGuiaRemisionOriginal().getmonto_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getmonto_retencion()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getmonto_retencion().toString();
				}
				if(guiaremision.getmonto_retencion()!=null)
				{
					strValorNuevo=guiaremision.getmonto_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.MONTORETENCION,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getid_tipo_cambio().equals(guiaremision.getGuiaRemisionOriginal().getid_tipo_cambio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getid_tipo_cambio()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getid_tipo_cambio().toString();
				}
				if(guiaremision.getid_tipo_cambio()!=null)
				{
					strValorNuevo=guiaremision.getid_tipo_cambio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.IDTIPOCAMBIO,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getfecha().equals(guiaremision.getGuiaRemisionOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getfecha()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getfecha().toString();
				}
				if(guiaremision.getfecha()!=null)
				{
					strValorNuevo=guiaremision.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getruc_cliente().equals(guiaremision.getGuiaRemisionOriginal().getruc_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getruc_cliente()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getruc_cliente();
				}
				if(guiaremision.getruc_cliente()!=null)
				{
					strValorNuevo=guiaremision.getruc_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.RUCCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getnombre_cliente().equals(guiaremision.getGuiaRemisionOriginal().getnombre_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getnombre_cliente()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getnombre_cliente();
				}
				if(guiaremision.getnombre_cliente()!=null)
				{
					strValorNuevo=guiaremision.getnombre_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.NOMBRECLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.gettelefono_cliente().equals(guiaremision.getGuiaRemisionOriginal().gettelefono_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().gettelefono_cliente()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().gettelefono_cliente();
				}
				if(guiaremision.gettelefono_cliente()!=null)
				{
					strValorNuevo=guiaremision.gettelefono_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.TELEFONOCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getdireccion_cliente().equals(guiaremision.getGuiaRemisionOriginal().getdireccion_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getdireccion_cliente()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getdireccion_cliente();
				}
				if(guiaremision.getdireccion_cliente()!=null)
				{
					strValorNuevo=guiaremision.getdireccion_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.DIRECCIONCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getnumero_pre_impreso().equals(guiaremision.getGuiaRemisionOriginal().getnumero_pre_impreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getnumero_pre_impreso()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getnumero_pre_impreso();
				}
				if(guiaremision.getnumero_pre_impreso()!=null)
				{
					strValorNuevo=guiaremision.getnumero_pre_impreso() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.NUMEROPREIMPRESO,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getpeso_bruto().equals(guiaremision.getGuiaRemisionOriginal().getpeso_bruto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getpeso_bruto()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getpeso_bruto().toString();
				}
				if(guiaremision.getpeso_bruto()!=null)
				{
					strValorNuevo=guiaremision.getpeso_bruto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.PESOBRUTO,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getfecha_autorizacion().equals(guiaremision.getGuiaRemisionOriginal().getfecha_autorizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getfecha_autorizacion()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getfecha_autorizacion().toString();
				}
				if(guiaremision.getfecha_autorizacion()!=null)
				{
					strValorNuevo=guiaremision.getfecha_autorizacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.FECHAAUTORIZACION,strValorActual,strValorNuevo);
			}	
			
			if(guiaremision.getIsNew()||!guiaremision.getfecha_vencimiento().equals(guiaremision.getGuiaRemisionOriginal().getfecha_vencimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(guiaremision.getGuiaRemisionOriginal().getfecha_vencimiento()!=null)
				{
					strValorActual=guiaremision.getGuiaRemisionOriginal().getfecha_vencimiento().toString();
				}
				if(guiaremision.getfecha_vencimiento()!=null)
				{
					strValorNuevo=guiaremision.getfecha_vencimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GuiaRemisionConstantesFunciones.FECHAVENCIMIENTO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveGuiaRemisionRelacionesWithConnection(GuiaRemision guiaremision,List<DetalleGuiaRemision> detalleguiaremisions) throws Exception {

		if(!guiaremision.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveGuiaRemisionRelacionesBase(guiaremision,detalleguiaremisions,true);
		}
	}

	public void saveGuiaRemisionRelaciones(GuiaRemision guiaremision,List<DetalleGuiaRemision> detalleguiaremisions)throws Exception {

		if(!guiaremision.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveGuiaRemisionRelacionesBase(guiaremision,detalleguiaremisions,false);
		}
	}

	public void saveGuiaRemisionRelacionesBase(GuiaRemision guiaremision,List<DetalleGuiaRemision> detalleguiaremisions,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("GuiaRemision-saveRelacionesWithConnection");}
	
			guiaremision.setDetalleGuiaRemisions(detalleguiaremisions);

			this.setGuiaRemision(guiaremision);

			if(GuiaRemisionLogicAdditional.validarSaveRelaciones(guiaremision,this)) {

				GuiaRemisionLogicAdditional.updateRelacionesToSave(guiaremision,this);

				if((guiaremision.getIsNew()||guiaremision.getIsChanged())&&!guiaremision.getIsDeleted()) {
					this.saveGuiaRemision();
					this.saveGuiaRemisionRelacionesDetalles(detalleguiaremisions);

				} else if(guiaremision.getIsDeleted()) {
					this.saveGuiaRemisionRelacionesDetalles(detalleguiaremisions);
					this.saveGuiaRemision();
				}

				GuiaRemisionLogicAdditional.updateRelacionesToSaveAfter(guiaremision,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleGuiaRemisionConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleGuiaRemisions(detalleguiaremisions,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveGuiaRemisionRelacionesDetalles(List<DetalleGuiaRemision> detalleguiaremisions)throws Exception {
		try {
	

			Long idGuiaRemisionActual=this.getGuiaRemision().getId();

			DetalleGuiaRemisionLogic detalleguiaremisionLogic_Desde_GuiaRemision=new DetalleGuiaRemisionLogic();
			detalleguiaremisionLogic_Desde_GuiaRemision.setDetalleGuiaRemisions(detalleguiaremisions);

			detalleguiaremisionLogic_Desde_GuiaRemision.setConnexion(this.getConnexion());
			detalleguiaremisionLogic_Desde_GuiaRemision.setDatosCliente(this.datosCliente);

			for(DetalleGuiaRemision detalleguiaremision_Desde_GuiaRemision:detalleguiaremisionLogic_Desde_GuiaRemision.getDetalleGuiaRemisions()) {
				detalleguiaremision_Desde_GuiaRemision.setid_guia_remision(idGuiaRemisionActual);
			}

			detalleguiaremisionLogic_Desde_GuiaRemision.saveDetalleGuiaRemisions();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfGuiaRemision(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=GuiaRemisionConstantesFunciones.getClassesForeignKeysOfGuiaRemision(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfGuiaRemision(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=GuiaRemisionConstantesFunciones.getClassesRelationshipsOfGuiaRemision(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
