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
import com.bydan.erp.nomina.util.NumeroPatronalConstantesFunciones;
import com.bydan.erp.nomina.util.NumeroPatronalParameterReturnGeneral;
//import com.bydan.erp.nomina.util.NumeroPatronalParameterGeneral;
import com.bydan.erp.nomina.business.entity.NumeroPatronal;
import com.bydan.erp.nomina.business.logic.NumeroPatronalLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.activosfijos.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;








@SuppressWarnings("unused")
public class NumeroPatronalLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(NumeroPatronalLogic.class);
	
	protected NumeroPatronalDataAccess numeropatronalDataAccess; 	
	protected NumeroPatronal numeropatronal;
	protected List<NumeroPatronal> numeropatronals;
	protected Object numeropatronalObject;	
	protected List<Object> numeropatronalsObject;
	
	public static ClassValidator<NumeroPatronal> numeropatronalValidator = new ClassValidator<NumeroPatronal>(NumeroPatronal.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected NumeroPatronalLogicAdditional numeropatronalLogicAdditional=null;
	
	public NumeroPatronalLogicAdditional getNumeroPatronalLogicAdditional() {
		return this.numeropatronalLogicAdditional;
	}
	
	public void setNumeroPatronalLogicAdditional(NumeroPatronalLogicAdditional numeropatronalLogicAdditional) {
		try {
			this.numeropatronalLogicAdditional=numeropatronalLogicAdditional;
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
	
	
	
	
	public  NumeroPatronalLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.numeropatronalDataAccess = new NumeroPatronalDataAccess();
			
			this.numeropatronals= new ArrayList<NumeroPatronal>();
			this.numeropatronal= new NumeroPatronal();
			
			this.numeropatronalObject=new Object();
			this.numeropatronalsObject=new ArrayList<Object>();
				
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
			
			this.numeropatronalDataAccess.setConnexionType(this.connexionType);
			this.numeropatronalDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  NumeroPatronalLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.numeropatronalDataAccess = new NumeroPatronalDataAccess();
			this.numeropatronals= new ArrayList<NumeroPatronal>();
			this.numeropatronal= new NumeroPatronal();
			this.numeropatronalObject=new Object();
			this.numeropatronalsObject=new ArrayList<Object>();
			
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
			
			this.numeropatronalDataAccess.setConnexionType(this.connexionType);
			this.numeropatronalDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public NumeroPatronal getNumeroPatronal() throws Exception {	
		NumeroPatronalLogicAdditional.checkNumeroPatronalToGet(numeropatronal,this.datosCliente,this.arrDatoGeneral);
		NumeroPatronalLogicAdditional.updateNumeroPatronalToGet(numeropatronal,this.arrDatoGeneral);
		
		return numeropatronal;
	}
		
	public void setNumeroPatronal(NumeroPatronal newNumeroPatronal) {
		this.numeropatronal = newNumeroPatronal;
	}
	
	public NumeroPatronalDataAccess getNumeroPatronalDataAccess() {
		return numeropatronalDataAccess;
	}
	
	public void setNumeroPatronalDataAccess(NumeroPatronalDataAccess newnumeropatronalDataAccess) {
		this.numeropatronalDataAccess = newnumeropatronalDataAccess;
	}
	
	public List<NumeroPatronal> getNumeroPatronals() throws Exception {		
		this.quitarNumeroPatronalsNulos();
		
		NumeroPatronalLogicAdditional.checkNumeroPatronalToGets(numeropatronals,this.datosCliente,this.arrDatoGeneral);
		
		for (NumeroPatronal numeropatronalLocal: numeropatronals ) {
			NumeroPatronalLogicAdditional.updateNumeroPatronalToGet(numeropatronalLocal,this.arrDatoGeneral);
		}
		
		return numeropatronals;
	}
	
	public void setNumeroPatronals(List<NumeroPatronal> newNumeroPatronals) {
		this.numeropatronals = newNumeroPatronals;
	}
	
	public Object getNumeroPatronalObject() {	
		this.numeropatronalObject=this.numeropatronalDataAccess.getEntityObject();
		return this.numeropatronalObject;
	}
		
	public void setNumeroPatronalObject(Object newNumeroPatronalObject) {
		this.numeropatronalObject = newNumeroPatronalObject;
	}
	
	public List<Object> getNumeroPatronalsObject() {		
		this.numeropatronalsObject=this.numeropatronalDataAccess.getEntitiesObject();
		return this.numeropatronalsObject;
	}
		
	public void setNumeroPatronalsObject(List<Object> newNumeroPatronalsObject) {
		this.numeropatronalsObject = newNumeroPatronalsObject;
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
		
		if(this.numeropatronalDataAccess!=null) {
			this.numeropatronalDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroPatronal.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			numeropatronalDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			numeropatronalDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		numeropatronal = new  NumeroPatronal();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroPatronal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			numeropatronal=numeropatronalDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.numeropatronal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NumeroPatronalConstantesFunciones.refrescarForeignKeysDescripcionesNumeroPatronal(this.numeropatronal);
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
		numeropatronal = new  NumeroPatronal();
		  		  
        try {
			
			numeropatronal=numeropatronalDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.numeropatronal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NumeroPatronalConstantesFunciones.refrescarForeignKeysDescripcionesNumeroPatronal(this.numeropatronal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		numeropatronal = new  NumeroPatronal();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroPatronal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			numeropatronal=numeropatronalDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.numeropatronal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NumeroPatronalConstantesFunciones.refrescarForeignKeysDescripcionesNumeroPatronal(this.numeropatronal);
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
		numeropatronal = new  NumeroPatronal();
		  		  
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
		numeropatronal = new  NumeroPatronal();
		  		  
        try {
			
			numeropatronal=numeropatronalDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.numeropatronal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NumeroPatronalConstantesFunciones.refrescarForeignKeysDescripcionesNumeroPatronal(this.numeropatronal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		numeropatronal = new  NumeroPatronal();
		  		  
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
		numeropatronal = new  NumeroPatronal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroPatronal.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =numeropatronalDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		numeropatronal = new  NumeroPatronal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=numeropatronalDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		numeropatronal = new  NumeroPatronal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroPatronal.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =numeropatronalDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		numeropatronal = new  NumeroPatronal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=numeropatronalDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		numeropatronal = new  NumeroPatronal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroPatronal.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =numeropatronalDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		numeropatronal = new  NumeroPatronal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=numeropatronalDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		numeropatronals = new  ArrayList<NumeroPatronal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroPatronal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			NumeroPatronalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			numeropatronals=numeropatronalDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNumeroPatronal(numeropatronals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NumeroPatronalConstantesFunciones.refrescarForeignKeysDescripcionesNumeroPatronal(this.numeropatronals);
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
		numeropatronals = new  ArrayList<NumeroPatronal>();
		  		  
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
		numeropatronals = new  ArrayList<NumeroPatronal>();
		  		  
        try {			
			NumeroPatronalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			numeropatronals=numeropatronalDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarNumeroPatronal(numeropatronals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NumeroPatronalConstantesFunciones.refrescarForeignKeysDescripcionesNumeroPatronal(this.numeropatronals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		numeropatronals = new  ArrayList<NumeroPatronal>();
		  		  
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
		numeropatronals = new  ArrayList<NumeroPatronal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroPatronal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			NumeroPatronalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			numeropatronals=numeropatronalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNumeroPatronal(numeropatronals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NumeroPatronalConstantesFunciones.refrescarForeignKeysDescripcionesNumeroPatronal(this.numeropatronals);
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
		numeropatronals = new  ArrayList<NumeroPatronal>();
		  		  
        try {
			NumeroPatronalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			numeropatronals=numeropatronalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNumeroPatronal(numeropatronals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NumeroPatronalConstantesFunciones.refrescarForeignKeysDescripcionesNumeroPatronal(this.numeropatronals);
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
		numeropatronals = new  ArrayList<NumeroPatronal>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroPatronal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NumeroPatronalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			numeropatronals=numeropatronalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNumeroPatronal(numeropatronals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NumeroPatronalConstantesFunciones.refrescarForeignKeysDescripcionesNumeroPatronal(this.numeropatronals);
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
		numeropatronals = new  ArrayList<NumeroPatronal>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NumeroPatronalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			numeropatronals=numeropatronalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNumeroPatronal(numeropatronals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NumeroPatronalConstantesFunciones.refrescarForeignKeysDescripcionesNumeroPatronal(this.numeropatronals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		numeropatronal = new  NumeroPatronal();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroPatronal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NumeroPatronalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			numeropatronal=numeropatronalDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNumeroPatronal(numeropatronal);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NumeroPatronalConstantesFunciones.refrescarForeignKeysDescripcionesNumeroPatronal(this.numeropatronal);
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
		numeropatronal = new  NumeroPatronal();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NumeroPatronalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			numeropatronal=numeropatronalDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNumeroPatronal(numeropatronal);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NumeroPatronalConstantesFunciones.refrescarForeignKeysDescripcionesNumeroPatronal(this.numeropatronal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		numeropatronals = new  ArrayList<NumeroPatronal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroPatronal.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			NumeroPatronalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			numeropatronals=numeropatronalDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNumeroPatronal(numeropatronals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NumeroPatronalConstantesFunciones.refrescarForeignKeysDescripcionesNumeroPatronal(this.numeropatronals);
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
		numeropatronals = new  ArrayList<NumeroPatronal>();
		  		  
        try {
			NumeroPatronalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			numeropatronals=numeropatronalDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNumeroPatronal(numeropatronals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NumeroPatronalConstantesFunciones.refrescarForeignKeysDescripcionesNumeroPatronal(this.numeropatronals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosNumeroPatronalsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		numeropatronals = new  ArrayList<NumeroPatronal>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroPatronal.class.getSimpleName()+"-getTodosNumeroPatronalsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NumeroPatronalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			numeropatronals=numeropatronalDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarNumeroPatronal(numeropatronals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NumeroPatronalConstantesFunciones.refrescarForeignKeysDescripcionesNumeroPatronal(this.numeropatronals);
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
	
	public  void  getTodosNumeroPatronals(String sFinalQuery,Pagination pagination)throws Exception {
		numeropatronals = new  ArrayList<NumeroPatronal>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NumeroPatronalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			numeropatronals=numeropatronalDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarNumeroPatronal(numeropatronals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NumeroPatronalConstantesFunciones.refrescarForeignKeysDescripcionesNumeroPatronal(this.numeropatronals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarNumeroPatronal(NumeroPatronal numeropatronal) throws Exception {
		Boolean estaValidado=false;
		
		if(numeropatronal.getIsNew() || numeropatronal.getIsChanged()) { 
			this.invalidValues = numeropatronalValidator.getInvalidValues(numeropatronal);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(numeropatronal);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarNumeroPatronal(List<NumeroPatronal> NumeroPatronals) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(NumeroPatronal numeropatronalLocal:numeropatronals) {				
			estaValidadoObjeto=this.validarGuardarNumeroPatronal(numeropatronalLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarNumeroPatronal(List<NumeroPatronal> NumeroPatronals) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarNumeroPatronal(numeropatronals)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarNumeroPatronal(NumeroPatronal NumeroPatronal) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarNumeroPatronal(numeropatronal)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(NumeroPatronal numeropatronal) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+numeropatronal.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=NumeroPatronalConstantesFunciones.getNumeroPatronalLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"numeropatronal","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(NumeroPatronalConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(NumeroPatronalConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveNumeroPatronalWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroPatronal.class.getSimpleName()+"-saveNumeroPatronalWithConnection");connexion.begin();			
			
			NumeroPatronalLogicAdditional.checkNumeroPatronalToSave(this.numeropatronal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			NumeroPatronalLogicAdditional.updateNumeroPatronalToSave(this.numeropatronal,this.arrDatoGeneral);
			
			NumeroPatronalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.numeropatronal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowNumeroPatronal();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarNumeroPatronal(this.numeropatronal)) {
				NumeroPatronalDataAccess.save(this.numeropatronal, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.numeropatronal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			NumeroPatronalLogicAdditional.checkNumeroPatronalToSaveAfter(this.numeropatronal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowNumeroPatronal();
			
			connexion.commit();			
			
			if(this.numeropatronal.getIsDeleted()) {
				this.numeropatronal=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveNumeroPatronal()throws Exception {	
		try {	
			
			NumeroPatronalLogicAdditional.checkNumeroPatronalToSave(this.numeropatronal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			NumeroPatronalLogicAdditional.updateNumeroPatronalToSave(this.numeropatronal,this.arrDatoGeneral);
			
			NumeroPatronalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.numeropatronal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarNumeroPatronal(this.numeropatronal)) {			
				NumeroPatronalDataAccess.save(this.numeropatronal, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.numeropatronal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			NumeroPatronalLogicAdditional.checkNumeroPatronalToSaveAfter(this.numeropatronal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.numeropatronal.getIsDeleted()) {
				this.numeropatronal=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveNumeroPatronalsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroPatronal.class.getSimpleName()+"-saveNumeroPatronalsWithConnection");connexion.begin();			
			
			NumeroPatronalLogicAdditional.checkNumeroPatronalToSaves(numeropatronals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowNumeroPatronals();
			
			Boolean validadoTodosNumeroPatronal=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(NumeroPatronal numeropatronalLocal:numeropatronals) {		
				if(numeropatronalLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				NumeroPatronalLogicAdditional.updateNumeroPatronalToSave(numeropatronalLocal,this.arrDatoGeneral);
	        	
				NumeroPatronalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),numeropatronalLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarNumeroPatronal(numeropatronalLocal)) {
					NumeroPatronalDataAccess.save(numeropatronalLocal, connexion);				
				} else {
					validadoTodosNumeroPatronal=false;
				}
			}
			
			if(!validadoTodosNumeroPatronal) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			NumeroPatronalLogicAdditional.checkNumeroPatronalToSavesAfter(numeropatronals,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowNumeroPatronals();
			
			connexion.commit();		
			
			this.quitarNumeroPatronalsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveNumeroPatronals()throws Exception {				
		 try {	
			NumeroPatronalLogicAdditional.checkNumeroPatronalToSaves(numeropatronals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosNumeroPatronal=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(NumeroPatronal numeropatronalLocal:numeropatronals) {				
				if(numeropatronalLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				NumeroPatronalLogicAdditional.updateNumeroPatronalToSave(numeropatronalLocal,this.arrDatoGeneral);
	        	
				NumeroPatronalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),numeropatronalLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarNumeroPatronal(numeropatronalLocal)) {				
					NumeroPatronalDataAccess.save(numeropatronalLocal, connexion);				
				} else {
					validadoTodosNumeroPatronal=false;
				}
			}
			
			if(!validadoTodosNumeroPatronal) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			NumeroPatronalLogicAdditional.checkNumeroPatronalToSavesAfter(numeropatronals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarNumeroPatronalsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public NumeroPatronalParameterReturnGeneral procesarAccionNumeroPatronals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<NumeroPatronal> numeropatronals,NumeroPatronalParameterReturnGeneral numeropatronalParameterGeneral)throws Exception {
		 try {	
			NumeroPatronalParameterReturnGeneral numeropatronalReturnGeneral=new NumeroPatronalParameterReturnGeneral();
	
			NumeroPatronalLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,numeropatronals,numeropatronalParameterGeneral,numeropatronalReturnGeneral);
			
			return numeropatronalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public NumeroPatronalParameterReturnGeneral procesarAccionNumeroPatronalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<NumeroPatronal> numeropatronals,NumeroPatronalParameterReturnGeneral numeropatronalParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroPatronal.class.getSimpleName()+"-procesarAccionNumeroPatronalsWithConnection");connexion.begin();			
			
			NumeroPatronalParameterReturnGeneral numeropatronalReturnGeneral=new NumeroPatronalParameterReturnGeneral();
	
			NumeroPatronalLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,numeropatronals,numeropatronalParameterGeneral,numeropatronalReturnGeneral);
			
			this.connexion.commit();
			
			return numeropatronalReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public NumeroPatronalParameterReturnGeneral procesarEventosNumeroPatronals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<NumeroPatronal> numeropatronals,NumeroPatronal numeropatronal,NumeroPatronalParameterReturnGeneral numeropatronalParameterGeneral,Boolean isEsNuevoNumeroPatronal,ArrayList<Classe> clases)throws Exception {
		 try {	
			NumeroPatronalParameterReturnGeneral numeropatronalReturnGeneral=new NumeroPatronalParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				numeropatronalReturnGeneral.setConRecargarPropiedades(true);
			}
			
			NumeroPatronalLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,numeropatronals,numeropatronal,numeropatronalParameterGeneral,numeropatronalReturnGeneral,isEsNuevoNumeroPatronal,clases);
			
			return numeropatronalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public NumeroPatronalParameterReturnGeneral procesarEventosNumeroPatronalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<NumeroPatronal> numeropatronals,NumeroPatronal numeropatronal,NumeroPatronalParameterReturnGeneral numeropatronalParameterGeneral,Boolean isEsNuevoNumeroPatronal,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroPatronal.class.getSimpleName()+"-procesarEventosNumeroPatronalsWithConnection");connexion.begin();			
			
			NumeroPatronalParameterReturnGeneral numeropatronalReturnGeneral=new NumeroPatronalParameterReturnGeneral();
	
			numeropatronalReturnGeneral.setNumeroPatronal(numeropatronal);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				numeropatronalReturnGeneral.setConRecargarPropiedades(true);
			}
			
			NumeroPatronalLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,numeropatronals,numeropatronal,numeropatronalParameterGeneral,numeropatronalReturnGeneral,isEsNuevoNumeroPatronal,clases);
			
			this.connexion.commit();
			
			return numeropatronalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public NumeroPatronalParameterReturnGeneral procesarImportacionNumeroPatronalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,NumeroPatronalParameterReturnGeneral numeropatronalParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroPatronal.class.getSimpleName()+"-procesarImportacionNumeroPatronalsWithConnection");connexion.begin();			
			
			NumeroPatronalParameterReturnGeneral numeropatronalReturnGeneral=new NumeroPatronalParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.numeropatronals=new ArrayList<NumeroPatronal>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.numeropatronal=new NumeroPatronal();
				
				
				if(conColumnasBase) {this.numeropatronal.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.numeropatronal.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.numeropatronal.setnumero(arrColumnas[iColumn++]);
				this.numeropatronal.setcodigo_actividad(arrColumnas[iColumn++]);
				this.numeropatronal.setapellido(arrColumnas[iColumn++]);
				this.numeropatronal.setnombre(arrColumnas[iColumn++]);
				this.numeropatronal.setcedula(arrColumnas[iColumn++]);
				this.numeropatronal.settelefono(arrColumnas[iColumn++]);
				this.numeropatronal.setdescripcion(arrColumnas[iColumn++]);
				
				this.numeropatronals.add(this.numeropatronal);
			}
			
			this.saveNumeroPatronals();
			
			this.connexion.commit();
			
			numeropatronalReturnGeneral.setConRetornoEstaProcesado(true);
			numeropatronalReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return numeropatronalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarNumeroPatronalsEliminados() throws Exception {				
		
		List<NumeroPatronal> numeropatronalsAux= new ArrayList<NumeroPatronal>();
		
		for(NumeroPatronal numeropatronal:numeropatronals) {
			if(!numeropatronal.getIsDeleted()) {
				numeropatronalsAux.add(numeropatronal);
			}
		}
		
		numeropatronals=numeropatronalsAux;
	}
	
	public void quitarNumeroPatronalsNulos() throws Exception {				
		
		List<NumeroPatronal> numeropatronalsAux= new ArrayList<NumeroPatronal>();
		
		for(NumeroPatronal numeropatronal : this.numeropatronals) {
			if(numeropatronal==null) {
				numeropatronalsAux.add(numeropatronal);
			}
		}
		
		//this.numeropatronals=numeropatronalsAux;
		
		this.numeropatronals.removeAll(numeropatronalsAux);
	}
	
	public void getSetVersionRowNumeroPatronalWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(numeropatronal.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((numeropatronal.getIsDeleted() || (numeropatronal.getIsChanged()&&!numeropatronal.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=numeropatronalDataAccess.getSetVersionRowNumeroPatronal(connexion,numeropatronal.getId());
				
				if(!numeropatronal.getVersionRow().equals(timestamp)) {	
					numeropatronal.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				numeropatronal.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowNumeroPatronal()throws Exception {	
		
		if(numeropatronal.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((numeropatronal.getIsDeleted() || (numeropatronal.getIsChanged()&&!numeropatronal.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=numeropatronalDataAccess.getSetVersionRowNumeroPatronal(connexion,numeropatronal.getId());
			
			try {							
				if(!numeropatronal.getVersionRow().equals(timestamp)) {	
					numeropatronal.setVersionRow(timestamp);
				}
				
				numeropatronal.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowNumeroPatronalsWithConnection()throws Exception {	
		if(numeropatronals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(NumeroPatronal numeropatronalAux:numeropatronals) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(numeropatronalAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(numeropatronalAux.getIsDeleted() || (numeropatronalAux.getIsChanged()&&!numeropatronalAux.getIsNew())) {
						
						timestamp=numeropatronalDataAccess.getSetVersionRowNumeroPatronal(connexion,numeropatronalAux.getId());
						
						if(!numeropatronal.getVersionRow().equals(timestamp)) {	
							numeropatronalAux.setVersionRow(timestamp);
						}
								
						numeropatronalAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowNumeroPatronals()throws Exception {	
		if(numeropatronals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(NumeroPatronal numeropatronalAux:numeropatronals) {
					if(numeropatronalAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(numeropatronalAux.getIsDeleted() || (numeropatronalAux.getIsChanged()&&!numeropatronalAux.getIsNew())) {
						
						timestamp=numeropatronalDataAccess.getSetVersionRowNumeroPatronal(connexion,numeropatronalAux.getId());
						
						if(!numeropatronalAux.getVersionRow().equals(timestamp)) {	
							numeropatronalAux.setVersionRow(timestamp);
						}
						
													
						numeropatronalAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public NumeroPatronalParameterReturnGeneral cargarCombosLoteForeignKeyNumeroPatronalWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalProvincia,String finalQueryGlobalCanton,String finalQueryGlobalParroquia) throws Exception {
		NumeroPatronalParameterReturnGeneral  numeropatronalReturnGeneral =new NumeroPatronalParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroPatronal.class.getSimpleName()+"-cargarCombosLoteForeignKeyNumeroPatronalWithConnection");connexion.begin();
			
			numeropatronalReturnGeneral =new NumeroPatronalParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			numeropatronalReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Provincia> provinciasForeignKey=new ArrayList<Provincia>();
			ProvinciaLogic provinciaLogic=new ProvinciaLogic();
			provinciaLogic.setConnexion(this.connexion);
			provinciaLogic.getProvinciaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProvincia.equals("NONE")) {
				provinciaLogic.getTodosProvincias(finalQueryGlobalProvincia,new Pagination());
				provinciasForeignKey=provinciaLogic.getProvincias();
			}

			numeropatronalReturnGeneral.setprovinciasForeignKey(provinciasForeignKey);


			List<Canton> cantonsForeignKey=new ArrayList<Canton>();
			CantonLogic cantonLogic=new CantonLogic();
			cantonLogic.setConnexion(this.connexion);
			cantonLogic.getCantonDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCanton.equals("NONE")) {
				cantonLogic.getTodosCantons(finalQueryGlobalCanton,new Pagination());
				cantonsForeignKey=cantonLogic.getCantons();
			}

			numeropatronalReturnGeneral.setcantonsForeignKey(cantonsForeignKey);


			List<Parroquia> parroquiasForeignKey=new ArrayList<Parroquia>();
			ParroquiaLogic parroquiaLogic=new ParroquiaLogic();
			parroquiaLogic.setConnexion(this.connexion);
			parroquiaLogic.getParroquiaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalParroquia.equals("NONE")) {
				parroquiaLogic.getTodosParroquias(finalQueryGlobalParroquia,new Pagination());
				parroquiasForeignKey=parroquiaLogic.getParroquias();
			}

			numeropatronalReturnGeneral.setparroquiasForeignKey(parroquiasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return numeropatronalReturnGeneral;
	}
	
	public NumeroPatronalParameterReturnGeneral cargarCombosLoteForeignKeyNumeroPatronal(String finalQueryGlobalEmpresa,String finalQueryGlobalProvincia,String finalQueryGlobalCanton,String finalQueryGlobalParroquia) throws Exception {
		NumeroPatronalParameterReturnGeneral  numeropatronalReturnGeneral =new NumeroPatronalParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			numeropatronalReturnGeneral =new NumeroPatronalParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			numeropatronalReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Provincia> provinciasForeignKey=new ArrayList<Provincia>();
			ProvinciaLogic provinciaLogic=new ProvinciaLogic();
			provinciaLogic.setConnexion(this.connexion);
			provinciaLogic.getProvinciaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProvincia.equals("NONE")) {
				provinciaLogic.getTodosProvincias(finalQueryGlobalProvincia,new Pagination());
				provinciasForeignKey=provinciaLogic.getProvincias();
			}

			numeropatronalReturnGeneral.setprovinciasForeignKey(provinciasForeignKey);


			List<Canton> cantonsForeignKey=new ArrayList<Canton>();
			CantonLogic cantonLogic=new CantonLogic();
			cantonLogic.setConnexion(this.connexion);
			cantonLogic.getCantonDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCanton.equals("NONE")) {
				cantonLogic.getTodosCantons(finalQueryGlobalCanton,new Pagination());
				cantonsForeignKey=cantonLogic.getCantons();
			}

			numeropatronalReturnGeneral.setcantonsForeignKey(cantonsForeignKey);


			List<Parroquia> parroquiasForeignKey=new ArrayList<Parroquia>();
			ParroquiaLogic parroquiaLogic=new ParroquiaLogic();
			parroquiaLogic.setConnexion(this.connexion);
			parroquiaLogic.getParroquiaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalParroquia.equals("NONE")) {
				parroquiaLogic.getTodosParroquias(finalQueryGlobalParroquia,new Pagination());
				parroquiasForeignKey=parroquiaLogic.getParroquias();
			}

			numeropatronalReturnGeneral.setparroquiasForeignKey(parroquiasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return numeropatronalReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyNumeroPatronalWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DatoGeneralEmpleadoLogic datogeneralempleadoLogic=new DatoGeneralEmpleadoLogic();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			CargoLogic cargoLogic=new CargoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroPatronal.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyNumeroPatronalWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DatoGeneralEmpleado.class));
			classes.add(new Classe(Estructura.class));
			classes.add(new Classe(Cargo.class));
											
			

			datogeneralempleadoLogic.setConnexion(this.getConnexion());
			datogeneralempleadoLogic.setDatosCliente(this.datosCliente);
			datogeneralempleadoLogic.setIsConRefrescarForeignKeys(true);

			estructuraLogic.setConnexion(this.getConnexion());
			estructuraLogic.setDatosCliente(this.datosCliente);
			estructuraLogic.setIsConRefrescarForeignKeys(true);

			cargoLogic.setConnexion(this.getConnexion());
			cargoLogic.setDatosCliente(this.datosCliente);
			cargoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(NumeroPatronal numeropatronal:this.numeropatronals) {
				

				classes=new ArrayList<Classe>();
				classes=DatoGeneralEmpleadoConstantesFunciones.getClassesForeignKeysOfDatoGeneralEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				datogeneralempleadoLogic.setDatoGeneralEmpleados(numeropatronal.datogeneralempleados);
				datogeneralempleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=EstructuraConstantesFunciones.getClassesForeignKeysOfEstructura(new ArrayList<Classe>(),DeepLoadType.NONE);

				estructuraLogic.setEstructuras(numeropatronal.estructuras);
				estructuraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CargoConstantesFunciones.getClassesForeignKeysOfCargo(new ArrayList<Classe>(),DeepLoadType.NONE);

				cargoLogic.setCargos(numeropatronal.cargos);
				cargoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(NumeroPatronal numeropatronal,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			NumeroPatronalLogicAdditional.updateNumeroPatronalToGet(numeropatronal,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		numeropatronal.setEmpresa(numeropatronalDataAccess.getEmpresa(connexion,numeropatronal));
		numeropatronal.setProvincia(numeropatronalDataAccess.getProvincia(connexion,numeropatronal));
		numeropatronal.setCanton(numeropatronalDataAccess.getCanton(connexion,numeropatronal));
		numeropatronal.setParroquia(numeropatronalDataAccess.getParroquia(connexion,numeropatronal));
		numeropatronal.setDatoGeneralEmpleados(numeropatronalDataAccess.getDatoGeneralEmpleados(connexion,numeropatronal));
		numeropatronal.setEstructuras(numeropatronalDataAccess.getEstructuras(connexion,numeropatronal));
		numeropatronal.setCargos(numeropatronalDataAccess.getCargos(connexion,numeropatronal));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				numeropatronal.setEmpresa(numeropatronalDataAccess.getEmpresa(connexion,numeropatronal));
				continue;
			}

			if(clas.clas.equals(Provincia.class)) {
				numeropatronal.setProvincia(numeropatronalDataAccess.getProvincia(connexion,numeropatronal));
				continue;
			}

			if(clas.clas.equals(Canton.class)) {
				numeropatronal.setCanton(numeropatronalDataAccess.getCanton(connexion,numeropatronal));
				continue;
			}

			if(clas.clas.equals(Parroquia.class)) {
				numeropatronal.setParroquia(numeropatronalDataAccess.getParroquia(connexion,numeropatronal));
				continue;
			}

			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				numeropatronal.setDatoGeneralEmpleados(numeropatronalDataAccess.getDatoGeneralEmpleados(connexion,numeropatronal));

				if(this.isConDeep) {
					DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(this.connexion);
					datogeneralempleadoLogic.setDatoGeneralEmpleados(numeropatronal.getDatoGeneralEmpleados());
					ArrayList<Classe> classesLocal=DatoGeneralEmpleadoConstantesFunciones.getClassesForeignKeysOfDatoGeneralEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					datogeneralempleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(datogeneralempleadoLogic.getDatoGeneralEmpleados());
					numeropatronal.setDatoGeneralEmpleados(datogeneralempleadoLogic.getDatoGeneralEmpleados());
				}

				continue;
			}

			if(clas.clas.equals(Estructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				numeropatronal.setEstructuras(numeropatronalDataAccess.getEstructuras(connexion,numeropatronal));

				if(this.isConDeep) {
					EstructuraLogic estructuraLogic= new EstructuraLogic(this.connexion);
					estructuraLogic.setEstructuras(numeropatronal.getEstructuras());
					ArrayList<Classe> classesLocal=EstructuraConstantesFunciones.getClassesForeignKeysOfEstructura(new ArrayList<Classe>(),DeepLoadType.NONE);
					estructuraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(estructuraLogic.getEstructuras());
					numeropatronal.setEstructuras(estructuraLogic.getEstructuras());
				}

				continue;
			}

			if(clas.clas.equals(Cargo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				numeropatronal.setCargos(numeropatronalDataAccess.getCargos(connexion,numeropatronal));

				if(this.isConDeep) {
					CargoLogic cargoLogic= new CargoLogic(this.connexion);
					cargoLogic.setCargos(numeropatronal.getCargos());
					ArrayList<Classe> classesLocal=CargoConstantesFunciones.getClassesForeignKeysOfCargo(new ArrayList<Classe>(),DeepLoadType.NONE);
					cargoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(cargoLogic.getCargos());
					numeropatronal.setCargos(cargoLogic.getCargos());
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
			numeropatronal.setEmpresa(numeropatronalDataAccess.getEmpresa(connexion,numeropatronal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			numeropatronal.setProvincia(numeropatronalDataAccess.getProvincia(connexion,numeropatronal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Canton.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			numeropatronal.setCanton(numeropatronalDataAccess.getCanton(connexion,numeropatronal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Parroquia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			numeropatronal.setParroquia(numeropatronalDataAccess.getParroquia(connexion,numeropatronal));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DatoGeneralEmpleado.class));
			numeropatronal.setDatoGeneralEmpleados(numeropatronalDataAccess.getDatoGeneralEmpleados(connexion,numeropatronal));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Estructura.class));
			numeropatronal.setEstructuras(numeropatronalDataAccess.getEstructuras(connexion,numeropatronal));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cargo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Cargo.class));
			numeropatronal.setCargos(numeropatronalDataAccess.getCargos(connexion,numeropatronal));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		numeropatronal.setEmpresa(numeropatronalDataAccess.getEmpresa(connexion,numeropatronal));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(numeropatronal.getEmpresa(),isDeep,deepLoadType,clases);
				
		numeropatronal.setProvincia(numeropatronalDataAccess.getProvincia(connexion,numeropatronal));
		ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
		provinciaLogic.deepLoad(numeropatronal.getProvincia(),isDeep,deepLoadType,clases);
				
		numeropatronal.setCanton(numeropatronalDataAccess.getCanton(connexion,numeropatronal));
		CantonLogic cantonLogic= new CantonLogic(connexion);
		cantonLogic.deepLoad(numeropatronal.getCanton(),isDeep,deepLoadType,clases);
				
		numeropatronal.setParroquia(numeropatronalDataAccess.getParroquia(connexion,numeropatronal));
		ParroquiaLogic parroquiaLogic= new ParroquiaLogic(connexion);
		parroquiaLogic.deepLoad(numeropatronal.getParroquia(),isDeep,deepLoadType,clases);
				

		numeropatronal.setDatoGeneralEmpleados(numeropatronalDataAccess.getDatoGeneralEmpleados(connexion,numeropatronal));

		for(DatoGeneralEmpleado datogeneralempleado:numeropatronal.getDatoGeneralEmpleados()) {
			DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
			datogeneralempleadoLogic.deepLoad(datogeneralempleado,isDeep,deepLoadType,clases);
		}

		numeropatronal.setEstructuras(numeropatronalDataAccess.getEstructuras(connexion,numeropatronal));

		for(Estructura estructura:numeropatronal.getEstructuras()) {
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(estructura,isDeep,deepLoadType,clases);
		}

		numeropatronal.setCargos(numeropatronalDataAccess.getCargos(connexion,numeropatronal));

		for(Cargo cargo:numeropatronal.getCargos()) {
			CargoLogic cargoLogic= new CargoLogic(connexion);
			cargoLogic.deepLoad(cargo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				numeropatronal.setEmpresa(numeropatronalDataAccess.getEmpresa(connexion,numeropatronal));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(numeropatronal.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Provincia.class)) {
				numeropatronal.setProvincia(numeropatronalDataAccess.getProvincia(connexion,numeropatronal));
				ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
				provinciaLogic.deepLoad(numeropatronal.getProvincia(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Canton.class)) {
				numeropatronal.setCanton(numeropatronalDataAccess.getCanton(connexion,numeropatronal));
				CantonLogic cantonLogic= new CantonLogic(connexion);
				cantonLogic.deepLoad(numeropatronal.getCanton(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Parroquia.class)) {
				numeropatronal.setParroquia(numeropatronalDataAccess.getParroquia(connexion,numeropatronal));
				ParroquiaLogic parroquiaLogic= new ParroquiaLogic(connexion);
				parroquiaLogic.deepLoad(numeropatronal.getParroquia(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				numeropatronal.setDatoGeneralEmpleados(numeropatronalDataAccess.getDatoGeneralEmpleados(connexion,numeropatronal));

				for(DatoGeneralEmpleado datogeneralempleado:numeropatronal.getDatoGeneralEmpleados()) {
					DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
					datogeneralempleadoLogic.deepLoad(datogeneralempleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Estructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				numeropatronal.setEstructuras(numeropatronalDataAccess.getEstructuras(connexion,numeropatronal));

				for(Estructura estructura:numeropatronal.getEstructuras()) {
					EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
					estructuraLogic.deepLoad(estructura,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Cargo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				numeropatronal.setCargos(numeropatronalDataAccess.getCargos(connexion,numeropatronal));

				for(Cargo cargo:numeropatronal.getCargos()) {
					CargoLogic cargoLogic= new CargoLogic(connexion);
					cargoLogic.deepLoad(cargo,isDeep,deepLoadType,clases);
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
			numeropatronal.setEmpresa(numeropatronalDataAccess.getEmpresa(connexion,numeropatronal));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(numeropatronal.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			numeropatronal.setProvincia(numeropatronalDataAccess.getProvincia(connexion,numeropatronal));
			ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
			provinciaLogic.deepLoad(numeropatronal.getProvincia(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Canton.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			numeropatronal.setCanton(numeropatronalDataAccess.getCanton(connexion,numeropatronal));
			CantonLogic cantonLogic= new CantonLogic(connexion);
			cantonLogic.deepLoad(numeropatronal.getCanton(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Parroquia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			numeropatronal.setParroquia(numeropatronalDataAccess.getParroquia(connexion,numeropatronal));
			ParroquiaLogic parroquiaLogic= new ParroquiaLogic(connexion);
			parroquiaLogic.deepLoad(numeropatronal.getParroquia(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DatoGeneralEmpleado.class));
			numeropatronal.setDatoGeneralEmpleados(numeropatronalDataAccess.getDatoGeneralEmpleados(connexion,numeropatronal));

			for(DatoGeneralEmpleado datogeneralempleado:numeropatronal.getDatoGeneralEmpleados()) {
				DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
				datogeneralempleadoLogic.deepLoad(datogeneralempleado,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Estructura.class));
			numeropatronal.setEstructuras(numeropatronalDataAccess.getEstructuras(connexion,numeropatronal));

			for(Estructura estructura:numeropatronal.getEstructuras()) {
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(estructura,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cargo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Cargo.class));
			numeropatronal.setCargos(numeropatronalDataAccess.getCargos(connexion,numeropatronal));

			for(Cargo cargo:numeropatronal.getCargos()) {
				CargoLogic cargoLogic= new CargoLogic(connexion);
				cargoLogic.deepLoad(cargo,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(NumeroPatronal numeropatronal,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			NumeroPatronalLogicAdditional.updateNumeroPatronalToSave(numeropatronal,this.arrDatoGeneral);
			
NumeroPatronalDataAccess.save(numeropatronal, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(numeropatronal.getEmpresa(),connexion);

		ProvinciaDataAccess.save(numeropatronal.getProvincia(),connexion);

		CantonDataAccess.save(numeropatronal.getCanton(),connexion);

		ParroquiaDataAccess.save(numeropatronal.getParroquia(),connexion);

		for(DatoGeneralEmpleado datogeneralempleado:numeropatronal.getDatoGeneralEmpleados()) {
			datogeneralempleado.setid_numero_patronal(numeropatronal.getId());
			DatoGeneralEmpleadoDataAccess.save(datogeneralempleado,connexion);
		}

		for(Estructura estructura:numeropatronal.getEstructuras()) {
			estructura.setid_numero_patronal(numeropatronal.getId());
			EstructuraDataAccess.save(estructura,connexion);
		}

		for(Cargo cargo:numeropatronal.getCargos()) {
			cargo.setid_numero_patronal(numeropatronal.getId());
			CargoDataAccess.save(cargo,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(numeropatronal.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Provincia.class)) {
				ProvinciaDataAccess.save(numeropatronal.getProvincia(),connexion);
				continue;
			}

			if(clas.clas.equals(Canton.class)) {
				CantonDataAccess.save(numeropatronal.getCanton(),connexion);
				continue;
			}

			if(clas.clas.equals(Parroquia.class)) {
				ParroquiaDataAccess.save(numeropatronal.getParroquia(),connexion);
				continue;
			}


			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DatoGeneralEmpleado datogeneralempleado:numeropatronal.getDatoGeneralEmpleados()) {
					datogeneralempleado.setid_numero_patronal(numeropatronal.getId());
					DatoGeneralEmpleadoDataAccess.save(datogeneralempleado,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Estructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Estructura estructura:numeropatronal.getEstructuras()) {
					estructura.setid_numero_patronal(numeropatronal.getId());
					EstructuraDataAccess.save(estructura,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Cargo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cargo cargo:numeropatronal.getCargos()) {
					cargo.setid_numero_patronal(numeropatronal.getId());
					CargoDataAccess.save(cargo,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(numeropatronal.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(numeropatronal.getEmpresa(),isDeep,deepLoadType,clases);
				

		ProvinciaDataAccess.save(numeropatronal.getProvincia(),connexion);
		ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
		provinciaLogic.deepLoad(numeropatronal.getProvincia(),isDeep,deepLoadType,clases);
				

		CantonDataAccess.save(numeropatronal.getCanton(),connexion);
		CantonLogic cantonLogic= new CantonLogic(connexion);
		cantonLogic.deepLoad(numeropatronal.getCanton(),isDeep,deepLoadType,clases);
				

		ParroquiaDataAccess.save(numeropatronal.getParroquia(),connexion);
		ParroquiaLogic parroquiaLogic= new ParroquiaLogic(connexion);
		parroquiaLogic.deepLoad(numeropatronal.getParroquia(),isDeep,deepLoadType,clases);
				

		for(DatoGeneralEmpleado datogeneralempleado:numeropatronal.getDatoGeneralEmpleados()) {
			DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
			datogeneralempleado.setid_numero_patronal(numeropatronal.getId());
			DatoGeneralEmpleadoDataAccess.save(datogeneralempleado,connexion);
			datogeneralempleadoLogic.deepSave(datogeneralempleado,isDeep,deepLoadType,clases);
		}

		for(Estructura estructura:numeropatronal.getEstructuras()) {
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructura.setid_numero_patronal(numeropatronal.getId());
			EstructuraDataAccess.save(estructura,connexion);
			estructuraLogic.deepSave(estructura,isDeep,deepLoadType,clases);
		}

		for(Cargo cargo:numeropatronal.getCargos()) {
			CargoLogic cargoLogic= new CargoLogic(connexion);
			cargo.setid_numero_patronal(numeropatronal.getId());
			CargoDataAccess.save(cargo,connexion);
			cargoLogic.deepSave(cargo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(numeropatronal.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(numeropatronal.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Provincia.class)) {
				ProvinciaDataAccess.save(numeropatronal.getProvincia(),connexion);
				ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
				provinciaLogic.deepSave(numeropatronal.getProvincia(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Canton.class)) {
				CantonDataAccess.save(numeropatronal.getCanton(),connexion);
				CantonLogic cantonLogic= new CantonLogic(connexion);
				cantonLogic.deepSave(numeropatronal.getCanton(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Parroquia.class)) {
				ParroquiaDataAccess.save(numeropatronal.getParroquia(),connexion);
				ParroquiaLogic parroquiaLogic= new ParroquiaLogic(connexion);
				parroquiaLogic.deepSave(numeropatronal.getParroquia(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DatoGeneralEmpleado datogeneralempleado:numeropatronal.getDatoGeneralEmpleados()) {
					DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
					datogeneralempleado.setid_numero_patronal(numeropatronal.getId());
					DatoGeneralEmpleadoDataAccess.save(datogeneralempleado,connexion);
					datogeneralempleadoLogic.deepSave(datogeneralempleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Estructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Estructura estructura:numeropatronal.getEstructuras()) {
					EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
					estructura.setid_numero_patronal(numeropatronal.getId());
					EstructuraDataAccess.save(estructura,connexion);
					estructuraLogic.deepSave(estructura,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Cargo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cargo cargo:numeropatronal.getCargos()) {
					CargoLogic cargoLogic= new CargoLogic(connexion);
					cargo.setid_numero_patronal(numeropatronal.getId());
					CargoDataAccess.save(cargo,connexion);
					cargoLogic.deepSave(cargo,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(NumeroPatronal.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(numeropatronal,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				NumeroPatronalConstantesFunciones.refrescarForeignKeysDescripcionesNumeroPatronal(numeropatronal);
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
			this.deepLoad(this.numeropatronal,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				NumeroPatronalConstantesFunciones.refrescarForeignKeysDescripcionesNumeroPatronal(this.numeropatronal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(NumeroPatronal.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(numeropatronals!=null) {
				for(NumeroPatronal numeropatronal:numeropatronals) {
					this.deepLoad(numeropatronal,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					NumeroPatronalConstantesFunciones.refrescarForeignKeysDescripcionesNumeroPatronal(numeropatronals);
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
			if(numeropatronals!=null) {
				for(NumeroPatronal numeropatronal:numeropatronals) {
					this.deepLoad(numeropatronal,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					NumeroPatronalConstantesFunciones.refrescarForeignKeysDescripcionesNumeroPatronal(numeropatronals);
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
			this.getNewConnexionToDeep(NumeroPatronal.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(numeropatronal,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(NumeroPatronal.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(numeropatronals!=null) {
				for(NumeroPatronal numeropatronal:numeropatronals) {
					this.deepSave(numeropatronal,isDeep,deepLoadType,clases);
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
			if(numeropatronals!=null) {
				for(NumeroPatronal numeropatronal:numeropatronals) {
					this.deepSave(numeropatronal,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getNumeroPatronalsFK_IdCantonWithConnection(String sFinalQuery,Pagination pagination,Long id_canton)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroPatronal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCanton= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCanton.setParameterSelectionGeneralEqual(ParameterType.LONG,id_canton,NumeroPatronalConstantesFunciones.IDCANTON,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCanton);

			NumeroPatronalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCanton","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			numeropatronals=numeropatronalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NumeroPatronalConstantesFunciones.refrescarForeignKeysDescripcionesNumeroPatronal(this.numeropatronals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNumeroPatronalsFK_IdCanton(String sFinalQuery,Pagination pagination,Long id_canton)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCanton= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCanton.setParameterSelectionGeneralEqual(ParameterType.LONG,id_canton,NumeroPatronalConstantesFunciones.IDCANTON,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCanton);

			NumeroPatronalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCanton","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			numeropatronals=numeropatronalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NumeroPatronalConstantesFunciones.refrescarForeignKeysDescripcionesNumeroPatronal(this.numeropatronals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNumeroPatronalsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroPatronal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,NumeroPatronalConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			NumeroPatronalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			numeropatronals=numeropatronalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NumeroPatronalConstantesFunciones.refrescarForeignKeysDescripcionesNumeroPatronal(this.numeropatronals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNumeroPatronalsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,NumeroPatronalConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			NumeroPatronalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			numeropatronals=numeropatronalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NumeroPatronalConstantesFunciones.refrescarForeignKeysDescripcionesNumeroPatronal(this.numeropatronals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNumeroPatronalsFK_IdParroquiaWithConnection(String sFinalQuery,Pagination pagination,Long id_parroquia)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroPatronal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidParroquia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidParroquia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_parroquia,NumeroPatronalConstantesFunciones.IDPARROQUIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidParroquia);

			NumeroPatronalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdParroquia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			numeropatronals=numeropatronalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NumeroPatronalConstantesFunciones.refrescarForeignKeysDescripcionesNumeroPatronal(this.numeropatronals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNumeroPatronalsFK_IdParroquia(String sFinalQuery,Pagination pagination,Long id_parroquia)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidParroquia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidParroquia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_parroquia,NumeroPatronalConstantesFunciones.IDPARROQUIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidParroquia);

			NumeroPatronalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdParroquia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			numeropatronals=numeropatronalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NumeroPatronalConstantesFunciones.refrescarForeignKeysDescripcionesNumeroPatronal(this.numeropatronals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNumeroPatronalsFK_IdProvinciaWithConnection(String sFinalQuery,Pagination pagination,Long id_provincia)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NumeroPatronal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProvincia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProvincia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_provincia,NumeroPatronalConstantesFunciones.IDPROVINCIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProvincia);

			NumeroPatronalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProvincia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			numeropatronals=numeropatronalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NumeroPatronalConstantesFunciones.refrescarForeignKeysDescripcionesNumeroPatronal(this.numeropatronals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNumeroPatronalsFK_IdProvincia(String sFinalQuery,Pagination pagination,Long id_provincia)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProvincia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProvincia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_provincia,NumeroPatronalConstantesFunciones.IDPROVINCIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProvincia);

			NumeroPatronalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProvincia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			numeropatronals=numeropatronalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NumeroPatronalConstantesFunciones.refrescarForeignKeysDescripcionesNumeroPatronal(this.numeropatronals);
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
			if(NumeroPatronalConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,NumeroPatronalDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,NumeroPatronal numeropatronal,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(NumeroPatronalConstantesFunciones.ISCONAUDITORIA) {
				if(numeropatronal.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NumeroPatronalDataAccess.TABLENAME, numeropatronal.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(NumeroPatronalConstantesFunciones.ISCONAUDITORIADETALLE) {
						////NumeroPatronalLogic.registrarAuditoriaDetallesNumeroPatronal(connexion,numeropatronal,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(numeropatronal.getIsDeleted()) {
					/*if(!numeropatronal.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,NumeroPatronalDataAccess.TABLENAME, numeropatronal.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////NumeroPatronalLogic.registrarAuditoriaDetallesNumeroPatronal(connexion,numeropatronal,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NumeroPatronalDataAccess.TABLENAME, numeropatronal.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(numeropatronal.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NumeroPatronalDataAccess.TABLENAME, numeropatronal.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(NumeroPatronalConstantesFunciones.ISCONAUDITORIADETALLE) {
						////NumeroPatronalLogic.registrarAuditoriaDetallesNumeroPatronal(connexion,numeropatronal,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesNumeroPatronal(Connexion connexion,NumeroPatronal numeropatronal)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(numeropatronal.getIsNew()||!numeropatronal.getid_empresa().equals(numeropatronal.getNumeroPatronalOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(numeropatronal.getNumeroPatronalOriginal().getid_empresa()!=null)
				{
					strValorActual=numeropatronal.getNumeroPatronalOriginal().getid_empresa().toString();
				}
				if(numeropatronal.getid_empresa()!=null)
				{
					strValorNuevo=numeropatronal.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NumeroPatronalConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(numeropatronal.getIsNew()||!numeropatronal.getid_provincia().equals(numeropatronal.getNumeroPatronalOriginal().getid_provincia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(numeropatronal.getNumeroPatronalOriginal().getid_provincia()!=null)
				{
					strValorActual=numeropatronal.getNumeroPatronalOriginal().getid_provincia().toString();
				}
				if(numeropatronal.getid_provincia()!=null)
				{
					strValorNuevo=numeropatronal.getid_provincia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NumeroPatronalConstantesFunciones.IDPROVINCIA,strValorActual,strValorNuevo);
			}	
			
			if(numeropatronal.getIsNew()||!numeropatronal.getid_canton().equals(numeropatronal.getNumeroPatronalOriginal().getid_canton()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(numeropatronal.getNumeroPatronalOriginal().getid_canton()!=null)
				{
					strValorActual=numeropatronal.getNumeroPatronalOriginal().getid_canton().toString();
				}
				if(numeropatronal.getid_canton()!=null)
				{
					strValorNuevo=numeropatronal.getid_canton().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NumeroPatronalConstantesFunciones.IDCANTON,strValorActual,strValorNuevo);
			}	
			
			if(numeropatronal.getIsNew()||!numeropatronal.getid_parroquia().equals(numeropatronal.getNumeroPatronalOriginal().getid_parroquia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(numeropatronal.getNumeroPatronalOriginal().getid_parroquia()!=null)
				{
					strValorActual=numeropatronal.getNumeroPatronalOriginal().getid_parroquia().toString();
				}
				if(numeropatronal.getid_parroquia()!=null)
				{
					strValorNuevo=numeropatronal.getid_parroquia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NumeroPatronalConstantesFunciones.IDPARROQUIA,strValorActual,strValorNuevo);
			}	
			
			if(numeropatronal.getIsNew()||!numeropatronal.getnumero().equals(numeropatronal.getNumeroPatronalOriginal().getnumero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(numeropatronal.getNumeroPatronalOriginal().getnumero()!=null)
				{
					strValorActual=numeropatronal.getNumeroPatronalOriginal().getnumero();
				}
				if(numeropatronal.getnumero()!=null)
				{
					strValorNuevo=numeropatronal.getnumero() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NumeroPatronalConstantesFunciones.NUMERO,strValorActual,strValorNuevo);
			}	
			
			if(numeropatronal.getIsNew()||!numeropatronal.getcodigo_actividad().equals(numeropatronal.getNumeroPatronalOriginal().getcodigo_actividad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(numeropatronal.getNumeroPatronalOriginal().getcodigo_actividad()!=null)
				{
					strValorActual=numeropatronal.getNumeroPatronalOriginal().getcodigo_actividad();
				}
				if(numeropatronal.getcodigo_actividad()!=null)
				{
					strValorNuevo=numeropatronal.getcodigo_actividad() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NumeroPatronalConstantesFunciones.CODIGOACTIVIDAD,strValorActual,strValorNuevo);
			}	
			
			if(numeropatronal.getIsNew()||!numeropatronal.getapellido().equals(numeropatronal.getNumeroPatronalOriginal().getapellido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(numeropatronal.getNumeroPatronalOriginal().getapellido()!=null)
				{
					strValorActual=numeropatronal.getNumeroPatronalOriginal().getapellido();
				}
				if(numeropatronal.getapellido()!=null)
				{
					strValorNuevo=numeropatronal.getapellido() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NumeroPatronalConstantesFunciones.APELLIDO,strValorActual,strValorNuevo);
			}	
			
			if(numeropatronal.getIsNew()||!numeropatronal.getnombre().equals(numeropatronal.getNumeroPatronalOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(numeropatronal.getNumeroPatronalOriginal().getnombre()!=null)
				{
					strValorActual=numeropatronal.getNumeroPatronalOriginal().getnombre();
				}
				if(numeropatronal.getnombre()!=null)
				{
					strValorNuevo=numeropatronal.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NumeroPatronalConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(numeropatronal.getIsNew()||!numeropatronal.getcedula().equals(numeropatronal.getNumeroPatronalOriginal().getcedula()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(numeropatronal.getNumeroPatronalOriginal().getcedula()!=null)
				{
					strValorActual=numeropatronal.getNumeroPatronalOriginal().getcedula();
				}
				if(numeropatronal.getcedula()!=null)
				{
					strValorNuevo=numeropatronal.getcedula() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NumeroPatronalConstantesFunciones.CEDULA,strValorActual,strValorNuevo);
			}	
			
			if(numeropatronal.getIsNew()||!numeropatronal.gettelefono().equals(numeropatronal.getNumeroPatronalOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(numeropatronal.getNumeroPatronalOriginal().gettelefono()!=null)
				{
					strValorActual=numeropatronal.getNumeroPatronalOriginal().gettelefono();
				}
				if(numeropatronal.gettelefono()!=null)
				{
					strValorNuevo=numeropatronal.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NumeroPatronalConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
			
			if(numeropatronal.getIsNew()||!numeropatronal.getdescripcion().equals(numeropatronal.getNumeroPatronalOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(numeropatronal.getNumeroPatronalOriginal().getdescripcion()!=null)
				{
					strValorActual=numeropatronal.getNumeroPatronalOriginal().getdescripcion();
				}
				if(numeropatronal.getdescripcion()!=null)
				{
					strValorNuevo=numeropatronal.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NumeroPatronalConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveNumeroPatronalRelacionesWithConnection(NumeroPatronal numeropatronal,List<DatoGeneralEmpleado> datogeneralempleados,List<Estructura> estructuras,List<Cargo> cargos) throws Exception {

		if(!numeropatronal.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveNumeroPatronalRelacionesBase(numeropatronal,datogeneralempleados,estructuras,cargos,true);
		}
	}

	public void saveNumeroPatronalRelaciones(NumeroPatronal numeropatronal,List<DatoGeneralEmpleado> datogeneralempleados,List<Estructura> estructuras,List<Cargo> cargos)throws Exception {

		if(!numeropatronal.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveNumeroPatronalRelacionesBase(numeropatronal,datogeneralempleados,estructuras,cargos,false);
		}
	}

	public void saveNumeroPatronalRelacionesBase(NumeroPatronal numeropatronal,List<DatoGeneralEmpleado> datogeneralempleados,List<Estructura> estructuras,List<Cargo> cargos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("NumeroPatronal-saveRelacionesWithConnection");}
	
			numeropatronal.setDatoGeneralEmpleados(datogeneralempleados);
			numeropatronal.setEstructuras(estructuras);
			numeropatronal.setCargos(cargos);

			this.setNumeroPatronal(numeropatronal);

			if(NumeroPatronalLogicAdditional.validarSaveRelaciones(numeropatronal,this)) {

				NumeroPatronalLogicAdditional.updateRelacionesToSave(numeropatronal,this);

				if((numeropatronal.getIsNew()||numeropatronal.getIsChanged())&&!numeropatronal.getIsDeleted()) {
					this.saveNumeroPatronal();
					this.saveNumeroPatronalRelacionesDetalles(datogeneralempleados,estructuras,cargos);

				} else if(numeropatronal.getIsDeleted()) {
					this.saveNumeroPatronalRelacionesDetalles(datogeneralempleados,estructuras,cargos);
					this.saveNumeroPatronal();
				}

				NumeroPatronalLogicAdditional.updateRelacionesToSaveAfter(numeropatronal,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DatoGeneralEmpleadoConstantesFunciones.InicializarGeneralEntityAuxiliaresDatoGeneralEmpleados(datogeneralempleados,true,true);
			EstructuraConstantesFunciones.InicializarGeneralEntityAuxiliaresEstructuras(estructuras,true,true);
			CargoConstantesFunciones.InicializarGeneralEntityAuxiliaresCargos(cargos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveNumeroPatronalRelacionesDetalles(List<DatoGeneralEmpleado> datogeneralempleados,List<Estructura> estructuras,List<Cargo> cargos)throws Exception {
		try {
	

			Long idNumeroPatronalActual=this.getNumeroPatronal().getId();

			DatoGeneralEmpleadoLogic datogeneralempleadoLogic_Desde_NumeroPatronal=new DatoGeneralEmpleadoLogic();
			datogeneralempleadoLogic_Desde_NumeroPatronal.setDatoGeneralEmpleados(datogeneralempleados);

			datogeneralempleadoLogic_Desde_NumeroPatronal.setConnexion(this.getConnexion());
			datogeneralempleadoLogic_Desde_NumeroPatronal.setDatosCliente(this.datosCliente);

			for(DatoGeneralEmpleado datogeneralempleado_Desde_NumeroPatronal:datogeneralempleadoLogic_Desde_NumeroPatronal.getDatoGeneralEmpleados()) {
				datogeneralempleado_Desde_NumeroPatronal.setid_numero_patronal(idNumeroPatronalActual);
			}

			datogeneralempleadoLogic_Desde_NumeroPatronal.saveDatoGeneralEmpleados();

			EstructuraLogic estructuraLogic_Desde_NumeroPatronal=new EstructuraLogic();
			estructuraLogic_Desde_NumeroPatronal.setEstructuras(estructuras);

			estructuraLogic_Desde_NumeroPatronal.setConnexion(this.getConnexion());
			estructuraLogic_Desde_NumeroPatronal.setDatosCliente(this.datosCliente);

			for(Estructura estructura_Desde_NumeroPatronal:estructuraLogic_Desde_NumeroPatronal.getEstructuras()) {
				estructura_Desde_NumeroPatronal.setid_numero_patronal(idNumeroPatronalActual);

				estructuraLogic_Desde_NumeroPatronal.setEstructura(estructura_Desde_NumeroPatronal);
				estructuraLogic_Desde_NumeroPatronal.saveEstructura();
			}


			CargoLogic cargoLogic_Desde_NumeroPatronal=new CargoLogic();
			cargoLogic_Desde_NumeroPatronal.setCargos(cargos);

			cargoLogic_Desde_NumeroPatronal.setConnexion(this.getConnexion());
			cargoLogic_Desde_NumeroPatronal.setDatosCliente(this.datosCliente);

			for(Cargo cargo_Desde_NumeroPatronal:cargoLogic_Desde_NumeroPatronal.getCargos()) {
				cargo_Desde_NumeroPatronal.setid_numero_patronal(idNumeroPatronalActual);

				cargoLogic_Desde_NumeroPatronal.setCargo(cargo_Desde_NumeroPatronal);
				cargoLogic_Desde_NumeroPatronal.saveCargo();

				Long idCargoActual=cargo_Desde_NumeroPatronal.getId();

				AsistenciaMensualLogic asistenciamensualLogic_Desde_Cargo=new AsistenciaMensualLogic();

				if(cargo_Desde_NumeroPatronal.getAsistenciaMensuals()==null){
					cargo_Desde_NumeroPatronal.setAsistenciaMensuals(new ArrayList<AsistenciaMensual>());
				}

				asistenciamensualLogic_Desde_Cargo.setAsistenciaMensuals(cargo_Desde_NumeroPatronal.getAsistenciaMensuals());

				asistenciamensualLogic_Desde_Cargo.setConnexion(this.getConnexion());
				asistenciamensualLogic_Desde_Cargo.setDatosCliente(this.datosCliente);

				for(AsistenciaMensual asistenciamensual_Desde_Cargo:asistenciamensualLogic_Desde_Cargo.getAsistenciaMensuals()) {
					asistenciamensual_Desde_Cargo.setid_cargo(idCargoActual);
				}

				asistenciamensualLogic_Desde_Cargo.saveAsistenciaMensuals();

				EmpleadoEstructuraLogic empleadoestructuraLogic_Desde_Cargo=new EmpleadoEstructuraLogic();

				if(cargo_Desde_NumeroPatronal.getEmpleadoEstructuras()==null){
					cargo_Desde_NumeroPatronal.setEmpleadoEstructuras(new ArrayList<EmpleadoEstructura>());
				}

				empleadoestructuraLogic_Desde_Cargo.setEmpleadoEstructuras(cargo_Desde_NumeroPatronal.getEmpleadoEstructuras());

				empleadoestructuraLogic_Desde_Cargo.setConnexion(this.getConnexion());
				empleadoestructuraLogic_Desde_Cargo.setDatosCliente(this.datosCliente);

				for(EmpleadoEstructura empleadoestructura_Desde_Cargo:empleadoestructuraLogic_Desde_Cargo.getEmpleadoEstructuras()) {
					empleadoestructura_Desde_Cargo.setid_cargo(idCargoActual);
				}

				empleadoestructuraLogic_Desde_Cargo.saveEmpleadoEstructuras();

				EmpleadoLogic empleadoLogic_Desde_Cargo=new EmpleadoLogic();

				if(cargo_Desde_NumeroPatronal.getEmpleados()==null){
					cargo_Desde_NumeroPatronal.setEmpleados(new ArrayList<Empleado>());
				}

				empleadoLogic_Desde_Cargo.setEmpleados(cargo_Desde_NumeroPatronal.getEmpleados());

				empleadoLogic_Desde_Cargo.setConnexion(this.getConnexion());
				empleadoLogic_Desde_Cargo.setDatosCliente(this.datosCliente);

				for(Empleado empleado_Desde_Cargo:empleadoLogic_Desde_Cargo.getEmpleados()) {
					empleado_Desde_Cargo.setid_cargo(idCargoActual);

					empleadoLogic_Desde_Cargo.setEmpleado(empleado_Desde_Cargo);
					empleadoLogic_Desde_Cargo.saveEmpleado();
				}


				CargoLogic cargoLogicHijos_Desde_Cargo=new CargoLogic();

				if(cargo_Desde_NumeroPatronal.getCargos()==null){
					cargo_Desde_NumeroPatronal.setCargos(new ArrayList<Cargo>());
				}

				cargoLogicHijos_Desde_Cargo.setCargos(cargo_Desde_NumeroPatronal.getCargos());

				cargoLogicHijos_Desde_Cargo.setConnexion(this.getConnexion());
				cargoLogicHijos_Desde_Cargo.setDatosCliente(this.datosCliente);

				for(Cargo cargoHijos_Desde_Cargo:cargoLogicHijos_Desde_Cargo.getCargos()) {
					cargoHijos_Desde_Cargo.setid_cargo(idCargoActual);

					cargoLogicHijos_Desde_Cargo.setCargo(cargoHijos_Desde_Cargo);
					cargoLogicHijos_Desde_Cargo.saveCargo();
				}

			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfNumeroPatronal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=NumeroPatronalConstantesFunciones.getClassesForeignKeysOfNumeroPatronal(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfNumeroPatronal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=NumeroPatronalConstantesFunciones.getClassesRelationshipsOfNumeroPatronal(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
