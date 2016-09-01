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


import com.bydan.erp.inventario.util.CostoConstantesFunciones;
import com.bydan.erp.inventario.util.CostoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.CostoParameterGeneral;

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
final public class CostoConstantesFunciones extends CostoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Costo";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Costo"+CostoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CostoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CostoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CostoConstantesFunciones.SCHEMA+"_"+CostoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CostoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CostoConstantesFunciones.SCHEMA+"_"+CostoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CostoConstantesFunciones.SCHEMA+"_"+CostoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CostoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CostoConstantesFunciones.SCHEMA+"_"+CostoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CostoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CostoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CostoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CostoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CostoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CostoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CostoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CostoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CostoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CostoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Costos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Costo";
	public static final String SCLASSWEBTITULO_LOWER="Costo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Costo";
	public static final String OBJECTNAME="costo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="costo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select costo from "+CostoConstantesFunciones.SPERSISTENCENAME+" costo";
	public static String QUERYSELECTNATIVE="select "+CostoConstantesFunciones.SCHEMA+"."+CostoConstantesFunciones.TABLENAME+".id,"+CostoConstantesFunciones.SCHEMA+"."+CostoConstantesFunciones.TABLENAME+".version_row,"+CostoConstantesFunciones.SCHEMA+"."+CostoConstantesFunciones.TABLENAME+".id_empresa,"+CostoConstantesFunciones.SCHEMA+"."+CostoConstantesFunciones.TABLENAME+".id_sucursal,"+CostoConstantesFunciones.SCHEMA+"."+CostoConstantesFunciones.TABLENAME+".id_bodega,"+CostoConstantesFunciones.SCHEMA+"."+CostoConstantesFunciones.TABLENAME+".id_producto,"+CostoConstantesFunciones.SCHEMA+"."+CostoConstantesFunciones.TABLENAME+".id_periodo,"+CostoConstantesFunciones.SCHEMA+"."+CostoConstantesFunciones.TABLENAME+".id_ejercicio,"+CostoConstantesFunciones.SCHEMA+"."+CostoConstantesFunciones.TABLENAME+".id_detalle_movimiento_inventario,"+CostoConstantesFunciones.SCHEMA+"."+CostoConstantesFunciones.TABLENAME+".id_tipo_costo,"+CostoConstantesFunciones.SCHEMA+"."+CostoConstantesFunciones.TABLENAME+".numero_comprobante,"+CostoConstantesFunciones.SCHEMA+"."+CostoConstantesFunciones.TABLENAME+".fecha,"+CostoConstantesFunciones.SCHEMA+"."+CostoConstantesFunciones.TABLENAME+".cantidad,"+CostoConstantesFunciones.SCHEMA+"."+CostoConstantesFunciones.TABLENAME+".valor_unitario,"+CostoConstantesFunciones.SCHEMA+"."+CostoConstantesFunciones.TABLENAME+".valor_total,"+CostoConstantesFunciones.SCHEMA+"."+CostoConstantesFunciones.TABLENAME+".id_anio,"+CostoConstantesFunciones.SCHEMA+"."+CostoConstantesFunciones.TABLENAME+".id_mes from "+CostoConstantesFunciones.SCHEMA+"."+CostoConstantesFunciones.TABLENAME;//+" as "+CostoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CostoConstantesFuncionesAdditional costoConstantesFuncionesAdditional=null;
	
	public CostoConstantesFuncionesAdditional getCostoConstantesFuncionesAdditional() {
		return this.costoConstantesFuncionesAdditional;
	}
	
	public void setCostoConstantesFuncionesAdditional(CostoConstantesFuncionesAdditional costoConstantesFuncionesAdditional) {
		try {
			this.costoConstantesFuncionesAdditional=costoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDDETALLEMOVIMIENTOINVENTARIO= "id_detalle_movimiento_inventario";
    public static final String IDTIPOCOSTO= "id_tipo_costo";
    public static final String NUMEROCOMPROBANTE= "numero_comprobante";
    public static final String FECHA= "fecha";
    public static final String CANTIDAD= "cantidad";
    public static final String VALORUNITARIO= "valor_unitario";
    public static final String VALORTOTAL= "valor_total";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDDETALLEMOVIMIENTOINVENTARIO= "Detalle Movimiento Inventario";
		public static final String LABEL_IDDETALLEMOVIMIENTOINVENTARIO_LOWER= "Detalle Movimiento Inventario";
    	public static final String LABEL_IDTIPOCOSTO= "Tipo Costo";
		public static final String LABEL_IDTIPOCOSTO_LOWER= "Tipo Costo";
    	public static final String LABEL_NUMEROCOMPROBANTE= "Numero Comprobante";
		public static final String LABEL_NUMEROCOMPROBANTE_LOWER= "Numero Comprobante";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_CANTIDAD= "Cantidad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_VALORUNITARIO= "Valor Unitario";
		public static final String LABEL_VALORUNITARIO_LOWER= "Valor Unitario";
    	public static final String LABEL_VALORTOTAL= "Valor Total";
		public static final String LABEL_VALORTOTAL_LOWER= "Valor Total";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getCostoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CostoConstantesFunciones.IDEMPRESA)) {sLabelColumna=CostoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CostoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=CostoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(CostoConstantesFunciones.IDBODEGA)) {sLabelColumna=CostoConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(CostoConstantesFunciones.IDPRODUCTO)) {sLabelColumna=CostoConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(CostoConstantesFunciones.IDPERIODO)) {sLabelColumna=CostoConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(CostoConstantesFunciones.IDEJERCICIO)) {sLabelColumna=CostoConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(CostoConstantesFunciones.IDDETALLEMOVIMIENTOINVENTARIO)) {sLabelColumna=CostoConstantesFunciones.LABEL_IDDETALLEMOVIMIENTOINVENTARIO;}
		if(sNombreColumna.equals(CostoConstantesFunciones.IDTIPOCOSTO)) {sLabelColumna=CostoConstantesFunciones.LABEL_IDTIPOCOSTO;}
		if(sNombreColumna.equals(CostoConstantesFunciones.NUMEROCOMPROBANTE)) {sLabelColumna=CostoConstantesFunciones.LABEL_NUMEROCOMPROBANTE;}
		if(sNombreColumna.equals(CostoConstantesFunciones.FECHA)) {sLabelColumna=CostoConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(CostoConstantesFunciones.CANTIDAD)) {sLabelColumna=CostoConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(CostoConstantesFunciones.VALORUNITARIO)) {sLabelColumna=CostoConstantesFunciones.LABEL_VALORUNITARIO;}
		if(sNombreColumna.equals(CostoConstantesFunciones.VALORTOTAL)) {sLabelColumna=CostoConstantesFunciones.LABEL_VALORTOTAL;}
		if(sNombreColumna.equals(CostoConstantesFunciones.IDANIO)) {sLabelColumna=CostoConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(CostoConstantesFunciones.IDMES)) {sLabelColumna=CostoConstantesFunciones.LABEL_IDMES;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getCostoDescripcion(Costo costo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(costo !=null/* && costo.getId()!=0*/) {
			if(costo.getId()!=null) {
				sDescripcion=costo.getId().toString();
			}//costocosto.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getCostoDescripcionDetallado(Costo costo) {
		String sDescripcion="";
			
		sDescripcion+=CostoConstantesFunciones.ID+"=";
		sDescripcion+=costo.getId().toString()+",";
		sDescripcion+=CostoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=costo.getVersionRow().toString()+",";
		sDescripcion+=CostoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=costo.getid_empresa().toString()+",";
		sDescripcion+=CostoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=costo.getid_sucursal().toString()+",";
		sDescripcion+=CostoConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=costo.getid_bodega().toString()+",";
		sDescripcion+=CostoConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=costo.getid_producto().toString()+",";
		sDescripcion+=CostoConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=costo.getid_periodo().toString()+",";
		sDescripcion+=CostoConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=costo.getid_ejercicio().toString()+",";
		sDescripcion+=CostoConstantesFunciones.IDDETALLEMOVIMIENTOINVENTARIO+"=";
		sDescripcion+=costo.getid_detalle_movimiento_inventario().toString()+",";
		sDescripcion+=CostoConstantesFunciones.IDTIPOCOSTO+"=";
		sDescripcion+=costo.getid_tipo_costo().toString()+",";
		sDescripcion+=CostoConstantesFunciones.NUMEROCOMPROBANTE+"=";
		sDescripcion+=costo.getnumero_comprobante().toString()+",";
		sDescripcion+=CostoConstantesFunciones.FECHA+"=";
		sDescripcion+=costo.getfecha().toString()+",";
		sDescripcion+=CostoConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=costo.getcantidad().toString()+",";
		sDescripcion+=CostoConstantesFunciones.VALORUNITARIO+"=";
		sDescripcion+=costo.getvalor_unitario().toString()+",";
		sDescripcion+=CostoConstantesFunciones.VALORTOTAL+"=";
		sDescripcion+=costo.getvalor_total().toString()+",";
		sDescripcion+=CostoConstantesFunciones.IDANIO+"=";
		sDescripcion+=costo.getid_anio().toString()+",";
		sDescripcion+=CostoConstantesFunciones.IDMES+"=";
		sDescripcion+=costo.getid_mes().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCostoDescripcion(Costo costo,String sValor) throws Exception {			
		if(costo !=null) {
			//costocosto.getId().toString();
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

	public static String getPeriodoDescripcion(Periodo periodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periodo!=null/*&&periodo.getId()>0*/) {
			sDescripcion=PeriodoConstantesFunciones.getPeriodoDescripcion(periodo);
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

	public static String getDetalleMovimientoInventarioDescripcion(DetalleMovimientoInventario detallemovimientoinventario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(detallemovimientoinventario!=null/*&&detallemovimientoinventario.getId()>0*/) {
			sDescripcion=DetalleMovimientoInventarioConstantesFunciones.getDetalleMovimientoInventarioDescripcion(detallemovimientoinventario);
		}

		return sDescripcion;
	}

	public static String getTipoCostoDescripcion(TipoCosto tipocosto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocosto!=null/*&&tipocosto.getId()>0*/) {
			sDescripcion=TipoCostoConstantesFunciones.getTipoCostoDescripcion(tipocosto);
		}

		return sDescripcion;
	}

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdBodega")) {
			sNombreIndice="Tipo=  Por Bodega";
		} else if(sNombreIndice.equals("FK_IdDetalleMovimientoInventario")) {
			sNombreIndice="Tipo=  Por Detalle Movimiento Inventario";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoCosto")) {
			sNombreIndice="Tipo=  Por Tipo Costo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBodega(Long id_bodega) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdDetalleMovimientoInventario(Long id_detalle_movimiento_inventario) {
		String sDetalleIndice=" Parametros->";
		if(id_detalle_movimiento_inventario!=null) {sDetalleIndice+=" Codigo Unico De Detalle Movimiento Inventario="+id_detalle_movimiento_inventario.toString();} 

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

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

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

	public static String getDetalleIndiceFK_IdTipoCosto(Long id_tipo_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_costo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Costo="+id_tipo_costo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCosto(Costo costo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosCostos(List<Costo> costos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Costo costo: costos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCosto(Costo costo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && costo.getConCambioAuxiliar()) {
			costo.setIsDeleted(costo.getIsDeletedAuxiliar());	
			costo.setIsNew(costo.getIsNewAuxiliar());	
			costo.setIsChanged(costo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			costo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			costo.setIsDeletedAuxiliar(false);	
			costo.setIsNewAuxiliar(false);	
			costo.setIsChangedAuxiliar(false);
			
			costo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCostos(List<Costo> costos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Costo costo : costos) {
			if(conAsignarBase && costo.getConCambioAuxiliar()) {
				costo.setIsDeleted(costo.getIsDeletedAuxiliar());	
				costo.setIsNew(costo.getIsNewAuxiliar());	
				costo.setIsChanged(costo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				costo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				costo.setIsDeletedAuxiliar(false);	
				costo.setIsNewAuxiliar(false);	
				costo.setIsChangedAuxiliar(false);
				
				costo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCosto(Costo costo,Boolean conEnteros) throws Exception  {
		costo.setvalor_unitario(0.0);
		costo.setvalor_total(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			costo.setnumero_comprobante(0L);
			costo.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresCostos(List<Costo> costos,Boolean conEnteros) throws Exception  {
		
		for(Costo costo: costos) {
			costo.setvalor_unitario(0.0);
			costo.setvalor_total(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				costo.setnumero_comprobante(0L);
				costo.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaCosto(List<Costo> costos,Costo costoAux) throws Exception  {
		CostoConstantesFunciones.InicializarValoresCosto(costoAux,true);
		
		for(Costo costo: costos) {
			if(costo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			costoAux.setnumero_comprobante(costoAux.getnumero_comprobante()+costo.getnumero_comprobante());			
			costoAux.setcantidad(costoAux.getcantidad()+costo.getcantidad());			
			costoAux.setvalor_unitario(costoAux.getvalor_unitario()+costo.getvalor_unitario());			
			costoAux.setvalor_total(costoAux.getvalor_total()+costo.getvalor_total());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCosto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CostoConstantesFunciones.getArrayColumnasGlobalesCosto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCosto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CostoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CostoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CostoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CostoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CostoConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CostoConstantesFunciones.IDPERIODO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CostoConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CostoConstantesFunciones.IDEJERCICIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCosto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Costo> costos,Costo costo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Costo costoAux: costos) {
			if(costoAux!=null && costo!=null) {
				if((costoAux.getId()==null && costo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(costoAux.getId()!=null && costo.getId()!=null){
					if(costoAux.getId().equals(costo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCosto(List<Costo> costos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_unitarioTotal=0.0;
		Double valor_totalTotal=0.0;
	
		for(Costo costo: costos) {			
			if(costo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_unitarioTotal+=costo.getvalor_unitario();
			valor_totalTotal+=costo.getvalor_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CostoConstantesFunciones.VALORUNITARIO);
		datoGeneral.setsDescripcion(CostoConstantesFunciones.LABEL_VALORUNITARIO);
		datoGeneral.setdValorDouble(valor_unitarioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CostoConstantesFunciones.VALORTOTAL);
		datoGeneral.setsDescripcion(CostoConstantesFunciones.LABEL_VALORTOTAL);
		datoGeneral.setdValorDouble(valor_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCosto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CostoConstantesFunciones.LABEL_ID, CostoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CostoConstantesFunciones.LABEL_VERSIONROW, CostoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CostoConstantesFunciones.LABEL_IDEMPRESA, CostoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CostoConstantesFunciones.LABEL_IDSUCURSAL, CostoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CostoConstantesFunciones.LABEL_IDBODEGA, CostoConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CostoConstantesFunciones.LABEL_IDPRODUCTO, CostoConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CostoConstantesFunciones.LABEL_IDPERIODO, CostoConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CostoConstantesFunciones.LABEL_IDEJERCICIO, CostoConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CostoConstantesFunciones.LABEL_IDDETALLEMOVIMIENTOINVENTARIO, CostoConstantesFunciones.IDDETALLEMOVIMIENTOINVENTARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CostoConstantesFunciones.LABEL_IDTIPOCOSTO, CostoConstantesFunciones.IDTIPOCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CostoConstantesFunciones.LABEL_NUMEROCOMPROBANTE, CostoConstantesFunciones.NUMEROCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CostoConstantesFunciones.LABEL_FECHA, CostoConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CostoConstantesFunciones.LABEL_CANTIDAD, CostoConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CostoConstantesFunciones.LABEL_VALORUNITARIO, CostoConstantesFunciones.VALORUNITARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CostoConstantesFunciones.LABEL_VALORTOTAL, CostoConstantesFunciones.VALORTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CostoConstantesFunciones.LABEL_IDANIO, CostoConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CostoConstantesFunciones.LABEL_IDMES, CostoConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCosto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CostoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CostoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CostoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CostoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CostoConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CostoConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CostoConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CostoConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CostoConstantesFunciones.IDDETALLEMOVIMIENTOINVENTARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CostoConstantesFunciones.IDTIPOCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CostoConstantesFunciones.NUMEROCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CostoConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CostoConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CostoConstantesFunciones.VALORUNITARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CostoConstantesFunciones.VALORTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CostoConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CostoConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCosto() throws Exception  {
		return CostoConstantesFunciones.getTiposSeleccionarCosto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCosto(Boolean conFk) throws Exception  {
		return CostoConstantesFunciones.getTiposSeleccionarCosto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCosto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CostoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CostoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CostoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(CostoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CostoConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(CostoConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CostoConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(CostoConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CostoConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(CostoConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CostoConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(CostoConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CostoConstantesFunciones.LABEL_IDDETALLEMOVIMIENTOINVENTARIO);
			reporte.setsDescripcion(CostoConstantesFunciones.LABEL_IDDETALLEMOVIMIENTOINVENTARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CostoConstantesFunciones.LABEL_IDTIPOCOSTO);
			reporte.setsDescripcion(CostoConstantesFunciones.LABEL_IDTIPOCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CostoConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
			reporte.setsDescripcion(CostoConstantesFunciones.LABEL_NUMEROCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CostoConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(CostoConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CostoConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(CostoConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CostoConstantesFunciones.LABEL_VALORUNITARIO);
			reporte.setsDescripcion(CostoConstantesFunciones.LABEL_VALORUNITARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CostoConstantesFunciones.LABEL_VALORTOTAL);
			reporte.setsDescripcion(CostoConstantesFunciones.LABEL_VALORTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CostoConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(CostoConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CostoConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(CostoConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCosto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCosto(Costo costoAux) throws Exception {
		
			costoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(costoAux.getEmpresa()));
			costoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(costoAux.getSucursal()));
			costoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(costoAux.getBodega()));
			costoAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(costoAux.getProducto()));
			costoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(costoAux.getPeriodo()));
			costoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(costoAux.getEjercicio()));
			costoAux.setdetallemovimientoinventario_descripcion(DetalleMovimientoInventarioConstantesFunciones.getDetalleMovimientoInventarioDescripcion(costoAux.getDetalleMovimientoInventario()));
			costoAux.settipocosto_descripcion(TipoCostoConstantesFunciones.getTipoCostoDescripcion(costoAux.getTipoCosto()));
			costoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(costoAux.getAnio()));
			costoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(costoAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCosto(List<Costo> costosTemp) throws Exception {
		for(Costo costoAux:costosTemp) {
			
			costoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(costoAux.getEmpresa()));
			costoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(costoAux.getSucursal()));
			costoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(costoAux.getBodega()));
			costoAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(costoAux.getProducto()));
			costoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(costoAux.getPeriodo()));
			costoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(costoAux.getEjercicio()));
			costoAux.setdetallemovimientoinventario_descripcion(DetalleMovimientoInventarioConstantesFunciones.getDetalleMovimientoInventarioDescripcion(costoAux.getDetalleMovimientoInventario()));
			costoAux.settipocosto_descripcion(TipoCostoConstantesFunciones.getTipoCostoDescripcion(costoAux.getTipoCosto()));
			costoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(costoAux.getAnio()));
			costoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(costoAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCosto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(DetalleMovimientoInventario.class));
				classes.add(new Classe(TipoCosto.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				
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
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleMovimientoInventario.class)) {
						classes.add(new Classe(DetalleMovimientoInventario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCosto.class)) {
						classes.add(new Classe(TipoCosto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCosto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(DetalleMovimientoInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleMovimientoInventario.class)); continue;
					}

					if(TipoCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCosto.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(DetalleMovimientoInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleMovimientoInventario.class)); continue;
					}

					if(TipoCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCosto.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCosto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CostoConstantesFunciones.getClassesRelationshipsOfCosto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCosto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCosto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CostoConstantesFunciones.getClassesRelationshipsFromStringsOfCosto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCosto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Costo costo,List<Costo> costos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Costo costoEncontrado=null;
			
			for(Costo costoLocal:costos) {
				if(costoLocal.getId().equals(costo.getId())) {
					costoEncontrado=costoLocal;
					
					costoLocal.setIsChanged(costo.getIsChanged());
					costoLocal.setIsNew(costo.getIsNew());
					costoLocal.setIsDeleted(costo.getIsDeleted());
					
					costoLocal.setGeneralEntityOriginal(costo.getGeneralEntityOriginal());
					
					costoLocal.setId(costo.getId());	
					costoLocal.setVersionRow(costo.getVersionRow());	
					costoLocal.setid_empresa(costo.getid_empresa());	
					costoLocal.setid_sucursal(costo.getid_sucursal());	
					costoLocal.setid_bodega(costo.getid_bodega());	
					costoLocal.setid_producto(costo.getid_producto());	
					costoLocal.setid_periodo(costo.getid_periodo());	
					costoLocal.setid_ejercicio(costo.getid_ejercicio());	
					costoLocal.setid_detalle_movimiento_inventario(costo.getid_detalle_movimiento_inventario());	
					costoLocal.setid_tipo_costo(costo.getid_tipo_costo());	
					costoLocal.setnumero_comprobante(costo.getnumero_comprobante());	
					costoLocal.setfecha(costo.getfecha());	
					costoLocal.setcantidad(costo.getcantidad());	
					costoLocal.setvalor_unitario(costo.getvalor_unitario());	
					costoLocal.setvalor_total(costo.getvalor_total());	
					costoLocal.setid_anio(costo.getid_anio());	
					costoLocal.setid_mes(costo.getid_mes());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!costo.getIsDeleted()) {
				if(!existe) {
					costos.add(costo);
				}
			} else {
				if(costoEncontrado!=null && permiteQuitar)  {
					costos.remove(costoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Costo costo,List<Costo> costos) throws Exception {
		try	{			
			for(Costo costoLocal:costos) {
				if(costoLocal.getId().equals(costo.getId())) {
					costoLocal.setIsSelected(costo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCosto(List<Costo> costosAux) throws Exception {
		//this.costosAux=costosAux;
		
		for(Costo costoAux:costosAux) {
			if(costoAux.getIsChanged()) {
				costoAux.setIsChanged(false);
			}		
			
			if(costoAux.getIsNew()) {
				costoAux.setIsNew(false);
			}	
			
			if(costoAux.getIsDeleted()) {
				costoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCosto(Costo costoAux) throws Exception {
		//this.costoAux=costoAux;
		
			if(costoAux.getIsChanged()) {
				costoAux.setIsChanged(false);
			}		
			
			if(costoAux.getIsNew()) {
				costoAux.setIsNew(false);
			}	
			
			if(costoAux.getIsDeleted()) {
				costoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Costo costoAsignar,Costo costo) throws Exception {
		costoAsignar.setId(costo.getId());	
		costoAsignar.setVersionRow(costo.getVersionRow());	
		costoAsignar.setid_empresa(costo.getid_empresa());
		costoAsignar.setempresa_descripcion(costo.getempresa_descripcion());	
		costoAsignar.setid_sucursal(costo.getid_sucursal());
		costoAsignar.setsucursal_descripcion(costo.getsucursal_descripcion());	
		costoAsignar.setid_bodega(costo.getid_bodega());
		costoAsignar.setbodega_descripcion(costo.getbodega_descripcion());	
		costoAsignar.setid_producto(costo.getid_producto());
		costoAsignar.setproducto_descripcion(costo.getproducto_descripcion());	
		costoAsignar.setid_periodo(costo.getid_periodo());
		costoAsignar.setperiodo_descripcion(costo.getperiodo_descripcion());	
		costoAsignar.setid_ejercicio(costo.getid_ejercicio());
		costoAsignar.setejercicio_descripcion(costo.getejercicio_descripcion());	
		costoAsignar.setid_detalle_movimiento_inventario(costo.getid_detalle_movimiento_inventario());
		costoAsignar.setdetallemovimientoinventario_descripcion(costo.getdetallemovimientoinventario_descripcion());	
		costoAsignar.setid_tipo_costo(costo.getid_tipo_costo());
		costoAsignar.settipocosto_descripcion(costo.gettipocosto_descripcion());	
		costoAsignar.setnumero_comprobante(costo.getnumero_comprobante());	
		costoAsignar.setfecha(costo.getfecha());	
		costoAsignar.setcantidad(costo.getcantidad());	
		costoAsignar.setvalor_unitario(costo.getvalor_unitario());	
		costoAsignar.setvalor_total(costo.getvalor_total());	
		costoAsignar.setid_anio(costo.getid_anio());
		costoAsignar.setanio_descripcion(costo.getanio_descripcion());	
		costoAsignar.setid_mes(costo.getid_mes());
		costoAsignar.setmes_descripcion(costo.getmes_descripcion());	
	}
	
	public static void inicializarCosto(Costo costo) throws Exception {
		try {
				costo.setId(0L);	
					
				costo.setid_empresa(-1L);	
				costo.setid_sucursal(-1L);	
				costo.setid_bodega(-1L);	
				costo.setid_producto(-1L);	
				costo.setid_periodo(-1L);	
				costo.setid_ejercicio(-1L);	
				costo.setid_detalle_movimiento_inventario(-1L);	
				costo.setid_tipo_costo(-1L);	
				costo.setnumero_comprobante(0L);	
				costo.setfecha(new Date());	
				costo.setcantidad(0);	
				costo.setvalor_unitario(0.0);	
				costo.setvalor_total(0.0);	
				costo.setid_anio(null);	
				costo.setid_mes(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCosto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CostoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CostoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CostoConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CostoConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CostoConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CostoConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CostoConstantesFunciones.LABEL_IDDETALLEMOVIMIENTOINVENTARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CostoConstantesFunciones.LABEL_IDTIPOCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CostoConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CostoConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CostoConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CostoConstantesFunciones.LABEL_VALORUNITARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CostoConstantesFunciones.LABEL_VALORTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CostoConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CostoConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCosto(String sTipo,Row row,Workbook workbook,Costo costo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(costo.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(costo.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(costo.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(costo.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(costo.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(costo.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(costo.getdetallemovimientoinventario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(costo.gettipocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(costo.getnumero_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(costo.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(costo.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(costo.getvalor_unitario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(costo.getvalor_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(costo.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(costo.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCosto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCosto() {
		return this.sFinalQueryCosto;
	}
	
	public void setsFinalQueryCosto(String sFinalQueryCosto) {
		this.sFinalQueryCosto= sFinalQueryCosto;
	}
	
	public Border resaltarSeleccionarCosto=null;
	
	public Border setResaltarSeleccionarCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CostoBeanSwingJInternalFrame costoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//costoBeanSwingJInternalFrame.jTtoolBarCosto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCosto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCosto() {
		return this.resaltarSeleccionarCosto;
	}
	
	public void setResaltarSeleccionarCosto(Border borderResaltarSeleccionarCosto) {
		this.resaltarSeleccionarCosto= borderResaltarSeleccionarCosto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCosto=null;
	public Boolean mostraridCosto=true;
	public Boolean activaridCosto=true;

	public Border resaltarid_empresaCosto=null;
	public Boolean mostrarid_empresaCosto=true;
	public Boolean activarid_empresaCosto=true;
	public Boolean cargarid_empresaCosto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCosto=false;//ConEventDepend=true

	public Border resaltarid_sucursalCosto=null;
	public Boolean mostrarid_sucursalCosto=true;
	public Boolean activarid_sucursalCosto=true;
	public Boolean cargarid_sucursalCosto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalCosto=false;//ConEventDepend=true

	public Border resaltarid_bodegaCosto=null;
	public Boolean mostrarid_bodegaCosto=true;
	public Boolean activarid_bodegaCosto=true;
	public Boolean cargarid_bodegaCosto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaCosto=false;//ConEventDepend=true

	public Border resaltarid_productoCosto=null;
	public Boolean mostrarid_productoCosto=true;
	public Boolean activarid_productoCosto=true;
	public Boolean cargarid_productoCosto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoCosto=false;//ConEventDepend=true

	public Border resaltarid_periodoCosto=null;
	public Boolean mostrarid_periodoCosto=true;
	public Boolean activarid_periodoCosto=true;
	public Boolean cargarid_periodoCosto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoCosto=false;//ConEventDepend=true

	public Border resaltarid_ejercicioCosto=null;
	public Boolean mostrarid_ejercicioCosto=true;
	public Boolean activarid_ejercicioCosto=true;
	public Boolean cargarid_ejercicioCosto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioCosto=false;//ConEventDepend=true

	public Border resaltarid_detalle_movimiento_inventarioCosto=null;
	public Boolean mostrarid_detalle_movimiento_inventarioCosto=true;
	public Boolean activarid_detalle_movimiento_inventarioCosto=true;
	public Boolean cargarid_detalle_movimiento_inventarioCosto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_detalle_movimiento_inventarioCosto=false;//ConEventDepend=true

	public Border resaltarid_tipo_costoCosto=null;
	public Boolean mostrarid_tipo_costoCosto=true;
	public Boolean activarid_tipo_costoCosto=true;
	public Boolean cargarid_tipo_costoCosto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_costoCosto=false;//ConEventDepend=true

	public Border resaltarnumero_comprobanteCosto=null;
	public Boolean mostrarnumero_comprobanteCosto=true;
	public Boolean activarnumero_comprobanteCosto=true;

	public Border resaltarfechaCosto=null;
	public Boolean mostrarfechaCosto=true;
	public Boolean activarfechaCosto=false;

	public Border resaltarcantidadCosto=null;
	public Boolean mostrarcantidadCosto=true;
	public Boolean activarcantidadCosto=true;

	public Border resaltarvalor_unitarioCosto=null;
	public Boolean mostrarvalor_unitarioCosto=true;
	public Boolean activarvalor_unitarioCosto=true;

	public Border resaltarvalor_totalCosto=null;
	public Boolean mostrarvalor_totalCosto=true;
	public Boolean activarvalor_totalCosto=true;

	public Border resaltarid_anioCosto=null;
	public Boolean mostrarid_anioCosto=true;
	public Boolean activarid_anioCosto=false;
	public Boolean cargarid_anioCosto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioCosto=false;//ConEventDepend=true

	public Border resaltarid_mesCosto=null;
	public Boolean mostrarid_mesCosto=true;
	public Boolean activarid_mesCosto=false;
	public Boolean cargarid_mesCosto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesCosto=false;//ConEventDepend=true

	
	

	public Border setResaltaridCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CostoBeanSwingJInternalFrame costoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//costoBeanSwingJInternalFrame.jTtoolBarCosto.setBorder(borderResaltar);
		
		this.resaltaridCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCosto() {
		return this.resaltaridCosto;
	}

	public void setResaltaridCosto(Border borderResaltar) {
		this.resaltaridCosto= borderResaltar;
	}

	public Boolean getMostraridCosto() {
		return this.mostraridCosto;
	}

	public void setMostraridCosto(Boolean mostraridCosto) {
		this.mostraridCosto= mostraridCosto;
	}

	public Boolean getActivaridCosto() {
		return this.activaridCosto;
	}

	public void setActivaridCosto(Boolean activaridCosto) {
		this.activaridCosto= activaridCosto;
	}

	public Border setResaltarid_empresaCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CostoBeanSwingJInternalFrame costoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//costoBeanSwingJInternalFrame.jTtoolBarCosto.setBorder(borderResaltar);
		
		this.resaltarid_empresaCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCosto() {
		return this.resaltarid_empresaCosto;
	}

	public void setResaltarid_empresaCosto(Border borderResaltar) {
		this.resaltarid_empresaCosto= borderResaltar;
	}

	public Boolean getMostrarid_empresaCosto() {
		return this.mostrarid_empresaCosto;
	}

	public void setMostrarid_empresaCosto(Boolean mostrarid_empresaCosto) {
		this.mostrarid_empresaCosto= mostrarid_empresaCosto;
	}

	public Boolean getActivarid_empresaCosto() {
		return this.activarid_empresaCosto;
	}

	public void setActivarid_empresaCosto(Boolean activarid_empresaCosto) {
		this.activarid_empresaCosto= activarid_empresaCosto;
	}

	public Boolean getCargarid_empresaCosto() {
		return this.cargarid_empresaCosto;
	}

	public void setCargarid_empresaCosto(Boolean cargarid_empresaCosto) {
		this.cargarid_empresaCosto= cargarid_empresaCosto;
	}

	public Border setResaltarid_sucursalCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CostoBeanSwingJInternalFrame costoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//costoBeanSwingJInternalFrame.jTtoolBarCosto.setBorder(borderResaltar);
		
		this.resaltarid_sucursalCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalCosto() {
		return this.resaltarid_sucursalCosto;
	}

	public void setResaltarid_sucursalCosto(Border borderResaltar) {
		this.resaltarid_sucursalCosto= borderResaltar;
	}

	public Boolean getMostrarid_sucursalCosto() {
		return this.mostrarid_sucursalCosto;
	}

	public void setMostrarid_sucursalCosto(Boolean mostrarid_sucursalCosto) {
		this.mostrarid_sucursalCosto= mostrarid_sucursalCosto;
	}

	public Boolean getActivarid_sucursalCosto() {
		return this.activarid_sucursalCosto;
	}

	public void setActivarid_sucursalCosto(Boolean activarid_sucursalCosto) {
		this.activarid_sucursalCosto= activarid_sucursalCosto;
	}

	public Boolean getCargarid_sucursalCosto() {
		return this.cargarid_sucursalCosto;
	}

	public void setCargarid_sucursalCosto(Boolean cargarid_sucursalCosto) {
		this.cargarid_sucursalCosto= cargarid_sucursalCosto;
	}

	public Border setResaltarid_bodegaCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CostoBeanSwingJInternalFrame costoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//costoBeanSwingJInternalFrame.jTtoolBarCosto.setBorder(borderResaltar);
		
		this.resaltarid_bodegaCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaCosto() {
		return this.resaltarid_bodegaCosto;
	}

	public void setResaltarid_bodegaCosto(Border borderResaltar) {
		this.resaltarid_bodegaCosto= borderResaltar;
	}

	public Boolean getMostrarid_bodegaCosto() {
		return this.mostrarid_bodegaCosto;
	}

	public void setMostrarid_bodegaCosto(Boolean mostrarid_bodegaCosto) {
		this.mostrarid_bodegaCosto= mostrarid_bodegaCosto;
	}

	public Boolean getActivarid_bodegaCosto() {
		return this.activarid_bodegaCosto;
	}

	public void setActivarid_bodegaCosto(Boolean activarid_bodegaCosto) {
		this.activarid_bodegaCosto= activarid_bodegaCosto;
	}

	public Boolean getCargarid_bodegaCosto() {
		return this.cargarid_bodegaCosto;
	}

	public void setCargarid_bodegaCosto(Boolean cargarid_bodegaCosto) {
		this.cargarid_bodegaCosto= cargarid_bodegaCosto;
	}

	public Border setResaltarid_productoCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CostoBeanSwingJInternalFrame costoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//costoBeanSwingJInternalFrame.jTtoolBarCosto.setBorder(borderResaltar);
		
		this.resaltarid_productoCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoCosto() {
		return this.resaltarid_productoCosto;
	}

	public void setResaltarid_productoCosto(Border borderResaltar) {
		this.resaltarid_productoCosto= borderResaltar;
	}

	public Boolean getMostrarid_productoCosto() {
		return this.mostrarid_productoCosto;
	}

	public void setMostrarid_productoCosto(Boolean mostrarid_productoCosto) {
		this.mostrarid_productoCosto= mostrarid_productoCosto;
	}

	public Boolean getActivarid_productoCosto() {
		return this.activarid_productoCosto;
	}

	public void setActivarid_productoCosto(Boolean activarid_productoCosto) {
		this.activarid_productoCosto= activarid_productoCosto;
	}

	public Boolean getCargarid_productoCosto() {
		return this.cargarid_productoCosto;
	}

	public void setCargarid_productoCosto(Boolean cargarid_productoCosto) {
		this.cargarid_productoCosto= cargarid_productoCosto;
	}

	public Border setResaltarid_periodoCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CostoBeanSwingJInternalFrame costoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//costoBeanSwingJInternalFrame.jTtoolBarCosto.setBorder(borderResaltar);
		
		this.resaltarid_periodoCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoCosto() {
		return this.resaltarid_periodoCosto;
	}

	public void setResaltarid_periodoCosto(Border borderResaltar) {
		this.resaltarid_periodoCosto= borderResaltar;
	}

	public Boolean getMostrarid_periodoCosto() {
		return this.mostrarid_periodoCosto;
	}

	public void setMostrarid_periodoCosto(Boolean mostrarid_periodoCosto) {
		this.mostrarid_periodoCosto= mostrarid_periodoCosto;
	}

	public Boolean getActivarid_periodoCosto() {
		return this.activarid_periodoCosto;
	}

	public void setActivarid_periodoCosto(Boolean activarid_periodoCosto) {
		this.activarid_periodoCosto= activarid_periodoCosto;
	}

	public Boolean getCargarid_periodoCosto() {
		return this.cargarid_periodoCosto;
	}

	public void setCargarid_periodoCosto(Boolean cargarid_periodoCosto) {
		this.cargarid_periodoCosto= cargarid_periodoCosto;
	}

	public Border setResaltarid_ejercicioCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CostoBeanSwingJInternalFrame costoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//costoBeanSwingJInternalFrame.jTtoolBarCosto.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioCosto() {
		return this.resaltarid_ejercicioCosto;
	}

	public void setResaltarid_ejercicioCosto(Border borderResaltar) {
		this.resaltarid_ejercicioCosto= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioCosto() {
		return this.mostrarid_ejercicioCosto;
	}

	public void setMostrarid_ejercicioCosto(Boolean mostrarid_ejercicioCosto) {
		this.mostrarid_ejercicioCosto= mostrarid_ejercicioCosto;
	}

	public Boolean getActivarid_ejercicioCosto() {
		return this.activarid_ejercicioCosto;
	}

	public void setActivarid_ejercicioCosto(Boolean activarid_ejercicioCosto) {
		this.activarid_ejercicioCosto= activarid_ejercicioCosto;
	}

	public Boolean getCargarid_ejercicioCosto() {
		return this.cargarid_ejercicioCosto;
	}

	public void setCargarid_ejercicioCosto(Boolean cargarid_ejercicioCosto) {
		this.cargarid_ejercicioCosto= cargarid_ejercicioCosto;
	}

	public Border setResaltarid_detalle_movimiento_inventarioCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CostoBeanSwingJInternalFrame costoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//costoBeanSwingJInternalFrame.jTtoolBarCosto.setBorder(borderResaltar);
		
		this.resaltarid_detalle_movimiento_inventarioCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_detalle_movimiento_inventarioCosto() {
		return this.resaltarid_detalle_movimiento_inventarioCosto;
	}

	public void setResaltarid_detalle_movimiento_inventarioCosto(Border borderResaltar) {
		this.resaltarid_detalle_movimiento_inventarioCosto= borderResaltar;
	}

	public Boolean getMostrarid_detalle_movimiento_inventarioCosto() {
		return this.mostrarid_detalle_movimiento_inventarioCosto;
	}

	public void setMostrarid_detalle_movimiento_inventarioCosto(Boolean mostrarid_detalle_movimiento_inventarioCosto) {
		this.mostrarid_detalle_movimiento_inventarioCosto= mostrarid_detalle_movimiento_inventarioCosto;
	}

	public Boolean getActivarid_detalle_movimiento_inventarioCosto() {
		return this.activarid_detalle_movimiento_inventarioCosto;
	}

	public void setActivarid_detalle_movimiento_inventarioCosto(Boolean activarid_detalle_movimiento_inventarioCosto) {
		this.activarid_detalle_movimiento_inventarioCosto= activarid_detalle_movimiento_inventarioCosto;
	}

	public Boolean getCargarid_detalle_movimiento_inventarioCosto() {
		return this.cargarid_detalle_movimiento_inventarioCosto;
	}

	public void setCargarid_detalle_movimiento_inventarioCosto(Boolean cargarid_detalle_movimiento_inventarioCosto) {
		this.cargarid_detalle_movimiento_inventarioCosto= cargarid_detalle_movimiento_inventarioCosto;
	}

	public Border setResaltarid_tipo_costoCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CostoBeanSwingJInternalFrame costoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//costoBeanSwingJInternalFrame.jTtoolBarCosto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_costoCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_costoCosto() {
		return this.resaltarid_tipo_costoCosto;
	}

	public void setResaltarid_tipo_costoCosto(Border borderResaltar) {
		this.resaltarid_tipo_costoCosto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_costoCosto() {
		return this.mostrarid_tipo_costoCosto;
	}

	public void setMostrarid_tipo_costoCosto(Boolean mostrarid_tipo_costoCosto) {
		this.mostrarid_tipo_costoCosto= mostrarid_tipo_costoCosto;
	}

	public Boolean getActivarid_tipo_costoCosto() {
		return this.activarid_tipo_costoCosto;
	}

	public void setActivarid_tipo_costoCosto(Boolean activarid_tipo_costoCosto) {
		this.activarid_tipo_costoCosto= activarid_tipo_costoCosto;
	}

	public Boolean getCargarid_tipo_costoCosto() {
		return this.cargarid_tipo_costoCosto;
	}

	public void setCargarid_tipo_costoCosto(Boolean cargarid_tipo_costoCosto) {
		this.cargarid_tipo_costoCosto= cargarid_tipo_costoCosto;
	}

	public Border setResaltarnumero_comprobanteCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CostoBeanSwingJInternalFrame costoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//costoBeanSwingJInternalFrame.jTtoolBarCosto.setBorder(borderResaltar);
		
		this.resaltarnumero_comprobanteCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobanteCosto() {
		return this.resaltarnumero_comprobanteCosto;
	}

	public void setResaltarnumero_comprobanteCosto(Border borderResaltar) {
		this.resaltarnumero_comprobanteCosto= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobanteCosto() {
		return this.mostrarnumero_comprobanteCosto;
	}

	public void setMostrarnumero_comprobanteCosto(Boolean mostrarnumero_comprobanteCosto) {
		this.mostrarnumero_comprobanteCosto= mostrarnumero_comprobanteCosto;
	}

	public Boolean getActivarnumero_comprobanteCosto() {
		return this.activarnumero_comprobanteCosto;
	}

	public void setActivarnumero_comprobanteCosto(Boolean activarnumero_comprobanteCosto) {
		this.activarnumero_comprobanteCosto= activarnumero_comprobanteCosto;
	}

	public Border setResaltarfechaCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CostoBeanSwingJInternalFrame costoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//costoBeanSwingJInternalFrame.jTtoolBarCosto.setBorder(borderResaltar);
		
		this.resaltarfechaCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaCosto() {
		return this.resaltarfechaCosto;
	}

	public void setResaltarfechaCosto(Border borderResaltar) {
		this.resaltarfechaCosto= borderResaltar;
	}

	public Boolean getMostrarfechaCosto() {
		return this.mostrarfechaCosto;
	}

	public void setMostrarfechaCosto(Boolean mostrarfechaCosto) {
		this.mostrarfechaCosto= mostrarfechaCosto;
	}

	public Boolean getActivarfechaCosto() {
		return this.activarfechaCosto;
	}

	public void setActivarfechaCosto(Boolean activarfechaCosto) {
		this.activarfechaCosto= activarfechaCosto;
	}

	public Border setResaltarcantidadCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CostoBeanSwingJInternalFrame costoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//costoBeanSwingJInternalFrame.jTtoolBarCosto.setBorder(borderResaltar);
		
		this.resaltarcantidadCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadCosto() {
		return this.resaltarcantidadCosto;
	}

	public void setResaltarcantidadCosto(Border borderResaltar) {
		this.resaltarcantidadCosto= borderResaltar;
	}

	public Boolean getMostrarcantidadCosto() {
		return this.mostrarcantidadCosto;
	}

	public void setMostrarcantidadCosto(Boolean mostrarcantidadCosto) {
		this.mostrarcantidadCosto= mostrarcantidadCosto;
	}

	public Boolean getActivarcantidadCosto() {
		return this.activarcantidadCosto;
	}

	public void setActivarcantidadCosto(Boolean activarcantidadCosto) {
		this.activarcantidadCosto= activarcantidadCosto;
	}

	public Border setResaltarvalor_unitarioCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CostoBeanSwingJInternalFrame costoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//costoBeanSwingJInternalFrame.jTtoolBarCosto.setBorder(borderResaltar);
		
		this.resaltarvalor_unitarioCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_unitarioCosto() {
		return this.resaltarvalor_unitarioCosto;
	}

	public void setResaltarvalor_unitarioCosto(Border borderResaltar) {
		this.resaltarvalor_unitarioCosto= borderResaltar;
	}

	public Boolean getMostrarvalor_unitarioCosto() {
		return this.mostrarvalor_unitarioCosto;
	}

	public void setMostrarvalor_unitarioCosto(Boolean mostrarvalor_unitarioCosto) {
		this.mostrarvalor_unitarioCosto= mostrarvalor_unitarioCosto;
	}

	public Boolean getActivarvalor_unitarioCosto() {
		return this.activarvalor_unitarioCosto;
	}

	public void setActivarvalor_unitarioCosto(Boolean activarvalor_unitarioCosto) {
		this.activarvalor_unitarioCosto= activarvalor_unitarioCosto;
	}

	public Border setResaltarvalor_totalCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CostoBeanSwingJInternalFrame costoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//costoBeanSwingJInternalFrame.jTtoolBarCosto.setBorder(borderResaltar);
		
		this.resaltarvalor_totalCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_totalCosto() {
		return this.resaltarvalor_totalCosto;
	}

	public void setResaltarvalor_totalCosto(Border borderResaltar) {
		this.resaltarvalor_totalCosto= borderResaltar;
	}

	public Boolean getMostrarvalor_totalCosto() {
		return this.mostrarvalor_totalCosto;
	}

	public void setMostrarvalor_totalCosto(Boolean mostrarvalor_totalCosto) {
		this.mostrarvalor_totalCosto= mostrarvalor_totalCosto;
	}

	public Boolean getActivarvalor_totalCosto() {
		return this.activarvalor_totalCosto;
	}

	public void setActivarvalor_totalCosto(Boolean activarvalor_totalCosto) {
		this.activarvalor_totalCosto= activarvalor_totalCosto;
	}

	public Border setResaltarid_anioCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CostoBeanSwingJInternalFrame costoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//costoBeanSwingJInternalFrame.jTtoolBarCosto.setBorder(borderResaltar);
		
		this.resaltarid_anioCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioCosto() {
		return this.resaltarid_anioCosto;
	}

	public void setResaltarid_anioCosto(Border borderResaltar) {
		this.resaltarid_anioCosto= borderResaltar;
	}

	public Boolean getMostrarid_anioCosto() {
		return this.mostrarid_anioCosto;
	}

	public void setMostrarid_anioCosto(Boolean mostrarid_anioCosto) {
		this.mostrarid_anioCosto= mostrarid_anioCosto;
	}

	public Boolean getActivarid_anioCosto() {
		return this.activarid_anioCosto;
	}

	public void setActivarid_anioCosto(Boolean activarid_anioCosto) {
		this.activarid_anioCosto= activarid_anioCosto;
	}

	public Boolean getCargarid_anioCosto() {
		return this.cargarid_anioCosto;
	}

	public void setCargarid_anioCosto(Boolean cargarid_anioCosto) {
		this.cargarid_anioCosto= cargarid_anioCosto;
	}

	public Border setResaltarid_mesCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CostoBeanSwingJInternalFrame costoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//costoBeanSwingJInternalFrame.jTtoolBarCosto.setBorder(borderResaltar);
		
		this.resaltarid_mesCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesCosto() {
		return this.resaltarid_mesCosto;
	}

	public void setResaltarid_mesCosto(Border borderResaltar) {
		this.resaltarid_mesCosto= borderResaltar;
	}

	public Boolean getMostrarid_mesCosto() {
		return this.mostrarid_mesCosto;
	}

	public void setMostrarid_mesCosto(Boolean mostrarid_mesCosto) {
		this.mostrarid_mesCosto= mostrarid_mesCosto;
	}

	public Boolean getActivarid_mesCosto() {
		return this.activarid_mesCosto;
	}

	public void setActivarid_mesCosto(Boolean activarid_mesCosto) {
		this.activarid_mesCosto= activarid_mesCosto;
	}

	public Boolean getCargarid_mesCosto() {
		return this.cargarid_mesCosto;
	}

	public void setCargarid_mesCosto(Boolean cargarid_mesCosto) {
		this.cargarid_mesCosto= cargarid_mesCosto;
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
		
		
		this.setMostraridCosto(esInicial);
		this.setMostrarid_empresaCosto(esInicial);
		this.setMostrarid_sucursalCosto(esInicial);
		this.setMostrarid_bodegaCosto(esInicial);
		this.setMostrarid_productoCosto(esInicial);
		this.setMostrarid_periodoCosto(esInicial);
		this.setMostrarid_ejercicioCosto(esInicial);
		this.setMostrarid_detalle_movimiento_inventarioCosto(esInicial);
		this.setMostrarid_tipo_costoCosto(esInicial);
		this.setMostrarnumero_comprobanteCosto(esInicial);
		this.setMostrarfechaCosto(esInicial);
		this.setMostrarcantidadCosto(esInicial);
		this.setMostrarvalor_unitarioCosto(esInicial);
		this.setMostrarvalor_totalCosto(esInicial);
		this.setMostrarid_anioCosto(esInicial);
		this.setMostrarid_mesCosto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CostoConstantesFunciones.ID)) {
				this.setMostraridCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.IDDETALLEMOVIMIENTOINVENTARIO)) {
				this.setMostrarid_detalle_movimiento_inventarioCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.IDTIPOCOSTO)) {
				this.setMostrarid_tipo_costoCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setMostrarnumero_comprobanteCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.FECHA)) {
				this.setMostrarfechaCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.VALORUNITARIO)) {
				this.setMostrarvalor_unitarioCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.VALORTOTAL)) {
				this.setMostrarvalor_totalCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.IDMES)) {
				this.setMostrarid_mesCosto(esAsigna);
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
		
		
		this.setActivaridCosto(esInicial);
		this.setActivarid_empresaCosto(esInicial);
		this.setActivarid_sucursalCosto(esInicial);
		this.setActivarid_bodegaCosto(esInicial);
		this.setActivarid_productoCosto(esInicial);
		this.setActivarid_periodoCosto(esInicial);
		this.setActivarid_ejercicioCosto(esInicial);
		this.setActivarid_detalle_movimiento_inventarioCosto(esInicial);
		this.setActivarid_tipo_costoCosto(esInicial);
		this.setActivarnumero_comprobanteCosto(esInicial);
		this.setActivarfechaCosto(esInicial);
		this.setActivarcantidadCosto(esInicial);
		this.setActivarvalor_unitarioCosto(esInicial);
		this.setActivarvalor_totalCosto(esInicial);
		this.setActivarid_anioCosto(esInicial);
		this.setActivarid_mesCosto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CostoConstantesFunciones.ID)) {
				this.setActivaridCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.IDDETALLEMOVIMIENTOINVENTARIO)) {
				this.setActivarid_detalle_movimiento_inventarioCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.IDTIPOCOSTO)) {
				this.setActivarid_tipo_costoCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setActivarnumero_comprobanteCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.FECHA)) {
				this.setActivarfechaCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.VALORUNITARIO)) {
				this.setActivarvalor_unitarioCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.VALORTOTAL)) {
				this.setActivarvalor_totalCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.IDANIO)) {
				this.setActivarid_anioCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.IDMES)) {
				this.setActivarid_mesCosto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CostoBeanSwingJInternalFrame costoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCosto(esInicial);
		this.setResaltarid_empresaCosto(esInicial);
		this.setResaltarid_sucursalCosto(esInicial);
		this.setResaltarid_bodegaCosto(esInicial);
		this.setResaltarid_productoCosto(esInicial);
		this.setResaltarid_periodoCosto(esInicial);
		this.setResaltarid_ejercicioCosto(esInicial);
		this.setResaltarid_detalle_movimiento_inventarioCosto(esInicial);
		this.setResaltarid_tipo_costoCosto(esInicial);
		this.setResaltarnumero_comprobanteCosto(esInicial);
		this.setResaltarfechaCosto(esInicial);
		this.setResaltarcantidadCosto(esInicial);
		this.setResaltarvalor_unitarioCosto(esInicial);
		this.setResaltarvalor_totalCosto(esInicial);
		this.setResaltarid_anioCosto(esInicial);
		this.setResaltarid_mesCosto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CostoConstantesFunciones.ID)) {
				this.setResaltaridCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.IDDETALLEMOVIMIENTOINVENTARIO)) {
				this.setResaltarid_detalle_movimiento_inventarioCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.IDTIPOCOSTO)) {
				this.setResaltarid_tipo_costoCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setResaltarnumero_comprobanteCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.FECHA)) {
				this.setResaltarfechaCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.VALORUNITARIO)) {
				this.setResaltarvalor_unitarioCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.VALORTOTAL)) {
				this.setResaltarvalor_totalCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CostoConstantesFunciones.IDMES)) {
				this.setResaltarid_mesCosto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CostoBeanSwingJInternalFrame costoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaCosto=true;

	public Boolean getMostrarFK_IdBodegaCosto() {
		return this.mostrarFK_IdBodegaCosto;
	}

	public void setMostrarFK_IdBodegaCosto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaCosto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdDetalleMovimientoInventarioCosto=true;

	public Boolean getMostrarFK_IdDetalleMovimientoInventarioCosto() {
		return this.mostrarFK_IdDetalleMovimientoInventarioCosto;
	}

	public void setMostrarFK_IdDetalleMovimientoInventarioCosto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDetalleMovimientoInventarioCosto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioCosto=true;

	public Boolean getMostrarFK_IdEjercicioCosto() {
		return this.mostrarFK_IdEjercicioCosto;
	}

	public void setMostrarFK_IdEjercicioCosto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioCosto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCosto=true;

	public Boolean getMostrarFK_IdEmpresaCosto() {
		return this.mostrarFK_IdEmpresaCosto;
	}

	public void setMostrarFK_IdEmpresaCosto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCosto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoCosto=true;

	public Boolean getMostrarFK_IdPeriodoCosto() {
		return this.mostrarFK_IdPeriodoCosto;
	}

	public void setMostrarFK_IdPeriodoCosto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoCosto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoCosto=true;

	public Boolean getMostrarFK_IdProductoCosto() {
		return this.mostrarFK_IdProductoCosto;
	}

	public void setMostrarFK_IdProductoCosto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoCosto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalCosto=true;

	public Boolean getMostrarFK_IdSucursalCosto() {
		return this.mostrarFK_IdSucursalCosto;
	}

	public void setMostrarFK_IdSucursalCosto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalCosto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoCostoCosto=true;

	public Boolean getMostrarFK_IdTipoCostoCosto() {
		return this.mostrarFK_IdTipoCostoCosto;
	}

	public void setMostrarFK_IdTipoCostoCosto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoCostoCosto= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaCosto=true;

	public Boolean getActivarFK_IdBodegaCosto() {
		return this.activarFK_IdBodegaCosto;
	}

	public void setActivarFK_IdBodegaCosto(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaCosto= habilitarResaltar;
	}

	public Boolean activarFK_IdDetalleMovimientoInventarioCosto=true;

	public Boolean getActivarFK_IdDetalleMovimientoInventarioCosto() {
		return this.activarFK_IdDetalleMovimientoInventarioCosto;
	}

	public void setActivarFK_IdDetalleMovimientoInventarioCosto(Boolean habilitarResaltar) {
		this.activarFK_IdDetalleMovimientoInventarioCosto= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioCosto=true;

	public Boolean getActivarFK_IdEjercicioCosto() {
		return this.activarFK_IdEjercicioCosto;
	}

	public void setActivarFK_IdEjercicioCosto(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioCosto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCosto=true;

	public Boolean getActivarFK_IdEmpresaCosto() {
		return this.activarFK_IdEmpresaCosto;
	}

	public void setActivarFK_IdEmpresaCosto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCosto= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoCosto=true;

	public Boolean getActivarFK_IdPeriodoCosto() {
		return this.activarFK_IdPeriodoCosto;
	}

	public void setActivarFK_IdPeriodoCosto(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoCosto= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoCosto=true;

	public Boolean getActivarFK_IdProductoCosto() {
		return this.activarFK_IdProductoCosto;
	}

	public void setActivarFK_IdProductoCosto(Boolean habilitarResaltar) {
		this.activarFK_IdProductoCosto= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalCosto=true;

	public Boolean getActivarFK_IdSucursalCosto() {
		return this.activarFK_IdSucursalCosto;
	}

	public void setActivarFK_IdSucursalCosto(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalCosto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoCostoCosto=true;

	public Boolean getActivarFK_IdTipoCostoCosto() {
		return this.activarFK_IdTipoCostoCosto;
	}

	public void setActivarFK_IdTipoCostoCosto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoCostoCosto= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaCosto=null;

	public Border getResaltarFK_IdBodegaCosto() {
		return this.resaltarFK_IdBodegaCosto;
	}

	public void setResaltarFK_IdBodegaCosto(Border borderResaltar) {
		this.resaltarFK_IdBodegaCosto= borderResaltar;
	}

	public void setResaltarFK_IdBodegaCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CostoBeanSwingJInternalFrame costoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaCosto= borderResaltar;
	}

	public Border resaltarFK_IdDetalleMovimientoInventarioCosto=null;

	public Border getResaltarFK_IdDetalleMovimientoInventarioCosto() {
		return this.resaltarFK_IdDetalleMovimientoInventarioCosto;
	}

	public void setResaltarFK_IdDetalleMovimientoInventarioCosto(Border borderResaltar) {
		this.resaltarFK_IdDetalleMovimientoInventarioCosto= borderResaltar;
	}

	public void setResaltarFK_IdDetalleMovimientoInventarioCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CostoBeanSwingJInternalFrame costoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDetalleMovimientoInventarioCosto= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioCosto=null;

	public Border getResaltarFK_IdEjercicioCosto() {
		return this.resaltarFK_IdEjercicioCosto;
	}

	public void setResaltarFK_IdEjercicioCosto(Border borderResaltar) {
		this.resaltarFK_IdEjercicioCosto= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CostoBeanSwingJInternalFrame costoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioCosto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCosto=null;

	public Border getResaltarFK_IdEmpresaCosto() {
		return this.resaltarFK_IdEmpresaCosto;
	}

	public void setResaltarFK_IdEmpresaCosto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCosto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CostoBeanSwingJInternalFrame costoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCosto= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoCosto=null;

	public Border getResaltarFK_IdPeriodoCosto() {
		return this.resaltarFK_IdPeriodoCosto;
	}

	public void setResaltarFK_IdPeriodoCosto(Border borderResaltar) {
		this.resaltarFK_IdPeriodoCosto= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CostoBeanSwingJInternalFrame costoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoCosto= borderResaltar;
	}

	public Border resaltarFK_IdProductoCosto=null;

	public Border getResaltarFK_IdProductoCosto() {
		return this.resaltarFK_IdProductoCosto;
	}

	public void setResaltarFK_IdProductoCosto(Border borderResaltar) {
		this.resaltarFK_IdProductoCosto= borderResaltar;
	}

	public void setResaltarFK_IdProductoCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CostoBeanSwingJInternalFrame costoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoCosto= borderResaltar;
	}

	public Border resaltarFK_IdSucursalCosto=null;

	public Border getResaltarFK_IdSucursalCosto() {
		return this.resaltarFK_IdSucursalCosto;
	}

	public void setResaltarFK_IdSucursalCosto(Border borderResaltar) {
		this.resaltarFK_IdSucursalCosto= borderResaltar;
	}

	public void setResaltarFK_IdSucursalCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CostoBeanSwingJInternalFrame costoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalCosto= borderResaltar;
	}

	public Border resaltarFK_IdTipoCostoCosto=null;

	public Border getResaltarFK_IdTipoCostoCosto() {
		return this.resaltarFK_IdTipoCostoCosto;
	}

	public void setResaltarFK_IdTipoCostoCosto(Border borderResaltar) {
		this.resaltarFK_IdTipoCostoCosto= borderResaltar;
	}

	public void setResaltarFK_IdTipoCostoCosto(ParametroGeneralUsuario parametroGeneralUsuario/*CostoBeanSwingJInternalFrame costoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoCostoCosto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}