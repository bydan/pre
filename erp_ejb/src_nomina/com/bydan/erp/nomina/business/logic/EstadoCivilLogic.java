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
import com.bydan.erp.nomina.util.EstadoCivilConstantesFunciones;
import com.bydan.erp.nomina.util.EstadoCivilParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EstadoCivilParameterGeneral;
import com.bydan.erp.nomina.business.entity.EstadoCivil;
import com.bydan.erp.nomina.business.logic.EstadoCivilLogicAdditional;
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
public class EstadoCivilLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoCivilLogic.class);
	
	protected EstadoCivilDataAccess estadocivilDataAccess; 	
	protected EstadoCivil estadocivil;
	protected List<EstadoCivil> estadocivils;
	protected Object estadocivilObject;	
	protected List<Object> estadocivilsObject;
	
	public static ClassValidator<EstadoCivil> estadocivilValidator = new ClassValidator<EstadoCivil>(EstadoCivil.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EstadoCivilLogicAdditional estadocivilLogicAdditional=null;
	
	public EstadoCivilLogicAdditional getEstadoCivilLogicAdditional() {
		return this.estadocivilLogicAdditional;
	}
	
	public void setEstadoCivilLogicAdditional(EstadoCivilLogicAdditional estadocivilLogicAdditional) {
		try {
			this.estadocivilLogicAdditional=estadocivilLogicAdditional;
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
	
	
	
	
	public  EstadoCivilLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadocivilDataAccess = new EstadoCivilDataAccess();
			
			this.estadocivils= new ArrayList<EstadoCivil>();
			this.estadocivil= new EstadoCivil();
			
			this.estadocivilObject=new Object();
			this.estadocivilsObject=new ArrayList<Object>();
				
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
			
			this.estadocivilDataAccess.setConnexionType(this.connexionType);
			this.estadocivilDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoCivilLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadocivilDataAccess = new EstadoCivilDataAccess();
			this.estadocivils= new ArrayList<EstadoCivil>();
			this.estadocivil= new EstadoCivil();
			this.estadocivilObject=new Object();
			this.estadocivilsObject=new ArrayList<Object>();
			
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
			
			this.estadocivilDataAccess.setConnexionType(this.connexionType);
			this.estadocivilDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoCivil getEstadoCivil() throws Exception {	
		EstadoCivilLogicAdditional.checkEstadoCivilToGet(estadocivil,this.datosCliente,this.arrDatoGeneral);
		EstadoCivilLogicAdditional.updateEstadoCivilToGet(estadocivil,this.arrDatoGeneral);
		
		return estadocivil;
	}
		
	public void setEstadoCivil(EstadoCivil newEstadoCivil) {
		this.estadocivil = newEstadoCivil;
	}
	
	public EstadoCivilDataAccess getEstadoCivilDataAccess() {
		return estadocivilDataAccess;
	}
	
	public void setEstadoCivilDataAccess(EstadoCivilDataAccess newestadocivilDataAccess) {
		this.estadocivilDataAccess = newestadocivilDataAccess;
	}
	
	public List<EstadoCivil> getEstadoCivils() throws Exception {		
		this.quitarEstadoCivilsNulos();
		
		EstadoCivilLogicAdditional.checkEstadoCivilToGets(estadocivils,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoCivil estadocivilLocal: estadocivils ) {
			EstadoCivilLogicAdditional.updateEstadoCivilToGet(estadocivilLocal,this.arrDatoGeneral);
		}
		
		return estadocivils;
	}
	
	public void setEstadoCivils(List<EstadoCivil> newEstadoCivils) {
		this.estadocivils = newEstadoCivils;
	}
	
	public Object getEstadoCivilObject() {	
		this.estadocivilObject=this.estadocivilDataAccess.getEntityObject();
		return this.estadocivilObject;
	}
		
	public void setEstadoCivilObject(Object newEstadoCivilObject) {
		this.estadocivilObject = newEstadoCivilObject;
	}
	
	public List<Object> getEstadoCivilsObject() {		
		this.estadocivilsObject=this.estadocivilDataAccess.getEntitiesObject();
		return this.estadocivilsObject;
	}
		
	public void setEstadoCivilsObject(List<Object> newEstadoCivilsObject) {
		this.estadocivilsObject = newEstadoCivilsObject;
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
		
		if(this.estadocivilDataAccess!=null) {
			this.estadocivilDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCivil.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadocivilDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadocivilDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadocivil = new  EstadoCivil();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCivil.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadocivil=estadocivilDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadocivil,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoCivilConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCivil(this.estadocivil);
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
		estadocivil = new  EstadoCivil();
		  		  
        try {
			
			estadocivil=estadocivilDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadocivil,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoCivilConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCivil(this.estadocivil);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadocivil = new  EstadoCivil();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCivil.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadocivil=estadocivilDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadocivil,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoCivilConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCivil(this.estadocivil);
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
		estadocivil = new  EstadoCivil();
		  		  
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
		estadocivil = new  EstadoCivil();
		  		  
        try {
			
			estadocivil=estadocivilDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadocivil,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoCivilConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCivil(this.estadocivil);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadocivil = new  EstadoCivil();
		  		  
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
		estadocivil = new  EstadoCivil();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCivil.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadocivilDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadocivil = new  EstadoCivil();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadocivilDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadocivil = new  EstadoCivil();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCivil.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadocivilDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadocivil = new  EstadoCivil();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadocivilDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadocivil = new  EstadoCivil();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCivil.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadocivilDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadocivil = new  EstadoCivil();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadocivilDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadocivils = new  ArrayList<EstadoCivil>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCivil.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoCivilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocivils=estadocivilDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoCivil(estadocivils);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCivilConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCivil(this.estadocivils);
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
		estadocivils = new  ArrayList<EstadoCivil>();
		  		  
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
		estadocivils = new  ArrayList<EstadoCivil>();
		  		  
        try {			
			EstadoCivilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocivils=estadocivilDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoCivil(estadocivils);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCivilConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCivil(this.estadocivils);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadocivils = new  ArrayList<EstadoCivil>();
		  		  
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
		estadocivils = new  ArrayList<EstadoCivil>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCivil.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoCivilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocivils=estadocivilDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoCivil(estadocivils);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCivilConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCivil(this.estadocivils);
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
		estadocivils = new  ArrayList<EstadoCivil>();
		  		  
        try {
			EstadoCivilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocivils=estadocivilDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoCivil(estadocivils);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCivilConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCivil(this.estadocivils);
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
		estadocivils = new  ArrayList<EstadoCivil>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCivil.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoCivilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocivils=estadocivilDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoCivil(estadocivils);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCivilConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCivil(this.estadocivils);
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
		estadocivils = new  ArrayList<EstadoCivil>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoCivilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocivils=estadocivilDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoCivil(estadocivils);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCivilConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCivil(this.estadocivils);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadocivil = new  EstadoCivil();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCivil.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoCivilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocivil=estadocivilDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoCivil(estadocivil);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCivilConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCivil(this.estadocivil);
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
		estadocivil = new  EstadoCivil();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoCivilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocivil=estadocivilDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoCivil(estadocivil);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCivilConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCivil(this.estadocivil);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadocivils = new  ArrayList<EstadoCivil>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCivil.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EstadoCivilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocivils=estadocivilDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoCivil(estadocivils);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCivilConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCivil(this.estadocivils);
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
		estadocivils = new  ArrayList<EstadoCivil>();
		  		  
        try {
			EstadoCivilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocivils=estadocivilDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoCivil(estadocivils);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCivilConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCivil(this.estadocivils);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEstadoCivilsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadocivils = new  ArrayList<EstadoCivil>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCivil.class.getSimpleName()+"-getTodosEstadoCivilsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoCivilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocivils=estadocivilDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoCivil(estadocivils);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCivilConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCivil(this.estadocivils);
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
	
	public  void  getTodosEstadoCivils(String sFinalQuery,Pagination pagination)throws Exception {
		estadocivils = new  ArrayList<EstadoCivil>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoCivilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocivils=estadocivilDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoCivil(estadocivils);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCivilConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCivil(this.estadocivils);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoCivil(EstadoCivil estadocivil) throws Exception {
		Boolean estaValidado=false;
		
		if(estadocivil.getIsNew() || estadocivil.getIsChanged()) { 
			this.invalidValues = estadocivilValidator.getInvalidValues(estadocivil);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadocivil);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoCivil(List<EstadoCivil> EstadoCivils) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoCivil estadocivilLocal:estadocivils) {				
			estaValidadoObjeto=this.validarGuardarEstadoCivil(estadocivilLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoCivil(List<EstadoCivil> EstadoCivils) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoCivil(estadocivils)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoCivil(EstadoCivil EstadoCivil) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoCivil(estadocivil)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoCivil estadocivil) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadocivil.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoCivilConstantesFunciones.getEstadoCivilLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadocivil","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoCivilConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoCivilConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoCivilWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCivil.class.getSimpleName()+"-saveEstadoCivilWithConnection");connexion.begin();			
			
			EstadoCivilLogicAdditional.checkEstadoCivilToSave(this.estadocivil,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoCivilLogicAdditional.updateEstadoCivilToSave(this.estadocivil,this.arrDatoGeneral);
			
			EstadoCivilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadocivil,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoCivil();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoCivil(this.estadocivil)) {
				EstadoCivilDataAccess.save(this.estadocivil, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadocivil,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoCivilLogicAdditional.checkEstadoCivilToSaveAfter(this.estadocivil,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoCivil();
			
			connexion.commit();			
			
			if(this.estadocivil.getIsDeleted()) {
				this.estadocivil=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoCivil()throws Exception {	
		try {	
			
			EstadoCivilLogicAdditional.checkEstadoCivilToSave(this.estadocivil,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoCivilLogicAdditional.updateEstadoCivilToSave(this.estadocivil,this.arrDatoGeneral);
			
			EstadoCivilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadocivil,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoCivil(this.estadocivil)) {			
				EstadoCivilDataAccess.save(this.estadocivil, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadocivil,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoCivilLogicAdditional.checkEstadoCivilToSaveAfter(this.estadocivil,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadocivil.getIsDeleted()) {
				this.estadocivil=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoCivilsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCivil.class.getSimpleName()+"-saveEstadoCivilsWithConnection");connexion.begin();			
			
			EstadoCivilLogicAdditional.checkEstadoCivilToSaves(estadocivils,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoCivils();
			
			Boolean validadoTodosEstadoCivil=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoCivil estadocivilLocal:estadocivils) {		
				if(estadocivilLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoCivilLogicAdditional.updateEstadoCivilToSave(estadocivilLocal,this.arrDatoGeneral);
	        	
				EstadoCivilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadocivilLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoCivil(estadocivilLocal)) {
					EstadoCivilDataAccess.save(estadocivilLocal, connexion);				
				} else {
					validadoTodosEstadoCivil=false;
				}
			}
			
			if(!validadoTodosEstadoCivil) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoCivilLogicAdditional.checkEstadoCivilToSavesAfter(estadocivils,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoCivils();
			
			connexion.commit();		
			
			this.quitarEstadoCivilsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoCivils()throws Exception {				
		 try {	
			EstadoCivilLogicAdditional.checkEstadoCivilToSaves(estadocivils,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoCivil=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoCivil estadocivilLocal:estadocivils) {				
				if(estadocivilLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoCivilLogicAdditional.updateEstadoCivilToSave(estadocivilLocal,this.arrDatoGeneral);
	        	
				EstadoCivilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadocivilLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoCivil(estadocivilLocal)) {				
					EstadoCivilDataAccess.save(estadocivilLocal, connexion);				
				} else {
					validadoTodosEstadoCivil=false;
				}
			}
			
			if(!validadoTodosEstadoCivil) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoCivilLogicAdditional.checkEstadoCivilToSavesAfter(estadocivils,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoCivilsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoCivilParameterReturnGeneral procesarAccionEstadoCivils(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoCivil> estadocivils,EstadoCivilParameterReturnGeneral estadocivilParameterGeneral)throws Exception {
		 try {	
			EstadoCivilParameterReturnGeneral estadocivilReturnGeneral=new EstadoCivilParameterReturnGeneral();
	
			EstadoCivilLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadocivils,estadocivilParameterGeneral,estadocivilReturnGeneral);
			
			return estadocivilReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoCivilParameterReturnGeneral procesarAccionEstadoCivilsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoCivil> estadocivils,EstadoCivilParameterReturnGeneral estadocivilParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCivil.class.getSimpleName()+"-procesarAccionEstadoCivilsWithConnection");connexion.begin();			
			
			EstadoCivilParameterReturnGeneral estadocivilReturnGeneral=new EstadoCivilParameterReturnGeneral();
	
			EstadoCivilLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadocivils,estadocivilParameterGeneral,estadocivilReturnGeneral);
			
			this.connexion.commit();
			
			return estadocivilReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoCivilParameterReturnGeneral procesarEventosEstadoCivils(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoCivil> estadocivils,EstadoCivil estadocivil,EstadoCivilParameterReturnGeneral estadocivilParameterGeneral,Boolean isEsNuevoEstadoCivil,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoCivilParameterReturnGeneral estadocivilReturnGeneral=new EstadoCivilParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadocivilReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoCivilLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadocivils,estadocivil,estadocivilParameterGeneral,estadocivilReturnGeneral,isEsNuevoEstadoCivil,clases);
			
			return estadocivilReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoCivilParameterReturnGeneral procesarEventosEstadoCivilsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoCivil> estadocivils,EstadoCivil estadocivil,EstadoCivilParameterReturnGeneral estadocivilParameterGeneral,Boolean isEsNuevoEstadoCivil,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCivil.class.getSimpleName()+"-procesarEventosEstadoCivilsWithConnection");connexion.begin();			
			
			EstadoCivilParameterReturnGeneral estadocivilReturnGeneral=new EstadoCivilParameterReturnGeneral();
	
			estadocivilReturnGeneral.setEstadoCivil(estadocivil);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadocivilReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoCivilLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadocivils,estadocivil,estadocivilParameterGeneral,estadocivilReturnGeneral,isEsNuevoEstadoCivil,clases);
			
			this.connexion.commit();
			
			return estadocivilReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoCivilParameterReturnGeneral procesarImportacionEstadoCivilsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoCivilParameterReturnGeneral estadocivilParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCivil.class.getSimpleName()+"-procesarImportacionEstadoCivilsWithConnection");connexion.begin();			
			
			EstadoCivilParameterReturnGeneral estadocivilReturnGeneral=new EstadoCivilParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadocivils=new ArrayList<EstadoCivil>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadocivil=new EstadoCivil();
				
				
				if(conColumnasBase) {this.estadocivil.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadocivil.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadocivil.setcodigo(arrColumnas[iColumn++]);
				this.estadocivil.setnombre(arrColumnas[iColumn++]);
				
				this.estadocivils.add(this.estadocivil);
			}
			
			this.saveEstadoCivils();
			
			this.connexion.commit();
			
			estadocivilReturnGeneral.setConRetornoEstaProcesado(true);
			estadocivilReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadocivilReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoCivilsEliminados() throws Exception {				
		
		List<EstadoCivil> estadocivilsAux= new ArrayList<EstadoCivil>();
		
		for(EstadoCivil estadocivil:estadocivils) {
			if(!estadocivil.getIsDeleted()) {
				estadocivilsAux.add(estadocivil);
			}
		}
		
		estadocivils=estadocivilsAux;
	}
	
	public void quitarEstadoCivilsNulos() throws Exception {				
		
		List<EstadoCivil> estadocivilsAux= new ArrayList<EstadoCivil>();
		
		for(EstadoCivil estadocivil : this.estadocivils) {
			if(estadocivil==null) {
				estadocivilsAux.add(estadocivil);
			}
		}
		
		//this.estadocivils=estadocivilsAux;
		
		this.estadocivils.removeAll(estadocivilsAux);
	}
	
	public void getSetVersionRowEstadoCivilWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadocivil.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadocivil.getIsDeleted() || (estadocivil.getIsChanged()&&!estadocivil.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadocivilDataAccess.getSetVersionRowEstadoCivil(connexion,estadocivil.getId());
				
				if(!estadocivil.getVersionRow().equals(timestamp)) {	
					estadocivil.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadocivil.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoCivil()throws Exception {	
		
		if(estadocivil.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadocivil.getIsDeleted() || (estadocivil.getIsChanged()&&!estadocivil.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadocivilDataAccess.getSetVersionRowEstadoCivil(connexion,estadocivil.getId());
			
			try {							
				if(!estadocivil.getVersionRow().equals(timestamp)) {	
					estadocivil.setVersionRow(timestamp);
				}
				
				estadocivil.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoCivilsWithConnection()throws Exception {	
		if(estadocivils!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoCivil estadocivilAux:estadocivils) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadocivilAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadocivilAux.getIsDeleted() || (estadocivilAux.getIsChanged()&&!estadocivilAux.getIsNew())) {
						
						timestamp=estadocivilDataAccess.getSetVersionRowEstadoCivil(connexion,estadocivilAux.getId());
						
						if(!estadocivil.getVersionRow().equals(timestamp)) {	
							estadocivilAux.setVersionRow(timestamp);
						}
								
						estadocivilAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoCivils()throws Exception {	
		if(estadocivils!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoCivil estadocivilAux:estadocivils) {
					if(estadocivilAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadocivilAux.getIsDeleted() || (estadocivilAux.getIsChanged()&&!estadocivilAux.getIsNew())) {
						
						timestamp=estadocivilDataAccess.getSetVersionRowEstadoCivil(connexion,estadocivilAux.getId());
						
						if(!estadocivilAux.getVersionRow().equals(timestamp)) {	
							estadocivilAux.setVersionRow(timestamp);
						}
						
													
						estadocivilAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoCivilWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ClienteLogic clienteLogic=new ClienteLogic();
			CargaFamiliar_NMLogic cargafamiliar_nmLogic=new CargaFamiliar_NMLogic();
			SubClienteLogic subclienteLogic=new SubClienteLogic();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			ParametroCarteraDefectoLogic parametrocarteradefectoLogic=new ParametroCarteraDefectoLogic();
			CargaFamiliarLogic cargafamiliarLogic=new CargaFamiliarLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCivil.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoCivilWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Cliente.class));
			classes.add(new Classe(CargaFamiliar_NM.class));
			classes.add(new Classe(SubCliente.class));
			classes.add(new Classe(Empleado.class));
			classes.add(new Classe(ParametroCarteraDefecto.class));
			classes.add(new Classe(CargaFamiliar.class));
											
			

			clienteLogic.setConnexion(this.getConnexion());
			clienteLogic.setDatosCliente(this.datosCliente);
			clienteLogic.setIsConRefrescarForeignKeys(true);

			cargafamiliar_nmLogic.setConnexion(this.getConnexion());
			cargafamiliar_nmLogic.setDatosCliente(this.datosCliente);
			cargafamiliar_nmLogic.setIsConRefrescarForeignKeys(true);

			subclienteLogic.setConnexion(this.getConnexion());
			subclienteLogic.setDatosCliente(this.datosCliente);
			subclienteLogic.setIsConRefrescarForeignKeys(true);

			empleadoLogic.setConnexion(this.getConnexion());
			empleadoLogic.setDatosCliente(this.datosCliente);
			empleadoLogic.setIsConRefrescarForeignKeys(true);

			parametrocarteradefectoLogic.setConnexion(this.getConnexion());
			parametrocarteradefectoLogic.setDatosCliente(this.datosCliente);
			parametrocarteradefectoLogic.setIsConRefrescarForeignKeys(true);

			cargafamiliarLogic.setConnexion(this.getConnexion());
			cargafamiliarLogic.setDatosCliente(this.datosCliente);
			cargafamiliarLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoCivil estadocivil:this.estadocivils) {
				

				classes=new ArrayList<Classe>();
				classes=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				clienteLogic.setClientes(estadocivil.clientes);
				clienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CargaFamiliar_NMConstantesFunciones.getClassesForeignKeysOfCargaFamiliar_NM(new ArrayList<Classe>(),DeepLoadType.NONE);

				cargafamiliar_nmLogic.setCargaFamiliar_NMs(estadocivil.cargafamiliar_nms);
				cargafamiliar_nmLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=SubClienteConstantesFunciones.getClassesForeignKeysOfSubCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				subclienteLogic.setSubClientes(estadocivil.subclientes);
				subclienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=EmpleadoConstantesFunciones.getClassesForeignKeysOfEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				empleadoLogic.setEmpleados(estadocivil.empleados);
				empleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ParametroCarteraDefectoConstantesFunciones.getClassesForeignKeysOfParametroCarteraDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametrocarteradefectoLogic.setParametroCarteraDefectos(estadocivil.parametrocarteradefectos);
				parametrocarteradefectoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CargaFamiliarConstantesFunciones.getClassesForeignKeysOfCargaFamiliar(new ArrayList<Classe>(),DeepLoadType.NONE);

				cargafamiliarLogic.setCargaFamiliars(estadocivil.cargafamiliars);
				cargafamiliarLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoCivil estadocivil,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EstadoCivilLogicAdditional.updateEstadoCivilToGet(estadocivil,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadocivil.setClientes(estadocivilDataAccess.getClientes(connexion,estadocivil));
		estadocivil.setCargaFamiliar_NMs(estadocivilDataAccess.getCargaFamiliar_NMs(connexion,estadocivil));
		estadocivil.setSubClientes(estadocivilDataAccess.getSubClientes(connexion,estadocivil));
		estadocivil.setEmpleados(estadocivilDataAccess.getEmpleados(connexion,estadocivil));
		estadocivil.setParametroCarteraDefectos(estadocivilDataAccess.getParametroCarteraDefectos(connexion,estadocivil));
		estadocivil.setCargaFamiliars(estadocivilDataAccess.getCargaFamiliars(connexion,estadocivil));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadocivil.setClientes(estadocivilDataAccess.getClientes(connexion,estadocivil));

				if(this.isConDeep) {
					ClienteLogic clienteLogic= new ClienteLogic(this.connexion);
					clienteLogic.setClientes(estadocivil.getClientes());
					ArrayList<Classe> classesLocal=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					clienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(clienteLogic.getClientes());
					estadocivil.setClientes(clienteLogic.getClientes());
				}

				continue;
			}

			if(clas.clas.equals(CargaFamiliar_NM.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadocivil.setCargaFamiliar_NMs(estadocivilDataAccess.getCargaFamiliar_NMs(connexion,estadocivil));

				if(this.isConDeep) {
					CargaFamiliar_NMLogic cargafamiliar_nmLogic= new CargaFamiliar_NMLogic(this.connexion);
					cargafamiliar_nmLogic.setCargaFamiliar_NMs(estadocivil.getCargaFamiliar_NMs());
					ArrayList<Classe> classesLocal=CargaFamiliar_NMConstantesFunciones.getClassesForeignKeysOfCargaFamiliar_NM(new ArrayList<Classe>(),DeepLoadType.NONE);
					cargafamiliar_nmLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(cargafamiliar_nmLogic.getCargaFamiliar_NMs());
					estadocivil.setCargaFamiliar_NMs(cargafamiliar_nmLogic.getCargaFamiliar_NMs());
				}

				continue;
			}

			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadocivil.setSubClientes(estadocivilDataAccess.getSubClientes(connexion,estadocivil));

				if(this.isConDeep) {
					SubClienteLogic subclienteLogic= new SubClienteLogic(this.connexion);
					subclienteLogic.setSubClientes(estadocivil.getSubClientes());
					ArrayList<Classe> classesLocal=SubClienteConstantesFunciones.getClassesForeignKeysOfSubCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					subclienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(subclienteLogic.getSubClientes());
					estadocivil.setSubClientes(subclienteLogic.getSubClientes());
				}

				continue;
			}

			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadocivil.setEmpleados(estadocivilDataAccess.getEmpleados(connexion,estadocivil));

				if(this.isConDeep) {
					EmpleadoLogic empleadoLogic= new EmpleadoLogic(this.connexion);
					empleadoLogic.setEmpleados(estadocivil.getEmpleados());
					ArrayList<Classe> classesLocal=EmpleadoConstantesFunciones.getClassesForeignKeysOfEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					empleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(empleadoLogic.getEmpleados());
					estadocivil.setEmpleados(empleadoLogic.getEmpleados());
				}

				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadocivil.setParametroCarteraDefectos(estadocivilDataAccess.getParametroCarteraDefectos(connexion,estadocivil));

				if(this.isConDeep) {
					ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(this.connexion);
					parametrocarteradefectoLogic.setParametroCarteraDefectos(estadocivil.getParametroCarteraDefectos());
					ArrayList<Classe> classesLocal=ParametroCarteraDefectoConstantesFunciones.getClassesForeignKeysOfParametroCarteraDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametrocarteradefectoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(parametrocarteradefectoLogic.getParametroCarteraDefectos());
					estadocivil.setParametroCarteraDefectos(parametrocarteradefectoLogic.getParametroCarteraDefectos());
				}

				continue;
			}

			if(clas.clas.equals(CargaFamiliar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadocivil.setCargaFamiliars(estadocivilDataAccess.getCargaFamiliars(connexion,estadocivil));

				if(this.isConDeep) {
					CargaFamiliarLogic cargafamiliarLogic= new CargaFamiliarLogic(this.connexion);
					cargafamiliarLogic.setCargaFamiliars(estadocivil.getCargaFamiliars());
					ArrayList<Classe> classesLocal=CargaFamiliarConstantesFunciones.getClassesForeignKeysOfCargaFamiliar(new ArrayList<Classe>(),DeepLoadType.NONE);
					cargafamiliarLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(cargafamiliarLogic.getCargaFamiliars());
					estadocivil.setCargaFamiliars(cargafamiliarLogic.getCargaFamiliars());
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
			estadocivil.setClientes(estadocivilDataAccess.getClientes(connexion,estadocivil));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CargaFamiliar_NM.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CargaFamiliar_NM.class));
			estadocivil.setCargaFamiliar_NMs(estadocivilDataAccess.getCargaFamiliar_NMs(connexion,estadocivil));
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
			estadocivil.setSubClientes(estadocivilDataAccess.getSubClientes(connexion,estadocivil));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Empleado.class));
			estadocivil.setEmpleados(estadocivilDataAccess.getEmpleados(connexion,estadocivil));
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
			estadocivil.setParametroCarteraDefectos(estadocivilDataAccess.getParametroCarteraDefectos(connexion,estadocivil));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CargaFamiliar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CargaFamiliar.class));
			estadocivil.setCargaFamiliars(estadocivilDataAccess.getCargaFamiliars(connexion,estadocivil));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadocivil.setClientes(estadocivilDataAccess.getClientes(connexion,estadocivil));

		for(Cliente cliente:estadocivil.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
		}

		estadocivil.setCargaFamiliar_NMs(estadocivilDataAccess.getCargaFamiliar_NMs(connexion,estadocivil));

		for(CargaFamiliar_NM cargafamiliar_nm:estadocivil.getCargaFamiliar_NMs()) {
			CargaFamiliar_NMLogic cargafamiliar_nmLogic= new CargaFamiliar_NMLogic(connexion);
			cargafamiliar_nmLogic.deepLoad(cargafamiliar_nm,isDeep,deepLoadType,clases);
		}

		estadocivil.setSubClientes(estadocivilDataAccess.getSubClientes(connexion,estadocivil));

		for(SubCliente subcliente:estadocivil.getSubClientes()) {
			SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
			subclienteLogic.deepLoad(subcliente,isDeep,deepLoadType,clases);
		}

		estadocivil.setEmpleados(estadocivilDataAccess.getEmpleados(connexion,estadocivil));

		for(Empleado empleado:estadocivil.getEmpleados()) {
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(empleado,isDeep,deepLoadType,clases);
		}

		estadocivil.setParametroCarteraDefectos(estadocivilDataAccess.getParametroCarteraDefectos(connexion,estadocivil));

		for(ParametroCarteraDefecto parametrocarteradefecto:estadocivil.getParametroCarteraDefectos()) {
			ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
			parametrocarteradefectoLogic.deepLoad(parametrocarteradefecto,isDeep,deepLoadType,clases);
		}

		estadocivil.setCargaFamiliars(estadocivilDataAccess.getCargaFamiliars(connexion,estadocivil));

		for(CargaFamiliar cargafamiliar:estadocivil.getCargaFamiliars()) {
			CargaFamiliarLogic cargafamiliarLogic= new CargaFamiliarLogic(connexion);
			cargafamiliarLogic.deepLoad(cargafamiliar,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadocivil.setClientes(estadocivilDataAccess.getClientes(connexion,estadocivil));

				for(Cliente cliente:estadocivil.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CargaFamiliar_NM.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadocivil.setCargaFamiliar_NMs(estadocivilDataAccess.getCargaFamiliar_NMs(connexion,estadocivil));

				for(CargaFamiliar_NM cargafamiliar_nm:estadocivil.getCargaFamiliar_NMs()) {
					CargaFamiliar_NMLogic cargafamiliar_nmLogic= new CargaFamiliar_NMLogic(connexion);
					cargafamiliar_nmLogic.deepLoad(cargafamiliar_nm,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadocivil.setSubClientes(estadocivilDataAccess.getSubClientes(connexion,estadocivil));

				for(SubCliente subcliente:estadocivil.getSubClientes()) {
					SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
					subclienteLogic.deepLoad(subcliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadocivil.setEmpleados(estadocivilDataAccess.getEmpleados(connexion,estadocivil));

				for(Empleado empleado:estadocivil.getEmpleados()) {
					EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
					empleadoLogic.deepLoad(empleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadocivil.setParametroCarteraDefectos(estadocivilDataAccess.getParametroCarteraDefectos(connexion,estadocivil));

				for(ParametroCarteraDefecto parametrocarteradefecto:estadocivil.getParametroCarteraDefectos()) {
					ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
					parametrocarteradefectoLogic.deepLoad(parametrocarteradefecto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CargaFamiliar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadocivil.setCargaFamiliars(estadocivilDataAccess.getCargaFamiliars(connexion,estadocivil));

				for(CargaFamiliar cargafamiliar:estadocivil.getCargaFamiliars()) {
					CargaFamiliarLogic cargafamiliarLogic= new CargaFamiliarLogic(connexion);
					cargafamiliarLogic.deepLoad(cargafamiliar,isDeep,deepLoadType,clases);
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
			estadocivil.setClientes(estadocivilDataAccess.getClientes(connexion,estadocivil));

			for(Cliente cliente:estadocivil.getClientes()) {
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CargaFamiliar_NM.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CargaFamiliar_NM.class));
			estadocivil.setCargaFamiliar_NMs(estadocivilDataAccess.getCargaFamiliar_NMs(connexion,estadocivil));

			for(CargaFamiliar_NM cargafamiliar_nm:estadocivil.getCargaFamiliar_NMs()) {
				CargaFamiliar_NMLogic cargafamiliar_nmLogic= new CargaFamiliar_NMLogic(connexion);
				cargafamiliar_nmLogic.deepLoad(cargafamiliar_nm,isDeep,deepLoadType,clases);
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
			estadocivil.setSubClientes(estadocivilDataAccess.getSubClientes(connexion,estadocivil));

			for(SubCliente subcliente:estadocivil.getSubClientes()) {
				SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
				subclienteLogic.deepLoad(subcliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Empleado.class));
			estadocivil.setEmpleados(estadocivilDataAccess.getEmpleados(connexion,estadocivil));

			for(Empleado empleado:estadocivil.getEmpleados()) {
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(empleado,isDeep,deepLoadType,clases);
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
			estadocivil.setParametroCarteraDefectos(estadocivilDataAccess.getParametroCarteraDefectos(connexion,estadocivil));

			for(ParametroCarteraDefecto parametrocarteradefecto:estadocivil.getParametroCarteraDefectos()) {
				ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
				parametrocarteradefectoLogic.deepLoad(parametrocarteradefecto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CargaFamiliar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CargaFamiliar.class));
			estadocivil.setCargaFamiliars(estadocivilDataAccess.getCargaFamiliars(connexion,estadocivil));

			for(CargaFamiliar cargafamiliar:estadocivil.getCargaFamiliars()) {
				CargaFamiliarLogic cargafamiliarLogic= new CargaFamiliarLogic(connexion);
				cargafamiliarLogic.deepLoad(cargafamiliar,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoCivil estadocivil,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EstadoCivilLogicAdditional.updateEstadoCivilToSave(estadocivil,this.arrDatoGeneral);
			
EstadoCivilDataAccess.save(estadocivil, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(Cliente cliente:estadocivil.getClientes()) {
			cliente.setid_estado_civil(estadocivil.getId());
			ClienteDataAccess.save(cliente,connexion);
		}

		for(CargaFamiliar_NM cargafamiliar_nm:estadocivil.getCargaFamiliar_NMs()) {
			cargafamiliar_nm.setid_estado_civil(estadocivil.getId());
			CargaFamiliar_NMDataAccess.save(cargafamiliar_nm,connexion);
		}

		for(SubCliente subcliente:estadocivil.getSubClientes()) {
			subcliente.setid_estado_civil(estadocivil.getId());
			SubClienteDataAccess.save(subcliente,connexion);
		}

		for(Empleado empleado:estadocivil.getEmpleados()) {
			empleado.setid_estado_civil(estadocivil.getId());
			EmpleadoDataAccess.save(empleado,connexion);
		}

		for(ParametroCarteraDefecto parametrocarteradefecto:estadocivil.getParametroCarteraDefectos()) {
			parametrocarteradefecto.setid_estado_civil(estadocivil.getId());
			ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
		}

		for(CargaFamiliar cargafamiliar:estadocivil.getCargaFamiliars()) {
			cargafamiliar.setid_estado_civil(estadocivil.getId());
			CargaFamiliarDataAccess.save(cargafamiliar,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:estadocivil.getClientes()) {
					cliente.setid_estado_civil(estadocivil.getId());
					ClienteDataAccess.save(cliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(CargaFamiliar_NM.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CargaFamiliar_NM cargafamiliar_nm:estadocivil.getCargaFamiliar_NMs()) {
					cargafamiliar_nm.setid_estado_civil(estadocivil.getId());
					CargaFamiliar_NMDataAccess.save(cargafamiliar_nm,connexion);
				}
				continue;
			}

			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SubCliente subcliente:estadocivil.getSubClientes()) {
					subcliente.setid_estado_civil(estadocivil.getId());
					SubClienteDataAccess.save(subcliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Empleado empleado:estadocivil.getEmpleados()) {
					empleado.setid_estado_civil(estadocivil.getId());
					EmpleadoDataAccess.save(empleado,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroCarteraDefecto parametrocarteradefecto:estadocivil.getParametroCarteraDefectos()) {
					parametrocarteradefecto.setid_estado_civil(estadocivil.getId());
					ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(CargaFamiliar.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CargaFamiliar cargafamiliar:estadocivil.getCargaFamiliars()) {
					cargafamiliar.setid_estado_civil(estadocivil.getId());
					CargaFamiliarDataAccess.save(cargafamiliar,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(Cliente cliente:estadocivil.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			cliente.setid_estado_civil(estadocivil.getId());
			ClienteDataAccess.save(cliente,connexion);
			clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
		}

		for(CargaFamiliar_NM cargafamiliar_nm:estadocivil.getCargaFamiliar_NMs()) {
			CargaFamiliar_NMLogic cargafamiliar_nmLogic= new CargaFamiliar_NMLogic(connexion);
			cargafamiliar_nm.setid_estado_civil(estadocivil.getId());
			CargaFamiliar_NMDataAccess.save(cargafamiliar_nm,connexion);
			cargafamiliar_nmLogic.deepSave(cargafamiliar_nm,isDeep,deepLoadType,clases);
		}

		for(SubCliente subcliente:estadocivil.getSubClientes()) {
			SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
			subcliente.setid_estado_civil(estadocivil.getId());
			SubClienteDataAccess.save(subcliente,connexion);
			subclienteLogic.deepSave(subcliente,isDeep,deepLoadType,clases);
		}

		for(Empleado empleado:estadocivil.getEmpleados()) {
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleado.setid_estado_civil(estadocivil.getId());
			EmpleadoDataAccess.save(empleado,connexion);
			empleadoLogic.deepSave(empleado,isDeep,deepLoadType,clases);
		}

		for(ParametroCarteraDefecto parametrocarteradefecto:estadocivil.getParametroCarteraDefectos()) {
			ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
			parametrocarteradefecto.setid_estado_civil(estadocivil.getId());
			ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
			parametrocarteradefectoLogic.deepSave(parametrocarteradefecto,isDeep,deepLoadType,clases);
		}

		for(CargaFamiliar cargafamiliar:estadocivil.getCargaFamiliars()) {
			CargaFamiliarLogic cargafamiliarLogic= new CargaFamiliarLogic(connexion);
			cargafamiliar.setid_estado_civil(estadocivil.getId());
			CargaFamiliarDataAccess.save(cargafamiliar,connexion);
			cargafamiliarLogic.deepSave(cargafamiliar,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:estadocivil.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					cliente.setid_estado_civil(estadocivil.getId());
					ClienteDataAccess.save(cliente,connexion);
					clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CargaFamiliar_NM.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CargaFamiliar_NM cargafamiliar_nm:estadocivil.getCargaFamiliar_NMs()) {
					CargaFamiliar_NMLogic cargafamiliar_nmLogic= new CargaFamiliar_NMLogic(connexion);
					cargafamiliar_nm.setid_estado_civil(estadocivil.getId());
					CargaFamiliar_NMDataAccess.save(cargafamiliar_nm,connexion);
					cargafamiliar_nmLogic.deepSave(cargafamiliar_nm,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SubCliente subcliente:estadocivil.getSubClientes()) {
					SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
					subcliente.setid_estado_civil(estadocivil.getId());
					SubClienteDataAccess.save(subcliente,connexion);
					subclienteLogic.deepSave(subcliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Empleado empleado:estadocivil.getEmpleados()) {
					EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
					empleado.setid_estado_civil(estadocivil.getId());
					EmpleadoDataAccess.save(empleado,connexion);
					empleadoLogic.deepSave(empleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroCarteraDefecto parametrocarteradefecto:estadocivil.getParametroCarteraDefectos()) {
					ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
					parametrocarteradefecto.setid_estado_civil(estadocivil.getId());
					ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
					parametrocarteradefectoLogic.deepSave(parametrocarteradefecto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CargaFamiliar.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CargaFamiliar cargafamiliar:estadocivil.getCargaFamiliars()) {
					CargaFamiliarLogic cargafamiliarLogic= new CargaFamiliarLogic(connexion);
					cargafamiliar.setid_estado_civil(estadocivil.getId());
					CargaFamiliarDataAccess.save(cargafamiliar,connexion);
					cargafamiliarLogic.deepSave(cargafamiliar,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(EstadoCivil.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadocivil,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoCivilConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCivil(estadocivil);
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
			this.deepLoad(this.estadocivil,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoCivilConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCivil(this.estadocivil);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoCivil.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadocivils!=null) {
				for(EstadoCivil estadocivil:estadocivils) {
					this.deepLoad(estadocivil,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoCivilConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCivil(estadocivils);
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
			if(estadocivils!=null) {
				for(EstadoCivil estadocivil:estadocivils) {
					this.deepLoad(estadocivil,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoCivilConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCivil(estadocivils);
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
			this.getNewConnexionToDeep(EstadoCivil.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(estadocivil,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EstadoCivil.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(estadocivils!=null) {
				for(EstadoCivil estadocivil:estadocivils) {
					this.deepSave(estadocivil,isDeep,deepLoadType,clases);
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
			if(estadocivils!=null) {
				for(EstadoCivil estadocivil:estadocivils) {
					this.deepSave(estadocivil,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEstadoCivilPorCodigoWithConnection(String codigo)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCivil.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,EstadoCivilConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			estadocivil=estadocivilDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadocivil,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoCivilConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCivil(this.estadocivil);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstadoCivilPorCodigo(String codigo)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,EstadoCivilConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			estadocivil=estadocivilDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadocivil,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoCivilConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCivil(this.estadocivil);
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
			if(EstadoCivilConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoCivilDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoCivil estadocivil,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoCivilConstantesFunciones.ISCONAUDITORIA) {
				if(estadocivil.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoCivilDataAccess.TABLENAME, estadocivil.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoCivilConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoCivilLogic.registrarAuditoriaDetallesEstadoCivil(connexion,estadocivil,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadocivil.getIsDeleted()) {
					/*if(!estadocivil.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoCivilDataAccess.TABLENAME, estadocivil.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoCivilLogic.registrarAuditoriaDetallesEstadoCivil(connexion,estadocivil,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoCivilDataAccess.TABLENAME, estadocivil.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadocivil.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoCivilDataAccess.TABLENAME, estadocivil.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoCivilConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoCivilLogic.registrarAuditoriaDetallesEstadoCivil(connexion,estadocivil,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoCivil(Connexion connexion,EstadoCivil estadocivil)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadocivil.getIsNew()||!estadocivil.getcodigo().equals(estadocivil.getEstadoCivilOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadocivil.getEstadoCivilOriginal().getcodigo()!=null)
				{
					strValorActual=estadocivil.getEstadoCivilOriginal().getcodigo();
				}
				if(estadocivil.getcodigo()!=null)
				{
					strValorNuevo=estadocivil.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoCivilConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadocivil.getIsNew()||!estadocivil.getnombre().equals(estadocivil.getEstadoCivilOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadocivil.getEstadoCivilOriginal().getnombre()!=null)
				{
					strValorActual=estadocivil.getEstadoCivilOriginal().getnombre();
				}
				if(estadocivil.getnombre()!=null)
				{
					strValorNuevo=estadocivil.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoCivilConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEstadoCivilRelacionesWithConnection(EstadoCivil estadocivil,List<Cliente> clientes,List<CargaFamiliar_NM> cargafamiliar_nms,List<SubCliente> subclientes,List<Empleado> empleados,List<ParametroCarteraDefecto> parametrocarteradefectos,List<CargaFamiliar> cargafamiliars) throws Exception {

		if(!estadocivil.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoCivilRelacionesBase(estadocivil,clientes,cargafamiliar_nms,subclientes,empleados,parametrocarteradefectos,cargafamiliars,true);
		}
	}

	public void saveEstadoCivilRelaciones(EstadoCivil estadocivil,List<Cliente> clientes,List<CargaFamiliar_NM> cargafamiliar_nms,List<SubCliente> subclientes,List<Empleado> empleados,List<ParametroCarteraDefecto> parametrocarteradefectos,List<CargaFamiliar> cargafamiliars)throws Exception {

		if(!estadocivil.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoCivilRelacionesBase(estadocivil,clientes,cargafamiliar_nms,subclientes,empleados,parametrocarteradefectos,cargafamiliars,false);
		}
	}

	public void saveEstadoCivilRelacionesBase(EstadoCivil estadocivil,List<Cliente> clientes,List<CargaFamiliar_NM> cargafamiliar_nms,List<SubCliente> subclientes,List<Empleado> empleados,List<ParametroCarteraDefecto> parametrocarteradefectos,List<CargaFamiliar> cargafamiliars,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EstadoCivil-saveRelacionesWithConnection");}
	
			estadocivil.setClientes(clientes);
			estadocivil.setCargaFamiliar_NMs(cargafamiliar_nms);
			estadocivil.setSubClientes(subclientes);
			estadocivil.setEmpleados(empleados);
			estadocivil.setParametroCarteraDefectos(parametrocarteradefectos);
			estadocivil.setCargaFamiliars(cargafamiliars);

			this.setEstadoCivil(estadocivil);

				if((estadocivil.getIsNew()||estadocivil.getIsChanged())&&!estadocivil.getIsDeleted()) {
					this.saveEstadoCivil();
					this.saveEstadoCivilRelacionesDetalles(clientes,cargafamiliar_nms,subclientes,empleados,parametrocarteradefectos,cargafamiliars);

				} else if(estadocivil.getIsDeleted()) {
					this.saveEstadoCivilRelacionesDetalles(clientes,cargafamiliar_nms,subclientes,empleados,parametrocarteradefectos,cargafamiliars);
					this.saveEstadoCivil();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresClientes(clientes,true,true);
			CargaFamiliar_NMConstantesFunciones.InicializarGeneralEntityAuxiliaresCargaFamiliar_NMs(cargafamiliar_nms,true,true);
			SubClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresSubClientes(subclientes,true,true);
			EmpleadoConstantesFunciones.InicializarGeneralEntityAuxiliaresEmpleados(empleados,true,true);
			ParametroCarteraDefectoConstantesFunciones.InicializarGeneralEntityAuxiliaresParametroCarteraDefectos(parametrocarteradefectos,true,true);
			CargaFamiliarConstantesFunciones.InicializarGeneralEntityAuxiliaresCargaFamiliars(cargafamiliars,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEstadoCivilRelacionesDetalles(List<Cliente> clientes,List<CargaFamiliar_NM> cargafamiliar_nms,List<SubCliente> subclientes,List<Empleado> empleados,List<ParametroCarteraDefecto> parametrocarteradefectos,List<CargaFamiliar> cargafamiliars)throws Exception {
		try {
	

			Long idEstadoCivilActual=this.getEstadoCivil().getId();

			ClienteLogic clienteLogic_Desde_EstadoCivil=new ClienteLogic();
			clienteLogic_Desde_EstadoCivil.setClientes(clientes);

			clienteLogic_Desde_EstadoCivil.setConnexion(this.getConnexion());
			clienteLogic_Desde_EstadoCivil.setDatosCliente(this.datosCliente);

			for(Cliente cliente_Desde_EstadoCivil:clienteLogic_Desde_EstadoCivil.getClientes()) {
				cliente_Desde_EstadoCivil.setid_estado_civil(idEstadoCivilActual);

				clienteLogic_Desde_EstadoCivil.setCliente(cliente_Desde_EstadoCivil);
				clienteLogic_Desde_EstadoCivil.saveCliente();
			}


			CargaFamiliar_NMLogic cargafamiliar_nmLogic_Desde_EstadoCivil=new CargaFamiliar_NMLogic();
			cargafamiliar_nmLogic_Desde_EstadoCivil.setCargaFamiliar_NMs(cargafamiliar_nms);

			cargafamiliar_nmLogic_Desde_EstadoCivil.setConnexion(this.getConnexion());
			cargafamiliar_nmLogic_Desde_EstadoCivil.setDatosCliente(this.datosCliente);

			for(CargaFamiliar_NM cargafamiliar_nm_Desde_EstadoCivil:cargafamiliar_nmLogic_Desde_EstadoCivil.getCargaFamiliar_NMs()) {
				cargafamiliar_nm_Desde_EstadoCivil.setid_estado_civil(idEstadoCivilActual);
			}

			cargafamiliar_nmLogic_Desde_EstadoCivil.saveCargaFamiliar_NMs();

			SubClienteLogic subclienteLogic_Desde_EstadoCivil=new SubClienteLogic();
			subclienteLogic_Desde_EstadoCivil.setSubClientes(subclientes);

			subclienteLogic_Desde_EstadoCivil.setConnexion(this.getConnexion());
			subclienteLogic_Desde_EstadoCivil.setDatosCliente(this.datosCliente);

			for(SubCliente subcliente_Desde_EstadoCivil:subclienteLogic_Desde_EstadoCivil.getSubClientes()) {
				subcliente_Desde_EstadoCivil.setid_estado_civil(idEstadoCivilActual);

				subclienteLogic_Desde_EstadoCivil.setSubCliente(subcliente_Desde_EstadoCivil);
				subclienteLogic_Desde_EstadoCivil.saveSubCliente();
			}


			EmpleadoLogic empleadoLogic_Desde_EstadoCivil=new EmpleadoLogic();
			empleadoLogic_Desde_EstadoCivil.setEmpleados(empleados);

			empleadoLogic_Desde_EstadoCivil.setConnexion(this.getConnexion());
			empleadoLogic_Desde_EstadoCivil.setDatosCliente(this.datosCliente);

			for(Empleado empleado_Desde_EstadoCivil:empleadoLogic_Desde_EstadoCivil.getEmpleados()) {
				empleado_Desde_EstadoCivil.setid_estado_civil(idEstadoCivilActual);

				empleadoLogic_Desde_EstadoCivil.setEmpleado(empleado_Desde_EstadoCivil);
				empleadoLogic_Desde_EstadoCivil.saveEmpleado();
			}


			ParametroCarteraDefectoLogic parametrocarteradefectoLogic_Desde_EstadoCivil=new ParametroCarteraDefectoLogic();
			parametrocarteradefectoLogic_Desde_EstadoCivil.setParametroCarteraDefectos(parametrocarteradefectos);

			parametrocarteradefectoLogic_Desde_EstadoCivil.setConnexion(this.getConnexion());
			parametrocarteradefectoLogic_Desde_EstadoCivil.setDatosCliente(this.datosCliente);

			for(ParametroCarteraDefecto parametrocarteradefecto_Desde_EstadoCivil:parametrocarteradefectoLogic_Desde_EstadoCivil.getParametroCarteraDefectos()) {
				parametrocarteradefecto_Desde_EstadoCivil.setid_estado_civil(idEstadoCivilActual);
			}

			parametrocarteradefectoLogic_Desde_EstadoCivil.saveParametroCarteraDefectos();

			CargaFamiliarLogic cargafamiliarLogic_Desde_EstadoCivil=new CargaFamiliarLogic();
			cargafamiliarLogic_Desde_EstadoCivil.setCargaFamiliars(cargafamiliars);

			cargafamiliarLogic_Desde_EstadoCivil.setConnexion(this.getConnexion());
			cargafamiliarLogic_Desde_EstadoCivil.setDatosCliente(this.datosCliente);

			for(CargaFamiliar cargafamiliar_Desde_EstadoCivil:cargafamiliarLogic_Desde_EstadoCivil.getCargaFamiliars()) {
				cargafamiliar_Desde_EstadoCivil.setid_estado_civil(idEstadoCivilActual);
			}

			cargafamiliarLogic_Desde_EstadoCivil.saveCargaFamiliars();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoCivil(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoCivilConstantesFunciones.getClassesForeignKeysOfEstadoCivil(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoCivil(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoCivilConstantesFunciones.getClassesRelationshipsOfEstadoCivil(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
