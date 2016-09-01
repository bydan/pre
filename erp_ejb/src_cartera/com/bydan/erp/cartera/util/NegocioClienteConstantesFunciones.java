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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.NegocioClienteConstantesFunciones;
import com.bydan.erp.cartera.util.NegocioClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.NegocioClienteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class NegocioClienteConstantesFunciones extends NegocioClienteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="NegocioCliente";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="NegocioCliente"+NegocioClienteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="NegocioClienteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="NegocioClienteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=NegocioClienteConstantesFunciones.SCHEMA+"_"+NegocioClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/NegocioClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=NegocioClienteConstantesFunciones.SCHEMA+"_"+NegocioClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=NegocioClienteConstantesFunciones.SCHEMA+"_"+NegocioClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/NegocioClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=NegocioClienteConstantesFunciones.SCHEMA+"_"+NegocioClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NegocioClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NegocioClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NegocioClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NegocioClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NegocioClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NegocioClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=NegocioClienteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+NegocioClienteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=NegocioClienteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+NegocioClienteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Negocio Clientes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Negocio Cliente";
	public static final String SCLASSWEBTITULO_LOWER="Negocio Cliente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="NegocioCliente";
	public static final String OBJECTNAME="negociocliente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="negocio_cliente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select negociocliente from "+NegocioClienteConstantesFunciones.SPERSISTENCENAME+" negociocliente";
	public static String QUERYSELECTNATIVE="select "+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".id,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".version_row,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".id_empresa,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".id_cliente,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".nombre_quien_se_factura,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".fax,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".ruc,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".telefono,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".nombre_local,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".e_mail,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".direccion,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_local_propio,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".numero_anios,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".numero_meses,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".id_tipo_ubicacion_negocio,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".empleados_fijos,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".empleado_temporales,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".empleados_total,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".porcentaje_ventas_contado,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".porcentaje_ventas_credito,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".plazo_dias,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".numero_clientes,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".monto_maximo_ventas_mensual,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".monto_minimo_ventas_mensual,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_enero_alto,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_febrero_alto,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_marzo_alto,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_abril_alto,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_mayo_alto,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_junio_alto,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_julio_alto,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_agosto_alto,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_septiembre_alto,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_octubre_alto,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_noviembre_alto,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_diciembre_alto,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_enero_bajo,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_febrero_bajo,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_marzo_bajo,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_abril_bajo,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_mayo_bajo,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_junio_bajo,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_julio_bajo,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_agosto_bajo,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_septiembre_bajo,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_octubre_bajo,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_noviembre_bajo,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".es_diciembre_bajo,"+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME+".descripcion from "+NegocioClienteConstantesFunciones.SCHEMA+"."+NegocioClienteConstantesFunciones.TABLENAME;//+" as "+NegocioClienteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected NegocioClienteConstantesFuncionesAdditional negocioclienteConstantesFuncionesAdditional=null;
	
	public NegocioClienteConstantesFuncionesAdditional getNegocioClienteConstantesFuncionesAdditional() {
		return this.negocioclienteConstantesFuncionesAdditional;
	}
	
	public void setNegocioClienteConstantesFuncionesAdditional(NegocioClienteConstantesFuncionesAdditional negocioclienteConstantesFuncionesAdditional) {
		try {
			this.negocioclienteConstantesFuncionesAdditional=negocioclienteConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCLIENTE= "id_cliente";
    public static final String NOMBREQUIENSEFACTURA= "nombre_quien_se_factura";
    public static final String FAX= "fax";
    public static final String RUC= "ruc";
    public static final String TELEFONO= "telefono";
    public static final String NOMBRELOCAL= "nombre_local";
    public static final String EMAIL= "e_mail";
    public static final String DIRECCION= "direccion";
    public static final String ESLOCALPROPIO= "es_local_propio";
    public static final String NUMEROANIOS= "numero_anios";
    public static final String NUMEROMESES= "numero_meses";
    public static final String IDTIPOUBICACIONNEGOCIO= "id_tipo_ubicacion_negocio";
    public static final String EMPLEADOSFIJOS= "empleados_fijos";
    public static final String EMPLEADOTEMPORALES= "empleado_temporales";
    public static final String EMPLEADOSTOTAL= "empleados_total";
    public static final String PORCENTAJEVENTASCONTADO= "porcentaje_ventas_contado";
    public static final String PORCENTAJEVENTASCREDITO= "porcentaje_ventas_credito";
    public static final String PLAZODIAS= "plazo_dias";
    public static final String NUMEROCLIENTES= "numero_clientes";
    public static final String MONTOMAXIMOVENTASMENSUAL= "monto_maximo_ventas_mensual";
    public static final String MONTOMINIMOVENTASMENSUAL= "monto_minimo_ventas_mensual";
    public static final String ESENEROALTO= "es_enero_alto";
    public static final String ESFEBREROALTO= "es_febrero_alto";
    public static final String ESMARZOALTO= "es_marzo_alto";
    public static final String ESABRILALTO= "es_abril_alto";
    public static final String ESMAYOALTO= "es_mayo_alto";
    public static final String ESJUNIOALTO= "es_junio_alto";
    public static final String ESJULIOALTO= "es_julio_alto";
    public static final String ESAGOSTOALTO= "es_agosto_alto";
    public static final String ESSEPTIEMBREALTO= "es_septiembre_alto";
    public static final String ESOCTUBREALTO= "es_octubre_alto";
    public static final String ESNOVIEMBREALTO= "es_noviembre_alto";
    public static final String ESDICIEMBREALTO= "es_diciembre_alto";
    public static final String ESENEROBAJO= "es_enero_bajo";
    public static final String ESFEBREROBAJO= "es_febrero_bajo";
    public static final String ESMARZOBAJO= "es_marzo_bajo";
    public static final String ESABRILBAJO= "es_abril_bajo";
    public static final String ESMAYOBAJO= "es_mayo_bajo";
    public static final String ESJUNIOBAJO= "es_junio_bajo";
    public static final String ESJULIOBAJO= "es_julio_bajo";
    public static final String ESAGOSTOBAJO= "es_agosto_bajo";
    public static final String ESSEPTIEMBREBAJO= "es_septiembre_bajo";
    public static final String ESOCTUBREBAJO= "es_octubre_bajo";
    public static final String ESNOVIEMBREBAJO= "es_noviembre_bajo";
    public static final String ESDICIEMBREBAJO= "es_diciembre_bajo";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_NOMBREQUIENSEFACTURA= "Nombre Quien Se Factura";
		public static final String LABEL_NOMBREQUIENSEFACTURA_LOWER= "Nombre Quien Se Factura";
    	public static final String LABEL_FAX= "Fax";
		public static final String LABEL_FAX_LOWER= "Fax";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
    	public static final String LABEL_NOMBRELOCAL= "Nombre Local";
		public static final String LABEL_NOMBRELOCAL_LOWER= "Nombre Local";
    	public static final String LABEL_EMAIL= "E Mail";
		public static final String LABEL_EMAIL_LOWER= "E Mail";
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_ESLOCALPROPIO= "Es Local Propio";
		public static final String LABEL_ESLOCALPROPIO_LOWER= "Es Local Propio";
    	public static final String LABEL_NUMEROANIOS= "Numero Anios";
		public static final String LABEL_NUMEROANIOS_LOWER= "Numero Anios";
    	public static final String LABEL_NUMEROMESES= "Numero Meses";
		public static final String LABEL_NUMEROMESES_LOWER= "Numero Meses";
    	public static final String LABEL_IDTIPOUBICACIONNEGOCIO= "Tipo Ubicacion Negocio";
		public static final String LABEL_IDTIPOUBICACIONNEGOCIO_LOWER= "Tipo Ubicacion Negocio";
    	public static final String LABEL_EMPLEADOSFIJOS= "Empleados Fijos";
		public static final String LABEL_EMPLEADOSFIJOS_LOWER= "Empleados Fijos";
    	public static final String LABEL_EMPLEADOTEMPORALES= "Empleado Temporales";
		public static final String LABEL_EMPLEADOTEMPORALES_LOWER= "Empleado Temporales";
    	public static final String LABEL_EMPLEADOSTOTAL= "Empleados Total";
		public static final String LABEL_EMPLEADOSTOTAL_LOWER= "Empleados Total";
    	public static final String LABEL_PORCENTAJEVENTASCONTADO= "Porcentaje Ventas Contado";
		public static final String LABEL_PORCENTAJEVENTASCONTADO_LOWER= "Porcentaje Ventas Contado";
    	public static final String LABEL_PORCENTAJEVENTASCREDITO= "Porcentaje Ventas Credito";
		public static final String LABEL_PORCENTAJEVENTASCREDITO_LOWER= "Porcentaje Ventas Credito";
    	public static final String LABEL_PLAZODIAS= "Plazo Dias";
		public static final String LABEL_PLAZODIAS_LOWER= "Plazo Dias";
    	public static final String LABEL_NUMEROCLIENTES= "Numero Clientes";
		public static final String LABEL_NUMEROCLIENTES_LOWER= "Numero Clientes";
    	public static final String LABEL_MONTOMAXIMOVENTASMENSUAL= "Monto Maximo Ventas Mensual";
		public static final String LABEL_MONTOMAXIMOVENTASMENSUAL_LOWER= "Monto Maximo Ventas Mensual";
    	public static final String LABEL_MONTOMINIMOVENTASMENSUAL= "Monto Minimo Ventas Mensual";
		public static final String LABEL_MONTOMINIMOVENTASMENSUAL_LOWER= "Monto Minimo Ventas Mensual";
    	public static final String LABEL_ESENEROALTO= "Es Enero Alto";
		public static final String LABEL_ESENEROALTO_LOWER= "Es Enero Alto";
    	public static final String LABEL_ESFEBREROALTO= "Es Febrero Alto";
		public static final String LABEL_ESFEBREROALTO_LOWER= "Es Febrero Alto";
    	public static final String LABEL_ESMARZOALTO= "Es Marzo Alto";
		public static final String LABEL_ESMARZOALTO_LOWER= "Es Marzo Alto";
    	public static final String LABEL_ESABRILALTO= "Es Abril Alto";
		public static final String LABEL_ESABRILALTO_LOWER= "Es Abril Alto";
    	public static final String LABEL_ESMAYOALTO= "Es Mayo Alto";
		public static final String LABEL_ESMAYOALTO_LOWER= "Es Mayo Alto";
    	public static final String LABEL_ESJUNIOALTO= "Es Junio Alto";
		public static final String LABEL_ESJUNIOALTO_LOWER= "Es Junio Alto";
    	public static final String LABEL_ESJULIOALTO= "Es Julio Alto";
		public static final String LABEL_ESJULIOALTO_LOWER= "Es Julio Alto";
    	public static final String LABEL_ESAGOSTOALTO= "Es Agosto Alto";
		public static final String LABEL_ESAGOSTOALTO_LOWER= "Es Agosto Alto";
    	public static final String LABEL_ESSEPTIEMBREALTO= "Es Septiembre Alto";
		public static final String LABEL_ESSEPTIEMBREALTO_LOWER= "Es Septiembre Alto";
    	public static final String LABEL_ESOCTUBREALTO= "Es Octubre Alto";
		public static final String LABEL_ESOCTUBREALTO_LOWER= "Es Octubre Alto";
    	public static final String LABEL_ESNOVIEMBREALTO= "Es Noviembre Alto";
		public static final String LABEL_ESNOVIEMBREALTO_LOWER= "Es Noviembre Alto";
    	public static final String LABEL_ESDICIEMBREALTO= "Es Diciembre Alto";
		public static final String LABEL_ESDICIEMBREALTO_LOWER= "Es Diciembre Alto";
    	public static final String LABEL_ESENEROBAJO= "Es Enero Bajo";
		public static final String LABEL_ESENEROBAJO_LOWER= "Es Enero Bajo";
    	public static final String LABEL_ESFEBREROBAJO= "Es Febrero Bajo";
		public static final String LABEL_ESFEBREROBAJO_LOWER= "Es Febrero Bajo";
    	public static final String LABEL_ESMARZOBAJO= "Es Marzo Bajo";
		public static final String LABEL_ESMARZOBAJO_LOWER= "Es Marzo Bajo";
    	public static final String LABEL_ESABRILBAJO= "Es Abril Bajo";
		public static final String LABEL_ESABRILBAJO_LOWER= "Es Abril Bajo";
    	public static final String LABEL_ESMAYOBAJO= "Es Mayo Bajo";
		public static final String LABEL_ESMAYOBAJO_LOWER= "Es Mayo Bajo";
    	public static final String LABEL_ESJUNIOBAJO= "Es Junio Bajo";
		public static final String LABEL_ESJUNIOBAJO_LOWER= "Es Junio Bajo";
    	public static final String LABEL_ESJULIOBAJO= "Es Julio Bajo";
		public static final String LABEL_ESJULIOBAJO_LOWER= "Es Julio Bajo";
    	public static final String LABEL_ESAGOSTOBAJO= "Es Agosto Bajo";
		public static final String LABEL_ESAGOSTOBAJO_LOWER= "Es Agosto Bajo";
    	public static final String LABEL_ESSEPTIEMBREBAJO= "Es Septiembre Bajo";
		public static final String LABEL_ESSEPTIEMBREBAJO_LOWER= "Es Septiembre Bajo";
    	public static final String LABEL_ESOCTUBREBAJO= "Es Octubre Bajo";
		public static final String LABEL_ESOCTUBREBAJO_LOWER= "Es Octubre Bajo";
    	public static final String LABEL_ESNOVIEMBREBAJO= "Es Noviembre Bajo";
		public static final String LABEL_ESNOVIEMBREBAJO_LOWER= "Es Noviembre Bajo";
    	public static final String LABEL_ESDICIEMBREBAJO= "Es Diciembre Bajo";
		public static final String LABEL_ESDICIEMBREBAJO_LOWER= "Es Diciembre Bajo";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
	public static final String SREGEXNOMBRE_QUIEN_SE_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_QUIEN_SE_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXFAX=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXFAX=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	public static final String SREGEXNOMBRE_LOCAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_LOCAL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXE_MAIL=ConstantesValidacion.SREGEXCADENA_MAIL;
	public static final String SMENSAJEREGEXE_MAIL=ConstantesValidacion.SVALIDACIONCADENA_MAIL;	
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getNegocioClienteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.IDEMPRESA)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.IDCLIENTE)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.NOMBREQUIENSEFACTURA)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_NOMBREQUIENSEFACTURA;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.FAX)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_FAX;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.RUC)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.TELEFONO)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_TELEFONO;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.NOMBRELOCAL)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_NOMBRELOCAL;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.EMAIL)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_EMAIL;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.DIRECCION)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.ESLOCALPROPIO)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_ESLOCALPROPIO;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.NUMEROANIOS)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_NUMEROANIOS;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.NUMEROMESES)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_NUMEROMESES;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.IDTIPOUBICACIONNEGOCIO)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_IDTIPOUBICACIONNEGOCIO;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.EMPLEADOSFIJOS)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_EMPLEADOSFIJOS;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.EMPLEADOTEMPORALES)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_EMPLEADOTEMPORALES;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.EMPLEADOSTOTAL)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_EMPLEADOSTOTAL;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.PORCENTAJEVENTASCONTADO)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_PORCENTAJEVENTASCONTADO;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.PORCENTAJEVENTASCREDITO)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_PORCENTAJEVENTASCREDITO;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.PLAZODIAS)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_PLAZODIAS;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.NUMEROCLIENTES)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_NUMEROCLIENTES;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.MONTOMAXIMOVENTASMENSUAL)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_MONTOMAXIMOVENTASMENSUAL;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.MONTOMINIMOVENTASMENSUAL)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_MONTOMINIMOVENTASMENSUAL;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.ESENEROALTO)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_ESENEROALTO;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.ESFEBREROALTO)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_ESFEBREROALTO;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.ESMARZOALTO)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_ESMARZOALTO;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.ESABRILALTO)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_ESABRILALTO;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.ESMAYOALTO)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_ESMAYOALTO;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.ESJUNIOALTO)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_ESJUNIOALTO;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.ESJULIOALTO)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_ESJULIOALTO;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.ESAGOSTOALTO)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_ESAGOSTOALTO;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.ESSEPTIEMBREALTO)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_ESSEPTIEMBREALTO;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.ESOCTUBREALTO)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_ESOCTUBREALTO;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.ESNOVIEMBREALTO)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_ESNOVIEMBREALTO;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.ESDICIEMBREALTO)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_ESDICIEMBREALTO;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.ESENEROBAJO)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_ESENEROBAJO;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.ESFEBREROBAJO)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_ESFEBREROBAJO;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.ESMARZOBAJO)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_ESMARZOBAJO;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.ESABRILBAJO)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_ESABRILBAJO;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.ESMAYOBAJO)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_ESMAYOBAJO;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.ESJUNIOBAJO)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_ESJUNIOBAJO;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.ESJULIOBAJO)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_ESJULIOBAJO;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.ESAGOSTOBAJO)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_ESAGOSTOBAJO;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.ESSEPTIEMBREBAJO)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_ESSEPTIEMBREBAJO;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.ESOCTUBREBAJO)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_ESOCTUBREBAJO;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.ESNOVIEMBREBAJO)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_ESNOVIEMBREBAJO;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.ESDICIEMBREBAJO)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_ESDICIEMBREBAJO;}
		if(sNombreColumna.equals(NegocioClienteConstantesFunciones.DESCRIPCION)) {sLabelColumna=NegocioClienteConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getes_local_propioDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!negociocliente.getes_local_propio()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_local_propioHtmlDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(negociocliente.getId(),negociocliente.getes_local_propio());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getes_enero_altoDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!negociocliente.getes_enero_alto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_enero_altoHtmlDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(negociocliente.getId(),negociocliente.getes_enero_alto());

		return sDescripcion;
	}	
		
	public static String getes_febrero_altoDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!negociocliente.getes_febrero_alto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_febrero_altoHtmlDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(negociocliente.getId(),negociocliente.getes_febrero_alto());

		return sDescripcion;
	}	
		
	public static String getes_marzo_altoDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!negociocliente.getes_marzo_alto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_marzo_altoHtmlDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(negociocliente.getId(),negociocliente.getes_marzo_alto());

		return sDescripcion;
	}	
		
	public static String getes_abril_altoDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!negociocliente.getes_abril_alto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_abril_altoHtmlDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(negociocliente.getId(),negociocliente.getes_abril_alto());

		return sDescripcion;
	}	
		
	public static String getes_mayo_altoDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!negociocliente.getes_mayo_alto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_mayo_altoHtmlDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(negociocliente.getId(),negociocliente.getes_mayo_alto());

		return sDescripcion;
	}	
		
	public static String getes_junio_altoDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!negociocliente.getes_junio_alto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_junio_altoHtmlDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(negociocliente.getId(),negociocliente.getes_junio_alto());

		return sDescripcion;
	}	
		
	public static String getes_julio_altoDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!negociocliente.getes_julio_alto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_julio_altoHtmlDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(negociocliente.getId(),negociocliente.getes_julio_alto());

		return sDescripcion;
	}	
		
	public static String getes_agosto_altoDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!negociocliente.getes_agosto_alto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_agosto_altoHtmlDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(negociocliente.getId(),negociocliente.getes_agosto_alto());

		return sDescripcion;
	}	
		
	public static String getes_septiembre_altoDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!negociocliente.getes_septiembre_alto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_septiembre_altoHtmlDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(negociocliente.getId(),negociocliente.getes_septiembre_alto());

		return sDescripcion;
	}	
		
	public static String getes_octubre_altoDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!negociocliente.getes_octubre_alto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_octubre_altoHtmlDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(negociocliente.getId(),negociocliente.getes_octubre_alto());

		return sDescripcion;
	}	
		
	public static String getes_noviembre_altoDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!negociocliente.getes_noviembre_alto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_noviembre_altoHtmlDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(negociocliente.getId(),negociocliente.getes_noviembre_alto());

		return sDescripcion;
	}	
		
	public static String getes_diciembre_altoDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!negociocliente.getes_diciembre_alto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_diciembre_altoHtmlDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(negociocliente.getId(),negociocliente.getes_diciembre_alto());

		return sDescripcion;
	}	
		
	public static String getes_enero_bajoDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!negociocliente.getes_enero_bajo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_enero_bajoHtmlDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(negociocliente.getId(),negociocliente.getes_enero_bajo());

		return sDescripcion;
	}	
		
	public static String getes_febrero_bajoDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!negociocliente.getes_febrero_bajo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_febrero_bajoHtmlDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(negociocliente.getId(),negociocliente.getes_febrero_bajo());

		return sDescripcion;
	}	
		
	public static String getes_marzo_bajoDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!negociocliente.getes_marzo_bajo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_marzo_bajoHtmlDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(negociocliente.getId(),negociocliente.getes_marzo_bajo());

		return sDescripcion;
	}	
		
	public static String getes_abril_bajoDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!negociocliente.getes_abril_bajo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_abril_bajoHtmlDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(negociocliente.getId(),negociocliente.getes_abril_bajo());

		return sDescripcion;
	}	
		
	public static String getes_mayo_bajoDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!negociocliente.getes_mayo_bajo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_mayo_bajoHtmlDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(negociocliente.getId(),negociocliente.getes_mayo_bajo());

		return sDescripcion;
	}	
		
	public static String getes_junio_bajoDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!negociocliente.getes_junio_bajo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_junio_bajoHtmlDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(negociocliente.getId(),negociocliente.getes_junio_bajo());

		return sDescripcion;
	}	
		
	public static String getes_julio_bajoDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!negociocliente.getes_julio_bajo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_julio_bajoHtmlDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(negociocliente.getId(),negociocliente.getes_julio_bajo());

		return sDescripcion;
	}	
		
	public static String getes_agosto_bajoDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!negociocliente.getes_agosto_bajo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_agosto_bajoHtmlDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(negociocliente.getId(),negociocliente.getes_agosto_bajo());

		return sDescripcion;
	}	
		
	public static String getes_septiembre_bajoDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!negociocliente.getes_septiembre_bajo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_septiembre_bajoHtmlDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(negociocliente.getId(),negociocliente.getes_septiembre_bajo());

		return sDescripcion;
	}	
		
	public static String getes_octubre_bajoDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!negociocliente.getes_octubre_bajo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_octubre_bajoHtmlDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(negociocliente.getId(),negociocliente.getes_octubre_bajo());

		return sDescripcion;
	}	
		
	public static String getes_noviembre_bajoDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!negociocliente.getes_noviembre_bajo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_noviembre_bajoHtmlDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(negociocliente.getId(),negociocliente.getes_noviembre_bajo());

		return sDescripcion;
	}	
		
	public static String getes_diciembre_bajoDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!negociocliente.getes_diciembre_bajo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_diciembre_bajoHtmlDescripcion(NegocioCliente negociocliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(negociocliente.getId(),negociocliente.getes_diciembre_bajo());

		return sDescripcion;
	}	
			
	
	public static String getNegocioClienteDescripcion(NegocioCliente negociocliente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(negociocliente !=null/* && negociocliente.getId()!=0*/) {
			sDescripcion=negociocliente.getnombre_quien_se_factura();//negocioclientenegociocliente.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getNegocioClienteDescripcionDetallado(NegocioCliente negociocliente) {
		String sDescripcion="";
			
		sDescripcion+=NegocioClienteConstantesFunciones.ID+"=";
		sDescripcion+=negociocliente.getId().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=negociocliente.getVersionRow().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=negociocliente.getid_empresa().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=negociocliente.getid_cliente().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.NOMBREQUIENSEFACTURA+"=";
		sDescripcion+=negociocliente.getnombre_quien_se_factura()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.FAX+"=";
		sDescripcion+=negociocliente.getfax()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.RUC+"=";
		sDescripcion+=negociocliente.getruc()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.TELEFONO+"=";
		sDescripcion+=negociocliente.gettelefono()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.NOMBRELOCAL+"=";
		sDescripcion+=negociocliente.getnombre_local()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.EMAIL+"=";
		sDescripcion+=negociocliente.gete_mail()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.DIRECCION+"=";
		sDescripcion+=negociocliente.getdireccion()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.ESLOCALPROPIO+"=";
		sDescripcion+=negociocliente.getes_local_propio().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.NUMEROANIOS+"=";
		sDescripcion+=negociocliente.getnumero_anios().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.NUMEROMESES+"=";
		sDescripcion+=negociocliente.getnumero_meses().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.IDTIPOUBICACIONNEGOCIO+"=";
		sDescripcion+=negociocliente.getid_tipo_ubicacion_negocio().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.EMPLEADOSFIJOS+"=";
		sDescripcion+=negociocliente.getempleados_fijos().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.EMPLEADOTEMPORALES+"=";
		sDescripcion+=negociocliente.getempleado_temporales().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.EMPLEADOSTOTAL+"=";
		sDescripcion+=negociocliente.getempleados_total().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.PORCENTAJEVENTASCONTADO+"=";
		sDescripcion+=negociocliente.getporcentaje_ventas_contado().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.PORCENTAJEVENTASCREDITO+"=";
		sDescripcion+=negociocliente.getporcentaje_ventas_credito().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.PLAZODIAS+"=";
		sDescripcion+=negociocliente.getplazo_dias().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.NUMEROCLIENTES+"=";
		sDescripcion+=negociocliente.getnumero_clientes().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.MONTOMAXIMOVENTASMENSUAL+"=";
		sDescripcion+=negociocliente.getmonto_maximo_ventas_mensual().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.MONTOMINIMOVENTASMENSUAL+"=";
		sDescripcion+=negociocliente.getmonto_minimo_ventas_mensual().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.ESENEROALTO+"=";
		sDescripcion+=negociocliente.getes_enero_alto().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.ESFEBREROALTO+"=";
		sDescripcion+=negociocliente.getes_febrero_alto().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.ESMARZOALTO+"=";
		sDescripcion+=negociocliente.getes_marzo_alto().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.ESABRILALTO+"=";
		sDescripcion+=negociocliente.getes_abril_alto().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.ESMAYOALTO+"=";
		sDescripcion+=negociocliente.getes_mayo_alto().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.ESJUNIOALTO+"=";
		sDescripcion+=negociocliente.getes_junio_alto().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.ESJULIOALTO+"=";
		sDescripcion+=negociocliente.getes_julio_alto().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.ESAGOSTOALTO+"=";
		sDescripcion+=negociocliente.getes_agosto_alto().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.ESSEPTIEMBREALTO+"=";
		sDescripcion+=negociocliente.getes_septiembre_alto().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.ESOCTUBREALTO+"=";
		sDescripcion+=negociocliente.getes_octubre_alto().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.ESNOVIEMBREALTO+"=";
		sDescripcion+=negociocliente.getes_noviembre_alto().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.ESDICIEMBREALTO+"=";
		sDescripcion+=negociocliente.getes_diciembre_alto().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.ESENEROBAJO+"=";
		sDescripcion+=negociocliente.getes_enero_bajo().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.ESFEBREROBAJO+"=";
		sDescripcion+=negociocliente.getes_febrero_bajo().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.ESMARZOBAJO+"=";
		sDescripcion+=negociocliente.getes_marzo_bajo().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.ESABRILBAJO+"=";
		sDescripcion+=negociocliente.getes_abril_bajo().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.ESMAYOBAJO+"=";
		sDescripcion+=negociocliente.getes_mayo_bajo().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.ESJUNIOBAJO+"=";
		sDescripcion+=negociocliente.getes_junio_bajo().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.ESJULIOBAJO+"=";
		sDescripcion+=negociocliente.getes_julio_bajo().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.ESAGOSTOBAJO+"=";
		sDescripcion+=negociocliente.getes_agosto_bajo().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.ESSEPTIEMBREBAJO+"=";
		sDescripcion+=negociocliente.getes_septiembre_bajo().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.ESOCTUBREBAJO+"=";
		sDescripcion+=negociocliente.getes_octubre_bajo().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.ESNOVIEMBREBAJO+"=";
		sDescripcion+=negociocliente.getes_noviembre_bajo().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.ESDICIEMBREBAJO+"=";
		sDescripcion+=negociocliente.getes_diciembre_bajo().toString()+",";
		sDescripcion+=NegocioClienteConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=negociocliente.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setNegocioClienteDescripcion(NegocioCliente negociocliente,String sValor) throws Exception {			
		if(negociocliente !=null) {
			negociocliente.setnombre_quien_se_factura(sValor);//negocioclientenegociocliente.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getTipoUbicacionNegocioDescripcion(TipoUbicacionNegocio tipoubicacionnegocio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoubicacionnegocio!=null/*&&tipoubicacionnegocio.getId()>0*/) {
			sDescripcion=TipoUbicacionNegocioConstantesFunciones.getTipoUbicacionNegocioDescripcion(tipoubicacionnegocio);
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
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoUbicacionNegocio")) {
			sNombreIndice="Tipo=  Por Tipo Ubicacion Negocio";
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

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoUbicacionNegocio(Long id_tipo_ubicacion_negocio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_ubicacion_negocio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Ubicacion Negocio="+id_tipo_ubicacion_negocio.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosNegocioCliente(NegocioCliente negociocliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		negociocliente.setnombre_quien_se_factura(negociocliente.getnombre_quien_se_factura().trim());
		negociocliente.setfax(negociocliente.getfax().trim());
		negociocliente.setruc(negociocliente.getruc().trim());
		negociocliente.settelefono(negociocliente.gettelefono().trim());
		negociocliente.setnombre_local(negociocliente.getnombre_local().trim());
		negociocliente.sete_mail(negociocliente.gete_mail().trim());
		negociocliente.setdireccion(negociocliente.getdireccion().trim());
		negociocliente.setdescripcion(negociocliente.getdescripcion().trim());
	}
	
	public static void quitarEspaciosNegocioClientes(List<NegocioCliente> negocioclientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(NegocioCliente negociocliente: negocioclientes) {
			negociocliente.setnombre_quien_se_factura(negociocliente.getnombre_quien_se_factura().trim());
			negociocliente.setfax(negociocliente.getfax().trim());
			negociocliente.setruc(negociocliente.getruc().trim());
			negociocliente.settelefono(negociocliente.gettelefono().trim());
			negociocliente.setnombre_local(negociocliente.getnombre_local().trim());
			negociocliente.sete_mail(negociocliente.gete_mail().trim());
			negociocliente.setdireccion(negociocliente.getdireccion().trim());
			negociocliente.setdescripcion(negociocliente.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNegocioCliente(NegocioCliente negociocliente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && negociocliente.getConCambioAuxiliar()) {
			negociocliente.setIsDeleted(negociocliente.getIsDeletedAuxiliar());	
			negociocliente.setIsNew(negociocliente.getIsNewAuxiliar());	
			negociocliente.setIsChanged(negociocliente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			negociocliente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			negociocliente.setIsDeletedAuxiliar(false);	
			negociocliente.setIsNewAuxiliar(false);	
			negociocliente.setIsChangedAuxiliar(false);
			
			negociocliente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNegocioClientes(List<NegocioCliente> negocioclientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(NegocioCliente negociocliente : negocioclientes) {
			if(conAsignarBase && negociocliente.getConCambioAuxiliar()) {
				negociocliente.setIsDeleted(negociocliente.getIsDeletedAuxiliar());	
				negociocliente.setIsNew(negociocliente.getIsNewAuxiliar());	
				negociocliente.setIsChanged(negociocliente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				negociocliente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				negociocliente.setIsDeletedAuxiliar(false);	
				negociocliente.setIsNewAuxiliar(false);	
				negociocliente.setIsChangedAuxiliar(false);
				
				negociocliente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresNegocioCliente(NegocioCliente negociocliente,Boolean conEnteros) throws Exception  {
		negociocliente.setporcentaje_ventas_contado(0.0);
		negociocliente.setporcentaje_ventas_credito(0.0);
		negociocliente.setmonto_maximo_ventas_mensual(0.0);
		negociocliente.setmonto_minimo_ventas_mensual(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			negociocliente.setnumero_anios(0);
			negociocliente.setnumero_meses(0);
			negociocliente.setempleados_fijos(0);
			negociocliente.setempleado_temporales(0);
			negociocliente.setempleados_total(0);
			negociocliente.setplazo_dias(0);
			negociocliente.setnumero_clientes(0);
		}
	}		
	
	public static void InicializarValoresNegocioClientes(List<NegocioCliente> negocioclientes,Boolean conEnteros) throws Exception  {
		
		for(NegocioCliente negociocliente: negocioclientes) {
			negociocliente.setporcentaje_ventas_contado(0.0);
			negociocliente.setporcentaje_ventas_credito(0.0);
			negociocliente.setmonto_maximo_ventas_mensual(0.0);
			negociocliente.setmonto_minimo_ventas_mensual(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				negociocliente.setnumero_anios(0);
				negociocliente.setnumero_meses(0);
				negociocliente.setempleados_fijos(0);
				negociocliente.setempleado_temporales(0);
				negociocliente.setempleados_total(0);
				negociocliente.setplazo_dias(0);
				negociocliente.setnumero_clientes(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaNegocioCliente(List<NegocioCliente> negocioclientes,NegocioCliente negocioclienteAux) throws Exception  {
		NegocioClienteConstantesFunciones.InicializarValoresNegocioCliente(negocioclienteAux,true);
		
		for(NegocioCliente negociocliente: negocioclientes) {
			if(negociocliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			negocioclienteAux.setnumero_anios(negocioclienteAux.getnumero_anios()+negociocliente.getnumero_anios());			
			negocioclienteAux.setnumero_meses(negocioclienteAux.getnumero_meses()+negociocliente.getnumero_meses());			
			negocioclienteAux.setempleados_fijos(negocioclienteAux.getempleados_fijos()+negociocliente.getempleados_fijos());			
			negocioclienteAux.setempleado_temporales(negocioclienteAux.getempleado_temporales()+negociocliente.getempleado_temporales());			
			negocioclienteAux.setempleados_total(negocioclienteAux.getempleados_total()+negociocliente.getempleados_total());			
			negocioclienteAux.setporcentaje_ventas_contado(negocioclienteAux.getporcentaje_ventas_contado()+negociocliente.getporcentaje_ventas_contado());			
			negocioclienteAux.setporcentaje_ventas_credito(negocioclienteAux.getporcentaje_ventas_credito()+negociocliente.getporcentaje_ventas_credito());			
			negocioclienteAux.setplazo_dias(negocioclienteAux.getplazo_dias()+negociocliente.getplazo_dias());			
			negocioclienteAux.setnumero_clientes(negocioclienteAux.getnumero_clientes()+negociocliente.getnumero_clientes());			
			negocioclienteAux.setmonto_maximo_ventas_mensual(negocioclienteAux.getmonto_maximo_ventas_mensual()+negociocliente.getmonto_maximo_ventas_mensual());			
			negocioclienteAux.setmonto_minimo_ventas_mensual(negocioclienteAux.getmonto_minimo_ventas_mensual()+negociocliente.getmonto_minimo_ventas_mensual());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNegocioCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=NegocioClienteConstantesFunciones.getArrayColumnasGlobalesNegocioCliente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesNegocioCliente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(NegocioClienteConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(NegocioClienteConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoNegocioCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<NegocioCliente> negocioclientes,NegocioCliente negociocliente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(NegocioCliente negocioclienteAux: negocioclientes) {
			if(negocioclienteAux!=null && negociocliente!=null) {
				if((negocioclienteAux.getId()==null && negociocliente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(negocioclienteAux.getId()!=null && negociocliente.getId()!=null){
					if(negocioclienteAux.getId().equals(negociocliente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaNegocioCliente(List<NegocioCliente> negocioclientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentaje_ventas_contadoTotal=0.0;
		Double porcentaje_ventas_creditoTotal=0.0;
		Double monto_maximo_ventas_mensualTotal=0.0;
		Double monto_minimo_ventas_mensualTotal=0.0;
	
		for(NegocioCliente negociocliente: negocioclientes) {			
			if(negociocliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentaje_ventas_contadoTotal+=negociocliente.getporcentaje_ventas_contado();
			porcentaje_ventas_creditoTotal+=negociocliente.getporcentaje_ventas_credito();
			monto_maximo_ventas_mensualTotal+=negociocliente.getmonto_maximo_ventas_mensual();
			monto_minimo_ventas_mensualTotal+=negociocliente.getmonto_minimo_ventas_mensual();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NegocioClienteConstantesFunciones.PORCENTAJEVENTASCONTADO);
		datoGeneral.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_PORCENTAJEVENTASCONTADO);
		datoGeneral.setdValorDouble(porcentaje_ventas_contadoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NegocioClienteConstantesFunciones.PORCENTAJEVENTASCREDITO);
		datoGeneral.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_PORCENTAJEVENTASCREDITO);
		datoGeneral.setdValorDouble(porcentaje_ventas_creditoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NegocioClienteConstantesFunciones.MONTOMAXIMOVENTASMENSUAL);
		datoGeneral.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_MONTOMAXIMOVENTASMENSUAL);
		datoGeneral.setdValorDouble(monto_maximo_ventas_mensualTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NegocioClienteConstantesFunciones.MONTOMINIMOVENTASMENSUAL);
		datoGeneral.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_MONTOMINIMOVENTASMENSUAL);
		datoGeneral.setdValorDouble(monto_minimo_ventas_mensualTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaNegocioCliente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_ID, NegocioClienteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_VERSIONROW, NegocioClienteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_IDEMPRESA, NegocioClienteConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_IDCLIENTE, NegocioClienteConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_NOMBREQUIENSEFACTURA, NegocioClienteConstantesFunciones.NOMBREQUIENSEFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_FAX, NegocioClienteConstantesFunciones.FAX,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_RUC, NegocioClienteConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_TELEFONO, NegocioClienteConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_NOMBRELOCAL, NegocioClienteConstantesFunciones.NOMBRELOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_EMAIL, NegocioClienteConstantesFunciones.EMAIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_DIRECCION, NegocioClienteConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_ESLOCALPROPIO, NegocioClienteConstantesFunciones.ESLOCALPROPIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_NUMEROANIOS, NegocioClienteConstantesFunciones.NUMEROANIOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_NUMEROMESES, NegocioClienteConstantesFunciones.NUMEROMESES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_IDTIPOUBICACIONNEGOCIO, NegocioClienteConstantesFunciones.IDTIPOUBICACIONNEGOCIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_EMPLEADOSFIJOS, NegocioClienteConstantesFunciones.EMPLEADOSFIJOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_EMPLEADOTEMPORALES, NegocioClienteConstantesFunciones.EMPLEADOTEMPORALES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_EMPLEADOSTOTAL, NegocioClienteConstantesFunciones.EMPLEADOSTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_PORCENTAJEVENTASCONTADO, NegocioClienteConstantesFunciones.PORCENTAJEVENTASCONTADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_PORCENTAJEVENTASCREDITO, NegocioClienteConstantesFunciones.PORCENTAJEVENTASCREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_PLAZODIAS, NegocioClienteConstantesFunciones.PLAZODIAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_NUMEROCLIENTES, NegocioClienteConstantesFunciones.NUMEROCLIENTES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_MONTOMAXIMOVENTASMENSUAL, NegocioClienteConstantesFunciones.MONTOMAXIMOVENTASMENSUAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_MONTOMINIMOVENTASMENSUAL, NegocioClienteConstantesFunciones.MONTOMINIMOVENTASMENSUAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_ESENEROALTO, NegocioClienteConstantesFunciones.ESENEROALTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_ESFEBREROALTO, NegocioClienteConstantesFunciones.ESFEBREROALTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_ESMARZOALTO, NegocioClienteConstantesFunciones.ESMARZOALTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_ESABRILALTO, NegocioClienteConstantesFunciones.ESABRILALTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_ESMAYOALTO, NegocioClienteConstantesFunciones.ESMAYOALTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_ESJUNIOALTO, NegocioClienteConstantesFunciones.ESJUNIOALTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_ESJULIOALTO, NegocioClienteConstantesFunciones.ESJULIOALTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_ESAGOSTOALTO, NegocioClienteConstantesFunciones.ESAGOSTOALTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_ESSEPTIEMBREALTO, NegocioClienteConstantesFunciones.ESSEPTIEMBREALTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_ESOCTUBREALTO, NegocioClienteConstantesFunciones.ESOCTUBREALTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_ESNOVIEMBREALTO, NegocioClienteConstantesFunciones.ESNOVIEMBREALTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_ESDICIEMBREALTO, NegocioClienteConstantesFunciones.ESDICIEMBREALTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_ESENEROBAJO, NegocioClienteConstantesFunciones.ESENEROBAJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_ESFEBREROBAJO, NegocioClienteConstantesFunciones.ESFEBREROBAJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_ESMARZOBAJO, NegocioClienteConstantesFunciones.ESMARZOBAJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_ESABRILBAJO, NegocioClienteConstantesFunciones.ESABRILBAJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_ESMAYOBAJO, NegocioClienteConstantesFunciones.ESMAYOBAJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_ESJUNIOBAJO, NegocioClienteConstantesFunciones.ESJUNIOBAJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_ESJULIOBAJO, NegocioClienteConstantesFunciones.ESJULIOBAJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_ESAGOSTOBAJO, NegocioClienteConstantesFunciones.ESAGOSTOBAJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_ESSEPTIEMBREBAJO, NegocioClienteConstantesFunciones.ESSEPTIEMBREBAJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_ESOCTUBREBAJO, NegocioClienteConstantesFunciones.ESOCTUBREBAJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_ESNOVIEMBREBAJO, NegocioClienteConstantesFunciones.ESNOVIEMBREBAJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_ESDICIEMBREBAJO, NegocioClienteConstantesFunciones.ESDICIEMBREBAJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NegocioClienteConstantesFunciones.LABEL_DESCRIPCION, NegocioClienteConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasNegocioCliente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.NOMBREQUIENSEFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.FAX;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.NOMBRELOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.EMAIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.ESLOCALPROPIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.NUMEROANIOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.NUMEROMESES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.IDTIPOUBICACIONNEGOCIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.EMPLEADOSFIJOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.EMPLEADOTEMPORALES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.EMPLEADOSTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.PORCENTAJEVENTASCONTADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.PORCENTAJEVENTASCREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.PLAZODIAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.NUMEROCLIENTES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.MONTOMAXIMOVENTASMENSUAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.MONTOMINIMOVENTASMENSUAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.ESENEROALTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.ESFEBREROALTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.ESMARZOALTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.ESABRILALTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.ESMAYOALTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.ESJUNIOALTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.ESJULIOALTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.ESAGOSTOALTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.ESSEPTIEMBREALTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.ESOCTUBREALTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.ESNOVIEMBREALTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.ESDICIEMBREALTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.ESENEROBAJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.ESFEBREROBAJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.ESMARZOBAJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.ESABRILBAJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.ESMAYOBAJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.ESJUNIOBAJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.ESJULIOBAJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.ESAGOSTOBAJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.ESSEPTIEMBREBAJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.ESOCTUBREBAJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.ESNOVIEMBREBAJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.ESDICIEMBREBAJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NegocioClienteConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNegocioCliente() throws Exception  {
		return NegocioClienteConstantesFunciones.getTiposSeleccionarNegocioCliente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNegocioCliente(Boolean conFk) throws Exception  {
		return NegocioClienteConstantesFunciones.getTiposSeleccionarNegocioCliente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNegocioCliente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_NOMBREQUIENSEFACTURA);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_NOMBREQUIENSEFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_FAX);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_FAX);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_NOMBRELOCAL);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_NOMBRELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_EMAIL);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_EMAIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_ESLOCALPROPIO);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_ESLOCALPROPIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_NUMEROANIOS);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_NUMEROANIOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_NUMEROMESES);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_NUMEROMESES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_IDTIPOUBICACIONNEGOCIO);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_IDTIPOUBICACIONNEGOCIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_EMPLEADOSFIJOS);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_EMPLEADOSFIJOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_EMPLEADOTEMPORALES);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_EMPLEADOTEMPORALES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_EMPLEADOSTOTAL);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_EMPLEADOSTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_PORCENTAJEVENTASCONTADO);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_PORCENTAJEVENTASCONTADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_PORCENTAJEVENTASCREDITO);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_PORCENTAJEVENTASCREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_PLAZODIAS);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_PLAZODIAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_NUMEROCLIENTES);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_NUMEROCLIENTES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_MONTOMAXIMOVENTASMENSUAL);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_MONTOMAXIMOVENTASMENSUAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_MONTOMINIMOVENTASMENSUAL);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_MONTOMINIMOVENTASMENSUAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_ESENEROALTO);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_ESENEROALTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_ESFEBREROALTO);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_ESFEBREROALTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_ESMARZOALTO);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_ESMARZOALTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_ESABRILALTO);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_ESABRILALTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_ESMAYOALTO);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_ESMAYOALTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_ESJUNIOALTO);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_ESJUNIOALTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_ESJULIOALTO);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_ESJULIOALTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_ESAGOSTOALTO);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_ESAGOSTOALTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_ESSEPTIEMBREALTO);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_ESSEPTIEMBREALTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_ESOCTUBREALTO);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_ESOCTUBREALTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_ESNOVIEMBREALTO);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_ESNOVIEMBREALTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_ESDICIEMBREALTO);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_ESDICIEMBREALTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_ESENEROBAJO);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_ESENEROBAJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_ESFEBREROBAJO);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_ESFEBREROBAJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_ESMARZOBAJO);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_ESMARZOBAJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_ESABRILBAJO);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_ESABRILBAJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_ESMAYOBAJO);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_ESMAYOBAJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_ESJUNIOBAJO);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_ESJUNIOBAJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_ESJULIOBAJO);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_ESJULIOBAJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_ESAGOSTOBAJO);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_ESAGOSTOBAJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_ESSEPTIEMBREBAJO);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_ESSEPTIEMBREBAJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_ESOCTUBREBAJO);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_ESOCTUBREBAJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_ESNOVIEMBREBAJO);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_ESNOVIEMBREBAJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_ESDICIEMBREBAJO);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_ESDICIEMBREBAJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NegocioClienteConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(NegocioClienteConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesNegocioCliente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesNegocioCliente(NegocioCliente negocioclienteAux) throws Exception {
		
			negocioclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(negocioclienteAux.getEmpresa()));
			negocioclienteAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(negocioclienteAux.getCliente()));
			negocioclienteAux.settipoubicacionnegocio_descripcion(TipoUbicacionNegocioConstantesFunciones.getTipoUbicacionNegocioDescripcion(negocioclienteAux.getTipoUbicacionNegocio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesNegocioCliente(List<NegocioCliente> negocioclientesTemp) throws Exception {
		for(NegocioCliente negocioclienteAux:negocioclientesTemp) {
			
			negocioclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(negocioclienteAux.getEmpresa()));
			negocioclienteAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(negocioclienteAux.getCliente()));
			negocioclienteAux.settipoubicacionnegocio_descripcion(TipoUbicacionNegocioConstantesFunciones.getTipoUbicacionNegocioDescripcion(negocioclienteAux.getTipoUbicacionNegocio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfNegocioCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(TipoUbicacionNegocio.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoUbicacionNegocio.class)) {
						classes.add(new Classe(TipoUbicacionNegocio.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfNegocioCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoUbicacionNegocio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoUbicacionNegocio.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoUbicacionNegocio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoUbicacionNegocio.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfNegocioCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return NegocioClienteConstantesFunciones.getClassesRelationshipsOfNegocioCliente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfNegocioCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNegocioCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return NegocioClienteConstantesFunciones.getClassesRelationshipsFromStringsOfNegocioCliente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNegocioCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(NegocioCliente negociocliente,List<NegocioCliente> negocioclientes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			NegocioCliente negocioclienteEncontrado=null;
			
			for(NegocioCliente negocioclienteLocal:negocioclientes) {
				if(negocioclienteLocal.getId().equals(negociocliente.getId())) {
					negocioclienteEncontrado=negocioclienteLocal;
					
					negocioclienteLocal.setIsChanged(negociocliente.getIsChanged());
					negocioclienteLocal.setIsNew(negociocliente.getIsNew());
					negocioclienteLocal.setIsDeleted(negociocliente.getIsDeleted());
					
					negocioclienteLocal.setGeneralEntityOriginal(negociocliente.getGeneralEntityOriginal());
					
					negocioclienteLocal.setId(negociocliente.getId());	
					negocioclienteLocal.setVersionRow(negociocliente.getVersionRow());	
					negocioclienteLocal.setid_empresa(negociocliente.getid_empresa());	
					negocioclienteLocal.setid_cliente(negociocliente.getid_cliente());	
					negocioclienteLocal.setnombre_quien_se_factura(negociocliente.getnombre_quien_se_factura());	
					negocioclienteLocal.setfax(negociocliente.getfax());	
					negocioclienteLocal.setruc(negociocliente.getruc());	
					negocioclienteLocal.settelefono(negociocliente.gettelefono());	
					negocioclienteLocal.setnombre_local(negociocliente.getnombre_local());	
					negocioclienteLocal.sete_mail(negociocliente.gete_mail());	
					negocioclienteLocal.setdireccion(negociocliente.getdireccion());	
					negocioclienteLocal.setes_local_propio(negociocliente.getes_local_propio());	
					negocioclienteLocal.setnumero_anios(negociocliente.getnumero_anios());	
					negocioclienteLocal.setnumero_meses(negociocliente.getnumero_meses());	
					negocioclienteLocal.setid_tipo_ubicacion_negocio(negociocliente.getid_tipo_ubicacion_negocio());	
					negocioclienteLocal.setempleados_fijos(negociocliente.getempleados_fijos());	
					negocioclienteLocal.setempleado_temporales(negociocliente.getempleado_temporales());	
					negocioclienteLocal.setempleados_total(negociocliente.getempleados_total());	
					negocioclienteLocal.setporcentaje_ventas_contado(negociocliente.getporcentaje_ventas_contado());	
					negocioclienteLocal.setporcentaje_ventas_credito(negociocliente.getporcentaje_ventas_credito());	
					negocioclienteLocal.setplazo_dias(negociocliente.getplazo_dias());	
					negocioclienteLocal.setnumero_clientes(negociocliente.getnumero_clientes());	
					negocioclienteLocal.setmonto_maximo_ventas_mensual(negociocliente.getmonto_maximo_ventas_mensual());	
					negocioclienteLocal.setmonto_minimo_ventas_mensual(negociocliente.getmonto_minimo_ventas_mensual());	
					negocioclienteLocal.setes_enero_alto(negociocliente.getes_enero_alto());	
					negocioclienteLocal.setes_febrero_alto(negociocliente.getes_febrero_alto());	
					negocioclienteLocal.setes_marzo_alto(negociocliente.getes_marzo_alto());	
					negocioclienteLocal.setes_abril_alto(negociocliente.getes_abril_alto());	
					negocioclienteLocal.setes_mayo_alto(negociocliente.getes_mayo_alto());	
					negocioclienteLocal.setes_junio_alto(negociocliente.getes_junio_alto());	
					negocioclienteLocal.setes_julio_alto(negociocliente.getes_julio_alto());	
					negocioclienteLocal.setes_agosto_alto(negociocliente.getes_agosto_alto());	
					negocioclienteLocal.setes_septiembre_alto(negociocliente.getes_septiembre_alto());	
					negocioclienteLocal.setes_octubre_alto(negociocliente.getes_octubre_alto());	
					negocioclienteLocal.setes_noviembre_alto(negociocliente.getes_noviembre_alto());	
					negocioclienteLocal.setes_diciembre_alto(negociocliente.getes_diciembre_alto());	
					negocioclienteLocal.setes_enero_bajo(negociocliente.getes_enero_bajo());	
					negocioclienteLocal.setes_febrero_bajo(negociocliente.getes_febrero_bajo());	
					negocioclienteLocal.setes_marzo_bajo(negociocliente.getes_marzo_bajo());	
					negocioclienteLocal.setes_abril_bajo(negociocliente.getes_abril_bajo());	
					negocioclienteLocal.setes_mayo_bajo(negociocliente.getes_mayo_bajo());	
					negocioclienteLocal.setes_junio_bajo(negociocliente.getes_junio_bajo());	
					negocioclienteLocal.setes_julio_bajo(negociocliente.getes_julio_bajo());	
					negocioclienteLocal.setes_agosto_bajo(negociocliente.getes_agosto_bajo());	
					negocioclienteLocal.setes_septiembre_bajo(negociocliente.getes_septiembre_bajo());	
					negocioclienteLocal.setes_octubre_bajo(negociocliente.getes_octubre_bajo());	
					negocioclienteLocal.setes_noviembre_bajo(negociocliente.getes_noviembre_bajo());	
					negocioclienteLocal.setes_diciembre_bajo(negociocliente.getes_diciembre_bajo());	
					negocioclienteLocal.setdescripcion(negociocliente.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!negociocliente.getIsDeleted()) {
				if(!existe) {
					negocioclientes.add(negociocliente);
				}
			} else {
				if(negocioclienteEncontrado!=null && permiteQuitar)  {
					negocioclientes.remove(negocioclienteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(NegocioCliente negociocliente,List<NegocioCliente> negocioclientes) throws Exception {
		try	{			
			for(NegocioCliente negocioclienteLocal:negocioclientes) {
				if(negocioclienteLocal.getId().equals(negociocliente.getId())) {
					negocioclienteLocal.setIsSelected(negociocliente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesNegocioCliente(List<NegocioCliente> negocioclientesAux) throws Exception {
		//this.negocioclientesAux=negocioclientesAux;
		
		for(NegocioCliente negocioclienteAux:negocioclientesAux) {
			if(negocioclienteAux.getIsChanged()) {
				negocioclienteAux.setIsChanged(false);
			}		
			
			if(negocioclienteAux.getIsNew()) {
				negocioclienteAux.setIsNew(false);
			}	
			
			if(negocioclienteAux.getIsDeleted()) {
				negocioclienteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesNegocioCliente(NegocioCliente negocioclienteAux) throws Exception {
		//this.negocioclienteAux=negocioclienteAux;
		
			if(negocioclienteAux.getIsChanged()) {
				negocioclienteAux.setIsChanged(false);
			}		
			
			if(negocioclienteAux.getIsNew()) {
				negocioclienteAux.setIsNew(false);
			}	
			
			if(negocioclienteAux.getIsDeleted()) {
				negocioclienteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(NegocioCliente negocioclienteAsignar,NegocioCliente negociocliente) throws Exception {
		negocioclienteAsignar.setId(negociocliente.getId());	
		negocioclienteAsignar.setVersionRow(negociocliente.getVersionRow());	
		negocioclienteAsignar.setid_empresa(negociocliente.getid_empresa());
		negocioclienteAsignar.setempresa_descripcion(negociocliente.getempresa_descripcion());	
		negocioclienteAsignar.setid_cliente(negociocliente.getid_cliente());
		negocioclienteAsignar.setcliente_descripcion(negociocliente.getcliente_descripcion());	
		negocioclienteAsignar.setnombre_quien_se_factura(negociocliente.getnombre_quien_se_factura());	
		negocioclienteAsignar.setfax(negociocliente.getfax());	
		negocioclienteAsignar.setruc(negociocliente.getruc());	
		negocioclienteAsignar.settelefono(negociocliente.gettelefono());	
		negocioclienteAsignar.setnombre_local(negociocliente.getnombre_local());	
		negocioclienteAsignar.sete_mail(negociocliente.gete_mail());	
		negocioclienteAsignar.setdireccion(negociocliente.getdireccion());	
		negocioclienteAsignar.setes_local_propio(negociocliente.getes_local_propio());	
		negocioclienteAsignar.setnumero_anios(negociocliente.getnumero_anios());	
		negocioclienteAsignar.setnumero_meses(negociocliente.getnumero_meses());	
		negocioclienteAsignar.setid_tipo_ubicacion_negocio(negociocliente.getid_tipo_ubicacion_negocio());
		negocioclienteAsignar.settipoubicacionnegocio_descripcion(negociocliente.gettipoubicacionnegocio_descripcion());	
		negocioclienteAsignar.setempleados_fijos(negociocliente.getempleados_fijos());	
		negocioclienteAsignar.setempleado_temporales(negociocliente.getempleado_temporales());	
		negocioclienteAsignar.setempleados_total(negociocliente.getempleados_total());	
		negocioclienteAsignar.setporcentaje_ventas_contado(negociocliente.getporcentaje_ventas_contado());	
		negocioclienteAsignar.setporcentaje_ventas_credito(negociocliente.getporcentaje_ventas_credito());	
		negocioclienteAsignar.setplazo_dias(negociocliente.getplazo_dias());	
		negocioclienteAsignar.setnumero_clientes(negociocliente.getnumero_clientes());	
		negocioclienteAsignar.setmonto_maximo_ventas_mensual(negociocliente.getmonto_maximo_ventas_mensual());	
		negocioclienteAsignar.setmonto_minimo_ventas_mensual(negociocliente.getmonto_minimo_ventas_mensual());	
		negocioclienteAsignar.setes_enero_alto(negociocliente.getes_enero_alto());	
		negocioclienteAsignar.setes_febrero_alto(negociocliente.getes_febrero_alto());	
		negocioclienteAsignar.setes_marzo_alto(negociocliente.getes_marzo_alto());	
		negocioclienteAsignar.setes_abril_alto(negociocliente.getes_abril_alto());	
		negocioclienteAsignar.setes_mayo_alto(negociocliente.getes_mayo_alto());	
		negocioclienteAsignar.setes_junio_alto(negociocliente.getes_junio_alto());	
		negocioclienteAsignar.setes_julio_alto(negociocliente.getes_julio_alto());	
		negocioclienteAsignar.setes_agosto_alto(negociocliente.getes_agosto_alto());	
		negocioclienteAsignar.setes_septiembre_alto(negociocliente.getes_septiembre_alto());	
		negocioclienteAsignar.setes_octubre_alto(negociocliente.getes_octubre_alto());	
		negocioclienteAsignar.setes_noviembre_alto(negociocliente.getes_noviembre_alto());	
		negocioclienteAsignar.setes_diciembre_alto(negociocliente.getes_diciembre_alto());	
		negocioclienteAsignar.setes_enero_bajo(negociocliente.getes_enero_bajo());	
		negocioclienteAsignar.setes_febrero_bajo(negociocliente.getes_febrero_bajo());	
		negocioclienteAsignar.setes_marzo_bajo(negociocliente.getes_marzo_bajo());	
		negocioclienteAsignar.setes_abril_bajo(negociocliente.getes_abril_bajo());	
		negocioclienteAsignar.setes_mayo_bajo(negociocliente.getes_mayo_bajo());	
		negocioclienteAsignar.setes_junio_bajo(negociocliente.getes_junio_bajo());	
		negocioclienteAsignar.setes_julio_bajo(negociocliente.getes_julio_bajo());	
		negocioclienteAsignar.setes_agosto_bajo(negociocliente.getes_agosto_bajo());	
		negocioclienteAsignar.setes_septiembre_bajo(negociocliente.getes_septiembre_bajo());	
		negocioclienteAsignar.setes_octubre_bajo(negociocliente.getes_octubre_bajo());	
		negocioclienteAsignar.setes_noviembre_bajo(negociocliente.getes_noviembre_bajo());	
		negocioclienteAsignar.setes_diciembre_bajo(negociocliente.getes_diciembre_bajo());	
		negocioclienteAsignar.setdescripcion(negociocliente.getdescripcion());	
	}
	
	public static void inicializarNegocioCliente(NegocioCliente negociocliente) throws Exception {
		try {
				negociocliente.setId(0L);	
					
				negociocliente.setid_empresa(-1L);	
				negociocliente.setid_cliente(-1L);	
				negociocliente.setnombre_quien_se_factura("");	
				negociocliente.setfax("");	
				negociocliente.setruc("");	
				negociocliente.settelefono("");	
				negociocliente.setnombre_local("");	
				negociocliente.sete_mail("");	
				negociocliente.setdireccion("");	
				negociocliente.setes_local_propio(false);	
				negociocliente.setnumero_anios(0);	
				negociocliente.setnumero_meses(0);	
				negociocliente.setid_tipo_ubicacion_negocio(-1L);	
				negociocliente.setempleados_fijos(0);	
				negociocliente.setempleado_temporales(0);	
				negociocliente.setempleados_total(0);	
				negociocliente.setporcentaje_ventas_contado(0.0);	
				negociocliente.setporcentaje_ventas_credito(0.0);	
				negociocliente.setplazo_dias(0);	
				negociocliente.setnumero_clientes(0);	
				negociocliente.setmonto_maximo_ventas_mensual(0.0);	
				negociocliente.setmonto_minimo_ventas_mensual(0.0);	
				negociocliente.setes_enero_alto(false);	
				negociocliente.setes_febrero_alto(false);	
				negociocliente.setes_marzo_alto(false);	
				negociocliente.setes_abril_alto(false);	
				negociocliente.setes_mayo_alto(false);	
				negociocliente.setes_junio_alto(false);	
				negociocliente.setes_julio_alto(false);	
				negociocliente.setes_agosto_alto(false);	
				negociocliente.setes_septiembre_alto(false);	
				negociocliente.setes_octubre_alto(false);	
				negociocliente.setes_noviembre_alto(false);	
				negociocliente.setes_diciembre_alto(false);	
				negociocliente.setes_enero_bajo(false);	
				negociocliente.setes_febrero_bajo(false);	
				negociocliente.setes_marzo_bajo(false);	
				negociocliente.setes_abril_bajo(false);	
				negociocliente.setes_mayo_bajo(false);	
				negociocliente.setes_junio_bajo(false);	
				negociocliente.setes_julio_bajo(false);	
				negociocliente.setes_agosto_bajo(false);	
				negociocliente.setes_septiembre_bajo(false);	
				negociocliente.setes_octubre_bajo(false);	
				negociocliente.setes_noviembre_bajo(false);	
				negociocliente.setes_diciembre_bajo(false);	
				negociocliente.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderNegocioCliente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_NOMBREQUIENSEFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_FAX);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_NOMBRELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_EMAIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_ESLOCALPROPIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_NUMEROANIOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_NUMEROMESES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_IDTIPOUBICACIONNEGOCIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_EMPLEADOSFIJOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_EMPLEADOTEMPORALES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_EMPLEADOSTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_PORCENTAJEVENTASCONTADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_PORCENTAJEVENTASCREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_PLAZODIAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_NUMEROCLIENTES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_MONTOMAXIMOVENTASMENSUAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_MONTOMINIMOVENTASMENSUAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_ESENEROALTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_ESFEBREROALTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_ESMARZOALTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_ESABRILALTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_ESMAYOALTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_ESJUNIOALTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_ESJULIOALTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_ESAGOSTOALTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_ESSEPTIEMBREALTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_ESOCTUBREALTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_ESNOVIEMBREALTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_ESDICIEMBREALTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_ESENEROBAJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_ESFEBREROBAJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_ESMARZOBAJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_ESABRILBAJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_ESMAYOBAJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_ESJUNIOBAJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_ESJULIOBAJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_ESAGOSTOBAJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_ESSEPTIEMBREBAJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_ESOCTUBREBAJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_ESNOVIEMBREBAJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_ESDICIEMBREBAJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NegocioClienteConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataNegocioCliente(String sTipo,Row row,Workbook workbook,NegocioCliente negociocliente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(negociocliente.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(negociocliente.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(negociocliente.getnombre_quien_se_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(negociocliente.getfax());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(negociocliente.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(negociocliente.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(negociocliente.getnombre_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(negociocliente.gete_mail());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(negociocliente.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(negociocliente.getes_local_propio()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(negociocliente.getnumero_anios());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(negociocliente.getnumero_meses());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(negociocliente.gettipoubicacionnegocio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(negociocliente.getempleados_fijos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(negociocliente.getempleado_temporales());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(negociocliente.getempleados_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(negociocliente.getporcentaje_ventas_contado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(negociocliente.getporcentaje_ventas_credito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(negociocliente.getplazo_dias());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(negociocliente.getnumero_clientes());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(negociocliente.getmonto_maximo_ventas_mensual());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(negociocliente.getmonto_minimo_ventas_mensual());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(negociocliente.getes_enero_alto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(negociocliente.getes_febrero_alto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(negociocliente.getes_marzo_alto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(negociocliente.getes_abril_alto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(negociocliente.getes_mayo_alto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(negociocliente.getes_junio_alto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(negociocliente.getes_julio_alto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(negociocliente.getes_agosto_alto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(negociocliente.getes_septiembre_alto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(negociocliente.getes_octubre_alto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(negociocliente.getes_noviembre_alto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(negociocliente.getes_diciembre_alto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(negociocliente.getes_enero_bajo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(negociocliente.getes_febrero_bajo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(negociocliente.getes_marzo_bajo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(negociocliente.getes_abril_bajo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(negociocliente.getes_mayo_bajo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(negociocliente.getes_junio_bajo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(negociocliente.getes_julio_bajo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(negociocliente.getes_agosto_bajo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(negociocliente.getes_septiembre_bajo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(negociocliente.getes_octubre_bajo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(negociocliente.getes_noviembre_bajo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(negociocliente.getes_diciembre_bajo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(negociocliente.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryNegocioCliente=Constantes.SFINALQUERY;
	
	public String getsFinalQueryNegocioCliente() {
		return this.sFinalQueryNegocioCliente;
	}
	
	public void setsFinalQueryNegocioCliente(String sFinalQueryNegocioCliente) {
		this.sFinalQueryNegocioCliente= sFinalQueryNegocioCliente;
	}
	
	public Border resaltarSeleccionarNegocioCliente=null;
	
	public Border setResaltarSeleccionarNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarNegocioCliente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarNegocioCliente() {
		return this.resaltarSeleccionarNegocioCliente;
	}
	
	public void setResaltarSeleccionarNegocioCliente(Border borderResaltarSeleccionarNegocioCliente) {
		this.resaltarSeleccionarNegocioCliente= borderResaltarSeleccionarNegocioCliente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridNegocioCliente=null;
	public Boolean mostraridNegocioCliente=true;
	public Boolean activaridNegocioCliente=true;

	public Border resaltarid_empresaNegocioCliente=null;
	public Boolean mostrarid_empresaNegocioCliente=true;
	public Boolean activarid_empresaNegocioCliente=true;
	public Boolean cargarid_empresaNegocioCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaNegocioCliente=false;//ConEventDepend=true

	public Border resaltarid_clienteNegocioCliente=null;
	public Boolean mostrarid_clienteNegocioCliente=true;
	public Boolean activarid_clienteNegocioCliente=true;
	public Boolean cargarid_clienteNegocioCliente=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteNegocioCliente=false;//ConEventDepend=true

	public Border resaltarnombre_quien_se_facturaNegocioCliente=null;
	public Boolean mostrarnombre_quien_se_facturaNegocioCliente=true;
	public Boolean activarnombre_quien_se_facturaNegocioCliente=true;

	public Border resaltarfaxNegocioCliente=null;
	public Boolean mostrarfaxNegocioCliente=true;
	public Boolean activarfaxNegocioCliente=true;

	public Border resaltarrucNegocioCliente=null;
	public Boolean mostrarrucNegocioCliente=true;
	public Boolean activarrucNegocioCliente=true;

	public Border resaltartelefonoNegocioCliente=null;
	public Boolean mostrartelefonoNegocioCliente=true;
	public Boolean activartelefonoNegocioCliente=true;

	public Border resaltarnombre_localNegocioCliente=null;
	public Boolean mostrarnombre_localNegocioCliente=true;
	public Boolean activarnombre_localNegocioCliente=true;

	public Border resaltare_mailNegocioCliente=null;
	public Boolean mostrare_mailNegocioCliente=true;
	public Boolean activare_mailNegocioCliente=true;

	public Border resaltardireccionNegocioCliente=null;
	public Boolean mostrardireccionNegocioCliente=true;
	public Boolean activardireccionNegocioCliente=true;

	public Border resaltares_local_propioNegocioCliente=null;
	public Boolean mostrares_local_propioNegocioCliente=true;
	public Boolean activares_local_propioNegocioCliente=true;

	public Border resaltarnumero_aniosNegocioCliente=null;
	public Boolean mostrarnumero_aniosNegocioCliente=true;
	public Boolean activarnumero_aniosNegocioCliente=true;

	public Border resaltarnumero_mesesNegocioCliente=null;
	public Boolean mostrarnumero_mesesNegocioCliente=true;
	public Boolean activarnumero_mesesNegocioCliente=true;

	public Border resaltarid_tipo_ubicacion_negocioNegocioCliente=null;
	public Boolean mostrarid_tipo_ubicacion_negocioNegocioCliente=true;
	public Boolean activarid_tipo_ubicacion_negocioNegocioCliente=true;
	public Boolean cargarid_tipo_ubicacion_negocioNegocioCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_ubicacion_negocioNegocioCliente=false;//ConEventDepend=true

	public Border resaltarempleados_fijosNegocioCliente=null;
	public Boolean mostrarempleados_fijosNegocioCliente=true;
	public Boolean activarempleados_fijosNegocioCliente=true;

	public Border resaltarempleado_temporalesNegocioCliente=null;
	public Boolean mostrarempleado_temporalesNegocioCliente=true;
	public Boolean activarempleado_temporalesNegocioCliente=true;

	public Border resaltarempleados_totalNegocioCliente=null;
	public Boolean mostrarempleados_totalNegocioCliente=true;
	public Boolean activarempleados_totalNegocioCliente=true;

	public Border resaltarporcentaje_ventas_contadoNegocioCliente=null;
	public Boolean mostrarporcentaje_ventas_contadoNegocioCliente=true;
	public Boolean activarporcentaje_ventas_contadoNegocioCliente=true;

	public Border resaltarporcentaje_ventas_creditoNegocioCliente=null;
	public Boolean mostrarporcentaje_ventas_creditoNegocioCliente=true;
	public Boolean activarporcentaje_ventas_creditoNegocioCliente=true;

	public Border resaltarplazo_diasNegocioCliente=null;
	public Boolean mostrarplazo_diasNegocioCliente=true;
	public Boolean activarplazo_diasNegocioCliente=true;

	public Border resaltarnumero_clientesNegocioCliente=null;
	public Boolean mostrarnumero_clientesNegocioCliente=true;
	public Boolean activarnumero_clientesNegocioCliente=true;

	public Border resaltarmonto_maximo_ventas_mensualNegocioCliente=null;
	public Boolean mostrarmonto_maximo_ventas_mensualNegocioCliente=true;
	public Boolean activarmonto_maximo_ventas_mensualNegocioCliente=true;

	public Border resaltarmonto_minimo_ventas_mensualNegocioCliente=null;
	public Boolean mostrarmonto_minimo_ventas_mensualNegocioCliente=true;
	public Boolean activarmonto_minimo_ventas_mensualNegocioCliente=true;

	public Border resaltares_enero_altoNegocioCliente=null;
	public Boolean mostrares_enero_altoNegocioCliente=true;
	public Boolean activares_enero_altoNegocioCliente=true;

	public Border resaltares_febrero_altoNegocioCliente=null;
	public Boolean mostrares_febrero_altoNegocioCliente=true;
	public Boolean activares_febrero_altoNegocioCliente=true;

	public Border resaltares_marzo_altoNegocioCliente=null;
	public Boolean mostrares_marzo_altoNegocioCliente=true;
	public Boolean activares_marzo_altoNegocioCliente=true;

	public Border resaltares_abril_altoNegocioCliente=null;
	public Boolean mostrares_abril_altoNegocioCliente=true;
	public Boolean activares_abril_altoNegocioCliente=true;

	public Border resaltares_mayo_altoNegocioCliente=null;
	public Boolean mostrares_mayo_altoNegocioCliente=true;
	public Boolean activares_mayo_altoNegocioCliente=true;

	public Border resaltares_junio_altoNegocioCliente=null;
	public Boolean mostrares_junio_altoNegocioCliente=true;
	public Boolean activares_junio_altoNegocioCliente=true;

	public Border resaltares_julio_altoNegocioCliente=null;
	public Boolean mostrares_julio_altoNegocioCliente=true;
	public Boolean activares_julio_altoNegocioCliente=true;

	public Border resaltares_agosto_altoNegocioCliente=null;
	public Boolean mostrares_agosto_altoNegocioCliente=true;
	public Boolean activares_agosto_altoNegocioCliente=true;

	public Border resaltares_septiembre_altoNegocioCliente=null;
	public Boolean mostrares_septiembre_altoNegocioCliente=true;
	public Boolean activares_septiembre_altoNegocioCliente=true;

	public Border resaltares_octubre_altoNegocioCliente=null;
	public Boolean mostrares_octubre_altoNegocioCliente=true;
	public Boolean activares_octubre_altoNegocioCliente=true;

	public Border resaltares_noviembre_altoNegocioCliente=null;
	public Boolean mostrares_noviembre_altoNegocioCliente=true;
	public Boolean activares_noviembre_altoNegocioCliente=true;

	public Border resaltares_diciembre_altoNegocioCliente=null;
	public Boolean mostrares_diciembre_altoNegocioCliente=true;
	public Boolean activares_diciembre_altoNegocioCliente=true;

	public Border resaltares_enero_bajoNegocioCliente=null;
	public Boolean mostrares_enero_bajoNegocioCliente=true;
	public Boolean activares_enero_bajoNegocioCliente=true;

	public Border resaltares_febrero_bajoNegocioCliente=null;
	public Boolean mostrares_febrero_bajoNegocioCliente=true;
	public Boolean activares_febrero_bajoNegocioCliente=true;

	public Border resaltares_marzo_bajoNegocioCliente=null;
	public Boolean mostrares_marzo_bajoNegocioCliente=true;
	public Boolean activares_marzo_bajoNegocioCliente=true;

	public Border resaltares_abril_bajoNegocioCliente=null;
	public Boolean mostrares_abril_bajoNegocioCliente=true;
	public Boolean activares_abril_bajoNegocioCliente=true;

	public Border resaltares_mayo_bajoNegocioCliente=null;
	public Boolean mostrares_mayo_bajoNegocioCliente=true;
	public Boolean activares_mayo_bajoNegocioCliente=true;

	public Border resaltares_junio_bajoNegocioCliente=null;
	public Boolean mostrares_junio_bajoNegocioCliente=true;
	public Boolean activares_junio_bajoNegocioCliente=true;

	public Border resaltares_julio_bajoNegocioCliente=null;
	public Boolean mostrares_julio_bajoNegocioCliente=true;
	public Boolean activares_julio_bajoNegocioCliente=true;

	public Border resaltares_agosto_bajoNegocioCliente=null;
	public Boolean mostrares_agosto_bajoNegocioCliente=true;
	public Boolean activares_agosto_bajoNegocioCliente=true;

	public Border resaltares_septiembre_bajoNegocioCliente=null;
	public Boolean mostrares_septiembre_bajoNegocioCliente=true;
	public Boolean activares_septiembre_bajoNegocioCliente=true;

	public Border resaltares_octubre_bajoNegocioCliente=null;
	public Boolean mostrares_octubre_bajoNegocioCliente=true;
	public Boolean activares_octubre_bajoNegocioCliente=true;

	public Border resaltares_noviembre_bajoNegocioCliente=null;
	public Boolean mostrares_noviembre_bajoNegocioCliente=true;
	public Boolean activares_noviembre_bajoNegocioCliente=true;

	public Border resaltares_diciembre_bajoNegocioCliente=null;
	public Boolean mostrares_diciembre_bajoNegocioCliente=true;
	public Boolean activares_diciembre_bajoNegocioCliente=true;

	public Border resaltardescripcionNegocioCliente=null;
	public Boolean mostrardescripcionNegocioCliente=true;
	public Boolean activardescripcionNegocioCliente=true;

	
	

	public Border setResaltaridNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltaridNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridNegocioCliente() {
		return this.resaltaridNegocioCliente;
	}

	public void setResaltaridNegocioCliente(Border borderResaltar) {
		this.resaltaridNegocioCliente= borderResaltar;
	}

	public Boolean getMostraridNegocioCliente() {
		return this.mostraridNegocioCliente;
	}

	public void setMostraridNegocioCliente(Boolean mostraridNegocioCliente) {
		this.mostraridNegocioCliente= mostraridNegocioCliente;
	}

	public Boolean getActivaridNegocioCliente() {
		return this.activaridNegocioCliente;
	}

	public void setActivaridNegocioCliente(Boolean activaridNegocioCliente) {
		this.activaridNegocioCliente= activaridNegocioCliente;
	}

	public Border setResaltarid_empresaNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltarid_empresaNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaNegocioCliente() {
		return this.resaltarid_empresaNegocioCliente;
	}

	public void setResaltarid_empresaNegocioCliente(Border borderResaltar) {
		this.resaltarid_empresaNegocioCliente= borderResaltar;
	}

	public Boolean getMostrarid_empresaNegocioCliente() {
		return this.mostrarid_empresaNegocioCliente;
	}

	public void setMostrarid_empresaNegocioCliente(Boolean mostrarid_empresaNegocioCliente) {
		this.mostrarid_empresaNegocioCliente= mostrarid_empresaNegocioCliente;
	}

	public Boolean getActivarid_empresaNegocioCliente() {
		return this.activarid_empresaNegocioCliente;
	}

	public void setActivarid_empresaNegocioCliente(Boolean activarid_empresaNegocioCliente) {
		this.activarid_empresaNegocioCliente= activarid_empresaNegocioCliente;
	}

	public Boolean getCargarid_empresaNegocioCliente() {
		return this.cargarid_empresaNegocioCliente;
	}

	public void setCargarid_empresaNegocioCliente(Boolean cargarid_empresaNegocioCliente) {
		this.cargarid_empresaNegocioCliente= cargarid_empresaNegocioCliente;
	}

	public Border setResaltarid_clienteNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltarid_clienteNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteNegocioCliente() {
		return this.resaltarid_clienteNegocioCliente;
	}

	public void setResaltarid_clienteNegocioCliente(Border borderResaltar) {
		this.resaltarid_clienteNegocioCliente= borderResaltar;
	}

	public Boolean getMostrarid_clienteNegocioCliente() {
		return this.mostrarid_clienteNegocioCliente;
	}

	public void setMostrarid_clienteNegocioCliente(Boolean mostrarid_clienteNegocioCliente) {
		this.mostrarid_clienteNegocioCliente= mostrarid_clienteNegocioCliente;
	}

	public Boolean getActivarid_clienteNegocioCliente() {
		return this.activarid_clienteNegocioCliente;
	}

	public void setActivarid_clienteNegocioCliente(Boolean activarid_clienteNegocioCliente) {
		this.activarid_clienteNegocioCliente= activarid_clienteNegocioCliente;
	}

	public Boolean getCargarid_clienteNegocioCliente() {
		return this.cargarid_clienteNegocioCliente;
	}

	public void setCargarid_clienteNegocioCliente(Boolean cargarid_clienteNegocioCliente) {
		this.cargarid_clienteNegocioCliente= cargarid_clienteNegocioCliente;
	}

	public Border setResaltarnombre_quien_se_facturaNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltarnombre_quien_se_facturaNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_quien_se_facturaNegocioCliente() {
		return this.resaltarnombre_quien_se_facturaNegocioCliente;
	}

	public void setResaltarnombre_quien_se_facturaNegocioCliente(Border borderResaltar) {
		this.resaltarnombre_quien_se_facturaNegocioCliente= borderResaltar;
	}

	public Boolean getMostrarnombre_quien_se_facturaNegocioCliente() {
		return this.mostrarnombre_quien_se_facturaNegocioCliente;
	}

	public void setMostrarnombre_quien_se_facturaNegocioCliente(Boolean mostrarnombre_quien_se_facturaNegocioCliente) {
		this.mostrarnombre_quien_se_facturaNegocioCliente= mostrarnombre_quien_se_facturaNegocioCliente;
	}

	public Boolean getActivarnombre_quien_se_facturaNegocioCliente() {
		return this.activarnombre_quien_se_facturaNegocioCliente;
	}

	public void setActivarnombre_quien_se_facturaNegocioCliente(Boolean activarnombre_quien_se_facturaNegocioCliente) {
		this.activarnombre_quien_se_facturaNegocioCliente= activarnombre_quien_se_facturaNegocioCliente;
	}

	public Border setResaltarfaxNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltarfaxNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfaxNegocioCliente() {
		return this.resaltarfaxNegocioCliente;
	}

	public void setResaltarfaxNegocioCliente(Border borderResaltar) {
		this.resaltarfaxNegocioCliente= borderResaltar;
	}

	public Boolean getMostrarfaxNegocioCliente() {
		return this.mostrarfaxNegocioCliente;
	}

	public void setMostrarfaxNegocioCliente(Boolean mostrarfaxNegocioCliente) {
		this.mostrarfaxNegocioCliente= mostrarfaxNegocioCliente;
	}

	public Boolean getActivarfaxNegocioCliente() {
		return this.activarfaxNegocioCliente;
	}

	public void setActivarfaxNegocioCliente(Boolean activarfaxNegocioCliente) {
		this.activarfaxNegocioCliente= activarfaxNegocioCliente;
	}

	public Border setResaltarrucNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltarrucNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucNegocioCliente() {
		return this.resaltarrucNegocioCliente;
	}

	public void setResaltarrucNegocioCliente(Border borderResaltar) {
		this.resaltarrucNegocioCliente= borderResaltar;
	}

	public Boolean getMostrarrucNegocioCliente() {
		return this.mostrarrucNegocioCliente;
	}

	public void setMostrarrucNegocioCliente(Boolean mostrarrucNegocioCliente) {
		this.mostrarrucNegocioCliente= mostrarrucNegocioCliente;
	}

	public Boolean getActivarrucNegocioCliente() {
		return this.activarrucNegocioCliente;
	}

	public void setActivarrucNegocioCliente(Boolean activarrucNegocioCliente) {
		this.activarrucNegocioCliente= activarrucNegocioCliente;
	}

	public Border setResaltartelefonoNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltartelefonoNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoNegocioCliente() {
		return this.resaltartelefonoNegocioCliente;
	}

	public void setResaltartelefonoNegocioCliente(Border borderResaltar) {
		this.resaltartelefonoNegocioCliente= borderResaltar;
	}

	public Boolean getMostrartelefonoNegocioCliente() {
		return this.mostrartelefonoNegocioCliente;
	}

	public void setMostrartelefonoNegocioCliente(Boolean mostrartelefonoNegocioCliente) {
		this.mostrartelefonoNegocioCliente= mostrartelefonoNegocioCliente;
	}

	public Boolean getActivartelefonoNegocioCliente() {
		return this.activartelefonoNegocioCliente;
	}

	public void setActivartelefonoNegocioCliente(Boolean activartelefonoNegocioCliente) {
		this.activartelefonoNegocioCliente= activartelefonoNegocioCliente;
	}

	public Border setResaltarnombre_localNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltarnombre_localNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_localNegocioCliente() {
		return this.resaltarnombre_localNegocioCliente;
	}

	public void setResaltarnombre_localNegocioCliente(Border borderResaltar) {
		this.resaltarnombre_localNegocioCliente= borderResaltar;
	}

	public Boolean getMostrarnombre_localNegocioCliente() {
		return this.mostrarnombre_localNegocioCliente;
	}

	public void setMostrarnombre_localNegocioCliente(Boolean mostrarnombre_localNegocioCliente) {
		this.mostrarnombre_localNegocioCliente= mostrarnombre_localNegocioCliente;
	}

	public Boolean getActivarnombre_localNegocioCliente() {
		return this.activarnombre_localNegocioCliente;
	}

	public void setActivarnombre_localNegocioCliente(Boolean activarnombre_localNegocioCliente) {
		this.activarnombre_localNegocioCliente= activarnombre_localNegocioCliente;
	}

	public Border setResaltare_mailNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltare_mailNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltare_mailNegocioCliente() {
		return this.resaltare_mailNegocioCliente;
	}

	public void setResaltare_mailNegocioCliente(Border borderResaltar) {
		this.resaltare_mailNegocioCliente= borderResaltar;
	}

	public Boolean getMostrare_mailNegocioCliente() {
		return this.mostrare_mailNegocioCliente;
	}

	public void setMostrare_mailNegocioCliente(Boolean mostrare_mailNegocioCliente) {
		this.mostrare_mailNegocioCliente= mostrare_mailNegocioCliente;
	}

	public Boolean getActivare_mailNegocioCliente() {
		return this.activare_mailNegocioCliente;
	}

	public void setActivare_mailNegocioCliente(Boolean activare_mailNegocioCliente) {
		this.activare_mailNegocioCliente= activare_mailNegocioCliente;
	}

	public Border setResaltardireccionNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltardireccionNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionNegocioCliente() {
		return this.resaltardireccionNegocioCliente;
	}

	public void setResaltardireccionNegocioCliente(Border borderResaltar) {
		this.resaltardireccionNegocioCliente= borderResaltar;
	}

	public Boolean getMostrardireccionNegocioCliente() {
		return this.mostrardireccionNegocioCliente;
	}

	public void setMostrardireccionNegocioCliente(Boolean mostrardireccionNegocioCliente) {
		this.mostrardireccionNegocioCliente= mostrardireccionNegocioCliente;
	}

	public Boolean getActivardireccionNegocioCliente() {
		return this.activardireccionNegocioCliente;
	}

	public void setActivardireccionNegocioCliente(Boolean activardireccionNegocioCliente) {
		this.activardireccionNegocioCliente= activardireccionNegocioCliente;
	}

	public Border setResaltares_local_propioNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltares_local_propioNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_local_propioNegocioCliente() {
		return this.resaltares_local_propioNegocioCliente;
	}

	public void setResaltares_local_propioNegocioCliente(Border borderResaltar) {
		this.resaltares_local_propioNegocioCliente= borderResaltar;
	}

	public Boolean getMostrares_local_propioNegocioCliente() {
		return this.mostrares_local_propioNegocioCliente;
	}

	public void setMostrares_local_propioNegocioCliente(Boolean mostrares_local_propioNegocioCliente) {
		this.mostrares_local_propioNegocioCliente= mostrares_local_propioNegocioCliente;
	}

	public Boolean getActivares_local_propioNegocioCliente() {
		return this.activares_local_propioNegocioCliente;
	}

	public void setActivares_local_propioNegocioCliente(Boolean activares_local_propioNegocioCliente) {
		this.activares_local_propioNegocioCliente= activares_local_propioNegocioCliente;
	}

	public Border setResaltarnumero_aniosNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltarnumero_aniosNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_aniosNegocioCliente() {
		return this.resaltarnumero_aniosNegocioCliente;
	}

	public void setResaltarnumero_aniosNegocioCliente(Border borderResaltar) {
		this.resaltarnumero_aniosNegocioCliente= borderResaltar;
	}

	public Boolean getMostrarnumero_aniosNegocioCliente() {
		return this.mostrarnumero_aniosNegocioCliente;
	}

	public void setMostrarnumero_aniosNegocioCliente(Boolean mostrarnumero_aniosNegocioCliente) {
		this.mostrarnumero_aniosNegocioCliente= mostrarnumero_aniosNegocioCliente;
	}

	public Boolean getActivarnumero_aniosNegocioCliente() {
		return this.activarnumero_aniosNegocioCliente;
	}

	public void setActivarnumero_aniosNegocioCliente(Boolean activarnumero_aniosNegocioCliente) {
		this.activarnumero_aniosNegocioCliente= activarnumero_aniosNegocioCliente;
	}

	public Border setResaltarnumero_mesesNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltarnumero_mesesNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_mesesNegocioCliente() {
		return this.resaltarnumero_mesesNegocioCliente;
	}

	public void setResaltarnumero_mesesNegocioCliente(Border borderResaltar) {
		this.resaltarnumero_mesesNegocioCliente= borderResaltar;
	}

	public Boolean getMostrarnumero_mesesNegocioCliente() {
		return this.mostrarnumero_mesesNegocioCliente;
	}

	public void setMostrarnumero_mesesNegocioCliente(Boolean mostrarnumero_mesesNegocioCliente) {
		this.mostrarnumero_mesesNegocioCliente= mostrarnumero_mesesNegocioCliente;
	}

	public Boolean getActivarnumero_mesesNegocioCliente() {
		return this.activarnumero_mesesNegocioCliente;
	}

	public void setActivarnumero_mesesNegocioCliente(Boolean activarnumero_mesesNegocioCliente) {
		this.activarnumero_mesesNegocioCliente= activarnumero_mesesNegocioCliente;
	}

	public Border setResaltarid_tipo_ubicacion_negocioNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltarid_tipo_ubicacion_negocioNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_ubicacion_negocioNegocioCliente() {
		return this.resaltarid_tipo_ubicacion_negocioNegocioCliente;
	}

	public void setResaltarid_tipo_ubicacion_negocioNegocioCliente(Border borderResaltar) {
		this.resaltarid_tipo_ubicacion_negocioNegocioCliente= borderResaltar;
	}

	public Boolean getMostrarid_tipo_ubicacion_negocioNegocioCliente() {
		return this.mostrarid_tipo_ubicacion_negocioNegocioCliente;
	}

	public void setMostrarid_tipo_ubicacion_negocioNegocioCliente(Boolean mostrarid_tipo_ubicacion_negocioNegocioCliente) {
		this.mostrarid_tipo_ubicacion_negocioNegocioCliente= mostrarid_tipo_ubicacion_negocioNegocioCliente;
	}

	public Boolean getActivarid_tipo_ubicacion_negocioNegocioCliente() {
		return this.activarid_tipo_ubicacion_negocioNegocioCliente;
	}

	public void setActivarid_tipo_ubicacion_negocioNegocioCliente(Boolean activarid_tipo_ubicacion_negocioNegocioCliente) {
		this.activarid_tipo_ubicacion_negocioNegocioCliente= activarid_tipo_ubicacion_negocioNegocioCliente;
	}

	public Boolean getCargarid_tipo_ubicacion_negocioNegocioCliente() {
		return this.cargarid_tipo_ubicacion_negocioNegocioCliente;
	}

	public void setCargarid_tipo_ubicacion_negocioNegocioCliente(Boolean cargarid_tipo_ubicacion_negocioNegocioCliente) {
		this.cargarid_tipo_ubicacion_negocioNegocioCliente= cargarid_tipo_ubicacion_negocioNegocioCliente;
	}

	public Border setResaltarempleados_fijosNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltarempleados_fijosNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarempleados_fijosNegocioCliente() {
		return this.resaltarempleados_fijosNegocioCliente;
	}

	public void setResaltarempleados_fijosNegocioCliente(Border borderResaltar) {
		this.resaltarempleados_fijosNegocioCliente= borderResaltar;
	}

	public Boolean getMostrarempleados_fijosNegocioCliente() {
		return this.mostrarempleados_fijosNegocioCliente;
	}

	public void setMostrarempleados_fijosNegocioCliente(Boolean mostrarempleados_fijosNegocioCliente) {
		this.mostrarempleados_fijosNegocioCliente= mostrarempleados_fijosNegocioCliente;
	}

	public Boolean getActivarempleados_fijosNegocioCliente() {
		return this.activarempleados_fijosNegocioCliente;
	}

	public void setActivarempleados_fijosNegocioCliente(Boolean activarempleados_fijosNegocioCliente) {
		this.activarempleados_fijosNegocioCliente= activarempleados_fijosNegocioCliente;
	}

	public Border setResaltarempleado_temporalesNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltarempleado_temporalesNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarempleado_temporalesNegocioCliente() {
		return this.resaltarempleado_temporalesNegocioCliente;
	}

	public void setResaltarempleado_temporalesNegocioCliente(Border borderResaltar) {
		this.resaltarempleado_temporalesNegocioCliente= borderResaltar;
	}

	public Boolean getMostrarempleado_temporalesNegocioCliente() {
		return this.mostrarempleado_temporalesNegocioCliente;
	}

	public void setMostrarempleado_temporalesNegocioCliente(Boolean mostrarempleado_temporalesNegocioCliente) {
		this.mostrarempleado_temporalesNegocioCliente= mostrarempleado_temporalesNegocioCliente;
	}

	public Boolean getActivarempleado_temporalesNegocioCliente() {
		return this.activarempleado_temporalesNegocioCliente;
	}

	public void setActivarempleado_temporalesNegocioCliente(Boolean activarempleado_temporalesNegocioCliente) {
		this.activarempleado_temporalesNegocioCliente= activarempleado_temporalesNegocioCliente;
	}

	public Border setResaltarempleados_totalNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltarempleados_totalNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarempleados_totalNegocioCliente() {
		return this.resaltarempleados_totalNegocioCliente;
	}

	public void setResaltarempleados_totalNegocioCliente(Border borderResaltar) {
		this.resaltarempleados_totalNegocioCliente= borderResaltar;
	}

	public Boolean getMostrarempleados_totalNegocioCliente() {
		return this.mostrarempleados_totalNegocioCliente;
	}

	public void setMostrarempleados_totalNegocioCliente(Boolean mostrarempleados_totalNegocioCliente) {
		this.mostrarempleados_totalNegocioCliente= mostrarempleados_totalNegocioCliente;
	}

	public Boolean getActivarempleados_totalNegocioCliente() {
		return this.activarempleados_totalNegocioCliente;
	}

	public void setActivarempleados_totalNegocioCliente(Boolean activarempleados_totalNegocioCliente) {
		this.activarempleados_totalNegocioCliente= activarempleados_totalNegocioCliente;
	}

	public Border setResaltarporcentaje_ventas_contadoNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltarporcentaje_ventas_contadoNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_ventas_contadoNegocioCliente() {
		return this.resaltarporcentaje_ventas_contadoNegocioCliente;
	}

	public void setResaltarporcentaje_ventas_contadoNegocioCliente(Border borderResaltar) {
		this.resaltarporcentaje_ventas_contadoNegocioCliente= borderResaltar;
	}

	public Boolean getMostrarporcentaje_ventas_contadoNegocioCliente() {
		return this.mostrarporcentaje_ventas_contadoNegocioCliente;
	}

	public void setMostrarporcentaje_ventas_contadoNegocioCliente(Boolean mostrarporcentaje_ventas_contadoNegocioCliente) {
		this.mostrarporcentaje_ventas_contadoNegocioCliente= mostrarporcentaje_ventas_contadoNegocioCliente;
	}

	public Boolean getActivarporcentaje_ventas_contadoNegocioCliente() {
		return this.activarporcentaje_ventas_contadoNegocioCliente;
	}

	public void setActivarporcentaje_ventas_contadoNegocioCliente(Boolean activarporcentaje_ventas_contadoNegocioCliente) {
		this.activarporcentaje_ventas_contadoNegocioCliente= activarporcentaje_ventas_contadoNegocioCliente;
	}

	public Border setResaltarporcentaje_ventas_creditoNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltarporcentaje_ventas_creditoNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_ventas_creditoNegocioCliente() {
		return this.resaltarporcentaje_ventas_creditoNegocioCliente;
	}

	public void setResaltarporcentaje_ventas_creditoNegocioCliente(Border borderResaltar) {
		this.resaltarporcentaje_ventas_creditoNegocioCliente= borderResaltar;
	}

	public Boolean getMostrarporcentaje_ventas_creditoNegocioCliente() {
		return this.mostrarporcentaje_ventas_creditoNegocioCliente;
	}

	public void setMostrarporcentaje_ventas_creditoNegocioCliente(Boolean mostrarporcentaje_ventas_creditoNegocioCliente) {
		this.mostrarporcentaje_ventas_creditoNegocioCliente= mostrarporcentaje_ventas_creditoNegocioCliente;
	}

	public Boolean getActivarporcentaje_ventas_creditoNegocioCliente() {
		return this.activarporcentaje_ventas_creditoNegocioCliente;
	}

	public void setActivarporcentaje_ventas_creditoNegocioCliente(Boolean activarporcentaje_ventas_creditoNegocioCliente) {
		this.activarporcentaje_ventas_creditoNegocioCliente= activarporcentaje_ventas_creditoNegocioCliente;
	}

	public Border setResaltarplazo_diasNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltarplazo_diasNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarplazo_diasNegocioCliente() {
		return this.resaltarplazo_diasNegocioCliente;
	}

	public void setResaltarplazo_diasNegocioCliente(Border borderResaltar) {
		this.resaltarplazo_diasNegocioCliente= borderResaltar;
	}

	public Boolean getMostrarplazo_diasNegocioCliente() {
		return this.mostrarplazo_diasNegocioCliente;
	}

	public void setMostrarplazo_diasNegocioCliente(Boolean mostrarplazo_diasNegocioCliente) {
		this.mostrarplazo_diasNegocioCliente= mostrarplazo_diasNegocioCliente;
	}

	public Boolean getActivarplazo_diasNegocioCliente() {
		return this.activarplazo_diasNegocioCliente;
	}

	public void setActivarplazo_diasNegocioCliente(Boolean activarplazo_diasNegocioCliente) {
		this.activarplazo_diasNegocioCliente= activarplazo_diasNegocioCliente;
	}

	public Border setResaltarnumero_clientesNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltarnumero_clientesNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_clientesNegocioCliente() {
		return this.resaltarnumero_clientesNegocioCliente;
	}

	public void setResaltarnumero_clientesNegocioCliente(Border borderResaltar) {
		this.resaltarnumero_clientesNegocioCliente= borderResaltar;
	}

	public Boolean getMostrarnumero_clientesNegocioCliente() {
		return this.mostrarnumero_clientesNegocioCliente;
	}

	public void setMostrarnumero_clientesNegocioCliente(Boolean mostrarnumero_clientesNegocioCliente) {
		this.mostrarnumero_clientesNegocioCliente= mostrarnumero_clientesNegocioCliente;
	}

	public Boolean getActivarnumero_clientesNegocioCliente() {
		return this.activarnumero_clientesNegocioCliente;
	}

	public void setActivarnumero_clientesNegocioCliente(Boolean activarnumero_clientesNegocioCliente) {
		this.activarnumero_clientesNegocioCliente= activarnumero_clientesNegocioCliente;
	}

	public Border setResaltarmonto_maximo_ventas_mensualNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltarmonto_maximo_ventas_mensualNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_maximo_ventas_mensualNegocioCliente() {
		return this.resaltarmonto_maximo_ventas_mensualNegocioCliente;
	}

	public void setResaltarmonto_maximo_ventas_mensualNegocioCliente(Border borderResaltar) {
		this.resaltarmonto_maximo_ventas_mensualNegocioCliente= borderResaltar;
	}

	public Boolean getMostrarmonto_maximo_ventas_mensualNegocioCliente() {
		return this.mostrarmonto_maximo_ventas_mensualNegocioCliente;
	}

	public void setMostrarmonto_maximo_ventas_mensualNegocioCliente(Boolean mostrarmonto_maximo_ventas_mensualNegocioCliente) {
		this.mostrarmonto_maximo_ventas_mensualNegocioCliente= mostrarmonto_maximo_ventas_mensualNegocioCliente;
	}

	public Boolean getActivarmonto_maximo_ventas_mensualNegocioCliente() {
		return this.activarmonto_maximo_ventas_mensualNegocioCliente;
	}

	public void setActivarmonto_maximo_ventas_mensualNegocioCliente(Boolean activarmonto_maximo_ventas_mensualNegocioCliente) {
		this.activarmonto_maximo_ventas_mensualNegocioCliente= activarmonto_maximo_ventas_mensualNegocioCliente;
	}

	public Border setResaltarmonto_minimo_ventas_mensualNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltarmonto_minimo_ventas_mensualNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_minimo_ventas_mensualNegocioCliente() {
		return this.resaltarmonto_minimo_ventas_mensualNegocioCliente;
	}

	public void setResaltarmonto_minimo_ventas_mensualNegocioCliente(Border borderResaltar) {
		this.resaltarmonto_minimo_ventas_mensualNegocioCliente= borderResaltar;
	}

	public Boolean getMostrarmonto_minimo_ventas_mensualNegocioCliente() {
		return this.mostrarmonto_minimo_ventas_mensualNegocioCliente;
	}

	public void setMostrarmonto_minimo_ventas_mensualNegocioCliente(Boolean mostrarmonto_minimo_ventas_mensualNegocioCliente) {
		this.mostrarmonto_minimo_ventas_mensualNegocioCliente= mostrarmonto_minimo_ventas_mensualNegocioCliente;
	}

	public Boolean getActivarmonto_minimo_ventas_mensualNegocioCliente() {
		return this.activarmonto_minimo_ventas_mensualNegocioCliente;
	}

	public void setActivarmonto_minimo_ventas_mensualNegocioCliente(Boolean activarmonto_minimo_ventas_mensualNegocioCliente) {
		this.activarmonto_minimo_ventas_mensualNegocioCliente= activarmonto_minimo_ventas_mensualNegocioCliente;
	}

	public Border setResaltares_enero_altoNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltares_enero_altoNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_enero_altoNegocioCliente() {
		return this.resaltares_enero_altoNegocioCliente;
	}

	public void setResaltares_enero_altoNegocioCliente(Border borderResaltar) {
		this.resaltares_enero_altoNegocioCliente= borderResaltar;
	}

	public Boolean getMostrares_enero_altoNegocioCliente() {
		return this.mostrares_enero_altoNegocioCliente;
	}

	public void setMostrares_enero_altoNegocioCliente(Boolean mostrares_enero_altoNegocioCliente) {
		this.mostrares_enero_altoNegocioCliente= mostrares_enero_altoNegocioCliente;
	}

	public Boolean getActivares_enero_altoNegocioCliente() {
		return this.activares_enero_altoNegocioCliente;
	}

	public void setActivares_enero_altoNegocioCliente(Boolean activares_enero_altoNegocioCliente) {
		this.activares_enero_altoNegocioCliente= activares_enero_altoNegocioCliente;
	}

	public Border setResaltares_febrero_altoNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltares_febrero_altoNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_febrero_altoNegocioCliente() {
		return this.resaltares_febrero_altoNegocioCliente;
	}

	public void setResaltares_febrero_altoNegocioCliente(Border borderResaltar) {
		this.resaltares_febrero_altoNegocioCliente= borderResaltar;
	}

	public Boolean getMostrares_febrero_altoNegocioCliente() {
		return this.mostrares_febrero_altoNegocioCliente;
	}

	public void setMostrares_febrero_altoNegocioCliente(Boolean mostrares_febrero_altoNegocioCliente) {
		this.mostrares_febrero_altoNegocioCliente= mostrares_febrero_altoNegocioCliente;
	}

	public Boolean getActivares_febrero_altoNegocioCliente() {
		return this.activares_febrero_altoNegocioCliente;
	}

	public void setActivares_febrero_altoNegocioCliente(Boolean activares_febrero_altoNegocioCliente) {
		this.activares_febrero_altoNegocioCliente= activares_febrero_altoNegocioCliente;
	}

	public Border setResaltares_marzo_altoNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltares_marzo_altoNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_marzo_altoNegocioCliente() {
		return this.resaltares_marzo_altoNegocioCliente;
	}

	public void setResaltares_marzo_altoNegocioCliente(Border borderResaltar) {
		this.resaltares_marzo_altoNegocioCliente= borderResaltar;
	}

	public Boolean getMostrares_marzo_altoNegocioCliente() {
		return this.mostrares_marzo_altoNegocioCliente;
	}

	public void setMostrares_marzo_altoNegocioCliente(Boolean mostrares_marzo_altoNegocioCliente) {
		this.mostrares_marzo_altoNegocioCliente= mostrares_marzo_altoNegocioCliente;
	}

	public Boolean getActivares_marzo_altoNegocioCliente() {
		return this.activares_marzo_altoNegocioCliente;
	}

	public void setActivares_marzo_altoNegocioCliente(Boolean activares_marzo_altoNegocioCliente) {
		this.activares_marzo_altoNegocioCliente= activares_marzo_altoNegocioCliente;
	}

	public Border setResaltares_abril_altoNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltares_abril_altoNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_abril_altoNegocioCliente() {
		return this.resaltares_abril_altoNegocioCliente;
	}

	public void setResaltares_abril_altoNegocioCliente(Border borderResaltar) {
		this.resaltares_abril_altoNegocioCliente= borderResaltar;
	}

	public Boolean getMostrares_abril_altoNegocioCliente() {
		return this.mostrares_abril_altoNegocioCliente;
	}

	public void setMostrares_abril_altoNegocioCliente(Boolean mostrares_abril_altoNegocioCliente) {
		this.mostrares_abril_altoNegocioCliente= mostrares_abril_altoNegocioCliente;
	}

	public Boolean getActivares_abril_altoNegocioCliente() {
		return this.activares_abril_altoNegocioCliente;
	}

	public void setActivares_abril_altoNegocioCliente(Boolean activares_abril_altoNegocioCliente) {
		this.activares_abril_altoNegocioCliente= activares_abril_altoNegocioCliente;
	}

	public Border setResaltares_mayo_altoNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltares_mayo_altoNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_mayo_altoNegocioCliente() {
		return this.resaltares_mayo_altoNegocioCliente;
	}

	public void setResaltares_mayo_altoNegocioCliente(Border borderResaltar) {
		this.resaltares_mayo_altoNegocioCliente= borderResaltar;
	}

	public Boolean getMostrares_mayo_altoNegocioCliente() {
		return this.mostrares_mayo_altoNegocioCliente;
	}

	public void setMostrares_mayo_altoNegocioCliente(Boolean mostrares_mayo_altoNegocioCliente) {
		this.mostrares_mayo_altoNegocioCliente= mostrares_mayo_altoNegocioCliente;
	}

	public Boolean getActivares_mayo_altoNegocioCliente() {
		return this.activares_mayo_altoNegocioCliente;
	}

	public void setActivares_mayo_altoNegocioCliente(Boolean activares_mayo_altoNegocioCliente) {
		this.activares_mayo_altoNegocioCliente= activares_mayo_altoNegocioCliente;
	}

	public Border setResaltares_junio_altoNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltares_junio_altoNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_junio_altoNegocioCliente() {
		return this.resaltares_junio_altoNegocioCliente;
	}

	public void setResaltares_junio_altoNegocioCliente(Border borderResaltar) {
		this.resaltares_junio_altoNegocioCliente= borderResaltar;
	}

	public Boolean getMostrares_junio_altoNegocioCliente() {
		return this.mostrares_junio_altoNegocioCliente;
	}

	public void setMostrares_junio_altoNegocioCliente(Boolean mostrares_junio_altoNegocioCliente) {
		this.mostrares_junio_altoNegocioCliente= mostrares_junio_altoNegocioCliente;
	}

	public Boolean getActivares_junio_altoNegocioCliente() {
		return this.activares_junio_altoNegocioCliente;
	}

	public void setActivares_junio_altoNegocioCliente(Boolean activares_junio_altoNegocioCliente) {
		this.activares_junio_altoNegocioCliente= activares_junio_altoNegocioCliente;
	}

	public Border setResaltares_julio_altoNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltares_julio_altoNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_julio_altoNegocioCliente() {
		return this.resaltares_julio_altoNegocioCliente;
	}

	public void setResaltares_julio_altoNegocioCliente(Border borderResaltar) {
		this.resaltares_julio_altoNegocioCliente= borderResaltar;
	}

	public Boolean getMostrares_julio_altoNegocioCliente() {
		return this.mostrares_julio_altoNegocioCliente;
	}

	public void setMostrares_julio_altoNegocioCliente(Boolean mostrares_julio_altoNegocioCliente) {
		this.mostrares_julio_altoNegocioCliente= mostrares_julio_altoNegocioCliente;
	}

	public Boolean getActivares_julio_altoNegocioCliente() {
		return this.activares_julio_altoNegocioCliente;
	}

	public void setActivares_julio_altoNegocioCliente(Boolean activares_julio_altoNegocioCliente) {
		this.activares_julio_altoNegocioCliente= activares_julio_altoNegocioCliente;
	}

	public Border setResaltares_agosto_altoNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltares_agosto_altoNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_agosto_altoNegocioCliente() {
		return this.resaltares_agosto_altoNegocioCliente;
	}

	public void setResaltares_agosto_altoNegocioCliente(Border borderResaltar) {
		this.resaltares_agosto_altoNegocioCliente= borderResaltar;
	}

	public Boolean getMostrares_agosto_altoNegocioCliente() {
		return this.mostrares_agosto_altoNegocioCliente;
	}

	public void setMostrares_agosto_altoNegocioCliente(Boolean mostrares_agosto_altoNegocioCliente) {
		this.mostrares_agosto_altoNegocioCliente= mostrares_agosto_altoNegocioCliente;
	}

	public Boolean getActivares_agosto_altoNegocioCliente() {
		return this.activares_agosto_altoNegocioCliente;
	}

	public void setActivares_agosto_altoNegocioCliente(Boolean activares_agosto_altoNegocioCliente) {
		this.activares_agosto_altoNegocioCliente= activares_agosto_altoNegocioCliente;
	}

	public Border setResaltares_septiembre_altoNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltares_septiembre_altoNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_septiembre_altoNegocioCliente() {
		return this.resaltares_septiembre_altoNegocioCliente;
	}

	public void setResaltares_septiembre_altoNegocioCliente(Border borderResaltar) {
		this.resaltares_septiembre_altoNegocioCliente= borderResaltar;
	}

	public Boolean getMostrares_septiembre_altoNegocioCliente() {
		return this.mostrares_septiembre_altoNegocioCliente;
	}

	public void setMostrares_septiembre_altoNegocioCliente(Boolean mostrares_septiembre_altoNegocioCliente) {
		this.mostrares_septiembre_altoNegocioCliente= mostrares_septiembre_altoNegocioCliente;
	}

	public Boolean getActivares_septiembre_altoNegocioCliente() {
		return this.activares_septiembre_altoNegocioCliente;
	}

	public void setActivares_septiembre_altoNegocioCliente(Boolean activares_septiembre_altoNegocioCliente) {
		this.activares_septiembre_altoNegocioCliente= activares_septiembre_altoNegocioCliente;
	}

	public Border setResaltares_octubre_altoNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltares_octubre_altoNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_octubre_altoNegocioCliente() {
		return this.resaltares_octubre_altoNegocioCliente;
	}

	public void setResaltares_octubre_altoNegocioCliente(Border borderResaltar) {
		this.resaltares_octubre_altoNegocioCliente= borderResaltar;
	}

	public Boolean getMostrares_octubre_altoNegocioCliente() {
		return this.mostrares_octubre_altoNegocioCliente;
	}

	public void setMostrares_octubre_altoNegocioCliente(Boolean mostrares_octubre_altoNegocioCliente) {
		this.mostrares_octubre_altoNegocioCliente= mostrares_octubre_altoNegocioCliente;
	}

	public Boolean getActivares_octubre_altoNegocioCliente() {
		return this.activares_octubre_altoNegocioCliente;
	}

	public void setActivares_octubre_altoNegocioCliente(Boolean activares_octubre_altoNegocioCliente) {
		this.activares_octubre_altoNegocioCliente= activares_octubre_altoNegocioCliente;
	}

	public Border setResaltares_noviembre_altoNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltares_noviembre_altoNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_noviembre_altoNegocioCliente() {
		return this.resaltares_noviembre_altoNegocioCliente;
	}

	public void setResaltares_noviembre_altoNegocioCliente(Border borderResaltar) {
		this.resaltares_noviembre_altoNegocioCliente= borderResaltar;
	}

	public Boolean getMostrares_noviembre_altoNegocioCliente() {
		return this.mostrares_noviembre_altoNegocioCliente;
	}

	public void setMostrares_noviembre_altoNegocioCliente(Boolean mostrares_noviembre_altoNegocioCliente) {
		this.mostrares_noviembre_altoNegocioCliente= mostrares_noviembre_altoNegocioCliente;
	}

	public Boolean getActivares_noviembre_altoNegocioCliente() {
		return this.activares_noviembre_altoNegocioCliente;
	}

	public void setActivares_noviembre_altoNegocioCliente(Boolean activares_noviembre_altoNegocioCliente) {
		this.activares_noviembre_altoNegocioCliente= activares_noviembre_altoNegocioCliente;
	}

	public Border setResaltares_diciembre_altoNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltares_diciembre_altoNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_diciembre_altoNegocioCliente() {
		return this.resaltares_diciembre_altoNegocioCliente;
	}

	public void setResaltares_diciembre_altoNegocioCliente(Border borderResaltar) {
		this.resaltares_diciembre_altoNegocioCliente= borderResaltar;
	}

	public Boolean getMostrares_diciembre_altoNegocioCliente() {
		return this.mostrares_diciembre_altoNegocioCliente;
	}

	public void setMostrares_diciembre_altoNegocioCliente(Boolean mostrares_diciembre_altoNegocioCliente) {
		this.mostrares_diciembre_altoNegocioCliente= mostrares_diciembre_altoNegocioCliente;
	}

	public Boolean getActivares_diciembre_altoNegocioCliente() {
		return this.activares_diciembre_altoNegocioCliente;
	}

	public void setActivares_diciembre_altoNegocioCliente(Boolean activares_diciembre_altoNegocioCliente) {
		this.activares_diciembre_altoNegocioCliente= activares_diciembre_altoNegocioCliente;
	}

	public Border setResaltares_enero_bajoNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltares_enero_bajoNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_enero_bajoNegocioCliente() {
		return this.resaltares_enero_bajoNegocioCliente;
	}

	public void setResaltares_enero_bajoNegocioCliente(Border borderResaltar) {
		this.resaltares_enero_bajoNegocioCliente= borderResaltar;
	}

	public Boolean getMostrares_enero_bajoNegocioCliente() {
		return this.mostrares_enero_bajoNegocioCliente;
	}

	public void setMostrares_enero_bajoNegocioCliente(Boolean mostrares_enero_bajoNegocioCliente) {
		this.mostrares_enero_bajoNegocioCliente= mostrares_enero_bajoNegocioCliente;
	}

	public Boolean getActivares_enero_bajoNegocioCliente() {
		return this.activares_enero_bajoNegocioCliente;
	}

	public void setActivares_enero_bajoNegocioCliente(Boolean activares_enero_bajoNegocioCliente) {
		this.activares_enero_bajoNegocioCliente= activares_enero_bajoNegocioCliente;
	}

	public Border setResaltares_febrero_bajoNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltares_febrero_bajoNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_febrero_bajoNegocioCliente() {
		return this.resaltares_febrero_bajoNegocioCliente;
	}

	public void setResaltares_febrero_bajoNegocioCliente(Border borderResaltar) {
		this.resaltares_febrero_bajoNegocioCliente= borderResaltar;
	}

	public Boolean getMostrares_febrero_bajoNegocioCliente() {
		return this.mostrares_febrero_bajoNegocioCliente;
	}

	public void setMostrares_febrero_bajoNegocioCliente(Boolean mostrares_febrero_bajoNegocioCliente) {
		this.mostrares_febrero_bajoNegocioCliente= mostrares_febrero_bajoNegocioCliente;
	}

	public Boolean getActivares_febrero_bajoNegocioCliente() {
		return this.activares_febrero_bajoNegocioCliente;
	}

	public void setActivares_febrero_bajoNegocioCliente(Boolean activares_febrero_bajoNegocioCliente) {
		this.activares_febrero_bajoNegocioCliente= activares_febrero_bajoNegocioCliente;
	}

	public Border setResaltares_marzo_bajoNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltares_marzo_bajoNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_marzo_bajoNegocioCliente() {
		return this.resaltares_marzo_bajoNegocioCliente;
	}

	public void setResaltares_marzo_bajoNegocioCliente(Border borderResaltar) {
		this.resaltares_marzo_bajoNegocioCliente= borderResaltar;
	}

	public Boolean getMostrares_marzo_bajoNegocioCliente() {
		return this.mostrares_marzo_bajoNegocioCliente;
	}

	public void setMostrares_marzo_bajoNegocioCliente(Boolean mostrares_marzo_bajoNegocioCliente) {
		this.mostrares_marzo_bajoNegocioCliente= mostrares_marzo_bajoNegocioCliente;
	}

	public Boolean getActivares_marzo_bajoNegocioCliente() {
		return this.activares_marzo_bajoNegocioCliente;
	}

	public void setActivares_marzo_bajoNegocioCliente(Boolean activares_marzo_bajoNegocioCliente) {
		this.activares_marzo_bajoNegocioCliente= activares_marzo_bajoNegocioCliente;
	}

	public Border setResaltares_abril_bajoNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltares_abril_bajoNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_abril_bajoNegocioCliente() {
		return this.resaltares_abril_bajoNegocioCliente;
	}

	public void setResaltares_abril_bajoNegocioCliente(Border borderResaltar) {
		this.resaltares_abril_bajoNegocioCliente= borderResaltar;
	}

	public Boolean getMostrares_abril_bajoNegocioCliente() {
		return this.mostrares_abril_bajoNegocioCliente;
	}

	public void setMostrares_abril_bajoNegocioCliente(Boolean mostrares_abril_bajoNegocioCliente) {
		this.mostrares_abril_bajoNegocioCliente= mostrares_abril_bajoNegocioCliente;
	}

	public Boolean getActivares_abril_bajoNegocioCliente() {
		return this.activares_abril_bajoNegocioCliente;
	}

	public void setActivares_abril_bajoNegocioCliente(Boolean activares_abril_bajoNegocioCliente) {
		this.activares_abril_bajoNegocioCliente= activares_abril_bajoNegocioCliente;
	}

	public Border setResaltares_mayo_bajoNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltares_mayo_bajoNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_mayo_bajoNegocioCliente() {
		return this.resaltares_mayo_bajoNegocioCliente;
	}

	public void setResaltares_mayo_bajoNegocioCliente(Border borderResaltar) {
		this.resaltares_mayo_bajoNegocioCliente= borderResaltar;
	}

	public Boolean getMostrares_mayo_bajoNegocioCliente() {
		return this.mostrares_mayo_bajoNegocioCliente;
	}

	public void setMostrares_mayo_bajoNegocioCliente(Boolean mostrares_mayo_bajoNegocioCliente) {
		this.mostrares_mayo_bajoNegocioCliente= mostrares_mayo_bajoNegocioCliente;
	}

	public Boolean getActivares_mayo_bajoNegocioCliente() {
		return this.activares_mayo_bajoNegocioCliente;
	}

	public void setActivares_mayo_bajoNegocioCliente(Boolean activares_mayo_bajoNegocioCliente) {
		this.activares_mayo_bajoNegocioCliente= activares_mayo_bajoNegocioCliente;
	}

	public Border setResaltares_junio_bajoNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltares_junio_bajoNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_junio_bajoNegocioCliente() {
		return this.resaltares_junio_bajoNegocioCliente;
	}

	public void setResaltares_junio_bajoNegocioCliente(Border borderResaltar) {
		this.resaltares_junio_bajoNegocioCliente= borderResaltar;
	}

	public Boolean getMostrares_junio_bajoNegocioCliente() {
		return this.mostrares_junio_bajoNegocioCliente;
	}

	public void setMostrares_junio_bajoNegocioCliente(Boolean mostrares_junio_bajoNegocioCliente) {
		this.mostrares_junio_bajoNegocioCliente= mostrares_junio_bajoNegocioCliente;
	}

	public Boolean getActivares_junio_bajoNegocioCliente() {
		return this.activares_junio_bajoNegocioCliente;
	}

	public void setActivares_junio_bajoNegocioCliente(Boolean activares_junio_bajoNegocioCliente) {
		this.activares_junio_bajoNegocioCliente= activares_junio_bajoNegocioCliente;
	}

	public Border setResaltares_julio_bajoNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltares_julio_bajoNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_julio_bajoNegocioCliente() {
		return this.resaltares_julio_bajoNegocioCliente;
	}

	public void setResaltares_julio_bajoNegocioCliente(Border borderResaltar) {
		this.resaltares_julio_bajoNegocioCliente= borderResaltar;
	}

	public Boolean getMostrares_julio_bajoNegocioCliente() {
		return this.mostrares_julio_bajoNegocioCliente;
	}

	public void setMostrares_julio_bajoNegocioCliente(Boolean mostrares_julio_bajoNegocioCliente) {
		this.mostrares_julio_bajoNegocioCliente= mostrares_julio_bajoNegocioCliente;
	}

	public Boolean getActivares_julio_bajoNegocioCliente() {
		return this.activares_julio_bajoNegocioCliente;
	}

	public void setActivares_julio_bajoNegocioCliente(Boolean activares_julio_bajoNegocioCliente) {
		this.activares_julio_bajoNegocioCliente= activares_julio_bajoNegocioCliente;
	}

	public Border setResaltares_agosto_bajoNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltares_agosto_bajoNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_agosto_bajoNegocioCliente() {
		return this.resaltares_agosto_bajoNegocioCliente;
	}

	public void setResaltares_agosto_bajoNegocioCliente(Border borderResaltar) {
		this.resaltares_agosto_bajoNegocioCliente= borderResaltar;
	}

	public Boolean getMostrares_agosto_bajoNegocioCliente() {
		return this.mostrares_agosto_bajoNegocioCliente;
	}

	public void setMostrares_agosto_bajoNegocioCliente(Boolean mostrares_agosto_bajoNegocioCliente) {
		this.mostrares_agosto_bajoNegocioCliente= mostrares_agosto_bajoNegocioCliente;
	}

	public Boolean getActivares_agosto_bajoNegocioCliente() {
		return this.activares_agosto_bajoNegocioCliente;
	}

	public void setActivares_agosto_bajoNegocioCliente(Boolean activares_agosto_bajoNegocioCliente) {
		this.activares_agosto_bajoNegocioCliente= activares_agosto_bajoNegocioCliente;
	}

	public Border setResaltares_septiembre_bajoNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltares_septiembre_bajoNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_septiembre_bajoNegocioCliente() {
		return this.resaltares_septiembre_bajoNegocioCliente;
	}

	public void setResaltares_septiembre_bajoNegocioCliente(Border borderResaltar) {
		this.resaltares_septiembre_bajoNegocioCliente= borderResaltar;
	}

	public Boolean getMostrares_septiembre_bajoNegocioCliente() {
		return this.mostrares_septiembre_bajoNegocioCliente;
	}

	public void setMostrares_septiembre_bajoNegocioCliente(Boolean mostrares_septiembre_bajoNegocioCliente) {
		this.mostrares_septiembre_bajoNegocioCliente= mostrares_septiembre_bajoNegocioCliente;
	}

	public Boolean getActivares_septiembre_bajoNegocioCliente() {
		return this.activares_septiembre_bajoNegocioCliente;
	}

	public void setActivares_septiembre_bajoNegocioCliente(Boolean activares_septiembre_bajoNegocioCliente) {
		this.activares_septiembre_bajoNegocioCliente= activares_septiembre_bajoNegocioCliente;
	}

	public Border setResaltares_octubre_bajoNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltares_octubre_bajoNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_octubre_bajoNegocioCliente() {
		return this.resaltares_octubre_bajoNegocioCliente;
	}

	public void setResaltares_octubre_bajoNegocioCliente(Border borderResaltar) {
		this.resaltares_octubre_bajoNegocioCliente= borderResaltar;
	}

	public Boolean getMostrares_octubre_bajoNegocioCliente() {
		return this.mostrares_octubre_bajoNegocioCliente;
	}

	public void setMostrares_octubre_bajoNegocioCliente(Boolean mostrares_octubre_bajoNegocioCliente) {
		this.mostrares_octubre_bajoNegocioCliente= mostrares_octubre_bajoNegocioCliente;
	}

	public Boolean getActivares_octubre_bajoNegocioCliente() {
		return this.activares_octubre_bajoNegocioCliente;
	}

	public void setActivares_octubre_bajoNegocioCliente(Boolean activares_octubre_bajoNegocioCliente) {
		this.activares_octubre_bajoNegocioCliente= activares_octubre_bajoNegocioCliente;
	}

	public Border setResaltares_noviembre_bajoNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltares_noviembre_bajoNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_noviembre_bajoNegocioCliente() {
		return this.resaltares_noviembre_bajoNegocioCliente;
	}

	public void setResaltares_noviembre_bajoNegocioCliente(Border borderResaltar) {
		this.resaltares_noviembre_bajoNegocioCliente= borderResaltar;
	}

	public Boolean getMostrares_noviembre_bajoNegocioCliente() {
		return this.mostrares_noviembre_bajoNegocioCliente;
	}

	public void setMostrares_noviembre_bajoNegocioCliente(Boolean mostrares_noviembre_bajoNegocioCliente) {
		this.mostrares_noviembre_bajoNegocioCliente= mostrares_noviembre_bajoNegocioCliente;
	}

	public Boolean getActivares_noviembre_bajoNegocioCliente() {
		return this.activares_noviembre_bajoNegocioCliente;
	}

	public void setActivares_noviembre_bajoNegocioCliente(Boolean activares_noviembre_bajoNegocioCliente) {
		this.activares_noviembre_bajoNegocioCliente= activares_noviembre_bajoNegocioCliente;
	}

	public Border setResaltares_diciembre_bajoNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltares_diciembre_bajoNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_diciembre_bajoNegocioCliente() {
		return this.resaltares_diciembre_bajoNegocioCliente;
	}

	public void setResaltares_diciembre_bajoNegocioCliente(Border borderResaltar) {
		this.resaltares_diciembre_bajoNegocioCliente= borderResaltar;
	}

	public Boolean getMostrares_diciembre_bajoNegocioCliente() {
		return this.mostrares_diciembre_bajoNegocioCliente;
	}

	public void setMostrares_diciembre_bajoNegocioCliente(Boolean mostrares_diciembre_bajoNegocioCliente) {
		this.mostrares_diciembre_bajoNegocioCliente= mostrares_diciembre_bajoNegocioCliente;
	}

	public Boolean getActivares_diciembre_bajoNegocioCliente() {
		return this.activares_diciembre_bajoNegocioCliente;
	}

	public void setActivares_diciembre_bajoNegocioCliente(Boolean activares_diciembre_bajoNegocioCliente) {
		this.activares_diciembre_bajoNegocioCliente= activares_diciembre_bajoNegocioCliente;
	}

	public Border setResaltardescripcionNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//negocioclienteBeanSwingJInternalFrame.jTtoolBarNegocioCliente.setBorder(borderResaltar);
		
		this.resaltardescripcionNegocioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionNegocioCliente() {
		return this.resaltardescripcionNegocioCliente;
	}

	public void setResaltardescripcionNegocioCliente(Border borderResaltar) {
		this.resaltardescripcionNegocioCliente= borderResaltar;
	}

	public Boolean getMostrardescripcionNegocioCliente() {
		return this.mostrardescripcionNegocioCliente;
	}

	public void setMostrardescripcionNegocioCliente(Boolean mostrardescripcionNegocioCliente) {
		this.mostrardescripcionNegocioCliente= mostrardescripcionNegocioCliente;
	}

	public Boolean getActivardescripcionNegocioCliente() {
		return this.activardescripcionNegocioCliente;
	}

	public void setActivardescripcionNegocioCliente(Boolean activardescripcionNegocioCliente) {
		this.activardescripcionNegocioCliente= activardescripcionNegocioCliente;
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
		
		
		this.setMostraridNegocioCliente(esInicial);
		this.setMostrarid_empresaNegocioCliente(esInicial);
		this.setMostrarid_clienteNegocioCliente(esInicial);
		this.setMostrarnombre_quien_se_facturaNegocioCliente(esInicial);
		this.setMostrarfaxNegocioCliente(esInicial);
		this.setMostrarrucNegocioCliente(esInicial);
		this.setMostrartelefonoNegocioCliente(esInicial);
		this.setMostrarnombre_localNegocioCliente(esInicial);
		this.setMostrare_mailNegocioCliente(esInicial);
		this.setMostrardireccionNegocioCliente(esInicial);
		this.setMostrares_local_propioNegocioCliente(esInicial);
		this.setMostrarnumero_aniosNegocioCliente(esInicial);
		this.setMostrarnumero_mesesNegocioCliente(esInicial);
		this.setMostrarid_tipo_ubicacion_negocioNegocioCliente(esInicial);
		this.setMostrarempleados_fijosNegocioCliente(esInicial);
		this.setMostrarempleado_temporalesNegocioCliente(esInicial);
		this.setMostrarempleados_totalNegocioCliente(esInicial);
		this.setMostrarporcentaje_ventas_contadoNegocioCliente(esInicial);
		this.setMostrarporcentaje_ventas_creditoNegocioCliente(esInicial);
		this.setMostrarplazo_diasNegocioCliente(esInicial);
		this.setMostrarnumero_clientesNegocioCliente(esInicial);
		this.setMostrarmonto_maximo_ventas_mensualNegocioCliente(esInicial);
		this.setMostrarmonto_minimo_ventas_mensualNegocioCliente(esInicial);
		this.setMostrares_enero_altoNegocioCliente(esInicial);
		this.setMostrares_febrero_altoNegocioCliente(esInicial);
		this.setMostrares_marzo_altoNegocioCliente(esInicial);
		this.setMostrares_abril_altoNegocioCliente(esInicial);
		this.setMostrares_mayo_altoNegocioCliente(esInicial);
		this.setMostrares_junio_altoNegocioCliente(esInicial);
		this.setMostrares_julio_altoNegocioCliente(esInicial);
		this.setMostrares_agosto_altoNegocioCliente(esInicial);
		this.setMostrares_septiembre_altoNegocioCliente(esInicial);
		this.setMostrares_octubre_altoNegocioCliente(esInicial);
		this.setMostrares_noviembre_altoNegocioCliente(esInicial);
		this.setMostrares_diciembre_altoNegocioCliente(esInicial);
		this.setMostrares_enero_bajoNegocioCliente(esInicial);
		this.setMostrares_febrero_bajoNegocioCliente(esInicial);
		this.setMostrares_marzo_bajoNegocioCliente(esInicial);
		this.setMostrares_abril_bajoNegocioCliente(esInicial);
		this.setMostrares_mayo_bajoNegocioCliente(esInicial);
		this.setMostrares_junio_bajoNegocioCliente(esInicial);
		this.setMostrares_julio_bajoNegocioCliente(esInicial);
		this.setMostrares_agosto_bajoNegocioCliente(esInicial);
		this.setMostrares_septiembre_bajoNegocioCliente(esInicial);
		this.setMostrares_octubre_bajoNegocioCliente(esInicial);
		this.setMostrares_noviembre_bajoNegocioCliente(esInicial);
		this.setMostrares_diciembre_bajoNegocioCliente(esInicial);
		this.setMostrardescripcionNegocioCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ID)) {
				this.setMostraridNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.NOMBREQUIENSEFACTURA)) {
				this.setMostrarnombre_quien_se_facturaNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.FAX)) {
				this.setMostrarfaxNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.RUC)) {
				this.setMostrarrucNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.NOMBRELOCAL)) {
				this.setMostrarnombre_localNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.EMAIL)) {
				this.setMostrare_mailNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESLOCALPROPIO)) {
				this.setMostrares_local_propioNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.NUMEROANIOS)) {
				this.setMostrarnumero_aniosNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.NUMEROMESES)) {
				this.setMostrarnumero_mesesNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.IDTIPOUBICACIONNEGOCIO)) {
				this.setMostrarid_tipo_ubicacion_negocioNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.EMPLEADOSFIJOS)) {
				this.setMostrarempleados_fijosNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.EMPLEADOTEMPORALES)) {
				this.setMostrarempleado_temporalesNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.EMPLEADOSTOTAL)) {
				this.setMostrarempleados_totalNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.PORCENTAJEVENTASCONTADO)) {
				this.setMostrarporcentaje_ventas_contadoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.PORCENTAJEVENTASCREDITO)) {
				this.setMostrarporcentaje_ventas_creditoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.PLAZODIAS)) {
				this.setMostrarplazo_diasNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.NUMEROCLIENTES)) {
				this.setMostrarnumero_clientesNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.MONTOMAXIMOVENTASMENSUAL)) {
				this.setMostrarmonto_maximo_ventas_mensualNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.MONTOMINIMOVENTASMENSUAL)) {
				this.setMostrarmonto_minimo_ventas_mensualNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESENEROALTO)) {
				this.setMostrares_enero_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESFEBREROALTO)) {
				this.setMostrares_febrero_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESMARZOALTO)) {
				this.setMostrares_marzo_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESABRILALTO)) {
				this.setMostrares_abril_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESMAYOALTO)) {
				this.setMostrares_mayo_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESJUNIOALTO)) {
				this.setMostrares_junio_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESJULIOALTO)) {
				this.setMostrares_julio_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESAGOSTOALTO)) {
				this.setMostrares_agosto_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESSEPTIEMBREALTO)) {
				this.setMostrares_septiembre_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESOCTUBREALTO)) {
				this.setMostrares_octubre_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESNOVIEMBREALTO)) {
				this.setMostrares_noviembre_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESDICIEMBREALTO)) {
				this.setMostrares_diciembre_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESENEROBAJO)) {
				this.setMostrares_enero_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESFEBREROBAJO)) {
				this.setMostrares_febrero_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESMARZOBAJO)) {
				this.setMostrares_marzo_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESABRILBAJO)) {
				this.setMostrares_abril_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESMAYOBAJO)) {
				this.setMostrares_mayo_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESJUNIOBAJO)) {
				this.setMostrares_junio_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESJULIOBAJO)) {
				this.setMostrares_julio_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESAGOSTOBAJO)) {
				this.setMostrares_agosto_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESSEPTIEMBREBAJO)) {
				this.setMostrares_septiembre_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESOCTUBREBAJO)) {
				this.setMostrares_octubre_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESNOVIEMBREBAJO)) {
				this.setMostrares_noviembre_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESDICIEMBREBAJO)) {
				this.setMostrares_diciembre_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionNegocioCliente(esAsigna);
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
		
		
		this.setActivaridNegocioCliente(esInicial);
		this.setActivarid_empresaNegocioCliente(esInicial);
		this.setActivarid_clienteNegocioCliente(esInicial);
		this.setActivarnombre_quien_se_facturaNegocioCliente(esInicial);
		this.setActivarfaxNegocioCliente(esInicial);
		this.setActivarrucNegocioCliente(esInicial);
		this.setActivartelefonoNegocioCliente(esInicial);
		this.setActivarnombre_localNegocioCliente(esInicial);
		this.setActivare_mailNegocioCliente(esInicial);
		this.setActivardireccionNegocioCliente(esInicial);
		this.setActivares_local_propioNegocioCliente(esInicial);
		this.setActivarnumero_aniosNegocioCliente(esInicial);
		this.setActivarnumero_mesesNegocioCliente(esInicial);
		this.setActivarid_tipo_ubicacion_negocioNegocioCliente(esInicial);
		this.setActivarempleados_fijosNegocioCliente(esInicial);
		this.setActivarempleado_temporalesNegocioCliente(esInicial);
		this.setActivarempleados_totalNegocioCliente(esInicial);
		this.setActivarporcentaje_ventas_contadoNegocioCliente(esInicial);
		this.setActivarporcentaje_ventas_creditoNegocioCliente(esInicial);
		this.setActivarplazo_diasNegocioCliente(esInicial);
		this.setActivarnumero_clientesNegocioCliente(esInicial);
		this.setActivarmonto_maximo_ventas_mensualNegocioCliente(esInicial);
		this.setActivarmonto_minimo_ventas_mensualNegocioCliente(esInicial);
		this.setActivares_enero_altoNegocioCliente(esInicial);
		this.setActivares_febrero_altoNegocioCliente(esInicial);
		this.setActivares_marzo_altoNegocioCliente(esInicial);
		this.setActivares_abril_altoNegocioCliente(esInicial);
		this.setActivares_mayo_altoNegocioCliente(esInicial);
		this.setActivares_junio_altoNegocioCliente(esInicial);
		this.setActivares_julio_altoNegocioCliente(esInicial);
		this.setActivares_agosto_altoNegocioCliente(esInicial);
		this.setActivares_septiembre_altoNegocioCliente(esInicial);
		this.setActivares_octubre_altoNegocioCliente(esInicial);
		this.setActivares_noviembre_altoNegocioCliente(esInicial);
		this.setActivares_diciembre_altoNegocioCliente(esInicial);
		this.setActivares_enero_bajoNegocioCliente(esInicial);
		this.setActivares_febrero_bajoNegocioCliente(esInicial);
		this.setActivares_marzo_bajoNegocioCliente(esInicial);
		this.setActivares_abril_bajoNegocioCliente(esInicial);
		this.setActivares_mayo_bajoNegocioCliente(esInicial);
		this.setActivares_junio_bajoNegocioCliente(esInicial);
		this.setActivares_julio_bajoNegocioCliente(esInicial);
		this.setActivares_agosto_bajoNegocioCliente(esInicial);
		this.setActivares_septiembre_bajoNegocioCliente(esInicial);
		this.setActivares_octubre_bajoNegocioCliente(esInicial);
		this.setActivares_noviembre_bajoNegocioCliente(esInicial);
		this.setActivares_diciembre_bajoNegocioCliente(esInicial);
		this.setActivardescripcionNegocioCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ID)) {
				this.setActivaridNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.NOMBREQUIENSEFACTURA)) {
				this.setActivarnombre_quien_se_facturaNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.FAX)) {
				this.setActivarfaxNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.RUC)) {
				this.setActivarrucNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.NOMBRELOCAL)) {
				this.setActivarnombre_localNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.EMAIL)) {
				this.setActivare_mailNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.DIRECCION)) {
				this.setActivardireccionNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESLOCALPROPIO)) {
				this.setActivares_local_propioNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.NUMEROANIOS)) {
				this.setActivarnumero_aniosNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.NUMEROMESES)) {
				this.setActivarnumero_mesesNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.IDTIPOUBICACIONNEGOCIO)) {
				this.setActivarid_tipo_ubicacion_negocioNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.EMPLEADOSFIJOS)) {
				this.setActivarempleados_fijosNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.EMPLEADOTEMPORALES)) {
				this.setActivarempleado_temporalesNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.EMPLEADOSTOTAL)) {
				this.setActivarempleados_totalNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.PORCENTAJEVENTASCONTADO)) {
				this.setActivarporcentaje_ventas_contadoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.PORCENTAJEVENTASCREDITO)) {
				this.setActivarporcentaje_ventas_creditoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.PLAZODIAS)) {
				this.setActivarplazo_diasNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.NUMEROCLIENTES)) {
				this.setActivarnumero_clientesNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.MONTOMAXIMOVENTASMENSUAL)) {
				this.setActivarmonto_maximo_ventas_mensualNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.MONTOMINIMOVENTASMENSUAL)) {
				this.setActivarmonto_minimo_ventas_mensualNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESENEROALTO)) {
				this.setActivares_enero_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESFEBREROALTO)) {
				this.setActivares_febrero_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESMARZOALTO)) {
				this.setActivares_marzo_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESABRILALTO)) {
				this.setActivares_abril_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESMAYOALTO)) {
				this.setActivares_mayo_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESJUNIOALTO)) {
				this.setActivares_junio_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESJULIOALTO)) {
				this.setActivares_julio_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESAGOSTOALTO)) {
				this.setActivares_agosto_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESSEPTIEMBREALTO)) {
				this.setActivares_septiembre_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESOCTUBREALTO)) {
				this.setActivares_octubre_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESNOVIEMBREALTO)) {
				this.setActivares_noviembre_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESDICIEMBREALTO)) {
				this.setActivares_diciembre_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESENEROBAJO)) {
				this.setActivares_enero_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESFEBREROBAJO)) {
				this.setActivares_febrero_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESMARZOBAJO)) {
				this.setActivares_marzo_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESABRILBAJO)) {
				this.setActivares_abril_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESMAYOBAJO)) {
				this.setActivares_mayo_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESJUNIOBAJO)) {
				this.setActivares_junio_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESJULIOBAJO)) {
				this.setActivares_julio_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESAGOSTOBAJO)) {
				this.setActivares_agosto_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESSEPTIEMBREBAJO)) {
				this.setActivares_septiembre_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESOCTUBREBAJO)) {
				this.setActivares_octubre_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESNOVIEMBREBAJO)) {
				this.setActivares_noviembre_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESDICIEMBREBAJO)) {
				this.setActivares_diciembre_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionNegocioCliente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridNegocioCliente(esInicial);
		this.setResaltarid_empresaNegocioCliente(esInicial);
		this.setResaltarid_clienteNegocioCliente(esInicial);
		this.setResaltarnombre_quien_se_facturaNegocioCliente(esInicial);
		this.setResaltarfaxNegocioCliente(esInicial);
		this.setResaltarrucNegocioCliente(esInicial);
		this.setResaltartelefonoNegocioCliente(esInicial);
		this.setResaltarnombre_localNegocioCliente(esInicial);
		this.setResaltare_mailNegocioCliente(esInicial);
		this.setResaltardireccionNegocioCliente(esInicial);
		this.setResaltares_local_propioNegocioCliente(esInicial);
		this.setResaltarnumero_aniosNegocioCliente(esInicial);
		this.setResaltarnumero_mesesNegocioCliente(esInicial);
		this.setResaltarid_tipo_ubicacion_negocioNegocioCliente(esInicial);
		this.setResaltarempleados_fijosNegocioCliente(esInicial);
		this.setResaltarempleado_temporalesNegocioCliente(esInicial);
		this.setResaltarempleados_totalNegocioCliente(esInicial);
		this.setResaltarporcentaje_ventas_contadoNegocioCliente(esInicial);
		this.setResaltarporcentaje_ventas_creditoNegocioCliente(esInicial);
		this.setResaltarplazo_diasNegocioCliente(esInicial);
		this.setResaltarnumero_clientesNegocioCliente(esInicial);
		this.setResaltarmonto_maximo_ventas_mensualNegocioCliente(esInicial);
		this.setResaltarmonto_minimo_ventas_mensualNegocioCliente(esInicial);
		this.setResaltares_enero_altoNegocioCliente(esInicial);
		this.setResaltares_febrero_altoNegocioCliente(esInicial);
		this.setResaltares_marzo_altoNegocioCliente(esInicial);
		this.setResaltares_abril_altoNegocioCliente(esInicial);
		this.setResaltares_mayo_altoNegocioCliente(esInicial);
		this.setResaltares_junio_altoNegocioCliente(esInicial);
		this.setResaltares_julio_altoNegocioCliente(esInicial);
		this.setResaltares_agosto_altoNegocioCliente(esInicial);
		this.setResaltares_septiembre_altoNegocioCliente(esInicial);
		this.setResaltares_octubre_altoNegocioCliente(esInicial);
		this.setResaltares_noviembre_altoNegocioCliente(esInicial);
		this.setResaltares_diciembre_altoNegocioCliente(esInicial);
		this.setResaltares_enero_bajoNegocioCliente(esInicial);
		this.setResaltares_febrero_bajoNegocioCliente(esInicial);
		this.setResaltares_marzo_bajoNegocioCliente(esInicial);
		this.setResaltares_abril_bajoNegocioCliente(esInicial);
		this.setResaltares_mayo_bajoNegocioCliente(esInicial);
		this.setResaltares_junio_bajoNegocioCliente(esInicial);
		this.setResaltares_julio_bajoNegocioCliente(esInicial);
		this.setResaltares_agosto_bajoNegocioCliente(esInicial);
		this.setResaltares_septiembre_bajoNegocioCliente(esInicial);
		this.setResaltares_octubre_bajoNegocioCliente(esInicial);
		this.setResaltares_noviembre_bajoNegocioCliente(esInicial);
		this.setResaltares_diciembre_bajoNegocioCliente(esInicial);
		this.setResaltardescripcionNegocioCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ID)) {
				this.setResaltaridNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.NOMBREQUIENSEFACTURA)) {
				this.setResaltarnombre_quien_se_facturaNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.FAX)) {
				this.setResaltarfaxNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.RUC)) {
				this.setResaltarrucNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.NOMBRELOCAL)) {
				this.setResaltarnombre_localNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.EMAIL)) {
				this.setResaltare_mailNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESLOCALPROPIO)) {
				this.setResaltares_local_propioNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.NUMEROANIOS)) {
				this.setResaltarnumero_aniosNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.NUMEROMESES)) {
				this.setResaltarnumero_mesesNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.IDTIPOUBICACIONNEGOCIO)) {
				this.setResaltarid_tipo_ubicacion_negocioNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.EMPLEADOSFIJOS)) {
				this.setResaltarempleados_fijosNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.EMPLEADOTEMPORALES)) {
				this.setResaltarempleado_temporalesNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.EMPLEADOSTOTAL)) {
				this.setResaltarempleados_totalNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.PORCENTAJEVENTASCONTADO)) {
				this.setResaltarporcentaje_ventas_contadoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.PORCENTAJEVENTASCREDITO)) {
				this.setResaltarporcentaje_ventas_creditoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.PLAZODIAS)) {
				this.setResaltarplazo_diasNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.NUMEROCLIENTES)) {
				this.setResaltarnumero_clientesNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.MONTOMAXIMOVENTASMENSUAL)) {
				this.setResaltarmonto_maximo_ventas_mensualNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.MONTOMINIMOVENTASMENSUAL)) {
				this.setResaltarmonto_minimo_ventas_mensualNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESENEROALTO)) {
				this.setResaltares_enero_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESFEBREROALTO)) {
				this.setResaltares_febrero_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESMARZOALTO)) {
				this.setResaltares_marzo_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESABRILALTO)) {
				this.setResaltares_abril_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESMAYOALTO)) {
				this.setResaltares_mayo_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESJUNIOALTO)) {
				this.setResaltares_junio_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESJULIOALTO)) {
				this.setResaltares_julio_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESAGOSTOALTO)) {
				this.setResaltares_agosto_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESSEPTIEMBREALTO)) {
				this.setResaltares_septiembre_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESOCTUBREALTO)) {
				this.setResaltares_octubre_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESNOVIEMBREALTO)) {
				this.setResaltares_noviembre_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESDICIEMBREALTO)) {
				this.setResaltares_diciembre_altoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESENEROBAJO)) {
				this.setResaltares_enero_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESFEBREROBAJO)) {
				this.setResaltares_febrero_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESMARZOBAJO)) {
				this.setResaltares_marzo_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESABRILBAJO)) {
				this.setResaltares_abril_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESMAYOBAJO)) {
				this.setResaltares_mayo_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESJUNIOBAJO)) {
				this.setResaltares_junio_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESJULIOBAJO)) {
				this.setResaltares_julio_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESAGOSTOBAJO)) {
				this.setResaltares_agosto_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESSEPTIEMBREBAJO)) {
				this.setResaltares_septiembre_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESOCTUBREBAJO)) {
				this.setResaltares_octubre_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESNOVIEMBREBAJO)) {
				this.setResaltares_noviembre_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.ESDICIEMBREBAJO)) {
				this.setResaltares_diciembre_bajoNegocioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(NegocioClienteConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionNegocioCliente(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdClienteNegocioCliente=true;

	public Boolean getMostrarFK_IdClienteNegocioCliente() {
		return this.mostrarFK_IdClienteNegocioCliente;
	}

	public void setMostrarFK_IdClienteNegocioCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteNegocioCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaNegocioCliente=true;

	public Boolean getMostrarFK_IdEmpresaNegocioCliente() {
		return this.mostrarFK_IdEmpresaNegocioCliente;
	}

	public void setMostrarFK_IdEmpresaNegocioCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaNegocioCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoUbicacionNegocioNegocioCliente=true;

	public Boolean getMostrarFK_IdTipoUbicacionNegocioNegocioCliente() {
		return this.mostrarFK_IdTipoUbicacionNegocioNegocioCliente;
	}

	public void setMostrarFK_IdTipoUbicacionNegocioNegocioCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoUbicacionNegocioNegocioCliente= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteNegocioCliente=true;

	public Boolean getActivarFK_IdClienteNegocioCliente() {
		return this.activarFK_IdClienteNegocioCliente;
	}

	public void setActivarFK_IdClienteNegocioCliente(Boolean habilitarResaltar) {
		this.activarFK_IdClienteNegocioCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaNegocioCliente=true;

	public Boolean getActivarFK_IdEmpresaNegocioCliente() {
		return this.activarFK_IdEmpresaNegocioCliente;
	}

	public void setActivarFK_IdEmpresaNegocioCliente(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaNegocioCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoUbicacionNegocioNegocioCliente=true;

	public Boolean getActivarFK_IdTipoUbicacionNegocioNegocioCliente() {
		return this.activarFK_IdTipoUbicacionNegocioNegocioCliente;
	}

	public void setActivarFK_IdTipoUbicacionNegocioNegocioCliente(Boolean habilitarResaltar) {
		this.activarFK_IdTipoUbicacionNegocioNegocioCliente= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteNegocioCliente=null;

	public Border getResaltarFK_IdClienteNegocioCliente() {
		return this.resaltarFK_IdClienteNegocioCliente;
	}

	public void setResaltarFK_IdClienteNegocioCliente(Border borderResaltar) {
		this.resaltarFK_IdClienteNegocioCliente= borderResaltar;
	}

	public void setResaltarFK_IdClienteNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteNegocioCliente= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaNegocioCliente=null;

	public Border getResaltarFK_IdEmpresaNegocioCliente() {
		return this.resaltarFK_IdEmpresaNegocioCliente;
	}

	public void setResaltarFK_IdEmpresaNegocioCliente(Border borderResaltar) {
		this.resaltarFK_IdEmpresaNegocioCliente= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaNegocioCliente= borderResaltar;
	}

	public Border resaltarFK_IdTipoUbicacionNegocioNegocioCliente=null;

	public Border getResaltarFK_IdTipoUbicacionNegocioNegocioCliente() {
		return this.resaltarFK_IdTipoUbicacionNegocioNegocioCliente;
	}

	public void setResaltarFK_IdTipoUbicacionNegocioNegocioCliente(Border borderResaltar) {
		this.resaltarFK_IdTipoUbicacionNegocioNegocioCliente= borderResaltar;
	}

	public void setResaltarFK_IdTipoUbicacionNegocioNegocioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*NegocioClienteBeanSwingJInternalFrame negocioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoUbicacionNegocioNegocioCliente= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}