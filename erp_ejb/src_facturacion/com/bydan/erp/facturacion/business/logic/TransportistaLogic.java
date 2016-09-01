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
import com.bydan.erp.facturacion.util.TransportistaConstantesFunciones;
import com.bydan.erp.facturacion.util.TransportistaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TransportistaParameterGeneral;
import com.bydan.erp.facturacion.business.entity.Transportista;
import com.bydan.erp.facturacion.business.logic.TransportistaLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class TransportistaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TransportistaLogic.class);
	
	protected TransportistaDataAccess transportistaDataAccess; 	
	protected Transportista transportista;
	protected List<Transportista> transportistas;
	protected Object transportistaObject;	
	protected List<Object> transportistasObject;
	
	public static ClassValidator<Transportista> transportistaValidator = new ClassValidator<Transportista>(Transportista.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TransportistaLogicAdditional transportistaLogicAdditional=null;
	
	public TransportistaLogicAdditional getTransportistaLogicAdditional() {
		return this.transportistaLogicAdditional;
	}
	
	public void setTransportistaLogicAdditional(TransportistaLogicAdditional transportistaLogicAdditional) {
		try {
			this.transportistaLogicAdditional=transportistaLogicAdditional;
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
	
	
	
	
	public  TransportistaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.transportistaDataAccess = new TransportistaDataAccess();
			
			this.transportistas= new ArrayList<Transportista>();
			this.transportista= new Transportista();
			
			this.transportistaObject=new Object();
			this.transportistasObject=new ArrayList<Object>();
				
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
			
			this.transportistaDataAccess.setConnexionType(this.connexionType);
			this.transportistaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TransportistaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.transportistaDataAccess = new TransportistaDataAccess();
			this.transportistas= new ArrayList<Transportista>();
			this.transportista= new Transportista();
			this.transportistaObject=new Object();
			this.transportistasObject=new ArrayList<Object>();
			
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
			
			this.transportistaDataAccess.setConnexionType(this.connexionType);
			this.transportistaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Transportista getTransportista() throws Exception {	
		TransportistaLogicAdditional.checkTransportistaToGet(transportista,this.datosCliente,this.arrDatoGeneral);
		TransportistaLogicAdditional.updateTransportistaToGet(transportista,this.arrDatoGeneral);
		
		return transportista;
	}
		
	public void setTransportista(Transportista newTransportista) {
		this.transportista = newTransportista;
	}
	
	public TransportistaDataAccess getTransportistaDataAccess() {
		return transportistaDataAccess;
	}
	
	public void setTransportistaDataAccess(TransportistaDataAccess newtransportistaDataAccess) {
		this.transportistaDataAccess = newtransportistaDataAccess;
	}
	
	public List<Transportista> getTransportistas() throws Exception {		
		this.quitarTransportistasNulos();
		
		TransportistaLogicAdditional.checkTransportistaToGets(transportistas,this.datosCliente,this.arrDatoGeneral);
		
		for (Transportista transportistaLocal: transportistas ) {
			TransportistaLogicAdditional.updateTransportistaToGet(transportistaLocal,this.arrDatoGeneral);
		}
		
		return transportistas;
	}
	
	public void setTransportistas(List<Transportista> newTransportistas) {
		this.transportistas = newTransportistas;
	}
	
	public Object getTransportistaObject() {	
		this.transportistaObject=this.transportistaDataAccess.getEntityObject();
		return this.transportistaObject;
	}
		
	public void setTransportistaObject(Object newTransportistaObject) {
		this.transportistaObject = newTransportistaObject;
	}
	
	public List<Object> getTransportistasObject() {		
		this.transportistasObject=this.transportistaDataAccess.getEntitiesObject();
		return this.transportistasObject;
	}
		
	public void setTransportistasObject(List<Object> newTransportistasObject) {
		this.transportistasObject = newTransportistasObject;
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
		
		if(this.transportistaDataAccess!=null) {
			this.transportistaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transportista.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			transportistaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			transportistaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		transportista = new  Transportista();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transportista.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			transportista=transportistaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.transportista,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportista);
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
		transportista = new  Transportista();
		  		  
        try {
			
			transportista=transportistaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.transportista,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportista);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		transportista = new  Transportista();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transportista.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			transportista=transportistaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.transportista,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportista);
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
		transportista = new  Transportista();
		  		  
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
		transportista = new  Transportista();
		  		  
        try {
			
			transportista=transportistaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.transportista,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportista);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		transportista = new  Transportista();
		  		  
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
		transportista = new  Transportista();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transportista.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =transportistaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		transportista = new  Transportista();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=transportistaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		transportista = new  Transportista();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transportista.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =transportistaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		transportista = new  Transportista();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=transportistaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		transportista = new  Transportista();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transportista.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =transportistaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		transportista = new  Transportista();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=transportistaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		transportistas = new  ArrayList<Transportista>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transportista.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transportistas=transportistaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransportista(transportistas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportistas);
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
		transportistas = new  ArrayList<Transportista>();
		  		  
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
		transportistas = new  ArrayList<Transportista>();
		  		  
        try {			
			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transportistas=transportistaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTransportista(transportistas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportistas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		transportistas = new  ArrayList<Transportista>();
		  		  
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
		transportistas = new  ArrayList<Transportista>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transportista.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transportistas=transportistaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransportista(transportistas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportistas);
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
		transportistas = new  ArrayList<Transportista>();
		  		  
        try {
			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transportistas=transportistaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransportista(transportistas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportistas);
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
		transportistas = new  ArrayList<Transportista>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transportista.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transportistas=transportistaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTransportista(transportistas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportistas);
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
		transportistas = new  ArrayList<Transportista>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transportistas=transportistaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTransportista(transportistas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportistas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		transportista = new  Transportista();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transportista.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transportista=transportistaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTransportista(transportista);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportista);
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
		transportista = new  Transportista();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transportista=transportistaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTransportista(transportista);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportista);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		transportistas = new  ArrayList<Transportista>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transportista.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transportistas=transportistaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransportista(transportistas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportistas);
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
		transportistas = new  ArrayList<Transportista>();
		  		  
        try {
			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transportistas=transportistaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransportista(transportistas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportistas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTransportistasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		transportistas = new  ArrayList<Transportista>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transportista.class.getSimpleName()+"-getTodosTransportistasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transportistas=transportistaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTransportista(transportistas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportistas);
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
	
	public  void  getTodosTransportistas(String sFinalQuery,Pagination pagination)throws Exception {
		transportistas = new  ArrayList<Transportista>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transportistas=transportistaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTransportista(transportistas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportistas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTransportista(Transportista transportista) throws Exception {
		Boolean estaValidado=false;
		
		if(transportista.getIsNew() || transportista.getIsChanged()) { 
			this.invalidValues = transportistaValidator.getInvalidValues(transportista);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(transportista);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTransportista(List<Transportista> Transportistas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Transportista transportistaLocal:transportistas) {				
			estaValidadoObjeto=this.validarGuardarTransportista(transportistaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTransportista(List<Transportista> Transportistas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTransportista(transportistas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTransportista(Transportista Transportista) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTransportista(transportista)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Transportista transportista) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+transportista.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TransportistaConstantesFunciones.getTransportistaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"transportista","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TransportistaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TransportistaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTransportistaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transportista.class.getSimpleName()+"-saveTransportistaWithConnection");connexion.begin();			
			
			TransportistaLogicAdditional.checkTransportistaToSave(this.transportista,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TransportistaLogicAdditional.updateTransportistaToSave(this.transportista,this.arrDatoGeneral);
			
			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.transportista,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTransportista();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTransportista(this.transportista)) {
				TransportistaDataAccess.save(this.transportista, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.transportista,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TransportistaLogicAdditional.checkTransportistaToSaveAfter(this.transportista,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTransportista();
			
			connexion.commit();			
			
			if(this.transportista.getIsDeleted()) {
				this.transportista=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTransportista()throws Exception {	
		try {	
			
			TransportistaLogicAdditional.checkTransportistaToSave(this.transportista,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TransportistaLogicAdditional.updateTransportistaToSave(this.transportista,this.arrDatoGeneral);
			
			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.transportista,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTransportista(this.transportista)) {			
				TransportistaDataAccess.save(this.transportista, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.transportista,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TransportistaLogicAdditional.checkTransportistaToSaveAfter(this.transportista,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.transportista.getIsDeleted()) {
				this.transportista=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTransportistasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transportista.class.getSimpleName()+"-saveTransportistasWithConnection");connexion.begin();			
			
			TransportistaLogicAdditional.checkTransportistaToSaves(transportistas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTransportistas();
			
			Boolean validadoTodosTransportista=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Transportista transportistaLocal:transportistas) {		
				if(transportistaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TransportistaLogicAdditional.updateTransportistaToSave(transportistaLocal,this.arrDatoGeneral);
	        	
				TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),transportistaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTransportista(transportistaLocal)) {
					TransportistaDataAccess.save(transportistaLocal, connexion);				
				} else {
					validadoTodosTransportista=false;
				}
			}
			
			if(!validadoTodosTransportista) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TransportistaLogicAdditional.checkTransportistaToSavesAfter(transportistas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTransportistas();
			
			connexion.commit();		
			
			this.quitarTransportistasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTransportistas()throws Exception {				
		 try {	
			TransportistaLogicAdditional.checkTransportistaToSaves(transportistas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTransportista=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Transportista transportistaLocal:transportistas) {				
				if(transportistaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TransportistaLogicAdditional.updateTransportistaToSave(transportistaLocal,this.arrDatoGeneral);
	        	
				TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),transportistaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTransportista(transportistaLocal)) {				
					TransportistaDataAccess.save(transportistaLocal, connexion);				
				} else {
					validadoTodosTransportista=false;
				}
			}
			
			if(!validadoTodosTransportista) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TransportistaLogicAdditional.checkTransportistaToSavesAfter(transportistas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTransportistasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TransportistaParameterReturnGeneral procesarAccionTransportistas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Transportista> transportistas,TransportistaParameterReturnGeneral transportistaParameterGeneral)throws Exception {
		 try {	
			TransportistaParameterReturnGeneral transportistaReturnGeneral=new TransportistaParameterReturnGeneral();
	
			TransportistaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,transportistas,transportistaParameterGeneral,transportistaReturnGeneral);
			
			return transportistaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TransportistaParameterReturnGeneral procesarAccionTransportistasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Transportista> transportistas,TransportistaParameterReturnGeneral transportistaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transportista.class.getSimpleName()+"-procesarAccionTransportistasWithConnection");connexion.begin();			
			
			TransportistaParameterReturnGeneral transportistaReturnGeneral=new TransportistaParameterReturnGeneral();
	
			TransportistaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,transportistas,transportistaParameterGeneral,transportistaReturnGeneral);
			
			this.connexion.commit();
			
			return transportistaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TransportistaParameterReturnGeneral procesarEventosTransportistas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Transportista> transportistas,Transportista transportista,TransportistaParameterReturnGeneral transportistaParameterGeneral,Boolean isEsNuevoTransportista,ArrayList<Classe> clases)throws Exception {
		 try {	
			TransportistaParameterReturnGeneral transportistaReturnGeneral=new TransportistaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				transportistaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TransportistaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,transportistas,transportista,transportistaParameterGeneral,transportistaReturnGeneral,isEsNuevoTransportista,clases);
			
			return transportistaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TransportistaParameterReturnGeneral procesarEventosTransportistasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Transportista> transportistas,Transportista transportista,TransportistaParameterReturnGeneral transportistaParameterGeneral,Boolean isEsNuevoTransportista,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transportista.class.getSimpleName()+"-procesarEventosTransportistasWithConnection");connexion.begin();			
			
			TransportistaParameterReturnGeneral transportistaReturnGeneral=new TransportistaParameterReturnGeneral();
	
			transportistaReturnGeneral.setTransportista(transportista);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				transportistaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TransportistaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,transportistas,transportista,transportistaParameterGeneral,transportistaReturnGeneral,isEsNuevoTransportista,clases);
			
			this.connexion.commit();
			
			return transportistaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TransportistaParameterReturnGeneral procesarImportacionTransportistasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TransportistaParameterReturnGeneral transportistaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transportista.class.getSimpleName()+"-procesarImportacionTransportistasWithConnection");connexion.begin();			
			
			TransportistaParameterReturnGeneral transportistaReturnGeneral=new TransportistaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.transportistas=new ArrayList<Transportista>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.transportista=new Transportista();
				
				
				if(conColumnasBase) {this.transportista.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.transportista.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.transportista.setidentificacion(arrColumnas[iColumn++]);
				this.transportista.setruc(arrColumnas[iColumn++]);
				this.transportista.setnombre(arrColumnas[iColumn++]);
				this.transportista.setapellido(arrColumnas[iColumn++]);
			this.transportista.setnombre_completo(arrColumnas[iColumn++]);
				this.transportista.settelefono(arrColumnas[iColumn++]);
				this.transportista.setdireccion(arrColumnas[iColumn++]);
				this.transportista.setplaca(arrColumnas[iColumn++]);
				this.transportista.setnumero(arrColumnas[iColumn++]);
			this.transportista.setobservacion(arrColumnas[iColumn++]);
				
				this.transportistas.add(this.transportista);
			}
			
			this.saveTransportistas();
			
			this.connexion.commit();
			
			transportistaReturnGeneral.setConRetornoEstaProcesado(true);
			transportistaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return transportistaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTransportistasEliminados() throws Exception {				
		
		List<Transportista> transportistasAux= new ArrayList<Transportista>();
		
		for(Transportista transportista:transportistas) {
			if(!transportista.getIsDeleted()) {
				transportistasAux.add(transportista);
			}
		}
		
		transportistas=transportistasAux;
	}
	
	public void quitarTransportistasNulos() throws Exception {				
		
		List<Transportista> transportistasAux= new ArrayList<Transportista>();
		
		for(Transportista transportista : this.transportistas) {
			if(transportista==null) {
				transportistasAux.add(transportista);
			}
		}
		
		//this.transportistas=transportistasAux;
		
		this.transportistas.removeAll(transportistasAux);
	}
	
	public void getSetVersionRowTransportistaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(transportista.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((transportista.getIsDeleted() || (transportista.getIsChanged()&&!transportista.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=transportistaDataAccess.getSetVersionRowTransportista(connexion,transportista.getId());
				
				if(!transportista.getVersionRow().equals(timestamp)) {	
					transportista.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				transportista.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTransportista()throws Exception {	
		
		if(transportista.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((transportista.getIsDeleted() || (transportista.getIsChanged()&&!transportista.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=transportistaDataAccess.getSetVersionRowTransportista(connexion,transportista.getId());
			
			try {							
				if(!transportista.getVersionRow().equals(timestamp)) {	
					transportista.setVersionRow(timestamp);
				}
				
				transportista.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTransportistasWithConnection()throws Exception {	
		if(transportistas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Transportista transportistaAux:transportistas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(transportistaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(transportistaAux.getIsDeleted() || (transportistaAux.getIsChanged()&&!transportistaAux.getIsNew())) {
						
						timestamp=transportistaDataAccess.getSetVersionRowTransportista(connexion,transportistaAux.getId());
						
						if(!transportista.getVersionRow().equals(timestamp)) {	
							transportistaAux.setVersionRow(timestamp);
						}
								
						transportistaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTransportistas()throws Exception {	
		if(transportistas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Transportista transportistaAux:transportistas) {
					if(transportistaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(transportistaAux.getIsDeleted() || (transportistaAux.getIsChanged()&&!transportistaAux.getIsNew())) {
						
						timestamp=transportistaDataAccess.getSetVersionRowTransportista(connexion,transportistaAux.getId());
						
						if(!transportistaAux.getVersionRow().equals(timestamp)) {	
							transportistaAux.setVersionRow(timestamp);
						}
						
													
						transportistaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TransportistaParameterReturnGeneral cargarCombosLoteForeignKeyTransportistaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTipoViaTransporte,String finalQueryGlobalCliente) throws Exception {
		TransportistaParameterReturnGeneral  transportistaReturnGeneral =new TransportistaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transportista.class.getSimpleName()+"-cargarCombosLoteForeignKeyTransportistaWithConnection");connexion.begin();
			
			transportistaReturnGeneral =new TransportistaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			transportistaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			transportistaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TipoViaTransporte> tipoviatransportesForeignKey=new ArrayList<TipoViaTransporte>();
			TipoViaTransporteLogic tipoviatransporteLogic=new TipoViaTransporteLogic();
			tipoviatransporteLogic.setConnexion(this.connexion);
			tipoviatransporteLogic.getTipoViaTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoViaTransporte.equals("NONE")) {
				tipoviatransporteLogic.getTodosTipoViaTransportes(finalQueryGlobalTipoViaTransporte,new Pagination());
				tipoviatransportesForeignKey=tipoviatransporteLogic.getTipoViaTransportes();
			}

			transportistaReturnGeneral.settipoviatransportesForeignKey(tipoviatransportesForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			transportistaReturnGeneral.setclientesForeignKey(clientesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return transportistaReturnGeneral;
	}
	
	public TransportistaParameterReturnGeneral cargarCombosLoteForeignKeyTransportista(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTipoViaTransporte,String finalQueryGlobalCliente) throws Exception {
		TransportistaParameterReturnGeneral  transportistaReturnGeneral =new TransportistaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			transportistaReturnGeneral =new TransportistaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			transportistaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			transportistaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TipoViaTransporte> tipoviatransportesForeignKey=new ArrayList<TipoViaTransporte>();
			TipoViaTransporteLogic tipoviatransporteLogic=new TipoViaTransporteLogic();
			tipoviatransporteLogic.setConnexion(this.connexion);
			tipoviatransporteLogic.getTipoViaTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoViaTransporte.equals("NONE")) {
				tipoviatransporteLogic.getTodosTipoViaTransportes(finalQueryGlobalTipoViaTransporte,new Pagination());
				tipoviatransportesForeignKey=tipoviatransporteLogic.getTipoViaTransportes();
			}

			transportistaReturnGeneral.settipoviatransportesForeignKey(tipoviatransportesForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			transportistaReturnGeneral.setclientesForeignKey(clientesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return transportistaReturnGeneral;
	}
	
	
	public void deepLoad(Transportista transportista,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TransportistaLogicAdditional.updateTransportistaToGet(transportista,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		transportista.setEmpresa(transportistaDataAccess.getEmpresa(connexion,transportista));
		transportista.setSucursal(transportistaDataAccess.getSucursal(connexion,transportista));
		transportista.setTipoViaTransporte(transportistaDataAccess.getTipoViaTransporte(connexion,transportista));
		transportista.setCliente(transportistaDataAccess.getCliente(connexion,transportista));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				transportista.setEmpresa(transportistaDataAccess.getEmpresa(connexion,transportista));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				transportista.setSucursal(transportistaDataAccess.getSucursal(connexion,transportista));
				continue;
			}

			if(clas.clas.equals(TipoViaTransporte.class)) {
				transportista.setTipoViaTransporte(transportistaDataAccess.getTipoViaTransporte(connexion,transportista));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				transportista.setCliente(transportistaDataAccess.getCliente(connexion,transportista));
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
			transportista.setEmpresa(transportistaDataAccess.getEmpresa(connexion,transportista));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transportista.setSucursal(transportistaDataAccess.getSucursal(connexion,transportista));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoViaTransporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transportista.setTipoViaTransporte(transportistaDataAccess.getTipoViaTransporte(connexion,transportista));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transportista.setCliente(transportistaDataAccess.getCliente(connexion,transportista));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		transportista.setEmpresa(transportistaDataAccess.getEmpresa(connexion,transportista));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(transportista.getEmpresa(),isDeep,deepLoadType,clases);
				
		transportista.setSucursal(transportistaDataAccess.getSucursal(connexion,transportista));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(transportista.getSucursal(),isDeep,deepLoadType,clases);
				
		transportista.setTipoViaTransporte(transportistaDataAccess.getTipoViaTransporte(connexion,transportista));
		TipoViaTransporteLogic tipoviatransporteLogic= new TipoViaTransporteLogic(connexion);
		tipoviatransporteLogic.deepLoad(transportista.getTipoViaTransporte(),isDeep,deepLoadType,clases);
				
		transportista.setCliente(transportistaDataAccess.getCliente(connexion,transportista));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(transportista.getCliente(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				transportista.setEmpresa(transportistaDataAccess.getEmpresa(connexion,transportista));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(transportista.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				transportista.setSucursal(transportistaDataAccess.getSucursal(connexion,transportista));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(transportista.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoViaTransporte.class)) {
				transportista.setTipoViaTransporte(transportistaDataAccess.getTipoViaTransporte(connexion,transportista));
				TipoViaTransporteLogic tipoviatransporteLogic= new TipoViaTransporteLogic(connexion);
				tipoviatransporteLogic.deepLoad(transportista.getTipoViaTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				transportista.setCliente(transportistaDataAccess.getCliente(connexion,transportista));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(transportista.getCliente(),isDeep,deepLoadType,clases);				
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
			transportista.setEmpresa(transportistaDataAccess.getEmpresa(connexion,transportista));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(transportista.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transportista.setSucursal(transportistaDataAccess.getSucursal(connexion,transportista));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(transportista.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoViaTransporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transportista.setTipoViaTransporte(transportistaDataAccess.getTipoViaTransporte(connexion,transportista));
			TipoViaTransporteLogic tipoviatransporteLogic= new TipoViaTransporteLogic(connexion);
			tipoviatransporteLogic.deepLoad(transportista.getTipoViaTransporte(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transportista.setCliente(transportistaDataAccess.getCliente(connexion,transportista));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(transportista.getCliente(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Transportista transportista,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TransportistaLogicAdditional.updateTransportistaToSave(transportista,this.arrDatoGeneral);
			
TransportistaDataAccess.save(transportista, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(transportista.getEmpresa(),connexion);

		SucursalDataAccess.save(transportista.getSucursal(),connexion);

		TipoViaTransporteDataAccess.save(transportista.getTipoViaTransporte(),connexion);

		ClienteDataAccess.save(transportista.getCliente(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(transportista.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(transportista.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoViaTransporte.class)) {
				TipoViaTransporteDataAccess.save(transportista.getTipoViaTransporte(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(transportista.getCliente(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(transportista.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(transportista.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(transportista.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(transportista.getSucursal(),isDeep,deepLoadType,clases);
				

		TipoViaTransporteDataAccess.save(transportista.getTipoViaTransporte(),connexion);
		TipoViaTransporteLogic tipoviatransporteLogic= new TipoViaTransporteLogic(connexion);
		tipoviatransporteLogic.deepLoad(transportista.getTipoViaTransporte(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(transportista.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(transportista.getCliente(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(transportista.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(transportista.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(transportista.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(transportista.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoViaTransporte.class)) {
				TipoViaTransporteDataAccess.save(transportista.getTipoViaTransporte(),connexion);
				TipoViaTransporteLogic tipoviatransporteLogic= new TipoViaTransporteLogic(connexion);
				tipoviatransporteLogic.deepSave(transportista.getTipoViaTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(transportista.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(transportista.getCliente(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(Transportista.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(transportista,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(transportista);
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
			this.deepLoad(this.transportista,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportista);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Transportista.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(transportistas!=null) {
				for(Transportista transportista:transportistas) {
					this.deepLoad(transportista,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(transportistas);
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
			if(transportistas!=null) {
				for(Transportista transportista:transportistas) {
					this.deepLoad(transportista,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(transportistas);
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
			this.getNewConnexionToDeep(Transportista.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(transportista,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Transportista.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(transportistas!=null) {
				for(Transportista transportista:transportistas) {
					this.deepSave(transportista,isDeep,deepLoadType,clases);
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
			if(transportistas!=null) {
				for(Transportista transportista:transportistas) {
					this.deepSave(transportista,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTransportistasBusquedaPorIdentificacionWithConnection(String sFinalQuery,Pagination pagination,String identificacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transportista.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralIdentificacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralIdentificacion.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+identificacion+"%",TransportistaConstantesFunciones.IDENTIFICACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralIdentificacion);

			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdentificacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transportistas=transportistaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportistas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransportistasBusquedaPorIdentificacion(String sFinalQuery,Pagination pagination,String identificacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralIdentificacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralIdentificacion.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+identificacion+"%",TransportistaConstantesFunciones.IDENTIFICACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralIdentificacion);

			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdentificacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transportistas=transportistaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportistas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransportistasBusquedaPorNombreCompletoWithConnection(String sFinalQuery,Pagination pagination,String nombre_completo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transportista.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombreCompleto= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombreCompleto.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre_completo+"%",TransportistaConstantesFunciones.NOMBRECOMPLETO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombreCompleto);

			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombreCompleto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transportistas=transportistaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportistas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransportistasBusquedaPorNombreCompleto(String sFinalQuery,Pagination pagination,String nombre_completo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombreCompleto= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombreCompleto.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre_completo+"%",TransportistaConstantesFunciones.NOMBRECOMPLETO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombreCompleto);

			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombreCompleto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transportistas=transportistaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportistas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransportistasBusquedaPorPlacaWithConnection(String sFinalQuery,Pagination pagination,String placa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transportista.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralPlaca= new ParameterSelectionGeneral();
			parameterSelectionGeneralPlaca.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+placa+"%",TransportistaConstantesFunciones.PLACA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralPlaca);

			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorPlaca","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transportistas=transportistaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportistas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransportistasBusquedaPorPlaca(String sFinalQuery,Pagination pagination,String placa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralPlaca= new ParameterSelectionGeneral();
			parameterSelectionGeneralPlaca.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+placa+"%",TransportistaConstantesFunciones.PLACA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralPlaca);

			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorPlaca","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transportistas=transportistaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportistas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransportistasBusquedaPorRucWithConnection(String sFinalQuery,Pagination pagination,String ruc)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transportista.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralRuc= new ParameterSelectionGeneral();
			parameterSelectionGeneralRuc.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+ruc+"%",TransportistaConstantesFunciones.RUC,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralRuc);

			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorRuc","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transportistas=transportistaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportistas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransportistasBusquedaPorRuc(String sFinalQuery,Pagination pagination,String ruc)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralRuc= new ParameterSelectionGeneral();
			parameterSelectionGeneralRuc.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+ruc+"%",TransportistaConstantesFunciones.RUC,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralRuc);

			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorRuc","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transportistas=transportistaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportistas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransportistasBusquedaPorTelefonoWithConnection(String sFinalQuery,Pagination pagination,String telefono)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transportista.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralTelefono= new ParameterSelectionGeneral();
			parameterSelectionGeneralTelefono.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+telefono+"%",TransportistaConstantesFunciones.TELEFONO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralTelefono);

			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorTelefono","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transportistas=transportistaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportistas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransportistasBusquedaPorTelefono(String sFinalQuery,Pagination pagination,String telefono)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralTelefono= new ParameterSelectionGeneral();
			parameterSelectionGeneralTelefono.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+telefono+"%",TransportistaConstantesFunciones.TELEFONO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralTelefono);

			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorTelefono","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transportistas=transportistaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportistas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransportistasFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transportista.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,TransportistaConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transportistas=transportistaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportistas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransportistasFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,TransportistaConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transportistas=transportistaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportistas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransportistasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transportista.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TransportistaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transportistas=transportistaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportistas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransportistasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TransportistaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transportistas=transportistaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportistas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransportistasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transportista.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,TransportistaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transportistas=transportistaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportistas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransportistasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,TransportistaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transportistas=transportistaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportistas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransportistasFK_IdTipoViaTransporteWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_via_transporte)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Transportista.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoViaTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoViaTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_via_transporte,TransportistaConstantesFunciones.IDTIPOVIATRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoViaTransporte);

			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoViaTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transportistas=transportistaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportistas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransportistasFK_IdTipoViaTransporte(String sFinalQuery,Pagination pagination,Long id_tipo_via_transporte)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoViaTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoViaTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_via_transporte,TransportistaConstantesFunciones.IDTIPOVIATRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoViaTransporte);

			TransportistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoViaTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transportistas=transportistaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(this.transportistas);
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
			if(TransportistaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TransportistaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Transportista transportista,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TransportistaConstantesFunciones.ISCONAUDITORIA) {
				if(transportista.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TransportistaDataAccess.TABLENAME, transportista.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TransportistaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TransportistaLogic.registrarAuditoriaDetallesTransportista(connexion,transportista,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(transportista.getIsDeleted()) {
					/*if(!transportista.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TransportistaDataAccess.TABLENAME, transportista.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TransportistaLogic.registrarAuditoriaDetallesTransportista(connexion,transportista,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TransportistaDataAccess.TABLENAME, transportista.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(transportista.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TransportistaDataAccess.TABLENAME, transportista.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TransportistaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TransportistaLogic.registrarAuditoriaDetallesTransportista(connexion,transportista,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTransportista(Connexion connexion,Transportista transportista)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(transportista.getIsNew()||!transportista.getid_empresa().equals(transportista.getTransportistaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transportista.getTransportistaOriginal().getid_empresa()!=null)
				{
					strValorActual=transportista.getTransportistaOriginal().getid_empresa().toString();
				}
				if(transportista.getid_empresa()!=null)
				{
					strValorNuevo=transportista.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransportistaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(transportista.getIsNew()||!transportista.getid_sucursal().equals(transportista.getTransportistaOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transportista.getTransportistaOriginal().getid_sucursal()!=null)
				{
					strValorActual=transportista.getTransportistaOriginal().getid_sucursal().toString();
				}
				if(transportista.getid_sucursal()!=null)
				{
					strValorNuevo=transportista.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransportistaConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(transportista.getIsNew()||!transportista.getid_tipo_via_transporte().equals(transportista.getTransportistaOriginal().getid_tipo_via_transporte()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transportista.getTransportistaOriginal().getid_tipo_via_transporte()!=null)
				{
					strValorActual=transportista.getTransportistaOriginal().getid_tipo_via_transporte().toString();
				}
				if(transportista.getid_tipo_via_transporte()!=null)
				{
					strValorNuevo=transportista.getid_tipo_via_transporte().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransportistaConstantesFunciones.IDTIPOVIATRANSPORTE,strValorActual,strValorNuevo);
			}	
			
			if(transportista.getIsNew()||!transportista.getidentificacion().equals(transportista.getTransportistaOriginal().getidentificacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transportista.getTransportistaOriginal().getidentificacion()!=null)
				{
					strValorActual=transportista.getTransportistaOriginal().getidentificacion();
				}
				if(transportista.getidentificacion()!=null)
				{
					strValorNuevo=transportista.getidentificacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransportistaConstantesFunciones.IDENTIFICACION,strValorActual,strValorNuevo);
			}	
			
			if(transportista.getIsNew()||!transportista.getruc().equals(transportista.getTransportistaOriginal().getruc()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transportista.getTransportistaOriginal().getruc()!=null)
				{
					strValorActual=transportista.getTransportistaOriginal().getruc();
				}
				if(transportista.getruc()!=null)
				{
					strValorNuevo=transportista.getruc() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransportistaConstantesFunciones.RUC,strValorActual,strValorNuevo);
			}	
			
			if(transportista.getIsNew()||!transportista.getnombre().equals(transportista.getTransportistaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transportista.getTransportistaOriginal().getnombre()!=null)
				{
					strValorActual=transportista.getTransportistaOriginal().getnombre();
				}
				if(transportista.getnombre()!=null)
				{
					strValorNuevo=transportista.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransportistaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(transportista.getIsNew()||!transportista.getapellido().equals(transportista.getTransportistaOriginal().getapellido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transportista.getTransportistaOriginal().getapellido()!=null)
				{
					strValorActual=transportista.getTransportistaOriginal().getapellido();
				}
				if(transportista.getapellido()!=null)
				{
					strValorNuevo=transportista.getapellido() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransportistaConstantesFunciones.APELLIDO,strValorActual,strValorNuevo);
			}	
			
			if(transportista.getIsNew()||!transportista.getnombre_completo().equals(transportista.getTransportistaOriginal().getnombre_completo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transportista.getTransportistaOriginal().getnombre_completo()!=null)
				{
					strValorActual=transportista.getTransportistaOriginal().getnombre_completo();
				}
				if(transportista.getnombre_completo()!=null)
				{
					strValorNuevo=transportista.getnombre_completo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransportistaConstantesFunciones.NOMBRECOMPLETO,strValorActual,strValorNuevo);
			}	
			
			if(transportista.getIsNew()||!transportista.gettelefono().equals(transportista.getTransportistaOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transportista.getTransportistaOriginal().gettelefono()!=null)
				{
					strValorActual=transportista.getTransportistaOriginal().gettelefono();
				}
				if(transportista.gettelefono()!=null)
				{
					strValorNuevo=transportista.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransportistaConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
			
			if(transportista.getIsNew()||!transportista.getdireccion().equals(transportista.getTransportistaOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transportista.getTransportistaOriginal().getdireccion()!=null)
				{
					strValorActual=transportista.getTransportistaOriginal().getdireccion();
				}
				if(transportista.getdireccion()!=null)
				{
					strValorNuevo=transportista.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransportistaConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(transportista.getIsNew()||!transportista.getid_cliente().equals(transportista.getTransportistaOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transportista.getTransportistaOriginal().getid_cliente()!=null)
				{
					strValorActual=transportista.getTransportistaOriginal().getid_cliente().toString();
				}
				if(transportista.getid_cliente()!=null)
				{
					strValorNuevo=transportista.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransportistaConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(transportista.getIsNew()||!transportista.getplaca().equals(transportista.getTransportistaOriginal().getplaca()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transportista.getTransportistaOriginal().getplaca()!=null)
				{
					strValorActual=transportista.getTransportistaOriginal().getplaca();
				}
				if(transportista.getplaca()!=null)
				{
					strValorNuevo=transportista.getplaca() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransportistaConstantesFunciones.PLACA,strValorActual,strValorNuevo);
			}	
			
			if(transportista.getIsNew()||!transportista.getnumero().equals(transportista.getTransportistaOriginal().getnumero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transportista.getTransportistaOriginal().getnumero()!=null)
				{
					strValorActual=transportista.getTransportistaOriginal().getnumero();
				}
				if(transportista.getnumero()!=null)
				{
					strValorNuevo=transportista.getnumero() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransportistaConstantesFunciones.NUMERO,strValorActual,strValorNuevo);
			}	
			
			if(transportista.getIsNew()||!transportista.getobservacion().equals(transportista.getTransportistaOriginal().getobservacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transportista.getTransportistaOriginal().getobservacion()!=null)
				{
					strValorActual=transportista.getTransportistaOriginal().getobservacion();
				}
				if(transportista.getobservacion()!=null)
				{
					strValorNuevo=transportista.getobservacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransportistaConstantesFunciones.OBSERVACION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTransportistaRelacionesWithConnection(Transportista transportista) throws Exception {

		if(!transportista.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTransportistaRelacionesBase(transportista,true);
		}
	}

	public void saveTransportistaRelaciones(Transportista transportista)throws Exception {

		if(!transportista.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTransportistaRelacionesBase(transportista,false);
		}
	}

	public void saveTransportistaRelacionesBase(Transportista transportista,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Transportista-saveRelacionesWithConnection");}
	

			this.setTransportista(transportista);

			if(TransportistaLogicAdditional.validarSaveRelaciones(transportista,this)) {

				TransportistaLogicAdditional.updateRelacionesToSave(transportista,this);

				if((transportista.getIsNew()||transportista.getIsChanged())&&!transportista.getIsDeleted()) {
					this.saveTransportista();
					this.saveTransportistaRelacionesDetalles();

				} else if(transportista.getIsDeleted()) {
					this.saveTransportistaRelacionesDetalles();
					this.saveTransportista();
				}

				TransportistaLogicAdditional.updateRelacionesToSaveAfter(transportista,this);

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
	
	
	private void saveTransportistaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTransportista(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TransportistaConstantesFunciones.getClassesForeignKeysOfTransportista(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransportista(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TransportistaConstantesFunciones.getClassesRelationshipsOfTransportista(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
