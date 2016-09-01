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
package com.bydan.erp.facturacion.util;

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


import com.bydan.erp.facturacion.util.PresupuestoVentasConstantesFunciones;
import com.bydan.erp.facturacion.util.PresupuestoVentasParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.PresupuestoVentasParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PresupuestoVentasConstantesFunciones extends PresupuestoVentasConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PresupuestoVentas";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PresupuestoVentas"+PresupuestoVentasConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PresupuestoVentasHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PresupuestoVentasHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PresupuestoVentasConstantesFunciones.SCHEMA+"_"+PresupuestoVentasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PresupuestoVentasHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PresupuestoVentasConstantesFunciones.SCHEMA+"_"+PresupuestoVentasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PresupuestoVentasConstantesFunciones.SCHEMA+"_"+PresupuestoVentasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PresupuestoVentasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PresupuestoVentasConstantesFunciones.SCHEMA+"_"+PresupuestoVentasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestoVentasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PresupuestoVentasHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestoVentasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestoVentasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PresupuestoVentasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestoVentasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PresupuestoVentasConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PresupuestoVentasConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PresupuestoVentasConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PresupuestoVentasConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Presupuesto Ventases";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Presupuesto Ventas";
	public static final String SCLASSWEBTITULO_LOWER="Presupuesto Ventas";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PresupuestoVentas";
	public static final String OBJECTNAME="presupuestoventas";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="presupuesto_ventas";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select presupuestoventas from "+PresupuestoVentasConstantesFunciones.SPERSISTENCENAME+" presupuestoventas";
	public static String QUERYSELECTNATIVE="select "+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".id,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".version_row,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".id_empresa,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".id_sucursal,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".id_ejercicio,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".id_periodo,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".id_vendedor,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".id_pais,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".id_ciudad,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".id_zona,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".id_producto,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".precio,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".cantidad,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".valor,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".porcentaje,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".cantidad_total,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".valor_total from "+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME;//+" as "+PresupuestoVentasConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PresupuestoVentasConstantesFuncionesAdditional presupuestoventasConstantesFuncionesAdditional=null;
	
	public PresupuestoVentasConstantesFuncionesAdditional getPresupuestoVentasConstantesFuncionesAdditional() {
		return this.presupuestoventasConstantesFuncionesAdditional;
	}
	
	public void setPresupuestoVentasConstantesFuncionesAdditional(PresupuestoVentasConstantesFuncionesAdditional presupuestoventasConstantesFuncionesAdditional) {
		try {
			this.presupuestoventasConstantesFuncionesAdditional=presupuestoventasConstantesFuncionesAdditional;
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
    public static final String IDVENDEDOR= "id_vendedor";
    public static final String IDPAIS= "id_pais";
    public static final String IDCIUDAD= "id_ciudad";
    public static final String IDZONA= "id_zona";
    public static final String IDPRODUCTO= "id_producto";
    public static final String PRECIO= "precio";
    public static final String CANTIDAD= "cantidad";
    public static final String VALOR= "valor";
    public static final String PORCENTAJE= "porcentaje";
    public static final String CANTIDADTOTAL= "cantidad_total";
    public static final String VALORTOTAL= "valor_total";
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
    	public static final String LABEL_IDVENDEDOR= "Vendedor";
		public static final String LABEL_IDVENDEDOR_LOWER= "Vendedor";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDCIUDAD= "Ciudad";
		public static final String LABEL_IDCIUDAD_LOWER= "Ciudad";
    	public static final String LABEL_IDZONA= "Zona";
		public static final String LABEL_IDZONA_LOWER= "Zona";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
    	public static final String LABEL_CANTIDAD= "Cantidad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_CANTIDADTOTAL= "Cantidad Total";
		public static final String LABEL_CANTIDADTOTAL_LOWER= "Cantidad Total";
    	public static final String LABEL_VALORTOTAL= "Valor Total";
		public static final String LABEL_VALORTOTAL_LOWER= "Valor Total";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getPresupuestoVentasLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PresupuestoVentasConstantesFunciones.IDEMPRESA)) {sLabelColumna=PresupuestoVentasConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PresupuestoVentasConstantesFunciones.IDSUCURSAL)) {sLabelColumna=PresupuestoVentasConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(PresupuestoVentasConstantesFunciones.IDEJERCICIO)) {sLabelColumna=PresupuestoVentasConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(PresupuestoVentasConstantesFunciones.IDPERIODO)) {sLabelColumna=PresupuestoVentasConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(PresupuestoVentasConstantesFunciones.IDVENDEDOR)) {sLabelColumna=PresupuestoVentasConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(PresupuestoVentasConstantesFunciones.IDPAIS)) {sLabelColumna=PresupuestoVentasConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(PresupuestoVentasConstantesFunciones.IDCIUDAD)) {sLabelColumna=PresupuestoVentasConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(PresupuestoVentasConstantesFunciones.IDZONA)) {sLabelColumna=PresupuestoVentasConstantesFunciones.LABEL_IDZONA;}
		if(sNombreColumna.equals(PresupuestoVentasConstantesFunciones.IDPRODUCTO)) {sLabelColumna=PresupuestoVentasConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(PresupuestoVentasConstantesFunciones.PRECIO)) {sLabelColumna=PresupuestoVentasConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(PresupuestoVentasConstantesFunciones.CANTIDAD)) {sLabelColumna=PresupuestoVentasConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(PresupuestoVentasConstantesFunciones.VALOR)) {sLabelColumna=PresupuestoVentasConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(PresupuestoVentasConstantesFunciones.PORCENTAJE)) {sLabelColumna=PresupuestoVentasConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(PresupuestoVentasConstantesFunciones.CANTIDADTOTAL)) {sLabelColumna=PresupuestoVentasConstantesFunciones.LABEL_CANTIDADTOTAL;}
		if(sNombreColumna.equals(PresupuestoVentasConstantesFunciones.VALORTOTAL)) {sLabelColumna=PresupuestoVentasConstantesFunciones.LABEL_VALORTOTAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getPresupuestoVentasDescripcion(PresupuestoVentas presupuestoventas) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(presupuestoventas !=null/* && presupuestoventas.getId()!=0*/) {
			if(presupuestoventas.getId()!=null) {
				sDescripcion=presupuestoventas.getId().toString();
			}//presupuestoventaspresupuestoventas.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPresupuestoVentasDescripcionDetallado(PresupuestoVentas presupuestoventas) {
		String sDescripcion="";
			
		sDescripcion+=PresupuestoVentasConstantesFunciones.ID+"=";
		sDescripcion+=presupuestoventas.getId().toString()+",";
		sDescripcion+=PresupuestoVentasConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=presupuestoventas.getVersionRow().toString()+",";
		sDescripcion+=PresupuestoVentasConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=presupuestoventas.getid_empresa().toString()+",";
		sDescripcion+=PresupuestoVentasConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=presupuestoventas.getid_sucursal().toString()+",";
		sDescripcion+=PresupuestoVentasConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=presupuestoventas.getid_ejercicio().toString()+",";
		sDescripcion+=PresupuestoVentasConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=presupuestoventas.getid_periodo().toString()+",";
		sDescripcion+=PresupuestoVentasConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=presupuestoventas.getid_vendedor().toString()+",";
		sDescripcion+=PresupuestoVentasConstantesFunciones.IDPAIS+"=";
		sDescripcion+=presupuestoventas.getid_pais().toString()+",";
		sDescripcion+=PresupuestoVentasConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=presupuestoventas.getid_ciudad().toString()+",";
		sDescripcion+=PresupuestoVentasConstantesFunciones.IDZONA+"=";
		sDescripcion+=presupuestoventas.getid_zona().toString()+",";
		sDescripcion+=PresupuestoVentasConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=presupuestoventas.getid_producto().toString()+",";
		sDescripcion+=PresupuestoVentasConstantesFunciones.PRECIO+"=";
		sDescripcion+=presupuestoventas.getprecio().toString()+",";
		sDescripcion+=PresupuestoVentasConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=presupuestoventas.getcantidad().toString()+",";
		sDescripcion+=PresupuestoVentasConstantesFunciones.VALOR+"=";
		sDescripcion+=presupuestoventas.getvalor().toString()+",";
		sDescripcion+=PresupuestoVentasConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=presupuestoventas.getporcentaje().toString()+",";
		sDescripcion+=PresupuestoVentasConstantesFunciones.CANTIDADTOTAL+"=";
		sDescripcion+=presupuestoventas.getcantidad_total().toString()+",";
		sDescripcion+=PresupuestoVentasConstantesFunciones.VALORTOTAL+"=";
		sDescripcion+=presupuestoventas.getvalor_total().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPresupuestoVentasDescripcion(PresupuestoVentas presupuestoventas,String sValor) throws Exception {			
		if(presupuestoventas !=null) {
			//presupuestoventaspresupuestoventas.getId().toString();
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

	public static String getVendedorDescripcion(Vendedor vendedor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(vendedor!=null/*&&vendedor.getId()>0*/) {
			sDescripcion=VendedorConstantesFunciones.getVendedorDescripcion(vendedor);
		}

		return sDescripcion;
	}

	public static String getPaisDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
		}

		return sDescripcion;
	}

	public static String getCiudadDescripcion(Ciudad ciudad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ciudad!=null/*&&ciudad.getId()>0*/) {
			sDescripcion=CiudadConstantesFunciones.getCiudadDescripcion(ciudad);
		}

		return sDescripcion;
	}

	public static String getZonaDescripcion(Zona zona) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(zona!=null/*&&zona.getId()>0*/) {
			sDescripcion=ZonaConstantesFunciones.getZonaDescripcion(zona);
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
		} else if(sNombreIndice.equals("FK_IdCiudad")) {
			sNombreIndice="Tipo=  Por Ciudad";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdVendedor")) {
			sNombreIndice="Tipo=  Por Vendedor";
		} else if(sNombreIndice.equals("FK_IdZona")) {
			sNombreIndice="Tipo=  Por Zona";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCiudad(Long id_ciudad) {
		String sDetalleIndice=" Parametros->";
		if(id_ciudad!=null) {sDetalleIndice+=" Codigo Unico De Ciudad="+id_ciudad.toString();} 

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

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

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

	public static String getDetalleIndiceFK_IdVendedor(Long id_vendedor) {
		String sDetalleIndice=" Parametros->";
		if(id_vendedor!=null) {sDetalleIndice+=" Codigo Unico De Vendedor="+id_vendedor.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdZona(Long id_zona) {
		String sDetalleIndice=" Parametros->";
		if(id_zona!=null) {sDetalleIndice+=" Codigo Unico De Zona="+id_zona.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPresupuestoVentas(PresupuestoVentas presupuestoventas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosPresupuestoVentass(List<PresupuestoVentas> presupuestoventass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PresupuestoVentas presupuestoventas: presupuestoventass) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPresupuestoVentas(PresupuestoVentas presupuestoventas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && presupuestoventas.getConCambioAuxiliar()) {
			presupuestoventas.setIsDeleted(presupuestoventas.getIsDeletedAuxiliar());	
			presupuestoventas.setIsNew(presupuestoventas.getIsNewAuxiliar());	
			presupuestoventas.setIsChanged(presupuestoventas.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			presupuestoventas.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			presupuestoventas.setIsDeletedAuxiliar(false);	
			presupuestoventas.setIsNewAuxiliar(false);	
			presupuestoventas.setIsChangedAuxiliar(false);
			
			presupuestoventas.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPresupuestoVentass(List<PresupuestoVentas> presupuestoventass,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PresupuestoVentas presupuestoventas : presupuestoventass) {
			if(conAsignarBase && presupuestoventas.getConCambioAuxiliar()) {
				presupuestoventas.setIsDeleted(presupuestoventas.getIsDeletedAuxiliar());	
				presupuestoventas.setIsNew(presupuestoventas.getIsNewAuxiliar());	
				presupuestoventas.setIsChanged(presupuestoventas.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				presupuestoventas.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				presupuestoventas.setIsDeletedAuxiliar(false);	
				presupuestoventas.setIsNewAuxiliar(false);	
				presupuestoventas.setIsChangedAuxiliar(false);
				
				presupuestoventas.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPresupuestoVentas(PresupuestoVentas presupuestoventas,Boolean conEnteros) throws Exception  {
		presupuestoventas.setprecio(0.0);
		presupuestoventas.setvalor(0.0);
		presupuestoventas.setporcentaje(0.0);
		presupuestoventas.setvalor_total(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			presupuestoventas.setcantidad(0);
			presupuestoventas.setcantidad_total(0);
		}
	}		
	
	public static void InicializarValoresPresupuestoVentass(List<PresupuestoVentas> presupuestoventass,Boolean conEnteros) throws Exception  {
		
		for(PresupuestoVentas presupuestoventas: presupuestoventass) {
			presupuestoventas.setprecio(0.0);
			presupuestoventas.setvalor(0.0);
			presupuestoventas.setporcentaje(0.0);
			presupuestoventas.setvalor_total(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				presupuestoventas.setcantidad(0);
				presupuestoventas.setcantidad_total(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaPresupuestoVentas(List<PresupuestoVentas> presupuestoventass,PresupuestoVentas presupuestoventasAux) throws Exception  {
		PresupuestoVentasConstantesFunciones.InicializarValoresPresupuestoVentas(presupuestoventasAux,true);
		
		for(PresupuestoVentas presupuestoventas: presupuestoventass) {
			if(presupuestoventas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			presupuestoventasAux.setprecio(presupuestoventasAux.getprecio()+presupuestoventas.getprecio());			
			presupuestoventasAux.setcantidad(presupuestoventasAux.getcantidad()+presupuestoventas.getcantidad());			
			presupuestoventasAux.setvalor(presupuestoventasAux.getvalor()+presupuestoventas.getvalor());			
			presupuestoventasAux.setporcentaje(presupuestoventasAux.getporcentaje()+presupuestoventas.getporcentaje());			
			presupuestoventasAux.setcantidad_total(presupuestoventasAux.getcantidad_total()+presupuestoventas.getcantidad_total());			
			presupuestoventasAux.setvalor_total(presupuestoventasAux.getvalor_total()+presupuestoventas.getvalor_total());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPresupuestoVentas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PresupuestoVentasConstantesFunciones.getArrayColumnasGlobalesPresupuestoVentas(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPresupuestoVentas(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresupuestoVentasConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresupuestoVentasConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresupuestoVentasConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresupuestoVentasConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresupuestoVentasConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresupuestoVentasConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresupuestoVentasConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresupuestoVentasConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPresupuestoVentas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PresupuestoVentas> presupuestoventass,PresupuestoVentas presupuestoventas,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PresupuestoVentas presupuestoventasAux: presupuestoventass) {
			if(presupuestoventasAux!=null && presupuestoventas!=null) {
				if((presupuestoventasAux.getId()==null && presupuestoventas.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(presupuestoventasAux.getId()!=null && presupuestoventas.getId()!=null){
					if(presupuestoventasAux.getId().equals(presupuestoventas.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPresupuestoVentas(List<PresupuestoVentas> presupuestoventass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
		Double valorTotal=0.0;
		Double porcentajeTotal=0.0;
		Double valor_totalTotal=0.0;
	
		for(PresupuestoVentas presupuestoventas: presupuestoventass) {			
			if(presupuestoventas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precioTotal+=presupuestoventas.getprecio();
			valorTotal+=presupuestoventas.getvalor();
			porcentajeTotal+=presupuestoventas.getporcentaje();
			valor_totalTotal+=presupuestoventas.getvalor_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestoVentasConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(PresupuestoVentasConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestoVentasConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(PresupuestoVentasConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestoVentasConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(PresupuestoVentasConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestoVentasConstantesFunciones.VALORTOTAL);
		datoGeneral.setsDescripcion(PresupuestoVentasConstantesFunciones.LABEL_VALORTOTAL);
		datoGeneral.setdValorDouble(valor_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPresupuestoVentas() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PresupuestoVentasConstantesFunciones.LABEL_ID, PresupuestoVentasConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasConstantesFunciones.LABEL_VERSIONROW, PresupuestoVentasConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasConstantesFunciones.LABEL_IDEMPRESA, PresupuestoVentasConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasConstantesFunciones.LABEL_IDSUCURSAL, PresupuestoVentasConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasConstantesFunciones.LABEL_IDEJERCICIO, PresupuestoVentasConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasConstantesFunciones.LABEL_IDPERIODO, PresupuestoVentasConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasConstantesFunciones.LABEL_IDVENDEDOR, PresupuestoVentasConstantesFunciones.IDVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasConstantesFunciones.LABEL_IDPAIS, PresupuestoVentasConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasConstantesFunciones.LABEL_IDCIUDAD, PresupuestoVentasConstantesFunciones.IDCIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasConstantesFunciones.LABEL_IDZONA, PresupuestoVentasConstantesFunciones.IDZONA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasConstantesFunciones.LABEL_IDPRODUCTO, PresupuestoVentasConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasConstantesFunciones.LABEL_PRECIO, PresupuestoVentasConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasConstantesFunciones.LABEL_CANTIDAD, PresupuestoVentasConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasConstantesFunciones.LABEL_VALOR, PresupuestoVentasConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasConstantesFunciones.LABEL_PORCENTAJE, PresupuestoVentasConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasConstantesFunciones.LABEL_CANTIDADTOTAL, PresupuestoVentasConstantesFunciones.CANTIDADTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasConstantesFunciones.LABEL_VALORTOTAL, PresupuestoVentasConstantesFunciones.VALORTOTAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPresupuestoVentas() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasConstantesFunciones.IDVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasConstantesFunciones.IDCIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasConstantesFunciones.IDZONA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasConstantesFunciones.CANTIDADTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasConstantesFunciones.VALORTOTAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresupuestoVentas() throws Exception  {
		return PresupuestoVentasConstantesFunciones.getTiposSeleccionarPresupuestoVentas(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresupuestoVentas(Boolean conFk) throws Exception  {
		return PresupuestoVentasConstantesFunciones.getTiposSeleccionarPresupuestoVentas(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresupuestoVentas(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PresupuestoVentasConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(PresupuestoVentasConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(PresupuestoVentasConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(PresupuestoVentasConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(PresupuestoVentasConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(PresupuestoVentasConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(PresupuestoVentasConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasConstantesFunciones.LABEL_IDZONA);
			reporte.setsDescripcion(PresupuestoVentasConstantesFunciones.LABEL_IDZONA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(PresupuestoVentasConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(PresupuestoVentasConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(PresupuestoVentasConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(PresupuestoVentasConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(PresupuestoVentasConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasConstantesFunciones.LABEL_CANTIDADTOTAL);
			reporte.setsDescripcion(PresupuestoVentasConstantesFunciones.LABEL_CANTIDADTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasConstantesFunciones.LABEL_VALORTOTAL);
			reporte.setsDescripcion(PresupuestoVentasConstantesFunciones.LABEL_VALORTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPresupuestoVentas(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPresupuestoVentas(PresupuestoVentas presupuestoventasAux) throws Exception {
		
			presupuestoventasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(presupuestoventasAux.getEmpresa()));
			presupuestoventasAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(presupuestoventasAux.getSucursal()));
			presupuestoventasAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(presupuestoventasAux.getEjercicio()));
			presupuestoventasAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(presupuestoventasAux.getPeriodo()));
			presupuestoventasAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(presupuestoventasAux.getVendedor()));
			presupuestoventasAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(presupuestoventasAux.getPais()));
			presupuestoventasAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(presupuestoventasAux.getCiudad()));
			presupuestoventasAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(presupuestoventasAux.getZona()));
			presupuestoventasAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(presupuestoventasAux.getProducto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPresupuestoVentas(List<PresupuestoVentas> presupuestoventassTemp) throws Exception {
		for(PresupuestoVentas presupuestoventasAux:presupuestoventassTemp) {
			
			presupuestoventasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(presupuestoventasAux.getEmpresa()));
			presupuestoventasAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(presupuestoventasAux.getSucursal()));
			presupuestoventasAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(presupuestoventasAux.getEjercicio()));
			presupuestoventasAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(presupuestoventasAux.getPeriodo()));
			presupuestoventasAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(presupuestoventasAux.getVendedor()));
			presupuestoventasAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(presupuestoventasAux.getPais()));
			presupuestoventasAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(presupuestoventasAux.getCiudad()));
			presupuestoventasAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(presupuestoventasAux.getZona()));
			presupuestoventasAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(presupuestoventasAux.getProducto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPresupuestoVentas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Vendedor.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Ciudad.class));
				classes.add(new Classe(Zona.class));
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
					if(clas.clas.equals(Vendedor.class)) {
						classes.add(new Classe(Vendedor.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ciudad.class)) {
						classes.add(new Classe(Ciudad.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Zona.class)) {
						classes.add(new Classe(Zona.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPresupuestoVentas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(Zona.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Zona.class)); continue;
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

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(Zona.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Zona.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresupuestoVentas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PresupuestoVentasConstantesFunciones.getClassesRelationshipsOfPresupuestoVentas(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresupuestoVentas(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPresupuestoVentas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PresupuestoVentasConstantesFunciones.getClassesRelationshipsFromStringsOfPresupuestoVentas(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPresupuestoVentas(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PresupuestoVentas presupuestoventas,List<PresupuestoVentas> presupuestoventass,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PresupuestoVentas presupuestoventasEncontrado=null;
			
			for(PresupuestoVentas presupuestoventasLocal:presupuestoventass) {
				if(presupuestoventasLocal.getId().equals(presupuestoventas.getId())) {
					presupuestoventasEncontrado=presupuestoventasLocal;
					
					presupuestoventasLocal.setIsChanged(presupuestoventas.getIsChanged());
					presupuestoventasLocal.setIsNew(presupuestoventas.getIsNew());
					presupuestoventasLocal.setIsDeleted(presupuestoventas.getIsDeleted());
					
					presupuestoventasLocal.setGeneralEntityOriginal(presupuestoventas.getGeneralEntityOriginal());
					
					presupuestoventasLocal.setId(presupuestoventas.getId());	
					presupuestoventasLocal.setVersionRow(presupuestoventas.getVersionRow());	
					presupuestoventasLocal.setid_empresa(presupuestoventas.getid_empresa());	
					presupuestoventasLocal.setid_sucursal(presupuestoventas.getid_sucursal());	
					presupuestoventasLocal.setid_ejercicio(presupuestoventas.getid_ejercicio());	
					presupuestoventasLocal.setid_periodo(presupuestoventas.getid_periodo());	
					presupuestoventasLocal.setid_vendedor(presupuestoventas.getid_vendedor());	
					presupuestoventasLocal.setid_pais(presupuestoventas.getid_pais());	
					presupuestoventasLocal.setid_ciudad(presupuestoventas.getid_ciudad());	
					presupuestoventasLocal.setid_zona(presupuestoventas.getid_zona());	
					presupuestoventasLocal.setid_producto(presupuestoventas.getid_producto());	
					presupuestoventasLocal.setprecio(presupuestoventas.getprecio());	
					presupuestoventasLocal.setcantidad(presupuestoventas.getcantidad());	
					presupuestoventasLocal.setvalor(presupuestoventas.getvalor());	
					presupuestoventasLocal.setporcentaje(presupuestoventas.getporcentaje());	
					presupuestoventasLocal.setcantidad_total(presupuestoventas.getcantidad_total());	
					presupuestoventasLocal.setvalor_total(presupuestoventas.getvalor_total());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!presupuestoventas.getIsDeleted()) {
				if(!existe) {
					presupuestoventass.add(presupuestoventas);
				}
			} else {
				if(presupuestoventasEncontrado!=null && permiteQuitar)  {
					presupuestoventass.remove(presupuestoventasEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PresupuestoVentas presupuestoventas,List<PresupuestoVentas> presupuestoventass) throws Exception {
		try	{			
			for(PresupuestoVentas presupuestoventasLocal:presupuestoventass) {
				if(presupuestoventasLocal.getId().equals(presupuestoventas.getId())) {
					presupuestoventasLocal.setIsSelected(presupuestoventas.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPresupuestoVentas(List<PresupuestoVentas> presupuestoventassAux) throws Exception {
		//this.presupuestoventassAux=presupuestoventassAux;
		
		for(PresupuestoVentas presupuestoventasAux:presupuestoventassAux) {
			if(presupuestoventasAux.getIsChanged()) {
				presupuestoventasAux.setIsChanged(false);
			}		
			
			if(presupuestoventasAux.getIsNew()) {
				presupuestoventasAux.setIsNew(false);
			}	
			
			if(presupuestoventasAux.getIsDeleted()) {
				presupuestoventasAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPresupuestoVentas(PresupuestoVentas presupuestoventasAux) throws Exception {
		//this.presupuestoventasAux=presupuestoventasAux;
		
			if(presupuestoventasAux.getIsChanged()) {
				presupuestoventasAux.setIsChanged(false);
			}		
			
			if(presupuestoventasAux.getIsNew()) {
				presupuestoventasAux.setIsNew(false);
			}	
			
			if(presupuestoventasAux.getIsDeleted()) {
				presupuestoventasAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PresupuestoVentas presupuestoventasAsignar,PresupuestoVentas presupuestoventas) throws Exception {
		presupuestoventasAsignar.setId(presupuestoventas.getId());	
		presupuestoventasAsignar.setVersionRow(presupuestoventas.getVersionRow());	
		presupuestoventasAsignar.setid_empresa(presupuestoventas.getid_empresa());
		presupuestoventasAsignar.setempresa_descripcion(presupuestoventas.getempresa_descripcion());	
		presupuestoventasAsignar.setid_sucursal(presupuestoventas.getid_sucursal());
		presupuestoventasAsignar.setsucursal_descripcion(presupuestoventas.getsucursal_descripcion());	
		presupuestoventasAsignar.setid_ejercicio(presupuestoventas.getid_ejercicio());
		presupuestoventasAsignar.setejercicio_descripcion(presupuestoventas.getejercicio_descripcion());	
		presupuestoventasAsignar.setid_periodo(presupuestoventas.getid_periodo());
		presupuestoventasAsignar.setperiodo_descripcion(presupuestoventas.getperiodo_descripcion());	
		presupuestoventasAsignar.setid_vendedor(presupuestoventas.getid_vendedor());
		presupuestoventasAsignar.setvendedor_descripcion(presupuestoventas.getvendedor_descripcion());	
		presupuestoventasAsignar.setid_pais(presupuestoventas.getid_pais());
		presupuestoventasAsignar.setpais_descripcion(presupuestoventas.getpais_descripcion());	
		presupuestoventasAsignar.setid_ciudad(presupuestoventas.getid_ciudad());
		presupuestoventasAsignar.setciudad_descripcion(presupuestoventas.getciudad_descripcion());	
		presupuestoventasAsignar.setid_zona(presupuestoventas.getid_zona());
		presupuestoventasAsignar.setzona_descripcion(presupuestoventas.getzona_descripcion());	
		presupuestoventasAsignar.setid_producto(presupuestoventas.getid_producto());
		presupuestoventasAsignar.setproducto_descripcion(presupuestoventas.getproducto_descripcion());	
		presupuestoventasAsignar.setprecio(presupuestoventas.getprecio());	
		presupuestoventasAsignar.setcantidad(presupuestoventas.getcantidad());	
		presupuestoventasAsignar.setvalor(presupuestoventas.getvalor());	
		presupuestoventasAsignar.setporcentaje(presupuestoventas.getporcentaje());	
		presupuestoventasAsignar.setcantidad_total(presupuestoventas.getcantidad_total());	
		presupuestoventasAsignar.setvalor_total(presupuestoventas.getvalor_total());	
	}
	
	public static void inicializarPresupuestoVentas(PresupuestoVentas presupuestoventas) throws Exception {
		try {
				presupuestoventas.setId(0L);	
					
				presupuestoventas.setid_empresa(-1L);	
				presupuestoventas.setid_sucursal(-1L);	
				presupuestoventas.setid_ejercicio(-1L);	
				presupuestoventas.setid_periodo(-1L);	
				presupuestoventas.setid_vendedor(-1L);	
				presupuestoventas.setid_pais(-1L);	
				presupuestoventas.setid_ciudad(-1L);	
				presupuestoventas.setid_zona(null);	
				presupuestoventas.setid_producto(-1L);	
				presupuestoventas.setprecio(0.0);	
				presupuestoventas.setcantidad(0);	
				presupuestoventas.setvalor(0.0);	
				presupuestoventas.setporcentaje(0.0);	
				presupuestoventas.setcantidad_total(0);	
				presupuestoventas.setvalor_total(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPresupuestoVentas(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasConstantesFunciones.LABEL_IDZONA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasConstantesFunciones.LABEL_CANTIDADTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasConstantesFunciones.LABEL_VALORTOTAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPresupuestoVentas(String sTipo,Row row,Workbook workbook,PresupuestoVentas presupuestoventas,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventas.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventas.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventas.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventas.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventas.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventas.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventas.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventas.getzona_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventas.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventas.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventas.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventas.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventas.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventas.getcantidad_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventas.getvalor_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPresupuestoVentas=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPresupuestoVentas() {
		return this.sFinalQueryPresupuestoVentas;
	}
	
	public void setsFinalQueryPresupuestoVentas(String sFinalQueryPresupuestoVentas) {
		this.sFinalQueryPresupuestoVentas= sFinalQueryPresupuestoVentas;
	}
	
	public Border resaltarSeleccionarPresupuestoVentas=null;
	
	public Border setResaltarSeleccionarPresupuestoVentas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasBeanSwingJInternalFrame presupuestoventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//presupuestoventasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentas.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPresupuestoVentas= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPresupuestoVentas() {
		return this.resaltarSeleccionarPresupuestoVentas;
	}
	
	public void setResaltarSeleccionarPresupuestoVentas(Border borderResaltarSeleccionarPresupuestoVentas) {
		this.resaltarSeleccionarPresupuestoVentas= borderResaltarSeleccionarPresupuestoVentas;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPresupuestoVentas=null;
	public Boolean mostraridPresupuestoVentas=true;
	public Boolean activaridPresupuestoVentas=true;

	public Border resaltarid_empresaPresupuestoVentas=null;
	public Boolean mostrarid_empresaPresupuestoVentas=true;
	public Boolean activarid_empresaPresupuestoVentas=true;
	public Boolean cargarid_empresaPresupuestoVentas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPresupuestoVentas=false;//ConEventDepend=true

	public Border resaltarid_sucursalPresupuestoVentas=null;
	public Boolean mostrarid_sucursalPresupuestoVentas=true;
	public Boolean activarid_sucursalPresupuestoVentas=true;
	public Boolean cargarid_sucursalPresupuestoVentas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalPresupuestoVentas=false;//ConEventDepend=true

	public Border resaltarid_ejercicioPresupuestoVentas=null;
	public Boolean mostrarid_ejercicioPresupuestoVentas=true;
	public Boolean activarid_ejercicioPresupuestoVentas=true;
	public Boolean cargarid_ejercicioPresupuestoVentas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioPresupuestoVentas=false;//ConEventDepend=true

	public Border resaltarid_periodoPresupuestoVentas=null;
	public Boolean mostrarid_periodoPresupuestoVentas=true;
	public Boolean activarid_periodoPresupuestoVentas=true;
	public Boolean cargarid_periodoPresupuestoVentas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoPresupuestoVentas=false;//ConEventDepend=true

	public Border resaltarid_vendedorPresupuestoVentas=null;
	public Boolean mostrarid_vendedorPresupuestoVentas=true;
	public Boolean activarid_vendedorPresupuestoVentas=true;
	public Boolean cargarid_vendedorPresupuestoVentas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorPresupuestoVentas=false;//ConEventDepend=true

	public Border resaltarid_paisPresupuestoVentas=null;
	public Boolean mostrarid_paisPresupuestoVentas=true;
	public Boolean activarid_paisPresupuestoVentas=true;
	public Boolean cargarid_paisPresupuestoVentas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisPresupuestoVentas=false;//ConEventDepend=true

	public Border resaltarid_ciudadPresupuestoVentas=null;
	public Boolean mostrarid_ciudadPresupuestoVentas=true;
	public Boolean activarid_ciudadPresupuestoVentas=true;
	public Boolean cargarid_ciudadPresupuestoVentas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ciudadPresupuestoVentas=false;//ConEventDepend=true

	public Border resaltarid_zonaPresupuestoVentas=null;
	public Boolean mostrarid_zonaPresupuestoVentas=true;
	public Boolean activarid_zonaPresupuestoVentas=true;
	public Boolean cargarid_zonaPresupuestoVentas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_zonaPresupuestoVentas=false;//ConEventDepend=true

	public Border resaltarid_productoPresupuestoVentas=null;
	public Boolean mostrarid_productoPresupuestoVentas=true;
	public Boolean activarid_productoPresupuestoVentas=true;
	public Boolean cargarid_productoPresupuestoVentas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoPresupuestoVentas=false;//ConEventDepend=true

	public Border resaltarprecioPresupuestoVentas=null;
	public Boolean mostrarprecioPresupuestoVentas=true;
	public Boolean activarprecioPresupuestoVentas=true;

	public Border resaltarcantidadPresupuestoVentas=null;
	public Boolean mostrarcantidadPresupuestoVentas=true;
	public Boolean activarcantidadPresupuestoVentas=true;

	public Border resaltarvalorPresupuestoVentas=null;
	public Boolean mostrarvalorPresupuestoVentas=true;
	public Boolean activarvalorPresupuestoVentas=true;

	public Border resaltarporcentajePresupuestoVentas=null;
	public Boolean mostrarporcentajePresupuestoVentas=true;
	public Boolean activarporcentajePresupuestoVentas=true;

	public Border resaltarcantidad_totalPresupuestoVentas=null;
	public Boolean mostrarcantidad_totalPresupuestoVentas=true;
	public Boolean activarcantidad_totalPresupuestoVentas=true;

	public Border resaltarvalor_totalPresupuestoVentas=null;
	public Boolean mostrarvalor_totalPresupuestoVentas=true;
	public Boolean activarvalor_totalPresupuestoVentas=true;

	
	

	public Border setResaltaridPresupuestoVentas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasBeanSwingJInternalFrame presupuestoventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentas.setBorder(borderResaltar);
		
		this.resaltaridPresupuestoVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPresupuestoVentas() {
		return this.resaltaridPresupuestoVentas;
	}

	public void setResaltaridPresupuestoVentas(Border borderResaltar) {
		this.resaltaridPresupuestoVentas= borderResaltar;
	}

	public Boolean getMostraridPresupuestoVentas() {
		return this.mostraridPresupuestoVentas;
	}

	public void setMostraridPresupuestoVentas(Boolean mostraridPresupuestoVentas) {
		this.mostraridPresupuestoVentas= mostraridPresupuestoVentas;
	}

	public Boolean getActivaridPresupuestoVentas() {
		return this.activaridPresupuestoVentas;
	}

	public void setActivaridPresupuestoVentas(Boolean activaridPresupuestoVentas) {
		this.activaridPresupuestoVentas= activaridPresupuestoVentas;
	}

	public Border setResaltarid_empresaPresupuestoVentas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasBeanSwingJInternalFrame presupuestoventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentas.setBorder(borderResaltar);
		
		this.resaltarid_empresaPresupuestoVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPresupuestoVentas() {
		return this.resaltarid_empresaPresupuestoVentas;
	}

	public void setResaltarid_empresaPresupuestoVentas(Border borderResaltar) {
		this.resaltarid_empresaPresupuestoVentas= borderResaltar;
	}

	public Boolean getMostrarid_empresaPresupuestoVentas() {
		return this.mostrarid_empresaPresupuestoVentas;
	}

	public void setMostrarid_empresaPresupuestoVentas(Boolean mostrarid_empresaPresupuestoVentas) {
		this.mostrarid_empresaPresupuestoVentas= mostrarid_empresaPresupuestoVentas;
	}

	public Boolean getActivarid_empresaPresupuestoVentas() {
		return this.activarid_empresaPresupuestoVentas;
	}

	public void setActivarid_empresaPresupuestoVentas(Boolean activarid_empresaPresupuestoVentas) {
		this.activarid_empresaPresupuestoVentas= activarid_empresaPresupuestoVentas;
	}

	public Boolean getCargarid_empresaPresupuestoVentas() {
		return this.cargarid_empresaPresupuestoVentas;
	}

	public void setCargarid_empresaPresupuestoVentas(Boolean cargarid_empresaPresupuestoVentas) {
		this.cargarid_empresaPresupuestoVentas= cargarid_empresaPresupuestoVentas;
	}

	public Border setResaltarid_sucursalPresupuestoVentas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasBeanSwingJInternalFrame presupuestoventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentas.setBorder(borderResaltar);
		
		this.resaltarid_sucursalPresupuestoVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalPresupuestoVentas() {
		return this.resaltarid_sucursalPresupuestoVentas;
	}

	public void setResaltarid_sucursalPresupuestoVentas(Border borderResaltar) {
		this.resaltarid_sucursalPresupuestoVentas= borderResaltar;
	}

	public Boolean getMostrarid_sucursalPresupuestoVentas() {
		return this.mostrarid_sucursalPresupuestoVentas;
	}

	public void setMostrarid_sucursalPresupuestoVentas(Boolean mostrarid_sucursalPresupuestoVentas) {
		this.mostrarid_sucursalPresupuestoVentas= mostrarid_sucursalPresupuestoVentas;
	}

	public Boolean getActivarid_sucursalPresupuestoVentas() {
		return this.activarid_sucursalPresupuestoVentas;
	}

	public void setActivarid_sucursalPresupuestoVentas(Boolean activarid_sucursalPresupuestoVentas) {
		this.activarid_sucursalPresupuestoVentas= activarid_sucursalPresupuestoVentas;
	}

	public Boolean getCargarid_sucursalPresupuestoVentas() {
		return this.cargarid_sucursalPresupuestoVentas;
	}

	public void setCargarid_sucursalPresupuestoVentas(Boolean cargarid_sucursalPresupuestoVentas) {
		this.cargarid_sucursalPresupuestoVentas= cargarid_sucursalPresupuestoVentas;
	}

	public Border setResaltarid_ejercicioPresupuestoVentas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasBeanSwingJInternalFrame presupuestoventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentas.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioPresupuestoVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioPresupuestoVentas() {
		return this.resaltarid_ejercicioPresupuestoVentas;
	}

	public void setResaltarid_ejercicioPresupuestoVentas(Border borderResaltar) {
		this.resaltarid_ejercicioPresupuestoVentas= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioPresupuestoVentas() {
		return this.mostrarid_ejercicioPresupuestoVentas;
	}

	public void setMostrarid_ejercicioPresupuestoVentas(Boolean mostrarid_ejercicioPresupuestoVentas) {
		this.mostrarid_ejercicioPresupuestoVentas= mostrarid_ejercicioPresupuestoVentas;
	}

	public Boolean getActivarid_ejercicioPresupuestoVentas() {
		return this.activarid_ejercicioPresupuestoVentas;
	}

	public void setActivarid_ejercicioPresupuestoVentas(Boolean activarid_ejercicioPresupuestoVentas) {
		this.activarid_ejercicioPresupuestoVentas= activarid_ejercicioPresupuestoVentas;
	}

	public Boolean getCargarid_ejercicioPresupuestoVentas() {
		return this.cargarid_ejercicioPresupuestoVentas;
	}

	public void setCargarid_ejercicioPresupuestoVentas(Boolean cargarid_ejercicioPresupuestoVentas) {
		this.cargarid_ejercicioPresupuestoVentas= cargarid_ejercicioPresupuestoVentas;
	}

	public Border setResaltarid_periodoPresupuestoVentas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasBeanSwingJInternalFrame presupuestoventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentas.setBorder(borderResaltar);
		
		this.resaltarid_periodoPresupuestoVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoPresupuestoVentas() {
		return this.resaltarid_periodoPresupuestoVentas;
	}

	public void setResaltarid_periodoPresupuestoVentas(Border borderResaltar) {
		this.resaltarid_periodoPresupuestoVentas= borderResaltar;
	}

	public Boolean getMostrarid_periodoPresupuestoVentas() {
		return this.mostrarid_periodoPresupuestoVentas;
	}

	public void setMostrarid_periodoPresupuestoVentas(Boolean mostrarid_periodoPresupuestoVentas) {
		this.mostrarid_periodoPresupuestoVentas= mostrarid_periodoPresupuestoVentas;
	}

	public Boolean getActivarid_periodoPresupuestoVentas() {
		return this.activarid_periodoPresupuestoVentas;
	}

	public void setActivarid_periodoPresupuestoVentas(Boolean activarid_periodoPresupuestoVentas) {
		this.activarid_periodoPresupuestoVentas= activarid_periodoPresupuestoVentas;
	}

	public Boolean getCargarid_periodoPresupuestoVentas() {
		return this.cargarid_periodoPresupuestoVentas;
	}

	public void setCargarid_periodoPresupuestoVentas(Boolean cargarid_periodoPresupuestoVentas) {
		this.cargarid_periodoPresupuestoVentas= cargarid_periodoPresupuestoVentas;
	}

	public Border setResaltarid_vendedorPresupuestoVentas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasBeanSwingJInternalFrame presupuestoventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentas.setBorder(borderResaltar);
		
		this.resaltarid_vendedorPresupuestoVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorPresupuestoVentas() {
		return this.resaltarid_vendedorPresupuestoVentas;
	}

	public void setResaltarid_vendedorPresupuestoVentas(Border borderResaltar) {
		this.resaltarid_vendedorPresupuestoVentas= borderResaltar;
	}

	public Boolean getMostrarid_vendedorPresupuestoVentas() {
		return this.mostrarid_vendedorPresupuestoVentas;
	}

	public void setMostrarid_vendedorPresupuestoVentas(Boolean mostrarid_vendedorPresupuestoVentas) {
		this.mostrarid_vendedorPresupuestoVentas= mostrarid_vendedorPresupuestoVentas;
	}

	public Boolean getActivarid_vendedorPresupuestoVentas() {
		return this.activarid_vendedorPresupuestoVentas;
	}

	public void setActivarid_vendedorPresupuestoVentas(Boolean activarid_vendedorPresupuestoVentas) {
		this.activarid_vendedorPresupuestoVentas= activarid_vendedorPresupuestoVentas;
	}

	public Boolean getCargarid_vendedorPresupuestoVentas() {
		return this.cargarid_vendedorPresupuestoVentas;
	}

	public void setCargarid_vendedorPresupuestoVentas(Boolean cargarid_vendedorPresupuestoVentas) {
		this.cargarid_vendedorPresupuestoVentas= cargarid_vendedorPresupuestoVentas;
	}

	public Border setResaltarid_paisPresupuestoVentas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasBeanSwingJInternalFrame presupuestoventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentas.setBorder(borderResaltar);
		
		this.resaltarid_paisPresupuestoVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisPresupuestoVentas() {
		return this.resaltarid_paisPresupuestoVentas;
	}

	public void setResaltarid_paisPresupuestoVentas(Border borderResaltar) {
		this.resaltarid_paisPresupuestoVentas= borderResaltar;
	}

	public Boolean getMostrarid_paisPresupuestoVentas() {
		return this.mostrarid_paisPresupuestoVentas;
	}

	public void setMostrarid_paisPresupuestoVentas(Boolean mostrarid_paisPresupuestoVentas) {
		this.mostrarid_paisPresupuestoVentas= mostrarid_paisPresupuestoVentas;
	}

	public Boolean getActivarid_paisPresupuestoVentas() {
		return this.activarid_paisPresupuestoVentas;
	}

	public void setActivarid_paisPresupuestoVentas(Boolean activarid_paisPresupuestoVentas) {
		this.activarid_paisPresupuestoVentas= activarid_paisPresupuestoVentas;
	}

	public Boolean getCargarid_paisPresupuestoVentas() {
		return this.cargarid_paisPresupuestoVentas;
	}

	public void setCargarid_paisPresupuestoVentas(Boolean cargarid_paisPresupuestoVentas) {
		this.cargarid_paisPresupuestoVentas= cargarid_paisPresupuestoVentas;
	}

	public Border setResaltarid_ciudadPresupuestoVentas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasBeanSwingJInternalFrame presupuestoventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentas.setBorder(borderResaltar);
		
		this.resaltarid_ciudadPresupuestoVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ciudadPresupuestoVentas() {
		return this.resaltarid_ciudadPresupuestoVentas;
	}

	public void setResaltarid_ciudadPresupuestoVentas(Border borderResaltar) {
		this.resaltarid_ciudadPresupuestoVentas= borderResaltar;
	}

	public Boolean getMostrarid_ciudadPresupuestoVentas() {
		return this.mostrarid_ciudadPresupuestoVentas;
	}

	public void setMostrarid_ciudadPresupuestoVentas(Boolean mostrarid_ciudadPresupuestoVentas) {
		this.mostrarid_ciudadPresupuestoVentas= mostrarid_ciudadPresupuestoVentas;
	}

	public Boolean getActivarid_ciudadPresupuestoVentas() {
		return this.activarid_ciudadPresupuestoVentas;
	}

	public void setActivarid_ciudadPresupuestoVentas(Boolean activarid_ciudadPresupuestoVentas) {
		this.activarid_ciudadPresupuestoVentas= activarid_ciudadPresupuestoVentas;
	}

	public Boolean getCargarid_ciudadPresupuestoVentas() {
		return this.cargarid_ciudadPresupuestoVentas;
	}

	public void setCargarid_ciudadPresupuestoVentas(Boolean cargarid_ciudadPresupuestoVentas) {
		this.cargarid_ciudadPresupuestoVentas= cargarid_ciudadPresupuestoVentas;
	}

	public Border setResaltarid_zonaPresupuestoVentas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasBeanSwingJInternalFrame presupuestoventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentas.setBorder(borderResaltar);
		
		this.resaltarid_zonaPresupuestoVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_zonaPresupuestoVentas() {
		return this.resaltarid_zonaPresupuestoVentas;
	}

	public void setResaltarid_zonaPresupuestoVentas(Border borderResaltar) {
		this.resaltarid_zonaPresupuestoVentas= borderResaltar;
	}

	public Boolean getMostrarid_zonaPresupuestoVentas() {
		return this.mostrarid_zonaPresupuestoVentas;
	}

	public void setMostrarid_zonaPresupuestoVentas(Boolean mostrarid_zonaPresupuestoVentas) {
		this.mostrarid_zonaPresupuestoVentas= mostrarid_zonaPresupuestoVentas;
	}

	public Boolean getActivarid_zonaPresupuestoVentas() {
		return this.activarid_zonaPresupuestoVentas;
	}

	public void setActivarid_zonaPresupuestoVentas(Boolean activarid_zonaPresupuestoVentas) {
		this.activarid_zonaPresupuestoVentas= activarid_zonaPresupuestoVentas;
	}

	public Boolean getCargarid_zonaPresupuestoVentas() {
		return this.cargarid_zonaPresupuestoVentas;
	}

	public void setCargarid_zonaPresupuestoVentas(Boolean cargarid_zonaPresupuestoVentas) {
		this.cargarid_zonaPresupuestoVentas= cargarid_zonaPresupuestoVentas;
	}

	public Border setResaltarid_productoPresupuestoVentas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasBeanSwingJInternalFrame presupuestoventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentas.setBorder(borderResaltar);
		
		this.resaltarid_productoPresupuestoVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoPresupuestoVentas() {
		return this.resaltarid_productoPresupuestoVentas;
	}

	public void setResaltarid_productoPresupuestoVentas(Border borderResaltar) {
		this.resaltarid_productoPresupuestoVentas= borderResaltar;
	}

	public Boolean getMostrarid_productoPresupuestoVentas() {
		return this.mostrarid_productoPresupuestoVentas;
	}

	public void setMostrarid_productoPresupuestoVentas(Boolean mostrarid_productoPresupuestoVentas) {
		this.mostrarid_productoPresupuestoVentas= mostrarid_productoPresupuestoVentas;
	}

	public Boolean getActivarid_productoPresupuestoVentas() {
		return this.activarid_productoPresupuestoVentas;
	}

	public void setActivarid_productoPresupuestoVentas(Boolean activarid_productoPresupuestoVentas) {
		this.activarid_productoPresupuestoVentas= activarid_productoPresupuestoVentas;
	}

	public Boolean getCargarid_productoPresupuestoVentas() {
		return this.cargarid_productoPresupuestoVentas;
	}

	public void setCargarid_productoPresupuestoVentas(Boolean cargarid_productoPresupuestoVentas) {
		this.cargarid_productoPresupuestoVentas= cargarid_productoPresupuestoVentas;
	}

	public Border setResaltarprecioPresupuestoVentas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasBeanSwingJInternalFrame presupuestoventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentas.setBorder(borderResaltar);
		
		this.resaltarprecioPresupuestoVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioPresupuestoVentas() {
		return this.resaltarprecioPresupuestoVentas;
	}

	public void setResaltarprecioPresupuestoVentas(Border borderResaltar) {
		this.resaltarprecioPresupuestoVentas= borderResaltar;
	}

	public Boolean getMostrarprecioPresupuestoVentas() {
		return this.mostrarprecioPresupuestoVentas;
	}

	public void setMostrarprecioPresupuestoVentas(Boolean mostrarprecioPresupuestoVentas) {
		this.mostrarprecioPresupuestoVentas= mostrarprecioPresupuestoVentas;
	}

	public Boolean getActivarprecioPresupuestoVentas() {
		return this.activarprecioPresupuestoVentas;
	}

	public void setActivarprecioPresupuestoVentas(Boolean activarprecioPresupuestoVentas) {
		this.activarprecioPresupuestoVentas= activarprecioPresupuestoVentas;
	}

	public Border setResaltarcantidadPresupuestoVentas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasBeanSwingJInternalFrame presupuestoventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentas.setBorder(borderResaltar);
		
		this.resaltarcantidadPresupuestoVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadPresupuestoVentas() {
		return this.resaltarcantidadPresupuestoVentas;
	}

	public void setResaltarcantidadPresupuestoVentas(Border borderResaltar) {
		this.resaltarcantidadPresupuestoVentas= borderResaltar;
	}

	public Boolean getMostrarcantidadPresupuestoVentas() {
		return this.mostrarcantidadPresupuestoVentas;
	}

	public void setMostrarcantidadPresupuestoVentas(Boolean mostrarcantidadPresupuestoVentas) {
		this.mostrarcantidadPresupuestoVentas= mostrarcantidadPresupuestoVentas;
	}

	public Boolean getActivarcantidadPresupuestoVentas() {
		return this.activarcantidadPresupuestoVentas;
	}

	public void setActivarcantidadPresupuestoVentas(Boolean activarcantidadPresupuestoVentas) {
		this.activarcantidadPresupuestoVentas= activarcantidadPresupuestoVentas;
	}

	public Border setResaltarvalorPresupuestoVentas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasBeanSwingJInternalFrame presupuestoventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentas.setBorder(borderResaltar);
		
		this.resaltarvalorPresupuestoVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorPresupuestoVentas() {
		return this.resaltarvalorPresupuestoVentas;
	}

	public void setResaltarvalorPresupuestoVentas(Border borderResaltar) {
		this.resaltarvalorPresupuestoVentas= borderResaltar;
	}

	public Boolean getMostrarvalorPresupuestoVentas() {
		return this.mostrarvalorPresupuestoVentas;
	}

	public void setMostrarvalorPresupuestoVentas(Boolean mostrarvalorPresupuestoVentas) {
		this.mostrarvalorPresupuestoVentas= mostrarvalorPresupuestoVentas;
	}

	public Boolean getActivarvalorPresupuestoVentas() {
		return this.activarvalorPresupuestoVentas;
	}

	public void setActivarvalorPresupuestoVentas(Boolean activarvalorPresupuestoVentas) {
		this.activarvalorPresupuestoVentas= activarvalorPresupuestoVentas;
	}

	public Border setResaltarporcentajePresupuestoVentas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasBeanSwingJInternalFrame presupuestoventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentas.setBorder(borderResaltar);
		
		this.resaltarporcentajePresupuestoVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajePresupuestoVentas() {
		return this.resaltarporcentajePresupuestoVentas;
	}

	public void setResaltarporcentajePresupuestoVentas(Border borderResaltar) {
		this.resaltarporcentajePresupuestoVentas= borderResaltar;
	}

	public Boolean getMostrarporcentajePresupuestoVentas() {
		return this.mostrarporcentajePresupuestoVentas;
	}

	public void setMostrarporcentajePresupuestoVentas(Boolean mostrarporcentajePresupuestoVentas) {
		this.mostrarporcentajePresupuestoVentas= mostrarporcentajePresupuestoVentas;
	}

	public Boolean getActivarporcentajePresupuestoVentas() {
		return this.activarporcentajePresupuestoVentas;
	}

	public void setActivarporcentajePresupuestoVentas(Boolean activarporcentajePresupuestoVentas) {
		this.activarporcentajePresupuestoVentas= activarporcentajePresupuestoVentas;
	}

	public Border setResaltarcantidad_totalPresupuestoVentas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasBeanSwingJInternalFrame presupuestoventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentas.setBorder(borderResaltar);
		
		this.resaltarcantidad_totalPresupuestoVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_totalPresupuestoVentas() {
		return this.resaltarcantidad_totalPresupuestoVentas;
	}

	public void setResaltarcantidad_totalPresupuestoVentas(Border borderResaltar) {
		this.resaltarcantidad_totalPresupuestoVentas= borderResaltar;
	}

	public Boolean getMostrarcantidad_totalPresupuestoVentas() {
		return this.mostrarcantidad_totalPresupuestoVentas;
	}

	public void setMostrarcantidad_totalPresupuestoVentas(Boolean mostrarcantidad_totalPresupuestoVentas) {
		this.mostrarcantidad_totalPresupuestoVentas= mostrarcantidad_totalPresupuestoVentas;
	}

	public Boolean getActivarcantidad_totalPresupuestoVentas() {
		return this.activarcantidad_totalPresupuestoVentas;
	}

	public void setActivarcantidad_totalPresupuestoVentas(Boolean activarcantidad_totalPresupuestoVentas) {
		this.activarcantidad_totalPresupuestoVentas= activarcantidad_totalPresupuestoVentas;
	}

	public Border setResaltarvalor_totalPresupuestoVentas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasBeanSwingJInternalFrame presupuestoventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentas.setBorder(borderResaltar);
		
		this.resaltarvalor_totalPresupuestoVentas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_totalPresupuestoVentas() {
		return this.resaltarvalor_totalPresupuestoVentas;
	}

	public void setResaltarvalor_totalPresupuestoVentas(Border borderResaltar) {
		this.resaltarvalor_totalPresupuestoVentas= borderResaltar;
	}

	public Boolean getMostrarvalor_totalPresupuestoVentas() {
		return this.mostrarvalor_totalPresupuestoVentas;
	}

	public void setMostrarvalor_totalPresupuestoVentas(Boolean mostrarvalor_totalPresupuestoVentas) {
		this.mostrarvalor_totalPresupuestoVentas= mostrarvalor_totalPresupuestoVentas;
	}

	public Boolean getActivarvalor_totalPresupuestoVentas() {
		return this.activarvalor_totalPresupuestoVentas;
	}

	public void setActivarvalor_totalPresupuestoVentas(Boolean activarvalor_totalPresupuestoVentas) {
		this.activarvalor_totalPresupuestoVentas= activarvalor_totalPresupuestoVentas;
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
		
		
		this.setMostraridPresupuestoVentas(esInicial);
		this.setMostrarid_empresaPresupuestoVentas(esInicial);
		this.setMostrarid_sucursalPresupuestoVentas(esInicial);
		this.setMostrarid_ejercicioPresupuestoVentas(esInicial);
		this.setMostrarid_periodoPresupuestoVentas(esInicial);
		this.setMostrarid_vendedorPresupuestoVentas(esInicial);
		this.setMostrarid_paisPresupuestoVentas(esInicial);
		this.setMostrarid_ciudadPresupuestoVentas(esInicial);
		this.setMostrarid_zonaPresupuestoVentas(esInicial);
		this.setMostrarid_productoPresupuestoVentas(esInicial);
		this.setMostrarprecioPresupuestoVentas(esInicial);
		this.setMostrarcantidadPresupuestoVentas(esInicial);
		this.setMostrarvalorPresupuestoVentas(esInicial);
		this.setMostrarporcentajePresupuestoVentas(esInicial);
		this.setMostrarcantidad_totalPresupuestoVentas(esInicial);
		this.setMostrarvalor_totalPresupuestoVentas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.ID)) {
				this.setMostraridPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.IDCIUDAD)) {
				this.setMostrarid_ciudadPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.IDZONA)) {
				this.setMostrarid_zonaPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.PRECIO)) {
				this.setMostrarprecioPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.VALOR)) {
				this.setMostrarvalorPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajePresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.CANTIDADTOTAL)) {
				this.setMostrarcantidad_totalPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.VALORTOTAL)) {
				this.setMostrarvalor_totalPresupuestoVentas(esAsigna);
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
		
		
		this.setActivaridPresupuestoVentas(esInicial);
		this.setActivarid_empresaPresupuestoVentas(esInicial);
		this.setActivarid_sucursalPresupuestoVentas(esInicial);
		this.setActivarid_ejercicioPresupuestoVentas(esInicial);
		this.setActivarid_periodoPresupuestoVentas(esInicial);
		this.setActivarid_vendedorPresupuestoVentas(esInicial);
		this.setActivarid_paisPresupuestoVentas(esInicial);
		this.setActivarid_ciudadPresupuestoVentas(esInicial);
		this.setActivarid_zonaPresupuestoVentas(esInicial);
		this.setActivarid_productoPresupuestoVentas(esInicial);
		this.setActivarprecioPresupuestoVentas(esInicial);
		this.setActivarcantidadPresupuestoVentas(esInicial);
		this.setActivarvalorPresupuestoVentas(esInicial);
		this.setActivarporcentajePresupuestoVentas(esInicial);
		this.setActivarcantidad_totalPresupuestoVentas(esInicial);
		this.setActivarvalor_totalPresupuestoVentas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.ID)) {
				this.setActivaridPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.IDCIUDAD)) {
				this.setActivarid_ciudadPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.IDZONA)) {
				this.setActivarid_zonaPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.PRECIO)) {
				this.setActivarprecioPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.VALOR)) {
				this.setActivarvalorPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajePresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.CANTIDADTOTAL)) {
				this.setActivarcantidad_totalPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.VALORTOTAL)) {
				this.setActivarvalor_totalPresupuestoVentas(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PresupuestoVentasBeanSwingJInternalFrame presupuestoventasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPresupuestoVentas(esInicial);
		this.setResaltarid_empresaPresupuestoVentas(esInicial);
		this.setResaltarid_sucursalPresupuestoVentas(esInicial);
		this.setResaltarid_ejercicioPresupuestoVentas(esInicial);
		this.setResaltarid_periodoPresupuestoVentas(esInicial);
		this.setResaltarid_vendedorPresupuestoVentas(esInicial);
		this.setResaltarid_paisPresupuestoVentas(esInicial);
		this.setResaltarid_ciudadPresupuestoVentas(esInicial);
		this.setResaltarid_zonaPresupuestoVentas(esInicial);
		this.setResaltarid_productoPresupuestoVentas(esInicial);
		this.setResaltarprecioPresupuestoVentas(esInicial);
		this.setResaltarcantidadPresupuestoVentas(esInicial);
		this.setResaltarvalorPresupuestoVentas(esInicial);
		this.setResaltarporcentajePresupuestoVentas(esInicial);
		this.setResaltarcantidad_totalPresupuestoVentas(esInicial);
		this.setResaltarvalor_totalPresupuestoVentas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.ID)) {
				this.setResaltaridPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.IDCIUDAD)) {
				this.setResaltarid_ciudadPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.IDZONA)) {
				this.setResaltarid_zonaPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.PRECIO)) {
				this.setResaltarprecioPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.VALOR)) {
				this.setResaltarvalorPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajePresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.CANTIDADTOTAL)) {
				this.setResaltarcantidad_totalPresupuestoVentas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasConstantesFunciones.VALORTOTAL)) {
				this.setResaltarvalor_totalPresupuestoVentas(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PresupuestoVentasBeanSwingJInternalFrame presupuestoventasBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCiudadPresupuestoVentas=true;

	public Boolean getMostrarFK_IdCiudadPresupuestoVentas() {
		return this.mostrarFK_IdCiudadPresupuestoVentas;
	}

	public void setMostrarFK_IdCiudadPresupuestoVentas(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCiudadPresupuestoVentas= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioPresupuestoVentas=true;

	public Boolean getMostrarFK_IdEjercicioPresupuestoVentas() {
		return this.mostrarFK_IdEjercicioPresupuestoVentas;
	}

	public void setMostrarFK_IdEjercicioPresupuestoVentas(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioPresupuestoVentas= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaPresupuestoVentas=true;

	public Boolean getMostrarFK_IdEmpresaPresupuestoVentas() {
		return this.mostrarFK_IdEmpresaPresupuestoVentas;
	}

	public void setMostrarFK_IdEmpresaPresupuestoVentas(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPresupuestoVentas= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisPresupuestoVentas=true;

	public Boolean getMostrarFK_IdPaisPresupuestoVentas() {
		return this.mostrarFK_IdPaisPresupuestoVentas;
	}

	public void setMostrarFK_IdPaisPresupuestoVentas(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisPresupuestoVentas= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoPresupuestoVentas=true;

	public Boolean getMostrarFK_IdPeriodoPresupuestoVentas() {
		return this.mostrarFK_IdPeriodoPresupuestoVentas;
	}

	public void setMostrarFK_IdPeriodoPresupuestoVentas(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoPresupuestoVentas= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoPresupuestoVentas=true;

	public Boolean getMostrarFK_IdProductoPresupuestoVentas() {
		return this.mostrarFK_IdProductoPresupuestoVentas;
	}

	public void setMostrarFK_IdProductoPresupuestoVentas(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoPresupuestoVentas= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalPresupuestoVentas=true;

	public Boolean getMostrarFK_IdSucursalPresupuestoVentas() {
		return this.mostrarFK_IdSucursalPresupuestoVentas;
	}

	public void setMostrarFK_IdSucursalPresupuestoVentas(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalPresupuestoVentas= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdVendedorPresupuestoVentas=true;

	public Boolean getMostrarFK_IdVendedorPresupuestoVentas() {
		return this.mostrarFK_IdVendedorPresupuestoVentas;
	}

	public void setMostrarFK_IdVendedorPresupuestoVentas(Boolean visibilidadResaltar) {
		this.mostrarFK_IdVendedorPresupuestoVentas= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdZonaPresupuestoVentas=true;

	public Boolean getMostrarFK_IdZonaPresupuestoVentas() {
		return this.mostrarFK_IdZonaPresupuestoVentas;
	}

	public void setMostrarFK_IdZonaPresupuestoVentas(Boolean visibilidadResaltar) {
		this.mostrarFK_IdZonaPresupuestoVentas= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCiudadPresupuestoVentas=true;

	public Boolean getActivarFK_IdCiudadPresupuestoVentas() {
		return this.activarFK_IdCiudadPresupuestoVentas;
	}

	public void setActivarFK_IdCiudadPresupuestoVentas(Boolean habilitarResaltar) {
		this.activarFK_IdCiudadPresupuestoVentas= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioPresupuestoVentas=true;

	public Boolean getActivarFK_IdEjercicioPresupuestoVentas() {
		return this.activarFK_IdEjercicioPresupuestoVentas;
	}

	public void setActivarFK_IdEjercicioPresupuestoVentas(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioPresupuestoVentas= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaPresupuestoVentas=true;

	public Boolean getActivarFK_IdEmpresaPresupuestoVentas() {
		return this.activarFK_IdEmpresaPresupuestoVentas;
	}

	public void setActivarFK_IdEmpresaPresupuestoVentas(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPresupuestoVentas= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisPresupuestoVentas=true;

	public Boolean getActivarFK_IdPaisPresupuestoVentas() {
		return this.activarFK_IdPaisPresupuestoVentas;
	}

	public void setActivarFK_IdPaisPresupuestoVentas(Boolean habilitarResaltar) {
		this.activarFK_IdPaisPresupuestoVentas= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoPresupuestoVentas=true;

	public Boolean getActivarFK_IdPeriodoPresupuestoVentas() {
		return this.activarFK_IdPeriodoPresupuestoVentas;
	}

	public void setActivarFK_IdPeriodoPresupuestoVentas(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoPresupuestoVentas= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoPresupuestoVentas=true;

	public Boolean getActivarFK_IdProductoPresupuestoVentas() {
		return this.activarFK_IdProductoPresupuestoVentas;
	}

	public void setActivarFK_IdProductoPresupuestoVentas(Boolean habilitarResaltar) {
		this.activarFK_IdProductoPresupuestoVentas= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalPresupuestoVentas=true;

	public Boolean getActivarFK_IdSucursalPresupuestoVentas() {
		return this.activarFK_IdSucursalPresupuestoVentas;
	}

	public void setActivarFK_IdSucursalPresupuestoVentas(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalPresupuestoVentas= habilitarResaltar;
	}

	public Boolean activarFK_IdVendedorPresupuestoVentas=true;

	public Boolean getActivarFK_IdVendedorPresupuestoVentas() {
		return this.activarFK_IdVendedorPresupuestoVentas;
	}

	public void setActivarFK_IdVendedorPresupuestoVentas(Boolean habilitarResaltar) {
		this.activarFK_IdVendedorPresupuestoVentas= habilitarResaltar;
	}

	public Boolean activarFK_IdZonaPresupuestoVentas=true;

	public Boolean getActivarFK_IdZonaPresupuestoVentas() {
		return this.activarFK_IdZonaPresupuestoVentas;
	}

	public void setActivarFK_IdZonaPresupuestoVentas(Boolean habilitarResaltar) {
		this.activarFK_IdZonaPresupuestoVentas= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCiudadPresupuestoVentas=null;

	public Border getResaltarFK_IdCiudadPresupuestoVentas() {
		return this.resaltarFK_IdCiudadPresupuestoVentas;
	}

	public void setResaltarFK_IdCiudadPresupuestoVentas(Border borderResaltar) {
		this.resaltarFK_IdCiudadPresupuestoVentas= borderResaltar;
	}

	public void setResaltarFK_IdCiudadPresupuestoVentas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasBeanSwingJInternalFrame presupuestoventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCiudadPresupuestoVentas= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioPresupuestoVentas=null;

	public Border getResaltarFK_IdEjercicioPresupuestoVentas() {
		return this.resaltarFK_IdEjercicioPresupuestoVentas;
	}

	public void setResaltarFK_IdEjercicioPresupuestoVentas(Border borderResaltar) {
		this.resaltarFK_IdEjercicioPresupuestoVentas= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioPresupuestoVentas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasBeanSwingJInternalFrame presupuestoventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioPresupuestoVentas= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaPresupuestoVentas=null;

	public Border getResaltarFK_IdEmpresaPresupuestoVentas() {
		return this.resaltarFK_IdEmpresaPresupuestoVentas;
	}

	public void setResaltarFK_IdEmpresaPresupuestoVentas(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPresupuestoVentas= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPresupuestoVentas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasBeanSwingJInternalFrame presupuestoventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPresupuestoVentas= borderResaltar;
	}

	public Border resaltarFK_IdPaisPresupuestoVentas=null;

	public Border getResaltarFK_IdPaisPresupuestoVentas() {
		return this.resaltarFK_IdPaisPresupuestoVentas;
	}

	public void setResaltarFK_IdPaisPresupuestoVentas(Border borderResaltar) {
		this.resaltarFK_IdPaisPresupuestoVentas= borderResaltar;
	}

	public void setResaltarFK_IdPaisPresupuestoVentas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasBeanSwingJInternalFrame presupuestoventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisPresupuestoVentas= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoPresupuestoVentas=null;

	public Border getResaltarFK_IdPeriodoPresupuestoVentas() {
		return this.resaltarFK_IdPeriodoPresupuestoVentas;
	}

	public void setResaltarFK_IdPeriodoPresupuestoVentas(Border borderResaltar) {
		this.resaltarFK_IdPeriodoPresupuestoVentas= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoPresupuestoVentas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasBeanSwingJInternalFrame presupuestoventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoPresupuestoVentas= borderResaltar;
	}

	public Border resaltarFK_IdProductoPresupuestoVentas=null;

	public Border getResaltarFK_IdProductoPresupuestoVentas() {
		return this.resaltarFK_IdProductoPresupuestoVentas;
	}

	public void setResaltarFK_IdProductoPresupuestoVentas(Border borderResaltar) {
		this.resaltarFK_IdProductoPresupuestoVentas= borderResaltar;
	}

	public void setResaltarFK_IdProductoPresupuestoVentas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasBeanSwingJInternalFrame presupuestoventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoPresupuestoVentas= borderResaltar;
	}

	public Border resaltarFK_IdSucursalPresupuestoVentas=null;

	public Border getResaltarFK_IdSucursalPresupuestoVentas() {
		return this.resaltarFK_IdSucursalPresupuestoVentas;
	}

	public void setResaltarFK_IdSucursalPresupuestoVentas(Border borderResaltar) {
		this.resaltarFK_IdSucursalPresupuestoVentas= borderResaltar;
	}

	public void setResaltarFK_IdSucursalPresupuestoVentas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasBeanSwingJInternalFrame presupuestoventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalPresupuestoVentas= borderResaltar;
	}

	public Border resaltarFK_IdVendedorPresupuestoVentas=null;

	public Border getResaltarFK_IdVendedorPresupuestoVentas() {
		return this.resaltarFK_IdVendedorPresupuestoVentas;
	}

	public void setResaltarFK_IdVendedorPresupuestoVentas(Border borderResaltar) {
		this.resaltarFK_IdVendedorPresupuestoVentas= borderResaltar;
	}

	public void setResaltarFK_IdVendedorPresupuestoVentas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasBeanSwingJInternalFrame presupuestoventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdVendedorPresupuestoVentas= borderResaltar;
	}

	public Border resaltarFK_IdZonaPresupuestoVentas=null;

	public Border getResaltarFK_IdZonaPresupuestoVentas() {
		return this.resaltarFK_IdZonaPresupuestoVentas;
	}

	public void setResaltarFK_IdZonaPresupuestoVentas(Border borderResaltar) {
		this.resaltarFK_IdZonaPresupuestoVentas= borderResaltar;
	}

	public void setResaltarFK_IdZonaPresupuestoVentas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasBeanSwingJInternalFrame presupuestoventasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdZonaPresupuestoVentas= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}