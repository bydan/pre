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
import com.bydan.erp.nomina.util.HistorialPagoMesNomiConstantesFunciones;
import com.bydan.erp.nomina.util.HistorialPagoMesNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.HistorialPagoMesNomiParameterGeneral;
import com.bydan.erp.nomina.business.entity.HistorialPagoMesNomi;
import com.bydan.erp.nomina.business.logic.HistorialPagoMesNomiLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class HistorialPagoMesNomiLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(HistorialPagoMesNomiLogic.class);
	
	protected HistorialPagoMesNomiDataAccess historialpagomesnomiDataAccess; 	
	protected HistorialPagoMesNomi historialpagomesnomi;
	protected List<HistorialPagoMesNomi> historialpagomesnomis;
	protected Object historialpagomesnomiObject;	
	protected List<Object> historialpagomesnomisObject;
	
	public static ClassValidator<HistorialPagoMesNomi> historialpagomesnomiValidator = new ClassValidator<HistorialPagoMesNomi>(HistorialPagoMesNomi.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected HistorialPagoMesNomiLogicAdditional historialpagomesnomiLogicAdditional=null;
	
	public HistorialPagoMesNomiLogicAdditional getHistorialPagoMesNomiLogicAdditional() {
		return this.historialpagomesnomiLogicAdditional;
	}
	
	public void setHistorialPagoMesNomiLogicAdditional(HistorialPagoMesNomiLogicAdditional historialpagomesnomiLogicAdditional) {
		try {
			this.historialpagomesnomiLogicAdditional=historialpagomesnomiLogicAdditional;
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
	
	
	
	
	public  HistorialPagoMesNomiLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.historialpagomesnomiDataAccess = new HistorialPagoMesNomiDataAccess();
			
			this.historialpagomesnomis= new ArrayList<HistorialPagoMesNomi>();
			this.historialpagomesnomi= new HistorialPagoMesNomi();
			
			this.historialpagomesnomiObject=new Object();
			this.historialpagomesnomisObject=new ArrayList<Object>();
				
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
			
			this.historialpagomesnomiDataAccess.setConnexionType(this.connexionType);
			this.historialpagomesnomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  HistorialPagoMesNomiLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.historialpagomesnomiDataAccess = new HistorialPagoMesNomiDataAccess();
			this.historialpagomesnomis= new ArrayList<HistorialPagoMesNomi>();
			this.historialpagomesnomi= new HistorialPagoMesNomi();
			this.historialpagomesnomiObject=new Object();
			this.historialpagomesnomisObject=new ArrayList<Object>();
			
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
			
			this.historialpagomesnomiDataAccess.setConnexionType(this.connexionType);
			this.historialpagomesnomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public HistorialPagoMesNomi getHistorialPagoMesNomi() throws Exception {	
		HistorialPagoMesNomiLogicAdditional.checkHistorialPagoMesNomiToGet(historialpagomesnomi,this.datosCliente,this.arrDatoGeneral);
		HistorialPagoMesNomiLogicAdditional.updateHistorialPagoMesNomiToGet(historialpagomesnomi,this.arrDatoGeneral);
		
		return historialpagomesnomi;
	}
		
	public void setHistorialPagoMesNomi(HistorialPagoMesNomi newHistorialPagoMesNomi) {
		this.historialpagomesnomi = newHistorialPagoMesNomi;
	}
	
	public HistorialPagoMesNomiDataAccess getHistorialPagoMesNomiDataAccess() {
		return historialpagomesnomiDataAccess;
	}
	
	public void setHistorialPagoMesNomiDataAccess(HistorialPagoMesNomiDataAccess newhistorialpagomesnomiDataAccess) {
		this.historialpagomesnomiDataAccess = newhistorialpagomesnomiDataAccess;
	}
	
	public List<HistorialPagoMesNomi> getHistorialPagoMesNomis() throws Exception {		
		this.quitarHistorialPagoMesNomisNulos();
		
		HistorialPagoMesNomiLogicAdditional.checkHistorialPagoMesNomiToGets(historialpagomesnomis,this.datosCliente,this.arrDatoGeneral);
		
		for (HistorialPagoMesNomi historialpagomesnomiLocal: historialpagomesnomis ) {
			HistorialPagoMesNomiLogicAdditional.updateHistorialPagoMesNomiToGet(historialpagomesnomiLocal,this.arrDatoGeneral);
		}
		
		return historialpagomesnomis;
	}
	
	public void setHistorialPagoMesNomis(List<HistorialPagoMesNomi> newHistorialPagoMesNomis) {
		this.historialpagomesnomis = newHistorialPagoMesNomis;
	}
	
	public Object getHistorialPagoMesNomiObject() {	
		this.historialpagomesnomiObject=this.historialpagomesnomiDataAccess.getEntityObject();
		return this.historialpagomesnomiObject;
	}
		
	public void setHistorialPagoMesNomiObject(Object newHistorialPagoMesNomiObject) {
		this.historialpagomesnomiObject = newHistorialPagoMesNomiObject;
	}
	
	public List<Object> getHistorialPagoMesNomisObject() {		
		this.historialpagomesnomisObject=this.historialpagomesnomiDataAccess.getEntitiesObject();
		return this.historialpagomesnomisObject;
	}
		
	public void setHistorialPagoMesNomisObject(List<Object> newHistorialPagoMesNomisObject) {
		this.historialpagomesnomisObject = newHistorialPagoMesNomisObject;
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
		
		if(this.historialpagomesnomiDataAccess!=null) {
			this.historialpagomesnomiDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoMesNomi.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			historialpagomesnomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			historialpagomesnomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		historialpagomesnomi = new  HistorialPagoMesNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoMesNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			historialpagomesnomi=historialpagomesnomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.historialpagomesnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(this.historialpagomesnomi);
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
		historialpagomesnomi = new  HistorialPagoMesNomi();
		  		  
        try {
			
			historialpagomesnomi=historialpagomesnomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.historialpagomesnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(this.historialpagomesnomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		historialpagomesnomi = new  HistorialPagoMesNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoMesNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			historialpagomesnomi=historialpagomesnomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.historialpagomesnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(this.historialpagomesnomi);
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
		historialpagomesnomi = new  HistorialPagoMesNomi();
		  		  
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
		historialpagomesnomi = new  HistorialPagoMesNomi();
		  		  
        try {
			
			historialpagomesnomi=historialpagomesnomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.historialpagomesnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(this.historialpagomesnomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		historialpagomesnomi = new  HistorialPagoMesNomi();
		  		  
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
		historialpagomesnomi = new  HistorialPagoMesNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoMesNomi.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =historialpagomesnomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		historialpagomesnomi = new  HistorialPagoMesNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=historialpagomesnomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		historialpagomesnomi = new  HistorialPagoMesNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoMesNomi.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =historialpagomesnomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		historialpagomesnomi = new  HistorialPagoMesNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=historialpagomesnomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		historialpagomesnomi = new  HistorialPagoMesNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoMesNomi.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =historialpagomesnomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		historialpagomesnomi = new  HistorialPagoMesNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=historialpagomesnomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		historialpagomesnomis = new  ArrayList<HistorialPagoMesNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoMesNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			HistorialPagoMesNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialpagomesnomis=historialpagomesnomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHistorialPagoMesNomi(historialpagomesnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(this.historialpagomesnomis);
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
		historialpagomesnomis = new  ArrayList<HistorialPagoMesNomi>();
		  		  
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
		historialpagomesnomis = new  ArrayList<HistorialPagoMesNomi>();
		  		  
        try {			
			HistorialPagoMesNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialpagomesnomis=historialpagomesnomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarHistorialPagoMesNomi(historialpagomesnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(this.historialpagomesnomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		historialpagomesnomis = new  ArrayList<HistorialPagoMesNomi>();
		  		  
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
		historialpagomesnomis = new  ArrayList<HistorialPagoMesNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoMesNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			HistorialPagoMesNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialpagomesnomis=historialpagomesnomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHistorialPagoMesNomi(historialpagomesnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(this.historialpagomesnomis);
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
		historialpagomesnomis = new  ArrayList<HistorialPagoMesNomi>();
		  		  
        try {
			HistorialPagoMesNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialpagomesnomis=historialpagomesnomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHistorialPagoMesNomi(historialpagomesnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(this.historialpagomesnomis);
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
		historialpagomesnomis = new  ArrayList<HistorialPagoMesNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoMesNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HistorialPagoMesNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialpagomesnomis=historialpagomesnomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHistorialPagoMesNomi(historialpagomesnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(this.historialpagomesnomis);
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
		historialpagomesnomis = new  ArrayList<HistorialPagoMesNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HistorialPagoMesNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialpagomesnomis=historialpagomesnomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHistorialPagoMesNomi(historialpagomesnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(this.historialpagomesnomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		historialpagomesnomi = new  HistorialPagoMesNomi();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoMesNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HistorialPagoMesNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialpagomesnomi=historialpagomesnomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHistorialPagoMesNomi(historialpagomesnomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(this.historialpagomesnomi);
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
		historialpagomesnomi = new  HistorialPagoMesNomi();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HistorialPagoMesNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialpagomesnomi=historialpagomesnomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHistorialPagoMesNomi(historialpagomesnomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(this.historialpagomesnomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		historialpagomesnomis = new  ArrayList<HistorialPagoMesNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoMesNomi.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			HistorialPagoMesNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialpagomesnomis=historialpagomesnomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHistorialPagoMesNomi(historialpagomesnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(this.historialpagomesnomis);
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
		historialpagomesnomis = new  ArrayList<HistorialPagoMesNomi>();
		  		  
        try {
			HistorialPagoMesNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialpagomesnomis=historialpagomesnomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHistorialPagoMesNomi(historialpagomesnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(this.historialpagomesnomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosHistorialPagoMesNomisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		historialpagomesnomis = new  ArrayList<HistorialPagoMesNomi>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoMesNomi.class.getSimpleName()+"-getTodosHistorialPagoMesNomisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HistorialPagoMesNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialpagomesnomis=historialpagomesnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarHistorialPagoMesNomi(historialpagomesnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(this.historialpagomesnomis);
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
	
	public  void  getTodosHistorialPagoMesNomis(String sFinalQuery,Pagination pagination)throws Exception {
		historialpagomesnomis = new  ArrayList<HistorialPagoMesNomi>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HistorialPagoMesNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialpagomesnomis=historialpagomesnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarHistorialPagoMesNomi(historialpagomesnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(this.historialpagomesnomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarHistorialPagoMesNomi(HistorialPagoMesNomi historialpagomesnomi) throws Exception {
		Boolean estaValidado=false;
		
		if(historialpagomesnomi.getIsNew() || historialpagomesnomi.getIsChanged()) { 
			this.invalidValues = historialpagomesnomiValidator.getInvalidValues(historialpagomesnomi);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(historialpagomesnomi);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarHistorialPagoMesNomi(List<HistorialPagoMesNomi> HistorialPagoMesNomis) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(HistorialPagoMesNomi historialpagomesnomiLocal:historialpagomesnomis) {				
			estaValidadoObjeto=this.validarGuardarHistorialPagoMesNomi(historialpagomesnomiLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarHistorialPagoMesNomi(List<HistorialPagoMesNomi> HistorialPagoMesNomis) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarHistorialPagoMesNomi(historialpagomesnomis)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarHistorialPagoMesNomi(HistorialPagoMesNomi HistorialPagoMesNomi) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarHistorialPagoMesNomi(historialpagomesnomi)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(HistorialPagoMesNomi historialpagomesnomi) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+historialpagomesnomi.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=HistorialPagoMesNomiConstantesFunciones.getHistorialPagoMesNomiLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"historialpagomesnomi","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(HistorialPagoMesNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(HistorialPagoMesNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveHistorialPagoMesNomiWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoMesNomi.class.getSimpleName()+"-saveHistorialPagoMesNomiWithConnection");connexion.begin();			
			
			HistorialPagoMesNomiLogicAdditional.checkHistorialPagoMesNomiToSave(this.historialpagomesnomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			HistorialPagoMesNomiLogicAdditional.updateHistorialPagoMesNomiToSave(this.historialpagomesnomi,this.arrDatoGeneral);
			
			HistorialPagoMesNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.historialpagomesnomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowHistorialPagoMesNomi();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarHistorialPagoMesNomi(this.historialpagomesnomi)) {
				HistorialPagoMesNomiDataAccess.save(this.historialpagomesnomi, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.historialpagomesnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			HistorialPagoMesNomiLogicAdditional.checkHistorialPagoMesNomiToSaveAfter(this.historialpagomesnomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowHistorialPagoMesNomi();
			
			connexion.commit();			
			
			if(this.historialpagomesnomi.getIsDeleted()) {
				this.historialpagomesnomi=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveHistorialPagoMesNomi()throws Exception {	
		try {	
			
			HistorialPagoMesNomiLogicAdditional.checkHistorialPagoMesNomiToSave(this.historialpagomesnomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			HistorialPagoMesNomiLogicAdditional.updateHistorialPagoMesNomiToSave(this.historialpagomesnomi,this.arrDatoGeneral);
			
			HistorialPagoMesNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.historialpagomesnomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarHistorialPagoMesNomi(this.historialpagomesnomi)) {			
				HistorialPagoMesNomiDataAccess.save(this.historialpagomesnomi, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.historialpagomesnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			HistorialPagoMesNomiLogicAdditional.checkHistorialPagoMesNomiToSaveAfter(this.historialpagomesnomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.historialpagomesnomi.getIsDeleted()) {
				this.historialpagomesnomi=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveHistorialPagoMesNomisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoMesNomi.class.getSimpleName()+"-saveHistorialPagoMesNomisWithConnection");connexion.begin();			
			
			HistorialPagoMesNomiLogicAdditional.checkHistorialPagoMesNomiToSaves(historialpagomesnomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowHistorialPagoMesNomis();
			
			Boolean validadoTodosHistorialPagoMesNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(HistorialPagoMesNomi historialpagomesnomiLocal:historialpagomesnomis) {		
				if(historialpagomesnomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				HistorialPagoMesNomiLogicAdditional.updateHistorialPagoMesNomiToSave(historialpagomesnomiLocal,this.arrDatoGeneral);
	        	
				HistorialPagoMesNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),historialpagomesnomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarHistorialPagoMesNomi(historialpagomesnomiLocal)) {
					HistorialPagoMesNomiDataAccess.save(historialpagomesnomiLocal, connexion);				
				} else {
					validadoTodosHistorialPagoMesNomi=false;
				}
			}
			
			if(!validadoTodosHistorialPagoMesNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			HistorialPagoMesNomiLogicAdditional.checkHistorialPagoMesNomiToSavesAfter(historialpagomesnomis,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowHistorialPagoMesNomis();
			
			connexion.commit();		
			
			this.quitarHistorialPagoMesNomisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveHistorialPagoMesNomis()throws Exception {				
		 try {	
			HistorialPagoMesNomiLogicAdditional.checkHistorialPagoMesNomiToSaves(historialpagomesnomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosHistorialPagoMesNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(HistorialPagoMesNomi historialpagomesnomiLocal:historialpagomesnomis) {				
				if(historialpagomesnomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				HistorialPagoMesNomiLogicAdditional.updateHistorialPagoMesNomiToSave(historialpagomesnomiLocal,this.arrDatoGeneral);
	        	
				HistorialPagoMesNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),historialpagomesnomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarHistorialPagoMesNomi(historialpagomesnomiLocal)) {				
					HistorialPagoMesNomiDataAccess.save(historialpagomesnomiLocal, connexion);				
				} else {
					validadoTodosHistorialPagoMesNomi=false;
				}
			}
			
			if(!validadoTodosHistorialPagoMesNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			HistorialPagoMesNomiLogicAdditional.checkHistorialPagoMesNomiToSavesAfter(historialpagomesnomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarHistorialPagoMesNomisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public HistorialPagoMesNomiParameterReturnGeneral procesarAccionHistorialPagoMesNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<HistorialPagoMesNomi> historialpagomesnomis,HistorialPagoMesNomiParameterReturnGeneral historialpagomesnomiParameterGeneral)throws Exception {
		 try {	
			HistorialPagoMesNomiParameterReturnGeneral historialpagomesnomiReturnGeneral=new HistorialPagoMesNomiParameterReturnGeneral();
	
			HistorialPagoMesNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,historialpagomesnomis,historialpagomesnomiParameterGeneral,historialpagomesnomiReturnGeneral);
			
			return historialpagomesnomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public HistorialPagoMesNomiParameterReturnGeneral procesarAccionHistorialPagoMesNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<HistorialPagoMesNomi> historialpagomesnomis,HistorialPagoMesNomiParameterReturnGeneral historialpagomesnomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoMesNomi.class.getSimpleName()+"-procesarAccionHistorialPagoMesNomisWithConnection");connexion.begin();			
			
			HistorialPagoMesNomiParameterReturnGeneral historialpagomesnomiReturnGeneral=new HistorialPagoMesNomiParameterReturnGeneral();
	
			HistorialPagoMesNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,historialpagomesnomis,historialpagomesnomiParameterGeneral,historialpagomesnomiReturnGeneral);
			
			this.connexion.commit();
			
			return historialpagomesnomiReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public HistorialPagoMesNomiParameterReturnGeneral procesarEventosHistorialPagoMesNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<HistorialPagoMesNomi> historialpagomesnomis,HistorialPagoMesNomi historialpagomesnomi,HistorialPagoMesNomiParameterReturnGeneral historialpagomesnomiParameterGeneral,Boolean isEsNuevoHistorialPagoMesNomi,ArrayList<Classe> clases)throws Exception {
		 try {	
			HistorialPagoMesNomiParameterReturnGeneral historialpagomesnomiReturnGeneral=new HistorialPagoMesNomiParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				historialpagomesnomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			HistorialPagoMesNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,historialpagomesnomis,historialpagomesnomi,historialpagomesnomiParameterGeneral,historialpagomesnomiReturnGeneral,isEsNuevoHistorialPagoMesNomi,clases);
			
			return historialpagomesnomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public HistorialPagoMesNomiParameterReturnGeneral procesarEventosHistorialPagoMesNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<HistorialPagoMesNomi> historialpagomesnomis,HistorialPagoMesNomi historialpagomesnomi,HistorialPagoMesNomiParameterReturnGeneral historialpagomesnomiParameterGeneral,Boolean isEsNuevoHistorialPagoMesNomi,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoMesNomi.class.getSimpleName()+"-procesarEventosHistorialPagoMesNomisWithConnection");connexion.begin();			
			
			HistorialPagoMesNomiParameterReturnGeneral historialpagomesnomiReturnGeneral=new HistorialPagoMesNomiParameterReturnGeneral();
	
			historialpagomesnomiReturnGeneral.setHistorialPagoMesNomi(historialpagomesnomi);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				historialpagomesnomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			HistorialPagoMesNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,historialpagomesnomis,historialpagomesnomi,historialpagomesnomiParameterGeneral,historialpagomesnomiReturnGeneral,isEsNuevoHistorialPagoMesNomi,clases);
			
			this.connexion.commit();
			
			return historialpagomesnomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public HistorialPagoMesNomiParameterReturnGeneral procesarImportacionHistorialPagoMesNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,HistorialPagoMesNomiParameterReturnGeneral historialpagomesnomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoMesNomi.class.getSimpleName()+"-procesarImportacionHistorialPagoMesNomisWithConnection");connexion.begin();			
			
			HistorialPagoMesNomiParameterReturnGeneral historialpagomesnomiReturnGeneral=new HistorialPagoMesNomiParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.historialpagomesnomis=new ArrayList<HistorialPagoMesNomi>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.historialpagomesnomi=new HistorialPagoMesNomi();
				
				
				if(conColumnasBase) {this.historialpagomesnomi.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.historialpagomesnomi.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.historialpagomesnomi.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.historialpagomesnomis.add(this.historialpagomesnomi);
			}
			
			this.saveHistorialPagoMesNomis();
			
			this.connexion.commit();
			
			historialpagomesnomiReturnGeneral.setConRetornoEstaProcesado(true);
			historialpagomesnomiReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return historialpagomesnomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarHistorialPagoMesNomisEliminados() throws Exception {				
		
		List<HistorialPagoMesNomi> historialpagomesnomisAux= new ArrayList<HistorialPagoMesNomi>();
		
		for(HistorialPagoMesNomi historialpagomesnomi:historialpagomesnomis) {
			if(!historialpagomesnomi.getIsDeleted()) {
				historialpagomesnomisAux.add(historialpagomesnomi);
			}
		}
		
		historialpagomesnomis=historialpagomesnomisAux;
	}
	
	public void quitarHistorialPagoMesNomisNulos() throws Exception {				
		
		List<HistorialPagoMesNomi> historialpagomesnomisAux= new ArrayList<HistorialPagoMesNomi>();
		
		for(HistorialPagoMesNomi historialpagomesnomi : this.historialpagomesnomis) {
			if(historialpagomesnomi==null) {
				historialpagomesnomisAux.add(historialpagomesnomi);
			}
		}
		
		//this.historialpagomesnomis=historialpagomesnomisAux;
		
		this.historialpagomesnomis.removeAll(historialpagomesnomisAux);
	}
	
	public void getSetVersionRowHistorialPagoMesNomiWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(historialpagomesnomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((historialpagomesnomi.getIsDeleted() || (historialpagomesnomi.getIsChanged()&&!historialpagomesnomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=historialpagomesnomiDataAccess.getSetVersionRowHistorialPagoMesNomi(connexion,historialpagomesnomi.getId());
				
				if(!historialpagomesnomi.getVersionRow().equals(timestamp)) {	
					historialpagomesnomi.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				historialpagomesnomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowHistorialPagoMesNomi()throws Exception {	
		
		if(historialpagomesnomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((historialpagomesnomi.getIsDeleted() || (historialpagomesnomi.getIsChanged()&&!historialpagomesnomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=historialpagomesnomiDataAccess.getSetVersionRowHistorialPagoMesNomi(connexion,historialpagomesnomi.getId());
			
			try {							
				if(!historialpagomesnomi.getVersionRow().equals(timestamp)) {	
					historialpagomesnomi.setVersionRow(timestamp);
				}
				
				historialpagomesnomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowHistorialPagoMesNomisWithConnection()throws Exception {	
		if(historialpagomesnomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(HistorialPagoMesNomi historialpagomesnomiAux:historialpagomesnomis) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(historialpagomesnomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(historialpagomesnomiAux.getIsDeleted() || (historialpagomesnomiAux.getIsChanged()&&!historialpagomesnomiAux.getIsNew())) {
						
						timestamp=historialpagomesnomiDataAccess.getSetVersionRowHistorialPagoMesNomi(connexion,historialpagomesnomiAux.getId());
						
						if(!historialpagomesnomi.getVersionRow().equals(timestamp)) {	
							historialpagomesnomiAux.setVersionRow(timestamp);
						}
								
						historialpagomesnomiAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowHistorialPagoMesNomis()throws Exception {	
		if(historialpagomesnomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(HistorialPagoMesNomi historialpagomesnomiAux:historialpagomesnomis) {
					if(historialpagomesnomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(historialpagomesnomiAux.getIsDeleted() || (historialpagomesnomiAux.getIsChanged()&&!historialpagomesnomiAux.getIsNew())) {
						
						timestamp=historialpagomesnomiDataAccess.getSetVersionRowHistorialPagoMesNomi(connexion,historialpagomesnomiAux.getId());
						
						if(!historialpagomesnomiAux.getVersionRow().equals(timestamp)) {	
							historialpagomesnomiAux.setVersionRow(timestamp);
						}
						
													
						historialpagomesnomiAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public HistorialPagoMesNomiParameterReturnGeneral cargarCombosLoteForeignKeyHistorialPagoMesNomiWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalRubroEmplea,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		HistorialPagoMesNomiParameterReturnGeneral  historialpagomesnomiReturnGeneral =new HistorialPagoMesNomiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoMesNomi.class.getSimpleName()+"-cargarCombosLoteForeignKeyHistorialPagoMesNomiWithConnection");connexion.begin();
			
			historialpagomesnomiReturnGeneral =new HistorialPagoMesNomiParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			historialpagomesnomiReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			historialpagomesnomiReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<RubroEmplea> rubroempleasForeignKey=new ArrayList<RubroEmplea>();
			RubroEmpleaLogic rubroempleaLogic=new RubroEmpleaLogic();
			rubroempleaLogic.setConnexion(this.connexion);
			rubroempleaLogic.getRubroEmpleaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRubroEmplea.equals("NONE")) {
				rubroempleaLogic.getTodosRubroEmpleas(finalQueryGlobalRubroEmplea,new Pagination());
				rubroempleasForeignKey=rubroempleaLogic.getRubroEmpleas();
			}

			historialpagomesnomiReturnGeneral.setrubroempleasForeignKey(rubroempleasForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			historialpagomesnomiReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			historialpagomesnomiReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return historialpagomesnomiReturnGeneral;
	}
	
	public HistorialPagoMesNomiParameterReturnGeneral cargarCombosLoteForeignKeyHistorialPagoMesNomi(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalRubroEmplea,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		HistorialPagoMesNomiParameterReturnGeneral  historialpagomesnomiReturnGeneral =new HistorialPagoMesNomiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			historialpagomesnomiReturnGeneral =new HistorialPagoMesNomiParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			historialpagomesnomiReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			historialpagomesnomiReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<RubroEmplea> rubroempleasForeignKey=new ArrayList<RubroEmplea>();
			RubroEmpleaLogic rubroempleaLogic=new RubroEmpleaLogic();
			rubroempleaLogic.setConnexion(this.connexion);
			rubroempleaLogic.getRubroEmpleaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRubroEmplea.equals("NONE")) {
				rubroempleaLogic.getTodosRubroEmpleas(finalQueryGlobalRubroEmplea,new Pagination());
				rubroempleasForeignKey=rubroempleaLogic.getRubroEmpleas();
			}

			historialpagomesnomiReturnGeneral.setrubroempleasForeignKey(rubroempleasForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			historialpagomesnomiReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			historialpagomesnomiReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return historialpagomesnomiReturnGeneral;
	}
	
	
	public void deepLoad(HistorialPagoMesNomi historialpagomesnomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			HistorialPagoMesNomiLogicAdditional.updateHistorialPagoMesNomiToGet(historialpagomesnomi,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		historialpagomesnomi.setEmpresa(historialpagomesnomiDataAccess.getEmpresa(connexion,historialpagomesnomi));
		historialpagomesnomi.setEmpleado(historialpagomesnomiDataAccess.getEmpleado(connexion,historialpagomesnomi));
		historialpagomesnomi.setRubroEmplea(historialpagomesnomiDataAccess.getRubroEmplea(connexion,historialpagomesnomi));
		historialpagomesnomi.setAnio(historialpagomesnomiDataAccess.getAnio(connexion,historialpagomesnomi));
		historialpagomesnomi.setMes(historialpagomesnomiDataAccess.getMes(connexion,historialpagomesnomi));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				historialpagomesnomi.setEmpresa(historialpagomesnomiDataAccess.getEmpresa(connexion,historialpagomesnomi));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				historialpagomesnomi.setEmpleado(historialpagomesnomiDataAccess.getEmpleado(connexion,historialpagomesnomi));
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				historialpagomesnomi.setRubroEmplea(historialpagomesnomiDataAccess.getRubroEmplea(connexion,historialpagomesnomi));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				historialpagomesnomi.setAnio(historialpagomesnomiDataAccess.getAnio(connexion,historialpagomesnomi));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				historialpagomesnomi.setMes(historialpagomesnomiDataAccess.getMes(connexion,historialpagomesnomi));
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
			historialpagomesnomi.setEmpresa(historialpagomesnomiDataAccess.getEmpresa(connexion,historialpagomesnomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialpagomesnomi.setEmpleado(historialpagomesnomiDataAccess.getEmpleado(connexion,historialpagomesnomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmplea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialpagomesnomi.setRubroEmplea(historialpagomesnomiDataAccess.getRubroEmplea(connexion,historialpagomesnomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialpagomesnomi.setAnio(historialpagomesnomiDataAccess.getAnio(connexion,historialpagomesnomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialpagomesnomi.setMes(historialpagomesnomiDataAccess.getMes(connexion,historialpagomesnomi));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		historialpagomesnomi.setEmpresa(historialpagomesnomiDataAccess.getEmpresa(connexion,historialpagomesnomi));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(historialpagomesnomi.getEmpresa(),isDeep,deepLoadType,clases);
				
		historialpagomesnomi.setEmpleado(historialpagomesnomiDataAccess.getEmpleado(connexion,historialpagomesnomi));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(historialpagomesnomi.getEmpleado(),isDeep,deepLoadType,clases);
				
		historialpagomesnomi.setRubroEmplea(historialpagomesnomiDataAccess.getRubroEmplea(connexion,historialpagomesnomi));
		RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
		rubroempleaLogic.deepLoad(historialpagomesnomi.getRubroEmplea(),isDeep,deepLoadType,clases);
				
		historialpagomesnomi.setAnio(historialpagomesnomiDataAccess.getAnio(connexion,historialpagomesnomi));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(historialpagomesnomi.getAnio(),isDeep,deepLoadType,clases);
				
		historialpagomesnomi.setMes(historialpagomesnomiDataAccess.getMes(connexion,historialpagomesnomi));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(historialpagomesnomi.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				historialpagomesnomi.setEmpresa(historialpagomesnomiDataAccess.getEmpresa(connexion,historialpagomesnomi));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(historialpagomesnomi.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				historialpagomesnomi.setEmpleado(historialpagomesnomiDataAccess.getEmpleado(connexion,historialpagomesnomi));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(historialpagomesnomi.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				historialpagomesnomi.setRubroEmplea(historialpagomesnomiDataAccess.getRubroEmplea(connexion,historialpagomesnomi));
				RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
				rubroempleaLogic.deepLoad(historialpagomesnomi.getRubroEmplea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				historialpagomesnomi.setAnio(historialpagomesnomiDataAccess.getAnio(connexion,historialpagomesnomi));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(historialpagomesnomi.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				historialpagomesnomi.setMes(historialpagomesnomiDataAccess.getMes(connexion,historialpagomesnomi));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(historialpagomesnomi.getMes(),isDeep,deepLoadType,clases);				
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
			historialpagomesnomi.setEmpresa(historialpagomesnomiDataAccess.getEmpresa(connexion,historialpagomesnomi));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(historialpagomesnomi.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialpagomesnomi.setEmpleado(historialpagomesnomiDataAccess.getEmpleado(connexion,historialpagomesnomi));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(historialpagomesnomi.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmplea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialpagomesnomi.setRubroEmplea(historialpagomesnomiDataAccess.getRubroEmplea(connexion,historialpagomesnomi));
			RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
			rubroempleaLogic.deepLoad(historialpagomesnomi.getRubroEmplea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialpagomesnomi.setAnio(historialpagomesnomiDataAccess.getAnio(connexion,historialpagomesnomi));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(historialpagomesnomi.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialpagomesnomi.setMes(historialpagomesnomiDataAccess.getMes(connexion,historialpagomesnomi));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(historialpagomesnomi.getMes(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(HistorialPagoMesNomi historialpagomesnomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			HistorialPagoMesNomiLogicAdditional.updateHistorialPagoMesNomiToSave(historialpagomesnomi,this.arrDatoGeneral);
			
HistorialPagoMesNomiDataAccess.save(historialpagomesnomi, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(historialpagomesnomi.getEmpresa(),connexion);

		EmpleadoDataAccess.save(historialpagomesnomi.getEmpleado(),connexion);

		RubroEmpleaDataAccess.save(historialpagomesnomi.getRubroEmplea(),connexion);

		AnioDataAccess.save(historialpagomesnomi.getAnio(),connexion);

		MesDataAccess.save(historialpagomesnomi.getMes(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(historialpagomesnomi.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(historialpagomesnomi.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				RubroEmpleaDataAccess.save(historialpagomesnomi.getRubroEmplea(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(historialpagomesnomi.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(historialpagomesnomi.getMes(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(historialpagomesnomi.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(historialpagomesnomi.getEmpresa(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(historialpagomesnomi.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(historialpagomesnomi.getEmpleado(),isDeep,deepLoadType,clases);
				

		RubroEmpleaDataAccess.save(historialpagomesnomi.getRubroEmplea(),connexion);
		RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
		rubroempleaLogic.deepLoad(historialpagomesnomi.getRubroEmplea(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(historialpagomesnomi.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(historialpagomesnomi.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(historialpagomesnomi.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(historialpagomesnomi.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(historialpagomesnomi.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(historialpagomesnomi.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(historialpagomesnomi.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(historialpagomesnomi.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				RubroEmpleaDataAccess.save(historialpagomesnomi.getRubroEmplea(),connexion);
				RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
				rubroempleaLogic.deepSave(historialpagomesnomi.getRubroEmplea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(historialpagomesnomi.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(historialpagomesnomi.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(historialpagomesnomi.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(historialpagomesnomi.getMes(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(HistorialPagoMesNomi.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(historialpagomesnomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(historialpagomesnomi);
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
			this.deepLoad(this.historialpagomesnomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(this.historialpagomesnomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(HistorialPagoMesNomi.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(historialpagomesnomis!=null) {
				for(HistorialPagoMesNomi historialpagomesnomi:historialpagomesnomis) {
					this.deepLoad(historialpagomesnomi,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(historialpagomesnomis);
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
			if(historialpagomesnomis!=null) {
				for(HistorialPagoMesNomi historialpagomesnomi:historialpagomesnomis) {
					this.deepLoad(historialpagomesnomi,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(historialpagomesnomis);
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
			this.getNewConnexionToDeep(HistorialPagoMesNomi.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(historialpagomesnomi,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(HistorialPagoMesNomi.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(historialpagomesnomis!=null) {
				for(HistorialPagoMesNomi historialpagomesnomi:historialpagomesnomis) {
					this.deepSave(historialpagomesnomi,isDeep,deepLoadType,clases);
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
			if(historialpagomesnomis!=null) {
				for(HistorialPagoMesNomi historialpagomesnomi:historialpagomesnomis) {
					this.deepSave(historialpagomesnomi,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getHistorialPagoMesNomisFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoMesNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,HistorialPagoMesNomiConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			HistorialPagoMesNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialpagomesnomis=historialpagomesnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(this.historialpagomesnomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHistorialPagoMesNomisFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,HistorialPagoMesNomiConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			HistorialPagoMesNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialpagomesnomis=historialpagomesnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(this.historialpagomesnomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getHistorialPagoMesNomisFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoMesNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,HistorialPagoMesNomiConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			HistorialPagoMesNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialpagomesnomis=historialpagomesnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(this.historialpagomesnomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHistorialPagoMesNomisFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,HistorialPagoMesNomiConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			HistorialPagoMesNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialpagomesnomis=historialpagomesnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(this.historialpagomesnomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getHistorialPagoMesNomisFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoMesNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,HistorialPagoMesNomiConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			HistorialPagoMesNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialpagomesnomis=historialpagomesnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(this.historialpagomesnomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHistorialPagoMesNomisFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,HistorialPagoMesNomiConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			HistorialPagoMesNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialpagomesnomis=historialpagomesnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(this.historialpagomesnomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getHistorialPagoMesNomisFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoMesNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,HistorialPagoMesNomiConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			HistorialPagoMesNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialpagomesnomis=historialpagomesnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(this.historialpagomesnomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHistorialPagoMesNomisFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,HistorialPagoMesNomiConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			HistorialPagoMesNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialpagomesnomis=historialpagomesnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(this.historialpagomesnomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getHistorialPagoMesNomisFK_IdRubroEmpleaWithConnection(String sFinalQuery,Pagination pagination,Long id_rubro_emplea)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialPagoMesNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRubroEmplea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRubroEmplea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_rubro_emplea,HistorialPagoMesNomiConstantesFunciones.IDRUBROEMPLEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRubroEmplea);

			HistorialPagoMesNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRubroEmplea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialpagomesnomis=historialpagomesnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(this.historialpagomesnomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHistorialPagoMesNomisFK_IdRubroEmplea(String sFinalQuery,Pagination pagination,Long id_rubro_emplea)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRubroEmplea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRubroEmplea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_rubro_emplea,HistorialPagoMesNomiConstantesFunciones.IDRUBROEMPLEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRubroEmplea);

			HistorialPagoMesNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRubroEmplea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialpagomesnomis=historialpagomesnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(this.historialpagomesnomis);
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
			if(HistorialPagoMesNomiConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,HistorialPagoMesNomiDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,HistorialPagoMesNomi historialpagomesnomi,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(HistorialPagoMesNomiConstantesFunciones.ISCONAUDITORIA) {
				if(historialpagomesnomi.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,HistorialPagoMesNomiDataAccess.TABLENAME, historialpagomesnomi.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(HistorialPagoMesNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////HistorialPagoMesNomiLogic.registrarAuditoriaDetallesHistorialPagoMesNomi(connexion,historialpagomesnomi,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(historialpagomesnomi.getIsDeleted()) {
					/*if(!historialpagomesnomi.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,HistorialPagoMesNomiDataAccess.TABLENAME, historialpagomesnomi.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////HistorialPagoMesNomiLogic.registrarAuditoriaDetallesHistorialPagoMesNomi(connexion,historialpagomesnomi,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,HistorialPagoMesNomiDataAccess.TABLENAME, historialpagomesnomi.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(historialpagomesnomi.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,HistorialPagoMesNomiDataAccess.TABLENAME, historialpagomesnomi.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(HistorialPagoMesNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////HistorialPagoMesNomiLogic.registrarAuditoriaDetallesHistorialPagoMesNomi(connexion,historialpagomesnomi,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesHistorialPagoMesNomi(Connexion connexion,HistorialPagoMesNomi historialpagomesnomi)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(historialpagomesnomi.getIsNew()||!historialpagomesnomi.getid_empresa().equals(historialpagomesnomi.getHistorialPagoMesNomiOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialpagomesnomi.getHistorialPagoMesNomiOriginal().getid_empresa()!=null)
				{
					strValorActual=historialpagomesnomi.getHistorialPagoMesNomiOriginal().getid_empresa().toString();
				}
				if(historialpagomesnomi.getid_empresa()!=null)
				{
					strValorNuevo=historialpagomesnomi.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialPagoMesNomiConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(historialpagomesnomi.getIsNew()||!historialpagomesnomi.getid_empleado().equals(historialpagomesnomi.getHistorialPagoMesNomiOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialpagomesnomi.getHistorialPagoMesNomiOriginal().getid_empleado()!=null)
				{
					strValorActual=historialpagomesnomi.getHistorialPagoMesNomiOriginal().getid_empleado().toString();
				}
				if(historialpagomesnomi.getid_empleado()!=null)
				{
					strValorNuevo=historialpagomesnomi.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialPagoMesNomiConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(historialpagomesnomi.getIsNew()||!historialpagomesnomi.getid_rubro_emplea().equals(historialpagomesnomi.getHistorialPagoMesNomiOriginal().getid_rubro_emplea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialpagomesnomi.getHistorialPagoMesNomiOriginal().getid_rubro_emplea()!=null)
				{
					strValorActual=historialpagomesnomi.getHistorialPagoMesNomiOriginal().getid_rubro_emplea().toString();
				}
				if(historialpagomesnomi.getid_rubro_emplea()!=null)
				{
					strValorNuevo=historialpagomesnomi.getid_rubro_emplea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialPagoMesNomiConstantesFunciones.IDRUBROEMPLEA,strValorActual,strValorNuevo);
			}	
			
			if(historialpagomesnomi.getIsNew()||!historialpagomesnomi.getid_anio().equals(historialpagomesnomi.getHistorialPagoMesNomiOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialpagomesnomi.getHistorialPagoMesNomiOriginal().getid_anio()!=null)
				{
					strValorActual=historialpagomesnomi.getHistorialPagoMesNomiOriginal().getid_anio().toString();
				}
				if(historialpagomesnomi.getid_anio()!=null)
				{
					strValorNuevo=historialpagomesnomi.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialPagoMesNomiConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(historialpagomesnomi.getIsNew()||!historialpagomesnomi.getid_mes().equals(historialpagomesnomi.getHistorialPagoMesNomiOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialpagomesnomi.getHistorialPagoMesNomiOriginal().getid_mes()!=null)
				{
					strValorActual=historialpagomesnomi.getHistorialPagoMesNomiOriginal().getid_mes().toString();
				}
				if(historialpagomesnomi.getid_mes()!=null)
				{
					strValorNuevo=historialpagomesnomi.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialPagoMesNomiConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(historialpagomesnomi.getIsNew()||!historialpagomesnomi.getvalor().equals(historialpagomesnomi.getHistorialPagoMesNomiOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialpagomesnomi.getHistorialPagoMesNomiOriginal().getvalor()!=null)
				{
					strValorActual=historialpagomesnomi.getHistorialPagoMesNomiOriginal().getvalor().toString();
				}
				if(historialpagomesnomi.getvalor()!=null)
				{
					strValorNuevo=historialpagomesnomi.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialPagoMesNomiConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveHistorialPagoMesNomiRelacionesWithConnection(HistorialPagoMesNomi historialpagomesnomi) throws Exception {

		if(!historialpagomesnomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveHistorialPagoMesNomiRelacionesBase(historialpagomesnomi,true);
		}
	}

	public void saveHistorialPagoMesNomiRelaciones(HistorialPagoMesNomi historialpagomesnomi)throws Exception {

		if(!historialpagomesnomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveHistorialPagoMesNomiRelacionesBase(historialpagomesnomi,false);
		}
	}

	public void saveHistorialPagoMesNomiRelacionesBase(HistorialPagoMesNomi historialpagomesnomi,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("HistorialPagoMesNomi-saveRelacionesWithConnection");}
	

			this.setHistorialPagoMesNomi(historialpagomesnomi);

			if(HistorialPagoMesNomiLogicAdditional.validarSaveRelaciones(historialpagomesnomi,this)) {

				HistorialPagoMesNomiLogicAdditional.updateRelacionesToSave(historialpagomesnomi,this);

				if((historialpagomesnomi.getIsNew()||historialpagomesnomi.getIsChanged())&&!historialpagomesnomi.getIsDeleted()) {
					this.saveHistorialPagoMesNomi();
					this.saveHistorialPagoMesNomiRelacionesDetalles();

				} else if(historialpagomesnomi.getIsDeleted()) {
					this.saveHistorialPagoMesNomiRelacionesDetalles();
					this.saveHistorialPagoMesNomi();
				}

				HistorialPagoMesNomiLogicAdditional.updateRelacionesToSaveAfter(historialpagomesnomi,this);

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
	
	
	private void saveHistorialPagoMesNomiRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfHistorialPagoMesNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=HistorialPagoMesNomiConstantesFunciones.getClassesForeignKeysOfHistorialPagoMesNomi(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfHistorialPagoMesNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=HistorialPagoMesNomiConstantesFunciones.getClassesRelationshipsOfHistorialPagoMesNomi(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
