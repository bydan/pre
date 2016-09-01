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
package com.bydan.erp.contabilidad.util;

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


import com.bydan.erp.contabilidad.util.ParametroContabilidadDefectoConstantesFunciones;
import com.bydan.erp.contabilidad.util.ParametroContabilidadDefectoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.ParametroContabilidadDefectoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ParametroContabilidadDefectoConstantesFunciones extends ParametroContabilidadDefectoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ParametroContabilidadDefecto";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ParametroContabilidadDefecto"+ParametroContabilidadDefectoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParametroContabilidadDefectoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParametroContabilidadDefectoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"_"+ParametroContabilidadDefectoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParametroContabilidadDefectoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"_"+ParametroContabilidadDefectoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"_"+ParametroContabilidadDefectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParametroContabilidadDefectoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"_"+ParametroContabilidadDefectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroContabilidadDefectoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroContabilidadDefectoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroContabilidadDefectoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroContabilidadDefectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroContabilidadDefectoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroContabilidadDefectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParametroContabilidadDefectoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParametroContabilidadDefectoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParametroContabilidadDefectoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParametroContabilidadDefectoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parametro Contabilidad Defectos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Parametro Contabilidad Defecto";
	public static final String SCLASSWEBTITULO_LOWER="Parametro Contabilidad Defecto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ParametroContabilidadDefecto";
	public static final String OBJECTNAME="parametrocontabilidaddefecto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="parametro_contabilidad_defecto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parametrocontabilidaddefecto from "+ParametroContabilidadDefectoConstantesFunciones.SPERSISTENCENAME+" parametrocontabilidaddefecto";
	public static String QUERYSELECTNATIVE="select "+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME+".id,"+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME+".version_row,"+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME+".id_empresa,"+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME+".id_sucursal,"+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME+".id_tipo_moneda,"+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME+".id_moneda,"+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME+".id_modulo,"+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME+".id_tipo_intervalo,"+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME+".id_tipo_documento,"+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME+".id_estado_asiento_contable from "+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME;//+" as "+ParametroContabilidadDefectoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParametroContabilidadDefectoConstantesFuncionesAdditional parametrocontabilidaddefectoConstantesFuncionesAdditional=null;
	
	public ParametroContabilidadDefectoConstantesFuncionesAdditional getParametroContabilidadDefectoConstantesFuncionesAdditional() {
		return this.parametrocontabilidaddefectoConstantesFuncionesAdditional;
	}
	
	public void setParametroContabilidadDefectoConstantesFuncionesAdditional(ParametroContabilidadDefectoConstantesFuncionesAdditional parametrocontabilidaddefectoConstantesFuncionesAdditional) {
		try {
			this.parametrocontabilidaddefectoConstantesFuncionesAdditional=parametrocontabilidaddefectoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDTIPOMONEDA= "id_tipo_moneda";
    public static final String IDMONEDA= "id_moneda";
    public static final String IDMODULO= "id_modulo";
    public static final String IDTIPOINTERVALO= "id_tipo_intervalo";
    public static final String IDTIPOMOVIMIENTO= "id_tipo_movimiento";
    public static final String IDTIPODOCUMENTO= "id_tipo_documento";
    public static final String IDESTADOASIENTOCONTABLE= "id_estado_asiento_contable";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDTIPOMONEDA= "Tipo Moneda";
		public static final String LABEL_IDTIPOMONEDA_LOWER= "Tipo Moneda";
    	public static final String LABEL_IDMONEDA= "Moneda";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDTIPOINTERVALO= "Tipo Intervalo";
		public static final String LABEL_IDTIPOINTERVALO_LOWER= "Tipo Intervalo";
    	public static final String LABEL_IDTIPOMOVIMIENTO= "Tipo Movimiento";
		public static final String LABEL_IDTIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
    	public static final String LABEL_IDTIPODOCUMENTO= "Tipo Documento";
		public static final String LABEL_IDTIPODOCUMENTO_LOWER= "Tipo Documento";
    	public static final String LABEL_IDESTADOASIENTOCONTABLE= "Estado Asiento C.";
		public static final String LABEL_IDESTADOASIENTOCONTABLE_LOWER= "Estado Asiento Contable";
	
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getParametroContabilidadDefectoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParametroContabilidadDefectoConstantesFunciones.IDEMPRESA)) {sLabelColumna=ParametroContabilidadDefectoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ParametroContabilidadDefectoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ParametroContabilidadDefectoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ParametroContabilidadDefectoConstantesFunciones.IDTIPOMONEDA)) {sLabelColumna=ParametroContabilidadDefectoConstantesFunciones.LABEL_IDTIPOMONEDA;}
		if(sNombreColumna.equals(ParametroContabilidadDefectoConstantesFunciones.IDMONEDA)) {sLabelColumna=ParametroContabilidadDefectoConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(ParametroContabilidadDefectoConstantesFunciones.IDMODULO)) {sLabelColumna=ParametroContabilidadDefectoConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(ParametroContabilidadDefectoConstantesFunciones.IDTIPOINTERVALO)) {sLabelColumna=ParametroContabilidadDefectoConstantesFunciones.LABEL_IDTIPOINTERVALO;}
		if(sNombreColumna.equals(ParametroContabilidadDefectoConstantesFunciones.IDTIPOMOVIMIENTO)) {sLabelColumna=ParametroContabilidadDefectoConstantesFunciones.LABEL_IDTIPOMOVIMIENTO;}
		if(sNombreColumna.equals(ParametroContabilidadDefectoConstantesFunciones.IDTIPODOCUMENTO)) {sLabelColumna=ParametroContabilidadDefectoConstantesFunciones.LABEL_IDTIPODOCUMENTO;}
		if(sNombreColumna.equals(ParametroContabilidadDefectoConstantesFunciones.IDESTADOASIENTOCONTABLE)) {sLabelColumna=ParametroContabilidadDefectoConstantesFunciones.LABEL_IDESTADOASIENTOCONTABLE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getParametroContabilidadDefectoDescripcion(ParametroContabilidadDefecto parametrocontabilidaddefecto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parametrocontabilidaddefecto !=null/* && parametrocontabilidaddefecto.getId()!=0*/) {
			if(parametrocontabilidaddefecto.getId()!=null) {
				sDescripcion=parametrocontabilidaddefecto.getId().toString();
			}//parametrocontabilidaddefectoparametrocontabilidaddefecto.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getParametroContabilidadDefectoDescripcionDetallado(ParametroContabilidadDefecto parametrocontabilidaddefecto) {
		String sDescripcion="";
			
		sDescripcion+=ParametroContabilidadDefectoConstantesFunciones.ID+"=";
		sDescripcion+=parametrocontabilidaddefecto.getId().toString()+",";
		sDescripcion+=ParametroContabilidadDefectoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parametrocontabilidaddefecto.getVersionRow().toString()+",";
		sDescripcion+=ParametroContabilidadDefectoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=parametrocontabilidaddefecto.getid_empresa().toString()+",";
		sDescripcion+=ParametroContabilidadDefectoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=parametrocontabilidaddefecto.getid_sucursal().toString()+",";
		sDescripcion+=ParametroContabilidadDefectoConstantesFunciones.IDTIPOMONEDA+"=";
		sDescripcion+=parametrocontabilidaddefecto.getid_tipo_moneda().toString()+",";
		sDescripcion+=ParametroContabilidadDefectoConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=parametrocontabilidaddefecto.getid_moneda().toString()+",";
		sDescripcion+=ParametroContabilidadDefectoConstantesFunciones.IDMODULO+"=";
		sDescripcion+=parametrocontabilidaddefecto.getid_modulo().toString()+",";
		sDescripcion+=ParametroContabilidadDefectoConstantesFunciones.IDTIPOINTERVALO+"=";
		sDescripcion+=parametrocontabilidaddefecto.getid_tipo_intervalo().toString()+",";
		sDescripcion+=ParametroContabilidadDefectoConstantesFunciones.IDTIPOMOVIMIENTO+"=";
		sDescripcion+=parametrocontabilidaddefecto.getid_tipo_movimiento().toString()+",";
		sDescripcion+=ParametroContabilidadDefectoConstantesFunciones.IDTIPODOCUMENTO+"=";
		sDescripcion+=parametrocontabilidaddefecto.getid_tipo_documento().toString()+",";
		sDescripcion+=ParametroContabilidadDefectoConstantesFunciones.IDESTADOASIENTOCONTABLE+"=";
		sDescripcion+=parametrocontabilidaddefecto.getid_estado_asiento_contable().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setParametroContabilidadDefectoDescripcion(ParametroContabilidadDefecto parametrocontabilidaddefecto,String sValor) throws Exception {			
		if(parametrocontabilidaddefecto !=null) {
			//parametrocontabilidaddefectoparametrocontabilidaddefecto.getId().toString();
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

	public static String getTipoMonedaDescripcion(TipoMoneda tipomoneda) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipomoneda!=null/*&&tipomoneda.getId()>0*/) {
			sDescripcion=TipoMonedaConstantesFunciones.getTipoMonedaDescripcion(tipomoneda);
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

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
		}

		return sDescripcion;
	}

	public static String getTipoIntervaloDescripcion(TipoIntervalo tipointervalo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipointervalo!=null/*&&tipointervalo.getId()>0*/) {
			sDescripcion=TipoIntervaloConstantesFunciones.getTipoIntervaloDescripcion(tipointervalo);
		}

		return sDescripcion;
	}

	public static String getTipoMovimientoDescripcion(TipoMovimiento tipomovimiento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipomovimiento!=null/*&&tipomovimiento.getId()>0*/) {
			sDescripcion=TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(tipomovimiento);
		}

		return sDescripcion;
	}

	public static String getTipoDocumentoDescripcion(TipoDocumento tipodocumento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodocumento!=null/*&&tipodocumento.getId()>0*/) {
			sDescripcion=TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(tipodocumento);
		}

		return sDescripcion;
	}

	public static String getEstadoAsientoContableDescripcion(EstadoAsientoContable estadoasientocontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadoasientocontable!=null/*&&estadoasientocontable.getId()>0*/) {
			sDescripcion=EstadoAsientoContableConstantesFunciones.getEstadoAsientoContableDescripcion(estadoasientocontable);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoAsientoContable")) {
			sNombreIndice="Tipo=  Por Estado Asiento C.";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdMoneda")) {
			sNombreIndice="Tipo=  Por Moneda";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoDocumento")) {
			sNombreIndice="Tipo=  Por Tipo Documento";
		} else if(sNombreIndice.equals("FK_IdTipoIntervalo")) {
			sNombreIndice="Tipo=  Por Tipo Intervalo";
		} else if(sNombreIndice.equals("FK_IdTipoMoneda")) {
			sNombreIndice="Tipo=  Por Tipo Moneda";
		} else if(sNombreIndice.equals("FK_IdTipoMovimiento")) {
			sNombreIndice="Tipo=  Por Tipo Movimiento";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoAsientoContable(Long id_estado_asiento_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_asiento_contable!=null) {sDetalleIndice+=" Codigo Unico De Estado Asiento C.="+id_estado_asiento_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMoneda(Long id_moneda) {
		String sDetalleIndice=" Parametros->";
		if(id_moneda!=null) {sDetalleIndice+=" Codigo Unico De Moneda="+id_moneda.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoDocumento(Long id_tipo_documento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_documento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Documento="+id_tipo_documento.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoIntervalo(Long id_tipo_intervalo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_intervalo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Intervalo="+id_tipo_intervalo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoMoneda(Long id_tipo_moneda) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_moneda!=null) {sDetalleIndice+=" Codigo Unico De Tipo Moneda="+id_tipo_moneda.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoMovimiento(Long id_tipo_movimiento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento="+id_tipo_movimiento.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosParametroContabilidadDefecto(ParametroContabilidadDefecto parametrocontabilidaddefecto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosParametroContabilidadDefectos(List<ParametroContabilidadDefecto> parametrocontabilidaddefectos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ParametroContabilidadDefecto parametrocontabilidaddefecto: parametrocontabilidaddefectos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroContabilidadDefecto(ParametroContabilidadDefecto parametrocontabilidaddefecto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parametrocontabilidaddefecto.getConCambioAuxiliar()) {
			parametrocontabilidaddefecto.setIsDeleted(parametrocontabilidaddefecto.getIsDeletedAuxiliar());	
			parametrocontabilidaddefecto.setIsNew(parametrocontabilidaddefecto.getIsNewAuxiliar());	
			parametrocontabilidaddefecto.setIsChanged(parametrocontabilidaddefecto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parametrocontabilidaddefecto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parametrocontabilidaddefecto.setIsDeletedAuxiliar(false);	
			parametrocontabilidaddefecto.setIsNewAuxiliar(false);	
			parametrocontabilidaddefecto.setIsChangedAuxiliar(false);
			
			parametrocontabilidaddefecto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroContabilidadDefectos(List<ParametroContabilidadDefecto> parametrocontabilidaddefectos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ParametroContabilidadDefecto parametrocontabilidaddefecto : parametrocontabilidaddefectos) {
			if(conAsignarBase && parametrocontabilidaddefecto.getConCambioAuxiliar()) {
				parametrocontabilidaddefecto.setIsDeleted(parametrocontabilidaddefecto.getIsDeletedAuxiliar());	
				parametrocontabilidaddefecto.setIsNew(parametrocontabilidaddefecto.getIsNewAuxiliar());	
				parametrocontabilidaddefecto.setIsChanged(parametrocontabilidaddefecto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parametrocontabilidaddefecto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parametrocontabilidaddefecto.setIsDeletedAuxiliar(false);	
				parametrocontabilidaddefecto.setIsNewAuxiliar(false);	
				parametrocontabilidaddefecto.setIsChangedAuxiliar(false);
				
				parametrocontabilidaddefecto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParametroContabilidadDefecto(ParametroContabilidadDefecto parametrocontabilidaddefecto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresParametroContabilidadDefectos(List<ParametroContabilidadDefecto> parametrocontabilidaddefectos,Boolean conEnteros) throws Exception  {
		
		for(ParametroContabilidadDefecto parametrocontabilidaddefecto: parametrocontabilidaddefectos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaParametroContabilidadDefecto(List<ParametroContabilidadDefecto> parametrocontabilidaddefectos,ParametroContabilidadDefecto parametrocontabilidaddefectoAux) throws Exception  {
		ParametroContabilidadDefectoConstantesFunciones.InicializarValoresParametroContabilidadDefecto(parametrocontabilidaddefectoAux,true);
		
		for(ParametroContabilidadDefecto parametrocontabilidaddefecto: parametrocontabilidaddefectos) {
			if(parametrocontabilidaddefecto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroContabilidadDefecto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParametroContabilidadDefectoConstantesFunciones.getArrayColumnasGlobalesParametroContabilidadDefecto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroContabilidadDefecto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroContabilidadDefectoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroContabilidadDefectoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroContabilidadDefectoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroContabilidadDefectoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroContabilidadDefectoConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroContabilidadDefectoConstantesFunciones.IDMONEDA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroContabilidadDefectoConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroContabilidadDefectoConstantesFunciones.IDMODULO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParametroContabilidadDefecto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ParametroContabilidadDefectoConstantesFunciones.IDMODULO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ParametroContabilidadDefecto> parametrocontabilidaddefectos,ParametroContabilidadDefecto parametrocontabilidaddefecto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ParametroContabilidadDefecto parametrocontabilidaddefectoAux: parametrocontabilidaddefectos) {
			if(parametrocontabilidaddefectoAux!=null && parametrocontabilidaddefecto!=null) {
				if((parametrocontabilidaddefectoAux.getId()==null && parametrocontabilidaddefecto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parametrocontabilidaddefectoAux.getId()!=null && parametrocontabilidaddefecto.getId()!=null){
					if(parametrocontabilidaddefectoAux.getId().equals(parametrocontabilidaddefecto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParametroContabilidadDefecto(List<ParametroContabilidadDefecto> parametrocontabilidaddefectos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ParametroContabilidadDefecto parametrocontabilidaddefecto: parametrocontabilidaddefectos) {			
			if(parametrocontabilidaddefecto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParametroContabilidadDefecto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParametroContabilidadDefectoConstantesFunciones.LABEL_ID, ParametroContabilidadDefectoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContabilidadDefectoConstantesFunciones.LABEL_VERSIONROW, ParametroContabilidadDefectoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContabilidadDefectoConstantesFunciones.LABEL_IDEMPRESA, ParametroContabilidadDefectoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContabilidadDefectoConstantesFunciones.LABEL_IDSUCURSAL, ParametroContabilidadDefectoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContabilidadDefectoConstantesFunciones.LABEL_IDTIPOMONEDA, ParametroContabilidadDefectoConstantesFunciones.IDTIPOMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContabilidadDefectoConstantesFunciones.LABEL_IDMONEDA, ParametroContabilidadDefectoConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContabilidadDefectoConstantesFunciones.LABEL_IDMODULO, ParametroContabilidadDefectoConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContabilidadDefectoConstantesFunciones.LABEL_IDTIPOINTERVALO, ParametroContabilidadDefectoConstantesFunciones.IDTIPOINTERVALO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContabilidadDefectoConstantesFunciones.LABEL_IDTIPOMOVIMIENTO, ParametroContabilidadDefectoConstantesFunciones.IDTIPOMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContabilidadDefectoConstantesFunciones.LABEL_IDTIPODOCUMENTO, ParametroContabilidadDefectoConstantesFunciones.IDTIPODOCUMENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContabilidadDefectoConstantesFunciones.LABEL_IDESTADOASIENTOCONTABLE, ParametroContabilidadDefectoConstantesFunciones.IDESTADOASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParametroContabilidadDefecto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParametroContabilidadDefectoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContabilidadDefectoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContabilidadDefectoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContabilidadDefectoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContabilidadDefectoConstantesFunciones.IDTIPOMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContabilidadDefectoConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContabilidadDefectoConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContabilidadDefectoConstantesFunciones.IDTIPOINTERVALO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContabilidadDefectoConstantesFunciones.IDTIPOMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContabilidadDefectoConstantesFunciones.IDTIPODOCUMENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContabilidadDefectoConstantesFunciones.IDESTADOASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroContabilidadDefecto() throws Exception  {
		return ParametroContabilidadDefectoConstantesFunciones.getTiposSeleccionarParametroContabilidadDefecto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroContabilidadDefecto(Boolean conFk) throws Exception  {
		return ParametroContabilidadDefectoConstantesFunciones.getTiposSeleccionarParametroContabilidadDefecto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroContabilidadDefecto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContabilidadDefectoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ParametroContabilidadDefectoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContabilidadDefectoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ParametroContabilidadDefectoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContabilidadDefectoConstantesFunciones.LABEL_IDTIPOMONEDA);
			reporte.setsDescripcion(ParametroContabilidadDefectoConstantesFunciones.LABEL_IDTIPOMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContabilidadDefectoConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(ParametroContabilidadDefectoConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContabilidadDefectoConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(ParametroContabilidadDefectoConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContabilidadDefectoConstantesFunciones.LABEL_IDTIPOINTERVALO);
			reporte.setsDescripcion(ParametroContabilidadDefectoConstantesFunciones.LABEL_IDTIPOINTERVALO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContabilidadDefectoConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
			reporte.setsDescripcion(ParametroContabilidadDefectoConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContabilidadDefectoConstantesFunciones.LABEL_IDTIPODOCUMENTO);
			reporte.setsDescripcion(ParametroContabilidadDefectoConstantesFunciones.LABEL_IDTIPODOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContabilidadDefectoConstantesFunciones.LABEL_IDESTADOASIENTOCONTABLE);
			reporte.setsDescripcion(ParametroContabilidadDefectoConstantesFunciones.LABEL_IDESTADOASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParametroContabilidadDefecto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParametroContabilidadDefecto(ParametroContabilidadDefecto parametrocontabilidaddefectoAux) throws Exception {
		
			parametrocontabilidaddefectoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrocontabilidaddefectoAux.getEmpresa()));
			parametrocontabilidaddefectoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametrocontabilidaddefectoAux.getSucursal()));
			parametrocontabilidaddefectoAux.settipomoneda_descripcion(TipoMonedaConstantesFunciones.getTipoMonedaDescripcion(parametrocontabilidaddefectoAux.getTipoMoneda()));
			parametrocontabilidaddefectoAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(parametrocontabilidaddefectoAux.getMoneda()));
			parametrocontabilidaddefectoAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(parametrocontabilidaddefectoAux.getModulo()));
			parametrocontabilidaddefectoAux.settipointervalo_descripcion(TipoIntervaloConstantesFunciones.getTipoIntervaloDescripcion(parametrocontabilidaddefectoAux.getTipoIntervalo()));
			parametrocontabilidaddefectoAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(parametrocontabilidaddefectoAux.getTipoMovimiento()));
			parametrocontabilidaddefectoAux.settipodocumento_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(parametrocontabilidaddefectoAux.getTipoDocumento()));
			parametrocontabilidaddefectoAux.setestadoasientocontable_descripcion(EstadoAsientoContableConstantesFunciones.getEstadoAsientoContableDescripcion(parametrocontabilidaddefectoAux.getEstadoAsientoContable()));		
	}
	
	public static void refrescarForeignKeysDescripcionesParametroContabilidadDefecto(List<ParametroContabilidadDefecto> parametrocontabilidaddefectosTemp) throws Exception {
		for(ParametroContabilidadDefecto parametrocontabilidaddefectoAux:parametrocontabilidaddefectosTemp) {
			
			parametrocontabilidaddefectoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrocontabilidaddefectoAux.getEmpresa()));
			parametrocontabilidaddefectoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametrocontabilidaddefectoAux.getSucursal()));
			parametrocontabilidaddefectoAux.settipomoneda_descripcion(TipoMonedaConstantesFunciones.getTipoMonedaDescripcion(parametrocontabilidaddefectoAux.getTipoMoneda()));
			parametrocontabilidaddefectoAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(parametrocontabilidaddefectoAux.getMoneda()));
			parametrocontabilidaddefectoAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(parametrocontabilidaddefectoAux.getModulo()));
			parametrocontabilidaddefectoAux.settipointervalo_descripcion(TipoIntervaloConstantesFunciones.getTipoIntervaloDescripcion(parametrocontabilidaddefectoAux.getTipoIntervalo()));
			parametrocontabilidaddefectoAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(parametrocontabilidaddefectoAux.getTipoMovimiento()));
			parametrocontabilidaddefectoAux.settipodocumento_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(parametrocontabilidaddefectoAux.getTipoDocumento()));
			parametrocontabilidaddefectoAux.setestadoasientocontable_descripcion(EstadoAsientoContableConstantesFunciones.getEstadoAsientoContableDescripcion(parametrocontabilidaddefectoAux.getEstadoAsientoContable()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParametroContabilidadDefecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(TipoMoneda.class));
				classes.add(new Classe(Moneda.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(TipoIntervalo.class));
				classes.add(new Classe(TipoMovimiento.class));
				classes.add(new Classe(TipoDocumento.class));
				classes.add(new Classe(EstadoAsientoContable.class));
				
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
					if(clas.clas.equals(TipoMoneda.class)) {
						classes.add(new Classe(TipoMoneda.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Moneda.class)) {
						classes.add(new Classe(Moneda.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoIntervalo.class)) {
						classes.add(new Classe(TipoIntervalo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoMovimiento.class)) {
						classes.add(new Classe(TipoMovimiento.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDocumento.class)) {
						classes.add(new Classe(TipoDocumento.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoAsientoContable.class)) {
						classes.add(new Classe(EstadoAsientoContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParametroContabilidadDefecto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(TipoMoneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMoneda.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(TipoIntervalo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIntervalo.class)); continue;
					}

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(EstadoAsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoAsientoContable.class)); continue;
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

					if(TipoMoneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMoneda.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(TipoIntervalo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIntervalo.class)); continue;
					}

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(EstadoAsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoAsientoContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroContabilidadDefecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroContabilidadDefectoConstantesFunciones.getClassesRelationshipsOfParametroContabilidadDefecto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroContabilidadDefecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroContabilidadDefecto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroContabilidadDefectoConstantesFunciones.getClassesRelationshipsFromStringsOfParametroContabilidadDefecto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroContabilidadDefecto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ParametroContabilidadDefecto parametrocontabilidaddefecto,List<ParametroContabilidadDefecto> parametrocontabilidaddefectos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ParametroContabilidadDefecto parametrocontabilidaddefectoEncontrado=null;
			
			for(ParametroContabilidadDefecto parametrocontabilidaddefectoLocal:parametrocontabilidaddefectos) {
				if(parametrocontabilidaddefectoLocal.getId().equals(parametrocontabilidaddefecto.getId())) {
					parametrocontabilidaddefectoEncontrado=parametrocontabilidaddefectoLocal;
					
					parametrocontabilidaddefectoLocal.setIsChanged(parametrocontabilidaddefecto.getIsChanged());
					parametrocontabilidaddefectoLocal.setIsNew(parametrocontabilidaddefecto.getIsNew());
					parametrocontabilidaddefectoLocal.setIsDeleted(parametrocontabilidaddefecto.getIsDeleted());
					
					parametrocontabilidaddefectoLocal.setGeneralEntityOriginal(parametrocontabilidaddefecto.getGeneralEntityOriginal());
					
					parametrocontabilidaddefectoLocal.setId(parametrocontabilidaddefecto.getId());	
					parametrocontabilidaddefectoLocal.setVersionRow(parametrocontabilidaddefecto.getVersionRow());	
					parametrocontabilidaddefectoLocal.setid_empresa(parametrocontabilidaddefecto.getid_empresa());	
					parametrocontabilidaddefectoLocal.setid_sucursal(parametrocontabilidaddefecto.getid_sucursal());	
					parametrocontabilidaddefectoLocal.setid_tipo_moneda(parametrocontabilidaddefecto.getid_tipo_moneda());	
					parametrocontabilidaddefectoLocal.setid_moneda(parametrocontabilidaddefecto.getid_moneda());	
					parametrocontabilidaddefectoLocal.setid_modulo(parametrocontabilidaddefecto.getid_modulo());	
					parametrocontabilidaddefectoLocal.setid_tipo_intervalo(parametrocontabilidaddefecto.getid_tipo_intervalo());	
					parametrocontabilidaddefectoLocal.setid_tipo_movimiento(parametrocontabilidaddefecto.getid_tipo_movimiento());	
					parametrocontabilidaddefectoLocal.setid_tipo_documento(parametrocontabilidaddefecto.getid_tipo_documento());	
					parametrocontabilidaddefectoLocal.setid_estado_asiento_contable(parametrocontabilidaddefecto.getid_estado_asiento_contable());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!parametrocontabilidaddefecto.getIsDeleted()) {
				if(!existe) {
					parametrocontabilidaddefectos.add(parametrocontabilidaddefecto);
				}
			} else {
				if(parametrocontabilidaddefectoEncontrado!=null && permiteQuitar)  {
					parametrocontabilidaddefectos.remove(parametrocontabilidaddefectoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ParametroContabilidadDefecto parametrocontabilidaddefecto,List<ParametroContabilidadDefecto> parametrocontabilidaddefectos) throws Exception {
		try	{			
			for(ParametroContabilidadDefecto parametrocontabilidaddefectoLocal:parametrocontabilidaddefectos) {
				if(parametrocontabilidaddefectoLocal.getId().equals(parametrocontabilidaddefecto.getId())) {
					parametrocontabilidaddefectoLocal.setIsSelected(parametrocontabilidaddefecto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParametroContabilidadDefecto(List<ParametroContabilidadDefecto> parametrocontabilidaddefectosAux) throws Exception {
		//this.parametrocontabilidaddefectosAux=parametrocontabilidaddefectosAux;
		
		for(ParametroContabilidadDefecto parametrocontabilidaddefectoAux:parametrocontabilidaddefectosAux) {
			if(parametrocontabilidaddefectoAux.getIsChanged()) {
				parametrocontabilidaddefectoAux.setIsChanged(false);
			}		
			
			if(parametrocontabilidaddefectoAux.getIsNew()) {
				parametrocontabilidaddefectoAux.setIsNew(false);
			}	
			
			if(parametrocontabilidaddefectoAux.getIsDeleted()) {
				parametrocontabilidaddefectoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParametroContabilidadDefecto(ParametroContabilidadDefecto parametrocontabilidaddefectoAux) throws Exception {
		//this.parametrocontabilidaddefectoAux=parametrocontabilidaddefectoAux;
		
			if(parametrocontabilidaddefectoAux.getIsChanged()) {
				parametrocontabilidaddefectoAux.setIsChanged(false);
			}		
			
			if(parametrocontabilidaddefectoAux.getIsNew()) {
				parametrocontabilidaddefectoAux.setIsNew(false);
			}	
			
			if(parametrocontabilidaddefectoAux.getIsDeleted()) {
				parametrocontabilidaddefectoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ParametroContabilidadDefecto parametrocontabilidaddefectoAsignar,ParametroContabilidadDefecto parametrocontabilidaddefecto) throws Exception {
		parametrocontabilidaddefectoAsignar.setId(parametrocontabilidaddefecto.getId());	
		parametrocontabilidaddefectoAsignar.setVersionRow(parametrocontabilidaddefecto.getVersionRow());	
		parametrocontabilidaddefectoAsignar.setid_empresa(parametrocontabilidaddefecto.getid_empresa());
		parametrocontabilidaddefectoAsignar.setempresa_descripcion(parametrocontabilidaddefecto.getempresa_descripcion());	
		parametrocontabilidaddefectoAsignar.setid_sucursal(parametrocontabilidaddefecto.getid_sucursal());
		parametrocontabilidaddefectoAsignar.setsucursal_descripcion(parametrocontabilidaddefecto.getsucursal_descripcion());	
		parametrocontabilidaddefectoAsignar.setid_tipo_moneda(parametrocontabilidaddefecto.getid_tipo_moneda());
		parametrocontabilidaddefectoAsignar.settipomoneda_descripcion(parametrocontabilidaddefecto.gettipomoneda_descripcion());	
		parametrocontabilidaddefectoAsignar.setid_moneda(parametrocontabilidaddefecto.getid_moneda());
		parametrocontabilidaddefectoAsignar.setmoneda_descripcion(parametrocontabilidaddefecto.getmoneda_descripcion());	
		parametrocontabilidaddefectoAsignar.setid_modulo(parametrocontabilidaddefecto.getid_modulo());
		parametrocontabilidaddefectoAsignar.setmodulo_descripcion(parametrocontabilidaddefecto.getmodulo_descripcion());	
		parametrocontabilidaddefectoAsignar.setid_tipo_intervalo(parametrocontabilidaddefecto.getid_tipo_intervalo());
		parametrocontabilidaddefectoAsignar.settipointervalo_descripcion(parametrocontabilidaddefecto.gettipointervalo_descripcion());	
		parametrocontabilidaddefectoAsignar.setid_tipo_movimiento(parametrocontabilidaddefecto.getid_tipo_movimiento());
		parametrocontabilidaddefectoAsignar.settipomovimiento_descripcion(parametrocontabilidaddefecto.gettipomovimiento_descripcion());	
		parametrocontabilidaddefectoAsignar.setid_tipo_documento(parametrocontabilidaddefecto.getid_tipo_documento());
		parametrocontabilidaddefectoAsignar.settipodocumento_descripcion(parametrocontabilidaddefecto.gettipodocumento_descripcion());	
		parametrocontabilidaddefectoAsignar.setid_estado_asiento_contable(parametrocontabilidaddefecto.getid_estado_asiento_contable());
		parametrocontabilidaddefectoAsignar.setestadoasientocontable_descripcion(parametrocontabilidaddefecto.getestadoasientocontable_descripcion());	
	}
	
	public static void inicializarParametroContabilidadDefecto(ParametroContabilidadDefecto parametrocontabilidaddefecto) throws Exception {
		try {
				parametrocontabilidaddefecto.setId(0L);	
					
				parametrocontabilidaddefecto.setid_empresa(-1L);	
				parametrocontabilidaddefecto.setid_sucursal(-1L);	
				parametrocontabilidaddefecto.setid_tipo_moneda(-1L);	
				parametrocontabilidaddefecto.setid_moneda(-1L);	
				parametrocontabilidaddefecto.setid_modulo(-1L);	
				parametrocontabilidaddefecto.setid_tipo_intervalo(-1L);	
				parametrocontabilidaddefecto.setid_tipo_movimiento(-1L);	
				parametrocontabilidaddefecto.setid_tipo_documento(-1L);	
				parametrocontabilidaddefecto.setid_estado_asiento_contable(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParametroContabilidadDefecto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContabilidadDefectoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContabilidadDefectoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContabilidadDefectoConstantesFunciones.LABEL_IDTIPOMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContabilidadDefectoConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContabilidadDefectoConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContabilidadDefectoConstantesFunciones.LABEL_IDTIPOINTERVALO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContabilidadDefectoConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContabilidadDefectoConstantesFunciones.LABEL_IDTIPODOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContabilidadDefectoConstantesFunciones.LABEL_IDESTADOASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParametroContabilidadDefecto(String sTipo,Row row,Workbook workbook,ParametroContabilidadDefecto parametrocontabilidaddefecto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocontabilidaddefecto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocontabilidaddefecto.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocontabilidaddefecto.gettipomoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocontabilidaddefecto.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocontabilidaddefecto.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocontabilidaddefecto.gettipointervalo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocontabilidaddefecto.gettipomovimiento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocontabilidaddefecto.gettipodocumento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrocontabilidaddefecto.getestadoasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParametroContabilidadDefecto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParametroContabilidadDefecto() {
		return this.sFinalQueryParametroContabilidadDefecto;
	}
	
	public void setsFinalQueryParametroContabilidadDefecto(String sFinalQueryParametroContabilidadDefecto) {
		this.sFinalQueryParametroContabilidadDefecto= sFinalQueryParametroContabilidadDefecto;
	}
	
	public Border resaltarSeleccionarParametroContabilidadDefecto=null;
	
	public Border setResaltarSeleccionarParametroContabilidadDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContabilidadDefectoBeanSwingJInternalFrame parametrocontabilidaddefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parametrocontabilidaddefectoBeanSwingJInternalFrame.jTtoolBarParametroContabilidadDefecto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParametroContabilidadDefecto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParametroContabilidadDefecto() {
		return this.resaltarSeleccionarParametroContabilidadDefecto;
	}
	
	public void setResaltarSeleccionarParametroContabilidadDefecto(Border borderResaltarSeleccionarParametroContabilidadDefecto) {
		this.resaltarSeleccionarParametroContabilidadDefecto= borderResaltarSeleccionarParametroContabilidadDefecto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParametroContabilidadDefecto=null;
	public Boolean mostraridParametroContabilidadDefecto=true;
	public Boolean activaridParametroContabilidadDefecto=true;

	public Border resaltarid_empresaParametroContabilidadDefecto=null;
	public Boolean mostrarid_empresaParametroContabilidadDefecto=true;
	public Boolean activarid_empresaParametroContabilidadDefecto=true;
	public Boolean cargarid_empresaParametroContabilidadDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaParametroContabilidadDefecto=false;//ConEventDepend=true

	public Border resaltarid_sucursalParametroContabilidadDefecto=null;
	public Boolean mostrarid_sucursalParametroContabilidadDefecto=true;
	public Boolean activarid_sucursalParametroContabilidadDefecto=true;
	public Boolean cargarid_sucursalParametroContabilidadDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalParametroContabilidadDefecto=false;//ConEventDepend=true

	public Border resaltarid_tipo_monedaParametroContabilidadDefecto=null;
	public Boolean mostrarid_tipo_monedaParametroContabilidadDefecto=true;
	public Boolean activarid_tipo_monedaParametroContabilidadDefecto=true;
	public Boolean cargarid_tipo_monedaParametroContabilidadDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_monedaParametroContabilidadDefecto=false;//ConEventDepend=true

	public Border resaltarid_monedaParametroContabilidadDefecto=null;
	public Boolean mostrarid_monedaParametroContabilidadDefecto=true;
	public Boolean activarid_monedaParametroContabilidadDefecto=true;
	public Boolean cargarid_monedaParametroContabilidadDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaParametroContabilidadDefecto=false;//ConEventDepend=true

	public Border resaltarid_moduloParametroContabilidadDefecto=null;
	public Boolean mostrarid_moduloParametroContabilidadDefecto=true;
	public Boolean activarid_moduloParametroContabilidadDefecto=true;
	public Boolean cargarid_moduloParametroContabilidadDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloParametroContabilidadDefecto=false;//ConEventDepend=true

	public Border resaltarid_tipo_intervaloParametroContabilidadDefecto=null;
	public Boolean mostrarid_tipo_intervaloParametroContabilidadDefecto=true;
	public Boolean activarid_tipo_intervaloParametroContabilidadDefecto=true;
	public Boolean cargarid_tipo_intervaloParametroContabilidadDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_intervaloParametroContabilidadDefecto=false;//ConEventDepend=true

	public Border resaltarid_tipo_movimientoParametroContabilidadDefecto=null;
	public Boolean mostrarid_tipo_movimientoParametroContabilidadDefecto=true;
	public Boolean activarid_tipo_movimientoParametroContabilidadDefecto=true;
	public Boolean cargarid_tipo_movimientoParametroContabilidadDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_movimientoParametroContabilidadDefecto=false;//ConEventDepend=true

	public Border resaltarid_tipo_documentoParametroContabilidadDefecto=null;
	public Boolean mostrarid_tipo_documentoParametroContabilidadDefecto=true;
	public Boolean activarid_tipo_documentoParametroContabilidadDefecto=true;
	public Boolean cargarid_tipo_documentoParametroContabilidadDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_documentoParametroContabilidadDefecto=false;//ConEventDepend=true

	public Border resaltarid_estado_asiento_contableParametroContabilidadDefecto=null;
	public Boolean mostrarid_estado_asiento_contableParametroContabilidadDefecto=true;
	public Boolean activarid_estado_asiento_contableParametroContabilidadDefecto=true;
	public Boolean cargarid_estado_asiento_contableParametroContabilidadDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_asiento_contableParametroContabilidadDefecto=false;//ConEventDepend=true

	
	

	public Border setResaltaridParametroContabilidadDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContabilidadDefectoBeanSwingJInternalFrame parametrocontabilidaddefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontabilidaddefectoBeanSwingJInternalFrame.jTtoolBarParametroContabilidadDefecto.setBorder(borderResaltar);
		
		this.resaltaridParametroContabilidadDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParametroContabilidadDefecto() {
		return this.resaltaridParametroContabilidadDefecto;
	}

	public void setResaltaridParametroContabilidadDefecto(Border borderResaltar) {
		this.resaltaridParametroContabilidadDefecto= borderResaltar;
	}

	public Boolean getMostraridParametroContabilidadDefecto() {
		return this.mostraridParametroContabilidadDefecto;
	}

	public void setMostraridParametroContabilidadDefecto(Boolean mostraridParametroContabilidadDefecto) {
		this.mostraridParametroContabilidadDefecto= mostraridParametroContabilidadDefecto;
	}

	public Boolean getActivaridParametroContabilidadDefecto() {
		return this.activaridParametroContabilidadDefecto;
	}

	public void setActivaridParametroContabilidadDefecto(Boolean activaridParametroContabilidadDefecto) {
		this.activaridParametroContabilidadDefecto= activaridParametroContabilidadDefecto;
	}

	public Border setResaltarid_empresaParametroContabilidadDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContabilidadDefectoBeanSwingJInternalFrame parametrocontabilidaddefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontabilidaddefectoBeanSwingJInternalFrame.jTtoolBarParametroContabilidadDefecto.setBorder(borderResaltar);
		
		this.resaltarid_empresaParametroContabilidadDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaParametroContabilidadDefecto() {
		return this.resaltarid_empresaParametroContabilidadDefecto;
	}

	public void setResaltarid_empresaParametroContabilidadDefecto(Border borderResaltar) {
		this.resaltarid_empresaParametroContabilidadDefecto= borderResaltar;
	}

	public Boolean getMostrarid_empresaParametroContabilidadDefecto() {
		return this.mostrarid_empresaParametroContabilidadDefecto;
	}

	public void setMostrarid_empresaParametroContabilidadDefecto(Boolean mostrarid_empresaParametroContabilidadDefecto) {
		this.mostrarid_empresaParametroContabilidadDefecto= mostrarid_empresaParametroContabilidadDefecto;
	}

	public Boolean getActivarid_empresaParametroContabilidadDefecto() {
		return this.activarid_empresaParametroContabilidadDefecto;
	}

	public void setActivarid_empresaParametroContabilidadDefecto(Boolean activarid_empresaParametroContabilidadDefecto) {
		this.activarid_empresaParametroContabilidadDefecto= activarid_empresaParametroContabilidadDefecto;
	}

	public Boolean getCargarid_empresaParametroContabilidadDefecto() {
		return this.cargarid_empresaParametroContabilidadDefecto;
	}

	public void setCargarid_empresaParametroContabilidadDefecto(Boolean cargarid_empresaParametroContabilidadDefecto) {
		this.cargarid_empresaParametroContabilidadDefecto= cargarid_empresaParametroContabilidadDefecto;
	}

	public Border setResaltarid_sucursalParametroContabilidadDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContabilidadDefectoBeanSwingJInternalFrame parametrocontabilidaddefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontabilidaddefectoBeanSwingJInternalFrame.jTtoolBarParametroContabilidadDefecto.setBorder(borderResaltar);
		
		this.resaltarid_sucursalParametroContabilidadDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalParametroContabilidadDefecto() {
		return this.resaltarid_sucursalParametroContabilidadDefecto;
	}

	public void setResaltarid_sucursalParametroContabilidadDefecto(Border borderResaltar) {
		this.resaltarid_sucursalParametroContabilidadDefecto= borderResaltar;
	}

	public Boolean getMostrarid_sucursalParametroContabilidadDefecto() {
		return this.mostrarid_sucursalParametroContabilidadDefecto;
	}

	public void setMostrarid_sucursalParametroContabilidadDefecto(Boolean mostrarid_sucursalParametroContabilidadDefecto) {
		this.mostrarid_sucursalParametroContabilidadDefecto= mostrarid_sucursalParametroContabilidadDefecto;
	}

	public Boolean getActivarid_sucursalParametroContabilidadDefecto() {
		return this.activarid_sucursalParametroContabilidadDefecto;
	}

	public void setActivarid_sucursalParametroContabilidadDefecto(Boolean activarid_sucursalParametroContabilidadDefecto) {
		this.activarid_sucursalParametroContabilidadDefecto= activarid_sucursalParametroContabilidadDefecto;
	}

	public Boolean getCargarid_sucursalParametroContabilidadDefecto() {
		return this.cargarid_sucursalParametroContabilidadDefecto;
	}

	public void setCargarid_sucursalParametroContabilidadDefecto(Boolean cargarid_sucursalParametroContabilidadDefecto) {
		this.cargarid_sucursalParametroContabilidadDefecto= cargarid_sucursalParametroContabilidadDefecto;
	}

	public Border setResaltarid_tipo_monedaParametroContabilidadDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContabilidadDefectoBeanSwingJInternalFrame parametrocontabilidaddefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontabilidaddefectoBeanSwingJInternalFrame.jTtoolBarParametroContabilidadDefecto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_monedaParametroContabilidadDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_monedaParametroContabilidadDefecto() {
		return this.resaltarid_tipo_monedaParametroContabilidadDefecto;
	}

	public void setResaltarid_tipo_monedaParametroContabilidadDefecto(Border borderResaltar) {
		this.resaltarid_tipo_monedaParametroContabilidadDefecto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_monedaParametroContabilidadDefecto() {
		return this.mostrarid_tipo_monedaParametroContabilidadDefecto;
	}

	public void setMostrarid_tipo_monedaParametroContabilidadDefecto(Boolean mostrarid_tipo_monedaParametroContabilidadDefecto) {
		this.mostrarid_tipo_monedaParametroContabilidadDefecto= mostrarid_tipo_monedaParametroContabilidadDefecto;
	}

	public Boolean getActivarid_tipo_monedaParametroContabilidadDefecto() {
		return this.activarid_tipo_monedaParametroContabilidadDefecto;
	}

	public void setActivarid_tipo_monedaParametroContabilidadDefecto(Boolean activarid_tipo_monedaParametroContabilidadDefecto) {
		this.activarid_tipo_monedaParametroContabilidadDefecto= activarid_tipo_monedaParametroContabilidadDefecto;
	}

	public Boolean getCargarid_tipo_monedaParametroContabilidadDefecto() {
		return this.cargarid_tipo_monedaParametroContabilidadDefecto;
	}

	public void setCargarid_tipo_monedaParametroContabilidadDefecto(Boolean cargarid_tipo_monedaParametroContabilidadDefecto) {
		this.cargarid_tipo_monedaParametroContabilidadDefecto= cargarid_tipo_monedaParametroContabilidadDefecto;
	}

	public Border setResaltarid_monedaParametroContabilidadDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContabilidadDefectoBeanSwingJInternalFrame parametrocontabilidaddefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontabilidaddefectoBeanSwingJInternalFrame.jTtoolBarParametroContabilidadDefecto.setBorder(borderResaltar);
		
		this.resaltarid_monedaParametroContabilidadDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaParametroContabilidadDefecto() {
		return this.resaltarid_monedaParametroContabilidadDefecto;
	}

	public void setResaltarid_monedaParametroContabilidadDefecto(Border borderResaltar) {
		this.resaltarid_monedaParametroContabilidadDefecto= borderResaltar;
	}

	public Boolean getMostrarid_monedaParametroContabilidadDefecto() {
		return this.mostrarid_monedaParametroContabilidadDefecto;
	}

	public void setMostrarid_monedaParametroContabilidadDefecto(Boolean mostrarid_monedaParametroContabilidadDefecto) {
		this.mostrarid_monedaParametroContabilidadDefecto= mostrarid_monedaParametroContabilidadDefecto;
	}

	public Boolean getActivarid_monedaParametroContabilidadDefecto() {
		return this.activarid_monedaParametroContabilidadDefecto;
	}

	public void setActivarid_monedaParametroContabilidadDefecto(Boolean activarid_monedaParametroContabilidadDefecto) {
		this.activarid_monedaParametroContabilidadDefecto= activarid_monedaParametroContabilidadDefecto;
	}

	public Boolean getCargarid_monedaParametroContabilidadDefecto() {
		return this.cargarid_monedaParametroContabilidadDefecto;
	}

	public void setCargarid_monedaParametroContabilidadDefecto(Boolean cargarid_monedaParametroContabilidadDefecto) {
		this.cargarid_monedaParametroContabilidadDefecto= cargarid_monedaParametroContabilidadDefecto;
	}

	public Border setResaltarid_moduloParametroContabilidadDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContabilidadDefectoBeanSwingJInternalFrame parametrocontabilidaddefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontabilidaddefectoBeanSwingJInternalFrame.jTtoolBarParametroContabilidadDefecto.setBorder(borderResaltar);
		
		this.resaltarid_moduloParametroContabilidadDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloParametroContabilidadDefecto() {
		return this.resaltarid_moduloParametroContabilidadDefecto;
	}

	public void setResaltarid_moduloParametroContabilidadDefecto(Border borderResaltar) {
		this.resaltarid_moduloParametroContabilidadDefecto= borderResaltar;
	}

	public Boolean getMostrarid_moduloParametroContabilidadDefecto() {
		return this.mostrarid_moduloParametroContabilidadDefecto;
	}

	public void setMostrarid_moduloParametroContabilidadDefecto(Boolean mostrarid_moduloParametroContabilidadDefecto) {
		this.mostrarid_moduloParametroContabilidadDefecto= mostrarid_moduloParametroContabilidadDefecto;
	}

	public Boolean getActivarid_moduloParametroContabilidadDefecto() {
		return this.activarid_moduloParametroContabilidadDefecto;
	}

	public void setActivarid_moduloParametroContabilidadDefecto(Boolean activarid_moduloParametroContabilidadDefecto) {
		this.activarid_moduloParametroContabilidadDefecto= activarid_moduloParametroContabilidadDefecto;
	}

	public Boolean getCargarid_moduloParametroContabilidadDefecto() {
		return this.cargarid_moduloParametroContabilidadDefecto;
	}

	public void setCargarid_moduloParametroContabilidadDefecto(Boolean cargarid_moduloParametroContabilidadDefecto) {
		this.cargarid_moduloParametroContabilidadDefecto= cargarid_moduloParametroContabilidadDefecto;
	}

	public Border setResaltarid_tipo_intervaloParametroContabilidadDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContabilidadDefectoBeanSwingJInternalFrame parametrocontabilidaddefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontabilidaddefectoBeanSwingJInternalFrame.jTtoolBarParametroContabilidadDefecto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_intervaloParametroContabilidadDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_intervaloParametroContabilidadDefecto() {
		return this.resaltarid_tipo_intervaloParametroContabilidadDefecto;
	}

	public void setResaltarid_tipo_intervaloParametroContabilidadDefecto(Border borderResaltar) {
		this.resaltarid_tipo_intervaloParametroContabilidadDefecto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_intervaloParametroContabilidadDefecto() {
		return this.mostrarid_tipo_intervaloParametroContabilidadDefecto;
	}

	public void setMostrarid_tipo_intervaloParametroContabilidadDefecto(Boolean mostrarid_tipo_intervaloParametroContabilidadDefecto) {
		this.mostrarid_tipo_intervaloParametroContabilidadDefecto= mostrarid_tipo_intervaloParametroContabilidadDefecto;
	}

	public Boolean getActivarid_tipo_intervaloParametroContabilidadDefecto() {
		return this.activarid_tipo_intervaloParametroContabilidadDefecto;
	}

	public void setActivarid_tipo_intervaloParametroContabilidadDefecto(Boolean activarid_tipo_intervaloParametroContabilidadDefecto) {
		this.activarid_tipo_intervaloParametroContabilidadDefecto= activarid_tipo_intervaloParametroContabilidadDefecto;
	}

	public Boolean getCargarid_tipo_intervaloParametroContabilidadDefecto() {
		return this.cargarid_tipo_intervaloParametroContabilidadDefecto;
	}

	public void setCargarid_tipo_intervaloParametroContabilidadDefecto(Boolean cargarid_tipo_intervaloParametroContabilidadDefecto) {
		this.cargarid_tipo_intervaloParametroContabilidadDefecto= cargarid_tipo_intervaloParametroContabilidadDefecto;
	}

	public Border setResaltarid_tipo_movimientoParametroContabilidadDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContabilidadDefectoBeanSwingJInternalFrame parametrocontabilidaddefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontabilidaddefectoBeanSwingJInternalFrame.jTtoolBarParametroContabilidadDefecto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_movimientoParametroContabilidadDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_movimientoParametroContabilidadDefecto() {
		return this.resaltarid_tipo_movimientoParametroContabilidadDefecto;
	}

	public void setResaltarid_tipo_movimientoParametroContabilidadDefecto(Border borderResaltar) {
		this.resaltarid_tipo_movimientoParametroContabilidadDefecto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_movimientoParametroContabilidadDefecto() {
		return this.mostrarid_tipo_movimientoParametroContabilidadDefecto;
	}

	public void setMostrarid_tipo_movimientoParametroContabilidadDefecto(Boolean mostrarid_tipo_movimientoParametroContabilidadDefecto) {
		this.mostrarid_tipo_movimientoParametroContabilidadDefecto= mostrarid_tipo_movimientoParametroContabilidadDefecto;
	}

	public Boolean getActivarid_tipo_movimientoParametroContabilidadDefecto() {
		return this.activarid_tipo_movimientoParametroContabilidadDefecto;
	}

	public void setActivarid_tipo_movimientoParametroContabilidadDefecto(Boolean activarid_tipo_movimientoParametroContabilidadDefecto) {
		this.activarid_tipo_movimientoParametroContabilidadDefecto= activarid_tipo_movimientoParametroContabilidadDefecto;
	}

	public Boolean getCargarid_tipo_movimientoParametroContabilidadDefecto() {
		return this.cargarid_tipo_movimientoParametroContabilidadDefecto;
	}

	public void setCargarid_tipo_movimientoParametroContabilidadDefecto(Boolean cargarid_tipo_movimientoParametroContabilidadDefecto) {
		this.cargarid_tipo_movimientoParametroContabilidadDefecto= cargarid_tipo_movimientoParametroContabilidadDefecto;
	}

	public Border setResaltarid_tipo_documentoParametroContabilidadDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContabilidadDefectoBeanSwingJInternalFrame parametrocontabilidaddefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontabilidaddefectoBeanSwingJInternalFrame.jTtoolBarParametroContabilidadDefecto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_documentoParametroContabilidadDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_documentoParametroContabilidadDefecto() {
		return this.resaltarid_tipo_documentoParametroContabilidadDefecto;
	}

	public void setResaltarid_tipo_documentoParametroContabilidadDefecto(Border borderResaltar) {
		this.resaltarid_tipo_documentoParametroContabilidadDefecto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_documentoParametroContabilidadDefecto() {
		return this.mostrarid_tipo_documentoParametroContabilidadDefecto;
	}

	public void setMostrarid_tipo_documentoParametroContabilidadDefecto(Boolean mostrarid_tipo_documentoParametroContabilidadDefecto) {
		this.mostrarid_tipo_documentoParametroContabilidadDefecto= mostrarid_tipo_documentoParametroContabilidadDefecto;
	}

	public Boolean getActivarid_tipo_documentoParametroContabilidadDefecto() {
		return this.activarid_tipo_documentoParametroContabilidadDefecto;
	}

	public void setActivarid_tipo_documentoParametroContabilidadDefecto(Boolean activarid_tipo_documentoParametroContabilidadDefecto) {
		this.activarid_tipo_documentoParametroContabilidadDefecto= activarid_tipo_documentoParametroContabilidadDefecto;
	}

	public Boolean getCargarid_tipo_documentoParametroContabilidadDefecto() {
		return this.cargarid_tipo_documentoParametroContabilidadDefecto;
	}

	public void setCargarid_tipo_documentoParametroContabilidadDefecto(Boolean cargarid_tipo_documentoParametroContabilidadDefecto) {
		this.cargarid_tipo_documentoParametroContabilidadDefecto= cargarid_tipo_documentoParametroContabilidadDefecto;
	}

	public Border setResaltarid_estado_asiento_contableParametroContabilidadDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContabilidadDefectoBeanSwingJInternalFrame parametrocontabilidaddefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontabilidaddefectoBeanSwingJInternalFrame.jTtoolBarParametroContabilidadDefecto.setBorder(borderResaltar);
		
		this.resaltarid_estado_asiento_contableParametroContabilidadDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_asiento_contableParametroContabilidadDefecto() {
		return this.resaltarid_estado_asiento_contableParametroContabilidadDefecto;
	}

	public void setResaltarid_estado_asiento_contableParametroContabilidadDefecto(Border borderResaltar) {
		this.resaltarid_estado_asiento_contableParametroContabilidadDefecto= borderResaltar;
	}

	public Boolean getMostrarid_estado_asiento_contableParametroContabilidadDefecto() {
		return this.mostrarid_estado_asiento_contableParametroContabilidadDefecto;
	}

	public void setMostrarid_estado_asiento_contableParametroContabilidadDefecto(Boolean mostrarid_estado_asiento_contableParametroContabilidadDefecto) {
		this.mostrarid_estado_asiento_contableParametroContabilidadDefecto= mostrarid_estado_asiento_contableParametroContabilidadDefecto;
	}

	public Boolean getActivarid_estado_asiento_contableParametroContabilidadDefecto() {
		return this.activarid_estado_asiento_contableParametroContabilidadDefecto;
	}

	public void setActivarid_estado_asiento_contableParametroContabilidadDefecto(Boolean activarid_estado_asiento_contableParametroContabilidadDefecto) {
		this.activarid_estado_asiento_contableParametroContabilidadDefecto= activarid_estado_asiento_contableParametroContabilidadDefecto;
	}

	public Boolean getCargarid_estado_asiento_contableParametroContabilidadDefecto() {
		return this.cargarid_estado_asiento_contableParametroContabilidadDefecto;
	}

	public void setCargarid_estado_asiento_contableParametroContabilidadDefecto(Boolean cargarid_estado_asiento_contableParametroContabilidadDefecto) {
		this.cargarid_estado_asiento_contableParametroContabilidadDefecto= cargarid_estado_asiento_contableParametroContabilidadDefecto;
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
		
		
		this.setMostraridParametroContabilidadDefecto(esInicial);
		this.setMostrarid_empresaParametroContabilidadDefecto(esInicial);
		this.setMostrarid_sucursalParametroContabilidadDefecto(esInicial);
		this.setMostrarid_tipo_monedaParametroContabilidadDefecto(esInicial);
		this.setMostrarid_monedaParametroContabilidadDefecto(esInicial);
		this.setMostrarid_moduloParametroContabilidadDefecto(esInicial);
		this.setMostrarid_tipo_intervaloParametroContabilidadDefecto(esInicial);
		this.setMostrarid_tipo_movimientoParametroContabilidadDefecto(esInicial);
		this.setMostrarid_tipo_documentoParametroContabilidadDefecto(esInicial);
		this.setMostrarid_estado_asiento_contableParametroContabilidadDefecto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroContabilidadDefectoConstantesFunciones.ID)) {
				this.setMostraridParametroContabilidadDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContabilidadDefectoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaParametroContabilidadDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContabilidadDefectoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalParametroContabilidadDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContabilidadDefectoConstantesFunciones.IDTIPOMONEDA)) {
				this.setMostrarid_tipo_monedaParametroContabilidadDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContabilidadDefectoConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaParametroContabilidadDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContabilidadDefectoConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloParametroContabilidadDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContabilidadDefectoConstantesFunciones.IDTIPOINTERVALO)) {
				this.setMostrarid_tipo_intervaloParametroContabilidadDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContabilidadDefectoConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setMostrarid_tipo_movimientoParametroContabilidadDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContabilidadDefectoConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setMostrarid_tipo_documentoParametroContabilidadDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContabilidadDefectoConstantesFunciones.IDESTADOASIENTOCONTABLE)) {
				this.setMostrarid_estado_asiento_contableParametroContabilidadDefecto(esAsigna);
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
		
		
		this.setActivaridParametroContabilidadDefecto(esInicial);
		this.setActivarid_empresaParametroContabilidadDefecto(esInicial);
		this.setActivarid_sucursalParametroContabilidadDefecto(esInicial);
		this.setActivarid_tipo_monedaParametroContabilidadDefecto(esInicial);
		this.setActivarid_monedaParametroContabilidadDefecto(esInicial);
		this.setActivarid_moduloParametroContabilidadDefecto(esInicial);
		this.setActivarid_tipo_intervaloParametroContabilidadDefecto(esInicial);
		this.setActivarid_tipo_movimientoParametroContabilidadDefecto(esInicial);
		this.setActivarid_tipo_documentoParametroContabilidadDefecto(esInicial);
		this.setActivarid_estado_asiento_contableParametroContabilidadDefecto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroContabilidadDefectoConstantesFunciones.ID)) {
				this.setActivaridParametroContabilidadDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContabilidadDefectoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaParametroContabilidadDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContabilidadDefectoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalParametroContabilidadDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContabilidadDefectoConstantesFunciones.IDTIPOMONEDA)) {
				this.setActivarid_tipo_monedaParametroContabilidadDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContabilidadDefectoConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaParametroContabilidadDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContabilidadDefectoConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloParametroContabilidadDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContabilidadDefectoConstantesFunciones.IDTIPOINTERVALO)) {
				this.setActivarid_tipo_intervaloParametroContabilidadDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContabilidadDefectoConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setActivarid_tipo_movimientoParametroContabilidadDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContabilidadDefectoConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setActivarid_tipo_documentoParametroContabilidadDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContabilidadDefectoConstantesFunciones.IDESTADOASIENTOCONTABLE)) {
				this.setActivarid_estado_asiento_contableParametroContabilidadDefecto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroContabilidadDefectoBeanSwingJInternalFrame parametrocontabilidaddefectoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParametroContabilidadDefecto(esInicial);
		this.setResaltarid_empresaParametroContabilidadDefecto(esInicial);
		this.setResaltarid_sucursalParametroContabilidadDefecto(esInicial);
		this.setResaltarid_tipo_monedaParametroContabilidadDefecto(esInicial);
		this.setResaltarid_monedaParametroContabilidadDefecto(esInicial);
		this.setResaltarid_moduloParametroContabilidadDefecto(esInicial);
		this.setResaltarid_tipo_intervaloParametroContabilidadDefecto(esInicial);
		this.setResaltarid_tipo_movimientoParametroContabilidadDefecto(esInicial);
		this.setResaltarid_tipo_documentoParametroContabilidadDefecto(esInicial);
		this.setResaltarid_estado_asiento_contableParametroContabilidadDefecto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroContabilidadDefectoConstantesFunciones.ID)) {
				this.setResaltaridParametroContabilidadDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContabilidadDefectoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaParametroContabilidadDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContabilidadDefectoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalParametroContabilidadDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContabilidadDefectoConstantesFunciones.IDTIPOMONEDA)) {
				this.setResaltarid_tipo_monedaParametroContabilidadDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContabilidadDefectoConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaParametroContabilidadDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContabilidadDefectoConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloParametroContabilidadDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContabilidadDefectoConstantesFunciones.IDTIPOINTERVALO)) {
				this.setResaltarid_tipo_intervaloParametroContabilidadDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContabilidadDefectoConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setResaltarid_tipo_movimientoParametroContabilidadDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContabilidadDefectoConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setResaltarid_tipo_documentoParametroContabilidadDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContabilidadDefectoConstantesFunciones.IDESTADOASIENTOCONTABLE)) {
				this.setResaltarid_estado_asiento_contableParametroContabilidadDefecto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroContabilidadDefectoBeanSwingJInternalFrame parametrocontabilidaddefectoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaParametroContabilidadDefecto=true;

	public Boolean getMostrarFK_IdEmpresaParametroContabilidadDefecto() {
		return this.mostrarFK_IdEmpresaParametroContabilidadDefecto;
	}

	public void setMostrarFK_IdEmpresaParametroContabilidadDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaParametroContabilidadDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoAsientoContableParametroContabilidadDefecto=true;

	public Boolean getMostrarFK_IdEstadoAsientoContableParametroContabilidadDefecto() {
		return this.mostrarFK_IdEstadoAsientoContableParametroContabilidadDefecto;
	}

	public void setMostrarFK_IdEstadoAsientoContableParametroContabilidadDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoAsientoContableParametroContabilidadDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloParametroContabilidadDefecto=true;

	public Boolean getMostrarFK_IdModuloParametroContabilidadDefecto() {
		return this.mostrarFK_IdModuloParametroContabilidadDefecto;
	}

	public void setMostrarFK_IdModuloParametroContabilidadDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloParametroContabilidadDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMonedaParametroContabilidadDefecto=true;

	public Boolean getMostrarFK_IdMonedaParametroContabilidadDefecto() {
		return this.mostrarFK_IdMonedaParametroContabilidadDefecto;
	}

	public void setMostrarFK_IdMonedaParametroContabilidadDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMonedaParametroContabilidadDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalParametroContabilidadDefecto=true;

	public Boolean getMostrarFK_IdSucursalParametroContabilidadDefecto() {
		return this.mostrarFK_IdSucursalParametroContabilidadDefecto;
	}

	public void setMostrarFK_IdSucursalParametroContabilidadDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalParametroContabilidadDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoDocumentoParametroContabilidadDefecto=true;

	public Boolean getMostrarFK_IdTipoDocumentoParametroContabilidadDefecto() {
		return this.mostrarFK_IdTipoDocumentoParametroContabilidadDefecto;
	}

	public void setMostrarFK_IdTipoDocumentoParametroContabilidadDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoDocumentoParametroContabilidadDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoIntervaloParametroContabilidadDefecto=true;

	public Boolean getMostrarFK_IdTipoIntervaloParametroContabilidadDefecto() {
		return this.mostrarFK_IdTipoIntervaloParametroContabilidadDefecto;
	}

	public void setMostrarFK_IdTipoIntervaloParametroContabilidadDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoIntervaloParametroContabilidadDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoMonedaParametroContabilidadDefecto=true;

	public Boolean getMostrarFK_IdTipoMonedaParametroContabilidadDefecto() {
		return this.mostrarFK_IdTipoMonedaParametroContabilidadDefecto;
	}

	public void setMostrarFK_IdTipoMonedaParametroContabilidadDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoMonedaParametroContabilidadDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoMovimientoParametroContabilidadDefecto=true;

	public Boolean getMostrarFK_IdTipoMovimientoParametroContabilidadDefecto() {
		return this.mostrarFK_IdTipoMovimientoParametroContabilidadDefecto;
	}

	public void setMostrarFK_IdTipoMovimientoParametroContabilidadDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoMovimientoParametroContabilidadDefecto= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaParametroContabilidadDefecto=true;

	public Boolean getActivarFK_IdEmpresaParametroContabilidadDefecto() {
		return this.activarFK_IdEmpresaParametroContabilidadDefecto;
	}

	public void setActivarFK_IdEmpresaParametroContabilidadDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaParametroContabilidadDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoAsientoContableParametroContabilidadDefecto=true;

	public Boolean getActivarFK_IdEstadoAsientoContableParametroContabilidadDefecto() {
		return this.activarFK_IdEstadoAsientoContableParametroContabilidadDefecto;
	}

	public void setActivarFK_IdEstadoAsientoContableParametroContabilidadDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoAsientoContableParametroContabilidadDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloParametroContabilidadDefecto=true;

	public Boolean getActivarFK_IdModuloParametroContabilidadDefecto() {
		return this.activarFK_IdModuloParametroContabilidadDefecto;
	}

	public void setActivarFK_IdModuloParametroContabilidadDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdModuloParametroContabilidadDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdMonedaParametroContabilidadDefecto=true;

	public Boolean getActivarFK_IdMonedaParametroContabilidadDefecto() {
		return this.activarFK_IdMonedaParametroContabilidadDefecto;
	}

	public void setActivarFK_IdMonedaParametroContabilidadDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdMonedaParametroContabilidadDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalParametroContabilidadDefecto=true;

	public Boolean getActivarFK_IdSucursalParametroContabilidadDefecto() {
		return this.activarFK_IdSucursalParametroContabilidadDefecto;
	}

	public void setActivarFK_IdSucursalParametroContabilidadDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalParametroContabilidadDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoDocumentoParametroContabilidadDefecto=true;

	public Boolean getActivarFK_IdTipoDocumentoParametroContabilidadDefecto() {
		return this.activarFK_IdTipoDocumentoParametroContabilidadDefecto;
	}

	public void setActivarFK_IdTipoDocumentoParametroContabilidadDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoDocumentoParametroContabilidadDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoIntervaloParametroContabilidadDefecto=true;

	public Boolean getActivarFK_IdTipoIntervaloParametroContabilidadDefecto() {
		return this.activarFK_IdTipoIntervaloParametroContabilidadDefecto;
	}

	public void setActivarFK_IdTipoIntervaloParametroContabilidadDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoIntervaloParametroContabilidadDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoMonedaParametroContabilidadDefecto=true;

	public Boolean getActivarFK_IdTipoMonedaParametroContabilidadDefecto() {
		return this.activarFK_IdTipoMonedaParametroContabilidadDefecto;
	}

	public void setActivarFK_IdTipoMonedaParametroContabilidadDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoMonedaParametroContabilidadDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoMovimientoParametroContabilidadDefecto=true;

	public Boolean getActivarFK_IdTipoMovimientoParametroContabilidadDefecto() {
		return this.activarFK_IdTipoMovimientoParametroContabilidadDefecto;
	}

	public void setActivarFK_IdTipoMovimientoParametroContabilidadDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoMovimientoParametroContabilidadDefecto= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaParametroContabilidadDefecto=null;

	public Border getResaltarFK_IdEmpresaParametroContabilidadDefecto() {
		return this.resaltarFK_IdEmpresaParametroContabilidadDefecto;
	}

	public void setResaltarFK_IdEmpresaParametroContabilidadDefecto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaParametroContabilidadDefecto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaParametroContabilidadDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContabilidadDefectoBeanSwingJInternalFrame parametrocontabilidaddefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaParametroContabilidadDefecto= borderResaltar;
	}

	public Border resaltarFK_IdEstadoAsientoContableParametroContabilidadDefecto=null;

	public Border getResaltarFK_IdEstadoAsientoContableParametroContabilidadDefecto() {
		return this.resaltarFK_IdEstadoAsientoContableParametroContabilidadDefecto;
	}

	public void setResaltarFK_IdEstadoAsientoContableParametroContabilidadDefecto(Border borderResaltar) {
		this.resaltarFK_IdEstadoAsientoContableParametroContabilidadDefecto= borderResaltar;
	}

	public void setResaltarFK_IdEstadoAsientoContableParametroContabilidadDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContabilidadDefectoBeanSwingJInternalFrame parametrocontabilidaddefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoAsientoContableParametroContabilidadDefecto= borderResaltar;
	}

	public Border resaltarFK_IdModuloParametroContabilidadDefecto=null;

	public Border getResaltarFK_IdModuloParametroContabilidadDefecto() {
		return this.resaltarFK_IdModuloParametroContabilidadDefecto;
	}

	public void setResaltarFK_IdModuloParametroContabilidadDefecto(Border borderResaltar) {
		this.resaltarFK_IdModuloParametroContabilidadDefecto= borderResaltar;
	}

	public void setResaltarFK_IdModuloParametroContabilidadDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContabilidadDefectoBeanSwingJInternalFrame parametrocontabilidaddefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloParametroContabilidadDefecto= borderResaltar;
	}

	public Border resaltarFK_IdMonedaParametroContabilidadDefecto=null;

	public Border getResaltarFK_IdMonedaParametroContabilidadDefecto() {
		return this.resaltarFK_IdMonedaParametroContabilidadDefecto;
	}

	public void setResaltarFK_IdMonedaParametroContabilidadDefecto(Border borderResaltar) {
		this.resaltarFK_IdMonedaParametroContabilidadDefecto= borderResaltar;
	}

	public void setResaltarFK_IdMonedaParametroContabilidadDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContabilidadDefectoBeanSwingJInternalFrame parametrocontabilidaddefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMonedaParametroContabilidadDefecto= borderResaltar;
	}

	public Border resaltarFK_IdSucursalParametroContabilidadDefecto=null;

	public Border getResaltarFK_IdSucursalParametroContabilidadDefecto() {
		return this.resaltarFK_IdSucursalParametroContabilidadDefecto;
	}

	public void setResaltarFK_IdSucursalParametroContabilidadDefecto(Border borderResaltar) {
		this.resaltarFK_IdSucursalParametroContabilidadDefecto= borderResaltar;
	}

	public void setResaltarFK_IdSucursalParametroContabilidadDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContabilidadDefectoBeanSwingJInternalFrame parametrocontabilidaddefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalParametroContabilidadDefecto= borderResaltar;
	}

	public Border resaltarFK_IdTipoDocumentoParametroContabilidadDefecto=null;

	public Border getResaltarFK_IdTipoDocumentoParametroContabilidadDefecto() {
		return this.resaltarFK_IdTipoDocumentoParametroContabilidadDefecto;
	}

	public void setResaltarFK_IdTipoDocumentoParametroContabilidadDefecto(Border borderResaltar) {
		this.resaltarFK_IdTipoDocumentoParametroContabilidadDefecto= borderResaltar;
	}

	public void setResaltarFK_IdTipoDocumentoParametroContabilidadDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContabilidadDefectoBeanSwingJInternalFrame parametrocontabilidaddefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoDocumentoParametroContabilidadDefecto= borderResaltar;
	}

	public Border resaltarFK_IdTipoIntervaloParametroContabilidadDefecto=null;

	public Border getResaltarFK_IdTipoIntervaloParametroContabilidadDefecto() {
		return this.resaltarFK_IdTipoIntervaloParametroContabilidadDefecto;
	}

	public void setResaltarFK_IdTipoIntervaloParametroContabilidadDefecto(Border borderResaltar) {
		this.resaltarFK_IdTipoIntervaloParametroContabilidadDefecto= borderResaltar;
	}

	public void setResaltarFK_IdTipoIntervaloParametroContabilidadDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContabilidadDefectoBeanSwingJInternalFrame parametrocontabilidaddefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoIntervaloParametroContabilidadDefecto= borderResaltar;
	}

	public Border resaltarFK_IdTipoMonedaParametroContabilidadDefecto=null;

	public Border getResaltarFK_IdTipoMonedaParametroContabilidadDefecto() {
		return this.resaltarFK_IdTipoMonedaParametroContabilidadDefecto;
	}

	public void setResaltarFK_IdTipoMonedaParametroContabilidadDefecto(Border borderResaltar) {
		this.resaltarFK_IdTipoMonedaParametroContabilidadDefecto= borderResaltar;
	}

	public void setResaltarFK_IdTipoMonedaParametroContabilidadDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContabilidadDefectoBeanSwingJInternalFrame parametrocontabilidaddefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoMonedaParametroContabilidadDefecto= borderResaltar;
	}

	public Border resaltarFK_IdTipoMovimientoParametroContabilidadDefecto=null;

	public Border getResaltarFK_IdTipoMovimientoParametroContabilidadDefecto() {
		return this.resaltarFK_IdTipoMovimientoParametroContabilidadDefecto;
	}

	public void setResaltarFK_IdTipoMovimientoParametroContabilidadDefecto(Border borderResaltar) {
		this.resaltarFK_IdTipoMovimientoParametroContabilidadDefecto= borderResaltar;
	}

	public void setResaltarFK_IdTipoMovimientoParametroContabilidadDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContabilidadDefectoBeanSwingJInternalFrame parametrocontabilidaddefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoMovimientoParametroContabilidadDefecto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}