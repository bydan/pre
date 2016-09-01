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
package com.bydan.erp.facturacion.business.dataaccess;

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

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.util.*;//CuentaContableTipoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class CuentaContableTipoDataAccess extends  CuentaContableTipoDataAccessAdditional{ //CuentaContableTipoDataAccessAdditional,DataAccessHelper<CuentaContableTipo>
	//static Logger logger = Logger.getLogger(CuentaContableTipoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="cuenta_contable_tipo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME+"(version_row,id_empresa,nombre,digito_verificador,id_tipo_cuenta_contable_tipo,id_tipo_producto_servicio,id_cuenta_contable_venta,id_cuenta_contable_descuento,id_cuenta_contable_devolucion,id_cuenta_contable_costo)values(current_timestamp,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?,digito_verificador=?,id_tipo_cuenta_contable_tipo=?,id_tipo_producto_servicio=?,id_cuenta_contable_venta=?,id_cuenta_contable_descuento=?,id_cuenta_contable_devolucion=?,id_cuenta_contable_costo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select cuentacontabletipo from "+CuentaContableTipoConstantesFunciones.SPERSISTENCENAME+" cuentacontabletipo";
	public static String QUERYSELECTNATIVE="select "+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME+".id,"+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME+".version_row,"+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME+".id_empresa,"+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME+".nombre,"+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME+".digito_verificador,"+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME+".id_tipo_cuenta_contable_tipo,"+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME+".id_tipo_producto_servicio,"+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME+".id_cuenta_contable_venta,"+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME+".id_cuenta_contable_descuento,"+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME+".id_cuenta_contable_devolucion,"+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME+".id_cuenta_contable_costo from "+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME;//+" as "+CuentaContableTipoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME+".id,"+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME+".version_row,"+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME+".nombre from "+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME;//+" as "+CuentaContableTipoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?,digito_verificador=?,id_tipo_cuenta_contable_tipo=?,id_tipo_producto_servicio=?,id_cuenta_contable_venta=?,id_cuenta_contable_descuento=?,id_cuenta_contable_devolucion=?,id_cuenta_contable_costo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CUENTACONTABLETIPO_INSERT(?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CUENTACONTABLETIPO_UPDATE(?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CUENTACONTABLETIPO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CUENTACONTABLETIPO_SELECT(?,?)";
	
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
	
	
	protected CuentaContableTipoDataAccessAdditional cuentacontabletipoDataAccessAdditional=null;
	
	public CuentaContableTipoDataAccessAdditional getCuentaContableTipoDataAccessAdditional() {
		return this.cuentacontabletipoDataAccessAdditional;
	}
	
	public void setCuentaContableTipoDataAccessAdditional(CuentaContableTipoDataAccessAdditional cuentacontabletipoDataAccessAdditional) {
		try {
			this.cuentacontabletipoDataAccessAdditional=cuentacontabletipoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public CuentaContableTipoDataAccess() {
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
		CuentaContableTipoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		CuentaContableTipoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		CuentaContableTipoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setCuentaContableTipoOriginal(CuentaContableTipo cuentacontabletipo)throws Exception  {
		cuentacontabletipo.setCuentaContableTipoOriginal((CuentaContableTipo)cuentacontabletipo.clone());		
	}
	
	public void setCuentaContableTiposOriginal(List<CuentaContableTipo> cuentacontabletipos)throws Exception  {
		
		for(CuentaContableTipo cuentacontabletipo:cuentacontabletipos){
			cuentacontabletipo.setCuentaContableTipoOriginal((CuentaContableTipo)cuentacontabletipo.clone());
		}
	}
	
	public static void setCuentaContableTipoOriginalStatic(CuentaContableTipo cuentacontabletipo)throws Exception  {
		cuentacontabletipo.setCuentaContableTipoOriginal((CuentaContableTipo)cuentacontabletipo.clone());		
	}
	
	public static void setCuentaContableTiposOriginalStatic(List<CuentaContableTipo> cuentacontabletipos)throws Exception  {
		
		for(CuentaContableTipo cuentacontabletipo:cuentacontabletipos){
			cuentacontabletipo.setCuentaContableTipoOriginal((CuentaContableTipo)cuentacontabletipo.clone());
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
	
	public  CuentaContableTipo getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		CuentaContableTipo entity = new CuentaContableTipo();		
		
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
	
	public  CuentaContableTipo getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		CuentaContableTipo entity = new CuentaContableTipo();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CuentaContableTipoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CuentaContableTipoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.CuentaContableTipo.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setCuentaContableTipoOriginal(new CuentaContableTipo());
      	    	entity=super.getEntity("",entity,resultSet,CuentaContableTipoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCuentaContableTipo("",entity,resultSet); 
				
				//entity.setCuentaContableTipoOriginal(super.getEntity("",entity.getCuentaContableTipoOriginal(),resultSet,CuentaContableTipoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaContableTipoOriginal(this.getEntityCuentaContableTipo("",entity.getCuentaContableTipoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseCuentaContableTipo(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  CuentaContableTipo getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CuentaContableTipo entity = new CuentaContableTipo();
				
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
	
	public  CuentaContableTipo getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CuentaContableTipo entity = new CuentaContableTipo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CuentaContableTipoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CuentaContableTipoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaContableTipoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.CuentaContableTipo.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setCuentaContableTipoOriginal(new CuentaContableTipo());
      	    	entity=super.getEntity("",entity,resultSet,CuentaContableTipoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCuentaContableTipo("",entity,resultSet);    
				
				//entity.setCuentaContableTipoOriginal(super.getEntity("",entity.getCuentaContableTipoOriginal(),resultSet,CuentaContableTipoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaContableTipoOriginal(this.getEntityCuentaContableTipo("",entity.getCuentaContableTipoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseCuentaContableTipo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //CuentaContableTipo
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		CuentaContableTipo entity = new CuentaContableTipo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CuentaContableTipoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CuentaContableTipoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaContableTipoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.CuentaContableTipo.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseCuentaContableTipo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<CuentaContableTipo> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CuentaContableTipo> entities = new  ArrayList<CuentaContableTipo>();
		CuentaContableTipo entity = new CuentaContableTipo();		  
		
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
	
	public  List<CuentaContableTipo> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CuentaContableTipo> entities = new  ArrayList<CuentaContableTipo>();
		CuentaContableTipo entity = new CuentaContableTipo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=CuentaContableTipoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CuentaContableTipoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaContableTipoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaContableTipo();
      	    	entity=super.getEntity("",entity,resultSet,CuentaContableTipoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCuentaContableTipo("",entity,resultSet);
      	    	
				//entity.setCuentaContableTipoOriginal( new CuentaContableTipo());
      	    	//entity.setCuentaContableTipoOriginal(super.getEntity("",entity.getCuentaContableTipoOriginal(),resultSet,CuentaContableTipoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaContableTipoOriginal(this.getEntityCuentaContableTipo("",entity.getCuentaContableTipoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCuentaContableTipos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaContableTipo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CuentaContableTipo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CuentaContableTipo> entities = new  ArrayList<CuentaContableTipo>();
		CuentaContableTipo entity = new CuentaContableTipo();		  
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
	
	public  List<CuentaContableTipo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CuentaContableTipo> entities = new  ArrayList<CuentaContableTipo>();
		CuentaContableTipo entity = new CuentaContableTipo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaContableTipo();
				
				if(conMapGenerico) {
					entity.inicializarMapCuentaContableTipo();
					//entity.setMapCuentaContableTipo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapCuentaContableTipoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCuentaContableTipo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CuentaContableTipoDataAccess.ISWITHSCHEMA);         		
					entity=CuentaContableTipoDataAccess.getEntityCuentaContableTipo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCuentaContableTipoOriginal( new CuentaContableTipo());
					////entity.setCuentaContableTipoOriginal(super.getEntity("",entity.getCuentaContableTipoOriginal(),resultSet,CuentaContableTipoDataAccess.ISWITHSCHEMA));         		
					////entity.setCuentaContableTipoOriginal(this.getEntityCuentaContableTipo("",entity.getCuentaContableTipoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCuentaContableTipos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaContableTipo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public CuentaContableTipo getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CuentaContableTipo entity = new CuentaContableTipo();		  
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
	
	public  CuentaContableTipo getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CuentaContableTipo entity = new CuentaContableTipo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaContableTipo();
				
				if(conMapGenerico) {
					entity.inicializarMapCuentaContableTipo();
					//entity.setMapCuentaContableTipo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapCuentaContableTipoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCuentaContableTipo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CuentaContableTipoDataAccess.ISWITHSCHEMA);         		
					entity=CuentaContableTipoDataAccess.getEntityCuentaContableTipo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCuentaContableTipoOriginal( new CuentaContableTipo());
					////entity.setCuentaContableTipoOriginal(super.getEntity("",entity.getCuentaContableTipoOriginal(),resultSet,CuentaContableTipoDataAccess.ISWITHSCHEMA));         		
					////entity.setCuentaContableTipoOriginal(this.getEntityCuentaContableTipo("",entity.getCuentaContableTipoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseCuentaContableTipo(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaContableTipo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CuentaContableTipo getEntityCuentaContableTipo(String strPrefijo,CuentaContableTipo entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = CuentaContableTipo.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = CuentaContableTipo.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					CuentaContableTipoDataAccess.setFieldReflectionCuentaContableTipo(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasCuentaContableTipo=CuentaContableTipoConstantesFunciones.getTodosTiposColumnasCuentaContableTipo();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasCuentaContableTipo) {
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
							field = CuentaContableTipo.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = CuentaContableTipo.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						CuentaContableTipoDataAccess.setFieldReflectionCuentaContableTipo(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCuentaContableTipo(Field field,String strPrefijo,String sColumn,CuentaContableTipo entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CuentaContableTipoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaContableTipoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CuentaContableTipoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaContableTipoConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CuentaContableTipoConstantesFunciones.DIGITOVERIFICADOR:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case CuentaContableTipoConstantesFunciones.IDTIPOCUENTACONTABLETIPO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaContableTipoConstantesFunciones.IDTIPOPRODUCTOSERVICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEVENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEDESCUENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaContableTipoConstantesFunciones.IDCUENTACONTABLECOSTO:
					field.set(entity,resultSet.getLong(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CuentaContableTipo>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<CuentaContableTipo> entities = new  ArrayList<CuentaContableTipo>();
		CuentaContableTipo entity = new CuentaContableTipo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CuentaContableTipoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CuentaContableTipoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaContableTipoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new CuentaContableTipo();
					entity=super.getEntity("",entity,resultSet,CuentaContableTipoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityCuentaContableTipo("",entity,resultSet);
					
					//entity.setCuentaContableTipoOriginal( new CuentaContableTipo());
					//entity.setCuentaContableTipoOriginal(super.getEntity("",entity.getCuentaContableTipoOriginal(),resultSet,CuentaContableTipoDataAccess.ISWITHSCHEMA));         		
					//entity.setCuentaContableTipoOriginal(this.getEntityCuentaContableTipo("",entity.getCuentaContableTipoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseCuentaContableTipos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaContableTipo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CuentaContableTipo>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<CuentaContableTipo> entities = new  ArrayList<CuentaContableTipo>();
		CuentaContableTipo entity = new CuentaContableTipo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CuentaContableTipoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CuentaContableTipoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaContableTipoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<CuentaContableTipo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentaContableTipo> entities = new  ArrayList<CuentaContableTipo>();
		CuentaContableTipo entity = new CuentaContableTipo();		  
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
	
	public  List<CuentaContableTipo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentaContableTipo> entities = new  ArrayList<CuentaContableTipo>();
		CuentaContableTipo entity = new CuentaContableTipo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaContableTipo();
      	    	entity=super.getEntity("",entity,resultSet,CuentaContableTipoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCuentaContableTipo("",entity,resultSet);
      	    	
				//entity.setCuentaContableTipoOriginal( new CuentaContableTipo());
      	    	//entity.setCuentaContableTipoOriginal(super.getEntity("",entity.getCuentaContableTipoOriginal(),resultSet,CuentaContableTipoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaContableTipoOriginal(this.getEntityCuentaContableTipo("",entity.getCuentaContableTipoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseCuentaContableTipos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaContableTipo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CuentaContableTipo> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentaContableTipo> entities = new  ArrayList<CuentaContableTipo>();
		CuentaContableTipo entity = new CuentaContableTipo();		  
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
	
	public  List<CuentaContableTipo> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentaContableTipo> entities = new  ArrayList<CuentaContableTipo>();
		CuentaContableTipo entity = new CuentaContableTipo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaContableTipo();
      	    	entity=super.getEntity("",entity,resultSet,CuentaContableTipoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCuentaContableTipo("",entity,resultSet);
      	    	
				//entity.setCuentaContableTipoOriginal( new CuentaContableTipo());
      	    	//entity.setCuentaContableTipoOriginal(super.getEntity("",entity.getCuentaContableTipoOriginal(),resultSet,CuentaContableTipoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaContableTipoOriginal(this.getEntityCuentaContableTipo("",entity.getCuentaContableTipoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCuentaContableTipos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public CuentaContableTipo getEntityCuentaContableTipo(String strPrefijo,CuentaContableTipo entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+CuentaContableTipoConstantesFunciones.IDEMPRESA));
				entity.setnombre(resultSet.getString(strPrefijo+CuentaContableTipoConstantesFunciones.NOMBRE));
				entity.setdigito_verificador(resultSet.getInt(strPrefijo+CuentaContableTipoConstantesFunciones.DIGITOVERIFICADOR));
				entity.setid_tipo_cuenta_contable_tipo(resultSet.getLong(strPrefijo+CuentaContableTipoConstantesFunciones.IDTIPOCUENTACONTABLETIPO));
				entity.setid_tipo_producto_servicio(resultSet.getLong(strPrefijo+CuentaContableTipoConstantesFunciones.IDTIPOPRODUCTOSERVICIO));
				entity.setid_cuenta_contable_venta(resultSet.getLong(strPrefijo+CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEVENTA));if(resultSet.wasNull()) {entity.setid_cuenta_contable_venta(null); }
				entity.setid_cuenta_contable_descuento(resultSet.getLong(strPrefijo+CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEDESCUENTO));if(resultSet.wasNull()) {entity.setid_cuenta_contable_descuento(null); }
				entity.setid_cuenta_contable_devolucion(resultSet.getLong(strPrefijo+CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION));if(resultSet.wasNull()) {entity.setid_cuenta_contable_devolucion(null); }
				entity.setid_cuenta_contable_costo(resultSet.getLong(strPrefijo+CuentaContableTipoConstantesFunciones.IDCUENTACONTABLECOSTO));if(resultSet.wasNull()) {entity.setid_cuenta_contable_costo(null); }
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+CuentaContableTipoConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowCuentaContableTipo(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(CuentaContableTipo entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=CuentaContableTipoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=CuentaContableTipoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=CuentaContableTipoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=CuentaContableTipoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(CuentaContableTipoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,CuentaContableTipoDataAccess.TABLENAME,CuentaContableTipoDataAccess.ISWITHSTOREPROCEDURES);
			
			CuentaContableTipoDataAccess.setCuentaContableTipoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,CuentaContableTipo relcuentacontabletipo)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcuentacontabletipo.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public TipoCuentaContableTipo getTipoCuentaContableTipo(Connexion connexion,CuentaContableTipo relcuentacontabletipo)throws SQLException,Exception {

		TipoCuentaContableTipo tipocuentacontabletipo= new TipoCuentaContableTipo();

		try {
			TipoCuentaContableTipoDataAccess tipocuentacontabletipoDataAccess=new TipoCuentaContableTipoDataAccess();

			tipocuentacontabletipoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocuentacontabletipoDataAccess.setConnexionType(this.connexionType);
			tipocuentacontabletipoDataAccess.setParameterDbType(this.parameterDbType);

			tipocuentacontabletipo=tipocuentacontabletipoDataAccess.getEntity(connexion,relcuentacontabletipo.getid_tipo_cuenta_contable_tipo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocuentacontabletipo;

	}

	public TipoProductoServicio getTipoProductoServicio(Connexion connexion,CuentaContableTipo relcuentacontabletipo)throws SQLException,Exception {

		TipoProductoServicio tipoproductoservicio= new TipoProductoServicio();

		try {
			TipoProductoServicioDataAccess tipoproductoservicioDataAccess=new TipoProductoServicioDataAccess();

			tipoproductoservicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoproductoservicioDataAccess.setConnexionType(this.connexionType);
			tipoproductoservicioDataAccess.setParameterDbType(this.parameterDbType);

			tipoproductoservicio=tipoproductoservicioDataAccess.getEntity(connexion,relcuentacontabletipo.getid_tipo_producto_servicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoproductoservicio;

	}

	public CuentaContable getCuentaContableVenta(Connexion connexion,CuentaContableTipo relcuentacontabletipo)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relcuentacontabletipo.getid_cuenta_contable_venta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableDescuento(Connexion connexion,CuentaContableTipo relcuentacontabletipo)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relcuentacontabletipo.getid_cuenta_contable_descuento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableDevolucion(Connexion connexion,CuentaContableTipo relcuentacontabletipo)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relcuentacontabletipo.getid_cuenta_contable_devolucion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableCosto(Connexion connexion,CuentaContableTipo relcuentacontabletipo)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relcuentacontabletipo.getid_cuenta_contable_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,CuentaContableTipo cuentacontabletipo) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!cuentacontabletipo.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(cuentacontabletipo.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(cuentacontabletipo.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuedigito_verificador=new ParameterValue<Integer>();
					parameterMaintenanceValuedigito_verificador.setValue(cuentacontabletipo.getdigito_verificador());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedigito_verificador);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_cuenta_contable_tipo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_cuenta_contable_tipo.setValue(cuentacontabletipo.getid_tipo_cuenta_contable_tipo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_cuenta_contable_tipo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_producto_servicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_producto_servicio.setValue(cuentacontabletipo.getid_tipo_producto_servicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_producto_servicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_venta=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_venta.setValue(cuentacontabletipo.getid_cuenta_contable_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_descuento=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_descuento.setValue(cuentacontabletipo.getid_cuenta_contable_descuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_descuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_devolucion=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_devolucion.setValue(cuentacontabletipo.getid_cuenta_contable_devolucion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_devolucion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_costo.setValue(cuentacontabletipo.getid_cuenta_contable_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_costo);
					parametersTemp.add(parameterMaintenance);
					
						if(!cuentacontabletipo.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(cuentacontabletipo.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(cuentacontabletipo.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(cuentacontabletipo.getId());
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
	
	public void setIsNewIsChangedFalseCuentaContableTipo(CuentaContableTipo cuentacontabletipo)throws Exception  {		
		cuentacontabletipo.setIsNew(false);
		cuentacontabletipo.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseCuentaContableTipos(List<CuentaContableTipo> cuentacontabletipos)throws Exception  {				
		for(CuentaContableTipo cuentacontabletipo:cuentacontabletipos) {
			cuentacontabletipo.setIsNew(false);
			cuentacontabletipo.setIsChanged(false);
		}
	}
	
	public void generarExportarCuentaContableTipo(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
