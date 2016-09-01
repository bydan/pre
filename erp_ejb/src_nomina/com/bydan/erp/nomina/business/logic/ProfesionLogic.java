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
import com.bydan.erp.nomina.util.ProfesionConstantesFunciones;
import com.bydan.erp.nomina.util.ProfesionParameterReturnGeneral;
//import com.bydan.erp.nomina.util.ProfesionParameterGeneral;
import com.bydan.erp.nomina.business.entity.Profesion;
import com.bydan.erp.nomina.business.logic.ProfesionLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.sris.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.puntoventa.business.logic.*;
import com.bydan.erp.activosfijos.business.logic.*;
import com.bydan.erp.importaciones.business.logic.*;
import com.bydan.erp.produccion.business.logic.*;


import com.bydan.erp.cartera.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;


import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.produccion.business.dataaccess.*;








@SuppressWarnings("unused")
public class ProfesionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ProfesionLogic.class);
	
	protected ProfesionDataAccess profesionDataAccess; 	
	protected Profesion profesion;
	protected List<Profesion> profesions;
	protected Object profesionObject;	
	protected List<Object> profesionsObject;
	
	public static ClassValidator<Profesion> profesionValidator = new ClassValidator<Profesion>(Profesion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ProfesionLogicAdditional profesionLogicAdditional=null;
	
	public ProfesionLogicAdditional getProfesionLogicAdditional() {
		return this.profesionLogicAdditional;
	}
	
	public void setProfesionLogicAdditional(ProfesionLogicAdditional profesionLogicAdditional) {
		try {
			this.profesionLogicAdditional=profesionLogicAdditional;
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
	
	
	
	
	public  ProfesionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.profesionDataAccess = new ProfesionDataAccess();
			
			this.profesions= new ArrayList<Profesion>();
			this.profesion= new Profesion();
			
			this.profesionObject=new Object();
			this.profesionsObject=new ArrayList<Object>();
				
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
			
			this.profesionDataAccess.setConnexionType(this.connexionType);
			this.profesionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProfesionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.profesionDataAccess = new ProfesionDataAccess();
			this.profesions= new ArrayList<Profesion>();
			this.profesion= new Profesion();
			this.profesionObject=new Object();
			this.profesionsObject=new ArrayList<Object>();
			
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
			
			this.profesionDataAccess.setConnexionType(this.connexionType);
			this.profesionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Profesion getProfesion() throws Exception {	
		ProfesionLogicAdditional.checkProfesionToGet(profesion,this.datosCliente,this.arrDatoGeneral);
		ProfesionLogicAdditional.updateProfesionToGet(profesion,this.arrDatoGeneral);
		
		return profesion;
	}
		
	public void setProfesion(Profesion newProfesion) {
		this.profesion = newProfesion;
	}
	
	public ProfesionDataAccess getProfesionDataAccess() {
		return profesionDataAccess;
	}
	
	public void setProfesionDataAccess(ProfesionDataAccess newprofesionDataAccess) {
		this.profesionDataAccess = newprofesionDataAccess;
	}
	
	public List<Profesion> getProfesions() throws Exception {		
		this.quitarProfesionsNulos();
		
		ProfesionLogicAdditional.checkProfesionToGets(profesions,this.datosCliente,this.arrDatoGeneral);
		
		for (Profesion profesionLocal: profesions ) {
			ProfesionLogicAdditional.updateProfesionToGet(profesionLocal,this.arrDatoGeneral);
		}
		
		return profesions;
	}
	
	public void setProfesions(List<Profesion> newProfesions) {
		this.profesions = newProfesions;
	}
	
	public Object getProfesionObject() {	
		this.profesionObject=this.profesionDataAccess.getEntityObject();
		return this.profesionObject;
	}
		
	public void setProfesionObject(Object newProfesionObject) {
		this.profesionObject = newProfesionObject;
	}
	
	public List<Object> getProfesionsObject() {		
		this.profesionsObject=this.profesionDataAccess.getEntitiesObject();
		return this.profesionsObject;
	}
		
	public void setProfesionsObject(List<Object> newProfesionsObject) {
		this.profesionsObject = newProfesionsObject;
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
		
		if(this.profesionDataAccess!=null) {
			this.profesionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Profesion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			profesionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			profesionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		profesion = new  Profesion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Profesion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			profesion=profesionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.profesion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProfesionConstantesFunciones.refrescarForeignKeysDescripcionesProfesion(this.profesion);
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
		profesion = new  Profesion();
		  		  
        try {
			
			profesion=profesionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.profesion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProfesionConstantesFunciones.refrescarForeignKeysDescripcionesProfesion(this.profesion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		profesion = new  Profesion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Profesion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			profesion=profesionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.profesion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProfesionConstantesFunciones.refrescarForeignKeysDescripcionesProfesion(this.profesion);
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
		profesion = new  Profesion();
		  		  
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
		profesion = new  Profesion();
		  		  
        try {
			
			profesion=profesionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.profesion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProfesionConstantesFunciones.refrescarForeignKeysDescripcionesProfesion(this.profesion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		profesion = new  Profesion();
		  		  
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
		profesion = new  Profesion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Profesion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =profesionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		profesion = new  Profesion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=profesionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		profesion = new  Profesion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Profesion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =profesionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		profesion = new  Profesion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=profesionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		profesion = new  Profesion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Profesion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =profesionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		profesion = new  Profesion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=profesionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		profesions = new  ArrayList<Profesion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Profesion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ProfesionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			profesions=profesionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProfesion(profesions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProfesionConstantesFunciones.refrescarForeignKeysDescripcionesProfesion(this.profesions);
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
		profesions = new  ArrayList<Profesion>();
		  		  
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
		profesions = new  ArrayList<Profesion>();
		  		  
        try {			
			ProfesionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			profesions=profesionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarProfesion(profesions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProfesionConstantesFunciones.refrescarForeignKeysDescripcionesProfesion(this.profesions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		profesions = new  ArrayList<Profesion>();
		  		  
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
		profesions = new  ArrayList<Profesion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Profesion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ProfesionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			profesions=profesionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProfesion(profesions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProfesionConstantesFunciones.refrescarForeignKeysDescripcionesProfesion(this.profesions);
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
		profesions = new  ArrayList<Profesion>();
		  		  
        try {
			ProfesionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			profesions=profesionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProfesion(profesions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProfesionConstantesFunciones.refrescarForeignKeysDescripcionesProfesion(this.profesions);
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
		profesions = new  ArrayList<Profesion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Profesion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProfesionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			profesions=profesionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProfesion(profesions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProfesionConstantesFunciones.refrescarForeignKeysDescripcionesProfesion(this.profesions);
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
		profesions = new  ArrayList<Profesion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProfesionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			profesions=profesionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProfesion(profesions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProfesionConstantesFunciones.refrescarForeignKeysDescripcionesProfesion(this.profesions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		profesion = new  Profesion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Profesion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProfesionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			profesion=profesionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProfesion(profesion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProfesionConstantesFunciones.refrescarForeignKeysDescripcionesProfesion(this.profesion);
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
		profesion = new  Profesion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProfesionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			profesion=profesionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProfesion(profesion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProfesionConstantesFunciones.refrescarForeignKeysDescripcionesProfesion(this.profesion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		profesions = new  ArrayList<Profesion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Profesion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ProfesionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			profesions=profesionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProfesion(profesions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProfesionConstantesFunciones.refrescarForeignKeysDescripcionesProfesion(this.profesions);
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
		profesions = new  ArrayList<Profesion>();
		  		  
        try {
			ProfesionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			profesions=profesionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProfesion(profesions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProfesionConstantesFunciones.refrescarForeignKeysDescripcionesProfesion(this.profesions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosProfesionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		profesions = new  ArrayList<Profesion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Profesion.class.getSimpleName()+"-getTodosProfesionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProfesionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			profesions=profesionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProfesion(profesions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProfesionConstantesFunciones.refrescarForeignKeysDescripcionesProfesion(this.profesions);
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
	
	public  void  getTodosProfesions(String sFinalQuery,Pagination pagination)throws Exception {
		profesions = new  ArrayList<Profesion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProfesionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			profesions=profesionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProfesion(profesions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProfesionConstantesFunciones.refrescarForeignKeysDescripcionesProfesion(this.profesions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarProfesion(Profesion profesion) throws Exception {
		Boolean estaValidado=false;
		
		if(profesion.getIsNew() || profesion.getIsChanged()) { 
			this.invalidValues = profesionValidator.getInvalidValues(profesion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(profesion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarProfesion(List<Profesion> Profesions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Profesion profesionLocal:profesions) {				
			estaValidadoObjeto=this.validarGuardarProfesion(profesionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarProfesion(List<Profesion> Profesions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProfesion(profesions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarProfesion(Profesion Profesion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProfesion(profesion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Profesion profesion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+profesion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ProfesionConstantesFunciones.getProfesionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"profesion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ProfesionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ProfesionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveProfesionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Profesion.class.getSimpleName()+"-saveProfesionWithConnection");connexion.begin();			
			
			ProfesionLogicAdditional.checkProfesionToSave(this.profesion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProfesionLogicAdditional.updateProfesionToSave(this.profesion,this.arrDatoGeneral);
			
			ProfesionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.profesion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowProfesion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProfesion(this.profesion)) {
				ProfesionDataAccess.save(this.profesion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.profesion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProfesionLogicAdditional.checkProfesionToSaveAfter(this.profesion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProfesion();
			
			connexion.commit();			
			
			if(this.profesion.getIsDeleted()) {
				this.profesion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveProfesion()throws Exception {	
		try {	
			
			ProfesionLogicAdditional.checkProfesionToSave(this.profesion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProfesionLogicAdditional.updateProfesionToSave(this.profesion,this.arrDatoGeneral);
			
			ProfesionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.profesion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProfesion(this.profesion)) {			
				ProfesionDataAccess.save(this.profesion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.profesion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProfesionLogicAdditional.checkProfesionToSaveAfter(this.profesion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.profesion.getIsDeleted()) {
				this.profesion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveProfesionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Profesion.class.getSimpleName()+"-saveProfesionsWithConnection");connexion.begin();			
			
			ProfesionLogicAdditional.checkProfesionToSaves(profesions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowProfesions();
			
			Boolean validadoTodosProfesion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Profesion profesionLocal:profesions) {		
				if(profesionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProfesionLogicAdditional.updateProfesionToSave(profesionLocal,this.arrDatoGeneral);
	        	
				ProfesionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),profesionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProfesion(profesionLocal)) {
					ProfesionDataAccess.save(profesionLocal, connexion);				
				} else {
					validadoTodosProfesion=false;
				}
			}
			
			if(!validadoTodosProfesion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProfesionLogicAdditional.checkProfesionToSavesAfter(profesions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProfesions();
			
			connexion.commit();		
			
			this.quitarProfesionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveProfesions()throws Exception {				
		 try {	
			ProfesionLogicAdditional.checkProfesionToSaves(profesions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosProfesion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Profesion profesionLocal:profesions) {				
				if(profesionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProfesionLogicAdditional.updateProfesionToSave(profesionLocal,this.arrDatoGeneral);
	        	
				ProfesionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),profesionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProfesion(profesionLocal)) {				
					ProfesionDataAccess.save(profesionLocal, connexion);				
				} else {
					validadoTodosProfesion=false;
				}
			}
			
			if(!validadoTodosProfesion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProfesionLogicAdditional.checkProfesionToSavesAfter(profesions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarProfesionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProfesionParameterReturnGeneral procesarAccionProfesions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Profesion> profesions,ProfesionParameterReturnGeneral profesionParameterGeneral)throws Exception {
		 try {	
			ProfesionParameterReturnGeneral profesionReturnGeneral=new ProfesionParameterReturnGeneral();
	
			ProfesionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,profesions,profesionParameterGeneral,profesionReturnGeneral);
			
			return profesionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProfesionParameterReturnGeneral procesarAccionProfesionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Profesion> profesions,ProfesionParameterReturnGeneral profesionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Profesion.class.getSimpleName()+"-procesarAccionProfesionsWithConnection");connexion.begin();			
			
			ProfesionParameterReturnGeneral profesionReturnGeneral=new ProfesionParameterReturnGeneral();
	
			ProfesionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,profesions,profesionParameterGeneral,profesionReturnGeneral);
			
			this.connexion.commit();
			
			return profesionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProfesionParameterReturnGeneral procesarEventosProfesions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Profesion> profesions,Profesion profesion,ProfesionParameterReturnGeneral profesionParameterGeneral,Boolean isEsNuevoProfesion,ArrayList<Classe> clases)throws Exception {
		 try {	
			ProfesionParameterReturnGeneral profesionReturnGeneral=new ProfesionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				profesionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProfesionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,profesions,profesion,profesionParameterGeneral,profesionReturnGeneral,isEsNuevoProfesion,clases);
			
			return profesionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ProfesionParameterReturnGeneral procesarEventosProfesionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Profesion> profesions,Profesion profesion,ProfesionParameterReturnGeneral profesionParameterGeneral,Boolean isEsNuevoProfesion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Profesion.class.getSimpleName()+"-procesarEventosProfesionsWithConnection");connexion.begin();			
			
			ProfesionParameterReturnGeneral profesionReturnGeneral=new ProfesionParameterReturnGeneral();
	
			profesionReturnGeneral.setProfesion(profesion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				profesionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProfesionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,profesions,profesion,profesionParameterGeneral,profesionReturnGeneral,isEsNuevoProfesion,clases);
			
			this.connexion.commit();
			
			return profesionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProfesionParameterReturnGeneral procesarImportacionProfesionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ProfesionParameterReturnGeneral profesionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Profesion.class.getSimpleName()+"-procesarImportacionProfesionsWithConnection");connexion.begin();			
			
			ProfesionParameterReturnGeneral profesionReturnGeneral=new ProfesionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.profesions=new ArrayList<Profesion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.profesion=new Profesion();
				
				
				if(conColumnasBase) {this.profesion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.profesion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.profesion.setcodigo(arrColumnas[iColumn++]);
				this.profesion.setnombre(arrColumnas[iColumn++]);
				
				this.profesions.add(this.profesion);
			}
			
			this.saveProfesions();
			
			this.connexion.commit();
			
			profesionReturnGeneral.setConRetornoEstaProcesado(true);
			profesionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return profesionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarProfesionsEliminados() throws Exception {				
		
		List<Profesion> profesionsAux= new ArrayList<Profesion>();
		
		for(Profesion profesion:profesions) {
			if(!profesion.getIsDeleted()) {
				profesionsAux.add(profesion);
			}
		}
		
		profesions=profesionsAux;
	}
	
	public void quitarProfesionsNulos() throws Exception {				
		
		List<Profesion> profesionsAux= new ArrayList<Profesion>();
		
		for(Profesion profesion : this.profesions) {
			if(profesion==null) {
				profesionsAux.add(profesion);
			}
		}
		
		//this.profesions=profesionsAux;
		
		this.profesions.removeAll(profesionsAux);
	}
	
	public void getSetVersionRowProfesionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(profesion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((profesion.getIsDeleted() || (profesion.getIsChanged()&&!profesion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=profesionDataAccess.getSetVersionRowProfesion(connexion,profesion.getId());
				
				if(!profesion.getVersionRow().equals(timestamp)) {	
					profesion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				profesion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowProfesion()throws Exception {	
		
		if(profesion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((profesion.getIsDeleted() || (profesion.getIsChanged()&&!profesion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=profesionDataAccess.getSetVersionRowProfesion(connexion,profesion.getId());
			
			try {							
				if(!profesion.getVersionRow().equals(timestamp)) {	
					profesion.setVersionRow(timestamp);
				}
				
				profesion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowProfesionsWithConnection()throws Exception {	
		if(profesions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Profesion profesionAux:profesions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(profesionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(profesionAux.getIsDeleted() || (profesionAux.getIsChanged()&&!profesionAux.getIsNew())) {
						
						timestamp=profesionDataAccess.getSetVersionRowProfesion(connexion,profesionAux.getId());
						
						if(!profesion.getVersionRow().equals(timestamp)) {	
							profesionAux.setVersionRow(timestamp);
						}
								
						profesionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowProfesions()throws Exception {	
		if(profesions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Profesion profesionAux:profesions) {
					if(profesionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(profesionAux.getIsDeleted() || (profesionAux.getIsChanged()&&!profesionAux.getIsNew())) {
						
						timestamp=profesionDataAccess.getSetVersionRowProfesion(connexion,profesionAux.getId());
						
						if(!profesionAux.getVersionRow().equals(timestamp)) {	
							profesionAux.setVersionRow(timestamp);
						}
						
													
						profesionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyProfesionWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ClienteLogic clienteLogic=new ClienteLogic();
			ProfesionEmpleaLogic profesionempleaLogic=new ProfesionEmpleaLogic();
			ReferenciaLogic referenciaLogic=new ReferenciaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Profesion.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyProfesionWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Cliente.class));
			classes.add(new Classe(ProfesionEmplea.class));
			classes.add(new Classe(Referencia.class));
											
			

			clienteLogic.setConnexion(this.getConnexion());
			clienteLogic.setDatosCliente(this.datosCliente);
			clienteLogic.setIsConRefrescarForeignKeys(true);

			profesionempleaLogic.setConnexion(this.getConnexion());
			profesionempleaLogic.setDatosCliente(this.datosCliente);
			profesionempleaLogic.setIsConRefrescarForeignKeys(true);

			referenciaLogic.setConnexion(this.getConnexion());
			referenciaLogic.setDatosCliente(this.datosCliente);
			referenciaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Profesion profesion:this.profesions) {
				

				classes=new ArrayList<Classe>();
				classes=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				clienteLogic.setClientes(profesion.clientes);
				clienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProfesionEmpleaConstantesFunciones.getClassesForeignKeysOfProfesionEmplea(new ArrayList<Classe>(),DeepLoadType.NONE);

				profesionempleaLogic.setProfesionEmpleas(profesion.profesionempleas);
				profesionempleaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ReferenciaConstantesFunciones.getClassesForeignKeysOfReferencia(new ArrayList<Classe>(),DeepLoadType.NONE);

				referenciaLogic.setReferencias(profesion.referencias);
				referenciaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Profesion profesion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProfesionLogicAdditional.updateProfesionToGet(profesion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		profesion.setClientes(profesionDataAccess.getClientes(connexion,profesion));
		profesion.setProfesionEmpleas(profesionDataAccess.getProfesionEmpleas(connexion,profesion));
		profesion.setReferencias(profesionDataAccess.getReferencias(connexion,profesion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				profesion.setClientes(profesionDataAccess.getClientes(connexion,profesion));

				if(this.isConDeep) {
					ClienteLogic clienteLogic= new ClienteLogic(this.connexion);
					clienteLogic.setClientes(profesion.getClientes());
					ArrayList<Classe> classesLocal=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					clienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(clienteLogic.getClientes());
					profesion.setClientes(clienteLogic.getClientes());
				}

				continue;
			}

			if(clas.clas.equals(ProfesionEmplea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				profesion.setProfesionEmpleas(profesionDataAccess.getProfesionEmpleas(connexion,profesion));

				if(this.isConDeep) {
					ProfesionEmpleaLogic profesionempleaLogic= new ProfesionEmpleaLogic(this.connexion);
					profesionempleaLogic.setProfesionEmpleas(profesion.getProfesionEmpleas());
					ArrayList<Classe> classesLocal=ProfesionEmpleaConstantesFunciones.getClassesForeignKeysOfProfesionEmplea(new ArrayList<Classe>(),DeepLoadType.NONE);
					profesionempleaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProfesionEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesProfesionEmplea(profesionempleaLogic.getProfesionEmpleas());
					profesion.setProfesionEmpleas(profesionempleaLogic.getProfesionEmpleas());
				}

				continue;
			}

			if(clas.clas.equals(Referencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				profesion.setReferencias(profesionDataAccess.getReferencias(connexion,profesion));

				if(this.isConDeep) {
					ReferenciaLogic referenciaLogic= new ReferenciaLogic(this.connexion);
					referenciaLogic.setReferencias(profesion.getReferencias());
					ArrayList<Classe> classesLocal=ReferenciaConstantesFunciones.getClassesForeignKeysOfReferencia(new ArrayList<Classe>(),DeepLoadType.NONE);
					referenciaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesReferencia(referenciaLogic.getReferencias());
					profesion.setReferencias(referenciaLogic.getReferencias());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


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
			profesion.setClientes(profesionDataAccess.getClientes(connexion,profesion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProfesionEmplea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProfesionEmplea.class));
			profesion.setProfesionEmpleas(profesionDataAccess.getProfesionEmpleas(connexion,profesion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Referencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Referencia.class));
			profesion.setReferencias(profesionDataAccess.getReferencias(connexion,profesion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		profesion.setClientes(profesionDataAccess.getClientes(connexion,profesion));

		for(Cliente cliente:profesion.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
		}

		profesion.setProfesionEmpleas(profesionDataAccess.getProfesionEmpleas(connexion,profesion));

		for(ProfesionEmplea profesionemplea:profesion.getProfesionEmpleas()) {
			ProfesionEmpleaLogic profesionempleaLogic= new ProfesionEmpleaLogic(connexion);
			profesionempleaLogic.deepLoad(profesionemplea,isDeep,deepLoadType,clases);
		}

		profesion.setReferencias(profesionDataAccess.getReferencias(connexion,profesion));

		for(Referencia referencia:profesion.getReferencias()) {
			ReferenciaLogic referenciaLogic= new ReferenciaLogic(connexion);
			referenciaLogic.deepLoad(referencia,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				profesion.setClientes(profesionDataAccess.getClientes(connexion,profesion));

				for(Cliente cliente:profesion.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProfesionEmplea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				profesion.setProfesionEmpleas(profesionDataAccess.getProfesionEmpleas(connexion,profesion));

				for(ProfesionEmplea profesionemplea:profesion.getProfesionEmpleas()) {
					ProfesionEmpleaLogic profesionempleaLogic= new ProfesionEmpleaLogic(connexion);
					profesionempleaLogic.deepLoad(profesionemplea,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Referencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				profesion.setReferencias(profesionDataAccess.getReferencias(connexion,profesion));

				for(Referencia referencia:profesion.getReferencias()) {
					ReferenciaLogic referenciaLogic= new ReferenciaLogic(connexion);
					referenciaLogic.deepLoad(referencia,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


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
			profesion.setClientes(profesionDataAccess.getClientes(connexion,profesion));

			for(Cliente cliente:profesion.getClientes()) {
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProfesionEmplea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProfesionEmplea.class));
			profesion.setProfesionEmpleas(profesionDataAccess.getProfesionEmpleas(connexion,profesion));

			for(ProfesionEmplea profesionemplea:profesion.getProfesionEmpleas()) {
				ProfesionEmpleaLogic profesionempleaLogic= new ProfesionEmpleaLogic(connexion);
				profesionempleaLogic.deepLoad(profesionemplea,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Referencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Referencia.class));
			profesion.setReferencias(profesionDataAccess.getReferencias(connexion,profesion));

			for(Referencia referencia:profesion.getReferencias()) {
				ReferenciaLogic referenciaLogic= new ReferenciaLogic(connexion);
				referenciaLogic.deepLoad(referencia,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Profesion profesion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ProfesionLogicAdditional.updateProfesionToSave(profesion,this.arrDatoGeneral);
			
ProfesionDataAccess.save(profesion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(Cliente cliente:profesion.getClientes()) {
			cliente.setid_profesion(profesion.getId());
			ClienteDataAccess.save(cliente,connexion);
		}

		for(ProfesionEmplea profesionemplea:profesion.getProfesionEmpleas()) {
			profesionemplea.setid_profesion(profesion.getId());
			ProfesionEmpleaDataAccess.save(profesionemplea,connexion);
		}

		for(Referencia referencia:profesion.getReferencias()) {
			referencia.setid_profesion(profesion.getId());
			ReferenciaDataAccess.save(referencia,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:profesion.getClientes()) {
					cliente.setid_profesion(profesion.getId());
					ClienteDataAccess.save(cliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ProfesionEmplea.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProfesionEmplea profesionemplea:profesion.getProfesionEmpleas()) {
					profesionemplea.setid_profesion(profesion.getId());
					ProfesionEmpleaDataAccess.save(profesionemplea,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Referencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Referencia referencia:profesion.getReferencias()) {
					referencia.setid_profesion(profesion.getId());
					ReferenciaDataAccess.save(referencia,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(Cliente cliente:profesion.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			cliente.setid_profesion(profesion.getId());
			ClienteDataAccess.save(cliente,connexion);
			clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
		}

		for(ProfesionEmplea profesionemplea:profesion.getProfesionEmpleas()) {
			ProfesionEmpleaLogic profesionempleaLogic= new ProfesionEmpleaLogic(connexion);
			profesionemplea.setid_profesion(profesion.getId());
			ProfesionEmpleaDataAccess.save(profesionemplea,connexion);
			profesionempleaLogic.deepSave(profesionemplea,isDeep,deepLoadType,clases);
		}

		for(Referencia referencia:profesion.getReferencias()) {
			ReferenciaLogic referenciaLogic= new ReferenciaLogic(connexion);
			referencia.setid_profesion(profesion.getId());
			ReferenciaDataAccess.save(referencia,connexion);
			referenciaLogic.deepSave(referencia,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:profesion.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					cliente.setid_profesion(profesion.getId());
					ClienteDataAccess.save(cliente,connexion);
					clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProfesionEmplea.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProfesionEmplea profesionemplea:profesion.getProfesionEmpleas()) {
					ProfesionEmpleaLogic profesionempleaLogic= new ProfesionEmpleaLogic(connexion);
					profesionemplea.setid_profesion(profesion.getId());
					ProfesionEmpleaDataAccess.save(profesionemplea,connexion);
					profesionempleaLogic.deepSave(profesionemplea,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Referencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Referencia referencia:profesion.getReferencias()) {
					ReferenciaLogic referenciaLogic= new ReferenciaLogic(connexion);
					referencia.setid_profesion(profesion.getId());
					ReferenciaDataAccess.save(referencia,connexion);
					referenciaLogic.deepSave(referencia,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Profesion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(profesion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProfesionConstantesFunciones.refrescarForeignKeysDescripcionesProfesion(profesion);
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
			this.deepLoad(this.profesion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProfesionConstantesFunciones.refrescarForeignKeysDescripcionesProfesion(this.profesion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Profesion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(profesions!=null) {
				for(Profesion profesion:profesions) {
					this.deepLoad(profesion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProfesionConstantesFunciones.refrescarForeignKeysDescripcionesProfesion(profesions);
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
			if(profesions!=null) {
				for(Profesion profesion:profesions) {
					this.deepLoad(profesion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProfesionConstantesFunciones.refrescarForeignKeysDescripcionesProfesion(profesions);
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
			this.getNewConnexionToDeep(Profesion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(profesion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Profesion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(profesions!=null) {
				for(Profesion profesion:profesions) {
					this.deepSave(profesion,isDeep,deepLoadType,clases);
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
			if(profesions!=null) {
				for(Profesion profesion:profesions) {
					this.deepSave(profesion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getProfesionsBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Profesion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",ProfesionConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			ProfesionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			profesions=profesionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProfesionConstantesFunciones.refrescarForeignKeysDescripcionesProfesion(this.profesions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProfesionsBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",ProfesionConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			ProfesionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			profesions=profesionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProfesionConstantesFunciones.refrescarForeignKeysDescripcionesProfesion(this.profesions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProfesionsBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Profesion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",ProfesionConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			ProfesionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			profesions=profesionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProfesionConstantesFunciones.refrescarForeignKeysDescripcionesProfesion(this.profesions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProfesionsBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",ProfesionConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			ProfesionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			profesions=profesionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProfesionConstantesFunciones.refrescarForeignKeysDescripcionesProfesion(this.profesions);
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
			if(ProfesionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ProfesionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Profesion profesion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ProfesionConstantesFunciones.ISCONAUDITORIA) {
				if(profesion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProfesionDataAccess.TABLENAME, profesion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProfesionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProfesionLogic.registrarAuditoriaDetallesProfesion(connexion,profesion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(profesion.getIsDeleted()) {
					/*if(!profesion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ProfesionDataAccess.TABLENAME, profesion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ProfesionLogic.registrarAuditoriaDetallesProfesion(connexion,profesion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProfesionDataAccess.TABLENAME, profesion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(profesion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProfesionDataAccess.TABLENAME, profesion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProfesionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProfesionLogic.registrarAuditoriaDetallesProfesion(connexion,profesion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesProfesion(Connexion connexion,Profesion profesion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(profesion.getIsNew()||!profesion.getcodigo().equals(profesion.getProfesionOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(profesion.getProfesionOriginal().getcodigo()!=null)
				{
					strValorActual=profesion.getProfesionOriginal().getcodigo();
				}
				if(profesion.getcodigo()!=null)
				{
					strValorNuevo=profesion.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProfesionConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(profesion.getIsNew()||!profesion.getnombre().equals(profesion.getProfesionOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(profesion.getProfesionOriginal().getnombre()!=null)
				{
					strValorActual=profesion.getProfesionOriginal().getnombre();
				}
				if(profesion.getnombre()!=null)
				{
					strValorNuevo=profesion.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProfesionConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveProfesionRelacionesWithConnection(Profesion profesion,List<Cliente> clientes,List<ProfesionEmplea> profesionempleas,List<Referencia> referencias) throws Exception {

		if(!profesion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProfesionRelacionesBase(profesion,clientes,profesionempleas,referencias,true);
		}
	}

	public void saveProfesionRelaciones(Profesion profesion,List<Cliente> clientes,List<ProfesionEmplea> profesionempleas,List<Referencia> referencias)throws Exception {

		if(!profesion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProfesionRelacionesBase(profesion,clientes,profesionempleas,referencias,false);
		}
	}

	public void saveProfesionRelacionesBase(Profesion profesion,List<Cliente> clientes,List<ProfesionEmplea> profesionempleas,List<Referencia> referencias,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Profesion-saveRelacionesWithConnection");}
	
			profesion.setClientes(clientes);
			profesion.setProfesionEmpleas(profesionempleas);
			profesion.setReferencias(referencias);

			this.setProfesion(profesion);

				if((profesion.getIsNew()||profesion.getIsChanged())&&!profesion.getIsDeleted()) {
					this.saveProfesion();
					this.saveProfesionRelacionesDetalles(clientes,profesionempleas,referencias);

				} else if(profesion.getIsDeleted()) {
					this.saveProfesionRelacionesDetalles(clientes,profesionempleas,referencias);
					this.saveProfesion();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresClientes(clientes,true,true);
			ProfesionEmpleaConstantesFunciones.InicializarGeneralEntityAuxiliaresProfesionEmpleas(profesionempleas,true,true);
			ReferenciaConstantesFunciones.InicializarGeneralEntityAuxiliaresReferencias(referencias,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveProfesionRelacionesDetalles(List<Cliente> clientes,List<ProfesionEmplea> profesionempleas,List<Referencia> referencias)throws Exception {
		try {
	

			Long idProfesionActual=this.getProfesion().getId();

			ClienteLogic clienteLogic_Desde_Profesion=new ClienteLogic();
			clienteLogic_Desde_Profesion.setClientes(clientes);

			clienteLogic_Desde_Profesion.setConnexion(this.getConnexion());
			clienteLogic_Desde_Profesion.setDatosCliente(this.datosCliente);

			for(Cliente cliente_Desde_Profesion:clienteLogic_Desde_Profesion.getClientes()) {
				cliente_Desde_Profesion.setid_profesion(idProfesionActual);

				clienteLogic_Desde_Profesion.setCliente(cliente_Desde_Profesion);
				clienteLogic_Desde_Profesion.saveCliente();
			}


			ProfesionEmpleaLogic profesionempleaLogic_Desde_Profesion=new ProfesionEmpleaLogic();
			profesionempleaLogic_Desde_Profesion.setProfesionEmpleas(profesionempleas);

			profesionempleaLogic_Desde_Profesion.setConnexion(this.getConnexion());
			profesionempleaLogic_Desde_Profesion.setDatosCliente(this.datosCliente);

			for(ProfesionEmplea profesionemplea_Desde_Profesion:profesionempleaLogic_Desde_Profesion.getProfesionEmpleas()) {
				profesionemplea_Desde_Profesion.setid_profesion(idProfesionActual);
			}

			profesionempleaLogic_Desde_Profesion.saveProfesionEmpleas();

			ReferenciaLogic referenciaLogic_Desde_Profesion=new ReferenciaLogic();
			referenciaLogic_Desde_Profesion.setReferencias(referencias);

			referenciaLogic_Desde_Profesion.setConnexion(this.getConnexion());
			referenciaLogic_Desde_Profesion.setDatosCliente(this.datosCliente);

			for(Referencia referencia_Desde_Profesion:referenciaLogic_Desde_Profesion.getReferencias()) {
				referencia_Desde_Profesion.setid_profesion(idProfesionActual);

				referenciaLogic_Desde_Profesion.setReferencia(referencia_Desde_Profesion);
				referenciaLogic_Desde_Profesion.saveReferencia();

				Long idReferenciaActual=referencia_Desde_Profesion.getId();

				TelefonoReferenciaLogic telefonoreferenciaLogic_Desde_Referencia=new TelefonoReferenciaLogic();

				if(referencia_Desde_Profesion.getTelefonoReferencias()==null){
					referencia_Desde_Profesion.setTelefonoReferencias(new ArrayList<TelefonoReferencia>());
				}

				telefonoreferenciaLogic_Desde_Referencia.setTelefonoReferencias(referencia_Desde_Profesion.getTelefonoReferencias());

				telefonoreferenciaLogic_Desde_Referencia.setConnexion(this.getConnexion());
				telefonoreferenciaLogic_Desde_Referencia.setDatosCliente(this.datosCliente);

				for(TelefonoReferencia telefonoreferencia_Desde_Referencia:telefonoreferenciaLogic_Desde_Referencia.getTelefonoReferencias()) {
					telefonoreferencia_Desde_Referencia.setid_referencia(idReferenciaActual);
				}

				telefonoreferenciaLogic_Desde_Referencia.saveTelefonoReferencias();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfProfesion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProfesionConstantesFunciones.getClassesForeignKeysOfProfesion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProfesion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProfesionConstantesFunciones.getClassesRelationshipsOfProfesion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
