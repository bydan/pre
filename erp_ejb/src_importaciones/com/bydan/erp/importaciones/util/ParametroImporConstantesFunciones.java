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
package com.bydan.erp.importaciones.util;

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


import com.bydan.erp.importaciones.util.ParametroImporConstantesFunciones;
import com.bydan.erp.importaciones.util.ParametroImporParameterReturnGeneral;
//import com.bydan.erp.importaciones.util.ParametroImporParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.importaciones.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.importaciones.business.dataaccess.*;
//import com.bydan.erp.importaciones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ParametroImporConstantesFunciones extends ParametroImporConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ParametroImpor";
	public static final String SPATHOPCION="Importaciones";	
	public static final String SPATHMODULO="importaciones/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ParametroImpor"+ParametroImporConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParametroImporHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParametroImporHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParametroImporConstantesFunciones.SCHEMA+"_"+ParametroImporConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParametroImporHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParametroImporConstantesFunciones.SCHEMA+"_"+ParametroImporConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParametroImporConstantesFunciones.SCHEMA+"_"+ParametroImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParametroImporHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParametroImporConstantesFunciones.SCHEMA+"_"+ParametroImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroImporConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroImporHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroImporConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroImporHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParametroImporConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParametroImporConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParametroImporConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParametroImporConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parametro Impores";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Parametro Impor";
	public static final String SCLASSWEBTITULO_LOWER="Parametro Impor";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ParametroImpor";
	public static final String OBJECTNAME="parametroimpor";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_IMPORTACIONES;	
	public static final String TABLENAME="parametro_impor";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parametroimpor from "+ParametroImporConstantesFunciones.SPERSISTENCENAME+" parametroimpor";
	public static String QUERYSELECTNATIVE="select "+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".id,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".version_row,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".id_empresa,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".id_pais,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".id_bodega,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".id_centro_costo,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".id_cuenta_contable,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".id_transaccion_orden_compra,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".id_transaccion_ingreso,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".id_formato_orden_compra,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".id_formato_ingreso,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".id_formato_pedido,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".id_formato_liquidacion,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".dias_llega_bodega,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".porcentaje_seguro,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".fodin,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".corpei,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".con_secuencial,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".secuencial,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".con_peso_precio,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".con_lote,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".con_unidad,"+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME+".con_conversion from "+ParametroImporConstantesFunciones.SCHEMA+"."+ParametroImporConstantesFunciones.TABLENAME;//+" as "+ParametroImporConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParametroImporConstantesFuncionesAdditional parametroimporConstantesFuncionesAdditional=null;
	
	public ParametroImporConstantesFuncionesAdditional getParametroImporConstantesFuncionesAdditional() {
		return this.parametroimporConstantesFuncionesAdditional;
	}
	
	public void setParametroImporConstantesFuncionesAdditional(ParametroImporConstantesFuncionesAdditional parametroimporConstantesFuncionesAdditional) {
		try {
			this.parametroimporConstantesFuncionesAdditional=parametroimporConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDPAIS= "id_pais";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String IDTRANSACCIONORDENCOMPRA= "id_transaccion_orden_compra";
    public static final String IDTRANSACCIONINGRESO= "id_transaccion_ingreso";
    public static final String IDFORMATOORDENCOMPRA= "id_formato_orden_compra";
    public static final String IDFORMATOINGRESO= "id_formato_ingreso";
    public static final String IDFORMATOPEDIDO= "id_formato_pedido";
    public static final String IDFORMATOLIQUIDACION= "id_formato_liquidacion";
    public static final String DIASLLEGABODEGA= "dias_llega_bodega";
    public static final String PORCENTAJESEGURO= "porcentaje_seguro";
    public static final String FODIN= "fodin";
    public static final String CORPEI= "corpei";
    public static final String CONSECUENCIAL= "con_secuencial";
    public static final String SECUENCIAL= "secuencial";
    public static final String CONPESOPRECIO= "con_peso_precio";
    public static final String CONLOTE= "con_lote";
    public static final String CONUNIDAD= "con_unidad";
    public static final String CONCONVERSION= "con_conversion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_IDTRANSACCIONORDENCOMPRA= "Transaccion Orden Compra";
		public static final String LABEL_IDTRANSACCIONORDENCOMPRA_LOWER= "Transaccion Orden Compra";
    	public static final String LABEL_IDTRANSACCIONINGRESO= "Transaccion Ingreso";
		public static final String LABEL_IDTRANSACCIONINGRESO_LOWER= "Transaccion Ingreso";
    	public static final String LABEL_IDFORMATOORDENCOMPRA= "Formato Orden Compra";
		public static final String LABEL_IDFORMATOORDENCOMPRA_LOWER= "Formato Orden Compra";
    	public static final String LABEL_IDFORMATOINGRESO= "Formato Ingreso";
		public static final String LABEL_IDFORMATOINGRESO_LOWER= "Formato Ingreso";
    	public static final String LABEL_IDFORMATOPEDIDO= "Formato Pedo";
		public static final String LABEL_IDFORMATOPEDIDO_LOWER= "Formato Pedido";
    	public static final String LABEL_IDFORMATOLIQUIDACION= "Formato Liquacion";
		public static final String LABEL_IDFORMATOLIQUIDACION_LOWER= "Formato Liquidacion";
    	public static final String LABEL_DIASLLEGABODEGA= "Dias Llega Bodega";
		public static final String LABEL_DIASLLEGABODEGA_LOWER= "Dias Llega Bodega";
    	public static final String LABEL_PORCENTAJESEGURO= "Porcentaje Seguro";
		public static final String LABEL_PORCENTAJESEGURO_LOWER= "Porcentaje Seguro";
    	public static final String LABEL_FODIN= "Fodin";
		public static final String LABEL_FODIN_LOWER= "Fodin";
    	public static final String LABEL_CORPEI= "Corpei";
		public static final String LABEL_CORPEI_LOWER= "Corpei";
    	public static final String LABEL_CONSECUENCIAL= "Con Secuencial";
		public static final String LABEL_CONSECUENCIAL_LOWER= "Con Secuencial";
    	public static final String LABEL_SECUENCIAL= "Secuencial";
		public static final String LABEL_SECUENCIAL_LOWER= "Secuencial";
    	public static final String LABEL_CONPESOPRECIO= "Con Peso Precio";
		public static final String LABEL_CONPESOPRECIO_LOWER= "Con Peso Precio";
    	public static final String LABEL_CONLOTE= "Con Lote";
		public static final String LABEL_CONLOTE_LOWER= "Con Lote";
    	public static final String LABEL_CONUNIDAD= "Con Unad";
		public static final String LABEL_CONUNIDAD_LOWER= "Con Unidad";
    	public static final String LABEL_CONCONVERSION= "Con Conversion";
		public static final String LABEL_CONCONVERSION_LOWER= "Con Conversion";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXSECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	
	public static String getParametroImporLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParametroImporConstantesFunciones.IDEMPRESA)) {sLabelColumna=ParametroImporConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ParametroImporConstantesFunciones.IDPAIS)) {sLabelColumna=ParametroImporConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(ParametroImporConstantesFunciones.IDBODEGA)) {sLabelColumna=ParametroImporConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ParametroImporConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=ParametroImporConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(ParametroImporConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=ParametroImporConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(ParametroImporConstantesFunciones.IDTRANSACCIONORDENCOMPRA)) {sLabelColumna=ParametroImporConstantesFunciones.LABEL_IDTRANSACCIONORDENCOMPRA;}
		if(sNombreColumna.equals(ParametroImporConstantesFunciones.IDTRANSACCIONINGRESO)) {sLabelColumna=ParametroImporConstantesFunciones.LABEL_IDTRANSACCIONINGRESO;}
		if(sNombreColumna.equals(ParametroImporConstantesFunciones.IDFORMATOORDENCOMPRA)) {sLabelColumna=ParametroImporConstantesFunciones.LABEL_IDFORMATOORDENCOMPRA;}
		if(sNombreColumna.equals(ParametroImporConstantesFunciones.IDFORMATOINGRESO)) {sLabelColumna=ParametroImporConstantesFunciones.LABEL_IDFORMATOINGRESO;}
		if(sNombreColumna.equals(ParametroImporConstantesFunciones.IDFORMATOPEDIDO)) {sLabelColumna=ParametroImporConstantesFunciones.LABEL_IDFORMATOPEDIDO;}
		if(sNombreColumna.equals(ParametroImporConstantesFunciones.IDFORMATOLIQUIDACION)) {sLabelColumna=ParametroImporConstantesFunciones.LABEL_IDFORMATOLIQUIDACION;}
		if(sNombreColumna.equals(ParametroImporConstantesFunciones.DIASLLEGABODEGA)) {sLabelColumna=ParametroImporConstantesFunciones.LABEL_DIASLLEGABODEGA;}
		if(sNombreColumna.equals(ParametroImporConstantesFunciones.PORCENTAJESEGURO)) {sLabelColumna=ParametroImporConstantesFunciones.LABEL_PORCENTAJESEGURO;}
		if(sNombreColumna.equals(ParametroImporConstantesFunciones.FODIN)) {sLabelColumna=ParametroImporConstantesFunciones.LABEL_FODIN;}
		if(sNombreColumna.equals(ParametroImporConstantesFunciones.CORPEI)) {sLabelColumna=ParametroImporConstantesFunciones.LABEL_CORPEI;}
		if(sNombreColumna.equals(ParametroImporConstantesFunciones.CONSECUENCIAL)) {sLabelColumna=ParametroImporConstantesFunciones.LABEL_CONSECUENCIAL;}
		if(sNombreColumna.equals(ParametroImporConstantesFunciones.SECUENCIAL)) {sLabelColumna=ParametroImporConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(ParametroImporConstantesFunciones.CONPESOPRECIO)) {sLabelColumna=ParametroImporConstantesFunciones.LABEL_CONPESOPRECIO;}
		if(sNombreColumna.equals(ParametroImporConstantesFunciones.CONLOTE)) {sLabelColumna=ParametroImporConstantesFunciones.LABEL_CONLOTE;}
		if(sNombreColumna.equals(ParametroImporConstantesFunciones.CONUNIDAD)) {sLabelColumna=ParametroImporConstantesFunciones.LABEL_CONUNIDAD;}
		if(sNombreColumna.equals(ParametroImporConstantesFunciones.CONCONVERSION)) {sLabelColumna=ParametroImporConstantesFunciones.LABEL_CONCONVERSION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getcon_secuencialDescripcion(ParametroImpor parametroimpor) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametroimpor.getcon_secuencial()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_secuencialHtmlDescripcion(ParametroImpor parametroimpor) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametroimpor.getId(),parametroimpor.getcon_secuencial());

		return sDescripcion;
	}	
			
		
	public static String getcon_peso_precioDescripcion(ParametroImpor parametroimpor) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametroimpor.getcon_peso_precio()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_peso_precioHtmlDescripcion(ParametroImpor parametroimpor) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametroimpor.getId(),parametroimpor.getcon_peso_precio());

		return sDescripcion;
	}	
		
	public static String getcon_loteDescripcion(ParametroImpor parametroimpor) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametroimpor.getcon_lote()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_loteHtmlDescripcion(ParametroImpor parametroimpor) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametroimpor.getId(),parametroimpor.getcon_lote());

		return sDescripcion;
	}	
		
	public static String getcon_unidadDescripcion(ParametroImpor parametroimpor) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametroimpor.getcon_unidad()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_unidadHtmlDescripcion(ParametroImpor parametroimpor) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametroimpor.getId(),parametroimpor.getcon_unidad());

		return sDescripcion;
	}	
		
	public static String getcon_conversionDescripcion(ParametroImpor parametroimpor) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametroimpor.getcon_conversion()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_conversionHtmlDescripcion(ParametroImpor parametroimpor) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametroimpor.getId(),parametroimpor.getcon_conversion());

		return sDescripcion;
	}	
	
	public static String getParametroImporDescripcion(ParametroImpor parametroimpor) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parametroimpor !=null/* && parametroimpor.getId()!=0*/) {
			if(parametroimpor.getId()!=null) {
				sDescripcion=parametroimpor.getId().toString();
			}//parametroimporparametroimpor.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getParametroImporDescripcionDetallado(ParametroImpor parametroimpor) {
		String sDescripcion="";
			
		sDescripcion+=ParametroImporConstantesFunciones.ID+"=";
		sDescripcion+=parametroimpor.getId().toString()+",";
		sDescripcion+=ParametroImporConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parametroimpor.getVersionRow().toString()+",";
		sDescripcion+=ParametroImporConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=parametroimpor.getid_empresa().toString()+",";
		sDescripcion+=ParametroImporConstantesFunciones.IDPAIS+"=";
		sDescripcion+=parametroimpor.getid_pais().toString()+",";
		sDescripcion+=ParametroImporConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=parametroimpor.getid_bodega().toString()+",";
		sDescripcion+=ParametroImporConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=parametroimpor.getid_centro_costo().toString()+",";
		sDescripcion+=ParametroImporConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=parametroimpor.getid_cuenta_contable().toString()+",";
		sDescripcion+=ParametroImporConstantesFunciones.IDTRANSACCIONORDENCOMPRA+"=";
		sDescripcion+=parametroimpor.getid_transaccion_orden_compra().toString()+",";
		sDescripcion+=ParametroImporConstantesFunciones.IDTRANSACCIONINGRESO+"=";
		sDescripcion+=parametroimpor.getid_transaccion_ingreso().toString()+",";
		sDescripcion+=ParametroImporConstantesFunciones.IDFORMATOORDENCOMPRA+"=";
		sDescripcion+=parametroimpor.getid_formato_orden_compra().toString()+",";
		sDescripcion+=ParametroImporConstantesFunciones.IDFORMATOINGRESO+"=";
		sDescripcion+=parametroimpor.getid_formato_ingreso().toString()+",";
		sDescripcion+=ParametroImporConstantesFunciones.IDFORMATOPEDIDO+"=";
		sDescripcion+=parametroimpor.getid_formato_pedido().toString()+",";
		sDescripcion+=ParametroImporConstantesFunciones.IDFORMATOLIQUIDACION+"=";
		sDescripcion+=parametroimpor.getid_formato_liquidacion().toString()+",";
		sDescripcion+=ParametroImporConstantesFunciones.DIASLLEGABODEGA+"=";
		sDescripcion+=parametroimpor.getdias_llega_bodega().toString()+",";
		sDescripcion+=ParametroImporConstantesFunciones.PORCENTAJESEGURO+"=";
		sDescripcion+=parametroimpor.getporcentaje_seguro().toString()+",";
		sDescripcion+=ParametroImporConstantesFunciones.FODIN+"=";
		sDescripcion+=parametroimpor.getfodin().toString()+",";
		sDescripcion+=ParametroImporConstantesFunciones.CORPEI+"=";
		sDescripcion+=parametroimpor.getcorpei().toString()+",";
		sDescripcion+=ParametroImporConstantesFunciones.CONSECUENCIAL+"=";
		sDescripcion+=parametroimpor.getcon_secuencial().toString()+",";
		sDescripcion+=ParametroImporConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=parametroimpor.getsecuencial()+",";
		sDescripcion+=ParametroImporConstantesFunciones.CONPESOPRECIO+"=";
		sDescripcion+=parametroimpor.getcon_peso_precio().toString()+",";
		sDescripcion+=ParametroImporConstantesFunciones.CONLOTE+"=";
		sDescripcion+=parametroimpor.getcon_lote().toString()+",";
		sDescripcion+=ParametroImporConstantesFunciones.CONUNIDAD+"=";
		sDescripcion+=parametroimpor.getcon_unidad().toString()+",";
		sDescripcion+=ParametroImporConstantesFunciones.CONCONVERSION+"=";
		sDescripcion+=parametroimpor.getcon_conversion().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setParametroImporDescripcion(ParametroImpor parametroimpor,String sValor) throws Exception {			
		if(parametroimpor !=null) {
			//parametroimporparametroimpor.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getBodegaDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
		}

		return sDescripcion;
	}

	public static String getCentroCostoDescripcion(CentroCosto centrocosto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(centrocosto!=null/*&&centrocosto.getId()>0*/) {
			sDescripcion=CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocosto);
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

	public static String getTransaccionOrdenCompraDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccionIngresoDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getFormatoOrdenCompraDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getFormatoIngresoDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getFormatoPedidoDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getFormatoLiquidacionDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
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
		} else if(sNombreIndice.equals("FK_IdCentroCosto")) {
			sNombreIndice="Tipo=  Por Centro Costo";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFormatoIngreso")) {
			sNombreIndice="Tipo=  Por Formato Ingreso";
		} else if(sNombreIndice.equals("FK_IdFormatoLiquacion")) {
			sNombreIndice="Tipo=  Por Formato Liquacion";
		} else if(sNombreIndice.equals("FK_IdFormatoOrdenCompra")) {
			sNombreIndice="Tipo=  Por Formato Orden Compra";
		} else if(sNombreIndice.equals("FK_IdFormatoPedo")) {
			sNombreIndice="Tipo=  Por Formato Pedo";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdTransaccionIngreso")) {
			sNombreIndice="Tipo=  Por Transaccion Ingreso";
		} else if(sNombreIndice.equals("FK_IdTransaccionOrdenCompra")) {
			sNombreIndice="Tipo=  Por Transaccion Orden Compra";
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

	public static String getDetalleIndiceFK_IdCentroCosto(Long id_centro_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_costo!=null) {sDetalleIndice+=" Codigo Unico De Centro Costo="+id_centro_costo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormatoIngreso(Long id_formato_ingreso) {
		String sDetalleIndice=" Parametros->";
		if(id_formato_ingreso!=null) {sDetalleIndice+=" Codigo Unico De Formato Ingreso="+id_formato_ingreso.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormatoLiquacion(Long id_formato_liquidacion) {
		String sDetalleIndice=" Parametros->";
		if(id_formato_liquidacion!=null) {sDetalleIndice+=" Codigo Unico De Formato Liquacion="+id_formato_liquidacion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormatoOrdenCompra(Long id_formato_orden_compra) {
		String sDetalleIndice=" Parametros->";
		if(id_formato_orden_compra!=null) {sDetalleIndice+=" Codigo Unico De Formato Orden Compra="+id_formato_orden_compra.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormatoPedo(Long id_formato_pedido) {
		String sDetalleIndice=" Parametros->";
		if(id_formato_pedido!=null) {sDetalleIndice+=" Codigo Unico De Formato Pedo="+id_formato_pedido.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionIngreso(Long id_transaccion_ingreso) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_ingreso!=null) {sDetalleIndice+=" Codigo Unico De Transaccion Ingreso="+id_transaccion_ingreso.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionOrdenCompra(Long id_transaccion_orden_compra) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_orden_compra!=null) {sDetalleIndice+=" Codigo Unico De Transaccion Orden Compra="+id_transaccion_orden_compra.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosParametroImpor(ParametroImpor parametroimpor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		parametroimpor.setsecuencial(parametroimpor.getsecuencial().trim());
	}
	
	public static void quitarEspaciosParametroImpors(List<ParametroImpor> parametroimpors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ParametroImpor parametroimpor: parametroimpors) {
			parametroimpor.setsecuencial(parametroimpor.getsecuencial().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroImpor(ParametroImpor parametroimpor,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parametroimpor.getConCambioAuxiliar()) {
			parametroimpor.setIsDeleted(parametroimpor.getIsDeletedAuxiliar());	
			parametroimpor.setIsNew(parametroimpor.getIsNewAuxiliar());	
			parametroimpor.setIsChanged(parametroimpor.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parametroimpor.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parametroimpor.setIsDeletedAuxiliar(false);	
			parametroimpor.setIsNewAuxiliar(false);	
			parametroimpor.setIsChangedAuxiliar(false);
			
			parametroimpor.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroImpors(List<ParametroImpor> parametroimpors,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ParametroImpor parametroimpor : parametroimpors) {
			if(conAsignarBase && parametroimpor.getConCambioAuxiliar()) {
				parametroimpor.setIsDeleted(parametroimpor.getIsDeletedAuxiliar());	
				parametroimpor.setIsNew(parametroimpor.getIsNewAuxiliar());	
				parametroimpor.setIsChanged(parametroimpor.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parametroimpor.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parametroimpor.setIsDeletedAuxiliar(false);	
				parametroimpor.setIsNewAuxiliar(false);	
				parametroimpor.setIsChangedAuxiliar(false);
				
				parametroimpor.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParametroImpor(ParametroImpor parametroimpor,Boolean conEnteros) throws Exception  {
		parametroimpor.setporcentaje_seguro(0.0);
		parametroimpor.setfodin(0.0);
		parametroimpor.setcorpei(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			parametroimpor.setdias_llega_bodega(0);
		}
	}		
	
	public static void InicializarValoresParametroImpors(List<ParametroImpor> parametroimpors,Boolean conEnteros) throws Exception  {
		
		for(ParametroImpor parametroimpor: parametroimpors) {
			parametroimpor.setporcentaje_seguro(0.0);
			parametroimpor.setfodin(0.0);
			parametroimpor.setcorpei(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				parametroimpor.setdias_llega_bodega(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaParametroImpor(List<ParametroImpor> parametroimpors,ParametroImpor parametroimporAux) throws Exception  {
		ParametroImporConstantesFunciones.InicializarValoresParametroImpor(parametroimporAux,true);
		
		for(ParametroImpor parametroimpor: parametroimpors) {
			if(parametroimpor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			parametroimporAux.setdias_llega_bodega(parametroimporAux.getdias_llega_bodega()+parametroimpor.getdias_llega_bodega());			
			parametroimporAux.setporcentaje_seguro(parametroimporAux.getporcentaje_seguro()+parametroimpor.getporcentaje_seguro());			
			parametroimporAux.setfodin(parametroimporAux.getfodin()+parametroimpor.getfodin());			
			parametroimporAux.setcorpei(parametroimporAux.getcorpei()+parametroimpor.getcorpei());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroImpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParametroImporConstantesFunciones.getArrayColumnasGlobalesParametroImpor(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroImpor(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroImporConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroImporConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParametroImpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ParametroImpor> parametroimpors,ParametroImpor parametroimpor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ParametroImpor parametroimporAux: parametroimpors) {
			if(parametroimporAux!=null && parametroimpor!=null) {
				if((parametroimporAux.getId()==null && parametroimpor.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parametroimporAux.getId()!=null && parametroimpor.getId()!=null){
					if(parametroimporAux.getId().equals(parametroimpor.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParametroImpor(List<ParametroImpor> parametroimpors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentaje_seguroTotal=0.0;
		Double fodinTotal=0.0;
		Double corpeiTotal=0.0;
	
		for(ParametroImpor parametroimpor: parametroimpors) {			
			if(parametroimpor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentaje_seguroTotal+=parametroimpor.getporcentaje_seguro();
			fodinTotal+=parametroimpor.getfodin();
			corpeiTotal+=parametroimpor.getcorpei();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ParametroImporConstantesFunciones.PORCENTAJESEGURO);
		datoGeneral.setsDescripcion(ParametroImporConstantesFunciones.LABEL_PORCENTAJESEGURO);
		datoGeneral.setdValorDouble(porcentaje_seguroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ParametroImporConstantesFunciones.FODIN);
		datoGeneral.setsDescripcion(ParametroImporConstantesFunciones.LABEL_FODIN);
		datoGeneral.setdValorDouble(fodinTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ParametroImporConstantesFunciones.CORPEI);
		datoGeneral.setsDescripcion(ParametroImporConstantesFunciones.LABEL_CORPEI);
		datoGeneral.setdValorDouble(corpeiTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParametroImpor() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParametroImporConstantesFunciones.LABEL_ID, ParametroImporConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroImporConstantesFunciones.LABEL_VERSIONROW, ParametroImporConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroImporConstantesFunciones.LABEL_IDEMPRESA, ParametroImporConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroImporConstantesFunciones.LABEL_IDPAIS, ParametroImporConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroImporConstantesFunciones.LABEL_IDBODEGA, ParametroImporConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroImporConstantesFunciones.LABEL_IDCENTROCOSTO, ParametroImporConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroImporConstantesFunciones.LABEL_IDCUENTACONTABLE, ParametroImporConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroImporConstantesFunciones.LABEL_IDTRANSACCIONORDENCOMPRA, ParametroImporConstantesFunciones.IDTRANSACCIONORDENCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroImporConstantesFunciones.LABEL_IDTRANSACCIONINGRESO, ParametroImporConstantesFunciones.IDTRANSACCIONINGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroImporConstantesFunciones.LABEL_IDFORMATOORDENCOMPRA, ParametroImporConstantesFunciones.IDFORMATOORDENCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroImporConstantesFunciones.LABEL_IDFORMATOINGRESO, ParametroImporConstantesFunciones.IDFORMATOINGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroImporConstantesFunciones.LABEL_IDFORMATOPEDIDO, ParametroImporConstantesFunciones.IDFORMATOPEDIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroImporConstantesFunciones.LABEL_IDFORMATOLIQUIDACION, ParametroImporConstantesFunciones.IDFORMATOLIQUIDACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroImporConstantesFunciones.LABEL_DIASLLEGABODEGA, ParametroImporConstantesFunciones.DIASLLEGABODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroImporConstantesFunciones.LABEL_PORCENTAJESEGURO, ParametroImporConstantesFunciones.PORCENTAJESEGURO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroImporConstantesFunciones.LABEL_FODIN, ParametroImporConstantesFunciones.FODIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroImporConstantesFunciones.LABEL_CORPEI, ParametroImporConstantesFunciones.CORPEI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroImporConstantesFunciones.LABEL_CONSECUENCIAL, ParametroImporConstantesFunciones.CONSECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroImporConstantesFunciones.LABEL_SECUENCIAL, ParametroImporConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroImporConstantesFunciones.LABEL_CONPESOPRECIO, ParametroImporConstantesFunciones.CONPESOPRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroImporConstantesFunciones.LABEL_CONLOTE, ParametroImporConstantesFunciones.CONLOTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroImporConstantesFunciones.LABEL_CONUNIDAD, ParametroImporConstantesFunciones.CONUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroImporConstantesFunciones.LABEL_CONCONVERSION, ParametroImporConstantesFunciones.CONCONVERSION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParametroImpor() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParametroImporConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroImporConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroImporConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroImporConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroImporConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroImporConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroImporConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroImporConstantesFunciones.IDTRANSACCIONORDENCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroImporConstantesFunciones.IDTRANSACCIONINGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroImporConstantesFunciones.IDFORMATOORDENCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroImporConstantesFunciones.IDFORMATOINGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroImporConstantesFunciones.IDFORMATOPEDIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroImporConstantesFunciones.IDFORMATOLIQUIDACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroImporConstantesFunciones.DIASLLEGABODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroImporConstantesFunciones.PORCENTAJESEGURO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroImporConstantesFunciones.FODIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroImporConstantesFunciones.CORPEI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroImporConstantesFunciones.CONSECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroImporConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroImporConstantesFunciones.CONPESOPRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroImporConstantesFunciones.CONLOTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroImporConstantesFunciones.CONUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroImporConstantesFunciones.CONCONVERSION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroImpor() throws Exception  {
		return ParametroImporConstantesFunciones.getTiposSeleccionarParametroImpor(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroImpor(Boolean conFk) throws Exception  {
		return ParametroImporConstantesFunciones.getTiposSeleccionarParametroImpor(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroImpor(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroImporConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ParametroImporConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroImporConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(ParametroImporConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroImporConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ParametroImporConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroImporConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(ParametroImporConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroImporConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(ParametroImporConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroImporConstantesFunciones.LABEL_IDTRANSACCIONORDENCOMPRA);
			reporte.setsDescripcion(ParametroImporConstantesFunciones.LABEL_IDTRANSACCIONORDENCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroImporConstantesFunciones.LABEL_IDTRANSACCIONINGRESO);
			reporte.setsDescripcion(ParametroImporConstantesFunciones.LABEL_IDTRANSACCIONINGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroImporConstantesFunciones.LABEL_IDFORMATOORDENCOMPRA);
			reporte.setsDescripcion(ParametroImporConstantesFunciones.LABEL_IDFORMATOORDENCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroImporConstantesFunciones.LABEL_IDFORMATOINGRESO);
			reporte.setsDescripcion(ParametroImporConstantesFunciones.LABEL_IDFORMATOINGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroImporConstantesFunciones.LABEL_IDFORMATOPEDIDO);
			reporte.setsDescripcion(ParametroImporConstantesFunciones.LABEL_IDFORMATOPEDIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroImporConstantesFunciones.LABEL_IDFORMATOLIQUIDACION);
			reporte.setsDescripcion(ParametroImporConstantesFunciones.LABEL_IDFORMATOLIQUIDACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroImporConstantesFunciones.LABEL_DIASLLEGABODEGA);
			reporte.setsDescripcion(ParametroImporConstantesFunciones.LABEL_DIASLLEGABODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroImporConstantesFunciones.LABEL_PORCENTAJESEGURO);
			reporte.setsDescripcion(ParametroImporConstantesFunciones.LABEL_PORCENTAJESEGURO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroImporConstantesFunciones.LABEL_FODIN);
			reporte.setsDescripcion(ParametroImporConstantesFunciones.LABEL_FODIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroImporConstantesFunciones.LABEL_CORPEI);
			reporte.setsDescripcion(ParametroImporConstantesFunciones.LABEL_CORPEI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroImporConstantesFunciones.LABEL_CONSECUENCIAL);
			reporte.setsDescripcion(ParametroImporConstantesFunciones.LABEL_CONSECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroImporConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(ParametroImporConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroImporConstantesFunciones.LABEL_CONPESOPRECIO);
			reporte.setsDescripcion(ParametroImporConstantesFunciones.LABEL_CONPESOPRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroImporConstantesFunciones.LABEL_CONLOTE);
			reporte.setsDescripcion(ParametroImporConstantesFunciones.LABEL_CONLOTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroImporConstantesFunciones.LABEL_CONUNIDAD);
			reporte.setsDescripcion(ParametroImporConstantesFunciones.LABEL_CONUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroImporConstantesFunciones.LABEL_CONCONVERSION);
			reporte.setsDescripcion(ParametroImporConstantesFunciones.LABEL_CONCONVERSION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParametroImpor(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParametroImpor(ParametroImpor parametroimporAux) throws Exception {
		
			parametroimporAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametroimporAux.getEmpresa()));
			parametroimporAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(parametroimporAux.getPais()));
			parametroimporAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(parametroimporAux.getBodega()));
			parametroimporAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(parametroimporAux.getCentroCosto()));
			parametroimporAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametroimporAux.getCuentaContable()));
			parametroimporAux.settransaccionordencompra_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametroimporAux.getTransaccionOrdenCompra()));
			parametroimporAux.settransaccioningreso_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametroimporAux.getTransaccionIngreso()));
			parametroimporAux.setformatoordencompra_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametroimporAux.getFormatoOrdenCompra()));
			parametroimporAux.setformatoingreso_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametroimporAux.getFormatoIngreso()));
			parametroimporAux.setformatopedido_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametroimporAux.getFormatoPedido()));
			parametroimporAux.setformatoliquidacion_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametroimporAux.getFormatoLiquidacion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesParametroImpor(List<ParametroImpor> parametroimporsTemp) throws Exception {
		for(ParametroImpor parametroimporAux:parametroimporsTemp) {
			
			parametroimporAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametroimporAux.getEmpresa()));
			parametroimporAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(parametroimporAux.getPais()));
			parametroimporAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(parametroimporAux.getBodega()));
			parametroimporAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(parametroimporAux.getCentroCosto()));
			parametroimporAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametroimporAux.getCuentaContable()));
			parametroimporAux.settransaccionordencompra_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametroimporAux.getTransaccionOrdenCompra()));
			parametroimporAux.settransaccioningreso_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametroimporAux.getTransaccionIngreso()));
			parametroimporAux.setformatoordencompra_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametroimporAux.getFormatoOrdenCompra()));
			parametroimporAux.setformatoingreso_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametroimporAux.getFormatoIngreso()));
			parametroimporAux.setformatopedido_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametroimporAux.getFormatoPedido()));
			parametroimporAux.setformatoliquidacion_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametroimporAux.getFormatoLiquidacion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParametroImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(CentroCosto.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(Formato.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParametroImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroImporConstantesFunciones.getClassesRelationshipsOfParametroImpor(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroImporConstantesFunciones.getClassesRelationshipsFromStringsOfParametroImpor(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ParametroImpor parametroimpor,List<ParametroImpor> parametroimpors,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ParametroImpor parametroimporEncontrado=null;
			
			for(ParametroImpor parametroimporLocal:parametroimpors) {
				if(parametroimporLocal.getId().equals(parametroimpor.getId())) {
					parametroimporEncontrado=parametroimporLocal;
					
					parametroimporLocal.setIsChanged(parametroimpor.getIsChanged());
					parametroimporLocal.setIsNew(parametroimpor.getIsNew());
					parametroimporLocal.setIsDeleted(parametroimpor.getIsDeleted());
					
					parametroimporLocal.setGeneralEntityOriginal(parametroimpor.getGeneralEntityOriginal());
					
					parametroimporLocal.setId(parametroimpor.getId());	
					parametroimporLocal.setVersionRow(parametroimpor.getVersionRow());	
					parametroimporLocal.setid_empresa(parametroimpor.getid_empresa());	
					parametroimporLocal.setid_pais(parametroimpor.getid_pais());	
					parametroimporLocal.setid_bodega(parametroimpor.getid_bodega());	
					parametroimporLocal.setid_centro_costo(parametroimpor.getid_centro_costo());	
					parametroimporLocal.setid_cuenta_contable(parametroimpor.getid_cuenta_contable());	
					parametroimporLocal.setid_transaccion_orden_compra(parametroimpor.getid_transaccion_orden_compra());	
					parametroimporLocal.setid_transaccion_ingreso(parametroimpor.getid_transaccion_ingreso());	
					parametroimporLocal.setid_formato_orden_compra(parametroimpor.getid_formato_orden_compra());	
					parametroimporLocal.setid_formato_ingreso(parametroimpor.getid_formato_ingreso());	
					parametroimporLocal.setid_formato_pedido(parametroimpor.getid_formato_pedido());	
					parametroimporLocal.setid_formato_liquidacion(parametroimpor.getid_formato_liquidacion());	
					parametroimporLocal.setdias_llega_bodega(parametroimpor.getdias_llega_bodega());	
					parametroimporLocal.setporcentaje_seguro(parametroimpor.getporcentaje_seguro());	
					parametroimporLocal.setfodin(parametroimpor.getfodin());	
					parametroimporLocal.setcorpei(parametroimpor.getcorpei());	
					parametroimporLocal.setcon_secuencial(parametroimpor.getcon_secuencial());	
					parametroimporLocal.setsecuencial(parametroimpor.getsecuencial());	
					parametroimporLocal.setcon_peso_precio(parametroimpor.getcon_peso_precio());	
					parametroimporLocal.setcon_lote(parametroimpor.getcon_lote());	
					parametroimporLocal.setcon_unidad(parametroimpor.getcon_unidad());	
					parametroimporLocal.setcon_conversion(parametroimpor.getcon_conversion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!parametroimpor.getIsDeleted()) {
				if(!existe) {
					parametroimpors.add(parametroimpor);
				}
			} else {
				if(parametroimporEncontrado!=null && permiteQuitar)  {
					parametroimpors.remove(parametroimporEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ParametroImpor parametroimpor,List<ParametroImpor> parametroimpors) throws Exception {
		try	{			
			for(ParametroImpor parametroimporLocal:parametroimpors) {
				if(parametroimporLocal.getId().equals(parametroimpor.getId())) {
					parametroimporLocal.setIsSelected(parametroimpor.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParametroImpor(List<ParametroImpor> parametroimporsAux) throws Exception {
		//this.parametroimporsAux=parametroimporsAux;
		
		for(ParametroImpor parametroimporAux:parametroimporsAux) {
			if(parametroimporAux.getIsChanged()) {
				parametroimporAux.setIsChanged(false);
			}		
			
			if(parametroimporAux.getIsNew()) {
				parametroimporAux.setIsNew(false);
			}	
			
			if(parametroimporAux.getIsDeleted()) {
				parametroimporAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParametroImpor(ParametroImpor parametroimporAux) throws Exception {
		//this.parametroimporAux=parametroimporAux;
		
			if(parametroimporAux.getIsChanged()) {
				parametroimporAux.setIsChanged(false);
			}		
			
			if(parametroimporAux.getIsNew()) {
				parametroimporAux.setIsNew(false);
			}	
			
			if(parametroimporAux.getIsDeleted()) {
				parametroimporAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ParametroImpor parametroimporAsignar,ParametroImpor parametroimpor) throws Exception {
		parametroimporAsignar.setId(parametroimpor.getId());	
		parametroimporAsignar.setVersionRow(parametroimpor.getVersionRow());	
		parametroimporAsignar.setid_empresa(parametroimpor.getid_empresa());
		parametroimporAsignar.setempresa_descripcion(parametroimpor.getempresa_descripcion());	
		parametroimporAsignar.setid_pais(parametroimpor.getid_pais());
		parametroimporAsignar.setpais_descripcion(parametroimpor.getpais_descripcion());	
		parametroimporAsignar.setid_bodega(parametroimpor.getid_bodega());
		parametroimporAsignar.setbodega_descripcion(parametroimpor.getbodega_descripcion());	
		parametroimporAsignar.setid_centro_costo(parametroimpor.getid_centro_costo());
		parametroimporAsignar.setcentrocosto_descripcion(parametroimpor.getcentrocosto_descripcion());	
		parametroimporAsignar.setid_cuenta_contable(parametroimpor.getid_cuenta_contable());
		parametroimporAsignar.setcuentacontable_descripcion(parametroimpor.getcuentacontable_descripcion());	
		parametroimporAsignar.setid_transaccion_orden_compra(parametroimpor.getid_transaccion_orden_compra());
		parametroimporAsignar.settransaccionordencompra_descripcion(parametroimpor.gettransaccionordencompra_descripcion());	
		parametroimporAsignar.setid_transaccion_ingreso(parametroimpor.getid_transaccion_ingreso());
		parametroimporAsignar.settransaccioningreso_descripcion(parametroimpor.gettransaccioningreso_descripcion());	
		parametroimporAsignar.setid_formato_orden_compra(parametroimpor.getid_formato_orden_compra());
		parametroimporAsignar.setformatoordencompra_descripcion(parametroimpor.getformatoordencompra_descripcion());	
		parametroimporAsignar.setid_formato_ingreso(parametroimpor.getid_formato_ingreso());
		parametroimporAsignar.setformatoingreso_descripcion(parametroimpor.getformatoingreso_descripcion());	
		parametroimporAsignar.setid_formato_pedido(parametroimpor.getid_formato_pedido());
		parametroimporAsignar.setformatopedido_descripcion(parametroimpor.getformatopedido_descripcion());	
		parametroimporAsignar.setid_formato_liquidacion(parametroimpor.getid_formato_liquidacion());
		parametroimporAsignar.setformatoliquidacion_descripcion(parametroimpor.getformatoliquidacion_descripcion());	
		parametroimporAsignar.setdias_llega_bodega(parametroimpor.getdias_llega_bodega());	
		parametroimporAsignar.setporcentaje_seguro(parametroimpor.getporcentaje_seguro());	
		parametroimporAsignar.setfodin(parametroimpor.getfodin());	
		parametroimporAsignar.setcorpei(parametroimpor.getcorpei());	
		parametroimporAsignar.setcon_secuencial(parametroimpor.getcon_secuencial());	
		parametroimporAsignar.setsecuencial(parametroimpor.getsecuencial());	
		parametroimporAsignar.setcon_peso_precio(parametroimpor.getcon_peso_precio());	
		parametroimporAsignar.setcon_lote(parametroimpor.getcon_lote());	
		parametroimporAsignar.setcon_unidad(parametroimpor.getcon_unidad());	
		parametroimporAsignar.setcon_conversion(parametroimpor.getcon_conversion());	
	}
	
	public static void inicializarParametroImpor(ParametroImpor parametroimpor) throws Exception {
		try {
				parametroimpor.setId(0L);	
					
				parametroimpor.setid_empresa(-1L);	
				parametroimpor.setid_pais(-1L);	
				parametroimpor.setid_bodega(-1L);	
				parametroimpor.setid_centro_costo(null);	
				parametroimpor.setid_cuenta_contable(-1L);	
				parametroimpor.setid_transaccion_orden_compra(-1L);	
				parametroimpor.setid_transaccion_ingreso(-1L);	
				parametroimpor.setid_formato_orden_compra(-1L);	
				parametroimpor.setid_formato_ingreso(-1L);	
				parametroimpor.setid_formato_pedido(-1L);	
				parametroimpor.setid_formato_liquidacion(-1L);	
				parametroimpor.setdias_llega_bodega(0);	
				parametroimpor.setporcentaje_seguro(0.0);	
				parametroimpor.setfodin(0.0);	
				parametroimpor.setcorpei(0.0);	
				parametroimpor.setcon_secuencial(false);	
				parametroimpor.setsecuencial("");	
				parametroimpor.setcon_peso_precio(false);	
				parametroimpor.setcon_lote(false);	
				parametroimpor.setcon_unidad(false);	
				parametroimpor.setcon_conversion(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParametroImpor(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroImporConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroImporConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroImporConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroImporConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroImporConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroImporConstantesFunciones.LABEL_IDTRANSACCIONORDENCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroImporConstantesFunciones.LABEL_IDTRANSACCIONINGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroImporConstantesFunciones.LABEL_IDFORMATOORDENCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroImporConstantesFunciones.LABEL_IDFORMATOINGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroImporConstantesFunciones.LABEL_IDFORMATOPEDIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroImporConstantesFunciones.LABEL_IDFORMATOLIQUIDACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroImporConstantesFunciones.LABEL_DIASLLEGABODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroImporConstantesFunciones.LABEL_PORCENTAJESEGURO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroImporConstantesFunciones.LABEL_FODIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroImporConstantesFunciones.LABEL_CORPEI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroImporConstantesFunciones.LABEL_CONSECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroImporConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroImporConstantesFunciones.LABEL_CONPESOPRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroImporConstantesFunciones.LABEL_CONLOTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroImporConstantesFunciones.LABEL_CONUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroImporConstantesFunciones.LABEL_CONCONVERSION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParametroImpor(String sTipo,Row row,Workbook workbook,ParametroImpor parametroimpor,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroimpor.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroimpor.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroimpor.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroimpor.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroimpor.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroimpor.gettransaccionordencompra_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroimpor.gettransaccioningreso_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroimpor.getformatoordencompra_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroimpor.getformatoingreso_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroimpor.getformatopedido_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroimpor.getformatoliquidacion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroimpor.getdias_llega_bodega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroimpor.getporcentaje_seguro());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroimpor.getfodin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroimpor.getcorpei());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametroimpor.getcon_secuencial()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroimpor.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametroimpor.getcon_peso_precio()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametroimpor.getcon_lote()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametroimpor.getcon_unidad()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametroimpor.getcon_conversion()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParametroImpor=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParametroImpor() {
		return this.sFinalQueryParametroImpor;
	}
	
	public void setsFinalQueryParametroImpor(String sFinalQueryParametroImpor) {
		this.sFinalQueryParametroImpor= sFinalQueryParametroImpor;
	}
	
	public Border resaltarSeleccionarParametroImpor=null;
	
	public Border setResaltarSeleccionarParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parametroimporBeanSwingJInternalFrame.jTtoolBarParametroImpor.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParametroImpor= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParametroImpor() {
		return this.resaltarSeleccionarParametroImpor;
	}
	
	public void setResaltarSeleccionarParametroImpor(Border borderResaltarSeleccionarParametroImpor) {
		this.resaltarSeleccionarParametroImpor= borderResaltarSeleccionarParametroImpor;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParametroImpor=null;
	public Boolean mostraridParametroImpor=true;
	public Boolean activaridParametroImpor=true;

	public Border resaltarid_empresaParametroImpor=null;
	public Boolean mostrarid_empresaParametroImpor=true;
	public Boolean activarid_empresaParametroImpor=true;
	public Boolean cargarid_empresaParametroImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaParametroImpor=false;//ConEventDepend=true

	public Border resaltarid_paisParametroImpor=null;
	public Boolean mostrarid_paisParametroImpor=true;
	public Boolean activarid_paisParametroImpor=true;
	public Boolean cargarid_paisParametroImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisParametroImpor=false;//ConEventDepend=true

	public Border resaltarid_bodegaParametroImpor=null;
	public Boolean mostrarid_bodegaParametroImpor=true;
	public Boolean activarid_bodegaParametroImpor=true;
	public Boolean cargarid_bodegaParametroImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaParametroImpor=false;//ConEventDepend=true

	public Border resaltarid_centro_costoParametroImpor=null;
	public Boolean mostrarid_centro_costoParametroImpor=true;
	public Boolean activarid_centro_costoParametroImpor=true;
	public Boolean cargarid_centro_costoParametroImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoParametroImpor=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableParametroImpor=null;
	public Boolean mostrarid_cuenta_contableParametroImpor=true;
	public Boolean activarid_cuenta_contableParametroImpor=true;
	public Boolean cargarid_cuenta_contableParametroImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableParametroImpor=false;//ConEventDepend=true

	public Border resaltarid_transaccion_orden_compraParametroImpor=null;
	public Boolean mostrarid_transaccion_orden_compraParametroImpor=true;
	public Boolean activarid_transaccion_orden_compraParametroImpor=true;
	public Boolean cargarid_transaccion_orden_compraParametroImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_orden_compraParametroImpor=false;//ConEventDepend=true

	public Border resaltarid_transaccion_ingresoParametroImpor=null;
	public Boolean mostrarid_transaccion_ingresoParametroImpor=true;
	public Boolean activarid_transaccion_ingresoParametroImpor=true;
	public Boolean cargarid_transaccion_ingresoParametroImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_ingresoParametroImpor=false;//ConEventDepend=true

	public Border resaltarid_formato_orden_compraParametroImpor=null;
	public Boolean mostrarid_formato_orden_compraParametroImpor=true;
	public Boolean activarid_formato_orden_compraParametroImpor=true;
	public Boolean cargarid_formato_orden_compraParametroImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_orden_compraParametroImpor=false;//ConEventDepend=true

	public Border resaltarid_formato_ingresoParametroImpor=null;
	public Boolean mostrarid_formato_ingresoParametroImpor=true;
	public Boolean activarid_formato_ingresoParametroImpor=true;
	public Boolean cargarid_formato_ingresoParametroImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_ingresoParametroImpor=false;//ConEventDepend=true

	public Border resaltarid_formato_pedidoParametroImpor=null;
	public Boolean mostrarid_formato_pedidoParametroImpor=true;
	public Boolean activarid_formato_pedidoParametroImpor=true;
	public Boolean cargarid_formato_pedidoParametroImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_pedidoParametroImpor=false;//ConEventDepend=true

	public Border resaltarid_formato_liquidacionParametroImpor=null;
	public Boolean mostrarid_formato_liquidacionParametroImpor=true;
	public Boolean activarid_formato_liquidacionParametroImpor=true;
	public Boolean cargarid_formato_liquidacionParametroImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_liquidacionParametroImpor=false;//ConEventDepend=true

	public Border resaltardias_llega_bodegaParametroImpor=null;
	public Boolean mostrardias_llega_bodegaParametroImpor=true;
	public Boolean activardias_llega_bodegaParametroImpor=true;

	public Border resaltarporcentaje_seguroParametroImpor=null;
	public Boolean mostrarporcentaje_seguroParametroImpor=true;
	public Boolean activarporcentaje_seguroParametroImpor=true;

	public Border resaltarfodinParametroImpor=null;
	public Boolean mostrarfodinParametroImpor=true;
	public Boolean activarfodinParametroImpor=true;

	public Border resaltarcorpeiParametroImpor=null;
	public Boolean mostrarcorpeiParametroImpor=true;
	public Boolean activarcorpeiParametroImpor=true;

	public Border resaltarcon_secuencialParametroImpor=null;
	public Boolean mostrarcon_secuencialParametroImpor=true;
	public Boolean activarcon_secuencialParametroImpor=true;

	public Border resaltarsecuencialParametroImpor=null;
	public Boolean mostrarsecuencialParametroImpor=true;
	public Boolean activarsecuencialParametroImpor=true;

	public Border resaltarcon_peso_precioParametroImpor=null;
	public Boolean mostrarcon_peso_precioParametroImpor=true;
	public Boolean activarcon_peso_precioParametroImpor=true;

	public Border resaltarcon_loteParametroImpor=null;
	public Boolean mostrarcon_loteParametroImpor=true;
	public Boolean activarcon_loteParametroImpor=true;

	public Border resaltarcon_unidadParametroImpor=null;
	public Boolean mostrarcon_unidadParametroImpor=true;
	public Boolean activarcon_unidadParametroImpor=true;

	public Border resaltarcon_conversionParametroImpor=null;
	public Boolean mostrarcon_conversionParametroImpor=true;
	public Boolean activarcon_conversionParametroImpor=true;

	
	

	public Border setResaltaridParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroimporBeanSwingJInternalFrame.jTtoolBarParametroImpor.setBorder(borderResaltar);
		
		this.resaltaridParametroImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParametroImpor() {
		return this.resaltaridParametroImpor;
	}

	public void setResaltaridParametroImpor(Border borderResaltar) {
		this.resaltaridParametroImpor= borderResaltar;
	}

	public Boolean getMostraridParametroImpor() {
		return this.mostraridParametroImpor;
	}

	public void setMostraridParametroImpor(Boolean mostraridParametroImpor) {
		this.mostraridParametroImpor= mostraridParametroImpor;
	}

	public Boolean getActivaridParametroImpor() {
		return this.activaridParametroImpor;
	}

	public void setActivaridParametroImpor(Boolean activaridParametroImpor) {
		this.activaridParametroImpor= activaridParametroImpor;
	}

	public Border setResaltarid_empresaParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroimporBeanSwingJInternalFrame.jTtoolBarParametroImpor.setBorder(borderResaltar);
		
		this.resaltarid_empresaParametroImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaParametroImpor() {
		return this.resaltarid_empresaParametroImpor;
	}

	public void setResaltarid_empresaParametroImpor(Border borderResaltar) {
		this.resaltarid_empresaParametroImpor= borderResaltar;
	}

	public Boolean getMostrarid_empresaParametroImpor() {
		return this.mostrarid_empresaParametroImpor;
	}

	public void setMostrarid_empresaParametroImpor(Boolean mostrarid_empresaParametroImpor) {
		this.mostrarid_empresaParametroImpor= mostrarid_empresaParametroImpor;
	}

	public Boolean getActivarid_empresaParametroImpor() {
		return this.activarid_empresaParametroImpor;
	}

	public void setActivarid_empresaParametroImpor(Boolean activarid_empresaParametroImpor) {
		this.activarid_empresaParametroImpor= activarid_empresaParametroImpor;
	}

	public Boolean getCargarid_empresaParametroImpor() {
		return this.cargarid_empresaParametroImpor;
	}

	public void setCargarid_empresaParametroImpor(Boolean cargarid_empresaParametroImpor) {
		this.cargarid_empresaParametroImpor= cargarid_empresaParametroImpor;
	}

	public Border setResaltarid_paisParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroimporBeanSwingJInternalFrame.jTtoolBarParametroImpor.setBorder(borderResaltar);
		
		this.resaltarid_paisParametroImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisParametroImpor() {
		return this.resaltarid_paisParametroImpor;
	}

	public void setResaltarid_paisParametroImpor(Border borderResaltar) {
		this.resaltarid_paisParametroImpor= borderResaltar;
	}

	public Boolean getMostrarid_paisParametroImpor() {
		return this.mostrarid_paisParametroImpor;
	}

	public void setMostrarid_paisParametroImpor(Boolean mostrarid_paisParametroImpor) {
		this.mostrarid_paisParametroImpor= mostrarid_paisParametroImpor;
	}

	public Boolean getActivarid_paisParametroImpor() {
		return this.activarid_paisParametroImpor;
	}

	public void setActivarid_paisParametroImpor(Boolean activarid_paisParametroImpor) {
		this.activarid_paisParametroImpor= activarid_paisParametroImpor;
	}

	public Boolean getCargarid_paisParametroImpor() {
		return this.cargarid_paisParametroImpor;
	}

	public void setCargarid_paisParametroImpor(Boolean cargarid_paisParametroImpor) {
		this.cargarid_paisParametroImpor= cargarid_paisParametroImpor;
	}

	public Border setResaltarid_bodegaParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroimporBeanSwingJInternalFrame.jTtoolBarParametroImpor.setBorder(borderResaltar);
		
		this.resaltarid_bodegaParametroImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaParametroImpor() {
		return this.resaltarid_bodegaParametroImpor;
	}

	public void setResaltarid_bodegaParametroImpor(Border borderResaltar) {
		this.resaltarid_bodegaParametroImpor= borderResaltar;
	}

	public Boolean getMostrarid_bodegaParametroImpor() {
		return this.mostrarid_bodegaParametroImpor;
	}

	public void setMostrarid_bodegaParametroImpor(Boolean mostrarid_bodegaParametroImpor) {
		this.mostrarid_bodegaParametroImpor= mostrarid_bodegaParametroImpor;
	}

	public Boolean getActivarid_bodegaParametroImpor() {
		return this.activarid_bodegaParametroImpor;
	}

	public void setActivarid_bodegaParametroImpor(Boolean activarid_bodegaParametroImpor) {
		this.activarid_bodegaParametroImpor= activarid_bodegaParametroImpor;
	}

	public Boolean getCargarid_bodegaParametroImpor() {
		return this.cargarid_bodegaParametroImpor;
	}

	public void setCargarid_bodegaParametroImpor(Boolean cargarid_bodegaParametroImpor) {
		this.cargarid_bodegaParametroImpor= cargarid_bodegaParametroImpor;
	}

	public Border setResaltarid_centro_costoParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroimporBeanSwingJInternalFrame.jTtoolBarParametroImpor.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoParametroImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoParametroImpor() {
		return this.resaltarid_centro_costoParametroImpor;
	}

	public void setResaltarid_centro_costoParametroImpor(Border borderResaltar) {
		this.resaltarid_centro_costoParametroImpor= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoParametroImpor() {
		return this.mostrarid_centro_costoParametroImpor;
	}

	public void setMostrarid_centro_costoParametroImpor(Boolean mostrarid_centro_costoParametroImpor) {
		this.mostrarid_centro_costoParametroImpor= mostrarid_centro_costoParametroImpor;
	}

	public Boolean getActivarid_centro_costoParametroImpor() {
		return this.activarid_centro_costoParametroImpor;
	}

	public void setActivarid_centro_costoParametroImpor(Boolean activarid_centro_costoParametroImpor) {
		this.activarid_centro_costoParametroImpor= activarid_centro_costoParametroImpor;
	}

	public Boolean getCargarid_centro_costoParametroImpor() {
		return this.cargarid_centro_costoParametroImpor;
	}

	public void setCargarid_centro_costoParametroImpor(Boolean cargarid_centro_costoParametroImpor) {
		this.cargarid_centro_costoParametroImpor= cargarid_centro_costoParametroImpor;
	}

	public Border setResaltarid_cuenta_contableParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroimporBeanSwingJInternalFrame.jTtoolBarParametroImpor.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableParametroImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableParametroImpor() {
		return this.resaltarid_cuenta_contableParametroImpor;
	}

	public void setResaltarid_cuenta_contableParametroImpor(Border borderResaltar) {
		this.resaltarid_cuenta_contableParametroImpor= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableParametroImpor() {
		return this.mostrarid_cuenta_contableParametroImpor;
	}

	public void setMostrarid_cuenta_contableParametroImpor(Boolean mostrarid_cuenta_contableParametroImpor) {
		this.mostrarid_cuenta_contableParametroImpor= mostrarid_cuenta_contableParametroImpor;
	}

	public Boolean getActivarid_cuenta_contableParametroImpor() {
		return this.activarid_cuenta_contableParametroImpor;
	}

	public void setActivarid_cuenta_contableParametroImpor(Boolean activarid_cuenta_contableParametroImpor) {
		this.activarid_cuenta_contableParametroImpor= activarid_cuenta_contableParametroImpor;
	}

	public Boolean getCargarid_cuenta_contableParametroImpor() {
		return this.cargarid_cuenta_contableParametroImpor;
	}

	public void setCargarid_cuenta_contableParametroImpor(Boolean cargarid_cuenta_contableParametroImpor) {
		this.cargarid_cuenta_contableParametroImpor= cargarid_cuenta_contableParametroImpor;
	}

	public Border setResaltarid_transaccion_orden_compraParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroimporBeanSwingJInternalFrame.jTtoolBarParametroImpor.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_orden_compraParametroImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_orden_compraParametroImpor() {
		return this.resaltarid_transaccion_orden_compraParametroImpor;
	}

	public void setResaltarid_transaccion_orden_compraParametroImpor(Border borderResaltar) {
		this.resaltarid_transaccion_orden_compraParametroImpor= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_orden_compraParametroImpor() {
		return this.mostrarid_transaccion_orden_compraParametroImpor;
	}

	public void setMostrarid_transaccion_orden_compraParametroImpor(Boolean mostrarid_transaccion_orden_compraParametroImpor) {
		this.mostrarid_transaccion_orden_compraParametroImpor= mostrarid_transaccion_orden_compraParametroImpor;
	}

	public Boolean getActivarid_transaccion_orden_compraParametroImpor() {
		return this.activarid_transaccion_orden_compraParametroImpor;
	}

	public void setActivarid_transaccion_orden_compraParametroImpor(Boolean activarid_transaccion_orden_compraParametroImpor) {
		this.activarid_transaccion_orden_compraParametroImpor= activarid_transaccion_orden_compraParametroImpor;
	}

	public Boolean getCargarid_transaccion_orden_compraParametroImpor() {
		return this.cargarid_transaccion_orden_compraParametroImpor;
	}

	public void setCargarid_transaccion_orden_compraParametroImpor(Boolean cargarid_transaccion_orden_compraParametroImpor) {
		this.cargarid_transaccion_orden_compraParametroImpor= cargarid_transaccion_orden_compraParametroImpor;
	}

	public Border setResaltarid_transaccion_ingresoParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroimporBeanSwingJInternalFrame.jTtoolBarParametroImpor.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_ingresoParametroImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_ingresoParametroImpor() {
		return this.resaltarid_transaccion_ingresoParametroImpor;
	}

	public void setResaltarid_transaccion_ingresoParametroImpor(Border borderResaltar) {
		this.resaltarid_transaccion_ingresoParametroImpor= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_ingresoParametroImpor() {
		return this.mostrarid_transaccion_ingresoParametroImpor;
	}

	public void setMostrarid_transaccion_ingresoParametroImpor(Boolean mostrarid_transaccion_ingresoParametroImpor) {
		this.mostrarid_transaccion_ingresoParametroImpor= mostrarid_transaccion_ingresoParametroImpor;
	}

	public Boolean getActivarid_transaccion_ingresoParametroImpor() {
		return this.activarid_transaccion_ingresoParametroImpor;
	}

	public void setActivarid_transaccion_ingresoParametroImpor(Boolean activarid_transaccion_ingresoParametroImpor) {
		this.activarid_transaccion_ingresoParametroImpor= activarid_transaccion_ingresoParametroImpor;
	}

	public Boolean getCargarid_transaccion_ingresoParametroImpor() {
		return this.cargarid_transaccion_ingresoParametroImpor;
	}

	public void setCargarid_transaccion_ingresoParametroImpor(Boolean cargarid_transaccion_ingresoParametroImpor) {
		this.cargarid_transaccion_ingresoParametroImpor= cargarid_transaccion_ingresoParametroImpor;
	}

	public Border setResaltarid_formato_orden_compraParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroimporBeanSwingJInternalFrame.jTtoolBarParametroImpor.setBorder(borderResaltar);
		
		this.resaltarid_formato_orden_compraParametroImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_orden_compraParametroImpor() {
		return this.resaltarid_formato_orden_compraParametroImpor;
	}

	public void setResaltarid_formato_orden_compraParametroImpor(Border borderResaltar) {
		this.resaltarid_formato_orden_compraParametroImpor= borderResaltar;
	}

	public Boolean getMostrarid_formato_orden_compraParametroImpor() {
		return this.mostrarid_formato_orden_compraParametroImpor;
	}

	public void setMostrarid_formato_orden_compraParametroImpor(Boolean mostrarid_formato_orden_compraParametroImpor) {
		this.mostrarid_formato_orden_compraParametroImpor= mostrarid_formato_orden_compraParametroImpor;
	}

	public Boolean getActivarid_formato_orden_compraParametroImpor() {
		return this.activarid_formato_orden_compraParametroImpor;
	}

	public void setActivarid_formato_orden_compraParametroImpor(Boolean activarid_formato_orden_compraParametroImpor) {
		this.activarid_formato_orden_compraParametroImpor= activarid_formato_orden_compraParametroImpor;
	}

	public Boolean getCargarid_formato_orden_compraParametroImpor() {
		return this.cargarid_formato_orden_compraParametroImpor;
	}

	public void setCargarid_formato_orden_compraParametroImpor(Boolean cargarid_formato_orden_compraParametroImpor) {
		this.cargarid_formato_orden_compraParametroImpor= cargarid_formato_orden_compraParametroImpor;
	}

	public Border setResaltarid_formato_ingresoParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroimporBeanSwingJInternalFrame.jTtoolBarParametroImpor.setBorder(borderResaltar);
		
		this.resaltarid_formato_ingresoParametroImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_ingresoParametroImpor() {
		return this.resaltarid_formato_ingresoParametroImpor;
	}

	public void setResaltarid_formato_ingresoParametroImpor(Border borderResaltar) {
		this.resaltarid_formato_ingresoParametroImpor= borderResaltar;
	}

	public Boolean getMostrarid_formato_ingresoParametroImpor() {
		return this.mostrarid_formato_ingresoParametroImpor;
	}

	public void setMostrarid_formato_ingresoParametroImpor(Boolean mostrarid_formato_ingresoParametroImpor) {
		this.mostrarid_formato_ingresoParametroImpor= mostrarid_formato_ingresoParametroImpor;
	}

	public Boolean getActivarid_formato_ingresoParametroImpor() {
		return this.activarid_formato_ingresoParametroImpor;
	}

	public void setActivarid_formato_ingresoParametroImpor(Boolean activarid_formato_ingresoParametroImpor) {
		this.activarid_formato_ingresoParametroImpor= activarid_formato_ingresoParametroImpor;
	}

	public Boolean getCargarid_formato_ingresoParametroImpor() {
		return this.cargarid_formato_ingresoParametroImpor;
	}

	public void setCargarid_formato_ingresoParametroImpor(Boolean cargarid_formato_ingresoParametroImpor) {
		this.cargarid_formato_ingresoParametroImpor= cargarid_formato_ingresoParametroImpor;
	}

	public Border setResaltarid_formato_pedidoParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroimporBeanSwingJInternalFrame.jTtoolBarParametroImpor.setBorder(borderResaltar);
		
		this.resaltarid_formato_pedidoParametroImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_pedidoParametroImpor() {
		return this.resaltarid_formato_pedidoParametroImpor;
	}

	public void setResaltarid_formato_pedidoParametroImpor(Border borderResaltar) {
		this.resaltarid_formato_pedidoParametroImpor= borderResaltar;
	}

	public Boolean getMostrarid_formato_pedidoParametroImpor() {
		return this.mostrarid_formato_pedidoParametroImpor;
	}

	public void setMostrarid_formato_pedidoParametroImpor(Boolean mostrarid_formato_pedidoParametroImpor) {
		this.mostrarid_formato_pedidoParametroImpor= mostrarid_formato_pedidoParametroImpor;
	}

	public Boolean getActivarid_formato_pedidoParametroImpor() {
		return this.activarid_formato_pedidoParametroImpor;
	}

	public void setActivarid_formato_pedidoParametroImpor(Boolean activarid_formato_pedidoParametroImpor) {
		this.activarid_formato_pedidoParametroImpor= activarid_formato_pedidoParametroImpor;
	}

	public Boolean getCargarid_formato_pedidoParametroImpor() {
		return this.cargarid_formato_pedidoParametroImpor;
	}

	public void setCargarid_formato_pedidoParametroImpor(Boolean cargarid_formato_pedidoParametroImpor) {
		this.cargarid_formato_pedidoParametroImpor= cargarid_formato_pedidoParametroImpor;
	}

	public Border setResaltarid_formato_liquidacionParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroimporBeanSwingJInternalFrame.jTtoolBarParametroImpor.setBorder(borderResaltar);
		
		this.resaltarid_formato_liquidacionParametroImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_liquidacionParametroImpor() {
		return this.resaltarid_formato_liquidacionParametroImpor;
	}

	public void setResaltarid_formato_liquidacionParametroImpor(Border borderResaltar) {
		this.resaltarid_formato_liquidacionParametroImpor= borderResaltar;
	}

	public Boolean getMostrarid_formato_liquidacionParametroImpor() {
		return this.mostrarid_formato_liquidacionParametroImpor;
	}

	public void setMostrarid_formato_liquidacionParametroImpor(Boolean mostrarid_formato_liquidacionParametroImpor) {
		this.mostrarid_formato_liquidacionParametroImpor= mostrarid_formato_liquidacionParametroImpor;
	}

	public Boolean getActivarid_formato_liquidacionParametroImpor() {
		return this.activarid_formato_liquidacionParametroImpor;
	}

	public void setActivarid_formato_liquidacionParametroImpor(Boolean activarid_formato_liquidacionParametroImpor) {
		this.activarid_formato_liquidacionParametroImpor= activarid_formato_liquidacionParametroImpor;
	}

	public Boolean getCargarid_formato_liquidacionParametroImpor() {
		return this.cargarid_formato_liquidacionParametroImpor;
	}

	public void setCargarid_formato_liquidacionParametroImpor(Boolean cargarid_formato_liquidacionParametroImpor) {
		this.cargarid_formato_liquidacionParametroImpor= cargarid_formato_liquidacionParametroImpor;
	}

	public Border setResaltardias_llega_bodegaParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroimporBeanSwingJInternalFrame.jTtoolBarParametroImpor.setBorder(borderResaltar);
		
		this.resaltardias_llega_bodegaParametroImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardias_llega_bodegaParametroImpor() {
		return this.resaltardias_llega_bodegaParametroImpor;
	}

	public void setResaltardias_llega_bodegaParametroImpor(Border borderResaltar) {
		this.resaltardias_llega_bodegaParametroImpor= borderResaltar;
	}

	public Boolean getMostrardias_llega_bodegaParametroImpor() {
		return this.mostrardias_llega_bodegaParametroImpor;
	}

	public void setMostrardias_llega_bodegaParametroImpor(Boolean mostrardias_llega_bodegaParametroImpor) {
		this.mostrardias_llega_bodegaParametroImpor= mostrardias_llega_bodegaParametroImpor;
	}

	public Boolean getActivardias_llega_bodegaParametroImpor() {
		return this.activardias_llega_bodegaParametroImpor;
	}

	public void setActivardias_llega_bodegaParametroImpor(Boolean activardias_llega_bodegaParametroImpor) {
		this.activardias_llega_bodegaParametroImpor= activardias_llega_bodegaParametroImpor;
	}

	public Border setResaltarporcentaje_seguroParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroimporBeanSwingJInternalFrame.jTtoolBarParametroImpor.setBorder(borderResaltar);
		
		this.resaltarporcentaje_seguroParametroImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_seguroParametroImpor() {
		return this.resaltarporcentaje_seguroParametroImpor;
	}

	public void setResaltarporcentaje_seguroParametroImpor(Border borderResaltar) {
		this.resaltarporcentaje_seguroParametroImpor= borderResaltar;
	}

	public Boolean getMostrarporcentaje_seguroParametroImpor() {
		return this.mostrarporcentaje_seguroParametroImpor;
	}

	public void setMostrarporcentaje_seguroParametroImpor(Boolean mostrarporcentaje_seguroParametroImpor) {
		this.mostrarporcentaje_seguroParametroImpor= mostrarporcentaje_seguroParametroImpor;
	}

	public Boolean getActivarporcentaje_seguroParametroImpor() {
		return this.activarporcentaje_seguroParametroImpor;
	}

	public void setActivarporcentaje_seguroParametroImpor(Boolean activarporcentaje_seguroParametroImpor) {
		this.activarporcentaje_seguroParametroImpor= activarporcentaje_seguroParametroImpor;
	}

	public Border setResaltarfodinParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroimporBeanSwingJInternalFrame.jTtoolBarParametroImpor.setBorder(borderResaltar);
		
		this.resaltarfodinParametroImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfodinParametroImpor() {
		return this.resaltarfodinParametroImpor;
	}

	public void setResaltarfodinParametroImpor(Border borderResaltar) {
		this.resaltarfodinParametroImpor= borderResaltar;
	}

	public Boolean getMostrarfodinParametroImpor() {
		return this.mostrarfodinParametroImpor;
	}

	public void setMostrarfodinParametroImpor(Boolean mostrarfodinParametroImpor) {
		this.mostrarfodinParametroImpor= mostrarfodinParametroImpor;
	}

	public Boolean getActivarfodinParametroImpor() {
		return this.activarfodinParametroImpor;
	}

	public void setActivarfodinParametroImpor(Boolean activarfodinParametroImpor) {
		this.activarfodinParametroImpor= activarfodinParametroImpor;
	}

	public Border setResaltarcorpeiParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroimporBeanSwingJInternalFrame.jTtoolBarParametroImpor.setBorder(borderResaltar);
		
		this.resaltarcorpeiParametroImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcorpeiParametroImpor() {
		return this.resaltarcorpeiParametroImpor;
	}

	public void setResaltarcorpeiParametroImpor(Border borderResaltar) {
		this.resaltarcorpeiParametroImpor= borderResaltar;
	}

	public Boolean getMostrarcorpeiParametroImpor() {
		return this.mostrarcorpeiParametroImpor;
	}

	public void setMostrarcorpeiParametroImpor(Boolean mostrarcorpeiParametroImpor) {
		this.mostrarcorpeiParametroImpor= mostrarcorpeiParametroImpor;
	}

	public Boolean getActivarcorpeiParametroImpor() {
		return this.activarcorpeiParametroImpor;
	}

	public void setActivarcorpeiParametroImpor(Boolean activarcorpeiParametroImpor) {
		this.activarcorpeiParametroImpor= activarcorpeiParametroImpor;
	}

	public Border setResaltarcon_secuencialParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroimporBeanSwingJInternalFrame.jTtoolBarParametroImpor.setBorder(borderResaltar);
		
		this.resaltarcon_secuencialParametroImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_secuencialParametroImpor() {
		return this.resaltarcon_secuencialParametroImpor;
	}

	public void setResaltarcon_secuencialParametroImpor(Border borderResaltar) {
		this.resaltarcon_secuencialParametroImpor= borderResaltar;
	}

	public Boolean getMostrarcon_secuencialParametroImpor() {
		return this.mostrarcon_secuencialParametroImpor;
	}

	public void setMostrarcon_secuencialParametroImpor(Boolean mostrarcon_secuencialParametroImpor) {
		this.mostrarcon_secuencialParametroImpor= mostrarcon_secuencialParametroImpor;
	}

	public Boolean getActivarcon_secuencialParametroImpor() {
		return this.activarcon_secuencialParametroImpor;
	}

	public void setActivarcon_secuencialParametroImpor(Boolean activarcon_secuencialParametroImpor) {
		this.activarcon_secuencialParametroImpor= activarcon_secuencialParametroImpor;
	}

	public Border setResaltarsecuencialParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroimporBeanSwingJInternalFrame.jTtoolBarParametroImpor.setBorder(borderResaltar);
		
		this.resaltarsecuencialParametroImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialParametroImpor() {
		return this.resaltarsecuencialParametroImpor;
	}

	public void setResaltarsecuencialParametroImpor(Border borderResaltar) {
		this.resaltarsecuencialParametroImpor= borderResaltar;
	}

	public Boolean getMostrarsecuencialParametroImpor() {
		return this.mostrarsecuencialParametroImpor;
	}

	public void setMostrarsecuencialParametroImpor(Boolean mostrarsecuencialParametroImpor) {
		this.mostrarsecuencialParametroImpor= mostrarsecuencialParametroImpor;
	}

	public Boolean getActivarsecuencialParametroImpor() {
		return this.activarsecuencialParametroImpor;
	}

	public void setActivarsecuencialParametroImpor(Boolean activarsecuencialParametroImpor) {
		this.activarsecuencialParametroImpor= activarsecuencialParametroImpor;
	}

	public Border setResaltarcon_peso_precioParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroimporBeanSwingJInternalFrame.jTtoolBarParametroImpor.setBorder(borderResaltar);
		
		this.resaltarcon_peso_precioParametroImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_peso_precioParametroImpor() {
		return this.resaltarcon_peso_precioParametroImpor;
	}

	public void setResaltarcon_peso_precioParametroImpor(Border borderResaltar) {
		this.resaltarcon_peso_precioParametroImpor= borderResaltar;
	}

	public Boolean getMostrarcon_peso_precioParametroImpor() {
		return this.mostrarcon_peso_precioParametroImpor;
	}

	public void setMostrarcon_peso_precioParametroImpor(Boolean mostrarcon_peso_precioParametroImpor) {
		this.mostrarcon_peso_precioParametroImpor= mostrarcon_peso_precioParametroImpor;
	}

	public Boolean getActivarcon_peso_precioParametroImpor() {
		return this.activarcon_peso_precioParametroImpor;
	}

	public void setActivarcon_peso_precioParametroImpor(Boolean activarcon_peso_precioParametroImpor) {
		this.activarcon_peso_precioParametroImpor= activarcon_peso_precioParametroImpor;
	}

	public Border setResaltarcon_loteParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroimporBeanSwingJInternalFrame.jTtoolBarParametroImpor.setBorder(borderResaltar);
		
		this.resaltarcon_loteParametroImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_loteParametroImpor() {
		return this.resaltarcon_loteParametroImpor;
	}

	public void setResaltarcon_loteParametroImpor(Border borderResaltar) {
		this.resaltarcon_loteParametroImpor= borderResaltar;
	}

	public Boolean getMostrarcon_loteParametroImpor() {
		return this.mostrarcon_loteParametroImpor;
	}

	public void setMostrarcon_loteParametroImpor(Boolean mostrarcon_loteParametroImpor) {
		this.mostrarcon_loteParametroImpor= mostrarcon_loteParametroImpor;
	}

	public Boolean getActivarcon_loteParametroImpor() {
		return this.activarcon_loteParametroImpor;
	}

	public void setActivarcon_loteParametroImpor(Boolean activarcon_loteParametroImpor) {
		this.activarcon_loteParametroImpor= activarcon_loteParametroImpor;
	}

	public Border setResaltarcon_unidadParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroimporBeanSwingJInternalFrame.jTtoolBarParametroImpor.setBorder(borderResaltar);
		
		this.resaltarcon_unidadParametroImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_unidadParametroImpor() {
		return this.resaltarcon_unidadParametroImpor;
	}

	public void setResaltarcon_unidadParametroImpor(Border borderResaltar) {
		this.resaltarcon_unidadParametroImpor= borderResaltar;
	}

	public Boolean getMostrarcon_unidadParametroImpor() {
		return this.mostrarcon_unidadParametroImpor;
	}

	public void setMostrarcon_unidadParametroImpor(Boolean mostrarcon_unidadParametroImpor) {
		this.mostrarcon_unidadParametroImpor= mostrarcon_unidadParametroImpor;
	}

	public Boolean getActivarcon_unidadParametroImpor() {
		return this.activarcon_unidadParametroImpor;
	}

	public void setActivarcon_unidadParametroImpor(Boolean activarcon_unidadParametroImpor) {
		this.activarcon_unidadParametroImpor= activarcon_unidadParametroImpor;
	}

	public Border setResaltarcon_conversionParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroimporBeanSwingJInternalFrame.jTtoolBarParametroImpor.setBorder(borderResaltar);
		
		this.resaltarcon_conversionParametroImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_conversionParametroImpor() {
		return this.resaltarcon_conversionParametroImpor;
	}

	public void setResaltarcon_conversionParametroImpor(Border borderResaltar) {
		this.resaltarcon_conversionParametroImpor= borderResaltar;
	}

	public Boolean getMostrarcon_conversionParametroImpor() {
		return this.mostrarcon_conversionParametroImpor;
	}

	public void setMostrarcon_conversionParametroImpor(Boolean mostrarcon_conversionParametroImpor) {
		this.mostrarcon_conversionParametroImpor= mostrarcon_conversionParametroImpor;
	}

	public Boolean getActivarcon_conversionParametroImpor() {
		return this.activarcon_conversionParametroImpor;
	}

	public void setActivarcon_conversionParametroImpor(Boolean activarcon_conversionParametroImpor) {
		this.activarcon_conversionParametroImpor= activarcon_conversionParametroImpor;
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
		
		
		this.setMostraridParametroImpor(esInicial);
		this.setMostrarid_empresaParametroImpor(esInicial);
		this.setMostrarid_paisParametroImpor(esInicial);
		this.setMostrarid_bodegaParametroImpor(esInicial);
		this.setMostrarid_centro_costoParametroImpor(esInicial);
		this.setMostrarid_cuenta_contableParametroImpor(esInicial);
		this.setMostrarid_transaccion_orden_compraParametroImpor(esInicial);
		this.setMostrarid_transaccion_ingresoParametroImpor(esInicial);
		this.setMostrarid_formato_orden_compraParametroImpor(esInicial);
		this.setMostrarid_formato_ingresoParametroImpor(esInicial);
		this.setMostrarid_formato_pedidoParametroImpor(esInicial);
		this.setMostrarid_formato_liquidacionParametroImpor(esInicial);
		this.setMostrardias_llega_bodegaParametroImpor(esInicial);
		this.setMostrarporcentaje_seguroParametroImpor(esInicial);
		this.setMostrarfodinParametroImpor(esInicial);
		this.setMostrarcorpeiParametroImpor(esInicial);
		this.setMostrarcon_secuencialParametroImpor(esInicial);
		this.setMostrarsecuencialParametroImpor(esInicial);
		this.setMostrarcon_peso_precioParametroImpor(esInicial);
		this.setMostrarcon_loteParametroImpor(esInicial);
		this.setMostrarcon_unidadParametroImpor(esInicial);
		this.setMostrarcon_conversionParametroImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroImporConstantesFunciones.ID)) {
				this.setMostraridParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDTRANSACCIONORDENCOMPRA)) {
				this.setMostrarid_transaccion_orden_compraParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDTRANSACCIONINGRESO)) {
				this.setMostrarid_transaccion_ingresoParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDFORMATOORDENCOMPRA)) {
				this.setMostrarid_formato_orden_compraParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDFORMATOINGRESO)) {
				this.setMostrarid_formato_ingresoParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDFORMATOPEDIDO)) {
				this.setMostrarid_formato_pedidoParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDFORMATOLIQUIDACION)) {
				this.setMostrarid_formato_liquidacionParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.DIASLLEGABODEGA)) {
				this.setMostrardias_llega_bodegaParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.PORCENTAJESEGURO)) {
				this.setMostrarporcentaje_seguroParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.FODIN)) {
				this.setMostrarfodinParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.CORPEI)) {
				this.setMostrarcorpeiParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.CONSECUENCIAL)) {
				this.setMostrarcon_secuencialParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.CONPESOPRECIO)) {
				this.setMostrarcon_peso_precioParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.CONLOTE)) {
				this.setMostrarcon_loteParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.CONUNIDAD)) {
				this.setMostrarcon_unidadParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.CONCONVERSION)) {
				this.setMostrarcon_conversionParametroImpor(esAsigna);
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
		
		
		this.setActivaridParametroImpor(esInicial);
		this.setActivarid_empresaParametroImpor(esInicial);
		this.setActivarid_paisParametroImpor(esInicial);
		this.setActivarid_bodegaParametroImpor(esInicial);
		this.setActivarid_centro_costoParametroImpor(esInicial);
		this.setActivarid_cuenta_contableParametroImpor(esInicial);
		this.setActivarid_transaccion_orden_compraParametroImpor(esInicial);
		this.setActivarid_transaccion_ingresoParametroImpor(esInicial);
		this.setActivarid_formato_orden_compraParametroImpor(esInicial);
		this.setActivarid_formato_ingresoParametroImpor(esInicial);
		this.setActivarid_formato_pedidoParametroImpor(esInicial);
		this.setActivarid_formato_liquidacionParametroImpor(esInicial);
		this.setActivardias_llega_bodegaParametroImpor(esInicial);
		this.setActivarporcentaje_seguroParametroImpor(esInicial);
		this.setActivarfodinParametroImpor(esInicial);
		this.setActivarcorpeiParametroImpor(esInicial);
		this.setActivarcon_secuencialParametroImpor(esInicial);
		this.setActivarsecuencialParametroImpor(esInicial);
		this.setActivarcon_peso_precioParametroImpor(esInicial);
		this.setActivarcon_loteParametroImpor(esInicial);
		this.setActivarcon_unidadParametroImpor(esInicial);
		this.setActivarcon_conversionParametroImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroImporConstantesFunciones.ID)) {
				this.setActivaridParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDTRANSACCIONORDENCOMPRA)) {
				this.setActivarid_transaccion_orden_compraParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDTRANSACCIONINGRESO)) {
				this.setActivarid_transaccion_ingresoParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDFORMATOORDENCOMPRA)) {
				this.setActivarid_formato_orden_compraParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDFORMATOINGRESO)) {
				this.setActivarid_formato_ingresoParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDFORMATOPEDIDO)) {
				this.setActivarid_formato_pedidoParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDFORMATOLIQUIDACION)) {
				this.setActivarid_formato_liquidacionParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.DIASLLEGABODEGA)) {
				this.setActivardias_llega_bodegaParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.PORCENTAJESEGURO)) {
				this.setActivarporcentaje_seguroParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.FODIN)) {
				this.setActivarfodinParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.CORPEI)) {
				this.setActivarcorpeiParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.CONSECUENCIAL)) {
				this.setActivarcon_secuencialParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.CONPESOPRECIO)) {
				this.setActivarcon_peso_precioParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.CONLOTE)) {
				this.setActivarcon_loteParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.CONUNIDAD)) {
				this.setActivarcon_unidadParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.CONCONVERSION)) {
				this.setActivarcon_conversionParametroImpor(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParametroImpor(esInicial);
		this.setResaltarid_empresaParametroImpor(esInicial);
		this.setResaltarid_paisParametroImpor(esInicial);
		this.setResaltarid_bodegaParametroImpor(esInicial);
		this.setResaltarid_centro_costoParametroImpor(esInicial);
		this.setResaltarid_cuenta_contableParametroImpor(esInicial);
		this.setResaltarid_transaccion_orden_compraParametroImpor(esInicial);
		this.setResaltarid_transaccion_ingresoParametroImpor(esInicial);
		this.setResaltarid_formato_orden_compraParametroImpor(esInicial);
		this.setResaltarid_formato_ingresoParametroImpor(esInicial);
		this.setResaltarid_formato_pedidoParametroImpor(esInicial);
		this.setResaltarid_formato_liquidacionParametroImpor(esInicial);
		this.setResaltardias_llega_bodegaParametroImpor(esInicial);
		this.setResaltarporcentaje_seguroParametroImpor(esInicial);
		this.setResaltarfodinParametroImpor(esInicial);
		this.setResaltarcorpeiParametroImpor(esInicial);
		this.setResaltarcon_secuencialParametroImpor(esInicial);
		this.setResaltarsecuencialParametroImpor(esInicial);
		this.setResaltarcon_peso_precioParametroImpor(esInicial);
		this.setResaltarcon_loteParametroImpor(esInicial);
		this.setResaltarcon_unidadParametroImpor(esInicial);
		this.setResaltarcon_conversionParametroImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroImporConstantesFunciones.ID)) {
				this.setResaltaridParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDTRANSACCIONORDENCOMPRA)) {
				this.setResaltarid_transaccion_orden_compraParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDTRANSACCIONINGRESO)) {
				this.setResaltarid_transaccion_ingresoParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDFORMATOORDENCOMPRA)) {
				this.setResaltarid_formato_orden_compraParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDFORMATOINGRESO)) {
				this.setResaltarid_formato_ingresoParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDFORMATOPEDIDO)) {
				this.setResaltarid_formato_pedidoParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.IDFORMATOLIQUIDACION)) {
				this.setResaltarid_formato_liquidacionParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.DIASLLEGABODEGA)) {
				this.setResaltardias_llega_bodegaParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.PORCENTAJESEGURO)) {
				this.setResaltarporcentaje_seguroParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.FODIN)) {
				this.setResaltarfodinParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.CORPEI)) {
				this.setResaltarcorpeiParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.CONSECUENCIAL)) {
				this.setResaltarcon_secuencialParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.CONPESOPRECIO)) {
				this.setResaltarcon_peso_precioParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.CONLOTE)) {
				this.setResaltarcon_loteParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.CONUNIDAD)) {
				this.setResaltarcon_unidadParametroImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroImporConstantesFunciones.CONCONVERSION)) {
				this.setResaltarcon_conversionParametroImpor(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaParametroImpor=true;

	public Boolean getMostrarFK_IdBodegaParametroImpor() {
		return this.mostrarFK_IdBodegaParametroImpor;
	}

	public void setMostrarFK_IdBodegaParametroImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaParametroImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroCostoParametroImpor=true;

	public Boolean getMostrarFK_IdCentroCostoParametroImpor() {
		return this.mostrarFK_IdCentroCostoParametroImpor;
	}

	public void setMostrarFK_IdCentroCostoParametroImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoParametroImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableParametroImpor=true;

	public Boolean getMostrarFK_IdCuentaContableParametroImpor() {
		return this.mostrarFK_IdCuentaContableParametroImpor;
	}

	public void setMostrarFK_IdCuentaContableParametroImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableParametroImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaParametroImpor=true;

	public Boolean getMostrarFK_IdEmpresaParametroImpor() {
		return this.mostrarFK_IdEmpresaParametroImpor;
	}

	public void setMostrarFK_IdEmpresaParametroImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaParametroImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoIngresoParametroImpor=true;

	public Boolean getMostrarFK_IdFormatoIngresoParametroImpor() {
		return this.mostrarFK_IdFormatoIngresoParametroImpor;
	}

	public void setMostrarFK_IdFormatoIngresoParametroImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoIngresoParametroImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoLiquacionParametroImpor=true;

	public Boolean getMostrarFK_IdFormatoLiquacionParametroImpor() {
		return this.mostrarFK_IdFormatoLiquacionParametroImpor;
	}

	public void setMostrarFK_IdFormatoLiquacionParametroImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoLiquacionParametroImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoOrdenCompraParametroImpor=true;

	public Boolean getMostrarFK_IdFormatoOrdenCompraParametroImpor() {
		return this.mostrarFK_IdFormatoOrdenCompraParametroImpor;
	}

	public void setMostrarFK_IdFormatoOrdenCompraParametroImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoOrdenCompraParametroImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoPedoParametroImpor=true;

	public Boolean getMostrarFK_IdFormatoPedoParametroImpor() {
		return this.mostrarFK_IdFormatoPedoParametroImpor;
	}

	public void setMostrarFK_IdFormatoPedoParametroImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoPedoParametroImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisParametroImpor=true;

	public Boolean getMostrarFK_IdPaisParametroImpor() {
		return this.mostrarFK_IdPaisParametroImpor;
	}

	public void setMostrarFK_IdPaisParametroImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisParametroImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionIngresoParametroImpor=true;

	public Boolean getMostrarFK_IdTransaccionIngresoParametroImpor() {
		return this.mostrarFK_IdTransaccionIngresoParametroImpor;
	}

	public void setMostrarFK_IdTransaccionIngresoParametroImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionIngresoParametroImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionOrdenCompraParametroImpor=true;

	public Boolean getMostrarFK_IdTransaccionOrdenCompraParametroImpor() {
		return this.mostrarFK_IdTransaccionOrdenCompraParametroImpor;
	}

	public void setMostrarFK_IdTransaccionOrdenCompraParametroImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionOrdenCompraParametroImpor= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaParametroImpor=true;

	public Boolean getActivarFK_IdBodegaParametroImpor() {
		return this.activarFK_IdBodegaParametroImpor;
	}

	public void setActivarFK_IdBodegaParametroImpor(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaParametroImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroCostoParametroImpor=true;

	public Boolean getActivarFK_IdCentroCostoParametroImpor() {
		return this.activarFK_IdCentroCostoParametroImpor;
	}

	public void setActivarFK_IdCentroCostoParametroImpor(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoParametroImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableParametroImpor=true;

	public Boolean getActivarFK_IdCuentaContableParametroImpor() {
		return this.activarFK_IdCuentaContableParametroImpor;
	}

	public void setActivarFK_IdCuentaContableParametroImpor(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableParametroImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaParametroImpor=true;

	public Boolean getActivarFK_IdEmpresaParametroImpor() {
		return this.activarFK_IdEmpresaParametroImpor;
	}

	public void setActivarFK_IdEmpresaParametroImpor(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaParametroImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoIngresoParametroImpor=true;

	public Boolean getActivarFK_IdFormatoIngresoParametroImpor() {
		return this.activarFK_IdFormatoIngresoParametroImpor;
	}

	public void setActivarFK_IdFormatoIngresoParametroImpor(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoIngresoParametroImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoLiquacionParametroImpor=true;

	public Boolean getActivarFK_IdFormatoLiquacionParametroImpor() {
		return this.activarFK_IdFormatoLiquacionParametroImpor;
	}

	public void setActivarFK_IdFormatoLiquacionParametroImpor(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoLiquacionParametroImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoOrdenCompraParametroImpor=true;

	public Boolean getActivarFK_IdFormatoOrdenCompraParametroImpor() {
		return this.activarFK_IdFormatoOrdenCompraParametroImpor;
	}

	public void setActivarFK_IdFormatoOrdenCompraParametroImpor(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoOrdenCompraParametroImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoPedoParametroImpor=true;

	public Boolean getActivarFK_IdFormatoPedoParametroImpor() {
		return this.activarFK_IdFormatoPedoParametroImpor;
	}

	public void setActivarFK_IdFormatoPedoParametroImpor(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoPedoParametroImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisParametroImpor=true;

	public Boolean getActivarFK_IdPaisParametroImpor() {
		return this.activarFK_IdPaisParametroImpor;
	}

	public void setActivarFK_IdPaisParametroImpor(Boolean habilitarResaltar) {
		this.activarFK_IdPaisParametroImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionIngresoParametroImpor=true;

	public Boolean getActivarFK_IdTransaccionIngresoParametroImpor() {
		return this.activarFK_IdTransaccionIngresoParametroImpor;
	}

	public void setActivarFK_IdTransaccionIngresoParametroImpor(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionIngresoParametroImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionOrdenCompraParametroImpor=true;

	public Boolean getActivarFK_IdTransaccionOrdenCompraParametroImpor() {
		return this.activarFK_IdTransaccionOrdenCompraParametroImpor;
	}

	public void setActivarFK_IdTransaccionOrdenCompraParametroImpor(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionOrdenCompraParametroImpor= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaParametroImpor=null;

	public Border getResaltarFK_IdBodegaParametroImpor() {
		return this.resaltarFK_IdBodegaParametroImpor;
	}

	public void setResaltarFK_IdBodegaParametroImpor(Border borderResaltar) {
		this.resaltarFK_IdBodegaParametroImpor= borderResaltar;
	}

	public void setResaltarFK_IdBodegaParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaParametroImpor= borderResaltar;
	}

	public Border resaltarFK_IdCentroCostoParametroImpor=null;

	public Border getResaltarFK_IdCentroCostoParametroImpor() {
		return this.resaltarFK_IdCentroCostoParametroImpor;
	}

	public void setResaltarFK_IdCentroCostoParametroImpor(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoParametroImpor= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoParametroImpor= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableParametroImpor=null;

	public Border getResaltarFK_IdCuentaContableParametroImpor() {
		return this.resaltarFK_IdCuentaContableParametroImpor;
	}

	public void setResaltarFK_IdCuentaContableParametroImpor(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableParametroImpor= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableParametroImpor= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaParametroImpor=null;

	public Border getResaltarFK_IdEmpresaParametroImpor() {
		return this.resaltarFK_IdEmpresaParametroImpor;
	}

	public void setResaltarFK_IdEmpresaParametroImpor(Border borderResaltar) {
		this.resaltarFK_IdEmpresaParametroImpor= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaParametroImpor= borderResaltar;
	}

	public Border resaltarFK_IdFormatoIngresoParametroImpor=null;

	public Border getResaltarFK_IdFormatoIngresoParametroImpor() {
		return this.resaltarFK_IdFormatoIngresoParametroImpor;
	}

	public void setResaltarFK_IdFormatoIngresoParametroImpor(Border borderResaltar) {
		this.resaltarFK_IdFormatoIngresoParametroImpor= borderResaltar;
	}

	public void setResaltarFK_IdFormatoIngresoParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoIngresoParametroImpor= borderResaltar;
	}

	public Border resaltarFK_IdFormatoLiquacionParametroImpor=null;

	public Border getResaltarFK_IdFormatoLiquacionParametroImpor() {
		return this.resaltarFK_IdFormatoLiquacionParametroImpor;
	}

	public void setResaltarFK_IdFormatoLiquacionParametroImpor(Border borderResaltar) {
		this.resaltarFK_IdFormatoLiquacionParametroImpor= borderResaltar;
	}

	public void setResaltarFK_IdFormatoLiquacionParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoLiquacionParametroImpor= borderResaltar;
	}

	public Border resaltarFK_IdFormatoOrdenCompraParametroImpor=null;

	public Border getResaltarFK_IdFormatoOrdenCompraParametroImpor() {
		return this.resaltarFK_IdFormatoOrdenCompraParametroImpor;
	}

	public void setResaltarFK_IdFormatoOrdenCompraParametroImpor(Border borderResaltar) {
		this.resaltarFK_IdFormatoOrdenCompraParametroImpor= borderResaltar;
	}

	public void setResaltarFK_IdFormatoOrdenCompraParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoOrdenCompraParametroImpor= borderResaltar;
	}

	public Border resaltarFK_IdFormatoPedoParametroImpor=null;

	public Border getResaltarFK_IdFormatoPedoParametroImpor() {
		return this.resaltarFK_IdFormatoPedoParametroImpor;
	}

	public void setResaltarFK_IdFormatoPedoParametroImpor(Border borderResaltar) {
		this.resaltarFK_IdFormatoPedoParametroImpor= borderResaltar;
	}

	public void setResaltarFK_IdFormatoPedoParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoPedoParametroImpor= borderResaltar;
	}

	public Border resaltarFK_IdPaisParametroImpor=null;

	public Border getResaltarFK_IdPaisParametroImpor() {
		return this.resaltarFK_IdPaisParametroImpor;
	}

	public void setResaltarFK_IdPaisParametroImpor(Border borderResaltar) {
		this.resaltarFK_IdPaisParametroImpor= borderResaltar;
	}

	public void setResaltarFK_IdPaisParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisParametroImpor= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionIngresoParametroImpor=null;

	public Border getResaltarFK_IdTransaccionIngresoParametroImpor() {
		return this.resaltarFK_IdTransaccionIngresoParametroImpor;
	}

	public void setResaltarFK_IdTransaccionIngresoParametroImpor(Border borderResaltar) {
		this.resaltarFK_IdTransaccionIngresoParametroImpor= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionIngresoParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionIngresoParametroImpor= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionOrdenCompraParametroImpor=null;

	public Border getResaltarFK_IdTransaccionOrdenCompraParametroImpor() {
		return this.resaltarFK_IdTransaccionOrdenCompraParametroImpor;
	}

	public void setResaltarFK_IdTransaccionOrdenCompraParametroImpor(Border borderResaltar) {
		this.resaltarFK_IdTransaccionOrdenCompraParametroImpor= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionOrdenCompraParametroImpor(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroImporBeanSwingJInternalFrame parametroimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionOrdenCompraParametroImpor= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}