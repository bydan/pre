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
package com.bydan.erp.sris.business.logic;

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
import com.bydan.erp.sris.util.*;
import com.bydan.erp.sris.util.FacturaDiarioConstantesFunciones;
import com.bydan.erp.sris.util.FacturaDiarioParameterReturnGeneral;
//import com.bydan.erp.sris.util.FacturaDiarioParameterGeneral;
import com.bydan.erp.sris.business.entity.FacturaDiario;
import com.bydan.erp.sris.business.logic.FacturaDiarioLogicAdditional;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.sris.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class FacturaDiarioLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(FacturaDiarioLogic.class);
	
	protected FacturaDiarioDataAccess facturadiarioDataAccess; 	
	protected FacturaDiario facturadiario;
	protected List<FacturaDiario> facturadiarios;
	protected Object facturadiarioObject;	
	protected List<Object> facturadiariosObject;
	
	public static ClassValidator<FacturaDiario> facturadiarioValidator = new ClassValidator<FacturaDiario>(FacturaDiario.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected FacturaDiarioLogicAdditional facturadiarioLogicAdditional=null;
	
	public FacturaDiarioLogicAdditional getFacturaDiarioLogicAdditional() {
		return this.facturadiarioLogicAdditional;
	}
	
	public void setFacturaDiarioLogicAdditional(FacturaDiarioLogicAdditional facturadiarioLogicAdditional) {
		try {
			this.facturadiarioLogicAdditional=facturadiarioLogicAdditional;
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
	
	
	
	
	public  FacturaDiarioLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.facturadiarioDataAccess = new FacturaDiarioDataAccess();
			
			this.facturadiarios= new ArrayList<FacturaDiario>();
			this.facturadiario= new FacturaDiario();
			
			this.facturadiarioObject=new Object();
			this.facturadiariosObject=new ArrayList<Object>();
				
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
			
			this.facturadiarioDataAccess.setConnexionType(this.connexionType);
			this.facturadiarioDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  FacturaDiarioLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.facturadiarioDataAccess = new FacturaDiarioDataAccess();
			this.facturadiarios= new ArrayList<FacturaDiario>();
			this.facturadiario= new FacturaDiario();
			this.facturadiarioObject=new Object();
			this.facturadiariosObject=new ArrayList<Object>();
			
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
			
			this.facturadiarioDataAccess.setConnexionType(this.connexionType);
			this.facturadiarioDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public FacturaDiario getFacturaDiario() throws Exception {	
		FacturaDiarioLogicAdditional.checkFacturaDiarioToGet(facturadiario,this.datosCliente,this.arrDatoGeneral);
		FacturaDiarioLogicAdditional.updateFacturaDiarioToGet(facturadiario,this.arrDatoGeneral);
		
		return facturadiario;
	}
		
	public void setFacturaDiario(FacturaDiario newFacturaDiario) {
		this.facturadiario = newFacturaDiario;
	}
	
	public FacturaDiarioDataAccess getFacturaDiarioDataAccess() {
		return facturadiarioDataAccess;
	}
	
	public void setFacturaDiarioDataAccess(FacturaDiarioDataAccess newfacturadiarioDataAccess) {
		this.facturadiarioDataAccess = newfacturadiarioDataAccess;
	}
	
	public List<FacturaDiario> getFacturaDiarios() throws Exception {		
		this.quitarFacturaDiariosNulos();
		
		FacturaDiarioLogicAdditional.checkFacturaDiarioToGets(facturadiarios,this.datosCliente,this.arrDatoGeneral);
		
		for (FacturaDiario facturadiarioLocal: facturadiarios ) {
			FacturaDiarioLogicAdditional.updateFacturaDiarioToGet(facturadiarioLocal,this.arrDatoGeneral);
		}
		
		return facturadiarios;
	}
	
	public void setFacturaDiarios(List<FacturaDiario> newFacturaDiarios) {
		this.facturadiarios = newFacturaDiarios;
	}
	
	public Object getFacturaDiarioObject() {	
		this.facturadiarioObject=this.facturadiarioDataAccess.getEntityObject();
		return this.facturadiarioObject;
	}
		
	public void setFacturaDiarioObject(Object newFacturaDiarioObject) {
		this.facturadiarioObject = newFacturaDiarioObject;
	}
	
	public List<Object> getFacturaDiariosObject() {		
		this.facturadiariosObject=this.facturadiarioDataAccess.getEntitiesObject();
		return this.facturadiariosObject;
	}
		
	public void setFacturaDiariosObject(List<Object> newFacturaDiariosObject) {
		this.facturadiariosObject = newFacturaDiariosObject;
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
		
		if(this.facturadiarioDataAccess!=null) {
			this.facturadiarioDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaDiario.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			facturadiarioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			facturadiarioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		facturadiario = new  FacturaDiario();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaDiario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			facturadiario=facturadiarioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.facturadiario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(this.facturadiario);
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
		facturadiario = new  FacturaDiario();
		  		  
        try {
			
			facturadiario=facturadiarioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.facturadiario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(this.facturadiario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		facturadiario = new  FacturaDiario();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaDiario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			facturadiario=facturadiarioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.facturadiario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(this.facturadiario);
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
		facturadiario = new  FacturaDiario();
		  		  
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
		facturadiario = new  FacturaDiario();
		  		  
        try {
			
			facturadiario=facturadiarioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.facturadiario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(this.facturadiario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		facturadiario = new  FacturaDiario();
		  		  
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
		facturadiario = new  FacturaDiario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaDiario.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =facturadiarioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		facturadiario = new  FacturaDiario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=facturadiarioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		facturadiario = new  FacturaDiario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaDiario.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =facturadiarioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		facturadiario = new  FacturaDiario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=facturadiarioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		facturadiario = new  FacturaDiario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaDiario.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =facturadiarioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		facturadiario = new  FacturaDiario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=facturadiarioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		facturadiarios = new  ArrayList<FacturaDiario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaDiario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			FacturaDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturadiarios=facturadiarioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFacturaDiario(facturadiarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(this.facturadiarios);
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
		facturadiarios = new  ArrayList<FacturaDiario>();
		  		  
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
		facturadiarios = new  ArrayList<FacturaDiario>();
		  		  
        try {			
			FacturaDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturadiarios=facturadiarioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarFacturaDiario(facturadiarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(this.facturadiarios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		facturadiarios = new  ArrayList<FacturaDiario>();
		  		  
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
		facturadiarios = new  ArrayList<FacturaDiario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaDiario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			FacturaDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturadiarios=facturadiarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFacturaDiario(facturadiarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(this.facturadiarios);
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
		facturadiarios = new  ArrayList<FacturaDiario>();
		  		  
        try {
			FacturaDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturadiarios=facturadiarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFacturaDiario(facturadiarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(this.facturadiarios);
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
		facturadiarios = new  ArrayList<FacturaDiario>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaDiario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturadiarios=facturadiarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFacturaDiario(facturadiarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(this.facturadiarios);
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
		facturadiarios = new  ArrayList<FacturaDiario>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturadiarios=facturadiarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFacturaDiario(facturadiarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(this.facturadiarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		facturadiario = new  FacturaDiario();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaDiario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturadiario=facturadiarioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFacturaDiario(facturadiario);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(this.facturadiario);
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
		facturadiario = new  FacturaDiario();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturadiario=facturadiarioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFacturaDiario(facturadiario);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(this.facturadiario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		facturadiarios = new  ArrayList<FacturaDiario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaDiario.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			FacturaDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturadiarios=facturadiarioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFacturaDiario(facturadiarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(this.facturadiarios);
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
		facturadiarios = new  ArrayList<FacturaDiario>();
		  		  
        try {
			FacturaDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturadiarios=facturadiarioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFacturaDiario(facturadiarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(this.facturadiarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosFacturaDiariosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		facturadiarios = new  ArrayList<FacturaDiario>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaDiario.class.getSimpleName()+"-getTodosFacturaDiariosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturadiarios=facturadiarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFacturaDiario(facturadiarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(this.facturadiarios);
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
	
	public  void  getTodosFacturaDiarios(String sFinalQuery,Pagination pagination)throws Exception {
		facturadiarios = new  ArrayList<FacturaDiario>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturadiarios=facturadiarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFacturaDiario(facturadiarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(this.facturadiarios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarFacturaDiario(FacturaDiario facturadiario) throws Exception {
		Boolean estaValidado=false;
		
		if(facturadiario.getIsNew() || facturadiario.getIsChanged()) { 
			this.invalidValues = facturadiarioValidator.getInvalidValues(facturadiario);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(facturadiario);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarFacturaDiario(List<FacturaDiario> FacturaDiarios) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(FacturaDiario facturadiarioLocal:facturadiarios) {				
			estaValidadoObjeto=this.validarGuardarFacturaDiario(facturadiarioLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarFacturaDiario(List<FacturaDiario> FacturaDiarios) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFacturaDiario(facturadiarios)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarFacturaDiario(FacturaDiario FacturaDiario) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFacturaDiario(facturadiario)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(FacturaDiario facturadiario) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+facturadiario.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=FacturaDiarioConstantesFunciones.getFacturaDiarioLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"facturadiario","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(FacturaDiarioConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(FacturaDiarioConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveFacturaDiarioWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaDiario.class.getSimpleName()+"-saveFacturaDiarioWithConnection");connexion.begin();			
			
			FacturaDiarioLogicAdditional.checkFacturaDiarioToSave(this.facturadiario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FacturaDiarioLogicAdditional.updateFacturaDiarioToSave(this.facturadiario,this.arrDatoGeneral);
			
			FacturaDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.facturadiario,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowFacturaDiario();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFacturaDiario(this.facturadiario)) {
				FacturaDiarioDataAccess.save(this.facturadiario, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.facturadiario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FacturaDiarioLogicAdditional.checkFacturaDiarioToSaveAfter(this.facturadiario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFacturaDiario();
			
			connexion.commit();			
			
			if(this.facturadiario.getIsDeleted()) {
				this.facturadiario=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveFacturaDiario()throws Exception {	
		try {	
			
			FacturaDiarioLogicAdditional.checkFacturaDiarioToSave(this.facturadiario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FacturaDiarioLogicAdditional.updateFacturaDiarioToSave(this.facturadiario,this.arrDatoGeneral);
			
			FacturaDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.facturadiario,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFacturaDiario(this.facturadiario)) {			
				FacturaDiarioDataAccess.save(this.facturadiario, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.facturadiario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FacturaDiarioLogicAdditional.checkFacturaDiarioToSaveAfter(this.facturadiario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.facturadiario.getIsDeleted()) {
				this.facturadiario=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveFacturaDiariosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaDiario.class.getSimpleName()+"-saveFacturaDiariosWithConnection");connexion.begin();			
			
			FacturaDiarioLogicAdditional.checkFacturaDiarioToSaves(facturadiarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowFacturaDiarios();
			
			Boolean validadoTodosFacturaDiario=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FacturaDiario facturadiarioLocal:facturadiarios) {		
				if(facturadiarioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FacturaDiarioLogicAdditional.updateFacturaDiarioToSave(facturadiarioLocal,this.arrDatoGeneral);
	        	
				FacturaDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),facturadiarioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFacturaDiario(facturadiarioLocal)) {
					FacturaDiarioDataAccess.save(facturadiarioLocal, connexion);				
				} else {
					validadoTodosFacturaDiario=false;
				}
			}
			
			if(!validadoTodosFacturaDiario) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FacturaDiarioLogicAdditional.checkFacturaDiarioToSavesAfter(facturadiarios,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFacturaDiarios();
			
			connexion.commit();		
			
			this.quitarFacturaDiariosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveFacturaDiarios()throws Exception {				
		 try {	
			FacturaDiarioLogicAdditional.checkFacturaDiarioToSaves(facturadiarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosFacturaDiario=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FacturaDiario facturadiarioLocal:facturadiarios) {				
				if(facturadiarioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FacturaDiarioLogicAdditional.updateFacturaDiarioToSave(facturadiarioLocal,this.arrDatoGeneral);
	        	
				FacturaDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),facturadiarioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFacturaDiario(facturadiarioLocal)) {				
					FacturaDiarioDataAccess.save(facturadiarioLocal, connexion);				
				} else {
					validadoTodosFacturaDiario=false;
				}
			}
			
			if(!validadoTodosFacturaDiario) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FacturaDiarioLogicAdditional.checkFacturaDiarioToSavesAfter(facturadiarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarFacturaDiariosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FacturaDiarioParameterReturnGeneral procesarAccionFacturaDiarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FacturaDiario> facturadiarios,FacturaDiarioParameterReturnGeneral facturadiarioParameterGeneral)throws Exception {
		 try {	
			FacturaDiarioParameterReturnGeneral facturadiarioReturnGeneral=new FacturaDiarioParameterReturnGeneral();
	
			FacturaDiarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,facturadiarios,facturadiarioParameterGeneral,facturadiarioReturnGeneral);
			
			return facturadiarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FacturaDiarioParameterReturnGeneral procesarAccionFacturaDiariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FacturaDiario> facturadiarios,FacturaDiarioParameterReturnGeneral facturadiarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaDiario.class.getSimpleName()+"-procesarAccionFacturaDiariosWithConnection");connexion.begin();			
			
			FacturaDiarioParameterReturnGeneral facturadiarioReturnGeneral=new FacturaDiarioParameterReturnGeneral();
	
			FacturaDiarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,facturadiarios,facturadiarioParameterGeneral,facturadiarioReturnGeneral);
			
			this.connexion.commit();
			
			return facturadiarioReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FacturaDiarioParameterReturnGeneral procesarEventosFacturaDiarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FacturaDiario> facturadiarios,FacturaDiario facturadiario,FacturaDiarioParameterReturnGeneral facturadiarioParameterGeneral,Boolean isEsNuevoFacturaDiario,ArrayList<Classe> clases)throws Exception {
		 try {	
			FacturaDiarioParameterReturnGeneral facturadiarioReturnGeneral=new FacturaDiarioParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				facturadiarioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FacturaDiarioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,facturadiarios,facturadiario,facturadiarioParameterGeneral,facturadiarioReturnGeneral,isEsNuevoFacturaDiario,clases);
			
			return facturadiarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public FacturaDiarioParameterReturnGeneral procesarEventosFacturaDiariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FacturaDiario> facturadiarios,FacturaDiario facturadiario,FacturaDiarioParameterReturnGeneral facturadiarioParameterGeneral,Boolean isEsNuevoFacturaDiario,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaDiario.class.getSimpleName()+"-procesarEventosFacturaDiariosWithConnection");connexion.begin();			
			
			FacturaDiarioParameterReturnGeneral facturadiarioReturnGeneral=new FacturaDiarioParameterReturnGeneral();
	
			facturadiarioReturnGeneral.setFacturaDiario(facturadiario);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				facturadiarioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FacturaDiarioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,facturadiarios,facturadiario,facturadiarioParameterGeneral,facturadiarioReturnGeneral,isEsNuevoFacturaDiario,clases);
			
			this.connexion.commit();
			
			return facturadiarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FacturaDiarioParameterReturnGeneral procesarImportacionFacturaDiariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,FacturaDiarioParameterReturnGeneral facturadiarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaDiario.class.getSimpleName()+"-procesarImportacionFacturaDiariosWithConnection");connexion.begin();			
			
			FacturaDiarioParameterReturnGeneral facturadiarioReturnGeneral=new FacturaDiarioParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.facturadiarios=new ArrayList<FacturaDiario>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.facturadiario=new FacturaDiario();
				
				
				if(conColumnasBase) {this.facturadiario.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.facturadiario.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.facturadiario.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.facturadiario.setfecha_vencimiento(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.facturadiario.setnumero_serie(arrColumnas[iColumn++]);
				this.facturadiario.setruc(arrColumnas[iColumn++]);
				this.facturadiario.setnumero_autoriza(arrColumnas[iColumn++]);
				this.facturadiario.setes_devolucion(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.facturadiario.setvalor_factura(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturadiario.setbase_imponible(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturadiario.setmonto_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.facturadiario.setbim_tarjeta(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.facturadiarios.add(this.facturadiario);
			}
			
			this.saveFacturaDiarios();
			
			this.connexion.commit();
			
			facturadiarioReturnGeneral.setConRetornoEstaProcesado(true);
			facturadiarioReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return facturadiarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarFacturaDiariosEliminados() throws Exception {				
		
		List<FacturaDiario> facturadiariosAux= new ArrayList<FacturaDiario>();
		
		for(FacturaDiario facturadiario:facturadiarios) {
			if(!facturadiario.getIsDeleted()) {
				facturadiariosAux.add(facturadiario);
			}
		}
		
		facturadiarios=facturadiariosAux;
	}
	
	public void quitarFacturaDiariosNulos() throws Exception {				
		
		List<FacturaDiario> facturadiariosAux= new ArrayList<FacturaDiario>();
		
		for(FacturaDiario facturadiario : this.facturadiarios) {
			if(facturadiario==null) {
				facturadiariosAux.add(facturadiario);
			}
		}
		
		//this.facturadiarios=facturadiariosAux;
		
		this.facturadiarios.removeAll(facturadiariosAux);
	}
	
	public void getSetVersionRowFacturaDiarioWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(facturadiario.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((facturadiario.getIsDeleted() || (facturadiario.getIsChanged()&&!facturadiario.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=facturadiarioDataAccess.getSetVersionRowFacturaDiario(connexion,facturadiario.getId());
				
				if(!facturadiario.getVersionRow().equals(timestamp)) {	
					facturadiario.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				facturadiario.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowFacturaDiario()throws Exception {	
		
		if(facturadiario.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((facturadiario.getIsDeleted() || (facturadiario.getIsChanged()&&!facturadiario.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=facturadiarioDataAccess.getSetVersionRowFacturaDiario(connexion,facturadiario.getId());
			
			try {							
				if(!facturadiario.getVersionRow().equals(timestamp)) {	
					facturadiario.setVersionRow(timestamp);
				}
				
				facturadiario.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowFacturaDiariosWithConnection()throws Exception {	
		if(facturadiarios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(FacturaDiario facturadiarioAux:facturadiarios) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(facturadiarioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(facturadiarioAux.getIsDeleted() || (facturadiarioAux.getIsChanged()&&!facturadiarioAux.getIsNew())) {
						
						timestamp=facturadiarioDataAccess.getSetVersionRowFacturaDiario(connexion,facturadiarioAux.getId());
						
						if(!facturadiario.getVersionRow().equals(timestamp)) {	
							facturadiarioAux.setVersionRow(timestamp);
						}
								
						facturadiarioAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowFacturaDiarios()throws Exception {	
		if(facturadiarios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(FacturaDiario facturadiarioAux:facturadiarios) {
					if(facturadiarioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(facturadiarioAux.getIsDeleted() || (facturadiarioAux.getIsChanged()&&!facturadiarioAux.getIsNew())) {
						
						timestamp=facturadiarioDataAccess.getSetVersionRowFacturaDiario(connexion,facturadiarioAux.getId());
						
						if(!facturadiarioAux.getVersionRow().equals(timestamp)) {	
							facturadiarioAux.setVersionRow(timestamp);
						}
						
													
						facturadiarioAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public FacturaDiarioParameterReturnGeneral cargarCombosLoteForeignKeyFacturaDiarioWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalCliente,String finalQueryGlobalPeriodoDeclara,String finalQueryGlobalTipoIva) throws Exception {
		FacturaDiarioParameterReturnGeneral  facturadiarioReturnGeneral =new FacturaDiarioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaDiario.class.getSimpleName()+"-cargarCombosLoteForeignKeyFacturaDiarioWithConnection");connexion.begin();
			
			facturadiarioReturnGeneral =new FacturaDiarioParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			facturadiarioReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			facturadiarioReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			facturadiarioReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<PeriodoDeclara> periododeclarasForeignKey=new ArrayList<PeriodoDeclara>();
			PeriodoDeclaraLogic periododeclaraLogic=new PeriodoDeclaraLogic();
			periododeclaraLogic.setConnexion(this.connexion);
			periododeclaraLogic.getPeriodoDeclaraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodoDeclara.equals("NONE")) {
				periododeclaraLogic.getTodosPeriodoDeclaras(finalQueryGlobalPeriodoDeclara,new Pagination());
				periododeclarasForeignKey=periododeclaraLogic.getPeriodoDeclaras();
			}

			facturadiarioReturnGeneral.setperiododeclarasForeignKey(periododeclarasForeignKey);


			List<TipoIva> tipoivasForeignKey=new ArrayList<TipoIva>();
			TipoIvaLogic tipoivaLogic=new TipoIvaLogic();
			tipoivaLogic.setConnexion(this.connexion);
			tipoivaLogic.getTipoIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIva.equals("NONE")) {
				tipoivaLogic.getTodosTipoIvas(finalQueryGlobalTipoIva,new Pagination());
				tipoivasForeignKey=tipoivaLogic.getTipoIvas();
			}

			facturadiarioReturnGeneral.settipoivasForeignKey(tipoivasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return facturadiarioReturnGeneral;
	}
	
	public FacturaDiarioParameterReturnGeneral cargarCombosLoteForeignKeyFacturaDiario(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalCliente,String finalQueryGlobalPeriodoDeclara,String finalQueryGlobalTipoIva) throws Exception {
		FacturaDiarioParameterReturnGeneral  facturadiarioReturnGeneral =new FacturaDiarioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			facturadiarioReturnGeneral =new FacturaDiarioParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			facturadiarioReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			facturadiarioReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			facturadiarioReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<PeriodoDeclara> periododeclarasForeignKey=new ArrayList<PeriodoDeclara>();
			PeriodoDeclaraLogic periododeclaraLogic=new PeriodoDeclaraLogic();
			periododeclaraLogic.setConnexion(this.connexion);
			periododeclaraLogic.getPeriodoDeclaraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodoDeclara.equals("NONE")) {
				periododeclaraLogic.getTodosPeriodoDeclaras(finalQueryGlobalPeriodoDeclara,new Pagination());
				periododeclarasForeignKey=periododeclaraLogic.getPeriodoDeclaras();
			}

			facturadiarioReturnGeneral.setperiododeclarasForeignKey(periododeclarasForeignKey);


			List<TipoIva> tipoivasForeignKey=new ArrayList<TipoIva>();
			TipoIvaLogic tipoivaLogic=new TipoIvaLogic();
			tipoivaLogic.setConnexion(this.connexion);
			tipoivaLogic.getTipoIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIva.equals("NONE")) {
				tipoivaLogic.getTodosTipoIvas(finalQueryGlobalTipoIva,new Pagination());
				tipoivasForeignKey=tipoivaLogic.getTipoIvas();
			}

			facturadiarioReturnGeneral.settipoivasForeignKey(tipoivasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return facturadiarioReturnGeneral;
	}
	
	
	public void deepLoad(FacturaDiario facturadiario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			FacturaDiarioLogicAdditional.updateFacturaDiarioToGet(facturadiario,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		facturadiario.setEmpresa(facturadiarioDataAccess.getEmpresa(connexion,facturadiario));
		facturadiario.setSucursal(facturadiarioDataAccess.getSucursal(connexion,facturadiario));
		facturadiario.setCliente(facturadiarioDataAccess.getCliente(connexion,facturadiario));
		facturadiario.setPeriodoDeclara(facturadiarioDataAccess.getPeriodoDeclara(connexion,facturadiario));
		facturadiario.setTipoIva(facturadiarioDataAccess.getTipoIva(connexion,facturadiario));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				facturadiario.setEmpresa(facturadiarioDataAccess.getEmpresa(connexion,facturadiario));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				facturadiario.setSucursal(facturadiarioDataAccess.getSucursal(connexion,facturadiario));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				facturadiario.setCliente(facturadiarioDataAccess.getCliente(connexion,facturadiario));
				continue;
			}

			if(clas.clas.equals(PeriodoDeclara.class)) {
				facturadiario.setPeriodoDeclara(facturadiarioDataAccess.getPeriodoDeclara(connexion,facturadiario));
				continue;
			}

			if(clas.clas.equals(TipoIva.class)) {
				facturadiario.setTipoIva(facturadiarioDataAccess.getTipoIva(connexion,facturadiario));
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
			facturadiario.setEmpresa(facturadiarioDataAccess.getEmpresa(connexion,facturadiario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturadiario.setSucursal(facturadiarioDataAccess.getSucursal(connexion,facturadiario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturadiario.setCliente(facturadiarioDataAccess.getCliente(connexion,facturadiario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PeriodoDeclara.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturadiario.setPeriodoDeclara(facturadiarioDataAccess.getPeriodoDeclara(connexion,facturadiario));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturadiario.setTipoIva(facturadiarioDataAccess.getTipoIva(connexion,facturadiario));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		facturadiario.setEmpresa(facturadiarioDataAccess.getEmpresa(connexion,facturadiario));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(facturadiario.getEmpresa(),isDeep,deepLoadType,clases);
				
		facturadiario.setSucursal(facturadiarioDataAccess.getSucursal(connexion,facturadiario));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(facturadiario.getSucursal(),isDeep,deepLoadType,clases);
				
		facturadiario.setCliente(facturadiarioDataAccess.getCliente(connexion,facturadiario));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(facturadiario.getCliente(),isDeep,deepLoadType,clases);
				
		facturadiario.setPeriodoDeclara(facturadiarioDataAccess.getPeriodoDeclara(connexion,facturadiario));
		PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
		periododeclaraLogic.deepLoad(facturadiario.getPeriodoDeclara(),isDeep,deepLoadType,clases);
				
		facturadiario.setTipoIva(facturadiarioDataAccess.getTipoIva(connexion,facturadiario));
		TipoIvaLogic tipoivaLogic= new TipoIvaLogic(connexion);
		tipoivaLogic.deepLoad(facturadiario.getTipoIva(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				facturadiario.setEmpresa(facturadiarioDataAccess.getEmpresa(connexion,facturadiario));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(facturadiario.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				facturadiario.setSucursal(facturadiarioDataAccess.getSucursal(connexion,facturadiario));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(facturadiario.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				facturadiario.setCliente(facturadiarioDataAccess.getCliente(connexion,facturadiario));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(facturadiario.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PeriodoDeclara.class)) {
				facturadiario.setPeriodoDeclara(facturadiarioDataAccess.getPeriodoDeclara(connexion,facturadiario));
				PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
				periododeclaraLogic.deepLoad(facturadiario.getPeriodoDeclara(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoIva.class)) {
				facturadiario.setTipoIva(facturadiarioDataAccess.getTipoIva(connexion,facturadiario));
				TipoIvaLogic tipoivaLogic= new TipoIvaLogic(connexion);
				tipoivaLogic.deepLoad(facturadiario.getTipoIva(),isDeep,deepLoadType,clases);				
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
			facturadiario.setEmpresa(facturadiarioDataAccess.getEmpresa(connexion,facturadiario));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(facturadiario.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturadiario.setSucursal(facturadiarioDataAccess.getSucursal(connexion,facturadiario));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(facturadiario.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturadiario.setCliente(facturadiarioDataAccess.getCliente(connexion,facturadiario));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(facturadiario.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PeriodoDeclara.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturadiario.setPeriodoDeclara(facturadiarioDataAccess.getPeriodoDeclara(connexion,facturadiario));
			PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
			periododeclaraLogic.deepLoad(facturadiario.getPeriodoDeclara(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturadiario.setTipoIva(facturadiarioDataAccess.getTipoIva(connexion,facturadiario));
			TipoIvaLogic tipoivaLogic= new TipoIvaLogic(connexion);
			tipoivaLogic.deepLoad(facturadiario.getTipoIva(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(FacturaDiario facturadiario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			FacturaDiarioLogicAdditional.updateFacturaDiarioToSave(facturadiario,this.arrDatoGeneral);
			
FacturaDiarioDataAccess.save(facturadiario, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(facturadiario.getEmpresa(),connexion);

		SucursalDataAccess.save(facturadiario.getSucursal(),connexion);

		ClienteDataAccess.save(facturadiario.getCliente(),connexion);

		PeriodoDeclaraDataAccess.save(facturadiario.getPeriodoDeclara(),connexion);

		TipoIvaDataAccess.save(facturadiario.getTipoIva(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(facturadiario.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(facturadiario.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(facturadiario.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(PeriodoDeclara.class)) {
				PeriodoDeclaraDataAccess.save(facturadiario.getPeriodoDeclara(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoIva.class)) {
				TipoIvaDataAccess.save(facturadiario.getTipoIva(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(facturadiario.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(facturadiario.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(facturadiario.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(facturadiario.getSucursal(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(facturadiario.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(facturadiario.getCliente(),isDeep,deepLoadType,clases);
				

		PeriodoDeclaraDataAccess.save(facturadiario.getPeriodoDeclara(),connexion);
		PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
		periododeclaraLogic.deepLoad(facturadiario.getPeriodoDeclara(),isDeep,deepLoadType,clases);
				

		TipoIvaDataAccess.save(facturadiario.getTipoIva(),connexion);
		TipoIvaLogic tipoivaLogic= new TipoIvaLogic(connexion);
		tipoivaLogic.deepLoad(facturadiario.getTipoIva(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(facturadiario.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(facturadiario.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(facturadiario.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(facturadiario.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(facturadiario.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(facturadiario.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PeriodoDeclara.class)) {
				PeriodoDeclaraDataAccess.save(facturadiario.getPeriodoDeclara(),connexion);
				PeriodoDeclaraLogic periododeclaraLogic= new PeriodoDeclaraLogic(connexion);
				periododeclaraLogic.deepSave(facturadiario.getPeriodoDeclara(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoIva.class)) {
				TipoIvaDataAccess.save(facturadiario.getTipoIva(),connexion);
				TipoIvaLogic tipoivaLogic= new TipoIvaLogic(connexion);
				tipoivaLogic.deepSave(facturadiario.getTipoIva(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(FacturaDiario.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(facturadiario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(facturadiario);
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
			this.deepLoad(this.facturadiario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(this.facturadiario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(FacturaDiario.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(facturadiarios!=null) {
				for(FacturaDiario facturadiario:facturadiarios) {
					this.deepLoad(facturadiario,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(facturadiarios);
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
			if(facturadiarios!=null) {
				for(FacturaDiario facturadiario:facturadiarios) {
					this.deepLoad(facturadiario,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(facturadiarios);
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
			this.getNewConnexionToDeep(FacturaDiario.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(facturadiario,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(FacturaDiario.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(facturadiarios!=null) {
				for(FacturaDiario facturadiario:facturadiarios) {
					this.deepSave(facturadiario,isDeep,deepLoadType,clases);
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
			if(facturadiarios!=null) {
				for(FacturaDiario facturadiario:facturadiarios) {
					this.deepSave(facturadiario,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getFacturaDiariosFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaDiario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,FacturaDiarioConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			FacturaDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturadiarios=facturadiarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(this.facturadiarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaDiariosFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,FacturaDiarioConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			FacturaDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturadiarios=facturadiarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(this.facturadiarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaDiariosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaDiario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FacturaDiarioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FacturaDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturadiarios=facturadiarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(this.facturadiarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaDiariosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FacturaDiarioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FacturaDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturadiarios=facturadiarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(this.facturadiarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaDiariosFK_IdPeriodoDeclaraWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo_declara)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaDiario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodoDeclara= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodoDeclara.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo_declara,FacturaDiarioConstantesFunciones.IDPERIODODECLARA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodoDeclara);

			FacturaDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodoDeclara","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturadiarios=facturadiarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(this.facturadiarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaDiariosFK_IdPeriodoDeclara(String sFinalQuery,Pagination pagination,Long id_periodo_declara)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodoDeclara= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodoDeclara.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo_declara,FacturaDiarioConstantesFunciones.IDPERIODODECLARA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodoDeclara);

			FacturaDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodoDeclara","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturadiarios=facturadiarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(this.facturadiarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaDiariosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaDiario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,FacturaDiarioConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			FacturaDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturadiarios=facturadiarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(this.facturadiarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaDiariosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,FacturaDiarioConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			FacturaDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturadiarios=facturadiarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(this.facturadiarios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaDiariosFK_IdTipoIvaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_iva)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaDiario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_iva,FacturaDiarioConstantesFunciones.IDTIPOIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIva);

			FacturaDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoIva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturadiarios=facturadiarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(this.facturadiarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaDiariosFK_IdTipoIva(String sFinalQuery,Pagination pagination,Long id_tipo_iva)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_iva,FacturaDiarioConstantesFunciones.IDTIPOIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIva);

			FacturaDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoIva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturadiarios=facturadiarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaDiarioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaDiario(this.facturadiarios);
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
			if(FacturaDiarioConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,FacturaDiarioDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,FacturaDiario facturadiario,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(FacturaDiarioConstantesFunciones.ISCONAUDITORIA) {
				if(facturadiario.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FacturaDiarioDataAccess.TABLENAME, facturadiario.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FacturaDiarioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FacturaDiarioLogic.registrarAuditoriaDetallesFacturaDiario(connexion,facturadiario,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(facturadiario.getIsDeleted()) {
					/*if(!facturadiario.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,FacturaDiarioDataAccess.TABLENAME, facturadiario.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////FacturaDiarioLogic.registrarAuditoriaDetallesFacturaDiario(connexion,facturadiario,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FacturaDiarioDataAccess.TABLENAME, facturadiario.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(facturadiario.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FacturaDiarioDataAccess.TABLENAME, facturadiario.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FacturaDiarioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FacturaDiarioLogic.registrarAuditoriaDetallesFacturaDiario(connexion,facturadiario,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesFacturaDiario(Connexion connexion,FacturaDiario facturadiario)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(facturadiario.getIsNew()||!facturadiario.getid_empresa().equals(facturadiario.getFacturaDiarioOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturadiario.getFacturaDiarioOriginal().getid_empresa()!=null)
				{
					strValorActual=facturadiario.getFacturaDiarioOriginal().getid_empresa().toString();
				}
				if(facturadiario.getid_empresa()!=null)
				{
					strValorNuevo=facturadiario.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaDiarioConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(facturadiario.getIsNew()||!facturadiario.getid_sucursal().equals(facturadiario.getFacturaDiarioOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturadiario.getFacturaDiarioOriginal().getid_sucursal()!=null)
				{
					strValorActual=facturadiario.getFacturaDiarioOriginal().getid_sucursal().toString();
				}
				if(facturadiario.getid_sucursal()!=null)
				{
					strValorNuevo=facturadiario.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaDiarioConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(facturadiario.getIsNew()||!facturadiario.getid_cliente().equals(facturadiario.getFacturaDiarioOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturadiario.getFacturaDiarioOriginal().getid_cliente()!=null)
				{
					strValorActual=facturadiario.getFacturaDiarioOriginal().getid_cliente().toString();
				}
				if(facturadiario.getid_cliente()!=null)
				{
					strValorNuevo=facturadiario.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaDiarioConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(facturadiario.getIsNew()||!facturadiario.getid_periodo_declara().equals(facturadiario.getFacturaDiarioOriginal().getid_periodo_declara()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturadiario.getFacturaDiarioOriginal().getid_periodo_declara()!=null)
				{
					strValorActual=facturadiario.getFacturaDiarioOriginal().getid_periodo_declara().toString();
				}
				if(facturadiario.getid_periodo_declara()!=null)
				{
					strValorNuevo=facturadiario.getid_periodo_declara().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaDiarioConstantesFunciones.IDPERIODODECLARA,strValorActual,strValorNuevo);
			}	
			
			if(facturadiario.getIsNew()||!facturadiario.getid_tipo_iva().equals(facturadiario.getFacturaDiarioOriginal().getid_tipo_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturadiario.getFacturaDiarioOriginal().getid_tipo_iva()!=null)
				{
					strValorActual=facturadiario.getFacturaDiarioOriginal().getid_tipo_iva().toString();
				}
				if(facturadiario.getid_tipo_iva()!=null)
				{
					strValorNuevo=facturadiario.getid_tipo_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaDiarioConstantesFunciones.IDTIPOIVA,strValorActual,strValorNuevo);
			}	
			
			if(facturadiario.getIsNew()||!facturadiario.getfecha_emision().equals(facturadiario.getFacturaDiarioOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturadiario.getFacturaDiarioOriginal().getfecha_emision()!=null)
				{
					strValorActual=facturadiario.getFacturaDiarioOriginal().getfecha_emision().toString();
				}
				if(facturadiario.getfecha_emision()!=null)
				{
					strValorNuevo=facturadiario.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaDiarioConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(facturadiario.getIsNew()||!facturadiario.getfecha_vencimiento().equals(facturadiario.getFacturaDiarioOriginal().getfecha_vencimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturadiario.getFacturaDiarioOriginal().getfecha_vencimiento()!=null)
				{
					strValorActual=facturadiario.getFacturaDiarioOriginal().getfecha_vencimiento().toString();
				}
				if(facturadiario.getfecha_vencimiento()!=null)
				{
					strValorNuevo=facturadiario.getfecha_vencimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaDiarioConstantesFunciones.FECHAVENCIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(facturadiario.getIsNew()||!facturadiario.getnumero_serie().equals(facturadiario.getFacturaDiarioOriginal().getnumero_serie()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturadiario.getFacturaDiarioOriginal().getnumero_serie()!=null)
				{
					strValorActual=facturadiario.getFacturaDiarioOriginal().getnumero_serie();
				}
				if(facturadiario.getnumero_serie()!=null)
				{
					strValorNuevo=facturadiario.getnumero_serie() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaDiarioConstantesFunciones.NUMEROSERIE,strValorActual,strValorNuevo);
			}	
			
			if(facturadiario.getIsNew()||!facturadiario.getruc().equals(facturadiario.getFacturaDiarioOriginal().getruc()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturadiario.getFacturaDiarioOriginal().getruc()!=null)
				{
					strValorActual=facturadiario.getFacturaDiarioOriginal().getruc();
				}
				if(facturadiario.getruc()!=null)
				{
					strValorNuevo=facturadiario.getruc() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaDiarioConstantesFunciones.RUC,strValorActual,strValorNuevo);
			}	
			
			if(facturadiario.getIsNew()||!facturadiario.getnumero_autoriza().equals(facturadiario.getFacturaDiarioOriginal().getnumero_autoriza()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturadiario.getFacturaDiarioOriginal().getnumero_autoriza()!=null)
				{
					strValorActual=facturadiario.getFacturaDiarioOriginal().getnumero_autoriza();
				}
				if(facturadiario.getnumero_autoriza()!=null)
				{
					strValorNuevo=facturadiario.getnumero_autoriza() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaDiarioConstantesFunciones.NUMEROAUTORIZA,strValorActual,strValorNuevo);
			}	
			
			if(facturadiario.getIsNew()||!facturadiario.getes_devolucion().equals(facturadiario.getFacturaDiarioOriginal().getes_devolucion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturadiario.getFacturaDiarioOriginal().getes_devolucion()!=null)
				{
					strValorActual=facturadiario.getFacturaDiarioOriginal().getes_devolucion().toString();
				}
				if(facturadiario.getes_devolucion()!=null)
				{
					strValorNuevo=facturadiario.getes_devolucion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaDiarioConstantesFunciones.ESDEVOLUCION,strValorActual,strValorNuevo);
			}	
			
			if(facturadiario.getIsNew()||!facturadiario.getvalor_factura().equals(facturadiario.getFacturaDiarioOriginal().getvalor_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturadiario.getFacturaDiarioOriginal().getvalor_factura()!=null)
				{
					strValorActual=facturadiario.getFacturaDiarioOriginal().getvalor_factura().toString();
				}
				if(facturadiario.getvalor_factura()!=null)
				{
					strValorNuevo=facturadiario.getvalor_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaDiarioConstantesFunciones.VALORFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(facturadiario.getIsNew()||!facturadiario.getbase_imponible().equals(facturadiario.getFacturaDiarioOriginal().getbase_imponible()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturadiario.getFacturaDiarioOriginal().getbase_imponible()!=null)
				{
					strValorActual=facturadiario.getFacturaDiarioOriginal().getbase_imponible().toString();
				}
				if(facturadiario.getbase_imponible()!=null)
				{
					strValorNuevo=facturadiario.getbase_imponible().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaDiarioConstantesFunciones.BASEIMPONIBLE,strValorActual,strValorNuevo);
			}	
			
			if(facturadiario.getIsNew()||!facturadiario.getmonto_iva().equals(facturadiario.getFacturaDiarioOriginal().getmonto_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturadiario.getFacturaDiarioOriginal().getmonto_iva()!=null)
				{
					strValorActual=facturadiario.getFacturaDiarioOriginal().getmonto_iva().toString();
				}
				if(facturadiario.getmonto_iva()!=null)
				{
					strValorNuevo=facturadiario.getmonto_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaDiarioConstantesFunciones.MONTOIVA,strValorActual,strValorNuevo);
			}	
			
			if(facturadiario.getIsNew()||!facturadiario.getbim_tarjeta().equals(facturadiario.getFacturaDiarioOriginal().getbim_tarjeta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturadiario.getFacturaDiarioOriginal().getbim_tarjeta()!=null)
				{
					strValorActual=facturadiario.getFacturaDiarioOriginal().getbim_tarjeta().toString();
				}
				if(facturadiario.getbim_tarjeta()!=null)
				{
					strValorNuevo=facturadiario.getbim_tarjeta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaDiarioConstantesFunciones.BIMTARJETA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveFacturaDiarioRelacionesWithConnection(FacturaDiario facturadiario) throws Exception {

		if(!facturadiario.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFacturaDiarioRelacionesBase(facturadiario,true);
		}
	}

	public void saveFacturaDiarioRelaciones(FacturaDiario facturadiario)throws Exception {

		if(!facturadiario.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFacturaDiarioRelacionesBase(facturadiario,false);
		}
	}

	public void saveFacturaDiarioRelacionesBase(FacturaDiario facturadiario,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("FacturaDiario-saveRelacionesWithConnection");}
	

			this.setFacturaDiario(facturadiario);

			if(FacturaDiarioLogicAdditional.validarSaveRelaciones(facturadiario,this)) {

				FacturaDiarioLogicAdditional.updateRelacionesToSave(facturadiario,this);

				if((facturadiario.getIsNew()||facturadiario.getIsChanged())&&!facturadiario.getIsDeleted()) {
					this.saveFacturaDiario();
					this.saveFacturaDiarioRelacionesDetalles();

				} else if(facturadiario.getIsDeleted()) {
					this.saveFacturaDiarioRelacionesDetalles();
					this.saveFacturaDiario();
				}

				FacturaDiarioLogicAdditional.updateRelacionesToSaveAfter(facturadiario,this);

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
	
	
	private void saveFacturaDiarioRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfFacturaDiario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FacturaDiarioConstantesFunciones.getClassesForeignKeysOfFacturaDiario(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFacturaDiario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FacturaDiarioConstantesFunciones.getClassesRelationshipsOfFacturaDiario(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
