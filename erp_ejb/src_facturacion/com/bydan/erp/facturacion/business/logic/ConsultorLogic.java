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
package com.bydan.erp.facturacion.business.logic;

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
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.facturacion.util.ConsultorConstantesFunciones;
import com.bydan.erp.facturacion.util.ConsultorParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.ConsultorParameterGeneral;
import com.bydan.erp.facturacion.business.entity.Consultor;
import com.bydan.erp.facturacion.business.logic.ConsultorLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.importaciones.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.importaciones.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;








@SuppressWarnings("unused")
public class ConsultorLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ConsultorLogic.class);
	
	protected ConsultorDataAccess consultorDataAccess; 	
	protected Consultor consultor;
	protected List<Consultor> consultors;
	protected Object consultorObject;	
	protected List<Object> consultorsObject;
	
	public static ClassValidator<Consultor> consultorValidator = new ClassValidator<Consultor>(Consultor.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ConsultorLogicAdditional consultorLogicAdditional=null;
	
	public ConsultorLogicAdditional getConsultorLogicAdditional() {
		return this.consultorLogicAdditional;
	}
	
	public void setConsultorLogicAdditional(ConsultorLogicAdditional consultorLogicAdditional) {
		try {
			this.consultorLogicAdditional=consultorLogicAdditional;
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
	
	
	
	
	public  ConsultorLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.consultorDataAccess = new ConsultorDataAccess();
			
			this.consultors= new ArrayList<Consultor>();
			this.consultor= new Consultor();
			
			this.consultorObject=new Object();
			this.consultorsObject=new ArrayList<Object>();
				
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
			
			this.consultorDataAccess.setConnexionType(this.connexionType);
			this.consultorDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ConsultorLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.consultorDataAccess = new ConsultorDataAccess();
			this.consultors= new ArrayList<Consultor>();
			this.consultor= new Consultor();
			this.consultorObject=new Object();
			this.consultorsObject=new ArrayList<Object>();
			
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
			
			this.consultorDataAccess.setConnexionType(this.connexionType);
			this.consultorDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Consultor getConsultor() throws Exception {	
		ConsultorLogicAdditional.checkConsultorToGet(consultor,this.datosCliente,this.arrDatoGeneral);
		ConsultorLogicAdditional.updateConsultorToGet(consultor,this.arrDatoGeneral);
		
		return consultor;
	}
		
	public void setConsultor(Consultor newConsultor) {
		this.consultor = newConsultor;
	}
	
	public ConsultorDataAccess getConsultorDataAccess() {
		return consultorDataAccess;
	}
	
	public void setConsultorDataAccess(ConsultorDataAccess newconsultorDataAccess) {
		this.consultorDataAccess = newconsultorDataAccess;
	}
	
	public List<Consultor> getConsultors() throws Exception {		
		this.quitarConsultorsNulos();
		
		ConsultorLogicAdditional.checkConsultorToGets(consultors,this.datosCliente,this.arrDatoGeneral);
		
		for (Consultor consultorLocal: consultors ) {
			ConsultorLogicAdditional.updateConsultorToGet(consultorLocal,this.arrDatoGeneral);
		}
		
		return consultors;
	}
	
	public void setConsultors(List<Consultor> newConsultors) {
		this.consultors = newConsultors;
	}
	
	public Object getConsultorObject() {	
		this.consultorObject=this.consultorDataAccess.getEntityObject();
		return this.consultorObject;
	}
		
	public void setConsultorObject(Object newConsultorObject) {
		this.consultorObject = newConsultorObject;
	}
	
	public List<Object> getConsultorsObject() {		
		this.consultorsObject=this.consultorDataAccess.getEntitiesObject();
		return this.consultorsObject;
	}
		
	public void setConsultorsObject(List<Object> newConsultorsObject) {
		this.consultorsObject = newConsultorsObject;
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
		
		if(this.consultorDataAccess!=null) {
			this.consultorDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consultor.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			consultorDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			consultorDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		consultor = new  Consultor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consultor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			consultor=consultorDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.consultor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConsultorConstantesFunciones.refrescarForeignKeysDescripcionesConsultor(this.consultor);
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
		consultor = new  Consultor();
		  		  
        try {
			
			consultor=consultorDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.consultor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConsultorConstantesFunciones.refrescarForeignKeysDescripcionesConsultor(this.consultor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		consultor = new  Consultor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consultor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			consultor=consultorDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.consultor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConsultorConstantesFunciones.refrescarForeignKeysDescripcionesConsultor(this.consultor);
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
		consultor = new  Consultor();
		  		  
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
		consultor = new  Consultor();
		  		  
        try {
			
			consultor=consultorDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.consultor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConsultorConstantesFunciones.refrescarForeignKeysDescripcionesConsultor(this.consultor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		consultor = new  Consultor();
		  		  
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
		consultor = new  Consultor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consultor.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =consultorDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		consultor = new  Consultor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=consultorDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		consultor = new  Consultor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consultor.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =consultorDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		consultor = new  Consultor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=consultorDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		consultor = new  Consultor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consultor.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =consultorDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		consultor = new  Consultor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=consultorDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		consultors = new  ArrayList<Consultor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consultor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ConsultorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consultors=consultorDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConsultor(consultors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsultorConstantesFunciones.refrescarForeignKeysDescripcionesConsultor(this.consultors);
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
		consultors = new  ArrayList<Consultor>();
		  		  
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
		consultors = new  ArrayList<Consultor>();
		  		  
        try {			
			ConsultorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consultors=consultorDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarConsultor(consultors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsultorConstantesFunciones.refrescarForeignKeysDescripcionesConsultor(this.consultors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		consultors = new  ArrayList<Consultor>();
		  		  
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
		consultors = new  ArrayList<Consultor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consultor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ConsultorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consultors=consultorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConsultor(consultors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsultorConstantesFunciones.refrescarForeignKeysDescripcionesConsultor(this.consultors);
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
		consultors = new  ArrayList<Consultor>();
		  		  
        try {
			ConsultorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consultors=consultorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConsultor(consultors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsultorConstantesFunciones.refrescarForeignKeysDescripcionesConsultor(this.consultors);
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
		consultors = new  ArrayList<Consultor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consultor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConsultorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consultors=consultorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConsultor(consultors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsultorConstantesFunciones.refrescarForeignKeysDescripcionesConsultor(this.consultors);
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
		consultors = new  ArrayList<Consultor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConsultorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consultors=consultorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConsultor(consultors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsultorConstantesFunciones.refrescarForeignKeysDescripcionesConsultor(this.consultors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		consultor = new  Consultor();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consultor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConsultorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consultor=consultorDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConsultor(consultor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsultorConstantesFunciones.refrescarForeignKeysDescripcionesConsultor(this.consultor);
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
		consultor = new  Consultor();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConsultorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consultor=consultorDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConsultor(consultor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsultorConstantesFunciones.refrescarForeignKeysDescripcionesConsultor(this.consultor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		consultors = new  ArrayList<Consultor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consultor.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ConsultorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consultors=consultorDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConsultor(consultors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsultorConstantesFunciones.refrescarForeignKeysDescripcionesConsultor(this.consultors);
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
		consultors = new  ArrayList<Consultor>();
		  		  
        try {
			ConsultorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consultors=consultorDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConsultor(consultors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsultorConstantesFunciones.refrescarForeignKeysDescripcionesConsultor(this.consultors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosConsultorsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		consultors = new  ArrayList<Consultor>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consultor.class.getSimpleName()+"-getTodosConsultorsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConsultorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consultors=consultorDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarConsultor(consultors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsultorConstantesFunciones.refrescarForeignKeysDescripcionesConsultor(this.consultors);
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
	
	public  void  getTodosConsultors(String sFinalQuery,Pagination pagination)throws Exception {
		consultors = new  ArrayList<Consultor>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConsultorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			consultors=consultorDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarConsultor(consultors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConsultorConstantesFunciones.refrescarForeignKeysDescripcionesConsultor(this.consultors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarConsultor(Consultor consultor) throws Exception {
		Boolean estaValidado=false;
		
		if(consultor.getIsNew() || consultor.getIsChanged()) { 
			this.invalidValues = consultorValidator.getInvalidValues(consultor);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(consultor);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarConsultor(List<Consultor> Consultors) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Consultor consultorLocal:consultors) {				
			estaValidadoObjeto=this.validarGuardarConsultor(consultorLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarConsultor(List<Consultor> Consultors) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarConsultor(consultors)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarConsultor(Consultor Consultor) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarConsultor(consultor)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Consultor consultor) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+consultor.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ConsultorConstantesFunciones.getConsultorLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"consultor","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ConsultorConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ConsultorConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveConsultorWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consultor.class.getSimpleName()+"-saveConsultorWithConnection");connexion.begin();			
			
			ConsultorLogicAdditional.checkConsultorToSave(this.consultor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ConsultorLogicAdditional.updateConsultorToSave(this.consultor,this.arrDatoGeneral);
			
			ConsultorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.consultor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowConsultor();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarConsultor(this.consultor)) {
				ConsultorDataAccess.save(this.consultor, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.consultor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ConsultorLogicAdditional.checkConsultorToSaveAfter(this.consultor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowConsultor();
			
			connexion.commit();			
			
			if(this.consultor.getIsDeleted()) {
				this.consultor=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveConsultor()throws Exception {	
		try {	
			
			ConsultorLogicAdditional.checkConsultorToSave(this.consultor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ConsultorLogicAdditional.updateConsultorToSave(this.consultor,this.arrDatoGeneral);
			
			ConsultorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.consultor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarConsultor(this.consultor)) {			
				ConsultorDataAccess.save(this.consultor, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.consultor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ConsultorLogicAdditional.checkConsultorToSaveAfter(this.consultor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.consultor.getIsDeleted()) {
				this.consultor=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveConsultorsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consultor.class.getSimpleName()+"-saveConsultorsWithConnection");connexion.begin();			
			
			ConsultorLogicAdditional.checkConsultorToSaves(consultors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowConsultors();
			
			Boolean validadoTodosConsultor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Consultor consultorLocal:consultors) {		
				if(consultorLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ConsultorLogicAdditional.updateConsultorToSave(consultorLocal,this.arrDatoGeneral);
	        	
				ConsultorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),consultorLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarConsultor(consultorLocal)) {
					ConsultorDataAccess.save(consultorLocal, connexion);				
				} else {
					validadoTodosConsultor=false;
				}
			}
			
			if(!validadoTodosConsultor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ConsultorLogicAdditional.checkConsultorToSavesAfter(consultors,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowConsultors();
			
			connexion.commit();		
			
			this.quitarConsultorsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveConsultors()throws Exception {				
		 try {	
			ConsultorLogicAdditional.checkConsultorToSaves(consultors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosConsultor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Consultor consultorLocal:consultors) {				
				if(consultorLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ConsultorLogicAdditional.updateConsultorToSave(consultorLocal,this.arrDatoGeneral);
	        	
				ConsultorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),consultorLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarConsultor(consultorLocal)) {				
					ConsultorDataAccess.save(consultorLocal, connexion);				
				} else {
					validadoTodosConsultor=false;
				}
			}
			
			if(!validadoTodosConsultor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ConsultorLogicAdditional.checkConsultorToSavesAfter(consultors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarConsultorsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ConsultorParameterReturnGeneral procesarAccionConsultors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Consultor> consultors,ConsultorParameterReturnGeneral consultorParameterGeneral)throws Exception {
		 try {	
			ConsultorParameterReturnGeneral consultorReturnGeneral=new ConsultorParameterReturnGeneral();
	
			ConsultorLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,consultors,consultorParameterGeneral,consultorReturnGeneral);
			
			return consultorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ConsultorParameterReturnGeneral procesarAccionConsultorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Consultor> consultors,ConsultorParameterReturnGeneral consultorParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consultor.class.getSimpleName()+"-procesarAccionConsultorsWithConnection");connexion.begin();			
			
			ConsultorParameterReturnGeneral consultorReturnGeneral=new ConsultorParameterReturnGeneral();
	
			ConsultorLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,consultors,consultorParameterGeneral,consultorReturnGeneral);
			
			this.connexion.commit();
			
			return consultorReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ConsultorParameterReturnGeneral procesarEventosConsultors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Consultor> consultors,Consultor consultor,ConsultorParameterReturnGeneral consultorParameterGeneral,Boolean isEsNuevoConsultor,ArrayList<Classe> clases)throws Exception {
		 try {	
			ConsultorParameterReturnGeneral consultorReturnGeneral=new ConsultorParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				consultorReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ConsultorLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,consultors,consultor,consultorParameterGeneral,consultorReturnGeneral,isEsNuevoConsultor,clases);
			
			return consultorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ConsultorParameterReturnGeneral procesarEventosConsultorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Consultor> consultors,Consultor consultor,ConsultorParameterReturnGeneral consultorParameterGeneral,Boolean isEsNuevoConsultor,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consultor.class.getSimpleName()+"-procesarEventosConsultorsWithConnection");connexion.begin();			
			
			ConsultorParameterReturnGeneral consultorReturnGeneral=new ConsultorParameterReturnGeneral();
	
			consultorReturnGeneral.setConsultor(consultor);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				consultorReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ConsultorLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,consultors,consultor,consultorParameterGeneral,consultorReturnGeneral,isEsNuevoConsultor,clases);
			
			this.connexion.commit();
			
			return consultorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ConsultorParameterReturnGeneral procesarImportacionConsultorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ConsultorParameterReturnGeneral consultorParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consultor.class.getSimpleName()+"-procesarImportacionConsultorsWithConnection");connexion.begin();			
			
			ConsultorParameterReturnGeneral consultorReturnGeneral=new ConsultorParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.consultors=new ArrayList<Consultor>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.consultor=new Consultor();
				
				
				if(conColumnasBase) {this.consultor.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.consultor.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.consultor.setidentificacion(arrColumnas[iColumn++]);
				this.consultor.setapellido(arrColumnas[iColumn++]);
				this.consultor.setnombre(arrColumnas[iColumn++]);
				this.consultor.setnombre_completo(arrColumnas[iColumn++]);
				this.consultor.settelefono(arrColumnas[iColumn++]);
			this.consultor.sete_mail(arrColumnas[iColumn++]);
			this.consultor.setdireccion(arrColumnas[iColumn++]);
			this.consultor.setdescripcion(arrColumnas[iColumn++]);
				
				this.consultors.add(this.consultor);
			}
			
			this.saveConsultors();
			
			this.connexion.commit();
			
			consultorReturnGeneral.setConRetornoEstaProcesado(true);
			consultorReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return consultorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarConsultorsEliminados() throws Exception {				
		
		List<Consultor> consultorsAux= new ArrayList<Consultor>();
		
		for(Consultor consultor:consultors) {
			if(!consultor.getIsDeleted()) {
				consultorsAux.add(consultor);
			}
		}
		
		consultors=consultorsAux;
	}
	
	public void quitarConsultorsNulos() throws Exception {				
		
		List<Consultor> consultorsAux= new ArrayList<Consultor>();
		
		for(Consultor consultor : this.consultors) {
			if(consultor==null) {
				consultorsAux.add(consultor);
			}
		}
		
		//this.consultors=consultorsAux;
		
		this.consultors.removeAll(consultorsAux);
	}
	
	public void getSetVersionRowConsultorWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(consultor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((consultor.getIsDeleted() || (consultor.getIsChanged()&&!consultor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=consultorDataAccess.getSetVersionRowConsultor(connexion,consultor.getId());
				
				if(!consultor.getVersionRow().equals(timestamp)) {	
					consultor.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				consultor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowConsultor()throws Exception {	
		
		if(consultor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((consultor.getIsDeleted() || (consultor.getIsChanged()&&!consultor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=consultorDataAccess.getSetVersionRowConsultor(connexion,consultor.getId());
			
			try {							
				if(!consultor.getVersionRow().equals(timestamp)) {	
					consultor.setVersionRow(timestamp);
				}
				
				consultor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowConsultorsWithConnection()throws Exception {	
		if(consultors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Consultor consultorAux:consultors) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(consultorAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(consultorAux.getIsDeleted() || (consultorAux.getIsChanged()&&!consultorAux.getIsNew())) {
						
						timestamp=consultorDataAccess.getSetVersionRowConsultor(connexion,consultorAux.getId());
						
						if(!consultor.getVersionRow().equals(timestamp)) {	
							consultorAux.setVersionRow(timestamp);
						}
								
						consultorAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowConsultors()throws Exception {	
		if(consultors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Consultor consultorAux:consultors) {
					if(consultorAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(consultorAux.getIsDeleted() || (consultorAux.getIsChanged()&&!consultorAux.getIsNew())) {
						
						timestamp=consultorDataAccess.getSetVersionRowConsultor(connexion,consultorAux.getId());
						
						if(!consultorAux.getVersionRow().equals(timestamp)) {	
							consultorAux.setVersionRow(timestamp);
						}
						
													
						consultorAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ConsultorParameterReturnGeneral cargarCombosLoteForeignKeyConsultorWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		ConsultorParameterReturnGeneral  consultorReturnGeneral =new ConsultorParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consultor.class.getSimpleName()+"-cargarCombosLoteForeignKeyConsultorWithConnection");connexion.begin();
			
			consultorReturnGeneral =new ConsultorParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			consultorReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return consultorReturnGeneral;
	}
	
	public ConsultorParameterReturnGeneral cargarCombosLoteForeignKeyConsultor(String finalQueryGlobalEmpresa) throws Exception {
		ConsultorParameterReturnGeneral  consultorReturnGeneral =new ConsultorParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			consultorReturnGeneral =new ConsultorParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			consultorReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return consultorReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyConsultorWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			GuiaRemisionLogic guiaremisionLogic=new GuiaRemisionLogic();
			PedidoExporLogic pedidoexporLogic=new PedidoExporLogic();
			PedidoLogic pedidoLogic=new PedidoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consultor.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyConsultorWithConnection");connexion.begin();
			
			
			classes.add(new Classe(GuiaRemision.class));
			classes.add(new Classe(PedidoExpor.class));
			classes.add(new Classe(Pedido.class));
											
			

			guiaremisionLogic.setConnexion(this.getConnexion());
			guiaremisionLogic.setDatosCliente(this.datosCliente);
			guiaremisionLogic.setIsConRefrescarForeignKeys(true);

			pedidoexporLogic.setConnexion(this.getConnexion());
			pedidoexporLogic.setDatosCliente(this.datosCliente);
			pedidoexporLogic.setIsConRefrescarForeignKeys(true);

			pedidoLogic.setConnexion(this.getConnexion());
			pedidoLogic.setDatosCliente(this.datosCliente);
			pedidoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Consultor consultor:this.consultors) {
				

				classes=new ArrayList<Classe>();
				classes=GuiaRemisionConstantesFunciones.getClassesForeignKeysOfGuiaRemision(new ArrayList<Classe>(),DeepLoadType.NONE);

				guiaremisionLogic.setGuiaRemisions(consultor.guiaremisions);
				guiaremisionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PedidoExporConstantesFunciones.getClassesForeignKeysOfPedidoExpor(new ArrayList<Classe>(),DeepLoadType.NONE);

				pedidoexporLogic.setPedidoExpors(consultor.pedidoexpors);
				pedidoexporLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PedidoConstantesFunciones.getClassesForeignKeysOfPedido(new ArrayList<Classe>(),DeepLoadType.NONE);

				pedidoLogic.setPedidos(consultor.pedidos);
				pedidoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Consultor consultor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ConsultorLogicAdditional.updateConsultorToGet(consultor,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		consultor.setEmpresa(consultorDataAccess.getEmpresa(connexion,consultor));
		consultor.setGuiaRemisions(consultorDataAccess.getGuiaRemisions(connexion,consultor));
		consultor.setPedidoExpors(consultorDataAccess.getPedidoExpors(connexion,consultor));
		consultor.setPedidos(consultorDataAccess.getPedidos(connexion,consultor));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				consultor.setEmpresa(consultorDataAccess.getEmpresa(connexion,consultor));
				continue;
			}

			if(clas.clas.equals(GuiaRemision.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				consultor.setGuiaRemisions(consultorDataAccess.getGuiaRemisions(connexion,consultor));

				if(this.isConDeep) {
					GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(this.connexion);
					guiaremisionLogic.setGuiaRemisions(consultor.getGuiaRemisions());
					ArrayList<Classe> classesLocal=GuiaRemisionConstantesFunciones.getClassesForeignKeysOfGuiaRemision(new ArrayList<Classe>(),DeepLoadType.NONE);
					guiaremisionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					GuiaRemisionConstantesFunciones.refrescarForeignKeysDescripcionesGuiaRemision(guiaremisionLogic.getGuiaRemisions());
					consultor.setGuiaRemisions(guiaremisionLogic.getGuiaRemisions());
				}

				continue;
			}

			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				consultor.setPedidoExpors(consultorDataAccess.getPedidoExpors(connexion,consultor));

				if(this.isConDeep) {
					PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(this.connexion);
					pedidoexporLogic.setPedidoExpors(consultor.getPedidoExpors());
					ArrayList<Classe> classesLocal=PedidoExporConstantesFunciones.getClassesForeignKeysOfPedidoExpor(new ArrayList<Classe>(),DeepLoadType.NONE);
					pedidoexporLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(pedidoexporLogic.getPedidoExpors());
					consultor.setPedidoExpors(pedidoexporLogic.getPedidoExpors());
				}

				continue;
			}

			if(clas.clas.equals(Pedido.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				consultor.setPedidos(consultorDataAccess.getPedidos(connexion,consultor));

				if(this.isConDeep) {
					PedidoLogic pedidoLogic= new PedidoLogic(this.connexion);
					pedidoLogic.setPedidos(consultor.getPedidos());
					ArrayList<Classe> classesLocal=PedidoConstantesFunciones.getClassesForeignKeysOfPedido(new ArrayList<Classe>(),DeepLoadType.NONE);
					pedidoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PedidoConstantesFunciones.refrescarForeignKeysDescripcionesPedido(pedidoLogic.getPedidos());
					consultor.setPedidos(pedidoLogic.getPedidos());
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
			consultor.setEmpresa(consultorDataAccess.getEmpresa(connexion,consultor));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GuiaRemision.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(GuiaRemision.class));
			consultor.setGuiaRemisions(consultorDataAccess.getGuiaRemisions(connexion,consultor));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoExpor.class));
			consultor.setPedidoExpors(consultorDataAccess.getPedidoExpors(connexion,consultor));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pedido.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Pedido.class));
			consultor.setPedidos(consultorDataAccess.getPedidos(connexion,consultor));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		consultor.setEmpresa(consultorDataAccess.getEmpresa(connexion,consultor));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(consultor.getEmpresa(),isDeep,deepLoadType,clases);
				

		consultor.setGuiaRemisions(consultorDataAccess.getGuiaRemisions(connexion,consultor));

		for(GuiaRemision guiaremision:consultor.getGuiaRemisions()) {
			GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(connexion);
			guiaremisionLogic.deepLoad(guiaremision,isDeep,deepLoadType,clases);
		}

		consultor.setPedidoExpors(consultorDataAccess.getPedidoExpors(connexion,consultor));

		for(PedidoExpor pedidoexpor:consultor.getPedidoExpors()) {
			PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
			pedidoexporLogic.deepLoad(pedidoexpor,isDeep,deepLoadType,clases);
		}

		consultor.setPedidos(consultorDataAccess.getPedidos(connexion,consultor));

		for(Pedido pedido:consultor.getPedidos()) {
			PedidoLogic pedidoLogic= new PedidoLogic(connexion);
			pedidoLogic.deepLoad(pedido,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				consultor.setEmpresa(consultorDataAccess.getEmpresa(connexion,consultor));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(consultor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(GuiaRemision.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				consultor.setGuiaRemisions(consultorDataAccess.getGuiaRemisions(connexion,consultor));

				for(GuiaRemision guiaremision:consultor.getGuiaRemisions()) {
					GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(connexion);
					guiaremisionLogic.deepLoad(guiaremision,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				consultor.setPedidoExpors(consultorDataAccess.getPedidoExpors(connexion,consultor));

				for(PedidoExpor pedidoexpor:consultor.getPedidoExpors()) {
					PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
					pedidoexporLogic.deepLoad(pedidoexpor,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Pedido.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				consultor.setPedidos(consultorDataAccess.getPedidos(connexion,consultor));

				for(Pedido pedido:consultor.getPedidos()) {
					PedidoLogic pedidoLogic= new PedidoLogic(connexion);
					pedidoLogic.deepLoad(pedido,isDeep,deepLoadType,clases);
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
			consultor.setEmpresa(consultorDataAccess.getEmpresa(connexion,consultor));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(consultor.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GuiaRemision.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(GuiaRemision.class));
			consultor.setGuiaRemisions(consultorDataAccess.getGuiaRemisions(connexion,consultor));

			for(GuiaRemision guiaremision:consultor.getGuiaRemisions()) {
				GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(connexion);
				guiaremisionLogic.deepLoad(guiaremision,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoExpor.class));
			consultor.setPedidoExpors(consultorDataAccess.getPedidoExpors(connexion,consultor));

			for(PedidoExpor pedidoexpor:consultor.getPedidoExpors()) {
				PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
				pedidoexporLogic.deepLoad(pedidoexpor,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pedido.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Pedido.class));
			consultor.setPedidos(consultorDataAccess.getPedidos(connexion,consultor));

			for(Pedido pedido:consultor.getPedidos()) {
				PedidoLogic pedidoLogic= new PedidoLogic(connexion);
				pedidoLogic.deepLoad(pedido,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Consultor consultor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ConsultorLogicAdditional.updateConsultorToSave(consultor,this.arrDatoGeneral);
			
ConsultorDataAccess.save(consultor, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(consultor.getEmpresa(),connexion);

		for(GuiaRemision guiaremision:consultor.getGuiaRemisions()) {
			guiaremision.setid_consultor(consultor.getId());
			GuiaRemisionDataAccess.save(guiaremision,connexion);
		}

		for(PedidoExpor pedidoexpor:consultor.getPedidoExpors()) {
			pedidoexpor.setid_consultor(consultor.getId());
			PedidoExporDataAccess.save(pedidoexpor,connexion);
		}

		for(Pedido pedido:consultor.getPedidos()) {
			pedido.setid_consultor(consultor.getId());
			PedidoDataAccess.save(pedido,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(consultor.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(GuiaRemision.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(GuiaRemision guiaremision:consultor.getGuiaRemisions()) {
					guiaremision.setid_consultor(consultor.getId());
					GuiaRemisionDataAccess.save(guiaremision,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PedidoExpor pedidoexpor:consultor.getPedidoExpors()) {
					pedidoexpor.setid_consultor(consultor.getId());
					PedidoExporDataAccess.save(pedidoexpor,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Pedido.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Pedido pedido:consultor.getPedidos()) {
					pedido.setid_consultor(consultor.getId());
					PedidoDataAccess.save(pedido,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(consultor.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(consultor.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(GuiaRemision guiaremision:consultor.getGuiaRemisions()) {
			GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(connexion);
			guiaremision.setid_consultor(consultor.getId());
			GuiaRemisionDataAccess.save(guiaremision,connexion);
			guiaremisionLogic.deepSave(guiaremision,isDeep,deepLoadType,clases);
		}

		for(PedidoExpor pedidoexpor:consultor.getPedidoExpors()) {
			PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
			pedidoexpor.setid_consultor(consultor.getId());
			PedidoExporDataAccess.save(pedidoexpor,connexion);
			pedidoexporLogic.deepSave(pedidoexpor,isDeep,deepLoadType,clases);
		}

		for(Pedido pedido:consultor.getPedidos()) {
			PedidoLogic pedidoLogic= new PedidoLogic(connexion);
			pedido.setid_consultor(consultor.getId());
			PedidoDataAccess.save(pedido,connexion);
			pedidoLogic.deepSave(pedido,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(consultor.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(consultor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(GuiaRemision.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(GuiaRemision guiaremision:consultor.getGuiaRemisions()) {
					GuiaRemisionLogic guiaremisionLogic= new GuiaRemisionLogic(connexion);
					guiaremision.setid_consultor(consultor.getId());
					GuiaRemisionDataAccess.save(guiaremision,connexion);
					guiaremisionLogic.deepSave(guiaremision,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PedidoExpor pedidoexpor:consultor.getPedidoExpors()) {
					PedidoExporLogic pedidoexporLogic= new PedidoExporLogic(connexion);
					pedidoexpor.setid_consultor(consultor.getId());
					PedidoExporDataAccess.save(pedidoexpor,connexion);
					pedidoexporLogic.deepSave(pedidoexpor,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Pedido.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Pedido pedido:consultor.getPedidos()) {
					PedidoLogic pedidoLogic= new PedidoLogic(connexion);
					pedido.setid_consultor(consultor.getId());
					PedidoDataAccess.save(pedido,connexion);
					pedidoLogic.deepSave(pedido,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Consultor.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(consultor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ConsultorConstantesFunciones.refrescarForeignKeysDescripcionesConsultor(consultor);
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
			this.deepLoad(this.consultor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ConsultorConstantesFunciones.refrescarForeignKeysDescripcionesConsultor(this.consultor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Consultor.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(consultors!=null) {
				for(Consultor consultor:consultors) {
					this.deepLoad(consultor,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ConsultorConstantesFunciones.refrescarForeignKeysDescripcionesConsultor(consultors);
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
			if(consultors!=null) {
				for(Consultor consultor:consultors) {
					this.deepLoad(consultor,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ConsultorConstantesFunciones.refrescarForeignKeysDescripcionesConsultor(consultors);
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
			this.getNewConnexionToDeep(Consultor.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(consultor,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Consultor.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(consultors!=null) {
				for(Consultor consultor:consultors) {
					this.deepSave(consultor,isDeep,deepLoadType,clases);
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
			if(consultors!=null) {
				for(Consultor consultor:consultors) {
					this.deepSave(consultor,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getConsultorsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Consultor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ConsultorConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ConsultorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consultors=consultorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsultorConstantesFunciones.refrescarForeignKeysDescripcionesConsultor(this.consultors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConsultorsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ConsultorConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ConsultorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			consultors=consultorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConsultorConstantesFunciones.refrescarForeignKeysDescripcionesConsultor(this.consultors);
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
			if(ConsultorConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ConsultorDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Consultor consultor,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ConsultorConstantesFunciones.ISCONAUDITORIA) {
				if(consultor.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ConsultorDataAccess.TABLENAME, consultor.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ConsultorConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ConsultorLogic.registrarAuditoriaDetallesConsultor(connexion,consultor,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(consultor.getIsDeleted()) {
					/*if(!consultor.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ConsultorDataAccess.TABLENAME, consultor.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ConsultorLogic.registrarAuditoriaDetallesConsultor(connexion,consultor,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ConsultorDataAccess.TABLENAME, consultor.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(consultor.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ConsultorDataAccess.TABLENAME, consultor.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ConsultorConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ConsultorLogic.registrarAuditoriaDetallesConsultor(connexion,consultor,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesConsultor(Connexion connexion,Consultor consultor)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(consultor.getIsNew()||!consultor.getid_empresa().equals(consultor.getConsultorOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consultor.getConsultorOriginal().getid_empresa()!=null)
				{
					strValorActual=consultor.getConsultorOriginal().getid_empresa().toString();
				}
				if(consultor.getid_empresa()!=null)
				{
					strValorNuevo=consultor.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsultorConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(consultor.getIsNew()||!consultor.getidentificacion().equals(consultor.getConsultorOriginal().getidentificacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consultor.getConsultorOriginal().getidentificacion()!=null)
				{
					strValorActual=consultor.getConsultorOriginal().getidentificacion();
				}
				if(consultor.getidentificacion()!=null)
				{
					strValorNuevo=consultor.getidentificacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsultorConstantesFunciones.IDENTIFICACION,strValorActual,strValorNuevo);
			}	
			
			if(consultor.getIsNew()||!consultor.getapellido().equals(consultor.getConsultorOriginal().getapellido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consultor.getConsultorOriginal().getapellido()!=null)
				{
					strValorActual=consultor.getConsultorOriginal().getapellido();
				}
				if(consultor.getapellido()!=null)
				{
					strValorNuevo=consultor.getapellido() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsultorConstantesFunciones.APELLIDO,strValorActual,strValorNuevo);
			}	
			
			if(consultor.getIsNew()||!consultor.getnombre().equals(consultor.getConsultorOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consultor.getConsultorOriginal().getnombre()!=null)
				{
					strValorActual=consultor.getConsultorOriginal().getnombre();
				}
				if(consultor.getnombre()!=null)
				{
					strValorNuevo=consultor.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsultorConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(consultor.getIsNew()||!consultor.getnombre_completo().equals(consultor.getConsultorOriginal().getnombre_completo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consultor.getConsultorOriginal().getnombre_completo()!=null)
				{
					strValorActual=consultor.getConsultorOriginal().getnombre_completo();
				}
				if(consultor.getnombre_completo()!=null)
				{
					strValorNuevo=consultor.getnombre_completo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsultorConstantesFunciones.NOMBRECOMPLETO,strValorActual,strValorNuevo);
			}	
			
			if(consultor.getIsNew()||!consultor.gettelefono().equals(consultor.getConsultorOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consultor.getConsultorOriginal().gettelefono()!=null)
				{
					strValorActual=consultor.getConsultorOriginal().gettelefono();
				}
				if(consultor.gettelefono()!=null)
				{
					strValorNuevo=consultor.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsultorConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
			
			if(consultor.getIsNew()||!consultor.gete_mail().equals(consultor.getConsultorOriginal().gete_mail()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consultor.getConsultorOriginal().gete_mail()!=null)
				{
					strValorActual=consultor.getConsultorOriginal().gete_mail();
				}
				if(consultor.gete_mail()!=null)
				{
					strValorNuevo=consultor.gete_mail() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsultorConstantesFunciones.EMAIL,strValorActual,strValorNuevo);
			}	
			
			if(consultor.getIsNew()||!consultor.getdireccion().equals(consultor.getConsultorOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consultor.getConsultorOriginal().getdireccion()!=null)
				{
					strValorActual=consultor.getConsultorOriginal().getdireccion();
				}
				if(consultor.getdireccion()!=null)
				{
					strValorNuevo=consultor.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsultorConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(consultor.getIsNew()||!consultor.getdescripcion().equals(consultor.getConsultorOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(consultor.getConsultorOriginal().getdescripcion()!=null)
				{
					strValorActual=consultor.getConsultorOriginal().getdescripcion();
				}
				if(consultor.getdescripcion()!=null)
				{
					strValorNuevo=consultor.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConsultorConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveConsultorRelacionesWithConnection(Consultor consultor,List<GuiaRemision> guiaremisions,List<PedidoExpor> pedidoexpors,List<Pedido> pedidos) throws Exception {

		if(!consultor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveConsultorRelacionesBase(consultor,guiaremisions,pedidoexpors,pedidos,true);
		}
	}

	public void saveConsultorRelaciones(Consultor consultor,List<GuiaRemision> guiaremisions,List<PedidoExpor> pedidoexpors,List<Pedido> pedidos)throws Exception {

		if(!consultor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveConsultorRelacionesBase(consultor,guiaremisions,pedidoexpors,pedidos,false);
		}
	}

	public void saveConsultorRelacionesBase(Consultor consultor,List<GuiaRemision> guiaremisions,List<PedidoExpor> pedidoexpors,List<Pedido> pedidos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Consultor-saveRelacionesWithConnection");}
	
			consultor.setGuiaRemisions(guiaremisions);
			consultor.setPedidoExpors(pedidoexpors);
			consultor.setPedidos(pedidos);

			this.setConsultor(consultor);

			if(ConsultorLogicAdditional.validarSaveRelaciones(consultor,this)) {

				ConsultorLogicAdditional.updateRelacionesToSave(consultor,this);

				if((consultor.getIsNew()||consultor.getIsChanged())&&!consultor.getIsDeleted()) {
					this.saveConsultor();
					this.saveConsultorRelacionesDetalles(guiaremisions,pedidoexpors,pedidos);

				} else if(consultor.getIsDeleted()) {
					this.saveConsultorRelacionesDetalles(guiaremisions,pedidoexpors,pedidos);
					this.saveConsultor();
				}

				ConsultorLogicAdditional.updateRelacionesToSaveAfter(consultor,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			GuiaRemisionConstantesFunciones.InicializarGeneralEntityAuxiliaresGuiaRemisions(guiaremisions,true,true);
			PedidoExporConstantesFunciones.InicializarGeneralEntityAuxiliaresPedidoExpors(pedidoexpors,true,true);
			PedidoConstantesFunciones.InicializarGeneralEntityAuxiliaresPedidos(pedidos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveConsultorRelacionesDetalles(List<GuiaRemision> guiaremisions,List<PedidoExpor> pedidoexpors,List<Pedido> pedidos)throws Exception {
		try {
	

			Long idConsultorActual=this.getConsultor().getId();

			GuiaRemisionLogic guiaremisionLogic_Desde_Consultor=new GuiaRemisionLogic();
			guiaremisionLogic_Desde_Consultor.setGuiaRemisions(guiaremisions);

			guiaremisionLogic_Desde_Consultor.setConnexion(this.getConnexion());
			guiaremisionLogic_Desde_Consultor.setDatosCliente(this.datosCliente);

			for(GuiaRemision guiaremision_Desde_Consultor:guiaremisionLogic_Desde_Consultor.getGuiaRemisions()) {
				guiaremision_Desde_Consultor.setid_consultor(idConsultorActual);

				guiaremisionLogic_Desde_Consultor.setGuiaRemision(guiaremision_Desde_Consultor);
				guiaremisionLogic_Desde_Consultor.saveGuiaRemision();

				Long idGuiaRemisionActual=guiaremision_Desde_Consultor.getId();

				DetalleGuiaRemisionLogic detalleguiaremisionLogic_Desde_GuiaRemision=new DetalleGuiaRemisionLogic();

				if(guiaremision_Desde_Consultor.getDetalleGuiaRemisions()==null){
					guiaremision_Desde_Consultor.setDetalleGuiaRemisions(new ArrayList<DetalleGuiaRemision>());
				}

				detalleguiaremisionLogic_Desde_GuiaRemision.setDetalleGuiaRemisions(guiaremision_Desde_Consultor.getDetalleGuiaRemisions());

				detalleguiaremisionLogic_Desde_GuiaRemision.setConnexion(this.getConnexion());
				detalleguiaremisionLogic_Desde_GuiaRemision.setDatosCliente(this.datosCliente);

				for(DetalleGuiaRemision detalleguiaremision_Desde_GuiaRemision:detalleguiaremisionLogic_Desde_GuiaRemision.getDetalleGuiaRemisions()) {
					detalleguiaremision_Desde_GuiaRemision.setid_guia_remision(idGuiaRemisionActual);
				}

				detalleguiaremisionLogic_Desde_GuiaRemision.saveDetalleGuiaRemisions();
			}


			PedidoExporLogic pedidoexporLogic_Desde_Consultor=new PedidoExporLogic();
			pedidoexporLogic_Desde_Consultor.setPedidoExpors(pedidoexpors);

			pedidoexporLogic_Desde_Consultor.setConnexion(this.getConnexion());
			pedidoexporLogic_Desde_Consultor.setDatosCliente(this.datosCliente);

			for(PedidoExpor pedidoexpor_Desde_Consultor:pedidoexporLogic_Desde_Consultor.getPedidoExpors()) {
				pedidoexpor_Desde_Consultor.setid_consultor(idConsultorActual);

				pedidoexporLogic_Desde_Consultor.setPedidoExpor(pedidoexpor_Desde_Consultor);
				pedidoexporLogic_Desde_Consultor.savePedidoExpor();

				Long idPedidoExporActual=pedidoexpor_Desde_Consultor.getId();

				DetallePedidoExporLogic detallepedidoexporLogic_Desde_PedidoExpor=new DetallePedidoExporLogic();

				if(pedidoexpor_Desde_Consultor.getDetallePedidoExpors()==null){
					pedidoexpor_Desde_Consultor.setDetallePedidoExpors(new ArrayList<DetallePedidoExpor>());
				}

				detallepedidoexporLogic_Desde_PedidoExpor.setDetallePedidoExpors(pedidoexpor_Desde_Consultor.getDetallePedidoExpors());

				detallepedidoexporLogic_Desde_PedidoExpor.setConnexion(this.getConnexion());
				detallepedidoexporLogic_Desde_PedidoExpor.setDatosCliente(this.datosCliente);

				for(DetallePedidoExpor detallepedidoexpor_Desde_PedidoExpor:detallepedidoexporLogic_Desde_PedidoExpor.getDetallePedidoExpors()) {
					detallepedidoexpor_Desde_PedidoExpor.setid_pedido_expor(idPedidoExporActual);
				}

				detallepedidoexporLogic_Desde_PedidoExpor.saveDetallePedidoExpors();
			}


			PedidoLogic pedidoLogic_Desde_Consultor=new PedidoLogic();
			pedidoLogic_Desde_Consultor.setPedidos(pedidos);

			pedidoLogic_Desde_Consultor.setConnexion(this.getConnexion());
			pedidoLogic_Desde_Consultor.setDatosCliente(this.datosCliente);

			for(Pedido pedido_Desde_Consultor:pedidoLogic_Desde_Consultor.getPedidos()) {
				pedido_Desde_Consultor.setid_consultor(idConsultorActual);

				pedidoLogic_Desde_Consultor.setPedido(pedido_Desde_Consultor);
				pedidoLogic_Desde_Consultor.savePedido();

				Long idPedidoActual=pedido_Desde_Consultor.getId();

				DetallePedidoLogic detallepedidoLogic_Desde_Pedido=new DetallePedidoLogic();

				if(pedido_Desde_Consultor.getDetallePedidos()==null){
					pedido_Desde_Consultor.setDetallePedidos(new ArrayList<DetallePedido>());
				}

				detallepedidoLogic_Desde_Pedido.setDetallePedidos(pedido_Desde_Consultor.getDetallePedidos());

				detallepedidoLogic_Desde_Pedido.setConnexion(this.getConnexion());
				detallepedidoLogic_Desde_Pedido.setDatosCliente(this.datosCliente);

				for(DetallePedido detallepedido_Desde_Pedido:detallepedidoLogic_Desde_Pedido.getDetallePedidos()) {
					detallepedido_Desde_Pedido.setid_pedido(idPedidoActual);
				}

				detallepedidoLogic_Desde_Pedido.saveDetallePedidos();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfConsultor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ConsultorConstantesFunciones.getClassesForeignKeysOfConsultor(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfConsultor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ConsultorConstantesFunciones.getClassesRelationshipsOfConsultor(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
