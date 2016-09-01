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
package com.bydan.erp.activosfijos.util;

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


import com.bydan.erp.activosfijos.util.DetalleActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.DetalleActivoFijoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.DetalleActivoFijoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.activosfijos.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetalleActivoFijoConstantesFunciones extends DetalleActivoFijoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleActivoFijo";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleActivoFijo"+DetalleActivoFijoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleActivoFijoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleActivoFijoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleActivoFijoConstantesFunciones.SCHEMA+"_"+DetalleActivoFijoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleActivoFijoConstantesFunciones.SCHEMA+"_"+DetalleActivoFijoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleActivoFijoConstantesFunciones.SCHEMA+"_"+DetalleActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleActivoFijoConstantesFunciones.SCHEMA+"_"+DetalleActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleActivoFijoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleActivoFijoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleActivoFijoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleActivoFijoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Activo Fijos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Activo Fijo";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Activo Fijo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleActivoFijo";
	public static final String OBJECTNAME="detalleactivofijo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="detalle_activo_fijo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detalleactivofijo from "+DetalleActivoFijoConstantesFunciones.SPERSISTENCENAME+" detalleactivofijo";
	public static String QUERYSELECTNATIVE="select "+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".id,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".version_row,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".id_empresa,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".id_detalle_grupo_activo_fijo,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".id_sub_grupo_activo_fijo,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".id_tipo_ramo_activo_fijo,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".id_tipo_activo_fijo_empresa,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".id_tipo_depreciacion_empresa,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".id_estado_activo_fijo,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".id_cliente,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".id_partida_presu,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".codigo,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".nombre,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".serie,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".fecha_compra,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".fecha_mantenimiento,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".fecha_correccion,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".fecha_depreciacion,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".clave,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".marca,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".modelo,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".color,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".fecha,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".valor_util,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".costo_de_compra,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".vida_util,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".valor_residual,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".cantidad,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".nombre_propietario,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".responsable,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".path_foto,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".numero_comprobante,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".referencia,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".valor_cotizacion,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".con_partes,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".con_garantia,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".con_existencia,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".fecha_baja,"+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME+".path_foto2 from "+DetalleActivoFijoConstantesFunciones.SCHEMA+"."+DetalleActivoFijoConstantesFunciones.TABLENAME;//+" as "+DetalleActivoFijoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleActivoFijoConstantesFuncionesAdditional detalleactivofijoConstantesFuncionesAdditional=null;
	
	public DetalleActivoFijoConstantesFuncionesAdditional getDetalleActivoFijoConstantesFuncionesAdditional() {
		return this.detalleactivofijoConstantesFuncionesAdditional;
	}
	
	public void setDetalleActivoFijoConstantesFuncionesAdditional(DetalleActivoFijoConstantesFuncionesAdditional detalleactivofijoConstantesFuncionesAdditional) {
		try {
			this.detalleactivofijoConstantesFuncionesAdditional=detalleactivofijoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDDETALLEGRUPOACTIVOFIJO= "id_detalle_grupo_activo_fijo";
    public static final String IDSUBGRUPOACTIVOFIJO= "id_sub_grupo_activo_fijo";
    public static final String IDTIPORAMOACTIVOFIJO= "id_tipo_ramo_activo_fijo";
    public static final String IDTIPOACTIVOFIJOEMPRESA= "id_tipo_activo_fijo_empresa";
    public static final String IDTIPODEPRECIACIONEMPRESA= "id_tipo_depreciacion_empresa";
    public static final String IDESTADOACTIVOFIJO= "id_estado_activo_fijo";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDPARTIDAPRESU= "id_partida_presu";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String SERIE= "serie";
    public static final String FECHACOMPRA= "fecha_compra";
    public static final String FECHAMANTENIMIENTO= "fecha_mantenimiento";
    public static final String FECHACORRECCION= "fecha_correccion";
    public static final String FECHADEPRECIACION= "fecha_depreciacion";
    public static final String CLAVE= "clave";
    public static final String MARCA= "marca";
    public static final String MODELO= "modelo";
    public static final String COLOR= "color";
    public static final String FECHA= "fecha";
    public static final String VALORUTIL= "valor_util";
    public static final String COSTODECOMPRA= "costo_de_compra";
    public static final String VIDAUTIL= "vida_util";
    public static final String VALORRESIDUAL= "valor_residual";
    public static final String CANTIDAD= "cantidad";
    public static final String NOMBREPROPIETARIO= "nombre_propietario";
    public static final String RESPONSABLE= "responsable";
    public static final String PATHFOTO= "path_foto";
    public static final String NUMEROCOMPROBANTE= "numero_comprobante";
    public static final String REFERENCIA= "referencia";
    public static final String VALORCOTIZACION= "valor_cotizacion";
    public static final String CONPARTES= "con_partes";
    public static final String CONGARANTIA= "con_garantia";
    public static final String CONEXISTENCIA= "con_existencia";
    public static final String FECHABAJA= "fecha_baja";
    public static final String PATHFOTO2= "path_foto2";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDDETALLEGRUPOACTIVOFIJO= "Detalle Grupo Activo Fijo";
		public static final String LABEL_IDDETALLEGRUPOACTIVOFIJO_LOWER= "Detalle Grupo Activo Fijo";
    	public static final String LABEL_IDSUBGRUPOACTIVOFIJO= "Sub Grupo Activo Fijo";
		public static final String LABEL_IDSUBGRUPOACTIVOFIJO_LOWER= "Sub Grupo Activo Fijo";
    	public static final String LABEL_IDTIPORAMOACTIVOFIJO= "Tipo Ramo Activo Fijo";
		public static final String LABEL_IDTIPORAMOACTIVOFIJO_LOWER= "Tipo Ramo Activo Fijo";
    	public static final String LABEL_IDTIPOACTIVOFIJOEMPRESA= "Tipo Activo Fijo Empresa";
		public static final String LABEL_IDTIPOACTIVOFIJOEMPRESA_LOWER= "Tipo Activo Fijo Empresa";
    	public static final String LABEL_IDTIPODEPRECIACIONEMPRESA= "Tipo Depreciacion Empresa";
		public static final String LABEL_IDTIPODEPRECIACIONEMPRESA_LOWER= "Tipo Depreciacion Empresa";
    	public static final String LABEL_IDESTADOACTIVOFIJO= "Estado Activo Fijo";
		public static final String LABEL_IDESTADOACTIVOFIJO_LOWER= "Estado Activo Fijo";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDPARTIDAPRESU= "Parta Presu";
		public static final String LABEL_IDPARTIDAPRESU_LOWER= "Partida Presu";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_SERIE= "Serie";
		public static final String LABEL_SERIE_LOWER= "Serie";
    	public static final String LABEL_FECHACOMPRA= "Fecha Compra";
		public static final String LABEL_FECHACOMPRA_LOWER= "Fecha Compra";
    	public static final String LABEL_FECHAMANTENIMIENTO= "Fecha Mantenimiento";
		public static final String LABEL_FECHAMANTENIMIENTO_LOWER= "Fecha Mantenimiento";
    	public static final String LABEL_FECHACORRECCION= "Fecha Correccion";
		public static final String LABEL_FECHACORRECCION_LOWER= "Fecha Correccion";
    	public static final String LABEL_FECHADEPRECIACION= "Fecha Depreciacion";
		public static final String LABEL_FECHADEPRECIACION_LOWER= "Fecha Depreciacion";
    	public static final String LABEL_CLAVE= "Clave";
		public static final String LABEL_CLAVE_LOWER= "Clave";
    	public static final String LABEL_MARCA= "Marca";
		public static final String LABEL_MARCA_LOWER= "Marca";
    	public static final String LABEL_MODELO= "Modelo";
		public static final String LABEL_MODELO_LOWER= "Modelo";
    	public static final String LABEL_COLOR= "Color";
		public static final String LABEL_COLOR_LOWER= "Color";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_VALORUTIL= "Valor Util";
		public static final String LABEL_VALORUTIL_LOWER= "Valor Util";
    	public static final String LABEL_COSTODECOMPRA= "Costo De Compra";
		public static final String LABEL_COSTODECOMPRA_LOWER= "Costo De Compra";
    	public static final String LABEL_VIDAUTIL= "Vida Util";
		public static final String LABEL_VIDAUTIL_LOWER= "Vida Util";
    	public static final String LABEL_VALORRESIDUAL= "Valor Residual";
		public static final String LABEL_VALORRESIDUAL_LOWER= "Valor Residual";
    	public static final String LABEL_CANTIDAD= "Cantidad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_NOMBREPROPIETARIO= "Nombre Propietario";
		public static final String LABEL_NOMBREPROPIETARIO_LOWER= "Nombre Propietario";
    	public static final String LABEL_RESPONSABLE= "Responsable Propietario";
		public static final String LABEL_RESPONSABLE_LOWER= "Responsable";
    	public static final String LABEL_PATHFOTO= "Path Foto";
		public static final String LABEL_PATHFOTO_LOWER= "Path Foto";
    	public static final String LABEL_NUMEROCOMPROBANTE= "Numero Comprobante";
		public static final String LABEL_NUMEROCOMPROBANTE_LOWER= "Numero Comprobante";
    	public static final String LABEL_REFERENCIA= "Referencia";
		public static final String LABEL_REFERENCIA_LOWER= "Referencia";
    	public static final String LABEL_VALORCOTIZACION= "Valor Cotizacion";
		public static final String LABEL_VALORCOTIZACION_LOWER= "Valor Cotizacion";
    	public static final String LABEL_CONPARTES= "Con Partes";
		public static final String LABEL_CONPARTES_LOWER= "Con Partes";
    	public static final String LABEL_CONGARANTIA= "Con Garantia";
		public static final String LABEL_CONGARANTIA_LOWER= "Con Garantia";
    	public static final String LABEL_CONEXISTENCIA= "Con Existencia";
		public static final String LABEL_CONEXISTENCIA_LOWER= "Con Existencia";
    	public static final String LABEL_FECHABAJA= "Fecha Baja";
		public static final String LABEL_FECHABAJA_LOWER= "Fecha Baja";
    	public static final String LABEL_PATHFOTO2= "Path Foto2";
		public static final String LABEL_PATHFOTO2_LOWER= "Path Foto2";
	
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSERIE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSERIE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXCLAVE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCLAVE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXMARCA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXMARCA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXMODELO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXMODELO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCOLOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCOLOR=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_PROPIETARIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PROPIETARIO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRESPONSABLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRESPONSABLE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXPATH_FOTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXPATH_FOTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXREFERENCIA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXREFERENCIA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	public static final String SREGEXPATH_FOTO2=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXPATH_FOTO2=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getDetalleActivoFijoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_IDDETALLEGRUPOACTIVOFIJO;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.IDSUBGRUPOACTIVOFIJO)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_IDSUBGRUPOACTIVOFIJO;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.IDTIPORAMOACTIVOFIJO)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_IDTIPORAMOACTIVOFIJO;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.IDTIPOACTIVOFIJOEMPRESA)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_IDTIPOACTIVOFIJOEMPRESA;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.IDTIPODEPRECIACIONEMPRESA)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_IDTIPODEPRECIACIONEMPRESA;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.IDESTADOACTIVOFIJO)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_IDESTADOACTIVOFIJO;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.IDCLIENTE)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.IDPARTIDAPRESU)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_IDPARTIDAPRESU;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.CODIGO)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.NOMBRE)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.SERIE)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_SERIE;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.FECHACOMPRA)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_FECHACOMPRA;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.FECHAMANTENIMIENTO)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_FECHAMANTENIMIENTO;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.FECHACORRECCION)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_FECHACORRECCION;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.FECHADEPRECIACION)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_FECHADEPRECIACION;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.CLAVE)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_CLAVE;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.MARCA)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_MARCA;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.MODELO)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_MODELO;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.COLOR)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_COLOR;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.FECHA)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.VALORUTIL)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_VALORUTIL;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.COSTODECOMPRA)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_COSTODECOMPRA;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.VIDAUTIL)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_VIDAUTIL;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.VALORRESIDUAL)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_VALORRESIDUAL;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.CANTIDAD)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.NOMBREPROPIETARIO)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_NOMBREPROPIETARIO;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.RESPONSABLE)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_RESPONSABLE;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.PATHFOTO)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_PATHFOTO;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.NUMEROCOMPROBANTE)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_NUMEROCOMPROBANTE;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.REFERENCIA)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_REFERENCIA;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.VALORCOTIZACION)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_VALORCOTIZACION;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.CONPARTES)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_CONPARTES;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.CONGARANTIA)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_CONGARANTIA;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.CONEXISTENCIA)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_CONEXISTENCIA;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.FECHABAJA)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_FECHABAJA;}
		if(sNombreColumna.equals(DetalleActivoFijoConstantesFunciones.PATHFOTO2)) {sLabelColumna=DetalleActivoFijoConstantesFunciones.LABEL_PATHFOTO2;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getcon_partesDescripcion(DetalleActivoFijo detalleactivofijo) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!detalleactivofijo.getcon_partes()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_partesHtmlDescripcion(DetalleActivoFijo detalleactivofijo) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(detalleactivofijo.getId(),detalleactivofijo.getcon_partes());

		return sDescripcion;
	}	
		
	public static String getcon_garantiaDescripcion(DetalleActivoFijo detalleactivofijo) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!detalleactivofijo.getcon_garantia()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_garantiaHtmlDescripcion(DetalleActivoFijo detalleactivofijo) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(detalleactivofijo.getId(),detalleactivofijo.getcon_garantia());

		return sDescripcion;
	}	
		
	public static String getcon_existenciaDescripcion(DetalleActivoFijo detalleactivofijo) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!detalleactivofijo.getcon_existencia()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_existenciaHtmlDescripcion(DetalleActivoFijo detalleactivofijo) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(detalleactivofijo.getId(),detalleactivofijo.getcon_existencia());

		return sDescripcion;
	}	
			
			
	
	public static String getDetalleActivoFijoDescripcion(DetalleActivoFijo detalleactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detalleactivofijo !=null/* && detalleactivofijo.getId()!=0*/) {
			sDescripcion=detalleactivofijo.getcodigo();//detalleactivofijodetalleactivofijo.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleActivoFijoDescripcionDetallado(DetalleActivoFijo detalleactivofijo) {
		String sDescripcion="";
			
		sDescripcion+=DetalleActivoFijoConstantesFunciones.ID+"=";
		sDescripcion+=detalleactivofijo.getId().toString()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detalleactivofijo.getVersionRow().toString()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detalleactivofijo.getid_empresa().toString()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detalleactivofijo.getid_sucursal().toString()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO+"=";
		sDescripcion+=detalleactivofijo.getid_detalle_grupo_activo_fijo().toString()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.IDSUBGRUPOACTIVOFIJO+"=";
		sDescripcion+=detalleactivofijo.getid_sub_grupo_activo_fijo().toString()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.IDTIPORAMOACTIVOFIJO+"=";
		sDescripcion+=detalleactivofijo.getid_tipo_ramo_activo_fijo().toString()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.IDTIPOACTIVOFIJOEMPRESA+"=";
		sDescripcion+=detalleactivofijo.getid_tipo_activo_fijo_empresa().toString()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.IDTIPODEPRECIACIONEMPRESA+"=";
		sDescripcion+=detalleactivofijo.getid_tipo_depreciacion_empresa().toString()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.IDESTADOACTIVOFIJO+"=";
		sDescripcion+=detalleactivofijo.getid_estado_activo_fijo().toString()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=detalleactivofijo.getid_cliente().toString()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.IDPARTIDAPRESU+"=";
		sDescripcion+=detalleactivofijo.getid_partida_presu().toString()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.CODIGO+"=";
		sDescripcion+=detalleactivofijo.getcodigo()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=detalleactivofijo.getnombre()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.SERIE+"=";
		sDescripcion+=detalleactivofijo.getserie()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.FECHACOMPRA+"=";
		sDescripcion+=detalleactivofijo.getfecha_compra().toString()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.FECHAMANTENIMIENTO+"=";
		sDescripcion+=detalleactivofijo.getfecha_mantenimiento().toString()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.FECHACORRECCION+"=";
		sDescripcion+=detalleactivofijo.getfecha_correccion().toString()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.FECHADEPRECIACION+"=";
		sDescripcion+=detalleactivofijo.getfecha_depreciacion().toString()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.CLAVE+"=";
		sDescripcion+=detalleactivofijo.getclave()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.MARCA+"=";
		sDescripcion+=detalleactivofijo.getmarca()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.MODELO+"=";
		sDescripcion+=detalleactivofijo.getmodelo()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.COLOR+"=";
		sDescripcion+=detalleactivofijo.getcolor()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.FECHA+"=";
		sDescripcion+=detalleactivofijo.getfecha().toString()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.VALORUTIL+"=";
		sDescripcion+=detalleactivofijo.getvalor_util().toString()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.COSTODECOMPRA+"=";
		sDescripcion+=detalleactivofijo.getcosto_de_compra().toString()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.VIDAUTIL+"=";
		sDescripcion+=detalleactivofijo.getvida_util().toString()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.VALORRESIDUAL+"=";
		sDescripcion+=detalleactivofijo.getvalor_residual().toString()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=detalleactivofijo.getcantidad().toString()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.NOMBREPROPIETARIO+"=";
		sDescripcion+=detalleactivofijo.getnombre_propietario()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.RESPONSABLE+"=";
		sDescripcion+=detalleactivofijo.getresponsable()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.PATHFOTO+"=";
		sDescripcion+=detalleactivofijo.getpath_foto()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.NUMEROCOMPROBANTE+"=";
		sDescripcion+=detalleactivofijo.getnumero_comprobante()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.REFERENCIA+"=";
		sDescripcion+=detalleactivofijo.getreferencia()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.VALORCOTIZACION+"=";
		sDescripcion+=detalleactivofijo.getvalor_cotizacion().toString()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.CONPARTES+"=";
		sDescripcion+=detalleactivofijo.getcon_partes().toString()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.CONGARANTIA+"=";
		sDescripcion+=detalleactivofijo.getcon_garantia().toString()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.CONEXISTENCIA+"=";
		sDescripcion+=detalleactivofijo.getcon_existencia().toString()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.FECHABAJA+"=";
		sDescripcion+=detalleactivofijo.getfecha_baja().toString()+",";
		sDescripcion+=DetalleActivoFijoConstantesFunciones.PATHFOTO2+"=";
		sDescripcion+=detalleactivofijo.getpath_foto2()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleActivoFijoDescripcion(DetalleActivoFijo detalleactivofijo,String sValor) throws Exception {			
		if(detalleactivofijo !=null) {
			detalleactivofijo.setcodigo(sValor);;//detalleactivofijodetalleactivofijo.getcodigo().trim();
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

	public static String getDetalleGrupoActivoFijoDescripcion(DetalleGrupoActivoFijo detallegrupoactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(detallegrupoactivofijo!=null/*&&detallegrupoactivofijo.getId()>0*/) {
			sDescripcion=DetalleGrupoActivoFijoConstantesFunciones.getDetalleGrupoActivoFijoDescripcion(detallegrupoactivofijo);
		}

		return sDescripcion;
	}

	public static String getSubGrupoActivoFijoDescripcion(SubGrupoActivoFijo subgrupoactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(subgrupoactivofijo!=null/*&&subgrupoactivofijo.getId()>0*/) {
			sDescripcion=SubGrupoActivoFijoConstantesFunciones.getSubGrupoActivoFijoDescripcion(subgrupoactivofijo);
		}

		return sDescripcion;
	}

	public static String getTipoRamoActivoFijoDescripcion(TipoRamoActivoFijo tiporamoactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporamoactivofijo!=null/*&&tiporamoactivofijo.getId()>0*/) {
			sDescripcion=TipoRamoActivoFijoConstantesFunciones.getTipoRamoActivoFijoDescripcion(tiporamoactivofijo);
		}

		return sDescripcion;
	}

	public static String getTipoActivoFijoEmpresaDescripcion(TipoActivoFijoEmpresa tipoactivofijoempresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoactivofijoempresa!=null/*&&tipoactivofijoempresa.getId()>0*/) {
			sDescripcion=TipoActivoFijoEmpresaConstantesFunciones.getTipoActivoFijoEmpresaDescripcion(tipoactivofijoempresa);
		}

		return sDescripcion;
	}

	public static String getTipoDepreciacionEmpresaDescripcion(TipoDepreciacionEmpresa tipodepreciacionempresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodepreciacionempresa!=null/*&&tipodepreciacionempresa.getId()>0*/) {
			sDescripcion=TipoDepreciacionEmpresaConstantesFunciones.getTipoDepreciacionEmpresaDescripcion(tipodepreciacionempresa);
		}

		return sDescripcion;
	}

	public static String getEstadoActivoFijoDescripcion(EstadoActivoFijo estadoactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadoactivofijo!=null/*&&estadoactivofijo.getId()>0*/) {
			sDescripcion=EstadoActivoFijoConstantesFunciones.getEstadoActivoFijoDescripcion(estadoactivofijo);
		}

		return sDescripcion;
	}

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getPartidaPresuDescripcion(PartidaPresu partidapresu) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(partidapresu!=null/*&&partidapresu.getId()>0*/) {
			sDescripcion=PartidaPresuConstantesFunciones.getPartidaPresuDescripcion(partidapresu);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdDetalleGrupoActivoFijo")) {
			sNombreIndice="Tipo=  Por Detalle Grupo Activo Fijo";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoActivoFijo")) {
			sNombreIndice="Tipo=  Por Estado Activo Fijo";
		} else if(sNombreIndice.equals("FK_IdPartidaPresu")) {
			sNombreIndice="Tipo=  Por Parta Presu";
		} else if(sNombreIndice.equals("FK_IdSubGrupoActivoFijo")) {
			sNombreIndice="Tipo=  Por Sub Grupo Activo Fijo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoActivoFijoEmpresa")) {
			sNombreIndice="Tipo=  Por Tipo Activo Fijo Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoDepreciacionEmpresa")) {
			sNombreIndice="Tipo=  Por Tipo Depreciacion Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoRamoActivoFijo")) {
			sNombreIndice="Tipo=  Por Tipo Ramo Activo Fijo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdDetalleGrupoActivoFijo(Long id_detalle_grupo_activo_fijo) {
		String sDetalleIndice=" Parametros->";
		if(id_detalle_grupo_activo_fijo!=null) {sDetalleIndice+=" Codigo Unico De Detalle Grupo Activo Fijo="+id_detalle_grupo_activo_fijo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoActivoFijo(Long id_estado_activo_fijo) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_activo_fijo!=null) {sDetalleIndice+=" Codigo Unico De Estado Activo Fijo="+id_estado_activo_fijo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPartidaPresu(Long id_partida_presu) {
		String sDetalleIndice=" Parametros->";
		if(id_partida_presu!=null) {sDetalleIndice+=" Codigo Unico De Parta Presu="+id_partida_presu.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSubGrupoActivoFijo(Long id_sub_grupo_activo_fijo) {
		String sDetalleIndice=" Parametros->";
		if(id_sub_grupo_activo_fijo!=null) {sDetalleIndice+=" Codigo Unico De Sub Grupo Activo Fijo="+id_sub_grupo_activo_fijo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoActivoFijoEmpresa(Long id_tipo_activo_fijo_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_activo_fijo_empresa!=null) {sDetalleIndice+=" Codigo Unico De Tipo Activo Fijo Empresa="+id_tipo_activo_fijo_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoDepreciacionEmpresa(Long id_tipo_depreciacion_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_depreciacion_empresa!=null) {sDetalleIndice+=" Codigo Unico De Tipo Depreciacion Empresa="+id_tipo_depreciacion_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRamoActivoFijo(Long id_tipo_ramo_activo_fijo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_ramo_activo_fijo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Ramo Activo Fijo="+id_tipo_ramo_activo_fijo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetalleActivoFijo(DetalleActivoFijo detalleactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detalleactivofijo.setcodigo(detalleactivofijo.getcodigo().trim());
		detalleactivofijo.setnombre(detalleactivofijo.getnombre().trim());
		detalleactivofijo.setserie(detalleactivofijo.getserie().trim());
		detalleactivofijo.setclave(detalleactivofijo.getclave().trim());
		detalleactivofijo.setmarca(detalleactivofijo.getmarca().trim());
		detalleactivofijo.setmodelo(detalleactivofijo.getmodelo().trim());
		detalleactivofijo.setcolor(detalleactivofijo.getcolor().trim());
		detalleactivofijo.setnombre_propietario(detalleactivofijo.getnombre_propietario().trim());
		detalleactivofijo.setresponsable(detalleactivofijo.getresponsable().trim());
		detalleactivofijo.setpath_foto(detalleactivofijo.getpath_foto().trim());
		detalleactivofijo.setnumero_comprobante(detalleactivofijo.getnumero_comprobante().trim());
		detalleactivofijo.setreferencia(detalleactivofijo.getreferencia().trim());
		detalleactivofijo.setpath_foto2(detalleactivofijo.getpath_foto2().trim());
	}
	
	public static void quitarEspaciosDetalleActivoFijos(List<DetalleActivoFijo> detalleactivofijos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleActivoFijo detalleactivofijo: detalleactivofijos) {
			detalleactivofijo.setcodigo(detalleactivofijo.getcodigo().trim());
			detalleactivofijo.setnombre(detalleactivofijo.getnombre().trim());
			detalleactivofijo.setserie(detalleactivofijo.getserie().trim());
			detalleactivofijo.setclave(detalleactivofijo.getclave().trim());
			detalleactivofijo.setmarca(detalleactivofijo.getmarca().trim());
			detalleactivofijo.setmodelo(detalleactivofijo.getmodelo().trim());
			detalleactivofijo.setcolor(detalleactivofijo.getcolor().trim());
			detalleactivofijo.setnombre_propietario(detalleactivofijo.getnombre_propietario().trim());
			detalleactivofijo.setresponsable(detalleactivofijo.getresponsable().trim());
			detalleactivofijo.setpath_foto(detalleactivofijo.getpath_foto().trim());
			detalleactivofijo.setnumero_comprobante(detalleactivofijo.getnumero_comprobante().trim());
			detalleactivofijo.setreferencia(detalleactivofijo.getreferencia().trim());
			detalleactivofijo.setpath_foto2(detalleactivofijo.getpath_foto2().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleActivoFijo(DetalleActivoFijo detalleactivofijo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detalleactivofijo.getConCambioAuxiliar()) {
			detalleactivofijo.setIsDeleted(detalleactivofijo.getIsDeletedAuxiliar());	
			detalleactivofijo.setIsNew(detalleactivofijo.getIsNewAuxiliar());	
			detalleactivofijo.setIsChanged(detalleactivofijo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detalleactivofijo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detalleactivofijo.setIsDeletedAuxiliar(false);	
			detalleactivofijo.setIsNewAuxiliar(false);	
			detalleactivofijo.setIsChangedAuxiliar(false);
			
			detalleactivofijo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleActivoFijos(List<DetalleActivoFijo> detalleactivofijos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleActivoFijo detalleactivofijo : detalleactivofijos) {
			if(conAsignarBase && detalleactivofijo.getConCambioAuxiliar()) {
				detalleactivofijo.setIsDeleted(detalleactivofijo.getIsDeletedAuxiliar());	
				detalleactivofijo.setIsNew(detalleactivofijo.getIsNewAuxiliar());	
				detalleactivofijo.setIsChanged(detalleactivofijo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detalleactivofijo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detalleactivofijo.setIsDeletedAuxiliar(false);	
				detalleactivofijo.setIsNewAuxiliar(false);	
				detalleactivofijo.setIsChangedAuxiliar(false);
				
				detalleactivofijo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleActivoFijo(DetalleActivoFijo detalleactivofijo,Boolean conEnteros) throws Exception  {
		detalleactivofijo.setvalor_util(0.0);
		detalleactivofijo.setcosto_de_compra(0.0);
		detalleactivofijo.setvida_util(0.0);
		detalleactivofijo.setvalor_residual(0.0);
		detalleactivofijo.setvalor_cotizacion(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			detalleactivofijo.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresDetalleActivoFijos(List<DetalleActivoFijo> detalleactivofijos,Boolean conEnteros) throws Exception  {
		
		for(DetalleActivoFijo detalleactivofijo: detalleactivofijos) {
			detalleactivofijo.setvalor_util(0.0);
			detalleactivofijo.setcosto_de_compra(0.0);
			detalleactivofijo.setvida_util(0.0);
			detalleactivofijo.setvalor_residual(0.0);
			detalleactivofijo.setvalor_cotizacion(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				detalleactivofijo.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleActivoFijo(List<DetalleActivoFijo> detalleactivofijos,DetalleActivoFijo detalleactivofijoAux) throws Exception  {
		DetalleActivoFijoConstantesFunciones.InicializarValoresDetalleActivoFijo(detalleactivofijoAux,true);
		
		for(DetalleActivoFijo detalleactivofijo: detalleactivofijos) {
			if(detalleactivofijo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detalleactivofijoAux.setvalor_util(detalleactivofijoAux.getvalor_util()+detalleactivofijo.getvalor_util());			
			detalleactivofijoAux.setcosto_de_compra(detalleactivofijoAux.getcosto_de_compra()+detalleactivofijo.getcosto_de_compra());			
			detalleactivofijoAux.setvida_util(detalleactivofijoAux.getvida_util()+detalleactivofijo.getvida_util());			
			detalleactivofijoAux.setvalor_residual(detalleactivofijoAux.getvalor_residual()+detalleactivofijo.getvalor_residual());			
			detalleactivofijoAux.setcantidad(detalleactivofijoAux.getcantidad()+detalleactivofijo.getcantidad());			
			detalleactivofijoAux.setvalor_cotizacion(detalleactivofijoAux.getvalor_cotizacion()+detalleactivofijo.getvalor_cotizacion());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleActivoFijoConstantesFunciones.getArrayColumnasGlobalesDetalleActivoFijo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleActivoFijoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleActivoFijoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleActivoFijoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleActivoFijoConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleActivoFijo> detalleactivofijos,DetalleActivoFijo detalleactivofijo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleActivoFijo detalleactivofijoAux: detalleactivofijos) {
			if(detalleactivofijoAux!=null && detalleactivofijo!=null) {
				if((detalleactivofijoAux.getId()==null && detalleactivofijo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detalleactivofijoAux.getId()!=null && detalleactivofijo.getId()!=null){
					if(detalleactivofijoAux.getId().equals(detalleactivofijo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleActivoFijo(List<DetalleActivoFijo> detalleactivofijos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_utilTotal=0.0;
		Double costo_de_compraTotal=0.0;
		Double vida_utilTotal=0.0;
		Double valor_residualTotal=0.0;
		Double valor_cotizacionTotal=0.0;
	
		for(DetalleActivoFijo detalleactivofijo: detalleactivofijos) {			
			if(detalleactivofijo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_utilTotal+=detalleactivofijo.getvalor_util();
			costo_de_compraTotal+=detalleactivofijo.getcosto_de_compra();
			vida_utilTotal+=detalleactivofijo.getvida_util();
			valor_residualTotal+=detalleactivofijo.getvalor_residual();
			valor_cotizacionTotal+=detalleactivofijo.getvalor_cotizacion();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleActivoFijoConstantesFunciones.VALORUTIL);
		datoGeneral.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_VALORUTIL);
		datoGeneral.setdValorDouble(valor_utilTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleActivoFijoConstantesFunciones.COSTODECOMPRA);
		datoGeneral.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_COSTODECOMPRA);
		datoGeneral.setdValorDouble(costo_de_compraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleActivoFijoConstantesFunciones.VIDAUTIL);
		datoGeneral.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_VIDAUTIL);
		datoGeneral.setdValorDouble(vida_utilTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleActivoFijoConstantesFunciones.VALORRESIDUAL);
		datoGeneral.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_VALORRESIDUAL);
		datoGeneral.setdValorDouble(valor_residualTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleActivoFijoConstantesFunciones.VALORCOTIZACION);
		datoGeneral.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_VALORCOTIZACION);
		datoGeneral.setdValorDouble(valor_cotizacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleActivoFijo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_ID, DetalleActivoFijoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_VERSIONROW, DetalleActivoFijoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_IDEMPRESA, DetalleActivoFijoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_IDSUCURSAL, DetalleActivoFijoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_IDDETALLEGRUPOACTIVOFIJO, DetalleActivoFijoConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_IDSUBGRUPOACTIVOFIJO, DetalleActivoFijoConstantesFunciones.IDSUBGRUPOACTIVOFIJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_IDTIPORAMOACTIVOFIJO, DetalleActivoFijoConstantesFunciones.IDTIPORAMOACTIVOFIJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_IDTIPOACTIVOFIJOEMPRESA, DetalleActivoFijoConstantesFunciones.IDTIPOACTIVOFIJOEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_IDTIPODEPRECIACIONEMPRESA, DetalleActivoFijoConstantesFunciones.IDTIPODEPRECIACIONEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_IDESTADOACTIVOFIJO, DetalleActivoFijoConstantesFunciones.IDESTADOACTIVOFIJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_IDCLIENTE, DetalleActivoFijoConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_IDPARTIDAPRESU, DetalleActivoFijoConstantesFunciones.IDPARTIDAPRESU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_CODIGO, DetalleActivoFijoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_NOMBRE, DetalleActivoFijoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_SERIE, DetalleActivoFijoConstantesFunciones.SERIE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_FECHACOMPRA, DetalleActivoFijoConstantesFunciones.FECHACOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_FECHAMANTENIMIENTO, DetalleActivoFijoConstantesFunciones.FECHAMANTENIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_FECHACORRECCION, DetalleActivoFijoConstantesFunciones.FECHACORRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_FECHADEPRECIACION, DetalleActivoFijoConstantesFunciones.FECHADEPRECIACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_CLAVE, DetalleActivoFijoConstantesFunciones.CLAVE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_MARCA, DetalleActivoFijoConstantesFunciones.MARCA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_MODELO, DetalleActivoFijoConstantesFunciones.MODELO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_COLOR, DetalleActivoFijoConstantesFunciones.COLOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_FECHA, DetalleActivoFijoConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_VALORUTIL, DetalleActivoFijoConstantesFunciones.VALORUTIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_COSTODECOMPRA, DetalleActivoFijoConstantesFunciones.COSTODECOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_VIDAUTIL, DetalleActivoFijoConstantesFunciones.VIDAUTIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_VALORRESIDUAL, DetalleActivoFijoConstantesFunciones.VALORRESIDUAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_CANTIDAD, DetalleActivoFijoConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_NOMBREPROPIETARIO, DetalleActivoFijoConstantesFunciones.NOMBREPROPIETARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_RESPONSABLE, DetalleActivoFijoConstantesFunciones.RESPONSABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_PATHFOTO, DetalleActivoFijoConstantesFunciones.PATHFOTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_NUMEROCOMPROBANTE, DetalleActivoFijoConstantesFunciones.NUMEROCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_REFERENCIA, DetalleActivoFijoConstantesFunciones.REFERENCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_VALORCOTIZACION, DetalleActivoFijoConstantesFunciones.VALORCOTIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_CONPARTES, DetalleActivoFijoConstantesFunciones.CONPARTES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_CONGARANTIA, DetalleActivoFijoConstantesFunciones.CONGARANTIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_CONEXISTENCIA, DetalleActivoFijoConstantesFunciones.CONEXISTENCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_FECHABAJA, DetalleActivoFijoConstantesFunciones.FECHABAJA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleActivoFijoConstantesFunciones.LABEL_PATHFOTO2, DetalleActivoFijoConstantesFunciones.PATHFOTO2,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleActivoFijo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.IDSUBGRUPOACTIVOFIJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.IDTIPORAMOACTIVOFIJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.IDTIPOACTIVOFIJOEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.IDTIPODEPRECIACIONEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.IDESTADOACTIVOFIJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.IDPARTIDAPRESU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.SERIE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.FECHACOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.FECHAMANTENIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.FECHACORRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.FECHADEPRECIACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.CLAVE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.MARCA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.MODELO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.COLOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.VALORUTIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.COSTODECOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.VIDAUTIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.VALORRESIDUAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.NOMBREPROPIETARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.RESPONSABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.PATHFOTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.NUMEROCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.REFERENCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.VALORCOTIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.CONPARTES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.CONGARANTIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.CONEXISTENCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.FECHABAJA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleActivoFijoConstantesFunciones.PATHFOTO2;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleActivoFijo() throws Exception  {
		return DetalleActivoFijoConstantesFunciones.getTiposSeleccionarDetalleActivoFijo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleActivoFijo(Boolean conFk) throws Exception  {
		return DetalleActivoFijoConstantesFunciones.getTiposSeleccionarDetalleActivoFijo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleActivoFijo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_IDDETALLEGRUPOACTIVOFIJO);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_IDDETALLEGRUPOACTIVOFIJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_IDSUBGRUPOACTIVOFIJO);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_IDSUBGRUPOACTIVOFIJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_IDTIPORAMOACTIVOFIJO);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_IDTIPORAMOACTIVOFIJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_IDTIPOACTIVOFIJOEMPRESA);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_IDTIPOACTIVOFIJOEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_IDTIPODEPRECIACIONEMPRESA);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_IDTIPODEPRECIACIONEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_IDESTADOACTIVOFIJO);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_IDESTADOACTIVOFIJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_IDPARTIDAPRESU);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_IDPARTIDAPRESU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_SERIE);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_SERIE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_FECHACOMPRA);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_FECHACOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_FECHAMANTENIMIENTO);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_FECHAMANTENIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_FECHACORRECCION);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_FECHACORRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_FECHADEPRECIACION);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_FECHADEPRECIACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_CLAVE);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_CLAVE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_MARCA);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_MARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_MODELO);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_MODELO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_COLOR);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_COLOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_VALORUTIL);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_VALORUTIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_COSTODECOMPRA);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_COSTODECOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_VIDAUTIL);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_VIDAUTIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_VALORRESIDUAL);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_VALORRESIDUAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_NOMBREPROPIETARIO);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_NOMBREPROPIETARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_RESPONSABLE);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_RESPONSABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_PATHFOTO);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_PATHFOTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_NUMEROCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_REFERENCIA);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_REFERENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_VALORCOTIZACION);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_VALORCOTIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_CONPARTES);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_CONPARTES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_CONGARANTIA);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_CONGARANTIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_CONEXISTENCIA);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_CONEXISTENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_FECHABAJA);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_FECHABAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleActivoFijoConstantesFunciones.LABEL_PATHFOTO2);
			reporte.setsDescripcion(DetalleActivoFijoConstantesFunciones.LABEL_PATHFOTO2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleActivoFijo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleActivoFijo(DetalleActivoFijo detalleactivofijoAux) throws Exception {
		
			detalleactivofijoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleactivofijoAux.getEmpresa()));
			detalleactivofijoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleactivofijoAux.getSucursal()));
			detalleactivofijoAux.setdetallegrupoactivofijo_descripcion(DetalleGrupoActivoFijoConstantesFunciones.getDetalleGrupoActivoFijoDescripcion(detalleactivofijoAux.getDetalleGrupoActivoFijo()));
			detalleactivofijoAux.setsubgrupoactivofijo_descripcion(SubGrupoActivoFijoConstantesFunciones.getSubGrupoActivoFijoDescripcion(detalleactivofijoAux.getSubGrupoActivoFijo()));
			detalleactivofijoAux.settiporamoactivofijo_descripcion(TipoRamoActivoFijoConstantesFunciones.getTipoRamoActivoFijoDescripcion(detalleactivofijoAux.getTipoRamoActivoFijo()));
			detalleactivofijoAux.settipoactivofijoempresa_descripcion(TipoActivoFijoEmpresaConstantesFunciones.getTipoActivoFijoEmpresaDescripcion(detalleactivofijoAux.getTipoActivoFijoEmpresa()));
			detalleactivofijoAux.settipodepreciacionempresa_descripcion(TipoDepreciacionEmpresaConstantesFunciones.getTipoDepreciacionEmpresaDescripcion(detalleactivofijoAux.getTipoDepreciacionEmpresa()));
			detalleactivofijoAux.setestadoactivofijo_descripcion(EstadoActivoFijoConstantesFunciones.getEstadoActivoFijoDescripcion(detalleactivofijoAux.getEstadoActivoFijo()));
			detalleactivofijoAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(detalleactivofijoAux.getCliente()));
			detalleactivofijoAux.setpartidapresu_descripcion(PartidaPresuConstantesFunciones.getPartidaPresuDescripcion(detalleactivofijoAux.getPartidaPresu()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleActivoFijo(List<DetalleActivoFijo> detalleactivofijosTemp) throws Exception {
		for(DetalleActivoFijo detalleactivofijoAux:detalleactivofijosTemp) {
			
			detalleactivofijoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleactivofijoAux.getEmpresa()));
			detalleactivofijoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleactivofijoAux.getSucursal()));
			detalleactivofijoAux.setdetallegrupoactivofijo_descripcion(DetalleGrupoActivoFijoConstantesFunciones.getDetalleGrupoActivoFijoDescripcion(detalleactivofijoAux.getDetalleGrupoActivoFijo()));
			detalleactivofijoAux.setsubgrupoactivofijo_descripcion(SubGrupoActivoFijoConstantesFunciones.getSubGrupoActivoFijoDescripcion(detalleactivofijoAux.getSubGrupoActivoFijo()));
			detalleactivofijoAux.settiporamoactivofijo_descripcion(TipoRamoActivoFijoConstantesFunciones.getTipoRamoActivoFijoDescripcion(detalleactivofijoAux.getTipoRamoActivoFijo()));
			detalleactivofijoAux.settipoactivofijoempresa_descripcion(TipoActivoFijoEmpresaConstantesFunciones.getTipoActivoFijoEmpresaDescripcion(detalleactivofijoAux.getTipoActivoFijoEmpresa()));
			detalleactivofijoAux.settipodepreciacionempresa_descripcion(TipoDepreciacionEmpresaConstantesFunciones.getTipoDepreciacionEmpresaDescripcion(detalleactivofijoAux.getTipoDepreciacionEmpresa()));
			detalleactivofijoAux.setestadoactivofijo_descripcion(EstadoActivoFijoConstantesFunciones.getEstadoActivoFijoDescripcion(detalleactivofijoAux.getEstadoActivoFijo()));
			detalleactivofijoAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(detalleactivofijoAux.getCliente()));
			detalleactivofijoAux.setpartidapresu_descripcion(PartidaPresuConstantesFunciones.getPartidaPresuDescripcion(detalleactivofijoAux.getPartidaPresu()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(DetalleGrupoActivoFijo.class));
				classes.add(new Classe(SubGrupoActivoFijo.class));
				classes.add(new Classe(TipoRamoActivoFijo.class));
				classes.add(new Classe(TipoActivoFijoEmpresa.class));
				classes.add(new Classe(TipoDepreciacionEmpresa.class));
				classes.add(new Classe(EstadoActivoFijo.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(PartidaPresu.class));
				
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
					if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
						classes.add(new Classe(DetalleGrupoActivoFijo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(SubGrupoActivoFijo.class)) {
						classes.add(new Classe(SubGrupoActivoFijo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRamoActivoFijo.class)) {
						classes.add(new Classe(TipoRamoActivoFijo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoActivoFijoEmpresa.class)) {
						classes.add(new Classe(TipoActivoFijoEmpresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDepreciacionEmpresa.class)) {
						classes.add(new Classe(TipoDepreciacionEmpresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoActivoFijo.class)) {
						classes.add(new Classe(EstadoActivoFijo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PartidaPresu.class)) {
						classes.add(new Classe(PartidaPresu.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(DetalleGrupoActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleGrupoActivoFijo.class)); continue;
					}

					if(SubGrupoActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubGrupoActivoFijo.class)); continue;
					}

					if(TipoRamoActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRamoActivoFijo.class)); continue;
					}

					if(TipoActivoFijoEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoActivoFijoEmpresa.class)); continue;
					}

					if(TipoDepreciacionEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDepreciacionEmpresa.class)); continue;
					}

					if(EstadoActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoActivoFijo.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(PartidaPresu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PartidaPresu.class)); continue;
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

					if(DetalleGrupoActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleGrupoActivoFijo.class)); continue;
					}

					if(SubGrupoActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubGrupoActivoFijo.class)); continue;
					}

					if(TipoRamoActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRamoActivoFijo.class)); continue;
					}

					if(TipoActivoFijoEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoActivoFijoEmpresa.class)); continue;
					}

					if(TipoDepreciacionEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDepreciacionEmpresa.class)); continue;
					}

					if(EstadoActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoActivoFijo.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(PartidaPresu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PartidaPresu.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleActivoFijoConstantesFunciones.getClassesRelationshipsOfDetalleActivoFijo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(MantenimientoActivoFijo.class));
				classes.add(new Classe(ServicioTransporte.class));
				classes.add(new Classe(MovimientoActivoFijo.class));
				classes.add(new Classe(Vehiculo.class));
				classes.add(new Classe(MetodoDepreciacion.class));
				classes.add(new Classe(ResponsableActivoFijo.class));
				classes.add(new Classe(DepreciacionActivoFijo.class));
				classes.add(new Classe(GastoDepreciacionCentroCosto.class));
				classes.add(new Classe(ParteActivoFijo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(MantenimientoActivoFijo.class)) {
						classes.add(new Classe(MantenimientoActivoFijo.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ServicioTransporte.class)) {
						classes.add(new Classe(ServicioTransporte.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(MovimientoActivoFijo.class)) {
						classes.add(new Classe(MovimientoActivoFijo.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Vehiculo.class)) {
						classes.add(new Classe(Vehiculo.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(MetodoDepreciacion.class)) {
						classes.add(new Classe(MetodoDepreciacion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ResponsableActivoFijo.class)) {
						classes.add(new Classe(ResponsableActivoFijo.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DepreciacionActivoFijo.class)) {
						classes.add(new Classe(DepreciacionActivoFijo.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(GastoDepreciacionCentroCosto.class)) {
						classes.add(new Classe(GastoDepreciacionCentroCosto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ParteActivoFijo.class)) {
						classes.add(new Classe(ParteActivoFijo.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleActivoFijoConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleActivoFijo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(MantenimientoActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MantenimientoActivoFijo.class)); continue;
					}

					if(ServicioTransporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ServicioTransporte.class)); continue;
					}

					if(MovimientoActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MovimientoActivoFijo.class)); continue;
					}

					if(Vehiculo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vehiculo.class)); continue;
					}

					if(MetodoDepreciacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MetodoDepreciacion.class)); continue;
					}

					if(ResponsableActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ResponsableActivoFijo.class)); continue;
					}

					if(DepreciacionActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DepreciacionActivoFijo.class)); continue;
					}

					if(GastoDepreciacionCentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GastoDepreciacionCentroCosto.class)); continue;
					}

					if(ParteActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParteActivoFijo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(MantenimientoActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MantenimientoActivoFijo.class)); continue;
					}

					if(ServicioTransporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ServicioTransporte.class)); continue;
					}

					if(MovimientoActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MovimientoActivoFijo.class)); continue;
					}

					if(Vehiculo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vehiculo.class)); continue;
					}

					if(MetodoDepreciacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MetodoDepreciacion.class)); continue;
					}

					if(ResponsableActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ResponsableActivoFijo.class)); continue;
					}

					if(DepreciacionActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DepreciacionActivoFijo.class)); continue;
					}

					if(GastoDepreciacionCentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GastoDepreciacionCentroCosto.class)); continue;
					}

					if(ParteActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParteActivoFijo.class)); continue;
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(DetalleActivoFijo detalleactivofijo,List<DetalleActivoFijo> detalleactivofijos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleActivoFijo detalleactivofijoEncontrado=null;
			
			for(DetalleActivoFijo detalleactivofijoLocal:detalleactivofijos) {
				if(detalleactivofijoLocal.getId().equals(detalleactivofijo.getId())) {
					detalleactivofijoEncontrado=detalleactivofijoLocal;
					
					detalleactivofijoLocal.setIsChanged(detalleactivofijo.getIsChanged());
					detalleactivofijoLocal.setIsNew(detalleactivofijo.getIsNew());
					detalleactivofijoLocal.setIsDeleted(detalleactivofijo.getIsDeleted());
					
					detalleactivofijoLocal.setGeneralEntityOriginal(detalleactivofijo.getGeneralEntityOriginal());
					
					detalleactivofijoLocal.setId(detalleactivofijo.getId());	
					detalleactivofijoLocal.setVersionRow(detalleactivofijo.getVersionRow());	
					detalleactivofijoLocal.setid_empresa(detalleactivofijo.getid_empresa());	
					detalleactivofijoLocal.setid_sucursal(detalleactivofijo.getid_sucursal());	
					detalleactivofijoLocal.setid_detalle_grupo_activo_fijo(detalleactivofijo.getid_detalle_grupo_activo_fijo());	
					detalleactivofijoLocal.setid_sub_grupo_activo_fijo(detalleactivofijo.getid_sub_grupo_activo_fijo());	
					detalleactivofijoLocal.setid_tipo_ramo_activo_fijo(detalleactivofijo.getid_tipo_ramo_activo_fijo());	
					detalleactivofijoLocal.setid_tipo_activo_fijo_empresa(detalleactivofijo.getid_tipo_activo_fijo_empresa());	
					detalleactivofijoLocal.setid_tipo_depreciacion_empresa(detalleactivofijo.getid_tipo_depreciacion_empresa());	
					detalleactivofijoLocal.setid_estado_activo_fijo(detalleactivofijo.getid_estado_activo_fijo());	
					detalleactivofijoLocal.setid_cliente(detalleactivofijo.getid_cliente());	
					detalleactivofijoLocal.setid_partida_presu(detalleactivofijo.getid_partida_presu());	
					detalleactivofijoLocal.setcodigo(detalleactivofijo.getcodigo());	
					detalleactivofijoLocal.setnombre(detalleactivofijo.getnombre());	
					detalleactivofijoLocal.setserie(detalleactivofijo.getserie());	
					detalleactivofijoLocal.setfecha_compra(detalleactivofijo.getfecha_compra());	
					detalleactivofijoLocal.setfecha_mantenimiento(detalleactivofijo.getfecha_mantenimiento());	
					detalleactivofijoLocal.setfecha_correccion(detalleactivofijo.getfecha_correccion());	
					detalleactivofijoLocal.setfecha_depreciacion(detalleactivofijo.getfecha_depreciacion());	
					detalleactivofijoLocal.setclave(detalleactivofijo.getclave());	
					detalleactivofijoLocal.setmarca(detalleactivofijo.getmarca());	
					detalleactivofijoLocal.setmodelo(detalleactivofijo.getmodelo());	
					detalleactivofijoLocal.setcolor(detalleactivofijo.getcolor());	
					detalleactivofijoLocal.setfecha(detalleactivofijo.getfecha());	
					detalleactivofijoLocal.setvalor_util(detalleactivofijo.getvalor_util());	
					detalleactivofijoLocal.setcosto_de_compra(detalleactivofijo.getcosto_de_compra());	
					detalleactivofijoLocal.setvida_util(detalleactivofijo.getvida_util());	
					detalleactivofijoLocal.setvalor_residual(detalleactivofijo.getvalor_residual());	
					detalleactivofijoLocal.setcantidad(detalleactivofijo.getcantidad());	
					detalleactivofijoLocal.setnombre_propietario(detalleactivofijo.getnombre_propietario());	
					detalleactivofijoLocal.setresponsable(detalleactivofijo.getresponsable());	
					detalleactivofijoLocal.setpath_foto(detalleactivofijo.getpath_foto());	
					detalleactivofijoLocal.setnumero_comprobante(detalleactivofijo.getnumero_comprobante());	
					detalleactivofijoLocal.setreferencia(detalleactivofijo.getreferencia());	
					detalleactivofijoLocal.setvalor_cotizacion(detalleactivofijo.getvalor_cotizacion());	
					detalleactivofijoLocal.setcon_partes(detalleactivofijo.getcon_partes());	
					detalleactivofijoLocal.setcon_garantia(detalleactivofijo.getcon_garantia());	
					detalleactivofijoLocal.setcon_existencia(detalleactivofijo.getcon_existencia());	
					detalleactivofijoLocal.setfecha_baja(detalleactivofijo.getfecha_baja());	
					detalleactivofijoLocal.setpath_foto2(detalleactivofijo.getpath_foto2());	
					
					
					detalleactivofijoLocal.setMantenimientoActivoFijos(detalleactivofijo.getMantenimientoActivoFijos());
					detalleactivofijoLocal.setServicioTransportes(detalleactivofijo.getServicioTransportes());
					detalleactivofijoLocal.setMovimientoActivoFijoDestinos(detalleactivofijo.getMovimientoActivoFijoDestinos());
					detalleactivofijoLocal.setVehiculos(detalleactivofijo.getVehiculos());
					detalleactivofijoLocal.setMetodoDepreciacions(detalleactivofijo.getMetodoDepreciacions());
					detalleactivofijoLocal.setResponsableActivoFijos(detalleactivofijo.getResponsableActivoFijos());
					detalleactivofijoLocal.setDepreciacionActivoFijos(detalleactivofijo.getDepreciacionActivoFijos());
					detalleactivofijoLocal.setGastoDepreciacionCentroCostos(detalleactivofijo.getGastoDepreciacionCentroCostos());
					detalleactivofijoLocal.setParteActivoFijos(detalleactivofijo.getParteActivoFijos());
					
					existe=true;
					break;
				}
			}
			
			if(!detalleactivofijo.getIsDeleted()) {
				if(!existe) {
					detalleactivofijos.add(detalleactivofijo);
				}
			} else {
				if(detalleactivofijoEncontrado!=null && permiteQuitar)  {
					detalleactivofijos.remove(detalleactivofijoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleActivoFijo detalleactivofijo,List<DetalleActivoFijo> detalleactivofijos) throws Exception {
		try	{			
			for(DetalleActivoFijo detalleactivofijoLocal:detalleactivofijos) {
				if(detalleactivofijoLocal.getId().equals(detalleactivofijo.getId())) {
					detalleactivofijoLocal.setIsSelected(detalleactivofijo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleActivoFijo(List<DetalleActivoFijo> detalleactivofijosAux) throws Exception {
		//this.detalleactivofijosAux=detalleactivofijosAux;
		
		for(DetalleActivoFijo detalleactivofijoAux:detalleactivofijosAux) {
			if(detalleactivofijoAux.getIsChanged()) {
				detalleactivofijoAux.setIsChanged(false);
			}		
			
			if(detalleactivofijoAux.getIsNew()) {
				detalleactivofijoAux.setIsNew(false);
			}	
			
			if(detalleactivofijoAux.getIsDeleted()) {
				detalleactivofijoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleActivoFijo(DetalleActivoFijo detalleactivofijoAux) throws Exception {
		//this.detalleactivofijoAux=detalleactivofijoAux;
		
			if(detalleactivofijoAux.getIsChanged()) {
				detalleactivofijoAux.setIsChanged(false);
			}		
			
			if(detalleactivofijoAux.getIsNew()) {
				detalleactivofijoAux.setIsNew(false);
			}	
			
			if(detalleactivofijoAux.getIsDeleted()) {
				detalleactivofijoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleActivoFijo detalleactivofijoAsignar,DetalleActivoFijo detalleactivofijo) throws Exception {
		detalleactivofijoAsignar.setId(detalleactivofijo.getId());	
		detalleactivofijoAsignar.setVersionRow(detalleactivofijo.getVersionRow());	
		detalleactivofijoAsignar.setid_empresa(detalleactivofijo.getid_empresa());
		detalleactivofijoAsignar.setempresa_descripcion(detalleactivofijo.getempresa_descripcion());	
		detalleactivofijoAsignar.setid_sucursal(detalleactivofijo.getid_sucursal());
		detalleactivofijoAsignar.setsucursal_descripcion(detalleactivofijo.getsucursal_descripcion());	
		detalleactivofijoAsignar.setid_detalle_grupo_activo_fijo(detalleactivofijo.getid_detalle_grupo_activo_fijo());
		detalleactivofijoAsignar.setdetallegrupoactivofijo_descripcion(detalleactivofijo.getdetallegrupoactivofijo_descripcion());	
		detalleactivofijoAsignar.setid_sub_grupo_activo_fijo(detalleactivofijo.getid_sub_grupo_activo_fijo());
		detalleactivofijoAsignar.setsubgrupoactivofijo_descripcion(detalleactivofijo.getsubgrupoactivofijo_descripcion());	
		detalleactivofijoAsignar.setid_tipo_ramo_activo_fijo(detalleactivofijo.getid_tipo_ramo_activo_fijo());
		detalleactivofijoAsignar.settiporamoactivofijo_descripcion(detalleactivofijo.gettiporamoactivofijo_descripcion());	
		detalleactivofijoAsignar.setid_tipo_activo_fijo_empresa(detalleactivofijo.getid_tipo_activo_fijo_empresa());
		detalleactivofijoAsignar.settipoactivofijoempresa_descripcion(detalleactivofijo.gettipoactivofijoempresa_descripcion());	
		detalleactivofijoAsignar.setid_tipo_depreciacion_empresa(detalleactivofijo.getid_tipo_depreciacion_empresa());
		detalleactivofijoAsignar.settipodepreciacionempresa_descripcion(detalleactivofijo.gettipodepreciacionempresa_descripcion());	
		detalleactivofijoAsignar.setid_estado_activo_fijo(detalleactivofijo.getid_estado_activo_fijo());
		detalleactivofijoAsignar.setestadoactivofijo_descripcion(detalleactivofijo.getestadoactivofijo_descripcion());	
		detalleactivofijoAsignar.setid_cliente(detalleactivofijo.getid_cliente());
		detalleactivofijoAsignar.setcliente_descripcion(detalleactivofijo.getcliente_descripcion());	
		detalleactivofijoAsignar.setid_partida_presu(detalleactivofijo.getid_partida_presu());
		detalleactivofijoAsignar.setpartidapresu_descripcion(detalleactivofijo.getpartidapresu_descripcion());	
		detalleactivofijoAsignar.setcodigo(detalleactivofijo.getcodigo());	
		detalleactivofijoAsignar.setnombre(detalleactivofijo.getnombre());	
		detalleactivofijoAsignar.setserie(detalleactivofijo.getserie());	
		detalleactivofijoAsignar.setfecha_compra(detalleactivofijo.getfecha_compra());	
		detalleactivofijoAsignar.setfecha_mantenimiento(detalleactivofijo.getfecha_mantenimiento());	
		detalleactivofijoAsignar.setfecha_correccion(detalleactivofijo.getfecha_correccion());	
		detalleactivofijoAsignar.setfecha_depreciacion(detalleactivofijo.getfecha_depreciacion());	
		detalleactivofijoAsignar.setclave(detalleactivofijo.getclave());	
		detalleactivofijoAsignar.setmarca(detalleactivofijo.getmarca());	
		detalleactivofijoAsignar.setmodelo(detalleactivofijo.getmodelo());	
		detalleactivofijoAsignar.setcolor(detalleactivofijo.getcolor());	
		detalleactivofijoAsignar.setfecha(detalleactivofijo.getfecha());	
		detalleactivofijoAsignar.setvalor_util(detalleactivofijo.getvalor_util());	
		detalleactivofijoAsignar.setcosto_de_compra(detalleactivofijo.getcosto_de_compra());	
		detalleactivofijoAsignar.setvida_util(detalleactivofijo.getvida_util());	
		detalleactivofijoAsignar.setvalor_residual(detalleactivofijo.getvalor_residual());	
		detalleactivofijoAsignar.setcantidad(detalleactivofijo.getcantidad());	
		detalleactivofijoAsignar.setnombre_propietario(detalleactivofijo.getnombre_propietario());	
		detalleactivofijoAsignar.setresponsable(detalleactivofijo.getresponsable());	
		detalleactivofijoAsignar.setpath_foto(detalleactivofijo.getpath_foto());	
		detalleactivofijoAsignar.setnumero_comprobante(detalleactivofijo.getnumero_comprobante());	
		detalleactivofijoAsignar.setreferencia(detalleactivofijo.getreferencia());	
		detalleactivofijoAsignar.setvalor_cotizacion(detalleactivofijo.getvalor_cotizacion());	
		detalleactivofijoAsignar.setcon_partes(detalleactivofijo.getcon_partes());	
		detalleactivofijoAsignar.setcon_garantia(detalleactivofijo.getcon_garantia());	
		detalleactivofijoAsignar.setcon_existencia(detalleactivofijo.getcon_existencia());	
		detalleactivofijoAsignar.setfecha_baja(detalleactivofijo.getfecha_baja());	
		detalleactivofijoAsignar.setpath_foto2(detalleactivofijo.getpath_foto2());	
	}
	
	public static void inicializarDetalleActivoFijo(DetalleActivoFijo detalleactivofijo) throws Exception {
		try {
				detalleactivofijo.setId(0L);	
					
				detalleactivofijo.setid_empresa(-1L);	
				detalleactivofijo.setid_sucursal(-1L);	
				detalleactivofijo.setid_detalle_grupo_activo_fijo(-1L);	
				detalleactivofijo.setid_sub_grupo_activo_fijo(-1L);	
				detalleactivofijo.setid_tipo_ramo_activo_fijo(-1L);	
				detalleactivofijo.setid_tipo_activo_fijo_empresa(-1L);	
				detalleactivofijo.setid_tipo_depreciacion_empresa(-1L);	
				detalleactivofijo.setid_estado_activo_fijo(-1L);	
				detalleactivofijo.setid_cliente(-1L);	
				detalleactivofijo.setid_partida_presu(-1L);	
				detalleactivofijo.setcodigo("");	
				detalleactivofijo.setnombre("");	
				detalleactivofijo.setserie("");	
				detalleactivofijo.setfecha_compra(new Date());	
				detalleactivofijo.setfecha_mantenimiento(new Date());	
				detalleactivofijo.setfecha_correccion(new Date());	
				detalleactivofijo.setfecha_depreciacion(new Date());	
				detalleactivofijo.setclave("");	
				detalleactivofijo.setmarca("");	
				detalleactivofijo.setmodelo("");	
				detalleactivofijo.setcolor("");	
				detalleactivofijo.setfecha(new Date());	
				detalleactivofijo.setvalor_util(0.0);	
				detalleactivofijo.setcosto_de_compra(0.0);	
				detalleactivofijo.setvida_util(0.0);	
				detalleactivofijo.setvalor_residual(0.0);	
				detalleactivofijo.setcantidad(0);	
				detalleactivofijo.setnombre_propietario("");	
				detalleactivofijo.setresponsable("");	
				detalleactivofijo.setpath_foto("");	
				detalleactivofijo.setnumero_comprobante("");	
				detalleactivofijo.setreferencia("");	
				detalleactivofijo.setvalor_cotizacion(0.0);	
				detalleactivofijo.setcon_partes(false);	
				detalleactivofijo.setcon_garantia(false);	
				detalleactivofijo.setcon_existencia(false);	
				detalleactivofijo.setfecha_baja(new Date());	
				detalleactivofijo.setpath_foto2("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleActivoFijo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_IDDETALLEGRUPOACTIVOFIJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_IDSUBGRUPOACTIVOFIJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_IDTIPORAMOACTIVOFIJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_IDTIPOACTIVOFIJOEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_IDTIPODEPRECIACIONEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_IDESTADOACTIVOFIJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_IDPARTIDAPRESU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_SERIE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_FECHACOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_FECHAMANTENIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_FECHACORRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_FECHADEPRECIACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_CLAVE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_MARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_MODELO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_COLOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_VALORUTIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_COSTODECOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_VIDAUTIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_VALORRESIDUAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_NOMBREPROPIETARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_RESPONSABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_PATHFOTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_REFERENCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_VALORCOTIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_CONPARTES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_CONGARANTIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_CONEXISTENCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_FECHABAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleActivoFijoConstantesFunciones.LABEL_PATHFOTO2);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleActivoFijo(String sTipo,Row row,Workbook workbook,DetalleActivoFijo detalleactivofijo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getdetallegrupoactivofijo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getsubgrupoactivofijo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.gettiporamoactivofijo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.gettipoactivofijoempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.gettipodepreciacionempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getestadoactivofijo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getpartidapresu_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getserie());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getfecha_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getfecha_mantenimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getfecha_correccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getfecha_depreciacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getclave());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getmarca());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getmodelo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getcolor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getvalor_util());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getcosto_de_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getvida_util());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getvalor_residual());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getnombre_propietario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getresponsable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getpath_foto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getnumero_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getreferencia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getvalor_cotizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(detalleactivofijo.getcon_partes()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(detalleactivofijo.getcon_garantia()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(detalleactivofijo.getcon_existencia()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getfecha_baja());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleactivofijo.getpath_foto2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleActivoFijo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleActivoFijo() {
		return this.sFinalQueryDetalleActivoFijo;
	}
	
	public void setsFinalQueryDetalleActivoFijo(String sFinalQueryDetalleActivoFijo) {
		this.sFinalQueryDetalleActivoFijo= sFinalQueryDetalleActivoFijo;
	}
	
	public Border resaltarSeleccionarDetalleActivoFijo=null;
	
	public Border setResaltarSeleccionarDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleActivoFijo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleActivoFijo() {
		return this.resaltarSeleccionarDetalleActivoFijo;
	}
	
	public void setResaltarSeleccionarDetalleActivoFijo(Border borderResaltarSeleccionarDetalleActivoFijo) {
		this.resaltarSeleccionarDetalleActivoFijo= borderResaltarSeleccionarDetalleActivoFijo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleActivoFijo=null;
	public Boolean mostraridDetalleActivoFijo=true;
	public Boolean activaridDetalleActivoFijo=true;

	public Border resaltarid_empresaDetalleActivoFijo=null;
	public Boolean mostrarid_empresaDetalleActivoFijo=true;
	public Boolean activarid_empresaDetalleActivoFijo=true;
	public Boolean cargarid_empresaDetalleActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleActivoFijo=null;
	public Boolean mostrarid_sucursalDetalleActivoFijo=true;
	public Boolean activarid_sucursalDetalleActivoFijo=true;
	public Boolean cargarid_sucursalDetalleActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_detalle_grupo_activo_fijoDetalleActivoFijo=null;
	public Boolean mostrarid_detalle_grupo_activo_fijoDetalleActivoFijo=true;
	public Boolean activarid_detalle_grupo_activo_fijoDetalleActivoFijo=true;
	public Boolean cargarid_detalle_grupo_activo_fijoDetalleActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_detalle_grupo_activo_fijoDetalleActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_sub_grupo_activo_fijoDetalleActivoFijo=null;
	public Boolean mostrarid_sub_grupo_activo_fijoDetalleActivoFijo=true;
	public Boolean activarid_sub_grupo_activo_fijoDetalleActivoFijo=true;
	public Boolean cargarid_sub_grupo_activo_fijoDetalleActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sub_grupo_activo_fijoDetalleActivoFijo=true;//ConEventDepend=true

	public Border resaltarid_tipo_ramo_activo_fijoDetalleActivoFijo=null;
	public Boolean mostrarid_tipo_ramo_activo_fijoDetalleActivoFijo=true;
	public Boolean activarid_tipo_ramo_activo_fijoDetalleActivoFijo=true;
	public Boolean cargarid_tipo_ramo_activo_fijoDetalleActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_ramo_activo_fijoDetalleActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_tipo_activo_fijo_empresaDetalleActivoFijo=null;
	public Boolean mostrarid_tipo_activo_fijo_empresaDetalleActivoFijo=true;
	public Boolean activarid_tipo_activo_fijo_empresaDetalleActivoFijo=true;
	public Boolean cargarid_tipo_activo_fijo_empresaDetalleActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_activo_fijo_empresaDetalleActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_tipo_depreciacion_empresaDetalleActivoFijo=null;
	public Boolean mostrarid_tipo_depreciacion_empresaDetalleActivoFijo=true;
	public Boolean activarid_tipo_depreciacion_empresaDetalleActivoFijo=true;
	public Boolean cargarid_tipo_depreciacion_empresaDetalleActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_depreciacion_empresaDetalleActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_estado_activo_fijoDetalleActivoFijo=null;
	public Boolean mostrarid_estado_activo_fijoDetalleActivoFijo=true;
	public Boolean activarid_estado_activo_fijoDetalleActivoFijo=true;
	public Boolean cargarid_estado_activo_fijoDetalleActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_activo_fijoDetalleActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_clienteDetalleActivoFijo=null;
	public Boolean mostrarid_clienteDetalleActivoFijo=true;
	public Boolean activarid_clienteDetalleActivoFijo=true;
	public Boolean cargarid_clienteDetalleActivoFijo=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteDetalleActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_partida_presuDetalleActivoFijo=null;
	public Boolean mostrarid_partida_presuDetalleActivoFijo=true;
	public Boolean activarid_partida_presuDetalleActivoFijo=true;
	public Boolean cargarid_partida_presuDetalleActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_partida_presuDetalleActivoFijo=false;//ConEventDepend=true

	public Border resaltarcodigoDetalleActivoFijo=null;
	public Boolean mostrarcodigoDetalleActivoFijo=true;
	public Boolean activarcodigoDetalleActivoFijo=true;

	public Border resaltarnombreDetalleActivoFijo=null;
	public Boolean mostrarnombreDetalleActivoFijo=true;
	public Boolean activarnombreDetalleActivoFijo=true;

	public Border resaltarserieDetalleActivoFijo=null;
	public Boolean mostrarserieDetalleActivoFijo=true;
	public Boolean activarserieDetalleActivoFijo=true;

	public Border resaltarfecha_compraDetalleActivoFijo=null;
	public Boolean mostrarfecha_compraDetalleActivoFijo=true;
	public Boolean activarfecha_compraDetalleActivoFijo=false;

	public Border resaltarfecha_mantenimientoDetalleActivoFijo=null;
	public Boolean mostrarfecha_mantenimientoDetalleActivoFijo=true;
	public Boolean activarfecha_mantenimientoDetalleActivoFijo=false;

	public Border resaltarfecha_correccionDetalleActivoFijo=null;
	public Boolean mostrarfecha_correccionDetalleActivoFijo=true;
	public Boolean activarfecha_correccionDetalleActivoFijo=false;

	public Border resaltarfecha_depreciacionDetalleActivoFijo=null;
	public Boolean mostrarfecha_depreciacionDetalleActivoFijo=true;
	public Boolean activarfecha_depreciacionDetalleActivoFijo=false;

	public Border resaltarclaveDetalleActivoFijo=null;
	public Boolean mostrarclaveDetalleActivoFijo=true;
	public Boolean activarclaveDetalleActivoFijo=true;

	public Border resaltarmarcaDetalleActivoFijo=null;
	public Boolean mostrarmarcaDetalleActivoFijo=true;
	public Boolean activarmarcaDetalleActivoFijo=true;

	public Border resaltarmodeloDetalleActivoFijo=null;
	public Boolean mostrarmodeloDetalleActivoFijo=true;
	public Boolean activarmodeloDetalleActivoFijo=true;

	public Border resaltarcolorDetalleActivoFijo=null;
	public Boolean mostrarcolorDetalleActivoFijo=true;
	public Boolean activarcolorDetalleActivoFijo=true;

	public Border resaltarfechaDetalleActivoFijo=null;
	public Boolean mostrarfechaDetalleActivoFijo=true;
	public Boolean activarfechaDetalleActivoFijo=false;

	public Border resaltarvalor_utilDetalleActivoFijo=null;
	public Boolean mostrarvalor_utilDetalleActivoFijo=true;
	public Boolean activarvalor_utilDetalleActivoFijo=true;

	public Border resaltarcosto_de_compraDetalleActivoFijo=null;
	public Boolean mostrarcosto_de_compraDetalleActivoFijo=true;
	public Boolean activarcosto_de_compraDetalleActivoFijo=true;

	public Border resaltarvida_utilDetalleActivoFijo=null;
	public Boolean mostrarvida_utilDetalleActivoFijo=true;
	public Boolean activarvida_utilDetalleActivoFijo=true;

	public Border resaltarvalor_residualDetalleActivoFijo=null;
	public Boolean mostrarvalor_residualDetalleActivoFijo=true;
	public Boolean activarvalor_residualDetalleActivoFijo=true;

	public Border resaltarcantidadDetalleActivoFijo=null;
	public Boolean mostrarcantidadDetalleActivoFijo=true;
	public Boolean activarcantidadDetalleActivoFijo=true;

	public Border resaltarnombre_propietarioDetalleActivoFijo=null;
	public Boolean mostrarnombre_propietarioDetalleActivoFijo=true;
	public Boolean activarnombre_propietarioDetalleActivoFijo=true;

	public Border resaltarresponsableDetalleActivoFijo=null;
	public Boolean mostrarresponsableDetalleActivoFijo=true;
	public Boolean activarresponsableDetalleActivoFijo=true;

	public Border resaltarpath_fotoDetalleActivoFijo=null;
	public Boolean mostrarpath_fotoDetalleActivoFijo=true;
	public Boolean activarpath_fotoDetalleActivoFijo=true;

	public Border resaltarnumero_comprobanteDetalleActivoFijo=null;
	public Boolean mostrarnumero_comprobanteDetalleActivoFijo=true;
	public Boolean activarnumero_comprobanteDetalleActivoFijo=true;

	public Border resaltarreferenciaDetalleActivoFijo=null;
	public Boolean mostrarreferenciaDetalleActivoFijo=true;
	public Boolean activarreferenciaDetalleActivoFijo=true;

	public Border resaltarvalor_cotizacionDetalleActivoFijo=null;
	public Boolean mostrarvalor_cotizacionDetalleActivoFijo=true;
	public Boolean activarvalor_cotizacionDetalleActivoFijo=true;

	public Border resaltarcon_partesDetalleActivoFijo=null;
	public Boolean mostrarcon_partesDetalleActivoFijo=true;
	public Boolean activarcon_partesDetalleActivoFijo=true;

	public Border resaltarcon_garantiaDetalleActivoFijo=null;
	public Boolean mostrarcon_garantiaDetalleActivoFijo=true;
	public Boolean activarcon_garantiaDetalleActivoFijo=true;

	public Border resaltarcon_existenciaDetalleActivoFijo=null;
	public Boolean mostrarcon_existenciaDetalleActivoFijo=true;
	public Boolean activarcon_existenciaDetalleActivoFijo=true;

	public Border resaltarfecha_bajaDetalleActivoFijo=null;
	public Boolean mostrarfecha_bajaDetalleActivoFijo=true;
	public Boolean activarfecha_bajaDetalleActivoFijo=false;

	public Border resaltarpath_foto2DetalleActivoFijo=null;
	public Boolean mostrarpath_foto2DetalleActivoFijo=true;
	public Boolean activarpath_foto2DetalleActivoFijo=true;

	
	

	public Border setResaltaridDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltaridDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleActivoFijo() {
		return this.resaltaridDetalleActivoFijo;
	}

	public void setResaltaridDetalleActivoFijo(Border borderResaltar) {
		this.resaltaridDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostraridDetalleActivoFijo() {
		return this.mostraridDetalleActivoFijo;
	}

	public void setMostraridDetalleActivoFijo(Boolean mostraridDetalleActivoFijo) {
		this.mostraridDetalleActivoFijo= mostraridDetalleActivoFijo;
	}

	public Boolean getActivaridDetalleActivoFijo() {
		return this.activaridDetalleActivoFijo;
	}

	public void setActivaridDetalleActivoFijo(Boolean activaridDetalleActivoFijo) {
		this.activaridDetalleActivoFijo= activaridDetalleActivoFijo;
	}

	public Border setResaltarid_empresaDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleActivoFijo() {
		return this.resaltarid_empresaDetalleActivoFijo;
	}

	public void setResaltarid_empresaDetalleActivoFijo(Border borderResaltar) {
		this.resaltarid_empresaDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleActivoFijo() {
		return this.mostrarid_empresaDetalleActivoFijo;
	}

	public void setMostrarid_empresaDetalleActivoFijo(Boolean mostrarid_empresaDetalleActivoFijo) {
		this.mostrarid_empresaDetalleActivoFijo= mostrarid_empresaDetalleActivoFijo;
	}

	public Boolean getActivarid_empresaDetalleActivoFijo() {
		return this.activarid_empresaDetalleActivoFijo;
	}

	public void setActivarid_empresaDetalleActivoFijo(Boolean activarid_empresaDetalleActivoFijo) {
		this.activarid_empresaDetalleActivoFijo= activarid_empresaDetalleActivoFijo;
	}

	public Boolean getCargarid_empresaDetalleActivoFijo() {
		return this.cargarid_empresaDetalleActivoFijo;
	}

	public void setCargarid_empresaDetalleActivoFijo(Boolean cargarid_empresaDetalleActivoFijo) {
		this.cargarid_empresaDetalleActivoFijo= cargarid_empresaDetalleActivoFijo;
	}

	public Border setResaltarid_sucursalDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleActivoFijo() {
		return this.resaltarid_sucursalDetalleActivoFijo;
	}

	public void setResaltarid_sucursalDetalleActivoFijo(Border borderResaltar) {
		this.resaltarid_sucursalDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleActivoFijo() {
		return this.mostrarid_sucursalDetalleActivoFijo;
	}

	public void setMostrarid_sucursalDetalleActivoFijo(Boolean mostrarid_sucursalDetalleActivoFijo) {
		this.mostrarid_sucursalDetalleActivoFijo= mostrarid_sucursalDetalleActivoFijo;
	}

	public Boolean getActivarid_sucursalDetalleActivoFijo() {
		return this.activarid_sucursalDetalleActivoFijo;
	}

	public void setActivarid_sucursalDetalleActivoFijo(Boolean activarid_sucursalDetalleActivoFijo) {
		this.activarid_sucursalDetalleActivoFijo= activarid_sucursalDetalleActivoFijo;
	}

	public Boolean getCargarid_sucursalDetalleActivoFijo() {
		return this.cargarid_sucursalDetalleActivoFijo;
	}

	public void setCargarid_sucursalDetalleActivoFijo(Boolean cargarid_sucursalDetalleActivoFijo) {
		this.cargarid_sucursalDetalleActivoFijo= cargarid_sucursalDetalleActivoFijo;
	}

	public Border setResaltarid_detalle_grupo_activo_fijoDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_detalle_grupo_activo_fijoDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_detalle_grupo_activo_fijoDetalleActivoFijo() {
		return this.resaltarid_detalle_grupo_activo_fijoDetalleActivoFijo;
	}

	public void setResaltarid_detalle_grupo_activo_fijoDetalleActivoFijo(Border borderResaltar) {
		this.resaltarid_detalle_grupo_activo_fijoDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_detalle_grupo_activo_fijoDetalleActivoFijo() {
		return this.mostrarid_detalle_grupo_activo_fijoDetalleActivoFijo;
	}

	public void setMostrarid_detalle_grupo_activo_fijoDetalleActivoFijo(Boolean mostrarid_detalle_grupo_activo_fijoDetalleActivoFijo) {
		this.mostrarid_detalle_grupo_activo_fijoDetalleActivoFijo= mostrarid_detalle_grupo_activo_fijoDetalleActivoFijo;
	}

	public Boolean getActivarid_detalle_grupo_activo_fijoDetalleActivoFijo() {
		return this.activarid_detalle_grupo_activo_fijoDetalleActivoFijo;
	}

	public void setActivarid_detalle_grupo_activo_fijoDetalleActivoFijo(Boolean activarid_detalle_grupo_activo_fijoDetalleActivoFijo) {
		this.activarid_detalle_grupo_activo_fijoDetalleActivoFijo= activarid_detalle_grupo_activo_fijoDetalleActivoFijo;
	}

	public Boolean getCargarid_detalle_grupo_activo_fijoDetalleActivoFijo() {
		return this.cargarid_detalle_grupo_activo_fijoDetalleActivoFijo;
	}

	public void setCargarid_detalle_grupo_activo_fijoDetalleActivoFijo(Boolean cargarid_detalle_grupo_activo_fijoDetalleActivoFijo) {
		this.cargarid_detalle_grupo_activo_fijoDetalleActivoFijo= cargarid_detalle_grupo_activo_fijoDetalleActivoFijo;
	}

	public Border setResaltarid_sub_grupo_activo_fijoDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_sub_grupo_activo_fijoDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sub_grupo_activo_fijoDetalleActivoFijo() {
		return this.resaltarid_sub_grupo_activo_fijoDetalleActivoFijo;
	}

	public void setResaltarid_sub_grupo_activo_fijoDetalleActivoFijo(Border borderResaltar) {
		this.resaltarid_sub_grupo_activo_fijoDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_sub_grupo_activo_fijoDetalleActivoFijo() {
		return this.mostrarid_sub_grupo_activo_fijoDetalleActivoFijo;
	}

	public void setMostrarid_sub_grupo_activo_fijoDetalleActivoFijo(Boolean mostrarid_sub_grupo_activo_fijoDetalleActivoFijo) {
		this.mostrarid_sub_grupo_activo_fijoDetalleActivoFijo= mostrarid_sub_grupo_activo_fijoDetalleActivoFijo;
	}

	public Boolean getActivarid_sub_grupo_activo_fijoDetalleActivoFijo() {
		return this.activarid_sub_grupo_activo_fijoDetalleActivoFijo;
	}

	public void setActivarid_sub_grupo_activo_fijoDetalleActivoFijo(Boolean activarid_sub_grupo_activo_fijoDetalleActivoFijo) {
		this.activarid_sub_grupo_activo_fijoDetalleActivoFijo= activarid_sub_grupo_activo_fijoDetalleActivoFijo;
	}

	public Boolean getCargarid_sub_grupo_activo_fijoDetalleActivoFijo() {
		return this.cargarid_sub_grupo_activo_fijoDetalleActivoFijo;
	}

	public void setCargarid_sub_grupo_activo_fijoDetalleActivoFijo(Boolean cargarid_sub_grupo_activo_fijoDetalleActivoFijo) {
		this.cargarid_sub_grupo_activo_fijoDetalleActivoFijo= cargarid_sub_grupo_activo_fijoDetalleActivoFijo;
	}

	public Border setResaltarid_tipo_ramo_activo_fijoDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_tipo_ramo_activo_fijoDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_ramo_activo_fijoDetalleActivoFijo() {
		return this.resaltarid_tipo_ramo_activo_fijoDetalleActivoFijo;
	}

	public void setResaltarid_tipo_ramo_activo_fijoDetalleActivoFijo(Border borderResaltar) {
		this.resaltarid_tipo_ramo_activo_fijoDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_tipo_ramo_activo_fijoDetalleActivoFijo() {
		return this.mostrarid_tipo_ramo_activo_fijoDetalleActivoFijo;
	}

	public void setMostrarid_tipo_ramo_activo_fijoDetalleActivoFijo(Boolean mostrarid_tipo_ramo_activo_fijoDetalleActivoFijo) {
		this.mostrarid_tipo_ramo_activo_fijoDetalleActivoFijo= mostrarid_tipo_ramo_activo_fijoDetalleActivoFijo;
	}

	public Boolean getActivarid_tipo_ramo_activo_fijoDetalleActivoFijo() {
		return this.activarid_tipo_ramo_activo_fijoDetalleActivoFijo;
	}

	public void setActivarid_tipo_ramo_activo_fijoDetalleActivoFijo(Boolean activarid_tipo_ramo_activo_fijoDetalleActivoFijo) {
		this.activarid_tipo_ramo_activo_fijoDetalleActivoFijo= activarid_tipo_ramo_activo_fijoDetalleActivoFijo;
	}

	public Boolean getCargarid_tipo_ramo_activo_fijoDetalleActivoFijo() {
		return this.cargarid_tipo_ramo_activo_fijoDetalleActivoFijo;
	}

	public void setCargarid_tipo_ramo_activo_fijoDetalleActivoFijo(Boolean cargarid_tipo_ramo_activo_fijoDetalleActivoFijo) {
		this.cargarid_tipo_ramo_activo_fijoDetalleActivoFijo= cargarid_tipo_ramo_activo_fijoDetalleActivoFijo;
	}

	public Border setResaltarid_tipo_activo_fijo_empresaDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_tipo_activo_fijo_empresaDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_activo_fijo_empresaDetalleActivoFijo() {
		return this.resaltarid_tipo_activo_fijo_empresaDetalleActivoFijo;
	}

	public void setResaltarid_tipo_activo_fijo_empresaDetalleActivoFijo(Border borderResaltar) {
		this.resaltarid_tipo_activo_fijo_empresaDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_tipo_activo_fijo_empresaDetalleActivoFijo() {
		return this.mostrarid_tipo_activo_fijo_empresaDetalleActivoFijo;
	}

	public void setMostrarid_tipo_activo_fijo_empresaDetalleActivoFijo(Boolean mostrarid_tipo_activo_fijo_empresaDetalleActivoFijo) {
		this.mostrarid_tipo_activo_fijo_empresaDetalleActivoFijo= mostrarid_tipo_activo_fijo_empresaDetalleActivoFijo;
	}

	public Boolean getActivarid_tipo_activo_fijo_empresaDetalleActivoFijo() {
		return this.activarid_tipo_activo_fijo_empresaDetalleActivoFijo;
	}

	public void setActivarid_tipo_activo_fijo_empresaDetalleActivoFijo(Boolean activarid_tipo_activo_fijo_empresaDetalleActivoFijo) {
		this.activarid_tipo_activo_fijo_empresaDetalleActivoFijo= activarid_tipo_activo_fijo_empresaDetalleActivoFijo;
	}

	public Boolean getCargarid_tipo_activo_fijo_empresaDetalleActivoFijo() {
		return this.cargarid_tipo_activo_fijo_empresaDetalleActivoFijo;
	}

	public void setCargarid_tipo_activo_fijo_empresaDetalleActivoFijo(Boolean cargarid_tipo_activo_fijo_empresaDetalleActivoFijo) {
		this.cargarid_tipo_activo_fijo_empresaDetalleActivoFijo= cargarid_tipo_activo_fijo_empresaDetalleActivoFijo;
	}

	public Border setResaltarid_tipo_depreciacion_empresaDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_tipo_depreciacion_empresaDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_depreciacion_empresaDetalleActivoFijo() {
		return this.resaltarid_tipo_depreciacion_empresaDetalleActivoFijo;
	}

	public void setResaltarid_tipo_depreciacion_empresaDetalleActivoFijo(Border borderResaltar) {
		this.resaltarid_tipo_depreciacion_empresaDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_tipo_depreciacion_empresaDetalleActivoFijo() {
		return this.mostrarid_tipo_depreciacion_empresaDetalleActivoFijo;
	}

	public void setMostrarid_tipo_depreciacion_empresaDetalleActivoFijo(Boolean mostrarid_tipo_depreciacion_empresaDetalleActivoFijo) {
		this.mostrarid_tipo_depreciacion_empresaDetalleActivoFijo= mostrarid_tipo_depreciacion_empresaDetalleActivoFijo;
	}

	public Boolean getActivarid_tipo_depreciacion_empresaDetalleActivoFijo() {
		return this.activarid_tipo_depreciacion_empresaDetalleActivoFijo;
	}

	public void setActivarid_tipo_depreciacion_empresaDetalleActivoFijo(Boolean activarid_tipo_depreciacion_empresaDetalleActivoFijo) {
		this.activarid_tipo_depreciacion_empresaDetalleActivoFijo= activarid_tipo_depreciacion_empresaDetalleActivoFijo;
	}

	public Boolean getCargarid_tipo_depreciacion_empresaDetalleActivoFijo() {
		return this.cargarid_tipo_depreciacion_empresaDetalleActivoFijo;
	}

	public void setCargarid_tipo_depreciacion_empresaDetalleActivoFijo(Boolean cargarid_tipo_depreciacion_empresaDetalleActivoFijo) {
		this.cargarid_tipo_depreciacion_empresaDetalleActivoFijo= cargarid_tipo_depreciacion_empresaDetalleActivoFijo;
	}

	public Border setResaltarid_estado_activo_fijoDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_estado_activo_fijoDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_activo_fijoDetalleActivoFijo() {
		return this.resaltarid_estado_activo_fijoDetalleActivoFijo;
	}

	public void setResaltarid_estado_activo_fijoDetalleActivoFijo(Border borderResaltar) {
		this.resaltarid_estado_activo_fijoDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_estado_activo_fijoDetalleActivoFijo() {
		return this.mostrarid_estado_activo_fijoDetalleActivoFijo;
	}

	public void setMostrarid_estado_activo_fijoDetalleActivoFijo(Boolean mostrarid_estado_activo_fijoDetalleActivoFijo) {
		this.mostrarid_estado_activo_fijoDetalleActivoFijo= mostrarid_estado_activo_fijoDetalleActivoFijo;
	}

	public Boolean getActivarid_estado_activo_fijoDetalleActivoFijo() {
		return this.activarid_estado_activo_fijoDetalleActivoFijo;
	}

	public void setActivarid_estado_activo_fijoDetalleActivoFijo(Boolean activarid_estado_activo_fijoDetalleActivoFijo) {
		this.activarid_estado_activo_fijoDetalleActivoFijo= activarid_estado_activo_fijoDetalleActivoFijo;
	}

	public Boolean getCargarid_estado_activo_fijoDetalleActivoFijo() {
		return this.cargarid_estado_activo_fijoDetalleActivoFijo;
	}

	public void setCargarid_estado_activo_fijoDetalleActivoFijo(Boolean cargarid_estado_activo_fijoDetalleActivoFijo) {
		this.cargarid_estado_activo_fijoDetalleActivoFijo= cargarid_estado_activo_fijoDetalleActivoFijo;
	}

	public Border setResaltarid_clienteDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_clienteDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteDetalleActivoFijo() {
		return this.resaltarid_clienteDetalleActivoFijo;
	}

	public void setResaltarid_clienteDetalleActivoFijo(Border borderResaltar) {
		this.resaltarid_clienteDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_clienteDetalleActivoFijo() {
		return this.mostrarid_clienteDetalleActivoFijo;
	}

	public void setMostrarid_clienteDetalleActivoFijo(Boolean mostrarid_clienteDetalleActivoFijo) {
		this.mostrarid_clienteDetalleActivoFijo= mostrarid_clienteDetalleActivoFijo;
	}

	public Boolean getActivarid_clienteDetalleActivoFijo() {
		return this.activarid_clienteDetalleActivoFijo;
	}

	public void setActivarid_clienteDetalleActivoFijo(Boolean activarid_clienteDetalleActivoFijo) {
		this.activarid_clienteDetalleActivoFijo= activarid_clienteDetalleActivoFijo;
	}

	public Boolean getCargarid_clienteDetalleActivoFijo() {
		return this.cargarid_clienteDetalleActivoFijo;
	}

	public void setCargarid_clienteDetalleActivoFijo(Boolean cargarid_clienteDetalleActivoFijo) {
		this.cargarid_clienteDetalleActivoFijo= cargarid_clienteDetalleActivoFijo;
	}

	public Border setResaltarid_partida_presuDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_partida_presuDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_partida_presuDetalleActivoFijo() {
		return this.resaltarid_partida_presuDetalleActivoFijo;
	}

	public void setResaltarid_partida_presuDetalleActivoFijo(Border borderResaltar) {
		this.resaltarid_partida_presuDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_partida_presuDetalleActivoFijo() {
		return this.mostrarid_partida_presuDetalleActivoFijo;
	}

	public void setMostrarid_partida_presuDetalleActivoFijo(Boolean mostrarid_partida_presuDetalleActivoFijo) {
		this.mostrarid_partida_presuDetalleActivoFijo= mostrarid_partida_presuDetalleActivoFijo;
	}

	public Boolean getActivarid_partida_presuDetalleActivoFijo() {
		return this.activarid_partida_presuDetalleActivoFijo;
	}

	public void setActivarid_partida_presuDetalleActivoFijo(Boolean activarid_partida_presuDetalleActivoFijo) {
		this.activarid_partida_presuDetalleActivoFijo= activarid_partida_presuDetalleActivoFijo;
	}

	public Boolean getCargarid_partida_presuDetalleActivoFijo() {
		return this.cargarid_partida_presuDetalleActivoFijo;
	}

	public void setCargarid_partida_presuDetalleActivoFijo(Boolean cargarid_partida_presuDetalleActivoFijo) {
		this.cargarid_partida_presuDetalleActivoFijo= cargarid_partida_presuDetalleActivoFijo;
	}

	public Border setResaltarcodigoDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarcodigoDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoDetalleActivoFijo() {
		return this.resaltarcodigoDetalleActivoFijo;
	}

	public void setResaltarcodigoDetalleActivoFijo(Border borderResaltar) {
		this.resaltarcodigoDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarcodigoDetalleActivoFijo() {
		return this.mostrarcodigoDetalleActivoFijo;
	}

	public void setMostrarcodigoDetalleActivoFijo(Boolean mostrarcodigoDetalleActivoFijo) {
		this.mostrarcodigoDetalleActivoFijo= mostrarcodigoDetalleActivoFijo;
	}

	public Boolean getActivarcodigoDetalleActivoFijo() {
		return this.activarcodigoDetalleActivoFijo;
	}

	public void setActivarcodigoDetalleActivoFijo(Boolean activarcodigoDetalleActivoFijo) {
		this.activarcodigoDetalleActivoFijo= activarcodigoDetalleActivoFijo;
	}

	public Border setResaltarnombreDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarnombreDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreDetalleActivoFijo() {
		return this.resaltarnombreDetalleActivoFijo;
	}

	public void setResaltarnombreDetalleActivoFijo(Border borderResaltar) {
		this.resaltarnombreDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarnombreDetalleActivoFijo() {
		return this.mostrarnombreDetalleActivoFijo;
	}

	public void setMostrarnombreDetalleActivoFijo(Boolean mostrarnombreDetalleActivoFijo) {
		this.mostrarnombreDetalleActivoFijo= mostrarnombreDetalleActivoFijo;
	}

	public Boolean getActivarnombreDetalleActivoFijo() {
		return this.activarnombreDetalleActivoFijo;
	}

	public void setActivarnombreDetalleActivoFijo(Boolean activarnombreDetalleActivoFijo) {
		this.activarnombreDetalleActivoFijo= activarnombreDetalleActivoFijo;
	}

	public Border setResaltarserieDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarserieDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarserieDetalleActivoFijo() {
		return this.resaltarserieDetalleActivoFijo;
	}

	public void setResaltarserieDetalleActivoFijo(Border borderResaltar) {
		this.resaltarserieDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarserieDetalleActivoFijo() {
		return this.mostrarserieDetalleActivoFijo;
	}

	public void setMostrarserieDetalleActivoFijo(Boolean mostrarserieDetalleActivoFijo) {
		this.mostrarserieDetalleActivoFijo= mostrarserieDetalleActivoFijo;
	}

	public Boolean getActivarserieDetalleActivoFijo() {
		return this.activarserieDetalleActivoFijo;
	}

	public void setActivarserieDetalleActivoFijo(Boolean activarserieDetalleActivoFijo) {
		this.activarserieDetalleActivoFijo= activarserieDetalleActivoFijo;
	}

	public Border setResaltarfecha_compraDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarfecha_compraDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_compraDetalleActivoFijo() {
		return this.resaltarfecha_compraDetalleActivoFijo;
	}

	public void setResaltarfecha_compraDetalleActivoFijo(Border borderResaltar) {
		this.resaltarfecha_compraDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarfecha_compraDetalleActivoFijo() {
		return this.mostrarfecha_compraDetalleActivoFijo;
	}

	public void setMostrarfecha_compraDetalleActivoFijo(Boolean mostrarfecha_compraDetalleActivoFijo) {
		this.mostrarfecha_compraDetalleActivoFijo= mostrarfecha_compraDetalleActivoFijo;
	}

	public Boolean getActivarfecha_compraDetalleActivoFijo() {
		return this.activarfecha_compraDetalleActivoFijo;
	}

	public void setActivarfecha_compraDetalleActivoFijo(Boolean activarfecha_compraDetalleActivoFijo) {
		this.activarfecha_compraDetalleActivoFijo= activarfecha_compraDetalleActivoFijo;
	}

	public Border setResaltarfecha_mantenimientoDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarfecha_mantenimientoDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_mantenimientoDetalleActivoFijo() {
		return this.resaltarfecha_mantenimientoDetalleActivoFijo;
	}

	public void setResaltarfecha_mantenimientoDetalleActivoFijo(Border borderResaltar) {
		this.resaltarfecha_mantenimientoDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarfecha_mantenimientoDetalleActivoFijo() {
		return this.mostrarfecha_mantenimientoDetalleActivoFijo;
	}

	public void setMostrarfecha_mantenimientoDetalleActivoFijo(Boolean mostrarfecha_mantenimientoDetalleActivoFijo) {
		this.mostrarfecha_mantenimientoDetalleActivoFijo= mostrarfecha_mantenimientoDetalleActivoFijo;
	}

	public Boolean getActivarfecha_mantenimientoDetalleActivoFijo() {
		return this.activarfecha_mantenimientoDetalleActivoFijo;
	}

	public void setActivarfecha_mantenimientoDetalleActivoFijo(Boolean activarfecha_mantenimientoDetalleActivoFijo) {
		this.activarfecha_mantenimientoDetalleActivoFijo= activarfecha_mantenimientoDetalleActivoFijo;
	}

	public Border setResaltarfecha_correccionDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarfecha_correccionDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_correccionDetalleActivoFijo() {
		return this.resaltarfecha_correccionDetalleActivoFijo;
	}

	public void setResaltarfecha_correccionDetalleActivoFijo(Border borderResaltar) {
		this.resaltarfecha_correccionDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarfecha_correccionDetalleActivoFijo() {
		return this.mostrarfecha_correccionDetalleActivoFijo;
	}

	public void setMostrarfecha_correccionDetalleActivoFijo(Boolean mostrarfecha_correccionDetalleActivoFijo) {
		this.mostrarfecha_correccionDetalleActivoFijo= mostrarfecha_correccionDetalleActivoFijo;
	}

	public Boolean getActivarfecha_correccionDetalleActivoFijo() {
		return this.activarfecha_correccionDetalleActivoFijo;
	}

	public void setActivarfecha_correccionDetalleActivoFijo(Boolean activarfecha_correccionDetalleActivoFijo) {
		this.activarfecha_correccionDetalleActivoFijo= activarfecha_correccionDetalleActivoFijo;
	}

	public Border setResaltarfecha_depreciacionDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarfecha_depreciacionDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_depreciacionDetalleActivoFijo() {
		return this.resaltarfecha_depreciacionDetalleActivoFijo;
	}

	public void setResaltarfecha_depreciacionDetalleActivoFijo(Border borderResaltar) {
		this.resaltarfecha_depreciacionDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarfecha_depreciacionDetalleActivoFijo() {
		return this.mostrarfecha_depreciacionDetalleActivoFijo;
	}

	public void setMostrarfecha_depreciacionDetalleActivoFijo(Boolean mostrarfecha_depreciacionDetalleActivoFijo) {
		this.mostrarfecha_depreciacionDetalleActivoFijo= mostrarfecha_depreciacionDetalleActivoFijo;
	}

	public Boolean getActivarfecha_depreciacionDetalleActivoFijo() {
		return this.activarfecha_depreciacionDetalleActivoFijo;
	}

	public void setActivarfecha_depreciacionDetalleActivoFijo(Boolean activarfecha_depreciacionDetalleActivoFijo) {
		this.activarfecha_depreciacionDetalleActivoFijo= activarfecha_depreciacionDetalleActivoFijo;
	}

	public Border setResaltarclaveDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarclaveDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarclaveDetalleActivoFijo() {
		return this.resaltarclaveDetalleActivoFijo;
	}

	public void setResaltarclaveDetalleActivoFijo(Border borderResaltar) {
		this.resaltarclaveDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarclaveDetalleActivoFijo() {
		return this.mostrarclaveDetalleActivoFijo;
	}

	public void setMostrarclaveDetalleActivoFijo(Boolean mostrarclaveDetalleActivoFijo) {
		this.mostrarclaveDetalleActivoFijo= mostrarclaveDetalleActivoFijo;
	}

	public Boolean getActivarclaveDetalleActivoFijo() {
		return this.activarclaveDetalleActivoFijo;
	}

	public void setActivarclaveDetalleActivoFijo(Boolean activarclaveDetalleActivoFijo) {
		this.activarclaveDetalleActivoFijo= activarclaveDetalleActivoFijo;
	}

	public Border setResaltarmarcaDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarmarcaDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmarcaDetalleActivoFijo() {
		return this.resaltarmarcaDetalleActivoFijo;
	}

	public void setResaltarmarcaDetalleActivoFijo(Border borderResaltar) {
		this.resaltarmarcaDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarmarcaDetalleActivoFijo() {
		return this.mostrarmarcaDetalleActivoFijo;
	}

	public void setMostrarmarcaDetalleActivoFijo(Boolean mostrarmarcaDetalleActivoFijo) {
		this.mostrarmarcaDetalleActivoFijo= mostrarmarcaDetalleActivoFijo;
	}

	public Boolean getActivarmarcaDetalleActivoFijo() {
		return this.activarmarcaDetalleActivoFijo;
	}

	public void setActivarmarcaDetalleActivoFijo(Boolean activarmarcaDetalleActivoFijo) {
		this.activarmarcaDetalleActivoFijo= activarmarcaDetalleActivoFijo;
	}

	public Border setResaltarmodeloDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarmodeloDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmodeloDetalleActivoFijo() {
		return this.resaltarmodeloDetalleActivoFijo;
	}

	public void setResaltarmodeloDetalleActivoFijo(Border borderResaltar) {
		this.resaltarmodeloDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarmodeloDetalleActivoFijo() {
		return this.mostrarmodeloDetalleActivoFijo;
	}

	public void setMostrarmodeloDetalleActivoFijo(Boolean mostrarmodeloDetalleActivoFijo) {
		this.mostrarmodeloDetalleActivoFijo= mostrarmodeloDetalleActivoFijo;
	}

	public Boolean getActivarmodeloDetalleActivoFijo() {
		return this.activarmodeloDetalleActivoFijo;
	}

	public void setActivarmodeloDetalleActivoFijo(Boolean activarmodeloDetalleActivoFijo) {
		this.activarmodeloDetalleActivoFijo= activarmodeloDetalleActivoFijo;
	}

	public Border setResaltarcolorDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarcolorDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcolorDetalleActivoFijo() {
		return this.resaltarcolorDetalleActivoFijo;
	}

	public void setResaltarcolorDetalleActivoFijo(Border borderResaltar) {
		this.resaltarcolorDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarcolorDetalleActivoFijo() {
		return this.mostrarcolorDetalleActivoFijo;
	}

	public void setMostrarcolorDetalleActivoFijo(Boolean mostrarcolorDetalleActivoFijo) {
		this.mostrarcolorDetalleActivoFijo= mostrarcolorDetalleActivoFijo;
	}

	public Boolean getActivarcolorDetalleActivoFijo() {
		return this.activarcolorDetalleActivoFijo;
	}

	public void setActivarcolorDetalleActivoFijo(Boolean activarcolorDetalleActivoFijo) {
		this.activarcolorDetalleActivoFijo= activarcolorDetalleActivoFijo;
	}

	public Border setResaltarfechaDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarfechaDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaDetalleActivoFijo() {
		return this.resaltarfechaDetalleActivoFijo;
	}

	public void setResaltarfechaDetalleActivoFijo(Border borderResaltar) {
		this.resaltarfechaDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarfechaDetalleActivoFijo() {
		return this.mostrarfechaDetalleActivoFijo;
	}

	public void setMostrarfechaDetalleActivoFijo(Boolean mostrarfechaDetalleActivoFijo) {
		this.mostrarfechaDetalleActivoFijo= mostrarfechaDetalleActivoFijo;
	}

	public Boolean getActivarfechaDetalleActivoFijo() {
		return this.activarfechaDetalleActivoFijo;
	}

	public void setActivarfechaDetalleActivoFijo(Boolean activarfechaDetalleActivoFijo) {
		this.activarfechaDetalleActivoFijo= activarfechaDetalleActivoFijo;
	}

	public Border setResaltarvalor_utilDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarvalor_utilDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_utilDetalleActivoFijo() {
		return this.resaltarvalor_utilDetalleActivoFijo;
	}

	public void setResaltarvalor_utilDetalleActivoFijo(Border borderResaltar) {
		this.resaltarvalor_utilDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarvalor_utilDetalleActivoFijo() {
		return this.mostrarvalor_utilDetalleActivoFijo;
	}

	public void setMostrarvalor_utilDetalleActivoFijo(Boolean mostrarvalor_utilDetalleActivoFijo) {
		this.mostrarvalor_utilDetalleActivoFijo= mostrarvalor_utilDetalleActivoFijo;
	}

	public Boolean getActivarvalor_utilDetalleActivoFijo() {
		return this.activarvalor_utilDetalleActivoFijo;
	}

	public void setActivarvalor_utilDetalleActivoFijo(Boolean activarvalor_utilDetalleActivoFijo) {
		this.activarvalor_utilDetalleActivoFijo= activarvalor_utilDetalleActivoFijo;
	}

	public Border setResaltarcosto_de_compraDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarcosto_de_compraDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_de_compraDetalleActivoFijo() {
		return this.resaltarcosto_de_compraDetalleActivoFijo;
	}

	public void setResaltarcosto_de_compraDetalleActivoFijo(Border borderResaltar) {
		this.resaltarcosto_de_compraDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarcosto_de_compraDetalleActivoFijo() {
		return this.mostrarcosto_de_compraDetalleActivoFijo;
	}

	public void setMostrarcosto_de_compraDetalleActivoFijo(Boolean mostrarcosto_de_compraDetalleActivoFijo) {
		this.mostrarcosto_de_compraDetalleActivoFijo= mostrarcosto_de_compraDetalleActivoFijo;
	}

	public Boolean getActivarcosto_de_compraDetalleActivoFijo() {
		return this.activarcosto_de_compraDetalleActivoFijo;
	}

	public void setActivarcosto_de_compraDetalleActivoFijo(Boolean activarcosto_de_compraDetalleActivoFijo) {
		this.activarcosto_de_compraDetalleActivoFijo= activarcosto_de_compraDetalleActivoFijo;
	}

	public Border setResaltarvida_utilDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarvida_utilDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvida_utilDetalleActivoFijo() {
		return this.resaltarvida_utilDetalleActivoFijo;
	}

	public void setResaltarvida_utilDetalleActivoFijo(Border borderResaltar) {
		this.resaltarvida_utilDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarvida_utilDetalleActivoFijo() {
		return this.mostrarvida_utilDetalleActivoFijo;
	}

	public void setMostrarvida_utilDetalleActivoFijo(Boolean mostrarvida_utilDetalleActivoFijo) {
		this.mostrarvida_utilDetalleActivoFijo= mostrarvida_utilDetalleActivoFijo;
	}

	public Boolean getActivarvida_utilDetalleActivoFijo() {
		return this.activarvida_utilDetalleActivoFijo;
	}

	public void setActivarvida_utilDetalleActivoFijo(Boolean activarvida_utilDetalleActivoFijo) {
		this.activarvida_utilDetalleActivoFijo= activarvida_utilDetalleActivoFijo;
	}

	public Border setResaltarvalor_residualDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarvalor_residualDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_residualDetalleActivoFijo() {
		return this.resaltarvalor_residualDetalleActivoFijo;
	}

	public void setResaltarvalor_residualDetalleActivoFijo(Border borderResaltar) {
		this.resaltarvalor_residualDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarvalor_residualDetalleActivoFijo() {
		return this.mostrarvalor_residualDetalleActivoFijo;
	}

	public void setMostrarvalor_residualDetalleActivoFijo(Boolean mostrarvalor_residualDetalleActivoFijo) {
		this.mostrarvalor_residualDetalleActivoFijo= mostrarvalor_residualDetalleActivoFijo;
	}

	public Boolean getActivarvalor_residualDetalleActivoFijo() {
		return this.activarvalor_residualDetalleActivoFijo;
	}

	public void setActivarvalor_residualDetalleActivoFijo(Boolean activarvalor_residualDetalleActivoFijo) {
		this.activarvalor_residualDetalleActivoFijo= activarvalor_residualDetalleActivoFijo;
	}

	public Border setResaltarcantidadDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarcantidadDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadDetalleActivoFijo() {
		return this.resaltarcantidadDetalleActivoFijo;
	}

	public void setResaltarcantidadDetalleActivoFijo(Border borderResaltar) {
		this.resaltarcantidadDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarcantidadDetalleActivoFijo() {
		return this.mostrarcantidadDetalleActivoFijo;
	}

	public void setMostrarcantidadDetalleActivoFijo(Boolean mostrarcantidadDetalleActivoFijo) {
		this.mostrarcantidadDetalleActivoFijo= mostrarcantidadDetalleActivoFijo;
	}

	public Boolean getActivarcantidadDetalleActivoFijo() {
		return this.activarcantidadDetalleActivoFijo;
	}

	public void setActivarcantidadDetalleActivoFijo(Boolean activarcantidadDetalleActivoFijo) {
		this.activarcantidadDetalleActivoFijo= activarcantidadDetalleActivoFijo;
	}

	public Border setResaltarnombre_propietarioDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarnombre_propietarioDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_propietarioDetalleActivoFijo() {
		return this.resaltarnombre_propietarioDetalleActivoFijo;
	}

	public void setResaltarnombre_propietarioDetalleActivoFijo(Border borderResaltar) {
		this.resaltarnombre_propietarioDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarnombre_propietarioDetalleActivoFijo() {
		return this.mostrarnombre_propietarioDetalleActivoFijo;
	}

	public void setMostrarnombre_propietarioDetalleActivoFijo(Boolean mostrarnombre_propietarioDetalleActivoFijo) {
		this.mostrarnombre_propietarioDetalleActivoFijo= mostrarnombre_propietarioDetalleActivoFijo;
	}

	public Boolean getActivarnombre_propietarioDetalleActivoFijo() {
		return this.activarnombre_propietarioDetalleActivoFijo;
	}

	public void setActivarnombre_propietarioDetalleActivoFijo(Boolean activarnombre_propietarioDetalleActivoFijo) {
		this.activarnombre_propietarioDetalleActivoFijo= activarnombre_propietarioDetalleActivoFijo;
	}

	public Border setResaltarresponsableDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarresponsableDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarresponsableDetalleActivoFijo() {
		return this.resaltarresponsableDetalleActivoFijo;
	}

	public void setResaltarresponsableDetalleActivoFijo(Border borderResaltar) {
		this.resaltarresponsableDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarresponsableDetalleActivoFijo() {
		return this.mostrarresponsableDetalleActivoFijo;
	}

	public void setMostrarresponsableDetalleActivoFijo(Boolean mostrarresponsableDetalleActivoFijo) {
		this.mostrarresponsableDetalleActivoFijo= mostrarresponsableDetalleActivoFijo;
	}

	public Boolean getActivarresponsableDetalleActivoFijo() {
		return this.activarresponsableDetalleActivoFijo;
	}

	public void setActivarresponsableDetalleActivoFijo(Boolean activarresponsableDetalleActivoFijo) {
		this.activarresponsableDetalleActivoFijo= activarresponsableDetalleActivoFijo;
	}

	public Border setResaltarpath_fotoDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarpath_fotoDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpath_fotoDetalleActivoFijo() {
		return this.resaltarpath_fotoDetalleActivoFijo;
	}

	public void setResaltarpath_fotoDetalleActivoFijo(Border borderResaltar) {
		this.resaltarpath_fotoDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarpath_fotoDetalleActivoFijo() {
		return this.mostrarpath_fotoDetalleActivoFijo;
	}

	public void setMostrarpath_fotoDetalleActivoFijo(Boolean mostrarpath_fotoDetalleActivoFijo) {
		this.mostrarpath_fotoDetalleActivoFijo= mostrarpath_fotoDetalleActivoFijo;
	}

	public Boolean getActivarpath_fotoDetalleActivoFijo() {
		return this.activarpath_fotoDetalleActivoFijo;
	}

	public void setActivarpath_fotoDetalleActivoFijo(Boolean activarpath_fotoDetalleActivoFijo) {
		this.activarpath_fotoDetalleActivoFijo= activarpath_fotoDetalleActivoFijo;
	}

	public Border setResaltarnumero_comprobanteDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarnumero_comprobanteDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobanteDetalleActivoFijo() {
		return this.resaltarnumero_comprobanteDetalleActivoFijo;
	}

	public void setResaltarnumero_comprobanteDetalleActivoFijo(Border borderResaltar) {
		this.resaltarnumero_comprobanteDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobanteDetalleActivoFijo() {
		return this.mostrarnumero_comprobanteDetalleActivoFijo;
	}

	public void setMostrarnumero_comprobanteDetalleActivoFijo(Boolean mostrarnumero_comprobanteDetalleActivoFijo) {
		this.mostrarnumero_comprobanteDetalleActivoFijo= mostrarnumero_comprobanteDetalleActivoFijo;
	}

	public Boolean getActivarnumero_comprobanteDetalleActivoFijo() {
		return this.activarnumero_comprobanteDetalleActivoFijo;
	}

	public void setActivarnumero_comprobanteDetalleActivoFijo(Boolean activarnumero_comprobanteDetalleActivoFijo) {
		this.activarnumero_comprobanteDetalleActivoFijo= activarnumero_comprobanteDetalleActivoFijo;
	}

	public Border setResaltarreferenciaDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarreferenciaDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarreferenciaDetalleActivoFijo() {
		return this.resaltarreferenciaDetalleActivoFijo;
	}

	public void setResaltarreferenciaDetalleActivoFijo(Border borderResaltar) {
		this.resaltarreferenciaDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarreferenciaDetalleActivoFijo() {
		return this.mostrarreferenciaDetalleActivoFijo;
	}

	public void setMostrarreferenciaDetalleActivoFijo(Boolean mostrarreferenciaDetalleActivoFijo) {
		this.mostrarreferenciaDetalleActivoFijo= mostrarreferenciaDetalleActivoFijo;
	}

	public Boolean getActivarreferenciaDetalleActivoFijo() {
		return this.activarreferenciaDetalleActivoFijo;
	}

	public void setActivarreferenciaDetalleActivoFijo(Boolean activarreferenciaDetalleActivoFijo) {
		this.activarreferenciaDetalleActivoFijo= activarreferenciaDetalleActivoFijo;
	}

	public Border setResaltarvalor_cotizacionDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarvalor_cotizacionDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_cotizacionDetalleActivoFijo() {
		return this.resaltarvalor_cotizacionDetalleActivoFijo;
	}

	public void setResaltarvalor_cotizacionDetalleActivoFijo(Border borderResaltar) {
		this.resaltarvalor_cotizacionDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarvalor_cotizacionDetalleActivoFijo() {
		return this.mostrarvalor_cotizacionDetalleActivoFijo;
	}

	public void setMostrarvalor_cotizacionDetalleActivoFijo(Boolean mostrarvalor_cotizacionDetalleActivoFijo) {
		this.mostrarvalor_cotizacionDetalleActivoFijo= mostrarvalor_cotizacionDetalleActivoFijo;
	}

	public Boolean getActivarvalor_cotizacionDetalleActivoFijo() {
		return this.activarvalor_cotizacionDetalleActivoFijo;
	}

	public void setActivarvalor_cotizacionDetalleActivoFijo(Boolean activarvalor_cotizacionDetalleActivoFijo) {
		this.activarvalor_cotizacionDetalleActivoFijo= activarvalor_cotizacionDetalleActivoFijo;
	}

	public Border setResaltarcon_partesDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarcon_partesDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_partesDetalleActivoFijo() {
		return this.resaltarcon_partesDetalleActivoFijo;
	}

	public void setResaltarcon_partesDetalleActivoFijo(Border borderResaltar) {
		this.resaltarcon_partesDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarcon_partesDetalleActivoFijo() {
		return this.mostrarcon_partesDetalleActivoFijo;
	}

	public void setMostrarcon_partesDetalleActivoFijo(Boolean mostrarcon_partesDetalleActivoFijo) {
		this.mostrarcon_partesDetalleActivoFijo= mostrarcon_partesDetalleActivoFijo;
	}

	public Boolean getActivarcon_partesDetalleActivoFijo() {
		return this.activarcon_partesDetalleActivoFijo;
	}

	public void setActivarcon_partesDetalleActivoFijo(Boolean activarcon_partesDetalleActivoFijo) {
		this.activarcon_partesDetalleActivoFijo= activarcon_partesDetalleActivoFijo;
	}

	public Border setResaltarcon_garantiaDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarcon_garantiaDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_garantiaDetalleActivoFijo() {
		return this.resaltarcon_garantiaDetalleActivoFijo;
	}

	public void setResaltarcon_garantiaDetalleActivoFijo(Border borderResaltar) {
		this.resaltarcon_garantiaDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarcon_garantiaDetalleActivoFijo() {
		return this.mostrarcon_garantiaDetalleActivoFijo;
	}

	public void setMostrarcon_garantiaDetalleActivoFijo(Boolean mostrarcon_garantiaDetalleActivoFijo) {
		this.mostrarcon_garantiaDetalleActivoFijo= mostrarcon_garantiaDetalleActivoFijo;
	}

	public Boolean getActivarcon_garantiaDetalleActivoFijo() {
		return this.activarcon_garantiaDetalleActivoFijo;
	}

	public void setActivarcon_garantiaDetalleActivoFijo(Boolean activarcon_garantiaDetalleActivoFijo) {
		this.activarcon_garantiaDetalleActivoFijo= activarcon_garantiaDetalleActivoFijo;
	}

	public Border setResaltarcon_existenciaDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarcon_existenciaDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_existenciaDetalleActivoFijo() {
		return this.resaltarcon_existenciaDetalleActivoFijo;
	}

	public void setResaltarcon_existenciaDetalleActivoFijo(Border borderResaltar) {
		this.resaltarcon_existenciaDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarcon_existenciaDetalleActivoFijo() {
		return this.mostrarcon_existenciaDetalleActivoFijo;
	}

	public void setMostrarcon_existenciaDetalleActivoFijo(Boolean mostrarcon_existenciaDetalleActivoFijo) {
		this.mostrarcon_existenciaDetalleActivoFijo= mostrarcon_existenciaDetalleActivoFijo;
	}

	public Boolean getActivarcon_existenciaDetalleActivoFijo() {
		return this.activarcon_existenciaDetalleActivoFijo;
	}

	public void setActivarcon_existenciaDetalleActivoFijo(Boolean activarcon_existenciaDetalleActivoFijo) {
		this.activarcon_existenciaDetalleActivoFijo= activarcon_existenciaDetalleActivoFijo;
	}

	public Border setResaltarfecha_bajaDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarfecha_bajaDetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_bajaDetalleActivoFijo() {
		return this.resaltarfecha_bajaDetalleActivoFijo;
	}

	public void setResaltarfecha_bajaDetalleActivoFijo(Border borderResaltar) {
		this.resaltarfecha_bajaDetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarfecha_bajaDetalleActivoFijo() {
		return this.mostrarfecha_bajaDetalleActivoFijo;
	}

	public void setMostrarfecha_bajaDetalleActivoFijo(Boolean mostrarfecha_bajaDetalleActivoFijo) {
		this.mostrarfecha_bajaDetalleActivoFijo= mostrarfecha_bajaDetalleActivoFijo;
	}

	public Boolean getActivarfecha_bajaDetalleActivoFijo() {
		return this.activarfecha_bajaDetalleActivoFijo;
	}

	public void setActivarfecha_bajaDetalleActivoFijo(Boolean activarfecha_bajaDetalleActivoFijo) {
		this.activarfecha_bajaDetalleActivoFijo= activarfecha_bajaDetalleActivoFijo;
	}

	public Border setResaltarpath_foto2DetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltar);
		
		this.resaltarpath_foto2DetalleActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpath_foto2DetalleActivoFijo() {
		return this.resaltarpath_foto2DetalleActivoFijo;
	}

	public void setResaltarpath_foto2DetalleActivoFijo(Border borderResaltar) {
		this.resaltarpath_foto2DetalleActivoFijo= borderResaltar;
	}

	public Boolean getMostrarpath_foto2DetalleActivoFijo() {
		return this.mostrarpath_foto2DetalleActivoFijo;
	}

	public void setMostrarpath_foto2DetalleActivoFijo(Boolean mostrarpath_foto2DetalleActivoFijo) {
		this.mostrarpath_foto2DetalleActivoFijo= mostrarpath_foto2DetalleActivoFijo;
	}

	public Boolean getActivarpath_foto2DetalleActivoFijo() {
		return this.activarpath_foto2DetalleActivoFijo;
	}

	public void setActivarpath_foto2DetalleActivoFijo(Boolean activarpath_foto2DetalleActivoFijo) {
		this.activarpath_foto2DetalleActivoFijo= activarpath_foto2DetalleActivoFijo;
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
		
		
		this.setMostraridDetalleActivoFijo(esInicial);
		this.setMostrarid_empresaDetalleActivoFijo(esInicial);
		this.setMostrarid_sucursalDetalleActivoFijo(esInicial);
		this.setMostrarid_detalle_grupo_activo_fijoDetalleActivoFijo(esInicial);
		this.setMostrarid_sub_grupo_activo_fijoDetalleActivoFijo(esInicial);
		this.setMostrarid_tipo_ramo_activo_fijoDetalleActivoFijo(esInicial);
		this.setMostrarid_tipo_activo_fijo_empresaDetalleActivoFijo(esInicial);
		this.setMostrarid_tipo_depreciacion_empresaDetalleActivoFijo(esInicial);
		this.setMostrarid_estado_activo_fijoDetalleActivoFijo(esInicial);
		this.setMostrarid_clienteDetalleActivoFijo(esInicial);
		this.setMostrarid_partida_presuDetalleActivoFijo(esInicial);
		this.setMostrarcodigoDetalleActivoFijo(esInicial);
		this.setMostrarnombreDetalleActivoFijo(esInicial);
		this.setMostrarserieDetalleActivoFijo(esInicial);
		this.setMostrarfecha_compraDetalleActivoFijo(esInicial);
		this.setMostrarfecha_mantenimientoDetalleActivoFijo(esInicial);
		this.setMostrarfecha_correccionDetalleActivoFijo(esInicial);
		this.setMostrarfecha_depreciacionDetalleActivoFijo(esInicial);
		this.setMostrarclaveDetalleActivoFijo(esInicial);
		this.setMostrarmarcaDetalleActivoFijo(esInicial);
		this.setMostrarmodeloDetalleActivoFijo(esInicial);
		this.setMostrarcolorDetalleActivoFijo(esInicial);
		this.setMostrarfechaDetalleActivoFijo(esInicial);
		this.setMostrarvalor_utilDetalleActivoFijo(esInicial);
		this.setMostrarcosto_de_compraDetalleActivoFijo(esInicial);
		this.setMostrarvida_utilDetalleActivoFijo(esInicial);
		this.setMostrarvalor_residualDetalleActivoFijo(esInicial);
		this.setMostrarcantidadDetalleActivoFijo(esInicial);
		this.setMostrarnombre_propietarioDetalleActivoFijo(esInicial);
		this.setMostrarresponsableDetalleActivoFijo(esInicial);
		this.setMostrarpath_fotoDetalleActivoFijo(esInicial);
		this.setMostrarnumero_comprobanteDetalleActivoFijo(esInicial);
		this.setMostrarreferenciaDetalleActivoFijo(esInicial);
		this.setMostrarvalor_cotizacionDetalleActivoFijo(esInicial);
		this.setMostrarcon_partesDetalleActivoFijo(esInicial);
		this.setMostrarcon_garantiaDetalleActivoFijo(esInicial);
		this.setMostrarcon_existenciaDetalleActivoFijo(esInicial);
		this.setMostrarfecha_bajaDetalleActivoFijo(esInicial);
		this.setMostrarpath_foto2DetalleActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.ID)) {
				this.setMostraridDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO)) {
				this.setMostrarid_detalle_grupo_activo_fijoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.IDSUBGRUPOACTIVOFIJO)) {
				this.setMostrarid_sub_grupo_activo_fijoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.IDTIPORAMOACTIVOFIJO)) {
				this.setMostrarid_tipo_ramo_activo_fijoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.IDTIPOACTIVOFIJOEMPRESA)) {
				this.setMostrarid_tipo_activo_fijo_empresaDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.IDTIPODEPRECIACIONEMPRESA)) {
				this.setMostrarid_tipo_depreciacion_empresaDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.IDESTADOACTIVOFIJO)) {
				this.setMostrarid_estado_activo_fijoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.IDPARTIDAPRESU)) {
				this.setMostrarid_partida_presuDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.SERIE)) {
				this.setMostrarserieDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.FECHACOMPRA)) {
				this.setMostrarfecha_compraDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.FECHAMANTENIMIENTO)) {
				this.setMostrarfecha_mantenimientoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.FECHACORRECCION)) {
				this.setMostrarfecha_correccionDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.FECHADEPRECIACION)) {
				this.setMostrarfecha_depreciacionDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.CLAVE)) {
				this.setMostrarclaveDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.MARCA)) {
				this.setMostrarmarcaDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.MODELO)) {
				this.setMostrarmodeloDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.COLOR)) {
				this.setMostrarcolorDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.FECHA)) {
				this.setMostrarfechaDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.VALORUTIL)) {
				this.setMostrarvalor_utilDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.COSTODECOMPRA)) {
				this.setMostrarcosto_de_compraDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.VIDAUTIL)) {
				this.setMostrarvida_utilDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.VALORRESIDUAL)) {
				this.setMostrarvalor_residualDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.NOMBREPROPIETARIO)) {
				this.setMostrarnombre_propietarioDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.RESPONSABLE)) {
				this.setMostrarresponsableDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.PATHFOTO)) {
				this.setMostrarpath_fotoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setMostrarnumero_comprobanteDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.REFERENCIA)) {
				this.setMostrarreferenciaDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.VALORCOTIZACION)) {
				this.setMostrarvalor_cotizacionDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.CONPARTES)) {
				this.setMostrarcon_partesDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.CONGARANTIA)) {
				this.setMostrarcon_garantiaDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.CONEXISTENCIA)) {
				this.setMostrarcon_existenciaDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.FECHABAJA)) {
				this.setMostrarfecha_bajaDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.PATHFOTO2)) {
				this.setMostrarpath_foto2DetalleActivoFijo(esAsigna);
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
		
		
		this.setActivaridDetalleActivoFijo(esInicial);
		this.setActivarid_empresaDetalleActivoFijo(esInicial);
		this.setActivarid_sucursalDetalleActivoFijo(esInicial);
		this.setActivarid_detalle_grupo_activo_fijoDetalleActivoFijo(esInicial);
		this.setActivarid_sub_grupo_activo_fijoDetalleActivoFijo(esInicial);
		this.setActivarid_tipo_ramo_activo_fijoDetalleActivoFijo(esInicial);
		this.setActivarid_tipo_activo_fijo_empresaDetalleActivoFijo(esInicial);
		this.setActivarid_tipo_depreciacion_empresaDetalleActivoFijo(esInicial);
		this.setActivarid_estado_activo_fijoDetalleActivoFijo(esInicial);
		this.setActivarid_clienteDetalleActivoFijo(esInicial);
		this.setActivarid_partida_presuDetalleActivoFijo(esInicial);
		this.setActivarcodigoDetalleActivoFijo(esInicial);
		this.setActivarnombreDetalleActivoFijo(esInicial);
		this.setActivarserieDetalleActivoFijo(esInicial);
		this.setActivarfecha_compraDetalleActivoFijo(esInicial);
		this.setActivarfecha_mantenimientoDetalleActivoFijo(esInicial);
		this.setActivarfecha_correccionDetalleActivoFijo(esInicial);
		this.setActivarfecha_depreciacionDetalleActivoFijo(esInicial);
		this.setActivarclaveDetalleActivoFijo(esInicial);
		this.setActivarmarcaDetalleActivoFijo(esInicial);
		this.setActivarmodeloDetalleActivoFijo(esInicial);
		this.setActivarcolorDetalleActivoFijo(esInicial);
		this.setActivarfechaDetalleActivoFijo(esInicial);
		this.setActivarvalor_utilDetalleActivoFijo(esInicial);
		this.setActivarcosto_de_compraDetalleActivoFijo(esInicial);
		this.setActivarvida_utilDetalleActivoFijo(esInicial);
		this.setActivarvalor_residualDetalleActivoFijo(esInicial);
		this.setActivarcantidadDetalleActivoFijo(esInicial);
		this.setActivarnombre_propietarioDetalleActivoFijo(esInicial);
		this.setActivarresponsableDetalleActivoFijo(esInicial);
		this.setActivarpath_fotoDetalleActivoFijo(esInicial);
		this.setActivarnumero_comprobanteDetalleActivoFijo(esInicial);
		this.setActivarreferenciaDetalleActivoFijo(esInicial);
		this.setActivarvalor_cotizacionDetalleActivoFijo(esInicial);
		this.setActivarcon_partesDetalleActivoFijo(esInicial);
		this.setActivarcon_garantiaDetalleActivoFijo(esInicial);
		this.setActivarcon_existenciaDetalleActivoFijo(esInicial);
		this.setActivarfecha_bajaDetalleActivoFijo(esInicial);
		this.setActivarpath_foto2DetalleActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.ID)) {
				this.setActivaridDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO)) {
				this.setActivarid_detalle_grupo_activo_fijoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.IDSUBGRUPOACTIVOFIJO)) {
				this.setActivarid_sub_grupo_activo_fijoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.IDTIPORAMOACTIVOFIJO)) {
				this.setActivarid_tipo_ramo_activo_fijoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.IDTIPOACTIVOFIJOEMPRESA)) {
				this.setActivarid_tipo_activo_fijo_empresaDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.IDTIPODEPRECIACIONEMPRESA)) {
				this.setActivarid_tipo_depreciacion_empresaDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.IDESTADOACTIVOFIJO)) {
				this.setActivarid_estado_activo_fijoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.IDPARTIDAPRESU)) {
				this.setActivarid_partida_presuDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.SERIE)) {
				this.setActivarserieDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.FECHACOMPRA)) {
				this.setActivarfecha_compraDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.FECHAMANTENIMIENTO)) {
				this.setActivarfecha_mantenimientoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.FECHACORRECCION)) {
				this.setActivarfecha_correccionDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.FECHADEPRECIACION)) {
				this.setActivarfecha_depreciacionDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.CLAVE)) {
				this.setActivarclaveDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.MARCA)) {
				this.setActivarmarcaDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.MODELO)) {
				this.setActivarmodeloDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.COLOR)) {
				this.setActivarcolorDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.FECHA)) {
				this.setActivarfechaDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.VALORUTIL)) {
				this.setActivarvalor_utilDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.COSTODECOMPRA)) {
				this.setActivarcosto_de_compraDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.VIDAUTIL)) {
				this.setActivarvida_utilDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.VALORRESIDUAL)) {
				this.setActivarvalor_residualDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.NOMBREPROPIETARIO)) {
				this.setActivarnombre_propietarioDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.RESPONSABLE)) {
				this.setActivarresponsableDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.PATHFOTO)) {
				this.setActivarpath_fotoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setActivarnumero_comprobanteDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.REFERENCIA)) {
				this.setActivarreferenciaDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.VALORCOTIZACION)) {
				this.setActivarvalor_cotizacionDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.CONPARTES)) {
				this.setActivarcon_partesDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.CONGARANTIA)) {
				this.setActivarcon_garantiaDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.CONEXISTENCIA)) {
				this.setActivarcon_existenciaDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.FECHABAJA)) {
				this.setActivarfecha_bajaDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.PATHFOTO2)) {
				this.setActivarpath_foto2DetalleActivoFijo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleActivoFijo(esInicial);
		this.setResaltarid_empresaDetalleActivoFijo(esInicial);
		this.setResaltarid_sucursalDetalleActivoFijo(esInicial);
		this.setResaltarid_detalle_grupo_activo_fijoDetalleActivoFijo(esInicial);
		this.setResaltarid_sub_grupo_activo_fijoDetalleActivoFijo(esInicial);
		this.setResaltarid_tipo_ramo_activo_fijoDetalleActivoFijo(esInicial);
		this.setResaltarid_tipo_activo_fijo_empresaDetalleActivoFijo(esInicial);
		this.setResaltarid_tipo_depreciacion_empresaDetalleActivoFijo(esInicial);
		this.setResaltarid_estado_activo_fijoDetalleActivoFijo(esInicial);
		this.setResaltarid_clienteDetalleActivoFijo(esInicial);
		this.setResaltarid_partida_presuDetalleActivoFijo(esInicial);
		this.setResaltarcodigoDetalleActivoFijo(esInicial);
		this.setResaltarnombreDetalleActivoFijo(esInicial);
		this.setResaltarserieDetalleActivoFijo(esInicial);
		this.setResaltarfecha_compraDetalleActivoFijo(esInicial);
		this.setResaltarfecha_mantenimientoDetalleActivoFijo(esInicial);
		this.setResaltarfecha_correccionDetalleActivoFijo(esInicial);
		this.setResaltarfecha_depreciacionDetalleActivoFijo(esInicial);
		this.setResaltarclaveDetalleActivoFijo(esInicial);
		this.setResaltarmarcaDetalleActivoFijo(esInicial);
		this.setResaltarmodeloDetalleActivoFijo(esInicial);
		this.setResaltarcolorDetalleActivoFijo(esInicial);
		this.setResaltarfechaDetalleActivoFijo(esInicial);
		this.setResaltarvalor_utilDetalleActivoFijo(esInicial);
		this.setResaltarcosto_de_compraDetalleActivoFijo(esInicial);
		this.setResaltarvida_utilDetalleActivoFijo(esInicial);
		this.setResaltarvalor_residualDetalleActivoFijo(esInicial);
		this.setResaltarcantidadDetalleActivoFijo(esInicial);
		this.setResaltarnombre_propietarioDetalleActivoFijo(esInicial);
		this.setResaltarresponsableDetalleActivoFijo(esInicial);
		this.setResaltarpath_fotoDetalleActivoFijo(esInicial);
		this.setResaltarnumero_comprobanteDetalleActivoFijo(esInicial);
		this.setResaltarreferenciaDetalleActivoFijo(esInicial);
		this.setResaltarvalor_cotizacionDetalleActivoFijo(esInicial);
		this.setResaltarcon_partesDetalleActivoFijo(esInicial);
		this.setResaltarcon_garantiaDetalleActivoFijo(esInicial);
		this.setResaltarcon_existenciaDetalleActivoFijo(esInicial);
		this.setResaltarfecha_bajaDetalleActivoFijo(esInicial);
		this.setResaltarpath_foto2DetalleActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.ID)) {
				this.setResaltaridDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO)) {
				this.setResaltarid_detalle_grupo_activo_fijoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.IDSUBGRUPOACTIVOFIJO)) {
				this.setResaltarid_sub_grupo_activo_fijoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.IDTIPORAMOACTIVOFIJO)) {
				this.setResaltarid_tipo_ramo_activo_fijoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.IDTIPOACTIVOFIJOEMPRESA)) {
				this.setResaltarid_tipo_activo_fijo_empresaDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.IDTIPODEPRECIACIONEMPRESA)) {
				this.setResaltarid_tipo_depreciacion_empresaDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.IDESTADOACTIVOFIJO)) {
				this.setResaltarid_estado_activo_fijoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.IDPARTIDAPRESU)) {
				this.setResaltarid_partida_presuDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.SERIE)) {
				this.setResaltarserieDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.FECHACOMPRA)) {
				this.setResaltarfecha_compraDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.FECHAMANTENIMIENTO)) {
				this.setResaltarfecha_mantenimientoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.FECHACORRECCION)) {
				this.setResaltarfecha_correccionDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.FECHADEPRECIACION)) {
				this.setResaltarfecha_depreciacionDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.CLAVE)) {
				this.setResaltarclaveDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.MARCA)) {
				this.setResaltarmarcaDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.MODELO)) {
				this.setResaltarmodeloDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.COLOR)) {
				this.setResaltarcolorDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.FECHA)) {
				this.setResaltarfechaDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.VALORUTIL)) {
				this.setResaltarvalor_utilDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.COSTODECOMPRA)) {
				this.setResaltarcosto_de_compraDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.VIDAUTIL)) {
				this.setResaltarvida_utilDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.VALORRESIDUAL)) {
				this.setResaltarvalor_residualDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.NOMBREPROPIETARIO)) {
				this.setResaltarnombre_propietarioDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.RESPONSABLE)) {
				this.setResaltarresponsableDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.PATHFOTO)) {
				this.setResaltarpath_fotoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setResaltarnumero_comprobanteDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.REFERENCIA)) {
				this.setResaltarreferenciaDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.VALORCOTIZACION)) {
				this.setResaltarvalor_cotizacionDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.CONPARTES)) {
				this.setResaltarcon_partesDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.CONGARANTIA)) {
				this.setResaltarcon_garantiaDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.CONEXISTENCIA)) {
				this.setResaltarcon_existenciaDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.FECHABAJA)) {
				this.setResaltarfecha_bajaDetalleActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleActivoFijoConstantesFunciones.PATHFOTO2)) {
				this.setResaltarpath_foto2DetalleActivoFijo(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarMantenimientoActivoFijoDetalleActivoFijo=null;

	public Border getResaltarMantenimientoActivoFijoDetalleActivoFijo() {
		return this.resaltarMantenimientoActivoFijoDetalleActivoFijo;
	}

	public void setResaltarMantenimientoActivoFijoDetalleActivoFijo(Border borderResaltarMantenimientoActivoFijo) {
		if(borderResaltarMantenimientoActivoFijo!=null) {
			this.resaltarMantenimientoActivoFijoDetalleActivoFijo= borderResaltarMantenimientoActivoFijo;
		}
	}

	public Border setResaltarMantenimientoActivoFijoDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltarMantenimientoActivoFijo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltarMantenimientoActivoFijo);
			
		this.resaltarMantenimientoActivoFijoDetalleActivoFijo= borderResaltarMantenimientoActivoFijo;

		 return borderResaltarMantenimientoActivoFijo;
	}



	public Boolean mostrarMantenimientoActivoFijoDetalleActivoFijo=true;

	public Boolean getMostrarMantenimientoActivoFijoDetalleActivoFijo() {
		return this.mostrarMantenimientoActivoFijoDetalleActivoFijo;
	}

	public void setMostrarMantenimientoActivoFijoDetalleActivoFijo(Boolean visibilidadResaltarMantenimientoActivoFijo) {
		this.mostrarMantenimientoActivoFijoDetalleActivoFijo= visibilidadResaltarMantenimientoActivoFijo;
	}



	public Boolean activarMantenimientoActivoFijoDetalleActivoFijo=true;

	public Boolean gethabilitarResaltarMantenimientoActivoFijoDetalleActivoFijo() {
		return this.activarMantenimientoActivoFijoDetalleActivoFijo;
	}

	public void setActivarMantenimientoActivoFijoDetalleActivoFijo(Boolean habilitarResaltarMantenimientoActivoFijo) {
		this.activarMantenimientoActivoFijoDetalleActivoFijo= habilitarResaltarMantenimientoActivoFijo;
	}


	public Border resaltarServicioTransporteDetalleActivoFijo=null;

	public Border getResaltarServicioTransporteDetalleActivoFijo() {
		return this.resaltarServicioTransporteDetalleActivoFijo;
	}

	public void setResaltarServicioTransporteDetalleActivoFijo(Border borderResaltarServicioTransporte) {
		if(borderResaltarServicioTransporte!=null) {
			this.resaltarServicioTransporteDetalleActivoFijo= borderResaltarServicioTransporte;
		}
	}

	public Border setResaltarServicioTransporteDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltarServicioTransporte=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltarServicioTransporte);
			
		this.resaltarServicioTransporteDetalleActivoFijo= borderResaltarServicioTransporte;

		 return borderResaltarServicioTransporte;
	}



	public Boolean mostrarServicioTransporteDetalleActivoFijo=true;

	public Boolean getMostrarServicioTransporteDetalleActivoFijo() {
		return this.mostrarServicioTransporteDetalleActivoFijo;
	}

	public void setMostrarServicioTransporteDetalleActivoFijo(Boolean visibilidadResaltarServicioTransporte) {
		this.mostrarServicioTransporteDetalleActivoFijo= visibilidadResaltarServicioTransporte;
	}



	public Boolean activarServicioTransporteDetalleActivoFijo=true;

	public Boolean gethabilitarResaltarServicioTransporteDetalleActivoFijo() {
		return this.activarServicioTransporteDetalleActivoFijo;
	}

	public void setActivarServicioTransporteDetalleActivoFijo(Boolean habilitarResaltarServicioTransporte) {
		this.activarServicioTransporteDetalleActivoFijo= habilitarResaltarServicioTransporte;
	}


	public Border resaltarMovimientoActivoFijoDetalleActivoFijo=null;

	public Border getResaltarMovimientoActivoFijoDetalleActivoFijo() {
		return this.resaltarMovimientoActivoFijoDetalleActivoFijo;
	}

	public void setResaltarMovimientoActivoFijoDetalleActivoFijo(Border borderResaltarMovimientoActivoFijo) {
		if(borderResaltarMovimientoActivoFijo!=null) {
			this.resaltarMovimientoActivoFijoDetalleActivoFijo= borderResaltarMovimientoActivoFijo;
		}
	}

	public Border setResaltarMovimientoActivoFijoDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltarMovimientoActivoFijo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltarMovimientoActivoFijo);
			
		this.resaltarMovimientoActivoFijoDetalleActivoFijo= borderResaltarMovimientoActivoFijo;

		 return borderResaltarMovimientoActivoFijo;
	}



	public Boolean mostrarMovimientoActivoFijoDetalleActivoFijo=true;

	public Boolean getMostrarMovimientoActivoFijoDetalleActivoFijo() {
		return this.mostrarMovimientoActivoFijoDetalleActivoFijo;
	}

	public void setMostrarMovimientoActivoFijoDetalleActivoFijo(Boolean visibilidadResaltarMovimientoActivoFijo) {
		this.mostrarMovimientoActivoFijoDetalleActivoFijo= visibilidadResaltarMovimientoActivoFijo;
	}



	public Boolean activarMovimientoActivoFijoDetalleActivoFijo=true;

	public Boolean gethabilitarResaltarMovimientoActivoFijoDetalleActivoFijo() {
		return this.activarMovimientoActivoFijoDetalleActivoFijo;
	}

	public void setActivarMovimientoActivoFijoDetalleActivoFijo(Boolean habilitarResaltarMovimientoActivoFijo) {
		this.activarMovimientoActivoFijoDetalleActivoFijo= habilitarResaltarMovimientoActivoFijo;
	}


	public Border resaltarVehiculoDetalleActivoFijo=null;

	public Border getResaltarVehiculoDetalleActivoFijo() {
		return this.resaltarVehiculoDetalleActivoFijo;
	}

	public void setResaltarVehiculoDetalleActivoFijo(Border borderResaltarVehiculo) {
		if(borderResaltarVehiculo!=null) {
			this.resaltarVehiculoDetalleActivoFijo= borderResaltarVehiculo;
		}
	}

	public Border setResaltarVehiculoDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltarVehiculo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltarVehiculo);
			
		this.resaltarVehiculoDetalleActivoFijo= borderResaltarVehiculo;

		 return borderResaltarVehiculo;
	}



	public Boolean mostrarVehiculoDetalleActivoFijo=true;

	public Boolean getMostrarVehiculoDetalleActivoFijo() {
		return this.mostrarVehiculoDetalleActivoFijo;
	}

	public void setMostrarVehiculoDetalleActivoFijo(Boolean visibilidadResaltarVehiculo) {
		this.mostrarVehiculoDetalleActivoFijo= visibilidadResaltarVehiculo;
	}



	public Boolean activarVehiculoDetalleActivoFijo=true;

	public Boolean gethabilitarResaltarVehiculoDetalleActivoFijo() {
		return this.activarVehiculoDetalleActivoFijo;
	}

	public void setActivarVehiculoDetalleActivoFijo(Boolean habilitarResaltarVehiculo) {
		this.activarVehiculoDetalleActivoFijo= habilitarResaltarVehiculo;
	}


	public Border resaltarMetodoDepreciacionDetalleActivoFijo=null;

	public Border getResaltarMetodoDepreciacionDetalleActivoFijo() {
		return this.resaltarMetodoDepreciacionDetalleActivoFijo;
	}

	public void setResaltarMetodoDepreciacionDetalleActivoFijo(Border borderResaltarMetodoDepreciacion) {
		if(borderResaltarMetodoDepreciacion!=null) {
			this.resaltarMetodoDepreciacionDetalleActivoFijo= borderResaltarMetodoDepreciacion;
		}
	}

	public Border setResaltarMetodoDepreciacionDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltarMetodoDepreciacion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltarMetodoDepreciacion);
			
		this.resaltarMetodoDepreciacionDetalleActivoFijo= borderResaltarMetodoDepreciacion;

		 return borderResaltarMetodoDepreciacion;
	}



	public Boolean mostrarMetodoDepreciacionDetalleActivoFijo=true;

	public Boolean getMostrarMetodoDepreciacionDetalleActivoFijo() {
		return this.mostrarMetodoDepreciacionDetalleActivoFijo;
	}

	public void setMostrarMetodoDepreciacionDetalleActivoFijo(Boolean visibilidadResaltarMetodoDepreciacion) {
		this.mostrarMetodoDepreciacionDetalleActivoFijo= visibilidadResaltarMetodoDepreciacion;
	}



	public Boolean activarMetodoDepreciacionDetalleActivoFijo=true;

	public Boolean gethabilitarResaltarMetodoDepreciacionDetalleActivoFijo() {
		return this.activarMetodoDepreciacionDetalleActivoFijo;
	}

	public void setActivarMetodoDepreciacionDetalleActivoFijo(Boolean habilitarResaltarMetodoDepreciacion) {
		this.activarMetodoDepreciacionDetalleActivoFijo= habilitarResaltarMetodoDepreciacion;
	}


	public Border resaltarResponsableActivoFijoDetalleActivoFijo=null;

	public Border getResaltarResponsableActivoFijoDetalleActivoFijo() {
		return this.resaltarResponsableActivoFijoDetalleActivoFijo;
	}

	public void setResaltarResponsableActivoFijoDetalleActivoFijo(Border borderResaltarResponsableActivoFijo) {
		if(borderResaltarResponsableActivoFijo!=null) {
			this.resaltarResponsableActivoFijoDetalleActivoFijo= borderResaltarResponsableActivoFijo;
		}
	}

	public Border setResaltarResponsableActivoFijoDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltarResponsableActivoFijo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltarResponsableActivoFijo);
			
		this.resaltarResponsableActivoFijoDetalleActivoFijo= borderResaltarResponsableActivoFijo;

		 return borderResaltarResponsableActivoFijo;
	}



	public Boolean mostrarResponsableActivoFijoDetalleActivoFijo=true;

	public Boolean getMostrarResponsableActivoFijoDetalleActivoFijo() {
		return this.mostrarResponsableActivoFijoDetalleActivoFijo;
	}

	public void setMostrarResponsableActivoFijoDetalleActivoFijo(Boolean visibilidadResaltarResponsableActivoFijo) {
		this.mostrarResponsableActivoFijoDetalleActivoFijo= visibilidadResaltarResponsableActivoFijo;
	}



	public Boolean activarResponsableActivoFijoDetalleActivoFijo=true;

	public Boolean gethabilitarResaltarResponsableActivoFijoDetalleActivoFijo() {
		return this.activarResponsableActivoFijoDetalleActivoFijo;
	}

	public void setActivarResponsableActivoFijoDetalleActivoFijo(Boolean habilitarResaltarResponsableActivoFijo) {
		this.activarResponsableActivoFijoDetalleActivoFijo= habilitarResaltarResponsableActivoFijo;
	}


	public Border resaltarDepreciacionActivoFijoDetalleActivoFijo=null;

	public Border getResaltarDepreciacionActivoFijoDetalleActivoFijo() {
		return this.resaltarDepreciacionActivoFijoDetalleActivoFijo;
	}

	public void setResaltarDepreciacionActivoFijoDetalleActivoFijo(Border borderResaltarDepreciacionActivoFijo) {
		if(borderResaltarDepreciacionActivoFijo!=null) {
			this.resaltarDepreciacionActivoFijoDetalleActivoFijo= borderResaltarDepreciacionActivoFijo;
		}
	}

	public Border setResaltarDepreciacionActivoFijoDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltarDepreciacionActivoFijo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltarDepreciacionActivoFijo);
			
		this.resaltarDepreciacionActivoFijoDetalleActivoFijo= borderResaltarDepreciacionActivoFijo;

		 return borderResaltarDepreciacionActivoFijo;
	}



	public Boolean mostrarDepreciacionActivoFijoDetalleActivoFijo=true;

	public Boolean getMostrarDepreciacionActivoFijoDetalleActivoFijo() {
		return this.mostrarDepreciacionActivoFijoDetalleActivoFijo;
	}

	public void setMostrarDepreciacionActivoFijoDetalleActivoFijo(Boolean visibilidadResaltarDepreciacionActivoFijo) {
		this.mostrarDepreciacionActivoFijoDetalleActivoFijo= visibilidadResaltarDepreciacionActivoFijo;
	}



	public Boolean activarDepreciacionActivoFijoDetalleActivoFijo=true;

	public Boolean gethabilitarResaltarDepreciacionActivoFijoDetalleActivoFijo() {
		return this.activarDepreciacionActivoFijoDetalleActivoFijo;
	}

	public void setActivarDepreciacionActivoFijoDetalleActivoFijo(Boolean habilitarResaltarDepreciacionActivoFijo) {
		this.activarDepreciacionActivoFijoDetalleActivoFijo= habilitarResaltarDepreciacionActivoFijo;
	}


	public Border resaltarGastoDepreciacionCentroCostoDetalleActivoFijo=null;

	public Border getResaltarGastoDepreciacionCentroCostoDetalleActivoFijo() {
		return this.resaltarGastoDepreciacionCentroCostoDetalleActivoFijo;
	}

	public void setResaltarGastoDepreciacionCentroCostoDetalleActivoFijo(Border borderResaltarGastoDepreciacionCentroCosto) {
		if(borderResaltarGastoDepreciacionCentroCosto!=null) {
			this.resaltarGastoDepreciacionCentroCostoDetalleActivoFijo= borderResaltarGastoDepreciacionCentroCosto;
		}
	}

	public Border setResaltarGastoDepreciacionCentroCostoDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltarGastoDepreciacionCentroCosto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltarGastoDepreciacionCentroCosto);
			
		this.resaltarGastoDepreciacionCentroCostoDetalleActivoFijo= borderResaltarGastoDepreciacionCentroCosto;

		 return borderResaltarGastoDepreciacionCentroCosto;
	}



	public Boolean mostrarGastoDepreciacionCentroCostoDetalleActivoFijo=true;

	public Boolean getMostrarGastoDepreciacionCentroCostoDetalleActivoFijo() {
		return this.mostrarGastoDepreciacionCentroCostoDetalleActivoFijo;
	}

	public void setMostrarGastoDepreciacionCentroCostoDetalleActivoFijo(Boolean visibilidadResaltarGastoDepreciacionCentroCosto) {
		this.mostrarGastoDepreciacionCentroCostoDetalleActivoFijo= visibilidadResaltarGastoDepreciacionCentroCosto;
	}



	public Boolean activarGastoDepreciacionCentroCostoDetalleActivoFijo=true;

	public Boolean gethabilitarResaltarGastoDepreciacionCentroCostoDetalleActivoFijo() {
		return this.activarGastoDepreciacionCentroCostoDetalleActivoFijo;
	}

	public void setActivarGastoDepreciacionCentroCostoDetalleActivoFijo(Boolean habilitarResaltarGastoDepreciacionCentroCosto) {
		this.activarGastoDepreciacionCentroCostoDetalleActivoFijo= habilitarResaltarGastoDepreciacionCentroCosto;
	}


	public Border resaltarParteActivoFijoDetalleActivoFijo=null;

	public Border getResaltarParteActivoFijoDetalleActivoFijo() {
		return this.resaltarParteActivoFijoDetalleActivoFijo;
	}

	public void setResaltarParteActivoFijoDetalleActivoFijo(Border borderResaltarParteActivoFijo) {
		if(borderResaltarParteActivoFijo!=null) {
			this.resaltarParteActivoFijoDetalleActivoFijo= borderResaltarParteActivoFijo;
		}
	}

	public Border setResaltarParteActivoFijoDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltarParteActivoFijo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//detalleactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleActivoFijo.setBorder(borderResaltarParteActivoFijo);
			
		this.resaltarParteActivoFijoDetalleActivoFijo= borderResaltarParteActivoFijo;

		 return borderResaltarParteActivoFijo;
	}



	public Boolean mostrarParteActivoFijoDetalleActivoFijo=true;

	public Boolean getMostrarParteActivoFijoDetalleActivoFijo() {
		return this.mostrarParteActivoFijoDetalleActivoFijo;
	}

	public void setMostrarParteActivoFijoDetalleActivoFijo(Boolean visibilidadResaltarParteActivoFijo) {
		this.mostrarParteActivoFijoDetalleActivoFijo= visibilidadResaltarParteActivoFijo;
	}



	public Boolean activarParteActivoFijoDetalleActivoFijo=true;

	public Boolean gethabilitarResaltarParteActivoFijoDetalleActivoFijo() {
		return this.activarParteActivoFijoDetalleActivoFijo;
	}

	public void setActivarParteActivoFijoDetalleActivoFijo(Boolean habilitarResaltarParteActivoFijo) {
		this.activarParteActivoFijoDetalleActivoFijo= habilitarResaltarParteActivoFijo;
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

		this.setMostrarMantenimientoActivoFijoDetalleActivoFijo(esInicial);
		this.setMostrarServicioTransporteDetalleActivoFijo(esInicial);
		this.setMostrarMovimientoActivoFijoDetalleActivoFijo(esInicial);
		this.setMostrarVehiculoDetalleActivoFijo(esInicial);
		this.setMostrarMetodoDepreciacionDetalleActivoFijo(esInicial);
		this.setMostrarResponsableActivoFijoDetalleActivoFijo(esInicial);
		this.setMostrarDepreciacionActivoFijoDetalleActivoFijo(esInicial);
		this.setMostrarGastoDepreciacionCentroCostoDetalleActivoFijo(esInicial);
		this.setMostrarParteActivoFijoDetalleActivoFijo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(MantenimientoActivoFijo.class)) {
				this.setMostrarMantenimientoActivoFijoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(ServicioTransporte.class)) {
				this.setMostrarServicioTransporteDetalleActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(MovimientoActivoFijo.class)) {
				this.setMostrarMovimientoActivoFijoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(Vehiculo.class)) {
				this.setMostrarVehiculoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(MetodoDepreciacion.class)) {
				this.setMostrarMetodoDepreciacionDetalleActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(ResponsableActivoFijo.class)) {
				this.setMostrarResponsableActivoFijoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(DepreciacionActivoFijo.class)) {
				this.setMostrarDepreciacionActivoFijoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(GastoDepreciacionCentroCosto.class)) {
				this.setMostrarGastoDepreciacionCentroCostoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParteActivoFijo.class)) {
				this.setMostrarParteActivoFijoDetalleActivoFijo(esAsigna);
				continue;
			}
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

		this.setActivarMantenimientoActivoFijoDetalleActivoFijo(esInicial);
		this.setActivarServicioTransporteDetalleActivoFijo(esInicial);
		this.setActivarMovimientoActivoFijoDetalleActivoFijo(esInicial);
		this.setActivarVehiculoDetalleActivoFijo(esInicial);
		this.setActivarMetodoDepreciacionDetalleActivoFijo(esInicial);
		this.setActivarResponsableActivoFijoDetalleActivoFijo(esInicial);
		this.setActivarDepreciacionActivoFijoDetalleActivoFijo(esInicial);
		this.setActivarGastoDepreciacionCentroCostoDetalleActivoFijo(esInicial);
		this.setActivarParteActivoFijoDetalleActivoFijo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(MantenimientoActivoFijo.class)) {
				this.setActivarMantenimientoActivoFijoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(ServicioTransporte.class)) {
				this.setActivarServicioTransporteDetalleActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(MovimientoActivoFijo.class)) {
				this.setActivarMovimientoActivoFijoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(Vehiculo.class)) {
				this.setActivarVehiculoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(MetodoDepreciacion.class)) {
				this.setActivarMetodoDepreciacionDetalleActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(ResponsableActivoFijo.class)) {
				this.setActivarResponsableActivoFijoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(DepreciacionActivoFijo.class)) {
				this.setActivarDepreciacionActivoFijoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(GastoDepreciacionCentroCosto.class)) {
				this.setActivarGastoDepreciacionCentroCostoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParteActivoFijo.class)) {
				this.setActivarParteActivoFijoDetalleActivoFijo(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarMantenimientoActivoFijoDetalleActivoFijo(esInicial);
		this.setResaltarServicioTransporteDetalleActivoFijo(esInicial);
		this.setResaltarMovimientoActivoFijoDetalleActivoFijo(esInicial);
		this.setResaltarVehiculoDetalleActivoFijo(esInicial);
		this.setResaltarMetodoDepreciacionDetalleActivoFijo(esInicial);
		this.setResaltarResponsableActivoFijoDetalleActivoFijo(esInicial);
		this.setResaltarDepreciacionActivoFijoDetalleActivoFijo(esInicial);
		this.setResaltarGastoDepreciacionCentroCostoDetalleActivoFijo(esInicial);
		this.setResaltarParteActivoFijoDetalleActivoFijo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(MantenimientoActivoFijo.class)) {
				this.setResaltarMantenimientoActivoFijoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(ServicioTransporte.class)) {
				this.setResaltarServicioTransporteDetalleActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(MovimientoActivoFijo.class)) {
				this.setResaltarMovimientoActivoFijoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(Vehiculo.class)) {
				this.setResaltarVehiculoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(MetodoDepreciacion.class)) {
				this.setResaltarMetodoDepreciacionDetalleActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(ResponsableActivoFijo.class)) {
				this.setResaltarResponsableActivoFijoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(DepreciacionActivoFijo.class)) {
				this.setResaltarDepreciacionActivoFijoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(GastoDepreciacionCentroCosto.class)) {
				this.setResaltarGastoDepreciacionCentroCostoDetalleActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParteActivoFijo.class)) {
				this.setResaltarParteActivoFijoDetalleActivoFijo(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdClienteDetalleActivoFijo=true;

	public Boolean getMostrarFK_IdClienteDetalleActivoFijo() {
		return this.mostrarFK_IdClienteDetalleActivoFijo;
	}

	public void setMostrarFK_IdClienteDetalleActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteDetalleActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdDetalleGrupoActivoFijoDetalleActivoFijo=true;

	public Boolean getMostrarFK_IdDetalleGrupoActivoFijoDetalleActivoFijo() {
		return this.mostrarFK_IdDetalleGrupoActivoFijoDetalleActivoFijo;
	}

	public void setMostrarFK_IdDetalleGrupoActivoFijoDetalleActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDetalleGrupoActivoFijoDetalleActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleActivoFijo=true;

	public Boolean getMostrarFK_IdEmpresaDetalleActivoFijo() {
		return this.mostrarFK_IdEmpresaDetalleActivoFijo;
	}

	public void setMostrarFK_IdEmpresaDetalleActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoActivoFijoDetalleActivoFijo=true;

	public Boolean getMostrarFK_IdEstadoActivoFijoDetalleActivoFijo() {
		return this.mostrarFK_IdEstadoActivoFijoDetalleActivoFijo;
	}

	public void setMostrarFK_IdEstadoActivoFijoDetalleActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoActivoFijoDetalleActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPartidaPresuDetalleActivoFijo=true;

	public Boolean getMostrarFK_IdPartidaPresuDetalleActivoFijo() {
		return this.mostrarFK_IdPartidaPresuDetalleActivoFijo;
	}

	public void setMostrarFK_IdPartidaPresuDetalleActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPartidaPresuDetalleActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSubGrupoActivoFijoDetalleActivoFijo=true;

	public Boolean getMostrarFK_IdSubGrupoActivoFijoDetalleActivoFijo() {
		return this.mostrarFK_IdSubGrupoActivoFijoDetalleActivoFijo;
	}

	public void setMostrarFK_IdSubGrupoActivoFijoDetalleActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSubGrupoActivoFijoDetalleActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleActivoFijo=true;

	public Boolean getMostrarFK_IdSucursalDetalleActivoFijo() {
		return this.mostrarFK_IdSucursalDetalleActivoFijo;
	}

	public void setMostrarFK_IdSucursalDetalleActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoActivoFijoEmpresaDetalleActivoFijo=true;

	public Boolean getMostrarFK_IdTipoActivoFijoEmpresaDetalleActivoFijo() {
		return this.mostrarFK_IdTipoActivoFijoEmpresaDetalleActivoFijo;
	}

	public void setMostrarFK_IdTipoActivoFijoEmpresaDetalleActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoActivoFijoEmpresaDetalleActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoDepreciacionEmpresaDetalleActivoFijo=true;

	public Boolean getMostrarFK_IdTipoDepreciacionEmpresaDetalleActivoFijo() {
		return this.mostrarFK_IdTipoDepreciacionEmpresaDetalleActivoFijo;
	}

	public void setMostrarFK_IdTipoDepreciacionEmpresaDetalleActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoDepreciacionEmpresaDetalleActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoRamoActivoFijoDetalleActivoFijo=true;

	public Boolean getMostrarFK_IdTipoRamoActivoFijoDetalleActivoFijo() {
		return this.mostrarFK_IdTipoRamoActivoFijoDetalleActivoFijo;
	}

	public void setMostrarFK_IdTipoRamoActivoFijoDetalleActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoRamoActivoFijoDetalleActivoFijo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteDetalleActivoFijo=true;

	public Boolean getActivarFK_IdClienteDetalleActivoFijo() {
		return this.activarFK_IdClienteDetalleActivoFijo;
	}

	public void setActivarFK_IdClienteDetalleActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdClienteDetalleActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdDetalleGrupoActivoFijoDetalleActivoFijo=true;

	public Boolean getActivarFK_IdDetalleGrupoActivoFijoDetalleActivoFijo() {
		return this.activarFK_IdDetalleGrupoActivoFijoDetalleActivoFijo;
	}

	public void setActivarFK_IdDetalleGrupoActivoFijoDetalleActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdDetalleGrupoActivoFijoDetalleActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleActivoFijo=true;

	public Boolean getActivarFK_IdEmpresaDetalleActivoFijo() {
		return this.activarFK_IdEmpresaDetalleActivoFijo;
	}

	public void setActivarFK_IdEmpresaDetalleActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoActivoFijoDetalleActivoFijo=true;

	public Boolean getActivarFK_IdEstadoActivoFijoDetalleActivoFijo() {
		return this.activarFK_IdEstadoActivoFijoDetalleActivoFijo;
	}

	public void setActivarFK_IdEstadoActivoFijoDetalleActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoActivoFijoDetalleActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdPartidaPresuDetalleActivoFijo=true;

	public Boolean getActivarFK_IdPartidaPresuDetalleActivoFijo() {
		return this.activarFK_IdPartidaPresuDetalleActivoFijo;
	}

	public void setActivarFK_IdPartidaPresuDetalleActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdPartidaPresuDetalleActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdSubGrupoActivoFijoDetalleActivoFijo=true;

	public Boolean getActivarFK_IdSubGrupoActivoFijoDetalleActivoFijo() {
		return this.activarFK_IdSubGrupoActivoFijoDetalleActivoFijo;
	}

	public void setActivarFK_IdSubGrupoActivoFijoDetalleActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdSubGrupoActivoFijoDetalleActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleActivoFijo=true;

	public Boolean getActivarFK_IdSucursalDetalleActivoFijo() {
		return this.activarFK_IdSucursalDetalleActivoFijo;
	}

	public void setActivarFK_IdSucursalDetalleActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoActivoFijoEmpresaDetalleActivoFijo=true;

	public Boolean getActivarFK_IdTipoActivoFijoEmpresaDetalleActivoFijo() {
		return this.activarFK_IdTipoActivoFijoEmpresaDetalleActivoFijo;
	}

	public void setActivarFK_IdTipoActivoFijoEmpresaDetalleActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdTipoActivoFijoEmpresaDetalleActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoDepreciacionEmpresaDetalleActivoFijo=true;

	public Boolean getActivarFK_IdTipoDepreciacionEmpresaDetalleActivoFijo() {
		return this.activarFK_IdTipoDepreciacionEmpresaDetalleActivoFijo;
	}

	public void setActivarFK_IdTipoDepreciacionEmpresaDetalleActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdTipoDepreciacionEmpresaDetalleActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoRamoActivoFijoDetalleActivoFijo=true;

	public Boolean getActivarFK_IdTipoRamoActivoFijoDetalleActivoFijo() {
		return this.activarFK_IdTipoRamoActivoFijoDetalleActivoFijo;
	}

	public void setActivarFK_IdTipoRamoActivoFijoDetalleActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdTipoRamoActivoFijoDetalleActivoFijo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteDetalleActivoFijo=null;

	public Border getResaltarFK_IdClienteDetalleActivoFijo() {
		return this.resaltarFK_IdClienteDetalleActivoFijo;
	}

	public void setResaltarFK_IdClienteDetalleActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdClienteDetalleActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdClienteDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteDetalleActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdDetalleGrupoActivoFijoDetalleActivoFijo=null;

	public Border getResaltarFK_IdDetalleGrupoActivoFijoDetalleActivoFijo() {
		return this.resaltarFK_IdDetalleGrupoActivoFijoDetalleActivoFijo;
	}

	public void setResaltarFK_IdDetalleGrupoActivoFijoDetalleActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdDetalleGrupoActivoFijoDetalleActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdDetalleGrupoActivoFijoDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDetalleGrupoActivoFijoDetalleActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleActivoFijo=null;

	public Border getResaltarFK_IdEmpresaDetalleActivoFijo() {
		return this.resaltarFK_IdEmpresaDetalleActivoFijo;
	}

	public void setResaltarFK_IdEmpresaDetalleActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdEstadoActivoFijoDetalleActivoFijo=null;

	public Border getResaltarFK_IdEstadoActivoFijoDetalleActivoFijo() {
		return this.resaltarFK_IdEstadoActivoFijoDetalleActivoFijo;
	}

	public void setResaltarFK_IdEstadoActivoFijoDetalleActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdEstadoActivoFijoDetalleActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdEstadoActivoFijoDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoActivoFijoDetalleActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdPartidaPresuDetalleActivoFijo=null;

	public Border getResaltarFK_IdPartidaPresuDetalleActivoFijo() {
		return this.resaltarFK_IdPartidaPresuDetalleActivoFijo;
	}

	public void setResaltarFK_IdPartidaPresuDetalleActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdPartidaPresuDetalleActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdPartidaPresuDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPartidaPresuDetalleActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdSubGrupoActivoFijoDetalleActivoFijo=null;

	public Border getResaltarFK_IdSubGrupoActivoFijoDetalleActivoFijo() {
		return this.resaltarFK_IdSubGrupoActivoFijoDetalleActivoFijo;
	}

	public void setResaltarFK_IdSubGrupoActivoFijoDetalleActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdSubGrupoActivoFijoDetalleActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdSubGrupoActivoFijoDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSubGrupoActivoFijoDetalleActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleActivoFijo=null;

	public Border getResaltarFK_IdSucursalDetalleActivoFijo() {
		return this.resaltarFK_IdSucursalDetalleActivoFijo;
	}

	public void setResaltarFK_IdSucursalDetalleActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdTipoActivoFijoEmpresaDetalleActivoFijo=null;

	public Border getResaltarFK_IdTipoActivoFijoEmpresaDetalleActivoFijo() {
		return this.resaltarFK_IdTipoActivoFijoEmpresaDetalleActivoFijo;
	}

	public void setResaltarFK_IdTipoActivoFijoEmpresaDetalleActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdTipoActivoFijoEmpresaDetalleActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdTipoActivoFijoEmpresaDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoActivoFijoEmpresaDetalleActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdTipoDepreciacionEmpresaDetalleActivoFijo=null;

	public Border getResaltarFK_IdTipoDepreciacionEmpresaDetalleActivoFijo() {
		return this.resaltarFK_IdTipoDepreciacionEmpresaDetalleActivoFijo;
	}

	public void setResaltarFK_IdTipoDepreciacionEmpresaDetalleActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdTipoDepreciacionEmpresaDetalleActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdTipoDepreciacionEmpresaDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoDepreciacionEmpresaDetalleActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdTipoRamoActivoFijoDetalleActivoFijo=null;

	public Border getResaltarFK_IdTipoRamoActivoFijoDetalleActivoFijo() {
		return this.resaltarFK_IdTipoRamoActivoFijoDetalleActivoFijo;
	}

	public void setResaltarFK_IdTipoRamoActivoFijoDetalleActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdTipoRamoActivoFijoDetalleActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdTipoRamoActivoFijoDetalleActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleActivoFijoBeanSwingJInternalFrame detalleactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoRamoActivoFijoDetalleActivoFijo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}