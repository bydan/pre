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
import com.bydan.erp.nomina.util.DetalleFormularioRenta107ConstantesFunciones;
import com.bydan.erp.nomina.util.DetalleFormularioRenta107ParameterReturnGeneral;
//import com.bydan.erp.nomina.util.DetalleFormularioRenta107ParameterGeneral;
import com.bydan.erp.nomina.business.entity.DetalleFormularioRenta107;
import com.bydan.erp.nomina.business.logic.DetalleFormularioRenta107LogicAdditional;
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
public class DetalleFormularioRenta107Logic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleFormularioRenta107Logic.class);
	
	protected DetalleFormularioRenta107DataAccess detalleformulariorenta107DataAccess; 	
	protected DetalleFormularioRenta107 detalleformulariorenta107;
	protected List<DetalleFormularioRenta107> detalleformulariorenta107s;
	protected Object detalleformulariorenta107Object;	
	protected List<Object> detalleformulariorenta107sObject;
	
	public static ClassValidator<DetalleFormularioRenta107> detalleformulariorenta107Validator = new ClassValidator<DetalleFormularioRenta107>(DetalleFormularioRenta107.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleFormularioRenta107LogicAdditional detalleformulariorenta107LogicAdditional=null;
	
	public DetalleFormularioRenta107LogicAdditional getDetalleFormularioRenta107LogicAdditional() {
		return this.detalleformulariorenta107LogicAdditional;
	}
	
	public void setDetalleFormularioRenta107LogicAdditional(DetalleFormularioRenta107LogicAdditional detalleformulariorenta107LogicAdditional) {
		try {
			this.detalleformulariorenta107LogicAdditional=detalleformulariorenta107LogicAdditional;
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
	
	
	
	
	public  DetalleFormularioRenta107Logic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detalleformulariorenta107DataAccess = new DetalleFormularioRenta107DataAccess();
			
			this.detalleformulariorenta107s= new ArrayList<DetalleFormularioRenta107>();
			this.detalleformulariorenta107= new DetalleFormularioRenta107();
			
			this.detalleformulariorenta107Object=new Object();
			this.detalleformulariorenta107sObject=new ArrayList<Object>();
				
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
			
			this.detalleformulariorenta107DataAccess.setConnexionType(this.connexionType);
			this.detalleformulariorenta107DataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleFormularioRenta107Logic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detalleformulariorenta107DataAccess = new DetalleFormularioRenta107DataAccess();
			this.detalleformulariorenta107s= new ArrayList<DetalleFormularioRenta107>();
			this.detalleformulariorenta107= new DetalleFormularioRenta107();
			this.detalleformulariorenta107Object=new Object();
			this.detalleformulariorenta107sObject=new ArrayList<Object>();
			
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
			
			this.detalleformulariorenta107DataAccess.setConnexionType(this.connexionType);
			this.detalleformulariorenta107DataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleFormularioRenta107 getDetalleFormularioRenta107() throws Exception {	
		DetalleFormularioRenta107LogicAdditional.checkDetalleFormularioRenta107ToGet(detalleformulariorenta107,this.datosCliente,this.arrDatoGeneral);
		DetalleFormularioRenta107LogicAdditional.updateDetalleFormularioRenta107ToGet(detalleformulariorenta107,this.arrDatoGeneral);
		
		return detalleformulariorenta107;
	}
		
	public void setDetalleFormularioRenta107(DetalleFormularioRenta107 newDetalleFormularioRenta107) {
		this.detalleformulariorenta107 = newDetalleFormularioRenta107;
	}
	
	public DetalleFormularioRenta107DataAccess getDetalleFormularioRenta107DataAccess() {
		return detalleformulariorenta107DataAccess;
	}
	
	public void setDetalleFormularioRenta107DataAccess(DetalleFormularioRenta107DataAccess newdetalleformulariorenta107DataAccess) {
		this.detalleformulariorenta107DataAccess = newdetalleformulariorenta107DataAccess;
	}
	
	public List<DetalleFormularioRenta107> getDetalleFormularioRenta107s() throws Exception {		
		this.quitarDetalleFormularioRenta107sNulos();
		
		DetalleFormularioRenta107LogicAdditional.checkDetalleFormularioRenta107ToGets(detalleformulariorenta107s,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleFormularioRenta107 detalleformulariorenta107Local: detalleformulariorenta107s ) {
			DetalleFormularioRenta107LogicAdditional.updateDetalleFormularioRenta107ToGet(detalleformulariorenta107Local,this.arrDatoGeneral);
		}
		
		return detalleformulariorenta107s;
	}
	
	public void setDetalleFormularioRenta107s(List<DetalleFormularioRenta107> newDetalleFormularioRenta107s) {
		this.detalleformulariorenta107s = newDetalleFormularioRenta107s;
	}
	
	public Object getDetalleFormularioRenta107Object() {	
		this.detalleformulariorenta107Object=this.detalleformulariorenta107DataAccess.getEntityObject();
		return this.detalleformulariorenta107Object;
	}
		
	public void setDetalleFormularioRenta107Object(Object newDetalleFormularioRenta107Object) {
		this.detalleformulariorenta107Object = newDetalleFormularioRenta107Object;
	}
	
	public List<Object> getDetalleFormularioRenta107sObject() {		
		this.detalleformulariorenta107sObject=this.detalleformulariorenta107DataAccess.getEntitiesObject();
		return this.detalleformulariorenta107sObject;
	}
		
	public void setDetalleFormularioRenta107sObject(List<Object> newDetalleFormularioRenta107sObject) {
		this.detalleformulariorenta107sObject = newDetalleFormularioRenta107sObject;
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
		
		if(this.detalleformulariorenta107DataAccess!=null) {
			this.detalleformulariorenta107DataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFormularioRenta107.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detalleformulariorenta107DataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detalleformulariorenta107DataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detalleformulariorenta107 = new  DetalleFormularioRenta107();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFormularioRenta107.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleformulariorenta107=detalleformulariorenta107DataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleformulariorenta107,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleFormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFormularioRenta107(this.detalleformulariorenta107);
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
		detalleformulariorenta107 = new  DetalleFormularioRenta107();
		  		  
        try {
			
			detalleformulariorenta107=detalleformulariorenta107DataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleformulariorenta107,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleFormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFormularioRenta107(this.detalleformulariorenta107);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detalleformulariorenta107 = new  DetalleFormularioRenta107();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFormularioRenta107.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleformulariorenta107=detalleformulariorenta107DataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleformulariorenta107,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleFormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFormularioRenta107(this.detalleformulariorenta107);
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
		detalleformulariorenta107 = new  DetalleFormularioRenta107();
		  		  
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
		detalleformulariorenta107 = new  DetalleFormularioRenta107();
		  		  
        try {
			
			detalleformulariorenta107=detalleformulariorenta107DataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleformulariorenta107,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleFormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFormularioRenta107(this.detalleformulariorenta107);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detalleformulariorenta107 = new  DetalleFormularioRenta107();
		  		  
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
		detalleformulariorenta107 = new  DetalleFormularioRenta107();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFormularioRenta107.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detalleformulariorenta107DataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleformulariorenta107 = new  DetalleFormularioRenta107();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detalleformulariorenta107DataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleformulariorenta107 = new  DetalleFormularioRenta107();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFormularioRenta107.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detalleformulariorenta107DataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleformulariorenta107 = new  DetalleFormularioRenta107();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detalleformulariorenta107DataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleformulariorenta107 = new  DetalleFormularioRenta107();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFormularioRenta107.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detalleformulariorenta107DataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleformulariorenta107 = new  DetalleFormularioRenta107();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detalleformulariorenta107DataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleformulariorenta107s = new  ArrayList<DetalleFormularioRenta107>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFormularioRenta107.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleFormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleformulariorenta107s=detalleformulariorenta107DataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleFormularioRenta107(detalleformulariorenta107s);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFormularioRenta107(this.detalleformulariorenta107s);
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
		detalleformulariorenta107s = new  ArrayList<DetalleFormularioRenta107>();
		  		  
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
		detalleformulariorenta107s = new  ArrayList<DetalleFormularioRenta107>();
		  		  
        try {			
			DetalleFormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleformulariorenta107s=detalleformulariorenta107DataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleFormularioRenta107(detalleformulariorenta107s);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFormularioRenta107(this.detalleformulariorenta107s);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detalleformulariorenta107s = new  ArrayList<DetalleFormularioRenta107>();
		  		  
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
		detalleformulariorenta107s = new  ArrayList<DetalleFormularioRenta107>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFormularioRenta107.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleFormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleformulariorenta107s=detalleformulariorenta107DataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleFormularioRenta107(detalleformulariorenta107s);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFormularioRenta107(this.detalleformulariorenta107s);
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
		detalleformulariorenta107s = new  ArrayList<DetalleFormularioRenta107>();
		  		  
        try {
			DetalleFormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleformulariorenta107s=detalleformulariorenta107DataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleFormularioRenta107(detalleformulariorenta107s);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFormularioRenta107(this.detalleformulariorenta107s);
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
		detalleformulariorenta107s = new  ArrayList<DetalleFormularioRenta107>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFormularioRenta107.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleFormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleformulariorenta107s=detalleformulariorenta107DataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleFormularioRenta107(detalleformulariorenta107s);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFormularioRenta107(this.detalleformulariorenta107s);
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
		detalleformulariorenta107s = new  ArrayList<DetalleFormularioRenta107>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleFormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleformulariorenta107s=detalleformulariorenta107DataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleFormularioRenta107(detalleformulariorenta107s);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFormularioRenta107(this.detalleformulariorenta107s);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detalleformulariorenta107 = new  DetalleFormularioRenta107();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFormularioRenta107.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleFormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleformulariorenta107=detalleformulariorenta107DataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleFormularioRenta107(detalleformulariorenta107);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFormularioRenta107(this.detalleformulariorenta107);
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
		detalleformulariorenta107 = new  DetalleFormularioRenta107();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleFormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleformulariorenta107=detalleformulariorenta107DataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleFormularioRenta107(detalleformulariorenta107);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFormularioRenta107(this.detalleformulariorenta107);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleformulariorenta107s = new  ArrayList<DetalleFormularioRenta107>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFormularioRenta107.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleFormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleformulariorenta107s=detalleformulariorenta107DataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleFormularioRenta107(detalleformulariorenta107s);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFormularioRenta107(this.detalleformulariorenta107s);
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
		detalleformulariorenta107s = new  ArrayList<DetalleFormularioRenta107>();
		  		  
        try {
			DetalleFormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleformulariorenta107s=detalleformulariorenta107DataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleFormularioRenta107(detalleformulariorenta107s);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFormularioRenta107(this.detalleformulariorenta107s);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleFormularioRenta107sWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detalleformulariorenta107s = new  ArrayList<DetalleFormularioRenta107>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFormularioRenta107.class.getSimpleName()+"-getTodosDetalleFormularioRenta107sWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleFormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleformulariorenta107s=detalleformulariorenta107DataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleFormularioRenta107(detalleformulariorenta107s);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFormularioRenta107(this.detalleformulariorenta107s);
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
	
	public  void  getTodosDetalleFormularioRenta107s(String sFinalQuery,Pagination pagination)throws Exception {
		detalleformulariorenta107s = new  ArrayList<DetalleFormularioRenta107>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleFormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleformulariorenta107s=detalleformulariorenta107DataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleFormularioRenta107(detalleformulariorenta107s);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleFormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFormularioRenta107(this.detalleformulariorenta107s);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleFormularioRenta107(DetalleFormularioRenta107 detalleformulariorenta107) throws Exception {
		Boolean estaValidado=false;
		
		if(detalleformulariorenta107.getIsNew() || detalleformulariorenta107.getIsChanged()) { 
			this.invalidValues = detalleformulariorenta107Validator.getInvalidValues(detalleformulariorenta107);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detalleformulariorenta107);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleFormularioRenta107(List<DetalleFormularioRenta107> DetalleFormularioRenta107s) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleFormularioRenta107 detalleformulariorenta107Local:detalleformulariorenta107s) {				
			estaValidadoObjeto=this.validarGuardarDetalleFormularioRenta107(detalleformulariorenta107Local);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleFormularioRenta107(List<DetalleFormularioRenta107> DetalleFormularioRenta107s) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleFormularioRenta107(detalleformulariorenta107s)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleFormularioRenta107(DetalleFormularioRenta107 DetalleFormularioRenta107) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleFormularioRenta107(detalleformulariorenta107)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleFormularioRenta107 detalleformulariorenta107) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detalleformulariorenta107.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleFormularioRenta107ConstantesFunciones.getDetalleFormularioRenta107LabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detalleformulariorenta107","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleFormularioRenta107ConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleFormularioRenta107ConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleFormularioRenta107WithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFormularioRenta107.class.getSimpleName()+"-saveDetalleFormularioRenta107WithConnection");connexion.begin();			
			
			DetalleFormularioRenta107LogicAdditional.checkDetalleFormularioRenta107ToSave(this.detalleformulariorenta107,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleFormularioRenta107LogicAdditional.updateDetalleFormularioRenta107ToSave(this.detalleformulariorenta107,this.arrDatoGeneral);
			
			DetalleFormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleformulariorenta107,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleFormularioRenta107();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleFormularioRenta107(this.detalleformulariorenta107)) {
				DetalleFormularioRenta107DataAccess.save(this.detalleformulariorenta107, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detalleformulariorenta107,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleFormularioRenta107LogicAdditional.checkDetalleFormularioRenta107ToSaveAfter(this.detalleformulariorenta107,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleFormularioRenta107();
			
			connexion.commit();			
			
			if(this.detalleformulariorenta107.getIsDeleted()) {
				this.detalleformulariorenta107=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleFormularioRenta107()throws Exception {	
		try {	
			
			DetalleFormularioRenta107LogicAdditional.checkDetalleFormularioRenta107ToSave(this.detalleformulariorenta107,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleFormularioRenta107LogicAdditional.updateDetalleFormularioRenta107ToSave(this.detalleformulariorenta107,this.arrDatoGeneral);
			
			DetalleFormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleformulariorenta107,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleFormularioRenta107(this.detalleformulariorenta107)) {			
				DetalleFormularioRenta107DataAccess.save(this.detalleformulariorenta107, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detalleformulariorenta107,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleFormularioRenta107LogicAdditional.checkDetalleFormularioRenta107ToSaveAfter(this.detalleformulariorenta107,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detalleformulariorenta107.getIsDeleted()) {
				this.detalleformulariorenta107=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleFormularioRenta107sWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFormularioRenta107.class.getSimpleName()+"-saveDetalleFormularioRenta107sWithConnection");connexion.begin();			
			
			DetalleFormularioRenta107LogicAdditional.checkDetalleFormularioRenta107ToSaves(detalleformulariorenta107s,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleFormularioRenta107s();
			
			Boolean validadoTodosDetalleFormularioRenta107=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleFormularioRenta107 detalleformulariorenta107Local:detalleformulariorenta107s) {		
				if(detalleformulariorenta107Local.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleFormularioRenta107LogicAdditional.updateDetalleFormularioRenta107ToSave(detalleformulariorenta107Local,this.arrDatoGeneral);
	        	
				DetalleFormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleformulariorenta107Local,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleFormularioRenta107(detalleformulariorenta107Local)) {
					DetalleFormularioRenta107DataAccess.save(detalleformulariorenta107Local, connexion);				
				} else {
					validadoTodosDetalleFormularioRenta107=false;
				}
			}
			
			if(!validadoTodosDetalleFormularioRenta107) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleFormularioRenta107LogicAdditional.checkDetalleFormularioRenta107ToSavesAfter(detalleformulariorenta107s,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleFormularioRenta107s();
			
			connexion.commit();		
			
			this.quitarDetalleFormularioRenta107sEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleFormularioRenta107s()throws Exception {				
		 try {	
			DetalleFormularioRenta107LogicAdditional.checkDetalleFormularioRenta107ToSaves(detalleformulariorenta107s,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleFormularioRenta107=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleFormularioRenta107 detalleformulariorenta107Local:detalleformulariorenta107s) {				
				if(detalleformulariorenta107Local.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleFormularioRenta107LogicAdditional.updateDetalleFormularioRenta107ToSave(detalleformulariorenta107Local,this.arrDatoGeneral);
	        	
				DetalleFormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleformulariorenta107Local,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleFormularioRenta107(detalleformulariorenta107Local)) {				
					DetalleFormularioRenta107DataAccess.save(detalleformulariorenta107Local, connexion);				
				} else {
					validadoTodosDetalleFormularioRenta107=false;
				}
			}
			
			if(!validadoTodosDetalleFormularioRenta107) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleFormularioRenta107LogicAdditional.checkDetalleFormularioRenta107ToSavesAfter(detalleformulariorenta107s,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleFormularioRenta107sEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleFormularioRenta107ParameterReturnGeneral procesarAccionDetalleFormularioRenta107s(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleFormularioRenta107> detalleformulariorenta107s,DetalleFormularioRenta107ParameterReturnGeneral detalleformulariorenta107ParameterGeneral)throws Exception {
		 try {	
			DetalleFormularioRenta107ParameterReturnGeneral detalleformulariorenta107ReturnGeneral=new DetalleFormularioRenta107ParameterReturnGeneral();
	
			DetalleFormularioRenta107LogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleformulariorenta107s,detalleformulariorenta107ParameterGeneral,detalleformulariorenta107ReturnGeneral);
			
			return detalleformulariorenta107ReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleFormularioRenta107ParameterReturnGeneral procesarAccionDetalleFormularioRenta107sWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleFormularioRenta107> detalleformulariorenta107s,DetalleFormularioRenta107ParameterReturnGeneral detalleformulariorenta107ParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFormularioRenta107.class.getSimpleName()+"-procesarAccionDetalleFormularioRenta107sWithConnection");connexion.begin();			
			
			DetalleFormularioRenta107ParameterReturnGeneral detalleformulariorenta107ReturnGeneral=new DetalleFormularioRenta107ParameterReturnGeneral();
	
			DetalleFormularioRenta107LogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleformulariorenta107s,detalleformulariorenta107ParameterGeneral,detalleformulariorenta107ReturnGeneral);
			
			this.connexion.commit();
			
			return detalleformulariorenta107ReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleFormularioRenta107ParameterReturnGeneral procesarEventosDetalleFormularioRenta107s(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleFormularioRenta107> detalleformulariorenta107s,DetalleFormularioRenta107 detalleformulariorenta107,DetalleFormularioRenta107ParameterReturnGeneral detalleformulariorenta107ParameterGeneral,Boolean isEsNuevoDetalleFormularioRenta107,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleFormularioRenta107ParameterReturnGeneral detalleformulariorenta107ReturnGeneral=new DetalleFormularioRenta107ParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleformulariorenta107ReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleFormularioRenta107LogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleformulariorenta107s,detalleformulariorenta107,detalleformulariorenta107ParameterGeneral,detalleformulariorenta107ReturnGeneral,isEsNuevoDetalleFormularioRenta107,clases);
			
			return detalleformulariorenta107ReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleFormularioRenta107ParameterReturnGeneral procesarEventosDetalleFormularioRenta107sWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleFormularioRenta107> detalleformulariorenta107s,DetalleFormularioRenta107 detalleformulariorenta107,DetalleFormularioRenta107ParameterReturnGeneral detalleformulariorenta107ParameterGeneral,Boolean isEsNuevoDetalleFormularioRenta107,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFormularioRenta107.class.getSimpleName()+"-procesarEventosDetalleFormularioRenta107sWithConnection");connexion.begin();			
			
			DetalleFormularioRenta107ParameterReturnGeneral detalleformulariorenta107ReturnGeneral=new DetalleFormularioRenta107ParameterReturnGeneral();
	
			detalleformulariorenta107ReturnGeneral.setDetalleFormularioRenta107(detalleformulariorenta107);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleformulariorenta107ReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleFormularioRenta107LogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleformulariorenta107s,detalleformulariorenta107,detalleformulariorenta107ParameterGeneral,detalleformulariorenta107ReturnGeneral,isEsNuevoDetalleFormularioRenta107,clases);
			
			this.connexion.commit();
			
			return detalleformulariorenta107ReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleFormularioRenta107ParameterReturnGeneral procesarImportacionDetalleFormularioRenta107sWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleFormularioRenta107ParameterReturnGeneral detalleformulariorenta107ParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFormularioRenta107.class.getSimpleName()+"-procesarImportacionDetalleFormularioRenta107sWithConnection");connexion.begin();			
			
			DetalleFormularioRenta107ParameterReturnGeneral detalleformulariorenta107ReturnGeneral=new DetalleFormularioRenta107ParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detalleformulariorenta107s=new ArrayList<DetalleFormularioRenta107>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detalleformulariorenta107=new DetalleFormularioRenta107();
				
				
				if(conColumnasBase) {this.detalleformulariorenta107.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detalleformulariorenta107.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detalleformulariorenta107.setsueldos_301(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleformulariorenta107.setsobre_sueldos_303(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleformulariorenta107.setdecimo_tercero_305(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleformulariorenta107.setdecimo_cuarto_307(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleformulariorenta107.setfondo_reserva_309(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleformulariorenta107.setutilidades_311(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleformulariorenta107.setdesahucio_313(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleformulariorenta107.setiess_personal_315(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleformulariorenta107.setgastos_vivienda_317(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleformulariorenta107.setgastos_salud_319(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleformulariorenta107.setgastos_educacion_321(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleformulariorenta107.setgastos_alimentacion_323(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleformulariorenta107.setgastos_vestimenta_325(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleformulariorenta107.setdescuento_discapacidad_327(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleformulariorenta107.setdescuento_tercera_edad_329(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleformulariorenta107.setasume_empleador_331(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleformulariorenta107.setsub_empleador_351(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleformulariorenta107.setnumero_meses_trabajados_353(Integer.parseInt(arrColumnas[iColumn++]));
				this.detalleformulariorenta107.setingreso_otros_empleadores_401(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleformulariorenta107.setdeduccion_gastos_otros_empleadores_403(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleformulariorenta107.setrebajas_otros_empleadores_405(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleformulariorenta107.setbase_imponible_anual_407(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleformulariorenta107.setimpuesto_causado_409(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleformulariorenta107.setimpuesto_retenido_empleador_411(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleformulariorenta107.setimpuesto_retenido_otros_empleadores_413(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.detalleformulariorenta107s.add(this.detalleformulariorenta107);
			}
			
			this.saveDetalleFormularioRenta107s();
			
			this.connexion.commit();
			
			detalleformulariorenta107ReturnGeneral.setConRetornoEstaProcesado(true);
			detalleformulariorenta107ReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detalleformulariorenta107ReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleFormularioRenta107sEliminados() throws Exception {				
		
		List<DetalleFormularioRenta107> detalleformulariorenta107sAux= new ArrayList<DetalleFormularioRenta107>();
		
		for(DetalleFormularioRenta107 detalleformulariorenta107:detalleformulariorenta107s) {
			if(!detalleformulariorenta107.getIsDeleted()) {
				detalleformulariorenta107sAux.add(detalleformulariorenta107);
			}
		}
		
		detalleformulariorenta107s=detalleformulariorenta107sAux;
	}
	
	public void quitarDetalleFormularioRenta107sNulos() throws Exception {				
		
		List<DetalleFormularioRenta107> detalleformulariorenta107sAux= new ArrayList<DetalleFormularioRenta107>();
		
		for(DetalleFormularioRenta107 detalleformulariorenta107 : this.detalleformulariorenta107s) {
			if(detalleformulariorenta107==null) {
				detalleformulariorenta107sAux.add(detalleformulariorenta107);
			}
		}
		
		//this.detalleformulariorenta107s=detalleformulariorenta107sAux;
		
		this.detalleformulariorenta107s.removeAll(detalleformulariorenta107sAux);
	}
	
	public void getSetVersionRowDetalleFormularioRenta107WithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detalleformulariorenta107.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detalleformulariorenta107.getIsDeleted() || (detalleformulariorenta107.getIsChanged()&&!detalleformulariorenta107.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detalleformulariorenta107DataAccess.getSetVersionRowDetalleFormularioRenta107(connexion,detalleformulariorenta107.getId());
				
				if(!detalleformulariorenta107.getVersionRow().equals(timestamp)) {	
					detalleformulariorenta107.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detalleformulariorenta107.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleFormularioRenta107()throws Exception {	
		
		if(detalleformulariorenta107.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detalleformulariorenta107.getIsDeleted() || (detalleformulariorenta107.getIsChanged()&&!detalleformulariorenta107.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detalleformulariorenta107DataAccess.getSetVersionRowDetalleFormularioRenta107(connexion,detalleformulariorenta107.getId());
			
			try {							
				if(!detalleformulariorenta107.getVersionRow().equals(timestamp)) {	
					detalleformulariorenta107.setVersionRow(timestamp);
				}
				
				detalleformulariorenta107.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleFormularioRenta107sWithConnection()throws Exception {	
		if(detalleformulariorenta107s!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleFormularioRenta107 detalleformulariorenta107Aux:detalleformulariorenta107s) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detalleformulariorenta107Aux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleformulariorenta107Aux.getIsDeleted() || (detalleformulariorenta107Aux.getIsChanged()&&!detalleformulariorenta107Aux.getIsNew())) {
						
						timestamp=detalleformulariorenta107DataAccess.getSetVersionRowDetalleFormularioRenta107(connexion,detalleformulariorenta107Aux.getId());
						
						if(!detalleformulariorenta107.getVersionRow().equals(timestamp)) {	
							detalleformulariorenta107Aux.setVersionRow(timestamp);
						}
								
						detalleformulariorenta107Aux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleFormularioRenta107s()throws Exception {	
		if(detalleformulariorenta107s!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleFormularioRenta107 detalleformulariorenta107Aux:detalleformulariorenta107s) {
					if(detalleformulariorenta107Aux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleformulariorenta107Aux.getIsDeleted() || (detalleformulariorenta107Aux.getIsChanged()&&!detalleformulariorenta107Aux.getIsNew())) {
						
						timestamp=detalleformulariorenta107DataAccess.getSetVersionRowDetalleFormularioRenta107(connexion,detalleformulariorenta107Aux.getId());
						
						if(!detalleformulariorenta107Aux.getVersionRow().equals(timestamp)) {	
							detalleformulariorenta107Aux.setVersionRow(timestamp);
						}
						
													
						detalleformulariorenta107Aux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleFormularioRenta107ParameterReturnGeneral cargarCombosLoteForeignKeyDetalleFormularioRenta107WithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalFormularioRenta107,String finalQueryGlobalEjercicio) throws Exception {
		DetalleFormularioRenta107ParameterReturnGeneral  detalleformulariorenta107ReturnGeneral =new DetalleFormularioRenta107ParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFormularioRenta107.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleFormularioRenta107WithConnection");connexion.begin();
			
			detalleformulariorenta107ReturnGeneral =new DetalleFormularioRenta107ParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleformulariorenta107ReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			detalleformulariorenta107ReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<FormularioRenta107> formulariorenta107sForeignKey=new ArrayList<FormularioRenta107>();
			FormularioRenta107Logic formulariorenta107Logic=new FormularioRenta107Logic();
			formulariorenta107Logic.setConnexion(this.connexion);
			formulariorenta107Logic.getFormularioRenta107DataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormularioRenta107.equals("NONE")) {
				formulariorenta107Logic.getTodosFormularioRenta107s(finalQueryGlobalFormularioRenta107,new Pagination());
				formulariorenta107sForeignKey=formulariorenta107Logic.getFormularioRenta107s();
			}

			detalleformulariorenta107ReturnGeneral.setformulariorenta107sForeignKey(formulariorenta107sForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detalleformulariorenta107ReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detalleformulariorenta107ReturnGeneral;
	}
	
	public DetalleFormularioRenta107ParameterReturnGeneral cargarCombosLoteForeignKeyDetalleFormularioRenta107(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalFormularioRenta107,String finalQueryGlobalEjercicio) throws Exception {
		DetalleFormularioRenta107ParameterReturnGeneral  detalleformulariorenta107ReturnGeneral =new DetalleFormularioRenta107ParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detalleformulariorenta107ReturnGeneral =new DetalleFormularioRenta107ParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleformulariorenta107ReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			detalleformulariorenta107ReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<FormularioRenta107> formulariorenta107sForeignKey=new ArrayList<FormularioRenta107>();
			FormularioRenta107Logic formulariorenta107Logic=new FormularioRenta107Logic();
			formulariorenta107Logic.setConnexion(this.connexion);
			formulariorenta107Logic.getFormularioRenta107DataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormularioRenta107.equals("NONE")) {
				formulariorenta107Logic.getTodosFormularioRenta107s(finalQueryGlobalFormularioRenta107,new Pagination());
				formulariorenta107sForeignKey=formulariorenta107Logic.getFormularioRenta107s();
			}

			detalleformulariorenta107ReturnGeneral.setformulariorenta107sForeignKey(formulariorenta107sForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detalleformulariorenta107ReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detalleformulariorenta107ReturnGeneral;
	}
	
	
	public void deepLoad(DetalleFormularioRenta107 detalleformulariorenta107,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleFormularioRenta107LogicAdditional.updateDetalleFormularioRenta107ToGet(detalleformulariorenta107,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleformulariorenta107.setEmpresa(detalleformulariorenta107DataAccess.getEmpresa(connexion,detalleformulariorenta107));
		detalleformulariorenta107.setEmpleado(detalleformulariorenta107DataAccess.getEmpleado(connexion,detalleformulariorenta107));
		detalleformulariorenta107.setFormularioRenta107(detalleformulariorenta107DataAccess.getFormularioRenta107(connexion,detalleformulariorenta107));
		detalleformulariorenta107.setEjercicio(detalleformulariorenta107DataAccess.getEjercicio(connexion,detalleformulariorenta107));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalleformulariorenta107.setEmpresa(detalleformulariorenta107DataAccess.getEmpresa(connexion,detalleformulariorenta107));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				detalleformulariorenta107.setEmpleado(detalleformulariorenta107DataAccess.getEmpleado(connexion,detalleformulariorenta107));
				continue;
			}

			if(clas.clas.equals(FormularioRenta107.class)) {
				detalleformulariorenta107.setFormularioRenta107(detalleformulariorenta107DataAccess.getFormularioRenta107(connexion,detalleformulariorenta107));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detalleformulariorenta107.setEjercicio(detalleformulariorenta107DataAccess.getEjercicio(connexion,detalleformulariorenta107));
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
			detalleformulariorenta107.setEmpresa(detalleformulariorenta107DataAccess.getEmpresa(connexion,detalleformulariorenta107));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleformulariorenta107.setEmpleado(detalleformulariorenta107DataAccess.getEmpleado(connexion,detalleformulariorenta107));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormularioRenta107.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleformulariorenta107.setFormularioRenta107(detalleformulariorenta107DataAccess.getFormularioRenta107(connexion,detalleformulariorenta107));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleformulariorenta107.setEjercicio(detalleformulariorenta107DataAccess.getEjercicio(connexion,detalleformulariorenta107));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleformulariorenta107.setEmpresa(detalleformulariorenta107DataAccess.getEmpresa(connexion,detalleformulariorenta107));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleformulariorenta107.getEmpresa(),isDeep,deepLoadType,clases);
				
		detalleformulariorenta107.setEmpleado(detalleformulariorenta107DataAccess.getEmpleado(connexion,detalleformulariorenta107));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(detalleformulariorenta107.getEmpleado(),isDeep,deepLoadType,clases);
				
		detalleformulariorenta107.setFormularioRenta107(detalleformulariorenta107DataAccess.getFormularioRenta107(connexion,detalleformulariorenta107));
		FormularioRenta107Logic formulariorenta107Logic= new FormularioRenta107Logic(connexion);
		formulariorenta107Logic.deepLoad(detalleformulariorenta107.getFormularioRenta107(),isDeep,deepLoadType,clases);
				
		detalleformulariorenta107.setEjercicio(detalleformulariorenta107DataAccess.getEjercicio(connexion,detalleformulariorenta107));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detalleformulariorenta107.getEjercicio(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalleformulariorenta107.setEmpresa(detalleformulariorenta107DataAccess.getEmpresa(connexion,detalleformulariorenta107));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detalleformulariorenta107.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				detalleformulariorenta107.setEmpleado(detalleformulariorenta107DataAccess.getEmpleado(connexion,detalleformulariorenta107));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(detalleformulariorenta107.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FormularioRenta107.class)) {
				detalleformulariorenta107.setFormularioRenta107(detalleformulariorenta107DataAccess.getFormularioRenta107(connexion,detalleformulariorenta107));
				FormularioRenta107Logic formulariorenta107Logic= new FormularioRenta107Logic(connexion);
				formulariorenta107Logic.deepLoad(detalleformulariorenta107.getFormularioRenta107(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detalleformulariorenta107.setEjercicio(detalleformulariorenta107DataAccess.getEjercicio(connexion,detalleformulariorenta107));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(detalleformulariorenta107.getEjercicio(),isDeep,deepLoadType,clases);				
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
			detalleformulariorenta107.setEmpresa(detalleformulariorenta107DataAccess.getEmpresa(connexion,detalleformulariorenta107));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detalleformulariorenta107.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleformulariorenta107.setEmpleado(detalleformulariorenta107DataAccess.getEmpleado(connexion,detalleformulariorenta107));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(detalleformulariorenta107.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(FormularioRenta107.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleformulariorenta107.setFormularioRenta107(detalleformulariorenta107DataAccess.getFormularioRenta107(connexion,detalleformulariorenta107));
			FormularioRenta107Logic formulariorenta107Logic= new FormularioRenta107Logic(connexion);
			formulariorenta107Logic.deepLoad(detalleformulariorenta107.getFormularioRenta107(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleformulariorenta107.setEjercicio(detalleformulariorenta107DataAccess.getEjercicio(connexion,detalleformulariorenta107));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(detalleformulariorenta107.getEjercicio(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleFormularioRenta107 detalleformulariorenta107,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleFormularioRenta107LogicAdditional.updateDetalleFormularioRenta107ToSave(detalleformulariorenta107,this.arrDatoGeneral);
			
DetalleFormularioRenta107DataAccess.save(detalleformulariorenta107, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalleformulariorenta107.getEmpresa(),connexion);

		EmpleadoDataAccess.save(detalleformulariorenta107.getEmpleado(),connexion);

		FormularioRenta107DataAccess.save(detalleformulariorenta107.getFormularioRenta107(),connexion);

		EjercicioDataAccess.save(detalleformulariorenta107.getEjercicio(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleformulariorenta107.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(detalleformulariorenta107.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(FormularioRenta107.class)) {
				FormularioRenta107DataAccess.save(detalleformulariorenta107.getFormularioRenta107(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detalleformulariorenta107.getEjercicio(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalleformulariorenta107.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleformulariorenta107.getEmpresa(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(detalleformulariorenta107.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(detalleformulariorenta107.getEmpleado(),isDeep,deepLoadType,clases);
				

		FormularioRenta107DataAccess.save(detalleformulariorenta107.getFormularioRenta107(),connexion);
		FormularioRenta107Logic formulariorenta107Logic= new FormularioRenta107Logic(connexion);
		formulariorenta107Logic.deepLoad(detalleformulariorenta107.getFormularioRenta107(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(detalleformulariorenta107.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detalleformulariorenta107.getEjercicio(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleformulariorenta107.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detalleformulariorenta107.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(detalleformulariorenta107.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(detalleformulariorenta107.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FormularioRenta107.class)) {
				FormularioRenta107DataAccess.save(detalleformulariorenta107.getFormularioRenta107(),connexion);
				FormularioRenta107Logic formulariorenta107Logic= new FormularioRenta107Logic(connexion);
				formulariorenta107Logic.deepSave(detalleformulariorenta107.getFormularioRenta107(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detalleformulariorenta107.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(detalleformulariorenta107.getEjercicio(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleFormularioRenta107.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detalleformulariorenta107,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleFormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFormularioRenta107(detalleformulariorenta107);
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
			this.deepLoad(this.detalleformulariorenta107,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleFormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFormularioRenta107(this.detalleformulariorenta107);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleFormularioRenta107.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detalleformulariorenta107s!=null) {
				for(DetalleFormularioRenta107 detalleformulariorenta107:detalleformulariorenta107s) {
					this.deepLoad(detalleformulariorenta107,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleFormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFormularioRenta107(detalleformulariorenta107s);
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
			if(detalleformulariorenta107s!=null) {
				for(DetalleFormularioRenta107 detalleformulariorenta107:detalleformulariorenta107s) {
					this.deepLoad(detalleformulariorenta107,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleFormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFormularioRenta107(detalleformulariorenta107s);
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
			this.getNewConnexionToDeep(DetalleFormularioRenta107.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detalleformulariorenta107,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleFormularioRenta107.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detalleformulariorenta107s!=null) {
				for(DetalleFormularioRenta107 detalleformulariorenta107:detalleformulariorenta107s) {
					this.deepSave(detalleformulariorenta107,isDeep,deepLoadType,clases);
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
			if(detalleformulariorenta107s!=null) {
				for(DetalleFormularioRenta107 detalleformulariorenta107:detalleformulariorenta107s) {
					this.deepSave(detalleformulariorenta107,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleFormularioRenta107sFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFormularioRenta107.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleFormularioRenta107ConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleFormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleformulariorenta107s=detalleformulariorenta107DataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFormularioRenta107(this.detalleformulariorenta107s);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleFormularioRenta107sFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleFormularioRenta107ConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleFormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleformulariorenta107s=detalleformulariorenta107DataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFormularioRenta107(this.detalleformulariorenta107s);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleFormularioRenta107sFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFormularioRenta107.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,DetalleFormularioRenta107ConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			DetalleFormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleformulariorenta107s=detalleformulariorenta107DataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFormularioRenta107(this.detalleformulariorenta107s);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleFormularioRenta107sFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,DetalleFormularioRenta107ConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			DetalleFormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleformulariorenta107s=detalleformulariorenta107DataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFormularioRenta107(this.detalleformulariorenta107s);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleFormularioRenta107sFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFormularioRenta107.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleFormularioRenta107ConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleFormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleformulariorenta107s=detalleformulariorenta107DataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFormularioRenta107(this.detalleformulariorenta107s);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleFormularioRenta107sFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleFormularioRenta107ConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleFormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleformulariorenta107s=detalleformulariorenta107DataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFormularioRenta107(this.detalleformulariorenta107s);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleFormularioRenta107sFK_IdFormularioRenta107WithConnection(String sFinalQuery,Pagination pagination,Long id_formulario_renta107)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleFormularioRenta107.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormularioRenta107= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormularioRenta107.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formulario_renta107,DetalleFormularioRenta107ConstantesFunciones.IDFORMULARIORENTA107,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormularioRenta107);

			DetalleFormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormularioRenta107","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleformulariorenta107s=detalleformulariorenta107DataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFormularioRenta107(this.detalleformulariorenta107s);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleFormularioRenta107sFK_IdFormularioRenta107(String sFinalQuery,Pagination pagination,Long id_formulario_renta107)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormularioRenta107= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormularioRenta107.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formulario_renta107,DetalleFormularioRenta107ConstantesFunciones.IDFORMULARIORENTA107,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormularioRenta107);

			DetalleFormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormularioRenta107","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleformulariorenta107s=detalleformulariorenta107DataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleFormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFormularioRenta107(this.detalleformulariorenta107s);
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
			if(DetalleFormularioRenta107ConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleFormularioRenta107DataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleFormularioRenta107 detalleformulariorenta107,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleFormularioRenta107ConstantesFunciones.ISCONAUDITORIA) {
				if(detalleformulariorenta107.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleFormularioRenta107DataAccess.TABLENAME, detalleformulariorenta107.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleFormularioRenta107ConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleFormularioRenta107Logic.registrarAuditoriaDetallesDetalleFormularioRenta107(connexion,detalleformulariorenta107,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detalleformulariorenta107.getIsDeleted()) {
					/*if(!detalleformulariorenta107.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleFormularioRenta107DataAccess.TABLENAME, detalleformulariorenta107.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleFormularioRenta107Logic.registrarAuditoriaDetallesDetalleFormularioRenta107(connexion,detalleformulariorenta107,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleFormularioRenta107DataAccess.TABLENAME, detalleformulariorenta107.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detalleformulariorenta107.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleFormularioRenta107DataAccess.TABLENAME, detalleformulariorenta107.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleFormularioRenta107ConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleFormularioRenta107Logic.registrarAuditoriaDetallesDetalleFormularioRenta107(connexion,detalleformulariorenta107,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleFormularioRenta107(Connexion connexion,DetalleFormularioRenta107 detalleformulariorenta107)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detalleformulariorenta107.getIsNew()||!detalleformulariorenta107.getid_empresa().equals(detalleformulariorenta107.getDetalleFormularioRenta107Original().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleformulariorenta107.getDetalleFormularioRenta107Original().getid_empresa()!=null)
				{
					strValorActual=detalleformulariorenta107.getDetalleFormularioRenta107Original().getid_empresa().toString();
				}
				if(detalleformulariorenta107.getid_empresa()!=null)
				{
					strValorNuevo=detalleformulariorenta107.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFormularioRenta107ConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detalleformulariorenta107.getIsNew()||!detalleformulariorenta107.getid_empleado().equals(detalleformulariorenta107.getDetalleFormularioRenta107Original().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleformulariorenta107.getDetalleFormularioRenta107Original().getid_empleado()!=null)
				{
					strValorActual=detalleformulariorenta107.getDetalleFormularioRenta107Original().getid_empleado().toString();
				}
				if(detalleformulariorenta107.getid_empleado()!=null)
				{
					strValorNuevo=detalleformulariorenta107.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFormularioRenta107ConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(detalleformulariorenta107.getIsNew()||!detalleformulariorenta107.getid_formulario_renta107().equals(detalleformulariorenta107.getDetalleFormularioRenta107Original().getid_formulario_renta107()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleformulariorenta107.getDetalleFormularioRenta107Original().getid_formulario_renta107()!=null)
				{
					strValorActual=detalleformulariorenta107.getDetalleFormularioRenta107Original().getid_formulario_renta107().toString();
				}
				if(detalleformulariorenta107.getid_formulario_renta107()!=null)
				{
					strValorNuevo=detalleformulariorenta107.getid_formulario_renta107().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFormularioRenta107ConstantesFunciones.IDFORMULARIORENTA107,strValorActual,strValorNuevo);
			}	
			
			if(detalleformulariorenta107.getIsNew()||!detalleformulariorenta107.getid_ejercicio().equals(detalleformulariorenta107.getDetalleFormularioRenta107Original().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleformulariorenta107.getDetalleFormularioRenta107Original().getid_ejercicio()!=null)
				{
					strValorActual=detalleformulariorenta107.getDetalleFormularioRenta107Original().getid_ejercicio().toString();
				}
				if(detalleformulariorenta107.getid_ejercicio()!=null)
				{
					strValorNuevo=detalleformulariorenta107.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFormularioRenta107ConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(detalleformulariorenta107.getIsNew()||!detalleformulariorenta107.getsueldos_301().equals(detalleformulariorenta107.getDetalleFormularioRenta107Original().getsueldos_301()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleformulariorenta107.getDetalleFormularioRenta107Original().getsueldos_301()!=null)
				{
					strValorActual=detalleformulariorenta107.getDetalleFormularioRenta107Original().getsueldos_301().toString();
				}
				if(detalleformulariorenta107.getsueldos_301()!=null)
				{
					strValorNuevo=detalleformulariorenta107.getsueldos_301().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFormularioRenta107ConstantesFunciones.SUELDOS_301,strValorActual,strValorNuevo);
			}	
			
			if(detalleformulariorenta107.getIsNew()||!detalleformulariorenta107.getsobre_sueldos_303().equals(detalleformulariorenta107.getDetalleFormularioRenta107Original().getsobre_sueldos_303()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleformulariorenta107.getDetalleFormularioRenta107Original().getsobre_sueldos_303()!=null)
				{
					strValorActual=detalleformulariorenta107.getDetalleFormularioRenta107Original().getsobre_sueldos_303().toString();
				}
				if(detalleformulariorenta107.getsobre_sueldos_303()!=null)
				{
					strValorNuevo=detalleformulariorenta107.getsobre_sueldos_303().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFormularioRenta107ConstantesFunciones.SOBRESUELDOS_303,strValorActual,strValorNuevo);
			}	
			
			if(detalleformulariorenta107.getIsNew()||!detalleformulariorenta107.getdecimo_tercero_305().equals(detalleformulariorenta107.getDetalleFormularioRenta107Original().getdecimo_tercero_305()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleformulariorenta107.getDetalleFormularioRenta107Original().getdecimo_tercero_305()!=null)
				{
					strValorActual=detalleformulariorenta107.getDetalleFormularioRenta107Original().getdecimo_tercero_305().toString();
				}
				if(detalleformulariorenta107.getdecimo_tercero_305()!=null)
				{
					strValorNuevo=detalleformulariorenta107.getdecimo_tercero_305().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFormularioRenta107ConstantesFunciones.DECIMOTERCERO_305,strValorActual,strValorNuevo);
			}	
			
			if(detalleformulariorenta107.getIsNew()||!detalleformulariorenta107.getdecimo_cuarto_307().equals(detalleformulariorenta107.getDetalleFormularioRenta107Original().getdecimo_cuarto_307()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleformulariorenta107.getDetalleFormularioRenta107Original().getdecimo_cuarto_307()!=null)
				{
					strValorActual=detalleformulariorenta107.getDetalleFormularioRenta107Original().getdecimo_cuarto_307().toString();
				}
				if(detalleformulariorenta107.getdecimo_cuarto_307()!=null)
				{
					strValorNuevo=detalleformulariorenta107.getdecimo_cuarto_307().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFormularioRenta107ConstantesFunciones.DECIMOCUARTO_307,strValorActual,strValorNuevo);
			}	
			
			if(detalleformulariorenta107.getIsNew()||!detalleformulariorenta107.getfondo_reserva_309().equals(detalleformulariorenta107.getDetalleFormularioRenta107Original().getfondo_reserva_309()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleformulariorenta107.getDetalleFormularioRenta107Original().getfondo_reserva_309()!=null)
				{
					strValorActual=detalleformulariorenta107.getDetalleFormularioRenta107Original().getfondo_reserva_309().toString();
				}
				if(detalleformulariorenta107.getfondo_reserva_309()!=null)
				{
					strValorNuevo=detalleformulariorenta107.getfondo_reserva_309().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFormularioRenta107ConstantesFunciones.FONDORESERVA_309,strValorActual,strValorNuevo);
			}	
			
			if(detalleformulariorenta107.getIsNew()||!detalleformulariorenta107.getutilidades_311().equals(detalleformulariorenta107.getDetalleFormularioRenta107Original().getutilidades_311()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleformulariorenta107.getDetalleFormularioRenta107Original().getutilidades_311()!=null)
				{
					strValorActual=detalleformulariorenta107.getDetalleFormularioRenta107Original().getutilidades_311().toString();
				}
				if(detalleformulariorenta107.getutilidades_311()!=null)
				{
					strValorNuevo=detalleformulariorenta107.getutilidades_311().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFormularioRenta107ConstantesFunciones.UTILIDADES_311,strValorActual,strValorNuevo);
			}	
			
			if(detalleformulariorenta107.getIsNew()||!detalleformulariorenta107.getdesahucio_313().equals(detalleformulariorenta107.getDetalleFormularioRenta107Original().getdesahucio_313()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleformulariorenta107.getDetalleFormularioRenta107Original().getdesahucio_313()!=null)
				{
					strValorActual=detalleformulariorenta107.getDetalleFormularioRenta107Original().getdesahucio_313().toString();
				}
				if(detalleformulariorenta107.getdesahucio_313()!=null)
				{
					strValorNuevo=detalleformulariorenta107.getdesahucio_313().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFormularioRenta107ConstantesFunciones.DESAHUCIO_313,strValorActual,strValorNuevo);
			}	
			
			if(detalleformulariorenta107.getIsNew()||!detalleformulariorenta107.getiess_personal_315().equals(detalleformulariorenta107.getDetalleFormularioRenta107Original().getiess_personal_315()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleformulariorenta107.getDetalleFormularioRenta107Original().getiess_personal_315()!=null)
				{
					strValorActual=detalleformulariorenta107.getDetalleFormularioRenta107Original().getiess_personal_315().toString();
				}
				if(detalleformulariorenta107.getiess_personal_315()!=null)
				{
					strValorNuevo=detalleformulariorenta107.getiess_personal_315().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFormularioRenta107ConstantesFunciones.IESSPERSONAL_315,strValorActual,strValorNuevo);
			}	
			
			if(detalleformulariorenta107.getIsNew()||!detalleformulariorenta107.getgastos_vivienda_317().equals(detalleformulariorenta107.getDetalleFormularioRenta107Original().getgastos_vivienda_317()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleformulariorenta107.getDetalleFormularioRenta107Original().getgastos_vivienda_317()!=null)
				{
					strValorActual=detalleformulariorenta107.getDetalleFormularioRenta107Original().getgastos_vivienda_317().toString();
				}
				if(detalleformulariorenta107.getgastos_vivienda_317()!=null)
				{
					strValorNuevo=detalleformulariorenta107.getgastos_vivienda_317().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFormularioRenta107ConstantesFunciones.GASTOSVIVIENDA_317,strValorActual,strValorNuevo);
			}	
			
			if(detalleformulariorenta107.getIsNew()||!detalleformulariorenta107.getgastos_salud_319().equals(detalleformulariorenta107.getDetalleFormularioRenta107Original().getgastos_salud_319()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleformulariorenta107.getDetalleFormularioRenta107Original().getgastos_salud_319()!=null)
				{
					strValorActual=detalleformulariorenta107.getDetalleFormularioRenta107Original().getgastos_salud_319().toString();
				}
				if(detalleformulariorenta107.getgastos_salud_319()!=null)
				{
					strValorNuevo=detalleformulariorenta107.getgastos_salud_319().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFormularioRenta107ConstantesFunciones.GASTOSSALUD_319,strValorActual,strValorNuevo);
			}	
			
			if(detalleformulariorenta107.getIsNew()||!detalleformulariorenta107.getgastos_educacion_321().equals(detalleformulariorenta107.getDetalleFormularioRenta107Original().getgastos_educacion_321()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleformulariorenta107.getDetalleFormularioRenta107Original().getgastos_educacion_321()!=null)
				{
					strValorActual=detalleformulariorenta107.getDetalleFormularioRenta107Original().getgastos_educacion_321().toString();
				}
				if(detalleformulariorenta107.getgastos_educacion_321()!=null)
				{
					strValorNuevo=detalleformulariorenta107.getgastos_educacion_321().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFormularioRenta107ConstantesFunciones.GASTOSEDUCACION_321,strValorActual,strValorNuevo);
			}	
			
			if(detalleformulariorenta107.getIsNew()||!detalleformulariorenta107.getgastos_alimentacion_323().equals(detalleformulariorenta107.getDetalleFormularioRenta107Original().getgastos_alimentacion_323()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleformulariorenta107.getDetalleFormularioRenta107Original().getgastos_alimentacion_323()!=null)
				{
					strValorActual=detalleformulariorenta107.getDetalleFormularioRenta107Original().getgastos_alimentacion_323().toString();
				}
				if(detalleformulariorenta107.getgastos_alimentacion_323()!=null)
				{
					strValorNuevo=detalleformulariorenta107.getgastos_alimentacion_323().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFormularioRenta107ConstantesFunciones.GASTOSALIMENTACION_323,strValorActual,strValorNuevo);
			}	
			
			if(detalleformulariorenta107.getIsNew()||!detalleformulariorenta107.getgastos_vestimenta_325().equals(detalleformulariorenta107.getDetalleFormularioRenta107Original().getgastos_vestimenta_325()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleformulariorenta107.getDetalleFormularioRenta107Original().getgastos_vestimenta_325()!=null)
				{
					strValorActual=detalleformulariorenta107.getDetalleFormularioRenta107Original().getgastos_vestimenta_325().toString();
				}
				if(detalleformulariorenta107.getgastos_vestimenta_325()!=null)
				{
					strValorNuevo=detalleformulariorenta107.getgastos_vestimenta_325().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFormularioRenta107ConstantesFunciones.GASTOSVESTIMENTA_325,strValorActual,strValorNuevo);
			}	
			
			if(detalleformulariorenta107.getIsNew()||!detalleformulariorenta107.getdescuento_discapacidad_327().equals(detalleformulariorenta107.getDetalleFormularioRenta107Original().getdescuento_discapacidad_327()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleformulariorenta107.getDetalleFormularioRenta107Original().getdescuento_discapacidad_327()!=null)
				{
					strValorActual=detalleformulariorenta107.getDetalleFormularioRenta107Original().getdescuento_discapacidad_327().toString();
				}
				if(detalleformulariorenta107.getdescuento_discapacidad_327()!=null)
				{
					strValorNuevo=detalleformulariorenta107.getdescuento_discapacidad_327().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFormularioRenta107ConstantesFunciones.DESCUENTODISCAPACIDAD_327,strValorActual,strValorNuevo);
			}	
			
			if(detalleformulariorenta107.getIsNew()||!detalleformulariorenta107.getdescuento_tercera_edad_329().equals(detalleformulariorenta107.getDetalleFormularioRenta107Original().getdescuento_tercera_edad_329()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleformulariorenta107.getDetalleFormularioRenta107Original().getdescuento_tercera_edad_329()!=null)
				{
					strValorActual=detalleformulariorenta107.getDetalleFormularioRenta107Original().getdescuento_tercera_edad_329().toString();
				}
				if(detalleformulariorenta107.getdescuento_tercera_edad_329()!=null)
				{
					strValorNuevo=detalleformulariorenta107.getdescuento_tercera_edad_329().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFormularioRenta107ConstantesFunciones.DESCUENTOTERCERAEDAD_329,strValorActual,strValorNuevo);
			}	
			
			if(detalleformulariorenta107.getIsNew()||!detalleformulariorenta107.getasume_empleador_331().equals(detalleformulariorenta107.getDetalleFormularioRenta107Original().getasume_empleador_331()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleformulariorenta107.getDetalleFormularioRenta107Original().getasume_empleador_331()!=null)
				{
					strValorActual=detalleformulariorenta107.getDetalleFormularioRenta107Original().getasume_empleador_331().toString();
				}
				if(detalleformulariorenta107.getasume_empleador_331()!=null)
				{
					strValorNuevo=detalleformulariorenta107.getasume_empleador_331().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFormularioRenta107ConstantesFunciones.ASUMEEMPLEADOR_331,strValorActual,strValorNuevo);
			}	
			
			if(detalleformulariorenta107.getIsNew()||!detalleformulariorenta107.getsub_empleador_351().equals(detalleformulariorenta107.getDetalleFormularioRenta107Original().getsub_empleador_351()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleformulariorenta107.getDetalleFormularioRenta107Original().getsub_empleador_351()!=null)
				{
					strValorActual=detalleformulariorenta107.getDetalleFormularioRenta107Original().getsub_empleador_351().toString();
				}
				if(detalleformulariorenta107.getsub_empleador_351()!=null)
				{
					strValorNuevo=detalleformulariorenta107.getsub_empleador_351().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFormularioRenta107ConstantesFunciones.SUBEMPLEADOR_351,strValorActual,strValorNuevo);
			}	
			
			if(detalleformulariorenta107.getIsNew()||!detalleformulariorenta107.getnumero_meses_trabajados_353().equals(detalleformulariorenta107.getDetalleFormularioRenta107Original().getnumero_meses_trabajados_353()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleformulariorenta107.getDetalleFormularioRenta107Original().getnumero_meses_trabajados_353()!=null)
				{
					strValorActual=detalleformulariorenta107.getDetalleFormularioRenta107Original().getnumero_meses_trabajados_353().toString();
				}
				if(detalleformulariorenta107.getnumero_meses_trabajados_353()!=null)
				{
					strValorNuevo=detalleformulariorenta107.getnumero_meses_trabajados_353().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFormularioRenta107ConstantesFunciones.NUMEROMESESTRABAJADOS_353,strValorActual,strValorNuevo);
			}	
			
			if(detalleformulariorenta107.getIsNew()||!detalleformulariorenta107.getingreso_otros_empleadores_401().equals(detalleformulariorenta107.getDetalleFormularioRenta107Original().getingreso_otros_empleadores_401()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleformulariorenta107.getDetalleFormularioRenta107Original().getingreso_otros_empleadores_401()!=null)
				{
					strValorActual=detalleformulariorenta107.getDetalleFormularioRenta107Original().getingreso_otros_empleadores_401().toString();
				}
				if(detalleformulariorenta107.getingreso_otros_empleadores_401()!=null)
				{
					strValorNuevo=detalleformulariorenta107.getingreso_otros_empleadores_401().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFormularioRenta107ConstantesFunciones.INGRESOOTROSEMPLEADORES_401,strValorActual,strValorNuevo);
			}	
			
			if(detalleformulariorenta107.getIsNew()||!detalleformulariorenta107.getdeduccion_gastos_otros_empleadores_403().equals(detalleformulariorenta107.getDetalleFormularioRenta107Original().getdeduccion_gastos_otros_empleadores_403()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleformulariorenta107.getDetalleFormularioRenta107Original().getdeduccion_gastos_otros_empleadores_403()!=null)
				{
					strValorActual=detalleformulariorenta107.getDetalleFormularioRenta107Original().getdeduccion_gastos_otros_empleadores_403().toString();
				}
				if(detalleformulariorenta107.getdeduccion_gastos_otros_empleadores_403()!=null)
				{
					strValorNuevo=detalleformulariorenta107.getdeduccion_gastos_otros_empleadores_403().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFormularioRenta107ConstantesFunciones.DEDUCCIONGASTOSOTROSEMPLEADORES_403,strValorActual,strValorNuevo);
			}	
			
			if(detalleformulariorenta107.getIsNew()||!detalleformulariorenta107.getrebajas_otros_empleadores_405().equals(detalleformulariorenta107.getDetalleFormularioRenta107Original().getrebajas_otros_empleadores_405()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleformulariorenta107.getDetalleFormularioRenta107Original().getrebajas_otros_empleadores_405()!=null)
				{
					strValorActual=detalleformulariorenta107.getDetalleFormularioRenta107Original().getrebajas_otros_empleadores_405().toString();
				}
				if(detalleformulariorenta107.getrebajas_otros_empleadores_405()!=null)
				{
					strValorNuevo=detalleformulariorenta107.getrebajas_otros_empleadores_405().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFormularioRenta107ConstantesFunciones.REBAJASOTROSEMPLEADORES_405,strValorActual,strValorNuevo);
			}	
			
			if(detalleformulariorenta107.getIsNew()||!detalleformulariorenta107.getbase_imponible_anual_407().equals(detalleformulariorenta107.getDetalleFormularioRenta107Original().getbase_imponible_anual_407()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleformulariorenta107.getDetalleFormularioRenta107Original().getbase_imponible_anual_407()!=null)
				{
					strValorActual=detalleformulariorenta107.getDetalleFormularioRenta107Original().getbase_imponible_anual_407().toString();
				}
				if(detalleformulariorenta107.getbase_imponible_anual_407()!=null)
				{
					strValorNuevo=detalleformulariorenta107.getbase_imponible_anual_407().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFormularioRenta107ConstantesFunciones.BASEIMPONIBLEANUAL_407,strValorActual,strValorNuevo);
			}	
			
			if(detalleformulariorenta107.getIsNew()||!detalleformulariorenta107.getimpuesto_causado_409().equals(detalleformulariorenta107.getDetalleFormularioRenta107Original().getimpuesto_causado_409()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleformulariorenta107.getDetalleFormularioRenta107Original().getimpuesto_causado_409()!=null)
				{
					strValorActual=detalleformulariorenta107.getDetalleFormularioRenta107Original().getimpuesto_causado_409().toString();
				}
				if(detalleformulariorenta107.getimpuesto_causado_409()!=null)
				{
					strValorNuevo=detalleformulariorenta107.getimpuesto_causado_409().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFormularioRenta107ConstantesFunciones.IMPUESTOCAUSADO_409,strValorActual,strValorNuevo);
			}	
			
			if(detalleformulariorenta107.getIsNew()||!detalleformulariorenta107.getimpuesto_retenido_empleador_411().equals(detalleformulariorenta107.getDetalleFormularioRenta107Original().getimpuesto_retenido_empleador_411()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleformulariorenta107.getDetalleFormularioRenta107Original().getimpuesto_retenido_empleador_411()!=null)
				{
					strValorActual=detalleformulariorenta107.getDetalleFormularioRenta107Original().getimpuesto_retenido_empleador_411().toString();
				}
				if(detalleformulariorenta107.getimpuesto_retenido_empleador_411()!=null)
				{
					strValorNuevo=detalleformulariorenta107.getimpuesto_retenido_empleador_411().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFormularioRenta107ConstantesFunciones.IMPUESTORETENIDOEMPLEADOR_411,strValorActual,strValorNuevo);
			}	
			
			if(detalleformulariorenta107.getIsNew()||!detalleformulariorenta107.getimpuesto_retenido_otros_empleadores_413().equals(detalleformulariorenta107.getDetalleFormularioRenta107Original().getimpuesto_retenido_otros_empleadores_413()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleformulariorenta107.getDetalleFormularioRenta107Original().getimpuesto_retenido_otros_empleadores_413()!=null)
				{
					strValorActual=detalleformulariorenta107.getDetalleFormularioRenta107Original().getimpuesto_retenido_otros_empleadores_413().toString();
				}
				if(detalleformulariorenta107.getimpuesto_retenido_otros_empleadores_413()!=null)
				{
					strValorNuevo=detalleformulariorenta107.getimpuesto_retenido_otros_empleadores_413().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleFormularioRenta107ConstantesFunciones.IMPUESTORETENIDOOTROSEMPLEADORES_413,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleFormularioRenta107RelacionesWithConnection(DetalleFormularioRenta107 detalleformulariorenta107) throws Exception {

		if(!detalleformulariorenta107.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleFormularioRenta107RelacionesBase(detalleformulariorenta107,true);
		}
	}

	public void saveDetalleFormularioRenta107Relaciones(DetalleFormularioRenta107 detalleformulariorenta107)throws Exception {

		if(!detalleformulariorenta107.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleFormularioRenta107RelacionesBase(detalleformulariorenta107,false);
		}
	}

	public void saveDetalleFormularioRenta107RelacionesBase(DetalleFormularioRenta107 detalleformulariorenta107,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleFormularioRenta107-saveRelacionesWithConnection");}
	

			this.setDetalleFormularioRenta107(detalleformulariorenta107);

			if(DetalleFormularioRenta107LogicAdditional.validarSaveRelaciones(detalleformulariorenta107,this)) {

				DetalleFormularioRenta107LogicAdditional.updateRelacionesToSave(detalleformulariorenta107,this);

				if((detalleformulariorenta107.getIsNew()||detalleformulariorenta107.getIsChanged())&&!detalleformulariorenta107.getIsDeleted()) {
					this.saveDetalleFormularioRenta107();
					this.saveDetalleFormularioRenta107RelacionesDetalles();

				} else if(detalleformulariorenta107.getIsDeleted()) {
					this.saveDetalleFormularioRenta107RelacionesDetalles();
					this.saveDetalleFormularioRenta107();
				}

				DetalleFormularioRenta107LogicAdditional.updateRelacionesToSaveAfter(detalleformulariorenta107,this);

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
	
	
	private void saveDetalleFormularioRenta107RelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleFormularioRenta107(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleFormularioRenta107ConstantesFunciones.getClassesForeignKeysOfDetalleFormularioRenta107(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleFormularioRenta107(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleFormularioRenta107ConstantesFunciones.getClassesRelationshipsOfDetalleFormularioRenta107(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
