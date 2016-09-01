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
import com.bydan.erp.inventario.util.*;//MovimientoInventarioConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.facturacion.util.*;




@SuppressWarnings("unused")
final public class MovimientoInventarioDataAccess extends  MovimientoInventarioDataAccessAdditional{ //MovimientoInventarioDataAccessAdditional,DataAccessHelper<MovimientoInventario>
	//static Logger logger = Logger.getLogger(MovimientoInventarioDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="movimiento_inventario";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_modulo,id_ejercicio,id_periodo,id_anio,id_mes,id_usuario,id_transaccion,fecha_emision,fecha_entrega,numero_secuencial,id_moneda,id_tipo_cambio,id_estado_movimiento_inventario,id_empleado,id_formato,id_factura,numero_factura,id_guia_remision,id_transportista,descripcion,porcentaje_descuento,suman,ice,valor_descuento,total_descuento,iva,stock,sub_total,total_otro,ultimo_costo,numero_items,retencion,total,flete,impuesto,id_tipo_transaccion_modulo,id_compra,id_asiento_contable,generico_id,tipo_id,numero_comprobante,fecha)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_modulo=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_usuario=?,id_transaccion=?,fecha_emision=?,fecha_entrega=?,numero_secuencial=?,id_moneda=?,id_tipo_cambio=?,id_estado_movimiento_inventario=?,id_empleado=?,id_formato=?,id_factura=?,numero_factura=?,id_guia_remision=?,id_transportista=?,descripcion=?,porcentaje_descuento=?,suman=?,ice=?,valor_descuento=?,total_descuento=?,iva=?,stock=?,sub_total=?,total_otro=?,ultimo_costo=?,numero_items=?,retencion=?,total=?,flete=?,impuesto=?,id_tipo_transaccion_modulo=?,id_compra=?,id_asiento_contable=?,generico_id=?,tipo_id=?,numero_comprobante=?,fecha=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select movimientoinventario from "+MovimientoInventarioConstantesFunciones.SPERSISTENCENAME+" movimientoinventario";
	public static String QUERYSELECTNATIVE="select "+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".version_row,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_empresa,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_sucursal,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_modulo,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_ejercicio,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_periodo,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_anio,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_mes,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_usuario,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_transaccion,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".fecha_emision,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".fecha_entrega,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".numero_secuencial,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_moneda,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_tipo_cambio,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_estado_movimiento_inventario,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_empleado,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_formato,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_factura,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".numero_factura,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_guia_remision,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_transportista,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".descripcion,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".porcentaje_descuento,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".suman,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".ice,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".valor_descuento,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".total_descuento,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".iva,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".stock,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".sub_total,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".total_otro,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".ultimo_costo,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".numero_items,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".retencion,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".total,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".flete,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".impuesto,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_compra,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id_asiento_contable,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".generico_id,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".tipo_id,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".numero_comprobante,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".fecha from "+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME;//+" as "+MovimientoInventarioConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".id,"+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+".version_row from "+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME;//+" as "+MovimientoInventarioConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+MovimientoInventarioConstantesFunciones.SCHEMA+"."+MovimientoInventarioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_modulo=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_usuario=?,id_transaccion=?,fecha_emision=?,fecha_entrega=?,numero_secuencial=?,id_moneda=?,id_tipo_cambio=?,id_estado_movimiento_inventario=?,id_empleado=?,id_formato=?,id_factura=?,numero_factura=?,id_guia_remision=?,id_transportista=?,descripcion=?,porcentaje_descuento=?,suman=?,ice=?,valor_descuento=?,total_descuento=?,iva=?,stock=?,sub_total=?,total_otro=?,ultimo_costo=?,numero_items=?,retencion=?,total=?,flete=?,impuesto=?,id_tipo_transaccion_modulo=?,id_compra=?,id_asiento_contable=?,generico_id=?,tipo_id=?,numero_comprobante=?,fecha=?";
	
	public static String STOREPROCEDUREINSERT="call SP_MOVIMIENTOINVENTARIO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_MOVIMIENTOINVENTARIO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_MOVIMIENTOINVENTARIO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_MOVIMIENTOINVENTARIO_SELECT(?,?)";
	
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
	
	
	protected MovimientoInventarioDataAccessAdditional movimientoinventarioDataAccessAdditional=null;
	
	public MovimientoInventarioDataAccessAdditional getMovimientoInventarioDataAccessAdditional() {
		return this.movimientoinventarioDataAccessAdditional;
	}
	
	public void setMovimientoInventarioDataAccessAdditional(MovimientoInventarioDataAccessAdditional movimientoinventarioDataAccessAdditional) {
		try {
			this.movimientoinventarioDataAccessAdditional=movimientoinventarioDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public MovimientoInventarioDataAccess() {
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
		MovimientoInventarioDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		MovimientoInventarioDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		MovimientoInventarioDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setMovimientoInventarioOriginal(MovimientoInventario movimientoinventario)throws Exception  {
		movimientoinventario.setMovimientoInventarioOriginal((MovimientoInventario)movimientoinventario.clone());		
	}
	
	public void setMovimientoInventariosOriginal(List<MovimientoInventario> movimientoinventarios)throws Exception  {
		
		for(MovimientoInventario movimientoinventario:movimientoinventarios){
			movimientoinventario.setMovimientoInventarioOriginal((MovimientoInventario)movimientoinventario.clone());
		}
	}
	
	public static void setMovimientoInventarioOriginalStatic(MovimientoInventario movimientoinventario)throws Exception  {
		movimientoinventario.setMovimientoInventarioOriginal((MovimientoInventario)movimientoinventario.clone());		
	}
	
	public static void setMovimientoInventariosOriginalStatic(List<MovimientoInventario> movimientoinventarios)throws Exception  {
		
		for(MovimientoInventario movimientoinventario:movimientoinventarios){
			movimientoinventario.setMovimientoInventarioOriginal((MovimientoInventario)movimientoinventario.clone());
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
	
	public  MovimientoInventario getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		MovimientoInventario entity = new MovimientoInventario();		
		
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
	
	public  MovimientoInventario getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		MovimientoInventario entity = new MovimientoInventario();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=MovimientoInventarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=MovimientoInventarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.MovimientoInventario.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setMovimientoInventarioOriginal(new MovimientoInventario());
      	    	entity=super.getEntity("",entity,resultSet,MovimientoInventarioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityMovimientoInventario("",entity,resultSet); 
				
				//entity.setMovimientoInventarioOriginal(super.getEntity("",entity.getMovimientoInventarioOriginal(),resultSet,MovimientoInventarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMovimientoInventarioOriginal(this.getEntityMovimientoInventario("",entity.getMovimientoInventarioOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseMovimientoInventario(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  MovimientoInventario getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		MovimientoInventario entity = new MovimientoInventario();
				
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
	
	public  MovimientoInventario getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		MovimientoInventario entity = new MovimientoInventario();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=MovimientoInventarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=MovimientoInventarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MovimientoInventarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.MovimientoInventario.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setMovimientoInventarioOriginal(new MovimientoInventario());
      	    	entity=super.getEntity("",entity,resultSet,MovimientoInventarioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityMovimientoInventario("",entity,resultSet);    
				
				//entity.setMovimientoInventarioOriginal(super.getEntity("",entity.getMovimientoInventarioOriginal(),resultSet,MovimientoInventarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMovimientoInventarioOriginal(this.getEntityMovimientoInventario("",entity.getMovimientoInventarioOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseMovimientoInventario(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //MovimientoInventario
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		MovimientoInventario entity = new MovimientoInventario();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=MovimientoInventarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=MovimientoInventarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MovimientoInventarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.MovimientoInventario.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseMovimientoInventario(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<MovimientoInventario> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<MovimientoInventario> entities = new  ArrayList<MovimientoInventario>();
		MovimientoInventario entity = new MovimientoInventario();		  
		
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
	
	public  List<MovimientoInventario> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<MovimientoInventario> entities = new  ArrayList<MovimientoInventario>();
		MovimientoInventario entity = new MovimientoInventario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=MovimientoInventarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=MovimientoInventarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MovimientoInventarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MovimientoInventario();
      	    	entity=super.getEntity("",entity,resultSet,MovimientoInventarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityMovimientoInventario("",entity,resultSet);
      	    	
				//entity.setMovimientoInventarioOriginal( new MovimientoInventario());
      	    	//entity.setMovimientoInventarioOriginal(super.getEntity("",entity.getMovimientoInventarioOriginal(),resultSet,MovimientoInventarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMovimientoInventarioOriginal(this.getEntityMovimientoInventario("",entity.getMovimientoInventarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseMovimientoInventarios(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMovimientoInventario(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<MovimientoInventario> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<MovimientoInventario> entities = new  ArrayList<MovimientoInventario>();
		MovimientoInventario entity = new MovimientoInventario();		  
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
	
	public  List<MovimientoInventario> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<MovimientoInventario> entities = new  ArrayList<MovimientoInventario>();
		MovimientoInventario entity = new MovimientoInventario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MovimientoInventario();
				
				if(conMapGenerico) {
					entity.inicializarMapMovimientoInventario();
					//entity.setMapMovimientoInventario(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapMovimientoInventarioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapMovimientoInventario().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,MovimientoInventarioDataAccess.ISWITHSCHEMA);         		
					entity=MovimientoInventarioDataAccess.getEntityMovimientoInventario("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setMovimientoInventarioOriginal( new MovimientoInventario());
					////entity.setMovimientoInventarioOriginal(super.getEntity("",entity.getMovimientoInventarioOriginal(),resultSet,MovimientoInventarioDataAccess.ISWITHSCHEMA));         		
					////entity.setMovimientoInventarioOriginal(this.getEntityMovimientoInventario("",entity.getMovimientoInventarioOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseMovimientoInventarios(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMovimientoInventario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public MovimientoInventario getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		MovimientoInventario entity = new MovimientoInventario();		  
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
	
	public  MovimientoInventario getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		MovimientoInventario entity = new MovimientoInventario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MovimientoInventario();
				
				if(conMapGenerico) {
					entity.inicializarMapMovimientoInventario();
					//entity.setMapMovimientoInventario(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapMovimientoInventarioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapMovimientoInventario().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,MovimientoInventarioDataAccess.ISWITHSCHEMA);         		
					entity=MovimientoInventarioDataAccess.getEntityMovimientoInventario("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setMovimientoInventarioOriginal( new MovimientoInventario());
					////entity.setMovimientoInventarioOriginal(super.getEntity("",entity.getMovimientoInventarioOriginal(),resultSet,MovimientoInventarioDataAccess.ISWITHSCHEMA));         		
					////entity.setMovimientoInventarioOriginal(this.getEntityMovimientoInventario("",entity.getMovimientoInventarioOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseMovimientoInventario(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMovimientoInventario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static MovimientoInventario getEntityMovimientoInventario(String strPrefijo,MovimientoInventario entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = MovimientoInventario.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = MovimientoInventario.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					MovimientoInventarioDataAccess.setFieldReflectionMovimientoInventario(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasMovimientoInventario=MovimientoInventarioConstantesFunciones.getTodosTiposColumnasMovimientoInventario();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasMovimientoInventario) {
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
							field = MovimientoInventario.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = MovimientoInventario.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						MovimientoInventarioDataAccess.setFieldReflectionMovimientoInventario(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionMovimientoInventario(Field field,String strPrefijo,String sColumn,MovimientoInventario entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case MovimientoInventarioConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.IDTRANSACCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case MovimientoInventarioConstantesFunciones.FECHAENTREGA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case MovimientoInventarioConstantesFunciones.NUMEROSECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.IDTIPOCAMBIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.IDESTADOMOVIMIENTOINVENTARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.IDFORMATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.IDFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.NUMEROFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.IDGUIAREMISION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.IDTRANSPORTISTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.PORCENTAJEDESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.SUMAN:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.ICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.VALORDESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.TOTALDESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.STOCK:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.SUBTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.TOTALOTRO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.ULTIMOCOSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.NUMEROITEMS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.RETENCION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.FLETE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.IMPUESTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.IDTIPOTRANSACCIONMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.IDCOMPRA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.IDASIENTOCONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.GENERICOID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.TIPOID:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.NUMEROCOMPROBANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MovimientoInventarioConstantesFunciones.FECHA:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<MovimientoInventario>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<MovimientoInventario> entities = new  ArrayList<MovimientoInventario>();
		MovimientoInventario entity = new MovimientoInventario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=MovimientoInventarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=MovimientoInventarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MovimientoInventarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new MovimientoInventario();
					entity=super.getEntity("",entity,resultSet,MovimientoInventarioDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityMovimientoInventario("",entity,resultSet);
					
					//entity.setMovimientoInventarioOriginal( new MovimientoInventario());
					//entity.setMovimientoInventarioOriginal(super.getEntity("",entity.getMovimientoInventarioOriginal(),resultSet,MovimientoInventarioDataAccess.ISWITHSCHEMA));         		
					//entity.setMovimientoInventarioOriginal(this.getEntityMovimientoInventario("",entity.getMovimientoInventarioOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseMovimientoInventarios(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMovimientoInventario(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<MovimientoInventario>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<MovimientoInventario> entities = new  ArrayList<MovimientoInventario>();
		MovimientoInventario entity = new MovimientoInventario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=MovimientoInventarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=MovimientoInventarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MovimientoInventarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<MovimientoInventario> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MovimientoInventario> entities = new  ArrayList<MovimientoInventario>();
		MovimientoInventario entity = new MovimientoInventario();		  
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
	
	public  List<MovimientoInventario> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MovimientoInventario> entities = new  ArrayList<MovimientoInventario>();
		MovimientoInventario entity = new MovimientoInventario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MovimientoInventario();
      	    	entity=super.getEntity("",entity,resultSet,MovimientoInventarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityMovimientoInventario("",entity,resultSet);
      	    	
				//entity.setMovimientoInventarioOriginal( new MovimientoInventario());
      	    	//entity.setMovimientoInventarioOriginal(super.getEntity("",entity.getMovimientoInventarioOriginal(),resultSet,MovimientoInventarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMovimientoInventarioOriginal(this.getEntityMovimientoInventario("",entity.getMovimientoInventarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseMovimientoInventarios(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMovimientoInventario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<MovimientoInventario> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MovimientoInventario> entities = new  ArrayList<MovimientoInventario>();
		MovimientoInventario entity = new MovimientoInventario();		  
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
	
	public  List<MovimientoInventario> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MovimientoInventario> entities = new  ArrayList<MovimientoInventario>();
		MovimientoInventario entity = new MovimientoInventario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MovimientoInventario();
      	    	entity=super.getEntity("",entity,resultSet,MovimientoInventarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityMovimientoInventario("",entity,resultSet);
      	    	
				//entity.setMovimientoInventarioOriginal( new MovimientoInventario());
      	    	//entity.setMovimientoInventarioOriginal(super.getEntity("",entity.getMovimientoInventarioOriginal(),resultSet,MovimientoInventarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMovimientoInventarioOriginal(this.getEntityMovimientoInventario("",entity.getMovimientoInventarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseMovimientoInventarios(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public MovimientoInventario getEntityMovimientoInventario(String strPrefijo,MovimientoInventario entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+MovimientoInventarioConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+MovimientoInventarioConstantesFunciones.IDSUCURSAL));
				entity.setid_modulo(resultSet.getLong(strPrefijo+MovimientoInventarioConstantesFunciones.IDMODULO));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+MovimientoInventarioConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+MovimientoInventarioConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+MovimientoInventarioConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+MovimientoInventarioConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_usuario(resultSet.getLong(strPrefijo+MovimientoInventarioConstantesFunciones.IDUSUARIO));
				entity.setid_transaccion(resultSet.getLong(strPrefijo+MovimientoInventarioConstantesFunciones.IDTRANSACCION));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+MovimientoInventarioConstantesFunciones.FECHAEMISION).getTime()));
				entity.setfecha_entrega(new Date(resultSet.getDate(strPrefijo+MovimientoInventarioConstantesFunciones.FECHAENTREGA).getTime()));
				entity.setnumero_secuencial(resultSet.getString(strPrefijo+MovimientoInventarioConstantesFunciones.NUMEROSECUENCIAL));
				entity.setid_moneda(resultSet.getLong(strPrefijo+MovimientoInventarioConstantesFunciones.IDMONEDA));
				entity.setid_tipo_cambio(resultSet.getLong(strPrefijo+MovimientoInventarioConstantesFunciones.IDTIPOCAMBIO));if(resultSet.wasNull()) {entity.setid_tipo_cambio(null); }
				entity.setid_estado_movimiento_inventario(resultSet.getLong(strPrefijo+MovimientoInventarioConstantesFunciones.IDESTADOMOVIMIENTOINVENTARIO));
				entity.setid_empleado(resultSet.getLong(strPrefijo+MovimientoInventarioConstantesFunciones.IDEMPLEADO));
				entity.setid_formato(resultSet.getLong(strPrefijo+MovimientoInventarioConstantesFunciones.IDFORMATO));
				entity.setid_factura(resultSet.getLong(strPrefijo+MovimientoInventarioConstantesFunciones.IDFACTURA));if(resultSet.wasNull()) {entity.setid_factura(null); }
				entity.setnumero_factura(resultSet.getString(strPrefijo+MovimientoInventarioConstantesFunciones.NUMEROFACTURA));
				entity.setid_guia_remision(resultSet.getLong(strPrefijo+MovimientoInventarioConstantesFunciones.IDGUIAREMISION));if(resultSet.wasNull()) {entity.setid_guia_remision(null); }
				entity.setid_transportista(resultSet.getLong(strPrefijo+MovimientoInventarioConstantesFunciones.IDTRANSPORTISTA));if(resultSet.wasNull()) {entity.setid_transportista(null); }
				entity.setdescripcion(resultSet.getString(strPrefijo+MovimientoInventarioConstantesFunciones.DESCRIPCION));
				entity.setporcentaje_descuento(resultSet.getDouble(strPrefijo+MovimientoInventarioConstantesFunciones.PORCENTAJEDESCUENTO));
				entity.setsuman(resultSet.getDouble(strPrefijo+MovimientoInventarioConstantesFunciones.SUMAN));
				entity.setice(resultSet.getDouble(strPrefijo+MovimientoInventarioConstantesFunciones.ICE));
				entity.setvalor_descuento(resultSet.getDouble(strPrefijo+MovimientoInventarioConstantesFunciones.VALORDESCUENTO));
				entity.settotal_descuento(resultSet.getDouble(strPrefijo+MovimientoInventarioConstantesFunciones.TOTALDESCUENTO));
				entity.setiva(resultSet.getDouble(strPrefijo+MovimientoInventarioConstantesFunciones.IVA));
				entity.setstock(resultSet.getDouble(strPrefijo+MovimientoInventarioConstantesFunciones.STOCK));
				entity.setsub_total(resultSet.getDouble(strPrefijo+MovimientoInventarioConstantesFunciones.SUBTOTAL));
				entity.settotal_otro(resultSet.getDouble(strPrefijo+MovimientoInventarioConstantesFunciones.TOTALOTRO));
				entity.setultimo_costo(resultSet.getDouble(strPrefijo+MovimientoInventarioConstantesFunciones.ULTIMOCOSTO));
				entity.setnumero_items(resultSet.getInt(strPrefijo+MovimientoInventarioConstantesFunciones.NUMEROITEMS));
				entity.setretencion(resultSet.getDouble(strPrefijo+MovimientoInventarioConstantesFunciones.RETENCION));
				entity.settotal(resultSet.getDouble(strPrefijo+MovimientoInventarioConstantesFunciones.TOTAL));
				entity.setflete(resultSet.getDouble(strPrefijo+MovimientoInventarioConstantesFunciones.FLETE));
				entity.setimpuesto(resultSet.getDouble(strPrefijo+MovimientoInventarioConstantesFunciones.IMPUESTO));
				entity.setid_tipo_transaccion_modulo(resultSet.getLong(strPrefijo+MovimientoInventarioConstantesFunciones.IDTIPOTRANSACCIONMODULO));if(resultSet.wasNull()) {entity.setid_tipo_transaccion_modulo(null); }
				entity.setid_compra(resultSet.getLong(strPrefijo+MovimientoInventarioConstantesFunciones.IDCOMPRA));if(resultSet.wasNull()) {entity.setid_compra(null); }
				entity.setid_asiento_contable(resultSet.getLong(strPrefijo+MovimientoInventarioConstantesFunciones.IDASIENTOCONTABLE));if(resultSet.wasNull()) {entity.setid_asiento_contable(null); }
				entity.setgenerico_id(resultSet.getLong(strPrefijo+MovimientoInventarioConstantesFunciones.GENERICOID));
				entity.settipo_id(resultSet.getString(strPrefijo+MovimientoInventarioConstantesFunciones.TIPOID));
				entity.setnumero_comprobante(resultSet.getString(strPrefijo+MovimientoInventarioConstantesFunciones.NUMEROCOMPROBANTE));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+MovimientoInventarioConstantesFunciones.FECHA).getTime()));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowMovimientoInventario(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(MovimientoInventario entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=MovimientoInventarioDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=MovimientoInventarioDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=MovimientoInventarioDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=MovimientoInventarioDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(MovimientoInventarioConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,MovimientoInventarioDataAccess.TABLENAME,MovimientoInventarioDataAccess.ISWITHSTOREPROCEDURES);
			
			MovimientoInventarioDataAccess.setMovimientoInventarioOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,MovimientoInventario relmovimientoinventario)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relmovimientoinventario.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,MovimientoInventario relmovimientoinventario)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relmovimientoinventario.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Modulo getModulo(Connexion connexion,MovimientoInventario relmovimientoinventario)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,relmovimientoinventario.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public Ejercicio getEjercicio(Connexion connexion,MovimientoInventario relmovimientoinventario)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relmovimientoinventario.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,MovimientoInventario relmovimientoinventario)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relmovimientoinventario.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,MovimientoInventario relmovimientoinventario)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relmovimientoinventario.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,MovimientoInventario relmovimientoinventario)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relmovimientoinventario.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Usuario getUsuario(Connexion connexion,MovimientoInventario relmovimientoinventario)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relmovimientoinventario.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public Transaccion getTransaccion(Connexion connexion,MovimientoInventario relmovimientoinventario)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relmovimientoinventario.getid_transaccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Moneda getMoneda(Connexion connexion,MovimientoInventario relmovimientoinventario)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,relmovimientoinventario.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public TipoCambio getTipoCambio(Connexion connexion,MovimientoInventario relmovimientoinventario)throws SQLException,Exception {

		TipoCambio tipocambio= new TipoCambio();

		try {
			TipoCambioDataAccess tipocambioDataAccess=new TipoCambioDataAccess();

			tipocambioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocambioDataAccess.setConnexionType(this.connexionType);
			tipocambioDataAccess.setParameterDbType(this.parameterDbType);

			tipocambio=tipocambioDataAccess.getEntity(connexion,relmovimientoinventario.getid_tipo_cambio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocambio;

	}

	public EstadoMovimientoInventario getEstadoMovimientoInventario(Connexion connexion,MovimientoInventario relmovimientoinventario)throws SQLException,Exception {

		EstadoMovimientoInventario estadomovimientoinventario= new EstadoMovimientoInventario();

		try {
			EstadoMovimientoInventarioDataAccess estadomovimientoinventarioDataAccess=new EstadoMovimientoInventarioDataAccess();

			estadomovimientoinventarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadomovimientoinventarioDataAccess.setConnexionType(this.connexionType);
			estadomovimientoinventarioDataAccess.setParameterDbType(this.parameterDbType);

			estadomovimientoinventario=estadomovimientoinventarioDataAccess.getEntity(connexion,relmovimientoinventario.getid_estado_movimiento_inventario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadomovimientoinventario;

	}

	public Empleado getEmpleado(Connexion connexion,MovimientoInventario relmovimientoinventario)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relmovimientoinventario.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Formato getFormato(Connexion connexion,MovimientoInventario relmovimientoinventario)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relmovimientoinventario.getid_formato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public Factura getFactura(Connexion connexion,MovimientoInventario relmovimientoinventario)throws SQLException,Exception {

		Factura factura= new Factura();

		try {
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);

			factura=facturaDataAccess.getEntity(connexion,relmovimientoinventario.getid_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return factura;

	}

	public GuiaRemision getGuiaRemision(Connexion connexion,MovimientoInventario relmovimientoinventario)throws SQLException,Exception {

		GuiaRemision guiaremision= new GuiaRemision();

		try {
			GuiaRemisionDataAccess guiaremisionDataAccess=new GuiaRemisionDataAccess();

			guiaremisionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			guiaremisionDataAccess.setConnexionType(this.connexionType);
			guiaremisionDataAccess.setParameterDbType(this.parameterDbType);

			guiaremision=guiaremisionDataAccess.getEntity(connexion,relmovimientoinventario.getid_guia_remision());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return guiaremision;

	}

	public Transportista getTransportista(Connexion connexion,MovimientoInventario relmovimientoinventario)throws SQLException,Exception {

		Transportista transportista= new Transportista();

		try {
			TransportistaDataAccess transportistaDataAccess=new TransportistaDataAccess();

			transportistaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transportistaDataAccess.setConnexionType(this.connexionType);
			transportistaDataAccess.setParameterDbType(this.parameterDbType);

			transportista=transportistaDataAccess.getEntity(connexion,relmovimientoinventario.getid_transportista());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transportista;

	}

	public TipoTransaccionModulo getTipoTransaccionModulo(Connexion connexion,MovimientoInventario relmovimientoinventario)throws SQLException,Exception {

		TipoTransaccionModulo tipotransaccionmodulo= new TipoTransaccionModulo();

		try {
			TipoTransaccionModuloDataAccess tipotransaccionmoduloDataAccess=new TipoTransaccionModuloDataAccess();

			tipotransaccionmoduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipotransaccionmoduloDataAccess.setConnexionType(this.connexionType);
			tipotransaccionmoduloDataAccess.setParameterDbType(this.parameterDbType);

			tipotransaccionmodulo=tipotransaccionmoduloDataAccess.getEntity(connexion,relmovimientoinventario.getid_tipo_transaccion_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipotransaccionmodulo;

	}

	public Compra getCompra(Connexion connexion,MovimientoInventario relmovimientoinventario)throws SQLException,Exception {

		Compra compra= new Compra();

		try {
			CompraDataAccess compraDataAccess=new CompraDataAccess();

			compraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			compraDataAccess.setConnexionType(this.connexionType);
			compraDataAccess.setParameterDbType(this.parameterDbType);

			compra=compraDataAccess.getEntity(connexion,relmovimientoinventario.getid_compra());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return compra;

	}

	public AsientoContable getAsientoContable(Connexion connexion,MovimientoInventario relmovimientoinventario)throws SQLException,Exception {

		AsientoContable asientocontable= new AsientoContable();

		try {
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);

			asientocontable=asientocontableDataAccess.getEntity(connexion,relmovimientoinventario.getid_asiento_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontable;

	}


		
		public List<DetalleMovimientoInventario> getDetalleMovimientoInventarios(Connexion connexion,MovimientoInventario movimientoinventario)throws SQLException,Exception {

		List<DetalleMovimientoInventario> detallemovimientoinventarios= new ArrayList<DetalleMovimientoInventario>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+MovimientoInventarioConstantesFunciones.SCHEMA+".movimiento_inventario ON "+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+".detalle_movimiento_inventario.id_movimiento_inventario="+MovimientoInventarioConstantesFunciones.SCHEMA+".movimiento_inventario.id WHERE "+MovimientoInventarioConstantesFunciones.SCHEMA+".movimiento_inventario.id="+String.valueOf(movimientoinventario.getId());
			} else {
				sQuery=" INNER JOIN detallemovimientoinventario.MovimientoInventario WHERE detallemovimientoinventario.MovimientoInventario.id="+String.valueOf(movimientoinventario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleMovimientoInventarioDataAccess detallemovimientoinventarioDataAccess=new DetalleMovimientoInventarioDataAccess();

			detallemovimientoinventarioDataAccess.setConnexionType(this.connexionType);
			detallemovimientoinventarioDataAccess.setParameterDbType(this.parameterDbType);
			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallemovimientoinventarios;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,MovimientoInventario movimientoinventario) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!movimientoinventario.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(movimientoinventario.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(movimientoinventario.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(movimientoinventario.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(movimientoinventario.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(movimientoinventario.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(movimientoinventario.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(movimientoinventario.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(movimientoinventario.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion.setValue(movimientoinventario.getid_transaccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(movimientoinventario.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_entrega=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_entrega.setValue(movimientoinventario.getfecha_entrega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_entrega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_secuencial=new ParameterValue<String>();
					parameterMaintenanceValuenumero_secuencial.setValue(movimientoinventario.getnumero_secuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_secuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda.setValue(movimientoinventario.getid_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_cambio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_cambio.setValue(movimientoinventario.getid_tipo_cambio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_cambio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_movimiento_inventario=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_movimiento_inventario.setValue(movimientoinventario.getid_estado_movimiento_inventario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_movimiento_inventario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(movimientoinventario.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato.setValue(movimientoinventario.getid_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_factura.setValue(movimientoinventario.getid_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_factura=new ParameterValue<String>();
					parameterMaintenanceValuenumero_factura.setValue(movimientoinventario.getnumero_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_guia_remision=new ParameterValue<Long>();
					parameterMaintenanceValueid_guia_remision.setValue(movimientoinventario.getid_guia_remision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_guia_remision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transportista=new ParameterValue<Long>();
					parameterMaintenanceValueid_transportista.setValue(movimientoinventario.getid_transportista());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transportista);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(movimientoinventario.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_descuento=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_descuento.setValue(movimientoinventario.getporcentaje_descuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_descuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesuman=new ParameterValue<Double>();
					parameterMaintenanceValuesuman.setValue(movimientoinventario.getsuman());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesuman);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice=new ParameterValue<Double>();
					parameterMaintenanceValueice.setValue(movimientoinventario.getice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_descuento=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_descuento.setValue(movimientoinventario.getvalor_descuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_descuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_descuento=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_descuento.setValue(movimientoinventario.gettotal_descuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_descuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva=new ParameterValue<Double>();
					parameterMaintenanceValueiva.setValue(movimientoinventario.getiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuestock=new ParameterValue<Double>();
					parameterMaintenanceValuestock.setValue(movimientoinventario.getstock());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuestock);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesub_total=new ParameterValue<Double>();
					parameterMaintenanceValuesub_total.setValue(movimientoinventario.getsub_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesub_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_otro=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_otro.setValue(movimientoinventario.gettotal_otro());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_otro);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueultimo_costo=new ParameterValue<Double>();
					parameterMaintenanceValueultimo_costo.setValue(movimientoinventario.getultimo_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueultimo_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_items=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_items.setValue(movimientoinventario.getnumero_items());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_items);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueretencion=new ParameterValue<Double>();
					parameterMaintenanceValueretencion.setValue(movimientoinventario.getretencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueretencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(movimientoinventario.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueflete=new ParameterValue<Double>();
					parameterMaintenanceValueflete.setValue(movimientoinventario.getflete());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueflete);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueimpuesto=new ParameterValue<Double>();
					parameterMaintenanceValueimpuesto.setValue(movimientoinventario.getimpuesto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueimpuesto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_transaccion_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_transaccion_modulo.setValue(movimientoinventario.getid_tipo_transaccion_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_transaccion_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_compra=new ParameterValue<Long>();
					parameterMaintenanceValueid_compra.setValue(movimientoinventario.getid_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_asiento_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_asiento_contable.setValue(movimientoinventario.getid_asiento_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_asiento_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValuegenerico_id=new ParameterValue<Long>();
					parameterMaintenanceValuegenerico_id.setValue(movimientoinventario.getgenerico_id());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuegenerico_id);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetipo_id=new ParameterValue<String>();
					parameterMaintenanceValuetipo_id.setValue(movimientoinventario.gettipo_id());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetipo_id);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_comprobante=new ParameterValue<String>();
					parameterMaintenanceValuenumero_comprobante.setValue(movimientoinventario.getnumero_comprobante());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_comprobante);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(movimientoinventario.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
						if(!movimientoinventario.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(movimientoinventario.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(movimientoinventario.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(movimientoinventario.getId());
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
	
	public void setIsNewIsChangedFalseMovimientoInventario(MovimientoInventario movimientoinventario)throws Exception  {		
		movimientoinventario.setIsNew(false);
		movimientoinventario.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseMovimientoInventarios(List<MovimientoInventario> movimientoinventarios)throws Exception  {				
		for(MovimientoInventario movimientoinventario:movimientoinventarios) {
			movimientoinventario.setIsNew(false);
			movimientoinventario.setIsChanged(false);
		}
	}
	
	public void generarExportarMovimientoInventario(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
