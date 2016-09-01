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
package com.bydan.erp.produccion.business.dataaccess;

import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

import java.io.File;
import java.lang.reflect.Field;

//COMODIN
import javax.persistence.EntityManagerFactory;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.DatoGeneralMaximo;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.business.logic.QueryWhereSelectParameters;
import com.bydan.framework.erp.business.logic.ParameterSelectionGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperBase;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.produccion.business.entity.*;
import com.bydan.erp.produccion.util.*;//TipoPrioridadEmpresaProduConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class TipoPrioridadEmpresaProduDataAccess extends  TipoPrioridadEmpresaProduDataAccessAdditional{ //TipoPrioridadEmpresaProduDataAccessAdditional,DataAccessHelper<TipoPrioridadEmpresaProdu>
	//static Logger logger = Logger.getLogger(TipoPrioridadEmpresaProduDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_prioridad_empresa_produ";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoPrioridadEmpresaProduConstantesFunciones.SCHEMA+"."+TipoPrioridadEmpresaProduConstantesFunciones.TABLENAME+"(version_row,id_empresa,nombre,descripcion)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+TipoPrioridadEmpresaProduConstantesFunciones.SCHEMA+"."+TipoPrioridadEmpresaProduConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoPrioridadEmpresaProduConstantesFunciones.SCHEMA+"."+TipoPrioridadEmpresaProduConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipoprioridadempresaprodu from "+TipoPrioridadEmpresaProduConstantesFunciones.SPERSISTENCENAME+" tipoprioridadempresaprodu";
	public static String QUERYSELECTNATIVE="select "+TipoPrioridadEmpresaProduConstantesFunciones.SCHEMA+"."+TipoPrioridadEmpresaProduConstantesFunciones.TABLENAME+".id,"+TipoPrioridadEmpresaProduConstantesFunciones.SCHEMA+"."+TipoPrioridadEmpresaProduConstantesFunciones.TABLENAME+".version_row,"+TipoPrioridadEmpresaProduConstantesFunciones.SCHEMA+"."+TipoPrioridadEmpresaProduConstantesFunciones.TABLENAME+".id_empresa,"+TipoPrioridadEmpresaProduConstantesFunciones.SCHEMA+"."+TipoPrioridadEmpresaProduConstantesFunciones.TABLENAME+".nombre,"+TipoPrioridadEmpresaProduConstantesFunciones.SCHEMA+"."+TipoPrioridadEmpresaProduConstantesFunciones.TABLENAME+".descripcion from "+TipoPrioridadEmpresaProduConstantesFunciones.SCHEMA+"."+TipoPrioridadEmpresaProduConstantesFunciones.TABLENAME;//+" as "+TipoPrioridadEmpresaProduConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoPrioridadEmpresaProduConstantesFunciones.SCHEMA+"."+TipoPrioridadEmpresaProduConstantesFunciones.TABLENAME+".id,"+TipoPrioridadEmpresaProduConstantesFunciones.SCHEMA+"."+TipoPrioridadEmpresaProduConstantesFunciones.TABLENAME+".version_row,"+TipoPrioridadEmpresaProduConstantesFunciones.SCHEMA+"."+TipoPrioridadEmpresaProduConstantesFunciones.TABLENAME+".nombre from "+TipoPrioridadEmpresaProduConstantesFunciones.SCHEMA+"."+TipoPrioridadEmpresaProduConstantesFunciones.TABLENAME;//+" as "+TipoPrioridadEmpresaProduConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoPrioridadEmpresaProduConstantesFunciones.SCHEMA+"."+TipoPrioridadEmpresaProduConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOPRIORIDADEMPRESAPRODU_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOPRIORIDADEMPRESAPRODU_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOPRIORIDADEMPRESAPRODU_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOPRIORIDADEMPRESAPRODU_SELECT(?,?)";
	
	public static Boolean ISDELETECASCADE=false;
	public static boolean ISWITHSCHEMA=true;
	public static boolean ISWITHSTOREPROCEDURES=false;
	
	protected Boolean isForForeingKeyData=false;
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	
	
	private Object entityObject;
	
	private List<Object> entitiesObject;
	
	protected DatosCliente datosCliente;
	
	
	protected TipoPrioridadEmpresaProduDataAccessAdditional tipoprioridadempresaproduDataAccessAdditional=null;
	
	public TipoPrioridadEmpresaProduDataAccessAdditional getTipoPrioridadEmpresaProduDataAccessAdditional() {
		return this.tipoprioridadempresaproduDataAccessAdditional;
	}
	
	public void setTipoPrioridadEmpresaProduDataAccessAdditional(TipoPrioridadEmpresaProduDataAccessAdditional tipoprioridadempresaproduDataAccessAdditional) {
		try {
			this.tipoprioridadempresaproduDataAccessAdditional=tipoprioridadempresaproduDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoPrioridadEmpresaProduDataAccess() {
		this.entityObject=new Object();
		this.entitiesObject=new ArrayList<Object>();
		this.isForForeingKeyData=false;
		this.isForForeingsKeysDataRelationships=false;
		this.datosCliente=new DatosCliente();
	}
	
	
	public Boolean getIsForForeingKeyData() {
		return this.isForForeingKeyData;
	}

	public void setIsForForeingKeyData(Boolean isForForeingKeyData) {
		this.isForForeingKeyData = isForForeingKeyData;
	}
	
	public Boolean getIsForForeingsKeysDataRelationships() {
		return this.isForForeingsKeysDataRelationships;
	}

	public void setIsForForeingsKeysDataRelationships(Boolean isForForeingsKeysDataRelationships) {
		this.isForForeingsKeysDataRelationships = isForForeingsKeysDataRelationships;
	}
	
	public static boolean getISWITHSCHEMA() {
		return ISWITHSCHEMA;
	}

	public static void setISWITHSCHEMA(boolean ANISWITHSCHEMA) {
		ISWITHSCHEMA = ANISWITHSCHEMA;
	}		
	
	public static boolean getISWITHSTOREPROCEDURES() {
		return ISWITHSTOREPROCEDURES;
	}

	public static void setISWITHSTOREPROCEDURES(boolean ANISWITHSTOREPROCEDURES) {
		ISWITHSTOREPROCEDURES =ANISWITHSTOREPROCEDURES;
	}
	
	public static String getTABLENAME() {
		return TABLENAME;
	}
	
	public static void setTABLENAME(String sTABLENAME) {
		TipoPrioridadEmpresaProduDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoPrioridadEmpresaProduDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoPrioridadEmpresaProduDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
	}
	
	public List<Object> getEntitiesObject() {
		return this.entitiesObject;
	}

	public void setEntitiesObject(List<Object> entitiesObject) {
		this.entitiesObject= entitiesObject;
	}
	
	public Object getEntityObject() {
		return this.entityObject;
	}

	public void setEntityObject(Object entityObject) {
		this.entityObject= entityObject;
	}
	
	public static ParametersMaintenance getParametersMaintenance(GeneralEntity generalEntity) {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
		int orderParameter;

		return parametersMaintenance;
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

	//COMODIN
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		
	}
	
	public DatosCliente getDatosCliente() {
		return datosCliente;
	}

	public void setDatosCliente(DatosCliente datosCliente) {
		this.datosCliente = datosCliente;
	}
	
	public void setTipoPrioridadEmpresaProduOriginal(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu)throws Exception  {
		tipoprioridadempresaprodu.setTipoPrioridadEmpresaProduOriginal((TipoPrioridadEmpresaProdu)tipoprioridadempresaprodu.clone());		
	}
	
	public void setTipoPrioridadEmpresaProdusOriginal(List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodus)throws Exception  {
		
		for(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu:tipoprioridadempresaprodus){
			tipoprioridadempresaprodu.setTipoPrioridadEmpresaProduOriginal((TipoPrioridadEmpresaProdu)tipoprioridadempresaprodu.clone());
		}
	}
	
	public static void setTipoPrioridadEmpresaProduOriginalStatic(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu)throws Exception  {
		tipoprioridadempresaprodu.setTipoPrioridadEmpresaProduOriginal((TipoPrioridadEmpresaProdu)tipoprioridadempresaprodu.clone());		
	}
	
	public static void setTipoPrioridadEmpresaProdusOriginalStatic(List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodus)throws Exception  {
		
		for(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu:tipoprioridadempresaprodus){
			tipoprioridadempresaprodu.setTipoPrioridadEmpresaProduOriginal((TipoPrioridadEmpresaProdu)tipoprioridadempresaprodu.clone());
		}
	}
	
	public  void executeQuery(Connexion connexion, String sQueryExecute) throws Exception {	
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				this.executeQueryJdbc(connexion, sQueryExecute);
			} else {
				//this.executeQueryHibernate(connexion, sQueryExecute);
			}
      	} catch(Exception e) {
			throw e;
      	}		    	
    }
	
	public void executeQueryJdbc(Connexion connexion, String sQueryExecute) throws Exception {		
        try {     				
        	PreparedStatement preparedStatement = connexion.getConnection().prepareStatement(sQueryExecute);
      					
        	preparedStatement.executeUpdate();
        	preparedStatement.close();
      		   	
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	public  TipoPrioridadEmpresaProdu getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoPrioridadEmpresaProdu entity = new TipoPrioridadEmpresaProdu();		
		
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion, id);
			} else {
			}
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	public  TipoPrioridadEmpresaProdu getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoPrioridadEmpresaProdu entity = new TipoPrioridadEmpresaProdu();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoPrioridadEmpresaProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoPrioridadEmpresaProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Produccion.TipoPrioridadEmpresaProdu.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoPrioridadEmpresaProduOriginal(new TipoPrioridadEmpresaProdu());
      	    	entity=super.getEntity("",entity,resultSet,TipoPrioridadEmpresaProduDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoPrioridadEmpresaProdu("",entity,resultSet); 
				
				//entity.setTipoPrioridadEmpresaProduOriginal(super.getEntity("",entity.getTipoPrioridadEmpresaProduOriginal(),resultSet,TipoPrioridadEmpresaProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoPrioridadEmpresaProduOriginal(this.getEntityTipoPrioridadEmpresaProdu("",entity.getTipoPrioridadEmpresaProduOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoPrioridadEmpresaProdu(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoPrioridadEmpresaProdu getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoPrioridadEmpresaProdu entity = new TipoPrioridadEmpresaProdu();
				
        try  {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,queryWhereSelectParameters);
			} else {
			}
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  TipoPrioridadEmpresaProdu getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoPrioridadEmpresaProdu entity = new TipoPrioridadEmpresaProdu();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoPrioridadEmpresaProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoPrioridadEmpresaProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoPrioridadEmpresaProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.TipoPrioridadEmpresaProdu.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoPrioridadEmpresaProduOriginal(new TipoPrioridadEmpresaProdu());
      	    	entity=super.getEntity("",entity,resultSet,TipoPrioridadEmpresaProduDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoPrioridadEmpresaProdu("",entity,resultSet);    
				
				//entity.setTipoPrioridadEmpresaProduOriginal(super.getEntity("",entity.getTipoPrioridadEmpresaProduOriginal(),resultSet,TipoPrioridadEmpresaProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoPrioridadEmpresaProduOriginal(this.getEntityTipoPrioridadEmpresaProdu("",entity.getTipoPrioridadEmpresaProduOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoPrioridadEmpresaProdu(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoPrioridadEmpresaProdu
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoPrioridadEmpresaProdu entity = new TipoPrioridadEmpresaProdu();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoPrioridadEmpresaProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoPrioridadEmpresaProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoPrioridadEmpresaProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.TipoPrioridadEmpresaProdu.isActive=1
        	 
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {
				if(resultSet.next()) {				
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMinimo,classe,resultSet);
					}
					
					/*
					int iIndexColumn = 1;
				    
					while(iIndexColumn <= iTotalCountColumn) {
						//arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }										
					*/
				} else {
					entity =null;
				}
			//}
			
			if(entity!=null) {
				//this.setIsNewIsChangedFalseTipoPrioridadEmpresaProdu(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoPrioridadEmpresaProdu> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoPrioridadEmpresaProdu> entities = new  ArrayList<TipoPrioridadEmpresaProdu>();
		TipoPrioridadEmpresaProdu entity = new TipoPrioridadEmpresaProdu();		  
		
        try { 
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,queryWhereSelectParameters);	
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<TipoPrioridadEmpresaProdu> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoPrioridadEmpresaProdu> entities = new  ArrayList<TipoPrioridadEmpresaProdu>();
		TipoPrioridadEmpresaProdu entity = new TipoPrioridadEmpresaProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoPrioridadEmpresaProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoPrioridadEmpresaProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoPrioridadEmpresaProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoPrioridadEmpresaProdu();
      	    	entity=super.getEntity("",entity,resultSet,TipoPrioridadEmpresaProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoPrioridadEmpresaProdu("",entity,resultSet);
      	    	
				//entity.setTipoPrioridadEmpresaProduOriginal( new TipoPrioridadEmpresaProdu());
      	    	//entity.setTipoPrioridadEmpresaProduOriginal(super.getEntity("",entity.getTipoPrioridadEmpresaProduOriginal(),resultSet,TipoPrioridadEmpresaProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoPrioridadEmpresaProduOriginal(this.getEntityTipoPrioridadEmpresaProdu("",entity.getTipoPrioridadEmpresaProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoPrioridadEmpresaProdus(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoPrioridadEmpresaProdu(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoPrioridadEmpresaProdu> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoPrioridadEmpresaProdu> entities = new  ArrayList<TipoPrioridadEmpresaProdu>();
		TipoPrioridadEmpresaProdu entity = new TipoPrioridadEmpresaProdu();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entities =this.getEntitiesHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<TipoPrioridadEmpresaProdu> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoPrioridadEmpresaProdu> entities = new  ArrayList<TipoPrioridadEmpresaProdu>();
		TipoPrioridadEmpresaProdu entity = new TipoPrioridadEmpresaProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoPrioridadEmpresaProdu();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoPrioridadEmpresaProdu();
					//entity.setMapTipoPrioridadEmpresaProdu(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoPrioridadEmpresaProduValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoPrioridadEmpresaProdu().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoPrioridadEmpresaProduDataAccess.ISWITHSCHEMA);         		
					entity=TipoPrioridadEmpresaProduDataAccess.getEntityTipoPrioridadEmpresaProdu("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoPrioridadEmpresaProduOriginal( new TipoPrioridadEmpresaProdu());
					////entity.setTipoPrioridadEmpresaProduOriginal(super.getEntity("",entity.getTipoPrioridadEmpresaProduOriginal(),resultSet,TipoPrioridadEmpresaProduDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoPrioridadEmpresaProduOriginal(this.getEntityTipoPrioridadEmpresaProdu("",entity.getTipoPrioridadEmpresaProduOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoPrioridadEmpresaProdus(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoPrioridadEmpresaProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoPrioridadEmpresaProdu getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoPrioridadEmpresaProdu entity = new TipoPrioridadEmpresaProdu();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entity =this.getEntityHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  TipoPrioridadEmpresaProdu getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoPrioridadEmpresaProdu entity = new TipoPrioridadEmpresaProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoPrioridadEmpresaProdu();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoPrioridadEmpresaProdu();
					//entity.setMapTipoPrioridadEmpresaProdu(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoPrioridadEmpresaProduValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoPrioridadEmpresaProdu().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoPrioridadEmpresaProduDataAccess.ISWITHSCHEMA);         		
					entity=TipoPrioridadEmpresaProduDataAccess.getEntityTipoPrioridadEmpresaProdu("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoPrioridadEmpresaProduOriginal( new TipoPrioridadEmpresaProdu());
					////entity.setTipoPrioridadEmpresaProduOriginal(super.getEntity("",entity.getTipoPrioridadEmpresaProduOriginal(),resultSet,TipoPrioridadEmpresaProduDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoPrioridadEmpresaProduOriginal(this.getEntityTipoPrioridadEmpresaProdu("",entity.getTipoPrioridadEmpresaProduOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoPrioridadEmpresaProdu(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoPrioridadEmpresaProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoPrioridadEmpresaProdu getEntityTipoPrioridadEmpresaProdu(String strPrefijo,TipoPrioridadEmpresaProdu entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoPrioridadEmpresaProdu.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoPrioridadEmpresaProdu.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoPrioridadEmpresaProduDataAccess.setFieldReflectionTipoPrioridadEmpresaProdu(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoPrioridadEmpresaProdu=TipoPrioridadEmpresaProduConstantesFunciones.getTodosTiposColumnasTipoPrioridadEmpresaProdu();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoPrioridadEmpresaProdu) {
					existe=false;
					
					for(String sColumnExlude:listColumns) {	        	
						if(sColumn.equals(sColumnExlude)) {
							existe=true;
							break;
						}
					} 
					
					if(!existe) {
						//ESTE PROCESO ES REPETIDO DE INCLUDE
						Field field =null;
						try {
							field = TipoPrioridadEmpresaProdu.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoPrioridadEmpresaProdu.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoPrioridadEmpresaProduDataAccess.setFieldReflectionTipoPrioridadEmpresaProdu(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoPrioridadEmpresaProdu(Field field,String strPrefijo,String sColumn,TipoPrioridadEmpresaProdu entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoPrioridadEmpresaProduConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoPrioridadEmpresaProduConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoPrioridadEmpresaProduConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoPrioridadEmpresaProduConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoPrioridadEmpresaProduConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				default: 
					//CUANDO SE UTILIZA CAMPOS DIFERENCTES A LOS ORIGINALMENTE DEFINIDOS(ADDITIONAL)
					DataAccessHelperBase.setFieldDynamic(entity,sCampo,field,resultSet);
					break;
				/*
        		case "id":
        			field.set(entity, resultSet.getLong(sCampo));
        			break;        		        			
				*/
        	}    
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoPrioridadEmpresaProdu>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoPrioridadEmpresaProdu> entities = new  ArrayList<TipoPrioridadEmpresaProdu>();
		TipoPrioridadEmpresaProdu entity = new TipoPrioridadEmpresaProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoPrioridadEmpresaProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoPrioridadEmpresaProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoPrioridadEmpresaProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneralMaximo=new DatoGeneralMaximo();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMaximo,classe,resultSet);
					}
					
					//int iIndexColumn = 1;
				    
					/*
					while(iIndexColumn <= iTotalCountColumn) {
				    	arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }
					*/
					
					datoGeneralMaximos.add(datoGeneralMaximo);
					
					
					
					//arrayListObjects.add(arrayListObject);
					
					/*
					entity = new TipoPrioridadEmpresaProdu();
					entity=super.getEntity("",entity,resultSet,TipoPrioridadEmpresaProduDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoPrioridadEmpresaProdu("",entity,resultSet);
					
					//entity.setTipoPrioridadEmpresaProduOriginal( new TipoPrioridadEmpresaProdu());
					//entity.setTipoPrioridadEmpresaProduOriginal(super.getEntity("",entity.getTipoPrioridadEmpresaProduOriginal(),resultSet,TipoPrioridadEmpresaProduDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoPrioridadEmpresaProduOriginal(this.getEntityTipoPrioridadEmpresaProdu("",entity.getTipoPrioridadEmpresaProduOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoPrioridadEmpresaProdus(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoPrioridadEmpresaProdu(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoPrioridadEmpresaProdu>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoPrioridadEmpresaProdu> entities = new  ArrayList<TipoPrioridadEmpresaProdu>();
		TipoPrioridadEmpresaProdu entity = new TipoPrioridadEmpresaProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoPrioridadEmpresaProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoPrioridadEmpresaProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoPrioridadEmpresaProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneral=new DatoGeneral();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneral,classe,resultSet);
					}
					
					datoGenerals.add(datoGeneral);
				}
			//}
			
			statement.close(); 
			
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGenerals;
    }
	
	
	public  List<TipoPrioridadEmpresaProdu> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoPrioridadEmpresaProdu> entities = new  ArrayList<TipoPrioridadEmpresaProdu>();
		TipoPrioridadEmpresaProdu entity = new TipoPrioridadEmpresaProdu();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<TipoPrioridadEmpresaProdu> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoPrioridadEmpresaProdu> entities = new  ArrayList<TipoPrioridadEmpresaProdu>();
		TipoPrioridadEmpresaProdu entity = new TipoPrioridadEmpresaProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoPrioridadEmpresaProdu();
      	    	entity=super.getEntity("",entity,resultSet,TipoPrioridadEmpresaProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoPrioridadEmpresaProdu("",entity,resultSet);
      	    	
				//entity.setTipoPrioridadEmpresaProduOriginal( new TipoPrioridadEmpresaProdu());
      	    	//entity.setTipoPrioridadEmpresaProduOriginal(super.getEntity("",entity.getTipoPrioridadEmpresaProduOriginal(),resultSet,TipoPrioridadEmpresaProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoPrioridadEmpresaProduOriginal(this.getEntityTipoPrioridadEmpresaProdu("",entity.getTipoPrioridadEmpresaProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoPrioridadEmpresaProdus(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoPrioridadEmpresaProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoPrioridadEmpresaProdu> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoPrioridadEmpresaProdu> entities = new  ArrayList<TipoPrioridadEmpresaProdu>();
		TipoPrioridadEmpresaProdu entity = new TipoPrioridadEmpresaProdu();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesSimpleQueryBuildJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}

		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<TipoPrioridadEmpresaProdu> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoPrioridadEmpresaProdu> entities = new  ArrayList<TipoPrioridadEmpresaProdu>();
		TipoPrioridadEmpresaProdu entity = new TipoPrioridadEmpresaProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoPrioridadEmpresaProdu();
      	    	entity=super.getEntity("",entity,resultSet,TipoPrioridadEmpresaProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoPrioridadEmpresaProdu("",entity,resultSet);
      	    	
				//entity.setTipoPrioridadEmpresaProduOriginal( new TipoPrioridadEmpresaProdu());
      	    	//entity.setTipoPrioridadEmpresaProduOriginal(super.getEntity("",entity.getTipoPrioridadEmpresaProduOriginal(),resultSet,TipoPrioridadEmpresaProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoPrioridadEmpresaProduOriginal(this.getEntityTipoPrioridadEmpresaProdu("",entity.getTipoPrioridadEmpresaProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoPrioridadEmpresaProdus(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoPrioridadEmpresaProdu getEntityTipoPrioridadEmpresaProdu(String strPrefijo,TipoPrioridadEmpresaProdu entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoPrioridadEmpresaProduConstantesFunciones.IDEMPRESA));
				entity.setnombre(resultSet.getString(strPrefijo+TipoPrioridadEmpresaProduConstantesFunciones.NOMBRE));
				entity.setdescripcion(resultSet.getString(strPrefijo+TipoPrioridadEmpresaProduConstantesFunciones.DESCRIPCION));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoPrioridadEmpresaProduConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoPrioridadEmpresaProdu(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoPrioridadEmpresaProdu entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoPrioridadEmpresaProduDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoPrioridadEmpresaProduDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoPrioridadEmpresaProduDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoPrioridadEmpresaProduDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoPrioridadEmpresaProduConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoPrioridadEmpresaProduDataAccess.TABLENAME,TipoPrioridadEmpresaProduDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoPrioridadEmpresaProduDataAccess.setTipoPrioridadEmpresaProduOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoPrioridadEmpresaProdu reltipoprioridadempresaprodu)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipoprioridadempresaprodu.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<OrdenProdu> getOrdenProdus(Connexion connexion,TipoPrioridadEmpresaProdu tipoprioridadempresaprodu)throws SQLException,Exception {

		List<OrdenProdu> ordenprodus= new ArrayList<OrdenProdu>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoPrioridadEmpresaProduConstantesFunciones.SCHEMA+".tipo_prioridad_empresa_produ ON "+OrdenProduConstantesFunciones.SCHEMA+".orden_produ.id_tipo_prioridad_empresa_produ="+TipoPrioridadEmpresaProduConstantesFunciones.SCHEMA+".tipo_prioridad_empresa_produ.id WHERE "+TipoPrioridadEmpresaProduConstantesFunciones.SCHEMA+".tipo_prioridad_empresa_produ.id="+String.valueOf(tipoprioridadempresaprodu.getId());
			} else {
				sQuery=" INNER JOIN ordenprodu.TipoPrioridadEmpresaProdu WHERE ordenprodu.TipoPrioridadEmpresaProdu.id="+String.valueOf(tipoprioridadempresaprodu.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			OrdenProduDataAccess ordenproduDataAccess=new OrdenProduDataAccess();

			ordenproduDataAccess.setConnexionType(this.connexionType);
			ordenproduDataAccess.setParameterDbType(this.parameterDbType);
			ordenprodus=ordenproduDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ordenprodus;

	}

	public List<PedidoProdu> getPedidoProdus(Connexion connexion,TipoPrioridadEmpresaProdu tipoprioridadempresaprodu)throws SQLException,Exception {

		List<PedidoProdu> pedidoprodus= new ArrayList<PedidoProdu>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoPrioridadEmpresaProduConstantesFunciones.SCHEMA+".tipo_prioridad_empresa_produ ON "+PedidoProduConstantesFunciones.SCHEMA+".pedido_produ.id_tipo_prioridad_empresa_produ="+TipoPrioridadEmpresaProduConstantesFunciones.SCHEMA+".tipo_prioridad_empresa_produ.id WHERE "+TipoPrioridadEmpresaProduConstantesFunciones.SCHEMA+".tipo_prioridad_empresa_produ.id="+String.valueOf(tipoprioridadempresaprodu.getId());
			} else {
				sQuery=" INNER JOIN pedidoprodu.TipoPrioridadEmpresaProdu WHERE pedidoprodu.TipoPrioridadEmpresaProdu.id="+String.valueOf(tipoprioridadempresaprodu.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoProduDataAccess pedidoproduDataAccess=new PedidoProduDataAccess();

			pedidoproduDataAccess.setConnexionType(this.connexionType);
			pedidoproduDataAccess.setParameterDbType(this.parameterDbType);
			pedidoprodus=pedidoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidoprodus;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoPrioridadEmpresaProdu tipoprioridadempresaprodu) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipoprioridadempresaprodu.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipoprioridadempresaprodu.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipoprioridadempresaprodu.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(tipoprioridadempresaprodu.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipoprioridadempresaprodu.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipoprioridadempresaprodu.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipoprioridadempresaprodu.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipoprioridadempresaprodu.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
					parametersTemp.add(parameterMaintenance);
				}
			
			parametersMaintenance= new ParametersMaintenance();
			parametersMaintenance.setDbType(newDbType);
			parametersMaintenance.setParametersMaintenance(parametersTemp);
			//super.setParametersMaintenance(parametersMaintenance);		
		} catch(Exception e) {
			throw e;
		}
		
		return parametersMaintenance;
	}
	
	public void setIsNewIsChangedFalseTipoPrioridadEmpresaProdu(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu)throws Exception  {		
		tipoprioridadempresaprodu.setIsNew(false);
		tipoprioridadempresaprodu.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoPrioridadEmpresaProdus(List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodus)throws Exception  {				
		for(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu:tipoprioridadempresaprodus) {
			tipoprioridadempresaprodu.setIsNew(false);
			tipoprioridadempresaprodu.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoPrioridadEmpresaProdu(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
		try {
			if(this.datosCliente.getIsConExportar()) {
				String sQueryExportar=Funciones2.getQueryExportar(this.datosCliente, sQuery, queryWhereSelectParameters);
				
				this.executeQueryJdbc(connexion,sQueryExportar);
			}
		} catch(Exception e) {
			e.printStackTrace();
			//System.out.print(e.getStackTrace());
		}
	}
}
   
