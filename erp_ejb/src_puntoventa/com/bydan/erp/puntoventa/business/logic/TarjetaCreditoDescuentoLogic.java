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
package com.bydan.erp.puntoventa.business.logic;

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
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.puntoventa.util.TarjetaCreditoDescuentoConstantesFunciones;
import com.bydan.erp.puntoventa.util.TarjetaCreditoDescuentoParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.TarjetaCreditoDescuentoParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.TarjetaCreditoDescuento;
import com.bydan.erp.puntoventa.business.logic.TarjetaCreditoDescuentoLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TarjetaCreditoDescuentoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TarjetaCreditoDescuentoLogic.class);
	
	protected TarjetaCreditoDescuentoDataAccess tarjetacreditodescuentoDataAccess; 	
	protected TarjetaCreditoDescuento tarjetacreditodescuento;
	protected List<TarjetaCreditoDescuento> tarjetacreditodescuentos;
	protected Object tarjetacreditodescuentoObject;	
	protected List<Object> tarjetacreditodescuentosObject;
	
	public static ClassValidator<TarjetaCreditoDescuento> tarjetacreditodescuentoValidator = new ClassValidator<TarjetaCreditoDescuento>(TarjetaCreditoDescuento.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TarjetaCreditoDescuentoLogicAdditional tarjetacreditodescuentoLogicAdditional=null;
	
	public TarjetaCreditoDescuentoLogicAdditional getTarjetaCreditoDescuentoLogicAdditional() {
		return this.tarjetacreditodescuentoLogicAdditional;
	}
	
	public void setTarjetaCreditoDescuentoLogicAdditional(TarjetaCreditoDescuentoLogicAdditional tarjetacreditodescuentoLogicAdditional) {
		try {
			this.tarjetacreditodescuentoLogicAdditional=tarjetacreditodescuentoLogicAdditional;
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
	
	
	
	
	public  TarjetaCreditoDescuentoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tarjetacreditodescuentoDataAccess = new TarjetaCreditoDescuentoDataAccess();
			
			this.tarjetacreditodescuentos= new ArrayList<TarjetaCreditoDescuento>();
			this.tarjetacreditodescuento= new TarjetaCreditoDescuento();
			
			this.tarjetacreditodescuentoObject=new Object();
			this.tarjetacreditodescuentosObject=new ArrayList<Object>();
				
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
			
			this.tarjetacreditodescuentoDataAccess.setConnexionType(this.connexionType);
			this.tarjetacreditodescuentoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TarjetaCreditoDescuentoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tarjetacreditodescuentoDataAccess = new TarjetaCreditoDescuentoDataAccess();
			this.tarjetacreditodescuentos= new ArrayList<TarjetaCreditoDescuento>();
			this.tarjetacreditodescuento= new TarjetaCreditoDescuento();
			this.tarjetacreditodescuentoObject=new Object();
			this.tarjetacreditodescuentosObject=new ArrayList<Object>();
			
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
			
			this.tarjetacreditodescuentoDataAccess.setConnexionType(this.connexionType);
			this.tarjetacreditodescuentoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TarjetaCreditoDescuento getTarjetaCreditoDescuento() throws Exception {	
		TarjetaCreditoDescuentoLogicAdditional.checkTarjetaCreditoDescuentoToGet(tarjetacreditodescuento,this.datosCliente,this.arrDatoGeneral);
		TarjetaCreditoDescuentoLogicAdditional.updateTarjetaCreditoDescuentoToGet(tarjetacreditodescuento,this.arrDatoGeneral);
		
		return tarjetacreditodescuento;
	}
		
	public void setTarjetaCreditoDescuento(TarjetaCreditoDescuento newTarjetaCreditoDescuento) {
		this.tarjetacreditodescuento = newTarjetaCreditoDescuento;
	}
	
	public TarjetaCreditoDescuentoDataAccess getTarjetaCreditoDescuentoDataAccess() {
		return tarjetacreditodescuentoDataAccess;
	}
	
	public void setTarjetaCreditoDescuentoDataAccess(TarjetaCreditoDescuentoDataAccess newtarjetacreditodescuentoDataAccess) {
		this.tarjetacreditodescuentoDataAccess = newtarjetacreditodescuentoDataAccess;
	}
	
	public List<TarjetaCreditoDescuento> getTarjetaCreditoDescuentos() throws Exception {		
		this.quitarTarjetaCreditoDescuentosNulos();
		
		TarjetaCreditoDescuentoLogicAdditional.checkTarjetaCreditoDescuentoToGets(tarjetacreditodescuentos,this.datosCliente,this.arrDatoGeneral);
		
		for (TarjetaCreditoDescuento tarjetacreditodescuentoLocal: tarjetacreditodescuentos ) {
			TarjetaCreditoDescuentoLogicAdditional.updateTarjetaCreditoDescuentoToGet(tarjetacreditodescuentoLocal,this.arrDatoGeneral);
		}
		
		return tarjetacreditodescuentos;
	}
	
	public void setTarjetaCreditoDescuentos(List<TarjetaCreditoDescuento> newTarjetaCreditoDescuentos) {
		this.tarjetacreditodescuentos = newTarjetaCreditoDescuentos;
	}
	
	public Object getTarjetaCreditoDescuentoObject() {	
		this.tarjetacreditodescuentoObject=this.tarjetacreditodescuentoDataAccess.getEntityObject();
		return this.tarjetacreditodescuentoObject;
	}
		
	public void setTarjetaCreditoDescuentoObject(Object newTarjetaCreditoDescuentoObject) {
		this.tarjetacreditodescuentoObject = newTarjetaCreditoDescuentoObject;
	}
	
	public List<Object> getTarjetaCreditoDescuentosObject() {		
		this.tarjetacreditodescuentosObject=this.tarjetacreditodescuentoDataAccess.getEntitiesObject();
		return this.tarjetacreditodescuentosObject;
	}
		
	public void setTarjetaCreditoDescuentosObject(List<Object> newTarjetaCreditoDescuentosObject) {
		this.tarjetacreditodescuentosObject = newTarjetaCreditoDescuentosObject;
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
		
		if(this.tarjetacreditodescuentoDataAccess!=null) {
			this.tarjetacreditodescuentoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoDescuento.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tarjetacreditodescuentoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tarjetacreditodescuentoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tarjetacreditodescuento = new  TarjetaCreditoDescuento();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoDescuento.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tarjetacreditodescuento=tarjetacreditodescuentoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tarjetacreditodescuento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TarjetaCreditoDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoDescuento(this.tarjetacreditodescuento);
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
		tarjetacreditodescuento = new  TarjetaCreditoDescuento();
		  		  
        try {
			
			tarjetacreditodescuento=tarjetacreditodescuentoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tarjetacreditodescuento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TarjetaCreditoDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoDescuento(this.tarjetacreditodescuento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tarjetacreditodescuento = new  TarjetaCreditoDescuento();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoDescuento.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tarjetacreditodescuento=tarjetacreditodescuentoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tarjetacreditodescuento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TarjetaCreditoDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoDescuento(this.tarjetacreditodescuento);
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
		tarjetacreditodescuento = new  TarjetaCreditoDescuento();
		  		  
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
		tarjetacreditodescuento = new  TarjetaCreditoDescuento();
		  		  
        try {
			
			tarjetacreditodescuento=tarjetacreditodescuentoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tarjetacreditodescuento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TarjetaCreditoDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoDescuento(this.tarjetacreditodescuento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tarjetacreditodescuento = new  TarjetaCreditoDescuento();
		  		  
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
		tarjetacreditodescuento = new  TarjetaCreditoDescuento();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoDescuento.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tarjetacreditodescuentoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tarjetacreditodescuento = new  TarjetaCreditoDescuento();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tarjetacreditodescuentoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tarjetacreditodescuento = new  TarjetaCreditoDescuento();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoDescuento.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tarjetacreditodescuentoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tarjetacreditodescuento = new  TarjetaCreditoDescuento();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tarjetacreditodescuentoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tarjetacreditodescuento = new  TarjetaCreditoDescuento();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoDescuento.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tarjetacreditodescuentoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tarjetacreditodescuento = new  TarjetaCreditoDescuento();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tarjetacreditodescuentoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tarjetacreditodescuentos = new  ArrayList<TarjetaCreditoDescuento>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoDescuento.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TarjetaCreditoDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditodescuentos=tarjetacreditodescuentoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTarjetaCreditoDescuento(tarjetacreditodescuentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoDescuento(this.tarjetacreditodescuentos);
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
		tarjetacreditodescuentos = new  ArrayList<TarjetaCreditoDescuento>();
		  		  
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
		tarjetacreditodescuentos = new  ArrayList<TarjetaCreditoDescuento>();
		  		  
        try {			
			TarjetaCreditoDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditodescuentos=tarjetacreditodescuentoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTarjetaCreditoDescuento(tarjetacreditodescuentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoDescuento(this.tarjetacreditodescuentos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tarjetacreditodescuentos = new  ArrayList<TarjetaCreditoDescuento>();
		  		  
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
		tarjetacreditodescuentos = new  ArrayList<TarjetaCreditoDescuento>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoDescuento.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TarjetaCreditoDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditodescuentos=tarjetacreditodescuentoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTarjetaCreditoDescuento(tarjetacreditodescuentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoDescuento(this.tarjetacreditodescuentos);
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
		tarjetacreditodescuentos = new  ArrayList<TarjetaCreditoDescuento>();
		  		  
        try {
			TarjetaCreditoDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditodescuentos=tarjetacreditodescuentoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTarjetaCreditoDescuento(tarjetacreditodescuentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoDescuento(this.tarjetacreditodescuentos);
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
		tarjetacreditodescuentos = new  ArrayList<TarjetaCreditoDescuento>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoDescuento.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TarjetaCreditoDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditodescuentos=tarjetacreditodescuentoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTarjetaCreditoDescuento(tarjetacreditodescuentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoDescuento(this.tarjetacreditodescuentos);
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
		tarjetacreditodescuentos = new  ArrayList<TarjetaCreditoDescuento>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TarjetaCreditoDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditodescuentos=tarjetacreditodescuentoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTarjetaCreditoDescuento(tarjetacreditodescuentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoDescuento(this.tarjetacreditodescuentos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tarjetacreditodescuento = new  TarjetaCreditoDescuento();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoDescuento.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TarjetaCreditoDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditodescuento=tarjetacreditodescuentoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTarjetaCreditoDescuento(tarjetacreditodescuento);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoDescuento(this.tarjetacreditodescuento);
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
		tarjetacreditodescuento = new  TarjetaCreditoDescuento();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TarjetaCreditoDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditodescuento=tarjetacreditodescuentoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTarjetaCreditoDescuento(tarjetacreditodescuento);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoDescuento(this.tarjetacreditodescuento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tarjetacreditodescuentos = new  ArrayList<TarjetaCreditoDescuento>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoDescuento.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TarjetaCreditoDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditodescuentos=tarjetacreditodescuentoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTarjetaCreditoDescuento(tarjetacreditodescuentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoDescuento(this.tarjetacreditodescuentos);
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
		tarjetacreditodescuentos = new  ArrayList<TarjetaCreditoDescuento>();
		  		  
        try {
			TarjetaCreditoDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditodescuentos=tarjetacreditodescuentoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTarjetaCreditoDescuento(tarjetacreditodescuentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoDescuento(this.tarjetacreditodescuentos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTarjetaCreditoDescuentosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tarjetacreditodescuentos = new  ArrayList<TarjetaCreditoDescuento>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoDescuento.class.getSimpleName()+"-getTodosTarjetaCreditoDescuentosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TarjetaCreditoDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditodescuentos=tarjetacreditodescuentoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTarjetaCreditoDescuento(tarjetacreditodescuentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoDescuento(this.tarjetacreditodescuentos);
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
	
	public  void  getTodosTarjetaCreditoDescuentos(String sFinalQuery,Pagination pagination)throws Exception {
		tarjetacreditodescuentos = new  ArrayList<TarjetaCreditoDescuento>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TarjetaCreditoDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tarjetacreditodescuentos=tarjetacreditodescuentoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTarjetaCreditoDescuento(tarjetacreditodescuentos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TarjetaCreditoDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoDescuento(this.tarjetacreditodescuentos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTarjetaCreditoDescuento(TarjetaCreditoDescuento tarjetacreditodescuento) throws Exception {
		Boolean estaValidado=false;
		
		if(tarjetacreditodescuento.getIsNew() || tarjetacreditodescuento.getIsChanged()) { 
			this.invalidValues = tarjetacreditodescuentoValidator.getInvalidValues(tarjetacreditodescuento);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tarjetacreditodescuento);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTarjetaCreditoDescuento(List<TarjetaCreditoDescuento> TarjetaCreditoDescuentos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TarjetaCreditoDescuento tarjetacreditodescuentoLocal:tarjetacreditodescuentos) {				
			estaValidadoObjeto=this.validarGuardarTarjetaCreditoDescuento(tarjetacreditodescuentoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTarjetaCreditoDescuento(List<TarjetaCreditoDescuento> TarjetaCreditoDescuentos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTarjetaCreditoDescuento(tarjetacreditodescuentos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTarjetaCreditoDescuento(TarjetaCreditoDescuento TarjetaCreditoDescuento) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTarjetaCreditoDescuento(tarjetacreditodescuento)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TarjetaCreditoDescuento tarjetacreditodescuento) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tarjetacreditodescuento.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TarjetaCreditoDescuentoConstantesFunciones.getTarjetaCreditoDescuentoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tarjetacreditodescuento","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TarjetaCreditoDescuentoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TarjetaCreditoDescuentoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTarjetaCreditoDescuentoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoDescuento.class.getSimpleName()+"-saveTarjetaCreditoDescuentoWithConnection");connexion.begin();			
			
			TarjetaCreditoDescuentoLogicAdditional.checkTarjetaCreditoDescuentoToSave(this.tarjetacreditodescuento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TarjetaCreditoDescuentoLogicAdditional.updateTarjetaCreditoDescuentoToSave(this.tarjetacreditodescuento,this.arrDatoGeneral);
			
			TarjetaCreditoDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tarjetacreditodescuento,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTarjetaCreditoDescuento();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTarjetaCreditoDescuento(this.tarjetacreditodescuento)) {
				TarjetaCreditoDescuentoDataAccess.save(this.tarjetacreditodescuento, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tarjetacreditodescuento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TarjetaCreditoDescuentoLogicAdditional.checkTarjetaCreditoDescuentoToSaveAfter(this.tarjetacreditodescuento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTarjetaCreditoDescuento();
			
			connexion.commit();			
			
			if(this.tarjetacreditodescuento.getIsDeleted()) {
				this.tarjetacreditodescuento=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTarjetaCreditoDescuento()throws Exception {	
		try {	
			
			TarjetaCreditoDescuentoLogicAdditional.checkTarjetaCreditoDescuentoToSave(this.tarjetacreditodescuento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TarjetaCreditoDescuentoLogicAdditional.updateTarjetaCreditoDescuentoToSave(this.tarjetacreditodescuento,this.arrDatoGeneral);
			
			TarjetaCreditoDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tarjetacreditodescuento,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTarjetaCreditoDescuento(this.tarjetacreditodescuento)) {			
				TarjetaCreditoDescuentoDataAccess.save(this.tarjetacreditodescuento, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tarjetacreditodescuento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TarjetaCreditoDescuentoLogicAdditional.checkTarjetaCreditoDescuentoToSaveAfter(this.tarjetacreditodescuento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tarjetacreditodescuento.getIsDeleted()) {
				this.tarjetacreditodescuento=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTarjetaCreditoDescuentosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoDescuento.class.getSimpleName()+"-saveTarjetaCreditoDescuentosWithConnection");connexion.begin();			
			
			TarjetaCreditoDescuentoLogicAdditional.checkTarjetaCreditoDescuentoToSaves(tarjetacreditodescuentos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTarjetaCreditoDescuentos();
			
			Boolean validadoTodosTarjetaCreditoDescuento=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TarjetaCreditoDescuento tarjetacreditodescuentoLocal:tarjetacreditodescuentos) {		
				if(tarjetacreditodescuentoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TarjetaCreditoDescuentoLogicAdditional.updateTarjetaCreditoDescuentoToSave(tarjetacreditodescuentoLocal,this.arrDatoGeneral);
	        	
				TarjetaCreditoDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tarjetacreditodescuentoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTarjetaCreditoDescuento(tarjetacreditodescuentoLocal)) {
					TarjetaCreditoDescuentoDataAccess.save(tarjetacreditodescuentoLocal, connexion);				
				} else {
					validadoTodosTarjetaCreditoDescuento=false;
				}
			}
			
			if(!validadoTodosTarjetaCreditoDescuento) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TarjetaCreditoDescuentoLogicAdditional.checkTarjetaCreditoDescuentoToSavesAfter(tarjetacreditodescuentos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTarjetaCreditoDescuentos();
			
			connexion.commit();		
			
			this.quitarTarjetaCreditoDescuentosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTarjetaCreditoDescuentos()throws Exception {				
		 try {	
			TarjetaCreditoDescuentoLogicAdditional.checkTarjetaCreditoDescuentoToSaves(tarjetacreditodescuentos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTarjetaCreditoDescuento=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TarjetaCreditoDescuento tarjetacreditodescuentoLocal:tarjetacreditodescuentos) {				
				if(tarjetacreditodescuentoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TarjetaCreditoDescuentoLogicAdditional.updateTarjetaCreditoDescuentoToSave(tarjetacreditodescuentoLocal,this.arrDatoGeneral);
	        	
				TarjetaCreditoDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tarjetacreditodescuentoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTarjetaCreditoDescuento(tarjetacreditodescuentoLocal)) {				
					TarjetaCreditoDescuentoDataAccess.save(tarjetacreditodescuentoLocal, connexion);				
				} else {
					validadoTodosTarjetaCreditoDescuento=false;
				}
			}
			
			if(!validadoTodosTarjetaCreditoDescuento) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TarjetaCreditoDescuentoLogicAdditional.checkTarjetaCreditoDescuentoToSavesAfter(tarjetacreditodescuentos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTarjetaCreditoDescuentosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TarjetaCreditoDescuentoParameterReturnGeneral procesarAccionTarjetaCreditoDescuentos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TarjetaCreditoDescuento> tarjetacreditodescuentos,TarjetaCreditoDescuentoParameterReturnGeneral tarjetacreditodescuentoParameterGeneral)throws Exception {
		 try {	
			TarjetaCreditoDescuentoParameterReturnGeneral tarjetacreditodescuentoReturnGeneral=new TarjetaCreditoDescuentoParameterReturnGeneral();
	
			TarjetaCreditoDescuentoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tarjetacreditodescuentos,tarjetacreditodescuentoParameterGeneral,tarjetacreditodescuentoReturnGeneral);
			
			return tarjetacreditodescuentoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TarjetaCreditoDescuentoParameterReturnGeneral procesarAccionTarjetaCreditoDescuentosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TarjetaCreditoDescuento> tarjetacreditodescuentos,TarjetaCreditoDescuentoParameterReturnGeneral tarjetacreditodescuentoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoDescuento.class.getSimpleName()+"-procesarAccionTarjetaCreditoDescuentosWithConnection");connexion.begin();			
			
			TarjetaCreditoDescuentoParameterReturnGeneral tarjetacreditodescuentoReturnGeneral=new TarjetaCreditoDescuentoParameterReturnGeneral();
	
			TarjetaCreditoDescuentoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tarjetacreditodescuentos,tarjetacreditodescuentoParameterGeneral,tarjetacreditodescuentoReturnGeneral);
			
			this.connexion.commit();
			
			return tarjetacreditodescuentoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TarjetaCreditoDescuentoParameterReturnGeneral procesarEventosTarjetaCreditoDescuentos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TarjetaCreditoDescuento> tarjetacreditodescuentos,TarjetaCreditoDescuento tarjetacreditodescuento,TarjetaCreditoDescuentoParameterReturnGeneral tarjetacreditodescuentoParameterGeneral,Boolean isEsNuevoTarjetaCreditoDescuento,ArrayList<Classe> clases)throws Exception {
		 try {	
			TarjetaCreditoDescuentoParameterReturnGeneral tarjetacreditodescuentoReturnGeneral=new TarjetaCreditoDescuentoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tarjetacreditodescuentoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TarjetaCreditoDescuentoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tarjetacreditodescuentos,tarjetacreditodescuento,tarjetacreditodescuentoParameterGeneral,tarjetacreditodescuentoReturnGeneral,isEsNuevoTarjetaCreditoDescuento,clases);
			
			return tarjetacreditodescuentoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TarjetaCreditoDescuentoParameterReturnGeneral procesarEventosTarjetaCreditoDescuentosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TarjetaCreditoDescuento> tarjetacreditodescuentos,TarjetaCreditoDescuento tarjetacreditodescuento,TarjetaCreditoDescuentoParameterReturnGeneral tarjetacreditodescuentoParameterGeneral,Boolean isEsNuevoTarjetaCreditoDescuento,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoDescuento.class.getSimpleName()+"-procesarEventosTarjetaCreditoDescuentosWithConnection");connexion.begin();			
			
			TarjetaCreditoDescuentoParameterReturnGeneral tarjetacreditodescuentoReturnGeneral=new TarjetaCreditoDescuentoParameterReturnGeneral();
	
			tarjetacreditodescuentoReturnGeneral.setTarjetaCreditoDescuento(tarjetacreditodescuento);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tarjetacreditodescuentoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TarjetaCreditoDescuentoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tarjetacreditodescuentos,tarjetacreditodescuento,tarjetacreditodescuentoParameterGeneral,tarjetacreditodescuentoReturnGeneral,isEsNuevoTarjetaCreditoDescuento,clases);
			
			this.connexion.commit();
			
			return tarjetacreditodescuentoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TarjetaCreditoDescuentoParameterReturnGeneral procesarImportacionTarjetaCreditoDescuentosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TarjetaCreditoDescuentoParameterReturnGeneral tarjetacreditodescuentoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoDescuento.class.getSimpleName()+"-procesarImportacionTarjetaCreditoDescuentosWithConnection");connexion.begin();			
			
			TarjetaCreditoDescuentoParameterReturnGeneral tarjetacreditodescuentoReturnGeneral=new TarjetaCreditoDescuentoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tarjetacreditodescuentos=new ArrayList<TarjetaCreditoDescuento>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tarjetacreditodescuento=new TarjetaCreditoDescuento();
				
				
				if(conColumnasBase) {this.tarjetacreditodescuento.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tarjetacreditodescuento.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tarjetacreditodescuento.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.tarjetacreditodescuento.setnumero_meses(Integer.parseInt(arrColumnas[iColumn++]));
				this.tarjetacreditodescuento.setes_corriente(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.tarjetacreditodescuento.setcon_interes(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.tarjetacreditodescuentos.add(this.tarjetacreditodescuento);
			}
			
			this.saveTarjetaCreditoDescuentos();
			
			this.connexion.commit();
			
			tarjetacreditodescuentoReturnGeneral.setConRetornoEstaProcesado(true);
			tarjetacreditodescuentoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tarjetacreditodescuentoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTarjetaCreditoDescuentosEliminados() throws Exception {				
		
		List<TarjetaCreditoDescuento> tarjetacreditodescuentosAux= new ArrayList<TarjetaCreditoDescuento>();
		
		for(TarjetaCreditoDescuento tarjetacreditodescuento:tarjetacreditodescuentos) {
			if(!tarjetacreditodescuento.getIsDeleted()) {
				tarjetacreditodescuentosAux.add(tarjetacreditodescuento);
			}
		}
		
		tarjetacreditodescuentos=tarjetacreditodescuentosAux;
	}
	
	public void quitarTarjetaCreditoDescuentosNulos() throws Exception {				
		
		List<TarjetaCreditoDescuento> tarjetacreditodescuentosAux= new ArrayList<TarjetaCreditoDescuento>();
		
		for(TarjetaCreditoDescuento tarjetacreditodescuento : this.tarjetacreditodescuentos) {
			if(tarjetacreditodescuento==null) {
				tarjetacreditodescuentosAux.add(tarjetacreditodescuento);
			}
		}
		
		//this.tarjetacreditodescuentos=tarjetacreditodescuentosAux;
		
		this.tarjetacreditodescuentos.removeAll(tarjetacreditodescuentosAux);
	}
	
	public void getSetVersionRowTarjetaCreditoDescuentoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tarjetacreditodescuento.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tarjetacreditodescuento.getIsDeleted() || (tarjetacreditodescuento.getIsChanged()&&!tarjetacreditodescuento.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tarjetacreditodescuentoDataAccess.getSetVersionRowTarjetaCreditoDescuento(connexion,tarjetacreditodescuento.getId());
				
				if(!tarjetacreditodescuento.getVersionRow().equals(timestamp)) {	
					tarjetacreditodescuento.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tarjetacreditodescuento.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTarjetaCreditoDescuento()throws Exception {	
		
		if(tarjetacreditodescuento.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tarjetacreditodescuento.getIsDeleted() || (tarjetacreditodescuento.getIsChanged()&&!tarjetacreditodescuento.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tarjetacreditodescuentoDataAccess.getSetVersionRowTarjetaCreditoDescuento(connexion,tarjetacreditodescuento.getId());
			
			try {							
				if(!tarjetacreditodescuento.getVersionRow().equals(timestamp)) {	
					tarjetacreditodescuento.setVersionRow(timestamp);
				}
				
				tarjetacreditodescuento.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTarjetaCreditoDescuentosWithConnection()throws Exception {	
		if(tarjetacreditodescuentos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TarjetaCreditoDescuento tarjetacreditodescuentoAux:tarjetacreditodescuentos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tarjetacreditodescuentoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tarjetacreditodescuentoAux.getIsDeleted() || (tarjetacreditodescuentoAux.getIsChanged()&&!tarjetacreditodescuentoAux.getIsNew())) {
						
						timestamp=tarjetacreditodescuentoDataAccess.getSetVersionRowTarjetaCreditoDescuento(connexion,tarjetacreditodescuentoAux.getId());
						
						if(!tarjetacreditodescuento.getVersionRow().equals(timestamp)) {	
							tarjetacreditodescuentoAux.setVersionRow(timestamp);
						}
								
						tarjetacreditodescuentoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTarjetaCreditoDescuentos()throws Exception {	
		if(tarjetacreditodescuentos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TarjetaCreditoDescuento tarjetacreditodescuentoAux:tarjetacreditodescuentos) {
					if(tarjetacreditodescuentoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tarjetacreditodescuentoAux.getIsDeleted() || (tarjetacreditodescuentoAux.getIsChanged()&&!tarjetacreditodescuentoAux.getIsNew())) {
						
						timestamp=tarjetacreditodescuentoDataAccess.getSetVersionRowTarjetaCreditoDescuento(connexion,tarjetacreditodescuentoAux.getId());
						
						if(!tarjetacreditodescuentoAux.getVersionRow().equals(timestamp)) {	
							tarjetacreditodescuentoAux.setVersionRow(timestamp);
						}
						
													
						tarjetacreditodescuentoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TarjetaCreditoDescuentoParameterReturnGeneral cargarCombosLoteForeignKeyTarjetaCreditoDescuentoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTarjetaCredito) throws Exception {
		TarjetaCreditoDescuentoParameterReturnGeneral  tarjetacreditodescuentoReturnGeneral =new TarjetaCreditoDescuentoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoDescuento.class.getSimpleName()+"-cargarCombosLoteForeignKeyTarjetaCreditoDescuentoWithConnection");connexion.begin();
			
			tarjetacreditodescuentoReturnGeneral =new TarjetaCreditoDescuentoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tarjetacreditodescuentoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			tarjetacreditodescuentoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TarjetaCredito> tarjetacreditosForeignKey=new ArrayList<TarjetaCredito>();
			TarjetaCreditoLogic tarjetacreditoLogic=new TarjetaCreditoLogic();
			tarjetacreditoLogic.setConnexion(this.connexion);
			tarjetacreditoLogic.getTarjetaCreditoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTarjetaCredito.equals("NONE")) {
				tarjetacreditoLogic.getTodosTarjetaCreditos(finalQueryGlobalTarjetaCredito,new Pagination());
				tarjetacreditosForeignKey=tarjetacreditoLogic.getTarjetaCreditos();
			}

			tarjetacreditodescuentoReturnGeneral.settarjetacreditosForeignKey(tarjetacreditosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tarjetacreditodescuentoReturnGeneral;
	}
	
	public TarjetaCreditoDescuentoParameterReturnGeneral cargarCombosLoteForeignKeyTarjetaCreditoDescuento(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTarjetaCredito) throws Exception {
		TarjetaCreditoDescuentoParameterReturnGeneral  tarjetacreditodescuentoReturnGeneral =new TarjetaCreditoDescuentoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tarjetacreditodescuentoReturnGeneral =new TarjetaCreditoDescuentoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tarjetacreditodescuentoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			tarjetacreditodescuentoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TarjetaCredito> tarjetacreditosForeignKey=new ArrayList<TarjetaCredito>();
			TarjetaCreditoLogic tarjetacreditoLogic=new TarjetaCreditoLogic();
			tarjetacreditoLogic.setConnexion(this.connexion);
			tarjetacreditoLogic.getTarjetaCreditoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTarjetaCredito.equals("NONE")) {
				tarjetacreditoLogic.getTodosTarjetaCreditos(finalQueryGlobalTarjetaCredito,new Pagination());
				tarjetacreditosForeignKey=tarjetacreditoLogic.getTarjetaCreditos();
			}

			tarjetacreditodescuentoReturnGeneral.settarjetacreditosForeignKey(tarjetacreditosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tarjetacreditodescuentoReturnGeneral;
	}
	
	
	public void deepLoad(TarjetaCreditoDescuento tarjetacreditodescuento,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TarjetaCreditoDescuentoLogicAdditional.updateTarjetaCreditoDescuentoToGet(tarjetacreditodescuento,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tarjetacreditodescuento.setEmpresa(tarjetacreditodescuentoDataAccess.getEmpresa(connexion,tarjetacreditodescuento));
		tarjetacreditodescuento.setSucursal(tarjetacreditodescuentoDataAccess.getSucursal(connexion,tarjetacreditodescuento));
		tarjetacreditodescuento.setTarjetaCredito(tarjetacreditodescuentoDataAccess.getTarjetaCredito(connexion,tarjetacreditodescuento));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tarjetacreditodescuento.setEmpresa(tarjetacreditodescuentoDataAccess.getEmpresa(connexion,tarjetacreditodescuento));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				tarjetacreditodescuento.setSucursal(tarjetacreditodescuentoDataAccess.getSucursal(connexion,tarjetacreditodescuento));
				continue;
			}

			if(clas.clas.equals(TarjetaCredito.class)) {
				tarjetacreditodescuento.setTarjetaCredito(tarjetacreditodescuentoDataAccess.getTarjetaCredito(connexion,tarjetacreditodescuento));
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
			tarjetacreditodescuento.setEmpresa(tarjetacreditodescuentoDataAccess.getEmpresa(connexion,tarjetacreditodescuento));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetacreditodescuento.setSucursal(tarjetacreditodescuentoDataAccess.getSucursal(connexion,tarjetacreditodescuento));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TarjetaCredito.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetacreditodescuento.setTarjetaCredito(tarjetacreditodescuentoDataAccess.getTarjetaCredito(connexion,tarjetacreditodescuento));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tarjetacreditodescuento.setEmpresa(tarjetacreditodescuentoDataAccess.getEmpresa(connexion,tarjetacreditodescuento));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tarjetacreditodescuento.getEmpresa(),isDeep,deepLoadType,clases);
				
		tarjetacreditodescuento.setSucursal(tarjetacreditodescuentoDataAccess.getSucursal(connexion,tarjetacreditodescuento));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(tarjetacreditodescuento.getSucursal(),isDeep,deepLoadType,clases);
				
		tarjetacreditodescuento.setTarjetaCredito(tarjetacreditodescuentoDataAccess.getTarjetaCredito(connexion,tarjetacreditodescuento));
		TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
		tarjetacreditoLogic.deepLoad(tarjetacreditodescuento.getTarjetaCredito(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tarjetacreditodescuento.setEmpresa(tarjetacreditodescuentoDataAccess.getEmpresa(connexion,tarjetacreditodescuento));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tarjetacreditodescuento.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				tarjetacreditodescuento.setSucursal(tarjetacreditodescuentoDataAccess.getSucursal(connexion,tarjetacreditodescuento));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(tarjetacreditodescuento.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TarjetaCredito.class)) {
				tarjetacreditodescuento.setTarjetaCredito(tarjetacreditodescuentoDataAccess.getTarjetaCredito(connexion,tarjetacreditodescuento));
				TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
				tarjetacreditoLogic.deepLoad(tarjetacreditodescuento.getTarjetaCredito(),isDeep,deepLoadType,clases);				
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
			tarjetacreditodescuento.setEmpresa(tarjetacreditodescuentoDataAccess.getEmpresa(connexion,tarjetacreditodescuento));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tarjetacreditodescuento.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetacreditodescuento.setSucursal(tarjetacreditodescuentoDataAccess.getSucursal(connexion,tarjetacreditodescuento));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(tarjetacreditodescuento.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TarjetaCredito.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tarjetacreditodescuento.setTarjetaCredito(tarjetacreditodescuentoDataAccess.getTarjetaCredito(connexion,tarjetacreditodescuento));
			TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
			tarjetacreditoLogic.deepLoad(tarjetacreditodescuento.getTarjetaCredito(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TarjetaCreditoDescuento tarjetacreditodescuento,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TarjetaCreditoDescuentoLogicAdditional.updateTarjetaCreditoDescuentoToSave(tarjetacreditodescuento,this.arrDatoGeneral);
			
TarjetaCreditoDescuentoDataAccess.save(tarjetacreditodescuento, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tarjetacreditodescuento.getEmpresa(),connexion);

		SucursalDataAccess.save(tarjetacreditodescuento.getSucursal(),connexion);

		TarjetaCreditoDataAccess.save(tarjetacreditodescuento.getTarjetaCredito(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tarjetacreditodescuento.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(tarjetacreditodescuento.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(TarjetaCredito.class)) {
				TarjetaCreditoDataAccess.save(tarjetacreditodescuento.getTarjetaCredito(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tarjetacreditodescuento.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tarjetacreditodescuento.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(tarjetacreditodescuento.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(tarjetacreditodescuento.getSucursal(),isDeep,deepLoadType,clases);
				

		TarjetaCreditoDataAccess.save(tarjetacreditodescuento.getTarjetaCredito(),connexion);
		TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
		tarjetacreditoLogic.deepLoad(tarjetacreditodescuento.getTarjetaCredito(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tarjetacreditodescuento.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tarjetacreditodescuento.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(tarjetacreditodescuento.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(tarjetacreditodescuento.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TarjetaCredito.class)) {
				TarjetaCreditoDataAccess.save(tarjetacreditodescuento.getTarjetaCredito(),connexion);
				TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
				tarjetacreditoLogic.deepSave(tarjetacreditodescuento.getTarjetaCredito(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(TarjetaCreditoDescuento.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tarjetacreditodescuento,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TarjetaCreditoDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoDescuento(tarjetacreditodescuento);
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
			this.deepLoad(this.tarjetacreditodescuento,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TarjetaCreditoDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoDescuento(this.tarjetacreditodescuento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TarjetaCreditoDescuento.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tarjetacreditodescuentos!=null) {
				for(TarjetaCreditoDescuento tarjetacreditodescuento:tarjetacreditodescuentos) {
					this.deepLoad(tarjetacreditodescuento,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TarjetaCreditoDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoDescuento(tarjetacreditodescuentos);
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
			if(tarjetacreditodescuentos!=null) {
				for(TarjetaCreditoDescuento tarjetacreditodescuento:tarjetacreditodescuentos) {
					this.deepLoad(tarjetacreditodescuento,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TarjetaCreditoDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoDescuento(tarjetacreditodescuentos);
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
			this.getNewConnexionToDeep(TarjetaCreditoDescuento.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tarjetacreditodescuento,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TarjetaCreditoDescuento.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tarjetacreditodescuentos!=null) {
				for(TarjetaCreditoDescuento tarjetacreditodescuento:tarjetacreditodescuentos) {
					this.deepSave(tarjetacreditodescuento,isDeep,deepLoadType,clases);
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
			if(tarjetacreditodescuentos!=null) {
				for(TarjetaCreditoDescuento tarjetacreditodescuento:tarjetacreditodescuentos) {
					this.deepSave(tarjetacreditodescuento,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTarjetaCreditoDescuentosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoDescuento.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TarjetaCreditoDescuentoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TarjetaCreditoDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditodescuentos=tarjetacreditodescuentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoDescuento(this.tarjetacreditodescuentos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTarjetaCreditoDescuentosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TarjetaCreditoDescuentoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TarjetaCreditoDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditodescuentos=tarjetacreditodescuentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoDescuento(this.tarjetacreditodescuentos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTarjetaCreditoDescuentosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoDescuento.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,TarjetaCreditoDescuentoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			TarjetaCreditoDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditodescuentos=tarjetacreditodescuentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoDescuento(this.tarjetacreditodescuentos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTarjetaCreditoDescuentosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,TarjetaCreditoDescuentoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			TarjetaCreditoDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditodescuentos=tarjetacreditodescuentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoDescuento(this.tarjetacreditodescuentos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTarjetaCreditoDescuentosFK_IdTarjetaCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_tarjeta_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TarjetaCreditoDescuento.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTarjetaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTarjetaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tarjeta_credito,TarjetaCreditoDescuentoConstantesFunciones.IDTARJETACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTarjetaCredito);

			TarjetaCreditoDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTarjetaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditodescuentos=tarjetacreditodescuentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoDescuento(this.tarjetacreditodescuentos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTarjetaCreditoDescuentosFK_IdTarjetaCredito(String sFinalQuery,Pagination pagination,Long id_tarjeta_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTarjetaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTarjetaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tarjeta_credito,TarjetaCreditoDescuentoConstantesFunciones.IDTARJETACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTarjetaCredito);

			TarjetaCreditoDescuentoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTarjetaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tarjetacreditodescuentos=tarjetacreditodescuentoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TarjetaCreditoDescuentoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCreditoDescuento(this.tarjetacreditodescuentos);
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
			if(TarjetaCreditoDescuentoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TarjetaCreditoDescuentoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TarjetaCreditoDescuento tarjetacreditodescuento,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TarjetaCreditoDescuentoConstantesFunciones.ISCONAUDITORIA) {
				if(tarjetacreditodescuento.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TarjetaCreditoDescuentoDataAccess.TABLENAME, tarjetacreditodescuento.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TarjetaCreditoDescuentoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TarjetaCreditoDescuentoLogic.registrarAuditoriaDetallesTarjetaCreditoDescuento(connexion,tarjetacreditodescuento,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tarjetacreditodescuento.getIsDeleted()) {
					/*if(!tarjetacreditodescuento.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TarjetaCreditoDescuentoDataAccess.TABLENAME, tarjetacreditodescuento.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TarjetaCreditoDescuentoLogic.registrarAuditoriaDetallesTarjetaCreditoDescuento(connexion,tarjetacreditodescuento,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TarjetaCreditoDescuentoDataAccess.TABLENAME, tarjetacreditodescuento.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tarjetacreditodescuento.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TarjetaCreditoDescuentoDataAccess.TABLENAME, tarjetacreditodescuento.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TarjetaCreditoDescuentoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TarjetaCreditoDescuentoLogic.registrarAuditoriaDetallesTarjetaCreditoDescuento(connexion,tarjetacreditodescuento,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTarjetaCreditoDescuento(Connexion connexion,TarjetaCreditoDescuento tarjetacreditodescuento)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tarjetacreditodescuento.getIsNew()||!tarjetacreditodescuento.getid_empresa().equals(tarjetacreditodescuento.getTarjetaCreditoDescuentoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacreditodescuento.getTarjetaCreditoDescuentoOriginal().getid_empresa()!=null)
				{
					strValorActual=tarjetacreditodescuento.getTarjetaCreditoDescuentoOriginal().getid_empresa().toString();
				}
				if(tarjetacreditodescuento.getid_empresa()!=null)
				{
					strValorNuevo=tarjetacreditodescuento.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoDescuentoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacreditodescuento.getIsNew()||!tarjetacreditodescuento.getid_sucursal().equals(tarjetacreditodescuento.getTarjetaCreditoDescuentoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacreditodescuento.getTarjetaCreditoDescuentoOriginal().getid_sucursal()!=null)
				{
					strValorActual=tarjetacreditodescuento.getTarjetaCreditoDescuentoOriginal().getid_sucursal().toString();
				}
				if(tarjetacreditodescuento.getid_sucursal()!=null)
				{
					strValorNuevo=tarjetacreditodescuento.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoDescuentoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacreditodescuento.getIsNew()||!tarjetacreditodescuento.getid_tarjeta_credito().equals(tarjetacreditodescuento.getTarjetaCreditoDescuentoOriginal().getid_tarjeta_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacreditodescuento.getTarjetaCreditoDescuentoOriginal().getid_tarjeta_credito()!=null)
				{
					strValorActual=tarjetacreditodescuento.getTarjetaCreditoDescuentoOriginal().getid_tarjeta_credito().toString();
				}
				if(tarjetacreditodescuento.getid_tarjeta_credito()!=null)
				{
					strValorNuevo=tarjetacreditodescuento.getid_tarjeta_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoDescuentoConstantesFunciones.IDTARJETACREDITO,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacreditodescuento.getIsNew()||!tarjetacreditodescuento.getporcentaje().equals(tarjetacreditodescuento.getTarjetaCreditoDescuentoOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacreditodescuento.getTarjetaCreditoDescuentoOriginal().getporcentaje()!=null)
				{
					strValorActual=tarjetacreditodescuento.getTarjetaCreditoDescuentoOriginal().getporcentaje().toString();
				}
				if(tarjetacreditodescuento.getporcentaje()!=null)
				{
					strValorNuevo=tarjetacreditodescuento.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoDescuentoConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacreditodescuento.getIsNew()||!tarjetacreditodescuento.getnumero_meses().equals(tarjetacreditodescuento.getTarjetaCreditoDescuentoOriginal().getnumero_meses()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacreditodescuento.getTarjetaCreditoDescuentoOriginal().getnumero_meses()!=null)
				{
					strValorActual=tarjetacreditodescuento.getTarjetaCreditoDescuentoOriginal().getnumero_meses().toString();
				}
				if(tarjetacreditodescuento.getnumero_meses()!=null)
				{
					strValorNuevo=tarjetacreditodescuento.getnumero_meses().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoDescuentoConstantesFunciones.NUMEROMESES,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacreditodescuento.getIsNew()||!tarjetacreditodescuento.getes_corriente().equals(tarjetacreditodescuento.getTarjetaCreditoDescuentoOriginal().getes_corriente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacreditodescuento.getTarjetaCreditoDescuentoOriginal().getes_corriente()!=null)
				{
					strValorActual=tarjetacreditodescuento.getTarjetaCreditoDescuentoOriginal().getes_corriente().toString();
				}
				if(tarjetacreditodescuento.getes_corriente()!=null)
				{
					strValorNuevo=tarjetacreditodescuento.getes_corriente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoDescuentoConstantesFunciones.ESCORRIENTE,strValorActual,strValorNuevo);
			}	
			
			if(tarjetacreditodescuento.getIsNew()||!tarjetacreditodescuento.getcon_interes().equals(tarjetacreditodescuento.getTarjetaCreditoDescuentoOriginal().getcon_interes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tarjetacreditodescuento.getTarjetaCreditoDescuentoOriginal().getcon_interes()!=null)
				{
					strValorActual=tarjetacreditodescuento.getTarjetaCreditoDescuentoOriginal().getcon_interes().toString();
				}
				if(tarjetacreditodescuento.getcon_interes()!=null)
				{
					strValorNuevo=tarjetacreditodescuento.getcon_interes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TarjetaCreditoDescuentoConstantesFunciones.CONINTERES,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTarjetaCreditoDescuentoRelacionesWithConnection(TarjetaCreditoDescuento tarjetacreditodescuento) throws Exception {

		if(!tarjetacreditodescuento.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTarjetaCreditoDescuentoRelacionesBase(tarjetacreditodescuento,true);
		}
	}

	public void saveTarjetaCreditoDescuentoRelaciones(TarjetaCreditoDescuento tarjetacreditodescuento)throws Exception {

		if(!tarjetacreditodescuento.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTarjetaCreditoDescuentoRelacionesBase(tarjetacreditodescuento,false);
		}
	}

	public void saveTarjetaCreditoDescuentoRelacionesBase(TarjetaCreditoDescuento tarjetacreditodescuento,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TarjetaCreditoDescuento-saveRelacionesWithConnection");}
	

			this.setTarjetaCreditoDescuento(tarjetacreditodescuento);

			if(TarjetaCreditoDescuentoLogicAdditional.validarSaveRelaciones(tarjetacreditodescuento,this)) {

				TarjetaCreditoDescuentoLogicAdditional.updateRelacionesToSave(tarjetacreditodescuento,this);

				if((tarjetacreditodescuento.getIsNew()||tarjetacreditodescuento.getIsChanged())&&!tarjetacreditodescuento.getIsDeleted()) {
					this.saveTarjetaCreditoDescuento();
					this.saveTarjetaCreditoDescuentoRelacionesDetalles();

				} else if(tarjetacreditodescuento.getIsDeleted()) {
					this.saveTarjetaCreditoDescuentoRelacionesDetalles();
					this.saveTarjetaCreditoDescuento();
				}

				TarjetaCreditoDescuentoLogicAdditional.updateRelacionesToSaveAfter(tarjetacreditodescuento,this);

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
	
	
	private void saveTarjetaCreditoDescuentoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTarjetaCreditoDescuento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TarjetaCreditoDescuentoConstantesFunciones.getClassesForeignKeysOfTarjetaCreditoDescuento(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTarjetaCreditoDescuento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TarjetaCreditoDescuentoConstantesFunciones.getClassesRelationshipsOfTarjetaCreditoDescuento(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
