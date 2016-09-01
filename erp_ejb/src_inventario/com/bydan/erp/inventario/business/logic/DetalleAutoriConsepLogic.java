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
package com.bydan.erp.inventario.business.logic;

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
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.inventario.util.DetalleAutoriConsepConstantesFunciones;
import com.bydan.erp.inventario.util.DetalleAutoriConsepParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DetalleAutoriConsepParameterGeneral;
import com.bydan.erp.inventario.business.entity.DetalleAutoriConsep;
import com.bydan.erp.inventario.business.logic.DetalleAutoriConsepLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class DetalleAutoriConsepLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleAutoriConsepLogic.class);
	
	protected DetalleAutoriConsepDataAccess detalleautoriconsepDataAccess; 	
	protected DetalleAutoriConsep detalleautoriconsep;
	protected List<DetalleAutoriConsep> detalleautoriconseps;
	protected Object detalleautoriconsepObject;	
	protected List<Object> detalleautoriconsepsObject;
	
	public static ClassValidator<DetalleAutoriConsep> detalleautoriconsepValidator = new ClassValidator<DetalleAutoriConsep>(DetalleAutoriConsep.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleAutoriConsepLogicAdditional detalleautoriconsepLogicAdditional=null;
	
	public DetalleAutoriConsepLogicAdditional getDetalleAutoriConsepLogicAdditional() {
		return this.detalleautoriconsepLogicAdditional;
	}
	
	public void setDetalleAutoriConsepLogicAdditional(DetalleAutoriConsepLogicAdditional detalleautoriconsepLogicAdditional) {
		try {
			this.detalleautoriconsepLogicAdditional=detalleautoriconsepLogicAdditional;
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
	
	
	
	
	public  DetalleAutoriConsepLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detalleautoriconsepDataAccess = new DetalleAutoriConsepDataAccess();
			
			this.detalleautoriconseps= new ArrayList<DetalleAutoriConsep>();
			this.detalleautoriconsep= new DetalleAutoriConsep();
			
			this.detalleautoriconsepObject=new Object();
			this.detalleautoriconsepsObject=new ArrayList<Object>();
				
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
			
			this.detalleautoriconsepDataAccess.setConnexionType(this.connexionType);
			this.detalleautoriconsepDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleAutoriConsepLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detalleautoriconsepDataAccess = new DetalleAutoriConsepDataAccess();
			this.detalleautoriconseps= new ArrayList<DetalleAutoriConsep>();
			this.detalleautoriconsep= new DetalleAutoriConsep();
			this.detalleautoriconsepObject=new Object();
			this.detalleautoriconsepsObject=new ArrayList<Object>();
			
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
			
			this.detalleautoriconsepDataAccess.setConnexionType(this.connexionType);
			this.detalleautoriconsepDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleAutoriConsep getDetalleAutoriConsep() throws Exception {	
		DetalleAutoriConsepLogicAdditional.checkDetalleAutoriConsepToGet(detalleautoriconsep,this.datosCliente,this.arrDatoGeneral);
		DetalleAutoriConsepLogicAdditional.updateDetalleAutoriConsepToGet(detalleautoriconsep,this.arrDatoGeneral);
		
		return detalleautoriconsep;
	}
		
	public void setDetalleAutoriConsep(DetalleAutoriConsep newDetalleAutoriConsep) {
		this.detalleautoriconsep = newDetalleAutoriConsep;
	}
	
	public DetalleAutoriConsepDataAccess getDetalleAutoriConsepDataAccess() {
		return detalleautoriconsepDataAccess;
	}
	
	public void setDetalleAutoriConsepDataAccess(DetalleAutoriConsepDataAccess newdetalleautoriconsepDataAccess) {
		this.detalleautoriconsepDataAccess = newdetalleautoriconsepDataAccess;
	}
	
	public List<DetalleAutoriConsep> getDetalleAutoriConseps() throws Exception {		
		this.quitarDetalleAutoriConsepsNulos();
		
		DetalleAutoriConsepLogicAdditional.checkDetalleAutoriConsepToGets(detalleautoriconseps,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleAutoriConsep detalleautoriconsepLocal: detalleautoriconseps ) {
			DetalleAutoriConsepLogicAdditional.updateDetalleAutoriConsepToGet(detalleautoriconsepLocal,this.arrDatoGeneral);
		}
		
		return detalleautoriconseps;
	}
	
	public void setDetalleAutoriConseps(List<DetalleAutoriConsep> newDetalleAutoriConseps) {
		this.detalleautoriconseps = newDetalleAutoriConseps;
	}
	
	public Object getDetalleAutoriConsepObject() {	
		this.detalleautoriconsepObject=this.detalleautoriconsepDataAccess.getEntityObject();
		return this.detalleautoriconsepObject;
	}
		
	public void setDetalleAutoriConsepObject(Object newDetalleAutoriConsepObject) {
		this.detalleautoriconsepObject = newDetalleAutoriConsepObject;
	}
	
	public List<Object> getDetalleAutoriConsepsObject() {		
		this.detalleautoriconsepsObject=this.detalleautoriconsepDataAccess.getEntitiesObject();
		return this.detalleautoriconsepsObject;
	}
		
	public void setDetalleAutoriConsepsObject(List<Object> newDetalleAutoriConsepsObject) {
		this.detalleautoriconsepsObject = newDetalleAutoriConsepsObject;
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
		
		if(this.detalleautoriconsepDataAccess!=null) {
			this.detalleautoriconsepDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAutoriConsep.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detalleautoriconsepDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detalleautoriconsepDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detalleautoriconsep = new  DetalleAutoriConsep();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAutoriConsep.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleautoriconsep=detalleautoriconsepDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleautoriconsep,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(this.detalleautoriconsep);
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
		detalleautoriconsep = new  DetalleAutoriConsep();
		  		  
        try {
			
			detalleautoriconsep=detalleautoriconsepDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleautoriconsep,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(this.detalleautoriconsep);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detalleautoriconsep = new  DetalleAutoriConsep();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAutoriConsep.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleautoriconsep=detalleautoriconsepDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleautoriconsep,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(this.detalleautoriconsep);
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
		detalleautoriconsep = new  DetalleAutoriConsep();
		  		  
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
		detalleautoriconsep = new  DetalleAutoriConsep();
		  		  
        try {
			
			detalleautoriconsep=detalleautoriconsepDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleautoriconsep,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(this.detalleautoriconsep);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detalleautoriconsep = new  DetalleAutoriConsep();
		  		  
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
		detalleautoriconsep = new  DetalleAutoriConsep();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAutoriConsep.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detalleautoriconsepDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleautoriconsep = new  DetalleAutoriConsep();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detalleautoriconsepDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleautoriconsep = new  DetalleAutoriConsep();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAutoriConsep.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detalleautoriconsepDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleautoriconsep = new  DetalleAutoriConsep();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detalleautoriconsepDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleautoriconsep = new  DetalleAutoriConsep();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAutoriConsep.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detalleautoriconsepDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleautoriconsep = new  DetalleAutoriConsep();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detalleautoriconsepDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleautoriconseps = new  ArrayList<DetalleAutoriConsep>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAutoriConsep.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleautoriconseps=detalleautoriconsepDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleAutoriConsep(detalleautoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(this.detalleautoriconseps);
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
		detalleautoriconseps = new  ArrayList<DetalleAutoriConsep>();
		  		  
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
		detalleautoriconseps = new  ArrayList<DetalleAutoriConsep>();
		  		  
        try {			
			DetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleautoriconseps=detalleautoriconsepDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleAutoriConsep(detalleautoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(this.detalleautoriconseps);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detalleautoriconseps = new  ArrayList<DetalleAutoriConsep>();
		  		  
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
		detalleautoriconseps = new  ArrayList<DetalleAutoriConsep>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAutoriConsep.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleautoriconseps=detalleautoriconsepDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleAutoriConsep(detalleautoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(this.detalleautoriconseps);
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
		detalleautoriconseps = new  ArrayList<DetalleAutoriConsep>();
		  		  
        try {
			DetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleautoriconseps=detalleautoriconsepDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleAutoriConsep(detalleautoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(this.detalleautoriconseps);
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
		detalleautoriconseps = new  ArrayList<DetalleAutoriConsep>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAutoriConsep.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleautoriconseps=detalleautoriconsepDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleAutoriConsep(detalleautoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(this.detalleautoriconseps);
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
		detalleautoriconseps = new  ArrayList<DetalleAutoriConsep>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleautoriconseps=detalleautoriconsepDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleAutoriConsep(detalleautoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(this.detalleautoriconseps);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detalleautoriconsep = new  DetalleAutoriConsep();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAutoriConsep.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleautoriconsep=detalleautoriconsepDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleAutoriConsep(detalleautoriconsep);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(this.detalleautoriconsep);
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
		detalleautoriconsep = new  DetalleAutoriConsep();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleautoriconsep=detalleautoriconsepDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleAutoriConsep(detalleautoriconsep);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(this.detalleautoriconsep);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleautoriconseps = new  ArrayList<DetalleAutoriConsep>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAutoriConsep.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleautoriconseps=detalleautoriconsepDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleAutoriConsep(detalleautoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(this.detalleautoriconseps);
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
		detalleautoriconseps = new  ArrayList<DetalleAutoriConsep>();
		  		  
        try {
			DetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleautoriconseps=detalleautoriconsepDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleAutoriConsep(detalleautoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(this.detalleautoriconseps);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleAutoriConsepsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detalleautoriconseps = new  ArrayList<DetalleAutoriConsep>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAutoriConsep.class.getSimpleName()+"-getTodosDetalleAutoriConsepsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleautoriconseps=detalleautoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleAutoriConsep(detalleautoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(this.detalleautoriconseps);
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
	
	public  void  getTodosDetalleAutoriConseps(String sFinalQuery,Pagination pagination)throws Exception {
		detalleautoriconseps = new  ArrayList<DetalleAutoriConsep>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleautoriconseps=detalleautoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleAutoriConsep(detalleautoriconseps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(this.detalleautoriconseps);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleAutoriConsep(DetalleAutoriConsep detalleautoriconsep) throws Exception {
		Boolean estaValidado=false;
		
		if(detalleautoriconsep.getIsNew() || detalleautoriconsep.getIsChanged()) { 
			this.invalidValues = detalleautoriconsepValidator.getInvalidValues(detalleautoriconsep);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detalleautoriconsep);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleAutoriConsep(List<DetalleAutoriConsep> DetalleAutoriConseps) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleAutoriConsep detalleautoriconsepLocal:detalleautoriconseps) {				
			estaValidadoObjeto=this.validarGuardarDetalleAutoriConsep(detalleautoriconsepLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleAutoriConsep(List<DetalleAutoriConsep> DetalleAutoriConseps) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleAutoriConsep(detalleautoriconseps)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleAutoriConsep(DetalleAutoriConsep DetalleAutoriConsep) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleAutoriConsep(detalleautoriconsep)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleAutoriConsep detalleautoriconsep) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detalleautoriconsep.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleAutoriConsepConstantesFunciones.getDetalleAutoriConsepLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detalleautoriconsep","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleAutoriConsepConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleAutoriConsepConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleAutoriConsepWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAutoriConsep.class.getSimpleName()+"-saveDetalleAutoriConsepWithConnection");connexion.begin();			
			
			DetalleAutoriConsepLogicAdditional.checkDetalleAutoriConsepToSave(this.detalleautoriconsep,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleAutoriConsepLogicAdditional.updateDetalleAutoriConsepToSave(this.detalleautoriconsep,this.arrDatoGeneral);
			
			DetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleautoriconsep,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleAutoriConsep();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleAutoriConsep(this.detalleautoriconsep)) {
				DetalleAutoriConsepDataAccess.save(this.detalleautoriconsep, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detalleautoriconsep,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleAutoriConsepLogicAdditional.checkDetalleAutoriConsepToSaveAfter(this.detalleautoriconsep,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleAutoriConsep();
			
			connexion.commit();			
			
			if(this.detalleautoriconsep.getIsDeleted()) {
				this.detalleautoriconsep=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleAutoriConsep()throws Exception {	
		try {	
			
			DetalleAutoriConsepLogicAdditional.checkDetalleAutoriConsepToSave(this.detalleautoriconsep,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleAutoriConsepLogicAdditional.updateDetalleAutoriConsepToSave(this.detalleautoriconsep,this.arrDatoGeneral);
			
			DetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleautoriconsep,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleAutoriConsep(this.detalleautoriconsep)) {			
				DetalleAutoriConsepDataAccess.save(this.detalleautoriconsep, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detalleautoriconsep,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleAutoriConsepLogicAdditional.checkDetalleAutoriConsepToSaveAfter(this.detalleautoriconsep,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detalleautoriconsep.getIsDeleted()) {
				this.detalleautoriconsep=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleAutoriConsepsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAutoriConsep.class.getSimpleName()+"-saveDetalleAutoriConsepsWithConnection");connexion.begin();			
			
			DetalleAutoriConsepLogicAdditional.checkDetalleAutoriConsepToSaves(detalleautoriconseps,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleAutoriConseps();
			
			Boolean validadoTodosDetalleAutoriConsep=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleAutoriConsep detalleautoriconsepLocal:detalleautoriconseps) {		
				if(detalleautoriconsepLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleAutoriConsepLogicAdditional.updateDetalleAutoriConsepToSave(detalleautoriconsepLocal,this.arrDatoGeneral);
	        	
				DetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleautoriconsepLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleAutoriConsep(detalleautoriconsepLocal)) {
					DetalleAutoriConsepDataAccess.save(detalleautoriconsepLocal, connexion);				
				} else {
					validadoTodosDetalleAutoriConsep=false;
				}
			}
			
			if(!validadoTodosDetalleAutoriConsep) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleAutoriConsepLogicAdditional.checkDetalleAutoriConsepToSavesAfter(detalleautoriconseps,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleAutoriConseps();
			
			connexion.commit();		
			
			this.quitarDetalleAutoriConsepsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleAutoriConseps()throws Exception {				
		 try {	
			DetalleAutoriConsepLogicAdditional.checkDetalleAutoriConsepToSaves(detalleautoriconseps,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleAutoriConsep=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleAutoriConsep detalleautoriconsepLocal:detalleautoriconseps) {				
				if(detalleautoriconsepLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleAutoriConsepLogicAdditional.updateDetalleAutoriConsepToSave(detalleautoriconsepLocal,this.arrDatoGeneral);
	        	
				DetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleautoriconsepLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleAutoriConsep(detalleautoriconsepLocal)) {				
					DetalleAutoriConsepDataAccess.save(detalleautoriconsepLocal, connexion);				
				} else {
					validadoTodosDetalleAutoriConsep=false;
				}
			}
			
			if(!validadoTodosDetalleAutoriConsep) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleAutoriConsepLogicAdditional.checkDetalleAutoriConsepToSavesAfter(detalleautoriconseps,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleAutoriConsepsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleAutoriConsepParameterReturnGeneral procesarAccionDetalleAutoriConseps(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleAutoriConsep> detalleautoriconseps,DetalleAutoriConsepParameterReturnGeneral detalleautoriconsepParameterGeneral)throws Exception {
		 try {	
			DetalleAutoriConsepParameterReturnGeneral detalleautoriconsepReturnGeneral=new DetalleAutoriConsepParameterReturnGeneral();
	
			DetalleAutoriConsepLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleautoriconseps,detalleautoriconsepParameterGeneral,detalleautoriconsepReturnGeneral);
			
			return detalleautoriconsepReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleAutoriConsepParameterReturnGeneral procesarAccionDetalleAutoriConsepsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleAutoriConsep> detalleautoriconseps,DetalleAutoriConsepParameterReturnGeneral detalleautoriconsepParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAutoriConsep.class.getSimpleName()+"-procesarAccionDetalleAutoriConsepsWithConnection");connexion.begin();			
			
			DetalleAutoriConsepParameterReturnGeneral detalleautoriconsepReturnGeneral=new DetalleAutoriConsepParameterReturnGeneral();
	
			DetalleAutoriConsepLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleautoriconseps,detalleautoriconsepParameterGeneral,detalleautoriconsepReturnGeneral);
			
			this.connexion.commit();
			
			return detalleautoriconsepReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleAutoriConsepParameterReturnGeneral procesarEventosDetalleAutoriConseps(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleAutoriConsep> detalleautoriconseps,DetalleAutoriConsep detalleautoriconsep,DetalleAutoriConsepParameterReturnGeneral detalleautoriconsepParameterGeneral,Boolean isEsNuevoDetalleAutoriConsep,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleAutoriConsepParameterReturnGeneral detalleautoriconsepReturnGeneral=new DetalleAutoriConsepParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleautoriconsepReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleAutoriConsepLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleautoriconseps,detalleautoriconsep,detalleautoriconsepParameterGeneral,detalleautoriconsepReturnGeneral,isEsNuevoDetalleAutoriConsep,clases);
			
			return detalleautoriconsepReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleAutoriConsepParameterReturnGeneral procesarEventosDetalleAutoriConsepsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleAutoriConsep> detalleautoriconseps,DetalleAutoriConsep detalleautoriconsep,DetalleAutoriConsepParameterReturnGeneral detalleautoriconsepParameterGeneral,Boolean isEsNuevoDetalleAutoriConsep,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAutoriConsep.class.getSimpleName()+"-procesarEventosDetalleAutoriConsepsWithConnection");connexion.begin();			
			
			DetalleAutoriConsepParameterReturnGeneral detalleautoriconsepReturnGeneral=new DetalleAutoriConsepParameterReturnGeneral();
	
			detalleautoriconsepReturnGeneral.setDetalleAutoriConsep(detalleautoriconsep);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleautoriconsepReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleAutoriConsepLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleautoriconseps,detalleautoriconsep,detalleautoriconsepParameterGeneral,detalleautoriconsepReturnGeneral,isEsNuevoDetalleAutoriConsep,clases);
			
			this.connexion.commit();
			
			return detalleautoriconsepReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleAutoriConsepParameterReturnGeneral procesarImportacionDetalleAutoriConsepsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleAutoriConsepParameterReturnGeneral detalleautoriconsepParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAutoriConsep.class.getSimpleName()+"-procesarImportacionDetalleAutoriConsepsWithConnection");connexion.begin();			
			
			DetalleAutoriConsepParameterReturnGeneral detalleautoriconsepReturnGeneral=new DetalleAutoriConsepParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detalleautoriconseps=new ArrayList<DetalleAutoriConsep>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detalleautoriconsep=new DetalleAutoriConsep();
				
				
				if(conColumnasBase) {this.detalleautoriconsep.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detalleautoriconsep.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detalleautoriconsep.setcantidad_anio(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleautoriconsep.setcantidad_saldo(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.detalleautoriconseps.add(this.detalleautoriconsep);
			}
			
			this.saveDetalleAutoriConseps();
			
			this.connexion.commit();
			
			detalleautoriconsepReturnGeneral.setConRetornoEstaProcesado(true);
			detalleautoriconsepReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detalleautoriconsepReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleAutoriConsepsEliminados() throws Exception {				
		
		List<DetalleAutoriConsep> detalleautoriconsepsAux= new ArrayList<DetalleAutoriConsep>();
		
		for(DetalleAutoriConsep detalleautoriconsep:detalleautoriconseps) {
			if(!detalleautoriconsep.getIsDeleted()) {
				detalleautoriconsepsAux.add(detalleautoriconsep);
			}
		}
		
		detalleautoriconseps=detalleautoriconsepsAux;
	}
	
	public void quitarDetalleAutoriConsepsNulos() throws Exception {				
		
		List<DetalleAutoriConsep> detalleautoriconsepsAux= new ArrayList<DetalleAutoriConsep>();
		
		for(DetalleAutoriConsep detalleautoriconsep : this.detalleautoriconseps) {
			if(detalleautoriconsep==null) {
				detalleautoriconsepsAux.add(detalleautoriconsep);
			}
		}
		
		//this.detalleautoriconseps=detalleautoriconsepsAux;
		
		this.detalleautoriconseps.removeAll(detalleautoriconsepsAux);
	}
	
	public void getSetVersionRowDetalleAutoriConsepWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detalleautoriconsep.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detalleautoriconsep.getIsDeleted() || (detalleautoriconsep.getIsChanged()&&!detalleautoriconsep.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detalleautoriconsepDataAccess.getSetVersionRowDetalleAutoriConsep(connexion,detalleautoriconsep.getId());
				
				if(!detalleautoriconsep.getVersionRow().equals(timestamp)) {	
					detalleautoriconsep.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detalleautoriconsep.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleAutoriConsep()throws Exception {	
		
		if(detalleautoriconsep.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detalleautoriconsep.getIsDeleted() || (detalleautoriconsep.getIsChanged()&&!detalleautoriconsep.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detalleautoriconsepDataAccess.getSetVersionRowDetalleAutoriConsep(connexion,detalleautoriconsep.getId());
			
			try {							
				if(!detalleautoriconsep.getVersionRow().equals(timestamp)) {	
					detalleautoriconsep.setVersionRow(timestamp);
				}
				
				detalleautoriconsep.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleAutoriConsepsWithConnection()throws Exception {	
		if(detalleautoriconseps!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleAutoriConsep detalleautoriconsepAux:detalleautoriconseps) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detalleautoriconsepAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleautoriconsepAux.getIsDeleted() || (detalleautoriconsepAux.getIsChanged()&&!detalleautoriconsepAux.getIsNew())) {
						
						timestamp=detalleautoriconsepDataAccess.getSetVersionRowDetalleAutoriConsep(connexion,detalleautoriconsepAux.getId());
						
						if(!detalleautoriconsep.getVersionRow().equals(timestamp)) {	
							detalleautoriconsepAux.setVersionRow(timestamp);
						}
								
						detalleautoriconsepAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleAutoriConseps()throws Exception {	
		if(detalleautoriconseps!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleAutoriConsep detalleautoriconsepAux:detalleautoriconseps) {
					if(detalleautoriconsepAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleautoriconsepAux.getIsDeleted() || (detalleautoriconsepAux.getIsChanged()&&!detalleautoriconsepAux.getIsNew())) {
						
						timestamp=detalleautoriconsepDataAccess.getSetVersionRowDetalleAutoriConsep(connexion,detalleautoriconsepAux.getId());
						
						if(!detalleautoriconsepAux.getVersionRow().equals(timestamp)) {	
							detalleautoriconsepAux.setVersionRow(timestamp);
						}
						
													
						detalleautoriconsepAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleAutoriConsepParameterReturnGeneral cargarCombosLoteForeignKeyDetalleAutoriConsepWithConnection(String finalQueryGlobalAutoriConsep,String finalQueryGlobalEmpresa,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalEstadoDetalleAutoriConsep) throws Exception {
		DetalleAutoriConsepParameterReturnGeneral  detalleautoriconsepReturnGeneral =new DetalleAutoriConsepParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAutoriConsep.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleAutoriConsepWithConnection");connexion.begin();
			
			detalleautoriconsepReturnGeneral =new DetalleAutoriConsepParameterReturnGeneral();
			
			

			List<AutoriConsep> autoriconsepsForeignKey=new ArrayList<AutoriConsep>();
			AutoriConsepLogic autoriconsepLogic=new AutoriConsepLogic();
			autoriconsepLogic.setConnexion(this.connexion);
			autoriconsepLogic.getAutoriConsepDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAutoriConsep.equals("NONE")) {
				autoriconsepLogic.getTodosAutoriConseps(finalQueryGlobalAutoriConsep,new Pagination());
				autoriconsepsForeignKey=autoriconsepLogic.getAutoriConseps();
			}

			detalleautoriconsepReturnGeneral.setautoriconsepsForeignKey(autoriconsepsForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleautoriconsepReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detalleautoriconsepReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detalleautoriconsepReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<EstadoDetalleAutoriConsep> estadodetalleautoriconsepsForeignKey=new ArrayList<EstadoDetalleAutoriConsep>();
			EstadoDetalleAutoriConsepLogic estadodetalleautoriconsepLogic=new EstadoDetalleAutoriConsepLogic();
			estadodetalleautoriconsepLogic.setConnexion(this.connexion);
			estadodetalleautoriconsepLogic.getEstadoDetalleAutoriConsepDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoDetalleAutoriConsep.equals("NONE")) {
				estadodetalleautoriconsepLogic.getTodosEstadoDetalleAutoriConseps(finalQueryGlobalEstadoDetalleAutoriConsep,new Pagination());
				estadodetalleautoriconsepsForeignKey=estadodetalleautoriconsepLogic.getEstadoDetalleAutoriConseps();
			}

			detalleautoriconsepReturnGeneral.setestadodetalleautoriconsepsForeignKey(estadodetalleautoriconsepsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detalleautoriconsepReturnGeneral;
	}
	
	public DetalleAutoriConsepParameterReturnGeneral cargarCombosLoteForeignKeyDetalleAutoriConsep(String finalQueryGlobalAutoriConsep,String finalQueryGlobalEmpresa,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalEstadoDetalleAutoriConsep) throws Exception {
		DetalleAutoriConsepParameterReturnGeneral  detalleautoriconsepReturnGeneral =new DetalleAutoriConsepParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detalleautoriconsepReturnGeneral =new DetalleAutoriConsepParameterReturnGeneral();
			
			

			List<AutoriConsep> autoriconsepsForeignKey=new ArrayList<AutoriConsep>();
			AutoriConsepLogic autoriconsepLogic=new AutoriConsepLogic();
			autoriconsepLogic.setConnexion(this.connexion);
			autoriconsepLogic.getAutoriConsepDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAutoriConsep.equals("NONE")) {
				autoriconsepLogic.getTodosAutoriConseps(finalQueryGlobalAutoriConsep,new Pagination());
				autoriconsepsForeignKey=autoriconsepLogic.getAutoriConseps();
			}

			detalleautoriconsepReturnGeneral.setautoriconsepsForeignKey(autoriconsepsForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleautoriconsepReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detalleautoriconsepReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detalleautoriconsepReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<EstadoDetalleAutoriConsep> estadodetalleautoriconsepsForeignKey=new ArrayList<EstadoDetalleAutoriConsep>();
			EstadoDetalleAutoriConsepLogic estadodetalleautoriconsepLogic=new EstadoDetalleAutoriConsepLogic();
			estadodetalleautoriconsepLogic.setConnexion(this.connexion);
			estadodetalleautoriconsepLogic.getEstadoDetalleAutoriConsepDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoDetalleAutoriConsep.equals("NONE")) {
				estadodetalleautoriconsepLogic.getTodosEstadoDetalleAutoriConseps(finalQueryGlobalEstadoDetalleAutoriConsep,new Pagination());
				estadodetalleautoriconsepsForeignKey=estadodetalleautoriconsepLogic.getEstadoDetalleAutoriConseps();
			}

			detalleautoriconsepReturnGeneral.setestadodetalleautoriconsepsForeignKey(estadodetalleautoriconsepsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detalleautoriconsepReturnGeneral;
	}
	
	
	public void deepLoad(DetalleAutoriConsep detalleautoriconsep,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleAutoriConsepLogicAdditional.updateDetalleAutoriConsepToGet(detalleautoriconsep,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleautoriconsep.setAutoriConsep(detalleautoriconsepDataAccess.getAutoriConsep(connexion,detalleautoriconsep));
		detalleautoriconsep.setEmpresa(detalleautoriconsepDataAccess.getEmpresa(connexion,detalleautoriconsep));
		detalleautoriconsep.setProducto(detalleautoriconsepDataAccess.getProducto(connexion,detalleautoriconsep));
		detalleautoriconsep.setUnidad(detalleautoriconsepDataAccess.getUnidad(connexion,detalleautoriconsep));
		detalleautoriconsep.setEstadoDetalleAutoriConsep(detalleautoriconsepDataAccess.getEstadoDetalleAutoriConsep(connexion,detalleautoriconsep));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(AutoriConsep.class)) {
				detalleautoriconsep.setAutoriConsep(detalleautoriconsepDataAccess.getAutoriConsep(connexion,detalleautoriconsep));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detalleautoriconsep.setEmpresa(detalleautoriconsepDataAccess.getEmpresa(connexion,detalleautoriconsep));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detalleautoriconsep.setProducto(detalleautoriconsepDataAccess.getProducto(connexion,detalleautoriconsep));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detalleautoriconsep.setUnidad(detalleautoriconsepDataAccess.getUnidad(connexion,detalleautoriconsep));
				continue;
			}

			if(clas.clas.equals(EstadoDetalleAutoriConsep.class)) {
				detalleautoriconsep.setEstadoDetalleAutoriConsep(detalleautoriconsepDataAccess.getEstadoDetalleAutoriConsep(connexion,detalleautoriconsep));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AutoriConsep.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleautoriconsep.setAutoriConsep(detalleautoriconsepDataAccess.getAutoriConsep(connexion,detalleautoriconsep));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleautoriconsep.setEmpresa(detalleautoriconsepDataAccess.getEmpresa(connexion,detalleautoriconsep));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleautoriconsep.setProducto(detalleautoriconsepDataAccess.getProducto(connexion,detalleautoriconsep));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleautoriconsep.setUnidad(detalleautoriconsepDataAccess.getUnidad(connexion,detalleautoriconsep));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoDetalleAutoriConsep.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleautoriconsep.setEstadoDetalleAutoriConsep(detalleautoriconsepDataAccess.getEstadoDetalleAutoriConsep(connexion,detalleautoriconsep));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleautoriconsep.setAutoriConsep(detalleautoriconsepDataAccess.getAutoriConsep(connexion,detalleautoriconsep));
		AutoriConsepLogic autoriconsepLogic= new AutoriConsepLogic(connexion);
		autoriconsepLogic.deepLoad(detalleautoriconsep.getAutoriConsep(),isDeep,deepLoadType,clases);
				
		detalleautoriconsep.setEmpresa(detalleautoriconsepDataAccess.getEmpresa(connexion,detalleautoriconsep));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleautoriconsep.getEmpresa(),isDeep,deepLoadType,clases);
				
		detalleautoriconsep.setProducto(detalleautoriconsepDataAccess.getProducto(connexion,detalleautoriconsep));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detalleautoriconsep.getProducto(),isDeep,deepLoadType,clases);
				
		detalleautoriconsep.setUnidad(detalleautoriconsepDataAccess.getUnidad(connexion,detalleautoriconsep));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detalleautoriconsep.getUnidad(),isDeep,deepLoadType,clases);
				
		detalleautoriconsep.setEstadoDetalleAutoriConsep(detalleautoriconsepDataAccess.getEstadoDetalleAutoriConsep(connexion,detalleautoriconsep));
		EstadoDetalleAutoriConsepLogic estadodetalleautoriconsepLogic= new EstadoDetalleAutoriConsepLogic(connexion);
		estadodetalleautoriconsepLogic.deepLoad(detalleautoriconsep.getEstadoDetalleAutoriConsep(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(AutoriConsep.class)) {
				detalleautoriconsep.setAutoriConsep(detalleautoriconsepDataAccess.getAutoriConsep(connexion,detalleautoriconsep));
				AutoriConsepLogic autoriconsepLogic= new AutoriConsepLogic(connexion);
				autoriconsepLogic.deepLoad(detalleautoriconsep.getAutoriConsep(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detalleautoriconsep.setEmpresa(detalleautoriconsepDataAccess.getEmpresa(connexion,detalleautoriconsep));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detalleautoriconsep.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detalleautoriconsep.setProducto(detalleautoriconsepDataAccess.getProducto(connexion,detalleautoriconsep));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(detalleautoriconsep.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detalleautoriconsep.setUnidad(detalleautoriconsepDataAccess.getUnidad(connexion,detalleautoriconsep));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(detalleautoriconsep.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoDetalleAutoriConsep.class)) {
				detalleautoriconsep.setEstadoDetalleAutoriConsep(detalleautoriconsepDataAccess.getEstadoDetalleAutoriConsep(connexion,detalleautoriconsep));
				EstadoDetalleAutoriConsepLogic estadodetalleautoriconsepLogic= new EstadoDetalleAutoriConsepLogic(connexion);
				estadodetalleautoriconsepLogic.deepLoad(detalleautoriconsep.getEstadoDetalleAutoriConsep(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(AutoriConsep.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleautoriconsep.setAutoriConsep(detalleautoriconsepDataAccess.getAutoriConsep(connexion,detalleautoriconsep));
			AutoriConsepLogic autoriconsepLogic= new AutoriConsepLogic(connexion);
			autoriconsepLogic.deepLoad(detalleautoriconsep.getAutoriConsep(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleautoriconsep.setEmpresa(detalleautoriconsepDataAccess.getEmpresa(connexion,detalleautoriconsep));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detalleautoriconsep.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleautoriconsep.setProducto(detalleautoriconsepDataAccess.getProducto(connexion,detalleautoriconsep));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(detalleautoriconsep.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleautoriconsep.setUnidad(detalleautoriconsepDataAccess.getUnidad(connexion,detalleautoriconsep));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(detalleautoriconsep.getUnidad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoDetalleAutoriConsep.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleautoriconsep.setEstadoDetalleAutoriConsep(detalleautoriconsepDataAccess.getEstadoDetalleAutoriConsep(connexion,detalleautoriconsep));
			EstadoDetalleAutoriConsepLogic estadodetalleautoriconsepLogic= new EstadoDetalleAutoriConsepLogic(connexion);
			estadodetalleautoriconsepLogic.deepLoad(detalleautoriconsep.getEstadoDetalleAutoriConsep(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleAutoriConsep detalleautoriconsep,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleAutoriConsepLogicAdditional.updateDetalleAutoriConsepToSave(detalleautoriconsep,this.arrDatoGeneral);
			
DetalleAutoriConsepDataAccess.save(detalleautoriconsep, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		AutoriConsepDataAccess.save(detalleautoriconsep.getAutoriConsep(),connexion);

		EmpresaDataAccess.save(detalleautoriconsep.getEmpresa(),connexion);

		ProductoDataAccess.save(detalleautoriconsep.getProducto(),connexion);

		UnidadDataAccess.save(detalleautoriconsep.getUnidad(),connexion);

		EstadoDetalleAutoriConsepDataAccess.save(detalleautoriconsep.getEstadoDetalleAutoriConsep(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(AutoriConsep.class)) {
				AutoriConsepDataAccess.save(detalleautoriconsep.getAutoriConsep(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleautoriconsep.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detalleautoriconsep.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detalleautoriconsep.getUnidad(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoDetalleAutoriConsep.class)) {
				EstadoDetalleAutoriConsepDataAccess.save(detalleautoriconsep.getEstadoDetalleAutoriConsep(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		AutoriConsepDataAccess.save(detalleautoriconsep.getAutoriConsep(),connexion);
		AutoriConsepLogic autoriconsepLogic= new AutoriConsepLogic(connexion);
		autoriconsepLogic.deepLoad(detalleautoriconsep.getAutoriConsep(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(detalleautoriconsep.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleautoriconsep.getEmpresa(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(detalleautoriconsep.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detalleautoriconsep.getProducto(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(detalleautoriconsep.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detalleautoriconsep.getUnidad(),isDeep,deepLoadType,clases);
				

		EstadoDetalleAutoriConsepDataAccess.save(detalleautoriconsep.getEstadoDetalleAutoriConsep(),connexion);
		EstadoDetalleAutoriConsepLogic estadodetalleautoriconsepLogic= new EstadoDetalleAutoriConsepLogic(connexion);
		estadodetalleautoriconsepLogic.deepLoad(detalleautoriconsep.getEstadoDetalleAutoriConsep(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(AutoriConsep.class)) {
				AutoriConsepDataAccess.save(detalleautoriconsep.getAutoriConsep(),connexion);
				AutoriConsepLogic autoriconsepLogic= new AutoriConsepLogic(connexion);
				autoriconsepLogic.deepSave(detalleautoriconsep.getAutoriConsep(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleautoriconsep.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detalleautoriconsep.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detalleautoriconsep.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(detalleautoriconsep.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detalleautoriconsep.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(detalleautoriconsep.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoDetalleAutoriConsep.class)) {
				EstadoDetalleAutoriConsepDataAccess.save(detalleautoriconsep.getEstadoDetalleAutoriConsep(),connexion);
				EstadoDetalleAutoriConsepLogic estadodetalleautoriconsepLogic= new EstadoDetalleAutoriConsepLogic(connexion);
				estadodetalleautoriconsepLogic.deepSave(detalleautoriconsep.getEstadoDetalleAutoriConsep(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleAutoriConsep.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detalleautoriconsep,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(detalleautoriconsep);
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
			this.deepLoad(this.detalleautoriconsep,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(this.detalleautoriconsep);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleAutoriConsep.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detalleautoriconseps!=null) {
				for(DetalleAutoriConsep detalleautoriconsep:detalleautoriconseps) {
					this.deepLoad(detalleautoriconsep,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(detalleautoriconseps);
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
			if(detalleautoriconseps!=null) {
				for(DetalleAutoriConsep detalleautoriconsep:detalleautoriconseps) {
					this.deepLoad(detalleautoriconsep,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(detalleautoriconseps);
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
			this.getNewConnexionToDeep(DetalleAutoriConsep.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detalleautoriconsep,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleAutoriConsep.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detalleautoriconseps!=null) {
				for(DetalleAutoriConsep detalleautoriconsep:detalleautoriconseps) {
					this.deepSave(detalleautoriconsep,isDeep,deepLoadType,clases);
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
			if(detalleautoriconseps!=null) {
				for(DetalleAutoriConsep detalleautoriconsep:detalleautoriconseps) {
					this.deepSave(detalleautoriconsep,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleAutoriConsepsFK_IdAutoriConsepWithConnection(String sFinalQuery,Pagination pagination,Long id_autori_consep)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAutoriConsep.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAutoriConsep= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAutoriConsep.setParameterSelectionGeneralEqual(ParameterType.LONG,id_autori_consep,DetalleAutoriConsepConstantesFunciones.IDAUTORICONSEP,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAutoriConsep);

			DetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAutoriConsep","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleautoriconseps=detalleautoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(this.detalleautoriconseps);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAutoriConsepsFK_IdAutoriConsep(String sFinalQuery,Pagination pagination,Long id_autori_consep)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAutoriConsep= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAutoriConsep.setParameterSelectionGeneralEqual(ParameterType.LONG,id_autori_consep,DetalleAutoriConsepConstantesFunciones.IDAUTORICONSEP,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAutoriConsep);

			DetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAutoriConsep","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleautoriconseps=detalleautoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(this.detalleautoriconseps);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleAutoriConsepsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAutoriConsep.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleAutoriConsepConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleautoriconseps=detalleautoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(this.detalleautoriconseps);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAutoriConsepsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleAutoriConsepConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleautoriconseps=detalleautoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(this.detalleautoriconseps);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleAutoriConsepsFK_IdEstadoDetalleAutoriConsepWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_detalle_autori_consep)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAutoriConsep.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoDetalleAutoriConsep= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoDetalleAutoriConsep.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_detalle_autori_consep,DetalleAutoriConsepConstantesFunciones.IDESTADODETALLEAUTORICONSEP,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoDetalleAutoriConsep);

			DetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoDetalleAutoriConsep","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleautoriconseps=detalleautoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(this.detalleautoriconseps);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAutoriConsepsFK_IdEstadoDetalleAutoriConsep(String sFinalQuery,Pagination pagination,Long id_estado_detalle_autori_consep)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoDetalleAutoriConsep= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoDetalleAutoriConsep.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_detalle_autori_consep,DetalleAutoriConsepConstantesFunciones.IDESTADODETALLEAUTORICONSEP,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoDetalleAutoriConsep);

			DetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoDetalleAutoriConsep","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleautoriconseps=detalleautoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(this.detalleautoriconseps);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleAutoriConsepsFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAutoriConsep.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleAutoriConsepConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleautoriconseps=detalleautoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(this.detalleautoriconseps);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAutoriConsepsFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleAutoriConsepConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleautoriconseps=detalleautoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(this.detalleautoriconseps);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleAutoriConsepsFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAutoriConsep.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetalleAutoriConsepConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleautoriconseps=detalleautoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(this.detalleautoriconseps);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAutoriConsepsFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetalleAutoriConsepConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetalleAutoriConsepLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleautoriconseps=detalleautoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAutoriConsepConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAutoriConsep(this.detalleautoriconseps);
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
			if(DetalleAutoriConsepConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleAutoriConsepDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleAutoriConsep detalleautoriconsep,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleAutoriConsepConstantesFunciones.ISCONAUDITORIA) {
				if(detalleautoriconsep.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleAutoriConsepDataAccess.TABLENAME, detalleautoriconsep.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleAutoriConsepConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleAutoriConsepLogic.registrarAuditoriaDetallesDetalleAutoriConsep(connexion,detalleautoriconsep,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detalleautoriconsep.getIsDeleted()) {
					/*if(!detalleautoriconsep.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleAutoriConsepDataAccess.TABLENAME, detalleautoriconsep.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleAutoriConsepLogic.registrarAuditoriaDetallesDetalleAutoriConsep(connexion,detalleautoriconsep,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleAutoriConsepDataAccess.TABLENAME, detalleautoriconsep.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detalleautoriconsep.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleAutoriConsepDataAccess.TABLENAME, detalleautoriconsep.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleAutoriConsepConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleAutoriConsepLogic.registrarAuditoriaDetallesDetalleAutoriConsep(connexion,detalleautoriconsep,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleAutoriConsep(Connexion connexion,DetalleAutoriConsep detalleautoriconsep)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detalleautoriconsep.getIsNew()||!detalleautoriconsep.getid_autori_consep().equals(detalleautoriconsep.getDetalleAutoriConsepOriginal().getid_autori_consep()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleautoriconsep.getDetalleAutoriConsepOriginal().getid_autori_consep()!=null)
				{
					strValorActual=detalleautoriconsep.getDetalleAutoriConsepOriginal().getid_autori_consep().toString();
				}
				if(detalleautoriconsep.getid_autori_consep()!=null)
				{
					strValorNuevo=detalleautoriconsep.getid_autori_consep().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAutoriConsepConstantesFunciones.IDAUTORICONSEP,strValorActual,strValorNuevo);
			}	
			
			if(detalleautoriconsep.getIsNew()||!detalleautoriconsep.getid_empresa().equals(detalleautoriconsep.getDetalleAutoriConsepOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleautoriconsep.getDetalleAutoriConsepOriginal().getid_empresa()!=null)
				{
					strValorActual=detalleautoriconsep.getDetalleAutoriConsepOriginal().getid_empresa().toString();
				}
				if(detalleautoriconsep.getid_empresa()!=null)
				{
					strValorNuevo=detalleautoriconsep.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAutoriConsepConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detalleautoriconsep.getIsNew()||!detalleautoriconsep.getid_producto().equals(detalleautoriconsep.getDetalleAutoriConsepOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleautoriconsep.getDetalleAutoriConsepOriginal().getid_producto()!=null)
				{
					strValorActual=detalleautoriconsep.getDetalleAutoriConsepOriginal().getid_producto().toString();
				}
				if(detalleautoriconsep.getid_producto()!=null)
				{
					strValorNuevo=detalleautoriconsep.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAutoriConsepConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleautoriconsep.getIsNew()||!detalleautoriconsep.getid_unidad().equals(detalleautoriconsep.getDetalleAutoriConsepOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleautoriconsep.getDetalleAutoriConsepOriginal().getid_unidad()!=null)
				{
					strValorActual=detalleautoriconsep.getDetalleAutoriConsepOriginal().getid_unidad().toString();
				}
				if(detalleautoriconsep.getid_unidad()!=null)
				{
					strValorNuevo=detalleautoriconsep.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAutoriConsepConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detalleautoriconsep.getIsNew()||!detalleautoriconsep.getcantidad_anio().equals(detalleautoriconsep.getDetalleAutoriConsepOriginal().getcantidad_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleautoriconsep.getDetalleAutoriConsepOriginal().getcantidad_anio()!=null)
				{
					strValorActual=detalleautoriconsep.getDetalleAutoriConsepOriginal().getcantidad_anio().toString();
				}
				if(detalleautoriconsep.getcantidad_anio()!=null)
				{
					strValorNuevo=detalleautoriconsep.getcantidad_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAutoriConsepConstantesFunciones.CANTIDADANIO,strValorActual,strValorNuevo);
			}	
			
			if(detalleautoriconsep.getIsNew()||!detalleautoriconsep.getcantidad_saldo().equals(detalleautoriconsep.getDetalleAutoriConsepOriginal().getcantidad_saldo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleautoriconsep.getDetalleAutoriConsepOriginal().getcantidad_saldo()!=null)
				{
					strValorActual=detalleautoriconsep.getDetalleAutoriConsepOriginal().getcantidad_saldo().toString();
				}
				if(detalleautoriconsep.getcantidad_saldo()!=null)
				{
					strValorNuevo=detalleautoriconsep.getcantidad_saldo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAutoriConsepConstantesFunciones.CANTIDADSALDO,strValorActual,strValorNuevo);
			}	
			
			if(detalleautoriconsep.getIsNew()||!detalleautoriconsep.getid_estado_detalle_autori_consep().equals(detalleautoriconsep.getDetalleAutoriConsepOriginal().getid_estado_detalle_autori_consep()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleautoriconsep.getDetalleAutoriConsepOriginal().getid_estado_detalle_autori_consep()!=null)
				{
					strValorActual=detalleautoriconsep.getDetalleAutoriConsepOriginal().getid_estado_detalle_autori_consep().toString();
				}
				if(detalleautoriconsep.getid_estado_detalle_autori_consep()!=null)
				{
					strValorNuevo=detalleautoriconsep.getid_estado_detalle_autori_consep().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAutoriConsepConstantesFunciones.IDESTADODETALLEAUTORICONSEP,strValorActual,strValorNuevo);
			}	
			
			if(detalleautoriconsep.getIsNew()||!detalleautoriconsep.getnombre().equals(detalleautoriconsep.getDetalleAutoriConsepOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleautoriconsep.getDetalleAutoriConsepOriginal().getnombre()!=null)
				{
					strValorActual=detalleautoriconsep.getDetalleAutoriConsepOriginal().getnombre();
				}
				if(detalleautoriconsep.getnombre()!=null)
				{
					strValorNuevo=detalleautoriconsep.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAutoriConsepConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleAutoriConsepRelacionesWithConnection(DetalleAutoriConsep detalleautoriconsep) throws Exception {

		if(!detalleautoriconsep.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleAutoriConsepRelacionesBase(detalleautoriconsep,true);
		}
	}

	public void saveDetalleAutoriConsepRelaciones(DetalleAutoriConsep detalleautoriconsep)throws Exception {

		if(!detalleautoriconsep.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleAutoriConsepRelacionesBase(detalleautoriconsep,false);
		}
	}

	public void saveDetalleAutoriConsepRelacionesBase(DetalleAutoriConsep detalleautoriconsep,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleAutoriConsep-saveRelacionesWithConnection");}
	

			this.setDetalleAutoriConsep(detalleautoriconsep);

			if(DetalleAutoriConsepLogicAdditional.validarSaveRelaciones(detalleautoriconsep,this)) {

				DetalleAutoriConsepLogicAdditional.updateRelacionesToSave(detalleautoriconsep,this);

				if((detalleautoriconsep.getIsNew()||detalleautoriconsep.getIsChanged())&&!detalleautoriconsep.getIsDeleted()) {
					this.saveDetalleAutoriConsep();
					this.saveDetalleAutoriConsepRelacionesDetalles();

				} else if(detalleautoriconsep.getIsDeleted()) {
					this.saveDetalleAutoriConsepRelacionesDetalles();
					this.saveDetalleAutoriConsep();
				}

				DetalleAutoriConsepLogicAdditional.updateRelacionesToSaveAfter(detalleautoriconsep,this);

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
	
	
	private void saveDetalleAutoriConsepRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleAutoriConsep(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleAutoriConsepConstantesFunciones.getClassesForeignKeysOfDetalleAutoriConsep(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleAutoriConsep(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleAutoriConsepConstantesFunciones.getClassesRelationshipsOfDetalleAutoriConsep(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
