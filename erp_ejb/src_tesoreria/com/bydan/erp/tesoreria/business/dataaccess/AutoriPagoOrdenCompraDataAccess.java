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
package com.bydan.erp.tesoreria.business.dataaccess;

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

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.util.*;//AutoriPagoOrdenCompraConstantesFunciones;


import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class AutoriPagoOrdenCompraDataAccess extends  AutoriPagoOrdenCompraDataAccessAdditional{ //AutoriPagoOrdenCompraDataAccessAdditional,DataAccessHelper<AutoriPagoOrdenCompra>
	//static Logger logger = Logger.getLogger(AutoriPagoOrdenCompraDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="autori_pago_orden_compra";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+"(version_row,id_tipo_cambio,id_moneda,id_cliente,id_empresa,id_sucursal,id_orden_compra,id_transaccion,id_modulo,id_ejercicio,id_usuario,id_asiento_contable,id_banco,id_cuenta_banco,numero_comprobante,fecha,fecha_autori,total,fecha_servidor,codigo_asiento,fecha_asiento,valor_asiento,total_saldo)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_tipo_cambio=?,id_moneda=?,id_cliente=?,id_empresa=?,id_sucursal=?,id_orden_compra=?,id_transaccion=?,id_modulo=?,id_ejercicio=?,id_usuario=?,id_asiento_contable=?,id_banco=?,id_cuenta_banco=?,numero_comprobante=?,fecha=?,fecha_autori=?,total=?,fecha_servidor=?,codigo_asiento=?,fecha_asiento=?,valor_asiento=?,total_saldo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select autoripagoordencompra from "+AutoriPagoOrdenCompraConstantesFunciones.SPERSISTENCENAME+" autoripagoordencompra";
	public static String QUERYSELECTNATIVE="select "+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".id,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".version_row,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".id_tipo_cambio,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".id_moneda,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".id_cliente,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".id_empresa,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".id_sucursal,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".id_orden_compra,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".id_transaccion,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".id_modulo,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".id_ejercicio,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".id_usuario,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".id_asiento_contable,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".id_banco,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".id_cuenta_banco,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".numero_comprobante,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".fecha,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".fecha_autori,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".total,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".fecha_servidor,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".codigo_asiento,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".fecha_asiento,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".valor_asiento,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".total_saldo from "+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME;//+" as "+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".id,"+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+".version_row from "+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME;//+" as "+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+"."+AutoriPagoOrdenCompraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_tipo_cambio=?,id_moneda=?,id_cliente=?,id_empresa=?,id_sucursal=?,id_orden_compra=?,id_transaccion=?,id_modulo=?,id_ejercicio=?,id_usuario=?,id_asiento_contable=?,id_banco=?,id_cuenta_banco=?,numero_comprobante=?,fecha=?,fecha_autori=?,total=?,fecha_servidor=?,codigo_asiento=?,fecha_asiento=?,valor_asiento=?,total_saldo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_AUTORIPAGOORDENCOMPRA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_AUTORIPAGOORDENCOMPRA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_AUTORIPAGOORDENCOMPRA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_AUTORIPAGOORDENCOMPRA_SELECT(?,?)";
	
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
	
	
	protected AutoriPagoOrdenCompraDataAccessAdditional autoripagoordencompraDataAccessAdditional=null;
	
	public AutoriPagoOrdenCompraDataAccessAdditional getAutoriPagoOrdenCompraDataAccessAdditional() {
		return this.autoripagoordencompraDataAccessAdditional;
	}
	
	public void setAutoriPagoOrdenCompraDataAccessAdditional(AutoriPagoOrdenCompraDataAccessAdditional autoripagoordencompraDataAccessAdditional) {
		try {
			this.autoripagoordencompraDataAccessAdditional=autoripagoordencompraDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public AutoriPagoOrdenCompraDataAccess() {
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
		AutoriPagoOrdenCompraDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		AutoriPagoOrdenCompraDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		AutoriPagoOrdenCompraDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setAutoriPagoOrdenCompraOriginal(AutoriPagoOrdenCompra autoripagoordencompra)throws Exception  {
		autoripagoordencompra.setAutoriPagoOrdenCompraOriginal((AutoriPagoOrdenCompra)autoripagoordencompra.clone());		
	}
	
	public void setAutoriPagoOrdenComprasOriginal(List<AutoriPagoOrdenCompra> autoripagoordencompras)throws Exception  {
		
		for(AutoriPagoOrdenCompra autoripagoordencompra:autoripagoordencompras){
			autoripagoordencompra.setAutoriPagoOrdenCompraOriginal((AutoriPagoOrdenCompra)autoripagoordencompra.clone());
		}
	}
	
	public static void setAutoriPagoOrdenCompraOriginalStatic(AutoriPagoOrdenCompra autoripagoordencompra)throws Exception  {
		autoripagoordencompra.setAutoriPagoOrdenCompraOriginal((AutoriPagoOrdenCompra)autoripagoordencompra.clone());		
	}
	
	public static void setAutoriPagoOrdenComprasOriginalStatic(List<AutoriPagoOrdenCompra> autoripagoordencompras)throws Exception  {
		
		for(AutoriPagoOrdenCompra autoripagoordencompra:autoripagoordencompras){
			autoripagoordencompra.setAutoriPagoOrdenCompraOriginal((AutoriPagoOrdenCompra)autoripagoordencompra.clone());
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
	
	public  AutoriPagoOrdenCompra getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		AutoriPagoOrdenCompra entity = new AutoriPagoOrdenCompra();		
		
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
	
	public  AutoriPagoOrdenCompra getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		AutoriPagoOrdenCompra entity = new AutoriPagoOrdenCompra();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=AutoriPagoOrdenCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AutoriPagoOrdenCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Tesoreria.AutoriPagoOrdenCompra.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setAutoriPagoOrdenCompraOriginal(new AutoriPagoOrdenCompra());
      	    	entity=super.getEntity("",entity,resultSet,AutoriPagoOrdenCompraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityAutoriPagoOrdenCompra("",entity,resultSet); 
				
				//entity.setAutoriPagoOrdenCompraOriginal(super.getEntity("",entity.getAutoriPagoOrdenCompraOriginal(),resultSet,AutoriPagoOrdenCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAutoriPagoOrdenCompraOriginal(this.getEntityAutoriPagoOrdenCompra("",entity.getAutoriPagoOrdenCompraOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseAutoriPagoOrdenCompra(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  AutoriPagoOrdenCompra getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		AutoriPagoOrdenCompra entity = new AutoriPagoOrdenCompra();
				
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
	
	public  AutoriPagoOrdenCompra getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		AutoriPagoOrdenCompra entity = new AutoriPagoOrdenCompra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=AutoriPagoOrdenCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AutoriPagoOrdenCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AutoriPagoOrdenCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.AutoriPagoOrdenCompra.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setAutoriPagoOrdenCompraOriginal(new AutoriPagoOrdenCompra());
      	    	entity=super.getEntity("",entity,resultSet,AutoriPagoOrdenCompraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityAutoriPagoOrdenCompra("",entity,resultSet);    
				
				//entity.setAutoriPagoOrdenCompraOriginal(super.getEntity("",entity.getAutoriPagoOrdenCompraOriginal(),resultSet,AutoriPagoOrdenCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAutoriPagoOrdenCompraOriginal(this.getEntityAutoriPagoOrdenCompra("",entity.getAutoriPagoOrdenCompraOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseAutoriPagoOrdenCompra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //AutoriPagoOrdenCompra
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		AutoriPagoOrdenCompra entity = new AutoriPagoOrdenCompra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AutoriPagoOrdenCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AutoriPagoOrdenCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AutoriPagoOrdenCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.AutoriPagoOrdenCompra.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseAutoriPagoOrdenCompra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<AutoriPagoOrdenCompra> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<AutoriPagoOrdenCompra> entities = new  ArrayList<AutoriPagoOrdenCompra>();
		AutoriPagoOrdenCompra entity = new AutoriPagoOrdenCompra();		  
		
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
	
	public  List<AutoriPagoOrdenCompra> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<AutoriPagoOrdenCompra> entities = new  ArrayList<AutoriPagoOrdenCompra>();
		AutoriPagoOrdenCompra entity = new AutoriPagoOrdenCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=AutoriPagoOrdenCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AutoriPagoOrdenCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AutoriPagoOrdenCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AutoriPagoOrdenCompra();
      	    	entity=super.getEntity("",entity,resultSet,AutoriPagoOrdenCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAutoriPagoOrdenCompra("",entity,resultSet);
      	    	
				//entity.setAutoriPagoOrdenCompraOriginal( new AutoriPagoOrdenCompra());
      	    	//entity.setAutoriPagoOrdenCompraOriginal(super.getEntity("",entity.getAutoriPagoOrdenCompraOriginal(),resultSet,AutoriPagoOrdenCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAutoriPagoOrdenCompraOriginal(this.getEntityAutoriPagoOrdenCompra("",entity.getAutoriPagoOrdenCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAutoriPagoOrdenCompras(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAutoriPagoOrdenCompra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<AutoriPagoOrdenCompra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<AutoriPagoOrdenCompra> entities = new  ArrayList<AutoriPagoOrdenCompra>();
		AutoriPagoOrdenCompra entity = new AutoriPagoOrdenCompra();		  
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
	
	public  List<AutoriPagoOrdenCompra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<AutoriPagoOrdenCompra> entities = new  ArrayList<AutoriPagoOrdenCompra>();
		AutoriPagoOrdenCompra entity = new AutoriPagoOrdenCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AutoriPagoOrdenCompra();
				
				if(conMapGenerico) {
					entity.inicializarMapAutoriPagoOrdenCompra();
					//entity.setMapAutoriPagoOrdenCompra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapAutoriPagoOrdenCompraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapAutoriPagoOrdenCompra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AutoriPagoOrdenCompraDataAccess.ISWITHSCHEMA);         		
					entity=AutoriPagoOrdenCompraDataAccess.getEntityAutoriPagoOrdenCompra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setAutoriPagoOrdenCompraOriginal( new AutoriPagoOrdenCompra());
					////entity.setAutoriPagoOrdenCompraOriginal(super.getEntity("",entity.getAutoriPagoOrdenCompraOriginal(),resultSet,AutoriPagoOrdenCompraDataAccess.ISWITHSCHEMA));         		
					////entity.setAutoriPagoOrdenCompraOriginal(this.getEntityAutoriPagoOrdenCompra("",entity.getAutoriPagoOrdenCompraOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAutoriPagoOrdenCompras(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAutoriPagoOrdenCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public AutoriPagoOrdenCompra getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		AutoriPagoOrdenCompra entity = new AutoriPagoOrdenCompra();		  
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
	
	public  AutoriPagoOrdenCompra getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		AutoriPagoOrdenCompra entity = new AutoriPagoOrdenCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AutoriPagoOrdenCompra();
				
				if(conMapGenerico) {
					entity.inicializarMapAutoriPagoOrdenCompra();
					//entity.setMapAutoriPagoOrdenCompra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapAutoriPagoOrdenCompraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapAutoriPagoOrdenCompra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AutoriPagoOrdenCompraDataAccess.ISWITHSCHEMA);         		
					entity=AutoriPagoOrdenCompraDataAccess.getEntityAutoriPagoOrdenCompra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setAutoriPagoOrdenCompraOriginal( new AutoriPagoOrdenCompra());
					////entity.setAutoriPagoOrdenCompraOriginal(super.getEntity("",entity.getAutoriPagoOrdenCompraOriginal(),resultSet,AutoriPagoOrdenCompraDataAccess.ISWITHSCHEMA));         		
					////entity.setAutoriPagoOrdenCompraOriginal(this.getEntityAutoriPagoOrdenCompra("",entity.getAutoriPagoOrdenCompraOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseAutoriPagoOrdenCompra(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAutoriPagoOrdenCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static AutoriPagoOrdenCompra getEntityAutoriPagoOrdenCompra(String strPrefijo,AutoriPagoOrdenCompra entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = AutoriPagoOrdenCompra.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = AutoriPagoOrdenCompra.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					AutoriPagoOrdenCompraDataAccess.setFieldReflectionAutoriPagoOrdenCompra(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasAutoriPagoOrdenCompra=AutoriPagoOrdenCompraConstantesFunciones.getTodosTiposColumnasAutoriPagoOrdenCompra();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasAutoriPagoOrdenCompra) {
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
							field = AutoriPagoOrdenCompra.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = AutoriPagoOrdenCompra.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						AutoriPagoOrdenCompraDataAccess.setFieldReflectionAutoriPagoOrdenCompra(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionAutoriPagoOrdenCompra(Field field,String strPrefijo,String sColumn,AutoriPagoOrdenCompra entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case AutoriPagoOrdenCompraConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriPagoOrdenCompraConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AutoriPagoOrdenCompraConstantesFunciones.IDTIPOCAMBIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriPagoOrdenCompraConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriPagoOrdenCompraConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriPagoOrdenCompraConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriPagoOrdenCompraConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriPagoOrdenCompraConstantesFunciones.IDORDENCOMPRA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriPagoOrdenCompraConstantesFunciones.IDTRANSACCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriPagoOrdenCompraConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriPagoOrdenCompraConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriPagoOrdenCompraConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriPagoOrdenCompraConstantesFunciones.IDASIENTOCONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriPagoOrdenCompraConstantesFunciones.IDBANCO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriPagoOrdenCompraConstantesFunciones.IDCUENTABANCO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriPagoOrdenCompraConstantesFunciones.NUMEROCOMPROBANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AutoriPagoOrdenCompraConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case AutoriPagoOrdenCompraConstantesFunciones.FECHAAUTORI:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case AutoriPagoOrdenCompraConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AutoriPagoOrdenCompraConstantesFunciones.FECHASERVIDOR:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case AutoriPagoOrdenCompraConstantesFunciones.CODIGOASIENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AutoriPagoOrdenCompraConstantesFunciones.FECHAASIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case AutoriPagoOrdenCompraConstantesFunciones.VALORASIENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AutoriPagoOrdenCompraConstantesFunciones.TOTALSALDO:
					field.set(entity,resultSet.getDouble(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<AutoriPagoOrdenCompra>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<AutoriPagoOrdenCompra> entities = new  ArrayList<AutoriPagoOrdenCompra>();
		AutoriPagoOrdenCompra entity = new AutoriPagoOrdenCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AutoriPagoOrdenCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AutoriPagoOrdenCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AutoriPagoOrdenCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new AutoriPagoOrdenCompra();
					entity=super.getEntity("",entity,resultSet,AutoriPagoOrdenCompraDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityAutoriPagoOrdenCompra("",entity,resultSet);
					
					//entity.setAutoriPagoOrdenCompraOriginal( new AutoriPagoOrdenCompra());
					//entity.setAutoriPagoOrdenCompraOriginal(super.getEntity("",entity.getAutoriPagoOrdenCompraOriginal(),resultSet,AutoriPagoOrdenCompraDataAccess.ISWITHSCHEMA));         		
					//entity.setAutoriPagoOrdenCompraOriginal(this.getEntityAutoriPagoOrdenCompra("",entity.getAutoriPagoOrdenCompraOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseAutoriPagoOrdenCompras(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAutoriPagoOrdenCompra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<AutoriPagoOrdenCompra>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<AutoriPagoOrdenCompra> entities = new  ArrayList<AutoriPagoOrdenCompra>();
		AutoriPagoOrdenCompra entity = new AutoriPagoOrdenCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AutoriPagoOrdenCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AutoriPagoOrdenCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AutoriPagoOrdenCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<AutoriPagoOrdenCompra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AutoriPagoOrdenCompra> entities = new  ArrayList<AutoriPagoOrdenCompra>();
		AutoriPagoOrdenCompra entity = new AutoriPagoOrdenCompra();		  
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
	
	public  List<AutoriPagoOrdenCompra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AutoriPagoOrdenCompra> entities = new  ArrayList<AutoriPagoOrdenCompra>();
		AutoriPagoOrdenCompra entity = new AutoriPagoOrdenCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AutoriPagoOrdenCompra();
      	    	entity=super.getEntity("",entity,resultSet,AutoriPagoOrdenCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAutoriPagoOrdenCompra("",entity,resultSet);
      	    	
				//entity.setAutoriPagoOrdenCompraOriginal( new AutoriPagoOrdenCompra());
      	    	//entity.setAutoriPagoOrdenCompraOriginal(super.getEntity("",entity.getAutoriPagoOrdenCompraOriginal(),resultSet,AutoriPagoOrdenCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAutoriPagoOrdenCompraOriginal(this.getEntityAutoriPagoOrdenCompra("",entity.getAutoriPagoOrdenCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseAutoriPagoOrdenCompras(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAutoriPagoOrdenCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<AutoriPagoOrdenCompra> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AutoriPagoOrdenCompra> entities = new  ArrayList<AutoriPagoOrdenCompra>();
		AutoriPagoOrdenCompra entity = new AutoriPagoOrdenCompra();		  
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
	
	public  List<AutoriPagoOrdenCompra> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AutoriPagoOrdenCompra> entities = new  ArrayList<AutoriPagoOrdenCompra>();
		AutoriPagoOrdenCompra entity = new AutoriPagoOrdenCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AutoriPagoOrdenCompra();
      	    	entity=super.getEntity("",entity,resultSet,AutoriPagoOrdenCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAutoriPagoOrdenCompra("",entity,resultSet);
      	    	
				//entity.setAutoriPagoOrdenCompraOriginal( new AutoriPagoOrdenCompra());
      	    	//entity.setAutoriPagoOrdenCompraOriginal(super.getEntity("",entity.getAutoriPagoOrdenCompraOriginal(),resultSet,AutoriPagoOrdenCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAutoriPagoOrdenCompraOriginal(this.getEntityAutoriPagoOrdenCompra("",entity.getAutoriPagoOrdenCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAutoriPagoOrdenCompras(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public AutoriPagoOrdenCompra getEntityAutoriPagoOrdenCompra(String strPrefijo,AutoriPagoOrdenCompra entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_tipo_cambio(resultSet.getLong(strPrefijo+AutoriPagoOrdenCompraConstantesFunciones.IDTIPOCAMBIO));if(resultSet.wasNull()) {entity.setid_tipo_cambio(null); }
				entity.setid_moneda(resultSet.getLong(strPrefijo+AutoriPagoOrdenCompraConstantesFunciones.IDMONEDA));
				entity.setid_cliente(resultSet.getLong(strPrefijo+AutoriPagoOrdenCompraConstantesFunciones.IDCLIENTE));
				entity.setid_empresa(resultSet.getLong(strPrefijo+AutoriPagoOrdenCompraConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+AutoriPagoOrdenCompraConstantesFunciones.IDSUCURSAL));
				entity.setid_orden_compra(resultSet.getLong(strPrefijo+AutoriPagoOrdenCompraConstantesFunciones.IDORDENCOMPRA));
				entity.setid_transaccion(resultSet.getLong(strPrefijo+AutoriPagoOrdenCompraConstantesFunciones.IDTRANSACCION));
				entity.setid_modulo(resultSet.getLong(strPrefijo+AutoriPagoOrdenCompraConstantesFunciones.IDMODULO));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+AutoriPagoOrdenCompraConstantesFunciones.IDEJERCICIO));
				entity.setid_usuario(resultSet.getLong(strPrefijo+AutoriPagoOrdenCompraConstantesFunciones.IDUSUARIO));
				entity.setid_asiento_contable(resultSet.getLong(strPrefijo+AutoriPagoOrdenCompraConstantesFunciones.IDASIENTOCONTABLE));
				entity.setid_banco(resultSet.getLong(strPrefijo+AutoriPagoOrdenCompraConstantesFunciones.IDBANCO));
				entity.setid_cuenta_banco(resultSet.getLong(strPrefijo+AutoriPagoOrdenCompraConstantesFunciones.IDCUENTABANCO));
				entity.setnumero_comprobante(resultSet.getString(strPrefijo+AutoriPagoOrdenCompraConstantesFunciones.NUMEROCOMPROBANTE));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+AutoriPagoOrdenCompraConstantesFunciones.FECHA).getTime()));
				entity.setfecha_autori(new Date(resultSet.getDate(strPrefijo+AutoriPagoOrdenCompraConstantesFunciones.FECHAAUTORI).getTime()));
				entity.settotal(resultSet.getDouble(strPrefijo+AutoriPagoOrdenCompraConstantesFunciones.TOTAL));
				entity.setfecha_servidor(new Date(resultSet.getDate(strPrefijo+AutoriPagoOrdenCompraConstantesFunciones.FECHASERVIDOR).getTime()));
				entity.setcodigo_asiento(resultSet.getString(strPrefijo+AutoriPagoOrdenCompraConstantesFunciones.CODIGOASIENTO));
				entity.setfecha_asiento(new Date(resultSet.getDate(strPrefijo+AutoriPagoOrdenCompraConstantesFunciones.FECHAASIENTO).getTime()));
				entity.setvalor_asiento(resultSet.getDouble(strPrefijo+AutoriPagoOrdenCompraConstantesFunciones.VALORASIENTO));
				entity.settotal_saldo(resultSet.getDouble(strPrefijo+AutoriPagoOrdenCompraConstantesFunciones.TOTALSALDO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowAutoriPagoOrdenCompra(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(AutoriPagoOrdenCompra entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=AutoriPagoOrdenCompraDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=AutoriPagoOrdenCompraDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=AutoriPagoOrdenCompraDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=AutoriPagoOrdenCompraDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(AutoriPagoOrdenCompraConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,AutoriPagoOrdenCompraDataAccess.TABLENAME,AutoriPagoOrdenCompraDataAccess.ISWITHSTOREPROCEDURES);
			
			AutoriPagoOrdenCompraDataAccess.setAutoriPagoOrdenCompraOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public TipoCambio getTipoCambio(Connexion connexion,AutoriPagoOrdenCompra relautoripagoordencompra)throws SQLException,Exception {

		TipoCambio tipocambio= new TipoCambio();

		try {
			TipoCambioDataAccess tipocambioDataAccess=new TipoCambioDataAccess();

			tipocambioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocambioDataAccess.setConnexionType(this.connexionType);
			tipocambioDataAccess.setParameterDbType(this.parameterDbType);

			tipocambio=tipocambioDataAccess.getEntity(connexion,relautoripagoordencompra.getid_tipo_cambio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocambio;

	}

	public Moneda getMoneda(Connexion connexion,AutoriPagoOrdenCompra relautoripagoordencompra)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,relautoripagoordencompra.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public Cliente getCliente(Connexion connexion,AutoriPagoOrdenCompra relautoripagoordencompra)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relautoripagoordencompra.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Empresa getEmpresa(Connexion connexion,AutoriPagoOrdenCompra relautoripagoordencompra)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relautoripagoordencompra.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,AutoriPagoOrdenCompra relautoripagoordencompra)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relautoripagoordencompra.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public OrdenCompra getOrdenCompra(Connexion connexion,AutoriPagoOrdenCompra relautoripagoordencompra)throws SQLException,Exception {

		OrdenCompra ordencompra= new OrdenCompra();

		try {
			OrdenCompraDataAccess ordencompraDataAccess=new OrdenCompraDataAccess();

			ordencompraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ordencompraDataAccess.setConnexionType(this.connexionType);
			ordencompraDataAccess.setParameterDbType(this.parameterDbType);

			ordencompra=ordencompraDataAccess.getEntity(connexion,relautoripagoordencompra.getid_orden_compra());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ordencompra;

	}

	public Transaccion getTransaccion(Connexion connexion,AutoriPagoOrdenCompra relautoripagoordencompra)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relautoripagoordencompra.getid_transaccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Modulo getModulo(Connexion connexion,AutoriPagoOrdenCompra relautoripagoordencompra)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,relautoripagoordencompra.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public Ejercicio getEjercicio(Connexion connexion,AutoriPagoOrdenCompra relautoripagoordencompra)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relautoripagoordencompra.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Usuario getUsuario(Connexion connexion,AutoriPagoOrdenCompra relautoripagoordencompra)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relautoripagoordencompra.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public AsientoContable getAsientoContable(Connexion connexion,AutoriPagoOrdenCompra relautoripagoordencompra)throws SQLException,Exception {

		AsientoContable asientocontable= new AsientoContable();

		try {
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);

			asientocontable=asientocontableDataAccess.getEntity(connexion,relautoripagoordencompra.getid_asiento_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontable;

	}

	public Banco getBanco(Connexion connexion,AutoriPagoOrdenCompra relautoripagoordencompra)throws SQLException,Exception {

		Banco banco= new Banco();

		try {
			BancoDataAccess bancoDataAccess=new BancoDataAccess();

			bancoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bancoDataAccess.setConnexionType(this.connexionType);
			bancoDataAccess.setParameterDbType(this.parameterDbType);

			banco=bancoDataAccess.getEntity(connexion,relautoripagoordencompra.getid_banco());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return banco;

	}

	public CuentaBanco getCuentaBanco(Connexion connexion,AutoriPagoOrdenCompra relautoripagoordencompra)throws SQLException,Exception {

		CuentaBanco cuentabanco= new CuentaBanco();

		try {
			CuentaBancoDataAccess cuentabancoDataAccess=new CuentaBancoDataAccess();

			cuentabancoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentabancoDataAccess.setConnexionType(this.connexionType);
			cuentabancoDataAccess.setParameterDbType(this.parameterDbType);

			cuentabanco=cuentabancoDataAccess.getEntity(connexion,relautoripagoordencompra.getid_cuenta_banco());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentabanco;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,AutoriPagoOrdenCompra autoripagoordencompra) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!autoripagoordencompra.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_cambio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_cambio.setValue(autoripagoordencompra.getid_tipo_cambio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_cambio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda.setValue(autoripagoordencompra.getid_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(autoripagoordencompra.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(autoripagoordencompra.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(autoripagoordencompra.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_orden_compra=new ParameterValue<Long>();
					parameterMaintenanceValueid_orden_compra.setValue(autoripagoordencompra.getid_orden_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_orden_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion.setValue(autoripagoordencompra.getid_transaccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(autoripagoordencompra.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(autoripagoordencompra.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(autoripagoordencompra.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_asiento_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_asiento_contable.setValue(autoripagoordencompra.getid_asiento_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_asiento_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_banco=new ParameterValue<Long>();
					parameterMaintenanceValueid_banco.setValue(autoripagoordencompra.getid_banco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_banco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_banco=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_banco.setValue(autoripagoordencompra.getid_cuenta_banco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_banco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_comprobante=new ParameterValue<String>();
					parameterMaintenanceValuenumero_comprobante.setValue(autoripagoordencompra.getnumero_comprobante());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_comprobante);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(autoripagoordencompra.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_autori=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_autori.setValue(autoripagoordencompra.getfecha_autori());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_autori);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(autoripagoordencompra.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_servidor=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_servidor.setValue(autoripagoordencompra.getfecha_servidor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_servidor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo_asiento=new ParameterValue<String>();
					parameterMaintenanceValuecodigo_asiento.setValue(autoripagoordencompra.getcodigo_asiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo_asiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_asiento=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_asiento.setValue(autoripagoordencompra.getfecha_asiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_asiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_asiento=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_asiento.setValue(autoripagoordencompra.getvalor_asiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_asiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_saldo=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_saldo.setValue(autoripagoordencompra.gettotal_saldo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_saldo);
					parametersTemp.add(parameterMaintenance);
					
						if(!autoripagoordencompra.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(autoripagoordencompra.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(autoripagoordencompra.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(autoripagoordencompra.getId());
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
	
	public void setIsNewIsChangedFalseAutoriPagoOrdenCompra(AutoriPagoOrdenCompra autoripagoordencompra)throws Exception  {		
		autoripagoordencompra.setIsNew(false);
		autoripagoordencompra.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseAutoriPagoOrdenCompras(List<AutoriPagoOrdenCompra> autoripagoordencompras)throws Exception  {				
		for(AutoriPagoOrdenCompra autoripagoordencompra:autoripagoordencompras) {
			autoripagoordencompra.setIsNew(false);
			autoripagoordencompra.setIsChanged(false);
		}
	}
	
	public void generarExportarAutoriPagoOrdenCompra(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
