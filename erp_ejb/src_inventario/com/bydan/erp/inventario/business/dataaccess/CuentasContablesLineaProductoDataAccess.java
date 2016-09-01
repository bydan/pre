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
package com.bydan.erp.inventario.business.dataaccess;

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

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.util.*;//CuentasContablesLineaProductoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class CuentasContablesLineaProductoDataAccess extends  CuentasContablesLineaProductoDataAccessAdditional{ //CuentasContablesLineaProductoDataAccessAdditional,DataAccessHelper<CuentasContablesLineaProducto>
	//static Logger logger = Logger.getLogger(CuentasContablesLineaProductoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="cuentas_contables_linea_producto";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_bodega,id_centro_costo,id_linea,id_linea_grupo,id_linea_categoria,id_cuenta_contable_inventario,id_cuenta_contable_costo_venta,id_cuenta_contable_venta,id_cuenta_contable_descuento,id_cuenta_contable_produccion,id_cuenta_contable_devolucion,id_cuenta_contable_iva_debito,id_cuenta_contable_iva_credito,id_cuenta_contable_bonifica,id_cuenta_contable_costo_bonifica)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_bodega=?,id_centro_costo=?,id_linea=?,id_linea_grupo=?,id_linea_categoria=?,id_cuenta_contable_inventario=?,id_cuenta_contable_costo_venta=?,id_cuenta_contable_venta=?,id_cuenta_contable_descuento=?,id_cuenta_contable_produccion=?,id_cuenta_contable_devolucion=?,id_cuenta_contable_iva_debito=?,id_cuenta_contable_iva_credito=?,id_cuenta_contable_bonifica=?,id_cuenta_contable_costo_bonifica=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select cuentascontableslineaproducto from "+CuentasContablesLineaProductoConstantesFunciones.SPERSISTENCENAME+" cuentascontableslineaproducto";
	public static String QUERYSELECTNATIVE="select "+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".version_row,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_empresa,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_bodega,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_centro_costo,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_linea,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_linea_grupo,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_linea_categoria,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_inventario,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_costo_venta,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_venta,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_descuento,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_produccion,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_devolucion,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_iva_debito,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_iva_credito,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_bonifica,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_costo_bonifica from "+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME;//+" as "+CuentasContablesLineaProductoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".id,"+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+".version_row from "+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME;//+" as "+CuentasContablesLineaProductoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+"."+CuentasContablesLineaProductoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_bodega=?,id_centro_costo=?,id_linea=?,id_linea_grupo=?,id_linea_categoria=?,id_cuenta_contable_inventario=?,id_cuenta_contable_costo_venta=?,id_cuenta_contable_venta=?,id_cuenta_contable_descuento=?,id_cuenta_contable_produccion=?,id_cuenta_contable_devolucion=?,id_cuenta_contable_iva_debito=?,id_cuenta_contable_iva_credito=?,id_cuenta_contable_bonifica=?,id_cuenta_contable_costo_bonifica=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CUENTASCONTABLESLINEAPRODUCTO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CUENTASCONTABLESLINEAPRODUCTO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CUENTASCONTABLESLINEAPRODUCTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CUENTASCONTABLESLINEAPRODUCTO_SELECT(?,?)";
	
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
	
	
	protected CuentasContablesLineaProductoDataAccessAdditional cuentascontableslineaproductoDataAccessAdditional=null;
	
	public CuentasContablesLineaProductoDataAccessAdditional getCuentasContablesLineaProductoDataAccessAdditional() {
		return this.cuentascontableslineaproductoDataAccessAdditional;
	}
	
	public void setCuentasContablesLineaProductoDataAccessAdditional(CuentasContablesLineaProductoDataAccessAdditional cuentascontableslineaproductoDataAccessAdditional) {
		try {
			this.cuentascontableslineaproductoDataAccessAdditional=cuentascontableslineaproductoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public CuentasContablesLineaProductoDataAccess() {
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
		CuentasContablesLineaProductoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		CuentasContablesLineaProductoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		CuentasContablesLineaProductoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setCuentasContablesLineaProductoOriginal(CuentasContablesLineaProducto cuentascontableslineaproducto)throws Exception  {
		cuentascontableslineaproducto.setCuentasContablesLineaProductoOriginal((CuentasContablesLineaProducto)cuentascontableslineaproducto.clone());		
	}
	
	public void setCuentasContablesLineaProductosOriginal(List<CuentasContablesLineaProducto> cuentascontableslineaproductos)throws Exception  {
		
		for(CuentasContablesLineaProducto cuentascontableslineaproducto:cuentascontableslineaproductos){
			cuentascontableslineaproducto.setCuentasContablesLineaProductoOriginal((CuentasContablesLineaProducto)cuentascontableslineaproducto.clone());
		}
	}
	
	public static void setCuentasContablesLineaProductoOriginalStatic(CuentasContablesLineaProducto cuentascontableslineaproducto)throws Exception  {
		cuentascontableslineaproducto.setCuentasContablesLineaProductoOriginal((CuentasContablesLineaProducto)cuentascontableslineaproducto.clone());		
	}
	
	public static void setCuentasContablesLineaProductosOriginalStatic(List<CuentasContablesLineaProducto> cuentascontableslineaproductos)throws Exception  {
		
		for(CuentasContablesLineaProducto cuentascontableslineaproducto:cuentascontableslineaproductos){
			cuentascontableslineaproducto.setCuentasContablesLineaProductoOriginal((CuentasContablesLineaProducto)cuentascontableslineaproducto.clone());
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
	
	public  CuentasContablesLineaProducto getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		CuentasContablesLineaProducto entity = new CuentasContablesLineaProducto();		
		
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
	
	public  CuentasContablesLineaProducto getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		CuentasContablesLineaProducto entity = new CuentasContablesLineaProducto();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CuentasContablesLineaProductoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CuentasContablesLineaProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.CuentasContablesLineaProducto.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setCuentasContablesLineaProductoOriginal(new CuentasContablesLineaProducto());
      	    	entity=super.getEntity("",entity,resultSet,CuentasContablesLineaProductoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCuentasContablesLineaProducto("",entity,resultSet); 
				
				//entity.setCuentasContablesLineaProductoOriginal(super.getEntity("",entity.getCuentasContablesLineaProductoOriginal(),resultSet,CuentasContablesLineaProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentasContablesLineaProductoOriginal(this.getEntityCuentasContablesLineaProducto("",entity.getCuentasContablesLineaProductoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseCuentasContablesLineaProducto(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  CuentasContablesLineaProducto getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CuentasContablesLineaProducto entity = new CuentasContablesLineaProducto();
				
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
	
	public  CuentasContablesLineaProducto getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CuentasContablesLineaProducto entity = new CuentasContablesLineaProducto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CuentasContablesLineaProductoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CuentasContablesLineaProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentasContablesLineaProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.CuentasContablesLineaProducto.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setCuentasContablesLineaProductoOriginal(new CuentasContablesLineaProducto());
      	    	entity=super.getEntity("",entity,resultSet,CuentasContablesLineaProductoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCuentasContablesLineaProducto("",entity,resultSet);    
				
				//entity.setCuentasContablesLineaProductoOriginal(super.getEntity("",entity.getCuentasContablesLineaProductoOriginal(),resultSet,CuentasContablesLineaProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentasContablesLineaProductoOriginal(this.getEntityCuentasContablesLineaProducto("",entity.getCuentasContablesLineaProductoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseCuentasContablesLineaProducto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //CuentasContablesLineaProducto
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		CuentasContablesLineaProducto entity = new CuentasContablesLineaProducto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CuentasContablesLineaProductoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CuentasContablesLineaProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentasContablesLineaProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.CuentasContablesLineaProducto.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseCuentasContablesLineaProducto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<CuentasContablesLineaProducto> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CuentasContablesLineaProducto> entities = new  ArrayList<CuentasContablesLineaProducto>();
		CuentasContablesLineaProducto entity = new CuentasContablesLineaProducto();		  
		
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
	
	public  List<CuentasContablesLineaProducto> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CuentasContablesLineaProducto> entities = new  ArrayList<CuentasContablesLineaProducto>();
		CuentasContablesLineaProducto entity = new CuentasContablesLineaProducto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=CuentasContablesLineaProductoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CuentasContablesLineaProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentasContablesLineaProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentasContablesLineaProducto();
      	    	entity=super.getEntity("",entity,resultSet,CuentasContablesLineaProductoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCuentasContablesLineaProducto("",entity,resultSet);
      	    	
				//entity.setCuentasContablesLineaProductoOriginal( new CuentasContablesLineaProducto());
      	    	//entity.setCuentasContablesLineaProductoOriginal(super.getEntity("",entity.getCuentasContablesLineaProductoOriginal(),resultSet,CuentasContablesLineaProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentasContablesLineaProductoOriginal(this.getEntityCuentasContablesLineaProducto("",entity.getCuentasContablesLineaProductoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCuentasContablesLineaProductos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentasContablesLineaProducto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CuentasContablesLineaProducto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CuentasContablesLineaProducto> entities = new  ArrayList<CuentasContablesLineaProducto>();
		CuentasContablesLineaProducto entity = new CuentasContablesLineaProducto();		  
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
	
	public  List<CuentasContablesLineaProducto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CuentasContablesLineaProducto> entities = new  ArrayList<CuentasContablesLineaProducto>();
		CuentasContablesLineaProducto entity = new CuentasContablesLineaProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentasContablesLineaProducto();
				
				if(conMapGenerico) {
					entity.inicializarMapCuentasContablesLineaProducto();
					//entity.setMapCuentasContablesLineaProducto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapCuentasContablesLineaProductoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCuentasContablesLineaProducto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CuentasContablesLineaProductoDataAccess.ISWITHSCHEMA);         		
					entity=CuentasContablesLineaProductoDataAccess.getEntityCuentasContablesLineaProducto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCuentasContablesLineaProductoOriginal( new CuentasContablesLineaProducto());
					////entity.setCuentasContablesLineaProductoOriginal(super.getEntity("",entity.getCuentasContablesLineaProductoOriginal(),resultSet,CuentasContablesLineaProductoDataAccess.ISWITHSCHEMA));         		
					////entity.setCuentasContablesLineaProductoOriginal(this.getEntityCuentasContablesLineaProducto("",entity.getCuentasContablesLineaProductoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCuentasContablesLineaProductos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentasContablesLineaProducto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public CuentasContablesLineaProducto getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CuentasContablesLineaProducto entity = new CuentasContablesLineaProducto();		  
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
	
	public  CuentasContablesLineaProducto getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CuentasContablesLineaProducto entity = new CuentasContablesLineaProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentasContablesLineaProducto();
				
				if(conMapGenerico) {
					entity.inicializarMapCuentasContablesLineaProducto();
					//entity.setMapCuentasContablesLineaProducto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapCuentasContablesLineaProductoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCuentasContablesLineaProducto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CuentasContablesLineaProductoDataAccess.ISWITHSCHEMA);         		
					entity=CuentasContablesLineaProductoDataAccess.getEntityCuentasContablesLineaProducto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCuentasContablesLineaProductoOriginal( new CuentasContablesLineaProducto());
					////entity.setCuentasContablesLineaProductoOriginal(super.getEntity("",entity.getCuentasContablesLineaProductoOriginal(),resultSet,CuentasContablesLineaProductoDataAccess.ISWITHSCHEMA));         		
					////entity.setCuentasContablesLineaProductoOriginal(this.getEntityCuentasContablesLineaProducto("",entity.getCuentasContablesLineaProductoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseCuentasContablesLineaProducto(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentasContablesLineaProducto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CuentasContablesLineaProducto getEntityCuentasContablesLineaProducto(String strPrefijo,CuentasContablesLineaProducto entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = CuentasContablesLineaProducto.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = CuentasContablesLineaProducto.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					CuentasContablesLineaProductoDataAccess.setFieldReflectionCuentasContablesLineaProducto(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasCuentasContablesLineaProducto=CuentasContablesLineaProductoConstantesFunciones.getTodosTiposColumnasCuentasContablesLineaProducto();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasCuentasContablesLineaProducto) {
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
							field = CuentasContablesLineaProducto.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = CuentasContablesLineaProducto.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						CuentasContablesLineaProductoDataAccess.setFieldReflectionCuentasContablesLineaProducto(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCuentasContablesLineaProducto(Field field,String strPrefijo,String sColumn,CuentasContablesLineaProducto entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CuentasContablesLineaProductoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentasContablesLineaProductoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CuentasContablesLineaProductoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentasContablesLineaProductoConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentasContablesLineaProductoConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentasContablesLineaProductoConstantesFunciones.IDLINEA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentasContablesLineaProductoConstantesFunciones.IDLINEAGRUPO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentasContablesLineaProductoConstantesFunciones.IDLINEACATEGORIA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEINVENTARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEVENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEDESCUENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEPRODUCCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEIVADEBITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEIVACREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEBONIFICA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CuentasContablesLineaProducto>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<CuentasContablesLineaProducto> entities = new  ArrayList<CuentasContablesLineaProducto>();
		CuentasContablesLineaProducto entity = new CuentasContablesLineaProducto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CuentasContablesLineaProductoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CuentasContablesLineaProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentasContablesLineaProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new CuentasContablesLineaProducto();
					entity=super.getEntity("",entity,resultSet,CuentasContablesLineaProductoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityCuentasContablesLineaProducto("",entity,resultSet);
					
					//entity.setCuentasContablesLineaProductoOriginal( new CuentasContablesLineaProducto());
					//entity.setCuentasContablesLineaProductoOriginal(super.getEntity("",entity.getCuentasContablesLineaProductoOriginal(),resultSet,CuentasContablesLineaProductoDataAccess.ISWITHSCHEMA));         		
					//entity.setCuentasContablesLineaProductoOriginal(this.getEntityCuentasContablesLineaProducto("",entity.getCuentasContablesLineaProductoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseCuentasContablesLineaProductos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentasContablesLineaProducto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CuentasContablesLineaProducto>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<CuentasContablesLineaProducto> entities = new  ArrayList<CuentasContablesLineaProducto>();
		CuentasContablesLineaProducto entity = new CuentasContablesLineaProducto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CuentasContablesLineaProductoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CuentasContablesLineaProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentasContablesLineaProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<CuentasContablesLineaProducto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentasContablesLineaProducto> entities = new  ArrayList<CuentasContablesLineaProducto>();
		CuentasContablesLineaProducto entity = new CuentasContablesLineaProducto();		  
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
	
	public  List<CuentasContablesLineaProducto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentasContablesLineaProducto> entities = new  ArrayList<CuentasContablesLineaProducto>();
		CuentasContablesLineaProducto entity = new CuentasContablesLineaProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentasContablesLineaProducto();
      	    	entity=super.getEntity("",entity,resultSet,CuentasContablesLineaProductoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCuentasContablesLineaProducto("",entity,resultSet);
      	    	
				//entity.setCuentasContablesLineaProductoOriginal( new CuentasContablesLineaProducto());
      	    	//entity.setCuentasContablesLineaProductoOriginal(super.getEntity("",entity.getCuentasContablesLineaProductoOriginal(),resultSet,CuentasContablesLineaProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentasContablesLineaProductoOriginal(this.getEntityCuentasContablesLineaProducto("",entity.getCuentasContablesLineaProductoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseCuentasContablesLineaProductos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentasContablesLineaProducto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CuentasContablesLineaProducto> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentasContablesLineaProducto> entities = new  ArrayList<CuentasContablesLineaProducto>();
		CuentasContablesLineaProducto entity = new CuentasContablesLineaProducto();		  
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
	
	public  List<CuentasContablesLineaProducto> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentasContablesLineaProducto> entities = new  ArrayList<CuentasContablesLineaProducto>();
		CuentasContablesLineaProducto entity = new CuentasContablesLineaProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentasContablesLineaProducto();
      	    	entity=super.getEntity("",entity,resultSet,CuentasContablesLineaProductoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCuentasContablesLineaProducto("",entity,resultSet);
      	    	
				//entity.setCuentasContablesLineaProductoOriginal( new CuentasContablesLineaProducto());
      	    	//entity.setCuentasContablesLineaProductoOriginal(super.getEntity("",entity.getCuentasContablesLineaProductoOriginal(),resultSet,CuentasContablesLineaProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentasContablesLineaProductoOriginal(this.getEntityCuentasContablesLineaProducto("",entity.getCuentasContablesLineaProductoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCuentasContablesLineaProductos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public CuentasContablesLineaProducto getEntityCuentasContablesLineaProducto(String strPrefijo,CuentasContablesLineaProducto entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+CuentasContablesLineaProductoConstantesFunciones.IDEMPRESA));
				entity.setid_bodega(resultSet.getLong(strPrefijo+CuentasContablesLineaProductoConstantesFunciones.IDBODEGA));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+CuentasContablesLineaProductoConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setid_linea(resultSet.getLong(strPrefijo+CuentasContablesLineaProductoConstantesFunciones.IDLINEA));
				entity.setid_linea_grupo(resultSet.getLong(strPrefijo+CuentasContablesLineaProductoConstantesFunciones.IDLINEAGRUPO));
				entity.setid_linea_categoria(resultSet.getLong(strPrefijo+CuentasContablesLineaProductoConstantesFunciones.IDLINEACATEGORIA));
				entity.setid_cuenta_contable_inventario(resultSet.getLong(strPrefijo+CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEINVENTARIO));
				entity.setid_cuenta_contable_costo_venta(resultSet.getLong(strPrefijo+CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA));
				entity.setid_cuenta_contable_venta(resultSet.getLong(strPrefijo+CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEVENTA));
				entity.setid_cuenta_contable_descuento(resultSet.getLong(strPrefijo+CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEDESCUENTO));
				entity.setid_cuenta_contable_produccion(resultSet.getLong(strPrefijo+CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEPRODUCCION));
				entity.setid_cuenta_contable_devolucion(resultSet.getLong(strPrefijo+CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION));
				entity.setid_cuenta_contable_iva_debito(resultSet.getLong(strPrefijo+CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEIVADEBITO));
				entity.setid_cuenta_contable_iva_credito(resultSet.getLong(strPrefijo+CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEIVACREDITO));
				entity.setid_cuenta_contable_bonifica(resultSet.getLong(strPrefijo+CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLEBONIFICA));
				entity.setid_cuenta_contable_costo_bonifica(resultSet.getLong(strPrefijo+CuentasContablesLineaProductoConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowCuentasContablesLineaProducto(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(CuentasContablesLineaProducto entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=CuentasContablesLineaProductoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=CuentasContablesLineaProductoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=CuentasContablesLineaProductoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=CuentasContablesLineaProductoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(CuentasContablesLineaProductoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,CuentasContablesLineaProductoDataAccess.TABLENAME,CuentasContablesLineaProductoDataAccess.ISWITHSTOREPROCEDURES);
			
			CuentasContablesLineaProductoDataAccess.setCuentasContablesLineaProductoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,CuentasContablesLineaProducto relcuentascontableslineaproducto)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcuentascontableslineaproducto.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Bodega getBodega(Connexion connexion,CuentasContablesLineaProducto relcuentascontableslineaproducto)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,relcuentascontableslineaproducto.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public CentroCosto getCentroCosto(Connexion connexion,CuentasContablesLineaProducto relcuentascontableslineaproducto)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,relcuentascontableslineaproducto.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}

	public Linea getLinea(Connexion connexion,CuentasContablesLineaProducto relcuentascontableslineaproducto)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,relcuentascontableslineaproducto.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupo(Connexion connexion,CuentasContablesLineaProducto relcuentascontableslineaproducto)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,relcuentascontableslineaproducto.getid_linea_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaCategoria(Connexion connexion,CuentasContablesLineaProducto relcuentascontableslineaproducto)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,relcuentascontableslineaproducto.getid_linea_categoria());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public CuentaContable getCuentaContableInventario(Connexion connexion,CuentasContablesLineaProducto relcuentascontableslineaproducto)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relcuentascontableslineaproducto.getid_cuenta_contable_inventario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableCostoVenta(Connexion connexion,CuentasContablesLineaProducto relcuentascontableslineaproducto)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relcuentascontableslineaproducto.getid_cuenta_contable_costo_venta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableVenta(Connexion connexion,CuentasContablesLineaProducto relcuentascontableslineaproducto)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relcuentascontableslineaproducto.getid_cuenta_contable_venta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableDescuento(Connexion connexion,CuentasContablesLineaProducto relcuentascontableslineaproducto)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relcuentascontableslineaproducto.getid_cuenta_contable_descuento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableProduccion(Connexion connexion,CuentasContablesLineaProducto relcuentascontableslineaproducto)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relcuentascontableslineaproducto.getid_cuenta_contable_produccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableDevolucion(Connexion connexion,CuentasContablesLineaProducto relcuentascontableslineaproducto)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relcuentascontableslineaproducto.getid_cuenta_contable_devolucion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableIvaDebito(Connexion connexion,CuentasContablesLineaProducto relcuentascontableslineaproducto)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relcuentascontableslineaproducto.getid_cuenta_contable_iva_debito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableIvaCredito(Connexion connexion,CuentasContablesLineaProducto relcuentascontableslineaproducto)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relcuentascontableslineaproducto.getid_cuenta_contable_iva_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableBonifica(Connexion connexion,CuentasContablesLineaProducto relcuentascontableslineaproducto)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relcuentascontableslineaproducto.getid_cuenta_contable_bonifica());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableCostoBonifica(Connexion connexion,CuentasContablesLineaProducto relcuentascontableslineaproducto)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relcuentascontableslineaproducto.getid_cuenta_contable_costo_bonifica());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,CuentasContablesLineaProducto cuentascontableslineaproducto) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!cuentascontableslineaproducto.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(cuentascontableslineaproducto.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(cuentascontableslineaproducto.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(cuentascontableslineaproducto.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea.setValue(cuentascontableslineaproducto.getid_linea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea_grupo=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea_grupo.setValue(cuentascontableslineaproducto.getid_linea_grupo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea_grupo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea_categoria=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea_categoria.setValue(cuentascontableslineaproducto.getid_linea_categoria());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea_categoria);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_inventario=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_inventario.setValue(cuentascontableslineaproducto.getid_cuenta_contable_inventario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_inventario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_costo_venta=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_costo_venta.setValue(cuentascontableslineaproducto.getid_cuenta_contable_costo_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_costo_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_venta=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_venta.setValue(cuentascontableslineaproducto.getid_cuenta_contable_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_descuento=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_descuento.setValue(cuentascontableslineaproducto.getid_cuenta_contable_descuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_descuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_produccion=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_produccion.setValue(cuentascontableslineaproducto.getid_cuenta_contable_produccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_produccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_devolucion=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_devolucion.setValue(cuentascontableslineaproducto.getid_cuenta_contable_devolucion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_devolucion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_iva_debito=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_iva_debito.setValue(cuentascontableslineaproducto.getid_cuenta_contable_iva_debito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_iva_debito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_iva_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_iva_credito.setValue(cuentascontableslineaproducto.getid_cuenta_contable_iva_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_iva_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_bonifica=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_bonifica.setValue(cuentascontableslineaproducto.getid_cuenta_contable_bonifica());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_bonifica);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_costo_bonifica=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_costo_bonifica.setValue(cuentascontableslineaproducto.getid_cuenta_contable_costo_bonifica());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_costo_bonifica);
					parametersTemp.add(parameterMaintenance);
					
						if(!cuentascontableslineaproducto.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(cuentascontableslineaproducto.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(cuentascontableslineaproducto.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(cuentascontableslineaproducto.getId());
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
	
	public void setIsNewIsChangedFalseCuentasContablesLineaProducto(CuentasContablesLineaProducto cuentascontableslineaproducto)throws Exception  {		
		cuentascontableslineaproducto.setIsNew(false);
		cuentascontableslineaproducto.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseCuentasContablesLineaProductos(List<CuentasContablesLineaProducto> cuentascontableslineaproductos)throws Exception  {				
		for(CuentasContablesLineaProducto cuentascontableslineaproducto:cuentascontableslineaproductos) {
			cuentascontableslineaproducto.setIsNew(false);
			cuentascontableslineaproducto.setIsChanged(false);
		}
	}
	
	public void generarExportarCuentasContablesLineaProducto(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
