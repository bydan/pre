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
import com.bydan.erp.nomina.util.DetalleEvaluacionNomiConstantesFunciones;
import com.bydan.erp.nomina.util.DetalleEvaluacionNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.DetalleEvaluacionNomiParameterGeneral;
import com.bydan.erp.nomina.business.entity.DetalleEvaluacionNomi;
import com.bydan.erp.nomina.business.logic.DetalleEvaluacionNomiLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class DetalleEvaluacionNomiLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleEvaluacionNomiLogic.class);
	
	protected DetalleEvaluacionNomiDataAccess detalleevaluacionnomiDataAccess; 	
	protected DetalleEvaluacionNomi detalleevaluacionnomi;
	protected List<DetalleEvaluacionNomi> detalleevaluacionnomis;
	protected Object detalleevaluacionnomiObject;	
	protected List<Object> detalleevaluacionnomisObject;
	
	public static ClassValidator<DetalleEvaluacionNomi> detalleevaluacionnomiValidator = new ClassValidator<DetalleEvaluacionNomi>(DetalleEvaluacionNomi.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleEvaluacionNomiLogicAdditional detalleevaluacionnomiLogicAdditional=null;
	
	public DetalleEvaluacionNomiLogicAdditional getDetalleEvaluacionNomiLogicAdditional() {
		return this.detalleevaluacionnomiLogicAdditional;
	}
	
	public void setDetalleEvaluacionNomiLogicAdditional(DetalleEvaluacionNomiLogicAdditional detalleevaluacionnomiLogicAdditional) {
		try {
			this.detalleevaluacionnomiLogicAdditional=detalleevaluacionnomiLogicAdditional;
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
	
	
	
	
	public  DetalleEvaluacionNomiLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detalleevaluacionnomiDataAccess = new DetalleEvaluacionNomiDataAccess();
			
			this.detalleevaluacionnomis= new ArrayList<DetalleEvaluacionNomi>();
			this.detalleevaluacionnomi= new DetalleEvaluacionNomi();
			
			this.detalleevaluacionnomiObject=new Object();
			this.detalleevaluacionnomisObject=new ArrayList<Object>();
				
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
			
			this.detalleevaluacionnomiDataAccess.setConnexionType(this.connexionType);
			this.detalleevaluacionnomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleEvaluacionNomiLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detalleevaluacionnomiDataAccess = new DetalleEvaluacionNomiDataAccess();
			this.detalleevaluacionnomis= new ArrayList<DetalleEvaluacionNomi>();
			this.detalleevaluacionnomi= new DetalleEvaluacionNomi();
			this.detalleevaluacionnomiObject=new Object();
			this.detalleevaluacionnomisObject=new ArrayList<Object>();
			
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
			
			this.detalleevaluacionnomiDataAccess.setConnexionType(this.connexionType);
			this.detalleevaluacionnomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleEvaluacionNomi getDetalleEvaluacionNomi() throws Exception {	
		DetalleEvaluacionNomiLogicAdditional.checkDetalleEvaluacionNomiToGet(detalleevaluacionnomi,this.datosCliente,this.arrDatoGeneral);
		DetalleEvaluacionNomiLogicAdditional.updateDetalleEvaluacionNomiToGet(detalleevaluacionnomi,this.arrDatoGeneral);
		
		return detalleevaluacionnomi;
	}
		
	public void setDetalleEvaluacionNomi(DetalleEvaluacionNomi newDetalleEvaluacionNomi) {
		this.detalleevaluacionnomi = newDetalleEvaluacionNomi;
	}
	
	public DetalleEvaluacionNomiDataAccess getDetalleEvaluacionNomiDataAccess() {
		return detalleevaluacionnomiDataAccess;
	}
	
	public void setDetalleEvaluacionNomiDataAccess(DetalleEvaluacionNomiDataAccess newdetalleevaluacionnomiDataAccess) {
		this.detalleevaluacionnomiDataAccess = newdetalleevaluacionnomiDataAccess;
	}
	
	public List<DetalleEvaluacionNomi> getDetalleEvaluacionNomis() throws Exception {		
		this.quitarDetalleEvaluacionNomisNulos();
		
		DetalleEvaluacionNomiLogicAdditional.checkDetalleEvaluacionNomiToGets(detalleevaluacionnomis,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleEvaluacionNomi detalleevaluacionnomiLocal: detalleevaluacionnomis ) {
			DetalleEvaluacionNomiLogicAdditional.updateDetalleEvaluacionNomiToGet(detalleevaluacionnomiLocal,this.arrDatoGeneral);
		}
		
		return detalleevaluacionnomis;
	}
	
	public void setDetalleEvaluacionNomis(List<DetalleEvaluacionNomi> newDetalleEvaluacionNomis) {
		this.detalleevaluacionnomis = newDetalleEvaluacionNomis;
	}
	
	public Object getDetalleEvaluacionNomiObject() {	
		this.detalleevaluacionnomiObject=this.detalleevaluacionnomiDataAccess.getEntityObject();
		return this.detalleevaluacionnomiObject;
	}
		
	public void setDetalleEvaluacionNomiObject(Object newDetalleEvaluacionNomiObject) {
		this.detalleevaluacionnomiObject = newDetalleEvaluacionNomiObject;
	}
	
	public List<Object> getDetalleEvaluacionNomisObject() {		
		this.detalleevaluacionnomisObject=this.detalleevaluacionnomiDataAccess.getEntitiesObject();
		return this.detalleevaluacionnomisObject;
	}
		
	public void setDetalleEvaluacionNomisObject(List<Object> newDetalleEvaluacionNomisObject) {
		this.detalleevaluacionnomisObject = newDetalleEvaluacionNomisObject;
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
		
		if(this.detalleevaluacionnomiDataAccess!=null) {
			this.detalleevaluacionnomiDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionNomi.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detalleevaluacionnomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detalleevaluacionnomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detalleevaluacionnomi = new  DetalleEvaluacionNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleevaluacionnomi=detalleevaluacionnomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleevaluacionnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(this.detalleevaluacionnomi);
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
		detalleevaluacionnomi = new  DetalleEvaluacionNomi();
		  		  
        try {
			
			detalleevaluacionnomi=detalleevaluacionnomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleevaluacionnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(this.detalleevaluacionnomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detalleevaluacionnomi = new  DetalleEvaluacionNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleevaluacionnomi=detalleevaluacionnomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleevaluacionnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(this.detalleevaluacionnomi);
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
		detalleevaluacionnomi = new  DetalleEvaluacionNomi();
		  		  
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
		detalleevaluacionnomi = new  DetalleEvaluacionNomi();
		  		  
        try {
			
			detalleevaluacionnomi=detalleevaluacionnomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleevaluacionnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(this.detalleevaluacionnomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detalleevaluacionnomi = new  DetalleEvaluacionNomi();
		  		  
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
		detalleevaluacionnomi = new  DetalleEvaluacionNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionNomi.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detalleevaluacionnomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleevaluacionnomi = new  DetalleEvaluacionNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detalleevaluacionnomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleevaluacionnomi = new  DetalleEvaluacionNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionNomi.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detalleevaluacionnomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleevaluacionnomi = new  DetalleEvaluacionNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detalleevaluacionnomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleevaluacionnomi = new  DetalleEvaluacionNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionNomi.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detalleevaluacionnomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleevaluacionnomi = new  DetalleEvaluacionNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detalleevaluacionnomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleevaluacionnomis = new  ArrayList<DetalleEvaluacionNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleEvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleevaluacionnomis=detalleevaluacionnomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleEvaluacionNomi(detalleevaluacionnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(this.detalleevaluacionnomis);
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
		detalleevaluacionnomis = new  ArrayList<DetalleEvaluacionNomi>();
		  		  
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
		detalleevaluacionnomis = new  ArrayList<DetalleEvaluacionNomi>();
		  		  
        try {			
			DetalleEvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleevaluacionnomis=detalleevaluacionnomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleEvaluacionNomi(detalleevaluacionnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(this.detalleevaluacionnomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detalleevaluacionnomis = new  ArrayList<DetalleEvaluacionNomi>();
		  		  
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
		detalleevaluacionnomis = new  ArrayList<DetalleEvaluacionNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleEvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleevaluacionnomis=detalleevaluacionnomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleEvaluacionNomi(detalleevaluacionnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(this.detalleevaluacionnomis);
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
		detalleevaluacionnomis = new  ArrayList<DetalleEvaluacionNomi>();
		  		  
        try {
			DetalleEvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleevaluacionnomis=detalleevaluacionnomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleEvaluacionNomi(detalleevaluacionnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(this.detalleevaluacionnomis);
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
		detalleevaluacionnomis = new  ArrayList<DetalleEvaluacionNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleEvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleevaluacionnomis=detalleevaluacionnomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleEvaluacionNomi(detalleevaluacionnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(this.detalleevaluacionnomis);
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
		detalleevaluacionnomis = new  ArrayList<DetalleEvaluacionNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleEvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleevaluacionnomis=detalleevaluacionnomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleEvaluacionNomi(detalleevaluacionnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(this.detalleevaluacionnomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detalleevaluacionnomi = new  DetalleEvaluacionNomi();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleEvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleevaluacionnomi=detalleevaluacionnomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleEvaluacionNomi(detalleevaluacionnomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(this.detalleevaluacionnomi);
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
		detalleevaluacionnomi = new  DetalleEvaluacionNomi();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleEvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleevaluacionnomi=detalleevaluacionnomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleEvaluacionNomi(detalleevaluacionnomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(this.detalleevaluacionnomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleevaluacionnomis = new  ArrayList<DetalleEvaluacionNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionNomi.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleEvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleevaluacionnomis=detalleevaluacionnomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleEvaluacionNomi(detalleevaluacionnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(this.detalleevaluacionnomis);
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
		detalleevaluacionnomis = new  ArrayList<DetalleEvaluacionNomi>();
		  		  
        try {
			DetalleEvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleevaluacionnomis=detalleevaluacionnomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleEvaluacionNomi(detalleevaluacionnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(this.detalleevaluacionnomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleEvaluacionNomisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detalleevaluacionnomis = new  ArrayList<DetalleEvaluacionNomi>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionNomi.class.getSimpleName()+"-getTodosDetalleEvaluacionNomisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleEvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleevaluacionnomis=detalleevaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleEvaluacionNomi(detalleevaluacionnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(this.detalleevaluacionnomis);
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
	
	public  void  getTodosDetalleEvaluacionNomis(String sFinalQuery,Pagination pagination)throws Exception {
		detalleevaluacionnomis = new  ArrayList<DetalleEvaluacionNomi>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleEvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleevaluacionnomis=detalleevaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleEvaluacionNomi(detalleevaluacionnomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(this.detalleevaluacionnomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleEvaluacionNomi(DetalleEvaluacionNomi detalleevaluacionnomi) throws Exception {
		Boolean estaValidado=false;
		
		if(detalleevaluacionnomi.getIsNew() || detalleevaluacionnomi.getIsChanged()) { 
			this.invalidValues = detalleevaluacionnomiValidator.getInvalidValues(detalleevaluacionnomi);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detalleevaluacionnomi);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleEvaluacionNomi(List<DetalleEvaluacionNomi> DetalleEvaluacionNomis) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleEvaluacionNomi detalleevaluacionnomiLocal:detalleevaluacionnomis) {				
			estaValidadoObjeto=this.validarGuardarDetalleEvaluacionNomi(detalleevaluacionnomiLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleEvaluacionNomi(List<DetalleEvaluacionNomi> DetalleEvaluacionNomis) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleEvaluacionNomi(detalleevaluacionnomis)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleEvaluacionNomi(DetalleEvaluacionNomi DetalleEvaluacionNomi) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleEvaluacionNomi(detalleevaluacionnomi)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleEvaluacionNomi detalleevaluacionnomi) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detalleevaluacionnomi.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleEvaluacionNomiConstantesFunciones.getDetalleEvaluacionNomiLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detalleevaluacionnomi","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleEvaluacionNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleEvaluacionNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleEvaluacionNomiWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionNomi.class.getSimpleName()+"-saveDetalleEvaluacionNomiWithConnection");connexion.begin();			
			
			DetalleEvaluacionNomiLogicAdditional.checkDetalleEvaluacionNomiToSave(this.detalleevaluacionnomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleEvaluacionNomiLogicAdditional.updateDetalleEvaluacionNomiToSave(this.detalleevaluacionnomi,this.arrDatoGeneral);
			
			DetalleEvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleevaluacionnomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleEvaluacionNomi();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleEvaluacionNomi(this.detalleevaluacionnomi)) {
				DetalleEvaluacionNomiDataAccess.save(this.detalleevaluacionnomi, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detalleevaluacionnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleEvaluacionNomiLogicAdditional.checkDetalleEvaluacionNomiToSaveAfter(this.detalleevaluacionnomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleEvaluacionNomi();
			
			connexion.commit();			
			
			if(this.detalleevaluacionnomi.getIsDeleted()) {
				this.detalleevaluacionnomi=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleEvaluacionNomi()throws Exception {	
		try {	
			
			DetalleEvaluacionNomiLogicAdditional.checkDetalleEvaluacionNomiToSave(this.detalleevaluacionnomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleEvaluacionNomiLogicAdditional.updateDetalleEvaluacionNomiToSave(this.detalleevaluacionnomi,this.arrDatoGeneral);
			
			DetalleEvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleevaluacionnomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleEvaluacionNomi(this.detalleevaluacionnomi)) {			
				DetalleEvaluacionNomiDataAccess.save(this.detalleevaluacionnomi, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detalleevaluacionnomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleEvaluacionNomiLogicAdditional.checkDetalleEvaluacionNomiToSaveAfter(this.detalleevaluacionnomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detalleevaluacionnomi.getIsDeleted()) {
				this.detalleevaluacionnomi=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleEvaluacionNomisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionNomi.class.getSimpleName()+"-saveDetalleEvaluacionNomisWithConnection");connexion.begin();			
			
			DetalleEvaluacionNomiLogicAdditional.checkDetalleEvaluacionNomiToSaves(detalleevaluacionnomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleEvaluacionNomis();
			
			Boolean validadoTodosDetalleEvaluacionNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleEvaluacionNomi detalleevaluacionnomiLocal:detalleevaluacionnomis) {		
				if(detalleevaluacionnomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleEvaluacionNomiLogicAdditional.updateDetalleEvaluacionNomiToSave(detalleevaluacionnomiLocal,this.arrDatoGeneral);
	        	
				DetalleEvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleevaluacionnomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleEvaluacionNomi(detalleevaluacionnomiLocal)) {
					DetalleEvaluacionNomiDataAccess.save(detalleevaluacionnomiLocal, connexion);				
				} else {
					validadoTodosDetalleEvaluacionNomi=false;
				}
			}
			
			if(!validadoTodosDetalleEvaluacionNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleEvaluacionNomiLogicAdditional.checkDetalleEvaluacionNomiToSavesAfter(detalleevaluacionnomis,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleEvaluacionNomis();
			
			connexion.commit();		
			
			this.quitarDetalleEvaluacionNomisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleEvaluacionNomis()throws Exception {				
		 try {	
			DetalleEvaluacionNomiLogicAdditional.checkDetalleEvaluacionNomiToSaves(detalleevaluacionnomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleEvaluacionNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleEvaluacionNomi detalleevaluacionnomiLocal:detalleevaluacionnomis) {				
				if(detalleevaluacionnomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleEvaluacionNomiLogicAdditional.updateDetalleEvaluacionNomiToSave(detalleevaluacionnomiLocal,this.arrDatoGeneral);
	        	
				DetalleEvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleevaluacionnomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleEvaluacionNomi(detalleevaluacionnomiLocal)) {				
					DetalleEvaluacionNomiDataAccess.save(detalleevaluacionnomiLocal, connexion);				
				} else {
					validadoTodosDetalleEvaluacionNomi=false;
				}
			}
			
			if(!validadoTodosDetalleEvaluacionNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleEvaluacionNomiLogicAdditional.checkDetalleEvaluacionNomiToSavesAfter(detalleevaluacionnomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleEvaluacionNomisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleEvaluacionNomiParameterReturnGeneral procesarAccionDetalleEvaluacionNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleEvaluacionNomi> detalleevaluacionnomis,DetalleEvaluacionNomiParameterReturnGeneral detalleevaluacionnomiParameterGeneral)throws Exception {
		 try {	
			DetalleEvaluacionNomiParameterReturnGeneral detalleevaluacionnomiReturnGeneral=new DetalleEvaluacionNomiParameterReturnGeneral();
	
			DetalleEvaluacionNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleevaluacionnomis,detalleevaluacionnomiParameterGeneral,detalleevaluacionnomiReturnGeneral);
			
			return detalleevaluacionnomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleEvaluacionNomiParameterReturnGeneral procesarAccionDetalleEvaluacionNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleEvaluacionNomi> detalleevaluacionnomis,DetalleEvaluacionNomiParameterReturnGeneral detalleevaluacionnomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionNomi.class.getSimpleName()+"-procesarAccionDetalleEvaluacionNomisWithConnection");connexion.begin();			
			
			DetalleEvaluacionNomiParameterReturnGeneral detalleevaluacionnomiReturnGeneral=new DetalleEvaluacionNomiParameterReturnGeneral();
	
			DetalleEvaluacionNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleevaluacionnomis,detalleevaluacionnomiParameterGeneral,detalleevaluacionnomiReturnGeneral);
			
			this.connexion.commit();
			
			return detalleevaluacionnomiReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleEvaluacionNomiParameterReturnGeneral procesarEventosDetalleEvaluacionNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleEvaluacionNomi> detalleevaluacionnomis,DetalleEvaluacionNomi detalleevaluacionnomi,DetalleEvaluacionNomiParameterReturnGeneral detalleevaluacionnomiParameterGeneral,Boolean isEsNuevoDetalleEvaluacionNomi,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleEvaluacionNomiParameterReturnGeneral detalleevaluacionnomiReturnGeneral=new DetalleEvaluacionNomiParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleevaluacionnomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleEvaluacionNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleevaluacionnomis,detalleevaluacionnomi,detalleevaluacionnomiParameterGeneral,detalleevaluacionnomiReturnGeneral,isEsNuevoDetalleEvaluacionNomi,clases);
			
			return detalleevaluacionnomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleEvaluacionNomiParameterReturnGeneral procesarEventosDetalleEvaluacionNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleEvaluacionNomi> detalleevaluacionnomis,DetalleEvaluacionNomi detalleevaluacionnomi,DetalleEvaluacionNomiParameterReturnGeneral detalleevaluacionnomiParameterGeneral,Boolean isEsNuevoDetalleEvaluacionNomi,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionNomi.class.getSimpleName()+"-procesarEventosDetalleEvaluacionNomisWithConnection");connexion.begin();			
			
			DetalleEvaluacionNomiParameterReturnGeneral detalleevaluacionnomiReturnGeneral=new DetalleEvaluacionNomiParameterReturnGeneral();
	
			detalleevaluacionnomiReturnGeneral.setDetalleEvaluacionNomi(detalleevaluacionnomi);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleevaluacionnomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleEvaluacionNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleevaluacionnomis,detalleevaluacionnomi,detalleevaluacionnomiParameterGeneral,detalleevaluacionnomiReturnGeneral,isEsNuevoDetalleEvaluacionNomi,clases);
			
			this.connexion.commit();
			
			return detalleevaluacionnomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleEvaluacionNomiParameterReturnGeneral procesarImportacionDetalleEvaluacionNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleEvaluacionNomiParameterReturnGeneral detalleevaluacionnomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionNomi.class.getSimpleName()+"-procesarImportacionDetalleEvaluacionNomisWithConnection");connexion.begin();			
			
			DetalleEvaluacionNomiParameterReturnGeneral detalleevaluacionnomiReturnGeneral=new DetalleEvaluacionNomiParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detalleevaluacionnomis=new ArrayList<DetalleEvaluacionNomi>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detalleevaluacionnomi=new DetalleEvaluacionNomi();
				
				
				if(conColumnasBase) {this.detalleevaluacionnomi.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detalleevaluacionnomi.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

			this.detalleevaluacionnomi.setrespuesta(arrColumnas[iColumn++]);
				this.detalleevaluacionnomi.setrespuesta_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleevaluacionnomi.setcalifica1(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.detalleevaluacionnomi.setcalifica2(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.detalleevaluacionnomi.setcalifica3(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.detalleevaluacionnomi.setcalifica4(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.detalleevaluacionnomi.setcalifica5(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.detalleevaluacionnomi.setcalifica6(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.detalleevaluacionnomi.setcalifica7(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.detalleevaluacionnomi.setcalifica8(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.detalleevaluacionnomi.setcalifica9(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.detalleevaluacionnomi.setcalifica10(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.detalleevaluacionnomis.add(this.detalleevaluacionnomi);
			}
			
			this.saveDetalleEvaluacionNomis();
			
			this.connexion.commit();
			
			detalleevaluacionnomiReturnGeneral.setConRetornoEstaProcesado(true);
			detalleevaluacionnomiReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detalleevaluacionnomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleEvaluacionNomisEliminados() throws Exception {				
		
		List<DetalleEvaluacionNomi> detalleevaluacionnomisAux= new ArrayList<DetalleEvaluacionNomi>();
		
		for(DetalleEvaluacionNomi detalleevaluacionnomi:detalleevaluacionnomis) {
			if(!detalleevaluacionnomi.getIsDeleted()) {
				detalleevaluacionnomisAux.add(detalleevaluacionnomi);
			}
		}
		
		detalleevaluacionnomis=detalleevaluacionnomisAux;
	}
	
	public void quitarDetalleEvaluacionNomisNulos() throws Exception {				
		
		List<DetalleEvaluacionNomi> detalleevaluacionnomisAux= new ArrayList<DetalleEvaluacionNomi>();
		
		for(DetalleEvaluacionNomi detalleevaluacionnomi : this.detalleevaluacionnomis) {
			if(detalleevaluacionnomi==null) {
				detalleevaluacionnomisAux.add(detalleevaluacionnomi);
			}
		}
		
		//this.detalleevaluacionnomis=detalleevaluacionnomisAux;
		
		this.detalleevaluacionnomis.removeAll(detalleevaluacionnomisAux);
	}
	
	public void getSetVersionRowDetalleEvaluacionNomiWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detalleevaluacionnomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detalleevaluacionnomi.getIsDeleted() || (detalleevaluacionnomi.getIsChanged()&&!detalleevaluacionnomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detalleevaluacionnomiDataAccess.getSetVersionRowDetalleEvaluacionNomi(connexion,detalleevaluacionnomi.getId());
				
				if(!detalleevaluacionnomi.getVersionRow().equals(timestamp)) {	
					detalleevaluacionnomi.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detalleevaluacionnomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleEvaluacionNomi()throws Exception {	
		
		if(detalleevaluacionnomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detalleevaluacionnomi.getIsDeleted() || (detalleevaluacionnomi.getIsChanged()&&!detalleevaluacionnomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detalleevaluacionnomiDataAccess.getSetVersionRowDetalleEvaluacionNomi(connexion,detalleevaluacionnomi.getId());
			
			try {							
				if(!detalleevaluacionnomi.getVersionRow().equals(timestamp)) {	
					detalleevaluacionnomi.setVersionRow(timestamp);
				}
				
				detalleevaluacionnomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleEvaluacionNomisWithConnection()throws Exception {	
		if(detalleevaluacionnomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleEvaluacionNomi detalleevaluacionnomiAux:detalleevaluacionnomis) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detalleevaluacionnomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleevaluacionnomiAux.getIsDeleted() || (detalleevaluacionnomiAux.getIsChanged()&&!detalleevaluacionnomiAux.getIsNew())) {
						
						timestamp=detalleevaluacionnomiDataAccess.getSetVersionRowDetalleEvaluacionNomi(connexion,detalleevaluacionnomiAux.getId());
						
						if(!detalleevaluacionnomi.getVersionRow().equals(timestamp)) {	
							detalleevaluacionnomiAux.setVersionRow(timestamp);
						}
								
						detalleevaluacionnomiAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleEvaluacionNomis()throws Exception {	
		if(detalleevaluacionnomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleEvaluacionNomi detalleevaluacionnomiAux:detalleevaluacionnomis) {
					if(detalleevaluacionnomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleevaluacionnomiAux.getIsDeleted() || (detalleevaluacionnomiAux.getIsChanged()&&!detalleevaluacionnomiAux.getIsNew())) {
						
						timestamp=detalleevaluacionnomiDataAccess.getSetVersionRowDetalleEvaluacionNomi(connexion,detalleevaluacionnomiAux.getId());
						
						if(!detalleevaluacionnomiAux.getVersionRow().equals(timestamp)) {	
							detalleevaluacionnomiAux.setVersionRow(timestamp);
						}
						
													
						detalleevaluacionnomiAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleEvaluacionNomiParameterReturnGeneral cargarCombosLoteForeignKeyDetalleEvaluacionNomiWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEvaluacionNomi,String finalQueryGlobalFormatoNomi,String finalQueryGlobalPreguntaNomi) throws Exception {
		DetalleEvaluacionNomiParameterReturnGeneral  detalleevaluacionnomiReturnGeneral =new DetalleEvaluacionNomiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionNomi.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleEvaluacionNomiWithConnection");connexion.begin();
			
			detalleevaluacionnomiReturnGeneral =new DetalleEvaluacionNomiParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleevaluacionnomiReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<EvaluacionNomi> evaluacionnomisForeignKey=new ArrayList<EvaluacionNomi>();
			EvaluacionNomiLogic evaluacionnomiLogic=new EvaluacionNomiLogic();
			evaluacionnomiLogic.setConnexion(this.connexion);
			evaluacionnomiLogic.getEvaluacionNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEvaluacionNomi.equals("NONE")) {
				evaluacionnomiLogic.getTodosEvaluacionNomis(finalQueryGlobalEvaluacionNomi,new Pagination());
				evaluacionnomisForeignKey=evaluacionnomiLogic.getEvaluacionNomis();
			}

			detalleevaluacionnomiReturnGeneral.setevaluacionnomisForeignKey(evaluacionnomisForeignKey);


			List<FormatoNomi> formatonomisForeignKey=new ArrayList<FormatoNomi>();
			FormatoNomiLogic formatonomiLogic=new FormatoNomiLogic();
			formatonomiLogic.setConnexion(this.connexion);
			formatonomiLogic.getFormatoNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoNomi.equals("NONE")) {
				formatonomiLogic.getTodosFormatoNomis(finalQueryGlobalFormatoNomi,new Pagination());
				formatonomisForeignKey=formatonomiLogic.getFormatoNomis();
			}

			detalleevaluacionnomiReturnGeneral.setformatonomisForeignKey(formatonomisForeignKey);


			List<PreguntaNomi> preguntanomisForeignKey=new ArrayList<PreguntaNomi>();
			PreguntaNomiLogic preguntanomiLogic=new PreguntaNomiLogic();
			preguntanomiLogic.setConnexion(this.connexion);
			preguntanomiLogic.getPreguntaNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPreguntaNomi.equals("NONE")) {
				preguntanomiLogic.getTodosPreguntaNomis(finalQueryGlobalPreguntaNomi,new Pagination());
				preguntanomisForeignKey=preguntanomiLogic.getPreguntaNomis();
			}

			detalleevaluacionnomiReturnGeneral.setpreguntanomisForeignKey(preguntanomisForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detalleevaluacionnomiReturnGeneral;
	}
	
	public DetalleEvaluacionNomiParameterReturnGeneral cargarCombosLoteForeignKeyDetalleEvaluacionNomi(String finalQueryGlobalEmpresa,String finalQueryGlobalEvaluacionNomi,String finalQueryGlobalFormatoNomi,String finalQueryGlobalPreguntaNomi) throws Exception {
		DetalleEvaluacionNomiParameterReturnGeneral  detalleevaluacionnomiReturnGeneral =new DetalleEvaluacionNomiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detalleevaluacionnomiReturnGeneral =new DetalleEvaluacionNomiParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleevaluacionnomiReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<EvaluacionNomi> evaluacionnomisForeignKey=new ArrayList<EvaluacionNomi>();
			EvaluacionNomiLogic evaluacionnomiLogic=new EvaluacionNomiLogic();
			evaluacionnomiLogic.setConnexion(this.connexion);
			evaluacionnomiLogic.getEvaluacionNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEvaluacionNomi.equals("NONE")) {
				evaluacionnomiLogic.getTodosEvaluacionNomis(finalQueryGlobalEvaluacionNomi,new Pagination());
				evaluacionnomisForeignKey=evaluacionnomiLogic.getEvaluacionNomis();
			}

			detalleevaluacionnomiReturnGeneral.setevaluacionnomisForeignKey(evaluacionnomisForeignKey);


			List<FormatoNomi> formatonomisForeignKey=new ArrayList<FormatoNomi>();
			FormatoNomiLogic formatonomiLogic=new FormatoNomiLogic();
			formatonomiLogic.setConnexion(this.connexion);
			formatonomiLogic.getFormatoNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoNomi.equals("NONE")) {
				formatonomiLogic.getTodosFormatoNomis(finalQueryGlobalFormatoNomi,new Pagination());
				formatonomisForeignKey=formatonomiLogic.getFormatoNomis();
			}

			detalleevaluacionnomiReturnGeneral.setformatonomisForeignKey(formatonomisForeignKey);


			List<PreguntaNomi> preguntanomisForeignKey=new ArrayList<PreguntaNomi>();
			PreguntaNomiLogic preguntanomiLogic=new PreguntaNomiLogic();
			preguntanomiLogic.setConnexion(this.connexion);
			preguntanomiLogic.getPreguntaNomiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPreguntaNomi.equals("NONE")) {
				preguntanomiLogic.getTodosPreguntaNomis(finalQueryGlobalPreguntaNomi,new Pagination());
				preguntanomisForeignKey=preguntanomiLogic.getPreguntaNomis();
			}

			detalleevaluacionnomiReturnGeneral.setpreguntanomisForeignKey(preguntanomisForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detalleevaluacionnomiReturnGeneral;
	}
	
	
	public void deepLoad(DetalleEvaluacionNomi detalleevaluacionnomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleEvaluacionNomiLogicAdditional.updateDetalleEvaluacionNomiToGet(detalleevaluacionnomi,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleevaluacionnomi.setEmpresa(detalleevaluacionnomiDataAccess.getEmpresa(connexion,detalleevaluacionnomi));
		detalleevaluacionnomi.setEvaluacionNomi(detalleevaluacionnomiDataAccess.getEvaluacionNomi(connexion,detalleevaluacionnomi));
		detalleevaluacionnomi.setFormatoNomi(detalleevaluacionnomiDataAccess.getFormatoNomi(connexion,detalleevaluacionnomi));
		detalleevaluacionnomi.setPreguntaNomi(detalleevaluacionnomiDataAccess.getPreguntaNomi(connexion,detalleevaluacionnomi));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalleevaluacionnomi.setEmpresa(detalleevaluacionnomiDataAccess.getEmpresa(connexion,detalleevaluacionnomi));
				continue;
			}

			if(clas.clas.equals(EvaluacionNomi.class)) {
				detalleevaluacionnomi.setEvaluacionNomi(detalleevaluacionnomiDataAccess.getEvaluacionNomi(connexion,detalleevaluacionnomi));
				continue;
			}

			if(clas.clas.equals(FormatoNomi.class)) {
				detalleevaluacionnomi.setFormatoNomi(detalleevaluacionnomiDataAccess.getFormatoNomi(connexion,detalleevaluacionnomi));
				continue;
			}

			if(clas.clas.equals(PreguntaNomi.class)) {
				detalleevaluacionnomi.setPreguntaNomi(detalleevaluacionnomiDataAccess.getPreguntaNomi(connexion,detalleevaluacionnomi));
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
			detalleevaluacionnomi.setEmpresa(detalleevaluacionnomiDataAccess.getEmpresa(connexion,detalleevaluacionnomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EvaluacionNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleevaluacionnomi.setEvaluacionNomi(detalleevaluacionnomiDataAccess.getEvaluacionNomi(connexion,detalleevaluacionnomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleevaluacionnomi.setFormatoNomi(detalleevaluacionnomiDataAccess.getFormatoNomi(connexion,detalleevaluacionnomi));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PreguntaNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleevaluacionnomi.setPreguntaNomi(detalleevaluacionnomiDataAccess.getPreguntaNomi(connexion,detalleevaluacionnomi));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleevaluacionnomi.setEmpresa(detalleevaluacionnomiDataAccess.getEmpresa(connexion,detalleevaluacionnomi));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleevaluacionnomi.getEmpresa(),isDeep,deepLoadType,clases);
				
		detalleevaluacionnomi.setEvaluacionNomi(detalleevaluacionnomiDataAccess.getEvaluacionNomi(connexion,detalleevaluacionnomi));
		EvaluacionNomiLogic evaluacionnomiLogic= new EvaluacionNomiLogic(connexion);
		evaluacionnomiLogic.deepLoad(detalleevaluacionnomi.getEvaluacionNomi(),isDeep,deepLoadType,clases);
				
		detalleevaluacionnomi.setFormatoNomi(detalleevaluacionnomiDataAccess.getFormatoNomi(connexion,detalleevaluacionnomi));
		FormatoNomiLogic formatonomiLogic= new FormatoNomiLogic(connexion);
		formatonomiLogic.deepLoad(detalleevaluacionnomi.getFormatoNomi(),isDeep,deepLoadType,clases);
				
		detalleevaluacionnomi.setPreguntaNomi(detalleevaluacionnomiDataAccess.getPreguntaNomi(connexion,detalleevaluacionnomi));
		PreguntaNomiLogic preguntanomiLogic= new PreguntaNomiLogic(connexion);
		preguntanomiLogic.deepLoad(detalleevaluacionnomi.getPreguntaNomi(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalleevaluacionnomi.setEmpresa(detalleevaluacionnomiDataAccess.getEmpresa(connexion,detalleevaluacionnomi));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detalleevaluacionnomi.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EvaluacionNomi.class)) {
				detalleevaluacionnomi.setEvaluacionNomi(detalleevaluacionnomiDataAccess.getEvaluacionNomi(connexion,detalleevaluacionnomi));
				EvaluacionNomiLogic evaluacionnomiLogic= new EvaluacionNomiLogic(connexion);
				evaluacionnomiLogic.deepLoad(detalleevaluacionnomi.getEvaluacionNomi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FormatoNomi.class)) {
				detalleevaluacionnomi.setFormatoNomi(detalleevaluacionnomiDataAccess.getFormatoNomi(connexion,detalleevaluacionnomi));
				FormatoNomiLogic formatonomiLogic= new FormatoNomiLogic(connexion);
				formatonomiLogic.deepLoad(detalleevaluacionnomi.getFormatoNomi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PreguntaNomi.class)) {
				detalleevaluacionnomi.setPreguntaNomi(detalleevaluacionnomiDataAccess.getPreguntaNomi(connexion,detalleevaluacionnomi));
				PreguntaNomiLogic preguntanomiLogic= new PreguntaNomiLogic(connexion);
				preguntanomiLogic.deepLoad(detalleevaluacionnomi.getPreguntaNomi(),isDeep,deepLoadType,clases);				
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
			detalleevaluacionnomi.setEmpresa(detalleevaluacionnomiDataAccess.getEmpresa(connexion,detalleevaluacionnomi));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detalleevaluacionnomi.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EvaluacionNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleevaluacionnomi.setEvaluacionNomi(detalleevaluacionnomiDataAccess.getEvaluacionNomi(connexion,detalleevaluacionnomi));
			EvaluacionNomiLogic evaluacionnomiLogic= new EvaluacionNomiLogic(connexion);
			evaluacionnomiLogic.deepLoad(detalleevaluacionnomi.getEvaluacionNomi(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(FormatoNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleevaluacionnomi.setFormatoNomi(detalleevaluacionnomiDataAccess.getFormatoNomi(connexion,detalleevaluacionnomi));
			FormatoNomiLogic formatonomiLogic= new FormatoNomiLogic(connexion);
			formatonomiLogic.deepLoad(detalleevaluacionnomi.getFormatoNomi(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PreguntaNomi.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleevaluacionnomi.setPreguntaNomi(detalleevaluacionnomiDataAccess.getPreguntaNomi(connexion,detalleevaluacionnomi));
			PreguntaNomiLogic preguntanomiLogic= new PreguntaNomiLogic(connexion);
			preguntanomiLogic.deepLoad(detalleevaluacionnomi.getPreguntaNomi(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleEvaluacionNomi detalleevaluacionnomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleEvaluacionNomiLogicAdditional.updateDetalleEvaluacionNomiToSave(detalleevaluacionnomi,this.arrDatoGeneral);
			
DetalleEvaluacionNomiDataAccess.save(detalleevaluacionnomi, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalleevaluacionnomi.getEmpresa(),connexion);

		EvaluacionNomiDataAccess.save(detalleevaluacionnomi.getEvaluacionNomi(),connexion);

		FormatoNomiDataAccess.save(detalleevaluacionnomi.getFormatoNomi(),connexion);

		PreguntaNomiDataAccess.save(detalleevaluacionnomi.getPreguntaNomi(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleevaluacionnomi.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(EvaluacionNomi.class)) {
				EvaluacionNomiDataAccess.save(detalleevaluacionnomi.getEvaluacionNomi(),connexion);
				continue;
			}

			if(clas.clas.equals(FormatoNomi.class)) {
				FormatoNomiDataAccess.save(detalleevaluacionnomi.getFormatoNomi(),connexion);
				continue;
			}

			if(clas.clas.equals(PreguntaNomi.class)) {
				PreguntaNomiDataAccess.save(detalleevaluacionnomi.getPreguntaNomi(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalleevaluacionnomi.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleevaluacionnomi.getEmpresa(),isDeep,deepLoadType,clases);
				

		EvaluacionNomiDataAccess.save(detalleevaluacionnomi.getEvaluacionNomi(),connexion);
		EvaluacionNomiLogic evaluacionnomiLogic= new EvaluacionNomiLogic(connexion);
		evaluacionnomiLogic.deepLoad(detalleevaluacionnomi.getEvaluacionNomi(),isDeep,deepLoadType,clases);
				

		FormatoNomiDataAccess.save(detalleevaluacionnomi.getFormatoNomi(),connexion);
		FormatoNomiLogic formatonomiLogic= new FormatoNomiLogic(connexion);
		formatonomiLogic.deepLoad(detalleevaluacionnomi.getFormatoNomi(),isDeep,deepLoadType,clases);
				

		PreguntaNomiDataAccess.save(detalleevaluacionnomi.getPreguntaNomi(),connexion);
		PreguntaNomiLogic preguntanomiLogic= new PreguntaNomiLogic(connexion);
		preguntanomiLogic.deepLoad(detalleevaluacionnomi.getPreguntaNomi(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleevaluacionnomi.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detalleevaluacionnomi.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EvaluacionNomi.class)) {
				EvaluacionNomiDataAccess.save(detalleevaluacionnomi.getEvaluacionNomi(),connexion);
				EvaluacionNomiLogic evaluacionnomiLogic= new EvaluacionNomiLogic(connexion);
				evaluacionnomiLogic.deepSave(detalleevaluacionnomi.getEvaluacionNomi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FormatoNomi.class)) {
				FormatoNomiDataAccess.save(detalleevaluacionnomi.getFormatoNomi(),connexion);
				FormatoNomiLogic formatonomiLogic= new FormatoNomiLogic(connexion);
				formatonomiLogic.deepSave(detalleevaluacionnomi.getFormatoNomi(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PreguntaNomi.class)) {
				PreguntaNomiDataAccess.save(detalleevaluacionnomi.getPreguntaNomi(),connexion);
				PreguntaNomiLogic preguntanomiLogic= new PreguntaNomiLogic(connexion);
				preguntanomiLogic.deepSave(detalleevaluacionnomi.getPreguntaNomi(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleEvaluacionNomi.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detalleevaluacionnomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(detalleevaluacionnomi);
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
			this.deepLoad(this.detalleevaluacionnomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(this.detalleevaluacionnomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleEvaluacionNomi.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detalleevaluacionnomis!=null) {
				for(DetalleEvaluacionNomi detalleevaluacionnomi:detalleevaluacionnomis) {
					this.deepLoad(detalleevaluacionnomi,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(detalleevaluacionnomis);
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
			if(detalleevaluacionnomis!=null) {
				for(DetalleEvaluacionNomi detalleevaluacionnomi:detalleevaluacionnomis) {
					this.deepLoad(detalleevaluacionnomi,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(detalleevaluacionnomis);
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
			this.getNewConnexionToDeep(DetalleEvaluacionNomi.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detalleevaluacionnomi,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleEvaluacionNomi.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detalleevaluacionnomis!=null) {
				for(DetalleEvaluacionNomi detalleevaluacionnomi:detalleevaluacionnomis) {
					this.deepSave(detalleevaluacionnomi,isDeep,deepLoadType,clases);
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
			if(detalleevaluacionnomis!=null) {
				for(DetalleEvaluacionNomi detalleevaluacionnomi:detalleevaluacionnomis) {
					this.deepSave(detalleevaluacionnomi,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleEvaluacionNomisFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleEvaluacionNomiConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleEvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleevaluacionnomis=detalleevaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(this.detalleevaluacionnomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleEvaluacionNomisFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleEvaluacionNomiConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleEvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleevaluacionnomis=detalleevaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(this.detalleevaluacionnomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleEvaluacionNomisFK_IdEvaluacionNomiWithConnection(String sFinalQuery,Pagination pagination,Long id_evaluacion_nomi)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEvaluacionNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEvaluacionNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_evaluacion_nomi,DetalleEvaluacionNomiConstantesFunciones.IDEVALUACIONNOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEvaluacionNomi);

			DetalleEvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEvaluacionNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleevaluacionnomis=detalleevaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(this.detalleevaluacionnomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleEvaluacionNomisFK_IdEvaluacionNomi(String sFinalQuery,Pagination pagination,Long id_evaluacion_nomi)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEvaluacionNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEvaluacionNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_evaluacion_nomi,DetalleEvaluacionNomiConstantesFunciones.IDEVALUACIONNOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEvaluacionNomi);

			DetalleEvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEvaluacionNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleevaluacionnomis=detalleevaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(this.detalleevaluacionnomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleEvaluacionNomisFK_IdFormatoNomiWithConnection(String sFinalQuery,Pagination pagination,Long id_formato_nomi)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_nomi,DetalleEvaluacionNomiConstantesFunciones.IDFORMATONOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoNomi);

			DetalleEvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleevaluacionnomis=detalleevaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(this.detalleevaluacionnomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleEvaluacionNomisFK_IdFormatoNomi(String sFinalQuery,Pagination pagination,Long id_formato_nomi)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_nomi,DetalleEvaluacionNomiConstantesFunciones.IDFORMATONOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoNomi);

			DetalleEvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleevaluacionnomis=detalleevaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(this.detalleevaluacionnomis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleEvaluacionNomisFK_IdPreguntaNomiWithConnection(String sFinalQuery,Pagination pagination,Long id_pregunta_nomi)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleEvaluacionNomi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPreguntaNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPreguntaNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pregunta_nomi,DetalleEvaluacionNomiConstantesFunciones.IDPREGUNTANOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPreguntaNomi);

			DetalleEvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPreguntaNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleevaluacionnomis=detalleevaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(this.detalleevaluacionnomis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleEvaluacionNomisFK_IdPreguntaNomi(String sFinalQuery,Pagination pagination,Long id_pregunta_nomi)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPreguntaNomi= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPreguntaNomi.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pregunta_nomi,DetalleEvaluacionNomiConstantesFunciones.IDPREGUNTANOMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPreguntaNomi);

			DetalleEvaluacionNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPreguntaNomi","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleevaluacionnomis=detalleevaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleEvaluacionNomiConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionNomi(this.detalleevaluacionnomis);
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
			if(DetalleEvaluacionNomiConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleEvaluacionNomiDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleEvaluacionNomi detalleevaluacionnomi,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleEvaluacionNomiConstantesFunciones.ISCONAUDITORIA) {
				if(detalleevaluacionnomi.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleEvaluacionNomiDataAccess.TABLENAME, detalleevaluacionnomi.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleEvaluacionNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleEvaluacionNomiLogic.registrarAuditoriaDetallesDetalleEvaluacionNomi(connexion,detalleevaluacionnomi,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detalleevaluacionnomi.getIsDeleted()) {
					/*if(!detalleevaluacionnomi.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleEvaluacionNomiDataAccess.TABLENAME, detalleevaluacionnomi.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleEvaluacionNomiLogic.registrarAuditoriaDetallesDetalleEvaluacionNomi(connexion,detalleevaluacionnomi,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleEvaluacionNomiDataAccess.TABLENAME, detalleevaluacionnomi.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detalleevaluacionnomi.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleEvaluacionNomiDataAccess.TABLENAME, detalleevaluacionnomi.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleEvaluacionNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleEvaluacionNomiLogic.registrarAuditoriaDetallesDetalleEvaluacionNomi(connexion,detalleevaluacionnomi,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleEvaluacionNomi(Connexion connexion,DetalleEvaluacionNomi detalleevaluacionnomi)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detalleevaluacionnomi.getIsNew()||!detalleevaluacionnomi.getid_empresa().equals(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getid_empresa()!=null)
				{
					strValorActual=detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getid_empresa().toString();
				}
				if(detalleevaluacionnomi.getid_empresa()!=null)
				{
					strValorNuevo=detalleevaluacionnomi.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleEvaluacionNomiConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detalleevaluacionnomi.getIsNew()||!detalleevaluacionnomi.getid_evaluacion_nomi().equals(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getid_evaluacion_nomi()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getid_evaluacion_nomi()!=null)
				{
					strValorActual=detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getid_evaluacion_nomi().toString();
				}
				if(detalleevaluacionnomi.getid_evaluacion_nomi()!=null)
				{
					strValorNuevo=detalleevaluacionnomi.getid_evaluacion_nomi().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleEvaluacionNomiConstantesFunciones.IDEVALUACIONNOMI,strValorActual,strValorNuevo);
			}	
			
			if(detalleevaluacionnomi.getIsNew()||!detalleevaluacionnomi.getid_formato_nomi().equals(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getid_formato_nomi()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getid_formato_nomi()!=null)
				{
					strValorActual=detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getid_formato_nomi().toString();
				}
				if(detalleevaluacionnomi.getid_formato_nomi()!=null)
				{
					strValorNuevo=detalleevaluacionnomi.getid_formato_nomi().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleEvaluacionNomiConstantesFunciones.IDFORMATONOMI,strValorActual,strValorNuevo);
			}	
			
			if(detalleevaluacionnomi.getIsNew()||!detalleevaluacionnomi.getid_pregunta_nomi().equals(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getid_pregunta_nomi()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getid_pregunta_nomi()!=null)
				{
					strValorActual=detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getid_pregunta_nomi().toString();
				}
				if(detalleevaluacionnomi.getid_pregunta_nomi()!=null)
				{
					strValorNuevo=detalleevaluacionnomi.getid_pregunta_nomi().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleEvaluacionNomiConstantesFunciones.IDPREGUNTANOMI,strValorActual,strValorNuevo);
			}	
			
			if(detalleevaluacionnomi.getIsNew()||!detalleevaluacionnomi.getrespuesta().equals(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getrespuesta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getrespuesta()!=null)
				{
					strValorActual=detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getrespuesta();
				}
				if(detalleevaluacionnomi.getrespuesta()!=null)
				{
					strValorNuevo=detalleevaluacionnomi.getrespuesta() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleEvaluacionNomiConstantesFunciones.RESPUESTA,strValorActual,strValorNuevo);
			}	
			
			if(detalleevaluacionnomi.getIsNew()||!detalleevaluacionnomi.getrespuesta_valor().equals(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getrespuesta_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getrespuesta_valor()!=null)
				{
					strValorActual=detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getrespuesta_valor().toString();
				}
				if(detalleevaluacionnomi.getrespuesta_valor()!=null)
				{
					strValorNuevo=detalleevaluacionnomi.getrespuesta_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleEvaluacionNomiConstantesFunciones.RESPUESTAVALOR,strValorActual,strValorNuevo);
			}	
			
			if(detalleevaluacionnomi.getIsNew()||!detalleevaluacionnomi.getcalifica1().equals(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getcalifica1()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getcalifica1()!=null)
				{
					strValorActual=detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getcalifica1().toString();
				}
				if(detalleevaluacionnomi.getcalifica1()!=null)
				{
					strValorNuevo=detalleevaluacionnomi.getcalifica1().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleEvaluacionNomiConstantesFunciones.CALIFICA1,strValorActual,strValorNuevo);
			}	
			
			if(detalleevaluacionnomi.getIsNew()||!detalleevaluacionnomi.getcalifica2().equals(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getcalifica2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getcalifica2()!=null)
				{
					strValorActual=detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getcalifica2().toString();
				}
				if(detalleevaluacionnomi.getcalifica2()!=null)
				{
					strValorNuevo=detalleevaluacionnomi.getcalifica2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleEvaluacionNomiConstantesFunciones.CALIFICA2,strValorActual,strValorNuevo);
			}	
			
			if(detalleevaluacionnomi.getIsNew()||!detalleevaluacionnomi.getcalifica3().equals(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getcalifica3()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getcalifica3()!=null)
				{
					strValorActual=detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getcalifica3().toString();
				}
				if(detalleevaluacionnomi.getcalifica3()!=null)
				{
					strValorNuevo=detalleevaluacionnomi.getcalifica3().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleEvaluacionNomiConstantesFunciones.CALIFICA3,strValorActual,strValorNuevo);
			}	
			
			if(detalleevaluacionnomi.getIsNew()||!detalleevaluacionnomi.getcalifica4().equals(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getcalifica4()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getcalifica4()!=null)
				{
					strValorActual=detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getcalifica4().toString();
				}
				if(detalleevaluacionnomi.getcalifica4()!=null)
				{
					strValorNuevo=detalleevaluacionnomi.getcalifica4().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleEvaluacionNomiConstantesFunciones.CALIFICA4,strValorActual,strValorNuevo);
			}	
			
			if(detalleevaluacionnomi.getIsNew()||!detalleevaluacionnomi.getcalifica5().equals(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getcalifica5()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getcalifica5()!=null)
				{
					strValorActual=detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getcalifica5().toString();
				}
				if(detalleevaluacionnomi.getcalifica5()!=null)
				{
					strValorNuevo=detalleevaluacionnomi.getcalifica5().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleEvaluacionNomiConstantesFunciones.CALIFICA5,strValorActual,strValorNuevo);
			}	
			
			if(detalleevaluacionnomi.getIsNew()||!detalleevaluacionnomi.getcalifica6().equals(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getcalifica6()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getcalifica6()!=null)
				{
					strValorActual=detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getcalifica6().toString();
				}
				if(detalleevaluacionnomi.getcalifica6()!=null)
				{
					strValorNuevo=detalleevaluacionnomi.getcalifica6().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleEvaluacionNomiConstantesFunciones.CALIFICA6,strValorActual,strValorNuevo);
			}	
			
			if(detalleevaluacionnomi.getIsNew()||!detalleevaluacionnomi.getcalifica7().equals(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getcalifica7()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getcalifica7()!=null)
				{
					strValorActual=detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getcalifica7().toString();
				}
				if(detalleevaluacionnomi.getcalifica7()!=null)
				{
					strValorNuevo=detalleevaluacionnomi.getcalifica7().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleEvaluacionNomiConstantesFunciones.CALIFICA7,strValorActual,strValorNuevo);
			}	
			
			if(detalleevaluacionnomi.getIsNew()||!detalleevaluacionnomi.getcalifica8().equals(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getcalifica8()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getcalifica8()!=null)
				{
					strValorActual=detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getcalifica8().toString();
				}
				if(detalleevaluacionnomi.getcalifica8()!=null)
				{
					strValorNuevo=detalleevaluacionnomi.getcalifica8().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleEvaluacionNomiConstantesFunciones.CALIFICA8,strValorActual,strValorNuevo);
			}	
			
			if(detalleevaluacionnomi.getIsNew()||!detalleevaluacionnomi.getcalifica9().equals(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getcalifica9()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getcalifica9()!=null)
				{
					strValorActual=detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getcalifica9().toString();
				}
				if(detalleevaluacionnomi.getcalifica9()!=null)
				{
					strValorNuevo=detalleevaluacionnomi.getcalifica9().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleEvaluacionNomiConstantesFunciones.CALIFICA9,strValorActual,strValorNuevo);
			}	
			
			if(detalleevaluacionnomi.getIsNew()||!detalleevaluacionnomi.getcalifica10().equals(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getcalifica10()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getcalifica10()!=null)
				{
					strValorActual=detalleevaluacionnomi.getDetalleEvaluacionNomiOriginal().getcalifica10().toString();
				}
				if(detalleevaluacionnomi.getcalifica10()!=null)
				{
					strValorNuevo=detalleevaluacionnomi.getcalifica10().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleEvaluacionNomiConstantesFunciones.CALIFICA10,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleEvaluacionNomiRelacionesWithConnection(DetalleEvaluacionNomi detalleevaluacionnomi) throws Exception {

		if(!detalleevaluacionnomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleEvaluacionNomiRelacionesBase(detalleevaluacionnomi,true);
		}
	}

	public void saveDetalleEvaluacionNomiRelaciones(DetalleEvaluacionNomi detalleevaluacionnomi)throws Exception {

		if(!detalleevaluacionnomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleEvaluacionNomiRelacionesBase(detalleevaluacionnomi,false);
		}
	}

	public void saveDetalleEvaluacionNomiRelacionesBase(DetalleEvaluacionNomi detalleevaluacionnomi,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleEvaluacionNomi-saveRelacionesWithConnection");}
	

			this.setDetalleEvaluacionNomi(detalleevaluacionnomi);

			if(DetalleEvaluacionNomiLogicAdditional.validarSaveRelaciones(detalleevaluacionnomi,this)) {

				DetalleEvaluacionNomiLogicAdditional.updateRelacionesToSave(detalleevaluacionnomi,this);

				if((detalleevaluacionnomi.getIsNew()||detalleevaluacionnomi.getIsChanged())&&!detalleevaluacionnomi.getIsDeleted()) {
					this.saveDetalleEvaluacionNomi();
					this.saveDetalleEvaluacionNomiRelacionesDetalles();

				} else if(detalleevaluacionnomi.getIsDeleted()) {
					this.saveDetalleEvaluacionNomiRelacionesDetalles();
					this.saveDetalleEvaluacionNomi();
				}

				DetalleEvaluacionNomiLogicAdditional.updateRelacionesToSaveAfter(detalleevaluacionnomi,this);

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
	
	
	private void saveDetalleEvaluacionNomiRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleEvaluacionNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleEvaluacionNomiConstantesFunciones.getClassesForeignKeysOfDetalleEvaluacionNomi(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleEvaluacionNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleEvaluacionNomiConstantesFunciones.getClassesRelationshipsOfDetalleEvaluacionNomi(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
