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
package com.bydan.erp.activosfijos.business.logic;

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
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.activosfijos.util.PartidaPresuConstantesFunciones;
import com.bydan.erp.activosfijos.util.PartidaPresuParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.PartidaPresuParameterGeneral;
import com.bydan.erp.activosfijos.business.entity.PartidaPresu;
import com.bydan.erp.activosfijos.business.logic.PartidaPresuLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.activosfijos.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;








@SuppressWarnings("unused")
public class PartidaPresuLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PartidaPresuLogic.class);
	
	protected PartidaPresuDataAccess partidapresuDataAccess; 	
	protected PartidaPresu partidapresu;
	protected List<PartidaPresu> partidapresus;
	protected Object partidapresuObject;	
	protected List<Object> partidapresusObject;
	
	public static ClassValidator<PartidaPresu> partidapresuValidator = new ClassValidator<PartidaPresu>(PartidaPresu.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PartidaPresuLogicAdditional partidapresuLogicAdditional=null;
	
	public PartidaPresuLogicAdditional getPartidaPresuLogicAdditional() {
		return this.partidapresuLogicAdditional;
	}
	
	public void setPartidaPresuLogicAdditional(PartidaPresuLogicAdditional partidapresuLogicAdditional) {
		try {
			this.partidapresuLogicAdditional=partidapresuLogicAdditional;
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
	
	
	
	
	public  PartidaPresuLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.partidapresuDataAccess = new PartidaPresuDataAccess();
			
			this.partidapresus= new ArrayList<PartidaPresu>();
			this.partidapresu= new PartidaPresu();
			
			this.partidapresuObject=new Object();
			this.partidapresusObject=new ArrayList<Object>();
				
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
			
			this.partidapresuDataAccess.setConnexionType(this.connexionType);
			this.partidapresuDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PartidaPresuLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.partidapresuDataAccess = new PartidaPresuDataAccess();
			this.partidapresus= new ArrayList<PartidaPresu>();
			this.partidapresu= new PartidaPresu();
			this.partidapresuObject=new Object();
			this.partidapresusObject=new ArrayList<Object>();
			
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
			
			this.partidapresuDataAccess.setConnexionType(this.connexionType);
			this.partidapresuDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PartidaPresu getPartidaPresu() throws Exception {	
		PartidaPresuLogicAdditional.checkPartidaPresuToGet(partidapresu,this.datosCliente,this.arrDatoGeneral);
		PartidaPresuLogicAdditional.updatePartidaPresuToGet(partidapresu,this.arrDatoGeneral);
		
		return partidapresu;
	}
		
	public void setPartidaPresu(PartidaPresu newPartidaPresu) {
		this.partidapresu = newPartidaPresu;
	}
	
	public PartidaPresuDataAccess getPartidaPresuDataAccess() {
		return partidapresuDataAccess;
	}
	
	public void setPartidaPresuDataAccess(PartidaPresuDataAccess newpartidapresuDataAccess) {
		this.partidapresuDataAccess = newpartidapresuDataAccess;
	}
	
	public List<PartidaPresu> getPartidaPresus() throws Exception {		
		this.quitarPartidaPresusNulos();
		
		PartidaPresuLogicAdditional.checkPartidaPresuToGets(partidapresus,this.datosCliente,this.arrDatoGeneral);
		
		for (PartidaPresu partidapresuLocal: partidapresus ) {
			PartidaPresuLogicAdditional.updatePartidaPresuToGet(partidapresuLocal,this.arrDatoGeneral);
		}
		
		return partidapresus;
	}
	
	public void setPartidaPresus(List<PartidaPresu> newPartidaPresus) {
		this.partidapresus = newPartidaPresus;
	}
	
	public Object getPartidaPresuObject() {	
		this.partidapresuObject=this.partidapresuDataAccess.getEntityObject();
		return this.partidapresuObject;
	}
		
	public void setPartidaPresuObject(Object newPartidaPresuObject) {
		this.partidapresuObject = newPartidaPresuObject;
	}
	
	public List<Object> getPartidaPresusObject() {		
		this.partidapresusObject=this.partidapresuDataAccess.getEntitiesObject();
		return this.partidapresusObject;
	}
		
	public void setPartidaPresusObject(List<Object> newPartidaPresusObject) {
		this.partidapresusObject = newPartidaPresusObject;
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
		
		if(this.partidapresuDataAccess!=null) {
			this.partidapresuDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PartidaPresu.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			partidapresuDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			partidapresuDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		partidapresu = new  PartidaPresu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PartidaPresu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			partidapresu=partidapresuDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.partidapresu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PartidaPresuConstantesFunciones.refrescarForeignKeysDescripcionesPartidaPresu(this.partidapresu);
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
		partidapresu = new  PartidaPresu();
		  		  
        try {
			
			partidapresu=partidapresuDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.partidapresu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PartidaPresuConstantesFunciones.refrescarForeignKeysDescripcionesPartidaPresu(this.partidapresu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		partidapresu = new  PartidaPresu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PartidaPresu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			partidapresu=partidapresuDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.partidapresu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PartidaPresuConstantesFunciones.refrescarForeignKeysDescripcionesPartidaPresu(this.partidapresu);
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
		partidapresu = new  PartidaPresu();
		  		  
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
		partidapresu = new  PartidaPresu();
		  		  
        try {
			
			partidapresu=partidapresuDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.partidapresu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PartidaPresuConstantesFunciones.refrescarForeignKeysDescripcionesPartidaPresu(this.partidapresu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		partidapresu = new  PartidaPresu();
		  		  
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
		partidapresu = new  PartidaPresu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PartidaPresu.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =partidapresuDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		partidapresu = new  PartidaPresu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=partidapresuDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		partidapresu = new  PartidaPresu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PartidaPresu.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =partidapresuDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		partidapresu = new  PartidaPresu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=partidapresuDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		partidapresu = new  PartidaPresu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PartidaPresu.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =partidapresuDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		partidapresu = new  PartidaPresu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=partidapresuDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		partidapresus = new  ArrayList<PartidaPresu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PartidaPresu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PartidaPresuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			partidapresus=partidapresuDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPartidaPresu(partidapresus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PartidaPresuConstantesFunciones.refrescarForeignKeysDescripcionesPartidaPresu(this.partidapresus);
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
		partidapresus = new  ArrayList<PartidaPresu>();
		  		  
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
		partidapresus = new  ArrayList<PartidaPresu>();
		  		  
        try {			
			PartidaPresuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			partidapresus=partidapresuDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPartidaPresu(partidapresus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PartidaPresuConstantesFunciones.refrescarForeignKeysDescripcionesPartidaPresu(this.partidapresus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		partidapresus = new  ArrayList<PartidaPresu>();
		  		  
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
		partidapresus = new  ArrayList<PartidaPresu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PartidaPresu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PartidaPresuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			partidapresus=partidapresuDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPartidaPresu(partidapresus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PartidaPresuConstantesFunciones.refrescarForeignKeysDescripcionesPartidaPresu(this.partidapresus);
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
		partidapresus = new  ArrayList<PartidaPresu>();
		  		  
        try {
			PartidaPresuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			partidapresus=partidapresuDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPartidaPresu(partidapresus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PartidaPresuConstantesFunciones.refrescarForeignKeysDescripcionesPartidaPresu(this.partidapresus);
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
		partidapresus = new  ArrayList<PartidaPresu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PartidaPresu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PartidaPresuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			partidapresus=partidapresuDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPartidaPresu(partidapresus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PartidaPresuConstantesFunciones.refrescarForeignKeysDescripcionesPartidaPresu(this.partidapresus);
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
		partidapresus = new  ArrayList<PartidaPresu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PartidaPresuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			partidapresus=partidapresuDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPartidaPresu(partidapresus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PartidaPresuConstantesFunciones.refrescarForeignKeysDescripcionesPartidaPresu(this.partidapresus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		partidapresu = new  PartidaPresu();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PartidaPresu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PartidaPresuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			partidapresu=partidapresuDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPartidaPresu(partidapresu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PartidaPresuConstantesFunciones.refrescarForeignKeysDescripcionesPartidaPresu(this.partidapresu);
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
		partidapresu = new  PartidaPresu();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PartidaPresuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			partidapresu=partidapresuDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPartidaPresu(partidapresu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PartidaPresuConstantesFunciones.refrescarForeignKeysDescripcionesPartidaPresu(this.partidapresu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		partidapresus = new  ArrayList<PartidaPresu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PartidaPresu.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PartidaPresuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			partidapresus=partidapresuDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPartidaPresu(partidapresus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PartidaPresuConstantesFunciones.refrescarForeignKeysDescripcionesPartidaPresu(this.partidapresus);
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
		partidapresus = new  ArrayList<PartidaPresu>();
		  		  
        try {
			PartidaPresuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			partidapresus=partidapresuDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPartidaPresu(partidapresus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PartidaPresuConstantesFunciones.refrescarForeignKeysDescripcionesPartidaPresu(this.partidapresus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPartidaPresusWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		partidapresus = new  ArrayList<PartidaPresu>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PartidaPresu.class.getSimpleName()+"-getTodosPartidaPresusWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PartidaPresuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			partidapresus=partidapresuDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPartidaPresu(partidapresus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PartidaPresuConstantesFunciones.refrescarForeignKeysDescripcionesPartidaPresu(this.partidapresus);
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
	
	public  void  getTodosPartidaPresus(String sFinalQuery,Pagination pagination)throws Exception {
		partidapresus = new  ArrayList<PartidaPresu>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PartidaPresuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			partidapresus=partidapresuDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPartidaPresu(partidapresus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PartidaPresuConstantesFunciones.refrescarForeignKeysDescripcionesPartidaPresu(this.partidapresus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPartidaPresu(PartidaPresu partidapresu) throws Exception {
		Boolean estaValidado=false;
		
		if(partidapresu.getIsNew() || partidapresu.getIsChanged()) { 
			this.invalidValues = partidapresuValidator.getInvalidValues(partidapresu);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(partidapresu);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPartidaPresu(List<PartidaPresu> PartidaPresus) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PartidaPresu partidapresuLocal:partidapresus) {				
			estaValidadoObjeto=this.validarGuardarPartidaPresu(partidapresuLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPartidaPresu(List<PartidaPresu> PartidaPresus) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPartidaPresu(partidapresus)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPartidaPresu(PartidaPresu PartidaPresu) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPartidaPresu(partidapresu)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PartidaPresu partidapresu) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+partidapresu.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PartidaPresuConstantesFunciones.getPartidaPresuLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"partidapresu","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PartidaPresuConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PartidaPresuConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePartidaPresuWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PartidaPresu.class.getSimpleName()+"-savePartidaPresuWithConnection");connexion.begin();			
			
			PartidaPresuLogicAdditional.checkPartidaPresuToSave(this.partidapresu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PartidaPresuLogicAdditional.updatePartidaPresuToSave(this.partidapresu,this.arrDatoGeneral);
			
			PartidaPresuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.partidapresu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPartidaPresu();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPartidaPresu(this.partidapresu)) {
				PartidaPresuDataAccess.save(this.partidapresu, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.partidapresu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PartidaPresuLogicAdditional.checkPartidaPresuToSaveAfter(this.partidapresu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPartidaPresu();
			
			connexion.commit();			
			
			if(this.partidapresu.getIsDeleted()) {
				this.partidapresu=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePartidaPresu()throws Exception {	
		try {	
			
			PartidaPresuLogicAdditional.checkPartidaPresuToSave(this.partidapresu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PartidaPresuLogicAdditional.updatePartidaPresuToSave(this.partidapresu,this.arrDatoGeneral);
			
			PartidaPresuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.partidapresu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPartidaPresu(this.partidapresu)) {			
				PartidaPresuDataAccess.save(this.partidapresu, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.partidapresu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PartidaPresuLogicAdditional.checkPartidaPresuToSaveAfter(this.partidapresu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.partidapresu.getIsDeleted()) {
				this.partidapresu=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePartidaPresusWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PartidaPresu.class.getSimpleName()+"-savePartidaPresusWithConnection");connexion.begin();			
			
			PartidaPresuLogicAdditional.checkPartidaPresuToSaves(partidapresus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPartidaPresus();
			
			Boolean validadoTodosPartidaPresu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PartidaPresu partidapresuLocal:partidapresus) {		
				if(partidapresuLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PartidaPresuLogicAdditional.updatePartidaPresuToSave(partidapresuLocal,this.arrDatoGeneral);
	        	
				PartidaPresuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),partidapresuLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPartidaPresu(partidapresuLocal)) {
					PartidaPresuDataAccess.save(partidapresuLocal, connexion);				
				} else {
					validadoTodosPartidaPresu=false;
				}
			}
			
			if(!validadoTodosPartidaPresu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PartidaPresuLogicAdditional.checkPartidaPresuToSavesAfter(partidapresus,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPartidaPresus();
			
			connexion.commit();		
			
			this.quitarPartidaPresusEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePartidaPresus()throws Exception {				
		 try {	
			PartidaPresuLogicAdditional.checkPartidaPresuToSaves(partidapresus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPartidaPresu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PartidaPresu partidapresuLocal:partidapresus) {				
				if(partidapresuLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PartidaPresuLogicAdditional.updatePartidaPresuToSave(partidapresuLocal,this.arrDatoGeneral);
	        	
				PartidaPresuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),partidapresuLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPartidaPresu(partidapresuLocal)) {				
					PartidaPresuDataAccess.save(partidapresuLocal, connexion);				
				} else {
					validadoTodosPartidaPresu=false;
				}
			}
			
			if(!validadoTodosPartidaPresu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PartidaPresuLogicAdditional.checkPartidaPresuToSavesAfter(partidapresus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPartidaPresusEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PartidaPresuParameterReturnGeneral procesarAccionPartidaPresus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PartidaPresu> partidapresus,PartidaPresuParameterReturnGeneral partidapresuParameterGeneral)throws Exception {
		 try {	
			PartidaPresuParameterReturnGeneral partidapresuReturnGeneral=new PartidaPresuParameterReturnGeneral();
	
			PartidaPresuLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,partidapresus,partidapresuParameterGeneral,partidapresuReturnGeneral);
			
			return partidapresuReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PartidaPresuParameterReturnGeneral procesarAccionPartidaPresusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PartidaPresu> partidapresus,PartidaPresuParameterReturnGeneral partidapresuParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PartidaPresu.class.getSimpleName()+"-procesarAccionPartidaPresusWithConnection");connexion.begin();			
			
			PartidaPresuParameterReturnGeneral partidapresuReturnGeneral=new PartidaPresuParameterReturnGeneral();
	
			PartidaPresuLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,partidapresus,partidapresuParameterGeneral,partidapresuReturnGeneral);
			
			this.connexion.commit();
			
			return partidapresuReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PartidaPresuParameterReturnGeneral procesarEventosPartidaPresus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PartidaPresu> partidapresus,PartidaPresu partidapresu,PartidaPresuParameterReturnGeneral partidapresuParameterGeneral,Boolean isEsNuevoPartidaPresu,ArrayList<Classe> clases)throws Exception {
		 try {	
			PartidaPresuParameterReturnGeneral partidapresuReturnGeneral=new PartidaPresuParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				partidapresuReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PartidaPresuLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,partidapresus,partidapresu,partidapresuParameterGeneral,partidapresuReturnGeneral,isEsNuevoPartidaPresu,clases);
			
			return partidapresuReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PartidaPresuParameterReturnGeneral procesarEventosPartidaPresusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PartidaPresu> partidapresus,PartidaPresu partidapresu,PartidaPresuParameterReturnGeneral partidapresuParameterGeneral,Boolean isEsNuevoPartidaPresu,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PartidaPresu.class.getSimpleName()+"-procesarEventosPartidaPresusWithConnection");connexion.begin();			
			
			PartidaPresuParameterReturnGeneral partidapresuReturnGeneral=new PartidaPresuParameterReturnGeneral();
	
			partidapresuReturnGeneral.setPartidaPresu(partidapresu);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				partidapresuReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PartidaPresuLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,partidapresus,partidapresu,partidapresuParameterGeneral,partidapresuReturnGeneral,isEsNuevoPartidaPresu,clases);
			
			this.connexion.commit();
			
			return partidapresuReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PartidaPresuParameterReturnGeneral procesarImportacionPartidaPresusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PartidaPresuParameterReturnGeneral partidapresuParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PartidaPresu.class.getSimpleName()+"-procesarImportacionPartidaPresusWithConnection");connexion.begin();			
			
			PartidaPresuParameterReturnGeneral partidapresuReturnGeneral=new PartidaPresuParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.partidapresus=new ArrayList<PartidaPresu>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.partidapresu=new PartidaPresu();
				
				
				if(conColumnasBase) {this.partidapresu.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.partidapresu.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.partidapresu.setcodigo(arrColumnas[iColumn++]);
				this.partidapresu.setnombre(arrColumnas[iColumn++]);
				
				this.partidapresus.add(this.partidapresu);
			}
			
			this.savePartidaPresus();
			
			this.connexion.commit();
			
			partidapresuReturnGeneral.setConRetornoEstaProcesado(true);
			partidapresuReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return partidapresuReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPartidaPresusEliminados() throws Exception {				
		
		List<PartidaPresu> partidapresusAux= new ArrayList<PartidaPresu>();
		
		for(PartidaPresu partidapresu:partidapresus) {
			if(!partidapresu.getIsDeleted()) {
				partidapresusAux.add(partidapresu);
			}
		}
		
		partidapresus=partidapresusAux;
	}
	
	public void quitarPartidaPresusNulos() throws Exception {				
		
		List<PartidaPresu> partidapresusAux= new ArrayList<PartidaPresu>();
		
		for(PartidaPresu partidapresu : this.partidapresus) {
			if(partidapresu==null) {
				partidapresusAux.add(partidapresu);
			}
		}
		
		//this.partidapresus=partidapresusAux;
		
		this.partidapresus.removeAll(partidapresusAux);
	}
	
	public void getSetVersionRowPartidaPresuWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(partidapresu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((partidapresu.getIsDeleted() || (partidapresu.getIsChanged()&&!partidapresu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=partidapresuDataAccess.getSetVersionRowPartidaPresu(connexion,partidapresu.getId());
				
				if(!partidapresu.getVersionRow().equals(timestamp)) {	
					partidapresu.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				partidapresu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPartidaPresu()throws Exception {	
		
		if(partidapresu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((partidapresu.getIsDeleted() || (partidapresu.getIsChanged()&&!partidapresu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=partidapresuDataAccess.getSetVersionRowPartidaPresu(connexion,partidapresu.getId());
			
			try {							
				if(!partidapresu.getVersionRow().equals(timestamp)) {	
					partidapresu.setVersionRow(timestamp);
				}
				
				partidapresu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPartidaPresusWithConnection()throws Exception {	
		if(partidapresus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PartidaPresu partidapresuAux:partidapresus) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(partidapresuAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(partidapresuAux.getIsDeleted() || (partidapresuAux.getIsChanged()&&!partidapresuAux.getIsNew())) {
						
						timestamp=partidapresuDataAccess.getSetVersionRowPartidaPresu(connexion,partidapresuAux.getId());
						
						if(!partidapresu.getVersionRow().equals(timestamp)) {	
							partidapresuAux.setVersionRow(timestamp);
						}
								
						partidapresuAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPartidaPresus()throws Exception {	
		if(partidapresus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PartidaPresu partidapresuAux:partidapresus) {
					if(partidapresuAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(partidapresuAux.getIsDeleted() || (partidapresuAux.getIsChanged()&&!partidapresuAux.getIsNew())) {
						
						timestamp=partidapresuDataAccess.getSetVersionRowPartidaPresu(connexion,partidapresuAux.getId());
						
						if(!partidapresuAux.getVersionRow().equals(timestamp)) {	
							partidapresuAux.setVersionRow(timestamp);
						}
						
													
						partidapresuAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PartidaPresuParameterReturnGeneral cargarCombosLoteForeignKeyPartidaPresuWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		PartidaPresuParameterReturnGeneral  partidapresuReturnGeneral =new PartidaPresuParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PartidaPresu.class.getSimpleName()+"-cargarCombosLoteForeignKeyPartidaPresuWithConnection");connexion.begin();
			
			partidapresuReturnGeneral =new PartidaPresuParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			partidapresuReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return partidapresuReturnGeneral;
	}
	
	public PartidaPresuParameterReturnGeneral cargarCombosLoteForeignKeyPartidaPresu(String finalQueryGlobalEmpresa) throws Exception {
		PartidaPresuParameterReturnGeneral  partidapresuReturnGeneral =new PartidaPresuParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			partidapresuReturnGeneral =new PartidaPresuParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			partidapresuReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return partidapresuReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyPartidaPresuWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleActivoFijoLogic detalleactivofijoLogic=new DetalleActivoFijoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PartidaPresu.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyPartidaPresuWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleActivoFijo.class));
											
			

			detalleactivofijoLogic.setConnexion(this.getConnexion());
			detalleactivofijoLogic.setDatosCliente(this.datosCliente);
			detalleactivofijoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(PartidaPresu partidapresu:this.partidapresus) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleActivoFijoConstantesFunciones.getClassesForeignKeysOfDetalleActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleactivofijoLogic.setDetalleActivoFijos(partidapresu.detalleactivofijos);
				detalleactivofijoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(PartidaPresu partidapresu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PartidaPresuLogicAdditional.updatePartidaPresuToGet(partidapresu,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		partidapresu.setEmpresa(partidapresuDataAccess.getEmpresa(connexion,partidapresu));
		partidapresu.setDetalleActivoFijos(partidapresuDataAccess.getDetalleActivoFijos(connexion,partidapresu));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				partidapresu.setEmpresa(partidapresuDataAccess.getEmpresa(connexion,partidapresu));
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				partidapresu.setDetalleActivoFijos(partidapresuDataAccess.getDetalleActivoFijos(connexion,partidapresu));

				if(this.isConDeep) {
					DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(this.connexion);
					detalleactivofijoLogic.setDetalleActivoFijos(partidapresu.getDetalleActivoFijos());
					ArrayList<Classe> classesLocal=DetalleActivoFijoConstantesFunciones.getClassesForeignKeysOfDetalleActivoFijo(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleactivofijoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleActivoFijo(detalleactivofijoLogic.getDetalleActivoFijos());
					partidapresu.setDetalleActivoFijos(detalleactivofijoLogic.getDetalleActivoFijos());
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
			partidapresu.setEmpresa(partidapresuDataAccess.getEmpresa(connexion,partidapresu));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleActivoFijo.class));
			partidapresu.setDetalleActivoFijos(partidapresuDataAccess.getDetalleActivoFijos(connexion,partidapresu));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		partidapresu.setEmpresa(partidapresuDataAccess.getEmpresa(connexion,partidapresu));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(partidapresu.getEmpresa(),isDeep,deepLoadType,clases);
				

		partidapresu.setDetalleActivoFijos(partidapresuDataAccess.getDetalleActivoFijos(connexion,partidapresu));

		for(DetalleActivoFijo detalleactivofijo:partidapresu.getDetalleActivoFijos()) {
			DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
			detalleactivofijoLogic.deepLoad(detalleactivofijo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				partidapresu.setEmpresa(partidapresuDataAccess.getEmpresa(connexion,partidapresu));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(partidapresu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				partidapresu.setDetalleActivoFijos(partidapresuDataAccess.getDetalleActivoFijos(connexion,partidapresu));

				for(DetalleActivoFijo detalleactivofijo:partidapresu.getDetalleActivoFijos()) {
					DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
					detalleactivofijoLogic.deepLoad(detalleactivofijo,isDeep,deepLoadType,clases);
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
			partidapresu.setEmpresa(partidapresuDataAccess.getEmpresa(connexion,partidapresu));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(partidapresu.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleActivoFijo.class));
			partidapresu.setDetalleActivoFijos(partidapresuDataAccess.getDetalleActivoFijos(connexion,partidapresu));

			for(DetalleActivoFijo detalleactivofijo:partidapresu.getDetalleActivoFijos()) {
				DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
				detalleactivofijoLogic.deepLoad(detalleactivofijo,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PartidaPresu partidapresu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PartidaPresuLogicAdditional.updatePartidaPresuToSave(partidapresu,this.arrDatoGeneral);
			
PartidaPresuDataAccess.save(partidapresu, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(partidapresu.getEmpresa(),connexion);

		for(DetalleActivoFijo detalleactivofijo:partidapresu.getDetalleActivoFijos()) {
			detalleactivofijo.setid_partida_presu(partidapresu.getId());
			DetalleActivoFijoDataAccess.save(detalleactivofijo,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(partidapresu.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleActivoFijo detalleactivofijo:partidapresu.getDetalleActivoFijos()) {
					detalleactivofijo.setid_partida_presu(partidapresu.getId());
					DetalleActivoFijoDataAccess.save(detalleactivofijo,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(partidapresu.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(partidapresu.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(DetalleActivoFijo detalleactivofijo:partidapresu.getDetalleActivoFijos()) {
			DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
			detalleactivofijo.setid_partida_presu(partidapresu.getId());
			DetalleActivoFijoDataAccess.save(detalleactivofijo,connexion);
			detalleactivofijoLogic.deepSave(detalleactivofijo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(partidapresu.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(partidapresu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleActivoFijo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleActivoFijo detalleactivofijo:partidapresu.getDetalleActivoFijos()) {
					DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
					detalleactivofijo.setid_partida_presu(partidapresu.getId());
					DetalleActivoFijoDataAccess.save(detalleactivofijo,connexion);
					detalleactivofijoLogic.deepSave(detalleactivofijo,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(PartidaPresu.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(partidapresu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PartidaPresuConstantesFunciones.refrescarForeignKeysDescripcionesPartidaPresu(partidapresu);
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
			this.deepLoad(this.partidapresu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PartidaPresuConstantesFunciones.refrescarForeignKeysDescripcionesPartidaPresu(this.partidapresu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PartidaPresu.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(partidapresus!=null) {
				for(PartidaPresu partidapresu:partidapresus) {
					this.deepLoad(partidapresu,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PartidaPresuConstantesFunciones.refrescarForeignKeysDescripcionesPartidaPresu(partidapresus);
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
			if(partidapresus!=null) {
				for(PartidaPresu partidapresu:partidapresus) {
					this.deepLoad(partidapresu,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PartidaPresuConstantesFunciones.refrescarForeignKeysDescripcionesPartidaPresu(partidapresus);
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
			this.getNewConnexionToDeep(PartidaPresu.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(partidapresu,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PartidaPresu.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(partidapresus!=null) {
				for(PartidaPresu partidapresu:partidapresus) {
					this.deepSave(partidapresu,isDeep,deepLoadType,clases);
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
			if(partidapresus!=null) {
				for(PartidaPresu partidapresu:partidapresus) {
					this.deepSave(partidapresu,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPartidaPresusFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PartidaPresu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PartidaPresuConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PartidaPresuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			partidapresus=partidapresuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PartidaPresuConstantesFunciones.refrescarForeignKeysDescripcionesPartidaPresu(this.partidapresus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPartidaPresusFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PartidaPresuConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PartidaPresuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			partidapresus=partidapresuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PartidaPresuConstantesFunciones.refrescarForeignKeysDescripcionesPartidaPresu(this.partidapresus);
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
			if(PartidaPresuConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PartidaPresuDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PartidaPresu partidapresu,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PartidaPresuConstantesFunciones.ISCONAUDITORIA) {
				if(partidapresu.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PartidaPresuDataAccess.TABLENAME, partidapresu.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PartidaPresuConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PartidaPresuLogic.registrarAuditoriaDetallesPartidaPresu(connexion,partidapresu,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(partidapresu.getIsDeleted()) {
					/*if(!partidapresu.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PartidaPresuDataAccess.TABLENAME, partidapresu.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PartidaPresuLogic.registrarAuditoriaDetallesPartidaPresu(connexion,partidapresu,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PartidaPresuDataAccess.TABLENAME, partidapresu.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(partidapresu.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PartidaPresuDataAccess.TABLENAME, partidapresu.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PartidaPresuConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PartidaPresuLogic.registrarAuditoriaDetallesPartidaPresu(connexion,partidapresu,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPartidaPresu(Connexion connexion,PartidaPresu partidapresu)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(partidapresu.getIsNew()||!partidapresu.getid_empresa().equals(partidapresu.getPartidaPresuOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(partidapresu.getPartidaPresuOriginal().getid_empresa()!=null)
				{
					strValorActual=partidapresu.getPartidaPresuOriginal().getid_empresa().toString();
				}
				if(partidapresu.getid_empresa()!=null)
				{
					strValorNuevo=partidapresu.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PartidaPresuConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(partidapresu.getIsNew()||!partidapresu.getcodigo().equals(partidapresu.getPartidaPresuOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(partidapresu.getPartidaPresuOriginal().getcodigo()!=null)
				{
					strValorActual=partidapresu.getPartidaPresuOriginal().getcodigo();
				}
				if(partidapresu.getcodigo()!=null)
				{
					strValorNuevo=partidapresu.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PartidaPresuConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(partidapresu.getIsNew()||!partidapresu.getnombre().equals(partidapresu.getPartidaPresuOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(partidapresu.getPartidaPresuOriginal().getnombre()!=null)
				{
					strValorActual=partidapresu.getPartidaPresuOriginal().getnombre();
				}
				if(partidapresu.getnombre()!=null)
				{
					strValorNuevo=partidapresu.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PartidaPresuConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePartidaPresuRelacionesWithConnection(PartidaPresu partidapresu,List<DetalleActivoFijo> detalleactivofijos) throws Exception {

		if(!partidapresu.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePartidaPresuRelacionesBase(partidapresu,detalleactivofijos,true);
		}
	}

	public void savePartidaPresuRelaciones(PartidaPresu partidapresu,List<DetalleActivoFijo> detalleactivofijos)throws Exception {

		if(!partidapresu.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePartidaPresuRelacionesBase(partidapresu,detalleactivofijos,false);
		}
	}

	public void savePartidaPresuRelacionesBase(PartidaPresu partidapresu,List<DetalleActivoFijo> detalleactivofijos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PartidaPresu-saveRelacionesWithConnection");}
	
			partidapresu.setDetalleActivoFijos(detalleactivofijos);

			this.setPartidaPresu(partidapresu);

			if(PartidaPresuLogicAdditional.validarSaveRelaciones(partidapresu,this)) {

				PartidaPresuLogicAdditional.updateRelacionesToSave(partidapresu,this);

				if((partidapresu.getIsNew()||partidapresu.getIsChanged())&&!partidapresu.getIsDeleted()) {
					this.savePartidaPresu();
					this.savePartidaPresuRelacionesDetalles(detalleactivofijos);

				} else if(partidapresu.getIsDeleted()) {
					this.savePartidaPresuRelacionesDetalles(detalleactivofijos);
					this.savePartidaPresu();
				}

				PartidaPresuLogicAdditional.updateRelacionesToSaveAfter(partidapresu,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleActivoFijoConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleActivoFijos(detalleactivofijos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void savePartidaPresuRelacionesDetalles(List<DetalleActivoFijo> detalleactivofijos)throws Exception {
		try {
	

			Long idPartidaPresuActual=this.getPartidaPresu().getId();

			DetalleActivoFijoLogic detalleactivofijoLogic_Desde_PartidaPresu=new DetalleActivoFijoLogic();
			detalleactivofijoLogic_Desde_PartidaPresu.setDetalleActivoFijos(detalleactivofijos);

			detalleactivofijoLogic_Desde_PartidaPresu.setConnexion(this.getConnexion());
			detalleactivofijoLogic_Desde_PartidaPresu.setDatosCliente(this.datosCliente);

			for(DetalleActivoFijo detalleactivofijo_Desde_PartidaPresu:detalleactivofijoLogic_Desde_PartidaPresu.getDetalleActivoFijos()) {
				detalleactivofijo_Desde_PartidaPresu.setid_partida_presu(idPartidaPresuActual);

				detalleactivofijoLogic_Desde_PartidaPresu.setDetalleActivoFijo(detalleactivofijo_Desde_PartidaPresu);
				detalleactivofijoLogic_Desde_PartidaPresu.saveDetalleActivoFijo();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPartidaPresu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PartidaPresuConstantesFunciones.getClassesForeignKeysOfPartidaPresu(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPartidaPresu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PartidaPresuConstantesFunciones.getClassesRelationshipsOfPartidaPresu(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
