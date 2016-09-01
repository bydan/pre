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
import com.bydan.erp.produccion.util.*;//TipoMaquinaEmpresaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class TipoMaquinaEmpresaDataAccess extends  TipoMaquinaEmpresaDataAccessAdditional{ //TipoMaquinaEmpresaDataAccessAdditional,DataAccessHelper<TipoMaquinaEmpresa>
	//static Logger logger = Logger.getLogger(TipoMaquinaEmpresaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_maquina_empresa";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_cuenta_contable_debito,id_cuenta_contable_credito,codigo,nombre,marca,modelo,costo,esta_activo)values(current_timestamp,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_cuenta_contable_debito=?,id_cuenta_contable_credito=?,codigo=?,nombre=?,marca=?,modelo=?,costo=?,esta_activo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipomaquinaempresa from "+TipoMaquinaEmpresaConstantesFunciones.SPERSISTENCENAME+" tipomaquinaempresa";
	public static String QUERYSELECTNATIVE="select "+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+".id,"+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+".version_row,"+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+".id_empresa,"+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+".id_sucursal,"+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+".id_cuenta_contable_debito,"+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+".id_cuenta_contable_credito,"+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+".codigo,"+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+".nombre,"+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+".marca,"+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+".modelo,"+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+".costo,"+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+".esta_activo from "+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME;//+" as "+TipoMaquinaEmpresaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+".id,"+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+".version_row,"+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+".codigo from "+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME;//+" as "+TipoMaquinaEmpresaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+"."+TipoMaquinaEmpresaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_cuenta_contable_debito=?,id_cuenta_contable_credito=?,codigo=?,nombre=?,marca=?,modelo=?,costo=?,esta_activo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOMAQUINAEMPRESA_INSERT(?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOMAQUINAEMPRESA_UPDATE(?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOMAQUINAEMPRESA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOMAQUINAEMPRESA_SELECT(?,?)";
	
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
	
	
	protected TipoMaquinaEmpresaDataAccessAdditional tipomaquinaempresaDataAccessAdditional=null;
	
	public TipoMaquinaEmpresaDataAccessAdditional getTipoMaquinaEmpresaDataAccessAdditional() {
		return this.tipomaquinaempresaDataAccessAdditional;
	}
	
	public void setTipoMaquinaEmpresaDataAccessAdditional(TipoMaquinaEmpresaDataAccessAdditional tipomaquinaempresaDataAccessAdditional) {
		try {
			this.tipomaquinaempresaDataAccessAdditional=tipomaquinaempresaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoMaquinaEmpresaDataAccess() {
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
		TipoMaquinaEmpresaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoMaquinaEmpresaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoMaquinaEmpresaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoMaquinaEmpresaOriginal(TipoMaquinaEmpresa tipomaquinaempresa)throws Exception  {
		tipomaquinaempresa.setTipoMaquinaEmpresaOriginal((TipoMaquinaEmpresa)tipomaquinaempresa.clone());		
	}
	
	public void setTipoMaquinaEmpresasOriginal(List<TipoMaquinaEmpresa> tipomaquinaempresas)throws Exception  {
		
		for(TipoMaquinaEmpresa tipomaquinaempresa:tipomaquinaempresas){
			tipomaquinaempresa.setTipoMaquinaEmpresaOriginal((TipoMaquinaEmpresa)tipomaquinaempresa.clone());
		}
	}
	
	public static void setTipoMaquinaEmpresaOriginalStatic(TipoMaquinaEmpresa tipomaquinaempresa)throws Exception  {
		tipomaquinaempresa.setTipoMaquinaEmpresaOriginal((TipoMaquinaEmpresa)tipomaquinaempresa.clone());		
	}
	
	public static void setTipoMaquinaEmpresasOriginalStatic(List<TipoMaquinaEmpresa> tipomaquinaempresas)throws Exception  {
		
		for(TipoMaquinaEmpresa tipomaquinaempresa:tipomaquinaempresas){
			tipomaquinaempresa.setTipoMaquinaEmpresaOriginal((TipoMaquinaEmpresa)tipomaquinaempresa.clone());
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
	
	public  TipoMaquinaEmpresa getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoMaquinaEmpresa entity = new TipoMaquinaEmpresa();		
		
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
	
	public  TipoMaquinaEmpresa getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoMaquinaEmpresa entity = new TipoMaquinaEmpresa();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoMaquinaEmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoMaquinaEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Produccion.TipoMaquinaEmpresa.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoMaquinaEmpresaOriginal(new TipoMaquinaEmpresa());
      	    	entity=super.getEntity("",entity,resultSet,TipoMaquinaEmpresaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoMaquinaEmpresa("",entity,resultSet); 
				
				//entity.setTipoMaquinaEmpresaOriginal(super.getEntity("",entity.getTipoMaquinaEmpresaOriginal(),resultSet,TipoMaquinaEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoMaquinaEmpresaOriginal(this.getEntityTipoMaquinaEmpresa("",entity.getTipoMaquinaEmpresaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoMaquinaEmpresa(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoMaquinaEmpresa getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoMaquinaEmpresa entity = new TipoMaquinaEmpresa();
				
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
	
	public  TipoMaquinaEmpresa getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoMaquinaEmpresa entity = new TipoMaquinaEmpresa();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoMaquinaEmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoMaquinaEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoMaquinaEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.TipoMaquinaEmpresa.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoMaquinaEmpresaOriginal(new TipoMaquinaEmpresa());
      	    	entity=super.getEntity("",entity,resultSet,TipoMaquinaEmpresaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoMaquinaEmpresa("",entity,resultSet);    
				
				//entity.setTipoMaquinaEmpresaOriginal(super.getEntity("",entity.getTipoMaquinaEmpresaOriginal(),resultSet,TipoMaquinaEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoMaquinaEmpresaOriginal(this.getEntityTipoMaquinaEmpresa("",entity.getTipoMaquinaEmpresaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoMaquinaEmpresa(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoMaquinaEmpresa
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoMaquinaEmpresa entity = new TipoMaquinaEmpresa();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoMaquinaEmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoMaquinaEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoMaquinaEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.TipoMaquinaEmpresa.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoMaquinaEmpresa(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoMaquinaEmpresa> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoMaquinaEmpresa> entities = new  ArrayList<TipoMaquinaEmpresa>();
		TipoMaquinaEmpresa entity = new TipoMaquinaEmpresa();		  
		
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
	
	public  List<TipoMaquinaEmpresa> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoMaquinaEmpresa> entities = new  ArrayList<TipoMaquinaEmpresa>();
		TipoMaquinaEmpresa entity = new TipoMaquinaEmpresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoMaquinaEmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoMaquinaEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoMaquinaEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoMaquinaEmpresa();
      	    	entity=super.getEntity("",entity,resultSet,TipoMaquinaEmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoMaquinaEmpresa("",entity,resultSet);
      	    	
				//entity.setTipoMaquinaEmpresaOriginal( new TipoMaquinaEmpresa());
      	    	//entity.setTipoMaquinaEmpresaOriginal(super.getEntity("",entity.getTipoMaquinaEmpresaOriginal(),resultSet,TipoMaquinaEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoMaquinaEmpresaOriginal(this.getEntityTipoMaquinaEmpresa("",entity.getTipoMaquinaEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoMaquinaEmpresas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoMaquinaEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoMaquinaEmpresa> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoMaquinaEmpresa> entities = new  ArrayList<TipoMaquinaEmpresa>();
		TipoMaquinaEmpresa entity = new TipoMaquinaEmpresa();		  
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
	
	public  List<TipoMaquinaEmpresa> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoMaquinaEmpresa> entities = new  ArrayList<TipoMaquinaEmpresa>();
		TipoMaquinaEmpresa entity = new TipoMaquinaEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoMaquinaEmpresa();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoMaquinaEmpresa();
					//entity.setMapTipoMaquinaEmpresa(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoMaquinaEmpresaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoMaquinaEmpresa().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoMaquinaEmpresaDataAccess.ISWITHSCHEMA);         		
					entity=TipoMaquinaEmpresaDataAccess.getEntityTipoMaquinaEmpresa("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoMaquinaEmpresaOriginal( new TipoMaquinaEmpresa());
					////entity.setTipoMaquinaEmpresaOriginal(super.getEntity("",entity.getTipoMaquinaEmpresaOriginal(),resultSet,TipoMaquinaEmpresaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoMaquinaEmpresaOriginal(this.getEntityTipoMaquinaEmpresa("",entity.getTipoMaquinaEmpresaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoMaquinaEmpresas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoMaquinaEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoMaquinaEmpresa getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoMaquinaEmpresa entity = new TipoMaquinaEmpresa();		  
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
	
	public  TipoMaquinaEmpresa getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoMaquinaEmpresa entity = new TipoMaquinaEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoMaquinaEmpresa();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoMaquinaEmpresa();
					//entity.setMapTipoMaquinaEmpresa(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoMaquinaEmpresaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoMaquinaEmpresa().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoMaquinaEmpresaDataAccess.ISWITHSCHEMA);         		
					entity=TipoMaquinaEmpresaDataAccess.getEntityTipoMaquinaEmpresa("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoMaquinaEmpresaOriginal( new TipoMaquinaEmpresa());
					////entity.setTipoMaquinaEmpresaOriginal(super.getEntity("",entity.getTipoMaquinaEmpresaOriginal(),resultSet,TipoMaquinaEmpresaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoMaquinaEmpresaOriginal(this.getEntityTipoMaquinaEmpresa("",entity.getTipoMaquinaEmpresaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoMaquinaEmpresa(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoMaquinaEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoMaquinaEmpresa getEntityTipoMaquinaEmpresa(String strPrefijo,TipoMaquinaEmpresa entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoMaquinaEmpresa.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoMaquinaEmpresa.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoMaquinaEmpresaDataAccess.setFieldReflectionTipoMaquinaEmpresa(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoMaquinaEmpresa=TipoMaquinaEmpresaConstantesFunciones.getTodosTiposColumnasTipoMaquinaEmpresa();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoMaquinaEmpresa) {
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
							field = TipoMaquinaEmpresa.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoMaquinaEmpresa.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoMaquinaEmpresaDataAccess.setFieldReflectionTipoMaquinaEmpresa(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoMaquinaEmpresa(Field field,String strPrefijo,String sColumn,TipoMaquinaEmpresa entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoMaquinaEmpresaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoMaquinaEmpresaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoMaquinaEmpresaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoMaquinaEmpresaConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoMaquinaEmpresaConstantesFunciones.IDCUENTACONTABLEDEBITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoMaquinaEmpresaConstantesFunciones.IDCUENTACONTABLECREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoMaquinaEmpresaConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoMaquinaEmpresaConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoMaquinaEmpresaConstantesFunciones.MARCA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoMaquinaEmpresaConstantesFunciones.MODELO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoMaquinaEmpresaConstantesFunciones.COSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TipoMaquinaEmpresaConstantesFunciones.ESTAACTIVO:
					field.set(entity,resultSet.getBoolean(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoMaquinaEmpresa>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoMaquinaEmpresa> entities = new  ArrayList<TipoMaquinaEmpresa>();
		TipoMaquinaEmpresa entity = new TipoMaquinaEmpresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoMaquinaEmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoMaquinaEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoMaquinaEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoMaquinaEmpresa();
					entity=super.getEntity("",entity,resultSet,TipoMaquinaEmpresaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoMaquinaEmpresa("",entity,resultSet);
					
					//entity.setTipoMaquinaEmpresaOriginal( new TipoMaquinaEmpresa());
					//entity.setTipoMaquinaEmpresaOriginal(super.getEntity("",entity.getTipoMaquinaEmpresaOriginal(),resultSet,TipoMaquinaEmpresaDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoMaquinaEmpresaOriginal(this.getEntityTipoMaquinaEmpresa("",entity.getTipoMaquinaEmpresaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoMaquinaEmpresas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoMaquinaEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoMaquinaEmpresa>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoMaquinaEmpresa> entities = new  ArrayList<TipoMaquinaEmpresa>();
		TipoMaquinaEmpresa entity = new TipoMaquinaEmpresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoMaquinaEmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoMaquinaEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoMaquinaEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoMaquinaEmpresa> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoMaquinaEmpresa> entities = new  ArrayList<TipoMaquinaEmpresa>();
		TipoMaquinaEmpresa entity = new TipoMaquinaEmpresa();		  
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
	
	public  List<TipoMaquinaEmpresa> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoMaquinaEmpresa> entities = new  ArrayList<TipoMaquinaEmpresa>();
		TipoMaquinaEmpresa entity = new TipoMaquinaEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoMaquinaEmpresa();
      	    	entity=super.getEntity("",entity,resultSet,TipoMaquinaEmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoMaquinaEmpresa("",entity,resultSet);
      	    	
				//entity.setTipoMaquinaEmpresaOriginal( new TipoMaquinaEmpresa());
      	    	//entity.setTipoMaquinaEmpresaOriginal(super.getEntity("",entity.getTipoMaquinaEmpresaOriginal(),resultSet,TipoMaquinaEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoMaquinaEmpresaOriginal(this.getEntityTipoMaquinaEmpresa("",entity.getTipoMaquinaEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoMaquinaEmpresas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoMaquinaEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoMaquinaEmpresa> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoMaquinaEmpresa> entities = new  ArrayList<TipoMaquinaEmpresa>();
		TipoMaquinaEmpresa entity = new TipoMaquinaEmpresa();		  
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
	
	public  List<TipoMaquinaEmpresa> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoMaquinaEmpresa> entities = new  ArrayList<TipoMaquinaEmpresa>();
		TipoMaquinaEmpresa entity = new TipoMaquinaEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoMaquinaEmpresa();
      	    	entity=super.getEntity("",entity,resultSet,TipoMaquinaEmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoMaquinaEmpresa("",entity,resultSet);
      	    	
				//entity.setTipoMaquinaEmpresaOriginal( new TipoMaquinaEmpresa());
      	    	//entity.setTipoMaquinaEmpresaOriginal(super.getEntity("",entity.getTipoMaquinaEmpresaOriginal(),resultSet,TipoMaquinaEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoMaquinaEmpresaOriginal(this.getEntityTipoMaquinaEmpresa("",entity.getTipoMaquinaEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoMaquinaEmpresas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoMaquinaEmpresa getEntityTipoMaquinaEmpresa(String strPrefijo,TipoMaquinaEmpresa entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoMaquinaEmpresaConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+TipoMaquinaEmpresaConstantesFunciones.IDSUCURSAL));
				entity.setid_cuenta_contable_debito(resultSet.getLong(strPrefijo+TipoMaquinaEmpresaConstantesFunciones.IDCUENTACONTABLEDEBITO));
				entity.setid_cuenta_contable_credito(resultSet.getLong(strPrefijo+TipoMaquinaEmpresaConstantesFunciones.IDCUENTACONTABLECREDITO));
				entity.setcodigo(resultSet.getString(strPrefijo+TipoMaquinaEmpresaConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoMaquinaEmpresaConstantesFunciones.NOMBRE));
				entity.setmarca(resultSet.getString(strPrefijo+TipoMaquinaEmpresaConstantesFunciones.MARCA));
				entity.setmodelo(resultSet.getString(strPrefijo+TipoMaquinaEmpresaConstantesFunciones.MODELO));
				entity.setcosto(resultSet.getDouble(strPrefijo+TipoMaquinaEmpresaConstantesFunciones.COSTO));
				entity.setesta_activo(resultSet.getBoolean(strPrefijo+TipoMaquinaEmpresaConstantesFunciones.ESTAACTIVO));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoMaquinaEmpresaConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoMaquinaEmpresa(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoMaquinaEmpresa entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoMaquinaEmpresaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoMaquinaEmpresaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoMaquinaEmpresaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoMaquinaEmpresaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoMaquinaEmpresaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoMaquinaEmpresaDataAccess.TABLENAME,TipoMaquinaEmpresaDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoMaquinaEmpresaDataAccess.setTipoMaquinaEmpresaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoMaquinaEmpresa reltipomaquinaempresa)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipomaquinaempresa.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,TipoMaquinaEmpresa reltipomaquinaempresa)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reltipomaquinaempresa.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public CuentaContable getCuentaContableDebito(Connexion connexion,TipoMaquinaEmpresa reltipomaquinaempresa)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reltipomaquinaempresa.getid_cuenta_contable_debito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableCredito(Connexion connexion,TipoMaquinaEmpresa reltipomaquinaempresa)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reltipomaquinaempresa.getid_cuenta_contable_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
		public List<ProductoOrdenDetaProduMaquina> getProductoOrdenDetaProduMaquinas(Connexion connexion,TipoMaquinaEmpresa tipomaquinaempresa)throws SQLException,Exception {

		List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas= new ArrayList<ProductoOrdenDetaProduMaquina>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+".tipo_maquina_empresa ON "+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+".producto_orden_deta_produ_maquina.id_tipo_maquina_empresa="+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+".tipo_maquina_empresa.id WHERE "+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+".tipo_maquina_empresa.id="+String.valueOf(tipomaquinaempresa.getId());
			} else {
				sQuery=" INNER JOIN productoordendetaprodumaquina.TipoMaquinaEmpresa WHERE productoordendetaprodumaquina.TipoMaquinaEmpresa.id="+String.valueOf(tipomaquinaempresa.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoOrdenDetaProduMaquinaDataAccess productoordendetaprodumaquinaDataAccess=new ProductoOrdenDetaProduMaquinaDataAccess();

			productoordendetaprodumaquinaDataAccess.setConnexionType(this.connexionType);
			productoordendetaprodumaquinaDataAccess.setParameterDbType(this.parameterDbType);
			productoordendetaprodumaquinas=productoordendetaprodumaquinaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productoordendetaprodumaquinas;

	}

	public List<ProductoProduMaquina> getProductoProduMaquinas(Connexion connexion,TipoMaquinaEmpresa tipomaquinaempresa)throws SQLException,Exception {

		List<ProductoProduMaquina> productoprodumaquinas= new ArrayList<ProductoProduMaquina>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+".tipo_maquina_empresa ON "+ProductoProduMaquinaConstantesFunciones.SCHEMA+".producto_produ_maquina.id_tipo_maquina_empresa="+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+".tipo_maquina_empresa.id WHERE "+TipoMaquinaEmpresaConstantesFunciones.SCHEMA+".tipo_maquina_empresa.id="+String.valueOf(tipomaquinaempresa.getId());
			} else {
				sQuery=" INNER JOIN productoprodumaquina.TipoMaquinaEmpresa WHERE productoprodumaquina.TipoMaquinaEmpresa.id="+String.valueOf(tipomaquinaempresa.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoProduMaquinaDataAccess productoprodumaquinaDataAccess=new ProductoProduMaquinaDataAccess();

			productoprodumaquinaDataAccess.setConnexionType(this.connexionType);
			productoprodumaquinaDataAccess.setParameterDbType(this.parameterDbType);
			productoprodumaquinas=productoprodumaquinaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productoprodumaquinas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoMaquinaEmpresa tipomaquinaempresa) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipomaquinaempresa.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipomaquinaempresa.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(tipomaquinaempresa.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_debito=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_debito.setValue(tipomaquinaempresa.getid_cuenta_contable_debito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_debito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_credito.setValue(tipomaquinaempresa.getid_cuenta_contable_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipomaquinaempresa.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipomaquinaempresa.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuemarca=new ParameterValue<String>();
					parameterMaintenanceValuemarca.setValue(tipomaquinaempresa.getmarca());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemarca);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuemodelo=new ParameterValue<String>();
					parameterMaintenanceValuemodelo.setValue(tipomaquinaempresa.getmodelo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemodelo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto=new ParameterValue<Double>();
					parameterMaintenanceValuecosto.setValue(tipomaquinaempresa.getcosto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesta_activo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesta_activo.setValue(tipomaquinaempresa.getesta_activo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesta_activo);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipomaquinaempresa.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipomaquinaempresa.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipomaquinaempresa.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipomaquinaempresa.getId());
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
	
	public void setIsNewIsChangedFalseTipoMaquinaEmpresa(TipoMaquinaEmpresa tipomaquinaempresa)throws Exception  {		
		tipomaquinaempresa.setIsNew(false);
		tipomaquinaempresa.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoMaquinaEmpresas(List<TipoMaquinaEmpresa> tipomaquinaempresas)throws Exception  {				
		for(TipoMaquinaEmpresa tipomaquinaempresa:tipomaquinaempresas) {
			tipomaquinaempresa.setIsNew(false);
			tipomaquinaempresa.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoMaquinaEmpresa(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
