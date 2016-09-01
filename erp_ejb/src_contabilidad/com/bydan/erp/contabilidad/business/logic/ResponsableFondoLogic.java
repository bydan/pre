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
import com.bydan.erp.contabilidad.util.ResponsableFondoConstantesFunciones;
import com.bydan.erp.contabilidad.util.ResponsableFondoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.ResponsableFondoParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.ResponsableFondo;
import com.bydan.erp.contabilidad.business.logic.ResponsableFondoLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;








@SuppressWarnings("unused")
public class ResponsableFondoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ResponsableFondoLogic.class);
	
	protected ResponsableFondoDataAccess responsablefondoDataAccess; 	
	protected ResponsableFondo responsablefondo;
	protected List<ResponsableFondo> responsablefondos;
	protected Object responsablefondoObject;	
	protected List<Object> responsablefondosObject;
	
	public static ClassValidator<ResponsableFondo> responsablefondoValidator = new ClassValidator<ResponsableFondo>(ResponsableFondo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ResponsableFondoLogicAdditional responsablefondoLogicAdditional=null;
	
	public ResponsableFondoLogicAdditional getResponsableFondoLogicAdditional() {
		return this.responsablefondoLogicAdditional;
	}
	
	public void setResponsableFondoLogicAdditional(ResponsableFondoLogicAdditional responsablefondoLogicAdditional) {
		try {
			this.responsablefondoLogicAdditional=responsablefondoLogicAdditional;
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
	
	
	
	
	public  ResponsableFondoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.responsablefondoDataAccess = new ResponsableFondoDataAccess();
			
			this.responsablefondos= new ArrayList<ResponsableFondo>();
			this.responsablefondo= new ResponsableFondo();
			
			this.responsablefondoObject=new Object();
			this.responsablefondosObject=new ArrayList<Object>();
				
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
			
			this.responsablefondoDataAccess.setConnexionType(this.connexionType);
			this.responsablefondoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ResponsableFondoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.responsablefondoDataAccess = new ResponsableFondoDataAccess();
			this.responsablefondos= new ArrayList<ResponsableFondo>();
			this.responsablefondo= new ResponsableFondo();
			this.responsablefondoObject=new Object();
			this.responsablefondosObject=new ArrayList<Object>();
			
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
			
			this.responsablefondoDataAccess.setConnexionType(this.connexionType);
			this.responsablefondoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ResponsableFondo getResponsableFondo() throws Exception {	
		ResponsableFondoLogicAdditional.checkResponsableFondoToGet(responsablefondo,this.datosCliente,this.arrDatoGeneral);
		ResponsableFondoLogicAdditional.updateResponsableFondoToGet(responsablefondo,this.arrDatoGeneral);
		
		return responsablefondo;
	}
		
	public void setResponsableFondo(ResponsableFondo newResponsableFondo) {
		this.responsablefondo = newResponsableFondo;
	}
	
	public ResponsableFondoDataAccess getResponsableFondoDataAccess() {
		return responsablefondoDataAccess;
	}
	
	public void setResponsableFondoDataAccess(ResponsableFondoDataAccess newresponsablefondoDataAccess) {
		this.responsablefondoDataAccess = newresponsablefondoDataAccess;
	}
	
	public List<ResponsableFondo> getResponsableFondos() throws Exception {		
		this.quitarResponsableFondosNulos();
		
		ResponsableFondoLogicAdditional.checkResponsableFondoToGets(responsablefondos,this.datosCliente,this.arrDatoGeneral);
		
		for (ResponsableFondo responsablefondoLocal: responsablefondos ) {
			ResponsableFondoLogicAdditional.updateResponsableFondoToGet(responsablefondoLocal,this.arrDatoGeneral);
		}
		
		return responsablefondos;
	}
	
	public void setResponsableFondos(List<ResponsableFondo> newResponsableFondos) {
		this.responsablefondos = newResponsableFondos;
	}
	
	public Object getResponsableFondoObject() {	
		this.responsablefondoObject=this.responsablefondoDataAccess.getEntityObject();
		return this.responsablefondoObject;
	}
		
	public void setResponsableFondoObject(Object newResponsableFondoObject) {
		this.responsablefondoObject = newResponsableFondoObject;
	}
	
	public List<Object> getResponsableFondosObject() {		
		this.responsablefondosObject=this.responsablefondoDataAccess.getEntitiesObject();
		return this.responsablefondosObject;
	}
		
	public void setResponsableFondosObject(List<Object> newResponsableFondosObject) {
		this.responsablefondosObject = newResponsableFondosObject;
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
		
		if(this.responsablefondoDataAccess!=null) {
			this.responsablefondoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableFondo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			responsablefondoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			responsablefondoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		responsablefondo = new  ResponsableFondo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableFondo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			responsablefondo=responsablefondoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.responsablefondo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ResponsableFondoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableFondo(this.responsablefondo);
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
		responsablefondo = new  ResponsableFondo();
		  		  
        try {
			
			responsablefondo=responsablefondoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.responsablefondo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ResponsableFondoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableFondo(this.responsablefondo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		responsablefondo = new  ResponsableFondo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableFondo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			responsablefondo=responsablefondoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.responsablefondo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ResponsableFondoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableFondo(this.responsablefondo);
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
		responsablefondo = new  ResponsableFondo();
		  		  
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
		responsablefondo = new  ResponsableFondo();
		  		  
        try {
			
			responsablefondo=responsablefondoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.responsablefondo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ResponsableFondoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableFondo(this.responsablefondo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		responsablefondo = new  ResponsableFondo();
		  		  
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
		responsablefondo = new  ResponsableFondo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableFondo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =responsablefondoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		responsablefondo = new  ResponsableFondo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=responsablefondoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		responsablefondo = new  ResponsableFondo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableFondo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =responsablefondoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		responsablefondo = new  ResponsableFondo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=responsablefondoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		responsablefondo = new  ResponsableFondo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableFondo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =responsablefondoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		responsablefondo = new  ResponsableFondo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=responsablefondoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		responsablefondos = new  ArrayList<ResponsableFondo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableFondo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ResponsableFondoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsablefondos=responsablefondoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarResponsableFondo(responsablefondos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableFondoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableFondo(this.responsablefondos);
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
		responsablefondos = new  ArrayList<ResponsableFondo>();
		  		  
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
		responsablefondos = new  ArrayList<ResponsableFondo>();
		  		  
        try {			
			ResponsableFondoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsablefondos=responsablefondoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarResponsableFondo(responsablefondos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableFondoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableFondo(this.responsablefondos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		responsablefondos = new  ArrayList<ResponsableFondo>();
		  		  
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
		responsablefondos = new  ArrayList<ResponsableFondo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableFondo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ResponsableFondoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsablefondos=responsablefondoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarResponsableFondo(responsablefondos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableFondoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableFondo(this.responsablefondos);
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
		responsablefondos = new  ArrayList<ResponsableFondo>();
		  		  
        try {
			ResponsableFondoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsablefondos=responsablefondoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarResponsableFondo(responsablefondos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableFondoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableFondo(this.responsablefondos);
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
		responsablefondos = new  ArrayList<ResponsableFondo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableFondo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ResponsableFondoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsablefondos=responsablefondoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarResponsableFondo(responsablefondos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableFondoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableFondo(this.responsablefondos);
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
		responsablefondos = new  ArrayList<ResponsableFondo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ResponsableFondoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsablefondos=responsablefondoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarResponsableFondo(responsablefondos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableFondoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableFondo(this.responsablefondos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		responsablefondo = new  ResponsableFondo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableFondo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ResponsableFondoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsablefondo=responsablefondoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarResponsableFondo(responsablefondo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableFondoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableFondo(this.responsablefondo);
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
		responsablefondo = new  ResponsableFondo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ResponsableFondoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsablefondo=responsablefondoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarResponsableFondo(responsablefondo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableFondoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableFondo(this.responsablefondo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		responsablefondos = new  ArrayList<ResponsableFondo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableFondo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ResponsableFondoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsablefondos=responsablefondoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarResponsableFondo(responsablefondos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableFondoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableFondo(this.responsablefondos);
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
		responsablefondos = new  ArrayList<ResponsableFondo>();
		  		  
        try {
			ResponsableFondoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsablefondos=responsablefondoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarResponsableFondo(responsablefondos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableFondoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableFondo(this.responsablefondos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosResponsableFondosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		responsablefondos = new  ArrayList<ResponsableFondo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableFondo.class.getSimpleName()+"-getTodosResponsableFondosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ResponsableFondoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsablefondos=responsablefondoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarResponsableFondo(responsablefondos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableFondoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableFondo(this.responsablefondos);
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
	
	public  void  getTodosResponsableFondos(String sFinalQuery,Pagination pagination)throws Exception {
		responsablefondos = new  ArrayList<ResponsableFondo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ResponsableFondoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			responsablefondos=responsablefondoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarResponsableFondo(responsablefondos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResponsableFondoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableFondo(this.responsablefondos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarResponsableFondo(ResponsableFondo responsablefondo) throws Exception {
		Boolean estaValidado=false;
		
		if(responsablefondo.getIsNew() || responsablefondo.getIsChanged()) { 
			this.invalidValues = responsablefondoValidator.getInvalidValues(responsablefondo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(responsablefondo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarResponsableFondo(List<ResponsableFondo> ResponsableFondos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ResponsableFondo responsablefondoLocal:responsablefondos) {				
			estaValidadoObjeto=this.validarGuardarResponsableFondo(responsablefondoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarResponsableFondo(List<ResponsableFondo> ResponsableFondos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarResponsableFondo(responsablefondos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarResponsableFondo(ResponsableFondo ResponsableFondo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarResponsableFondo(responsablefondo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ResponsableFondo responsablefondo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+responsablefondo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ResponsableFondoConstantesFunciones.getResponsableFondoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"responsablefondo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ResponsableFondoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ResponsableFondoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveResponsableFondoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableFondo.class.getSimpleName()+"-saveResponsableFondoWithConnection");connexion.begin();			
			
			ResponsableFondoLogicAdditional.checkResponsableFondoToSave(this.responsablefondo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ResponsableFondoLogicAdditional.updateResponsableFondoToSave(this.responsablefondo,this.arrDatoGeneral);
			
			ResponsableFondoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.responsablefondo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowResponsableFondo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarResponsableFondo(this.responsablefondo)) {
				ResponsableFondoDataAccess.save(this.responsablefondo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.responsablefondo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ResponsableFondoLogicAdditional.checkResponsableFondoToSaveAfter(this.responsablefondo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowResponsableFondo();
			
			connexion.commit();			
			
			if(this.responsablefondo.getIsDeleted()) {
				this.responsablefondo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveResponsableFondo()throws Exception {	
		try {	
			
			ResponsableFondoLogicAdditional.checkResponsableFondoToSave(this.responsablefondo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ResponsableFondoLogicAdditional.updateResponsableFondoToSave(this.responsablefondo,this.arrDatoGeneral);
			
			ResponsableFondoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.responsablefondo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarResponsableFondo(this.responsablefondo)) {			
				ResponsableFondoDataAccess.save(this.responsablefondo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.responsablefondo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ResponsableFondoLogicAdditional.checkResponsableFondoToSaveAfter(this.responsablefondo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.responsablefondo.getIsDeleted()) {
				this.responsablefondo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveResponsableFondosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableFondo.class.getSimpleName()+"-saveResponsableFondosWithConnection");connexion.begin();			
			
			ResponsableFondoLogicAdditional.checkResponsableFondoToSaves(responsablefondos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowResponsableFondos();
			
			Boolean validadoTodosResponsableFondo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ResponsableFondo responsablefondoLocal:responsablefondos) {		
				if(responsablefondoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ResponsableFondoLogicAdditional.updateResponsableFondoToSave(responsablefondoLocal,this.arrDatoGeneral);
	        	
				ResponsableFondoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),responsablefondoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarResponsableFondo(responsablefondoLocal)) {
					ResponsableFondoDataAccess.save(responsablefondoLocal, connexion);				
				} else {
					validadoTodosResponsableFondo=false;
				}
			}
			
			if(!validadoTodosResponsableFondo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ResponsableFondoLogicAdditional.checkResponsableFondoToSavesAfter(responsablefondos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowResponsableFondos();
			
			connexion.commit();		
			
			this.quitarResponsableFondosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveResponsableFondos()throws Exception {				
		 try {	
			ResponsableFondoLogicAdditional.checkResponsableFondoToSaves(responsablefondos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosResponsableFondo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ResponsableFondo responsablefondoLocal:responsablefondos) {				
				if(responsablefondoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ResponsableFondoLogicAdditional.updateResponsableFondoToSave(responsablefondoLocal,this.arrDatoGeneral);
	        	
				ResponsableFondoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),responsablefondoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarResponsableFondo(responsablefondoLocal)) {				
					ResponsableFondoDataAccess.save(responsablefondoLocal, connexion);				
				} else {
					validadoTodosResponsableFondo=false;
				}
			}
			
			if(!validadoTodosResponsableFondo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ResponsableFondoLogicAdditional.checkResponsableFondoToSavesAfter(responsablefondos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarResponsableFondosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ResponsableFondoParameterReturnGeneral procesarAccionResponsableFondos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ResponsableFondo> responsablefondos,ResponsableFondoParameterReturnGeneral responsablefondoParameterGeneral)throws Exception {
		 try {	
			ResponsableFondoParameterReturnGeneral responsablefondoReturnGeneral=new ResponsableFondoParameterReturnGeneral();
	
			ResponsableFondoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,responsablefondos,responsablefondoParameterGeneral,responsablefondoReturnGeneral);
			
			return responsablefondoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ResponsableFondoParameterReturnGeneral procesarAccionResponsableFondosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ResponsableFondo> responsablefondos,ResponsableFondoParameterReturnGeneral responsablefondoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableFondo.class.getSimpleName()+"-procesarAccionResponsableFondosWithConnection");connexion.begin();			
			
			ResponsableFondoParameterReturnGeneral responsablefondoReturnGeneral=new ResponsableFondoParameterReturnGeneral();
	
			ResponsableFondoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,responsablefondos,responsablefondoParameterGeneral,responsablefondoReturnGeneral);
			
			this.connexion.commit();
			
			return responsablefondoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ResponsableFondoParameterReturnGeneral procesarEventosResponsableFondos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ResponsableFondo> responsablefondos,ResponsableFondo responsablefondo,ResponsableFondoParameterReturnGeneral responsablefondoParameterGeneral,Boolean isEsNuevoResponsableFondo,ArrayList<Classe> clases)throws Exception {
		 try {	
			ResponsableFondoParameterReturnGeneral responsablefondoReturnGeneral=new ResponsableFondoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				responsablefondoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ResponsableFondoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,responsablefondos,responsablefondo,responsablefondoParameterGeneral,responsablefondoReturnGeneral,isEsNuevoResponsableFondo,clases);
			
			return responsablefondoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ResponsableFondoParameterReturnGeneral procesarEventosResponsableFondosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ResponsableFondo> responsablefondos,ResponsableFondo responsablefondo,ResponsableFondoParameterReturnGeneral responsablefondoParameterGeneral,Boolean isEsNuevoResponsableFondo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableFondo.class.getSimpleName()+"-procesarEventosResponsableFondosWithConnection");connexion.begin();			
			
			ResponsableFondoParameterReturnGeneral responsablefondoReturnGeneral=new ResponsableFondoParameterReturnGeneral();
	
			responsablefondoReturnGeneral.setResponsableFondo(responsablefondo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				responsablefondoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ResponsableFondoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,responsablefondos,responsablefondo,responsablefondoParameterGeneral,responsablefondoReturnGeneral,isEsNuevoResponsableFondo,clases);
			
			this.connexion.commit();
			
			return responsablefondoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ResponsableFondoParameterReturnGeneral procesarImportacionResponsableFondosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ResponsableFondoParameterReturnGeneral responsablefondoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableFondo.class.getSimpleName()+"-procesarImportacionResponsableFondosWithConnection");connexion.begin();			
			
			ResponsableFondoParameterReturnGeneral responsablefondoReturnGeneral=new ResponsableFondoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.responsablefondos=new ArrayList<ResponsableFondo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.responsablefondo=new ResponsableFondo();
				
				
				if(conColumnasBase) {this.responsablefondo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.responsablefondo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.responsablefondo.setsecuencial(Long.parseLong(arrColumnas[iColumn++]));
				this.responsablefondo.setvalor_caja(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.responsablefondos.add(this.responsablefondo);
			}
			
			this.saveResponsableFondos();
			
			this.connexion.commit();
			
			responsablefondoReturnGeneral.setConRetornoEstaProcesado(true);
			responsablefondoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return responsablefondoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarResponsableFondosEliminados() throws Exception {				
		
		List<ResponsableFondo> responsablefondosAux= new ArrayList<ResponsableFondo>();
		
		for(ResponsableFondo responsablefondo:responsablefondos) {
			if(!responsablefondo.getIsDeleted()) {
				responsablefondosAux.add(responsablefondo);
			}
		}
		
		responsablefondos=responsablefondosAux;
	}
	
	public void quitarResponsableFondosNulos() throws Exception {				
		
		List<ResponsableFondo> responsablefondosAux= new ArrayList<ResponsableFondo>();
		
		for(ResponsableFondo responsablefondo : this.responsablefondos) {
			if(responsablefondo==null) {
				responsablefondosAux.add(responsablefondo);
			}
		}
		
		//this.responsablefondos=responsablefondosAux;
		
		this.responsablefondos.removeAll(responsablefondosAux);
	}
	
	public void getSetVersionRowResponsableFondoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(responsablefondo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((responsablefondo.getIsDeleted() || (responsablefondo.getIsChanged()&&!responsablefondo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=responsablefondoDataAccess.getSetVersionRowResponsableFondo(connexion,responsablefondo.getId());
				
				if(!responsablefondo.getVersionRow().equals(timestamp)) {	
					responsablefondo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				responsablefondo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowResponsableFondo()throws Exception {	
		
		if(responsablefondo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((responsablefondo.getIsDeleted() || (responsablefondo.getIsChanged()&&!responsablefondo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=responsablefondoDataAccess.getSetVersionRowResponsableFondo(connexion,responsablefondo.getId());
			
			try {							
				if(!responsablefondo.getVersionRow().equals(timestamp)) {	
					responsablefondo.setVersionRow(timestamp);
				}
				
				responsablefondo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowResponsableFondosWithConnection()throws Exception {	
		if(responsablefondos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ResponsableFondo responsablefondoAux:responsablefondos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(responsablefondoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(responsablefondoAux.getIsDeleted() || (responsablefondoAux.getIsChanged()&&!responsablefondoAux.getIsNew())) {
						
						timestamp=responsablefondoDataAccess.getSetVersionRowResponsableFondo(connexion,responsablefondoAux.getId());
						
						if(!responsablefondo.getVersionRow().equals(timestamp)) {	
							responsablefondoAux.setVersionRow(timestamp);
						}
								
						responsablefondoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowResponsableFondos()throws Exception {	
		if(responsablefondos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ResponsableFondo responsablefondoAux:responsablefondos) {
					if(responsablefondoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(responsablefondoAux.getIsDeleted() || (responsablefondoAux.getIsChanged()&&!responsablefondoAux.getIsNew())) {
						
						timestamp=responsablefondoDataAccess.getSetVersionRowResponsableFondo(connexion,responsablefondoAux.getId());
						
						if(!responsablefondoAux.getVersionRow().equals(timestamp)) {	
							responsablefondoAux.setVersionRow(timestamp);
						}
						
													
						responsablefondoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ResponsableFondoParameterReturnGeneral cargarCombosLoteForeignKeyResponsableFondoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEmpleado) throws Exception {
		ResponsableFondoParameterReturnGeneral  responsablefondoReturnGeneral =new ResponsableFondoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableFondo.class.getSimpleName()+"-cargarCombosLoteForeignKeyResponsableFondoWithConnection");connexion.begin();
			
			responsablefondoReturnGeneral =new ResponsableFondoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			responsablefondoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			responsablefondoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			responsablefondoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return responsablefondoReturnGeneral;
	}
	
	public ResponsableFondoParameterReturnGeneral cargarCombosLoteForeignKeyResponsableFondo(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEmpleado) throws Exception {
		ResponsableFondoParameterReturnGeneral  responsablefondoReturnGeneral =new ResponsableFondoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			responsablefondoReturnGeneral =new ResponsableFondoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			responsablefondoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			responsablefondoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			responsablefondoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return responsablefondoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyResponsableFondoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			FacturaProveedorLogic facturaproveedorLogic=new FacturaProveedorLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableFondo.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyResponsableFondoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(FacturaProveedor.class));
											
			

			facturaproveedorLogic.setConnexion(this.getConnexion());
			facturaproveedorLogic.setDatosCliente(this.datosCliente);
			facturaproveedorLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(ResponsableFondo responsablefondo:this.responsablefondos) {
				

				classes=new ArrayList<Classe>();
				classes=FacturaProveedorConstantesFunciones.getClassesForeignKeysOfFacturaProveedor(new ArrayList<Classe>(),DeepLoadType.NONE);

				facturaproveedorLogic.setFacturaProveedors(responsablefondo.facturaproveedors);
				facturaproveedorLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(ResponsableFondo responsablefondo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ResponsableFondoLogicAdditional.updateResponsableFondoToGet(responsablefondo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		responsablefondo.setEmpresa(responsablefondoDataAccess.getEmpresa(connexion,responsablefondo));
		responsablefondo.setSucursal(responsablefondoDataAccess.getSucursal(connexion,responsablefondo));
		responsablefondo.setEmpleado(responsablefondoDataAccess.getEmpleado(connexion,responsablefondo));
		responsablefondo.setFacturaProveedors(responsablefondoDataAccess.getFacturaProveedors(connexion,responsablefondo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				responsablefondo.setEmpresa(responsablefondoDataAccess.getEmpresa(connexion,responsablefondo));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				responsablefondo.setSucursal(responsablefondoDataAccess.getSucursal(connexion,responsablefondo));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				responsablefondo.setEmpleado(responsablefondoDataAccess.getEmpleado(connexion,responsablefondo));
				continue;
			}

			if(clas.clas.equals(FacturaProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				responsablefondo.setFacturaProveedors(responsablefondoDataAccess.getFacturaProveedors(connexion,responsablefondo));

				if(this.isConDeep) {
					FacturaProveedorLogic facturaproveedorLogic= new FacturaProveedorLogic(this.connexion);
					facturaproveedorLogic.setFacturaProveedors(responsablefondo.getFacturaProveedors());
					ArrayList<Classe> classesLocal=FacturaProveedorConstantesFunciones.getClassesForeignKeysOfFacturaProveedor(new ArrayList<Classe>(),DeepLoadType.NONE);
					facturaproveedorLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FacturaProveedorConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedor(facturaproveedorLogic.getFacturaProveedors());
					responsablefondo.setFacturaProveedors(facturaproveedorLogic.getFacturaProveedors());
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
			responsablefondo.setEmpresa(responsablefondoDataAccess.getEmpresa(connexion,responsablefondo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			responsablefondo.setSucursal(responsablefondoDataAccess.getSucursal(connexion,responsablefondo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			responsablefondo.setEmpleado(responsablefondoDataAccess.getEmpleado(connexion,responsablefondo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FacturaProveedor.class));
			responsablefondo.setFacturaProveedors(responsablefondoDataAccess.getFacturaProveedors(connexion,responsablefondo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		responsablefondo.setEmpresa(responsablefondoDataAccess.getEmpresa(connexion,responsablefondo));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(responsablefondo.getEmpresa(),isDeep,deepLoadType,clases);
				
		responsablefondo.setSucursal(responsablefondoDataAccess.getSucursal(connexion,responsablefondo));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(responsablefondo.getSucursal(),isDeep,deepLoadType,clases);
				
		responsablefondo.setEmpleado(responsablefondoDataAccess.getEmpleado(connexion,responsablefondo));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(responsablefondo.getEmpleado(),isDeep,deepLoadType,clases);
				

		responsablefondo.setFacturaProveedors(responsablefondoDataAccess.getFacturaProveedors(connexion,responsablefondo));

		for(FacturaProveedor facturaproveedor:responsablefondo.getFacturaProveedors()) {
			FacturaProveedorLogic facturaproveedorLogic= new FacturaProveedorLogic(connexion);
			facturaproveedorLogic.deepLoad(facturaproveedor,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				responsablefondo.setEmpresa(responsablefondoDataAccess.getEmpresa(connexion,responsablefondo));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(responsablefondo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				responsablefondo.setSucursal(responsablefondoDataAccess.getSucursal(connexion,responsablefondo));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(responsablefondo.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				responsablefondo.setEmpleado(responsablefondoDataAccess.getEmpleado(connexion,responsablefondo));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(responsablefondo.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FacturaProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				responsablefondo.setFacturaProveedors(responsablefondoDataAccess.getFacturaProveedors(connexion,responsablefondo));

				for(FacturaProveedor facturaproveedor:responsablefondo.getFacturaProveedors()) {
					FacturaProveedorLogic facturaproveedorLogic= new FacturaProveedorLogic(connexion);
					facturaproveedorLogic.deepLoad(facturaproveedor,isDeep,deepLoadType,clases);
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
			responsablefondo.setEmpresa(responsablefondoDataAccess.getEmpresa(connexion,responsablefondo));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(responsablefondo.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			responsablefondo.setSucursal(responsablefondoDataAccess.getSucursal(connexion,responsablefondo));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(responsablefondo.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			responsablefondo.setEmpleado(responsablefondoDataAccess.getEmpleado(connexion,responsablefondo));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(responsablefondo.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FacturaProveedor.class));
			responsablefondo.setFacturaProveedors(responsablefondoDataAccess.getFacturaProveedors(connexion,responsablefondo));

			for(FacturaProveedor facturaproveedor:responsablefondo.getFacturaProveedors()) {
				FacturaProveedorLogic facturaproveedorLogic= new FacturaProveedorLogic(connexion);
				facturaproveedorLogic.deepLoad(facturaproveedor,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ResponsableFondo responsablefondo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ResponsableFondoLogicAdditional.updateResponsableFondoToSave(responsablefondo,this.arrDatoGeneral);
			
ResponsableFondoDataAccess.save(responsablefondo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(responsablefondo.getEmpresa(),connexion);

		SucursalDataAccess.save(responsablefondo.getSucursal(),connexion);

		EmpleadoDataAccess.save(responsablefondo.getEmpleado(),connexion);

		for(FacturaProveedor facturaproveedor:responsablefondo.getFacturaProveedors()) {
			facturaproveedor.setid_responsable_fondo(responsablefondo.getId());
			FacturaProveedorDataAccess.save(facturaproveedor,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(responsablefondo.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(responsablefondo.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(responsablefondo.getEmpleado(),connexion);
				continue;
			}


			if(clas.clas.equals(FacturaProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FacturaProveedor facturaproveedor:responsablefondo.getFacturaProveedors()) {
					facturaproveedor.setid_responsable_fondo(responsablefondo.getId());
					FacturaProveedorDataAccess.save(facturaproveedor,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(responsablefondo.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(responsablefondo.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(responsablefondo.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(responsablefondo.getSucursal(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(responsablefondo.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(responsablefondo.getEmpleado(),isDeep,deepLoadType,clases);
				

		for(FacturaProveedor facturaproveedor:responsablefondo.getFacturaProveedors()) {
			FacturaProveedorLogic facturaproveedorLogic= new FacturaProveedorLogic(connexion);
			facturaproveedor.setid_responsable_fondo(responsablefondo.getId());
			FacturaProveedorDataAccess.save(facturaproveedor,connexion);
			facturaproveedorLogic.deepSave(facturaproveedor,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(responsablefondo.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(responsablefondo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(responsablefondo.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(responsablefondo.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(responsablefondo.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(responsablefondo.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(FacturaProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FacturaProveedor facturaproveedor:responsablefondo.getFacturaProveedors()) {
					FacturaProveedorLogic facturaproveedorLogic= new FacturaProveedorLogic(connexion);
					facturaproveedor.setid_responsable_fondo(responsablefondo.getId());
					FacturaProveedorDataAccess.save(facturaproveedor,connexion);
					facturaproveedorLogic.deepSave(facturaproveedor,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(ResponsableFondo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(responsablefondo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ResponsableFondoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableFondo(responsablefondo);
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
			this.deepLoad(this.responsablefondo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ResponsableFondoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableFondo(this.responsablefondo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ResponsableFondo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(responsablefondos!=null) {
				for(ResponsableFondo responsablefondo:responsablefondos) {
					this.deepLoad(responsablefondo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ResponsableFondoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableFondo(responsablefondos);
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
			if(responsablefondos!=null) {
				for(ResponsableFondo responsablefondo:responsablefondos) {
					this.deepLoad(responsablefondo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ResponsableFondoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableFondo(responsablefondos);
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
			this.getNewConnexionToDeep(ResponsableFondo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(responsablefondo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ResponsableFondo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(responsablefondos!=null) {
				for(ResponsableFondo responsablefondo:responsablefondos) {
					this.deepSave(responsablefondo,isDeep,deepLoadType,clases);
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
			if(responsablefondos!=null) {
				for(ResponsableFondo responsablefondo:responsablefondos) {
					this.deepSave(responsablefondo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getResponsableFondosFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableFondo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,ResponsableFondoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			ResponsableFondoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsablefondos=responsablefondoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableFondoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableFondo(this.responsablefondos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getResponsableFondosFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,ResponsableFondoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			ResponsableFondoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsablefondos=responsablefondoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableFondoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableFondo(this.responsablefondos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getResponsableFondosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableFondo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ResponsableFondoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ResponsableFondoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsablefondos=responsablefondoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableFondoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableFondo(this.responsablefondos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getResponsableFondosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ResponsableFondoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ResponsableFondoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsablefondos=responsablefondoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableFondoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableFondo(this.responsablefondos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getResponsableFondosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableFondo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ResponsableFondoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ResponsableFondoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsablefondos=responsablefondoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableFondoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableFondo(this.responsablefondos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getResponsableFondosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ResponsableFondoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ResponsableFondoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			responsablefondos=responsablefondoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResponsableFondoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableFondo(this.responsablefondos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getResponsableFondoPorEmpresaPorSucursalPorEmpleadoWithConnection(Long id_empresa,Long id_sucursal,Long id_empleado)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResponsableFondo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ResponsableFondoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ResponsableFondoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,ResponsableFondoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			responsablefondo=responsablefondoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.responsablefondo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				ResponsableFondoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableFondo(this.responsablefondo);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getResponsableFondoPorEmpresaPorSucursalPorEmpleado(Long id_empresa,Long id_sucursal,Long id_empleado)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ResponsableFondoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ResponsableFondoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,ResponsableFondoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			responsablefondo=responsablefondoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.responsablefondo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				ResponsableFondoConstantesFunciones.refrescarForeignKeysDescripcionesResponsableFondo(this.responsablefondo);
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
			if(ResponsableFondoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ResponsableFondoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ResponsableFondo responsablefondo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ResponsableFondoConstantesFunciones.ISCONAUDITORIA) {
				if(responsablefondo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ResponsableFondoDataAccess.TABLENAME, responsablefondo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ResponsableFondoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ResponsableFondoLogic.registrarAuditoriaDetallesResponsableFondo(connexion,responsablefondo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(responsablefondo.getIsDeleted()) {
					/*if(!responsablefondo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ResponsableFondoDataAccess.TABLENAME, responsablefondo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ResponsableFondoLogic.registrarAuditoriaDetallesResponsableFondo(connexion,responsablefondo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ResponsableFondoDataAccess.TABLENAME, responsablefondo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(responsablefondo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ResponsableFondoDataAccess.TABLENAME, responsablefondo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ResponsableFondoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ResponsableFondoLogic.registrarAuditoriaDetallesResponsableFondo(connexion,responsablefondo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesResponsableFondo(Connexion connexion,ResponsableFondo responsablefondo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(responsablefondo.getIsNew()||!responsablefondo.getid_empresa().equals(responsablefondo.getResponsableFondoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(responsablefondo.getResponsableFondoOriginal().getid_empresa()!=null)
				{
					strValorActual=responsablefondo.getResponsableFondoOriginal().getid_empresa().toString();
				}
				if(responsablefondo.getid_empresa()!=null)
				{
					strValorNuevo=responsablefondo.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResponsableFondoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(responsablefondo.getIsNew()||!responsablefondo.getid_sucursal().equals(responsablefondo.getResponsableFondoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(responsablefondo.getResponsableFondoOriginal().getid_sucursal()!=null)
				{
					strValorActual=responsablefondo.getResponsableFondoOriginal().getid_sucursal().toString();
				}
				if(responsablefondo.getid_sucursal()!=null)
				{
					strValorNuevo=responsablefondo.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResponsableFondoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(responsablefondo.getIsNew()||!responsablefondo.getid_empleado().equals(responsablefondo.getResponsableFondoOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(responsablefondo.getResponsableFondoOriginal().getid_empleado()!=null)
				{
					strValorActual=responsablefondo.getResponsableFondoOriginal().getid_empleado().toString();
				}
				if(responsablefondo.getid_empleado()!=null)
				{
					strValorNuevo=responsablefondo.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResponsableFondoConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(responsablefondo.getIsNew()||!responsablefondo.getsecuencial().equals(responsablefondo.getResponsableFondoOriginal().getsecuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(responsablefondo.getResponsableFondoOriginal().getsecuencial()!=null)
				{
					strValorActual=responsablefondo.getResponsableFondoOriginal().getsecuencial().toString();
				}
				if(responsablefondo.getsecuencial()!=null)
				{
					strValorNuevo=responsablefondo.getsecuencial().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResponsableFondoConstantesFunciones.SECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(responsablefondo.getIsNew()||!responsablefondo.getvalor_caja().equals(responsablefondo.getResponsableFondoOriginal().getvalor_caja()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(responsablefondo.getResponsableFondoOriginal().getvalor_caja()!=null)
				{
					strValorActual=responsablefondo.getResponsableFondoOriginal().getvalor_caja().toString();
				}
				if(responsablefondo.getvalor_caja()!=null)
				{
					strValorNuevo=responsablefondo.getvalor_caja().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResponsableFondoConstantesFunciones.VALORCAJA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveResponsableFondoRelacionesWithConnection(ResponsableFondo responsablefondo,List<FacturaProveedor> facturaproveedors) throws Exception {

		if(!responsablefondo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveResponsableFondoRelacionesBase(responsablefondo,facturaproveedors,true);
		}
	}

	public void saveResponsableFondoRelaciones(ResponsableFondo responsablefondo,List<FacturaProveedor> facturaproveedors)throws Exception {

		if(!responsablefondo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveResponsableFondoRelacionesBase(responsablefondo,facturaproveedors,false);
		}
	}

	public void saveResponsableFondoRelacionesBase(ResponsableFondo responsablefondo,List<FacturaProveedor> facturaproveedors,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ResponsableFondo-saveRelacionesWithConnection");}
	
			responsablefondo.setFacturaProveedors(facturaproveedors);

			this.setResponsableFondo(responsablefondo);

			if(ResponsableFondoLogicAdditional.validarSaveRelaciones(responsablefondo,this)) {

				ResponsableFondoLogicAdditional.updateRelacionesToSave(responsablefondo,this);

				if((responsablefondo.getIsNew()||responsablefondo.getIsChanged())&&!responsablefondo.getIsDeleted()) {
					this.saveResponsableFondo();
					this.saveResponsableFondoRelacionesDetalles(facturaproveedors);

				} else if(responsablefondo.getIsDeleted()) {
					this.saveResponsableFondoRelacionesDetalles(facturaproveedors);
					this.saveResponsableFondo();
				}

				ResponsableFondoLogicAdditional.updateRelacionesToSaveAfter(responsablefondo,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			FacturaProveedorConstantesFunciones.InicializarGeneralEntityAuxiliaresFacturaProveedors(facturaproveedors,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveResponsableFondoRelacionesDetalles(List<FacturaProveedor> facturaproveedors)throws Exception {
		try {
	

			Long idResponsableFondoActual=this.getResponsableFondo().getId();

			FacturaProveedorLogic facturaproveedorLogic_Desde_ResponsableFondo=new FacturaProveedorLogic();
			facturaproveedorLogic_Desde_ResponsableFondo.setFacturaProveedors(facturaproveedors);

			facturaproveedorLogic_Desde_ResponsableFondo.setConnexion(this.getConnexion());
			facturaproveedorLogic_Desde_ResponsableFondo.setDatosCliente(this.datosCliente);

			for(FacturaProveedor facturaproveedor_Desde_ResponsableFondo:facturaproveedorLogic_Desde_ResponsableFondo.getFacturaProveedors()) {
				facturaproveedor_Desde_ResponsableFondo.setid_responsable_fondo(idResponsableFondoActual);

				facturaproveedorLogic_Desde_ResponsableFondo.setFacturaProveedor(facturaproveedor_Desde_ResponsableFondo);
				facturaproveedorLogic_Desde_ResponsableFondo.saveFacturaProveedor();

				Long idFacturaProveedorActual=facturaproveedor_Desde_ResponsableFondo.getId();

				DetalleFacturaProveedorLogic detallefacturaproveedorLogic_Desde_FacturaProveedor=new DetalleFacturaProveedorLogic();

				if(facturaproveedor_Desde_ResponsableFondo.getDetalleFacturaProveedors()==null){
					facturaproveedor_Desde_ResponsableFondo.setDetalleFacturaProveedors(new ArrayList<DetalleFacturaProveedor>());
				}

				detallefacturaproveedorLogic_Desde_FacturaProveedor.setDetalleFacturaProveedors(facturaproveedor_Desde_ResponsableFondo.getDetalleFacturaProveedors());

				detallefacturaproveedorLogic_Desde_FacturaProveedor.setConnexion(this.getConnexion());
				detallefacturaproveedorLogic_Desde_FacturaProveedor.setDatosCliente(this.datosCliente);

				for(DetalleFacturaProveedor detallefacturaproveedor_Desde_FacturaProveedor:detallefacturaproveedorLogic_Desde_FacturaProveedor.getDetalleFacturaProveedors()) {
					detallefacturaproveedor_Desde_FacturaProveedor.setid_factura_proveedor(idFacturaProveedorActual);
				}

				detallefacturaproveedorLogic_Desde_FacturaProveedor.saveDetalleFacturaProveedors();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfResponsableFondo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ResponsableFondoConstantesFunciones.getClassesForeignKeysOfResponsableFondo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfResponsableFondo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ResponsableFondoConstantesFunciones.getClassesRelationshipsOfResponsableFondo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
