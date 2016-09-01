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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.PresupuestoProductoConstantesFunciones;
import com.bydan.erp.inventario.util.PresupuestoProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.PresupuestoProductoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PresupuestoProductoConstantesFunciones extends PresupuestoProductoConstantesFuncionesAdditional {		
	
	
	
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
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="PresupuestoProducto";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PresupuestoProducto"+PresupuestoProductoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PresupuestoProductoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PresupuestoProductoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PresupuestoProductoConstantesFunciones.SCHEMA+"_"+PresupuestoProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PresupuestoProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PresupuestoProductoConstantesFunciones.SCHEMA+"_"+PresupuestoProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PresupuestoProductoConstantesFunciones.SCHEMA+"_"+PresupuestoProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PresupuestoProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PresupuestoProductoConstantesFunciones.SCHEMA+"_"+PresupuestoProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestoProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PresupuestoProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestoProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestoProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PresupuestoProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestoProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PresupuestoProductoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PresupuestoProductoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PresupuestoProductoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PresupuestoProductoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Presupuesto Productos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Presupuesto Producto";
	public static final String SCLASSWEBTITULO_LOWER="Presupuesto Producto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PresupuestoProducto";
	public static final String OBJECTNAME="presupuestoproducto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="presupuesto_producto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select presupuestoproducto from "+PresupuestoProductoConstantesFunciones.SPERSISTENCENAME+" presupuestoproducto";
	public static String QUERYSELECTNATIVE="select "+PresupuestoProductoConstantesFunciones.SCHEMA+"."+PresupuestoProductoConstantesFunciones.TABLENAME+".id,"+PresupuestoProductoConstantesFunciones.SCHEMA+"."+PresupuestoProductoConstantesFunciones.TABLENAME+".version_row,"+PresupuestoProductoConstantesFunciones.SCHEMA+"."+PresupuestoProductoConstantesFunciones.TABLENAME+".id_empresa,"+PresupuestoProductoConstantesFunciones.SCHEMA+"."+PresupuestoProductoConstantesFunciones.TABLENAME+".id_sucursal,"+PresupuestoProductoConstantesFunciones.SCHEMA+"."+PresupuestoProductoConstantesFunciones.TABLENAME+".id_ejercicio,"+PresupuestoProductoConstantesFunciones.SCHEMA+"."+PresupuestoProductoConstantesFunciones.TABLENAME+".id_periodo,"+PresupuestoProductoConstantesFunciones.SCHEMA+"."+PresupuestoProductoConstantesFunciones.TABLENAME+".id_cuenta_contable,"+PresupuestoProductoConstantesFunciones.SCHEMA+"."+PresupuestoProductoConstantesFunciones.TABLENAME+".id_bodega,"+PresupuestoProductoConstantesFunciones.SCHEMA+"."+PresupuestoProductoConstantesFunciones.TABLENAME+".id_producto,"+PresupuestoProductoConstantesFunciones.SCHEMA+"."+PresupuestoProductoConstantesFunciones.TABLENAME+".valor_ingreso,"+PresupuestoProductoConstantesFunciones.SCHEMA+"."+PresupuestoProductoConstantesFunciones.TABLENAME+".valor_egreso,"+PresupuestoProductoConstantesFunciones.SCHEMA+"."+PresupuestoProductoConstantesFunciones.TABLENAME+".cantidad_ingreso,"+PresupuestoProductoConstantesFunciones.SCHEMA+"."+PresupuestoProductoConstantesFunciones.TABLENAME+".cantidad_egreso from "+PresupuestoProductoConstantesFunciones.SCHEMA+"."+PresupuestoProductoConstantesFunciones.TABLENAME;//+" as "+PresupuestoProductoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PresupuestoProductoConstantesFuncionesAdditional presupuestoproductoConstantesFuncionesAdditional=null;
	
	public PresupuestoProductoConstantesFuncionesAdditional getPresupuestoProductoConstantesFuncionesAdditional() {
		return this.presupuestoproductoConstantesFuncionesAdditional;
	}
	
	public void setPresupuestoProductoConstantesFuncionesAdditional(PresupuestoProductoConstantesFuncionesAdditional presupuestoproductoConstantesFuncionesAdditional) {
		try {
			this.presupuestoproductoConstantesFuncionesAdditional=presupuestoproductoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String VALORINGRESO= "valor_ingreso";
    public static final String VALOREGRESO= "valor_egreso";
    public static final String CANTIDADINGRESO= "cantidad_ingreso";
    public static final String CANTIDADEGRESO= "cantidad_egreso";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_VALORINGRESO= "Valor Ingreso";
		public static final String LABEL_VALORINGRESO_LOWER= "Valor Ingreso";
    	public static final String LABEL_VALOREGRESO= "Valor Egreso";
		public static final String LABEL_VALOREGRESO_LOWER= "Valor Egreso";
    	public static final String LABEL_CANTIDADINGRESO= "Cantidad Ingreso";
		public static final String LABEL_CANTIDADINGRESO_LOWER= "Cantidad Ingreso";
    	public static final String LABEL_CANTIDADEGRESO= "Cantidad Egreso";
		public static final String LABEL_CANTIDADEGRESO_LOWER= "Cantidad Egreso";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getPresupuestoProductoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PresupuestoProductoConstantesFunciones.IDEMPRESA)) {sLabelColumna=PresupuestoProductoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PresupuestoProductoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=PresupuestoProductoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(PresupuestoProductoConstantesFunciones.IDEJERCICIO)) {sLabelColumna=PresupuestoProductoConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(PresupuestoProductoConstantesFunciones.IDPERIODO)) {sLabelColumna=PresupuestoProductoConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(PresupuestoProductoConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=PresupuestoProductoConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(PresupuestoProductoConstantesFunciones.IDBODEGA)) {sLabelColumna=PresupuestoProductoConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(PresupuestoProductoConstantesFunciones.IDPRODUCTO)) {sLabelColumna=PresupuestoProductoConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(PresupuestoProductoConstantesFunciones.VALORINGRESO)) {sLabelColumna=PresupuestoProductoConstantesFunciones.LABEL_VALORINGRESO;}
		if(sNombreColumna.equals(PresupuestoProductoConstantesFunciones.VALOREGRESO)) {sLabelColumna=PresupuestoProductoConstantesFunciones.LABEL_VALOREGRESO;}
		if(sNombreColumna.equals(PresupuestoProductoConstantesFunciones.CANTIDADINGRESO)) {sLabelColumna=PresupuestoProductoConstantesFunciones.LABEL_CANTIDADINGRESO;}
		if(sNombreColumna.equals(PresupuestoProductoConstantesFunciones.CANTIDADEGRESO)) {sLabelColumna=PresupuestoProductoConstantesFunciones.LABEL_CANTIDADEGRESO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getPresupuestoProductoDescripcion(PresupuestoProducto presupuestoproducto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(presupuestoproducto !=null/* && presupuestoproducto.getId()!=0*/) {
			if(presupuestoproducto.getId()!=null) {
				sDescripcion=presupuestoproducto.getId().toString();
			}//presupuestoproductopresupuestoproducto.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPresupuestoProductoDescripcionDetallado(PresupuestoProducto presupuestoproducto) {
		String sDescripcion="";
			
		sDescripcion+=PresupuestoProductoConstantesFunciones.ID+"=";
		sDescripcion+=presupuestoproducto.getId().toString()+",";
		sDescripcion+=PresupuestoProductoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=presupuestoproducto.getVersionRow().toString()+",";
		sDescripcion+=PresupuestoProductoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=presupuestoproducto.getid_empresa().toString()+",";
		sDescripcion+=PresupuestoProductoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=presupuestoproducto.getid_sucursal().toString()+",";
		sDescripcion+=PresupuestoProductoConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=presupuestoproducto.getid_ejercicio().toString()+",";
		sDescripcion+=PresupuestoProductoConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=presupuestoproducto.getid_periodo().toString()+",";
		sDescripcion+=PresupuestoProductoConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=presupuestoproducto.getid_cuenta_contable().toString()+",";
		sDescripcion+=PresupuestoProductoConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=presupuestoproducto.getid_bodega().toString()+",";
		sDescripcion+=PresupuestoProductoConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=presupuestoproducto.getid_producto().toString()+",";
		sDescripcion+=PresupuestoProductoConstantesFunciones.VALORINGRESO+"=";
		sDescripcion+=presupuestoproducto.getvalor_ingreso().toString()+",";
		sDescripcion+=PresupuestoProductoConstantesFunciones.VALOREGRESO+"=";
		sDescripcion+=presupuestoproducto.getvalor_egreso().toString()+",";
		sDescripcion+=PresupuestoProductoConstantesFunciones.CANTIDADINGRESO+"=";
		sDescripcion+=presupuestoproducto.getcantidad_ingreso().toString()+",";
		sDescripcion+=PresupuestoProductoConstantesFunciones.CANTIDADEGRESO+"=";
		sDescripcion+=presupuestoproducto.getcantidad_egreso().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPresupuestoProductoDescripcion(PresupuestoProducto presupuestoproducto,String sValor) throws Exception {			
		if(presupuestoproducto !=null) {
			//presupuestoproductopresupuestoproducto.getId().toString();
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

	public static String getPeriodoDescripcion(Periodo periodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periodo!=null/*&&periodo.getId()>0*/) {
			sDescripcion=PeriodoConstantesFunciones.getPeriodoDescripcion(periodo);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getBodegaDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
		}

		return sDescripcion;
	}

	public static String getProductoDescripcion(Producto producto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(producto!=null/*&&producto.getId()>0*/) {
			sDescripcion=ProductoConstantesFunciones.getProductoDescripcion(producto);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdBodega")) {
			sNombreIndice="Tipo=  Por Bodega";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdBodega(Long id_bodega) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

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

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProducto(Long id_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPresupuestoProducto(PresupuestoProducto presupuestoproducto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosPresupuestoProductos(List<PresupuestoProducto> presupuestoproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PresupuestoProducto presupuestoproducto: presupuestoproductos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPresupuestoProducto(PresupuestoProducto presupuestoproducto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && presupuestoproducto.getConCambioAuxiliar()) {
			presupuestoproducto.setIsDeleted(presupuestoproducto.getIsDeletedAuxiliar());	
			presupuestoproducto.setIsNew(presupuestoproducto.getIsNewAuxiliar());	
			presupuestoproducto.setIsChanged(presupuestoproducto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			presupuestoproducto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			presupuestoproducto.setIsDeletedAuxiliar(false);	
			presupuestoproducto.setIsNewAuxiliar(false);	
			presupuestoproducto.setIsChangedAuxiliar(false);
			
			presupuestoproducto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPresupuestoProductos(List<PresupuestoProducto> presupuestoproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PresupuestoProducto presupuestoproducto : presupuestoproductos) {
			if(conAsignarBase && presupuestoproducto.getConCambioAuxiliar()) {
				presupuestoproducto.setIsDeleted(presupuestoproducto.getIsDeletedAuxiliar());	
				presupuestoproducto.setIsNew(presupuestoproducto.getIsNewAuxiliar());	
				presupuestoproducto.setIsChanged(presupuestoproducto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				presupuestoproducto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				presupuestoproducto.setIsDeletedAuxiliar(false);	
				presupuestoproducto.setIsNewAuxiliar(false);	
				presupuestoproducto.setIsChangedAuxiliar(false);
				
				presupuestoproducto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPresupuestoProducto(PresupuestoProducto presupuestoproducto,Boolean conEnteros) throws Exception  {
		presupuestoproducto.setvalor_ingreso(0.0);
		presupuestoproducto.setvalor_egreso(0.0);
		presupuestoproducto.setcantidad_ingreso(0.0);
		presupuestoproducto.setcantidad_egreso(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPresupuestoProductos(List<PresupuestoProducto> presupuestoproductos,Boolean conEnteros) throws Exception  {
		
		for(PresupuestoProducto presupuestoproducto: presupuestoproductos) {
			presupuestoproducto.setvalor_ingreso(0.0);
			presupuestoproducto.setvalor_egreso(0.0);
			presupuestoproducto.setcantidad_ingreso(0.0);
			presupuestoproducto.setcantidad_egreso(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPresupuestoProducto(List<PresupuestoProducto> presupuestoproductos,PresupuestoProducto presupuestoproductoAux) throws Exception  {
		PresupuestoProductoConstantesFunciones.InicializarValoresPresupuestoProducto(presupuestoproductoAux,true);
		
		for(PresupuestoProducto presupuestoproducto: presupuestoproductos) {
			if(presupuestoproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			presupuestoproductoAux.setvalor_ingreso(presupuestoproductoAux.getvalor_ingreso()+presupuestoproducto.getvalor_ingreso());			
			presupuestoproductoAux.setvalor_egreso(presupuestoproductoAux.getvalor_egreso()+presupuestoproducto.getvalor_egreso());			
			presupuestoproductoAux.setcantidad_ingreso(presupuestoproductoAux.getcantidad_ingreso()+presupuestoproducto.getcantidad_ingreso());			
			presupuestoproductoAux.setcantidad_egreso(presupuestoproductoAux.getcantidad_egreso()+presupuestoproducto.getcantidad_egreso());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPresupuestoProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PresupuestoProductoConstantesFunciones.getArrayColumnasGlobalesPresupuestoProducto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPresupuestoProducto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresupuestoProductoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresupuestoProductoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresupuestoProductoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresupuestoProductoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresupuestoProductoConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresupuestoProductoConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresupuestoProductoConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresupuestoProductoConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPresupuestoProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PresupuestoProducto> presupuestoproductos,PresupuestoProducto presupuestoproducto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PresupuestoProducto presupuestoproductoAux: presupuestoproductos) {
			if(presupuestoproductoAux!=null && presupuestoproducto!=null) {
				if((presupuestoproductoAux.getId()==null && presupuestoproducto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(presupuestoproductoAux.getId()!=null && presupuestoproducto.getId()!=null){
					if(presupuestoproductoAux.getId().equals(presupuestoproducto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPresupuestoProducto(List<PresupuestoProducto> presupuestoproductos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_ingresoTotal=0.0;
		Double valor_egresoTotal=0.0;
		Double cantidad_ingresoTotal=0.0;
		Double cantidad_egresoTotal=0.0;
	
		for(PresupuestoProducto presupuestoproducto: presupuestoproductos) {			
			if(presupuestoproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_ingresoTotal+=presupuestoproducto.getvalor_ingreso();
			valor_egresoTotal+=presupuestoproducto.getvalor_egreso();
			cantidad_ingresoTotal+=presupuestoproducto.getcantidad_ingreso();
			cantidad_egresoTotal+=presupuestoproducto.getcantidad_egreso();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestoProductoConstantesFunciones.VALORINGRESO);
		datoGeneral.setsDescripcion(PresupuestoProductoConstantesFunciones.LABEL_VALORINGRESO);
		datoGeneral.setdValorDouble(valor_ingresoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestoProductoConstantesFunciones.VALOREGRESO);
		datoGeneral.setsDescripcion(PresupuestoProductoConstantesFunciones.LABEL_VALOREGRESO);
		datoGeneral.setdValorDouble(valor_egresoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestoProductoConstantesFunciones.CANTIDADINGRESO);
		datoGeneral.setsDescripcion(PresupuestoProductoConstantesFunciones.LABEL_CANTIDADINGRESO);
		datoGeneral.setdValorDouble(cantidad_ingresoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestoProductoConstantesFunciones.CANTIDADEGRESO);
		datoGeneral.setsDescripcion(PresupuestoProductoConstantesFunciones.LABEL_CANTIDADEGRESO);
		datoGeneral.setdValorDouble(cantidad_egresoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPresupuestoProducto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PresupuestoProductoConstantesFunciones.LABEL_ID, PresupuestoProductoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoProductoConstantesFunciones.LABEL_VERSIONROW, PresupuestoProductoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoProductoConstantesFunciones.LABEL_IDEMPRESA, PresupuestoProductoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoProductoConstantesFunciones.LABEL_IDSUCURSAL, PresupuestoProductoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoProductoConstantesFunciones.LABEL_IDEJERCICIO, PresupuestoProductoConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoProductoConstantesFunciones.LABEL_IDPERIODO, PresupuestoProductoConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoProductoConstantesFunciones.LABEL_IDCUENTACONTABLE, PresupuestoProductoConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoProductoConstantesFunciones.LABEL_IDBODEGA, PresupuestoProductoConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoProductoConstantesFunciones.LABEL_IDPRODUCTO, PresupuestoProductoConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoProductoConstantesFunciones.LABEL_VALORINGRESO, PresupuestoProductoConstantesFunciones.VALORINGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoProductoConstantesFunciones.LABEL_VALOREGRESO, PresupuestoProductoConstantesFunciones.VALOREGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoProductoConstantesFunciones.LABEL_CANTIDADINGRESO, PresupuestoProductoConstantesFunciones.CANTIDADINGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoProductoConstantesFunciones.LABEL_CANTIDADEGRESO, PresupuestoProductoConstantesFunciones.CANTIDADEGRESO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPresupuestoProducto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PresupuestoProductoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoProductoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoProductoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoProductoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoProductoConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoProductoConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoProductoConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoProductoConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoProductoConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoProductoConstantesFunciones.VALORINGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoProductoConstantesFunciones.VALOREGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoProductoConstantesFunciones.CANTIDADINGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoProductoConstantesFunciones.CANTIDADEGRESO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresupuestoProducto() throws Exception  {
		return PresupuestoProductoConstantesFunciones.getTiposSeleccionarPresupuestoProducto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresupuestoProducto(Boolean conFk) throws Exception  {
		return PresupuestoProductoConstantesFunciones.getTiposSeleccionarPresupuestoProducto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresupuestoProducto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoProductoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PresupuestoProductoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoProductoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(PresupuestoProductoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoProductoConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(PresupuestoProductoConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoProductoConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(PresupuestoProductoConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoProductoConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(PresupuestoProductoConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoProductoConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(PresupuestoProductoConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoProductoConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(PresupuestoProductoConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoProductoConstantesFunciones.LABEL_VALORINGRESO);
			reporte.setsDescripcion(PresupuestoProductoConstantesFunciones.LABEL_VALORINGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoProductoConstantesFunciones.LABEL_VALOREGRESO);
			reporte.setsDescripcion(PresupuestoProductoConstantesFunciones.LABEL_VALOREGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoProductoConstantesFunciones.LABEL_CANTIDADINGRESO);
			reporte.setsDescripcion(PresupuestoProductoConstantesFunciones.LABEL_CANTIDADINGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoProductoConstantesFunciones.LABEL_CANTIDADEGRESO);
			reporte.setsDescripcion(PresupuestoProductoConstantesFunciones.LABEL_CANTIDADEGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPresupuestoProducto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPresupuestoProducto(PresupuestoProducto presupuestoproductoAux) throws Exception {
		
			presupuestoproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(presupuestoproductoAux.getEmpresa()));
			presupuestoproductoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(presupuestoproductoAux.getSucursal()));
			presupuestoproductoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(presupuestoproductoAux.getEjercicio()));
			presupuestoproductoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(presupuestoproductoAux.getPeriodo()));
			presupuestoproductoAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(presupuestoproductoAux.getCuentaContable()));
			presupuestoproductoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(presupuestoproductoAux.getBodega()));
			presupuestoproductoAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(presupuestoproductoAux.getProducto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPresupuestoProducto(List<PresupuestoProducto> presupuestoproductosTemp) throws Exception {
		for(PresupuestoProducto presupuestoproductoAux:presupuestoproductosTemp) {
			
			presupuestoproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(presupuestoproductoAux.getEmpresa()));
			presupuestoproductoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(presupuestoproductoAux.getSucursal()));
			presupuestoproductoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(presupuestoproductoAux.getEjercicio()));
			presupuestoproductoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(presupuestoproductoAux.getPeriodo()));
			presupuestoproductoAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(presupuestoproductoAux.getCuentaContable()));
			presupuestoproductoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(presupuestoproductoAux.getBodega()));
			presupuestoproductoAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(presupuestoproductoAux.getProducto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPresupuestoProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				
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

				for(Classe clas:classesP) {
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPresupuestoProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
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

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresupuestoProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PresupuestoProductoConstantesFunciones.getClassesRelationshipsOfPresupuestoProducto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresupuestoProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPresupuestoProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PresupuestoProductoConstantesFunciones.getClassesRelationshipsFromStringsOfPresupuestoProducto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPresupuestoProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PresupuestoProducto presupuestoproducto,List<PresupuestoProducto> presupuestoproductos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PresupuestoProducto presupuestoproductoEncontrado=null;
			
			for(PresupuestoProducto presupuestoproductoLocal:presupuestoproductos) {
				if(presupuestoproductoLocal.getId().equals(presupuestoproducto.getId())) {
					presupuestoproductoEncontrado=presupuestoproductoLocal;
					
					presupuestoproductoLocal.setIsChanged(presupuestoproducto.getIsChanged());
					presupuestoproductoLocal.setIsNew(presupuestoproducto.getIsNew());
					presupuestoproductoLocal.setIsDeleted(presupuestoproducto.getIsDeleted());
					
					presupuestoproductoLocal.setGeneralEntityOriginal(presupuestoproducto.getGeneralEntityOriginal());
					
					presupuestoproductoLocal.setId(presupuestoproducto.getId());	
					presupuestoproductoLocal.setVersionRow(presupuestoproducto.getVersionRow());	
					presupuestoproductoLocal.setid_empresa(presupuestoproducto.getid_empresa());	
					presupuestoproductoLocal.setid_sucursal(presupuestoproducto.getid_sucursal());	
					presupuestoproductoLocal.setid_ejercicio(presupuestoproducto.getid_ejercicio());	
					presupuestoproductoLocal.setid_periodo(presupuestoproducto.getid_periodo());	
					presupuestoproductoLocal.setid_cuenta_contable(presupuestoproducto.getid_cuenta_contable());	
					presupuestoproductoLocal.setid_bodega(presupuestoproducto.getid_bodega());	
					presupuestoproductoLocal.setid_producto(presupuestoproducto.getid_producto());	
					presupuestoproductoLocal.setvalor_ingreso(presupuestoproducto.getvalor_ingreso());	
					presupuestoproductoLocal.setvalor_egreso(presupuestoproducto.getvalor_egreso());	
					presupuestoproductoLocal.setcantidad_ingreso(presupuestoproducto.getcantidad_ingreso());	
					presupuestoproductoLocal.setcantidad_egreso(presupuestoproducto.getcantidad_egreso());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!presupuestoproducto.getIsDeleted()) {
				if(!existe) {
					presupuestoproductos.add(presupuestoproducto);
				}
			} else {
				if(presupuestoproductoEncontrado!=null && permiteQuitar)  {
					presupuestoproductos.remove(presupuestoproductoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PresupuestoProducto presupuestoproducto,List<PresupuestoProducto> presupuestoproductos) throws Exception {
		try	{			
			for(PresupuestoProducto presupuestoproductoLocal:presupuestoproductos) {
				if(presupuestoproductoLocal.getId().equals(presupuestoproducto.getId())) {
					presupuestoproductoLocal.setIsSelected(presupuestoproducto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPresupuestoProducto(List<PresupuestoProducto> presupuestoproductosAux) throws Exception {
		//this.presupuestoproductosAux=presupuestoproductosAux;
		
		for(PresupuestoProducto presupuestoproductoAux:presupuestoproductosAux) {
			if(presupuestoproductoAux.getIsChanged()) {
				presupuestoproductoAux.setIsChanged(false);
			}		
			
			if(presupuestoproductoAux.getIsNew()) {
				presupuestoproductoAux.setIsNew(false);
			}	
			
			if(presupuestoproductoAux.getIsDeleted()) {
				presupuestoproductoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPresupuestoProducto(PresupuestoProducto presupuestoproductoAux) throws Exception {
		//this.presupuestoproductoAux=presupuestoproductoAux;
		
			if(presupuestoproductoAux.getIsChanged()) {
				presupuestoproductoAux.setIsChanged(false);
			}		
			
			if(presupuestoproductoAux.getIsNew()) {
				presupuestoproductoAux.setIsNew(false);
			}	
			
			if(presupuestoproductoAux.getIsDeleted()) {
				presupuestoproductoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PresupuestoProducto presupuestoproductoAsignar,PresupuestoProducto presupuestoproducto) throws Exception {
		presupuestoproductoAsignar.setId(presupuestoproducto.getId());	
		presupuestoproductoAsignar.setVersionRow(presupuestoproducto.getVersionRow());	
		presupuestoproductoAsignar.setid_empresa(presupuestoproducto.getid_empresa());
		presupuestoproductoAsignar.setempresa_descripcion(presupuestoproducto.getempresa_descripcion());	
		presupuestoproductoAsignar.setid_sucursal(presupuestoproducto.getid_sucursal());
		presupuestoproductoAsignar.setsucursal_descripcion(presupuestoproducto.getsucursal_descripcion());	
		presupuestoproductoAsignar.setid_ejercicio(presupuestoproducto.getid_ejercicio());
		presupuestoproductoAsignar.setejercicio_descripcion(presupuestoproducto.getejercicio_descripcion());	
		presupuestoproductoAsignar.setid_periodo(presupuestoproducto.getid_periodo());
		presupuestoproductoAsignar.setperiodo_descripcion(presupuestoproducto.getperiodo_descripcion());	
		presupuestoproductoAsignar.setid_cuenta_contable(presupuestoproducto.getid_cuenta_contable());
		presupuestoproductoAsignar.setcuentacontable_descripcion(presupuestoproducto.getcuentacontable_descripcion());	
		presupuestoproductoAsignar.setid_bodega(presupuestoproducto.getid_bodega());
		presupuestoproductoAsignar.setbodega_descripcion(presupuestoproducto.getbodega_descripcion());	
		presupuestoproductoAsignar.setid_producto(presupuestoproducto.getid_producto());
		presupuestoproductoAsignar.setproducto_descripcion(presupuestoproducto.getproducto_descripcion());	
		presupuestoproductoAsignar.setvalor_ingreso(presupuestoproducto.getvalor_ingreso());	
		presupuestoproductoAsignar.setvalor_egreso(presupuestoproducto.getvalor_egreso());	
		presupuestoproductoAsignar.setcantidad_ingreso(presupuestoproducto.getcantidad_ingreso());	
		presupuestoproductoAsignar.setcantidad_egreso(presupuestoproducto.getcantidad_egreso());	
	}
	
	public static void inicializarPresupuestoProducto(PresupuestoProducto presupuestoproducto) throws Exception {
		try {
				presupuestoproducto.setId(0L);	
					
				presupuestoproducto.setid_empresa(-1L);	
				presupuestoproducto.setid_sucursal(-1L);	
				presupuestoproducto.setid_ejercicio(-1L);	
				presupuestoproducto.setid_periodo(-1L);	
				presupuestoproducto.setid_cuenta_contable(-1L);	
				presupuestoproducto.setid_bodega(-1L);	
				presupuestoproducto.setid_producto(-1L);	
				presupuestoproducto.setvalor_ingreso(0.0);	
				presupuestoproducto.setvalor_egreso(0.0);	
				presupuestoproducto.setcantidad_ingreso(0.0);	
				presupuestoproducto.setcantidad_egreso(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPresupuestoProducto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoProductoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoProductoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoProductoConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoProductoConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoProductoConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoProductoConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoProductoConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoProductoConstantesFunciones.LABEL_VALORINGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoProductoConstantesFunciones.LABEL_VALOREGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoProductoConstantesFunciones.LABEL_CANTIDADINGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoProductoConstantesFunciones.LABEL_CANTIDADEGRESO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPresupuestoProducto(String sTipo,Row row,Workbook workbook,PresupuestoProducto presupuestoproducto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoproducto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoproducto.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoproducto.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoproducto.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoproducto.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoproducto.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoproducto.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoproducto.getvalor_ingreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoproducto.getvalor_egreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoproducto.getcantidad_ingreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoproducto.getcantidad_egreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPresupuestoProducto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPresupuestoProducto() {
		return this.sFinalQueryPresupuestoProducto;
	}
	
	public void setsFinalQueryPresupuestoProducto(String sFinalQueryPresupuestoProducto) {
		this.sFinalQueryPresupuestoProducto= sFinalQueryPresupuestoProducto;
	}
	
	public Border resaltarSeleccionarPresupuestoProducto=null;
	
	public Border setResaltarSeleccionarPresupuestoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoProductoBeanSwingJInternalFrame presupuestoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//presupuestoproductoBeanSwingJInternalFrame.jTtoolBarPresupuestoProducto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPresupuestoProducto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPresupuestoProducto() {
		return this.resaltarSeleccionarPresupuestoProducto;
	}
	
	public void setResaltarSeleccionarPresupuestoProducto(Border borderResaltarSeleccionarPresupuestoProducto) {
		this.resaltarSeleccionarPresupuestoProducto= borderResaltarSeleccionarPresupuestoProducto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPresupuestoProducto=null;
	public Boolean mostraridPresupuestoProducto=true;
	public Boolean activaridPresupuestoProducto=true;

	public Border resaltarid_empresaPresupuestoProducto=null;
	public Boolean mostrarid_empresaPresupuestoProducto=true;
	public Boolean activarid_empresaPresupuestoProducto=true;
	public Boolean cargarid_empresaPresupuestoProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPresupuestoProducto=false;//ConEventDepend=true

	public Border resaltarid_sucursalPresupuestoProducto=null;
	public Boolean mostrarid_sucursalPresupuestoProducto=true;
	public Boolean activarid_sucursalPresupuestoProducto=true;
	public Boolean cargarid_sucursalPresupuestoProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalPresupuestoProducto=false;//ConEventDepend=true

	public Border resaltarid_ejercicioPresupuestoProducto=null;
	public Boolean mostrarid_ejercicioPresupuestoProducto=true;
	public Boolean activarid_ejercicioPresupuestoProducto=true;
	public Boolean cargarid_ejercicioPresupuestoProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioPresupuestoProducto=false;//ConEventDepend=true

	public Border resaltarid_periodoPresupuestoProducto=null;
	public Boolean mostrarid_periodoPresupuestoProducto=true;
	public Boolean activarid_periodoPresupuestoProducto=true;
	public Boolean cargarid_periodoPresupuestoProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoPresupuestoProducto=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contablePresupuestoProducto=null;
	public Boolean mostrarid_cuenta_contablePresupuestoProducto=true;
	public Boolean activarid_cuenta_contablePresupuestoProducto=true;
	public Boolean cargarid_cuenta_contablePresupuestoProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contablePresupuestoProducto=false;//ConEventDepend=true

	public Border resaltarid_bodegaPresupuestoProducto=null;
	public Boolean mostrarid_bodegaPresupuestoProducto=true;
	public Boolean activarid_bodegaPresupuestoProducto=true;
	public Boolean cargarid_bodegaPresupuestoProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaPresupuestoProducto=false;//ConEventDepend=true

	public Border resaltarid_productoPresupuestoProducto=null;
	public Boolean mostrarid_productoPresupuestoProducto=true;
	public Boolean activarid_productoPresupuestoProducto=true;
	public Boolean cargarid_productoPresupuestoProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoPresupuestoProducto=false;//ConEventDepend=true

	public Border resaltarvalor_ingresoPresupuestoProducto=null;
	public Boolean mostrarvalor_ingresoPresupuestoProducto=true;
	public Boolean activarvalor_ingresoPresupuestoProducto=true;

	public Border resaltarvalor_egresoPresupuestoProducto=null;
	public Boolean mostrarvalor_egresoPresupuestoProducto=true;
	public Boolean activarvalor_egresoPresupuestoProducto=true;

	public Border resaltarcantidad_ingresoPresupuestoProducto=null;
	public Boolean mostrarcantidad_ingresoPresupuestoProducto=true;
	public Boolean activarcantidad_ingresoPresupuestoProducto=true;

	public Border resaltarcantidad_egresoPresupuestoProducto=null;
	public Boolean mostrarcantidad_egresoPresupuestoProducto=true;
	public Boolean activarcantidad_egresoPresupuestoProducto=true;

	
	

	public Border setResaltaridPresupuestoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoProductoBeanSwingJInternalFrame presupuestoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoproductoBeanSwingJInternalFrame.jTtoolBarPresupuestoProducto.setBorder(borderResaltar);
		
		this.resaltaridPresupuestoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPresupuestoProducto() {
		return this.resaltaridPresupuestoProducto;
	}

	public void setResaltaridPresupuestoProducto(Border borderResaltar) {
		this.resaltaridPresupuestoProducto= borderResaltar;
	}

	public Boolean getMostraridPresupuestoProducto() {
		return this.mostraridPresupuestoProducto;
	}

	public void setMostraridPresupuestoProducto(Boolean mostraridPresupuestoProducto) {
		this.mostraridPresupuestoProducto= mostraridPresupuestoProducto;
	}

	public Boolean getActivaridPresupuestoProducto() {
		return this.activaridPresupuestoProducto;
	}

	public void setActivaridPresupuestoProducto(Boolean activaridPresupuestoProducto) {
		this.activaridPresupuestoProducto= activaridPresupuestoProducto;
	}

	public Border setResaltarid_empresaPresupuestoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoProductoBeanSwingJInternalFrame presupuestoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoproductoBeanSwingJInternalFrame.jTtoolBarPresupuestoProducto.setBorder(borderResaltar);
		
		this.resaltarid_empresaPresupuestoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPresupuestoProducto() {
		return this.resaltarid_empresaPresupuestoProducto;
	}

	public void setResaltarid_empresaPresupuestoProducto(Border borderResaltar) {
		this.resaltarid_empresaPresupuestoProducto= borderResaltar;
	}

	public Boolean getMostrarid_empresaPresupuestoProducto() {
		return this.mostrarid_empresaPresupuestoProducto;
	}

	public void setMostrarid_empresaPresupuestoProducto(Boolean mostrarid_empresaPresupuestoProducto) {
		this.mostrarid_empresaPresupuestoProducto= mostrarid_empresaPresupuestoProducto;
	}

	public Boolean getActivarid_empresaPresupuestoProducto() {
		return this.activarid_empresaPresupuestoProducto;
	}

	public void setActivarid_empresaPresupuestoProducto(Boolean activarid_empresaPresupuestoProducto) {
		this.activarid_empresaPresupuestoProducto= activarid_empresaPresupuestoProducto;
	}

	public Boolean getCargarid_empresaPresupuestoProducto() {
		return this.cargarid_empresaPresupuestoProducto;
	}

	public void setCargarid_empresaPresupuestoProducto(Boolean cargarid_empresaPresupuestoProducto) {
		this.cargarid_empresaPresupuestoProducto= cargarid_empresaPresupuestoProducto;
	}

	public Border setResaltarid_sucursalPresupuestoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoProductoBeanSwingJInternalFrame presupuestoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoproductoBeanSwingJInternalFrame.jTtoolBarPresupuestoProducto.setBorder(borderResaltar);
		
		this.resaltarid_sucursalPresupuestoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalPresupuestoProducto() {
		return this.resaltarid_sucursalPresupuestoProducto;
	}

	public void setResaltarid_sucursalPresupuestoProducto(Border borderResaltar) {
		this.resaltarid_sucursalPresupuestoProducto= borderResaltar;
	}

	public Boolean getMostrarid_sucursalPresupuestoProducto() {
		return this.mostrarid_sucursalPresupuestoProducto;
	}

	public void setMostrarid_sucursalPresupuestoProducto(Boolean mostrarid_sucursalPresupuestoProducto) {
		this.mostrarid_sucursalPresupuestoProducto= mostrarid_sucursalPresupuestoProducto;
	}

	public Boolean getActivarid_sucursalPresupuestoProducto() {
		return this.activarid_sucursalPresupuestoProducto;
	}

	public void setActivarid_sucursalPresupuestoProducto(Boolean activarid_sucursalPresupuestoProducto) {
		this.activarid_sucursalPresupuestoProducto= activarid_sucursalPresupuestoProducto;
	}

	public Boolean getCargarid_sucursalPresupuestoProducto() {
		return this.cargarid_sucursalPresupuestoProducto;
	}

	public void setCargarid_sucursalPresupuestoProducto(Boolean cargarid_sucursalPresupuestoProducto) {
		this.cargarid_sucursalPresupuestoProducto= cargarid_sucursalPresupuestoProducto;
	}

	public Border setResaltarid_ejercicioPresupuestoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoProductoBeanSwingJInternalFrame presupuestoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoproductoBeanSwingJInternalFrame.jTtoolBarPresupuestoProducto.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioPresupuestoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioPresupuestoProducto() {
		return this.resaltarid_ejercicioPresupuestoProducto;
	}

	public void setResaltarid_ejercicioPresupuestoProducto(Border borderResaltar) {
		this.resaltarid_ejercicioPresupuestoProducto= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioPresupuestoProducto() {
		return this.mostrarid_ejercicioPresupuestoProducto;
	}

	public void setMostrarid_ejercicioPresupuestoProducto(Boolean mostrarid_ejercicioPresupuestoProducto) {
		this.mostrarid_ejercicioPresupuestoProducto= mostrarid_ejercicioPresupuestoProducto;
	}

	public Boolean getActivarid_ejercicioPresupuestoProducto() {
		return this.activarid_ejercicioPresupuestoProducto;
	}

	public void setActivarid_ejercicioPresupuestoProducto(Boolean activarid_ejercicioPresupuestoProducto) {
		this.activarid_ejercicioPresupuestoProducto= activarid_ejercicioPresupuestoProducto;
	}

	public Boolean getCargarid_ejercicioPresupuestoProducto() {
		return this.cargarid_ejercicioPresupuestoProducto;
	}

	public void setCargarid_ejercicioPresupuestoProducto(Boolean cargarid_ejercicioPresupuestoProducto) {
		this.cargarid_ejercicioPresupuestoProducto= cargarid_ejercicioPresupuestoProducto;
	}

	public Border setResaltarid_periodoPresupuestoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoProductoBeanSwingJInternalFrame presupuestoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoproductoBeanSwingJInternalFrame.jTtoolBarPresupuestoProducto.setBorder(borderResaltar);
		
		this.resaltarid_periodoPresupuestoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoPresupuestoProducto() {
		return this.resaltarid_periodoPresupuestoProducto;
	}

	public void setResaltarid_periodoPresupuestoProducto(Border borderResaltar) {
		this.resaltarid_periodoPresupuestoProducto= borderResaltar;
	}

	public Boolean getMostrarid_periodoPresupuestoProducto() {
		return this.mostrarid_periodoPresupuestoProducto;
	}

	public void setMostrarid_periodoPresupuestoProducto(Boolean mostrarid_periodoPresupuestoProducto) {
		this.mostrarid_periodoPresupuestoProducto= mostrarid_periodoPresupuestoProducto;
	}

	public Boolean getActivarid_periodoPresupuestoProducto() {
		return this.activarid_periodoPresupuestoProducto;
	}

	public void setActivarid_periodoPresupuestoProducto(Boolean activarid_periodoPresupuestoProducto) {
		this.activarid_periodoPresupuestoProducto= activarid_periodoPresupuestoProducto;
	}

	public Boolean getCargarid_periodoPresupuestoProducto() {
		return this.cargarid_periodoPresupuestoProducto;
	}

	public void setCargarid_periodoPresupuestoProducto(Boolean cargarid_periodoPresupuestoProducto) {
		this.cargarid_periodoPresupuestoProducto= cargarid_periodoPresupuestoProducto;
	}

	public Border setResaltarid_cuenta_contablePresupuestoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoProductoBeanSwingJInternalFrame presupuestoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoproductoBeanSwingJInternalFrame.jTtoolBarPresupuestoProducto.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contablePresupuestoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contablePresupuestoProducto() {
		return this.resaltarid_cuenta_contablePresupuestoProducto;
	}

	public void setResaltarid_cuenta_contablePresupuestoProducto(Border borderResaltar) {
		this.resaltarid_cuenta_contablePresupuestoProducto= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contablePresupuestoProducto() {
		return this.mostrarid_cuenta_contablePresupuestoProducto;
	}

	public void setMostrarid_cuenta_contablePresupuestoProducto(Boolean mostrarid_cuenta_contablePresupuestoProducto) {
		this.mostrarid_cuenta_contablePresupuestoProducto= mostrarid_cuenta_contablePresupuestoProducto;
	}

	public Boolean getActivarid_cuenta_contablePresupuestoProducto() {
		return this.activarid_cuenta_contablePresupuestoProducto;
	}

	public void setActivarid_cuenta_contablePresupuestoProducto(Boolean activarid_cuenta_contablePresupuestoProducto) {
		this.activarid_cuenta_contablePresupuestoProducto= activarid_cuenta_contablePresupuestoProducto;
	}

	public Boolean getCargarid_cuenta_contablePresupuestoProducto() {
		return this.cargarid_cuenta_contablePresupuestoProducto;
	}

	public void setCargarid_cuenta_contablePresupuestoProducto(Boolean cargarid_cuenta_contablePresupuestoProducto) {
		this.cargarid_cuenta_contablePresupuestoProducto= cargarid_cuenta_contablePresupuestoProducto;
	}

	public Border setResaltarid_bodegaPresupuestoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoProductoBeanSwingJInternalFrame presupuestoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoproductoBeanSwingJInternalFrame.jTtoolBarPresupuestoProducto.setBorder(borderResaltar);
		
		this.resaltarid_bodegaPresupuestoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaPresupuestoProducto() {
		return this.resaltarid_bodegaPresupuestoProducto;
	}

	public void setResaltarid_bodegaPresupuestoProducto(Border borderResaltar) {
		this.resaltarid_bodegaPresupuestoProducto= borderResaltar;
	}

	public Boolean getMostrarid_bodegaPresupuestoProducto() {
		return this.mostrarid_bodegaPresupuestoProducto;
	}

	public void setMostrarid_bodegaPresupuestoProducto(Boolean mostrarid_bodegaPresupuestoProducto) {
		this.mostrarid_bodegaPresupuestoProducto= mostrarid_bodegaPresupuestoProducto;
	}

	public Boolean getActivarid_bodegaPresupuestoProducto() {
		return this.activarid_bodegaPresupuestoProducto;
	}

	public void setActivarid_bodegaPresupuestoProducto(Boolean activarid_bodegaPresupuestoProducto) {
		this.activarid_bodegaPresupuestoProducto= activarid_bodegaPresupuestoProducto;
	}

	public Boolean getCargarid_bodegaPresupuestoProducto() {
		return this.cargarid_bodegaPresupuestoProducto;
	}

	public void setCargarid_bodegaPresupuestoProducto(Boolean cargarid_bodegaPresupuestoProducto) {
		this.cargarid_bodegaPresupuestoProducto= cargarid_bodegaPresupuestoProducto;
	}

	public Border setResaltarid_productoPresupuestoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoProductoBeanSwingJInternalFrame presupuestoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoproductoBeanSwingJInternalFrame.jTtoolBarPresupuestoProducto.setBorder(borderResaltar);
		
		this.resaltarid_productoPresupuestoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoPresupuestoProducto() {
		return this.resaltarid_productoPresupuestoProducto;
	}

	public void setResaltarid_productoPresupuestoProducto(Border borderResaltar) {
		this.resaltarid_productoPresupuestoProducto= borderResaltar;
	}

	public Boolean getMostrarid_productoPresupuestoProducto() {
		return this.mostrarid_productoPresupuestoProducto;
	}

	public void setMostrarid_productoPresupuestoProducto(Boolean mostrarid_productoPresupuestoProducto) {
		this.mostrarid_productoPresupuestoProducto= mostrarid_productoPresupuestoProducto;
	}

	public Boolean getActivarid_productoPresupuestoProducto() {
		return this.activarid_productoPresupuestoProducto;
	}

	public void setActivarid_productoPresupuestoProducto(Boolean activarid_productoPresupuestoProducto) {
		this.activarid_productoPresupuestoProducto= activarid_productoPresupuestoProducto;
	}

	public Boolean getCargarid_productoPresupuestoProducto() {
		return this.cargarid_productoPresupuestoProducto;
	}

	public void setCargarid_productoPresupuestoProducto(Boolean cargarid_productoPresupuestoProducto) {
		this.cargarid_productoPresupuestoProducto= cargarid_productoPresupuestoProducto;
	}

	public Border setResaltarvalor_ingresoPresupuestoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoProductoBeanSwingJInternalFrame presupuestoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoproductoBeanSwingJInternalFrame.jTtoolBarPresupuestoProducto.setBorder(borderResaltar);
		
		this.resaltarvalor_ingresoPresupuestoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_ingresoPresupuestoProducto() {
		return this.resaltarvalor_ingresoPresupuestoProducto;
	}

	public void setResaltarvalor_ingresoPresupuestoProducto(Border borderResaltar) {
		this.resaltarvalor_ingresoPresupuestoProducto= borderResaltar;
	}

	public Boolean getMostrarvalor_ingresoPresupuestoProducto() {
		return this.mostrarvalor_ingresoPresupuestoProducto;
	}

	public void setMostrarvalor_ingresoPresupuestoProducto(Boolean mostrarvalor_ingresoPresupuestoProducto) {
		this.mostrarvalor_ingresoPresupuestoProducto= mostrarvalor_ingresoPresupuestoProducto;
	}

	public Boolean getActivarvalor_ingresoPresupuestoProducto() {
		return this.activarvalor_ingresoPresupuestoProducto;
	}

	public void setActivarvalor_ingresoPresupuestoProducto(Boolean activarvalor_ingresoPresupuestoProducto) {
		this.activarvalor_ingresoPresupuestoProducto= activarvalor_ingresoPresupuestoProducto;
	}

	public Border setResaltarvalor_egresoPresupuestoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoProductoBeanSwingJInternalFrame presupuestoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoproductoBeanSwingJInternalFrame.jTtoolBarPresupuestoProducto.setBorder(borderResaltar);
		
		this.resaltarvalor_egresoPresupuestoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_egresoPresupuestoProducto() {
		return this.resaltarvalor_egresoPresupuestoProducto;
	}

	public void setResaltarvalor_egresoPresupuestoProducto(Border borderResaltar) {
		this.resaltarvalor_egresoPresupuestoProducto= borderResaltar;
	}

	public Boolean getMostrarvalor_egresoPresupuestoProducto() {
		return this.mostrarvalor_egresoPresupuestoProducto;
	}

	public void setMostrarvalor_egresoPresupuestoProducto(Boolean mostrarvalor_egresoPresupuestoProducto) {
		this.mostrarvalor_egresoPresupuestoProducto= mostrarvalor_egresoPresupuestoProducto;
	}

	public Boolean getActivarvalor_egresoPresupuestoProducto() {
		return this.activarvalor_egresoPresupuestoProducto;
	}

	public void setActivarvalor_egresoPresupuestoProducto(Boolean activarvalor_egresoPresupuestoProducto) {
		this.activarvalor_egresoPresupuestoProducto= activarvalor_egresoPresupuestoProducto;
	}

	public Border setResaltarcantidad_ingresoPresupuestoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoProductoBeanSwingJInternalFrame presupuestoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoproductoBeanSwingJInternalFrame.jTtoolBarPresupuestoProducto.setBorder(borderResaltar);
		
		this.resaltarcantidad_ingresoPresupuestoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_ingresoPresupuestoProducto() {
		return this.resaltarcantidad_ingresoPresupuestoProducto;
	}

	public void setResaltarcantidad_ingresoPresupuestoProducto(Border borderResaltar) {
		this.resaltarcantidad_ingresoPresupuestoProducto= borderResaltar;
	}

	public Boolean getMostrarcantidad_ingresoPresupuestoProducto() {
		return this.mostrarcantidad_ingresoPresupuestoProducto;
	}

	public void setMostrarcantidad_ingresoPresupuestoProducto(Boolean mostrarcantidad_ingresoPresupuestoProducto) {
		this.mostrarcantidad_ingresoPresupuestoProducto= mostrarcantidad_ingresoPresupuestoProducto;
	}

	public Boolean getActivarcantidad_ingresoPresupuestoProducto() {
		return this.activarcantidad_ingresoPresupuestoProducto;
	}

	public void setActivarcantidad_ingresoPresupuestoProducto(Boolean activarcantidad_ingresoPresupuestoProducto) {
		this.activarcantidad_ingresoPresupuestoProducto= activarcantidad_ingresoPresupuestoProducto;
	}

	public Border setResaltarcantidad_egresoPresupuestoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoProductoBeanSwingJInternalFrame presupuestoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoproductoBeanSwingJInternalFrame.jTtoolBarPresupuestoProducto.setBorder(borderResaltar);
		
		this.resaltarcantidad_egresoPresupuestoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_egresoPresupuestoProducto() {
		return this.resaltarcantidad_egresoPresupuestoProducto;
	}

	public void setResaltarcantidad_egresoPresupuestoProducto(Border borderResaltar) {
		this.resaltarcantidad_egresoPresupuestoProducto= borderResaltar;
	}

	public Boolean getMostrarcantidad_egresoPresupuestoProducto() {
		return this.mostrarcantidad_egresoPresupuestoProducto;
	}

	public void setMostrarcantidad_egresoPresupuestoProducto(Boolean mostrarcantidad_egresoPresupuestoProducto) {
		this.mostrarcantidad_egresoPresupuestoProducto= mostrarcantidad_egresoPresupuestoProducto;
	}

	public Boolean getActivarcantidad_egresoPresupuestoProducto() {
		return this.activarcantidad_egresoPresupuestoProducto;
	}

	public void setActivarcantidad_egresoPresupuestoProducto(Boolean activarcantidad_egresoPresupuestoProducto) {
		this.activarcantidad_egresoPresupuestoProducto= activarcantidad_egresoPresupuestoProducto;
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
		
		
		this.setMostraridPresupuestoProducto(esInicial);
		this.setMostrarid_empresaPresupuestoProducto(esInicial);
		this.setMostrarid_sucursalPresupuestoProducto(esInicial);
		this.setMostrarid_ejercicioPresupuestoProducto(esInicial);
		this.setMostrarid_periodoPresupuestoProducto(esInicial);
		this.setMostrarid_cuenta_contablePresupuestoProducto(esInicial);
		this.setMostrarid_bodegaPresupuestoProducto(esInicial);
		this.setMostrarid_productoPresupuestoProducto(esInicial);
		this.setMostrarvalor_ingresoPresupuestoProducto(esInicial);
		this.setMostrarvalor_egresoPresupuestoProducto(esInicial);
		this.setMostrarcantidad_ingresoPresupuestoProducto(esInicial);
		this.setMostrarcantidad_egresoPresupuestoProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.ID)) {
				this.setMostraridPresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalPresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioPresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoPresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contablePresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaPresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoPresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.VALORINGRESO)) {
				this.setMostrarvalor_ingresoPresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.VALOREGRESO)) {
				this.setMostrarvalor_egresoPresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.CANTIDADINGRESO)) {
				this.setMostrarcantidad_ingresoPresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.CANTIDADEGRESO)) {
				this.setMostrarcantidad_egresoPresupuestoProducto(esAsigna);
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
		
		
		this.setActivaridPresupuestoProducto(esInicial);
		this.setActivarid_empresaPresupuestoProducto(esInicial);
		this.setActivarid_sucursalPresupuestoProducto(esInicial);
		this.setActivarid_ejercicioPresupuestoProducto(esInicial);
		this.setActivarid_periodoPresupuestoProducto(esInicial);
		this.setActivarid_cuenta_contablePresupuestoProducto(esInicial);
		this.setActivarid_bodegaPresupuestoProducto(esInicial);
		this.setActivarid_productoPresupuestoProducto(esInicial);
		this.setActivarvalor_ingresoPresupuestoProducto(esInicial);
		this.setActivarvalor_egresoPresupuestoProducto(esInicial);
		this.setActivarcantidad_ingresoPresupuestoProducto(esInicial);
		this.setActivarcantidad_egresoPresupuestoProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.ID)) {
				this.setActivaridPresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalPresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioPresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoPresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contablePresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaPresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoPresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.VALORINGRESO)) {
				this.setActivarvalor_ingresoPresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.VALOREGRESO)) {
				this.setActivarvalor_egresoPresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.CANTIDADINGRESO)) {
				this.setActivarcantidad_ingresoPresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.CANTIDADEGRESO)) {
				this.setActivarcantidad_egresoPresupuestoProducto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PresupuestoProductoBeanSwingJInternalFrame presupuestoproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPresupuestoProducto(esInicial);
		this.setResaltarid_empresaPresupuestoProducto(esInicial);
		this.setResaltarid_sucursalPresupuestoProducto(esInicial);
		this.setResaltarid_ejercicioPresupuestoProducto(esInicial);
		this.setResaltarid_periodoPresupuestoProducto(esInicial);
		this.setResaltarid_cuenta_contablePresupuestoProducto(esInicial);
		this.setResaltarid_bodegaPresupuestoProducto(esInicial);
		this.setResaltarid_productoPresupuestoProducto(esInicial);
		this.setResaltarvalor_ingresoPresupuestoProducto(esInicial);
		this.setResaltarvalor_egresoPresupuestoProducto(esInicial);
		this.setResaltarcantidad_ingresoPresupuestoProducto(esInicial);
		this.setResaltarcantidad_egresoPresupuestoProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.ID)) {
				this.setResaltaridPresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalPresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioPresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoPresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contablePresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaPresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoPresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.VALORINGRESO)) {
				this.setResaltarvalor_ingresoPresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.VALOREGRESO)) {
				this.setResaltarvalor_egresoPresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.CANTIDADINGRESO)) {
				this.setResaltarcantidad_ingresoPresupuestoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoProductoConstantesFunciones.CANTIDADEGRESO)) {
				this.setResaltarcantidad_egresoPresupuestoProducto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PresupuestoProductoBeanSwingJInternalFrame presupuestoproductoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaPresupuestoProducto=true;

	public Boolean getMostrarFK_IdBodegaPresupuestoProducto() {
		return this.mostrarFK_IdBodegaPresupuestoProducto;
	}

	public void setMostrarFK_IdBodegaPresupuestoProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaPresupuestoProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContablePresupuestoProducto=true;

	public Boolean getMostrarFK_IdCuentaContablePresupuestoProducto() {
		return this.mostrarFK_IdCuentaContablePresupuestoProducto;
	}

	public void setMostrarFK_IdCuentaContablePresupuestoProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContablePresupuestoProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioPresupuestoProducto=true;

	public Boolean getMostrarFK_IdEjercicioPresupuestoProducto() {
		return this.mostrarFK_IdEjercicioPresupuestoProducto;
	}

	public void setMostrarFK_IdEjercicioPresupuestoProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioPresupuestoProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaPresupuestoProducto=true;

	public Boolean getMostrarFK_IdEmpresaPresupuestoProducto() {
		return this.mostrarFK_IdEmpresaPresupuestoProducto;
	}

	public void setMostrarFK_IdEmpresaPresupuestoProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPresupuestoProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoPresupuestoProducto=true;

	public Boolean getMostrarFK_IdPeriodoPresupuestoProducto() {
		return this.mostrarFK_IdPeriodoPresupuestoProducto;
	}

	public void setMostrarFK_IdPeriodoPresupuestoProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoPresupuestoProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoPresupuestoProducto=true;

	public Boolean getMostrarFK_IdProductoPresupuestoProducto() {
		return this.mostrarFK_IdProductoPresupuestoProducto;
	}

	public void setMostrarFK_IdProductoPresupuestoProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoPresupuestoProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalPresupuestoProducto=true;

	public Boolean getMostrarFK_IdSucursalPresupuestoProducto() {
		return this.mostrarFK_IdSucursalPresupuestoProducto;
	}

	public void setMostrarFK_IdSucursalPresupuestoProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalPresupuestoProducto= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaPresupuestoProducto=true;

	public Boolean getActivarFK_IdBodegaPresupuestoProducto() {
		return this.activarFK_IdBodegaPresupuestoProducto;
	}

	public void setActivarFK_IdBodegaPresupuestoProducto(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaPresupuestoProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContablePresupuestoProducto=true;

	public Boolean getActivarFK_IdCuentaContablePresupuestoProducto() {
		return this.activarFK_IdCuentaContablePresupuestoProducto;
	}

	public void setActivarFK_IdCuentaContablePresupuestoProducto(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContablePresupuestoProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioPresupuestoProducto=true;

	public Boolean getActivarFK_IdEjercicioPresupuestoProducto() {
		return this.activarFK_IdEjercicioPresupuestoProducto;
	}

	public void setActivarFK_IdEjercicioPresupuestoProducto(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioPresupuestoProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaPresupuestoProducto=true;

	public Boolean getActivarFK_IdEmpresaPresupuestoProducto() {
		return this.activarFK_IdEmpresaPresupuestoProducto;
	}

	public void setActivarFK_IdEmpresaPresupuestoProducto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPresupuestoProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoPresupuestoProducto=true;

	public Boolean getActivarFK_IdPeriodoPresupuestoProducto() {
		return this.activarFK_IdPeriodoPresupuestoProducto;
	}

	public void setActivarFK_IdPeriodoPresupuestoProducto(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoPresupuestoProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoPresupuestoProducto=true;

	public Boolean getActivarFK_IdProductoPresupuestoProducto() {
		return this.activarFK_IdProductoPresupuestoProducto;
	}

	public void setActivarFK_IdProductoPresupuestoProducto(Boolean habilitarResaltar) {
		this.activarFK_IdProductoPresupuestoProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalPresupuestoProducto=true;

	public Boolean getActivarFK_IdSucursalPresupuestoProducto() {
		return this.activarFK_IdSucursalPresupuestoProducto;
	}

	public void setActivarFK_IdSucursalPresupuestoProducto(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalPresupuestoProducto= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaPresupuestoProducto=null;

	public Border getResaltarFK_IdBodegaPresupuestoProducto() {
		return this.resaltarFK_IdBodegaPresupuestoProducto;
	}

	public void setResaltarFK_IdBodegaPresupuestoProducto(Border borderResaltar) {
		this.resaltarFK_IdBodegaPresupuestoProducto= borderResaltar;
	}

	public void setResaltarFK_IdBodegaPresupuestoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoProductoBeanSwingJInternalFrame presupuestoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaPresupuestoProducto= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContablePresupuestoProducto=null;

	public Border getResaltarFK_IdCuentaContablePresupuestoProducto() {
		return this.resaltarFK_IdCuentaContablePresupuestoProducto;
	}

	public void setResaltarFK_IdCuentaContablePresupuestoProducto(Border borderResaltar) {
		this.resaltarFK_IdCuentaContablePresupuestoProducto= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContablePresupuestoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoProductoBeanSwingJInternalFrame presupuestoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContablePresupuestoProducto= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioPresupuestoProducto=null;

	public Border getResaltarFK_IdEjercicioPresupuestoProducto() {
		return this.resaltarFK_IdEjercicioPresupuestoProducto;
	}

	public void setResaltarFK_IdEjercicioPresupuestoProducto(Border borderResaltar) {
		this.resaltarFK_IdEjercicioPresupuestoProducto= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioPresupuestoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoProductoBeanSwingJInternalFrame presupuestoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioPresupuestoProducto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaPresupuestoProducto=null;

	public Border getResaltarFK_IdEmpresaPresupuestoProducto() {
		return this.resaltarFK_IdEmpresaPresupuestoProducto;
	}

	public void setResaltarFK_IdEmpresaPresupuestoProducto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPresupuestoProducto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPresupuestoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoProductoBeanSwingJInternalFrame presupuestoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPresupuestoProducto= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoPresupuestoProducto=null;

	public Border getResaltarFK_IdPeriodoPresupuestoProducto() {
		return this.resaltarFK_IdPeriodoPresupuestoProducto;
	}

	public void setResaltarFK_IdPeriodoPresupuestoProducto(Border borderResaltar) {
		this.resaltarFK_IdPeriodoPresupuestoProducto= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoPresupuestoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoProductoBeanSwingJInternalFrame presupuestoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoPresupuestoProducto= borderResaltar;
	}

	public Border resaltarFK_IdProductoPresupuestoProducto=null;

	public Border getResaltarFK_IdProductoPresupuestoProducto() {
		return this.resaltarFK_IdProductoPresupuestoProducto;
	}

	public void setResaltarFK_IdProductoPresupuestoProducto(Border borderResaltar) {
		this.resaltarFK_IdProductoPresupuestoProducto= borderResaltar;
	}

	public void setResaltarFK_IdProductoPresupuestoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoProductoBeanSwingJInternalFrame presupuestoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoPresupuestoProducto= borderResaltar;
	}

	public Border resaltarFK_IdSucursalPresupuestoProducto=null;

	public Border getResaltarFK_IdSucursalPresupuestoProducto() {
		return this.resaltarFK_IdSucursalPresupuestoProducto;
	}

	public void setResaltarFK_IdSucursalPresupuestoProducto(Border borderResaltar) {
		this.resaltarFK_IdSucursalPresupuestoProducto= borderResaltar;
	}

	public void setResaltarFK_IdSucursalPresupuestoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoProductoBeanSwingJInternalFrame presupuestoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalPresupuestoProducto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}