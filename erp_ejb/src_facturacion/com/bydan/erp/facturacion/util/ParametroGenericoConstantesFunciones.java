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


import com.bydan.erp.facturacion.util.ParametroGenericoConstantesFunciones;
import com.bydan.erp.facturacion.util.ParametroGenericoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.ParametroGenericoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ParametroGenericoConstantesFunciones extends ParametroGenericoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ParametroGenerico";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ParametroGenerico"+ParametroGenericoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParametroGenericoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParametroGenericoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParametroGenericoConstantesFunciones.SCHEMA+"_"+ParametroGenericoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParametroGenericoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParametroGenericoConstantesFunciones.SCHEMA+"_"+ParametroGenericoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParametroGenericoConstantesFunciones.SCHEMA+"_"+ParametroGenericoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParametroGenericoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParametroGenericoConstantesFunciones.SCHEMA+"_"+ParametroGenericoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroGenericoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroGenericoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroGenericoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroGenericoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroGenericoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroGenericoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParametroGenericoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParametroGenericoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParametroGenericoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParametroGenericoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parametro Genericos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Parametro Generico";
	public static final String SCLASSWEBTITULO_LOWER="Parametro Generico";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ParametroGenerico";
	public static final String OBJECTNAME="parametrogenerico";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="parametro_generico";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parametrogenerico from "+ParametroGenericoConstantesFunciones.SPERSISTENCENAME+" parametrogenerico";
	public static String QUERYSELECTNATIVE="select "+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+".id,"+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+".version_row,"+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+".id_empresa,"+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+".id_sucursal,"+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+".id_modulo,"+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+".secuencial,"+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+".codigo,"+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+".id_transaccion,"+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+".id_transaccion_recibo,"+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+".id_bodega,"+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+".id_servicio,"+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+".id_formato,"+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME+".id_formato_recibo from "+ParametroGenericoConstantesFunciones.SCHEMA+"."+ParametroGenericoConstantesFunciones.TABLENAME;//+" as "+ParametroGenericoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParametroGenericoConstantesFuncionesAdditional parametrogenericoConstantesFuncionesAdditional=null;
	
	public ParametroGenericoConstantesFuncionesAdditional getParametroGenericoConstantesFuncionesAdditional() {
		return this.parametrogenericoConstantesFuncionesAdditional;
	}
	
	public void setParametroGenericoConstantesFuncionesAdditional(ParametroGenericoConstantesFuncionesAdditional parametrogenericoConstantesFuncionesAdditional) {
		try {
			this.parametrogenericoConstantesFuncionesAdditional=parametrogenericoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDMODULO= "id_modulo";
    public static final String SECUENCIAL= "secuencial";
    public static final String CONPRESUPUESTOCIUDAD= "codigo";
    public static final String IDTRANSACCION= "id_transaccion";
    public static final String IDTRANSACCIONRECIBO= "id_transaccion_recibo";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDSERVICIO= "id_servicio";
    public static final String IDFORMATO= "id_formato";
    public static final String IDFORMATORECIBO= "id_formato_recibo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_SECUENCIAL= "Secuencial";
		public static final String LABEL_SECUENCIAL_LOWER= "Secuencial";
    	public static final String LABEL_CONPRESUPUESTOCIUDAD= "Presupuesto Ciudad";
		public static final String LABEL_CONPRESUPUESTOCIUDAD_LOWER= "Con Presupuesto Ciudad";
    	public static final String LABEL_IDTRANSACCION= "Transaccion";
		public static final String LABEL_IDTRANSACCION_LOWER= "Transaccion";
    	public static final String LABEL_IDTRANSACCIONRECIBO= "Transaccion Recibo";
		public static final String LABEL_IDTRANSACCIONRECIBO_LOWER= "Transaccion Recibo";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDSERVICIO= "Servicio";
		public static final String LABEL_IDSERVICIO_LOWER= "Servicio";
    	public static final String LABEL_IDFORMATO= "Formato";
		public static final String LABEL_IDFORMATO_LOWER= "Formato";
    	public static final String LABEL_IDFORMATORECIBO= "Formato Recibo";
		public static final String LABEL_IDFORMATORECIBO_LOWER= "Formato Recibo";
	
		
		
		
		
		
	public static final String SREGEXSECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	
	public static String getParametroGenericoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParametroGenericoConstantesFunciones.IDEMPRESA)) {sLabelColumna=ParametroGenericoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ParametroGenericoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ParametroGenericoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ParametroGenericoConstantesFunciones.IDMODULO)) {sLabelColumna=ParametroGenericoConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(ParametroGenericoConstantesFunciones.SECUENCIAL)) {sLabelColumna=ParametroGenericoConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(ParametroGenericoConstantesFunciones.CONPRESUPUESTOCIUDAD)) {sLabelColumna=ParametroGenericoConstantesFunciones.LABEL_CONPRESUPUESTOCIUDAD;}
		if(sNombreColumna.equals(ParametroGenericoConstantesFunciones.IDTRANSACCION)) {sLabelColumna=ParametroGenericoConstantesFunciones.LABEL_IDTRANSACCION;}
		if(sNombreColumna.equals(ParametroGenericoConstantesFunciones.IDTRANSACCIONRECIBO)) {sLabelColumna=ParametroGenericoConstantesFunciones.LABEL_IDTRANSACCIONRECIBO;}
		if(sNombreColumna.equals(ParametroGenericoConstantesFunciones.IDBODEGA)) {sLabelColumna=ParametroGenericoConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ParametroGenericoConstantesFunciones.IDSERVICIO)) {sLabelColumna=ParametroGenericoConstantesFunciones.LABEL_IDSERVICIO;}
		if(sNombreColumna.equals(ParametroGenericoConstantesFunciones.IDFORMATO)) {sLabelColumna=ParametroGenericoConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(ParametroGenericoConstantesFunciones.IDFORMATORECIBO)) {sLabelColumna=ParametroGenericoConstantesFunciones.LABEL_IDFORMATORECIBO;}
		
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
	
	
	
			
			
			
			
			
			
		
	public static String getcodigoDescripcion(ParametroGenerico parametrogenerico) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrogenerico.getcodigo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcodigoHtmlDescripcion(ParametroGenerico parametrogenerico) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrogenerico.getId(),parametrogenerico.getcodigo());

		return sDescripcion;
	}	
			
			
			
			
			
			
	
	public static String getParametroGenericoDescripcion(ParametroGenerico parametrogenerico) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parametrogenerico !=null/* && parametrogenerico.getId()!=0*/) {
			if(parametrogenerico.getId()!=null) {
				sDescripcion=parametrogenerico.getId().toString();
			}//parametrogenericoparametrogenerico.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getParametroGenericoDescripcionDetallado(ParametroGenerico parametrogenerico) {
		String sDescripcion="";
			
		sDescripcion+=ParametroGenericoConstantesFunciones.ID+"=";
		sDescripcion+=parametrogenerico.getId().toString()+",";
		sDescripcion+=ParametroGenericoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parametrogenerico.getVersionRow().toString()+",";
		sDescripcion+=ParametroGenericoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=parametrogenerico.getid_empresa().toString()+",";
		sDescripcion+=ParametroGenericoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=parametrogenerico.getid_sucursal().toString()+",";
		sDescripcion+=ParametroGenericoConstantesFunciones.IDMODULO+"=";
		sDescripcion+=parametrogenerico.getid_modulo().toString()+",";
		sDescripcion+=ParametroGenericoConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=parametrogenerico.getsecuencial()+",";
		sDescripcion+=ParametroGenericoConstantesFunciones.CONPRESUPUESTOCIUDAD+"=";
		sDescripcion+=parametrogenerico.getcodigo().toString()+",";
		sDescripcion+=ParametroGenericoConstantesFunciones.IDTRANSACCION+"=";
		sDescripcion+=parametrogenerico.getid_transaccion().toString()+",";
		sDescripcion+=ParametroGenericoConstantesFunciones.IDTRANSACCIONRECIBO+"=";
		sDescripcion+=parametrogenerico.getid_transaccion_recibo().toString()+",";
		sDescripcion+=ParametroGenericoConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=parametrogenerico.getid_bodega().toString()+",";
		sDescripcion+=ParametroGenericoConstantesFunciones.IDSERVICIO+"=";
		sDescripcion+=parametrogenerico.getid_servicio().toString()+",";
		sDescripcion+=ParametroGenericoConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=parametrogenerico.getid_formato().toString()+",";
		sDescripcion+=ParametroGenericoConstantesFunciones.IDFORMATORECIBO+"=";
		sDescripcion+=parametrogenerico.getid_formato_recibo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setParametroGenericoDescripcion(ParametroGenerico parametrogenerico,String sValor) throws Exception {			
		if(parametrogenerico !=null) {
			//parametrogenericoparametrogenerico.getId().toString();
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

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
		}

		return sDescripcion;
	}

	public static String getTransaccionDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccionReciboDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
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

	public static String getServicioDescripcion(Servicio servicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(servicio!=null/*&&servicio.getId()>0*/) {
			sDescripcion=ServicioConstantesFunciones.getServicioDescripcion(servicio);
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

	public static String getFormatoReciboDescripcion(Formato formato) {
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
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFormato")) {
			sNombreIndice="Tipo=  Por Formato";
		} else if(sNombreIndice.equals("FK_IdFormatoRecibo")) {
			sNombreIndice="Tipo=  Por Formato Recibo";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdServicio")) {
			sNombreIndice="Tipo=  Por Servicio";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTransaccion")) {
			sNombreIndice="Tipo=  Por Transaccion";
		} else if(sNombreIndice.equals("FK_IdTransaccionRecibo")) {
			sNombreIndice="Tipo=  Por Transaccion Recibo";
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

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormato(Long id_formato) {
		String sDetalleIndice=" Parametros->";
		if(id_formato!=null) {sDetalleIndice+=" Codigo Unico De Formato="+id_formato.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormatoRecibo(Long id_formato_recibo) {
		String sDetalleIndice=" Parametros->";
		if(id_formato_recibo!=null) {sDetalleIndice+=" Codigo Unico De Formato Recibo="+id_formato_recibo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdServicio(Long id_servicio) {
		String sDetalleIndice=" Parametros->";
		if(id_servicio!=null) {sDetalleIndice+=" Codigo Unico De Servicio="+id_servicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion(Long id_transaccion) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Transaccion="+id_transaccion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionRecibo(Long id_transaccion_recibo) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_recibo!=null) {sDetalleIndice+=" Codigo Unico De Transaccion Recibo="+id_transaccion_recibo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosParametroGenerico(ParametroGenerico parametrogenerico,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		parametrogenerico.setsecuencial(parametrogenerico.getsecuencial().trim());
	}
	
	public static void quitarEspaciosParametroGenericos(List<ParametroGenerico> parametrogenericos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ParametroGenerico parametrogenerico: parametrogenericos) {
			parametrogenerico.setsecuencial(parametrogenerico.getsecuencial().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroGenerico(ParametroGenerico parametrogenerico,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parametrogenerico.getConCambioAuxiliar()) {
			parametrogenerico.setIsDeleted(parametrogenerico.getIsDeletedAuxiliar());	
			parametrogenerico.setIsNew(parametrogenerico.getIsNewAuxiliar());	
			parametrogenerico.setIsChanged(parametrogenerico.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parametrogenerico.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parametrogenerico.setIsDeletedAuxiliar(false);	
			parametrogenerico.setIsNewAuxiliar(false);	
			parametrogenerico.setIsChangedAuxiliar(false);
			
			parametrogenerico.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroGenericos(List<ParametroGenerico> parametrogenericos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ParametroGenerico parametrogenerico : parametrogenericos) {
			if(conAsignarBase && parametrogenerico.getConCambioAuxiliar()) {
				parametrogenerico.setIsDeleted(parametrogenerico.getIsDeletedAuxiliar());	
				parametrogenerico.setIsNew(parametrogenerico.getIsNewAuxiliar());	
				parametrogenerico.setIsChanged(parametrogenerico.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parametrogenerico.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parametrogenerico.setIsDeletedAuxiliar(false);	
				parametrogenerico.setIsNewAuxiliar(false);	
				parametrogenerico.setIsChangedAuxiliar(false);
				
				parametrogenerico.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParametroGenerico(ParametroGenerico parametrogenerico,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresParametroGenericos(List<ParametroGenerico> parametrogenericos,Boolean conEnteros) throws Exception  {
		
		for(ParametroGenerico parametrogenerico: parametrogenericos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaParametroGenerico(List<ParametroGenerico> parametrogenericos,ParametroGenerico parametrogenericoAux) throws Exception  {
		ParametroGenericoConstantesFunciones.InicializarValoresParametroGenerico(parametrogenericoAux,true);
		
		for(ParametroGenerico parametrogenerico: parametrogenericos) {
			if(parametrogenerico.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroGenerico(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParametroGenericoConstantesFunciones.getArrayColumnasGlobalesParametroGenerico(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroGenerico(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroGenericoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroGenericoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroGenericoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroGenericoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroGenericoConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroGenericoConstantesFunciones.IDMODULO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParametroGenerico(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ParametroGenericoConstantesFunciones.IDMODULO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ParametroGenerico> parametrogenericos,ParametroGenerico parametrogenerico,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ParametroGenerico parametrogenericoAux: parametrogenericos) {
			if(parametrogenericoAux!=null && parametrogenerico!=null) {
				if((parametrogenericoAux.getId()==null && parametrogenerico.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parametrogenericoAux.getId()!=null && parametrogenerico.getId()!=null){
					if(parametrogenericoAux.getId().equals(parametrogenerico.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParametroGenerico(List<ParametroGenerico> parametrogenericos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ParametroGenerico parametrogenerico: parametrogenericos) {			
			if(parametrogenerico.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParametroGenerico() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParametroGenericoConstantesFunciones.LABEL_ID, ParametroGenericoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGenericoConstantesFunciones.LABEL_VERSIONROW, ParametroGenericoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGenericoConstantesFunciones.LABEL_IDEMPRESA, ParametroGenericoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGenericoConstantesFunciones.LABEL_IDSUCURSAL, ParametroGenericoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGenericoConstantesFunciones.LABEL_IDMODULO, ParametroGenericoConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGenericoConstantesFunciones.LABEL_SECUENCIAL, ParametroGenericoConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGenericoConstantesFunciones.LABEL_CONPRESUPUESTOCIUDAD, ParametroGenericoConstantesFunciones.CONPRESUPUESTOCIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGenericoConstantesFunciones.LABEL_IDTRANSACCION, ParametroGenericoConstantesFunciones.IDTRANSACCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGenericoConstantesFunciones.LABEL_IDTRANSACCIONRECIBO, ParametroGenericoConstantesFunciones.IDTRANSACCIONRECIBO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGenericoConstantesFunciones.LABEL_IDBODEGA, ParametroGenericoConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGenericoConstantesFunciones.LABEL_IDSERVICIO, ParametroGenericoConstantesFunciones.IDSERVICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGenericoConstantesFunciones.LABEL_IDFORMATO, ParametroGenericoConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroGenericoConstantesFunciones.LABEL_IDFORMATORECIBO, ParametroGenericoConstantesFunciones.IDFORMATORECIBO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParametroGenerico() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParametroGenericoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGenericoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGenericoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGenericoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGenericoConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGenericoConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGenericoConstantesFunciones.CONPRESUPUESTOCIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGenericoConstantesFunciones.IDTRANSACCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGenericoConstantesFunciones.IDTRANSACCIONRECIBO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGenericoConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGenericoConstantesFunciones.IDSERVICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGenericoConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroGenericoConstantesFunciones.IDFORMATORECIBO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroGenerico() throws Exception  {
		return ParametroGenericoConstantesFunciones.getTiposSeleccionarParametroGenerico(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroGenerico(Boolean conFk) throws Exception  {
		return ParametroGenericoConstantesFunciones.getTiposSeleccionarParametroGenerico(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroGenerico(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGenericoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ParametroGenericoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGenericoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ParametroGenericoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGenericoConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(ParametroGenericoConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGenericoConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(ParametroGenericoConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGenericoConstantesFunciones.LABEL_CONPRESUPUESTOCIUDAD);
			reporte.setsDescripcion(ParametroGenericoConstantesFunciones.LABEL_CONPRESUPUESTOCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGenericoConstantesFunciones.LABEL_IDTRANSACCION);
			reporte.setsDescripcion(ParametroGenericoConstantesFunciones.LABEL_IDTRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGenericoConstantesFunciones.LABEL_IDTRANSACCIONRECIBO);
			reporte.setsDescripcion(ParametroGenericoConstantesFunciones.LABEL_IDTRANSACCIONRECIBO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGenericoConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ParametroGenericoConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGenericoConstantesFunciones.LABEL_IDSERVICIO);
			reporte.setsDescripcion(ParametroGenericoConstantesFunciones.LABEL_IDSERVICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGenericoConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(ParametroGenericoConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroGenericoConstantesFunciones.LABEL_IDFORMATORECIBO);
			reporte.setsDescripcion(ParametroGenericoConstantesFunciones.LABEL_IDFORMATORECIBO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParametroGenerico(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParametroGenerico(ParametroGenerico parametrogenericoAux) throws Exception {
		
			parametrogenericoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrogenericoAux.getEmpresa()));
			parametrogenericoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametrogenericoAux.getSucursal()));
			parametrogenericoAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(parametrogenericoAux.getModulo()));
			parametrogenericoAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrogenericoAux.getTransaccion()));
			parametrogenericoAux.settransaccionrecibo_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrogenericoAux.getTransaccionRecibo()));
			parametrogenericoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(parametrogenericoAux.getBodega()));
			parametrogenericoAux.setservicio_descripcion(ServicioConstantesFunciones.getServicioDescripcion(parametrogenericoAux.getServicio()));
			parametrogenericoAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametrogenericoAux.getFormato()));
			parametrogenericoAux.setformatorecibo_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametrogenericoAux.getFormatoRecibo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesParametroGenerico(List<ParametroGenerico> parametrogenericosTemp) throws Exception {
		for(ParametroGenerico parametrogenericoAux:parametrogenericosTemp) {
			
			parametrogenericoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrogenericoAux.getEmpresa()));
			parametrogenericoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametrogenericoAux.getSucursal()));
			parametrogenericoAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(parametrogenericoAux.getModulo()));
			parametrogenericoAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrogenericoAux.getTransaccion()));
			parametrogenericoAux.settransaccionrecibo_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrogenericoAux.getTransaccionRecibo()));
			parametrogenericoAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(parametrogenericoAux.getBodega()));
			parametrogenericoAux.setservicio_descripcion(ServicioConstantesFunciones.getServicioDescripcion(parametrogenericoAux.getServicio()));
			parametrogenericoAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametrogenericoAux.getFormato()));
			parametrogenericoAux.setformatorecibo_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametrogenericoAux.getFormatoRecibo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParametroGenerico(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Servicio.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(Formato.class));
				
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
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
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
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Servicio.class)) {
						classes.add(new Classe(Servicio.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParametroGenerico(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Servicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Servicio.class)); continue;
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

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Servicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Servicio.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroGenerico(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroGenericoConstantesFunciones.getClassesRelationshipsOfParametroGenerico(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroGenerico(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroGenerico(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroGenericoConstantesFunciones.getClassesRelationshipsFromStringsOfParametroGenerico(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroGenerico(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ParametroGenerico parametrogenerico,List<ParametroGenerico> parametrogenericos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ParametroGenerico parametrogenericoEncontrado=null;
			
			for(ParametroGenerico parametrogenericoLocal:parametrogenericos) {
				if(parametrogenericoLocal.getId().equals(parametrogenerico.getId())) {
					parametrogenericoEncontrado=parametrogenericoLocal;
					
					parametrogenericoLocal.setIsChanged(parametrogenerico.getIsChanged());
					parametrogenericoLocal.setIsNew(parametrogenerico.getIsNew());
					parametrogenericoLocal.setIsDeleted(parametrogenerico.getIsDeleted());
					
					parametrogenericoLocal.setGeneralEntityOriginal(parametrogenerico.getGeneralEntityOriginal());
					
					parametrogenericoLocal.setId(parametrogenerico.getId());	
					parametrogenericoLocal.setVersionRow(parametrogenerico.getVersionRow());	
					parametrogenericoLocal.setid_empresa(parametrogenerico.getid_empresa());	
					parametrogenericoLocal.setid_sucursal(parametrogenerico.getid_sucursal());	
					parametrogenericoLocal.setid_modulo(parametrogenerico.getid_modulo());	
					parametrogenericoLocal.setsecuencial(parametrogenerico.getsecuencial());	
					parametrogenericoLocal.setcodigo(parametrogenerico.getcodigo());	
					parametrogenericoLocal.setid_transaccion(parametrogenerico.getid_transaccion());	
					parametrogenericoLocal.setid_transaccion_recibo(parametrogenerico.getid_transaccion_recibo());	
					parametrogenericoLocal.setid_bodega(parametrogenerico.getid_bodega());	
					parametrogenericoLocal.setid_servicio(parametrogenerico.getid_servicio());	
					parametrogenericoLocal.setid_formato(parametrogenerico.getid_formato());	
					parametrogenericoLocal.setid_formato_recibo(parametrogenerico.getid_formato_recibo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!parametrogenerico.getIsDeleted()) {
				if(!existe) {
					parametrogenericos.add(parametrogenerico);
				}
			} else {
				if(parametrogenericoEncontrado!=null && permiteQuitar)  {
					parametrogenericos.remove(parametrogenericoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ParametroGenerico parametrogenerico,List<ParametroGenerico> parametrogenericos) throws Exception {
		try	{			
			for(ParametroGenerico parametrogenericoLocal:parametrogenericos) {
				if(parametrogenericoLocal.getId().equals(parametrogenerico.getId())) {
					parametrogenericoLocal.setIsSelected(parametrogenerico.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParametroGenerico(List<ParametroGenerico> parametrogenericosAux) throws Exception {
		//this.parametrogenericosAux=parametrogenericosAux;
		
		for(ParametroGenerico parametrogenericoAux:parametrogenericosAux) {
			if(parametrogenericoAux.getIsChanged()) {
				parametrogenericoAux.setIsChanged(false);
			}		
			
			if(parametrogenericoAux.getIsNew()) {
				parametrogenericoAux.setIsNew(false);
			}	
			
			if(parametrogenericoAux.getIsDeleted()) {
				parametrogenericoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParametroGenerico(ParametroGenerico parametrogenericoAux) throws Exception {
		//this.parametrogenericoAux=parametrogenericoAux;
		
			if(parametrogenericoAux.getIsChanged()) {
				parametrogenericoAux.setIsChanged(false);
			}		
			
			if(parametrogenericoAux.getIsNew()) {
				parametrogenericoAux.setIsNew(false);
			}	
			
			if(parametrogenericoAux.getIsDeleted()) {
				parametrogenericoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ParametroGenerico parametrogenericoAsignar,ParametroGenerico parametrogenerico) throws Exception {
		parametrogenericoAsignar.setId(parametrogenerico.getId());	
		parametrogenericoAsignar.setVersionRow(parametrogenerico.getVersionRow());	
		parametrogenericoAsignar.setid_empresa(parametrogenerico.getid_empresa());
		parametrogenericoAsignar.setempresa_descripcion(parametrogenerico.getempresa_descripcion());	
		parametrogenericoAsignar.setid_sucursal(parametrogenerico.getid_sucursal());
		parametrogenericoAsignar.setsucursal_descripcion(parametrogenerico.getsucursal_descripcion());	
		parametrogenericoAsignar.setid_modulo(parametrogenerico.getid_modulo());
		parametrogenericoAsignar.setmodulo_descripcion(parametrogenerico.getmodulo_descripcion());	
		parametrogenericoAsignar.setsecuencial(parametrogenerico.getsecuencial());	
		parametrogenericoAsignar.setcodigo(parametrogenerico.getcodigo());	
		parametrogenericoAsignar.setid_transaccion(parametrogenerico.getid_transaccion());
		parametrogenericoAsignar.settransaccion_descripcion(parametrogenerico.gettransaccion_descripcion());	
		parametrogenericoAsignar.setid_transaccion_recibo(parametrogenerico.getid_transaccion_recibo());
		parametrogenericoAsignar.settransaccionrecibo_descripcion(parametrogenerico.gettransaccionrecibo_descripcion());	
		parametrogenericoAsignar.setid_bodega(parametrogenerico.getid_bodega());
		parametrogenericoAsignar.setbodega_descripcion(parametrogenerico.getbodega_descripcion());	
		parametrogenericoAsignar.setid_servicio(parametrogenerico.getid_servicio());
		parametrogenericoAsignar.setservicio_descripcion(parametrogenerico.getservicio_descripcion());	
		parametrogenericoAsignar.setid_formato(parametrogenerico.getid_formato());
		parametrogenericoAsignar.setformato_descripcion(parametrogenerico.getformato_descripcion());	
		parametrogenericoAsignar.setid_formato_recibo(parametrogenerico.getid_formato_recibo());
		parametrogenericoAsignar.setformatorecibo_descripcion(parametrogenerico.getformatorecibo_descripcion());	
	}
	
	public static void inicializarParametroGenerico(ParametroGenerico parametrogenerico) throws Exception {
		try {
				parametrogenerico.setId(0L);	
					
				parametrogenerico.setid_empresa(-1L);	
				parametrogenerico.setid_sucursal(-1L);	
				parametrogenerico.setid_modulo(-1L);	
				parametrogenerico.setsecuencial("");	
				parametrogenerico.setcodigo(false);	
				parametrogenerico.setid_transaccion(-1L);	
				parametrogenerico.setid_transaccion_recibo(null);	
				parametrogenerico.setid_bodega(-1L);	
				parametrogenerico.setid_servicio(-1L);	
				parametrogenerico.setid_formato(-1L);	
				parametrogenerico.setid_formato_recibo(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParametroGenerico(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGenericoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGenericoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGenericoConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGenericoConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGenericoConstantesFunciones.LABEL_CONPRESUPUESTOCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGenericoConstantesFunciones.LABEL_IDTRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGenericoConstantesFunciones.LABEL_IDTRANSACCIONRECIBO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGenericoConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGenericoConstantesFunciones.LABEL_IDSERVICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGenericoConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroGenericoConstantesFunciones.LABEL_IDFORMATORECIBO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParametroGenerico(String sTipo,Row row,Workbook workbook,ParametroGenerico parametrogenerico,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogenerico.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogenerico.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogenerico.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogenerico.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrogenerico.getcodigo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogenerico.gettransaccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogenerico.gettransaccionrecibo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogenerico.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogenerico.getservicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogenerico.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrogenerico.getformatorecibo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParametroGenerico=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParametroGenerico() {
		return this.sFinalQueryParametroGenerico;
	}
	
	public void setsFinalQueryParametroGenerico(String sFinalQueryParametroGenerico) {
		this.sFinalQueryParametroGenerico= sFinalQueryParametroGenerico;
	}
	
	public Border resaltarSeleccionarParametroGenerico=null;
	
	public Border setResaltarSeleccionarParametroGenerico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGenericoBeanSwingJInternalFrame parametrogenericoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parametrogenericoBeanSwingJInternalFrame.jTtoolBarParametroGenerico.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParametroGenerico= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParametroGenerico() {
		return this.resaltarSeleccionarParametroGenerico;
	}
	
	public void setResaltarSeleccionarParametroGenerico(Border borderResaltarSeleccionarParametroGenerico) {
		this.resaltarSeleccionarParametroGenerico= borderResaltarSeleccionarParametroGenerico;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParametroGenerico=null;
	public Boolean mostraridParametroGenerico=true;
	public Boolean activaridParametroGenerico=true;

	public Border resaltarid_empresaParametroGenerico=null;
	public Boolean mostrarid_empresaParametroGenerico=true;
	public Boolean activarid_empresaParametroGenerico=true;
	public Boolean cargarid_empresaParametroGenerico=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaParametroGenerico=false;//ConEventDepend=true

	public Border resaltarid_sucursalParametroGenerico=null;
	public Boolean mostrarid_sucursalParametroGenerico=true;
	public Boolean activarid_sucursalParametroGenerico=true;
	public Boolean cargarid_sucursalParametroGenerico=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalParametroGenerico=false;//ConEventDepend=true

	public Border resaltarid_moduloParametroGenerico=null;
	public Boolean mostrarid_moduloParametroGenerico=true;
	public Boolean activarid_moduloParametroGenerico=true;
	public Boolean cargarid_moduloParametroGenerico=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloParametroGenerico=false;//ConEventDepend=true

	public Border resaltarsecuencialParametroGenerico=null;
	public Boolean mostrarsecuencialParametroGenerico=true;
	public Boolean activarsecuencialParametroGenerico=true;

	public Border resaltarcodigoParametroGenerico=null;
	public Boolean mostrarcodigoParametroGenerico=true;
	public Boolean activarcodigoParametroGenerico=true;

	public Border resaltarid_transaccionParametroGenerico=null;
	public Boolean mostrarid_transaccionParametroGenerico=true;
	public Boolean activarid_transaccionParametroGenerico=true;
	public Boolean cargarid_transaccionParametroGenerico=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccionParametroGenerico=false;//ConEventDepend=true

	public Border resaltarid_transaccion_reciboParametroGenerico=null;
	public Boolean mostrarid_transaccion_reciboParametroGenerico=true;
	public Boolean activarid_transaccion_reciboParametroGenerico=true;
	public Boolean cargarid_transaccion_reciboParametroGenerico=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_reciboParametroGenerico=false;//ConEventDepend=true

	public Border resaltarid_bodegaParametroGenerico=null;
	public Boolean mostrarid_bodegaParametroGenerico=true;
	public Boolean activarid_bodegaParametroGenerico=true;
	public Boolean cargarid_bodegaParametroGenerico=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaParametroGenerico=false;//ConEventDepend=true

	public Border resaltarid_servicioParametroGenerico=null;
	public Boolean mostrarid_servicioParametroGenerico=true;
	public Boolean activarid_servicioParametroGenerico=true;
	public Boolean cargarid_servicioParametroGenerico=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_servicioParametroGenerico=false;//ConEventDepend=true

	public Border resaltarid_formatoParametroGenerico=null;
	public Boolean mostrarid_formatoParametroGenerico=true;
	public Boolean activarid_formatoParametroGenerico=true;
	public Boolean cargarid_formatoParametroGenerico=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoParametroGenerico=false;//ConEventDepend=true

	public Border resaltarid_formato_reciboParametroGenerico=null;
	public Boolean mostrarid_formato_reciboParametroGenerico=true;
	public Boolean activarid_formato_reciboParametroGenerico=true;
	public Boolean cargarid_formato_reciboParametroGenerico=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_reciboParametroGenerico=false;//ConEventDepend=true

	
	

	public Border setResaltaridParametroGenerico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGenericoBeanSwingJInternalFrame parametrogenericoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogenericoBeanSwingJInternalFrame.jTtoolBarParametroGenerico.setBorder(borderResaltar);
		
		this.resaltaridParametroGenerico= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParametroGenerico() {
		return this.resaltaridParametroGenerico;
	}

	public void setResaltaridParametroGenerico(Border borderResaltar) {
		this.resaltaridParametroGenerico= borderResaltar;
	}

	public Boolean getMostraridParametroGenerico() {
		return this.mostraridParametroGenerico;
	}

	public void setMostraridParametroGenerico(Boolean mostraridParametroGenerico) {
		this.mostraridParametroGenerico= mostraridParametroGenerico;
	}

	public Boolean getActivaridParametroGenerico() {
		return this.activaridParametroGenerico;
	}

	public void setActivaridParametroGenerico(Boolean activaridParametroGenerico) {
		this.activaridParametroGenerico= activaridParametroGenerico;
	}

	public Border setResaltarid_empresaParametroGenerico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGenericoBeanSwingJInternalFrame parametrogenericoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogenericoBeanSwingJInternalFrame.jTtoolBarParametroGenerico.setBorder(borderResaltar);
		
		this.resaltarid_empresaParametroGenerico= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaParametroGenerico() {
		return this.resaltarid_empresaParametroGenerico;
	}

	public void setResaltarid_empresaParametroGenerico(Border borderResaltar) {
		this.resaltarid_empresaParametroGenerico= borderResaltar;
	}

	public Boolean getMostrarid_empresaParametroGenerico() {
		return this.mostrarid_empresaParametroGenerico;
	}

	public void setMostrarid_empresaParametroGenerico(Boolean mostrarid_empresaParametroGenerico) {
		this.mostrarid_empresaParametroGenerico= mostrarid_empresaParametroGenerico;
	}

	public Boolean getActivarid_empresaParametroGenerico() {
		return this.activarid_empresaParametroGenerico;
	}

	public void setActivarid_empresaParametroGenerico(Boolean activarid_empresaParametroGenerico) {
		this.activarid_empresaParametroGenerico= activarid_empresaParametroGenerico;
	}

	public Boolean getCargarid_empresaParametroGenerico() {
		return this.cargarid_empresaParametroGenerico;
	}

	public void setCargarid_empresaParametroGenerico(Boolean cargarid_empresaParametroGenerico) {
		this.cargarid_empresaParametroGenerico= cargarid_empresaParametroGenerico;
	}

	public Border setResaltarid_sucursalParametroGenerico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGenericoBeanSwingJInternalFrame parametrogenericoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogenericoBeanSwingJInternalFrame.jTtoolBarParametroGenerico.setBorder(borderResaltar);
		
		this.resaltarid_sucursalParametroGenerico= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalParametroGenerico() {
		return this.resaltarid_sucursalParametroGenerico;
	}

	public void setResaltarid_sucursalParametroGenerico(Border borderResaltar) {
		this.resaltarid_sucursalParametroGenerico= borderResaltar;
	}

	public Boolean getMostrarid_sucursalParametroGenerico() {
		return this.mostrarid_sucursalParametroGenerico;
	}

	public void setMostrarid_sucursalParametroGenerico(Boolean mostrarid_sucursalParametroGenerico) {
		this.mostrarid_sucursalParametroGenerico= mostrarid_sucursalParametroGenerico;
	}

	public Boolean getActivarid_sucursalParametroGenerico() {
		return this.activarid_sucursalParametroGenerico;
	}

	public void setActivarid_sucursalParametroGenerico(Boolean activarid_sucursalParametroGenerico) {
		this.activarid_sucursalParametroGenerico= activarid_sucursalParametroGenerico;
	}

	public Boolean getCargarid_sucursalParametroGenerico() {
		return this.cargarid_sucursalParametroGenerico;
	}

	public void setCargarid_sucursalParametroGenerico(Boolean cargarid_sucursalParametroGenerico) {
		this.cargarid_sucursalParametroGenerico= cargarid_sucursalParametroGenerico;
	}

	public Border setResaltarid_moduloParametroGenerico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGenericoBeanSwingJInternalFrame parametrogenericoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogenericoBeanSwingJInternalFrame.jTtoolBarParametroGenerico.setBorder(borderResaltar);
		
		this.resaltarid_moduloParametroGenerico= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloParametroGenerico() {
		return this.resaltarid_moduloParametroGenerico;
	}

	public void setResaltarid_moduloParametroGenerico(Border borderResaltar) {
		this.resaltarid_moduloParametroGenerico= borderResaltar;
	}

	public Boolean getMostrarid_moduloParametroGenerico() {
		return this.mostrarid_moduloParametroGenerico;
	}

	public void setMostrarid_moduloParametroGenerico(Boolean mostrarid_moduloParametroGenerico) {
		this.mostrarid_moduloParametroGenerico= mostrarid_moduloParametroGenerico;
	}

	public Boolean getActivarid_moduloParametroGenerico() {
		return this.activarid_moduloParametroGenerico;
	}

	public void setActivarid_moduloParametroGenerico(Boolean activarid_moduloParametroGenerico) {
		this.activarid_moduloParametroGenerico= activarid_moduloParametroGenerico;
	}

	public Boolean getCargarid_moduloParametroGenerico() {
		return this.cargarid_moduloParametroGenerico;
	}

	public void setCargarid_moduloParametroGenerico(Boolean cargarid_moduloParametroGenerico) {
		this.cargarid_moduloParametroGenerico= cargarid_moduloParametroGenerico;
	}

	public Border setResaltarsecuencialParametroGenerico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGenericoBeanSwingJInternalFrame parametrogenericoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogenericoBeanSwingJInternalFrame.jTtoolBarParametroGenerico.setBorder(borderResaltar);
		
		this.resaltarsecuencialParametroGenerico= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialParametroGenerico() {
		return this.resaltarsecuencialParametroGenerico;
	}

	public void setResaltarsecuencialParametroGenerico(Border borderResaltar) {
		this.resaltarsecuencialParametroGenerico= borderResaltar;
	}

	public Boolean getMostrarsecuencialParametroGenerico() {
		return this.mostrarsecuencialParametroGenerico;
	}

	public void setMostrarsecuencialParametroGenerico(Boolean mostrarsecuencialParametroGenerico) {
		this.mostrarsecuencialParametroGenerico= mostrarsecuencialParametroGenerico;
	}

	public Boolean getActivarsecuencialParametroGenerico() {
		return this.activarsecuencialParametroGenerico;
	}

	public void setActivarsecuencialParametroGenerico(Boolean activarsecuencialParametroGenerico) {
		this.activarsecuencialParametroGenerico= activarsecuencialParametroGenerico;
	}

	public Border setResaltarcodigoParametroGenerico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGenericoBeanSwingJInternalFrame parametrogenericoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogenericoBeanSwingJInternalFrame.jTtoolBarParametroGenerico.setBorder(borderResaltar);
		
		this.resaltarcodigoParametroGenerico= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoParametroGenerico() {
		return this.resaltarcodigoParametroGenerico;
	}

	public void setResaltarcodigoParametroGenerico(Border borderResaltar) {
		this.resaltarcodigoParametroGenerico= borderResaltar;
	}

	public Boolean getMostrarcodigoParametroGenerico() {
		return this.mostrarcodigoParametroGenerico;
	}

	public void setMostrarcodigoParametroGenerico(Boolean mostrarcodigoParametroGenerico) {
		this.mostrarcodigoParametroGenerico= mostrarcodigoParametroGenerico;
	}

	public Boolean getActivarcodigoParametroGenerico() {
		return this.activarcodigoParametroGenerico;
	}

	public void setActivarcodigoParametroGenerico(Boolean activarcodigoParametroGenerico) {
		this.activarcodigoParametroGenerico= activarcodigoParametroGenerico;
	}

	public Border setResaltarid_transaccionParametroGenerico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGenericoBeanSwingJInternalFrame parametrogenericoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogenericoBeanSwingJInternalFrame.jTtoolBarParametroGenerico.setBorder(borderResaltar);
		
		this.resaltarid_transaccionParametroGenerico= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccionParametroGenerico() {
		return this.resaltarid_transaccionParametroGenerico;
	}

	public void setResaltarid_transaccionParametroGenerico(Border borderResaltar) {
		this.resaltarid_transaccionParametroGenerico= borderResaltar;
	}

	public Boolean getMostrarid_transaccionParametroGenerico() {
		return this.mostrarid_transaccionParametroGenerico;
	}

	public void setMostrarid_transaccionParametroGenerico(Boolean mostrarid_transaccionParametroGenerico) {
		this.mostrarid_transaccionParametroGenerico= mostrarid_transaccionParametroGenerico;
	}

	public Boolean getActivarid_transaccionParametroGenerico() {
		return this.activarid_transaccionParametroGenerico;
	}

	public void setActivarid_transaccionParametroGenerico(Boolean activarid_transaccionParametroGenerico) {
		this.activarid_transaccionParametroGenerico= activarid_transaccionParametroGenerico;
	}

	public Boolean getCargarid_transaccionParametroGenerico() {
		return this.cargarid_transaccionParametroGenerico;
	}

	public void setCargarid_transaccionParametroGenerico(Boolean cargarid_transaccionParametroGenerico) {
		this.cargarid_transaccionParametroGenerico= cargarid_transaccionParametroGenerico;
	}

	public Border setResaltarid_transaccion_reciboParametroGenerico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGenericoBeanSwingJInternalFrame parametrogenericoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogenericoBeanSwingJInternalFrame.jTtoolBarParametroGenerico.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_reciboParametroGenerico= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_reciboParametroGenerico() {
		return this.resaltarid_transaccion_reciboParametroGenerico;
	}

	public void setResaltarid_transaccion_reciboParametroGenerico(Border borderResaltar) {
		this.resaltarid_transaccion_reciboParametroGenerico= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_reciboParametroGenerico() {
		return this.mostrarid_transaccion_reciboParametroGenerico;
	}

	public void setMostrarid_transaccion_reciboParametroGenerico(Boolean mostrarid_transaccion_reciboParametroGenerico) {
		this.mostrarid_transaccion_reciboParametroGenerico= mostrarid_transaccion_reciboParametroGenerico;
	}

	public Boolean getActivarid_transaccion_reciboParametroGenerico() {
		return this.activarid_transaccion_reciboParametroGenerico;
	}

	public void setActivarid_transaccion_reciboParametroGenerico(Boolean activarid_transaccion_reciboParametroGenerico) {
		this.activarid_transaccion_reciboParametroGenerico= activarid_transaccion_reciboParametroGenerico;
	}

	public Boolean getCargarid_transaccion_reciboParametroGenerico() {
		return this.cargarid_transaccion_reciboParametroGenerico;
	}

	public void setCargarid_transaccion_reciboParametroGenerico(Boolean cargarid_transaccion_reciboParametroGenerico) {
		this.cargarid_transaccion_reciboParametroGenerico= cargarid_transaccion_reciboParametroGenerico;
	}

	public Border setResaltarid_bodegaParametroGenerico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGenericoBeanSwingJInternalFrame parametrogenericoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogenericoBeanSwingJInternalFrame.jTtoolBarParametroGenerico.setBorder(borderResaltar);
		
		this.resaltarid_bodegaParametroGenerico= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaParametroGenerico() {
		return this.resaltarid_bodegaParametroGenerico;
	}

	public void setResaltarid_bodegaParametroGenerico(Border borderResaltar) {
		this.resaltarid_bodegaParametroGenerico= borderResaltar;
	}

	public Boolean getMostrarid_bodegaParametroGenerico() {
		return this.mostrarid_bodegaParametroGenerico;
	}

	public void setMostrarid_bodegaParametroGenerico(Boolean mostrarid_bodegaParametroGenerico) {
		this.mostrarid_bodegaParametroGenerico= mostrarid_bodegaParametroGenerico;
	}

	public Boolean getActivarid_bodegaParametroGenerico() {
		return this.activarid_bodegaParametroGenerico;
	}

	public void setActivarid_bodegaParametroGenerico(Boolean activarid_bodegaParametroGenerico) {
		this.activarid_bodegaParametroGenerico= activarid_bodegaParametroGenerico;
	}

	public Boolean getCargarid_bodegaParametroGenerico() {
		return this.cargarid_bodegaParametroGenerico;
	}

	public void setCargarid_bodegaParametroGenerico(Boolean cargarid_bodegaParametroGenerico) {
		this.cargarid_bodegaParametroGenerico= cargarid_bodegaParametroGenerico;
	}

	public Border setResaltarid_servicioParametroGenerico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGenericoBeanSwingJInternalFrame parametrogenericoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogenericoBeanSwingJInternalFrame.jTtoolBarParametroGenerico.setBorder(borderResaltar);
		
		this.resaltarid_servicioParametroGenerico= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_servicioParametroGenerico() {
		return this.resaltarid_servicioParametroGenerico;
	}

	public void setResaltarid_servicioParametroGenerico(Border borderResaltar) {
		this.resaltarid_servicioParametroGenerico= borderResaltar;
	}

	public Boolean getMostrarid_servicioParametroGenerico() {
		return this.mostrarid_servicioParametroGenerico;
	}

	public void setMostrarid_servicioParametroGenerico(Boolean mostrarid_servicioParametroGenerico) {
		this.mostrarid_servicioParametroGenerico= mostrarid_servicioParametroGenerico;
	}

	public Boolean getActivarid_servicioParametroGenerico() {
		return this.activarid_servicioParametroGenerico;
	}

	public void setActivarid_servicioParametroGenerico(Boolean activarid_servicioParametroGenerico) {
		this.activarid_servicioParametroGenerico= activarid_servicioParametroGenerico;
	}

	public Boolean getCargarid_servicioParametroGenerico() {
		return this.cargarid_servicioParametroGenerico;
	}

	public void setCargarid_servicioParametroGenerico(Boolean cargarid_servicioParametroGenerico) {
		this.cargarid_servicioParametroGenerico= cargarid_servicioParametroGenerico;
	}

	public Border setResaltarid_formatoParametroGenerico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGenericoBeanSwingJInternalFrame parametrogenericoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogenericoBeanSwingJInternalFrame.jTtoolBarParametroGenerico.setBorder(borderResaltar);
		
		this.resaltarid_formatoParametroGenerico= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoParametroGenerico() {
		return this.resaltarid_formatoParametroGenerico;
	}

	public void setResaltarid_formatoParametroGenerico(Border borderResaltar) {
		this.resaltarid_formatoParametroGenerico= borderResaltar;
	}

	public Boolean getMostrarid_formatoParametroGenerico() {
		return this.mostrarid_formatoParametroGenerico;
	}

	public void setMostrarid_formatoParametroGenerico(Boolean mostrarid_formatoParametroGenerico) {
		this.mostrarid_formatoParametroGenerico= mostrarid_formatoParametroGenerico;
	}

	public Boolean getActivarid_formatoParametroGenerico() {
		return this.activarid_formatoParametroGenerico;
	}

	public void setActivarid_formatoParametroGenerico(Boolean activarid_formatoParametroGenerico) {
		this.activarid_formatoParametroGenerico= activarid_formatoParametroGenerico;
	}

	public Boolean getCargarid_formatoParametroGenerico() {
		return this.cargarid_formatoParametroGenerico;
	}

	public void setCargarid_formatoParametroGenerico(Boolean cargarid_formatoParametroGenerico) {
		this.cargarid_formatoParametroGenerico= cargarid_formatoParametroGenerico;
	}

	public Border setResaltarid_formato_reciboParametroGenerico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGenericoBeanSwingJInternalFrame parametrogenericoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrogenericoBeanSwingJInternalFrame.jTtoolBarParametroGenerico.setBorder(borderResaltar);
		
		this.resaltarid_formato_reciboParametroGenerico= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_reciboParametroGenerico() {
		return this.resaltarid_formato_reciboParametroGenerico;
	}

	public void setResaltarid_formato_reciboParametroGenerico(Border borderResaltar) {
		this.resaltarid_formato_reciboParametroGenerico= borderResaltar;
	}

	public Boolean getMostrarid_formato_reciboParametroGenerico() {
		return this.mostrarid_formato_reciboParametroGenerico;
	}

	public void setMostrarid_formato_reciboParametroGenerico(Boolean mostrarid_formato_reciboParametroGenerico) {
		this.mostrarid_formato_reciboParametroGenerico= mostrarid_formato_reciboParametroGenerico;
	}

	public Boolean getActivarid_formato_reciboParametroGenerico() {
		return this.activarid_formato_reciboParametroGenerico;
	}

	public void setActivarid_formato_reciboParametroGenerico(Boolean activarid_formato_reciboParametroGenerico) {
		this.activarid_formato_reciboParametroGenerico= activarid_formato_reciboParametroGenerico;
	}

	public Boolean getCargarid_formato_reciboParametroGenerico() {
		return this.cargarid_formato_reciboParametroGenerico;
	}

	public void setCargarid_formato_reciboParametroGenerico(Boolean cargarid_formato_reciboParametroGenerico) {
		this.cargarid_formato_reciboParametroGenerico= cargarid_formato_reciboParametroGenerico;
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
		
		
		this.setMostraridParametroGenerico(esInicial);
		this.setMostrarid_empresaParametroGenerico(esInicial);
		this.setMostrarid_sucursalParametroGenerico(esInicial);
		this.setMostrarid_moduloParametroGenerico(esInicial);
		this.setMostrarsecuencialParametroGenerico(esInicial);
		this.setMostrarcodigoParametroGenerico(esInicial);
		this.setMostrarid_transaccionParametroGenerico(esInicial);
		this.setMostrarid_transaccion_reciboParametroGenerico(esInicial);
		this.setMostrarid_bodegaParametroGenerico(esInicial);
		this.setMostrarid_servicioParametroGenerico(esInicial);
		this.setMostrarid_formatoParametroGenerico(esInicial);
		this.setMostrarid_formato_reciboParametroGenerico(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.ID)) {
				this.setMostraridParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.CONPRESUPUESTOCIUDAD)) {
				this.setMostrarcodigoParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.IDTRANSACCION)) {
				this.setMostrarid_transaccionParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.IDTRANSACCIONRECIBO)) {
				this.setMostrarid_transaccion_reciboParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.IDSERVICIO)) {
				this.setMostrarid_servicioParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.IDFORMATORECIBO)) {
				this.setMostrarid_formato_reciboParametroGenerico(esAsigna);
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
		
		
		this.setActivaridParametroGenerico(esInicial);
		this.setActivarid_empresaParametroGenerico(esInicial);
		this.setActivarid_sucursalParametroGenerico(esInicial);
		this.setActivarid_moduloParametroGenerico(esInicial);
		this.setActivarsecuencialParametroGenerico(esInicial);
		this.setActivarcodigoParametroGenerico(esInicial);
		this.setActivarid_transaccionParametroGenerico(esInicial);
		this.setActivarid_transaccion_reciboParametroGenerico(esInicial);
		this.setActivarid_bodegaParametroGenerico(esInicial);
		this.setActivarid_servicioParametroGenerico(esInicial);
		this.setActivarid_formatoParametroGenerico(esInicial);
		this.setActivarid_formato_reciboParametroGenerico(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.ID)) {
				this.setActivaridParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.CONPRESUPUESTOCIUDAD)) {
				this.setActivarcodigoParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.IDTRANSACCION)) {
				this.setActivarid_transaccionParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.IDTRANSACCIONRECIBO)) {
				this.setActivarid_transaccion_reciboParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.IDSERVICIO)) {
				this.setActivarid_servicioParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.IDFORMATORECIBO)) {
				this.setActivarid_formato_reciboParametroGenerico(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroGenericoBeanSwingJInternalFrame parametrogenericoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParametroGenerico(esInicial);
		this.setResaltarid_empresaParametroGenerico(esInicial);
		this.setResaltarid_sucursalParametroGenerico(esInicial);
		this.setResaltarid_moduloParametroGenerico(esInicial);
		this.setResaltarsecuencialParametroGenerico(esInicial);
		this.setResaltarcodigoParametroGenerico(esInicial);
		this.setResaltarid_transaccionParametroGenerico(esInicial);
		this.setResaltarid_transaccion_reciboParametroGenerico(esInicial);
		this.setResaltarid_bodegaParametroGenerico(esInicial);
		this.setResaltarid_servicioParametroGenerico(esInicial);
		this.setResaltarid_formatoParametroGenerico(esInicial);
		this.setResaltarid_formato_reciboParametroGenerico(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.ID)) {
				this.setResaltaridParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.CONPRESUPUESTOCIUDAD)) {
				this.setResaltarcodigoParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.IDTRANSACCION)) {
				this.setResaltarid_transaccionParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.IDTRANSACCIONRECIBO)) {
				this.setResaltarid_transaccion_reciboParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.IDSERVICIO)) {
				this.setResaltarid_servicioParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoParametroGenerico(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroGenericoConstantesFunciones.IDFORMATORECIBO)) {
				this.setResaltarid_formato_reciboParametroGenerico(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroGenericoBeanSwingJInternalFrame parametrogenericoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaParametroGenerico=true;

	public Boolean getMostrarFK_IdBodegaParametroGenerico() {
		return this.mostrarFK_IdBodegaParametroGenerico;
	}

	public void setMostrarFK_IdBodegaParametroGenerico(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaParametroGenerico= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaParametroGenerico=true;

	public Boolean getMostrarFK_IdEmpresaParametroGenerico() {
		return this.mostrarFK_IdEmpresaParametroGenerico;
	}

	public void setMostrarFK_IdEmpresaParametroGenerico(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaParametroGenerico= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloParametroGenerico=true;

	public Boolean getMostrarFK_IdModuloParametroGenerico() {
		return this.mostrarFK_IdModuloParametroGenerico;
	}

	public void setMostrarFK_IdModuloParametroGenerico(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloParametroGenerico= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalParametroGenerico=true;

	public Boolean getMostrarFK_IdSucursalParametroGenerico() {
		return this.mostrarFK_IdSucursalParametroGenerico;
	}

	public void setMostrarFK_IdSucursalParametroGenerico(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalParametroGenerico= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaParametroGenerico=true;

	public Boolean getActivarFK_IdBodegaParametroGenerico() {
		return this.activarFK_IdBodegaParametroGenerico;
	}

	public void setActivarFK_IdBodegaParametroGenerico(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaParametroGenerico= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaParametroGenerico=true;

	public Boolean getActivarFK_IdEmpresaParametroGenerico() {
		return this.activarFK_IdEmpresaParametroGenerico;
	}

	public void setActivarFK_IdEmpresaParametroGenerico(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaParametroGenerico= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloParametroGenerico=true;

	public Boolean getActivarFK_IdModuloParametroGenerico() {
		return this.activarFK_IdModuloParametroGenerico;
	}

	public void setActivarFK_IdModuloParametroGenerico(Boolean habilitarResaltar) {
		this.activarFK_IdModuloParametroGenerico= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalParametroGenerico=true;

	public Boolean getActivarFK_IdSucursalParametroGenerico() {
		return this.activarFK_IdSucursalParametroGenerico;
	}

	public void setActivarFK_IdSucursalParametroGenerico(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalParametroGenerico= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaParametroGenerico=null;

	public Border getResaltarFK_IdBodegaParametroGenerico() {
		return this.resaltarFK_IdBodegaParametroGenerico;
	}

	public void setResaltarFK_IdBodegaParametroGenerico(Border borderResaltar) {
		this.resaltarFK_IdBodegaParametroGenerico= borderResaltar;
	}

	public void setResaltarFK_IdBodegaParametroGenerico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGenericoBeanSwingJInternalFrame parametrogenericoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaParametroGenerico= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaParametroGenerico=null;

	public Border getResaltarFK_IdEmpresaParametroGenerico() {
		return this.resaltarFK_IdEmpresaParametroGenerico;
	}

	public void setResaltarFK_IdEmpresaParametroGenerico(Border borderResaltar) {
		this.resaltarFK_IdEmpresaParametroGenerico= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaParametroGenerico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGenericoBeanSwingJInternalFrame parametrogenericoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaParametroGenerico= borderResaltar;
	}

	public Border resaltarFK_IdModuloParametroGenerico=null;

	public Border getResaltarFK_IdModuloParametroGenerico() {
		return this.resaltarFK_IdModuloParametroGenerico;
	}

	public void setResaltarFK_IdModuloParametroGenerico(Border borderResaltar) {
		this.resaltarFK_IdModuloParametroGenerico= borderResaltar;
	}

	public void setResaltarFK_IdModuloParametroGenerico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGenericoBeanSwingJInternalFrame parametrogenericoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloParametroGenerico= borderResaltar;
	}

	public Border resaltarFK_IdSucursalParametroGenerico=null;

	public Border getResaltarFK_IdSucursalParametroGenerico() {
		return this.resaltarFK_IdSucursalParametroGenerico;
	}

	public void setResaltarFK_IdSucursalParametroGenerico(Border borderResaltar) {
		this.resaltarFK_IdSucursalParametroGenerico= borderResaltar;
	}

	public void setResaltarFK_IdSucursalParametroGenerico(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroGenericoBeanSwingJInternalFrame parametrogenericoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalParametroGenerico= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}