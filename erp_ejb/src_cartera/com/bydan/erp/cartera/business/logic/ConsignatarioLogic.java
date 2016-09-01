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
import com.bydan.erp.cartera.util.ConsignatarioConstantesFunciones;
import com.bydan.erp.cartera.util.ConsignatarioParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ConsignatarioParameterGeneral;
import com.bydan.erp.cartera.business.entity.Consignatario;
import com.bydan.erp.cartera.business.logic.ConsignatarioLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;








@SuppressWarnings("unused")
public class ConsignatarioLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ConsignatarioLogic.class);
	
	protected ConsignatarioDataAccess consignatarioDataAccess; 	
	protected Consignatario consignatario;
	protected List<Consignatario> consignatarios;
	protected Object consignatarioObject;	
	protected List<Object> consignatariosObject;
	
	public static ClassValidator<Consignatario> consignatarioValidator = new ClassValidator<Consignatario>(Consignatario.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ConsignatarioLogicAdditional consignatarioLogicAdditional=null;
	
	public ConsignatarioLogicAdditional getConsignatarioLogicAdditional() {
		return this.consignatarioLogicAdditional;
	}
	
	public void setConsignatarioLogicAdditional(ConsignatarioLogicAdditional consignatarioLogicAdditional) {
		try {
			this.consignatarioLogicAdditional=consignatarioLogicAdditional;
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
	
	
	
	
	public  ConsignatarioLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.consignatarioDataAccess = new ConsignatarioDataAccess();
			
			this.consignatarios= new ArrayList<Consignatario>();
			this.consignatario= new Consignatario();
			
			this.consignatarioObject=new Object();
			this.consignatariosObject=new ArrayList<Object>();
				
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
			
			this.consignatarioDataAccess.setConnexionType(this.connexionType);
			this.consignatarioDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ConsignatarioLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.consignatarioDataAccess = new ConsignatarioDataAccess();
			this.consignatarios= new ArrayList<Consignatario>();
			this.consignatario= new Consignatario();
			this.consignatarioObject=new Object();
			this.consignatariosObject=new ArrayList<Object>();
			
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
			
			this.consignatarioDataAccess.setConnexionType(this.connexionType);
			this.consignatarioDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Consignatario getConsignatario() throws Exception {	
		ConsignatarioLogicAdditional.checkConsignatarioToGet(consignatario,this.datosCliente,this.arrDatoGeneral);
		ConsignatarioLogicAdditional.updateConsignatarioToGet(consignatario,this.arrDatoGeneral);
		
		return consignatario;
	}
		
	public void setConsignatario(Consignatario newConsignatario) {
		this.consignatario = newConsignatario;
	}
	
	public ConsignatarioDataAccess getConsignatarioDataAccess() {
		return consignatarioDataAccess;
	}
	
	public void setConsignatarioDataAccess(ConsignatarioDataAccess newconsignatarioDataAccess) {
		this.consignatarioDataAccess = newconsignatarioDataAccess;
	}
	
	public List<Consignatario> getConsignatarios() throws Exception {		
		this.quitarConsignatariosNulos();
		
		ConsignatarioLogicAdditional.checkConsignatarioToGets(consignatarios,this.datosCliente,this.arrDatoGeneral);
		
		for (Consignatario consignatarioLocal: consignatarios ) {
			ConsignatarioLogicAdditional.updateConsignatarioToGet(consignatarioLocal,this.arrDatoGeneral);
		}
		
		return consignatarios;
	}
	
	public void setConsignatarios(List<Consignatario> newConsignatarios) {
		this.consignatarios = newConsignatarios;
	}
	
	public Object getConsignatarioObject() {	
		this.consignatarioObject=this.consignatarioDataAccess.getEntityObject();
		return this.consignatarioObject;
	}
		
	public void setConsignatarioObject(Object newConsignatarioObject) {
		this.consignatarioObject = newConsignatarioObject;
	}
	
	public List<Object> getConsignatariosObject() {		
		this.consignatariosObject=this.consignatarioDataAccess.getEntitiesObject();
		return this.consignatariosObject;
	}
		
	public void setConsignatariosObject(List<Object> newConsignatariosObject) {
		this.consignatariosObject = newConsignatariosObject;
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
		
		if(this.consignatarioDataAccess!=null) {
			this.consignatarioDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignatario.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			consignatarioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			consignatarioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		consignatario = new  Consignatario();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignatario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			consignatario=consignatarioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.consignatario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConsignatarioConstantesFunciones.refrescarForeignKeysDescripcionesConsignatario(this.consignatario);
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
		consignatario = new  Consignatario();
		  		  
        try {
			
			consignatario=consignatarioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.consignatario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConsignatarioConstantesFunciones.refrescarForeignKeysDescripcionesConsignatario(this.consignatario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		consignatario = new  Consignatario();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignatario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			consignatario=consignatarioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.consignatario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConsignatarioConstantesFunciones.refrescarForeignKeysDescripcionesConsignatario(this.consignatario);
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
		consignatario = new  Consignatario();
		  		  
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
		consignatario = new  Consignatario();
		  		  
        try {
			
			consignatario=consignatarioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.consignatario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConsignatarioConstantesFunciones.refrescarForeignKeysDescripcionesConsignatario(this.consignatario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		consignatario = new  Consignatario();
		  		  
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
		consignatario = new  Consignatario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignatario.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =consignatarioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		consignatario = new  Consignatario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=consignatarioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		consignatario = new  Consignatario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignatario.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =consignatarioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		consignatario = new  Consignatario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=consignatarioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		consignatario = new  Consignatario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignatario.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =consignatarioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		consignatario = new  Consignatario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=consignatarioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		consignatarios = new  ArrayList<Consignatario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignatario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ConsignatarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consignatarios=consignatarioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConsignatario(consignatarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsignatarioConstantesFunciones.refrescarForeignKeysDescripcionesConsignatario(this.consignatarios);
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
		consignatarios = new  ArrayList<Consignatario>();
		  		  
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
		consignatarios = new  ArrayList<Consignatario>();
		  		  
        try {			
			ConsignatarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consignatarios=consignatarioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarConsignatario(consignatarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsignatarioConstantesFunciones.refrescarForeignKeysDescripcionesConsignatario(this.consignatarios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		consignatarios = new  ArrayList<Consignatario>();
		  		  
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
		consignatarios = new  ArrayList<Consignatario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignatario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ConsignatarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consignatarios=consignatarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConsignatario(consignatarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsignatarioConstantesFunciones.refrescarForeignKeysDescripcionesConsignatario(this.consignatarios);
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
		consignatarios = new  ArrayList<Consignatario>();
		  		  
        try {
			ConsignatarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consignatarios=consignatarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConsignatario(consignatarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsignatarioConstantesFunciones.refrescarForeignKeysDescripcionesConsignatario(this.consignatarios);
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
		consignatarios = new  ArrayList<Consignatario>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignatario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConsignatarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consignatarios=consignatarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConsignatario(consignatarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsignatarioConstantesFunciones.refrescarForeignKeysDescripcionesConsignatario(this.consignatarios);
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
		consignatarios = new  ArrayList<Consignatario>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConsignatarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consignatarios=consignatarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConsignatario(consignatarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsignatarioConstantesFunciones.refrescarForeignKeysDescripcionesConsignatario(this.consignatarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		consignatario = new  Consignatario();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignatario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConsignatarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consignatario=consignatarioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConsignatario(consignatario);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsignatarioConstantesFunciones.refrescarForeignKeysDescripcionesConsignatario(this.consignatario);
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
		consignatario = new  Consignatario();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConsignatarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consignatario=consignatarioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConsignatario(consignatario);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsignatarioConstantesFunciones.refrescarForeignKeysDescripcionesConsignatario(this.consignatario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		consignatarios = new  ArrayList<Consignatario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignatario.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ConsignatarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consignatarios=consignatarioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConsignatario(consignatarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsignatarioConstantesFunciones.refrescarForeignKeysDescripcionesConsignatario(this.consignatarios);
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
		consignatarios = new  ArrayList<Consignatario>();
		  		  
        try {
			ConsignatarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consignatarios=consignatarioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConsignatario(consignatarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsignatarioConstantesFunciones.refrescarForeignKeysDescripcionesConsignatario(this.consignatarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosConsignatariosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		consignatarios = new  ArrayList<Consignatario>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignatario.class.getSimpleName()+"-getTodosConsignatariosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConsignatarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consignatarios=consignatarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarConsignatario(consignatarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsignatarioConstantesFunciones.refrescarForeignKeysDescripcionesConsignatario(this.consignatarios);
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
	
	public  void  getTodosConsignatarios(String sFinalQuery,Pagination pagination)throws Exception {
		consignatarios = new  ArrayList<Consignatario>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConsignatarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consignatarios=consignatarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarConsignatario(consignatarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsignatarioConstantesFunciones.refrescarForeignKeysDescripcionesConsignatario(this.consignatarios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarConsignatario(Consignatario consignatario) throws Exception {
		Boolean estaValidado=false;
		
		if(consignatario.getIsNew() || consignatario.getIsChanged()) { 
			this.invalidValues = consignatarioValidator.getInvalidValues(consignatario);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(consignatario);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarConsignatario(List<Consignatario> Consignatarios) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Consignatario consignatarioLocal:consignatarios) {				
			estaValidadoObjeto=this.validarGuardarConsignatario(consignatarioLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarConsignatario(List<Consignatario> Consignatarios) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarConsignatario(consignatarios)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarConsignatario(Consignatario Consignatario) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarConsignatario(consignatario)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Consignatario consignatario) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+consignatario.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ConsignatarioConstantesFunciones.getConsignatarioLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"consignatario","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ConsignatarioConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ConsignatarioConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveConsignatarioWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignatario.class.getSimpleName()+"-saveConsignatarioWithConnection");connexion.begin();			
			
			ConsignatarioLogicAdditional.checkConsignatarioToSave(this.consignatario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ConsignatarioLogicAdditional.updateConsignatarioToSave(this.consignatario,this.arrDatoGeneral);
			
			ConsignatarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.consignatario,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowConsignatario();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarConsignatario(this.consignatario)) {
				ConsignatarioDataAccess.save(this.consignatario, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.consignatario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ConsignatarioLogicAdditional.checkConsignatarioToSaveAfter(this.consignatario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowConsignatario();
			
			connexion.commit();			
			
			if(this.consignatario.getIsDeleted()) {
				this.consignatario=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveConsignatario()throws Exception {	
		try {	
			
			ConsignatarioLogicAdditional.checkConsignatarioToSave(this.consignatario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ConsignatarioLogicAdditional.updateConsignatarioToSave(this.consignatario,this.arrDatoGeneral);
			
			ConsignatarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.consignatario,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarConsignatario(this.consignatario)) {			
				ConsignatarioDataAccess.save(this.consignatario, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.consignatario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ConsignatarioLogicAdditional.checkConsignatarioToSaveAfter(this.consignatario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.consignatario.getIsDeleted()) {
				this.consignatario=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveConsignatariosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignatario.class.getSimpleName()+"-saveConsignatariosWithConnection");connexion.begin();			
			
			ConsignatarioLogicAdditional.checkConsignatarioToSaves(consignatarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowConsignatarios();
			
			Boolean validadoTodosConsignatario=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Consignatario consignatarioLocal:consignatarios) {		
				if(consignatarioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ConsignatarioLogicAdditional.updateConsignatarioToSave(consignatarioLocal,this.arrDatoGeneral);
	        	
				ConsignatarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),consignatarioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarConsignatario(consignatarioLocal)) {
					ConsignatarioDataAccess.save(consignatarioLocal, connexion);				
				} else {
					validadoTodosConsignatario=false;
				}
			}
			
			if(!validadoTodosConsignatario) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ConsignatarioLogicAdditional.checkConsignatarioToSavesAfter(consignatarios,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowConsignatarios();
			
			connexion.commit();		
			
			this.quitarConsignatariosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveConsignatarios()throws Exception {				
		 try {	
			ConsignatarioLogicAdditional.checkConsignatarioToSaves(consignatarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosConsignatario=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Consignatario consignatarioLocal:consignatarios) {				
				if(consignatarioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ConsignatarioLogicAdditional.updateConsignatarioToSave(consignatarioLocal,this.arrDatoGeneral);
	        	
				ConsignatarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),consignatarioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarConsignatario(consignatarioLocal)) {				
					ConsignatarioDataAccess.save(consignatarioLocal, connexion);				
				} else {
					validadoTodosConsignatario=false;
				}
			}
			
			if(!validadoTodosConsignatario) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ConsignatarioLogicAdditional.checkConsignatarioToSavesAfter(consignatarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarConsignatariosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ConsignatarioParameterReturnGeneral procesarAccionConsignatarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Consignatario> consignatarios,ConsignatarioParameterReturnGeneral consignatarioParameterGeneral)throws Exception {
		 try {	
			ConsignatarioParameterReturnGeneral consignatarioReturnGeneral=new ConsignatarioParameterReturnGeneral();
	
			ConsignatarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,consignatarios,consignatarioParameterGeneral,consignatarioReturnGeneral);
			
			return consignatarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ConsignatarioParameterReturnGeneral procesarAccionConsignatariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Consignatario> consignatarios,ConsignatarioParameterReturnGeneral consignatarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignatario.class.getSimpleName()+"-procesarAccionConsignatariosWithConnection");connexion.begin();			
			
			ConsignatarioParameterReturnGeneral consignatarioReturnGeneral=new ConsignatarioParameterReturnGeneral();
	
			ConsignatarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,consignatarios,consignatarioParameterGeneral,consignatarioReturnGeneral);
			
			this.connexion.commit();
			
			return consignatarioReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ConsignatarioParameterReturnGeneral procesarEventosConsignatarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Consignatario> consignatarios,Consignatario consignatario,ConsignatarioParameterReturnGeneral consignatarioParameterGeneral,Boolean isEsNuevoConsignatario,ArrayList<Classe> clases)throws Exception {
		 try {	
			ConsignatarioParameterReturnGeneral consignatarioReturnGeneral=new ConsignatarioParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				consignatarioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ConsignatarioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,consignatarios,consignatario,consignatarioParameterGeneral,consignatarioReturnGeneral,isEsNuevoConsignatario,clases);
			
			return consignatarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ConsignatarioParameterReturnGeneral procesarEventosConsignatariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Consignatario> consignatarios,Consignatario consignatario,ConsignatarioParameterReturnGeneral consignatarioParameterGeneral,Boolean isEsNuevoConsignatario,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignatario.class.getSimpleName()+"-procesarEventosConsignatariosWithConnection");connexion.begin();			
			
			ConsignatarioParameterReturnGeneral consignatarioReturnGeneral=new ConsignatarioParameterReturnGeneral();
	
			consignatarioReturnGeneral.setConsignatario(consignatario);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				consignatarioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ConsignatarioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,consignatarios,consignatario,consignatarioParameterGeneral,consignatarioReturnGeneral,isEsNuevoConsignatario,clases);
			
			this.connexion.commit();
			
			return consignatarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ConsignatarioParameterReturnGeneral procesarImportacionConsignatariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ConsignatarioParameterReturnGeneral consignatarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignatario.class.getSimpleName()+"-procesarImportacionConsignatariosWithConnection");connexion.begin();			
			
			ConsignatarioParameterReturnGeneral consignatarioReturnGeneral=new ConsignatarioParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.consignatarios=new ArrayList<Consignatario>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.consignatario=new Consignatario();
				
				
				if(conColumnasBase) {this.consignatario.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.consignatario.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.consignatario.setnombre_completo(arrColumnas[iColumn++]);
				this.consignatario.setnombre(arrColumnas[iColumn++]);
				this.consignatario.setapellido(arrColumnas[iColumn++]);
				
				this.consignatarios.add(this.consignatario);
			}
			
			this.saveConsignatarios();
			
			this.connexion.commit();
			
			consignatarioReturnGeneral.setConRetornoEstaProcesado(true);
			consignatarioReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return consignatarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarConsignatariosEliminados() throws Exception {				
		
		List<Consignatario> consignatariosAux= new ArrayList<Consignatario>();
		
		for(Consignatario consignatario:consignatarios) {
			if(!consignatario.getIsDeleted()) {
				consignatariosAux.add(consignatario);
			}
		}
		
		consignatarios=consignatariosAux;
	}
	
	public void quitarConsignatariosNulos() throws Exception {				
		
		List<Consignatario> consignatariosAux= new ArrayList<Consignatario>();
		
		for(Consignatario consignatario : this.consignatarios) {
			if(consignatario==null) {
				consignatariosAux.add(consignatario);
			}
		}
		
		//this.consignatarios=consignatariosAux;
		
		this.consignatarios.removeAll(consignatariosAux);
	}
	
	public void getSetVersionRowConsignatarioWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(consignatario.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((consignatario.getIsDeleted() || (consignatario.getIsChanged()&&!consignatario.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=consignatarioDataAccess.getSetVersionRowConsignatario(connexion,consignatario.getId());
				
				if(!consignatario.getVersionRow().equals(timestamp)) {	
					consignatario.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				consignatario.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowConsignatario()throws Exception {	
		
		if(consignatario.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((consignatario.getIsDeleted() || (consignatario.getIsChanged()&&!consignatario.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=consignatarioDataAccess.getSetVersionRowConsignatario(connexion,consignatario.getId());
			
			try {							
				if(!consignatario.getVersionRow().equals(timestamp)) {	
					consignatario.setVersionRow(timestamp);
				}
				
				consignatario.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowConsignatariosWithConnection()throws Exception {	
		if(consignatarios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Consignatario consignatarioAux:consignatarios) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(consignatarioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(consignatarioAux.getIsDeleted() || (consignatarioAux.getIsChanged()&&!consignatarioAux.getIsNew())) {
						
						timestamp=consignatarioDataAccess.getSetVersionRowConsignatario(connexion,consignatarioAux.getId());
						
						if(!consignatario.getVersionRow().equals(timestamp)) {	
							consignatarioAux.setVersionRow(timestamp);
						}
								
						consignatarioAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowConsignatarios()throws Exception {	
		if(consignatarios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Consignatario consignatarioAux:consignatarios) {
					if(consignatarioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(consignatarioAux.getIsDeleted() || (consignatarioAux.getIsChanged()&&!consignatarioAux.getIsNew())) {
						
						timestamp=consignatarioDataAccess.getSetVersionRowConsignatario(connexion,consignatarioAux.getId());
						
						if(!consignatarioAux.getVersionRow().equals(timestamp)) {	
							consignatarioAux.setVersionRow(timestamp);
						}
						
													
						consignatarioAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ConsignatarioParameterReturnGeneral cargarCombosLoteForeignKeyConsignatarioWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalCliente,String finalQueryGlobalUsuario) throws Exception {
		ConsignatarioParameterReturnGeneral  consignatarioReturnGeneral =new ConsignatarioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignatario.class.getSimpleName()+"-cargarCombosLoteForeignKeyConsignatarioWithConnection");connexion.begin();
			
			consignatarioReturnGeneral =new ConsignatarioParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			consignatarioReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			consignatarioReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			consignatarioReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			consignatarioReturnGeneral.setusuariosForeignKey(usuariosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return consignatarioReturnGeneral;
	}
	
	public ConsignatarioParameterReturnGeneral cargarCombosLoteForeignKeyConsignatario(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalCliente,String finalQueryGlobalUsuario) throws Exception {
		ConsignatarioParameterReturnGeneral  consignatarioReturnGeneral =new ConsignatarioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			consignatarioReturnGeneral =new ConsignatarioParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			consignatarioReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			consignatarioReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			consignatarioReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			consignatarioReturnGeneral.setusuariosForeignKey(usuariosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return consignatarioReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyConsignatarioWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ProformaLogic proformaLogic=new ProformaLogic();
			ConsignacionLogic consignacionLogic=new ConsignacionLogic();
			PedidoExporLogic pedidoexporLogic=new PedidoExporLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignatario.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyConsignatarioWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Proforma.class));
			classes.add(new Classe(Consignacion.class));
			classes.add(new Classe(PedidoExpor.class));
											
			

			proformaLogic.setConnexion(this.getConnexion());
			proformaLogic.setDatosCliente(this.datosCliente);
			proformaLogic.setIsConRefrescarForeignKeys(true);

			consignacionLogic.setConnexion(this.getConnexion());
			consignacionLogic.setDatosCliente(this.datosCliente);
			consignacionLogic.setIsConRefrescarForeignKeys(true);

			pedidoexporLogic.setConnexion(this.getConnexion());
			pedidoexporLogic.setDatosCliente(this.datosCliente);
			pedidoexporLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Consignatario consignatario:this.consignatarios) {
				

				classes=new ArrayList<Classe>();
				classes=ProformaConstantesFunciones.getClassesForeignKeysOfProforma(new ArrayList<Classe>(),DeepLoadType.NONE);

				proformaLogic.setProformas(consignatario.proformas);
				proformaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ConsignacionConstantesFunciones.getClassesForeignKeysOfConsignacion(new ArrayList<Classe>(),DeepLoadType.NONE);

				consignacionLogic.setConsignacions(consignatario.consignacions);
				consignacionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PedidoExporConstantesFunciones.getClassesForeignKeysOfPedidoExpor(new ArrayList<Classe>(),DeepLoadType.NONE);

				pedidoexporLogic.setPedidoExpors(consignatario.pedidoexpors);
				pedidoexporLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Consignatario consignatario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ConsignatarioLogicAdditional.updateConsignatarioToGet(consignatario,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		consignatario.setEmpresa(consignatarioDataAccess.getEmpresa(connexion,consignatario));
		consignatario.setSucursal(consignatarioDataAccess.getSucursal(connexion,consignatario));
		consignatario.setCliente(consignatarioDataAccess.getCliente(connexion,consignatario));
		consignatario.setUsuario(consignatarioDataAccess.getUsuario(connexion,consignatario));
		consignatario.setProformas(consignatarioDataAccess.getProformas(connexion,consignatario));
		consignatario.setConsignacions(consignatarioDataAccess.getConsignacions(connexion,consignatario));
		consignatario.setPedidoExpors(consignatarioDataAccess.getPedidoExpors(connexion,consignatario));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				consignatario.setEmpresa(consignatarioDataAccess.getEmpresa(connexion,consignatario));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				consignatario.setSucursal(consignatarioDataAccess.getSucursal(connexion,consignatario));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				consignatario.setCliente(consignatarioDataAccess.getCliente(connexion,consignatario));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				consignatario.setUsuario(consignatarioDataAccess.getUsuario(connexion,consignatario));
				continue;
			}

			if(clas.clas.equals(Proforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				consignatario.setProformas(consignatarioDataAccess.getProformas(connexion,consignatario));

				if(this.isConDeep) {
					ProformaLogic proformaLogic= new ProformaLogic(this.connexion);
					proformaLogic.setProformas(consignatario.getProformas());
					ArrayList<Classe> classesLocal=ProformaConstantesFunciones.getClassesForeignKeysOfProforma(new ArrayList<Classe>(),DeepLoadType.NONE);
					proformaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProformaConstantesFunciones.refrescarForeignKeysDescripcionesProforma(proformaLogic.getProformas());
					consignatario.setProformas(proformaLogic.getProformas());
				}

				continue;
			}

			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				consignatario.setConsignacions(consignatarioDataAccess.getConsignacions(connexion,consignatario));

				if(this.isConDeep) {
					ConsignacionLogic consignacionLogic= new ConsignacionLogic(this.connexion);
					consignacionLogic.setConsignacions(consignatario.getConsignacions());
					ArrayList<Classe> classesLocal=ConsignacionConstantesFunciones.getClassesForeignKeysOfConsignacion(new ArrayList<Classe>(),DeepLoadType.NONE);
					consignacionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesConsignacion(consignacionLogic.getConsignacions());
					consignatario.setConsignacions(consignacionLogic.getConsignacions());
				}

				continue;
			}

			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				consignatario.setPedidoExpors(consignatarioDataAccess.getPedidoExpors(connexion,consignatario));

				if(this.isConDeep) {
					PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(this.connexion);
					pedidoexporLogic.setPedidoExpors(consignatario.getPedidoExpors());
					ArrayList<Classe> classesLocal=PedidoExporConstantesFunciones.getClassesForeignKeysOfPedidoExpor(new ArrayList<Classe>(),DeepLoadType.NONE);
					pedidoexporLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(pedidoexporLogic.getPedidoExpors());
					consignatario.setPedidoExpors(pedidoexporLogic.getPedidoExpors());
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
			consignatario.setEmpresa(consignatarioDataAccess.getEmpresa(connexion,consignatario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignatario.setSucursal(consignatarioDataAccess.getSucursal(connexion,consignatario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignatario.setCliente(consignatarioDataAccess.getCliente(connexion,consignatario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignatario.setUsuario(consignatarioDataAccess.getUsuario(connexion,consignatario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Proforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Proforma.class));
			consignatario.setProformas(consignatarioDataAccess.getProformas(connexion,consignatario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Consignacion.class));
			consignatario.setConsignacions(consignatarioDataAccess.getConsignacions(connexion,consignatario));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoExpor.class));
			consignatario.setPedidoExpors(consignatarioDataAccess.getPedidoExpors(connexion,consignatario));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		consignatario.setEmpresa(consignatarioDataAccess.getEmpresa(connexion,consignatario));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(consignatario.getEmpresa(),isDeep,deepLoadType,clases);
				
		consignatario.setSucursal(consignatarioDataAccess.getSucursal(connexion,consignatario));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(consignatario.getSucursal(),isDeep,deepLoadType,clases);
				
		consignatario.setCliente(consignatarioDataAccess.getCliente(connexion,consignatario));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(consignatario.getCliente(),isDeep,deepLoadType,clases);
				
		consignatario.setUsuario(consignatarioDataAccess.getUsuario(connexion,consignatario));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(consignatario.getUsuario(),isDeep,deepLoadType,clases);
				

		consignatario.setProformas(consignatarioDataAccess.getProformas(connexion,consignatario));

		for(Proforma proforma:consignatario.getProformas()) {
			ProformaLogic proformaLogic= new ProformaLogic(connexion);
			proformaLogic.deepLoad(proforma,isDeep,deepLoadType,clases);
		}

		consignatario.setConsignacions(consignatarioDataAccess.getConsignacions(connexion,consignatario));

		for(Consignacion consignacion:consignatario.getConsignacions()) {
			ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
			consignacionLogic.deepLoad(consignacion,isDeep,deepLoadType,clases);
		}

		consignatario.setPedidoExpors(consignatarioDataAccess.getPedidoExpors(connexion,consignatario));

		for(PedidoExpor pedidoexpor:consignatario.getPedidoExpors()) {
			PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
			pedidoexporLogic.deepLoad(pedidoexpor,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				consignatario.setEmpresa(consignatarioDataAccess.getEmpresa(connexion,consignatario));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(consignatario.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				consignatario.setSucursal(consignatarioDataAccess.getSucursal(connexion,consignatario));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(consignatario.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				consignatario.setCliente(consignatarioDataAccess.getCliente(connexion,consignatario));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(consignatario.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				consignatario.setUsuario(consignatarioDataAccess.getUsuario(connexion,consignatario));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(consignatario.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Proforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				consignatario.setProformas(consignatarioDataAccess.getProformas(connexion,consignatario));

				for(Proforma proforma:consignatario.getProformas()) {
					ProformaLogic proformaLogic= new ProformaLogic(connexion);
					proformaLogic.deepLoad(proforma,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				consignatario.setConsignacions(consignatarioDataAccess.getConsignacions(connexion,consignatario));

				for(Consignacion consignacion:consignatario.getConsignacions()) {
					ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
					consignacionLogic.deepLoad(consignacion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				consignatario.setPedidoExpors(consignatarioDataAccess.getPedidoExpors(connexion,consignatario));

				for(PedidoExpor pedidoexpor:consignatario.getPedidoExpors()) {
					PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
					pedidoexporLogic.deepLoad(pedidoexpor,isDeep,deepLoadType,clases);
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
			consignatario.setEmpresa(consignatarioDataAccess.getEmpresa(connexion,consignatario));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(consignatario.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignatario.setSucursal(consignatarioDataAccess.getSucursal(connexion,consignatario));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(consignatario.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignatario.setCliente(consignatarioDataAccess.getCliente(connexion,consignatario));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(consignatario.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			consignatario.setUsuario(consignatarioDataAccess.getUsuario(connexion,consignatario));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(consignatario.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Proforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Proforma.class));
			consignatario.setProformas(consignatarioDataAccess.getProformas(connexion,consignatario));

			for(Proforma proforma:consignatario.getProformas()) {
				ProformaLogic proformaLogic= new ProformaLogic(connexion);
				proformaLogic.deepLoad(proforma,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Consignacion.class));
			consignatario.setConsignacions(consignatarioDataAccess.getConsignacions(connexion,consignatario));

			for(Consignacion consignacion:consignatario.getConsignacions()) {
				ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
				consignacionLogic.deepLoad(consignacion,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoExpor.class));
			consignatario.setPedidoExpors(consignatarioDataAccess.getPedidoExpors(connexion,consignatario));

			for(PedidoExpor pedidoexpor:consignatario.getPedidoExpors()) {
				PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
				pedidoexporLogic.deepLoad(pedidoexpor,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Consignatario consignatario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ConsignatarioLogicAdditional.updateConsignatarioToSave(consignatario,this.arrDatoGeneral);
			
ConsignatarioDataAccess.save(consignatario, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(consignatario.getEmpresa(),connexion);

		SucursalDataAccess.save(consignatario.getSucursal(),connexion);

		ClienteDataAccess.save(consignatario.getCliente(),connexion);

		UsuarioDataAccess.save(consignatario.getUsuario(),connexion);

		for(Proforma proforma:consignatario.getProformas()) {
			proforma.setid_consignatario(consignatario.getId());
			ProformaDataAccess.save(proforma,connexion);
		}

		for(Consignacion consignacion:consignatario.getConsignacions()) {
			consignacion.setid_consignatario(consignatario.getId());
			ConsignacionDataAccess.save(consignacion,connexion);
		}

		for(PedidoExpor pedidoexpor:consignatario.getPedidoExpors()) {
			pedidoexpor.setid_consignatario(consignatario.getId());
			PedidoExporDataAccess.save(pedidoexpor,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(consignatario.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(consignatario.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(consignatario.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(consignatario.getUsuario(),connexion);
				continue;
			}


			if(clas.clas.equals(Proforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Proforma proforma:consignatario.getProformas()) {
					proforma.setid_consignatario(consignatario.getId());
					ProformaDataAccess.save(proforma,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Consignacion consignacion:consignatario.getConsignacions()) {
					consignacion.setid_consignatario(consignatario.getId());
					ConsignacionDataAccess.save(consignacion,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PedidoExpor pedidoexpor:consignatario.getPedidoExpors()) {
					pedidoexpor.setid_consignatario(consignatario.getId());
					PedidoExporDataAccess.save(pedidoexpor,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(consignatario.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(consignatario.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(consignatario.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(consignatario.getSucursal(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(consignatario.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(consignatario.getCliente(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(consignatario.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(consignatario.getUsuario(),isDeep,deepLoadType,clases);
				

		for(Proforma proforma:consignatario.getProformas()) {
			ProformaLogic proformaLogic= new ProformaLogic(connexion);
			proforma.setid_consignatario(consignatario.getId());
			ProformaDataAccess.save(proforma,connexion);
			proformaLogic.deepSave(proforma,isDeep,deepLoadType,clases);
		}

		for(Consignacion consignacion:consignatario.getConsignacions()) {
			ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
			consignacion.setid_consignatario(consignatario.getId());
			ConsignacionDataAccess.save(consignacion,connexion);
			consignacionLogic.deepSave(consignacion,isDeep,deepLoadType,clases);
		}

		for(PedidoExpor pedidoexpor:consignatario.getPedidoExpors()) {
			PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
			pedidoexpor.setid_consignatario(consignatario.getId());
			PedidoExporDataAccess.save(pedidoexpor,connexion);
			pedidoexporLogic.deepSave(pedidoexpor,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(consignatario.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(consignatario.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(consignatario.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(consignatario.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(consignatario.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(consignatario.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(consignatario.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(consignatario.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Proforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Proforma proforma:consignatario.getProformas()) {
					ProformaLogic proformaLogic= new ProformaLogic(connexion);
					proforma.setid_consignatario(consignatario.getId());
					ProformaDataAccess.save(proforma,connexion);
					proformaLogic.deepSave(proforma,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Consignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Consignacion consignacion:consignatario.getConsignacions()) {
					ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
					consignacion.setid_consignatario(consignatario.getId());
					ConsignacionDataAccess.save(consignacion,connexion);
					consignacionLogic.deepSave(consignacion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PedidoExpor pedidoexpor:consignatario.getPedidoExpors()) {
					PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
					pedidoexpor.setid_consignatario(consignatario.getId());
					PedidoExporDataAccess.save(pedidoexpor,connexion);
					pedidoexporLogic.deepSave(pedidoexpor,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Consignatario.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(consignatario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ConsignatarioConstantesFunciones.refrescarForeignKeysDescripcionesConsignatario(consignatario);
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
			this.deepLoad(this.consignatario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ConsignatarioConstantesFunciones.refrescarForeignKeysDescripcionesConsignatario(this.consignatario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Consignatario.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(consignatarios!=null) {
				for(Consignatario consignatario:consignatarios) {
					this.deepLoad(consignatario,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ConsignatarioConstantesFunciones.refrescarForeignKeysDescripcionesConsignatario(consignatarios);
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
			if(consignatarios!=null) {
				for(Consignatario consignatario:consignatarios) {
					this.deepLoad(consignatario,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ConsignatarioConstantesFunciones.refrescarForeignKeysDescripcionesConsignatario(consignatarios);
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
			this.getNewConnexionToDeep(Consignatario.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(consignatario,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Consignatario.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(consignatarios!=null) {
				for(Consignatario consignatario:consignatarios) {
					this.deepSave(consignatario,isDeep,deepLoadType,clases);
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
			if(consignatarios!=null) {
				for(Consignatario consignatario:consignatarios) {
					this.deepSave(consignatario,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getConsignatariosFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignatario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,ConsignatarioConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ConsignatarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignatarios=consignatarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignatarioConstantesFunciones.refrescarForeignKeysDescripcionesConsignatario(this.consignatarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConsignatariosFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,ConsignatarioConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ConsignatarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignatarios=consignatarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignatarioConstantesFunciones.refrescarForeignKeysDescripcionesConsignatario(this.consignatarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConsignatariosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignatario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ConsignatarioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ConsignatarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignatarios=consignatarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignatarioConstantesFunciones.refrescarForeignKeysDescripcionesConsignatario(this.consignatarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConsignatariosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ConsignatarioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ConsignatarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignatarios=consignatarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignatarioConstantesFunciones.refrescarForeignKeysDescripcionesConsignatario(this.consignatarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConsignatariosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignatario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ConsignatarioConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ConsignatarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignatarios=consignatarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignatarioConstantesFunciones.refrescarForeignKeysDescripcionesConsignatario(this.consignatarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConsignatariosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ConsignatarioConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ConsignatarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignatarios=consignatarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignatarioConstantesFunciones.refrescarForeignKeysDescripcionesConsignatario(this.consignatarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConsignatariosFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consignatario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,ConsignatarioConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			ConsignatarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignatarios=consignatarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignatarioConstantesFunciones.refrescarForeignKeysDescripcionesConsignatario(this.consignatarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConsignatariosFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,ConsignatarioConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			ConsignatarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consignatarios=consignatarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsignatarioConstantesFunciones.refrescarForeignKeysDescripcionesConsignatario(this.consignatarios);
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
			if(ConsignatarioConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ConsignatarioDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Consignatario consignatario,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ConsignatarioConstantesFunciones.ISCONAUDITORIA) {
				if(consignatario.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ConsignatarioDataAccess.TABLENAME, consignatario.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ConsignatarioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ConsignatarioLogic.registrarAuditoriaDetallesConsignatario(connexion,consignatario,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(consignatario.getIsDeleted()) {
					/*if(!consignatario.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ConsignatarioDataAccess.TABLENAME, consignatario.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ConsignatarioLogic.registrarAuditoriaDetallesConsignatario(connexion,consignatario,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ConsignatarioDataAccess.TABLENAME, consignatario.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(consignatario.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ConsignatarioDataAccess.TABLENAME, consignatario.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ConsignatarioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ConsignatarioLogic.registrarAuditoriaDetallesConsignatario(connexion,consignatario,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesConsignatario(Connexion connexion,Consignatario consignatario)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(consignatario.getIsNew()||!consignatario.getid_empresa().equals(consignatario.getConsignatarioOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignatario.getConsignatarioOriginal().getid_empresa()!=null)
				{
					strValorActual=consignatario.getConsignatarioOriginal().getid_empresa().toString();
				}
				if(consignatario.getid_empresa()!=null)
				{
					strValorNuevo=consignatario.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignatarioConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(consignatario.getIsNew()||!consignatario.getid_sucursal().equals(consignatario.getConsignatarioOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignatario.getConsignatarioOriginal().getid_sucursal()!=null)
				{
					strValorActual=consignatario.getConsignatarioOriginal().getid_sucursal().toString();
				}
				if(consignatario.getid_sucursal()!=null)
				{
					strValorNuevo=consignatario.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignatarioConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(consignatario.getIsNew()||!consignatario.getid_cliente().equals(consignatario.getConsignatarioOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignatario.getConsignatarioOriginal().getid_cliente()!=null)
				{
					strValorActual=consignatario.getConsignatarioOriginal().getid_cliente().toString();
				}
				if(consignatario.getid_cliente()!=null)
				{
					strValorNuevo=consignatario.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignatarioConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(consignatario.getIsNew()||!consignatario.getid_usuario().equals(consignatario.getConsignatarioOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignatario.getConsignatarioOriginal().getid_usuario()!=null)
				{
					strValorActual=consignatario.getConsignatarioOriginal().getid_usuario().toString();
				}
				if(consignatario.getid_usuario()!=null)
				{
					strValorNuevo=consignatario.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignatarioConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(consignatario.getIsNew()||!consignatario.getnombre_completo().equals(consignatario.getConsignatarioOriginal().getnombre_completo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignatario.getConsignatarioOriginal().getnombre_completo()!=null)
				{
					strValorActual=consignatario.getConsignatarioOriginal().getnombre_completo();
				}
				if(consignatario.getnombre_completo()!=null)
				{
					strValorNuevo=consignatario.getnombre_completo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignatarioConstantesFunciones.NOMBRECOMPLETO,strValorActual,strValorNuevo);
			}	
			
			if(consignatario.getIsNew()||!consignatario.getnombre().equals(consignatario.getConsignatarioOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignatario.getConsignatarioOriginal().getnombre()!=null)
				{
					strValorActual=consignatario.getConsignatarioOriginal().getnombre();
				}
				if(consignatario.getnombre()!=null)
				{
					strValorNuevo=consignatario.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignatarioConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(consignatario.getIsNew()||!consignatario.getapellido().equals(consignatario.getConsignatarioOriginal().getapellido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consignatario.getConsignatarioOriginal().getapellido()!=null)
				{
					strValorActual=consignatario.getConsignatarioOriginal().getapellido();
				}
				if(consignatario.getapellido()!=null)
				{
					strValorNuevo=consignatario.getapellido() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsignatarioConstantesFunciones.APELLIDO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveConsignatarioRelacionesWithConnection(Consignatario consignatario,List<Proforma> proformas,List<Consignacion> consignacions,List<PedidoExpor> pedidoexpors) throws Exception {

		if(!consignatario.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveConsignatarioRelacionesBase(consignatario,proformas,consignacions,pedidoexpors,true);
		}
	}

	public void saveConsignatarioRelaciones(Consignatario consignatario,List<Proforma> proformas,List<Consignacion> consignacions,List<PedidoExpor> pedidoexpors)throws Exception {

		if(!consignatario.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveConsignatarioRelacionesBase(consignatario,proformas,consignacions,pedidoexpors,false);
		}
	}

	public void saveConsignatarioRelacionesBase(Consignatario consignatario,List<Proforma> proformas,List<Consignacion> consignacions,List<PedidoExpor> pedidoexpors,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Consignatario-saveRelacionesWithConnection");}
	
			consignatario.setProformas(proformas);
			consignatario.setConsignacions(consignacions);
			consignatario.setPedidoExpors(pedidoexpors);

			this.setConsignatario(consignatario);

			if(ConsignatarioLogicAdditional.validarSaveRelaciones(consignatario,this)) {

				ConsignatarioLogicAdditional.updateRelacionesToSave(consignatario,this);

				if((consignatario.getIsNew()||consignatario.getIsChanged())&&!consignatario.getIsDeleted()) {
					this.saveConsignatario();
					this.saveConsignatarioRelacionesDetalles(proformas,consignacions,pedidoexpors);

				} else if(consignatario.getIsDeleted()) {
					this.saveConsignatarioRelacionesDetalles(proformas,consignacions,pedidoexpors);
					this.saveConsignatario();
				}

				ConsignatarioLogicAdditional.updateRelacionesToSaveAfter(consignatario,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ProformaConstantesFunciones.InicializarGeneralEntityAuxiliaresProformas(proformas,true,true);
			ConsignacionConstantesFunciones.InicializarGeneralEntityAuxiliaresConsignacions(consignacions,true,true);
			PedidoExporConstantesFunciones.InicializarGeneralEntityAuxiliaresPedidoExpors(pedidoexpors,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveConsignatarioRelacionesDetalles(List<Proforma> proformas,List<Consignacion> consignacions,List<PedidoExpor> pedidoexpors)throws Exception {
		try {
	

			Long idConsignatarioActual=this.getConsignatario().getId();

			ProformaLogic proformaLogic_Desde_Consignatario=new ProformaLogic();
			proformaLogic_Desde_Consignatario.setProformas(proformas);

			proformaLogic_Desde_Consignatario.setConnexion(this.getConnexion());
			proformaLogic_Desde_Consignatario.setDatosCliente(this.datosCliente);

			for(Proforma proforma_Desde_Consignatario:proformaLogic_Desde_Consignatario.getProformas()) {
				proforma_Desde_Consignatario.setid_consignatario(idConsignatarioActual);

				proformaLogic_Desde_Consignatario.setProforma(proforma_Desde_Consignatario);
				proformaLogic_Desde_Consignatario.saveProforma();

				Long idProformaActual=proforma_Desde_Consignatario.getId();

				TerminoProformaLogic terminoproformaLogic_Desde_Proforma=new TerminoProformaLogic();

				if(proforma_Desde_Consignatario.getTerminoProformas()==null){
					proforma_Desde_Consignatario.setTerminoProformas(new ArrayList<TerminoProforma>());
				}

				terminoproformaLogic_Desde_Proforma.setTerminoProformas(proforma_Desde_Consignatario.getTerminoProformas());

				terminoproformaLogic_Desde_Proforma.setConnexion(this.getConnexion());
				terminoproformaLogic_Desde_Proforma.setDatosCliente(this.datosCliente);

				for(TerminoProforma terminoproforma_Desde_Proforma:terminoproformaLogic_Desde_Proforma.getTerminoProformas()) {
					terminoproforma_Desde_Proforma.setid_proforma(idProformaActual);

					terminoproformaLogic_Desde_Proforma.setTerminoProforma(terminoproforma_Desde_Proforma);
					terminoproformaLogic_Desde_Proforma.saveTerminoProforma();

					Long idTerminoProformaActual=terminoproforma_Desde_Proforma.getId();

					DetalleTerminoProformaLogic detalleterminoproformaLogic_Desde_TerminoProforma=new DetalleTerminoProformaLogic();

					if(terminoproforma_Desde_Proforma.getDetalleTerminoProformas()==null){
						terminoproforma_Desde_Proforma.setDetalleTerminoProformas(new ArrayList<DetalleTerminoProforma>());
					}

					detalleterminoproformaLogic_Desde_TerminoProforma.setDetalleTerminoProformas(terminoproforma_Desde_Proforma.getDetalleTerminoProformas());

					detalleterminoproformaLogic_Desde_TerminoProforma.setConnexion(this.getConnexion());
					detalleterminoproformaLogic_Desde_TerminoProforma.setDatosCliente(this.datosCliente);

					for(DetalleTerminoProforma detalleterminoproforma_Desde_TerminoProforma:detalleterminoproformaLogic_Desde_TerminoProforma.getDetalleTerminoProformas()) {
						detalleterminoproforma_Desde_TerminoProforma.setid_termino_proforma(idTerminoProformaActual);
					}

					detalleterminoproformaLogic_Desde_TerminoProforma.saveDetalleTerminoProformas();
				}


				DetalleProformaLogic detalleproformaLogic_Desde_Proforma=new DetalleProformaLogic();

				if(proforma_Desde_Consignatario.getDetalleProformas()==null){
					proforma_Desde_Consignatario.setDetalleProformas(new ArrayList<DetalleProforma>());
				}

				detalleproformaLogic_Desde_Proforma.setDetalleProformas(proforma_Desde_Consignatario.getDetalleProformas());

				detalleproformaLogic_Desde_Proforma.setConnexion(this.getConnexion());
				detalleproformaLogic_Desde_Proforma.setDatosCliente(this.datosCliente);

				for(DetalleProforma detalleproforma_Desde_Proforma:detalleproformaLogic_Desde_Proforma.getDetalleProformas()) {
					detalleproforma_Desde_Proforma.setid_proforma(idProformaActual);
				}

				detalleproformaLogic_Desde_Proforma.saveDetalleProformas();
			}


			ConsignacionLogic consignacionLogic_Desde_Consignatario=new ConsignacionLogic();
			consignacionLogic_Desde_Consignatario.setConsignacions(consignacions);

			consignacionLogic_Desde_Consignatario.setConnexion(this.getConnexion());
			consignacionLogic_Desde_Consignatario.setDatosCliente(this.datosCliente);

			for(Consignacion consignacion_Desde_Consignatario:consignacionLogic_Desde_Consignatario.getConsignacions()) {
				consignacion_Desde_Consignatario.setid_consignatario(idConsignatarioActual);

				consignacionLogic_Desde_Consignatario.setConsignacion(consignacion_Desde_Consignatario);
				consignacionLogic_Desde_Consignatario.saveConsignacion();

				Long idConsignacionActual=consignacion_Desde_Consignatario.getId();

				DetalleConsignacionLogic detalleconsignacionLogic_Desde_Consignacion=new DetalleConsignacionLogic();

				if(consignacion_Desde_Consignatario.getDetalleConsignacions()==null){
					consignacion_Desde_Consignatario.setDetalleConsignacions(new ArrayList<DetalleConsignacion>());
				}

				detalleconsignacionLogic_Desde_Consignacion.setDetalleConsignacions(consignacion_Desde_Consignatario.getDetalleConsignacions());

				detalleconsignacionLogic_Desde_Consignacion.setConnexion(this.getConnexion());
				detalleconsignacionLogic_Desde_Consignacion.setDatosCliente(this.datosCliente);

				for(DetalleConsignacion detalleconsignacion_Desde_Consignacion:detalleconsignacionLogic_Desde_Consignacion.getDetalleConsignacions()) {
					detalleconsignacion_Desde_Consignacion.setid_consignacion(idConsignacionActual);
				}

				detalleconsignacionLogic_Desde_Consignacion.saveDetalleConsignacions();
			}


			PedidoExporLogic pedidoexporLogic_Desde_Consignatario=new PedidoExporLogic();
			pedidoexporLogic_Desde_Consignatario.setPedidoExpors(pedidoexpors);

			pedidoexporLogic_Desde_Consignatario.setConnexion(this.getConnexion());
			pedidoexporLogic_Desde_Consignatario.setDatosCliente(this.datosCliente);

			for(PedidoExpor pedidoexpor_Desde_Consignatario:pedidoexporLogic_Desde_Consignatario.getPedidoExpors()) {
				pedidoexpor_Desde_Consignatario.setid_consignatario(idConsignatarioActual);

				pedidoexporLogic_Desde_Consignatario.setPedidoExpor(pedidoexpor_Desde_Consignatario);
				pedidoexporLogic_Desde_Consignatario.savePedidoExpor();

				Long idPedidoExporActual=pedidoexpor_Desde_Consignatario.getId();

				DetallePedidoExporLogic detallepedidoexporLogic_Desde_PedidoExpor=new DetallePedidoExporLogic();

				if(pedidoexpor_Desde_Consignatario.getDetallePedidoExpors()==null){
					pedidoexpor_Desde_Consignatario.setDetallePedidoExpors(new ArrayList<DetallePedidoExpor>());
				}

				detallepedidoexporLogic_Desde_PedidoExpor.setDetallePedidoExpors(pedidoexpor_Desde_Consignatario.getDetallePedidoExpors());

				detallepedidoexporLogic_Desde_PedidoExpor.setConnexion(this.getConnexion());
				detallepedidoexporLogic_Desde_PedidoExpor.setDatosCliente(this.datosCliente);

				for(DetallePedidoExpor detallepedidoexpor_Desde_PedidoExpor:detallepedidoexporLogic_Desde_PedidoExpor.getDetallePedidoExpors()) {
					detallepedidoexpor_Desde_PedidoExpor.setid_pedido_expor(idPedidoExporActual);
				}

				detallepedidoexporLogic_Desde_PedidoExpor.saveDetallePedidoExpors();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfConsignatario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ConsignatarioConstantesFunciones.getClassesForeignKeysOfConsignatario(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfConsignatario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ConsignatarioConstantesFunciones.getClassesRelationshipsOfConsignatario(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
