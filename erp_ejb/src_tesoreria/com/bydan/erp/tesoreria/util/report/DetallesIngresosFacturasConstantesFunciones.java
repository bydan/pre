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
package com.bydan.erp.tesoreria.util.report;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.tesoreria.util.report.DetallesIngresosFacturasConstantesFunciones;
import com.bydan.erp.tesoreria.util.report.DetallesIngresosFacturasParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.report.DetallesIngresosFacturasParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetallesIngresosFacturasConstantesFunciones{		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="DetallesIngresosFacturas";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetallesIngresosFacturas"+DetallesIngresosFacturasConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetallesIngresosFacturasHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetallesIngresosFacturasHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetallesIngresosFacturasConstantesFunciones.SCHEMA+"_"+DetallesIngresosFacturasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetallesIngresosFacturasHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetallesIngresosFacturasConstantesFunciones.SCHEMA+"_"+DetallesIngresosFacturasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetallesIngresosFacturasConstantesFunciones.SCHEMA+"_"+DetallesIngresosFacturasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetallesIngresosFacturasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetallesIngresosFacturasConstantesFunciones.SCHEMA+"_"+DetallesIngresosFacturasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallesIngresosFacturasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetallesIngresosFacturasHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallesIngresosFacturasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallesIngresosFacturasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetallesIngresosFacturasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallesIngresosFacturasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetallesIngresosFacturasConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetallesIngresosFacturasConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetallesIngresosFacturasConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetallesIngresosFacturasConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalles Ingresos Facturases";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Detalles Ingresos Facturas";
	public static final String SCLASSWEBTITULO_LOWER="Detalles Ingresos Facturas";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetallesIngresosFacturas";
	public static final String OBJECTNAME="detallesingresosfacturas";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="detalles_ingresos_facturas";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detallesingresosfacturas from "+DetallesIngresosFacturasConstantesFunciones.SPERSISTENCENAME+" detallesingresosfacturas";
	public static String QUERYSELECTNATIVE="select "+DetallesIngresosFacturasConstantesFunciones.SCHEMA+"."+DetallesIngresosFacturasConstantesFunciones.TABLENAME+".id,"+DetallesIngresosFacturasConstantesFunciones.SCHEMA+"."+DetallesIngresosFacturasConstantesFunciones.TABLENAME+".version_row,"+DetallesIngresosFacturasConstantesFunciones.SCHEMA+"."+DetallesIngresosFacturasConstantesFunciones.TABLENAME+".id_empresa,"+DetallesIngresosFacturasConstantesFunciones.SCHEMA+"."+DetallesIngresosFacturasConstantesFunciones.TABLENAME+".id_sucursal,"+DetallesIngresosFacturasConstantesFunciones.SCHEMA+"."+DetallesIngresosFacturasConstantesFunciones.TABLENAME+".id_ejercicio,"+DetallesIngresosFacturasConstantesFunciones.SCHEMA+"."+DetallesIngresosFacturasConstantesFunciones.TABLENAME+".fecha,"+DetallesIngresosFacturasConstantesFunciones.SCHEMA+"."+DetallesIngresosFacturasConstantesFunciones.TABLENAME+".tipo_movimiento,"+DetallesIngresosFacturasConstantesFunciones.SCHEMA+"."+DetallesIngresosFacturasConstantesFunciones.TABLENAME+".numero_mayor,"+DetallesIngresosFacturasConstantesFunciones.SCHEMA+"."+DetallesIngresosFacturasConstantesFunciones.TABLENAME+".numero_factura,"+DetallesIngresosFacturasConstantesFunciones.SCHEMA+"."+DetallesIngresosFacturasConstantesFunciones.TABLENAME+".nombre_cliente,"+DetallesIngresosFacturasConstantesFunciones.SCHEMA+"."+DetallesIngresosFacturasConstantesFunciones.TABLENAME+".siglas_pago,"+DetallesIngresosFacturasConstantesFunciones.SCHEMA+"."+DetallesIngresosFacturasConstantesFunciones.TABLENAME+".nombre_pago,"+DetallesIngresosFacturasConstantesFunciones.SCHEMA+"."+DetallesIngresosFacturasConstantesFunciones.TABLENAME+".codigo,"+DetallesIngresosFacturasConstantesFunciones.SCHEMA+"."+DetallesIngresosFacturasConstantesFunciones.TABLENAME+".credito_mone_local from "+DetallesIngresosFacturasConstantesFunciones.SCHEMA+"."+DetallesIngresosFacturasConstantesFunciones.TABLENAME;//+" as "+DetallesIngresosFacturasConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String FECHA= "fecha";
    public static final String TIPOMOVIMIENTO= "tipo_movimiento";
    public static final String NUMEROMAYOR= "numero_mayor";
    public static final String NUMEROFACTURA= "numero_factura";
    public static final String NOMBRECLIENTE= "nombre_cliente";
    public static final String SIGLASPAGO= "siglas_pago";
    public static final String NOMBREPAGO= "nombre_pago";
    public static final String CODIGO= "codigo";
    public static final String CREDITOMONELOCAL= "credito_mone_local";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_TIPOMOVIMIENTO= "Tipo Movimiento";
		public static final String LABEL_TIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
    	public static final String LABEL_NUMEROMAYOR= "Numero Mayor";
		public static final String LABEL_NUMEROMAYOR_LOWER= "Numero Mayor";
    	public static final String LABEL_NUMEROFACTURA= "Numero Factura";
		public static final String LABEL_NUMEROFACTURA_LOWER= "Numero Factura";
    	public static final String LABEL_NOMBRECLIENTE= "Nombre Cliente";
		public static final String LABEL_NOMBRECLIENTE_LOWER= "Nombre Cliente";
    	public static final String LABEL_SIGLASPAGO= "Siglas Pago";
		public static final String LABEL_SIGLASPAGO_LOWER= "Siglas Pago";
    	public static final String LABEL_NOMBREPAGO= "Nombre Pago";
		public static final String LABEL_NOMBREPAGO_LOWER= "Nombre Pago";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_CREDITOMONELOCAL= "Credito Mone Local";
		public static final String LABEL_CREDITOMONELOCAL_LOWER= "Credito Mone Local";
	
		
		
		
		
		
		
	public static final String SREGEXTIPO_MOVIMIENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTIPO_MOVIMIENTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_MAYOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_MAYOR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSIGLAS_PAGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSIGLAS_PAGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_PAGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PAGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getDetallesIngresosFacturasLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetallesIngresosFacturasConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetallesIngresosFacturasConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetallesIngresosFacturasConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetallesIngresosFacturasConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetallesIngresosFacturasConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetallesIngresosFacturasConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetallesIngresosFacturasConstantesFunciones.FECHA)) {sLabelColumna=DetallesIngresosFacturasConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(DetallesIngresosFacturasConstantesFunciones.TIPOMOVIMIENTO)) {sLabelColumna=DetallesIngresosFacturasConstantesFunciones.LABEL_TIPOMOVIMIENTO;}
		if(sNombreColumna.equals(DetallesIngresosFacturasConstantesFunciones.NUMEROMAYOR)) {sLabelColumna=DetallesIngresosFacturasConstantesFunciones.LABEL_NUMEROMAYOR;}
		if(sNombreColumna.equals(DetallesIngresosFacturasConstantesFunciones.NUMEROFACTURA)) {sLabelColumna=DetallesIngresosFacturasConstantesFunciones.LABEL_NUMEROFACTURA;}
		if(sNombreColumna.equals(DetallesIngresosFacturasConstantesFunciones.NOMBRECLIENTE)) {sLabelColumna=DetallesIngresosFacturasConstantesFunciones.LABEL_NOMBRECLIENTE;}
		if(sNombreColumna.equals(DetallesIngresosFacturasConstantesFunciones.SIGLASPAGO)) {sLabelColumna=DetallesIngresosFacturasConstantesFunciones.LABEL_SIGLASPAGO;}
		if(sNombreColumna.equals(DetallesIngresosFacturasConstantesFunciones.NOMBREPAGO)) {sLabelColumna=DetallesIngresosFacturasConstantesFunciones.LABEL_NOMBREPAGO;}
		if(sNombreColumna.equals(DetallesIngresosFacturasConstantesFunciones.CODIGO)) {sLabelColumna=DetallesIngresosFacturasConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(DetallesIngresosFacturasConstantesFunciones.CREDITOMONELOCAL)) {sLabelColumna=DetallesIngresosFacturasConstantesFunciones.LABEL_CREDITOMONELOCAL;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetallesIngresosFacturasDescripcion(DetallesIngresosFacturas detallesingresosfacturas) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detallesingresosfacturas !=null/* && detallesingresosfacturas.getId()!=0*/) {
			sDescripcion=detallesingresosfacturas.getcodigo();//detallesingresosfacturasdetallesingresosfacturas.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getDetallesIngresosFacturasDescripcionDetallado(DetallesIngresosFacturas detallesingresosfacturas) {
		String sDescripcion="";
			
		sDescripcion+=DetallesIngresosFacturasConstantesFunciones.ID+"=";
		sDescripcion+=detallesingresosfacturas.getId().toString()+",";
		sDescripcion+=DetallesIngresosFacturasConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detallesingresosfacturas.getVersionRow().toString()+",";
		sDescripcion+=DetallesIngresosFacturasConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detallesingresosfacturas.getid_empresa().toString()+",";
		sDescripcion+=DetallesIngresosFacturasConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detallesingresosfacturas.getid_sucursal().toString()+",";
		sDescripcion+=DetallesIngresosFacturasConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detallesingresosfacturas.getid_ejercicio().toString()+",";
		sDescripcion+=DetallesIngresosFacturasConstantesFunciones.FECHA+"=";
		sDescripcion+=detallesingresosfacturas.getfecha().toString()+",";
		sDescripcion+=DetallesIngresosFacturasConstantesFunciones.TIPOMOVIMIENTO+"=";
		sDescripcion+=detallesingresosfacturas.gettipo_movimiento()+",";
		sDescripcion+=DetallesIngresosFacturasConstantesFunciones.NUMEROMAYOR+"=";
		sDescripcion+=detallesingresosfacturas.getnumero_mayor()+",";
		sDescripcion+=DetallesIngresosFacturasConstantesFunciones.NUMEROFACTURA+"=";
		sDescripcion+=detallesingresosfacturas.getnumero_factura()+",";
		sDescripcion+=DetallesIngresosFacturasConstantesFunciones.NOMBRECLIENTE+"=";
		sDescripcion+=detallesingresosfacturas.getnombre_cliente()+",";
		sDescripcion+=DetallesIngresosFacturasConstantesFunciones.SIGLASPAGO+"=";
		sDescripcion+=detallesingresosfacturas.getsiglas_pago()+",";
		sDescripcion+=DetallesIngresosFacturasConstantesFunciones.NOMBREPAGO+"=";
		sDescripcion+=detallesingresosfacturas.getnombre_pago()+",";
		sDescripcion+=DetallesIngresosFacturasConstantesFunciones.CODIGO+"=";
		sDescripcion+=detallesingresosfacturas.getcodigo()+",";
		sDescripcion+=DetallesIngresosFacturasConstantesFunciones.CREDITOMONELOCAL+"=";
		sDescripcion+=detallesingresosfacturas.getcredito_mone_local().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDetallesIngresosFacturasDescripcion(DetallesIngresosFacturas detallesingresosfacturas,String sValor) throws Exception {			
		if(detallesingresosfacturas !=null) {
			detallesingresosfacturas.setcodigo(sValor);;//detallesingresosfacturasdetallesingresosfacturas.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaDetallesIngresosFacturas")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaDetallesIngresosFacturas(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetallesIngresosFacturas(DetallesIngresosFacturas detallesingresosfacturas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallesingresosfacturas.settipo_movimiento(detallesingresosfacturas.gettipo_movimiento().trim());
		detallesingresosfacturas.setnumero_mayor(detallesingresosfacturas.getnumero_mayor().trim());
		detallesingresosfacturas.setnumero_factura(detallesingresosfacturas.getnumero_factura().trim());
		detallesingresosfacturas.setnombre_cliente(detallesingresosfacturas.getnombre_cliente().trim());
		detallesingresosfacturas.setsiglas_pago(detallesingresosfacturas.getsiglas_pago().trim());
		detallesingresosfacturas.setnombre_pago(detallesingresosfacturas.getnombre_pago().trim());
		detallesingresosfacturas.setcodigo(detallesingresosfacturas.getcodigo().trim());
	}
	
	public static void quitarEspaciosDetallesIngresosFacturass(List<DetallesIngresosFacturas> detallesingresosfacturass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetallesIngresosFacturas detallesingresosfacturas: detallesingresosfacturass) {
			detallesingresosfacturas.settipo_movimiento(detallesingresosfacturas.gettipo_movimiento().trim());
			detallesingresosfacturas.setnumero_mayor(detallesingresosfacturas.getnumero_mayor().trim());
			detallesingresosfacturas.setnumero_factura(detallesingresosfacturas.getnumero_factura().trim());
			detallesingresosfacturas.setnombre_cliente(detallesingresosfacturas.getnombre_cliente().trim());
			detallesingresosfacturas.setsiglas_pago(detallesingresosfacturas.getsiglas_pago().trim());
			detallesingresosfacturas.setnombre_pago(detallesingresosfacturas.getnombre_pago().trim());
			detallesingresosfacturas.setcodigo(detallesingresosfacturas.getcodigo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetallesIngresosFacturas(DetallesIngresosFacturas detallesingresosfacturas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detallesingresosfacturas.getConCambioAuxiliar()) {
			detallesingresosfacturas.setIsDeleted(detallesingresosfacturas.getIsDeletedAuxiliar());	
			detallesingresosfacturas.setIsNew(detallesingresosfacturas.getIsNewAuxiliar());	
			detallesingresosfacturas.setIsChanged(detallesingresosfacturas.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detallesingresosfacturas.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detallesingresosfacturas.setIsDeletedAuxiliar(false);	
			detallesingresosfacturas.setIsNewAuxiliar(false);	
			detallesingresosfacturas.setIsChangedAuxiliar(false);
			
			detallesingresosfacturas.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetallesIngresosFacturass(List<DetallesIngresosFacturas> detallesingresosfacturass,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetallesIngresosFacturas detallesingresosfacturas : detallesingresosfacturass) {
			if(conAsignarBase && detallesingresosfacturas.getConCambioAuxiliar()) {
				detallesingresosfacturas.setIsDeleted(detallesingresosfacturas.getIsDeletedAuxiliar());	
				detallesingresosfacturas.setIsNew(detallesingresosfacturas.getIsNewAuxiliar());	
				detallesingresosfacturas.setIsChanged(detallesingresosfacturas.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detallesingresosfacturas.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detallesingresosfacturas.setIsDeletedAuxiliar(false);	
				detallesingresosfacturas.setIsNewAuxiliar(false);	
				detallesingresosfacturas.setIsChangedAuxiliar(false);
				
				detallesingresosfacturas.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetallesIngresosFacturas(DetallesIngresosFacturas detallesingresosfacturas,Boolean conEnteros) throws Exception  {
		detallesingresosfacturas.setcredito_mone_local(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDetallesIngresosFacturass(List<DetallesIngresosFacturas> detallesingresosfacturass,Boolean conEnteros) throws Exception  {
		
		for(DetallesIngresosFacturas detallesingresosfacturas: detallesingresosfacturass) {
			detallesingresosfacturas.setcredito_mone_local(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetallesIngresosFacturas(List<DetallesIngresosFacturas> detallesingresosfacturass,DetallesIngresosFacturas detallesingresosfacturasAux) throws Exception  {
		DetallesIngresosFacturasConstantesFunciones.InicializarValoresDetallesIngresosFacturas(detallesingresosfacturasAux,true);
		
		for(DetallesIngresosFacturas detallesingresosfacturas: detallesingresosfacturass) {
			if(detallesingresosfacturas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detallesingresosfacturasAux.setcredito_mone_local(detallesingresosfacturasAux.getcredito_mone_local()+detallesingresosfacturas.getcredito_mone_local());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetallesIngresosFacturas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetallesIngresosFacturasConstantesFunciones.getArrayColumnasGlobalesDetallesIngresosFacturas(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetallesIngresosFacturas(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallesIngresosFacturasConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallesIngresosFacturasConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallesIngresosFacturasConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallesIngresosFacturasConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallesIngresosFacturasConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallesIngresosFacturasConstantesFunciones.IDEJERCICIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetallesIngresosFacturas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetallesIngresosFacturas> detallesingresosfacturass,DetallesIngresosFacturas detallesingresosfacturas,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetallesIngresosFacturas detallesingresosfacturasAux: detallesingresosfacturass) {
			if(detallesingresosfacturasAux!=null && detallesingresosfacturas!=null) {
				if((detallesingresosfacturasAux.getId()==null && detallesingresosfacturas.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detallesingresosfacturasAux.getId()!=null && detallesingresosfacturas.getId()!=null){
					if(detallesingresosfacturasAux.getId().equals(detallesingresosfacturas.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetallesIngresosFacturas(List<DetallesIngresosFacturas> detallesingresosfacturass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double credito_mone_localTotal=0.0;
	
		for(DetallesIngresosFacturas detallesingresosfacturas: detallesingresosfacturass) {			
			if(detallesingresosfacturas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			credito_mone_localTotal+=detallesingresosfacturas.getcredito_mone_local();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallesIngresosFacturasConstantesFunciones.CREDITOMONELOCAL);
		datoGeneral.setsDescripcion(DetallesIngresosFacturasConstantesFunciones.LABEL_CREDITOMONELOCAL);
		datoGeneral.setdValorDouble(credito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetallesIngresosFacturas() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetallesIngresosFacturasConstantesFunciones.LABEL_ID, DetallesIngresosFacturasConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallesIngresosFacturasConstantesFunciones.LABEL_VERSIONROW, DetallesIngresosFacturasConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallesIngresosFacturasConstantesFunciones.LABEL_FECHA, DetallesIngresosFacturasConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallesIngresosFacturasConstantesFunciones.LABEL_TIPOMOVIMIENTO, DetallesIngresosFacturasConstantesFunciones.TIPOMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallesIngresosFacturasConstantesFunciones.LABEL_NUMEROMAYOR, DetallesIngresosFacturasConstantesFunciones.NUMEROMAYOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallesIngresosFacturasConstantesFunciones.LABEL_NUMEROFACTURA, DetallesIngresosFacturasConstantesFunciones.NUMEROFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallesIngresosFacturasConstantesFunciones.LABEL_NOMBRECLIENTE, DetallesIngresosFacturasConstantesFunciones.NOMBRECLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallesIngresosFacturasConstantesFunciones.LABEL_SIGLASPAGO, DetallesIngresosFacturasConstantesFunciones.SIGLASPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallesIngresosFacturasConstantesFunciones.LABEL_NOMBREPAGO, DetallesIngresosFacturasConstantesFunciones.NOMBREPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallesIngresosFacturasConstantesFunciones.LABEL_CODIGO, DetallesIngresosFacturasConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallesIngresosFacturasConstantesFunciones.LABEL_CREDITOMONELOCAL, DetallesIngresosFacturasConstantesFunciones.CREDITOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetallesIngresosFacturas() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetallesIngresosFacturasConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallesIngresosFacturasConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallesIngresosFacturasConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallesIngresosFacturasConstantesFunciones.TIPOMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallesIngresosFacturasConstantesFunciones.NUMEROMAYOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallesIngresosFacturasConstantesFunciones.NUMEROFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallesIngresosFacturasConstantesFunciones.NOMBRECLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallesIngresosFacturasConstantesFunciones.SIGLASPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallesIngresosFacturasConstantesFunciones.NOMBREPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallesIngresosFacturasConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallesIngresosFacturasConstantesFunciones.CREDITOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetallesIngresosFacturas() throws Exception  {
		return DetallesIngresosFacturasConstantesFunciones.getTiposSeleccionarDetallesIngresosFacturas(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetallesIngresosFacturas(Boolean conFk) throws Exception  {
		return DetallesIngresosFacturasConstantesFunciones.getTiposSeleccionarDetallesIngresosFacturas(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetallesIngresosFacturas(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallesIngresosFacturasConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetallesIngresosFacturasConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallesIngresosFacturasConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetallesIngresosFacturasConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallesIngresosFacturasConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetallesIngresosFacturasConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallesIngresosFacturasConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(DetallesIngresosFacturasConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallesIngresosFacturasConstantesFunciones.LABEL_TIPOMOVIMIENTO);
			reporte.setsDescripcion(DetallesIngresosFacturasConstantesFunciones.LABEL_TIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallesIngresosFacturasConstantesFunciones.LABEL_NUMEROMAYOR);
			reporte.setsDescripcion(DetallesIngresosFacturasConstantesFunciones.LABEL_NUMEROMAYOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallesIngresosFacturasConstantesFunciones.LABEL_NUMEROFACTURA);
			reporte.setsDescripcion(DetallesIngresosFacturasConstantesFunciones.LABEL_NUMEROFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallesIngresosFacturasConstantesFunciones.LABEL_NOMBRECLIENTE);
			reporte.setsDescripcion(DetallesIngresosFacturasConstantesFunciones.LABEL_NOMBRECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallesIngresosFacturasConstantesFunciones.LABEL_SIGLASPAGO);
			reporte.setsDescripcion(DetallesIngresosFacturasConstantesFunciones.LABEL_SIGLASPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallesIngresosFacturasConstantesFunciones.LABEL_NOMBREPAGO);
			reporte.setsDescripcion(DetallesIngresosFacturasConstantesFunciones.LABEL_NOMBREPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallesIngresosFacturasConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(DetallesIngresosFacturasConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallesIngresosFacturasConstantesFunciones.LABEL_CREDITOMONELOCAL);
			reporte.setsDescripcion(DetallesIngresosFacturasConstantesFunciones.LABEL_CREDITOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetallesIngresosFacturas(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetallesIngresosFacturas(DetallesIngresosFacturas detallesingresosfacturasAux) throws Exception {
		
			detallesingresosfacturasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallesingresosfacturasAux.getEmpresa()));
			detallesingresosfacturasAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallesingresosfacturasAux.getSucursal()));
			detallesingresosfacturasAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallesingresosfacturasAux.getEjercicio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetallesIngresosFacturas(List<DetallesIngresosFacturas> detallesingresosfacturassTemp) throws Exception {
		for(DetallesIngresosFacturas detallesingresosfacturasAux:detallesingresosfacturassTemp) {
			
			detallesingresosfacturasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallesingresosfacturasAux.getEmpresa()));
			detallesingresosfacturasAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallesingresosfacturasAux.getSucursal()));
			detallesingresosfacturasAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallesingresosfacturasAux.getEjercicio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetallesIngresosFacturas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetallesIngresosFacturas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetallesIngresosFacturas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetallesIngresosFacturasConstantesFunciones.getClassesRelationshipsOfDetallesIngresosFacturas(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetallesIngresosFacturas(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetallesIngresosFacturas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetallesIngresosFacturasConstantesFunciones.getClassesRelationshipsFromStringsOfDetallesIngresosFacturas(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetallesIngresosFacturas(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(DetallesIngresosFacturas detallesingresosfacturas,List<DetallesIngresosFacturas> detallesingresosfacturass,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(DetallesIngresosFacturas detallesingresosfacturas,List<DetallesIngresosFacturas> detallesingresosfacturass) throws Exception {
		try	{			
			for(DetallesIngresosFacturas detallesingresosfacturasLocal:detallesingresosfacturass) {
				if(detallesingresosfacturasLocal.getId().equals(detallesingresosfacturas.getId())) {
					detallesingresosfacturasLocal.setIsSelected(detallesingresosfacturas.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetallesIngresosFacturas(List<DetallesIngresosFacturas> detallesingresosfacturassAux) throws Exception {
		//this.detallesingresosfacturassAux=detallesingresosfacturassAux;
		
		for(DetallesIngresosFacturas detallesingresosfacturasAux:detallesingresosfacturassAux) {
			if(detallesingresosfacturasAux.getIsChanged()) {
				detallesingresosfacturasAux.setIsChanged(false);
			}		
			
			if(detallesingresosfacturasAux.getIsNew()) {
				detallesingresosfacturasAux.setIsNew(false);
			}	
			
			if(detallesingresosfacturasAux.getIsDeleted()) {
				detallesingresosfacturasAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetallesIngresosFacturas(DetallesIngresosFacturas detallesingresosfacturasAux) throws Exception {
		//this.detallesingresosfacturasAux=detallesingresosfacturasAux;
		
			if(detallesingresosfacturasAux.getIsChanged()) {
				detallesingresosfacturasAux.setIsChanged(false);
			}		
			
			if(detallesingresosfacturasAux.getIsNew()) {
				detallesingresosfacturasAux.setIsNew(false);
			}	
			
			if(detallesingresosfacturasAux.getIsDeleted()) {
				detallesingresosfacturasAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetallesIngresosFacturas detallesingresosfacturasAsignar,DetallesIngresosFacturas detallesingresosfacturas) throws Exception {
		detallesingresosfacturasAsignar.setId(detallesingresosfacturas.getId());	
		detallesingresosfacturasAsignar.setVersionRow(detallesingresosfacturas.getVersionRow());	
		detallesingresosfacturasAsignar.setfecha(detallesingresosfacturas.getfecha());	
		detallesingresosfacturasAsignar.settipo_movimiento(detallesingresosfacturas.gettipo_movimiento());	
		detallesingresosfacturasAsignar.setnumero_mayor(detallesingresosfacturas.getnumero_mayor());	
		detallesingresosfacturasAsignar.setnumero_factura(detallesingresosfacturas.getnumero_factura());	
		detallesingresosfacturasAsignar.setnombre_cliente(detallesingresosfacturas.getnombre_cliente());	
		detallesingresosfacturasAsignar.setsiglas_pago(detallesingresosfacturas.getsiglas_pago());	
		detallesingresosfacturasAsignar.setnombre_pago(detallesingresosfacturas.getnombre_pago());	
		detallesingresosfacturasAsignar.setcodigo(detallesingresosfacturas.getcodigo());	
		detallesingresosfacturasAsignar.setcredito_mone_local(detallesingresosfacturas.getcredito_mone_local());	
	}
	
	public static void inicializarDetallesIngresosFacturas(DetallesIngresosFacturas detallesingresosfacturas) throws Exception {
		try {
				detallesingresosfacturas.setId(0L);	
					
				detallesingresosfacturas.setfecha(new Date());	
				detallesingresosfacturas.settipo_movimiento("");	
				detallesingresosfacturas.setnumero_mayor("");	
				detallesingresosfacturas.setnumero_factura("");	
				detallesingresosfacturas.setnombre_cliente("");	
				detallesingresosfacturas.setsiglas_pago("");	
				detallesingresosfacturas.setnombre_pago("");	
				detallesingresosfacturas.setcodigo("");	
				detallesingresosfacturas.setcredito_mone_local(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetallesIngresosFacturas(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallesIngresosFacturasConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallesIngresosFacturasConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallesIngresosFacturasConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallesIngresosFacturasConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallesIngresosFacturasConstantesFunciones.LABEL_TIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallesIngresosFacturasConstantesFunciones.LABEL_NUMEROMAYOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallesIngresosFacturasConstantesFunciones.LABEL_NUMEROFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallesIngresosFacturasConstantesFunciones.LABEL_NOMBRECLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallesIngresosFacturasConstantesFunciones.LABEL_SIGLASPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallesIngresosFacturasConstantesFunciones.LABEL_NOMBREPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallesIngresosFacturasConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallesIngresosFacturasConstantesFunciones.LABEL_CREDITOMONELOCAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetallesIngresosFacturas(String sTipo,Row row,Workbook workbook,DetallesIngresosFacturas detallesingresosfacturas,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detallesingresosfacturas.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallesingresosfacturas.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallesingresosfacturas.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallesingresosfacturas.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallesingresosfacturas.gettipo_movimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallesingresosfacturas.getnumero_mayor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallesingresosfacturas.getnumero_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallesingresosfacturas.getnombre_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallesingresosfacturas.getsiglas_pago());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallesingresosfacturas.getnombre_pago());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallesingresosfacturas.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallesingresosfacturas.getcredito_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetallesIngresosFacturas="";
	
	public String getsFinalQueryDetallesIngresosFacturas() {
		return this.sFinalQueryDetallesIngresosFacturas;
	}
	
	public void setsFinalQueryDetallesIngresosFacturas(String sFinalQueryDetallesIngresosFacturas) {
		this.sFinalQueryDetallesIngresosFacturas= sFinalQueryDetallesIngresosFacturas;
	}
	
	public Border resaltarSeleccionarDetallesIngresosFacturas=null;
	
	public Border setResaltarSeleccionarDetallesIngresosFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*DetallesIngresosFacturasBeanSwingJInternalFrame detallesingresosfacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detallesingresosfacturasBeanSwingJInternalFrame.jTtoolBarDetallesIngresosFacturas.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetallesIngresosFacturas= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetallesIngresosFacturas() {
		return this.resaltarSeleccionarDetallesIngresosFacturas;
	}
	
	public void setResaltarSeleccionarDetallesIngresosFacturas(Border borderResaltarSeleccionarDetallesIngresosFacturas) {
		this.resaltarSeleccionarDetallesIngresosFacturas= borderResaltarSeleccionarDetallesIngresosFacturas;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetallesIngresosFacturas=null;
	public Boolean mostraridDetallesIngresosFacturas=true;
	public Boolean activaridDetallesIngresosFacturas=true;

	public Border resaltarid_empresaDetallesIngresosFacturas=null;
	public Boolean mostrarid_empresaDetallesIngresosFacturas=true;
	public Boolean activarid_empresaDetallesIngresosFacturas=true;
	public Boolean cargarid_empresaDetallesIngresosFacturas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetallesIngresosFacturas=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetallesIngresosFacturas=null;
	public Boolean mostrarid_sucursalDetallesIngresosFacturas=true;
	public Boolean activarid_sucursalDetallesIngresosFacturas=true;
	public Boolean cargarid_sucursalDetallesIngresosFacturas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetallesIngresosFacturas=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDetallesIngresosFacturas=null;
	public Boolean mostrarid_ejercicioDetallesIngresosFacturas=true;
	public Boolean activarid_ejercicioDetallesIngresosFacturas=true;
	public Boolean cargarid_ejercicioDetallesIngresosFacturas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetallesIngresosFacturas=false;//ConEventDepend=true

	public Border resaltarfechaDetallesIngresosFacturas=null;
	public Boolean mostrarfechaDetallesIngresosFacturas=true;
	public Boolean activarfechaDetallesIngresosFacturas=true;

	public Border resaltartipo_movimientoDetallesIngresosFacturas=null;
	public Boolean mostrartipo_movimientoDetallesIngresosFacturas=true;
	public Boolean activartipo_movimientoDetallesIngresosFacturas=true;

	public Border resaltarnumero_mayorDetallesIngresosFacturas=null;
	public Boolean mostrarnumero_mayorDetallesIngresosFacturas=true;
	public Boolean activarnumero_mayorDetallesIngresosFacturas=true;

	public Border resaltarnumero_facturaDetallesIngresosFacturas=null;
	public Boolean mostrarnumero_facturaDetallesIngresosFacturas=true;
	public Boolean activarnumero_facturaDetallesIngresosFacturas=true;

	public Border resaltarnombre_clienteDetallesIngresosFacturas=null;
	public Boolean mostrarnombre_clienteDetallesIngresosFacturas=true;
	public Boolean activarnombre_clienteDetallesIngresosFacturas=true;

	public Border resaltarsiglas_pagoDetallesIngresosFacturas=null;
	public Boolean mostrarsiglas_pagoDetallesIngresosFacturas=true;
	public Boolean activarsiglas_pagoDetallesIngresosFacturas=true;

	public Border resaltarnombre_pagoDetallesIngresosFacturas=null;
	public Boolean mostrarnombre_pagoDetallesIngresosFacturas=true;
	public Boolean activarnombre_pagoDetallesIngresosFacturas=true;

	public Border resaltarcodigoDetallesIngresosFacturas=null;
	public Boolean mostrarcodigoDetallesIngresosFacturas=true;
	public Boolean activarcodigoDetallesIngresosFacturas=true;

	public Border resaltarcredito_mone_localDetallesIngresosFacturas=null;
	public Boolean mostrarcredito_mone_localDetallesIngresosFacturas=true;
	public Boolean activarcredito_mone_localDetallesIngresosFacturas=true;

	
	

	public Border setResaltaridDetallesIngresosFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*DetallesIngresosFacturasBeanSwingJInternalFrame detallesingresosfacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallesingresosfacturasBeanSwingJInternalFrame.jTtoolBarDetallesIngresosFacturas.setBorder(borderResaltar);
		
		this.resaltaridDetallesIngresosFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetallesIngresosFacturas() {
		return this.resaltaridDetallesIngresosFacturas;
	}

	public void setResaltaridDetallesIngresosFacturas(Border borderResaltar) {
		this.resaltaridDetallesIngresosFacturas= borderResaltar;
	}

	public Boolean getMostraridDetallesIngresosFacturas() {
		return this.mostraridDetallesIngresosFacturas;
	}

	public void setMostraridDetallesIngresosFacturas(Boolean mostraridDetallesIngresosFacturas) {
		this.mostraridDetallesIngresosFacturas= mostraridDetallesIngresosFacturas;
	}

	public Boolean getActivaridDetallesIngresosFacturas() {
		return this.activaridDetallesIngresosFacturas;
	}

	public void setActivaridDetallesIngresosFacturas(Boolean activaridDetallesIngresosFacturas) {
		this.activaridDetallesIngresosFacturas= activaridDetallesIngresosFacturas;
	}

	public Border setResaltarid_empresaDetallesIngresosFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*DetallesIngresosFacturasBeanSwingJInternalFrame detallesingresosfacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallesingresosfacturasBeanSwingJInternalFrame.jTtoolBarDetallesIngresosFacturas.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetallesIngresosFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetallesIngresosFacturas() {
		return this.resaltarid_empresaDetallesIngresosFacturas;
	}

	public void setResaltarid_empresaDetallesIngresosFacturas(Border borderResaltar) {
		this.resaltarid_empresaDetallesIngresosFacturas= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetallesIngresosFacturas() {
		return this.mostrarid_empresaDetallesIngresosFacturas;
	}

	public void setMostrarid_empresaDetallesIngresosFacturas(Boolean mostrarid_empresaDetallesIngresosFacturas) {
		this.mostrarid_empresaDetallesIngresosFacturas= mostrarid_empresaDetallesIngresosFacturas;
	}

	public Boolean getActivarid_empresaDetallesIngresosFacturas() {
		return this.activarid_empresaDetallesIngresosFacturas;
	}

	public void setActivarid_empresaDetallesIngresosFacturas(Boolean activarid_empresaDetallesIngresosFacturas) {
		this.activarid_empresaDetallesIngresosFacturas= activarid_empresaDetallesIngresosFacturas;
	}

	public Boolean getCargarid_empresaDetallesIngresosFacturas() {
		return this.cargarid_empresaDetallesIngresosFacturas;
	}

	public void setCargarid_empresaDetallesIngresosFacturas(Boolean cargarid_empresaDetallesIngresosFacturas) {
		this.cargarid_empresaDetallesIngresosFacturas= cargarid_empresaDetallesIngresosFacturas;
	}

	public Border setResaltarid_sucursalDetallesIngresosFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*DetallesIngresosFacturasBeanSwingJInternalFrame detallesingresosfacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallesingresosfacturasBeanSwingJInternalFrame.jTtoolBarDetallesIngresosFacturas.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetallesIngresosFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetallesIngresosFacturas() {
		return this.resaltarid_sucursalDetallesIngresosFacturas;
	}

	public void setResaltarid_sucursalDetallesIngresosFacturas(Border borderResaltar) {
		this.resaltarid_sucursalDetallesIngresosFacturas= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetallesIngresosFacturas() {
		return this.mostrarid_sucursalDetallesIngresosFacturas;
	}

	public void setMostrarid_sucursalDetallesIngresosFacturas(Boolean mostrarid_sucursalDetallesIngresosFacturas) {
		this.mostrarid_sucursalDetallesIngresosFacturas= mostrarid_sucursalDetallesIngresosFacturas;
	}

	public Boolean getActivarid_sucursalDetallesIngresosFacturas() {
		return this.activarid_sucursalDetallesIngresosFacturas;
	}

	public void setActivarid_sucursalDetallesIngresosFacturas(Boolean activarid_sucursalDetallesIngresosFacturas) {
		this.activarid_sucursalDetallesIngresosFacturas= activarid_sucursalDetallesIngresosFacturas;
	}

	public Boolean getCargarid_sucursalDetallesIngresosFacturas() {
		return this.cargarid_sucursalDetallesIngresosFacturas;
	}

	public void setCargarid_sucursalDetallesIngresosFacturas(Boolean cargarid_sucursalDetallesIngresosFacturas) {
		this.cargarid_sucursalDetallesIngresosFacturas= cargarid_sucursalDetallesIngresosFacturas;
	}

	public Border setResaltarid_ejercicioDetallesIngresosFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*DetallesIngresosFacturasBeanSwingJInternalFrame detallesingresosfacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallesingresosfacturasBeanSwingJInternalFrame.jTtoolBarDetallesIngresosFacturas.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioDetallesIngresosFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetallesIngresosFacturas() {
		return this.resaltarid_ejercicioDetallesIngresosFacturas;
	}

	public void setResaltarid_ejercicioDetallesIngresosFacturas(Border borderResaltar) {
		this.resaltarid_ejercicioDetallesIngresosFacturas= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetallesIngresosFacturas() {
		return this.mostrarid_ejercicioDetallesIngresosFacturas;
	}

	public void setMostrarid_ejercicioDetallesIngresosFacturas(Boolean mostrarid_ejercicioDetallesIngresosFacturas) {
		this.mostrarid_ejercicioDetallesIngresosFacturas= mostrarid_ejercicioDetallesIngresosFacturas;
	}

	public Boolean getActivarid_ejercicioDetallesIngresosFacturas() {
		return this.activarid_ejercicioDetallesIngresosFacturas;
	}

	public void setActivarid_ejercicioDetallesIngresosFacturas(Boolean activarid_ejercicioDetallesIngresosFacturas) {
		this.activarid_ejercicioDetallesIngresosFacturas= activarid_ejercicioDetallesIngresosFacturas;
	}

	public Boolean getCargarid_ejercicioDetallesIngresosFacturas() {
		return this.cargarid_ejercicioDetallesIngresosFacturas;
	}

	public void setCargarid_ejercicioDetallesIngresosFacturas(Boolean cargarid_ejercicioDetallesIngresosFacturas) {
		this.cargarid_ejercicioDetallesIngresosFacturas= cargarid_ejercicioDetallesIngresosFacturas;
	}

	public Border setResaltarfechaDetallesIngresosFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*DetallesIngresosFacturasBeanSwingJInternalFrame detallesingresosfacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallesingresosfacturasBeanSwingJInternalFrame.jTtoolBarDetallesIngresosFacturas.setBorder(borderResaltar);
		
		this.resaltarfechaDetallesIngresosFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaDetallesIngresosFacturas() {
		return this.resaltarfechaDetallesIngresosFacturas;
	}

	public void setResaltarfechaDetallesIngresosFacturas(Border borderResaltar) {
		this.resaltarfechaDetallesIngresosFacturas= borderResaltar;
	}

	public Boolean getMostrarfechaDetallesIngresosFacturas() {
		return this.mostrarfechaDetallesIngresosFacturas;
	}

	public void setMostrarfechaDetallesIngresosFacturas(Boolean mostrarfechaDetallesIngresosFacturas) {
		this.mostrarfechaDetallesIngresosFacturas= mostrarfechaDetallesIngresosFacturas;
	}

	public Boolean getActivarfechaDetallesIngresosFacturas() {
		return this.activarfechaDetallesIngresosFacturas;
	}

	public void setActivarfechaDetallesIngresosFacturas(Boolean activarfechaDetallesIngresosFacturas) {
		this.activarfechaDetallesIngresosFacturas= activarfechaDetallesIngresosFacturas;
	}

	public Border setResaltartipo_movimientoDetallesIngresosFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*DetallesIngresosFacturasBeanSwingJInternalFrame detallesingresosfacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallesingresosfacturasBeanSwingJInternalFrame.jTtoolBarDetallesIngresosFacturas.setBorder(borderResaltar);
		
		this.resaltartipo_movimientoDetallesIngresosFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartipo_movimientoDetallesIngresosFacturas() {
		return this.resaltartipo_movimientoDetallesIngresosFacturas;
	}

	public void setResaltartipo_movimientoDetallesIngresosFacturas(Border borderResaltar) {
		this.resaltartipo_movimientoDetallesIngresosFacturas= borderResaltar;
	}

	public Boolean getMostrartipo_movimientoDetallesIngresosFacturas() {
		return this.mostrartipo_movimientoDetallesIngresosFacturas;
	}

	public void setMostrartipo_movimientoDetallesIngresosFacturas(Boolean mostrartipo_movimientoDetallesIngresosFacturas) {
		this.mostrartipo_movimientoDetallesIngresosFacturas= mostrartipo_movimientoDetallesIngresosFacturas;
	}

	public Boolean getActivartipo_movimientoDetallesIngresosFacturas() {
		return this.activartipo_movimientoDetallesIngresosFacturas;
	}

	public void setActivartipo_movimientoDetallesIngresosFacturas(Boolean activartipo_movimientoDetallesIngresosFacturas) {
		this.activartipo_movimientoDetallesIngresosFacturas= activartipo_movimientoDetallesIngresosFacturas;
	}

	public Border setResaltarnumero_mayorDetallesIngresosFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*DetallesIngresosFacturasBeanSwingJInternalFrame detallesingresosfacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallesingresosfacturasBeanSwingJInternalFrame.jTtoolBarDetallesIngresosFacturas.setBorder(borderResaltar);
		
		this.resaltarnumero_mayorDetallesIngresosFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_mayorDetallesIngresosFacturas() {
		return this.resaltarnumero_mayorDetallesIngresosFacturas;
	}

	public void setResaltarnumero_mayorDetallesIngresosFacturas(Border borderResaltar) {
		this.resaltarnumero_mayorDetallesIngresosFacturas= borderResaltar;
	}

	public Boolean getMostrarnumero_mayorDetallesIngresosFacturas() {
		return this.mostrarnumero_mayorDetallesIngresosFacturas;
	}

	public void setMostrarnumero_mayorDetallesIngresosFacturas(Boolean mostrarnumero_mayorDetallesIngresosFacturas) {
		this.mostrarnumero_mayorDetallesIngresosFacturas= mostrarnumero_mayorDetallesIngresosFacturas;
	}

	public Boolean getActivarnumero_mayorDetallesIngresosFacturas() {
		return this.activarnumero_mayorDetallesIngresosFacturas;
	}

	public void setActivarnumero_mayorDetallesIngresosFacturas(Boolean activarnumero_mayorDetallesIngresosFacturas) {
		this.activarnumero_mayorDetallesIngresosFacturas= activarnumero_mayorDetallesIngresosFacturas;
	}

	public Border setResaltarnumero_facturaDetallesIngresosFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*DetallesIngresosFacturasBeanSwingJInternalFrame detallesingresosfacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallesingresosfacturasBeanSwingJInternalFrame.jTtoolBarDetallesIngresosFacturas.setBorder(borderResaltar);
		
		this.resaltarnumero_facturaDetallesIngresosFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_facturaDetallesIngresosFacturas() {
		return this.resaltarnumero_facturaDetallesIngresosFacturas;
	}

	public void setResaltarnumero_facturaDetallesIngresosFacturas(Border borderResaltar) {
		this.resaltarnumero_facturaDetallesIngresosFacturas= borderResaltar;
	}

	public Boolean getMostrarnumero_facturaDetallesIngresosFacturas() {
		return this.mostrarnumero_facturaDetallesIngresosFacturas;
	}

	public void setMostrarnumero_facturaDetallesIngresosFacturas(Boolean mostrarnumero_facturaDetallesIngresosFacturas) {
		this.mostrarnumero_facturaDetallesIngresosFacturas= mostrarnumero_facturaDetallesIngresosFacturas;
	}

	public Boolean getActivarnumero_facturaDetallesIngresosFacturas() {
		return this.activarnumero_facturaDetallesIngresosFacturas;
	}

	public void setActivarnumero_facturaDetallesIngresosFacturas(Boolean activarnumero_facturaDetallesIngresosFacturas) {
		this.activarnumero_facturaDetallesIngresosFacturas= activarnumero_facturaDetallesIngresosFacturas;
	}

	public Border setResaltarnombre_clienteDetallesIngresosFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*DetallesIngresosFacturasBeanSwingJInternalFrame detallesingresosfacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallesingresosfacturasBeanSwingJInternalFrame.jTtoolBarDetallesIngresosFacturas.setBorder(borderResaltar);
		
		this.resaltarnombre_clienteDetallesIngresosFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_clienteDetallesIngresosFacturas() {
		return this.resaltarnombre_clienteDetallesIngresosFacturas;
	}

	public void setResaltarnombre_clienteDetallesIngresosFacturas(Border borderResaltar) {
		this.resaltarnombre_clienteDetallesIngresosFacturas= borderResaltar;
	}

	public Boolean getMostrarnombre_clienteDetallesIngresosFacturas() {
		return this.mostrarnombre_clienteDetallesIngresosFacturas;
	}

	public void setMostrarnombre_clienteDetallesIngresosFacturas(Boolean mostrarnombre_clienteDetallesIngresosFacturas) {
		this.mostrarnombre_clienteDetallesIngresosFacturas= mostrarnombre_clienteDetallesIngresosFacturas;
	}

	public Boolean getActivarnombre_clienteDetallesIngresosFacturas() {
		return this.activarnombre_clienteDetallesIngresosFacturas;
	}

	public void setActivarnombre_clienteDetallesIngresosFacturas(Boolean activarnombre_clienteDetallesIngresosFacturas) {
		this.activarnombre_clienteDetallesIngresosFacturas= activarnombre_clienteDetallesIngresosFacturas;
	}

	public Border setResaltarsiglas_pagoDetallesIngresosFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*DetallesIngresosFacturasBeanSwingJInternalFrame detallesingresosfacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallesingresosfacturasBeanSwingJInternalFrame.jTtoolBarDetallesIngresosFacturas.setBorder(borderResaltar);
		
		this.resaltarsiglas_pagoDetallesIngresosFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsiglas_pagoDetallesIngresosFacturas() {
		return this.resaltarsiglas_pagoDetallesIngresosFacturas;
	}

	public void setResaltarsiglas_pagoDetallesIngresosFacturas(Border borderResaltar) {
		this.resaltarsiglas_pagoDetallesIngresosFacturas= borderResaltar;
	}

	public Boolean getMostrarsiglas_pagoDetallesIngresosFacturas() {
		return this.mostrarsiglas_pagoDetallesIngresosFacturas;
	}

	public void setMostrarsiglas_pagoDetallesIngresosFacturas(Boolean mostrarsiglas_pagoDetallesIngresosFacturas) {
		this.mostrarsiglas_pagoDetallesIngresosFacturas= mostrarsiglas_pagoDetallesIngresosFacturas;
	}

	public Boolean getActivarsiglas_pagoDetallesIngresosFacturas() {
		return this.activarsiglas_pagoDetallesIngresosFacturas;
	}

	public void setActivarsiglas_pagoDetallesIngresosFacturas(Boolean activarsiglas_pagoDetallesIngresosFacturas) {
		this.activarsiglas_pagoDetallesIngresosFacturas= activarsiglas_pagoDetallesIngresosFacturas;
	}

	public Border setResaltarnombre_pagoDetallesIngresosFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*DetallesIngresosFacturasBeanSwingJInternalFrame detallesingresosfacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallesingresosfacturasBeanSwingJInternalFrame.jTtoolBarDetallesIngresosFacturas.setBorder(borderResaltar);
		
		this.resaltarnombre_pagoDetallesIngresosFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_pagoDetallesIngresosFacturas() {
		return this.resaltarnombre_pagoDetallesIngresosFacturas;
	}

	public void setResaltarnombre_pagoDetallesIngresosFacturas(Border borderResaltar) {
		this.resaltarnombre_pagoDetallesIngresosFacturas= borderResaltar;
	}

	public Boolean getMostrarnombre_pagoDetallesIngresosFacturas() {
		return this.mostrarnombre_pagoDetallesIngresosFacturas;
	}

	public void setMostrarnombre_pagoDetallesIngresosFacturas(Boolean mostrarnombre_pagoDetallesIngresosFacturas) {
		this.mostrarnombre_pagoDetallesIngresosFacturas= mostrarnombre_pagoDetallesIngresosFacturas;
	}

	public Boolean getActivarnombre_pagoDetallesIngresosFacturas() {
		return this.activarnombre_pagoDetallesIngresosFacturas;
	}

	public void setActivarnombre_pagoDetallesIngresosFacturas(Boolean activarnombre_pagoDetallesIngresosFacturas) {
		this.activarnombre_pagoDetallesIngresosFacturas= activarnombre_pagoDetallesIngresosFacturas;
	}

	public Border setResaltarcodigoDetallesIngresosFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*DetallesIngresosFacturasBeanSwingJInternalFrame detallesingresosfacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallesingresosfacturasBeanSwingJInternalFrame.jTtoolBarDetallesIngresosFacturas.setBorder(borderResaltar);
		
		this.resaltarcodigoDetallesIngresosFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoDetallesIngresosFacturas() {
		return this.resaltarcodigoDetallesIngresosFacturas;
	}

	public void setResaltarcodigoDetallesIngresosFacturas(Border borderResaltar) {
		this.resaltarcodigoDetallesIngresosFacturas= borderResaltar;
	}

	public Boolean getMostrarcodigoDetallesIngresosFacturas() {
		return this.mostrarcodigoDetallesIngresosFacturas;
	}

	public void setMostrarcodigoDetallesIngresosFacturas(Boolean mostrarcodigoDetallesIngresosFacturas) {
		this.mostrarcodigoDetallesIngresosFacturas= mostrarcodigoDetallesIngresosFacturas;
	}

	public Boolean getActivarcodigoDetallesIngresosFacturas() {
		return this.activarcodigoDetallesIngresosFacturas;
	}

	public void setActivarcodigoDetallesIngresosFacturas(Boolean activarcodigoDetallesIngresosFacturas) {
		this.activarcodigoDetallesIngresosFacturas= activarcodigoDetallesIngresosFacturas;
	}

	public Border setResaltarcredito_mone_localDetallesIngresosFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*DetallesIngresosFacturasBeanSwingJInternalFrame detallesingresosfacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallesingresosfacturasBeanSwingJInternalFrame.jTtoolBarDetallesIngresosFacturas.setBorder(borderResaltar);
		
		this.resaltarcredito_mone_localDetallesIngresosFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_mone_localDetallesIngresosFacturas() {
		return this.resaltarcredito_mone_localDetallesIngresosFacturas;
	}

	public void setResaltarcredito_mone_localDetallesIngresosFacturas(Border borderResaltar) {
		this.resaltarcredito_mone_localDetallesIngresosFacturas= borderResaltar;
	}

	public Boolean getMostrarcredito_mone_localDetallesIngresosFacturas() {
		return this.mostrarcredito_mone_localDetallesIngresosFacturas;
	}

	public void setMostrarcredito_mone_localDetallesIngresosFacturas(Boolean mostrarcredito_mone_localDetallesIngresosFacturas) {
		this.mostrarcredito_mone_localDetallesIngresosFacturas= mostrarcredito_mone_localDetallesIngresosFacturas;
	}

	public Boolean getActivarcredito_mone_localDetallesIngresosFacturas() {
		return this.activarcredito_mone_localDetallesIngresosFacturas;
	}

	public void setActivarcredito_mone_localDetallesIngresosFacturas(Boolean activarcredito_mone_localDetallesIngresosFacturas) {
		this.activarcredito_mone_localDetallesIngresosFacturas= activarcredito_mone_localDetallesIngresosFacturas;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridDetallesIngresosFacturas(esInicial);
		this.setMostrarid_empresaDetallesIngresosFacturas(esInicial);
		this.setMostrarid_sucursalDetallesIngresosFacturas(esInicial);
		this.setMostrarid_ejercicioDetallesIngresosFacturas(esInicial);
		this.setMostrarfechaDetallesIngresosFacturas(esInicial);
		this.setMostrartipo_movimientoDetallesIngresosFacturas(esInicial);
		this.setMostrarnumero_mayorDetallesIngresosFacturas(esInicial);
		this.setMostrarnumero_facturaDetallesIngresosFacturas(esInicial);
		this.setMostrarnombre_clienteDetallesIngresosFacturas(esInicial);
		this.setMostrarsiglas_pagoDetallesIngresosFacturas(esInicial);
		this.setMostrarnombre_pagoDetallesIngresosFacturas(esInicial);
		this.setMostrarcodigoDetallesIngresosFacturas(esInicial);
		this.setMostrarcredito_mone_localDetallesIngresosFacturas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.ID)) {
				this.setMostraridDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.FECHA)) {
				this.setMostrarfechaDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.TIPOMOVIMIENTO)) {
				this.setMostrartipo_movimientoDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.NUMEROMAYOR)) {
				this.setMostrarnumero_mayorDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.NUMEROFACTURA)) {
				this.setMostrarnumero_facturaDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.NOMBRECLIENTE)) {
				this.setMostrarnombre_clienteDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.SIGLASPAGO)) {
				this.setMostrarsiglas_pagoDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.NOMBREPAGO)) {
				this.setMostrarnombre_pagoDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.CREDITOMONELOCAL)) {
				this.setMostrarcredito_mone_localDetallesIngresosFacturas(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridDetallesIngresosFacturas(esInicial);
		this.setActivarid_empresaDetallesIngresosFacturas(esInicial);
		this.setActivarid_sucursalDetallesIngresosFacturas(esInicial);
		this.setActivarid_ejercicioDetallesIngresosFacturas(esInicial);
		this.setActivarfechaDetallesIngresosFacturas(esInicial);
		this.setActivartipo_movimientoDetallesIngresosFacturas(esInicial);
		this.setActivarnumero_mayorDetallesIngresosFacturas(esInicial);
		this.setActivarnumero_facturaDetallesIngresosFacturas(esInicial);
		this.setActivarnombre_clienteDetallesIngresosFacturas(esInicial);
		this.setActivarsiglas_pagoDetallesIngresosFacturas(esInicial);
		this.setActivarnombre_pagoDetallesIngresosFacturas(esInicial);
		this.setActivarcodigoDetallesIngresosFacturas(esInicial);
		this.setActivarcredito_mone_localDetallesIngresosFacturas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.ID)) {
				this.setActivaridDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.FECHA)) {
				this.setActivarfechaDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.TIPOMOVIMIENTO)) {
				this.setActivartipo_movimientoDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.NUMEROMAYOR)) {
				this.setActivarnumero_mayorDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.NUMEROFACTURA)) {
				this.setActivarnumero_facturaDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.NOMBRECLIENTE)) {
				this.setActivarnombre_clienteDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.SIGLASPAGO)) {
				this.setActivarsiglas_pagoDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.NOMBREPAGO)) {
				this.setActivarnombre_pagoDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.CODIGO)) {
				this.setActivarcodigoDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.CREDITOMONELOCAL)) {
				this.setActivarcredito_mone_localDetallesIngresosFacturas(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetallesIngresosFacturasBeanSwingJInternalFrame detallesingresosfacturasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetallesIngresosFacturas(esInicial);
		this.setResaltarid_empresaDetallesIngresosFacturas(esInicial);
		this.setResaltarid_sucursalDetallesIngresosFacturas(esInicial);
		this.setResaltarid_ejercicioDetallesIngresosFacturas(esInicial);
		this.setResaltarfechaDetallesIngresosFacturas(esInicial);
		this.setResaltartipo_movimientoDetallesIngresosFacturas(esInicial);
		this.setResaltarnumero_mayorDetallesIngresosFacturas(esInicial);
		this.setResaltarnumero_facturaDetallesIngresosFacturas(esInicial);
		this.setResaltarnombre_clienteDetallesIngresosFacturas(esInicial);
		this.setResaltarsiglas_pagoDetallesIngresosFacturas(esInicial);
		this.setResaltarnombre_pagoDetallesIngresosFacturas(esInicial);
		this.setResaltarcodigoDetallesIngresosFacturas(esInicial);
		this.setResaltarcredito_mone_localDetallesIngresosFacturas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.ID)) {
				this.setResaltaridDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.FECHA)) {
				this.setResaltarfechaDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.TIPOMOVIMIENTO)) {
				this.setResaltartipo_movimientoDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.NUMEROMAYOR)) {
				this.setResaltarnumero_mayorDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.NUMEROFACTURA)) {
				this.setResaltarnumero_facturaDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.NOMBRECLIENTE)) {
				this.setResaltarnombre_clienteDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.SIGLASPAGO)) {
				this.setResaltarsiglas_pagoDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.NOMBREPAGO)) {
				this.setResaltarnombre_pagoDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoDetallesIngresosFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallesIngresosFacturasConstantesFunciones.CREDITOMONELOCAL)) {
				this.setResaltarcredito_mone_localDetallesIngresosFacturas(esAsigna);
				continue;
			}
		}
	}
	
			
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetallesIngresosFacturasBeanSwingJInternalFrame detallesingresosfacturasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarBusquedaDetallesIngresosFacturasDetallesIngresosFacturas=true;

	public Boolean getMostrarBusquedaDetallesIngresosFacturasDetallesIngresosFacturas() {
		return this.mostrarBusquedaDetallesIngresosFacturasDetallesIngresosFacturas;
	}

	public void setMostrarBusquedaDetallesIngresosFacturasDetallesIngresosFacturas(Boolean visibilidadResaltar) {
		this.mostrarBusquedaDetallesIngresosFacturasDetallesIngresosFacturas= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaDetallesIngresosFacturasDetallesIngresosFacturas=true;

	public Boolean getActivarBusquedaDetallesIngresosFacturasDetallesIngresosFacturas() {
		return this.activarBusquedaDetallesIngresosFacturasDetallesIngresosFacturas;
	}

	public void setActivarBusquedaDetallesIngresosFacturasDetallesIngresosFacturas(Boolean habilitarResaltar) {
		this.activarBusquedaDetallesIngresosFacturasDetallesIngresosFacturas= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaDetallesIngresosFacturasDetallesIngresosFacturas=null;

	public Border getResaltarBusquedaDetallesIngresosFacturasDetallesIngresosFacturas() {
		return this.resaltarBusquedaDetallesIngresosFacturasDetallesIngresosFacturas;
	}

	public void setResaltarBusquedaDetallesIngresosFacturasDetallesIngresosFacturas(Border borderResaltar) {
		this.resaltarBusquedaDetallesIngresosFacturasDetallesIngresosFacturas= borderResaltar;
	}

	public void setResaltarBusquedaDetallesIngresosFacturasDetallesIngresosFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*DetallesIngresosFacturasBeanSwingJInternalFrame detallesingresosfacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaDetallesIngresosFacturasDetallesIngresosFacturas= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}