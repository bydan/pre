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
import com.bydan.erp.inventario.util.*;//OrdenCompraConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;




@SuppressWarnings("unused")
final public class OrdenCompraDataAccess extends  OrdenCompraDataAccessAdditional{ //OrdenCompraDataAccessAdditional,DataAccessHelper<OrdenCompra>
	//static Logger logger = Logger.getLogger(OrdenCompraDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="orden_compra";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_modulo,id_ejercicio,id_periodo,id_anio,id_mes,id_usuario,fecha_emision,fecha_entrega,numero_secuencial,id_moneda,id_tipo_cambio,id_estado_orden_compra,id_cliente,id_formato,id_transportista,id_empleado,descripcion,porcentaje_descuento,suman,ice,valor_descuento,total_descuento,iva,stock,sub_total,total_otro,ultimo_costo,numero_items,retencion,total,flete,impuesto,id_tipo_transaccion_modulo,id_orden_compra,id_asiento_contable,numero_comprobante,fecha)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_modulo=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_usuario=?,fecha_emision=?,fecha_entrega=?,numero_secuencial=?,id_moneda=?,id_tipo_cambio=?,id_estado_orden_compra=?,id_cliente=?,id_formato=?,id_transportista=?,id_empleado=?,descripcion=?,porcentaje_descuento=?,suman=?,ice=?,valor_descuento=?,total_descuento=?,iva=?,stock=?,sub_total=?,total_otro=?,ultimo_costo=?,numero_items=?,retencion=?,total=?,flete=?,impuesto=?,id_tipo_transaccion_modulo=?,id_orden_compra=?,id_asiento_contable=?,numero_comprobante=?,fecha=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select ordencompra from "+OrdenCompraConstantesFunciones.SPERSISTENCENAME+" ordencompra";
	public static String QUERYSELECTNATIVE="select "+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".version_row,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_empresa,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_sucursal,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_modulo,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_ejercicio,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_periodo,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_anio,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_mes,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_usuario,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".fecha_emision,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".fecha_entrega,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".numero_secuencial,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_moneda,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_tipo_cambio,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_estado_orden_compra,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_cliente,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_formato,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_transportista,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_empleado,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".descripcion,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".porcentaje_descuento,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".suman,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".ice,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".valor_descuento,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".total_descuento,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".iva,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".stock,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".sub_total,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".total_otro,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".ultimo_costo,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".numero_items,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".retencion,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".total,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".flete,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".impuesto,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_orden_compra,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_asiento_contable,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".numero_comprobante,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".fecha from "+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME;//+" as "+OrdenCompraConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".version_row from "+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME;//+" as "+OrdenCompraConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_modulo=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_usuario=?,fecha_emision=?,fecha_entrega=?,numero_secuencial=?,id_moneda=?,id_tipo_cambio=?,id_estado_orden_compra=?,id_cliente=?,id_formato=?,id_transportista=?,id_empleado=?,descripcion=?,porcentaje_descuento=?,suman=?,ice=?,valor_descuento=?,total_descuento=?,iva=?,stock=?,sub_total=?,total_otro=?,ultimo_costo=?,numero_items=?,retencion=?,total=?,flete=?,impuesto=?,id_tipo_transaccion_modulo=?,id_orden_compra=?,id_asiento_contable=?,numero_comprobante=?,fecha=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ORDENCOMPRA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ORDENCOMPRA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ORDENCOMPRA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ORDENCOMPRA_SELECT(?,?)";
	
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
	
	
	protected OrdenCompraDataAccessAdditional ordencompraDataAccessAdditional=null;
	
	public OrdenCompraDataAccessAdditional getOrdenCompraDataAccessAdditional() {
		return this.ordencompraDataAccessAdditional;
	}
	
	public void setOrdenCompraDataAccessAdditional(OrdenCompraDataAccessAdditional ordencompraDataAccessAdditional) {
		try {
			this.ordencompraDataAccessAdditional=ordencompraDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public OrdenCompraDataAccess() {
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
		OrdenCompraDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		OrdenCompraDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		OrdenCompraDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setOrdenCompraOriginal(OrdenCompra ordencompra)throws Exception  {
		ordencompra.setOrdenCompraOriginal((OrdenCompra)ordencompra.clone());		
	}
	
	public void setOrdenComprasOriginal(List<OrdenCompra> ordencompras)throws Exception  {
		
		for(OrdenCompra ordencompra:ordencompras){
			ordencompra.setOrdenCompraOriginal((OrdenCompra)ordencompra.clone());
		}
	}
	
	public static void setOrdenCompraOriginalStatic(OrdenCompra ordencompra)throws Exception  {
		ordencompra.setOrdenCompraOriginal((OrdenCompra)ordencompra.clone());		
	}
	
	public static void setOrdenComprasOriginalStatic(List<OrdenCompra> ordencompras)throws Exception  {
		
		for(OrdenCompra ordencompra:ordencompras){
			ordencompra.setOrdenCompraOriginal((OrdenCompra)ordencompra.clone());
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
	
	public  OrdenCompra getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		OrdenCompra entity = new OrdenCompra();		
		
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
	
	public  OrdenCompra getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		OrdenCompra entity = new OrdenCompra();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=OrdenCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=OrdenCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.OrdenCompra.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setOrdenCompraOriginal(new OrdenCompra());
      	    	entity=super.getEntity("",entity,resultSet,OrdenCompraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityOrdenCompra("",entity,resultSet); 
				
				//entity.setOrdenCompraOriginal(super.getEntity("",entity.getOrdenCompraOriginal(),resultSet,OrdenCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setOrdenCompraOriginal(this.getEntityOrdenCompra("",entity.getOrdenCompraOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseOrdenCompra(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  OrdenCompra getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		OrdenCompra entity = new OrdenCompra();
				
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
	
	public  OrdenCompra getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		OrdenCompra entity = new OrdenCompra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=OrdenCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=OrdenCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,OrdenCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.OrdenCompra.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setOrdenCompraOriginal(new OrdenCompra());
      	    	entity=super.getEntity("",entity,resultSet,OrdenCompraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityOrdenCompra("",entity,resultSet);    
				
				//entity.setOrdenCompraOriginal(super.getEntity("",entity.getOrdenCompraOriginal(),resultSet,OrdenCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setOrdenCompraOriginal(this.getEntityOrdenCompra("",entity.getOrdenCompraOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseOrdenCompra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //OrdenCompra
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		OrdenCompra entity = new OrdenCompra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=OrdenCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=OrdenCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,OrdenCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.OrdenCompra.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseOrdenCompra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<OrdenCompra> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<OrdenCompra> entities = new  ArrayList<OrdenCompra>();
		OrdenCompra entity = new OrdenCompra();		  
		
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
	
	public  List<OrdenCompra> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<OrdenCompra> entities = new  ArrayList<OrdenCompra>();
		OrdenCompra entity = new OrdenCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=OrdenCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=OrdenCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,OrdenCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new OrdenCompra();
      	    	entity=super.getEntity("",entity,resultSet,OrdenCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityOrdenCompra("",entity,resultSet);
      	    	
				//entity.setOrdenCompraOriginal( new OrdenCompra());
      	    	//entity.setOrdenCompraOriginal(super.getEntity("",entity.getOrdenCompraOriginal(),resultSet,OrdenCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setOrdenCompraOriginal(this.getEntityOrdenCompra("",entity.getOrdenCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseOrdenCompras(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarOrdenCompra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<OrdenCompra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<OrdenCompra> entities = new  ArrayList<OrdenCompra>();
		OrdenCompra entity = new OrdenCompra();		  
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
	
	public  List<OrdenCompra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<OrdenCompra> entities = new  ArrayList<OrdenCompra>();
		OrdenCompra entity = new OrdenCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new OrdenCompra();
				
				if(conMapGenerico) {
					entity.inicializarMapOrdenCompra();
					//entity.setMapOrdenCompra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapOrdenCompraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapOrdenCompra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,OrdenCompraDataAccess.ISWITHSCHEMA);         		
					entity=OrdenCompraDataAccess.getEntityOrdenCompra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setOrdenCompraOriginal( new OrdenCompra());
					////entity.setOrdenCompraOriginal(super.getEntity("",entity.getOrdenCompraOriginal(),resultSet,OrdenCompraDataAccess.ISWITHSCHEMA));         		
					////entity.setOrdenCompraOriginal(this.getEntityOrdenCompra("",entity.getOrdenCompraOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseOrdenCompras(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarOrdenCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public OrdenCompra getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		OrdenCompra entity = new OrdenCompra();		  
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
	
	public  OrdenCompra getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		OrdenCompra entity = new OrdenCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new OrdenCompra();
				
				if(conMapGenerico) {
					entity.inicializarMapOrdenCompra();
					//entity.setMapOrdenCompra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapOrdenCompraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapOrdenCompra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,OrdenCompraDataAccess.ISWITHSCHEMA);         		
					entity=OrdenCompraDataAccess.getEntityOrdenCompra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setOrdenCompraOriginal( new OrdenCompra());
					////entity.setOrdenCompraOriginal(super.getEntity("",entity.getOrdenCompraOriginal(),resultSet,OrdenCompraDataAccess.ISWITHSCHEMA));         		
					////entity.setOrdenCompraOriginal(this.getEntityOrdenCompra("",entity.getOrdenCompraOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseOrdenCompra(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarOrdenCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static OrdenCompra getEntityOrdenCompra(String strPrefijo,OrdenCompra entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = OrdenCompra.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = OrdenCompra.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					OrdenCompraDataAccess.setFieldReflectionOrdenCompra(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasOrdenCompra=OrdenCompraConstantesFunciones.getTodosTiposColumnasOrdenCompra();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasOrdenCompra) {
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
							field = OrdenCompra.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = OrdenCompra.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						OrdenCompraDataAccess.setFieldReflectionOrdenCompra(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionOrdenCompra(Field field,String strPrefijo,String sColumn,OrdenCompra entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case OrdenCompraConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case OrdenCompraConstantesFunciones.FECHAENTREGA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case OrdenCompraConstantesFunciones.NUMEROSECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.IDTIPOCAMBIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.IDESTADOORDENCOMPRA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.IDFORMATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.IDTRANSPORTISTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.PORCENTAJEDESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.SUMAN:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.ICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.VALORDESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.TOTALDESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.STOCK:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.SUBTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.TOTALOTRO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.ULTIMOCOSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.NUMEROITEMS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.RETENCION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.FLETE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.IMPUESTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.IDTIPOTRANSACCIONMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.IDORDENCOMPRA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.IDASIENTOCONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.NUMEROCOMPROBANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case OrdenCompraConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<OrdenCompra>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<OrdenCompra> entities = new  ArrayList<OrdenCompra>();
		OrdenCompra entity = new OrdenCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=OrdenCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=OrdenCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,OrdenCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new OrdenCompra();
					entity=super.getEntity("",entity,resultSet,OrdenCompraDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityOrdenCompra("",entity,resultSet);
					
					//entity.setOrdenCompraOriginal( new OrdenCompra());
					//entity.setOrdenCompraOriginal(super.getEntity("",entity.getOrdenCompraOriginal(),resultSet,OrdenCompraDataAccess.ISWITHSCHEMA));         		
					//entity.setOrdenCompraOriginal(this.getEntityOrdenCompra("",entity.getOrdenCompraOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseOrdenCompras(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarOrdenCompra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<OrdenCompra>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<OrdenCompra> entities = new  ArrayList<OrdenCompra>();
		OrdenCompra entity = new OrdenCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=OrdenCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=OrdenCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,OrdenCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<OrdenCompra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<OrdenCompra> entities = new  ArrayList<OrdenCompra>();
		OrdenCompra entity = new OrdenCompra();		  
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
	
	public  List<OrdenCompra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<OrdenCompra> entities = new  ArrayList<OrdenCompra>();
		OrdenCompra entity = new OrdenCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new OrdenCompra();
      	    	entity=super.getEntity("",entity,resultSet,OrdenCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityOrdenCompra("",entity,resultSet);
      	    	
				//entity.setOrdenCompraOriginal( new OrdenCompra());
      	    	//entity.setOrdenCompraOriginal(super.getEntity("",entity.getOrdenCompraOriginal(),resultSet,OrdenCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setOrdenCompraOriginal(this.getEntityOrdenCompra("",entity.getOrdenCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseOrdenCompras(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarOrdenCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<OrdenCompra> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<OrdenCompra> entities = new  ArrayList<OrdenCompra>();
		OrdenCompra entity = new OrdenCompra();		  
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
	
	public  List<OrdenCompra> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<OrdenCompra> entities = new  ArrayList<OrdenCompra>();
		OrdenCompra entity = new OrdenCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new OrdenCompra();
      	    	entity=super.getEntity("",entity,resultSet,OrdenCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityOrdenCompra("",entity,resultSet);
      	    	
				//entity.setOrdenCompraOriginal( new OrdenCompra());
      	    	//entity.setOrdenCompraOriginal(super.getEntity("",entity.getOrdenCompraOriginal(),resultSet,OrdenCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setOrdenCompraOriginal(this.getEntityOrdenCompra("",entity.getOrdenCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseOrdenCompras(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public OrdenCompra getEntityOrdenCompra(String strPrefijo,OrdenCompra entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+OrdenCompraConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+OrdenCompraConstantesFunciones.IDSUCURSAL));
				entity.setid_modulo(resultSet.getLong(strPrefijo+OrdenCompraConstantesFunciones.IDMODULO));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+OrdenCompraConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+OrdenCompraConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+OrdenCompraConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+OrdenCompraConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_usuario(resultSet.getLong(strPrefijo+OrdenCompraConstantesFunciones.IDUSUARIO));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+OrdenCompraConstantesFunciones.FECHAEMISION).getTime()));
				entity.setfecha_entrega(new Date(resultSet.getDate(strPrefijo+OrdenCompraConstantesFunciones.FECHAENTREGA).getTime()));
				entity.setnumero_secuencial(resultSet.getString(strPrefijo+OrdenCompraConstantesFunciones.NUMEROSECUENCIAL));
				entity.setid_moneda(resultSet.getLong(strPrefijo+OrdenCompraConstantesFunciones.IDMONEDA));
				entity.setid_tipo_cambio(resultSet.getLong(strPrefijo+OrdenCompraConstantesFunciones.IDTIPOCAMBIO));if(resultSet.wasNull()) {entity.setid_tipo_cambio(null); }
				entity.setid_estado_orden_compra(resultSet.getLong(strPrefijo+OrdenCompraConstantesFunciones.IDESTADOORDENCOMPRA));
				entity.setid_cliente(resultSet.getLong(strPrefijo+OrdenCompraConstantesFunciones.IDCLIENTE));
				entity.setid_formato(resultSet.getLong(strPrefijo+OrdenCompraConstantesFunciones.IDFORMATO));
				entity.setid_transportista(resultSet.getLong(strPrefijo+OrdenCompraConstantesFunciones.IDTRANSPORTISTA));if(resultSet.wasNull()) {entity.setid_transportista(null); }
				entity.setid_empleado(resultSet.getLong(strPrefijo+OrdenCompraConstantesFunciones.IDEMPLEADO));
				entity.setdescripcion(resultSet.getString(strPrefijo+OrdenCompraConstantesFunciones.DESCRIPCION));
				entity.setporcentaje_descuento(resultSet.getDouble(strPrefijo+OrdenCompraConstantesFunciones.PORCENTAJEDESCUENTO));
				entity.setsuman(resultSet.getDouble(strPrefijo+OrdenCompraConstantesFunciones.SUMAN));
				entity.setice(resultSet.getDouble(strPrefijo+OrdenCompraConstantesFunciones.ICE));
				entity.setvalor_descuento(resultSet.getDouble(strPrefijo+OrdenCompraConstantesFunciones.VALORDESCUENTO));
				entity.settotal_descuento(resultSet.getDouble(strPrefijo+OrdenCompraConstantesFunciones.TOTALDESCUENTO));
				entity.setiva(resultSet.getDouble(strPrefijo+OrdenCompraConstantesFunciones.IVA));
				entity.setstock(resultSet.getDouble(strPrefijo+OrdenCompraConstantesFunciones.STOCK));
				entity.setsub_total(resultSet.getDouble(strPrefijo+OrdenCompraConstantesFunciones.SUBTOTAL));
				entity.settotal_otro(resultSet.getDouble(strPrefijo+OrdenCompraConstantesFunciones.TOTALOTRO));
				entity.setultimo_costo(resultSet.getDouble(strPrefijo+OrdenCompraConstantesFunciones.ULTIMOCOSTO));
				entity.setnumero_items(resultSet.getDouble(strPrefijo+OrdenCompraConstantesFunciones.NUMEROITEMS));
				entity.setretencion(resultSet.getDouble(strPrefijo+OrdenCompraConstantesFunciones.RETENCION));
				entity.settotal(resultSet.getDouble(strPrefijo+OrdenCompraConstantesFunciones.TOTAL));
				entity.setflete(resultSet.getDouble(strPrefijo+OrdenCompraConstantesFunciones.FLETE));
				entity.setimpuesto(resultSet.getDouble(strPrefijo+OrdenCompraConstantesFunciones.IMPUESTO));
				entity.setid_tipo_transaccion_modulo(resultSet.getLong(strPrefijo+OrdenCompraConstantesFunciones.IDTIPOTRANSACCIONMODULO));if(resultSet.wasNull()) {entity.setid_tipo_transaccion_modulo(null); }
				entity.setid_orden_compra(resultSet.getLong(strPrefijo+OrdenCompraConstantesFunciones.IDORDENCOMPRA));if(resultSet.wasNull()) {entity.setid_orden_compra(null); }
				entity.setid_asiento_contable(resultSet.getLong(strPrefijo+OrdenCompraConstantesFunciones.IDASIENTOCONTABLE));if(resultSet.wasNull()) {entity.setid_asiento_contable(null); }
				entity.setnumero_comprobante(resultSet.getString(strPrefijo+OrdenCompraConstantesFunciones.NUMEROCOMPROBANTE));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+OrdenCompraConstantesFunciones.FECHA).getTime()));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowOrdenCompra(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(OrdenCompra entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=OrdenCompraDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=OrdenCompraDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=OrdenCompraDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=OrdenCompraDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(OrdenCompraConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,OrdenCompraDataAccess.TABLENAME,OrdenCompraDataAccess.ISWITHSTOREPROCEDURES);
			
			OrdenCompraDataAccess.setOrdenCompraOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,OrdenCompra relordencompra)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relordencompra.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,OrdenCompra relordencompra)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relordencompra.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Modulo getModulo(Connexion connexion,OrdenCompra relordencompra)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,relordencompra.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public Ejercicio getEjercicio(Connexion connexion,OrdenCompra relordencompra)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relordencompra.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,OrdenCompra relordencompra)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relordencompra.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,OrdenCompra relordencompra)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relordencompra.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,OrdenCompra relordencompra)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relordencompra.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Usuario getUsuario(Connexion connexion,OrdenCompra relordencompra)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relordencompra.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public Moneda getMoneda(Connexion connexion,OrdenCompra relordencompra)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,relordencompra.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public TipoCambio getTipoCambio(Connexion connexion,OrdenCompra relordencompra)throws SQLException,Exception {

		TipoCambio tipocambio= new TipoCambio();

		try {
			TipoCambioDataAccess tipocambioDataAccess=new TipoCambioDataAccess();

			tipocambioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocambioDataAccess.setConnexionType(this.connexionType);
			tipocambioDataAccess.setParameterDbType(this.parameterDbType);

			tipocambio=tipocambioDataAccess.getEntity(connexion,relordencompra.getid_tipo_cambio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocambio;

	}

	public EstadoOrdenCompra getEstadoOrdenCompra(Connexion connexion,OrdenCompra relordencompra)throws SQLException,Exception {

		EstadoOrdenCompra estadoordencompra= new EstadoOrdenCompra();

		try {
			EstadoOrdenCompraDataAccess estadoordencompraDataAccess=new EstadoOrdenCompraDataAccess();

			estadoordencompraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadoordencompraDataAccess.setConnexionType(this.connexionType);
			estadoordencompraDataAccess.setParameterDbType(this.parameterDbType);

			estadoordencompra=estadoordencompraDataAccess.getEntity(connexion,relordencompra.getid_estado_orden_compra());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadoordencompra;

	}

	public Cliente getCliente(Connexion connexion,OrdenCompra relordencompra)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relordencompra.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Formato getFormato(Connexion connexion,OrdenCompra relordencompra)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relordencompra.getid_formato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public Transportista getTransportista(Connexion connexion,OrdenCompra relordencompra)throws SQLException,Exception {

		Transportista transportista= new Transportista();

		try {
			TransportistaDataAccess transportistaDataAccess=new TransportistaDataAccess();

			transportistaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transportistaDataAccess.setConnexionType(this.connexionType);
			transportistaDataAccess.setParameterDbType(this.parameterDbType);

			transportista=transportistaDataAccess.getEntity(connexion,relordencompra.getid_transportista());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transportista;

	}

	public Empleado getEmpleado(Connexion connexion,OrdenCompra relordencompra)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relordencompra.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public TipoTransaccionModulo getTipoTransaccionModulo(Connexion connexion,OrdenCompra relordencompra)throws SQLException,Exception {

		TipoTransaccionModulo tipotransaccionmodulo= new TipoTransaccionModulo();

		try {
			TipoTransaccionModuloDataAccess tipotransaccionmoduloDataAccess=new TipoTransaccionModuloDataAccess();

			tipotransaccionmoduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipotransaccionmoduloDataAccess.setConnexionType(this.connexionType);
			tipotransaccionmoduloDataAccess.setParameterDbType(this.parameterDbType);

			tipotransaccionmodulo=tipotransaccionmoduloDataAccess.getEntity(connexion,relordencompra.getid_tipo_transaccion_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipotransaccionmodulo;

	}

	public OrdenCompra getOrdenCompra(Connexion connexion,OrdenCompra relordencompra)throws SQLException,Exception {

		OrdenCompra ordencompra= new OrdenCompra();

		try {
			OrdenCompraDataAccess ordencompraDataAccess=new OrdenCompraDataAccess();

			ordencompraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ordencompraDataAccess.setConnexionType(this.connexionType);
			ordencompraDataAccess.setParameterDbType(this.parameterDbType);

			ordencompra=ordencompraDataAccess.getEntity(connexion,relordencompra.getid_orden_compra());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ordencompra;

	}

	public AsientoContable getAsientoContable(Connexion connexion,OrdenCompra relordencompra)throws SQLException,Exception {

		AsientoContable asientocontable= new AsientoContable();

		try {
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);

			asientocontable=asientocontableDataAccess.getEntity(connexion,relordencompra.getid_asiento_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontable;

	}


		
		public List<DetalleProve> getDetalleProves(Connexion connexion,OrdenCompra ordencompra)throws SQLException,Exception {

		List<DetalleProve> detalleproves= new ArrayList<DetalleProve>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+OrdenCompraConstantesFunciones.SCHEMA+".orden_compra ON "+DetalleProveConstantesFunciones.SCHEMA+".detalle_prove.id_orden_compra="+OrdenCompraConstantesFunciones.SCHEMA+".orden_compra.id WHERE "+OrdenCompraConstantesFunciones.SCHEMA+".orden_compra.id="+String.valueOf(ordencompra.getId());
			} else {
				sQuery=" INNER JOIN detalleprove.OrdenCompra WHERE detalleprove.OrdenCompra.id="+String.valueOf(ordencompra.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleProveDataAccess detalleproveDataAccess=new DetalleProveDataAccess();

			detalleproveDataAccess.setConnexionType(this.connexionType);
			detalleproveDataAccess.setParameterDbType(this.parameterDbType);
			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleproves;

	}

	public List<OrdenCompra> getOrdenCompras(Connexion connexion,OrdenCompra ordencompra)throws SQLException,Exception {

		List<OrdenCompra> ordencompras= new ArrayList<OrdenCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+OrdenCompraConstantesFunciones.SCHEMA+".orden_compra ON "+OrdenCompraConstantesFunciones.SCHEMA+".orden_compra.id_orden_compra="+OrdenCompraConstantesFunciones.SCHEMA+".orden_compra.id WHERE "+OrdenCompraConstantesFunciones.SCHEMA+".orden_compra.id="+String.valueOf(ordencompra.getId());
			} else {
				sQuery=" INNER JOIN ordencompra.OrdenCompra WHERE ordencompra.OrdenCompra.id="+String.valueOf(ordencompra.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			OrdenCompraDataAccess ordencompraDataAccess=new OrdenCompraDataAccess();

			ordencompraDataAccess.setConnexionType(this.connexionType);
			ordencompraDataAccess.setParameterDbType(this.parameterDbType);
			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ordencompras;

	}

	public List<AutoriPagoOrdenCompra> getAutoriPagoOrdenCompras(Connexion connexion,OrdenCompra ordencompra)throws SQLException,Exception {

		List<AutoriPagoOrdenCompra> autoripagoordencompras= new ArrayList<AutoriPagoOrdenCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+OrdenCompraConstantesFunciones.SCHEMA+".orden_compra ON "+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+".autori_pago_orden_compra.id_orden_compra="+OrdenCompraConstantesFunciones.SCHEMA+".orden_compra.id WHERE "+OrdenCompraConstantesFunciones.SCHEMA+".orden_compra.id="+String.valueOf(ordencompra.getId());
			} else {
				sQuery=" INNER JOIN autoripagoordencompra.OrdenCompra WHERE autoripagoordencompra.OrdenCompra.id="+String.valueOf(ordencompra.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AutoriPagoOrdenCompraDataAccess autoripagoordencompraDataAccess=new AutoriPagoOrdenCompraDataAccess();

			autoripagoordencompraDataAccess.setConnexionType(this.connexionType);
			autoripagoordencompraDataAccess.setParameterDbType(this.parameterDbType);
			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return autoripagoordencompras;

	}

	public List<Compra> getCompras(Connexion connexion,OrdenCompra ordencompra)throws SQLException,Exception {

		List<Compra> compras= new ArrayList<Compra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+OrdenCompraConstantesFunciones.SCHEMA+".orden_compra ON "+CompraConstantesFunciones.SCHEMA+".compra.id_orden_compra="+OrdenCompraConstantesFunciones.SCHEMA+".orden_compra.id WHERE "+OrdenCompraConstantesFunciones.SCHEMA+".orden_compra.id="+String.valueOf(ordencompra.getId());
			} else {
				sQuery=" INNER JOIN compra.OrdenCompra WHERE compra.OrdenCompra.id="+String.valueOf(ordencompra.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CompraDataAccess compraDataAccess=new CompraDataAccess();

			compraDataAccess.setConnexionType(this.connexionType);
			compraDataAccess.setParameterDbType(this.parameterDbType);
			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return compras;

	}

	public List<DetalleOrdenCompra> getDetalleOrdenCompras(Connexion connexion,OrdenCompra ordencompra)throws SQLException,Exception {

		List<DetalleOrdenCompra> detalleordencompras= new ArrayList<DetalleOrdenCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+OrdenCompraConstantesFunciones.SCHEMA+".orden_compra ON "+DetalleOrdenCompraConstantesFunciones.SCHEMA+".detalle_orden_compra.id_orden_compra="+OrdenCompraConstantesFunciones.SCHEMA+".orden_compra.id WHERE "+OrdenCompraConstantesFunciones.SCHEMA+".orden_compra.id="+String.valueOf(ordencompra.getId());
			} else {
				sQuery=" INNER JOIN detalleordencompra.OrdenCompra WHERE detalleordencompra.OrdenCompra.id="+String.valueOf(ordencompra.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleOrdenCompraDataAccess detalleordencompraDataAccess=new DetalleOrdenCompraDataAccess();

			detalleordencompraDataAccess.setConnexionType(this.connexionType);
			detalleordencompraDataAccess.setParameterDbType(this.parameterDbType);
			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleordencompras;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,OrdenCompra ordencompra) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!ordencompra.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(ordencompra.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(ordencompra.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(ordencompra.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(ordencompra.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(ordencompra.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(ordencompra.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(ordencompra.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(ordencompra.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(ordencompra.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_entrega=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_entrega.setValue(ordencompra.getfecha_entrega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_entrega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_secuencial=new ParameterValue<String>();
					parameterMaintenanceValuenumero_secuencial.setValue(ordencompra.getnumero_secuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_secuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda.setValue(ordencompra.getid_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_cambio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_cambio.setValue(ordencompra.getid_tipo_cambio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_cambio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_orden_compra=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_orden_compra.setValue(ordencompra.getid_estado_orden_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_orden_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(ordencompra.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato.setValue(ordencompra.getid_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transportista=new ParameterValue<Long>();
					parameterMaintenanceValueid_transportista.setValue(ordencompra.getid_transportista());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transportista);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(ordencompra.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(ordencompra.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_descuento=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_descuento.setValue(ordencompra.getporcentaje_descuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_descuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesuman=new ParameterValue<Double>();
					parameterMaintenanceValuesuman.setValue(ordencompra.getsuman());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesuman);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice=new ParameterValue<Double>();
					parameterMaintenanceValueice.setValue(ordencompra.getice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_descuento=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_descuento.setValue(ordencompra.getvalor_descuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_descuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_descuento=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_descuento.setValue(ordencompra.gettotal_descuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_descuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva=new ParameterValue<Double>();
					parameterMaintenanceValueiva.setValue(ordencompra.getiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuestock=new ParameterValue<Double>();
					parameterMaintenanceValuestock.setValue(ordencompra.getstock());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuestock);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesub_total=new ParameterValue<Double>();
					parameterMaintenanceValuesub_total.setValue(ordencompra.getsub_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesub_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_otro=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_otro.setValue(ordencompra.gettotal_otro());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_otro);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueultimo_costo=new ParameterValue<Double>();
					parameterMaintenanceValueultimo_costo.setValue(ordencompra.getultimo_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueultimo_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuenumero_items=new ParameterValue<Double>();
					parameterMaintenanceValuenumero_items.setValue(ordencompra.getnumero_items());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_items);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueretencion=new ParameterValue<Double>();
					parameterMaintenanceValueretencion.setValue(ordencompra.getretencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueretencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(ordencompra.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueflete=new ParameterValue<Double>();
					parameterMaintenanceValueflete.setValue(ordencompra.getflete());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueflete);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueimpuesto=new ParameterValue<Double>();
					parameterMaintenanceValueimpuesto.setValue(ordencompra.getimpuesto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueimpuesto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_transaccion_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_transaccion_modulo.setValue(ordencompra.getid_tipo_transaccion_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_transaccion_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_orden_compra=new ParameterValue<Long>();
					parameterMaintenanceValueid_orden_compra.setValue(ordencompra.getid_orden_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_orden_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_asiento_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_asiento_contable.setValue(ordencompra.getid_asiento_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_asiento_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_comprobante=new ParameterValue<String>();
					parameterMaintenanceValuenumero_comprobante.setValue(ordencompra.getnumero_comprobante());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_comprobante);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(ordencompra.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
						if(!ordencompra.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(ordencompra.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(ordencompra.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(ordencompra.getId());
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
	
	public void setIsNewIsChangedFalseOrdenCompra(OrdenCompra ordencompra)throws Exception  {		
		ordencompra.setIsNew(false);
		ordencompra.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseOrdenCompras(List<OrdenCompra> ordencompras)throws Exception  {				
		for(OrdenCompra ordencompra:ordencompras) {
			ordencompra.setIsNew(false);
			ordencompra.setIsChanged(false);
		}
	}
	
	public void generarExportarOrdenCompra(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
