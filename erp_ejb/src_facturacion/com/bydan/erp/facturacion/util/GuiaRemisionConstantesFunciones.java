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


import com.bydan.erp.facturacion.util.GuiaRemisionConstantesFunciones;
import com.bydan.erp.facturacion.util.GuiaRemisionParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.GuiaRemisionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class GuiaRemisionConstantesFunciones extends GuiaRemisionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="GuiaRemision";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="GuiaRemision"+GuiaRemisionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="GuiaRemisionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="GuiaRemisionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=GuiaRemisionConstantesFunciones.SCHEMA+"_"+GuiaRemisionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/GuiaRemisionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=GuiaRemisionConstantesFunciones.SCHEMA+"_"+GuiaRemisionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=GuiaRemisionConstantesFunciones.SCHEMA+"_"+GuiaRemisionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/GuiaRemisionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=GuiaRemisionConstantesFunciones.SCHEMA+"_"+GuiaRemisionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GuiaRemisionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/GuiaRemisionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GuiaRemisionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GuiaRemisionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/GuiaRemisionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GuiaRemisionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=GuiaRemisionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+GuiaRemisionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=GuiaRemisionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+GuiaRemisionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Guia Remisiones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Guia Remision";
	public static final String SCLASSWEBTITULO_LOWER="Guia Remision";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="GuiaRemision";
	public static final String OBJECTNAME="guiaremision";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="guia_remision";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select guiaremision from "+GuiaRemisionConstantesFunciones.SPERSISTENCENAME+" guiaremision";
	public static String QUERYSELECTNATIVE="select "+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".version_row,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_empresa,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_sucursal,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_ejercicio,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_periodo,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_usuario,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".secuencial,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".fecha_emision,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_formato,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_tipo_precio,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_moneda,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".numero_camion,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_cliente,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_vendedor,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_factura,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_transportista,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".identificacion,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".fecha_origen,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".fecha_destino,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".transporte_codigo,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".cantidad_bultos,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_consultor,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_transporte,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_sub_cliente,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_empleado,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_ciudad_origen,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_ciudad_destino,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_tipo_llamada,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".hora_inicio,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".hora_fin,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".cupo,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".saldo,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".documento,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".disponible,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".descripcion,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".total_iva,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".total_sin_iva,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".descuento,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".flete,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".otro,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".financiamiento,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".iva,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".total,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".monto_retencion,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".id_tipo_cambio,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".fecha,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".ruc_cliente,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".nombre_cliente,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".telefono_cliente,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".direccion_cliente,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".numero_pre_impreso,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".peso_bruto,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".fecha_autorizacion,"+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME+".fecha_vencimiento from "+GuiaRemisionConstantesFunciones.SCHEMA+"."+GuiaRemisionConstantesFunciones.TABLENAME;//+" as "+GuiaRemisionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=true;
	
	
	protected GuiaRemisionConstantesFuncionesAdditional guiaremisionConstantesFuncionesAdditional=null;
	
	public GuiaRemisionConstantesFuncionesAdditional getGuiaRemisionConstantesFuncionesAdditional() {
		return this.guiaremisionConstantesFuncionesAdditional;
	}
	
	public void setGuiaRemisionConstantesFuncionesAdditional(GuiaRemisionConstantesFuncionesAdditional guiaremisionConstantesFuncionesAdditional) {
		try {
			this.guiaremisionConstantesFuncionesAdditional=guiaremisionConstantesFuncionesAdditional;
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
    public static final String IDUSUARIO= "id_usuario";
    public static final String SECUENCIAL= "secuencial";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String IDFORMATO= "id_formato";
    public static final String IDTIPOPRECIO= "id_tipo_precio";
    public static final String IDMONEDA= "id_moneda";
    public static final String NUMEROCAMION= "numero_camion";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDVENDEDOR= "id_vendedor";
    public static final String IDFACTURA= "id_factura";
    public static final String IDTRANSPORTISTA= "id_transportista";
    public static final String IDENTIFICACION= "identificacion";
    public static final String FECHAORIGEN= "fecha_origen";
    public static final String FECHADESTINO= "fecha_destino";
    public static final String TRANSPORTECODIGO= "transporte_codigo";
    public static final String CANTIDADBULTOS= "cantidad_bultos";
    public static final String IDCONSULTOR= "id_consultor";
    public static final String IDTRANSPORTE= "id_transporte";
    public static final String IDSUBCLIENTE= "id_sub_cliente";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDCIUDADORIGEN= "id_ciudad_origen";
    public static final String IDCIUDADDESTINO= "id_ciudad_destino";
    public static final String IDTIPOLLAMADA= "id_tipo_llamada";
    public static final String HORAINICIO= "hora_inicio";
    public static final String HORAFIN= "hora_fin";
    public static final String CUPO= "cupo";
    public static final String SALDO= "saldo";
    public static final String DOCUMENTO= "documento";
    public static final String DISPONIBLE= "disponible";
    public static final String DESCRIPCION= "descripcion";
    public static final String TOTALIVA= "total_iva";
    public static final String TOTALSINIVA= "total_sin_iva";
    public static final String DESCUENTO= "descuento";
    public static final String FLETE= "flete";
    public static final String OTRO= "otro";
    public static final String FINANCIAMIENTO= "financiamiento";
    public static final String IVA= "iva";
    public static final String TOTAL= "total";
    public static final String MONTORETENCION= "monto_retencion";
    public static final String IDTIPOCAMBIO= "id_tipo_cambio";
    public static final String FECHA= "fecha";
    public static final String RUCCLIENTE= "ruc_cliente";
    public static final String NOMBRECLIENTE= "nombre_cliente";
    public static final String TELEFONOCLIENTE= "telefono_cliente";
    public static final String DIRECCIONCLIENTE= "direccion_cliente";
    public static final String NUMEROPREIMPRESO= "numero_pre_impreso";
    public static final String PESOBRUTO= "peso_bruto";
    public static final String FECHAAUTORIZACION= "fecha_autorizacion";
    public static final String FECHAVENCIMIENTO= "fecha_vencimiento";
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
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_SECUENCIAL= "Nro Guia";
		public static final String LABEL_SECUENCIAL_LOWER= "Secuencial";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_IDFORMATO= "Formato";
		public static final String LABEL_IDFORMATO_LOWER= "Formato";
    	public static final String LABEL_IDTIPOPRECIO= "Tipo Precio";
		public static final String LABEL_IDTIPOPRECIO_LOWER= "Tipo Precio";
    	public static final String LABEL_IDMONEDA= "Moneda";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_NUMEROCAMION= "Numero Camion";
		public static final String LABEL_NUMEROCAMION_LOWER= "Numero Camion";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDVENDEDOR= "Vendedor";
		public static final String LABEL_IDVENDEDOR_LOWER= "Vendedor";
    	public static final String LABEL_IDFACTURA= "Factura";
		public static final String LABEL_IDFACTURA_LOWER= "Factura";
    	public static final String LABEL_IDTRANSPORTISTA= "Transportista";
		public static final String LABEL_IDTRANSPORTISTA_LOWER= "Transportista";
    	public static final String LABEL_IDENTIFICACION= "Identificacion";
		public static final String LABEL_IDENTIFICACION_LOWER= "Identificacion";
    	public static final String LABEL_FECHAORIGEN= "Fecha Origen";
		public static final String LABEL_FECHAORIGEN_LOWER= "Fecha Origen";
    	public static final String LABEL_FECHADESTINO= "Fecha Destino";
		public static final String LABEL_FECHADESTINO_LOWER= "Fecha Destino";
    	public static final String LABEL_TRANSPORTECODIGO= "Transporte Codigo";
		public static final String LABEL_TRANSPORTECODIGO_LOWER= "Transporte Codigo";
    	public static final String LABEL_CANTIDADBULTOS= "Cantidad Bultos";
		public static final String LABEL_CANTIDADBULTOS_LOWER= "Cantidad Bultos";
    	public static final String LABEL_IDCONSULTOR= "Consultor";
		public static final String LABEL_IDCONSULTOR_LOWER= "Consultor";
    	public static final String LABEL_IDTRANSPORTE= "Transporte";
		public static final String LABEL_IDTRANSPORTE_LOWER= "Transporte";
    	public static final String LABEL_IDSUBCLIENTE= "Sub Cliente";
		public static final String LABEL_IDSUBCLIENTE_LOWER= "Sub Cliente";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDCIUDADORIGEN= "Ciudad Origen";
		public static final String LABEL_IDCIUDADORIGEN_LOWER= "Ciudad Origen";
    	public static final String LABEL_IDCIUDADDESTINO= "Ciudad Destino";
		public static final String LABEL_IDCIUDADDESTINO_LOWER= "Ciudad Destino";
    	public static final String LABEL_IDTIPOLLAMADA= "Tipo Llamada";
		public static final String LABEL_IDTIPOLLAMADA_LOWER= "Tipo Llamada";
    	public static final String LABEL_HORAINICIO= "Hora Inicio";
		public static final String LABEL_HORAINICIO_LOWER= "Hora Inicio";
    	public static final String LABEL_HORAFIN= "Hora Fin";
		public static final String LABEL_HORAFIN_LOWER= "Hora Fin";
    	public static final String LABEL_CUPO= "Cupo";
		public static final String LABEL_CUPO_LOWER= "Cupo";
    	public static final String LABEL_SALDO= "Saldo";
		public static final String LABEL_SALDO_LOWER= "Saldo";
    	public static final String LABEL_DOCUMENTO= "Documento";
		public static final String LABEL_DOCUMENTO_LOWER= "Documento";
    	public static final String LABEL_DISPONIBLE= "Disponible";
		public static final String LABEL_DISPONIBLE_LOWER= "Disponible";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_TOTALIVA= "Total Iva";
		public static final String LABEL_TOTALIVA_LOWER= "Total Iva";
    	public static final String LABEL_TOTALSINIVA= "Total Sin Iva";
		public static final String LABEL_TOTALSINIVA_LOWER= "Total Sin Iva";
    	public static final String LABEL_DESCUENTO= "Descuento";
		public static final String LABEL_DESCUENTO_LOWER= "Descuento";
    	public static final String LABEL_FLETE= "Flete";
		public static final String LABEL_FLETE_LOWER= "Flete";
    	public static final String LABEL_OTRO= "Otro";
		public static final String LABEL_OTRO_LOWER= "Otro";
    	public static final String LABEL_FINANCIAMIENTO= "Financiamiento";
		public static final String LABEL_FINANCIAMIENTO_LOWER= "Financiamiento";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_MONTORETENCION= "Monto Retencion";
		public static final String LABEL_MONTORETENCION_LOWER= "Monto Retencion";
    	public static final String LABEL_IDTIPOCAMBIO= "Tipo Cambio";
		public static final String LABEL_IDTIPOCAMBIO_LOWER= "Tipo Cambio";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_RUCCLIENTE= "Ruc Cliente";
		public static final String LABEL_RUCCLIENTE_LOWER= "Ruc Cliente";
    	public static final String LABEL_NOMBRECLIENTE= "Nombre Cliente";
		public static final String LABEL_NOMBRECLIENTE_LOWER= "Nombre Cliente";
    	public static final String LABEL_TELEFONOCLIENTE= "Telefono Cliente";
		public static final String LABEL_TELEFONOCLIENTE_LOWER= "Telefono Cliente";
    	public static final String LABEL_DIRECCIONCLIENTE= "Direccion Cliente";
		public static final String LABEL_DIRECCIONCLIENTE_LOWER= "Direccion Cliente";
    	public static final String LABEL_NUMEROPREIMPRESO= "Numero Pre Impreso";
		public static final String LABEL_NUMEROPREIMPRESO_LOWER= "Numero Pre Impreso";
    	public static final String LABEL_PESOBRUTO= "Peso Bruto";
		public static final String LABEL_PESOBRUTO_LOWER= "Peso Bruto";
    	public static final String LABEL_FECHAAUTORIZACION= "Fecha Autorizacion";
		public static final String LABEL_FECHAAUTORIZACION_LOWER= "Fecha Autorizacion";
    	public static final String LABEL_FECHAVENCIMIENTO= "Fecha Vencimiento";
		public static final String LABEL_FECHAVENCIMIENTO_LOWER= "Fecha Vencimiento";
	
		
		
		
		
		
		
		
	public static final String SREGEXSECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXNUMERO_CAMION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CAMION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXIDENTIFICACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXIDENTIFICACION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXTRANSPORTE_CODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTRANSPORTE_CODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXRUC_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO_CLIENTE=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	public static final String SREGEXDIRECCION_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	
	public static String getGuiaRemisionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.IDEMPRESA)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.IDSUCURSAL)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.IDEJERCICIO)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.IDPERIODO)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.IDUSUARIO)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.SECUENCIAL)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.FECHAEMISION)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.IDFORMATO)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.IDTIPOPRECIO)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_IDTIPOPRECIO;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.IDMONEDA)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.NUMEROCAMION)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_NUMEROCAMION;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.IDCLIENTE)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.IDVENDEDOR)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.IDFACTURA)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.IDTRANSPORTISTA)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_IDTRANSPORTISTA;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.IDENTIFICACION)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_IDENTIFICACION;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.FECHAORIGEN)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_FECHAORIGEN;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.FECHADESTINO)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_FECHADESTINO;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.TRANSPORTECODIGO)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_TRANSPORTECODIGO;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.CANTIDADBULTOS)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_CANTIDADBULTOS;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.IDCONSULTOR)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_IDCONSULTOR;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.IDTRANSPORTE)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_IDTRANSPORTE;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.IDSUBCLIENTE)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_IDSUBCLIENTE;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.IDEMPLEADO)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.IDCIUDADORIGEN)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_IDCIUDADORIGEN;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.IDCIUDADDESTINO)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_IDCIUDADDESTINO;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.IDTIPOLLAMADA)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_IDTIPOLLAMADA;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.HORAINICIO)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_HORAINICIO;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.HORAFIN)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_HORAFIN;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.CUPO)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_CUPO;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.SALDO)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_SALDO;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.DOCUMENTO)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_DOCUMENTO;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.DISPONIBLE)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_DISPONIBLE;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.DESCRIPCION)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.TOTALIVA)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_TOTALIVA;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.TOTALSINIVA)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_TOTALSINIVA;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.DESCUENTO)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.FLETE)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_FLETE;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.OTRO)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_OTRO;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.FINANCIAMIENTO)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_FINANCIAMIENTO;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.IVA)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.TOTAL)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.MONTORETENCION)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_MONTORETENCION;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.IDTIPOCAMBIO)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_IDTIPOCAMBIO;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.FECHA)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.RUCCLIENTE)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_RUCCLIENTE;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.NOMBRECLIENTE)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_NOMBRECLIENTE;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.TELEFONOCLIENTE)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_TELEFONOCLIENTE;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.DIRECCIONCLIENTE)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_DIRECCIONCLIENTE;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.NUMEROPREIMPRESO)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_NUMEROPREIMPRESO;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.PESOBRUTO)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_PESOBRUTO;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.FECHAAUTORIZACION)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_FECHAAUTORIZACION;}
		if(sNombreColumna.equals(GuiaRemisionConstantesFunciones.FECHAVENCIMIENTO)) {sLabelColumna=GuiaRemisionConstantesFunciones.LABEL_FECHAVENCIMIENTO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getGuiaRemisionDescripcion(GuiaRemision guiaremision) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(guiaremision !=null/* && guiaremision.getId()!=0*/) {
			if(guiaremision.getId()!=null) {
				sDescripcion=guiaremision.getId().toString();
			}//guiaremisionguiaremision.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getGuiaRemisionDescripcionDetallado(GuiaRemision guiaremision) {
		String sDescripcion="";
			
		sDescripcion+=GuiaRemisionConstantesFunciones.ID+"=";
		sDescripcion+=guiaremision.getId().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=guiaremision.getVersionRow().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=guiaremision.getid_empresa().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=guiaremision.getid_sucursal().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=guiaremision.getid_ejercicio().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=guiaremision.getid_periodo().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=guiaremision.getid_usuario().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=guiaremision.getsecuencial()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=guiaremision.getfecha_emision().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=guiaremision.getid_formato().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.IDTIPOPRECIO+"=";
		sDescripcion+=guiaremision.getid_tipo_precio().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=guiaremision.getid_moneda().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.NUMEROCAMION+"=";
		sDescripcion+=guiaremision.getnumero_camion()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=guiaremision.getid_cliente().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=guiaremision.getid_vendedor().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=guiaremision.getid_factura().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.IDTRANSPORTISTA+"=";
		sDescripcion+=guiaremision.getid_transportista().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.IDENTIFICACION+"=";
		sDescripcion+=guiaremision.getidentificacion()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.FECHAORIGEN+"=";
		sDescripcion+=guiaremision.getfecha_origen().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.FECHADESTINO+"=";
		sDescripcion+=guiaremision.getfecha_destino().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.TRANSPORTECODIGO+"=";
		sDescripcion+=guiaremision.gettransporte_codigo()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.CANTIDADBULTOS+"=";
		sDescripcion+=guiaremision.getcantidad_bultos().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.IDCONSULTOR+"=";
		sDescripcion+=guiaremision.getid_consultor().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.IDTRANSPORTE+"=";
		sDescripcion+=guiaremision.getid_transporte().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.IDSUBCLIENTE+"=";
		sDescripcion+=guiaremision.getid_sub_cliente().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=guiaremision.getid_empleado().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.IDCIUDADORIGEN+"=";
		sDescripcion+=guiaremision.getid_ciudad_origen().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.IDCIUDADDESTINO+"=";
		sDescripcion+=guiaremision.getid_ciudad_destino().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.IDTIPOLLAMADA+"=";
		sDescripcion+=guiaremision.getid_tipo_llamada().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.HORAINICIO+"=";
		sDescripcion+=guiaremision.gethora_inicio().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.HORAFIN+"=";
		sDescripcion+=guiaremision.gethora_fin().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.CUPO+"=";
		sDescripcion+=guiaremision.getcupo().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.SALDO+"=";
		sDescripcion+=guiaremision.getsaldo().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.DOCUMENTO+"=";
		sDescripcion+=guiaremision.getdocumento().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.DISPONIBLE+"=";
		sDescripcion+=guiaremision.getdisponible().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=guiaremision.getdescripcion()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.TOTALIVA+"=";
		sDescripcion+=guiaremision.gettotal_iva().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.TOTALSINIVA+"=";
		sDescripcion+=guiaremision.gettotal_sin_iva().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=guiaremision.getdescuento().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.FLETE+"=";
		sDescripcion+=guiaremision.getflete().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.OTRO+"=";
		sDescripcion+=guiaremision.getotro().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.FINANCIAMIENTO+"=";
		sDescripcion+=guiaremision.getfinanciamiento().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.IVA+"=";
		sDescripcion+=guiaremision.getiva().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.TOTAL+"=";
		sDescripcion+=guiaremision.gettotal().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.MONTORETENCION+"=";
		sDescripcion+=guiaremision.getmonto_retencion().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.IDTIPOCAMBIO+"=";
		sDescripcion+=guiaremision.getid_tipo_cambio().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.FECHA+"=";
		sDescripcion+=guiaremision.getfecha().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.RUCCLIENTE+"=";
		sDescripcion+=guiaremision.getruc_cliente()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.NOMBRECLIENTE+"=";
		sDescripcion+=guiaremision.getnombre_cliente()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.TELEFONOCLIENTE+"=";
		sDescripcion+=guiaremision.gettelefono_cliente()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.DIRECCIONCLIENTE+"=";
		sDescripcion+=guiaremision.getdireccion_cliente()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.NUMEROPREIMPRESO+"=";
		sDescripcion+=guiaremision.getnumero_pre_impreso()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.PESOBRUTO+"=";
		sDescripcion+=guiaremision.getpeso_bruto().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.FECHAAUTORIZACION+"=";
		sDescripcion+=guiaremision.getfecha_autorizacion().toString()+",";
		sDescripcion+=GuiaRemisionConstantesFunciones.FECHAVENCIMIENTO+"=";
		sDescripcion+=guiaremision.getfecha_vencimiento().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setGuiaRemisionDescripcion(GuiaRemision guiaremision,String sValor) throws Exception {			
		if(guiaremision !=null) {
			//guiaremisionguiaremision.getId().toString();
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

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
		}

		return sDescripcion;
	}

	public static String getFormatoDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getTipoPrecioDescripcion(TipoPrecio tipoprecio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoprecio!=null/*&&tipoprecio.getId()>0*/) {
			sDescripcion=TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(tipoprecio);
		}

		return sDescripcion;
	}

	public static String getMonedaDescripcion(Moneda moneda) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(moneda!=null/*&&moneda.getId()>0*/) {
			sDescripcion=MonedaConstantesFunciones.getMonedaDescripcion(moneda);
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

	public static String getVendedorDescripcion(Vendedor vendedor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(vendedor!=null/*&&vendedor.getId()>0*/) {
			sDescripcion=VendedorConstantesFunciones.getVendedorDescripcion(vendedor);
		}

		return sDescripcion;
	}

	public static String getFacturaDescripcion(Factura factura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(factura!=null/*&&factura.getId()>0*/) {
			sDescripcion=FacturaConstantesFunciones.getFacturaDescripcion(factura);
		}

		return sDescripcion;
	}

	public static String getTransportistaDescripcion(Transportista transportista) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transportista!=null/*&&transportista.getId()>0*/) {
			sDescripcion=TransportistaConstantesFunciones.getTransportistaDescripcion(transportista);
		}

		return sDescripcion;
	}

	public static String getConsultorDescripcion(Consultor consultor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(consultor!=null/*&&consultor.getId()>0*/) {
			sDescripcion=ConsultorConstantesFunciones.getConsultorDescripcion(consultor);
		}

		return sDescripcion;
	}

	public static String getTransporteDescripcion(Transporte transporte) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transporte!=null/*&&transporte.getId()>0*/) {
			sDescripcion=TransporteConstantesFunciones.getTransporteDescripcion(transporte);
		}

		return sDescripcion;
	}

	public static String getSubClienteDescripcion(SubCliente subcliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(subcliente!=null/*&&subcliente.getId()>0*/) {
			sDescripcion=SubClienteConstantesFunciones.getSubClienteDescripcion(subcliente);
		}

		return sDescripcion;
	}

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}

	public static String getCiudadOrigenDescripcion(Ciudad ciudad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ciudad!=null/*&&ciudad.getId()>0*/) {
			sDescripcion=CiudadConstantesFunciones.getCiudadDescripcion(ciudad);
		}

		return sDescripcion;
	}

	public static String getCiudadDestinoDescripcion(Ciudad ciudad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ciudad!=null/*&&ciudad.getId()>0*/) {
			sDescripcion=CiudadConstantesFunciones.getCiudadDescripcion(ciudad);
		}

		return sDescripcion;
	}

	public static String getTipoLlamadaDescripcion(TipoLlamada tipollamada) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipollamada!=null/*&&tipollamada.getId()>0*/) {
			sDescripcion=TipoLlamadaConstantesFunciones.getTipoLlamadaDescripcion(tipollamada);
		}

		return sDescripcion;
	}

	public static String getTipoCambioDescripcion(TipoCambio tipocambio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocambio!=null/*&&tipocambio.getId()>0*/) {
			sDescripcion=TipoCambioConstantesFunciones.getTipoCambioDescripcion(tipocambio);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCiudadDestino")) {
			sNombreIndice="Tipo=  Por Ciudad Destino";
		} else if(sNombreIndice.equals("FK_IdCiudadOrigen")) {
			sNombreIndice="Tipo=  Por Ciudad Origen";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdConsultor")) {
			sNombreIndice="Tipo=  Por Consultor";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFactura")) {
			sNombreIndice="Tipo=  Por Factura";
		} else if(sNombreIndice.equals("FK_IdFormato")) {
			sNombreIndice="Tipo=  Por Formato";
		} else if(sNombreIndice.equals("FK_IdMoneda")) {
			sNombreIndice="Tipo=  Por Moneda";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSubCliente")) {
			sNombreIndice="Tipo=  Por Sub Cliente";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoCambio")) {
			sNombreIndice="Tipo=  Por Tipo Cambio";
		} else if(sNombreIndice.equals("FK_IdTipoLlamada")) {
			sNombreIndice="Tipo=  Por Tipo Llamada";
		} else if(sNombreIndice.equals("FK_IdTipoPrecio")) {
			sNombreIndice="Tipo=  Por Tipo Precio";
		} else if(sNombreIndice.equals("FK_IdTransporte")) {
			sNombreIndice="Tipo=  Por Transporte";
		} else if(sNombreIndice.equals("FK_IdTransportista")) {
			sNombreIndice="Tipo=  Por Transportista";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
		} else if(sNombreIndice.equals("FK_IdVendedor")) {
			sNombreIndice="Tipo=  Por Vendedor";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCiudadDestino(Long id_ciudad_destino) {
		String sDetalleIndice=" Parametros->";
		if(id_ciudad_destino!=null) {sDetalleIndice+=" Codigo Unico De Ciudad Destino="+id_ciudad_destino.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCiudadOrigen(Long id_ciudad_origen) {
		String sDetalleIndice=" Parametros->";
		if(id_ciudad_origen!=null) {sDetalleIndice+=" Codigo Unico De Ciudad Origen="+id_ciudad_origen.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdConsultor(Long id_consultor) {
		String sDetalleIndice=" Parametros->";
		if(id_consultor!=null) {sDetalleIndice+=" Codigo Unico De Consultor="+id_consultor.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFactura(Long id_factura) {
		String sDetalleIndice=" Parametros->";
		if(id_factura!=null) {sDetalleIndice+=" Codigo Unico De Factura="+id_factura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormato(Long id_formato) {
		String sDetalleIndice=" Parametros->";
		if(id_formato!=null) {sDetalleIndice+=" Codigo Unico De Formato="+id_formato.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMoneda(Long id_moneda) {
		String sDetalleIndice=" Parametros->";
		if(id_moneda!=null) {sDetalleIndice+=" Codigo Unico De Moneda="+id_moneda.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSubCliente(Long id_sub_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_sub_cliente!=null) {sDetalleIndice+=" Codigo Unico De Sub Cliente="+id_sub_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoCambio(Long id_tipo_cambio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_cambio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Cambio="+id_tipo_cambio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoLlamada(Long id_tipo_llamada) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_llamada!=null) {sDetalleIndice+=" Codigo Unico De Tipo Llamada="+id_tipo_llamada.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoPrecio(Long id_tipo_precio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_precio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Precio="+id_tipo_precio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransporte(Long id_transporte) {
		String sDetalleIndice=" Parametros->";
		if(id_transporte!=null) {sDetalleIndice+=" Codigo Unico De Transporte="+id_transporte.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransportista(Long id_transportista) {
		String sDetalleIndice=" Parametros->";
		if(id_transportista!=null) {sDetalleIndice+=" Codigo Unico De Transportista="+id_transportista.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdVendedor(Long id_vendedor) {
		String sDetalleIndice=" Parametros->";
		if(id_vendedor!=null) {sDetalleIndice+=" Codigo Unico De Vendedor="+id_vendedor.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosGuiaRemision(GuiaRemision guiaremision,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		guiaremision.setsecuencial(guiaremision.getsecuencial().trim());
		guiaremision.setnumero_camion(guiaremision.getnumero_camion().trim());
		guiaremision.setidentificacion(guiaremision.getidentificacion().trim());
		guiaremision.settransporte_codigo(guiaremision.gettransporte_codigo().trim());
		guiaremision.setdescripcion(guiaremision.getdescripcion().trim());
		guiaremision.setruc_cliente(guiaremision.getruc_cliente().trim());
		guiaremision.setnombre_cliente(guiaremision.getnombre_cliente().trim());
		guiaremision.settelefono_cliente(guiaremision.gettelefono_cliente().trim());
		guiaremision.setdireccion_cliente(guiaremision.getdireccion_cliente().trim());
		guiaremision.setnumero_pre_impreso(guiaremision.getnumero_pre_impreso().trim());
	}
	
	public static void quitarEspaciosGuiaRemisions(List<GuiaRemision> guiaremisions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(GuiaRemision guiaremision: guiaremisions) {
			guiaremision.setsecuencial(guiaremision.getsecuencial().trim());
			guiaremision.setnumero_camion(guiaremision.getnumero_camion().trim());
			guiaremision.setidentificacion(guiaremision.getidentificacion().trim());
			guiaremision.settransporte_codigo(guiaremision.gettransporte_codigo().trim());
			guiaremision.setdescripcion(guiaremision.getdescripcion().trim());
			guiaremision.setruc_cliente(guiaremision.getruc_cliente().trim());
			guiaremision.setnombre_cliente(guiaremision.getnombre_cliente().trim());
			guiaremision.settelefono_cliente(guiaremision.gettelefono_cliente().trim());
			guiaremision.setdireccion_cliente(guiaremision.getdireccion_cliente().trim());
			guiaremision.setnumero_pre_impreso(guiaremision.getnumero_pre_impreso().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresGuiaRemision(GuiaRemision guiaremision,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && guiaremision.getConCambioAuxiliar()) {
			guiaremision.setIsDeleted(guiaremision.getIsDeletedAuxiliar());	
			guiaremision.setIsNew(guiaremision.getIsNewAuxiliar());	
			guiaremision.setIsChanged(guiaremision.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			guiaremision.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			guiaremision.setIsDeletedAuxiliar(false);	
			guiaremision.setIsNewAuxiliar(false);	
			guiaremision.setIsChangedAuxiliar(false);
			
			guiaremision.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresGuiaRemisions(List<GuiaRemision> guiaremisions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(GuiaRemision guiaremision : guiaremisions) {
			if(conAsignarBase && guiaremision.getConCambioAuxiliar()) {
				guiaremision.setIsDeleted(guiaremision.getIsDeletedAuxiliar());	
				guiaremision.setIsNew(guiaremision.getIsNewAuxiliar());	
				guiaremision.setIsChanged(guiaremision.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				guiaremision.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				guiaremision.setIsDeletedAuxiliar(false);	
				guiaremision.setIsNewAuxiliar(false);	
				guiaremision.setIsChangedAuxiliar(false);
				
				guiaremision.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresGuiaRemision(GuiaRemision guiaremision,Boolean conEnteros) throws Exception  {
		guiaremision.setcupo(0.0);
		guiaremision.setsaldo(0.0);
		guiaremision.setdocumento(0.0);
		guiaremision.setdisponible(0.0);
		guiaremision.settotal_iva(0.0);
		guiaremision.settotal_sin_iva(0.0);
		guiaremision.setdescuento(0.0);
		guiaremision.setflete(0.0);
		guiaremision.setotro(0.0);
		guiaremision.setfinanciamiento(0.0);
		guiaremision.setiva(0.0);
		guiaremision.settotal(0.0);
		guiaremision.setmonto_retencion(0.0);
		guiaremision.setpeso_bruto(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			guiaremision.setcantidad_bultos(0);
		}
	}		
	
	public static void InicializarValoresGuiaRemisions(List<GuiaRemision> guiaremisions,Boolean conEnteros) throws Exception  {
		
		for(GuiaRemision guiaremision: guiaremisions) {
			guiaremision.setcupo(0.0);
			guiaremision.setsaldo(0.0);
			guiaremision.setdocumento(0.0);
			guiaremision.setdisponible(0.0);
			guiaremision.settotal_iva(0.0);
			guiaremision.settotal_sin_iva(0.0);
			guiaremision.setdescuento(0.0);
			guiaremision.setflete(0.0);
			guiaremision.setotro(0.0);
			guiaremision.setfinanciamiento(0.0);
			guiaremision.setiva(0.0);
			guiaremision.settotal(0.0);
			guiaremision.setmonto_retencion(0.0);
			guiaremision.setpeso_bruto(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				guiaremision.setcantidad_bultos(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaGuiaRemision(List<GuiaRemision> guiaremisions,GuiaRemision guiaremisionAux) throws Exception  {
		GuiaRemisionConstantesFunciones.InicializarValoresGuiaRemision(guiaremisionAux,true);
		
		for(GuiaRemision guiaremision: guiaremisions) {
			if(guiaremision.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			guiaremisionAux.setcantidad_bultos(guiaremisionAux.getcantidad_bultos()+guiaremision.getcantidad_bultos());			
			guiaremisionAux.setcupo(guiaremisionAux.getcupo()+guiaremision.getcupo());			
			guiaremisionAux.setsaldo(guiaremisionAux.getsaldo()+guiaremision.getsaldo());			
			guiaremisionAux.setdocumento(guiaremisionAux.getdocumento()+guiaremision.getdocumento());			
			guiaremisionAux.setdisponible(guiaremisionAux.getdisponible()+guiaremision.getdisponible());			
			guiaremisionAux.settotal_iva(guiaremisionAux.gettotal_iva()+guiaremision.gettotal_iva());			
			guiaremisionAux.settotal_sin_iva(guiaremisionAux.gettotal_sin_iva()+guiaremision.gettotal_sin_iva());			
			guiaremisionAux.setdescuento(guiaremisionAux.getdescuento()+guiaremision.getdescuento());			
			guiaremisionAux.setflete(guiaremisionAux.getflete()+guiaremision.getflete());			
			guiaremisionAux.setotro(guiaremisionAux.getotro()+guiaremision.getotro());			
			guiaremisionAux.setfinanciamiento(guiaremisionAux.getfinanciamiento()+guiaremision.getfinanciamiento());			
			guiaremisionAux.setiva(guiaremisionAux.getiva()+guiaremision.getiva());			
			guiaremisionAux.settotal(guiaremisionAux.gettotal()+guiaremision.gettotal());			
			guiaremisionAux.setmonto_retencion(guiaremisionAux.getmonto_retencion()+guiaremision.getmonto_retencion());			
			guiaremisionAux.setpeso_bruto(guiaremisionAux.getpeso_bruto()+guiaremision.getpeso_bruto());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesGuiaRemision(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=GuiaRemisionConstantesFunciones.getArrayColumnasGlobalesGuiaRemision(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesGuiaRemision(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(GuiaRemisionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(GuiaRemisionConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(GuiaRemisionConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(GuiaRemisionConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(GuiaRemisionConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(GuiaRemisionConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(GuiaRemisionConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(GuiaRemisionConstantesFunciones.IDPERIODO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(GuiaRemisionConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(GuiaRemisionConstantesFunciones.IDUSUARIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(GuiaRemisionConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(GuiaRemisionConstantesFunciones.IDMONEDA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoGuiaRemision(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<GuiaRemision> guiaremisions,GuiaRemision guiaremision,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(GuiaRemision guiaremisionAux: guiaremisions) {
			if(guiaremisionAux!=null && guiaremision!=null) {
				if((guiaremisionAux.getId()==null && guiaremision.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(guiaremisionAux.getId()!=null && guiaremision.getId()!=null){
					if(guiaremisionAux.getId().equals(guiaremision.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaGuiaRemision(List<GuiaRemision> guiaremisions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double cupoTotal=0.0;
		Double saldoTotal=0.0;
		Double documentoTotal=0.0;
		Double disponibleTotal=0.0;
		Double total_ivaTotal=0.0;
		Double total_sin_ivaTotal=0.0;
		Double descuentoTotal=0.0;
		Double fleteTotal=0.0;
		Double otroTotal=0.0;
		Double financiamientoTotal=0.0;
		Double ivaTotal=0.0;
		Double totalTotal=0.0;
		Double monto_retencionTotal=0.0;
		Double peso_brutoTotal=0.0;
	
		for(GuiaRemision guiaremision: guiaremisions) {			
			if(guiaremision.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cupoTotal+=guiaremision.getcupo();
			saldoTotal+=guiaremision.getsaldo();
			documentoTotal+=guiaremision.getdocumento();
			disponibleTotal+=guiaremision.getdisponible();
			total_ivaTotal+=guiaremision.gettotal_iva();
			total_sin_ivaTotal+=guiaremision.gettotal_sin_iva();
			descuentoTotal+=guiaremision.getdescuento();
			fleteTotal+=guiaremision.getflete();
			otroTotal+=guiaremision.getotro();
			financiamientoTotal+=guiaremision.getfinanciamiento();
			ivaTotal+=guiaremision.getiva();
			totalTotal+=guiaremision.gettotal();
			monto_retencionTotal+=guiaremision.getmonto_retencion();
			peso_brutoTotal+=guiaremision.getpeso_bruto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiaRemisionConstantesFunciones.CUPO);
		datoGeneral.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_CUPO);
		datoGeneral.setdValorDouble(cupoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiaRemisionConstantesFunciones.SALDO);
		datoGeneral.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_SALDO);
		datoGeneral.setdValorDouble(saldoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiaRemisionConstantesFunciones.DOCUMENTO);
		datoGeneral.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_DOCUMENTO);
		datoGeneral.setdValorDouble(documentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiaRemisionConstantesFunciones.DISPONIBLE);
		datoGeneral.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_DISPONIBLE);
		datoGeneral.setdValorDouble(disponibleTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiaRemisionConstantesFunciones.TOTALIVA);
		datoGeneral.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_TOTALIVA);
		datoGeneral.setdValorDouble(total_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiaRemisionConstantesFunciones.TOTALSINIVA);
		datoGeneral.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_TOTALSINIVA);
		datoGeneral.setdValorDouble(total_sin_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiaRemisionConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiaRemisionConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiaRemisionConstantesFunciones.OTRO);
		datoGeneral.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_OTRO);
		datoGeneral.setdValorDouble(otroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiaRemisionConstantesFunciones.FINANCIAMIENTO);
		datoGeneral.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_FINANCIAMIENTO);
		datoGeneral.setdValorDouble(financiamientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiaRemisionConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiaRemisionConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiaRemisionConstantesFunciones.MONTORETENCION);
		datoGeneral.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_MONTORETENCION);
		datoGeneral.setdValorDouble(monto_retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiaRemisionConstantesFunciones.PESOBRUTO);
		datoGeneral.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_PESOBRUTO);
		datoGeneral.setdValorDouble(peso_brutoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaGuiaRemision() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_ID, GuiaRemisionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_VERSIONROW, GuiaRemisionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_IDEMPRESA, GuiaRemisionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_IDSUCURSAL, GuiaRemisionConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_IDEJERCICIO, GuiaRemisionConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_IDPERIODO, GuiaRemisionConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_IDUSUARIO, GuiaRemisionConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_SECUENCIAL, GuiaRemisionConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_FECHAEMISION, GuiaRemisionConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_IDFORMATO, GuiaRemisionConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_IDTIPOPRECIO, GuiaRemisionConstantesFunciones.IDTIPOPRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_IDMONEDA, GuiaRemisionConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_NUMEROCAMION, GuiaRemisionConstantesFunciones.NUMEROCAMION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_IDCLIENTE, GuiaRemisionConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_IDVENDEDOR, GuiaRemisionConstantesFunciones.IDVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_IDFACTURA, GuiaRemisionConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_IDTRANSPORTISTA, GuiaRemisionConstantesFunciones.IDTRANSPORTISTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_IDENTIFICACION, GuiaRemisionConstantesFunciones.IDENTIFICACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_FECHAORIGEN, GuiaRemisionConstantesFunciones.FECHAORIGEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_FECHADESTINO, GuiaRemisionConstantesFunciones.FECHADESTINO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_TRANSPORTECODIGO, GuiaRemisionConstantesFunciones.TRANSPORTECODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_CANTIDADBULTOS, GuiaRemisionConstantesFunciones.CANTIDADBULTOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_IDCONSULTOR, GuiaRemisionConstantesFunciones.IDCONSULTOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_IDTRANSPORTE, GuiaRemisionConstantesFunciones.IDTRANSPORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_IDSUBCLIENTE, GuiaRemisionConstantesFunciones.IDSUBCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_IDEMPLEADO, GuiaRemisionConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_IDCIUDADORIGEN, GuiaRemisionConstantesFunciones.IDCIUDADORIGEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_IDCIUDADDESTINO, GuiaRemisionConstantesFunciones.IDCIUDADDESTINO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_IDTIPOLLAMADA, GuiaRemisionConstantesFunciones.IDTIPOLLAMADA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_HORAINICIO, GuiaRemisionConstantesFunciones.HORAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_HORAFIN, GuiaRemisionConstantesFunciones.HORAFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_CUPO, GuiaRemisionConstantesFunciones.CUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_SALDO, GuiaRemisionConstantesFunciones.SALDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_DOCUMENTO, GuiaRemisionConstantesFunciones.DOCUMENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_DISPONIBLE, GuiaRemisionConstantesFunciones.DISPONIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_DESCRIPCION, GuiaRemisionConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_TOTALIVA, GuiaRemisionConstantesFunciones.TOTALIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_TOTALSINIVA, GuiaRemisionConstantesFunciones.TOTALSINIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_DESCUENTO, GuiaRemisionConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_FLETE, GuiaRemisionConstantesFunciones.FLETE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_OTRO, GuiaRemisionConstantesFunciones.OTRO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_FINANCIAMIENTO, GuiaRemisionConstantesFunciones.FINANCIAMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_IVA, GuiaRemisionConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_TOTAL, GuiaRemisionConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_MONTORETENCION, GuiaRemisionConstantesFunciones.MONTORETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_IDTIPOCAMBIO, GuiaRemisionConstantesFunciones.IDTIPOCAMBIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_FECHA, GuiaRemisionConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_RUCCLIENTE, GuiaRemisionConstantesFunciones.RUCCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_NOMBRECLIENTE, GuiaRemisionConstantesFunciones.NOMBRECLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_TELEFONOCLIENTE, GuiaRemisionConstantesFunciones.TELEFONOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_DIRECCIONCLIENTE, GuiaRemisionConstantesFunciones.DIRECCIONCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_NUMEROPREIMPRESO, GuiaRemisionConstantesFunciones.NUMEROPREIMPRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_PESOBRUTO, GuiaRemisionConstantesFunciones.PESOBRUTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_FECHAAUTORIZACION, GuiaRemisionConstantesFunciones.FECHAAUTORIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiaRemisionConstantesFunciones.LABEL_FECHAVENCIMIENTO, GuiaRemisionConstantesFunciones.FECHAVENCIMIENTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasGuiaRemision() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.IDTIPOPRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.NUMEROCAMION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.IDVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.IDTRANSPORTISTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.IDENTIFICACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.FECHAORIGEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.FECHADESTINO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.TRANSPORTECODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.CANTIDADBULTOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.IDCONSULTOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.IDTRANSPORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.IDSUBCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.IDCIUDADORIGEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.IDCIUDADDESTINO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.IDTIPOLLAMADA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.HORAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.HORAFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.CUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.SALDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.DOCUMENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.DISPONIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.TOTALIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.TOTALSINIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.FLETE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.OTRO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.FINANCIAMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.MONTORETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.IDTIPOCAMBIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.RUCCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.NOMBRECLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.TELEFONOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.DIRECCIONCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.NUMEROPREIMPRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.PESOBRUTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.FECHAAUTORIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiaRemisionConstantesFunciones.FECHAVENCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGuiaRemision() throws Exception  {
		return GuiaRemisionConstantesFunciones.getTiposSeleccionarGuiaRemision(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGuiaRemision(Boolean conFk) throws Exception  {
		return GuiaRemisionConstantesFunciones.getTiposSeleccionarGuiaRemision(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGuiaRemision(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_IDTIPOPRECIO);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_IDTIPOPRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_NUMEROCAMION);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_NUMEROCAMION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_IDTRANSPORTISTA);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_IDTRANSPORTISTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_IDENTIFICACION);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_IDENTIFICACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_FECHAORIGEN);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_FECHAORIGEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_FECHADESTINO);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_FECHADESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_TRANSPORTECODIGO);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_TRANSPORTECODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_CANTIDADBULTOS);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_CANTIDADBULTOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_IDCONSULTOR);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_IDCONSULTOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_IDTRANSPORTE);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_IDTRANSPORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_IDSUBCLIENTE);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_IDSUBCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_IDCIUDADORIGEN);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_IDCIUDADORIGEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_IDCIUDADDESTINO);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_IDCIUDADDESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_IDTIPOLLAMADA);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_IDTIPOLLAMADA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		reporte=new Reporte();
		reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_HORAINICIO);
		reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_HORAINICIO);

		arrTiposSeleccionarTodos.add(reporte);
		reporte=new Reporte();
		reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_HORAFIN);
		reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_HORAFIN);

		arrTiposSeleccionarTodos.add(reporte);
		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_CUPO);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_CUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_SALDO);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_SALDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_DOCUMENTO);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_DOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_DISPONIBLE);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_DISPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_TOTALIVA);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_TOTALIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_TOTALSINIVA);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_TOTALSINIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_FLETE);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_FLETE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_OTRO);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_OTRO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_FINANCIAMIENTO);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_FINANCIAMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_MONTORETENCION);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_MONTORETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_IDTIPOCAMBIO);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_IDTIPOCAMBIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_RUCCLIENTE);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_RUCCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_NOMBRECLIENTE);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_NOMBRECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_TELEFONOCLIENTE);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_TELEFONOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_DIRECCIONCLIENTE);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_DIRECCIONCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_NUMEROPREIMPRESO);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_NUMEROPREIMPRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_PESOBRUTO);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_PESOBRUTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_FECHAAUTORIZACION);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_FECHAAUTORIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiaRemisionConstantesFunciones.LABEL_FECHAVENCIMIENTO);
			reporte.setsDescripcion(GuiaRemisionConstantesFunciones.LABEL_FECHAVENCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesGuiaRemision(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesGuiaRemision(GuiaRemision guiaremisionAux) throws Exception {
		
			guiaremisionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(guiaremisionAux.getEmpresa()));
			guiaremisionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(guiaremisionAux.getSucursal()));
			guiaremisionAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(guiaremisionAux.getEjercicio()));
			guiaremisionAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(guiaremisionAux.getPeriodo()));
			guiaremisionAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(guiaremisionAux.getUsuario()));
			guiaremisionAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(guiaremisionAux.getFormato()));
			guiaremisionAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(guiaremisionAux.getTipoPrecio()));
			guiaremisionAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(guiaremisionAux.getMoneda()));
			guiaremisionAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(guiaremisionAux.getCliente()));
			guiaremisionAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(guiaremisionAux.getVendedor()));
			guiaremisionAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(guiaremisionAux.getFactura()));
			guiaremisionAux.settransportista_descripcion(TransportistaConstantesFunciones.getTransportistaDescripcion(guiaremisionAux.getTransportista()));
			guiaremisionAux.setconsultor_descripcion(ConsultorConstantesFunciones.getConsultorDescripcion(guiaremisionAux.getConsultor()));
			guiaremisionAux.settransporte_descripcion(TransporteConstantesFunciones.getTransporteDescripcion(guiaremisionAux.getTransporte()));
			guiaremisionAux.setsubcliente_descripcion(SubClienteConstantesFunciones.getSubClienteDescripcion(guiaremisionAux.getSubCliente()));
			guiaremisionAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(guiaremisionAux.getEmpleado()));
			guiaremisionAux.setciudadorigen_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(guiaremisionAux.getCiudadOrigen()));
			guiaremisionAux.setciudaddestino_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(guiaremisionAux.getCiudadDestino()));
			guiaremisionAux.settipollamada_descripcion(TipoLlamadaConstantesFunciones.getTipoLlamadaDescripcion(guiaremisionAux.getTipoLlamada()));
			guiaremisionAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(guiaremisionAux.getTipoCambio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesGuiaRemision(List<GuiaRemision> guiaremisionsTemp) throws Exception {
		for(GuiaRemision guiaremisionAux:guiaremisionsTemp) {
			
			guiaremisionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(guiaremisionAux.getEmpresa()));
			guiaremisionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(guiaremisionAux.getSucursal()));
			guiaremisionAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(guiaremisionAux.getEjercicio()));
			guiaremisionAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(guiaremisionAux.getPeriodo()));
			guiaremisionAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(guiaremisionAux.getUsuario()));
			guiaremisionAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(guiaremisionAux.getFormato()));
			guiaremisionAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(guiaremisionAux.getTipoPrecio()));
			guiaremisionAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(guiaremisionAux.getMoneda()));
			guiaremisionAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(guiaremisionAux.getCliente()));
			guiaremisionAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(guiaremisionAux.getVendedor()));
			guiaremisionAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(guiaremisionAux.getFactura()));
			guiaremisionAux.settransportista_descripcion(TransportistaConstantesFunciones.getTransportistaDescripcion(guiaremisionAux.getTransportista()));
			guiaremisionAux.setconsultor_descripcion(ConsultorConstantesFunciones.getConsultorDescripcion(guiaremisionAux.getConsultor()));
			guiaremisionAux.settransporte_descripcion(TransporteConstantesFunciones.getTransporteDescripcion(guiaremisionAux.getTransporte()));
			guiaremisionAux.setsubcliente_descripcion(SubClienteConstantesFunciones.getSubClienteDescripcion(guiaremisionAux.getSubCliente()));
			guiaremisionAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(guiaremisionAux.getEmpleado()));
			guiaremisionAux.setciudadorigen_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(guiaremisionAux.getCiudadOrigen()));
			guiaremisionAux.setciudaddestino_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(guiaremisionAux.getCiudadDestino()));
			guiaremisionAux.settipollamada_descripcion(TipoLlamadaConstantesFunciones.getTipoLlamadaDescripcion(guiaremisionAux.getTipoLlamada()));
			guiaremisionAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(guiaremisionAux.getTipoCambio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfGuiaRemision(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(TipoPrecio.class));
				classes.add(new Classe(Moneda.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Vendedor.class));
				classes.add(new Classe(Factura.class));
				classes.add(new Classe(Transportista.class));
				classes.add(new Classe(Consultor.class));
				classes.add(new Classe(Transporte.class));
				classes.add(new Classe(SubCliente.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Ciudad.class));
				classes.add(new Classe(Ciudad.class));
				classes.add(new Classe(TipoLlamada.class));
				classes.add(new Classe(TipoCambio.class));
				
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
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoPrecio.class)) {
						classes.add(new Classe(TipoPrecio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Moneda.class)) {
						classes.add(new Classe(Moneda.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Vendedor.class)) {
						classes.add(new Classe(Vendedor.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transportista.class)) {
						classes.add(new Classe(Transportista.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Consultor.class)) {
						classes.add(new Classe(Consultor.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transporte.class)) {
						classes.add(new Classe(Transporte.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(SubCliente.class)) {
						classes.add(new Classe(SubCliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ciudad.class)) {
						classes.add(new Classe(Ciudad.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ciudad.class)) {
						classes.add(new Classe(Ciudad.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoLlamada.class)) {
						classes.add(new Classe(TipoLlamada.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCambio.class)) {
						classes.add(new Classe(TipoCambio.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfGuiaRemision(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(Transportista.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transportista.class)); continue;
					}

					if(Consultor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Consultor.class)); continue;
					}

					if(Transporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transporte.class)); continue;
					}

					if(SubCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubCliente.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(TipoLlamada.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoLlamada.class)); continue;
					}

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
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

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(Transportista.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transportista.class)); continue;
					}

					if(Consultor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Consultor.class)); continue;
					}

					if(Transporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transporte.class)); continue;
					}

					if(SubCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubCliente.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}

					if(TipoLlamada.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoLlamada.class)); continue;
					}

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfGuiaRemision(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return GuiaRemisionConstantesFunciones.getClassesRelationshipsOfGuiaRemision(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfGuiaRemision(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(MovimientoInventario.class));
				classes.add(new Classe(DetalleGuiaRemision.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(MovimientoInventario.class)) {
						classes.add(new Classe(MovimientoInventario.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleGuiaRemision.class)) {
						classes.add(new Classe(DetalleGuiaRemision.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfGuiaRemision(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return GuiaRemisionConstantesFunciones.getClassesRelationshipsFromStringsOfGuiaRemision(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfGuiaRemision(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(MovimientoInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MovimientoInventario.class)); continue;
					}

					if(DetalleGuiaRemision.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleGuiaRemision.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(MovimientoInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(MovimientoInventario.class)); continue;
					}

					if(DetalleGuiaRemision.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleGuiaRemision.class)); continue;
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
	public static void actualizarLista(GuiaRemision guiaremision,List<GuiaRemision> guiaremisions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			GuiaRemision guiaremisionEncontrado=null;
			
			for(GuiaRemision guiaremisionLocal:guiaremisions) {
				if(guiaremisionLocal.getId().equals(guiaremision.getId())) {
					guiaremisionEncontrado=guiaremisionLocal;
					
					guiaremisionLocal.setIsChanged(guiaremision.getIsChanged());
					guiaremisionLocal.setIsNew(guiaremision.getIsNew());
					guiaremisionLocal.setIsDeleted(guiaremision.getIsDeleted());
					
					guiaremisionLocal.setGeneralEntityOriginal(guiaremision.getGeneralEntityOriginal());
					
					guiaremisionLocal.setId(guiaremision.getId());	
					guiaremisionLocal.setVersionRow(guiaremision.getVersionRow());	
					guiaremisionLocal.setid_empresa(guiaremision.getid_empresa());	
					guiaremisionLocal.setid_sucursal(guiaremision.getid_sucursal());	
					guiaremisionLocal.setid_ejercicio(guiaremision.getid_ejercicio());	
					guiaremisionLocal.setid_periodo(guiaremision.getid_periodo());	
					guiaremisionLocal.setid_usuario(guiaremision.getid_usuario());	
					guiaremisionLocal.setsecuencial(guiaremision.getsecuencial());	
					guiaremisionLocal.setfecha_emision(guiaremision.getfecha_emision());	
					guiaremisionLocal.setid_formato(guiaremision.getid_formato());	
					guiaremisionLocal.setid_tipo_precio(guiaremision.getid_tipo_precio());	
					guiaremisionLocal.setid_moneda(guiaremision.getid_moneda());	
					guiaremisionLocal.setnumero_camion(guiaremision.getnumero_camion());	
					guiaremisionLocal.setid_cliente(guiaremision.getid_cliente());	
					guiaremisionLocal.setid_vendedor(guiaremision.getid_vendedor());	
					guiaremisionLocal.setid_factura(guiaremision.getid_factura());	
					guiaremisionLocal.setid_transportista(guiaremision.getid_transportista());	
					guiaremisionLocal.setidentificacion(guiaremision.getidentificacion());	
					guiaremisionLocal.setfecha_origen(guiaremision.getfecha_origen());	
					guiaremisionLocal.setfecha_destino(guiaremision.getfecha_destino());	
					guiaremisionLocal.settransporte_codigo(guiaremision.gettransporte_codigo());	
					guiaremisionLocal.setcantidad_bultos(guiaremision.getcantidad_bultos());	
					guiaremisionLocal.setid_consultor(guiaremision.getid_consultor());	
					guiaremisionLocal.setid_transporte(guiaremision.getid_transporte());	
					guiaremisionLocal.setid_sub_cliente(guiaremision.getid_sub_cliente());	
					guiaremisionLocal.setid_empleado(guiaremision.getid_empleado());	
					guiaremisionLocal.setid_ciudad_origen(guiaremision.getid_ciudad_origen());	
					guiaremisionLocal.setid_ciudad_destino(guiaremision.getid_ciudad_destino());	
					guiaremisionLocal.setid_tipo_llamada(guiaremision.getid_tipo_llamada());	
					guiaremisionLocal.sethora_inicio(guiaremision.gethora_inicio());	
					guiaremisionLocal.sethora_fin(guiaremision.gethora_fin());	
					guiaremisionLocal.setcupo(guiaremision.getcupo());	
					guiaremisionLocal.setsaldo(guiaremision.getsaldo());	
					guiaremisionLocal.setdocumento(guiaremision.getdocumento());	
					guiaremisionLocal.setdisponible(guiaremision.getdisponible());	
					guiaremisionLocal.setdescripcion(guiaremision.getdescripcion());	
					guiaremisionLocal.settotal_iva(guiaremision.gettotal_iva());	
					guiaremisionLocal.settotal_sin_iva(guiaremision.gettotal_sin_iva());	
					guiaremisionLocal.setdescuento(guiaremision.getdescuento());	
					guiaremisionLocal.setflete(guiaremision.getflete());	
					guiaremisionLocal.setotro(guiaremision.getotro());	
					guiaremisionLocal.setfinanciamiento(guiaremision.getfinanciamiento());	
					guiaremisionLocal.setiva(guiaremision.getiva());	
					guiaremisionLocal.settotal(guiaremision.gettotal());	
					guiaremisionLocal.setmonto_retencion(guiaremision.getmonto_retencion());	
					guiaremisionLocal.setid_tipo_cambio(guiaremision.getid_tipo_cambio());	
					guiaremisionLocal.setfecha(guiaremision.getfecha());	
					guiaremisionLocal.setruc_cliente(guiaremision.getruc_cliente());	
					guiaremisionLocal.setnombre_cliente(guiaremision.getnombre_cliente());	
					guiaremisionLocal.settelefono_cliente(guiaremision.gettelefono_cliente());	
					guiaremisionLocal.setdireccion_cliente(guiaremision.getdireccion_cliente());	
					guiaremisionLocal.setnumero_pre_impreso(guiaremision.getnumero_pre_impreso());	
					guiaremisionLocal.setpeso_bruto(guiaremision.getpeso_bruto());	
					guiaremisionLocal.setfecha_autorizacion(guiaremision.getfecha_autorizacion());	
					guiaremisionLocal.setfecha_vencimiento(guiaremision.getfecha_vencimiento());	
					
					
					guiaremisionLocal.setDetalleGuiaRemisions(guiaremision.getDetalleGuiaRemisions());
					
					existe=true;
					break;
				}
			}
			
			if(!guiaremision.getIsDeleted()) {
				if(!existe) {
					guiaremisions.add(guiaremision);
				}
			} else {
				if(guiaremisionEncontrado!=null && permiteQuitar)  {
					guiaremisions.remove(guiaremisionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(GuiaRemision guiaremision,List<GuiaRemision> guiaremisions) throws Exception {
		try	{			
			for(GuiaRemision guiaremisionLocal:guiaremisions) {
				if(guiaremisionLocal.getId().equals(guiaremision.getId())) {
					guiaremisionLocal.setIsSelected(guiaremision.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesGuiaRemision(List<GuiaRemision> guiaremisionsAux) throws Exception {
		//this.guiaremisionsAux=guiaremisionsAux;
		
		for(GuiaRemision guiaremisionAux:guiaremisionsAux) {
			if(guiaremisionAux.getIsChanged()) {
				guiaremisionAux.setIsChanged(false);
			}		
			
			if(guiaremisionAux.getIsNew()) {
				guiaremisionAux.setIsNew(false);
			}	
			
			if(guiaremisionAux.getIsDeleted()) {
				guiaremisionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesGuiaRemision(GuiaRemision guiaremisionAux) throws Exception {
		//this.guiaremisionAux=guiaremisionAux;
		
			if(guiaremisionAux.getIsChanged()) {
				guiaremisionAux.setIsChanged(false);
			}		
			
			if(guiaremisionAux.getIsNew()) {
				guiaremisionAux.setIsNew(false);
			}	
			
			if(guiaremisionAux.getIsDeleted()) {
				guiaremisionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(GuiaRemision guiaremisionAsignar,GuiaRemision guiaremision) throws Exception {
		guiaremisionAsignar.setId(guiaremision.getId());	
		guiaremisionAsignar.setVersionRow(guiaremision.getVersionRow());	
		guiaremisionAsignar.setid_empresa(guiaremision.getid_empresa());
		guiaremisionAsignar.setempresa_descripcion(guiaremision.getempresa_descripcion());	
		guiaremisionAsignar.setid_sucursal(guiaremision.getid_sucursal());
		guiaremisionAsignar.setsucursal_descripcion(guiaremision.getsucursal_descripcion());	
		guiaremisionAsignar.setid_ejercicio(guiaremision.getid_ejercicio());
		guiaremisionAsignar.setejercicio_descripcion(guiaremision.getejercicio_descripcion());	
		guiaremisionAsignar.setid_periodo(guiaremision.getid_periodo());
		guiaremisionAsignar.setperiodo_descripcion(guiaremision.getperiodo_descripcion());	
		guiaremisionAsignar.setid_usuario(guiaremision.getid_usuario());
		guiaremisionAsignar.setusuario_descripcion(guiaremision.getusuario_descripcion());	
		guiaremisionAsignar.setsecuencial(guiaremision.getsecuencial());	
		guiaremisionAsignar.setfecha_emision(guiaremision.getfecha_emision());	
		guiaremisionAsignar.setid_formato(guiaremision.getid_formato());
		guiaremisionAsignar.setformato_descripcion(guiaremision.getformato_descripcion());	
		guiaremisionAsignar.setid_tipo_precio(guiaremision.getid_tipo_precio());
		guiaremisionAsignar.settipoprecio_descripcion(guiaremision.gettipoprecio_descripcion());	
		guiaremisionAsignar.setid_moneda(guiaremision.getid_moneda());
		guiaremisionAsignar.setmoneda_descripcion(guiaremision.getmoneda_descripcion());	
		guiaremisionAsignar.setnumero_camion(guiaremision.getnumero_camion());	
		guiaremisionAsignar.setid_cliente(guiaremision.getid_cliente());
		guiaremisionAsignar.setcliente_descripcion(guiaremision.getcliente_descripcion());	
		guiaremisionAsignar.setid_vendedor(guiaremision.getid_vendedor());
		guiaremisionAsignar.setvendedor_descripcion(guiaremision.getvendedor_descripcion());	
		guiaremisionAsignar.setid_factura(guiaremision.getid_factura());
		guiaremisionAsignar.setfactura_descripcion(guiaremision.getfactura_descripcion());	
		guiaremisionAsignar.setid_transportista(guiaremision.getid_transportista());
		guiaremisionAsignar.settransportista_descripcion(guiaremision.gettransportista_descripcion());	
		guiaremisionAsignar.setidentificacion(guiaremision.getidentificacion());	
		guiaremisionAsignar.setfecha_origen(guiaremision.getfecha_origen());	
		guiaremisionAsignar.setfecha_destino(guiaremision.getfecha_destino());	
		guiaremisionAsignar.settransporte_codigo(guiaremision.gettransporte_codigo());	
		guiaremisionAsignar.setcantidad_bultos(guiaremision.getcantidad_bultos());	
		guiaremisionAsignar.setid_consultor(guiaremision.getid_consultor());
		guiaremisionAsignar.setconsultor_descripcion(guiaremision.getconsultor_descripcion());	
		guiaremisionAsignar.setid_transporte(guiaremision.getid_transporte());
		guiaremisionAsignar.settransporte_descripcion(guiaremision.gettransporte_descripcion());	
		guiaremisionAsignar.setid_sub_cliente(guiaremision.getid_sub_cliente());
		guiaremisionAsignar.setsubcliente_descripcion(guiaremision.getsubcliente_descripcion());	
		guiaremisionAsignar.setid_empleado(guiaremision.getid_empleado());
		guiaremisionAsignar.setempleado_descripcion(guiaremision.getempleado_descripcion());	
		guiaremisionAsignar.setid_ciudad_origen(guiaremision.getid_ciudad_origen());
		guiaremisionAsignar.setciudadorigen_descripcion(guiaremision.getciudadorigen_descripcion());	
		guiaremisionAsignar.setid_ciudad_destino(guiaremision.getid_ciudad_destino());
		guiaremisionAsignar.setciudaddestino_descripcion(guiaremision.getciudaddestino_descripcion());	
		guiaremisionAsignar.setid_tipo_llamada(guiaremision.getid_tipo_llamada());
		guiaremisionAsignar.settipollamada_descripcion(guiaremision.gettipollamada_descripcion());	
		guiaremisionAsignar.sethora_inicio(guiaremision.gethora_inicio());	
		guiaremisionAsignar.sethora_fin(guiaremision.gethora_fin());	
		guiaremisionAsignar.setcupo(guiaremision.getcupo());	
		guiaremisionAsignar.setsaldo(guiaremision.getsaldo());	
		guiaremisionAsignar.setdocumento(guiaremision.getdocumento());	
		guiaremisionAsignar.setdisponible(guiaremision.getdisponible());	
		guiaremisionAsignar.setdescripcion(guiaremision.getdescripcion());	
		guiaremisionAsignar.settotal_iva(guiaremision.gettotal_iva());	
		guiaremisionAsignar.settotal_sin_iva(guiaremision.gettotal_sin_iva());	
		guiaremisionAsignar.setdescuento(guiaremision.getdescuento());	
		guiaremisionAsignar.setflete(guiaremision.getflete());	
		guiaremisionAsignar.setotro(guiaremision.getotro());	
		guiaremisionAsignar.setfinanciamiento(guiaremision.getfinanciamiento());	
		guiaremisionAsignar.setiva(guiaremision.getiva());	
		guiaremisionAsignar.settotal(guiaremision.gettotal());	
		guiaremisionAsignar.setmonto_retencion(guiaremision.getmonto_retencion());	
		guiaremisionAsignar.setid_tipo_cambio(guiaremision.getid_tipo_cambio());
		guiaremisionAsignar.settipocambio_descripcion(guiaremision.gettipocambio_descripcion());	
		guiaremisionAsignar.setfecha(guiaremision.getfecha());	
		guiaremisionAsignar.setruc_cliente(guiaremision.getruc_cliente());	
		guiaremisionAsignar.setnombre_cliente(guiaremision.getnombre_cliente());	
		guiaremisionAsignar.settelefono_cliente(guiaremision.gettelefono_cliente());	
		guiaremisionAsignar.setdireccion_cliente(guiaremision.getdireccion_cliente());	
		guiaremisionAsignar.setnumero_pre_impreso(guiaremision.getnumero_pre_impreso());	
		guiaremisionAsignar.setpeso_bruto(guiaremision.getpeso_bruto());	
		guiaremisionAsignar.setfecha_autorizacion(guiaremision.getfecha_autorizacion());	
		guiaremisionAsignar.setfecha_vencimiento(guiaremision.getfecha_vencimiento());	
	}
	
	public static void inicializarGuiaRemision(GuiaRemision guiaremision) throws Exception {
		try {
				guiaremision.setId(0L);	
					
				guiaremision.setid_empresa(-1L);	
				guiaremision.setid_sucursal(-1L);	
				guiaremision.setid_ejercicio(-1L);	
				guiaremision.setid_periodo(-1L);	
				guiaremision.setid_usuario(-1L);	
				guiaremision.setsecuencial("");	
				guiaremision.setfecha_emision(new Date());	
				guiaremision.setid_formato(null);	
				guiaremision.setid_tipo_precio(-1L);	
				guiaremision.setid_moneda(-1L);	
				guiaremision.setnumero_camion("");	
				guiaremision.setid_cliente(-1L);	
				guiaremision.setid_vendedor(null);	
				guiaremision.setid_factura(null);	
				guiaremision.setid_transportista(null);	
				guiaremision.setidentificacion("");	
				guiaremision.setfecha_origen(new Date());	
				guiaremision.setfecha_destino(new Date());	
				guiaremision.settransporte_codigo("");	
				guiaremision.setcantidad_bultos(0);	
				guiaremision.setid_consultor(-1L);	
				guiaremision.setid_transporte(-1L);	
				guiaremision.setid_sub_cliente(-1L);	
				guiaremision.setid_empleado(-1L);	
				guiaremision.setid_ciudad_origen(null);	
				guiaremision.setid_ciudad_destino(null);	
				guiaremision.setid_tipo_llamada(-1L);	
				guiaremision.sethora_inicio(new Time((new Date()).getTime()));	
				guiaremision.sethora_fin(new Time((new Date()).getTime()));	
				guiaremision.setcupo(0.0);	
				guiaremision.setsaldo(0.0);	
				guiaremision.setdocumento(0.0);	
				guiaremision.setdisponible(0.0);	
				guiaremision.setdescripcion("");	
				guiaremision.settotal_iva(0.0);	
				guiaremision.settotal_sin_iva(0.0);	
				guiaremision.setdescuento(0.0);	
				guiaremision.setflete(0.0);	
				guiaremision.setotro(0.0);	
				guiaremision.setfinanciamiento(0.0);	
				guiaremision.setiva(0.0);	
				guiaremision.settotal(0.0);	
				guiaremision.setmonto_retencion(0.0);	
				guiaremision.setid_tipo_cambio(null);	
				guiaremision.setfecha(new Date());	
				guiaremision.setruc_cliente("");	
				guiaremision.setnombre_cliente("");	
				guiaremision.settelefono_cliente("");	
				guiaremision.setdireccion_cliente("");	
				guiaremision.setnumero_pre_impreso("");	
				guiaremision.setpeso_bruto(0.0);	
				guiaremision.setfecha_autorizacion(new Date());	
				guiaremision.setfecha_vencimiento(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderGuiaRemision(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_IDTIPOPRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_NUMEROCAMION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_IDTRANSPORTISTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_IDENTIFICACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_FECHAORIGEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_FECHADESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_TRANSPORTECODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_CANTIDADBULTOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_IDCONSULTOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_IDTRANSPORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_IDSUBCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_IDCIUDADORIGEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_IDCIUDADDESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_IDTIPOLLAMADA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_HORAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_HORAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_CUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_SALDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_DOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_DISPONIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_TOTALIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_TOTALSINIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_FLETE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_OTRO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_FINANCIAMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_MONTORETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_IDTIPOCAMBIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_RUCCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_NOMBRECLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_TELEFONOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_DIRECCIONCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_NUMEROPREIMPRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_PESOBRUTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_FECHAAUTORIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiaRemisionConstantesFunciones.LABEL_FECHAVENCIMIENTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataGuiaRemision(String sTipo,Row row,Workbook workbook,GuiaRemision guiaremision,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.gettipoprecio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getnumero_camion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.gettransportista_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getidentificacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getfecha_origen());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getfecha_destino());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.gettransporte_codigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getcantidad_bultos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getconsultor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.gettransporte_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getsubcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getciudadorigen_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getciudaddestino_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.gettipollamada_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.gethora_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.gethora_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getcupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getsaldo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getdocumento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getdisponible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.gettotal_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.gettotal_sin_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getflete());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getotro());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getfinanciamiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getmonto_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.gettipocambio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getruc_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getnombre_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.gettelefono_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getdireccion_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getnumero_pre_impreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getpeso_bruto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getfecha_autorizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiaremision.getfecha_vencimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryGuiaRemision=Constantes.SFINALQUERY;
	
	public String getsFinalQueryGuiaRemision() {
		return this.sFinalQueryGuiaRemision;
	}
	
	public void setsFinalQueryGuiaRemision(String sFinalQueryGuiaRemision) {
		this.sFinalQueryGuiaRemision= sFinalQueryGuiaRemision;
	}
	
	public Border resaltarSeleccionarGuiaRemision=null;
	
	public Border setResaltarSeleccionarGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarSeleccionarGuiaRemision= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarGuiaRemision() {
		return this.resaltarSeleccionarGuiaRemision;
	}
	
	public void setResaltarSeleccionarGuiaRemision(Border borderResaltarSeleccionarGuiaRemision) {
		this.resaltarSeleccionarGuiaRemision= borderResaltarSeleccionarGuiaRemision;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridGuiaRemision=null;
	public Boolean mostraridGuiaRemision=true;
	public Boolean activaridGuiaRemision=true;

	public Border resaltarid_empresaGuiaRemision=null;
	public Boolean mostrarid_empresaGuiaRemision=true;
	public Boolean activarid_empresaGuiaRemision=true;
	public Boolean cargarid_empresaGuiaRemision=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaGuiaRemision=false;//ConEventDepend=true

	public Border resaltarid_sucursalGuiaRemision=null;
	public Boolean mostrarid_sucursalGuiaRemision=true;
	public Boolean activarid_sucursalGuiaRemision=true;
	public Boolean cargarid_sucursalGuiaRemision=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalGuiaRemision=false;//ConEventDepend=true

	public Border resaltarid_ejercicioGuiaRemision=null;
	public Boolean mostrarid_ejercicioGuiaRemision=true;
	public Boolean activarid_ejercicioGuiaRemision=true;
	public Boolean cargarid_ejercicioGuiaRemision=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioGuiaRemision=false;//ConEventDepend=true

	public Border resaltarid_periodoGuiaRemision=null;
	public Boolean mostrarid_periodoGuiaRemision=true;
	public Boolean activarid_periodoGuiaRemision=true;
	public Boolean cargarid_periodoGuiaRemision=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoGuiaRemision=false;//ConEventDepend=true

	public Border resaltarid_usuarioGuiaRemision=null;
	public Boolean mostrarid_usuarioGuiaRemision=true;
	public Boolean activarid_usuarioGuiaRemision=true;
	public Boolean cargarid_usuarioGuiaRemision=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioGuiaRemision=false;//ConEventDepend=true

	public Border resaltarsecuencialGuiaRemision=null;
	public Boolean mostrarsecuencialGuiaRemision=true;
	public Boolean activarsecuencialGuiaRemision=true;

	public Border resaltarfecha_emisionGuiaRemision=null;
	public Boolean mostrarfecha_emisionGuiaRemision=true;
	public Boolean activarfecha_emisionGuiaRemision=true;

	public Border resaltarid_formatoGuiaRemision=null;
	public Boolean mostrarid_formatoGuiaRemision=true;
	public Boolean activarid_formatoGuiaRemision=true;
	public Boolean cargarid_formatoGuiaRemision=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoGuiaRemision=false;//ConEventDepend=true

	public Border resaltarid_tipo_precioGuiaRemision=null;
	public Boolean mostrarid_tipo_precioGuiaRemision=true;
	public Boolean activarid_tipo_precioGuiaRemision=true;
	public Boolean cargarid_tipo_precioGuiaRemision=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_precioGuiaRemision=false;//ConEventDepend=true

	public Border resaltarid_monedaGuiaRemision=null;
	public Boolean mostrarid_monedaGuiaRemision=true;
	public Boolean activarid_monedaGuiaRemision=true;
	public Boolean cargarid_monedaGuiaRemision=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaGuiaRemision=false;//ConEventDepend=true

	public Border resaltarnumero_camionGuiaRemision=null;
	public Boolean mostrarnumero_camionGuiaRemision=true;
	public Boolean activarnumero_camionGuiaRemision=true;

	public Border resaltarid_clienteGuiaRemision=null;
	public Boolean mostrarid_clienteGuiaRemision=true;
	public Boolean activarid_clienteGuiaRemision=true;
	public Boolean cargarid_clienteGuiaRemision=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteGuiaRemision=false;//ConEventDepend=true

	public Border resaltarid_vendedorGuiaRemision=null;
	public Boolean mostrarid_vendedorGuiaRemision=true;
	public Boolean activarid_vendedorGuiaRemision=true;
	public Boolean cargarid_vendedorGuiaRemision=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorGuiaRemision=false;//ConEventDepend=true

	public Border resaltarid_facturaGuiaRemision=null;
	public Boolean mostrarid_facturaGuiaRemision=true;
	public Boolean activarid_facturaGuiaRemision=true;
	public Boolean cargarid_facturaGuiaRemision=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaGuiaRemision=false;//ConEventDepend=true

	public Border resaltarid_transportistaGuiaRemision=null;
	public Boolean mostrarid_transportistaGuiaRemision=true;
	public Boolean activarid_transportistaGuiaRemision=true;
	public Boolean cargarid_transportistaGuiaRemision=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transportistaGuiaRemision=false;//ConEventDepend=true

	public Border resaltaridentificacionGuiaRemision=null;
	public Boolean mostraridentificacionGuiaRemision=true;
	public Boolean activaridentificacionGuiaRemision=true;

	public Border resaltarfecha_origenGuiaRemision=null;
	public Boolean mostrarfecha_origenGuiaRemision=true;
	public Boolean activarfecha_origenGuiaRemision=true;

	public Border resaltarfecha_destinoGuiaRemision=null;
	public Boolean mostrarfecha_destinoGuiaRemision=true;
	public Boolean activarfecha_destinoGuiaRemision=true;

	public Border resaltartransporte_codigoGuiaRemision=null;
	public Boolean mostrartransporte_codigoGuiaRemision=true;
	public Boolean activartransporte_codigoGuiaRemision=true;

	public Border resaltarcantidad_bultosGuiaRemision=null;
	public Boolean mostrarcantidad_bultosGuiaRemision=true;
	public Boolean activarcantidad_bultosGuiaRemision=true;

	public Border resaltarid_consultorGuiaRemision=null;
	public Boolean mostrarid_consultorGuiaRemision=true;
	public Boolean activarid_consultorGuiaRemision=true;
	public Boolean cargarid_consultorGuiaRemision=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_consultorGuiaRemision=false;//ConEventDepend=true

	public Border resaltarid_transporteGuiaRemision=null;
	public Boolean mostrarid_transporteGuiaRemision=true;
	public Boolean activarid_transporteGuiaRemision=true;
	public Boolean cargarid_transporteGuiaRemision=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transporteGuiaRemision=false;//ConEventDepend=true

	public Border resaltarid_sub_clienteGuiaRemision=null;
	public Boolean mostrarid_sub_clienteGuiaRemision=true;
	public Boolean activarid_sub_clienteGuiaRemision=true;
	public Boolean cargarid_sub_clienteGuiaRemision=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sub_clienteGuiaRemision=false;//ConEventDepend=true

	public Border resaltarid_empleadoGuiaRemision=null;
	public Boolean mostrarid_empleadoGuiaRemision=true;
	public Boolean activarid_empleadoGuiaRemision=true;
	public Boolean cargarid_empleadoGuiaRemision=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoGuiaRemision=false;//ConEventDepend=true

	public Border resaltarid_ciudad_origenGuiaRemision=null;
	public Boolean mostrarid_ciudad_origenGuiaRemision=true;
	public Boolean activarid_ciudad_origenGuiaRemision=true;
	public Boolean cargarid_ciudad_origenGuiaRemision=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ciudad_origenGuiaRemision=false;//ConEventDepend=true

	public Border resaltarid_ciudad_destinoGuiaRemision=null;
	public Boolean mostrarid_ciudad_destinoGuiaRemision=true;
	public Boolean activarid_ciudad_destinoGuiaRemision=true;
	public Boolean cargarid_ciudad_destinoGuiaRemision=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ciudad_destinoGuiaRemision=false;//ConEventDepend=true

	public Border resaltarid_tipo_llamadaGuiaRemision=null;
	public Boolean mostrarid_tipo_llamadaGuiaRemision=true;
	public Boolean activarid_tipo_llamadaGuiaRemision=true;
	public Boolean cargarid_tipo_llamadaGuiaRemision=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_llamadaGuiaRemision=false;//ConEventDepend=true

	public Border resaltarhora_inicioGuiaRemision=null;
	public Boolean mostrarhora_inicioGuiaRemision=true;
	public Boolean activarhora_inicioGuiaRemision=true;

	public Border resaltarhora_finGuiaRemision=null;
	public Boolean mostrarhora_finGuiaRemision=true;
	public Boolean activarhora_finGuiaRemision=true;

	public Border resaltarcupoGuiaRemision=null;
	public Boolean mostrarcupoGuiaRemision=true;
	public Boolean activarcupoGuiaRemision=true;

	public Border resaltarsaldoGuiaRemision=null;
	public Boolean mostrarsaldoGuiaRemision=true;
	public Boolean activarsaldoGuiaRemision=true;

	public Border resaltardocumentoGuiaRemision=null;
	public Boolean mostrardocumentoGuiaRemision=true;
	public Boolean activardocumentoGuiaRemision=true;

	public Border resaltardisponibleGuiaRemision=null;
	public Boolean mostrardisponibleGuiaRemision=true;
	public Boolean activardisponibleGuiaRemision=true;

	public Border resaltardescripcionGuiaRemision=null;
	public Boolean mostrardescripcionGuiaRemision=true;
	public Boolean activardescripcionGuiaRemision=true;

	public Border resaltartotal_ivaGuiaRemision=null;
	public Boolean mostrartotal_ivaGuiaRemision=true;
	public Boolean activartotal_ivaGuiaRemision=true;

	public Border resaltartotal_sin_ivaGuiaRemision=null;
	public Boolean mostrartotal_sin_ivaGuiaRemision=true;
	public Boolean activartotal_sin_ivaGuiaRemision=true;

	public Border resaltardescuentoGuiaRemision=null;
	public Boolean mostrardescuentoGuiaRemision=true;
	public Boolean activardescuentoGuiaRemision=true;

	public Border resaltarfleteGuiaRemision=null;
	public Boolean mostrarfleteGuiaRemision=true;
	public Boolean activarfleteGuiaRemision=true;

	public Border resaltarotroGuiaRemision=null;
	public Boolean mostrarotroGuiaRemision=true;
	public Boolean activarotroGuiaRemision=true;

	public Border resaltarfinanciamientoGuiaRemision=null;
	public Boolean mostrarfinanciamientoGuiaRemision=true;
	public Boolean activarfinanciamientoGuiaRemision=true;

	public Border resaltarivaGuiaRemision=null;
	public Boolean mostrarivaGuiaRemision=true;
	public Boolean activarivaGuiaRemision=true;

	public Border resaltartotalGuiaRemision=null;
	public Boolean mostrartotalGuiaRemision=true;
	public Boolean activartotalGuiaRemision=true;

	public Border resaltarmonto_retencionGuiaRemision=null;
	public Boolean mostrarmonto_retencionGuiaRemision=true;
	public Boolean activarmonto_retencionGuiaRemision=false;

	public Border resaltarid_tipo_cambioGuiaRemision=null;
	public Boolean mostrarid_tipo_cambioGuiaRemision=true;
	public Boolean activarid_tipo_cambioGuiaRemision=false;
	public Boolean cargarid_tipo_cambioGuiaRemision=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_cambioGuiaRemision=false;//ConEventDepend=true

	public Border resaltarfechaGuiaRemision=null;
	public Boolean mostrarfechaGuiaRemision=true;
	public Boolean activarfechaGuiaRemision=false;

	public Border resaltarruc_clienteGuiaRemision=null;
	public Boolean mostrarruc_clienteGuiaRemision=true;
	public Boolean activarruc_clienteGuiaRemision=false;

	public Border resaltarnombre_clienteGuiaRemision=null;
	public Boolean mostrarnombre_clienteGuiaRemision=true;
	public Boolean activarnombre_clienteGuiaRemision=false;

	public Border resaltartelefono_clienteGuiaRemision=null;
	public Boolean mostrartelefono_clienteGuiaRemision=true;
	public Boolean activartelefono_clienteGuiaRemision=false;

	public Border resaltardireccion_clienteGuiaRemision=null;
	public Boolean mostrardireccion_clienteGuiaRemision=true;
	public Boolean activardireccion_clienteGuiaRemision=false;

	public Border resaltarnumero_pre_impresoGuiaRemision=null;
	public Boolean mostrarnumero_pre_impresoGuiaRemision=true;
	public Boolean activarnumero_pre_impresoGuiaRemision=false;

	public Border resaltarpeso_brutoGuiaRemision=null;
	public Boolean mostrarpeso_brutoGuiaRemision=true;
	public Boolean activarpeso_brutoGuiaRemision=false;

	public Border resaltarfecha_autorizacionGuiaRemision=null;
	public Boolean mostrarfecha_autorizacionGuiaRemision=true;
	public Boolean activarfecha_autorizacionGuiaRemision=false;

	public Border resaltarfecha_vencimientoGuiaRemision=null;
	public Boolean mostrarfecha_vencimientoGuiaRemision=true;
	public Boolean activarfecha_vencimientoGuiaRemision=false;

	
	

	public Border setResaltaridGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltaridGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridGuiaRemision() {
		return this.resaltaridGuiaRemision;
	}

	public void setResaltaridGuiaRemision(Border borderResaltar) {
		this.resaltaridGuiaRemision= borderResaltar;
	}

	public Boolean getMostraridGuiaRemision() {
		return this.mostraridGuiaRemision;
	}

	public void setMostraridGuiaRemision(Boolean mostraridGuiaRemision) {
		this.mostraridGuiaRemision= mostraridGuiaRemision;
	}

	public Boolean getActivaridGuiaRemision() {
		return this.activaridGuiaRemision;
	}

	public void setActivaridGuiaRemision(Boolean activaridGuiaRemision) {
		this.activaridGuiaRemision= activaridGuiaRemision;
	}

	public Border setResaltarid_empresaGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarid_empresaGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaGuiaRemision() {
		return this.resaltarid_empresaGuiaRemision;
	}

	public void setResaltarid_empresaGuiaRemision(Border borderResaltar) {
		this.resaltarid_empresaGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarid_empresaGuiaRemision() {
		return this.mostrarid_empresaGuiaRemision;
	}

	public void setMostrarid_empresaGuiaRemision(Boolean mostrarid_empresaGuiaRemision) {
		this.mostrarid_empresaGuiaRemision= mostrarid_empresaGuiaRemision;
	}

	public Boolean getActivarid_empresaGuiaRemision() {
		return this.activarid_empresaGuiaRemision;
	}

	public void setActivarid_empresaGuiaRemision(Boolean activarid_empresaGuiaRemision) {
		this.activarid_empresaGuiaRemision= activarid_empresaGuiaRemision;
	}

	public Boolean getCargarid_empresaGuiaRemision() {
		return this.cargarid_empresaGuiaRemision;
	}

	public void setCargarid_empresaGuiaRemision(Boolean cargarid_empresaGuiaRemision) {
		this.cargarid_empresaGuiaRemision= cargarid_empresaGuiaRemision;
	}

	public Border setResaltarid_sucursalGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarid_sucursalGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalGuiaRemision() {
		return this.resaltarid_sucursalGuiaRemision;
	}

	public void setResaltarid_sucursalGuiaRemision(Border borderResaltar) {
		this.resaltarid_sucursalGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarid_sucursalGuiaRemision() {
		return this.mostrarid_sucursalGuiaRemision;
	}

	public void setMostrarid_sucursalGuiaRemision(Boolean mostrarid_sucursalGuiaRemision) {
		this.mostrarid_sucursalGuiaRemision= mostrarid_sucursalGuiaRemision;
	}

	public Boolean getActivarid_sucursalGuiaRemision() {
		return this.activarid_sucursalGuiaRemision;
	}

	public void setActivarid_sucursalGuiaRemision(Boolean activarid_sucursalGuiaRemision) {
		this.activarid_sucursalGuiaRemision= activarid_sucursalGuiaRemision;
	}

	public Boolean getCargarid_sucursalGuiaRemision() {
		return this.cargarid_sucursalGuiaRemision;
	}

	public void setCargarid_sucursalGuiaRemision(Boolean cargarid_sucursalGuiaRemision) {
		this.cargarid_sucursalGuiaRemision= cargarid_sucursalGuiaRemision;
	}

	public Border setResaltarid_ejercicioGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioGuiaRemision() {
		return this.resaltarid_ejercicioGuiaRemision;
	}

	public void setResaltarid_ejercicioGuiaRemision(Border borderResaltar) {
		this.resaltarid_ejercicioGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioGuiaRemision() {
		return this.mostrarid_ejercicioGuiaRemision;
	}

	public void setMostrarid_ejercicioGuiaRemision(Boolean mostrarid_ejercicioGuiaRemision) {
		this.mostrarid_ejercicioGuiaRemision= mostrarid_ejercicioGuiaRemision;
	}

	public Boolean getActivarid_ejercicioGuiaRemision() {
		return this.activarid_ejercicioGuiaRemision;
	}

	public void setActivarid_ejercicioGuiaRemision(Boolean activarid_ejercicioGuiaRemision) {
		this.activarid_ejercicioGuiaRemision= activarid_ejercicioGuiaRemision;
	}

	public Boolean getCargarid_ejercicioGuiaRemision() {
		return this.cargarid_ejercicioGuiaRemision;
	}

	public void setCargarid_ejercicioGuiaRemision(Boolean cargarid_ejercicioGuiaRemision) {
		this.cargarid_ejercicioGuiaRemision= cargarid_ejercicioGuiaRemision;
	}

	public Border setResaltarid_periodoGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarid_periodoGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoGuiaRemision() {
		return this.resaltarid_periodoGuiaRemision;
	}

	public void setResaltarid_periodoGuiaRemision(Border borderResaltar) {
		this.resaltarid_periodoGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarid_periodoGuiaRemision() {
		return this.mostrarid_periodoGuiaRemision;
	}

	public void setMostrarid_periodoGuiaRemision(Boolean mostrarid_periodoGuiaRemision) {
		this.mostrarid_periodoGuiaRemision= mostrarid_periodoGuiaRemision;
	}

	public Boolean getActivarid_periodoGuiaRemision() {
		return this.activarid_periodoGuiaRemision;
	}

	public void setActivarid_periodoGuiaRemision(Boolean activarid_periodoGuiaRemision) {
		this.activarid_periodoGuiaRemision= activarid_periodoGuiaRemision;
	}

	public Boolean getCargarid_periodoGuiaRemision() {
		return this.cargarid_periodoGuiaRemision;
	}

	public void setCargarid_periodoGuiaRemision(Boolean cargarid_periodoGuiaRemision) {
		this.cargarid_periodoGuiaRemision= cargarid_periodoGuiaRemision;
	}

	public Border setResaltarid_usuarioGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarid_usuarioGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioGuiaRemision() {
		return this.resaltarid_usuarioGuiaRemision;
	}

	public void setResaltarid_usuarioGuiaRemision(Border borderResaltar) {
		this.resaltarid_usuarioGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarid_usuarioGuiaRemision() {
		return this.mostrarid_usuarioGuiaRemision;
	}

	public void setMostrarid_usuarioGuiaRemision(Boolean mostrarid_usuarioGuiaRemision) {
		this.mostrarid_usuarioGuiaRemision= mostrarid_usuarioGuiaRemision;
	}

	public Boolean getActivarid_usuarioGuiaRemision() {
		return this.activarid_usuarioGuiaRemision;
	}

	public void setActivarid_usuarioGuiaRemision(Boolean activarid_usuarioGuiaRemision) {
		this.activarid_usuarioGuiaRemision= activarid_usuarioGuiaRemision;
	}

	public Boolean getCargarid_usuarioGuiaRemision() {
		return this.cargarid_usuarioGuiaRemision;
	}

	public void setCargarid_usuarioGuiaRemision(Boolean cargarid_usuarioGuiaRemision) {
		this.cargarid_usuarioGuiaRemision= cargarid_usuarioGuiaRemision;
	}

	public Border setResaltarsecuencialGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarsecuencialGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialGuiaRemision() {
		return this.resaltarsecuencialGuiaRemision;
	}

	public void setResaltarsecuencialGuiaRemision(Border borderResaltar) {
		this.resaltarsecuencialGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarsecuencialGuiaRemision() {
		return this.mostrarsecuencialGuiaRemision;
	}

	public void setMostrarsecuencialGuiaRemision(Boolean mostrarsecuencialGuiaRemision) {
		this.mostrarsecuencialGuiaRemision= mostrarsecuencialGuiaRemision;
	}

	public Boolean getActivarsecuencialGuiaRemision() {
		return this.activarsecuencialGuiaRemision;
	}

	public void setActivarsecuencialGuiaRemision(Boolean activarsecuencialGuiaRemision) {
		this.activarsecuencialGuiaRemision= activarsecuencialGuiaRemision;
	}

	public Border setResaltarfecha_emisionGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionGuiaRemision() {
		return this.resaltarfecha_emisionGuiaRemision;
	}

	public void setResaltarfecha_emisionGuiaRemision(Border borderResaltar) {
		this.resaltarfecha_emisionGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionGuiaRemision() {
		return this.mostrarfecha_emisionGuiaRemision;
	}

	public void setMostrarfecha_emisionGuiaRemision(Boolean mostrarfecha_emisionGuiaRemision) {
		this.mostrarfecha_emisionGuiaRemision= mostrarfecha_emisionGuiaRemision;
	}

	public Boolean getActivarfecha_emisionGuiaRemision() {
		return this.activarfecha_emisionGuiaRemision;
	}

	public void setActivarfecha_emisionGuiaRemision(Boolean activarfecha_emisionGuiaRemision) {
		this.activarfecha_emisionGuiaRemision= activarfecha_emisionGuiaRemision;
	}

	public Border setResaltarid_formatoGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarid_formatoGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoGuiaRemision() {
		return this.resaltarid_formatoGuiaRemision;
	}

	public void setResaltarid_formatoGuiaRemision(Border borderResaltar) {
		this.resaltarid_formatoGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarid_formatoGuiaRemision() {
		return this.mostrarid_formatoGuiaRemision;
	}

	public void setMostrarid_formatoGuiaRemision(Boolean mostrarid_formatoGuiaRemision) {
		this.mostrarid_formatoGuiaRemision= mostrarid_formatoGuiaRemision;
	}

	public Boolean getActivarid_formatoGuiaRemision() {
		return this.activarid_formatoGuiaRemision;
	}

	public void setActivarid_formatoGuiaRemision(Boolean activarid_formatoGuiaRemision) {
		this.activarid_formatoGuiaRemision= activarid_formatoGuiaRemision;
	}

	public Boolean getCargarid_formatoGuiaRemision() {
		return this.cargarid_formatoGuiaRemision;
	}

	public void setCargarid_formatoGuiaRemision(Boolean cargarid_formatoGuiaRemision) {
		this.cargarid_formatoGuiaRemision= cargarid_formatoGuiaRemision;
	}

	public Border setResaltarid_tipo_precioGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarid_tipo_precioGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_precioGuiaRemision() {
		return this.resaltarid_tipo_precioGuiaRemision;
	}

	public void setResaltarid_tipo_precioGuiaRemision(Border borderResaltar) {
		this.resaltarid_tipo_precioGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarid_tipo_precioGuiaRemision() {
		return this.mostrarid_tipo_precioGuiaRemision;
	}

	public void setMostrarid_tipo_precioGuiaRemision(Boolean mostrarid_tipo_precioGuiaRemision) {
		this.mostrarid_tipo_precioGuiaRemision= mostrarid_tipo_precioGuiaRemision;
	}

	public Boolean getActivarid_tipo_precioGuiaRemision() {
		return this.activarid_tipo_precioGuiaRemision;
	}

	public void setActivarid_tipo_precioGuiaRemision(Boolean activarid_tipo_precioGuiaRemision) {
		this.activarid_tipo_precioGuiaRemision= activarid_tipo_precioGuiaRemision;
	}

	public Boolean getCargarid_tipo_precioGuiaRemision() {
		return this.cargarid_tipo_precioGuiaRemision;
	}

	public void setCargarid_tipo_precioGuiaRemision(Boolean cargarid_tipo_precioGuiaRemision) {
		this.cargarid_tipo_precioGuiaRemision= cargarid_tipo_precioGuiaRemision;
	}

	public Border setResaltarid_monedaGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarid_monedaGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaGuiaRemision() {
		return this.resaltarid_monedaGuiaRemision;
	}

	public void setResaltarid_monedaGuiaRemision(Border borderResaltar) {
		this.resaltarid_monedaGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarid_monedaGuiaRemision() {
		return this.mostrarid_monedaGuiaRemision;
	}

	public void setMostrarid_monedaGuiaRemision(Boolean mostrarid_monedaGuiaRemision) {
		this.mostrarid_monedaGuiaRemision= mostrarid_monedaGuiaRemision;
	}

	public Boolean getActivarid_monedaGuiaRemision() {
		return this.activarid_monedaGuiaRemision;
	}

	public void setActivarid_monedaGuiaRemision(Boolean activarid_monedaGuiaRemision) {
		this.activarid_monedaGuiaRemision= activarid_monedaGuiaRemision;
	}

	public Boolean getCargarid_monedaGuiaRemision() {
		return this.cargarid_monedaGuiaRemision;
	}

	public void setCargarid_monedaGuiaRemision(Boolean cargarid_monedaGuiaRemision) {
		this.cargarid_monedaGuiaRemision= cargarid_monedaGuiaRemision;
	}

	public Border setResaltarnumero_camionGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarnumero_camionGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_camionGuiaRemision() {
		return this.resaltarnumero_camionGuiaRemision;
	}

	public void setResaltarnumero_camionGuiaRemision(Border borderResaltar) {
		this.resaltarnumero_camionGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarnumero_camionGuiaRemision() {
		return this.mostrarnumero_camionGuiaRemision;
	}

	public void setMostrarnumero_camionGuiaRemision(Boolean mostrarnumero_camionGuiaRemision) {
		this.mostrarnumero_camionGuiaRemision= mostrarnumero_camionGuiaRemision;
	}

	public Boolean getActivarnumero_camionGuiaRemision() {
		return this.activarnumero_camionGuiaRemision;
	}

	public void setActivarnumero_camionGuiaRemision(Boolean activarnumero_camionGuiaRemision) {
		this.activarnumero_camionGuiaRemision= activarnumero_camionGuiaRemision;
	}

	public Border setResaltarid_clienteGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarid_clienteGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteGuiaRemision() {
		return this.resaltarid_clienteGuiaRemision;
	}

	public void setResaltarid_clienteGuiaRemision(Border borderResaltar) {
		this.resaltarid_clienteGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarid_clienteGuiaRemision() {
		return this.mostrarid_clienteGuiaRemision;
	}

	public void setMostrarid_clienteGuiaRemision(Boolean mostrarid_clienteGuiaRemision) {
		this.mostrarid_clienteGuiaRemision= mostrarid_clienteGuiaRemision;
	}

	public Boolean getActivarid_clienteGuiaRemision() {
		return this.activarid_clienteGuiaRemision;
	}

	public void setActivarid_clienteGuiaRemision(Boolean activarid_clienteGuiaRemision) {
		this.activarid_clienteGuiaRemision= activarid_clienteGuiaRemision;
	}

	public Boolean getCargarid_clienteGuiaRemision() {
		return this.cargarid_clienteGuiaRemision;
	}

	public void setCargarid_clienteGuiaRemision(Boolean cargarid_clienteGuiaRemision) {
		this.cargarid_clienteGuiaRemision= cargarid_clienteGuiaRemision;
	}

	public Border setResaltarid_vendedorGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarid_vendedorGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorGuiaRemision() {
		return this.resaltarid_vendedorGuiaRemision;
	}

	public void setResaltarid_vendedorGuiaRemision(Border borderResaltar) {
		this.resaltarid_vendedorGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarid_vendedorGuiaRemision() {
		return this.mostrarid_vendedorGuiaRemision;
	}

	public void setMostrarid_vendedorGuiaRemision(Boolean mostrarid_vendedorGuiaRemision) {
		this.mostrarid_vendedorGuiaRemision= mostrarid_vendedorGuiaRemision;
	}

	public Boolean getActivarid_vendedorGuiaRemision() {
		return this.activarid_vendedorGuiaRemision;
	}

	public void setActivarid_vendedorGuiaRemision(Boolean activarid_vendedorGuiaRemision) {
		this.activarid_vendedorGuiaRemision= activarid_vendedorGuiaRemision;
	}

	public Boolean getCargarid_vendedorGuiaRemision() {
		return this.cargarid_vendedorGuiaRemision;
	}

	public void setCargarid_vendedorGuiaRemision(Boolean cargarid_vendedorGuiaRemision) {
		this.cargarid_vendedorGuiaRemision= cargarid_vendedorGuiaRemision;
	}

	public Border setResaltarid_facturaGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarid_facturaGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaGuiaRemision() {
		return this.resaltarid_facturaGuiaRemision;
	}

	public void setResaltarid_facturaGuiaRemision(Border borderResaltar) {
		this.resaltarid_facturaGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarid_facturaGuiaRemision() {
		return this.mostrarid_facturaGuiaRemision;
	}

	public void setMostrarid_facturaGuiaRemision(Boolean mostrarid_facturaGuiaRemision) {
		this.mostrarid_facturaGuiaRemision= mostrarid_facturaGuiaRemision;
	}

	public Boolean getActivarid_facturaGuiaRemision() {
		return this.activarid_facturaGuiaRemision;
	}

	public void setActivarid_facturaGuiaRemision(Boolean activarid_facturaGuiaRemision) {
		this.activarid_facturaGuiaRemision= activarid_facturaGuiaRemision;
	}

	public Boolean getCargarid_facturaGuiaRemision() {
		return this.cargarid_facturaGuiaRemision;
	}

	public void setCargarid_facturaGuiaRemision(Boolean cargarid_facturaGuiaRemision) {
		this.cargarid_facturaGuiaRemision= cargarid_facturaGuiaRemision;
	}

	public Border setResaltarid_transportistaGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarid_transportistaGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transportistaGuiaRemision() {
		return this.resaltarid_transportistaGuiaRemision;
	}

	public void setResaltarid_transportistaGuiaRemision(Border borderResaltar) {
		this.resaltarid_transportistaGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarid_transportistaGuiaRemision() {
		return this.mostrarid_transportistaGuiaRemision;
	}

	public void setMostrarid_transportistaGuiaRemision(Boolean mostrarid_transportistaGuiaRemision) {
		this.mostrarid_transportistaGuiaRemision= mostrarid_transportistaGuiaRemision;
	}

	public Boolean getActivarid_transportistaGuiaRemision() {
		return this.activarid_transportistaGuiaRemision;
	}

	public void setActivarid_transportistaGuiaRemision(Boolean activarid_transportistaGuiaRemision) {
		this.activarid_transportistaGuiaRemision= activarid_transportistaGuiaRemision;
	}

	public Boolean getCargarid_transportistaGuiaRemision() {
		return this.cargarid_transportistaGuiaRemision;
	}

	public void setCargarid_transportistaGuiaRemision(Boolean cargarid_transportistaGuiaRemision) {
		this.cargarid_transportistaGuiaRemision= cargarid_transportistaGuiaRemision;
	}

	public Border setResaltaridentificacionGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltaridentificacionGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridentificacionGuiaRemision() {
		return this.resaltaridentificacionGuiaRemision;
	}

	public void setResaltaridentificacionGuiaRemision(Border borderResaltar) {
		this.resaltaridentificacionGuiaRemision= borderResaltar;
	}

	public Boolean getMostraridentificacionGuiaRemision() {
		return this.mostraridentificacionGuiaRemision;
	}

	public void setMostraridentificacionGuiaRemision(Boolean mostraridentificacionGuiaRemision) {
		this.mostraridentificacionGuiaRemision= mostraridentificacionGuiaRemision;
	}

	public Boolean getActivaridentificacionGuiaRemision() {
		return this.activaridentificacionGuiaRemision;
	}

	public void setActivaridentificacionGuiaRemision(Boolean activaridentificacionGuiaRemision) {
		this.activaridentificacionGuiaRemision= activaridentificacionGuiaRemision;
	}

	public Border setResaltarfecha_origenGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarfecha_origenGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_origenGuiaRemision() {
		return this.resaltarfecha_origenGuiaRemision;
	}

	public void setResaltarfecha_origenGuiaRemision(Border borderResaltar) {
		this.resaltarfecha_origenGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarfecha_origenGuiaRemision() {
		return this.mostrarfecha_origenGuiaRemision;
	}

	public void setMostrarfecha_origenGuiaRemision(Boolean mostrarfecha_origenGuiaRemision) {
		this.mostrarfecha_origenGuiaRemision= mostrarfecha_origenGuiaRemision;
	}

	public Boolean getActivarfecha_origenGuiaRemision() {
		return this.activarfecha_origenGuiaRemision;
	}

	public void setActivarfecha_origenGuiaRemision(Boolean activarfecha_origenGuiaRemision) {
		this.activarfecha_origenGuiaRemision= activarfecha_origenGuiaRemision;
	}

	public Border setResaltarfecha_destinoGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarfecha_destinoGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_destinoGuiaRemision() {
		return this.resaltarfecha_destinoGuiaRemision;
	}

	public void setResaltarfecha_destinoGuiaRemision(Border borderResaltar) {
		this.resaltarfecha_destinoGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarfecha_destinoGuiaRemision() {
		return this.mostrarfecha_destinoGuiaRemision;
	}

	public void setMostrarfecha_destinoGuiaRemision(Boolean mostrarfecha_destinoGuiaRemision) {
		this.mostrarfecha_destinoGuiaRemision= mostrarfecha_destinoGuiaRemision;
	}

	public Boolean getActivarfecha_destinoGuiaRemision() {
		return this.activarfecha_destinoGuiaRemision;
	}

	public void setActivarfecha_destinoGuiaRemision(Boolean activarfecha_destinoGuiaRemision) {
		this.activarfecha_destinoGuiaRemision= activarfecha_destinoGuiaRemision;
	}

	public Border setResaltartransporte_codigoGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltartransporte_codigoGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartransporte_codigoGuiaRemision() {
		return this.resaltartransporte_codigoGuiaRemision;
	}

	public void setResaltartransporte_codigoGuiaRemision(Border borderResaltar) {
		this.resaltartransporte_codigoGuiaRemision= borderResaltar;
	}

	public Boolean getMostrartransporte_codigoGuiaRemision() {
		return this.mostrartransporte_codigoGuiaRemision;
	}

	public void setMostrartransporte_codigoGuiaRemision(Boolean mostrartransporte_codigoGuiaRemision) {
		this.mostrartransporte_codigoGuiaRemision= mostrartransporte_codigoGuiaRemision;
	}

	public Boolean getActivartransporte_codigoGuiaRemision() {
		return this.activartransporte_codigoGuiaRemision;
	}

	public void setActivartransporte_codigoGuiaRemision(Boolean activartransporte_codigoGuiaRemision) {
		this.activartransporte_codigoGuiaRemision= activartransporte_codigoGuiaRemision;
	}

	public Border setResaltarcantidad_bultosGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarcantidad_bultosGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_bultosGuiaRemision() {
		return this.resaltarcantidad_bultosGuiaRemision;
	}

	public void setResaltarcantidad_bultosGuiaRemision(Border borderResaltar) {
		this.resaltarcantidad_bultosGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarcantidad_bultosGuiaRemision() {
		return this.mostrarcantidad_bultosGuiaRemision;
	}

	public void setMostrarcantidad_bultosGuiaRemision(Boolean mostrarcantidad_bultosGuiaRemision) {
		this.mostrarcantidad_bultosGuiaRemision= mostrarcantidad_bultosGuiaRemision;
	}

	public Boolean getActivarcantidad_bultosGuiaRemision() {
		return this.activarcantidad_bultosGuiaRemision;
	}

	public void setActivarcantidad_bultosGuiaRemision(Boolean activarcantidad_bultosGuiaRemision) {
		this.activarcantidad_bultosGuiaRemision= activarcantidad_bultosGuiaRemision;
	}

	public Border setResaltarid_consultorGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarid_consultorGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_consultorGuiaRemision() {
		return this.resaltarid_consultorGuiaRemision;
	}

	public void setResaltarid_consultorGuiaRemision(Border borderResaltar) {
		this.resaltarid_consultorGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarid_consultorGuiaRemision() {
		return this.mostrarid_consultorGuiaRemision;
	}

	public void setMostrarid_consultorGuiaRemision(Boolean mostrarid_consultorGuiaRemision) {
		this.mostrarid_consultorGuiaRemision= mostrarid_consultorGuiaRemision;
	}

	public Boolean getActivarid_consultorGuiaRemision() {
		return this.activarid_consultorGuiaRemision;
	}

	public void setActivarid_consultorGuiaRemision(Boolean activarid_consultorGuiaRemision) {
		this.activarid_consultorGuiaRemision= activarid_consultorGuiaRemision;
	}

	public Boolean getCargarid_consultorGuiaRemision() {
		return this.cargarid_consultorGuiaRemision;
	}

	public void setCargarid_consultorGuiaRemision(Boolean cargarid_consultorGuiaRemision) {
		this.cargarid_consultorGuiaRemision= cargarid_consultorGuiaRemision;
	}

	public Border setResaltarid_transporteGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarid_transporteGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transporteGuiaRemision() {
		return this.resaltarid_transporteGuiaRemision;
	}

	public void setResaltarid_transporteGuiaRemision(Border borderResaltar) {
		this.resaltarid_transporteGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarid_transporteGuiaRemision() {
		return this.mostrarid_transporteGuiaRemision;
	}

	public void setMostrarid_transporteGuiaRemision(Boolean mostrarid_transporteGuiaRemision) {
		this.mostrarid_transporteGuiaRemision= mostrarid_transporteGuiaRemision;
	}

	public Boolean getActivarid_transporteGuiaRemision() {
		return this.activarid_transporteGuiaRemision;
	}

	public void setActivarid_transporteGuiaRemision(Boolean activarid_transporteGuiaRemision) {
		this.activarid_transporteGuiaRemision= activarid_transporteGuiaRemision;
	}

	public Boolean getCargarid_transporteGuiaRemision() {
		return this.cargarid_transporteGuiaRemision;
	}

	public void setCargarid_transporteGuiaRemision(Boolean cargarid_transporteGuiaRemision) {
		this.cargarid_transporteGuiaRemision= cargarid_transporteGuiaRemision;
	}

	public Border setResaltarid_sub_clienteGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarid_sub_clienteGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sub_clienteGuiaRemision() {
		return this.resaltarid_sub_clienteGuiaRemision;
	}

	public void setResaltarid_sub_clienteGuiaRemision(Border borderResaltar) {
		this.resaltarid_sub_clienteGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarid_sub_clienteGuiaRemision() {
		return this.mostrarid_sub_clienteGuiaRemision;
	}

	public void setMostrarid_sub_clienteGuiaRemision(Boolean mostrarid_sub_clienteGuiaRemision) {
		this.mostrarid_sub_clienteGuiaRemision= mostrarid_sub_clienteGuiaRemision;
	}

	public Boolean getActivarid_sub_clienteGuiaRemision() {
		return this.activarid_sub_clienteGuiaRemision;
	}

	public void setActivarid_sub_clienteGuiaRemision(Boolean activarid_sub_clienteGuiaRemision) {
		this.activarid_sub_clienteGuiaRemision= activarid_sub_clienteGuiaRemision;
	}

	public Boolean getCargarid_sub_clienteGuiaRemision() {
		return this.cargarid_sub_clienteGuiaRemision;
	}

	public void setCargarid_sub_clienteGuiaRemision(Boolean cargarid_sub_clienteGuiaRemision) {
		this.cargarid_sub_clienteGuiaRemision= cargarid_sub_clienteGuiaRemision;
	}

	public Border setResaltarid_empleadoGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarid_empleadoGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoGuiaRemision() {
		return this.resaltarid_empleadoGuiaRemision;
	}

	public void setResaltarid_empleadoGuiaRemision(Border borderResaltar) {
		this.resaltarid_empleadoGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarid_empleadoGuiaRemision() {
		return this.mostrarid_empleadoGuiaRemision;
	}

	public void setMostrarid_empleadoGuiaRemision(Boolean mostrarid_empleadoGuiaRemision) {
		this.mostrarid_empleadoGuiaRemision= mostrarid_empleadoGuiaRemision;
	}

	public Boolean getActivarid_empleadoGuiaRemision() {
		return this.activarid_empleadoGuiaRemision;
	}

	public void setActivarid_empleadoGuiaRemision(Boolean activarid_empleadoGuiaRemision) {
		this.activarid_empleadoGuiaRemision= activarid_empleadoGuiaRemision;
	}

	public Boolean getCargarid_empleadoGuiaRemision() {
		return this.cargarid_empleadoGuiaRemision;
	}

	public void setCargarid_empleadoGuiaRemision(Boolean cargarid_empleadoGuiaRemision) {
		this.cargarid_empleadoGuiaRemision= cargarid_empleadoGuiaRemision;
	}

	public Border setResaltarid_ciudad_origenGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarid_ciudad_origenGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ciudad_origenGuiaRemision() {
		return this.resaltarid_ciudad_origenGuiaRemision;
	}

	public void setResaltarid_ciudad_origenGuiaRemision(Border borderResaltar) {
		this.resaltarid_ciudad_origenGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarid_ciudad_origenGuiaRemision() {
		return this.mostrarid_ciudad_origenGuiaRemision;
	}

	public void setMostrarid_ciudad_origenGuiaRemision(Boolean mostrarid_ciudad_origenGuiaRemision) {
		this.mostrarid_ciudad_origenGuiaRemision= mostrarid_ciudad_origenGuiaRemision;
	}

	public Boolean getActivarid_ciudad_origenGuiaRemision() {
		return this.activarid_ciudad_origenGuiaRemision;
	}

	public void setActivarid_ciudad_origenGuiaRemision(Boolean activarid_ciudad_origenGuiaRemision) {
		this.activarid_ciudad_origenGuiaRemision= activarid_ciudad_origenGuiaRemision;
	}

	public Boolean getCargarid_ciudad_origenGuiaRemision() {
		return this.cargarid_ciudad_origenGuiaRemision;
	}

	public void setCargarid_ciudad_origenGuiaRemision(Boolean cargarid_ciudad_origenGuiaRemision) {
		this.cargarid_ciudad_origenGuiaRemision= cargarid_ciudad_origenGuiaRemision;
	}

	public Border setResaltarid_ciudad_destinoGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarid_ciudad_destinoGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ciudad_destinoGuiaRemision() {
		return this.resaltarid_ciudad_destinoGuiaRemision;
	}

	public void setResaltarid_ciudad_destinoGuiaRemision(Border borderResaltar) {
		this.resaltarid_ciudad_destinoGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarid_ciudad_destinoGuiaRemision() {
		return this.mostrarid_ciudad_destinoGuiaRemision;
	}

	public void setMostrarid_ciudad_destinoGuiaRemision(Boolean mostrarid_ciudad_destinoGuiaRemision) {
		this.mostrarid_ciudad_destinoGuiaRemision= mostrarid_ciudad_destinoGuiaRemision;
	}

	public Boolean getActivarid_ciudad_destinoGuiaRemision() {
		return this.activarid_ciudad_destinoGuiaRemision;
	}

	public void setActivarid_ciudad_destinoGuiaRemision(Boolean activarid_ciudad_destinoGuiaRemision) {
		this.activarid_ciudad_destinoGuiaRemision= activarid_ciudad_destinoGuiaRemision;
	}

	public Boolean getCargarid_ciudad_destinoGuiaRemision() {
		return this.cargarid_ciudad_destinoGuiaRemision;
	}

	public void setCargarid_ciudad_destinoGuiaRemision(Boolean cargarid_ciudad_destinoGuiaRemision) {
		this.cargarid_ciudad_destinoGuiaRemision= cargarid_ciudad_destinoGuiaRemision;
	}

	public Border setResaltarid_tipo_llamadaGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarid_tipo_llamadaGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_llamadaGuiaRemision() {
		return this.resaltarid_tipo_llamadaGuiaRemision;
	}

	public void setResaltarid_tipo_llamadaGuiaRemision(Border borderResaltar) {
		this.resaltarid_tipo_llamadaGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarid_tipo_llamadaGuiaRemision() {
		return this.mostrarid_tipo_llamadaGuiaRemision;
	}

	public void setMostrarid_tipo_llamadaGuiaRemision(Boolean mostrarid_tipo_llamadaGuiaRemision) {
		this.mostrarid_tipo_llamadaGuiaRemision= mostrarid_tipo_llamadaGuiaRemision;
	}

	public Boolean getActivarid_tipo_llamadaGuiaRemision() {
		return this.activarid_tipo_llamadaGuiaRemision;
	}

	public void setActivarid_tipo_llamadaGuiaRemision(Boolean activarid_tipo_llamadaGuiaRemision) {
		this.activarid_tipo_llamadaGuiaRemision= activarid_tipo_llamadaGuiaRemision;
	}

	public Boolean getCargarid_tipo_llamadaGuiaRemision() {
		return this.cargarid_tipo_llamadaGuiaRemision;
	}

	public void setCargarid_tipo_llamadaGuiaRemision(Boolean cargarid_tipo_llamadaGuiaRemision) {
		this.cargarid_tipo_llamadaGuiaRemision= cargarid_tipo_llamadaGuiaRemision;
	}

	public Border setResaltarhora_inicioGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarhora_inicioGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_inicioGuiaRemision() {
		return this.resaltarhora_inicioGuiaRemision;
	}

	public void setResaltarhora_inicioGuiaRemision(Border borderResaltar) {
		this.resaltarhora_inicioGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarhora_inicioGuiaRemision() {
		return this.mostrarhora_inicioGuiaRemision;
	}

	public void setMostrarhora_inicioGuiaRemision(Boolean mostrarhora_inicioGuiaRemision) {
		this.mostrarhora_inicioGuiaRemision= mostrarhora_inicioGuiaRemision;
	}

	public Boolean getActivarhora_inicioGuiaRemision() {
		return this.activarhora_inicioGuiaRemision;
	}

	public void setActivarhora_inicioGuiaRemision(Boolean activarhora_inicioGuiaRemision) {
		this.activarhora_inicioGuiaRemision= activarhora_inicioGuiaRemision;
	}

	public Border setResaltarhora_finGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarhora_finGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_finGuiaRemision() {
		return this.resaltarhora_finGuiaRemision;
	}

	public void setResaltarhora_finGuiaRemision(Border borderResaltar) {
		this.resaltarhora_finGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarhora_finGuiaRemision() {
		return this.mostrarhora_finGuiaRemision;
	}

	public void setMostrarhora_finGuiaRemision(Boolean mostrarhora_finGuiaRemision) {
		this.mostrarhora_finGuiaRemision= mostrarhora_finGuiaRemision;
	}

	public Boolean getActivarhora_finGuiaRemision() {
		return this.activarhora_finGuiaRemision;
	}

	public void setActivarhora_finGuiaRemision(Boolean activarhora_finGuiaRemision) {
		this.activarhora_finGuiaRemision= activarhora_finGuiaRemision;
	}

	public Border setResaltarcupoGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarcupoGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcupoGuiaRemision() {
		return this.resaltarcupoGuiaRemision;
	}

	public void setResaltarcupoGuiaRemision(Border borderResaltar) {
		this.resaltarcupoGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarcupoGuiaRemision() {
		return this.mostrarcupoGuiaRemision;
	}

	public void setMostrarcupoGuiaRemision(Boolean mostrarcupoGuiaRemision) {
		this.mostrarcupoGuiaRemision= mostrarcupoGuiaRemision;
	}

	public Boolean getActivarcupoGuiaRemision() {
		return this.activarcupoGuiaRemision;
	}

	public void setActivarcupoGuiaRemision(Boolean activarcupoGuiaRemision) {
		this.activarcupoGuiaRemision= activarcupoGuiaRemision;
	}

	public Border setResaltarsaldoGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarsaldoGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldoGuiaRemision() {
		return this.resaltarsaldoGuiaRemision;
	}

	public void setResaltarsaldoGuiaRemision(Border borderResaltar) {
		this.resaltarsaldoGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarsaldoGuiaRemision() {
		return this.mostrarsaldoGuiaRemision;
	}

	public void setMostrarsaldoGuiaRemision(Boolean mostrarsaldoGuiaRemision) {
		this.mostrarsaldoGuiaRemision= mostrarsaldoGuiaRemision;
	}

	public Boolean getActivarsaldoGuiaRemision() {
		return this.activarsaldoGuiaRemision;
	}

	public void setActivarsaldoGuiaRemision(Boolean activarsaldoGuiaRemision) {
		this.activarsaldoGuiaRemision= activarsaldoGuiaRemision;
	}

	public Border setResaltardocumentoGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltardocumentoGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardocumentoGuiaRemision() {
		return this.resaltardocumentoGuiaRemision;
	}

	public void setResaltardocumentoGuiaRemision(Border borderResaltar) {
		this.resaltardocumentoGuiaRemision= borderResaltar;
	}

	public Boolean getMostrardocumentoGuiaRemision() {
		return this.mostrardocumentoGuiaRemision;
	}

	public void setMostrardocumentoGuiaRemision(Boolean mostrardocumentoGuiaRemision) {
		this.mostrardocumentoGuiaRemision= mostrardocumentoGuiaRemision;
	}

	public Boolean getActivardocumentoGuiaRemision() {
		return this.activardocumentoGuiaRemision;
	}

	public void setActivardocumentoGuiaRemision(Boolean activardocumentoGuiaRemision) {
		this.activardocumentoGuiaRemision= activardocumentoGuiaRemision;
	}

	public Border setResaltardisponibleGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltardisponibleGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardisponibleGuiaRemision() {
		return this.resaltardisponibleGuiaRemision;
	}

	public void setResaltardisponibleGuiaRemision(Border borderResaltar) {
		this.resaltardisponibleGuiaRemision= borderResaltar;
	}

	public Boolean getMostrardisponibleGuiaRemision() {
		return this.mostrardisponibleGuiaRemision;
	}

	public void setMostrardisponibleGuiaRemision(Boolean mostrardisponibleGuiaRemision) {
		this.mostrardisponibleGuiaRemision= mostrardisponibleGuiaRemision;
	}

	public Boolean getActivardisponibleGuiaRemision() {
		return this.activardisponibleGuiaRemision;
	}

	public void setActivardisponibleGuiaRemision(Boolean activardisponibleGuiaRemision) {
		this.activardisponibleGuiaRemision= activardisponibleGuiaRemision;
	}

	public Border setResaltardescripcionGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltardescripcionGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionGuiaRemision() {
		return this.resaltardescripcionGuiaRemision;
	}

	public void setResaltardescripcionGuiaRemision(Border borderResaltar) {
		this.resaltardescripcionGuiaRemision= borderResaltar;
	}

	public Boolean getMostrardescripcionGuiaRemision() {
		return this.mostrardescripcionGuiaRemision;
	}

	public void setMostrardescripcionGuiaRemision(Boolean mostrardescripcionGuiaRemision) {
		this.mostrardescripcionGuiaRemision= mostrardescripcionGuiaRemision;
	}

	public Boolean getActivardescripcionGuiaRemision() {
		return this.activardescripcionGuiaRemision;
	}

	public void setActivardescripcionGuiaRemision(Boolean activardescripcionGuiaRemision) {
		this.activardescripcionGuiaRemision= activardescripcionGuiaRemision;
	}

	public Border setResaltartotal_ivaGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltartotal_ivaGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_ivaGuiaRemision() {
		return this.resaltartotal_ivaGuiaRemision;
	}

	public void setResaltartotal_ivaGuiaRemision(Border borderResaltar) {
		this.resaltartotal_ivaGuiaRemision= borderResaltar;
	}

	public Boolean getMostrartotal_ivaGuiaRemision() {
		return this.mostrartotal_ivaGuiaRemision;
	}

	public void setMostrartotal_ivaGuiaRemision(Boolean mostrartotal_ivaGuiaRemision) {
		this.mostrartotal_ivaGuiaRemision= mostrartotal_ivaGuiaRemision;
	}

	public Boolean getActivartotal_ivaGuiaRemision() {
		return this.activartotal_ivaGuiaRemision;
	}

	public void setActivartotal_ivaGuiaRemision(Boolean activartotal_ivaGuiaRemision) {
		this.activartotal_ivaGuiaRemision= activartotal_ivaGuiaRemision;
	}

	public Border setResaltartotal_sin_ivaGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltartotal_sin_ivaGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_sin_ivaGuiaRemision() {
		return this.resaltartotal_sin_ivaGuiaRemision;
	}

	public void setResaltartotal_sin_ivaGuiaRemision(Border borderResaltar) {
		this.resaltartotal_sin_ivaGuiaRemision= borderResaltar;
	}

	public Boolean getMostrartotal_sin_ivaGuiaRemision() {
		return this.mostrartotal_sin_ivaGuiaRemision;
	}

	public void setMostrartotal_sin_ivaGuiaRemision(Boolean mostrartotal_sin_ivaGuiaRemision) {
		this.mostrartotal_sin_ivaGuiaRemision= mostrartotal_sin_ivaGuiaRemision;
	}

	public Boolean getActivartotal_sin_ivaGuiaRemision() {
		return this.activartotal_sin_ivaGuiaRemision;
	}

	public void setActivartotal_sin_ivaGuiaRemision(Boolean activartotal_sin_ivaGuiaRemision) {
		this.activartotal_sin_ivaGuiaRemision= activartotal_sin_ivaGuiaRemision;
	}

	public Border setResaltardescuentoGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltardescuentoGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoGuiaRemision() {
		return this.resaltardescuentoGuiaRemision;
	}

	public void setResaltardescuentoGuiaRemision(Border borderResaltar) {
		this.resaltardescuentoGuiaRemision= borderResaltar;
	}

	public Boolean getMostrardescuentoGuiaRemision() {
		return this.mostrardescuentoGuiaRemision;
	}

	public void setMostrardescuentoGuiaRemision(Boolean mostrardescuentoGuiaRemision) {
		this.mostrardescuentoGuiaRemision= mostrardescuentoGuiaRemision;
	}

	public Boolean getActivardescuentoGuiaRemision() {
		return this.activardescuentoGuiaRemision;
	}

	public void setActivardescuentoGuiaRemision(Boolean activardescuentoGuiaRemision) {
		this.activardescuentoGuiaRemision= activardescuentoGuiaRemision;
	}

	public Border setResaltarfleteGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarfleteGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfleteGuiaRemision() {
		return this.resaltarfleteGuiaRemision;
	}

	public void setResaltarfleteGuiaRemision(Border borderResaltar) {
		this.resaltarfleteGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarfleteGuiaRemision() {
		return this.mostrarfleteGuiaRemision;
	}

	public void setMostrarfleteGuiaRemision(Boolean mostrarfleteGuiaRemision) {
		this.mostrarfleteGuiaRemision= mostrarfleteGuiaRemision;
	}

	public Boolean getActivarfleteGuiaRemision() {
		return this.activarfleteGuiaRemision;
	}

	public void setActivarfleteGuiaRemision(Boolean activarfleteGuiaRemision) {
		this.activarfleteGuiaRemision= activarfleteGuiaRemision;
	}

	public Border setResaltarotroGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarotroGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarotroGuiaRemision() {
		return this.resaltarotroGuiaRemision;
	}

	public void setResaltarotroGuiaRemision(Border borderResaltar) {
		this.resaltarotroGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarotroGuiaRemision() {
		return this.mostrarotroGuiaRemision;
	}

	public void setMostrarotroGuiaRemision(Boolean mostrarotroGuiaRemision) {
		this.mostrarotroGuiaRemision= mostrarotroGuiaRemision;
	}

	public Boolean getActivarotroGuiaRemision() {
		return this.activarotroGuiaRemision;
	}

	public void setActivarotroGuiaRemision(Boolean activarotroGuiaRemision) {
		this.activarotroGuiaRemision= activarotroGuiaRemision;
	}

	public Border setResaltarfinanciamientoGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarfinanciamientoGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfinanciamientoGuiaRemision() {
		return this.resaltarfinanciamientoGuiaRemision;
	}

	public void setResaltarfinanciamientoGuiaRemision(Border borderResaltar) {
		this.resaltarfinanciamientoGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarfinanciamientoGuiaRemision() {
		return this.mostrarfinanciamientoGuiaRemision;
	}

	public void setMostrarfinanciamientoGuiaRemision(Boolean mostrarfinanciamientoGuiaRemision) {
		this.mostrarfinanciamientoGuiaRemision= mostrarfinanciamientoGuiaRemision;
	}

	public Boolean getActivarfinanciamientoGuiaRemision() {
		return this.activarfinanciamientoGuiaRemision;
	}

	public void setActivarfinanciamientoGuiaRemision(Boolean activarfinanciamientoGuiaRemision) {
		this.activarfinanciamientoGuiaRemision= activarfinanciamientoGuiaRemision;
	}

	public Border setResaltarivaGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarivaGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaGuiaRemision() {
		return this.resaltarivaGuiaRemision;
	}

	public void setResaltarivaGuiaRemision(Border borderResaltar) {
		this.resaltarivaGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarivaGuiaRemision() {
		return this.mostrarivaGuiaRemision;
	}

	public void setMostrarivaGuiaRemision(Boolean mostrarivaGuiaRemision) {
		this.mostrarivaGuiaRemision= mostrarivaGuiaRemision;
	}

	public Boolean getActivarivaGuiaRemision() {
		return this.activarivaGuiaRemision;
	}

	public void setActivarivaGuiaRemision(Boolean activarivaGuiaRemision) {
		this.activarivaGuiaRemision= activarivaGuiaRemision;
	}

	public Border setResaltartotalGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltartotalGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalGuiaRemision() {
		return this.resaltartotalGuiaRemision;
	}

	public void setResaltartotalGuiaRemision(Border borderResaltar) {
		this.resaltartotalGuiaRemision= borderResaltar;
	}

	public Boolean getMostrartotalGuiaRemision() {
		return this.mostrartotalGuiaRemision;
	}

	public void setMostrartotalGuiaRemision(Boolean mostrartotalGuiaRemision) {
		this.mostrartotalGuiaRemision= mostrartotalGuiaRemision;
	}

	public Boolean getActivartotalGuiaRemision() {
		return this.activartotalGuiaRemision;
	}

	public void setActivartotalGuiaRemision(Boolean activartotalGuiaRemision) {
		this.activartotalGuiaRemision= activartotalGuiaRemision;
	}

	public Border setResaltarmonto_retencionGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarmonto_retencionGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_retencionGuiaRemision() {
		return this.resaltarmonto_retencionGuiaRemision;
	}

	public void setResaltarmonto_retencionGuiaRemision(Border borderResaltar) {
		this.resaltarmonto_retencionGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarmonto_retencionGuiaRemision() {
		return this.mostrarmonto_retencionGuiaRemision;
	}

	public void setMostrarmonto_retencionGuiaRemision(Boolean mostrarmonto_retencionGuiaRemision) {
		this.mostrarmonto_retencionGuiaRemision= mostrarmonto_retencionGuiaRemision;
	}

	public Boolean getActivarmonto_retencionGuiaRemision() {
		return this.activarmonto_retencionGuiaRemision;
	}

	public void setActivarmonto_retencionGuiaRemision(Boolean activarmonto_retencionGuiaRemision) {
		this.activarmonto_retencionGuiaRemision= activarmonto_retencionGuiaRemision;
	}

	public Border setResaltarid_tipo_cambioGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarid_tipo_cambioGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_cambioGuiaRemision() {
		return this.resaltarid_tipo_cambioGuiaRemision;
	}

	public void setResaltarid_tipo_cambioGuiaRemision(Border borderResaltar) {
		this.resaltarid_tipo_cambioGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarid_tipo_cambioGuiaRemision() {
		return this.mostrarid_tipo_cambioGuiaRemision;
	}

	public void setMostrarid_tipo_cambioGuiaRemision(Boolean mostrarid_tipo_cambioGuiaRemision) {
		this.mostrarid_tipo_cambioGuiaRemision= mostrarid_tipo_cambioGuiaRemision;
	}

	public Boolean getActivarid_tipo_cambioGuiaRemision() {
		return this.activarid_tipo_cambioGuiaRemision;
	}

	public void setActivarid_tipo_cambioGuiaRemision(Boolean activarid_tipo_cambioGuiaRemision) {
		this.activarid_tipo_cambioGuiaRemision= activarid_tipo_cambioGuiaRemision;
	}

	public Boolean getCargarid_tipo_cambioGuiaRemision() {
		return this.cargarid_tipo_cambioGuiaRemision;
	}

	public void setCargarid_tipo_cambioGuiaRemision(Boolean cargarid_tipo_cambioGuiaRemision) {
		this.cargarid_tipo_cambioGuiaRemision= cargarid_tipo_cambioGuiaRemision;
	}

	public Border setResaltarfechaGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarfechaGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaGuiaRemision() {
		return this.resaltarfechaGuiaRemision;
	}

	public void setResaltarfechaGuiaRemision(Border borderResaltar) {
		this.resaltarfechaGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarfechaGuiaRemision() {
		return this.mostrarfechaGuiaRemision;
	}

	public void setMostrarfechaGuiaRemision(Boolean mostrarfechaGuiaRemision) {
		this.mostrarfechaGuiaRemision= mostrarfechaGuiaRemision;
	}

	public Boolean getActivarfechaGuiaRemision() {
		return this.activarfechaGuiaRemision;
	}

	public void setActivarfechaGuiaRemision(Boolean activarfechaGuiaRemision) {
		this.activarfechaGuiaRemision= activarfechaGuiaRemision;
	}

	public Border setResaltarruc_clienteGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarruc_clienteGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarruc_clienteGuiaRemision() {
		return this.resaltarruc_clienteGuiaRemision;
	}

	public void setResaltarruc_clienteGuiaRemision(Border borderResaltar) {
		this.resaltarruc_clienteGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarruc_clienteGuiaRemision() {
		return this.mostrarruc_clienteGuiaRemision;
	}

	public void setMostrarruc_clienteGuiaRemision(Boolean mostrarruc_clienteGuiaRemision) {
		this.mostrarruc_clienteGuiaRemision= mostrarruc_clienteGuiaRemision;
	}

	public Boolean getActivarruc_clienteGuiaRemision() {
		return this.activarruc_clienteGuiaRemision;
	}

	public void setActivarruc_clienteGuiaRemision(Boolean activarruc_clienteGuiaRemision) {
		this.activarruc_clienteGuiaRemision= activarruc_clienteGuiaRemision;
	}

	public Border setResaltarnombre_clienteGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarnombre_clienteGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_clienteGuiaRemision() {
		return this.resaltarnombre_clienteGuiaRemision;
	}

	public void setResaltarnombre_clienteGuiaRemision(Border borderResaltar) {
		this.resaltarnombre_clienteGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarnombre_clienteGuiaRemision() {
		return this.mostrarnombre_clienteGuiaRemision;
	}

	public void setMostrarnombre_clienteGuiaRemision(Boolean mostrarnombre_clienteGuiaRemision) {
		this.mostrarnombre_clienteGuiaRemision= mostrarnombre_clienteGuiaRemision;
	}

	public Boolean getActivarnombre_clienteGuiaRemision() {
		return this.activarnombre_clienteGuiaRemision;
	}

	public void setActivarnombre_clienteGuiaRemision(Boolean activarnombre_clienteGuiaRemision) {
		this.activarnombre_clienteGuiaRemision= activarnombre_clienteGuiaRemision;
	}

	public Border setResaltartelefono_clienteGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltartelefono_clienteGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefono_clienteGuiaRemision() {
		return this.resaltartelefono_clienteGuiaRemision;
	}

	public void setResaltartelefono_clienteGuiaRemision(Border borderResaltar) {
		this.resaltartelefono_clienteGuiaRemision= borderResaltar;
	}

	public Boolean getMostrartelefono_clienteGuiaRemision() {
		return this.mostrartelefono_clienteGuiaRemision;
	}

	public void setMostrartelefono_clienteGuiaRemision(Boolean mostrartelefono_clienteGuiaRemision) {
		this.mostrartelefono_clienteGuiaRemision= mostrartelefono_clienteGuiaRemision;
	}

	public Boolean getActivartelefono_clienteGuiaRemision() {
		return this.activartelefono_clienteGuiaRemision;
	}

	public void setActivartelefono_clienteGuiaRemision(Boolean activartelefono_clienteGuiaRemision) {
		this.activartelefono_clienteGuiaRemision= activartelefono_clienteGuiaRemision;
	}

	public Border setResaltardireccion_clienteGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltardireccion_clienteGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccion_clienteGuiaRemision() {
		return this.resaltardireccion_clienteGuiaRemision;
	}

	public void setResaltardireccion_clienteGuiaRemision(Border borderResaltar) {
		this.resaltardireccion_clienteGuiaRemision= borderResaltar;
	}

	public Boolean getMostrardireccion_clienteGuiaRemision() {
		return this.mostrardireccion_clienteGuiaRemision;
	}

	public void setMostrardireccion_clienteGuiaRemision(Boolean mostrardireccion_clienteGuiaRemision) {
		this.mostrardireccion_clienteGuiaRemision= mostrardireccion_clienteGuiaRemision;
	}

	public Boolean getActivardireccion_clienteGuiaRemision() {
		return this.activardireccion_clienteGuiaRemision;
	}

	public void setActivardireccion_clienteGuiaRemision(Boolean activardireccion_clienteGuiaRemision) {
		this.activardireccion_clienteGuiaRemision= activardireccion_clienteGuiaRemision;
	}

	public Border setResaltarnumero_pre_impresoGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarnumero_pre_impresoGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_pre_impresoGuiaRemision() {
		return this.resaltarnumero_pre_impresoGuiaRemision;
	}

	public void setResaltarnumero_pre_impresoGuiaRemision(Border borderResaltar) {
		this.resaltarnumero_pre_impresoGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarnumero_pre_impresoGuiaRemision() {
		return this.mostrarnumero_pre_impresoGuiaRemision;
	}

	public void setMostrarnumero_pre_impresoGuiaRemision(Boolean mostrarnumero_pre_impresoGuiaRemision) {
		this.mostrarnumero_pre_impresoGuiaRemision= mostrarnumero_pre_impresoGuiaRemision;
	}

	public Boolean getActivarnumero_pre_impresoGuiaRemision() {
		return this.activarnumero_pre_impresoGuiaRemision;
	}

	public void setActivarnumero_pre_impresoGuiaRemision(Boolean activarnumero_pre_impresoGuiaRemision) {
		this.activarnumero_pre_impresoGuiaRemision= activarnumero_pre_impresoGuiaRemision;
	}

	public Border setResaltarpeso_brutoGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarpeso_brutoGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpeso_brutoGuiaRemision() {
		return this.resaltarpeso_brutoGuiaRemision;
	}

	public void setResaltarpeso_brutoGuiaRemision(Border borderResaltar) {
		this.resaltarpeso_brutoGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarpeso_brutoGuiaRemision() {
		return this.mostrarpeso_brutoGuiaRemision;
	}

	public void setMostrarpeso_brutoGuiaRemision(Boolean mostrarpeso_brutoGuiaRemision) {
		this.mostrarpeso_brutoGuiaRemision= mostrarpeso_brutoGuiaRemision;
	}

	public Boolean getActivarpeso_brutoGuiaRemision() {
		return this.activarpeso_brutoGuiaRemision;
	}

	public void setActivarpeso_brutoGuiaRemision(Boolean activarpeso_brutoGuiaRemision) {
		this.activarpeso_brutoGuiaRemision= activarpeso_brutoGuiaRemision;
	}

	public Border setResaltarfecha_autorizacionGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarfecha_autorizacionGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_autorizacionGuiaRemision() {
		return this.resaltarfecha_autorizacionGuiaRemision;
	}

	public void setResaltarfecha_autorizacionGuiaRemision(Border borderResaltar) {
		this.resaltarfecha_autorizacionGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarfecha_autorizacionGuiaRemision() {
		return this.mostrarfecha_autorizacionGuiaRemision;
	}

	public void setMostrarfecha_autorizacionGuiaRemision(Boolean mostrarfecha_autorizacionGuiaRemision) {
		this.mostrarfecha_autorizacionGuiaRemision= mostrarfecha_autorizacionGuiaRemision;
	}

	public Boolean getActivarfecha_autorizacionGuiaRemision() {
		return this.activarfecha_autorizacionGuiaRemision;
	}

	public void setActivarfecha_autorizacionGuiaRemision(Boolean activarfecha_autorizacionGuiaRemision) {
		this.activarfecha_autorizacionGuiaRemision= activarfecha_autorizacionGuiaRemision;
	}

	public Border setResaltarfecha_vencimientoGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimientoGuiaRemision= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimientoGuiaRemision() {
		return this.resaltarfecha_vencimientoGuiaRemision;
	}

	public void setResaltarfecha_vencimientoGuiaRemision(Border borderResaltar) {
		this.resaltarfecha_vencimientoGuiaRemision= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimientoGuiaRemision() {
		return this.mostrarfecha_vencimientoGuiaRemision;
	}

	public void setMostrarfecha_vencimientoGuiaRemision(Boolean mostrarfecha_vencimientoGuiaRemision) {
		this.mostrarfecha_vencimientoGuiaRemision= mostrarfecha_vencimientoGuiaRemision;
	}

	public Boolean getActivarfecha_vencimientoGuiaRemision() {
		return this.activarfecha_vencimientoGuiaRemision;
	}

	public void setActivarfecha_vencimientoGuiaRemision(Boolean activarfecha_vencimientoGuiaRemision) {
		this.activarfecha_vencimientoGuiaRemision= activarfecha_vencimientoGuiaRemision;
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
		
		
		this.setMostraridGuiaRemision(esInicial);
		this.setMostrarid_empresaGuiaRemision(esInicial);
		this.setMostrarid_sucursalGuiaRemision(esInicial);
		this.setMostrarid_ejercicioGuiaRemision(esInicial);
		this.setMostrarid_periodoGuiaRemision(esInicial);
		this.setMostrarid_usuarioGuiaRemision(esInicial);
		this.setMostrarsecuencialGuiaRemision(esInicial);
		this.setMostrarfecha_emisionGuiaRemision(esInicial);
		this.setMostrarid_formatoGuiaRemision(esInicial);
		this.setMostrarid_tipo_precioGuiaRemision(esInicial);
		this.setMostrarid_monedaGuiaRemision(esInicial);
		this.setMostrarnumero_camionGuiaRemision(esInicial);
		this.setMostrarid_clienteGuiaRemision(esInicial);
		this.setMostrarid_vendedorGuiaRemision(esInicial);
		this.setMostrarid_facturaGuiaRemision(esInicial);
		this.setMostrarid_transportistaGuiaRemision(esInicial);
		this.setMostraridentificacionGuiaRemision(esInicial);
		this.setMostrarfecha_origenGuiaRemision(esInicial);
		this.setMostrarfecha_destinoGuiaRemision(esInicial);
		this.setMostrartransporte_codigoGuiaRemision(esInicial);
		this.setMostrarcantidad_bultosGuiaRemision(esInicial);
		this.setMostrarid_consultorGuiaRemision(esInicial);
		this.setMostrarid_transporteGuiaRemision(esInicial);
		this.setMostrarid_sub_clienteGuiaRemision(esInicial);
		this.setMostrarid_empleadoGuiaRemision(esInicial);
		this.setMostrarid_ciudad_origenGuiaRemision(esInicial);
		this.setMostrarid_ciudad_destinoGuiaRemision(esInicial);
		this.setMostrarid_tipo_llamadaGuiaRemision(esInicial);
		this.setMostrarhora_inicioGuiaRemision(esInicial);
		this.setMostrarhora_finGuiaRemision(esInicial);
		this.setMostrarcupoGuiaRemision(esInicial);
		this.setMostrarsaldoGuiaRemision(esInicial);
		this.setMostrardocumentoGuiaRemision(esInicial);
		this.setMostrardisponibleGuiaRemision(esInicial);
		this.setMostrardescripcionGuiaRemision(esInicial);
		this.setMostrartotal_ivaGuiaRemision(esInicial);
		this.setMostrartotal_sin_ivaGuiaRemision(esInicial);
		this.setMostrardescuentoGuiaRemision(esInicial);
		this.setMostrarfleteGuiaRemision(esInicial);
		this.setMostrarotroGuiaRemision(esInicial);
		this.setMostrarfinanciamientoGuiaRemision(esInicial);
		this.setMostrarivaGuiaRemision(esInicial);
		this.setMostrartotalGuiaRemision(esInicial);
		this.setMostrarmonto_retencionGuiaRemision(esInicial);
		this.setMostrarid_tipo_cambioGuiaRemision(esInicial);
		this.setMostrarfechaGuiaRemision(esInicial);
		this.setMostrarruc_clienteGuiaRemision(esInicial);
		this.setMostrarnombre_clienteGuiaRemision(esInicial);
		this.setMostrartelefono_clienteGuiaRemision(esInicial);
		this.setMostrardireccion_clienteGuiaRemision(esInicial);
		this.setMostrarnumero_pre_impresoGuiaRemision(esInicial);
		this.setMostrarpeso_brutoGuiaRemision(esInicial);
		this.setMostrarfecha_autorizacionGuiaRemision(esInicial);
		this.setMostrarfecha_vencimientoGuiaRemision(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.ID)) {
				this.setMostraridGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDTIPOPRECIO)) {
				this.setMostrarid_tipo_precioGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.NUMEROCAMION)) {
				this.setMostrarnumero_camionGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDTRANSPORTISTA)) {
				this.setMostrarid_transportistaGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDENTIFICACION)) {
				this.setMostraridentificacionGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.FECHAORIGEN)) {
				this.setMostrarfecha_origenGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.FECHADESTINO)) {
				this.setMostrarfecha_destinoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.TRANSPORTECODIGO)) {
				this.setMostrartransporte_codigoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.CANTIDADBULTOS)) {
				this.setMostrarcantidad_bultosGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDCONSULTOR)) {
				this.setMostrarid_consultorGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDTRANSPORTE)) {
				this.setMostrarid_transporteGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDSUBCLIENTE)) {
				this.setMostrarid_sub_clienteGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDCIUDADORIGEN)) {
				this.setMostrarid_ciudad_origenGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDCIUDADDESTINO)) {
				this.setMostrarid_ciudad_destinoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDTIPOLLAMADA)) {
				this.setMostrarid_tipo_llamadaGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.HORAINICIO)) {
				this.setMostrarhora_inicioGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.HORAFIN)) {
				this.setMostrarhora_finGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.CUPO)) {
				this.setMostrarcupoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.SALDO)) {
				this.setMostrarsaldoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.DOCUMENTO)) {
				this.setMostrardocumentoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.DISPONIBLE)) {
				this.setMostrardisponibleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.TOTALIVA)) {
				this.setMostrartotal_ivaGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.TOTALSINIVA)) {
				this.setMostrartotal_sin_ivaGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.FLETE)) {
				this.setMostrarfleteGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.OTRO)) {
				this.setMostrarotroGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.FINANCIAMIENTO)) {
				this.setMostrarfinanciamientoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IVA)) {
				this.setMostrarivaGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.TOTAL)) {
				this.setMostrartotalGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.MONTORETENCION)) {
				this.setMostrarmonto_retencionGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDTIPOCAMBIO)) {
				this.setMostrarid_tipo_cambioGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.FECHA)) {
				this.setMostrarfechaGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.RUCCLIENTE)) {
				this.setMostrarruc_clienteGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.NOMBRECLIENTE)) {
				this.setMostrarnombre_clienteGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.TELEFONOCLIENTE)) {
				this.setMostrartelefono_clienteGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.DIRECCIONCLIENTE)) {
				this.setMostrardireccion_clienteGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setMostrarnumero_pre_impresoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.PESOBRUTO)) {
				this.setMostrarpeso_brutoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.FECHAAUTORIZACION)) {
				this.setMostrarfecha_autorizacionGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setMostrarfecha_vencimientoGuiaRemision(esAsigna);
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
		
		
		this.setActivaridGuiaRemision(esInicial);
		this.setActivarid_empresaGuiaRemision(esInicial);
		this.setActivarid_sucursalGuiaRemision(esInicial);
		this.setActivarid_ejercicioGuiaRemision(esInicial);
		this.setActivarid_periodoGuiaRemision(esInicial);
		this.setActivarid_usuarioGuiaRemision(esInicial);
		this.setActivarsecuencialGuiaRemision(esInicial);
		this.setActivarfecha_emisionGuiaRemision(esInicial);
		this.setActivarid_formatoGuiaRemision(esInicial);
		this.setActivarid_tipo_precioGuiaRemision(esInicial);
		this.setActivarid_monedaGuiaRemision(esInicial);
		this.setActivarnumero_camionGuiaRemision(esInicial);
		this.setActivarid_clienteGuiaRemision(esInicial);
		this.setActivarid_vendedorGuiaRemision(esInicial);
		this.setActivarid_facturaGuiaRemision(esInicial);
		this.setActivarid_transportistaGuiaRemision(esInicial);
		this.setActivaridentificacionGuiaRemision(esInicial);
		this.setActivarfecha_origenGuiaRemision(esInicial);
		this.setActivarfecha_destinoGuiaRemision(esInicial);
		this.setActivartransporte_codigoGuiaRemision(esInicial);
		this.setActivarcantidad_bultosGuiaRemision(esInicial);
		this.setActivarid_consultorGuiaRemision(esInicial);
		this.setActivarid_transporteGuiaRemision(esInicial);
		this.setActivarid_sub_clienteGuiaRemision(esInicial);
		this.setActivarid_empleadoGuiaRemision(esInicial);
		this.setActivarid_ciudad_origenGuiaRemision(esInicial);
		this.setActivarid_ciudad_destinoGuiaRemision(esInicial);
		this.setActivarid_tipo_llamadaGuiaRemision(esInicial);
		this.setActivarhora_inicioGuiaRemision(esInicial);
		this.setActivarhora_finGuiaRemision(esInicial);
		this.setActivarcupoGuiaRemision(esInicial);
		this.setActivarsaldoGuiaRemision(esInicial);
		this.setActivardocumentoGuiaRemision(esInicial);
		this.setActivardisponibleGuiaRemision(esInicial);
		this.setActivardescripcionGuiaRemision(esInicial);
		this.setActivartotal_ivaGuiaRemision(esInicial);
		this.setActivartotal_sin_ivaGuiaRemision(esInicial);
		this.setActivardescuentoGuiaRemision(esInicial);
		this.setActivarfleteGuiaRemision(esInicial);
		this.setActivarotroGuiaRemision(esInicial);
		this.setActivarfinanciamientoGuiaRemision(esInicial);
		this.setActivarivaGuiaRemision(esInicial);
		this.setActivartotalGuiaRemision(esInicial);
		this.setActivarmonto_retencionGuiaRemision(esInicial);
		this.setActivarid_tipo_cambioGuiaRemision(esInicial);
		this.setActivarfechaGuiaRemision(esInicial);
		this.setActivarruc_clienteGuiaRemision(esInicial);
		this.setActivarnombre_clienteGuiaRemision(esInicial);
		this.setActivartelefono_clienteGuiaRemision(esInicial);
		this.setActivardireccion_clienteGuiaRemision(esInicial);
		this.setActivarnumero_pre_impresoGuiaRemision(esInicial);
		this.setActivarpeso_brutoGuiaRemision(esInicial);
		this.setActivarfecha_autorizacionGuiaRemision(esInicial);
		this.setActivarfecha_vencimientoGuiaRemision(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.ID)) {
				this.setActivaridGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDTIPOPRECIO)) {
				this.setActivarid_tipo_precioGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.NUMEROCAMION)) {
				this.setActivarnumero_camionGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDTRANSPORTISTA)) {
				this.setActivarid_transportistaGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDENTIFICACION)) {
				this.setActivaridentificacionGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.FECHAORIGEN)) {
				this.setActivarfecha_origenGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.FECHADESTINO)) {
				this.setActivarfecha_destinoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.TRANSPORTECODIGO)) {
				this.setActivartransporte_codigoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.CANTIDADBULTOS)) {
				this.setActivarcantidad_bultosGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDCONSULTOR)) {
				this.setActivarid_consultorGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDTRANSPORTE)) {
				this.setActivarid_transporteGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDSUBCLIENTE)) {
				this.setActivarid_sub_clienteGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDCIUDADORIGEN)) {
				this.setActivarid_ciudad_origenGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDCIUDADDESTINO)) {
				this.setActivarid_ciudad_destinoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDTIPOLLAMADA)) {
				this.setActivarid_tipo_llamadaGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.HORAINICIO)) {
				this.setActivarhora_inicioGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.HORAFIN)) {
				this.setActivarhora_finGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.CUPO)) {
				this.setActivarcupoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.SALDO)) {
				this.setActivarsaldoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.DOCUMENTO)) {
				this.setActivardocumentoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.DISPONIBLE)) {
				this.setActivardisponibleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.TOTALIVA)) {
				this.setActivartotal_ivaGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.TOTALSINIVA)) {
				this.setActivartotal_sin_ivaGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.FLETE)) {
				this.setActivarfleteGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.OTRO)) {
				this.setActivarotroGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.FINANCIAMIENTO)) {
				this.setActivarfinanciamientoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IVA)) {
				this.setActivarivaGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.TOTAL)) {
				this.setActivartotalGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.MONTORETENCION)) {
				this.setActivarmonto_retencionGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDTIPOCAMBIO)) {
				this.setActivarid_tipo_cambioGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.FECHA)) {
				this.setActivarfechaGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.RUCCLIENTE)) {
				this.setActivarruc_clienteGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.NOMBRECLIENTE)) {
				this.setActivarnombre_clienteGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.TELEFONOCLIENTE)) {
				this.setActivartelefono_clienteGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.DIRECCIONCLIENTE)) {
				this.setActivardireccion_clienteGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setActivarnumero_pre_impresoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.PESOBRUTO)) {
				this.setActivarpeso_brutoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.FECHAAUTORIZACION)) {
				this.setActivarfecha_autorizacionGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setActivarfecha_vencimientoGuiaRemision(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridGuiaRemision(esInicial);
		this.setResaltarid_empresaGuiaRemision(esInicial);
		this.setResaltarid_sucursalGuiaRemision(esInicial);
		this.setResaltarid_ejercicioGuiaRemision(esInicial);
		this.setResaltarid_periodoGuiaRemision(esInicial);
		this.setResaltarid_usuarioGuiaRemision(esInicial);
		this.setResaltarsecuencialGuiaRemision(esInicial);
		this.setResaltarfecha_emisionGuiaRemision(esInicial);
		this.setResaltarid_formatoGuiaRemision(esInicial);
		this.setResaltarid_tipo_precioGuiaRemision(esInicial);
		this.setResaltarid_monedaGuiaRemision(esInicial);
		this.setResaltarnumero_camionGuiaRemision(esInicial);
		this.setResaltarid_clienteGuiaRemision(esInicial);
		this.setResaltarid_vendedorGuiaRemision(esInicial);
		this.setResaltarid_facturaGuiaRemision(esInicial);
		this.setResaltarid_transportistaGuiaRemision(esInicial);
		this.setResaltaridentificacionGuiaRemision(esInicial);
		this.setResaltarfecha_origenGuiaRemision(esInicial);
		this.setResaltarfecha_destinoGuiaRemision(esInicial);
		this.setResaltartransporte_codigoGuiaRemision(esInicial);
		this.setResaltarcantidad_bultosGuiaRemision(esInicial);
		this.setResaltarid_consultorGuiaRemision(esInicial);
		this.setResaltarid_transporteGuiaRemision(esInicial);
		this.setResaltarid_sub_clienteGuiaRemision(esInicial);
		this.setResaltarid_empleadoGuiaRemision(esInicial);
		this.setResaltarid_ciudad_origenGuiaRemision(esInicial);
		this.setResaltarid_ciudad_destinoGuiaRemision(esInicial);
		this.setResaltarid_tipo_llamadaGuiaRemision(esInicial);
		this.setResaltarhora_inicioGuiaRemision(esInicial);
		this.setResaltarhora_finGuiaRemision(esInicial);
		this.setResaltarcupoGuiaRemision(esInicial);
		this.setResaltarsaldoGuiaRemision(esInicial);
		this.setResaltardocumentoGuiaRemision(esInicial);
		this.setResaltardisponibleGuiaRemision(esInicial);
		this.setResaltardescripcionGuiaRemision(esInicial);
		this.setResaltartotal_ivaGuiaRemision(esInicial);
		this.setResaltartotal_sin_ivaGuiaRemision(esInicial);
		this.setResaltardescuentoGuiaRemision(esInicial);
		this.setResaltarfleteGuiaRemision(esInicial);
		this.setResaltarotroGuiaRemision(esInicial);
		this.setResaltarfinanciamientoGuiaRemision(esInicial);
		this.setResaltarivaGuiaRemision(esInicial);
		this.setResaltartotalGuiaRemision(esInicial);
		this.setResaltarmonto_retencionGuiaRemision(esInicial);
		this.setResaltarid_tipo_cambioGuiaRemision(esInicial);
		this.setResaltarfechaGuiaRemision(esInicial);
		this.setResaltarruc_clienteGuiaRemision(esInicial);
		this.setResaltarnombre_clienteGuiaRemision(esInicial);
		this.setResaltartelefono_clienteGuiaRemision(esInicial);
		this.setResaltardireccion_clienteGuiaRemision(esInicial);
		this.setResaltarnumero_pre_impresoGuiaRemision(esInicial);
		this.setResaltarpeso_brutoGuiaRemision(esInicial);
		this.setResaltarfecha_autorizacionGuiaRemision(esInicial);
		this.setResaltarfecha_vencimientoGuiaRemision(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.ID)) {
				this.setResaltaridGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDTIPOPRECIO)) {
				this.setResaltarid_tipo_precioGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.NUMEROCAMION)) {
				this.setResaltarnumero_camionGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDTRANSPORTISTA)) {
				this.setResaltarid_transportistaGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDENTIFICACION)) {
				this.setResaltaridentificacionGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.FECHAORIGEN)) {
				this.setResaltarfecha_origenGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.FECHADESTINO)) {
				this.setResaltarfecha_destinoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.TRANSPORTECODIGO)) {
				this.setResaltartransporte_codigoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.CANTIDADBULTOS)) {
				this.setResaltarcantidad_bultosGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDCONSULTOR)) {
				this.setResaltarid_consultorGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDTRANSPORTE)) {
				this.setResaltarid_transporteGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDSUBCLIENTE)) {
				this.setResaltarid_sub_clienteGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDCIUDADORIGEN)) {
				this.setResaltarid_ciudad_origenGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDCIUDADDESTINO)) {
				this.setResaltarid_ciudad_destinoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDTIPOLLAMADA)) {
				this.setResaltarid_tipo_llamadaGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.HORAINICIO)) {
				this.setResaltarhora_inicioGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.HORAFIN)) {
				this.setResaltarhora_finGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.CUPO)) {
				this.setResaltarcupoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.SALDO)) {
				this.setResaltarsaldoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.DOCUMENTO)) {
				this.setResaltardocumentoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.DISPONIBLE)) {
				this.setResaltardisponibleGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.TOTALIVA)) {
				this.setResaltartotal_ivaGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.TOTALSINIVA)) {
				this.setResaltartotal_sin_ivaGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.FLETE)) {
				this.setResaltarfleteGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.OTRO)) {
				this.setResaltarotroGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.FINANCIAMIENTO)) {
				this.setResaltarfinanciamientoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IVA)) {
				this.setResaltarivaGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.TOTAL)) {
				this.setResaltartotalGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.MONTORETENCION)) {
				this.setResaltarmonto_retencionGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.IDTIPOCAMBIO)) {
				this.setResaltarid_tipo_cambioGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.FECHA)) {
				this.setResaltarfechaGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.RUCCLIENTE)) {
				this.setResaltarruc_clienteGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.NOMBRECLIENTE)) {
				this.setResaltarnombre_clienteGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.TELEFONOCLIENTE)) {
				this.setResaltartelefono_clienteGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.DIRECCIONCLIENTE)) {
				this.setResaltardireccion_clienteGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setResaltarnumero_pre_impresoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.PESOBRUTO)) {
				this.setResaltarpeso_brutoGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.FECHAAUTORIZACION)) {
				this.setResaltarfecha_autorizacionGuiaRemision(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiaRemisionConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setResaltarfecha_vencimientoGuiaRemision(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleGuiaRemisionGuiaRemision=null;

	public Border getResaltarDetalleGuiaRemisionGuiaRemision() {
		return this.resaltarDetalleGuiaRemisionGuiaRemision;
	}

	public void setResaltarDetalleGuiaRemisionGuiaRemision(Border borderResaltarDetalleGuiaRemision) {
		if(borderResaltarDetalleGuiaRemision!=null) {
			this.resaltarDetalleGuiaRemisionGuiaRemision= borderResaltarDetalleGuiaRemision;
		}
	}

	public Border setResaltarDetalleGuiaRemisionGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleGuiaRemision=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//guiaremisionBeanSwingJInternalFrame.jTtoolBarGuiaRemision.setBorder(borderResaltarDetalleGuiaRemision);
			
		this.resaltarDetalleGuiaRemisionGuiaRemision= borderResaltarDetalleGuiaRemision;

		 return borderResaltarDetalleGuiaRemision;
	}



	public Boolean mostrarDetalleGuiaRemisionGuiaRemision=true;

	public Boolean getMostrarDetalleGuiaRemisionGuiaRemision() {
		return this.mostrarDetalleGuiaRemisionGuiaRemision;
	}

	public void setMostrarDetalleGuiaRemisionGuiaRemision(Boolean visibilidadResaltarDetalleGuiaRemision) {
		this.mostrarDetalleGuiaRemisionGuiaRemision= visibilidadResaltarDetalleGuiaRemision;
	}



	public Boolean activarDetalleGuiaRemisionGuiaRemision=true;

	public Boolean gethabilitarResaltarDetalleGuiaRemisionGuiaRemision() {
		return this.activarDetalleGuiaRemisionGuiaRemision;
	}

	public void setActivarDetalleGuiaRemisionGuiaRemision(Boolean habilitarResaltarDetalleGuiaRemision) {
		this.activarDetalleGuiaRemisionGuiaRemision= habilitarResaltarDetalleGuiaRemision;
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

		this.setMostrarDetalleGuiaRemisionGuiaRemision(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleGuiaRemision.class)) {
				this.setMostrarDetalleGuiaRemisionGuiaRemision(esAsigna);
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

		this.setActivarDetalleGuiaRemisionGuiaRemision(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleGuiaRemision.class)) {
				this.setActivarDetalleGuiaRemisionGuiaRemision(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleGuiaRemisionGuiaRemision(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleGuiaRemision.class)) {
				this.setResaltarDetalleGuiaRemisionGuiaRemision(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdCiudadDestinoGuiaRemision=true;

	public Boolean getMostrarFK_IdCiudadDestinoGuiaRemision() {
		return this.mostrarFK_IdCiudadDestinoGuiaRemision;
	}

	public void setMostrarFK_IdCiudadDestinoGuiaRemision(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCiudadDestinoGuiaRemision= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCiudadOrigenGuiaRemision=true;

	public Boolean getMostrarFK_IdCiudadOrigenGuiaRemision() {
		return this.mostrarFK_IdCiudadOrigenGuiaRemision;
	}

	public void setMostrarFK_IdCiudadOrigenGuiaRemision(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCiudadOrigenGuiaRemision= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteGuiaRemision=true;

	public Boolean getMostrarFK_IdClienteGuiaRemision() {
		return this.mostrarFK_IdClienteGuiaRemision;
	}

	public void setMostrarFK_IdClienteGuiaRemision(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteGuiaRemision= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdConsultorGuiaRemision=true;

	public Boolean getMostrarFK_IdConsultorGuiaRemision() {
		return this.mostrarFK_IdConsultorGuiaRemision;
	}

	public void setMostrarFK_IdConsultorGuiaRemision(Boolean visibilidadResaltar) {
		this.mostrarFK_IdConsultorGuiaRemision= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioGuiaRemision=true;

	public Boolean getMostrarFK_IdEjercicioGuiaRemision() {
		return this.mostrarFK_IdEjercicioGuiaRemision;
	}

	public void setMostrarFK_IdEjercicioGuiaRemision(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioGuiaRemision= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoGuiaRemision=true;

	public Boolean getMostrarFK_IdEmpleadoGuiaRemision() {
		return this.mostrarFK_IdEmpleadoGuiaRemision;
	}

	public void setMostrarFK_IdEmpleadoGuiaRemision(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoGuiaRemision= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaGuiaRemision=true;

	public Boolean getMostrarFK_IdEmpresaGuiaRemision() {
		return this.mostrarFK_IdEmpresaGuiaRemision;
	}

	public void setMostrarFK_IdEmpresaGuiaRemision(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaGuiaRemision= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFacturaGuiaRemision=true;

	public Boolean getMostrarFK_IdFacturaGuiaRemision() {
		return this.mostrarFK_IdFacturaGuiaRemision;
	}

	public void setMostrarFK_IdFacturaGuiaRemision(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFacturaGuiaRemision= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoGuiaRemision=true;

	public Boolean getMostrarFK_IdFormatoGuiaRemision() {
		return this.mostrarFK_IdFormatoGuiaRemision;
	}

	public void setMostrarFK_IdFormatoGuiaRemision(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoGuiaRemision= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMonedaGuiaRemision=true;

	public Boolean getMostrarFK_IdMonedaGuiaRemision() {
		return this.mostrarFK_IdMonedaGuiaRemision;
	}

	public void setMostrarFK_IdMonedaGuiaRemision(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMonedaGuiaRemision= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoGuiaRemision=true;

	public Boolean getMostrarFK_IdPeriodoGuiaRemision() {
		return this.mostrarFK_IdPeriodoGuiaRemision;
	}

	public void setMostrarFK_IdPeriodoGuiaRemision(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoGuiaRemision= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSubClienteGuiaRemision=true;

	public Boolean getMostrarFK_IdSubClienteGuiaRemision() {
		return this.mostrarFK_IdSubClienteGuiaRemision;
	}

	public void setMostrarFK_IdSubClienteGuiaRemision(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSubClienteGuiaRemision= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalGuiaRemision=true;

	public Boolean getMostrarFK_IdSucursalGuiaRemision() {
		return this.mostrarFK_IdSucursalGuiaRemision;
	}

	public void setMostrarFK_IdSucursalGuiaRemision(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalGuiaRemision= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoCambioGuiaRemision=true;

	public Boolean getMostrarFK_IdTipoCambioGuiaRemision() {
		return this.mostrarFK_IdTipoCambioGuiaRemision;
	}

	public void setMostrarFK_IdTipoCambioGuiaRemision(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoCambioGuiaRemision= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoLlamadaGuiaRemision=true;

	public Boolean getMostrarFK_IdTipoLlamadaGuiaRemision() {
		return this.mostrarFK_IdTipoLlamadaGuiaRemision;
	}

	public void setMostrarFK_IdTipoLlamadaGuiaRemision(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoLlamadaGuiaRemision= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoPrecioGuiaRemision=true;

	public Boolean getMostrarFK_IdTipoPrecioGuiaRemision() {
		return this.mostrarFK_IdTipoPrecioGuiaRemision;
	}

	public void setMostrarFK_IdTipoPrecioGuiaRemision(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoPrecioGuiaRemision= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransporteGuiaRemision=true;

	public Boolean getMostrarFK_IdTransporteGuiaRemision() {
		return this.mostrarFK_IdTransporteGuiaRemision;
	}

	public void setMostrarFK_IdTransporteGuiaRemision(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransporteGuiaRemision= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransportistaGuiaRemision=true;

	public Boolean getMostrarFK_IdTransportistaGuiaRemision() {
		return this.mostrarFK_IdTransportistaGuiaRemision;
	}

	public void setMostrarFK_IdTransportistaGuiaRemision(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransportistaGuiaRemision= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioGuiaRemision=true;

	public Boolean getMostrarFK_IdUsuarioGuiaRemision() {
		return this.mostrarFK_IdUsuarioGuiaRemision;
	}

	public void setMostrarFK_IdUsuarioGuiaRemision(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioGuiaRemision= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdVendedorGuiaRemision=true;

	public Boolean getMostrarFK_IdVendedorGuiaRemision() {
		return this.mostrarFK_IdVendedorGuiaRemision;
	}

	public void setMostrarFK_IdVendedorGuiaRemision(Boolean visibilidadResaltar) {
		this.mostrarFK_IdVendedorGuiaRemision= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCiudadDestinoGuiaRemision=true;

	public Boolean getActivarFK_IdCiudadDestinoGuiaRemision() {
		return this.activarFK_IdCiudadDestinoGuiaRemision;
	}

	public void setActivarFK_IdCiudadDestinoGuiaRemision(Boolean habilitarResaltar) {
		this.activarFK_IdCiudadDestinoGuiaRemision= habilitarResaltar;
	}

	public Boolean activarFK_IdCiudadOrigenGuiaRemision=true;

	public Boolean getActivarFK_IdCiudadOrigenGuiaRemision() {
		return this.activarFK_IdCiudadOrigenGuiaRemision;
	}

	public void setActivarFK_IdCiudadOrigenGuiaRemision(Boolean habilitarResaltar) {
		this.activarFK_IdCiudadOrigenGuiaRemision= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteGuiaRemision=true;

	public Boolean getActivarFK_IdClienteGuiaRemision() {
		return this.activarFK_IdClienteGuiaRemision;
	}

	public void setActivarFK_IdClienteGuiaRemision(Boolean habilitarResaltar) {
		this.activarFK_IdClienteGuiaRemision= habilitarResaltar;
	}

	public Boolean activarFK_IdConsultorGuiaRemision=true;

	public Boolean getActivarFK_IdConsultorGuiaRemision() {
		return this.activarFK_IdConsultorGuiaRemision;
	}

	public void setActivarFK_IdConsultorGuiaRemision(Boolean habilitarResaltar) {
		this.activarFK_IdConsultorGuiaRemision= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioGuiaRemision=true;

	public Boolean getActivarFK_IdEjercicioGuiaRemision() {
		return this.activarFK_IdEjercicioGuiaRemision;
	}

	public void setActivarFK_IdEjercicioGuiaRemision(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioGuiaRemision= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoGuiaRemision=true;

	public Boolean getActivarFK_IdEmpleadoGuiaRemision() {
		return this.activarFK_IdEmpleadoGuiaRemision;
	}

	public void setActivarFK_IdEmpleadoGuiaRemision(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoGuiaRemision= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaGuiaRemision=true;

	public Boolean getActivarFK_IdEmpresaGuiaRemision() {
		return this.activarFK_IdEmpresaGuiaRemision;
	}

	public void setActivarFK_IdEmpresaGuiaRemision(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaGuiaRemision= habilitarResaltar;
	}

	public Boolean activarFK_IdFacturaGuiaRemision=true;

	public Boolean getActivarFK_IdFacturaGuiaRemision() {
		return this.activarFK_IdFacturaGuiaRemision;
	}

	public void setActivarFK_IdFacturaGuiaRemision(Boolean habilitarResaltar) {
		this.activarFK_IdFacturaGuiaRemision= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoGuiaRemision=true;

	public Boolean getActivarFK_IdFormatoGuiaRemision() {
		return this.activarFK_IdFormatoGuiaRemision;
	}

	public void setActivarFK_IdFormatoGuiaRemision(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoGuiaRemision= habilitarResaltar;
	}

	public Boolean activarFK_IdMonedaGuiaRemision=true;

	public Boolean getActivarFK_IdMonedaGuiaRemision() {
		return this.activarFK_IdMonedaGuiaRemision;
	}

	public void setActivarFK_IdMonedaGuiaRemision(Boolean habilitarResaltar) {
		this.activarFK_IdMonedaGuiaRemision= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoGuiaRemision=true;

	public Boolean getActivarFK_IdPeriodoGuiaRemision() {
		return this.activarFK_IdPeriodoGuiaRemision;
	}

	public void setActivarFK_IdPeriodoGuiaRemision(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoGuiaRemision= habilitarResaltar;
	}

	public Boolean activarFK_IdSubClienteGuiaRemision=true;

	public Boolean getActivarFK_IdSubClienteGuiaRemision() {
		return this.activarFK_IdSubClienteGuiaRemision;
	}

	public void setActivarFK_IdSubClienteGuiaRemision(Boolean habilitarResaltar) {
		this.activarFK_IdSubClienteGuiaRemision= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalGuiaRemision=true;

	public Boolean getActivarFK_IdSucursalGuiaRemision() {
		return this.activarFK_IdSucursalGuiaRemision;
	}

	public void setActivarFK_IdSucursalGuiaRemision(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalGuiaRemision= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoCambioGuiaRemision=true;

	public Boolean getActivarFK_IdTipoCambioGuiaRemision() {
		return this.activarFK_IdTipoCambioGuiaRemision;
	}

	public void setActivarFK_IdTipoCambioGuiaRemision(Boolean habilitarResaltar) {
		this.activarFK_IdTipoCambioGuiaRemision= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoLlamadaGuiaRemision=true;

	public Boolean getActivarFK_IdTipoLlamadaGuiaRemision() {
		return this.activarFK_IdTipoLlamadaGuiaRemision;
	}

	public void setActivarFK_IdTipoLlamadaGuiaRemision(Boolean habilitarResaltar) {
		this.activarFK_IdTipoLlamadaGuiaRemision= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoPrecioGuiaRemision=true;

	public Boolean getActivarFK_IdTipoPrecioGuiaRemision() {
		return this.activarFK_IdTipoPrecioGuiaRemision;
	}

	public void setActivarFK_IdTipoPrecioGuiaRemision(Boolean habilitarResaltar) {
		this.activarFK_IdTipoPrecioGuiaRemision= habilitarResaltar;
	}

	public Boolean activarFK_IdTransporteGuiaRemision=true;

	public Boolean getActivarFK_IdTransporteGuiaRemision() {
		return this.activarFK_IdTransporteGuiaRemision;
	}

	public void setActivarFK_IdTransporteGuiaRemision(Boolean habilitarResaltar) {
		this.activarFK_IdTransporteGuiaRemision= habilitarResaltar;
	}

	public Boolean activarFK_IdTransportistaGuiaRemision=true;

	public Boolean getActivarFK_IdTransportistaGuiaRemision() {
		return this.activarFK_IdTransportistaGuiaRemision;
	}

	public void setActivarFK_IdTransportistaGuiaRemision(Boolean habilitarResaltar) {
		this.activarFK_IdTransportistaGuiaRemision= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioGuiaRemision=true;

	public Boolean getActivarFK_IdUsuarioGuiaRemision() {
		return this.activarFK_IdUsuarioGuiaRemision;
	}

	public void setActivarFK_IdUsuarioGuiaRemision(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioGuiaRemision= habilitarResaltar;
	}

	public Boolean activarFK_IdVendedorGuiaRemision=true;

	public Boolean getActivarFK_IdVendedorGuiaRemision() {
		return this.activarFK_IdVendedorGuiaRemision;
	}

	public void setActivarFK_IdVendedorGuiaRemision(Boolean habilitarResaltar) {
		this.activarFK_IdVendedorGuiaRemision= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCiudadDestinoGuiaRemision=null;

	public Border getResaltarFK_IdCiudadDestinoGuiaRemision() {
		return this.resaltarFK_IdCiudadDestinoGuiaRemision;
	}

	public void setResaltarFK_IdCiudadDestinoGuiaRemision(Border borderResaltar) {
		this.resaltarFK_IdCiudadDestinoGuiaRemision= borderResaltar;
	}

	public void setResaltarFK_IdCiudadDestinoGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCiudadDestinoGuiaRemision= borderResaltar;
	}

	public Border resaltarFK_IdCiudadOrigenGuiaRemision=null;

	public Border getResaltarFK_IdCiudadOrigenGuiaRemision() {
		return this.resaltarFK_IdCiudadOrigenGuiaRemision;
	}

	public void setResaltarFK_IdCiudadOrigenGuiaRemision(Border borderResaltar) {
		this.resaltarFK_IdCiudadOrigenGuiaRemision= borderResaltar;
	}

	public void setResaltarFK_IdCiudadOrigenGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCiudadOrigenGuiaRemision= borderResaltar;
	}

	public Border resaltarFK_IdClienteGuiaRemision=null;

	public Border getResaltarFK_IdClienteGuiaRemision() {
		return this.resaltarFK_IdClienteGuiaRemision;
	}

	public void setResaltarFK_IdClienteGuiaRemision(Border borderResaltar) {
		this.resaltarFK_IdClienteGuiaRemision= borderResaltar;
	}

	public void setResaltarFK_IdClienteGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteGuiaRemision= borderResaltar;
	}

	public Border resaltarFK_IdConsultorGuiaRemision=null;

	public Border getResaltarFK_IdConsultorGuiaRemision() {
		return this.resaltarFK_IdConsultorGuiaRemision;
	}

	public void setResaltarFK_IdConsultorGuiaRemision(Border borderResaltar) {
		this.resaltarFK_IdConsultorGuiaRemision= borderResaltar;
	}

	public void setResaltarFK_IdConsultorGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdConsultorGuiaRemision= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioGuiaRemision=null;

	public Border getResaltarFK_IdEjercicioGuiaRemision() {
		return this.resaltarFK_IdEjercicioGuiaRemision;
	}

	public void setResaltarFK_IdEjercicioGuiaRemision(Border borderResaltar) {
		this.resaltarFK_IdEjercicioGuiaRemision= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioGuiaRemision= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoGuiaRemision=null;

	public Border getResaltarFK_IdEmpleadoGuiaRemision() {
		return this.resaltarFK_IdEmpleadoGuiaRemision;
	}

	public void setResaltarFK_IdEmpleadoGuiaRemision(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoGuiaRemision= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoGuiaRemision= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaGuiaRemision=null;

	public Border getResaltarFK_IdEmpresaGuiaRemision() {
		return this.resaltarFK_IdEmpresaGuiaRemision;
	}

	public void setResaltarFK_IdEmpresaGuiaRemision(Border borderResaltar) {
		this.resaltarFK_IdEmpresaGuiaRemision= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaGuiaRemision= borderResaltar;
	}

	public Border resaltarFK_IdFacturaGuiaRemision=null;

	public Border getResaltarFK_IdFacturaGuiaRemision() {
		return this.resaltarFK_IdFacturaGuiaRemision;
	}

	public void setResaltarFK_IdFacturaGuiaRemision(Border borderResaltar) {
		this.resaltarFK_IdFacturaGuiaRemision= borderResaltar;
	}

	public void setResaltarFK_IdFacturaGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFacturaGuiaRemision= borderResaltar;
	}

	public Border resaltarFK_IdFormatoGuiaRemision=null;

	public Border getResaltarFK_IdFormatoGuiaRemision() {
		return this.resaltarFK_IdFormatoGuiaRemision;
	}

	public void setResaltarFK_IdFormatoGuiaRemision(Border borderResaltar) {
		this.resaltarFK_IdFormatoGuiaRemision= borderResaltar;
	}

	public void setResaltarFK_IdFormatoGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoGuiaRemision= borderResaltar;
	}

	public Border resaltarFK_IdMonedaGuiaRemision=null;

	public Border getResaltarFK_IdMonedaGuiaRemision() {
		return this.resaltarFK_IdMonedaGuiaRemision;
	}

	public void setResaltarFK_IdMonedaGuiaRemision(Border borderResaltar) {
		this.resaltarFK_IdMonedaGuiaRemision= borderResaltar;
	}

	public void setResaltarFK_IdMonedaGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMonedaGuiaRemision= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoGuiaRemision=null;

	public Border getResaltarFK_IdPeriodoGuiaRemision() {
		return this.resaltarFK_IdPeriodoGuiaRemision;
	}

	public void setResaltarFK_IdPeriodoGuiaRemision(Border borderResaltar) {
		this.resaltarFK_IdPeriodoGuiaRemision= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoGuiaRemision= borderResaltar;
	}

	public Border resaltarFK_IdSubClienteGuiaRemision=null;

	public Border getResaltarFK_IdSubClienteGuiaRemision() {
		return this.resaltarFK_IdSubClienteGuiaRemision;
	}

	public void setResaltarFK_IdSubClienteGuiaRemision(Border borderResaltar) {
		this.resaltarFK_IdSubClienteGuiaRemision= borderResaltar;
	}

	public void setResaltarFK_IdSubClienteGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSubClienteGuiaRemision= borderResaltar;
	}

	public Border resaltarFK_IdSucursalGuiaRemision=null;

	public Border getResaltarFK_IdSucursalGuiaRemision() {
		return this.resaltarFK_IdSucursalGuiaRemision;
	}

	public void setResaltarFK_IdSucursalGuiaRemision(Border borderResaltar) {
		this.resaltarFK_IdSucursalGuiaRemision= borderResaltar;
	}

	public void setResaltarFK_IdSucursalGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalGuiaRemision= borderResaltar;
	}

	public Border resaltarFK_IdTipoCambioGuiaRemision=null;

	public Border getResaltarFK_IdTipoCambioGuiaRemision() {
		return this.resaltarFK_IdTipoCambioGuiaRemision;
	}

	public void setResaltarFK_IdTipoCambioGuiaRemision(Border borderResaltar) {
		this.resaltarFK_IdTipoCambioGuiaRemision= borderResaltar;
	}

	public void setResaltarFK_IdTipoCambioGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoCambioGuiaRemision= borderResaltar;
	}

	public Border resaltarFK_IdTipoLlamadaGuiaRemision=null;

	public Border getResaltarFK_IdTipoLlamadaGuiaRemision() {
		return this.resaltarFK_IdTipoLlamadaGuiaRemision;
	}

	public void setResaltarFK_IdTipoLlamadaGuiaRemision(Border borderResaltar) {
		this.resaltarFK_IdTipoLlamadaGuiaRemision= borderResaltar;
	}

	public void setResaltarFK_IdTipoLlamadaGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoLlamadaGuiaRemision= borderResaltar;
	}

	public Border resaltarFK_IdTipoPrecioGuiaRemision=null;

	public Border getResaltarFK_IdTipoPrecioGuiaRemision() {
		return this.resaltarFK_IdTipoPrecioGuiaRemision;
	}

	public void setResaltarFK_IdTipoPrecioGuiaRemision(Border borderResaltar) {
		this.resaltarFK_IdTipoPrecioGuiaRemision= borderResaltar;
	}

	public void setResaltarFK_IdTipoPrecioGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoPrecioGuiaRemision= borderResaltar;
	}

	public Border resaltarFK_IdTransporteGuiaRemision=null;

	public Border getResaltarFK_IdTransporteGuiaRemision() {
		return this.resaltarFK_IdTransporteGuiaRemision;
	}

	public void setResaltarFK_IdTransporteGuiaRemision(Border borderResaltar) {
		this.resaltarFK_IdTransporteGuiaRemision= borderResaltar;
	}

	public void setResaltarFK_IdTransporteGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransporteGuiaRemision= borderResaltar;
	}

	public Border resaltarFK_IdTransportistaGuiaRemision=null;

	public Border getResaltarFK_IdTransportistaGuiaRemision() {
		return this.resaltarFK_IdTransportistaGuiaRemision;
	}

	public void setResaltarFK_IdTransportistaGuiaRemision(Border borderResaltar) {
		this.resaltarFK_IdTransportistaGuiaRemision= borderResaltar;
	}

	public void setResaltarFK_IdTransportistaGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransportistaGuiaRemision= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioGuiaRemision=null;

	public Border getResaltarFK_IdUsuarioGuiaRemision() {
		return this.resaltarFK_IdUsuarioGuiaRemision;
	}

	public void setResaltarFK_IdUsuarioGuiaRemision(Border borderResaltar) {
		this.resaltarFK_IdUsuarioGuiaRemision= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioGuiaRemision= borderResaltar;
	}

	public Border resaltarFK_IdVendedorGuiaRemision=null;

	public Border getResaltarFK_IdVendedorGuiaRemision() {
		return this.resaltarFK_IdVendedorGuiaRemision;
	}

	public void setResaltarFK_IdVendedorGuiaRemision(Border borderResaltar) {
		this.resaltarFK_IdVendedorGuiaRemision= borderResaltar;
	}

	public void setResaltarFK_IdVendedorGuiaRemision(ParametroGeneralUsuario parametroGeneralUsuario/*GuiaRemisionBeanSwingJInternalFrame guiaremisionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdVendedorGuiaRemision= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}