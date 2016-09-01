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


import com.bydan.erp.facturacion.util.PresupuestoVentasLineasConstantesFunciones;
import com.bydan.erp.facturacion.util.PresupuestoVentasLineasParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.PresupuestoVentasLineasParameterGeneral;

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
final public class PresupuestoVentasLineasConstantesFunciones extends PresupuestoVentasLineasConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PresupuestoVentasLineas";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PresupuestoVentasLineas"+PresupuestoVentasLineasConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PresupuestoVentasLineasHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PresupuestoVentasLineasHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PresupuestoVentasLineasConstantesFunciones.SCHEMA+"_"+PresupuestoVentasLineasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PresupuestoVentasLineasHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PresupuestoVentasLineasConstantesFunciones.SCHEMA+"_"+PresupuestoVentasLineasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PresupuestoVentasLineasConstantesFunciones.SCHEMA+"_"+PresupuestoVentasLineasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PresupuestoVentasLineasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PresupuestoVentasLineasConstantesFunciones.SCHEMA+"_"+PresupuestoVentasLineasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestoVentasLineasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PresupuestoVentasLineasHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestoVentasLineasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestoVentasLineasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PresupuestoVentasLineasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestoVentasLineasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PresupuestoVentasLineasConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PresupuestoVentasLineasConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PresupuestoVentasLineasConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PresupuestoVentasLineasConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Presupuesto Ventas_lineases";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Presupuesto Ventas_lineas";
	public static final String SCLASSWEBTITULO_LOWER="Presupuesto Ventas Lineas";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PresupuestoVentasLineas";
	public static final String OBJECTNAME="presupuestoventaslineas";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="presupuesto_ventas_lineas";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select presupuestoventaslineas from "+PresupuestoVentasLineasConstantesFunciones.SPERSISTENCENAME+" presupuestoventaslineas";
	public static String QUERYSELECTNATIVE="select "+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".id,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".version_row,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".id_empresa,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".id_sucursal,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".id_ejercicio,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".id_periodo,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".id_vendedor,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".id_pais,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".id_ciudad,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".id_zona,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".id_linea,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".id_linea_grupo,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".id_linea_categoria,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".id_linea_marca,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".precio,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".cantidad,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".valor,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".porcentaje,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".cantidad_total,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".valor_total from "+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME;//+" as "+PresupuestoVentasLineasConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PresupuestoVentasLineasConstantesFuncionesAdditional presupuestoventaslineasConstantesFuncionesAdditional=null;
	
	public PresupuestoVentasLineasConstantesFuncionesAdditional getPresupuestoVentasLineasConstantesFuncionesAdditional() {
		return this.presupuestoventaslineasConstantesFuncionesAdditional;
	}
	
	public void setPresupuestoVentasLineasConstantesFuncionesAdditional(PresupuestoVentasLineasConstantesFuncionesAdditional presupuestoventaslineasConstantesFuncionesAdditional) {
		try {
			this.presupuestoventaslineasConstantesFuncionesAdditional=presupuestoventaslineasConstantesFuncionesAdditional;
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
    public static final String IDLINEA= "id_linea";
    public static final String IDLINEAGRUPO= "id_linea_grupo";
    public static final String IDLINEACATEGORIA= "id_linea_categoria";
    public static final String IDLINEAMARCA= "id_linea_marca";
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
    	public static final String LABEL_IDLINEA= "Linea";
		public static final String LABEL_IDLINEA_LOWER= "Linea";
    	public static final String LABEL_IDLINEAGRUPO= "Linea Grupo";
		public static final String LABEL_IDLINEAGRUPO_LOWER= "Linea Grupo";
    	public static final String LABEL_IDLINEACATEGORIA= "Linea Categoria";
		public static final String LABEL_IDLINEACATEGORIA_LOWER= "Linea Categoria";
    	public static final String LABEL_IDLINEAMARCA= "Linea Marca";
		public static final String LABEL_IDLINEAMARCA_LOWER= "Linea Marca";
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
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getPresupuestoVentasLineasLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PresupuestoVentasLineasConstantesFunciones.IDEMPRESA)) {sLabelColumna=PresupuestoVentasLineasConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PresupuestoVentasLineasConstantesFunciones.IDSUCURSAL)) {sLabelColumna=PresupuestoVentasLineasConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(PresupuestoVentasLineasConstantesFunciones.IDEJERCICIO)) {sLabelColumna=PresupuestoVentasLineasConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(PresupuestoVentasLineasConstantesFunciones.IDPERIODO)) {sLabelColumna=PresupuestoVentasLineasConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(PresupuestoVentasLineasConstantesFunciones.IDVENDEDOR)) {sLabelColumna=PresupuestoVentasLineasConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(PresupuestoVentasLineasConstantesFunciones.IDPAIS)) {sLabelColumna=PresupuestoVentasLineasConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(PresupuestoVentasLineasConstantesFunciones.IDCIUDAD)) {sLabelColumna=PresupuestoVentasLineasConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(PresupuestoVentasLineasConstantesFunciones.IDZONA)) {sLabelColumna=PresupuestoVentasLineasConstantesFunciones.LABEL_IDZONA;}
		if(sNombreColumna.equals(PresupuestoVentasLineasConstantesFunciones.IDLINEA)) {sLabelColumna=PresupuestoVentasLineasConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(PresupuestoVentasLineasConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=PresupuestoVentasLineasConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(PresupuestoVentasLineasConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=PresupuestoVentasLineasConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(PresupuestoVentasLineasConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=PresupuestoVentasLineasConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(PresupuestoVentasLineasConstantesFunciones.PRECIO)) {sLabelColumna=PresupuestoVentasLineasConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(PresupuestoVentasLineasConstantesFunciones.CANTIDAD)) {sLabelColumna=PresupuestoVentasLineasConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(PresupuestoVentasLineasConstantesFunciones.VALOR)) {sLabelColumna=PresupuestoVentasLineasConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(PresupuestoVentasLineasConstantesFunciones.PORCENTAJE)) {sLabelColumna=PresupuestoVentasLineasConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(PresupuestoVentasLineasConstantesFunciones.CANTIDADTOTAL)) {sLabelColumna=PresupuestoVentasLineasConstantesFunciones.LABEL_CANTIDADTOTAL;}
		if(sNombreColumna.equals(PresupuestoVentasLineasConstantesFunciones.VALORTOTAL)) {sLabelColumna=PresupuestoVentasLineasConstantesFunciones.LABEL_VALORTOTAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getPresupuestoVentasLineasDescripcion(PresupuestoVentasLineas presupuestoventaslineas) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(presupuestoventaslineas !=null/* && presupuestoventaslineas.getId()!=0*/) {
			if(presupuestoventaslineas.getId()!=null) {
				sDescripcion=presupuestoventaslineas.getId().toString();
			}//presupuestoventaslineaspresupuestoventaslineas.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPresupuestoVentasLineasDescripcionDetallado(PresupuestoVentasLineas presupuestoventaslineas) {
		String sDescripcion="";
			
		sDescripcion+=PresupuestoVentasLineasConstantesFunciones.ID+"=";
		sDescripcion+=presupuestoventaslineas.getId().toString()+",";
		sDescripcion+=PresupuestoVentasLineasConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=presupuestoventaslineas.getVersionRow().toString()+",";
		sDescripcion+=PresupuestoVentasLineasConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=presupuestoventaslineas.getid_empresa().toString()+",";
		sDescripcion+=PresupuestoVentasLineasConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=presupuestoventaslineas.getid_sucursal().toString()+",";
		sDescripcion+=PresupuestoVentasLineasConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=presupuestoventaslineas.getid_ejercicio().toString()+",";
		sDescripcion+=PresupuestoVentasLineasConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=presupuestoventaslineas.getid_periodo().toString()+",";
		sDescripcion+=PresupuestoVentasLineasConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=presupuestoventaslineas.getid_vendedor().toString()+",";
		sDescripcion+=PresupuestoVentasLineasConstantesFunciones.IDPAIS+"=";
		sDescripcion+=presupuestoventaslineas.getid_pais().toString()+",";
		sDescripcion+=PresupuestoVentasLineasConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=presupuestoventaslineas.getid_ciudad().toString()+",";
		sDescripcion+=PresupuestoVentasLineasConstantesFunciones.IDZONA+"=";
		sDescripcion+=presupuestoventaslineas.getid_zona().toString()+",";
		sDescripcion+=PresupuestoVentasLineasConstantesFunciones.IDLINEA+"=";
		sDescripcion+=presupuestoventaslineas.getid_linea().toString()+",";
		sDescripcion+=PresupuestoVentasLineasConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=presupuestoventaslineas.getid_linea_grupo().toString()+",";
		sDescripcion+=PresupuestoVentasLineasConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=presupuestoventaslineas.getid_linea_categoria().toString()+",";
		sDescripcion+=PresupuestoVentasLineasConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=presupuestoventaslineas.getid_linea_marca().toString()+",";
		sDescripcion+=PresupuestoVentasLineasConstantesFunciones.PRECIO+"=";
		sDescripcion+=presupuestoventaslineas.getprecio().toString()+",";
		sDescripcion+=PresupuestoVentasLineasConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=presupuestoventaslineas.getcantidad().toString()+",";
		sDescripcion+=PresupuestoVentasLineasConstantesFunciones.VALOR+"=";
		sDescripcion+=presupuestoventaslineas.getvalor().toString()+",";
		sDescripcion+=PresupuestoVentasLineasConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=presupuestoventaslineas.getporcentaje().toString()+",";
		sDescripcion+=PresupuestoVentasLineasConstantesFunciones.CANTIDADTOTAL+"=";
		sDescripcion+=presupuestoventaslineas.getcantidad_total().toString()+",";
		sDescripcion+=PresupuestoVentasLineasConstantesFunciones.VALORTOTAL+"=";
		sDescripcion+=presupuestoventaslineas.getvalor_total().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPresupuestoVentasLineasDescripcion(PresupuestoVentasLineas presupuestoventaslineas,String sValor) throws Exception {			
		if(presupuestoventaslineas !=null) {
			//presupuestoventaslineaspresupuestoventaslineas.getId().toString();
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

	public static String getLineaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaGrupoDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaCategoriaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaMarcaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
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
		} else if(sNombreIndice.equals("FK_IdLinea")) {
			sNombreIndice="Tipo=  Por Linea";
		} else if(sNombreIndice.equals("FK_IdLineaCategoria")) {
			sNombreIndice="Tipo=  Por Linea Categoria";
		} else if(sNombreIndice.equals("FK_IdLineaGrupo")) {
			sNombreIndice="Tipo=  Por Linea Grupo";
		} else if(sNombreIndice.equals("FK_IdLineaMarca")) {
			sNombreIndice="Tipo=  Por Linea Marca";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
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

	public static String getDetalleIndiceFK_IdLinea(Long id_linea) {
		String sDetalleIndice=" Parametros->";
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaCategoria(Long id_linea_categoria) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaGrupo(Long id_linea_grupo) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaMarca(Long id_linea_marca) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosPresupuestoVentasLineas(PresupuestoVentasLineas presupuestoventaslineas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosPresupuestoVentasLineass(List<PresupuestoVentasLineas> presupuestoventaslineass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PresupuestoVentasLineas presupuestoventaslineas: presupuestoventaslineass) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPresupuestoVentasLineas(PresupuestoVentasLineas presupuestoventaslineas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && presupuestoventaslineas.getConCambioAuxiliar()) {
			presupuestoventaslineas.setIsDeleted(presupuestoventaslineas.getIsDeletedAuxiliar());	
			presupuestoventaslineas.setIsNew(presupuestoventaslineas.getIsNewAuxiliar());	
			presupuestoventaslineas.setIsChanged(presupuestoventaslineas.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			presupuestoventaslineas.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			presupuestoventaslineas.setIsDeletedAuxiliar(false);	
			presupuestoventaslineas.setIsNewAuxiliar(false);	
			presupuestoventaslineas.setIsChangedAuxiliar(false);
			
			presupuestoventaslineas.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPresupuestoVentasLineass(List<PresupuestoVentasLineas> presupuestoventaslineass,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PresupuestoVentasLineas presupuestoventaslineas : presupuestoventaslineass) {
			if(conAsignarBase && presupuestoventaslineas.getConCambioAuxiliar()) {
				presupuestoventaslineas.setIsDeleted(presupuestoventaslineas.getIsDeletedAuxiliar());	
				presupuestoventaslineas.setIsNew(presupuestoventaslineas.getIsNewAuxiliar());	
				presupuestoventaslineas.setIsChanged(presupuestoventaslineas.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				presupuestoventaslineas.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				presupuestoventaslineas.setIsDeletedAuxiliar(false);	
				presupuestoventaslineas.setIsNewAuxiliar(false);	
				presupuestoventaslineas.setIsChangedAuxiliar(false);
				
				presupuestoventaslineas.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPresupuestoVentasLineas(PresupuestoVentasLineas presupuestoventaslineas,Boolean conEnteros) throws Exception  {
		presupuestoventaslineas.setprecio(0.0);
		presupuestoventaslineas.setvalor(0.0);
		presupuestoventaslineas.setporcentaje(0.0);
		presupuestoventaslineas.setvalor_total(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			presupuestoventaslineas.setcantidad(0);
			presupuestoventaslineas.setcantidad_total(0);
		}
	}		
	
	public static void InicializarValoresPresupuestoVentasLineass(List<PresupuestoVentasLineas> presupuestoventaslineass,Boolean conEnteros) throws Exception  {
		
		for(PresupuestoVentasLineas presupuestoventaslineas: presupuestoventaslineass) {
			presupuestoventaslineas.setprecio(0.0);
			presupuestoventaslineas.setvalor(0.0);
			presupuestoventaslineas.setporcentaje(0.0);
			presupuestoventaslineas.setvalor_total(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				presupuestoventaslineas.setcantidad(0);
				presupuestoventaslineas.setcantidad_total(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaPresupuestoVentasLineas(List<PresupuestoVentasLineas> presupuestoventaslineass,PresupuestoVentasLineas presupuestoventaslineasAux) throws Exception  {
		PresupuestoVentasLineasConstantesFunciones.InicializarValoresPresupuestoVentasLineas(presupuestoventaslineasAux,true);
		
		for(PresupuestoVentasLineas presupuestoventaslineas: presupuestoventaslineass) {
			if(presupuestoventaslineas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			presupuestoventaslineasAux.setprecio(presupuestoventaslineasAux.getprecio()+presupuestoventaslineas.getprecio());			
			presupuestoventaslineasAux.setcantidad(presupuestoventaslineasAux.getcantidad()+presupuestoventaslineas.getcantidad());			
			presupuestoventaslineasAux.setvalor(presupuestoventaslineasAux.getvalor()+presupuestoventaslineas.getvalor());			
			presupuestoventaslineasAux.setporcentaje(presupuestoventaslineasAux.getporcentaje()+presupuestoventaslineas.getporcentaje());			
			presupuestoventaslineasAux.setcantidad_total(presupuestoventaslineasAux.getcantidad_total()+presupuestoventaslineas.getcantidad_total());			
			presupuestoventaslineasAux.setvalor_total(presupuestoventaslineasAux.getvalor_total()+presupuestoventaslineas.getvalor_total());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPresupuestoVentasLineas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PresupuestoVentasLineasConstantesFunciones.getArrayColumnasGlobalesPresupuestoVentasLineas(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPresupuestoVentasLineas(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresupuestoVentasLineasConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresupuestoVentasLineasConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresupuestoVentasLineasConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresupuestoVentasLineasConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresupuestoVentasLineasConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresupuestoVentasLineasConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresupuestoVentasLineasConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresupuestoVentasLineasConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPresupuestoVentasLineas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PresupuestoVentasLineas> presupuestoventaslineass,PresupuestoVentasLineas presupuestoventaslineas,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PresupuestoVentasLineas presupuestoventaslineasAux: presupuestoventaslineass) {
			if(presupuestoventaslineasAux!=null && presupuestoventaslineas!=null) {
				if((presupuestoventaslineasAux.getId()==null && presupuestoventaslineas.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(presupuestoventaslineasAux.getId()!=null && presupuestoventaslineas.getId()!=null){
					if(presupuestoventaslineasAux.getId().equals(presupuestoventaslineas.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPresupuestoVentasLineas(List<PresupuestoVentasLineas> presupuestoventaslineass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
		Double valorTotal=0.0;
		Double porcentajeTotal=0.0;
		Double valor_totalTotal=0.0;
	
		for(PresupuestoVentasLineas presupuestoventaslineas: presupuestoventaslineass) {			
			if(presupuestoventaslineas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precioTotal+=presupuestoventaslineas.getprecio();
			valorTotal+=presupuestoventaslineas.getvalor();
			porcentajeTotal+=presupuestoventaslineas.getporcentaje();
			valor_totalTotal+=presupuestoventaslineas.getvalor_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestoVentasLineasConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(PresupuestoVentasLineasConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestoVentasLineasConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(PresupuestoVentasLineasConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestoVentasLineasConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(PresupuestoVentasLineasConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestoVentasLineasConstantesFunciones.VALORTOTAL);
		datoGeneral.setsDescripcion(PresupuestoVentasLineasConstantesFunciones.LABEL_VALORTOTAL);
		datoGeneral.setdValorDouble(valor_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPresupuestoVentasLineas() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PresupuestoVentasLineasConstantesFunciones.LABEL_ID, PresupuestoVentasLineasConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasLineasConstantesFunciones.LABEL_VERSIONROW, PresupuestoVentasLineasConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasLineasConstantesFunciones.LABEL_IDEMPRESA, PresupuestoVentasLineasConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasLineasConstantesFunciones.LABEL_IDSUCURSAL, PresupuestoVentasLineasConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasLineasConstantesFunciones.LABEL_IDEJERCICIO, PresupuestoVentasLineasConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasLineasConstantesFunciones.LABEL_IDPERIODO, PresupuestoVentasLineasConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasLineasConstantesFunciones.LABEL_IDVENDEDOR, PresupuestoVentasLineasConstantesFunciones.IDVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasLineasConstantesFunciones.LABEL_IDPAIS, PresupuestoVentasLineasConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasLineasConstantesFunciones.LABEL_IDCIUDAD, PresupuestoVentasLineasConstantesFunciones.IDCIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasLineasConstantesFunciones.LABEL_IDZONA, PresupuestoVentasLineasConstantesFunciones.IDZONA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasLineasConstantesFunciones.LABEL_IDLINEA, PresupuestoVentasLineasConstantesFunciones.IDLINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasLineasConstantesFunciones.LABEL_IDLINEAGRUPO, PresupuestoVentasLineasConstantesFunciones.IDLINEAGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasLineasConstantesFunciones.LABEL_IDLINEACATEGORIA, PresupuestoVentasLineasConstantesFunciones.IDLINEACATEGORIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasLineasConstantesFunciones.LABEL_IDLINEAMARCA, PresupuestoVentasLineasConstantesFunciones.IDLINEAMARCA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasLineasConstantesFunciones.LABEL_PRECIO, PresupuestoVentasLineasConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasLineasConstantesFunciones.LABEL_CANTIDAD, PresupuestoVentasLineasConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasLineasConstantesFunciones.LABEL_VALOR, PresupuestoVentasLineasConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasLineasConstantesFunciones.LABEL_PORCENTAJE, PresupuestoVentasLineasConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasLineasConstantesFunciones.LABEL_CANTIDADTOTAL, PresupuestoVentasLineasConstantesFunciones.CANTIDADTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasLineasConstantesFunciones.LABEL_VALORTOTAL, PresupuestoVentasLineasConstantesFunciones.VALORTOTAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPresupuestoVentasLineas() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasLineasConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasLineasConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasLineasConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasLineasConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasLineasConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasLineasConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasLineasConstantesFunciones.IDVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasLineasConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasLineasConstantesFunciones.IDCIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasLineasConstantesFunciones.IDZONA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasLineasConstantesFunciones.IDLINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasLineasConstantesFunciones.IDLINEAGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasLineasConstantesFunciones.IDLINEACATEGORIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasLineasConstantesFunciones.IDLINEAMARCA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasLineasConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasLineasConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasLineasConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasLineasConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasLineasConstantesFunciones.CANTIDADTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasLineasConstantesFunciones.VALORTOTAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresupuestoVentasLineas() throws Exception  {
		return PresupuestoVentasLineasConstantesFunciones.getTiposSeleccionarPresupuestoVentasLineas(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresupuestoVentasLineas(Boolean conFk) throws Exception  {
		return PresupuestoVentasLineasConstantesFunciones.getTiposSeleccionarPresupuestoVentasLineas(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresupuestoVentasLineas(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasLineasConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PresupuestoVentasLineasConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasLineasConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(PresupuestoVentasLineasConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasLineasConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(PresupuestoVentasLineasConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasLineasConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(PresupuestoVentasLineasConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasLineasConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(PresupuestoVentasLineasConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasLineasConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(PresupuestoVentasLineasConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasLineasConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(PresupuestoVentasLineasConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasLineasConstantesFunciones.LABEL_IDZONA);
			reporte.setsDescripcion(PresupuestoVentasLineasConstantesFunciones.LABEL_IDZONA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasLineasConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(PresupuestoVentasLineasConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasLineasConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(PresupuestoVentasLineasConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasLineasConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(PresupuestoVentasLineasConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasLineasConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(PresupuestoVentasLineasConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasLineasConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(PresupuestoVentasLineasConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasLineasConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(PresupuestoVentasLineasConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasLineasConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(PresupuestoVentasLineasConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasLineasConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(PresupuestoVentasLineasConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasLineasConstantesFunciones.LABEL_CANTIDADTOTAL);
			reporte.setsDescripcion(PresupuestoVentasLineasConstantesFunciones.LABEL_CANTIDADTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasLineasConstantesFunciones.LABEL_VALORTOTAL);
			reporte.setsDescripcion(PresupuestoVentasLineasConstantesFunciones.LABEL_VALORTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPresupuestoVentasLineas(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPresupuestoVentasLineas(PresupuestoVentasLineas presupuestoventaslineasAux) throws Exception {
		
			presupuestoventaslineasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(presupuestoventaslineasAux.getEmpresa()));
			presupuestoventaslineasAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(presupuestoventaslineasAux.getSucursal()));
			presupuestoventaslineasAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(presupuestoventaslineasAux.getEjercicio()));
			presupuestoventaslineasAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(presupuestoventaslineasAux.getPeriodo()));
			presupuestoventaslineasAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(presupuestoventaslineasAux.getVendedor()));
			presupuestoventaslineasAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(presupuestoventaslineasAux.getPais()));
			presupuestoventaslineasAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(presupuestoventaslineasAux.getCiudad()));
			presupuestoventaslineasAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(presupuestoventaslineasAux.getZona()));
			presupuestoventaslineasAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(presupuestoventaslineasAux.getLinea()));
			presupuestoventaslineasAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(presupuestoventaslineasAux.getLineaGrupo()));
			presupuestoventaslineasAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(presupuestoventaslineasAux.getLineaCategoria()));
			presupuestoventaslineasAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(presupuestoventaslineasAux.getLineaMarca()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPresupuestoVentasLineas(List<PresupuestoVentasLineas> presupuestoventaslineassTemp) throws Exception {
		for(PresupuestoVentasLineas presupuestoventaslineasAux:presupuestoventaslineassTemp) {
			
			presupuestoventaslineasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(presupuestoventaslineasAux.getEmpresa()));
			presupuestoventaslineasAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(presupuestoventaslineasAux.getSucursal()));
			presupuestoventaslineasAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(presupuestoventaslineasAux.getEjercicio()));
			presupuestoventaslineasAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(presupuestoventaslineasAux.getPeriodo()));
			presupuestoventaslineasAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(presupuestoventaslineasAux.getVendedor()));
			presupuestoventaslineasAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(presupuestoventaslineasAux.getPais()));
			presupuestoventaslineasAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(presupuestoventaslineasAux.getCiudad()));
			presupuestoventaslineasAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(presupuestoventaslineasAux.getZona()));
			presupuestoventaslineasAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(presupuestoventaslineasAux.getLinea()));
			presupuestoventaslineasAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(presupuestoventaslineasAux.getLineaGrupo()));
			presupuestoventaslineasAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(presupuestoventaslineasAux.getLineaCategoria()));
			presupuestoventaslineasAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(presupuestoventaslineasAux.getLineaMarca()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPresupuestoVentasLineas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				
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
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPresupuestoVentasLineas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
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

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresupuestoVentasLineas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PresupuestoVentasLineasConstantesFunciones.getClassesRelationshipsOfPresupuestoVentasLineas(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresupuestoVentasLineas(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPresupuestoVentasLineas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PresupuestoVentasLineasConstantesFunciones.getClassesRelationshipsFromStringsOfPresupuestoVentasLineas(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPresupuestoVentasLineas(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PresupuestoVentasLineas presupuestoventaslineas,List<PresupuestoVentasLineas> presupuestoventaslineass,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PresupuestoVentasLineas presupuestoventaslineasEncontrado=null;
			
			for(PresupuestoVentasLineas presupuestoventaslineasLocal:presupuestoventaslineass) {
				if(presupuestoventaslineasLocal.getId().equals(presupuestoventaslineas.getId())) {
					presupuestoventaslineasEncontrado=presupuestoventaslineasLocal;
					
					presupuestoventaslineasLocal.setIsChanged(presupuestoventaslineas.getIsChanged());
					presupuestoventaslineasLocal.setIsNew(presupuestoventaslineas.getIsNew());
					presupuestoventaslineasLocal.setIsDeleted(presupuestoventaslineas.getIsDeleted());
					
					presupuestoventaslineasLocal.setGeneralEntityOriginal(presupuestoventaslineas.getGeneralEntityOriginal());
					
					presupuestoventaslineasLocal.setId(presupuestoventaslineas.getId());	
					presupuestoventaslineasLocal.setVersionRow(presupuestoventaslineas.getVersionRow());	
					presupuestoventaslineasLocal.setid_empresa(presupuestoventaslineas.getid_empresa());	
					presupuestoventaslineasLocal.setid_sucursal(presupuestoventaslineas.getid_sucursal());	
					presupuestoventaslineasLocal.setid_ejercicio(presupuestoventaslineas.getid_ejercicio());	
					presupuestoventaslineasLocal.setid_periodo(presupuestoventaslineas.getid_periodo());	
					presupuestoventaslineasLocal.setid_vendedor(presupuestoventaslineas.getid_vendedor());	
					presupuestoventaslineasLocal.setid_pais(presupuestoventaslineas.getid_pais());	
					presupuestoventaslineasLocal.setid_ciudad(presupuestoventaslineas.getid_ciudad());	
					presupuestoventaslineasLocal.setid_zona(presupuestoventaslineas.getid_zona());	
					presupuestoventaslineasLocal.setid_linea(presupuestoventaslineas.getid_linea());	
					presupuestoventaslineasLocal.setid_linea_grupo(presupuestoventaslineas.getid_linea_grupo());	
					presupuestoventaslineasLocal.setid_linea_categoria(presupuestoventaslineas.getid_linea_categoria());	
					presupuestoventaslineasLocal.setid_linea_marca(presupuestoventaslineas.getid_linea_marca());	
					presupuestoventaslineasLocal.setprecio(presupuestoventaslineas.getprecio());	
					presupuestoventaslineasLocal.setcantidad(presupuestoventaslineas.getcantidad());	
					presupuestoventaslineasLocal.setvalor(presupuestoventaslineas.getvalor());	
					presupuestoventaslineasLocal.setporcentaje(presupuestoventaslineas.getporcentaje());	
					presupuestoventaslineasLocal.setcantidad_total(presupuestoventaslineas.getcantidad_total());	
					presupuestoventaslineasLocal.setvalor_total(presupuestoventaslineas.getvalor_total());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!presupuestoventaslineas.getIsDeleted()) {
				if(!existe) {
					presupuestoventaslineass.add(presupuestoventaslineas);
				}
			} else {
				if(presupuestoventaslineasEncontrado!=null && permiteQuitar)  {
					presupuestoventaslineass.remove(presupuestoventaslineasEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PresupuestoVentasLineas presupuestoventaslineas,List<PresupuestoVentasLineas> presupuestoventaslineass) throws Exception {
		try	{			
			for(PresupuestoVentasLineas presupuestoventaslineasLocal:presupuestoventaslineass) {
				if(presupuestoventaslineasLocal.getId().equals(presupuestoventaslineas.getId())) {
					presupuestoventaslineasLocal.setIsSelected(presupuestoventaslineas.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPresupuestoVentasLineas(List<PresupuestoVentasLineas> presupuestoventaslineassAux) throws Exception {
		//this.presupuestoventaslineassAux=presupuestoventaslineassAux;
		
		for(PresupuestoVentasLineas presupuestoventaslineasAux:presupuestoventaslineassAux) {
			if(presupuestoventaslineasAux.getIsChanged()) {
				presupuestoventaslineasAux.setIsChanged(false);
			}		
			
			if(presupuestoventaslineasAux.getIsNew()) {
				presupuestoventaslineasAux.setIsNew(false);
			}	
			
			if(presupuestoventaslineasAux.getIsDeleted()) {
				presupuestoventaslineasAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPresupuestoVentasLineas(PresupuestoVentasLineas presupuestoventaslineasAux) throws Exception {
		//this.presupuestoventaslineasAux=presupuestoventaslineasAux;
		
			if(presupuestoventaslineasAux.getIsChanged()) {
				presupuestoventaslineasAux.setIsChanged(false);
			}		
			
			if(presupuestoventaslineasAux.getIsNew()) {
				presupuestoventaslineasAux.setIsNew(false);
			}	
			
			if(presupuestoventaslineasAux.getIsDeleted()) {
				presupuestoventaslineasAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PresupuestoVentasLineas presupuestoventaslineasAsignar,PresupuestoVentasLineas presupuestoventaslineas) throws Exception {
		presupuestoventaslineasAsignar.setId(presupuestoventaslineas.getId());	
		presupuestoventaslineasAsignar.setVersionRow(presupuestoventaslineas.getVersionRow());	
		presupuestoventaslineasAsignar.setid_empresa(presupuestoventaslineas.getid_empresa());
		presupuestoventaslineasAsignar.setempresa_descripcion(presupuestoventaslineas.getempresa_descripcion());	
		presupuestoventaslineasAsignar.setid_sucursal(presupuestoventaslineas.getid_sucursal());
		presupuestoventaslineasAsignar.setsucursal_descripcion(presupuestoventaslineas.getsucursal_descripcion());	
		presupuestoventaslineasAsignar.setid_ejercicio(presupuestoventaslineas.getid_ejercicio());
		presupuestoventaslineasAsignar.setejercicio_descripcion(presupuestoventaslineas.getejercicio_descripcion());	
		presupuestoventaslineasAsignar.setid_periodo(presupuestoventaslineas.getid_periodo());
		presupuestoventaslineasAsignar.setperiodo_descripcion(presupuestoventaslineas.getperiodo_descripcion());	
		presupuestoventaslineasAsignar.setid_vendedor(presupuestoventaslineas.getid_vendedor());
		presupuestoventaslineasAsignar.setvendedor_descripcion(presupuestoventaslineas.getvendedor_descripcion());	
		presupuestoventaslineasAsignar.setid_pais(presupuestoventaslineas.getid_pais());
		presupuestoventaslineasAsignar.setpais_descripcion(presupuestoventaslineas.getpais_descripcion());	
		presupuestoventaslineasAsignar.setid_ciudad(presupuestoventaslineas.getid_ciudad());
		presupuestoventaslineasAsignar.setciudad_descripcion(presupuestoventaslineas.getciudad_descripcion());	
		presupuestoventaslineasAsignar.setid_zona(presupuestoventaslineas.getid_zona());
		presupuestoventaslineasAsignar.setzona_descripcion(presupuestoventaslineas.getzona_descripcion());	
		presupuestoventaslineasAsignar.setid_linea(presupuestoventaslineas.getid_linea());
		presupuestoventaslineasAsignar.setlinea_descripcion(presupuestoventaslineas.getlinea_descripcion());	
		presupuestoventaslineasAsignar.setid_linea_grupo(presupuestoventaslineas.getid_linea_grupo());
		presupuestoventaslineasAsignar.setlineagrupo_descripcion(presupuestoventaslineas.getlineagrupo_descripcion());	
		presupuestoventaslineasAsignar.setid_linea_categoria(presupuestoventaslineas.getid_linea_categoria());
		presupuestoventaslineasAsignar.setlineacategoria_descripcion(presupuestoventaslineas.getlineacategoria_descripcion());	
		presupuestoventaslineasAsignar.setid_linea_marca(presupuestoventaslineas.getid_linea_marca());
		presupuestoventaslineasAsignar.setlineamarca_descripcion(presupuestoventaslineas.getlineamarca_descripcion());	
		presupuestoventaslineasAsignar.setprecio(presupuestoventaslineas.getprecio());	
		presupuestoventaslineasAsignar.setcantidad(presupuestoventaslineas.getcantidad());	
		presupuestoventaslineasAsignar.setvalor(presupuestoventaslineas.getvalor());	
		presupuestoventaslineasAsignar.setporcentaje(presupuestoventaslineas.getporcentaje());	
		presupuestoventaslineasAsignar.setcantidad_total(presupuestoventaslineas.getcantidad_total());	
		presupuestoventaslineasAsignar.setvalor_total(presupuestoventaslineas.getvalor_total());	
	}
	
	public static void inicializarPresupuestoVentasLineas(PresupuestoVentasLineas presupuestoventaslineas) throws Exception {
		try {
				presupuestoventaslineas.setId(0L);	
					
				presupuestoventaslineas.setid_empresa(-1L);	
				presupuestoventaslineas.setid_sucursal(-1L);	
				presupuestoventaslineas.setid_ejercicio(-1L);	
				presupuestoventaslineas.setid_periodo(-1L);	
				presupuestoventaslineas.setid_vendedor(-1L);	
				presupuestoventaslineas.setid_pais(-1L);	
				presupuestoventaslineas.setid_ciudad(-1L);	
				presupuestoventaslineas.setid_zona(null);	
				presupuestoventaslineas.setid_linea(-1L);	
				presupuestoventaslineas.setid_linea_grupo(null);	
				presupuestoventaslineas.setid_linea_categoria(null);	
				presupuestoventaslineas.setid_linea_marca(null);	
				presupuestoventaslineas.setprecio(0.0);	
				presupuestoventaslineas.setcantidad(0);	
				presupuestoventaslineas.setvalor(0.0);	
				presupuestoventaslineas.setporcentaje(0.0);	
				presupuestoventaslineas.setcantidad_total(0);	
				presupuestoventaslineas.setvalor_total(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPresupuestoVentasLineas(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasLineasConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasLineasConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasLineasConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasLineasConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasLineasConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasLineasConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasLineasConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasLineasConstantesFunciones.LABEL_IDZONA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasLineasConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasLineasConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasLineasConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasLineasConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasLineasConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasLineasConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasLineasConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasLineasConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasLineasConstantesFunciones.LABEL_CANTIDADTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasLineasConstantesFunciones.LABEL_VALORTOTAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPresupuestoVentasLineas(String sTipo,Row row,Workbook workbook,PresupuestoVentasLineas presupuestoventaslineas,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventaslineas.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventaslineas.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventaslineas.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventaslineas.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventaslineas.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventaslineas.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventaslineas.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventaslineas.getzona_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventaslineas.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventaslineas.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventaslineas.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventaslineas.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventaslineas.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventaslineas.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventaslineas.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventaslineas.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventaslineas.getcantidad_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventaslineas.getvalor_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPresupuestoVentasLineas=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPresupuestoVentasLineas() {
		return this.sFinalQueryPresupuestoVentasLineas;
	}
	
	public void setsFinalQueryPresupuestoVentasLineas(String sFinalQueryPresupuestoVentasLineas) {
		this.sFinalQueryPresupuestoVentasLineas= sFinalQueryPresupuestoVentasLineas;
	}
	
	public Border resaltarSeleccionarPresupuestoVentasLineas=null;
	
	public Border setResaltarSeleccionarPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//presupuestoventaslineasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasLineas.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPresupuestoVentasLineas= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPresupuestoVentasLineas() {
		return this.resaltarSeleccionarPresupuestoVentasLineas;
	}
	
	public void setResaltarSeleccionarPresupuestoVentasLineas(Border borderResaltarSeleccionarPresupuestoVentasLineas) {
		this.resaltarSeleccionarPresupuestoVentasLineas= borderResaltarSeleccionarPresupuestoVentasLineas;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPresupuestoVentasLineas=null;
	public Boolean mostraridPresupuestoVentasLineas=true;
	public Boolean activaridPresupuestoVentasLineas=true;

	public Border resaltarid_empresaPresupuestoVentasLineas=null;
	public Boolean mostrarid_empresaPresupuestoVentasLineas=true;
	public Boolean activarid_empresaPresupuestoVentasLineas=true;
	public Boolean cargarid_empresaPresupuestoVentasLineas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPresupuestoVentasLineas=false;//ConEventDepend=true

	public Border resaltarid_sucursalPresupuestoVentasLineas=null;
	public Boolean mostrarid_sucursalPresupuestoVentasLineas=true;
	public Boolean activarid_sucursalPresupuestoVentasLineas=true;
	public Boolean cargarid_sucursalPresupuestoVentasLineas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalPresupuestoVentasLineas=false;//ConEventDepend=true

	public Border resaltarid_ejercicioPresupuestoVentasLineas=null;
	public Boolean mostrarid_ejercicioPresupuestoVentasLineas=true;
	public Boolean activarid_ejercicioPresupuestoVentasLineas=true;
	public Boolean cargarid_ejercicioPresupuestoVentasLineas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioPresupuestoVentasLineas=false;//ConEventDepend=true

	public Border resaltarid_periodoPresupuestoVentasLineas=null;
	public Boolean mostrarid_periodoPresupuestoVentasLineas=true;
	public Boolean activarid_periodoPresupuestoVentasLineas=true;
	public Boolean cargarid_periodoPresupuestoVentasLineas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoPresupuestoVentasLineas=false;//ConEventDepend=true

	public Border resaltarid_vendedorPresupuestoVentasLineas=null;
	public Boolean mostrarid_vendedorPresupuestoVentasLineas=true;
	public Boolean activarid_vendedorPresupuestoVentasLineas=true;
	public Boolean cargarid_vendedorPresupuestoVentasLineas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorPresupuestoVentasLineas=false;//ConEventDepend=true

	public Border resaltarid_paisPresupuestoVentasLineas=null;
	public Boolean mostrarid_paisPresupuestoVentasLineas=true;
	public Boolean activarid_paisPresupuestoVentasLineas=true;
	public Boolean cargarid_paisPresupuestoVentasLineas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisPresupuestoVentasLineas=false;//ConEventDepend=true

	public Border resaltarid_ciudadPresupuestoVentasLineas=null;
	public Boolean mostrarid_ciudadPresupuestoVentasLineas=true;
	public Boolean activarid_ciudadPresupuestoVentasLineas=true;
	public Boolean cargarid_ciudadPresupuestoVentasLineas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ciudadPresupuestoVentasLineas=false;//ConEventDepend=true

	public Border resaltarid_zonaPresupuestoVentasLineas=null;
	public Boolean mostrarid_zonaPresupuestoVentasLineas=true;
	public Boolean activarid_zonaPresupuestoVentasLineas=true;
	public Boolean cargarid_zonaPresupuestoVentasLineas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_zonaPresupuestoVentasLineas=false;//ConEventDepend=true

	public Border resaltarid_lineaPresupuestoVentasLineas=null;
	public Boolean mostrarid_lineaPresupuestoVentasLineas=true;
	public Boolean activarid_lineaPresupuestoVentasLineas=true;
	public Boolean cargarid_lineaPresupuestoVentasLineas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaPresupuestoVentasLineas=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoPresupuestoVentasLineas=null;
	public Boolean mostrarid_linea_grupoPresupuestoVentasLineas=true;
	public Boolean activarid_linea_grupoPresupuestoVentasLineas=true;
	public Boolean cargarid_linea_grupoPresupuestoVentasLineas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoPresupuestoVentasLineas=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaPresupuestoVentasLineas=null;
	public Boolean mostrarid_linea_categoriaPresupuestoVentasLineas=true;
	public Boolean activarid_linea_categoriaPresupuestoVentasLineas=true;
	public Boolean cargarid_linea_categoriaPresupuestoVentasLineas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaPresupuestoVentasLineas=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaPresupuestoVentasLineas=null;
	public Boolean mostrarid_linea_marcaPresupuestoVentasLineas=true;
	public Boolean activarid_linea_marcaPresupuestoVentasLineas=true;
	public Boolean cargarid_linea_marcaPresupuestoVentasLineas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaPresupuestoVentasLineas=false;//ConEventDepend=true

	public Border resaltarprecioPresupuestoVentasLineas=null;
	public Boolean mostrarprecioPresupuestoVentasLineas=true;
	public Boolean activarprecioPresupuestoVentasLineas=true;

	public Border resaltarcantidadPresupuestoVentasLineas=null;
	public Boolean mostrarcantidadPresupuestoVentasLineas=true;
	public Boolean activarcantidadPresupuestoVentasLineas=true;

	public Border resaltarvalorPresupuestoVentasLineas=null;
	public Boolean mostrarvalorPresupuestoVentasLineas=true;
	public Boolean activarvalorPresupuestoVentasLineas=true;

	public Border resaltarporcentajePresupuestoVentasLineas=null;
	public Boolean mostrarporcentajePresupuestoVentasLineas=true;
	public Boolean activarporcentajePresupuestoVentasLineas=true;

	public Border resaltarcantidad_totalPresupuestoVentasLineas=null;
	public Boolean mostrarcantidad_totalPresupuestoVentasLineas=true;
	public Boolean activarcantidad_totalPresupuestoVentasLineas=true;

	public Border resaltarvalor_totalPresupuestoVentasLineas=null;
	public Boolean mostrarvalor_totalPresupuestoVentasLineas=true;
	public Boolean activarvalor_totalPresupuestoVentasLineas=true;

	
	

	public Border setResaltaridPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventaslineasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasLineas.setBorder(borderResaltar);
		
		this.resaltaridPresupuestoVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPresupuestoVentasLineas() {
		return this.resaltaridPresupuestoVentasLineas;
	}

	public void setResaltaridPresupuestoVentasLineas(Border borderResaltar) {
		this.resaltaridPresupuestoVentasLineas= borderResaltar;
	}

	public Boolean getMostraridPresupuestoVentasLineas() {
		return this.mostraridPresupuestoVentasLineas;
	}

	public void setMostraridPresupuestoVentasLineas(Boolean mostraridPresupuestoVentasLineas) {
		this.mostraridPresupuestoVentasLineas= mostraridPresupuestoVentasLineas;
	}

	public Boolean getActivaridPresupuestoVentasLineas() {
		return this.activaridPresupuestoVentasLineas;
	}

	public void setActivaridPresupuestoVentasLineas(Boolean activaridPresupuestoVentasLineas) {
		this.activaridPresupuestoVentasLineas= activaridPresupuestoVentasLineas;
	}

	public Border setResaltarid_empresaPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventaslineasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasLineas.setBorder(borderResaltar);
		
		this.resaltarid_empresaPresupuestoVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPresupuestoVentasLineas() {
		return this.resaltarid_empresaPresupuestoVentasLineas;
	}

	public void setResaltarid_empresaPresupuestoVentasLineas(Border borderResaltar) {
		this.resaltarid_empresaPresupuestoVentasLineas= borderResaltar;
	}

	public Boolean getMostrarid_empresaPresupuestoVentasLineas() {
		return this.mostrarid_empresaPresupuestoVentasLineas;
	}

	public void setMostrarid_empresaPresupuestoVentasLineas(Boolean mostrarid_empresaPresupuestoVentasLineas) {
		this.mostrarid_empresaPresupuestoVentasLineas= mostrarid_empresaPresupuestoVentasLineas;
	}

	public Boolean getActivarid_empresaPresupuestoVentasLineas() {
		return this.activarid_empresaPresupuestoVentasLineas;
	}

	public void setActivarid_empresaPresupuestoVentasLineas(Boolean activarid_empresaPresupuestoVentasLineas) {
		this.activarid_empresaPresupuestoVentasLineas= activarid_empresaPresupuestoVentasLineas;
	}

	public Boolean getCargarid_empresaPresupuestoVentasLineas() {
		return this.cargarid_empresaPresupuestoVentasLineas;
	}

	public void setCargarid_empresaPresupuestoVentasLineas(Boolean cargarid_empresaPresupuestoVentasLineas) {
		this.cargarid_empresaPresupuestoVentasLineas= cargarid_empresaPresupuestoVentasLineas;
	}

	public Border setResaltarid_sucursalPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventaslineasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasLineas.setBorder(borderResaltar);
		
		this.resaltarid_sucursalPresupuestoVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalPresupuestoVentasLineas() {
		return this.resaltarid_sucursalPresupuestoVentasLineas;
	}

	public void setResaltarid_sucursalPresupuestoVentasLineas(Border borderResaltar) {
		this.resaltarid_sucursalPresupuestoVentasLineas= borderResaltar;
	}

	public Boolean getMostrarid_sucursalPresupuestoVentasLineas() {
		return this.mostrarid_sucursalPresupuestoVentasLineas;
	}

	public void setMostrarid_sucursalPresupuestoVentasLineas(Boolean mostrarid_sucursalPresupuestoVentasLineas) {
		this.mostrarid_sucursalPresupuestoVentasLineas= mostrarid_sucursalPresupuestoVentasLineas;
	}

	public Boolean getActivarid_sucursalPresupuestoVentasLineas() {
		return this.activarid_sucursalPresupuestoVentasLineas;
	}

	public void setActivarid_sucursalPresupuestoVentasLineas(Boolean activarid_sucursalPresupuestoVentasLineas) {
		this.activarid_sucursalPresupuestoVentasLineas= activarid_sucursalPresupuestoVentasLineas;
	}

	public Boolean getCargarid_sucursalPresupuestoVentasLineas() {
		return this.cargarid_sucursalPresupuestoVentasLineas;
	}

	public void setCargarid_sucursalPresupuestoVentasLineas(Boolean cargarid_sucursalPresupuestoVentasLineas) {
		this.cargarid_sucursalPresupuestoVentasLineas= cargarid_sucursalPresupuestoVentasLineas;
	}

	public Border setResaltarid_ejercicioPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventaslineasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasLineas.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioPresupuestoVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioPresupuestoVentasLineas() {
		return this.resaltarid_ejercicioPresupuestoVentasLineas;
	}

	public void setResaltarid_ejercicioPresupuestoVentasLineas(Border borderResaltar) {
		this.resaltarid_ejercicioPresupuestoVentasLineas= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioPresupuestoVentasLineas() {
		return this.mostrarid_ejercicioPresupuestoVentasLineas;
	}

	public void setMostrarid_ejercicioPresupuestoVentasLineas(Boolean mostrarid_ejercicioPresupuestoVentasLineas) {
		this.mostrarid_ejercicioPresupuestoVentasLineas= mostrarid_ejercicioPresupuestoVentasLineas;
	}

	public Boolean getActivarid_ejercicioPresupuestoVentasLineas() {
		return this.activarid_ejercicioPresupuestoVentasLineas;
	}

	public void setActivarid_ejercicioPresupuestoVentasLineas(Boolean activarid_ejercicioPresupuestoVentasLineas) {
		this.activarid_ejercicioPresupuestoVentasLineas= activarid_ejercicioPresupuestoVentasLineas;
	}

	public Boolean getCargarid_ejercicioPresupuestoVentasLineas() {
		return this.cargarid_ejercicioPresupuestoVentasLineas;
	}

	public void setCargarid_ejercicioPresupuestoVentasLineas(Boolean cargarid_ejercicioPresupuestoVentasLineas) {
		this.cargarid_ejercicioPresupuestoVentasLineas= cargarid_ejercicioPresupuestoVentasLineas;
	}

	public Border setResaltarid_periodoPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventaslineasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasLineas.setBorder(borderResaltar);
		
		this.resaltarid_periodoPresupuestoVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoPresupuestoVentasLineas() {
		return this.resaltarid_periodoPresupuestoVentasLineas;
	}

	public void setResaltarid_periodoPresupuestoVentasLineas(Border borderResaltar) {
		this.resaltarid_periodoPresupuestoVentasLineas= borderResaltar;
	}

	public Boolean getMostrarid_periodoPresupuestoVentasLineas() {
		return this.mostrarid_periodoPresupuestoVentasLineas;
	}

	public void setMostrarid_periodoPresupuestoVentasLineas(Boolean mostrarid_periodoPresupuestoVentasLineas) {
		this.mostrarid_periodoPresupuestoVentasLineas= mostrarid_periodoPresupuestoVentasLineas;
	}

	public Boolean getActivarid_periodoPresupuestoVentasLineas() {
		return this.activarid_periodoPresupuestoVentasLineas;
	}

	public void setActivarid_periodoPresupuestoVentasLineas(Boolean activarid_periodoPresupuestoVentasLineas) {
		this.activarid_periodoPresupuestoVentasLineas= activarid_periodoPresupuestoVentasLineas;
	}

	public Boolean getCargarid_periodoPresupuestoVentasLineas() {
		return this.cargarid_periodoPresupuestoVentasLineas;
	}

	public void setCargarid_periodoPresupuestoVentasLineas(Boolean cargarid_periodoPresupuestoVentasLineas) {
		this.cargarid_periodoPresupuestoVentasLineas= cargarid_periodoPresupuestoVentasLineas;
	}

	public Border setResaltarid_vendedorPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventaslineasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasLineas.setBorder(borderResaltar);
		
		this.resaltarid_vendedorPresupuestoVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorPresupuestoVentasLineas() {
		return this.resaltarid_vendedorPresupuestoVentasLineas;
	}

	public void setResaltarid_vendedorPresupuestoVentasLineas(Border borderResaltar) {
		this.resaltarid_vendedorPresupuestoVentasLineas= borderResaltar;
	}

	public Boolean getMostrarid_vendedorPresupuestoVentasLineas() {
		return this.mostrarid_vendedorPresupuestoVentasLineas;
	}

	public void setMostrarid_vendedorPresupuestoVentasLineas(Boolean mostrarid_vendedorPresupuestoVentasLineas) {
		this.mostrarid_vendedorPresupuestoVentasLineas= mostrarid_vendedorPresupuestoVentasLineas;
	}

	public Boolean getActivarid_vendedorPresupuestoVentasLineas() {
		return this.activarid_vendedorPresupuestoVentasLineas;
	}

	public void setActivarid_vendedorPresupuestoVentasLineas(Boolean activarid_vendedorPresupuestoVentasLineas) {
		this.activarid_vendedorPresupuestoVentasLineas= activarid_vendedorPresupuestoVentasLineas;
	}

	public Boolean getCargarid_vendedorPresupuestoVentasLineas() {
		return this.cargarid_vendedorPresupuestoVentasLineas;
	}

	public void setCargarid_vendedorPresupuestoVentasLineas(Boolean cargarid_vendedorPresupuestoVentasLineas) {
		this.cargarid_vendedorPresupuestoVentasLineas= cargarid_vendedorPresupuestoVentasLineas;
	}

	public Border setResaltarid_paisPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventaslineasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasLineas.setBorder(borderResaltar);
		
		this.resaltarid_paisPresupuestoVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisPresupuestoVentasLineas() {
		return this.resaltarid_paisPresupuestoVentasLineas;
	}

	public void setResaltarid_paisPresupuestoVentasLineas(Border borderResaltar) {
		this.resaltarid_paisPresupuestoVentasLineas= borderResaltar;
	}

	public Boolean getMostrarid_paisPresupuestoVentasLineas() {
		return this.mostrarid_paisPresupuestoVentasLineas;
	}

	public void setMostrarid_paisPresupuestoVentasLineas(Boolean mostrarid_paisPresupuestoVentasLineas) {
		this.mostrarid_paisPresupuestoVentasLineas= mostrarid_paisPresupuestoVentasLineas;
	}

	public Boolean getActivarid_paisPresupuestoVentasLineas() {
		return this.activarid_paisPresupuestoVentasLineas;
	}

	public void setActivarid_paisPresupuestoVentasLineas(Boolean activarid_paisPresupuestoVentasLineas) {
		this.activarid_paisPresupuestoVentasLineas= activarid_paisPresupuestoVentasLineas;
	}

	public Boolean getCargarid_paisPresupuestoVentasLineas() {
		return this.cargarid_paisPresupuestoVentasLineas;
	}

	public void setCargarid_paisPresupuestoVentasLineas(Boolean cargarid_paisPresupuestoVentasLineas) {
		this.cargarid_paisPresupuestoVentasLineas= cargarid_paisPresupuestoVentasLineas;
	}

	public Border setResaltarid_ciudadPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventaslineasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasLineas.setBorder(borderResaltar);
		
		this.resaltarid_ciudadPresupuestoVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ciudadPresupuestoVentasLineas() {
		return this.resaltarid_ciudadPresupuestoVentasLineas;
	}

	public void setResaltarid_ciudadPresupuestoVentasLineas(Border borderResaltar) {
		this.resaltarid_ciudadPresupuestoVentasLineas= borderResaltar;
	}

	public Boolean getMostrarid_ciudadPresupuestoVentasLineas() {
		return this.mostrarid_ciudadPresupuestoVentasLineas;
	}

	public void setMostrarid_ciudadPresupuestoVentasLineas(Boolean mostrarid_ciudadPresupuestoVentasLineas) {
		this.mostrarid_ciudadPresupuestoVentasLineas= mostrarid_ciudadPresupuestoVentasLineas;
	}

	public Boolean getActivarid_ciudadPresupuestoVentasLineas() {
		return this.activarid_ciudadPresupuestoVentasLineas;
	}

	public void setActivarid_ciudadPresupuestoVentasLineas(Boolean activarid_ciudadPresupuestoVentasLineas) {
		this.activarid_ciudadPresupuestoVentasLineas= activarid_ciudadPresupuestoVentasLineas;
	}

	public Boolean getCargarid_ciudadPresupuestoVentasLineas() {
		return this.cargarid_ciudadPresupuestoVentasLineas;
	}

	public void setCargarid_ciudadPresupuestoVentasLineas(Boolean cargarid_ciudadPresupuestoVentasLineas) {
		this.cargarid_ciudadPresupuestoVentasLineas= cargarid_ciudadPresupuestoVentasLineas;
	}

	public Border setResaltarid_zonaPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventaslineasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasLineas.setBorder(borderResaltar);
		
		this.resaltarid_zonaPresupuestoVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_zonaPresupuestoVentasLineas() {
		return this.resaltarid_zonaPresupuestoVentasLineas;
	}

	public void setResaltarid_zonaPresupuestoVentasLineas(Border borderResaltar) {
		this.resaltarid_zonaPresupuestoVentasLineas= borderResaltar;
	}

	public Boolean getMostrarid_zonaPresupuestoVentasLineas() {
		return this.mostrarid_zonaPresupuestoVentasLineas;
	}

	public void setMostrarid_zonaPresupuestoVentasLineas(Boolean mostrarid_zonaPresupuestoVentasLineas) {
		this.mostrarid_zonaPresupuestoVentasLineas= mostrarid_zonaPresupuestoVentasLineas;
	}

	public Boolean getActivarid_zonaPresupuestoVentasLineas() {
		return this.activarid_zonaPresupuestoVentasLineas;
	}

	public void setActivarid_zonaPresupuestoVentasLineas(Boolean activarid_zonaPresupuestoVentasLineas) {
		this.activarid_zonaPresupuestoVentasLineas= activarid_zonaPresupuestoVentasLineas;
	}

	public Boolean getCargarid_zonaPresupuestoVentasLineas() {
		return this.cargarid_zonaPresupuestoVentasLineas;
	}

	public void setCargarid_zonaPresupuestoVentasLineas(Boolean cargarid_zonaPresupuestoVentasLineas) {
		this.cargarid_zonaPresupuestoVentasLineas= cargarid_zonaPresupuestoVentasLineas;
	}

	public Border setResaltarid_lineaPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventaslineasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasLineas.setBorder(borderResaltar);
		
		this.resaltarid_lineaPresupuestoVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaPresupuestoVentasLineas() {
		return this.resaltarid_lineaPresupuestoVentasLineas;
	}

	public void setResaltarid_lineaPresupuestoVentasLineas(Border borderResaltar) {
		this.resaltarid_lineaPresupuestoVentasLineas= borderResaltar;
	}

	public Boolean getMostrarid_lineaPresupuestoVentasLineas() {
		return this.mostrarid_lineaPresupuestoVentasLineas;
	}

	public void setMostrarid_lineaPresupuestoVentasLineas(Boolean mostrarid_lineaPresupuestoVentasLineas) {
		this.mostrarid_lineaPresupuestoVentasLineas= mostrarid_lineaPresupuestoVentasLineas;
	}

	public Boolean getActivarid_lineaPresupuestoVentasLineas() {
		return this.activarid_lineaPresupuestoVentasLineas;
	}

	public void setActivarid_lineaPresupuestoVentasLineas(Boolean activarid_lineaPresupuestoVentasLineas) {
		this.activarid_lineaPresupuestoVentasLineas= activarid_lineaPresupuestoVentasLineas;
	}

	public Boolean getCargarid_lineaPresupuestoVentasLineas() {
		return this.cargarid_lineaPresupuestoVentasLineas;
	}

	public void setCargarid_lineaPresupuestoVentasLineas(Boolean cargarid_lineaPresupuestoVentasLineas) {
		this.cargarid_lineaPresupuestoVentasLineas= cargarid_lineaPresupuestoVentasLineas;
	}

	public Border setResaltarid_linea_grupoPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventaslineasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasLineas.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoPresupuestoVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoPresupuestoVentasLineas() {
		return this.resaltarid_linea_grupoPresupuestoVentasLineas;
	}

	public void setResaltarid_linea_grupoPresupuestoVentasLineas(Border borderResaltar) {
		this.resaltarid_linea_grupoPresupuestoVentasLineas= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoPresupuestoVentasLineas() {
		return this.mostrarid_linea_grupoPresupuestoVentasLineas;
	}

	public void setMostrarid_linea_grupoPresupuestoVentasLineas(Boolean mostrarid_linea_grupoPresupuestoVentasLineas) {
		this.mostrarid_linea_grupoPresupuestoVentasLineas= mostrarid_linea_grupoPresupuestoVentasLineas;
	}

	public Boolean getActivarid_linea_grupoPresupuestoVentasLineas() {
		return this.activarid_linea_grupoPresupuestoVentasLineas;
	}

	public void setActivarid_linea_grupoPresupuestoVentasLineas(Boolean activarid_linea_grupoPresupuestoVentasLineas) {
		this.activarid_linea_grupoPresupuestoVentasLineas= activarid_linea_grupoPresupuestoVentasLineas;
	}

	public Boolean getCargarid_linea_grupoPresupuestoVentasLineas() {
		return this.cargarid_linea_grupoPresupuestoVentasLineas;
	}

	public void setCargarid_linea_grupoPresupuestoVentasLineas(Boolean cargarid_linea_grupoPresupuestoVentasLineas) {
		this.cargarid_linea_grupoPresupuestoVentasLineas= cargarid_linea_grupoPresupuestoVentasLineas;
	}

	public Border setResaltarid_linea_categoriaPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventaslineasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasLineas.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaPresupuestoVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaPresupuestoVentasLineas() {
		return this.resaltarid_linea_categoriaPresupuestoVentasLineas;
	}

	public void setResaltarid_linea_categoriaPresupuestoVentasLineas(Border borderResaltar) {
		this.resaltarid_linea_categoriaPresupuestoVentasLineas= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaPresupuestoVentasLineas() {
		return this.mostrarid_linea_categoriaPresupuestoVentasLineas;
	}

	public void setMostrarid_linea_categoriaPresupuestoVentasLineas(Boolean mostrarid_linea_categoriaPresupuestoVentasLineas) {
		this.mostrarid_linea_categoriaPresupuestoVentasLineas= mostrarid_linea_categoriaPresupuestoVentasLineas;
	}

	public Boolean getActivarid_linea_categoriaPresupuestoVentasLineas() {
		return this.activarid_linea_categoriaPresupuestoVentasLineas;
	}

	public void setActivarid_linea_categoriaPresupuestoVentasLineas(Boolean activarid_linea_categoriaPresupuestoVentasLineas) {
		this.activarid_linea_categoriaPresupuestoVentasLineas= activarid_linea_categoriaPresupuestoVentasLineas;
	}

	public Boolean getCargarid_linea_categoriaPresupuestoVentasLineas() {
		return this.cargarid_linea_categoriaPresupuestoVentasLineas;
	}

	public void setCargarid_linea_categoriaPresupuestoVentasLineas(Boolean cargarid_linea_categoriaPresupuestoVentasLineas) {
		this.cargarid_linea_categoriaPresupuestoVentasLineas= cargarid_linea_categoriaPresupuestoVentasLineas;
	}

	public Border setResaltarid_linea_marcaPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventaslineasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasLineas.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaPresupuestoVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaPresupuestoVentasLineas() {
		return this.resaltarid_linea_marcaPresupuestoVentasLineas;
	}

	public void setResaltarid_linea_marcaPresupuestoVentasLineas(Border borderResaltar) {
		this.resaltarid_linea_marcaPresupuestoVentasLineas= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaPresupuestoVentasLineas() {
		return this.mostrarid_linea_marcaPresupuestoVentasLineas;
	}

	public void setMostrarid_linea_marcaPresupuestoVentasLineas(Boolean mostrarid_linea_marcaPresupuestoVentasLineas) {
		this.mostrarid_linea_marcaPresupuestoVentasLineas= mostrarid_linea_marcaPresupuestoVentasLineas;
	}

	public Boolean getActivarid_linea_marcaPresupuestoVentasLineas() {
		return this.activarid_linea_marcaPresupuestoVentasLineas;
	}

	public void setActivarid_linea_marcaPresupuestoVentasLineas(Boolean activarid_linea_marcaPresupuestoVentasLineas) {
		this.activarid_linea_marcaPresupuestoVentasLineas= activarid_linea_marcaPresupuestoVentasLineas;
	}

	public Boolean getCargarid_linea_marcaPresupuestoVentasLineas() {
		return this.cargarid_linea_marcaPresupuestoVentasLineas;
	}

	public void setCargarid_linea_marcaPresupuestoVentasLineas(Boolean cargarid_linea_marcaPresupuestoVentasLineas) {
		this.cargarid_linea_marcaPresupuestoVentasLineas= cargarid_linea_marcaPresupuestoVentasLineas;
	}

	public Border setResaltarprecioPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventaslineasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasLineas.setBorder(borderResaltar);
		
		this.resaltarprecioPresupuestoVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioPresupuestoVentasLineas() {
		return this.resaltarprecioPresupuestoVentasLineas;
	}

	public void setResaltarprecioPresupuestoVentasLineas(Border borderResaltar) {
		this.resaltarprecioPresupuestoVentasLineas= borderResaltar;
	}

	public Boolean getMostrarprecioPresupuestoVentasLineas() {
		return this.mostrarprecioPresupuestoVentasLineas;
	}

	public void setMostrarprecioPresupuestoVentasLineas(Boolean mostrarprecioPresupuestoVentasLineas) {
		this.mostrarprecioPresupuestoVentasLineas= mostrarprecioPresupuestoVentasLineas;
	}

	public Boolean getActivarprecioPresupuestoVentasLineas() {
		return this.activarprecioPresupuestoVentasLineas;
	}

	public void setActivarprecioPresupuestoVentasLineas(Boolean activarprecioPresupuestoVentasLineas) {
		this.activarprecioPresupuestoVentasLineas= activarprecioPresupuestoVentasLineas;
	}

	public Border setResaltarcantidadPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventaslineasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasLineas.setBorder(borderResaltar);
		
		this.resaltarcantidadPresupuestoVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadPresupuestoVentasLineas() {
		return this.resaltarcantidadPresupuestoVentasLineas;
	}

	public void setResaltarcantidadPresupuestoVentasLineas(Border borderResaltar) {
		this.resaltarcantidadPresupuestoVentasLineas= borderResaltar;
	}

	public Boolean getMostrarcantidadPresupuestoVentasLineas() {
		return this.mostrarcantidadPresupuestoVentasLineas;
	}

	public void setMostrarcantidadPresupuestoVentasLineas(Boolean mostrarcantidadPresupuestoVentasLineas) {
		this.mostrarcantidadPresupuestoVentasLineas= mostrarcantidadPresupuestoVentasLineas;
	}

	public Boolean getActivarcantidadPresupuestoVentasLineas() {
		return this.activarcantidadPresupuestoVentasLineas;
	}

	public void setActivarcantidadPresupuestoVentasLineas(Boolean activarcantidadPresupuestoVentasLineas) {
		this.activarcantidadPresupuestoVentasLineas= activarcantidadPresupuestoVentasLineas;
	}

	public Border setResaltarvalorPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventaslineasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasLineas.setBorder(borderResaltar);
		
		this.resaltarvalorPresupuestoVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorPresupuestoVentasLineas() {
		return this.resaltarvalorPresupuestoVentasLineas;
	}

	public void setResaltarvalorPresupuestoVentasLineas(Border borderResaltar) {
		this.resaltarvalorPresupuestoVentasLineas= borderResaltar;
	}

	public Boolean getMostrarvalorPresupuestoVentasLineas() {
		return this.mostrarvalorPresupuestoVentasLineas;
	}

	public void setMostrarvalorPresupuestoVentasLineas(Boolean mostrarvalorPresupuestoVentasLineas) {
		this.mostrarvalorPresupuestoVentasLineas= mostrarvalorPresupuestoVentasLineas;
	}

	public Boolean getActivarvalorPresupuestoVentasLineas() {
		return this.activarvalorPresupuestoVentasLineas;
	}

	public void setActivarvalorPresupuestoVentasLineas(Boolean activarvalorPresupuestoVentasLineas) {
		this.activarvalorPresupuestoVentasLineas= activarvalorPresupuestoVentasLineas;
	}

	public Border setResaltarporcentajePresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventaslineasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasLineas.setBorder(borderResaltar);
		
		this.resaltarporcentajePresupuestoVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajePresupuestoVentasLineas() {
		return this.resaltarporcentajePresupuestoVentasLineas;
	}

	public void setResaltarporcentajePresupuestoVentasLineas(Border borderResaltar) {
		this.resaltarporcentajePresupuestoVentasLineas= borderResaltar;
	}

	public Boolean getMostrarporcentajePresupuestoVentasLineas() {
		return this.mostrarporcentajePresupuestoVentasLineas;
	}

	public void setMostrarporcentajePresupuestoVentasLineas(Boolean mostrarporcentajePresupuestoVentasLineas) {
		this.mostrarporcentajePresupuestoVentasLineas= mostrarporcentajePresupuestoVentasLineas;
	}

	public Boolean getActivarporcentajePresupuestoVentasLineas() {
		return this.activarporcentajePresupuestoVentasLineas;
	}

	public void setActivarporcentajePresupuestoVentasLineas(Boolean activarporcentajePresupuestoVentasLineas) {
		this.activarporcentajePresupuestoVentasLineas= activarporcentajePresupuestoVentasLineas;
	}

	public Border setResaltarcantidad_totalPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventaslineasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasLineas.setBorder(borderResaltar);
		
		this.resaltarcantidad_totalPresupuestoVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_totalPresupuestoVentasLineas() {
		return this.resaltarcantidad_totalPresupuestoVentasLineas;
	}

	public void setResaltarcantidad_totalPresupuestoVentasLineas(Border borderResaltar) {
		this.resaltarcantidad_totalPresupuestoVentasLineas= borderResaltar;
	}

	public Boolean getMostrarcantidad_totalPresupuestoVentasLineas() {
		return this.mostrarcantidad_totalPresupuestoVentasLineas;
	}

	public void setMostrarcantidad_totalPresupuestoVentasLineas(Boolean mostrarcantidad_totalPresupuestoVentasLineas) {
		this.mostrarcantidad_totalPresupuestoVentasLineas= mostrarcantidad_totalPresupuestoVentasLineas;
	}

	public Boolean getActivarcantidad_totalPresupuestoVentasLineas() {
		return this.activarcantidad_totalPresupuestoVentasLineas;
	}

	public void setActivarcantidad_totalPresupuestoVentasLineas(Boolean activarcantidad_totalPresupuestoVentasLineas) {
		this.activarcantidad_totalPresupuestoVentasLineas= activarcantidad_totalPresupuestoVentasLineas;
	}

	public Border setResaltarvalor_totalPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventaslineasBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasLineas.setBorder(borderResaltar);
		
		this.resaltarvalor_totalPresupuestoVentasLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_totalPresupuestoVentasLineas() {
		return this.resaltarvalor_totalPresupuestoVentasLineas;
	}

	public void setResaltarvalor_totalPresupuestoVentasLineas(Border borderResaltar) {
		this.resaltarvalor_totalPresupuestoVentasLineas= borderResaltar;
	}

	public Boolean getMostrarvalor_totalPresupuestoVentasLineas() {
		return this.mostrarvalor_totalPresupuestoVentasLineas;
	}

	public void setMostrarvalor_totalPresupuestoVentasLineas(Boolean mostrarvalor_totalPresupuestoVentasLineas) {
		this.mostrarvalor_totalPresupuestoVentasLineas= mostrarvalor_totalPresupuestoVentasLineas;
	}

	public Boolean getActivarvalor_totalPresupuestoVentasLineas() {
		return this.activarvalor_totalPresupuestoVentasLineas;
	}

	public void setActivarvalor_totalPresupuestoVentasLineas(Boolean activarvalor_totalPresupuestoVentasLineas) {
		this.activarvalor_totalPresupuestoVentasLineas= activarvalor_totalPresupuestoVentasLineas;
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
		
		
		this.setMostraridPresupuestoVentasLineas(esInicial);
		this.setMostrarid_empresaPresupuestoVentasLineas(esInicial);
		this.setMostrarid_sucursalPresupuestoVentasLineas(esInicial);
		this.setMostrarid_ejercicioPresupuestoVentasLineas(esInicial);
		this.setMostrarid_periodoPresupuestoVentasLineas(esInicial);
		this.setMostrarid_vendedorPresupuestoVentasLineas(esInicial);
		this.setMostrarid_paisPresupuestoVentasLineas(esInicial);
		this.setMostrarid_ciudadPresupuestoVentasLineas(esInicial);
		this.setMostrarid_zonaPresupuestoVentasLineas(esInicial);
		this.setMostrarid_lineaPresupuestoVentasLineas(esInicial);
		this.setMostrarid_linea_grupoPresupuestoVentasLineas(esInicial);
		this.setMostrarid_linea_categoriaPresupuestoVentasLineas(esInicial);
		this.setMostrarid_linea_marcaPresupuestoVentasLineas(esInicial);
		this.setMostrarprecioPresupuestoVentasLineas(esInicial);
		this.setMostrarcantidadPresupuestoVentasLineas(esInicial);
		this.setMostrarvalorPresupuestoVentasLineas(esInicial);
		this.setMostrarporcentajePresupuestoVentasLineas(esInicial);
		this.setMostrarcantidad_totalPresupuestoVentasLineas(esInicial);
		this.setMostrarvalor_totalPresupuestoVentasLineas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.ID)) {
				this.setMostraridPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDCIUDAD)) {
				this.setMostrarid_ciudadPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDZONA)) {
				this.setMostrarid_zonaPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.PRECIO)) {
				this.setMostrarprecioPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.VALOR)) {
				this.setMostrarvalorPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajePresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.CANTIDADTOTAL)) {
				this.setMostrarcantidad_totalPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.VALORTOTAL)) {
				this.setMostrarvalor_totalPresupuestoVentasLineas(esAsigna);
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
		
		
		this.setActivaridPresupuestoVentasLineas(esInicial);
		this.setActivarid_empresaPresupuestoVentasLineas(esInicial);
		this.setActivarid_sucursalPresupuestoVentasLineas(esInicial);
		this.setActivarid_ejercicioPresupuestoVentasLineas(esInicial);
		this.setActivarid_periodoPresupuestoVentasLineas(esInicial);
		this.setActivarid_vendedorPresupuestoVentasLineas(esInicial);
		this.setActivarid_paisPresupuestoVentasLineas(esInicial);
		this.setActivarid_ciudadPresupuestoVentasLineas(esInicial);
		this.setActivarid_zonaPresupuestoVentasLineas(esInicial);
		this.setActivarid_lineaPresupuestoVentasLineas(esInicial);
		this.setActivarid_linea_grupoPresupuestoVentasLineas(esInicial);
		this.setActivarid_linea_categoriaPresupuestoVentasLineas(esInicial);
		this.setActivarid_linea_marcaPresupuestoVentasLineas(esInicial);
		this.setActivarprecioPresupuestoVentasLineas(esInicial);
		this.setActivarcantidadPresupuestoVentasLineas(esInicial);
		this.setActivarvalorPresupuestoVentasLineas(esInicial);
		this.setActivarporcentajePresupuestoVentasLineas(esInicial);
		this.setActivarcantidad_totalPresupuestoVentasLineas(esInicial);
		this.setActivarvalor_totalPresupuestoVentasLineas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.ID)) {
				this.setActivaridPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDCIUDAD)) {
				this.setActivarid_ciudadPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDZONA)) {
				this.setActivarid_zonaPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.PRECIO)) {
				this.setActivarprecioPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.VALOR)) {
				this.setActivarvalorPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajePresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.CANTIDADTOTAL)) {
				this.setActivarcantidad_totalPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.VALORTOTAL)) {
				this.setActivarvalor_totalPresupuestoVentasLineas(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPresupuestoVentasLineas(esInicial);
		this.setResaltarid_empresaPresupuestoVentasLineas(esInicial);
		this.setResaltarid_sucursalPresupuestoVentasLineas(esInicial);
		this.setResaltarid_ejercicioPresupuestoVentasLineas(esInicial);
		this.setResaltarid_periodoPresupuestoVentasLineas(esInicial);
		this.setResaltarid_vendedorPresupuestoVentasLineas(esInicial);
		this.setResaltarid_paisPresupuestoVentasLineas(esInicial);
		this.setResaltarid_ciudadPresupuestoVentasLineas(esInicial);
		this.setResaltarid_zonaPresupuestoVentasLineas(esInicial);
		this.setResaltarid_lineaPresupuestoVentasLineas(esInicial);
		this.setResaltarid_linea_grupoPresupuestoVentasLineas(esInicial);
		this.setResaltarid_linea_categoriaPresupuestoVentasLineas(esInicial);
		this.setResaltarid_linea_marcaPresupuestoVentasLineas(esInicial);
		this.setResaltarprecioPresupuestoVentasLineas(esInicial);
		this.setResaltarcantidadPresupuestoVentasLineas(esInicial);
		this.setResaltarvalorPresupuestoVentasLineas(esInicial);
		this.setResaltarporcentajePresupuestoVentasLineas(esInicial);
		this.setResaltarcantidad_totalPresupuestoVentasLineas(esInicial);
		this.setResaltarvalor_totalPresupuestoVentasLineas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.ID)) {
				this.setResaltaridPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDCIUDAD)) {
				this.setResaltarid_ciudadPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDZONA)) {
				this.setResaltarid_zonaPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.PRECIO)) {
				this.setResaltarprecioPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.VALOR)) {
				this.setResaltarvalorPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajePresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.CANTIDADTOTAL)) {
				this.setResaltarcantidad_totalPresupuestoVentasLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasLineasConstantesFunciones.VALORTOTAL)) {
				this.setResaltarvalor_totalPresupuestoVentasLineas(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCiudadPresupuestoVentasLineas=true;

	public Boolean getMostrarFK_IdCiudadPresupuestoVentasLineas() {
		return this.mostrarFK_IdCiudadPresupuestoVentasLineas;
	}

	public void setMostrarFK_IdCiudadPresupuestoVentasLineas(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCiudadPresupuestoVentasLineas= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioPresupuestoVentasLineas=true;

	public Boolean getMostrarFK_IdEjercicioPresupuestoVentasLineas() {
		return this.mostrarFK_IdEjercicioPresupuestoVentasLineas;
	}

	public void setMostrarFK_IdEjercicioPresupuestoVentasLineas(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioPresupuestoVentasLineas= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaPresupuestoVentasLineas=true;

	public Boolean getMostrarFK_IdEmpresaPresupuestoVentasLineas() {
		return this.mostrarFK_IdEmpresaPresupuestoVentasLineas;
	}

	public void setMostrarFK_IdEmpresaPresupuestoVentasLineas(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPresupuestoVentasLineas= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdLineaPresupuestoVentasLineas=true;

	public Boolean getMostrarFK_IdLineaPresupuestoVentasLineas() {
		return this.mostrarFK_IdLineaPresupuestoVentasLineas;
	}

	public void setMostrarFK_IdLineaPresupuestoVentasLineas(Boolean visibilidadResaltar) {
		this.mostrarFK_IdLineaPresupuestoVentasLineas= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdLineaCategoriaPresupuestoVentasLineas=true;

	public Boolean getMostrarFK_IdLineaCategoriaPresupuestoVentasLineas() {
		return this.mostrarFK_IdLineaCategoriaPresupuestoVentasLineas;
	}

	public void setMostrarFK_IdLineaCategoriaPresupuestoVentasLineas(Boolean visibilidadResaltar) {
		this.mostrarFK_IdLineaCategoriaPresupuestoVentasLineas= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdLineaGrupoPresupuestoVentasLineas=true;

	public Boolean getMostrarFK_IdLineaGrupoPresupuestoVentasLineas() {
		return this.mostrarFK_IdLineaGrupoPresupuestoVentasLineas;
	}

	public void setMostrarFK_IdLineaGrupoPresupuestoVentasLineas(Boolean visibilidadResaltar) {
		this.mostrarFK_IdLineaGrupoPresupuestoVentasLineas= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdLineaMarcaPresupuestoVentasLineas=true;

	public Boolean getMostrarFK_IdLineaMarcaPresupuestoVentasLineas() {
		return this.mostrarFK_IdLineaMarcaPresupuestoVentasLineas;
	}

	public void setMostrarFK_IdLineaMarcaPresupuestoVentasLineas(Boolean visibilidadResaltar) {
		this.mostrarFK_IdLineaMarcaPresupuestoVentasLineas= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisPresupuestoVentasLineas=true;

	public Boolean getMostrarFK_IdPaisPresupuestoVentasLineas() {
		return this.mostrarFK_IdPaisPresupuestoVentasLineas;
	}

	public void setMostrarFK_IdPaisPresupuestoVentasLineas(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisPresupuestoVentasLineas= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoPresupuestoVentasLineas=true;

	public Boolean getMostrarFK_IdPeriodoPresupuestoVentasLineas() {
		return this.mostrarFK_IdPeriodoPresupuestoVentasLineas;
	}

	public void setMostrarFK_IdPeriodoPresupuestoVentasLineas(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoPresupuestoVentasLineas= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalPresupuestoVentasLineas=true;

	public Boolean getMostrarFK_IdSucursalPresupuestoVentasLineas() {
		return this.mostrarFK_IdSucursalPresupuestoVentasLineas;
	}

	public void setMostrarFK_IdSucursalPresupuestoVentasLineas(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalPresupuestoVentasLineas= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdVendedorPresupuestoVentasLineas=true;

	public Boolean getMostrarFK_IdVendedorPresupuestoVentasLineas() {
		return this.mostrarFK_IdVendedorPresupuestoVentasLineas;
	}

	public void setMostrarFK_IdVendedorPresupuestoVentasLineas(Boolean visibilidadResaltar) {
		this.mostrarFK_IdVendedorPresupuestoVentasLineas= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdZonaPresupuestoVentasLineas=true;

	public Boolean getMostrarFK_IdZonaPresupuestoVentasLineas() {
		return this.mostrarFK_IdZonaPresupuestoVentasLineas;
	}

	public void setMostrarFK_IdZonaPresupuestoVentasLineas(Boolean visibilidadResaltar) {
		this.mostrarFK_IdZonaPresupuestoVentasLineas= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCiudadPresupuestoVentasLineas=true;

	public Boolean getActivarFK_IdCiudadPresupuestoVentasLineas() {
		return this.activarFK_IdCiudadPresupuestoVentasLineas;
	}

	public void setActivarFK_IdCiudadPresupuestoVentasLineas(Boolean habilitarResaltar) {
		this.activarFK_IdCiudadPresupuestoVentasLineas= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioPresupuestoVentasLineas=true;

	public Boolean getActivarFK_IdEjercicioPresupuestoVentasLineas() {
		return this.activarFK_IdEjercicioPresupuestoVentasLineas;
	}

	public void setActivarFK_IdEjercicioPresupuestoVentasLineas(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioPresupuestoVentasLineas= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaPresupuestoVentasLineas=true;

	public Boolean getActivarFK_IdEmpresaPresupuestoVentasLineas() {
		return this.activarFK_IdEmpresaPresupuestoVentasLineas;
	}

	public void setActivarFK_IdEmpresaPresupuestoVentasLineas(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPresupuestoVentasLineas= habilitarResaltar;
	}

	public Boolean activarFK_IdLineaPresupuestoVentasLineas=true;

	public Boolean getActivarFK_IdLineaPresupuestoVentasLineas() {
		return this.activarFK_IdLineaPresupuestoVentasLineas;
	}

	public void setActivarFK_IdLineaPresupuestoVentasLineas(Boolean habilitarResaltar) {
		this.activarFK_IdLineaPresupuestoVentasLineas= habilitarResaltar;
	}

	public Boolean activarFK_IdLineaCategoriaPresupuestoVentasLineas=true;

	public Boolean getActivarFK_IdLineaCategoriaPresupuestoVentasLineas() {
		return this.activarFK_IdLineaCategoriaPresupuestoVentasLineas;
	}

	public void setActivarFK_IdLineaCategoriaPresupuestoVentasLineas(Boolean habilitarResaltar) {
		this.activarFK_IdLineaCategoriaPresupuestoVentasLineas= habilitarResaltar;
	}

	public Boolean activarFK_IdLineaGrupoPresupuestoVentasLineas=true;

	public Boolean getActivarFK_IdLineaGrupoPresupuestoVentasLineas() {
		return this.activarFK_IdLineaGrupoPresupuestoVentasLineas;
	}

	public void setActivarFK_IdLineaGrupoPresupuestoVentasLineas(Boolean habilitarResaltar) {
		this.activarFK_IdLineaGrupoPresupuestoVentasLineas= habilitarResaltar;
	}

	public Boolean activarFK_IdLineaMarcaPresupuestoVentasLineas=true;

	public Boolean getActivarFK_IdLineaMarcaPresupuestoVentasLineas() {
		return this.activarFK_IdLineaMarcaPresupuestoVentasLineas;
	}

	public void setActivarFK_IdLineaMarcaPresupuestoVentasLineas(Boolean habilitarResaltar) {
		this.activarFK_IdLineaMarcaPresupuestoVentasLineas= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisPresupuestoVentasLineas=true;

	public Boolean getActivarFK_IdPaisPresupuestoVentasLineas() {
		return this.activarFK_IdPaisPresupuestoVentasLineas;
	}

	public void setActivarFK_IdPaisPresupuestoVentasLineas(Boolean habilitarResaltar) {
		this.activarFK_IdPaisPresupuestoVentasLineas= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoPresupuestoVentasLineas=true;

	public Boolean getActivarFK_IdPeriodoPresupuestoVentasLineas() {
		return this.activarFK_IdPeriodoPresupuestoVentasLineas;
	}

	public void setActivarFK_IdPeriodoPresupuestoVentasLineas(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoPresupuestoVentasLineas= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalPresupuestoVentasLineas=true;

	public Boolean getActivarFK_IdSucursalPresupuestoVentasLineas() {
		return this.activarFK_IdSucursalPresupuestoVentasLineas;
	}

	public void setActivarFK_IdSucursalPresupuestoVentasLineas(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalPresupuestoVentasLineas= habilitarResaltar;
	}

	public Boolean activarFK_IdVendedorPresupuestoVentasLineas=true;

	public Boolean getActivarFK_IdVendedorPresupuestoVentasLineas() {
		return this.activarFK_IdVendedorPresupuestoVentasLineas;
	}

	public void setActivarFK_IdVendedorPresupuestoVentasLineas(Boolean habilitarResaltar) {
		this.activarFK_IdVendedorPresupuestoVentasLineas= habilitarResaltar;
	}

	public Boolean activarFK_IdZonaPresupuestoVentasLineas=true;

	public Boolean getActivarFK_IdZonaPresupuestoVentasLineas() {
		return this.activarFK_IdZonaPresupuestoVentasLineas;
	}

	public void setActivarFK_IdZonaPresupuestoVentasLineas(Boolean habilitarResaltar) {
		this.activarFK_IdZonaPresupuestoVentasLineas= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCiudadPresupuestoVentasLineas=null;

	public Border getResaltarFK_IdCiudadPresupuestoVentasLineas() {
		return this.resaltarFK_IdCiudadPresupuestoVentasLineas;
	}

	public void setResaltarFK_IdCiudadPresupuestoVentasLineas(Border borderResaltar) {
		this.resaltarFK_IdCiudadPresupuestoVentasLineas= borderResaltar;
	}

	public void setResaltarFK_IdCiudadPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCiudadPresupuestoVentasLineas= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioPresupuestoVentasLineas=null;

	public Border getResaltarFK_IdEjercicioPresupuestoVentasLineas() {
		return this.resaltarFK_IdEjercicioPresupuestoVentasLineas;
	}

	public void setResaltarFK_IdEjercicioPresupuestoVentasLineas(Border borderResaltar) {
		this.resaltarFK_IdEjercicioPresupuestoVentasLineas= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioPresupuestoVentasLineas= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaPresupuestoVentasLineas=null;

	public Border getResaltarFK_IdEmpresaPresupuestoVentasLineas() {
		return this.resaltarFK_IdEmpresaPresupuestoVentasLineas;
	}

	public void setResaltarFK_IdEmpresaPresupuestoVentasLineas(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPresupuestoVentasLineas= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPresupuestoVentasLineas= borderResaltar;
	}

	public Border resaltarFK_IdLineaPresupuestoVentasLineas=null;

	public Border getResaltarFK_IdLineaPresupuestoVentasLineas() {
		return this.resaltarFK_IdLineaPresupuestoVentasLineas;
	}

	public void setResaltarFK_IdLineaPresupuestoVentasLineas(Border borderResaltar) {
		this.resaltarFK_IdLineaPresupuestoVentasLineas= borderResaltar;
	}

	public void setResaltarFK_IdLineaPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdLineaPresupuestoVentasLineas= borderResaltar;
	}

	public Border resaltarFK_IdLineaCategoriaPresupuestoVentasLineas=null;

	public Border getResaltarFK_IdLineaCategoriaPresupuestoVentasLineas() {
		return this.resaltarFK_IdLineaCategoriaPresupuestoVentasLineas;
	}

	public void setResaltarFK_IdLineaCategoriaPresupuestoVentasLineas(Border borderResaltar) {
		this.resaltarFK_IdLineaCategoriaPresupuestoVentasLineas= borderResaltar;
	}

	public void setResaltarFK_IdLineaCategoriaPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdLineaCategoriaPresupuestoVentasLineas= borderResaltar;
	}

	public Border resaltarFK_IdLineaGrupoPresupuestoVentasLineas=null;

	public Border getResaltarFK_IdLineaGrupoPresupuestoVentasLineas() {
		return this.resaltarFK_IdLineaGrupoPresupuestoVentasLineas;
	}

	public void setResaltarFK_IdLineaGrupoPresupuestoVentasLineas(Border borderResaltar) {
		this.resaltarFK_IdLineaGrupoPresupuestoVentasLineas= borderResaltar;
	}

	public void setResaltarFK_IdLineaGrupoPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdLineaGrupoPresupuestoVentasLineas= borderResaltar;
	}

	public Border resaltarFK_IdLineaMarcaPresupuestoVentasLineas=null;

	public Border getResaltarFK_IdLineaMarcaPresupuestoVentasLineas() {
		return this.resaltarFK_IdLineaMarcaPresupuestoVentasLineas;
	}

	public void setResaltarFK_IdLineaMarcaPresupuestoVentasLineas(Border borderResaltar) {
		this.resaltarFK_IdLineaMarcaPresupuestoVentasLineas= borderResaltar;
	}

	public void setResaltarFK_IdLineaMarcaPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdLineaMarcaPresupuestoVentasLineas= borderResaltar;
	}

	public Border resaltarFK_IdPaisPresupuestoVentasLineas=null;

	public Border getResaltarFK_IdPaisPresupuestoVentasLineas() {
		return this.resaltarFK_IdPaisPresupuestoVentasLineas;
	}

	public void setResaltarFK_IdPaisPresupuestoVentasLineas(Border borderResaltar) {
		this.resaltarFK_IdPaisPresupuestoVentasLineas= borderResaltar;
	}

	public void setResaltarFK_IdPaisPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisPresupuestoVentasLineas= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoPresupuestoVentasLineas=null;

	public Border getResaltarFK_IdPeriodoPresupuestoVentasLineas() {
		return this.resaltarFK_IdPeriodoPresupuestoVentasLineas;
	}

	public void setResaltarFK_IdPeriodoPresupuestoVentasLineas(Border borderResaltar) {
		this.resaltarFK_IdPeriodoPresupuestoVentasLineas= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoPresupuestoVentasLineas= borderResaltar;
	}

	public Border resaltarFK_IdSucursalPresupuestoVentasLineas=null;

	public Border getResaltarFK_IdSucursalPresupuestoVentasLineas() {
		return this.resaltarFK_IdSucursalPresupuestoVentasLineas;
	}

	public void setResaltarFK_IdSucursalPresupuestoVentasLineas(Border borderResaltar) {
		this.resaltarFK_IdSucursalPresupuestoVentasLineas= borderResaltar;
	}

	public void setResaltarFK_IdSucursalPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalPresupuestoVentasLineas= borderResaltar;
	}

	public Border resaltarFK_IdVendedorPresupuestoVentasLineas=null;

	public Border getResaltarFK_IdVendedorPresupuestoVentasLineas() {
		return this.resaltarFK_IdVendedorPresupuestoVentasLineas;
	}

	public void setResaltarFK_IdVendedorPresupuestoVentasLineas(Border borderResaltar) {
		this.resaltarFK_IdVendedorPresupuestoVentasLineas= borderResaltar;
	}

	public void setResaltarFK_IdVendedorPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdVendedorPresupuestoVentasLineas= borderResaltar;
	}

	public Border resaltarFK_IdZonaPresupuestoVentasLineas=null;

	public Border getResaltarFK_IdZonaPresupuestoVentasLineas() {
		return this.resaltarFK_IdZonaPresupuestoVentasLineas;
	}

	public void setResaltarFK_IdZonaPresupuestoVentasLineas(Border borderResaltar) {
		this.resaltarFK_IdZonaPresupuestoVentasLineas= borderResaltar;
	}

	public void setResaltarFK_IdZonaPresupuestoVentasLineas(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasLineasBeanSwingJInternalFrame presupuestoventaslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdZonaPresupuestoVentasLineas= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}