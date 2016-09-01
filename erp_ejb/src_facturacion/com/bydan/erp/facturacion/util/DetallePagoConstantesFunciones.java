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


import com.bydan.erp.facturacion.util.DetallePagoConstantesFunciones;
import com.bydan.erp.facturacion.util.DetallePagoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.DetallePagoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetallePagoConstantesFunciones extends DetallePagoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetallePago";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetallePago"+DetallePagoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetallePagoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetallePagoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetallePagoConstantesFunciones.SCHEMA+"_"+DetallePagoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetallePagoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetallePagoConstantesFunciones.SCHEMA+"_"+DetallePagoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetallePagoConstantesFunciones.SCHEMA+"_"+DetallePagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetallePagoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetallePagoConstantesFunciones.SCHEMA+"_"+DetallePagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePagoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetallePagoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePagoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetallePagoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetallePagoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetallePagoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetallePagoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetallePagoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Pagos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Pago";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Pago";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetallePago";
	public static final String OBJECTNAME="detallepago";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="detalle_pago";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detallepago from "+DetallePagoConstantesFunciones.SPERSISTENCENAME+" detallepago";
	public static String QUERYSELECTNATIVE="select "+DetallePagoConstantesFunciones.SCHEMA+"."+DetallePagoConstantesFunciones.TABLENAME+".id,"+DetallePagoConstantesFunciones.SCHEMA+"."+DetallePagoConstantesFunciones.TABLENAME+".version_row,"+DetallePagoConstantesFunciones.SCHEMA+"."+DetallePagoConstantesFunciones.TABLENAME+".id_empresa,"+DetallePagoConstantesFunciones.SCHEMA+"."+DetallePagoConstantesFunciones.TABLENAME+".id_sucursal,"+DetallePagoConstantesFunciones.SCHEMA+"."+DetallePagoConstantesFunciones.TABLENAME+".id_ejercicio,"+DetallePagoConstantesFunciones.SCHEMA+"."+DetallePagoConstantesFunciones.TABLENAME+".id_periodo,"+DetallePagoConstantesFunciones.SCHEMA+"."+DetallePagoConstantesFunciones.TABLENAME+".id_asiento_contable,"+DetallePagoConstantesFunciones.SCHEMA+"."+DetallePagoConstantesFunciones.TABLENAME+".id_tipo_forma_pago,"+DetallePagoConstantesFunciones.SCHEMA+"."+DetallePagoConstantesFunciones.TABLENAME+".valor,"+DetallePagoConstantesFunciones.SCHEMA+"."+DetallePagoConstantesFunciones.TABLENAME+".numero_fila,"+DetallePagoConstantesFunciones.SCHEMA+"."+DetallePagoConstantesFunciones.TABLENAME+".id_anio,"+DetallePagoConstantesFunciones.SCHEMA+"."+DetallePagoConstantesFunciones.TABLENAME+".id_mes from "+DetallePagoConstantesFunciones.SCHEMA+"."+DetallePagoConstantesFunciones.TABLENAME;//+" as "+DetallePagoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetallePagoConstantesFuncionesAdditional detallepagoConstantesFuncionesAdditional=null;
	
	public DetallePagoConstantesFuncionesAdditional getDetallePagoConstantesFuncionesAdditional() {
		return this.detallepagoConstantesFuncionesAdditional;
	}
	
	public void setDetallePagoConstantesFuncionesAdditional(DetallePagoConstantesFuncionesAdditional detallepagoConstantesFuncionesAdditional) {
		try {
			this.detallepagoConstantesFuncionesAdditional=detallepagoConstantesFuncionesAdditional;
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
    public static final String IDASIENTOCONTABLE= "id_asiento_contable";
    public static final String IDTIPOFORMAPAGO= "id_tipo_forma_pago";
    public static final String VALOR= "valor";
    public static final String NUMEROFILA= "numero_fila";
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
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDASIENTOCONTABLE= "Asiento Contable";
		public static final String LABEL_IDASIENTOCONTABLE_LOWER= "Asiento Contable";
    	public static final String LABEL_IDTIPOFORMAPAGO= "Tipo Forma Pago";
		public static final String LABEL_IDTIPOFORMAPAGO_LOWER= "Tipo Forma Pago";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_NUMEROFILA= "Numero Fila";
		public static final String LABEL_NUMEROFILA_LOWER= "Numero Fila";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
	
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getDetallePagoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetallePagoConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetallePagoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetallePagoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetallePagoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetallePagoConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetallePagoConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetallePagoConstantesFunciones.IDPERIODO)) {sLabelColumna=DetallePagoConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DetallePagoConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=DetallePagoConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		if(sNombreColumna.equals(DetallePagoConstantesFunciones.IDTIPOFORMAPAGO)) {sLabelColumna=DetallePagoConstantesFunciones.LABEL_IDTIPOFORMAPAGO;}
		if(sNombreColumna.equals(DetallePagoConstantesFunciones.VALOR)) {sLabelColumna=DetallePagoConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(DetallePagoConstantesFunciones.NUMEROFILA)) {sLabelColumna=DetallePagoConstantesFunciones.LABEL_NUMEROFILA;}
		if(sNombreColumna.equals(DetallePagoConstantesFunciones.IDANIO)) {sLabelColumna=DetallePagoConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DetallePagoConstantesFunciones.IDMES)) {sLabelColumna=DetallePagoConstantesFunciones.LABEL_IDMES;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetallePagoDescripcion(DetallePago detallepago) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detallepago !=null/* && detallepago.getId()!=0*/) {
			if(detallepago.getId()!=null) {
				sDescripcion=detallepago.getId().toString();
			}//detallepagodetallepago.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetallePagoDescripcionDetallado(DetallePago detallepago) {
		String sDescripcion="";
			
		sDescripcion+=DetallePagoConstantesFunciones.ID+"=";
		sDescripcion+=detallepago.getId().toString()+",";
		sDescripcion+=DetallePagoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detallepago.getVersionRow().toString()+",";
		sDescripcion+=DetallePagoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detallepago.getid_empresa().toString()+",";
		sDescripcion+=DetallePagoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detallepago.getid_sucursal().toString()+",";
		sDescripcion+=DetallePagoConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detallepago.getid_ejercicio().toString()+",";
		sDescripcion+=DetallePagoConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=detallepago.getid_periodo().toString()+",";
		sDescripcion+=DetallePagoConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=detallepago.getid_asiento_contable().toString()+",";
		sDescripcion+=DetallePagoConstantesFunciones.IDTIPOFORMAPAGO+"=";
		sDescripcion+=detallepago.getid_tipo_forma_pago().toString()+",";
		sDescripcion+=DetallePagoConstantesFunciones.VALOR+"=";
		sDescripcion+=detallepago.getvalor().toString()+",";
		sDescripcion+=DetallePagoConstantesFunciones.NUMEROFILA+"=";
		sDescripcion+=detallepago.getnumero_fila().toString()+",";
		sDescripcion+=DetallePagoConstantesFunciones.IDANIO+"=";
		sDescripcion+=detallepago.getid_anio().toString()+",";
		sDescripcion+=DetallePagoConstantesFunciones.IDMES+"=";
		sDescripcion+=detallepago.getid_mes().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDetallePagoDescripcion(DetallePago detallepago,String sValor) throws Exception {			
		if(detallepago !=null) {
			//detallepagodetallepago.getId().toString();
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

	public static String getAsientoContableDescripcion(AsientoContable asientocontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(asientocontable!=null/*&&asientocontable.getId()>0*/) {
			sDescripcion=AsientoContableConstantesFunciones.getAsientoContableDescripcion(asientocontable);
		}

		return sDescripcion;
	}

	public static String getTipoFormaPagoDescripcion(TipoFormaPago tipoformapago) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoformapago!=null/*&&tipoformapago.getId()>0*/) {
			sDescripcion=TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(tipoformapago);
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
		} else if(sNombreIndice.equals("FK_IdAsientoContable")) {
			sNombreIndice="Tipo=  Por Asiento Contable";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoFormaPago")) {
			sNombreIndice="Tipo=  Por Tipo Forma Pago";
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

	public static String getDetalleIndiceFK_IdAsientoContable(Long id_asiento_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_asiento_contable!=null) {sDetalleIndice+=" Codigo Unico De Asiento Contable="+id_asiento_contable.toString();} 

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

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoFormaPago(Long id_tipo_forma_pago) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_forma_pago!=null) {sDetalleIndice+=" Codigo Unico De Tipo Forma Pago="+id_tipo_forma_pago.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetallePago(DetallePago detallepago,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosDetallePagos(List<DetallePago> detallepagos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetallePago detallepago: detallepagos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetallePago(DetallePago detallepago,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detallepago.getConCambioAuxiliar()) {
			detallepago.setIsDeleted(detallepago.getIsDeletedAuxiliar());	
			detallepago.setIsNew(detallepago.getIsNewAuxiliar());	
			detallepago.setIsChanged(detallepago.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detallepago.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detallepago.setIsDeletedAuxiliar(false);	
			detallepago.setIsNewAuxiliar(false);	
			detallepago.setIsChangedAuxiliar(false);
			
			detallepago.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetallePagos(List<DetallePago> detallepagos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetallePago detallepago : detallepagos) {
			if(conAsignarBase && detallepago.getConCambioAuxiliar()) {
				detallepago.setIsDeleted(detallepago.getIsDeletedAuxiliar());	
				detallepago.setIsNew(detallepago.getIsNewAuxiliar());	
				detallepago.setIsChanged(detallepago.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detallepago.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detallepago.setIsDeletedAuxiliar(false);	
				detallepago.setIsNewAuxiliar(false);	
				detallepago.setIsChangedAuxiliar(false);
				
				detallepago.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetallePago(DetallePago detallepago,Boolean conEnteros) throws Exception  {
		detallepago.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			detallepago.setnumero_fila(0);
		}
	}		
	
	public static void InicializarValoresDetallePagos(List<DetallePago> detallepagos,Boolean conEnteros) throws Exception  {
		
		for(DetallePago detallepago: detallepagos) {
			detallepago.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				detallepago.setnumero_fila(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetallePago(List<DetallePago> detallepagos,DetallePago detallepagoAux) throws Exception  {
		DetallePagoConstantesFunciones.InicializarValoresDetallePago(detallepagoAux,true);
		
		for(DetallePago detallepago: detallepagos) {
			if(detallepago.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detallepagoAux.setvalor(detallepagoAux.getvalor()+detallepago.getvalor());			
			detallepagoAux.setnumero_fila(detallepagoAux.getnumero_fila()+detallepago.getnumero_fila());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetallePago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetallePagoConstantesFunciones.getArrayColumnasGlobalesDetallePago(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetallePago(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePagoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePagoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePagoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePagoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePagoConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePagoConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePagoConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePagoConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetallePago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetallePago> detallepagos,DetallePago detallepago,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetallePago detallepagoAux: detallepagos) {
			if(detallepagoAux!=null && detallepago!=null) {
				if((detallepagoAux.getId()==null && detallepago.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detallepagoAux.getId()!=null && detallepago.getId()!=null){
					if(detallepagoAux.getId().equals(detallepago.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetallePago(List<DetallePago> detallepagos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(DetallePago detallepago: detallepagos) {			
			if(detallepago.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=detallepago.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePagoConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(DetallePagoConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetallePago() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetallePagoConstantesFunciones.LABEL_ID, DetallePagoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePagoConstantesFunciones.LABEL_VERSIONROW, DetallePagoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePagoConstantesFunciones.LABEL_IDEMPRESA, DetallePagoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePagoConstantesFunciones.LABEL_IDSUCURSAL, DetallePagoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePagoConstantesFunciones.LABEL_IDEJERCICIO, DetallePagoConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePagoConstantesFunciones.LABEL_IDPERIODO, DetallePagoConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePagoConstantesFunciones.LABEL_IDASIENTOCONTABLE, DetallePagoConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePagoConstantesFunciones.LABEL_IDTIPOFORMAPAGO, DetallePagoConstantesFunciones.IDTIPOFORMAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePagoConstantesFunciones.LABEL_VALOR, DetallePagoConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePagoConstantesFunciones.LABEL_NUMEROFILA, DetallePagoConstantesFunciones.NUMEROFILA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePagoConstantesFunciones.LABEL_IDANIO, DetallePagoConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePagoConstantesFunciones.LABEL_IDMES, DetallePagoConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetallePago() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetallePagoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePagoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePagoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePagoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePagoConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePagoConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePagoConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePagoConstantesFunciones.IDTIPOFORMAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePagoConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePagoConstantesFunciones.NUMEROFILA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePagoConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePagoConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetallePago() throws Exception  {
		return DetallePagoConstantesFunciones.getTiposSeleccionarDetallePago(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetallePago(Boolean conFk) throws Exception  {
		return DetallePagoConstantesFunciones.getTiposSeleccionarDetallePago(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetallePago(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetallePagoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetallePagoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagoConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetallePagoConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagoConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DetallePagoConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagoConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(DetallePagoConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagoConstantesFunciones.LABEL_IDTIPOFORMAPAGO);
			reporte.setsDescripcion(DetallePagoConstantesFunciones.LABEL_IDTIPOFORMAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagoConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(DetallePagoConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagoConstantesFunciones.LABEL_NUMEROFILA);
			reporte.setsDescripcion(DetallePagoConstantesFunciones.LABEL_NUMEROFILA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagoConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DetallePagoConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagoConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DetallePagoConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetallePago(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetallePago(DetallePago detallepagoAux) throws Exception {
		
			detallepagoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallepagoAux.getEmpresa()));
			detallepagoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallepagoAux.getSucursal()));
			detallepagoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallepagoAux.getEjercicio()));
			detallepagoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detallepagoAux.getPeriodo()));
			detallepagoAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(detallepagoAux.getAsientoContable()));
			detallepagoAux.settipoformapago_descripcion(TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(detallepagoAux.getTipoFormaPago()));
			detallepagoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detallepagoAux.getAnio()));
			detallepagoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detallepagoAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetallePago(List<DetallePago> detallepagosTemp) throws Exception {
		for(DetallePago detallepagoAux:detallepagosTemp) {
			
			detallepagoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallepagoAux.getEmpresa()));
			detallepagoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallepagoAux.getSucursal()));
			detallepagoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallepagoAux.getEjercicio()));
			detallepagoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detallepagoAux.getPeriodo()));
			detallepagoAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(detallepagoAux.getAsientoContable()));
			detallepagoAux.settipoformapago_descripcion(TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(detallepagoAux.getTipoFormaPago()));
			detallepagoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detallepagoAux.getAnio()));
			detallepagoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detallepagoAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetallePago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(AsientoContable.class));
				classes.add(new Classe(TipoFormaPago.class));
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
					if(clas.clas.equals(AsientoContable.class)) {
						classes.add(new Classe(AsientoContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoFormaPago.class)) {
						classes.add(new Classe(TipoFormaPago.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetallePago(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(TipoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFormaPago.class)); continue;
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(TipoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFormaPago.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetallePago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetallePagoConstantesFunciones.getClassesRelationshipsOfDetallePago(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetallePago(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetallePago(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetallePagoConstantesFunciones.getClassesRelationshipsFromStringsOfDetallePago(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetallePago(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetallePago detallepago,List<DetallePago> detallepagos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetallePago detallepagoEncontrado=null;
			
			for(DetallePago detallepagoLocal:detallepagos) {
				if(detallepagoLocal.getId().equals(detallepago.getId())) {
					detallepagoEncontrado=detallepagoLocal;
					
					detallepagoLocal.setIsChanged(detallepago.getIsChanged());
					detallepagoLocal.setIsNew(detallepago.getIsNew());
					detallepagoLocal.setIsDeleted(detallepago.getIsDeleted());
					
					detallepagoLocal.setGeneralEntityOriginal(detallepago.getGeneralEntityOriginal());
					
					detallepagoLocal.setId(detallepago.getId());	
					detallepagoLocal.setVersionRow(detallepago.getVersionRow());	
					detallepagoLocal.setid_empresa(detallepago.getid_empresa());	
					detallepagoLocal.setid_sucursal(detallepago.getid_sucursal());	
					detallepagoLocal.setid_ejercicio(detallepago.getid_ejercicio());	
					detallepagoLocal.setid_periodo(detallepago.getid_periodo());	
					detallepagoLocal.setid_asiento_contable(detallepago.getid_asiento_contable());	
					detallepagoLocal.setid_tipo_forma_pago(detallepago.getid_tipo_forma_pago());	
					detallepagoLocal.setvalor(detallepago.getvalor());	
					detallepagoLocal.setnumero_fila(detallepago.getnumero_fila());	
					detallepagoLocal.setid_anio(detallepago.getid_anio());	
					detallepagoLocal.setid_mes(detallepago.getid_mes());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detallepago.getIsDeleted()) {
				if(!existe) {
					detallepagos.add(detallepago);
				}
			} else {
				if(detallepagoEncontrado!=null && permiteQuitar)  {
					detallepagos.remove(detallepagoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetallePago detallepago,List<DetallePago> detallepagos) throws Exception {
		try	{			
			for(DetallePago detallepagoLocal:detallepagos) {
				if(detallepagoLocal.getId().equals(detallepago.getId())) {
					detallepagoLocal.setIsSelected(detallepago.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetallePago(List<DetallePago> detallepagosAux) throws Exception {
		//this.detallepagosAux=detallepagosAux;
		
		for(DetallePago detallepagoAux:detallepagosAux) {
			if(detallepagoAux.getIsChanged()) {
				detallepagoAux.setIsChanged(false);
			}		
			
			if(detallepagoAux.getIsNew()) {
				detallepagoAux.setIsNew(false);
			}	
			
			if(detallepagoAux.getIsDeleted()) {
				detallepagoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetallePago(DetallePago detallepagoAux) throws Exception {
		//this.detallepagoAux=detallepagoAux;
		
			if(detallepagoAux.getIsChanged()) {
				detallepagoAux.setIsChanged(false);
			}		
			
			if(detallepagoAux.getIsNew()) {
				detallepagoAux.setIsNew(false);
			}	
			
			if(detallepagoAux.getIsDeleted()) {
				detallepagoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetallePago detallepagoAsignar,DetallePago detallepago) throws Exception {
		detallepagoAsignar.setId(detallepago.getId());	
		detallepagoAsignar.setVersionRow(detallepago.getVersionRow());	
		detallepagoAsignar.setid_empresa(detallepago.getid_empresa());
		detallepagoAsignar.setempresa_descripcion(detallepago.getempresa_descripcion());	
		detallepagoAsignar.setid_sucursal(detallepago.getid_sucursal());
		detallepagoAsignar.setsucursal_descripcion(detallepago.getsucursal_descripcion());	
		detallepagoAsignar.setid_ejercicio(detallepago.getid_ejercicio());
		detallepagoAsignar.setejercicio_descripcion(detallepago.getejercicio_descripcion());	
		detallepagoAsignar.setid_periodo(detallepago.getid_periodo());
		detallepagoAsignar.setperiodo_descripcion(detallepago.getperiodo_descripcion());	
		detallepagoAsignar.setid_asiento_contable(detallepago.getid_asiento_contable());
		detallepagoAsignar.setasientocontable_descripcion(detallepago.getasientocontable_descripcion());	
		detallepagoAsignar.setid_tipo_forma_pago(detallepago.getid_tipo_forma_pago());
		detallepagoAsignar.settipoformapago_descripcion(detallepago.gettipoformapago_descripcion());	
		detallepagoAsignar.setvalor(detallepago.getvalor());	
		detallepagoAsignar.setnumero_fila(detallepago.getnumero_fila());	
		detallepagoAsignar.setid_anio(detallepago.getid_anio());
		detallepagoAsignar.setanio_descripcion(detallepago.getanio_descripcion());	
		detallepagoAsignar.setid_mes(detallepago.getid_mes());
		detallepagoAsignar.setmes_descripcion(detallepago.getmes_descripcion());	
	}
	
	public static void inicializarDetallePago(DetallePago detallepago) throws Exception {
		try {
				detallepago.setId(0L);	
					
				detallepago.setid_empresa(-1L);	
				detallepago.setid_sucursal(-1L);	
				detallepago.setid_ejercicio(-1L);	
				detallepago.setid_periodo(-1L);	
				detallepago.setid_asiento_contable(-1L);	
				detallepago.setid_tipo_forma_pago(-1L);	
				detallepago.setvalor(0.0);	
				detallepago.setnumero_fila(0);	
				detallepago.setid_anio(null);	
				detallepago.setid_mes(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetallePago(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagoConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagoConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagoConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagoConstantesFunciones.LABEL_IDTIPOFORMAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagoConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagoConstantesFunciones.LABEL_NUMEROFILA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagoConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagoConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetallePago(String sTipo,Row row,Workbook workbook,DetallePago detallepago,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepago.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepago.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepago.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepago.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepago.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepago.gettipoformapago_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepago.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepago.getnumero_fila());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepago.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepago.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetallePago=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetallePago() {
		return this.sFinalQueryDetallePago;
	}
	
	public void setsFinalQueryDetallePago(String sFinalQueryDetallePago) {
		this.sFinalQueryDetallePago= sFinalQueryDetallePago;
	}
	
	public Border resaltarSeleccionarDetallePago=null;
	
	public Border setResaltarSeleccionarDetallePago(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoBeanSwingJInternalFrame detallepagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detallepagoBeanSwingJInternalFrame.jTtoolBarDetallePago.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetallePago= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetallePago() {
		return this.resaltarSeleccionarDetallePago;
	}
	
	public void setResaltarSeleccionarDetallePago(Border borderResaltarSeleccionarDetallePago) {
		this.resaltarSeleccionarDetallePago= borderResaltarSeleccionarDetallePago;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetallePago=null;
	public Boolean mostraridDetallePago=true;
	public Boolean activaridDetallePago=true;

	public Border resaltarid_empresaDetallePago=null;
	public Boolean mostrarid_empresaDetallePago=true;
	public Boolean activarid_empresaDetallePago=true;
	public Boolean cargarid_empresaDetallePago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetallePago=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetallePago=null;
	public Boolean mostrarid_sucursalDetallePago=true;
	public Boolean activarid_sucursalDetallePago=true;
	public Boolean cargarid_sucursalDetallePago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetallePago=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDetallePago=null;
	public Boolean mostrarid_ejercicioDetallePago=true;
	public Boolean activarid_ejercicioDetallePago=true;
	public Boolean cargarid_ejercicioDetallePago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetallePago=false;//ConEventDepend=true

	public Border resaltarid_periodoDetallePago=null;
	public Boolean mostrarid_periodoDetallePago=true;
	public Boolean activarid_periodoDetallePago=true;
	public Boolean cargarid_periodoDetallePago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDetallePago=false;//ConEventDepend=true

	public Border resaltarid_asiento_contableDetallePago=null;
	public Boolean mostrarid_asiento_contableDetallePago=true;
	public Boolean activarid_asiento_contableDetallePago=true;
	public Boolean cargarid_asiento_contableDetallePago=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contableDetallePago=false;//ConEventDepend=true

	public Border resaltarid_tipo_forma_pagoDetallePago=null;
	public Boolean mostrarid_tipo_forma_pagoDetallePago=true;
	public Boolean activarid_tipo_forma_pagoDetallePago=true;
	public Boolean cargarid_tipo_forma_pagoDetallePago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_forma_pagoDetallePago=false;//ConEventDepend=true

	public Border resaltarvalorDetallePago=null;
	public Boolean mostrarvalorDetallePago=true;
	public Boolean activarvalorDetallePago=true;

	public Border resaltarnumero_filaDetallePago=null;
	public Boolean mostrarnumero_filaDetallePago=true;
	public Boolean activarnumero_filaDetallePago=true;

	public Border resaltarid_anioDetallePago=null;
	public Boolean mostrarid_anioDetallePago=true;
	public Boolean activarid_anioDetallePago=false;
	public Boolean cargarid_anioDetallePago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDetallePago=false;//ConEventDepend=true

	public Border resaltarid_mesDetallePago=null;
	public Boolean mostrarid_mesDetallePago=true;
	public Boolean activarid_mesDetallePago=false;
	public Boolean cargarid_mesDetallePago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDetallePago=false;//ConEventDepend=true

	
	

	public Border setResaltaridDetallePago(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoBeanSwingJInternalFrame detallepagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagoBeanSwingJInternalFrame.jTtoolBarDetallePago.setBorder(borderResaltar);
		
		this.resaltaridDetallePago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetallePago() {
		return this.resaltaridDetallePago;
	}

	public void setResaltaridDetallePago(Border borderResaltar) {
		this.resaltaridDetallePago= borderResaltar;
	}

	public Boolean getMostraridDetallePago() {
		return this.mostraridDetallePago;
	}

	public void setMostraridDetallePago(Boolean mostraridDetallePago) {
		this.mostraridDetallePago= mostraridDetallePago;
	}

	public Boolean getActivaridDetallePago() {
		return this.activaridDetallePago;
	}

	public void setActivaridDetallePago(Boolean activaridDetallePago) {
		this.activaridDetallePago= activaridDetallePago;
	}

	public Border setResaltarid_empresaDetallePago(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoBeanSwingJInternalFrame detallepagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagoBeanSwingJInternalFrame.jTtoolBarDetallePago.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetallePago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetallePago() {
		return this.resaltarid_empresaDetallePago;
	}

	public void setResaltarid_empresaDetallePago(Border borderResaltar) {
		this.resaltarid_empresaDetallePago= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetallePago() {
		return this.mostrarid_empresaDetallePago;
	}

	public void setMostrarid_empresaDetallePago(Boolean mostrarid_empresaDetallePago) {
		this.mostrarid_empresaDetallePago= mostrarid_empresaDetallePago;
	}

	public Boolean getActivarid_empresaDetallePago() {
		return this.activarid_empresaDetallePago;
	}

	public void setActivarid_empresaDetallePago(Boolean activarid_empresaDetallePago) {
		this.activarid_empresaDetallePago= activarid_empresaDetallePago;
	}

	public Boolean getCargarid_empresaDetallePago() {
		return this.cargarid_empresaDetallePago;
	}

	public void setCargarid_empresaDetallePago(Boolean cargarid_empresaDetallePago) {
		this.cargarid_empresaDetallePago= cargarid_empresaDetallePago;
	}

	public Border setResaltarid_sucursalDetallePago(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoBeanSwingJInternalFrame detallepagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagoBeanSwingJInternalFrame.jTtoolBarDetallePago.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetallePago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetallePago() {
		return this.resaltarid_sucursalDetallePago;
	}

	public void setResaltarid_sucursalDetallePago(Border borderResaltar) {
		this.resaltarid_sucursalDetallePago= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetallePago() {
		return this.mostrarid_sucursalDetallePago;
	}

	public void setMostrarid_sucursalDetallePago(Boolean mostrarid_sucursalDetallePago) {
		this.mostrarid_sucursalDetallePago= mostrarid_sucursalDetallePago;
	}

	public Boolean getActivarid_sucursalDetallePago() {
		return this.activarid_sucursalDetallePago;
	}

	public void setActivarid_sucursalDetallePago(Boolean activarid_sucursalDetallePago) {
		this.activarid_sucursalDetallePago= activarid_sucursalDetallePago;
	}

	public Boolean getCargarid_sucursalDetallePago() {
		return this.cargarid_sucursalDetallePago;
	}

	public void setCargarid_sucursalDetallePago(Boolean cargarid_sucursalDetallePago) {
		this.cargarid_sucursalDetallePago= cargarid_sucursalDetallePago;
	}

	public Border setResaltarid_ejercicioDetallePago(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoBeanSwingJInternalFrame detallepagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagoBeanSwingJInternalFrame.jTtoolBarDetallePago.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioDetallePago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetallePago() {
		return this.resaltarid_ejercicioDetallePago;
	}

	public void setResaltarid_ejercicioDetallePago(Border borderResaltar) {
		this.resaltarid_ejercicioDetallePago= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetallePago() {
		return this.mostrarid_ejercicioDetallePago;
	}

	public void setMostrarid_ejercicioDetallePago(Boolean mostrarid_ejercicioDetallePago) {
		this.mostrarid_ejercicioDetallePago= mostrarid_ejercicioDetallePago;
	}

	public Boolean getActivarid_ejercicioDetallePago() {
		return this.activarid_ejercicioDetallePago;
	}

	public void setActivarid_ejercicioDetallePago(Boolean activarid_ejercicioDetallePago) {
		this.activarid_ejercicioDetallePago= activarid_ejercicioDetallePago;
	}

	public Boolean getCargarid_ejercicioDetallePago() {
		return this.cargarid_ejercicioDetallePago;
	}

	public void setCargarid_ejercicioDetallePago(Boolean cargarid_ejercicioDetallePago) {
		this.cargarid_ejercicioDetallePago= cargarid_ejercicioDetallePago;
	}

	public Border setResaltarid_periodoDetallePago(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoBeanSwingJInternalFrame detallepagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagoBeanSwingJInternalFrame.jTtoolBarDetallePago.setBorder(borderResaltar);
		
		this.resaltarid_periodoDetallePago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDetallePago() {
		return this.resaltarid_periodoDetallePago;
	}

	public void setResaltarid_periodoDetallePago(Border borderResaltar) {
		this.resaltarid_periodoDetallePago= borderResaltar;
	}

	public Boolean getMostrarid_periodoDetallePago() {
		return this.mostrarid_periodoDetallePago;
	}

	public void setMostrarid_periodoDetallePago(Boolean mostrarid_periodoDetallePago) {
		this.mostrarid_periodoDetallePago= mostrarid_periodoDetallePago;
	}

	public Boolean getActivarid_periodoDetallePago() {
		return this.activarid_periodoDetallePago;
	}

	public void setActivarid_periodoDetallePago(Boolean activarid_periodoDetallePago) {
		this.activarid_periodoDetallePago= activarid_periodoDetallePago;
	}

	public Boolean getCargarid_periodoDetallePago() {
		return this.cargarid_periodoDetallePago;
	}

	public void setCargarid_periodoDetallePago(Boolean cargarid_periodoDetallePago) {
		this.cargarid_periodoDetallePago= cargarid_periodoDetallePago;
	}

	public Border setResaltarid_asiento_contableDetallePago(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoBeanSwingJInternalFrame detallepagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagoBeanSwingJInternalFrame.jTtoolBarDetallePago.setBorder(borderResaltar);
		
		this.resaltarid_asiento_contableDetallePago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contableDetallePago() {
		return this.resaltarid_asiento_contableDetallePago;
	}

	public void setResaltarid_asiento_contableDetallePago(Border borderResaltar) {
		this.resaltarid_asiento_contableDetallePago= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contableDetallePago() {
		return this.mostrarid_asiento_contableDetallePago;
	}

	public void setMostrarid_asiento_contableDetallePago(Boolean mostrarid_asiento_contableDetallePago) {
		this.mostrarid_asiento_contableDetallePago= mostrarid_asiento_contableDetallePago;
	}

	public Boolean getActivarid_asiento_contableDetallePago() {
		return this.activarid_asiento_contableDetallePago;
	}

	public void setActivarid_asiento_contableDetallePago(Boolean activarid_asiento_contableDetallePago) {
		this.activarid_asiento_contableDetallePago= activarid_asiento_contableDetallePago;
	}

	public Boolean getCargarid_asiento_contableDetallePago() {
		return this.cargarid_asiento_contableDetallePago;
	}

	public void setCargarid_asiento_contableDetallePago(Boolean cargarid_asiento_contableDetallePago) {
		this.cargarid_asiento_contableDetallePago= cargarid_asiento_contableDetallePago;
	}

	public Border setResaltarid_tipo_forma_pagoDetallePago(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoBeanSwingJInternalFrame detallepagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagoBeanSwingJInternalFrame.jTtoolBarDetallePago.setBorder(borderResaltar);
		
		this.resaltarid_tipo_forma_pagoDetallePago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_forma_pagoDetallePago() {
		return this.resaltarid_tipo_forma_pagoDetallePago;
	}

	public void setResaltarid_tipo_forma_pagoDetallePago(Border borderResaltar) {
		this.resaltarid_tipo_forma_pagoDetallePago= borderResaltar;
	}

	public Boolean getMostrarid_tipo_forma_pagoDetallePago() {
		return this.mostrarid_tipo_forma_pagoDetallePago;
	}

	public void setMostrarid_tipo_forma_pagoDetallePago(Boolean mostrarid_tipo_forma_pagoDetallePago) {
		this.mostrarid_tipo_forma_pagoDetallePago= mostrarid_tipo_forma_pagoDetallePago;
	}

	public Boolean getActivarid_tipo_forma_pagoDetallePago() {
		return this.activarid_tipo_forma_pagoDetallePago;
	}

	public void setActivarid_tipo_forma_pagoDetallePago(Boolean activarid_tipo_forma_pagoDetallePago) {
		this.activarid_tipo_forma_pagoDetallePago= activarid_tipo_forma_pagoDetallePago;
	}

	public Boolean getCargarid_tipo_forma_pagoDetallePago() {
		return this.cargarid_tipo_forma_pagoDetallePago;
	}

	public void setCargarid_tipo_forma_pagoDetallePago(Boolean cargarid_tipo_forma_pagoDetallePago) {
		this.cargarid_tipo_forma_pagoDetallePago= cargarid_tipo_forma_pagoDetallePago;
	}

	public Border setResaltarvalorDetallePago(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoBeanSwingJInternalFrame detallepagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagoBeanSwingJInternalFrame.jTtoolBarDetallePago.setBorder(borderResaltar);
		
		this.resaltarvalorDetallePago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorDetallePago() {
		return this.resaltarvalorDetallePago;
	}

	public void setResaltarvalorDetallePago(Border borderResaltar) {
		this.resaltarvalorDetallePago= borderResaltar;
	}

	public Boolean getMostrarvalorDetallePago() {
		return this.mostrarvalorDetallePago;
	}

	public void setMostrarvalorDetallePago(Boolean mostrarvalorDetallePago) {
		this.mostrarvalorDetallePago= mostrarvalorDetallePago;
	}

	public Boolean getActivarvalorDetallePago() {
		return this.activarvalorDetallePago;
	}

	public void setActivarvalorDetallePago(Boolean activarvalorDetallePago) {
		this.activarvalorDetallePago= activarvalorDetallePago;
	}

	public Border setResaltarnumero_filaDetallePago(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoBeanSwingJInternalFrame detallepagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagoBeanSwingJInternalFrame.jTtoolBarDetallePago.setBorder(borderResaltar);
		
		this.resaltarnumero_filaDetallePago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_filaDetallePago() {
		return this.resaltarnumero_filaDetallePago;
	}

	public void setResaltarnumero_filaDetallePago(Border borderResaltar) {
		this.resaltarnumero_filaDetallePago= borderResaltar;
	}

	public Boolean getMostrarnumero_filaDetallePago() {
		return this.mostrarnumero_filaDetallePago;
	}

	public void setMostrarnumero_filaDetallePago(Boolean mostrarnumero_filaDetallePago) {
		this.mostrarnumero_filaDetallePago= mostrarnumero_filaDetallePago;
	}

	public Boolean getActivarnumero_filaDetallePago() {
		return this.activarnumero_filaDetallePago;
	}

	public void setActivarnumero_filaDetallePago(Boolean activarnumero_filaDetallePago) {
		this.activarnumero_filaDetallePago= activarnumero_filaDetallePago;
	}

	public Border setResaltarid_anioDetallePago(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoBeanSwingJInternalFrame detallepagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagoBeanSwingJInternalFrame.jTtoolBarDetallePago.setBorder(borderResaltar);
		
		this.resaltarid_anioDetallePago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDetallePago() {
		return this.resaltarid_anioDetallePago;
	}

	public void setResaltarid_anioDetallePago(Border borderResaltar) {
		this.resaltarid_anioDetallePago= borderResaltar;
	}

	public Boolean getMostrarid_anioDetallePago() {
		return this.mostrarid_anioDetallePago;
	}

	public void setMostrarid_anioDetallePago(Boolean mostrarid_anioDetallePago) {
		this.mostrarid_anioDetallePago= mostrarid_anioDetallePago;
	}

	public Boolean getActivarid_anioDetallePago() {
		return this.activarid_anioDetallePago;
	}

	public void setActivarid_anioDetallePago(Boolean activarid_anioDetallePago) {
		this.activarid_anioDetallePago= activarid_anioDetallePago;
	}

	public Boolean getCargarid_anioDetallePago() {
		return this.cargarid_anioDetallePago;
	}

	public void setCargarid_anioDetallePago(Boolean cargarid_anioDetallePago) {
		this.cargarid_anioDetallePago= cargarid_anioDetallePago;
	}

	public Border setResaltarid_mesDetallePago(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoBeanSwingJInternalFrame detallepagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagoBeanSwingJInternalFrame.jTtoolBarDetallePago.setBorder(borderResaltar);
		
		this.resaltarid_mesDetallePago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDetallePago() {
		return this.resaltarid_mesDetallePago;
	}

	public void setResaltarid_mesDetallePago(Border borderResaltar) {
		this.resaltarid_mesDetallePago= borderResaltar;
	}

	public Boolean getMostrarid_mesDetallePago() {
		return this.mostrarid_mesDetallePago;
	}

	public void setMostrarid_mesDetallePago(Boolean mostrarid_mesDetallePago) {
		this.mostrarid_mesDetallePago= mostrarid_mesDetallePago;
	}

	public Boolean getActivarid_mesDetallePago() {
		return this.activarid_mesDetallePago;
	}

	public void setActivarid_mesDetallePago(Boolean activarid_mesDetallePago) {
		this.activarid_mesDetallePago= activarid_mesDetallePago;
	}

	public Boolean getCargarid_mesDetallePago() {
		return this.cargarid_mesDetallePago;
	}

	public void setCargarid_mesDetallePago(Boolean cargarid_mesDetallePago) {
		this.cargarid_mesDetallePago= cargarid_mesDetallePago;
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
		
		
		this.setMostraridDetallePago(esInicial);
		this.setMostrarid_empresaDetallePago(esInicial);
		this.setMostrarid_sucursalDetallePago(esInicial);
		this.setMostrarid_ejercicioDetallePago(esInicial);
		this.setMostrarid_periodoDetallePago(esInicial);
		this.setMostrarid_asiento_contableDetallePago(esInicial);
		this.setMostrarid_tipo_forma_pagoDetallePago(esInicial);
		this.setMostrarvalorDetallePago(esInicial);
		this.setMostrarnumero_filaDetallePago(esInicial);
		this.setMostrarid_anioDetallePago(esInicial);
		this.setMostrarid_mesDetallePago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetallePagoConstantesFunciones.ID)) {
				this.setMostraridDetallePago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetallePago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetallePago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetallePago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDetallePago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contableDetallePago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setMostrarid_tipo_forma_pagoDetallePago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoConstantesFunciones.VALOR)) {
				this.setMostrarvalorDetallePago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoConstantesFunciones.NUMEROFILA)) {
				this.setMostrarnumero_filaDetallePago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDetallePago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDetallePago(esAsigna);
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
		
		
		this.setActivaridDetallePago(esInicial);
		this.setActivarid_empresaDetallePago(esInicial);
		this.setActivarid_sucursalDetallePago(esInicial);
		this.setActivarid_ejercicioDetallePago(esInicial);
		this.setActivarid_periodoDetallePago(esInicial);
		this.setActivarid_asiento_contableDetallePago(esInicial);
		this.setActivarid_tipo_forma_pagoDetallePago(esInicial);
		this.setActivarvalorDetallePago(esInicial);
		this.setActivarnumero_filaDetallePago(esInicial);
		this.setActivarid_anioDetallePago(esInicial);
		this.setActivarid_mesDetallePago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetallePagoConstantesFunciones.ID)) {
				this.setActivaridDetallePago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetallePago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetallePago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetallePago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDetallePago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contableDetallePago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setActivarid_tipo_forma_pagoDetallePago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoConstantesFunciones.VALOR)) {
				this.setActivarvalorDetallePago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoConstantesFunciones.NUMEROFILA)) {
				this.setActivarnumero_filaDetallePago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDetallePago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoConstantesFunciones.IDMES)) {
				this.setActivarid_mesDetallePago(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetallePagoBeanSwingJInternalFrame detallepagoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetallePago(esInicial);
		this.setResaltarid_empresaDetallePago(esInicial);
		this.setResaltarid_sucursalDetallePago(esInicial);
		this.setResaltarid_ejercicioDetallePago(esInicial);
		this.setResaltarid_periodoDetallePago(esInicial);
		this.setResaltarid_asiento_contableDetallePago(esInicial);
		this.setResaltarid_tipo_forma_pagoDetallePago(esInicial);
		this.setResaltarvalorDetallePago(esInicial);
		this.setResaltarnumero_filaDetallePago(esInicial);
		this.setResaltarid_anioDetallePago(esInicial);
		this.setResaltarid_mesDetallePago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetallePagoConstantesFunciones.ID)) {
				this.setResaltaridDetallePago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetallePago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetallePago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetallePago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDetallePago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contableDetallePago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setResaltarid_tipo_forma_pagoDetallePago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoConstantesFunciones.VALOR)) {
				this.setResaltarvalorDetallePago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoConstantesFunciones.NUMEROFILA)) {
				this.setResaltarnumero_filaDetallePago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDetallePago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDetallePago(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetallePagoBeanSwingJInternalFrame detallepagoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAsientoContableDetallePago=true;

	public Boolean getMostrarFK_IdAsientoContableDetallePago() {
		return this.mostrarFK_IdAsientoContableDetallePago;
	}

	public void setMostrarFK_IdAsientoContableDetallePago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAsientoContableDetallePago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioDetallePago=true;

	public Boolean getMostrarFK_IdEjercicioDetallePago() {
		return this.mostrarFK_IdEjercicioDetallePago;
	}

	public void setMostrarFK_IdEjercicioDetallePago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetallePago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetallePago=true;

	public Boolean getMostrarFK_IdEmpresaDetallePago() {
		return this.mostrarFK_IdEmpresaDetallePago;
	}

	public void setMostrarFK_IdEmpresaDetallePago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetallePago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDetallePago=true;

	public Boolean getMostrarFK_IdPeriodoDetallePago() {
		return this.mostrarFK_IdPeriodoDetallePago;
	}

	public void setMostrarFK_IdPeriodoDetallePago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDetallePago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetallePago=true;

	public Boolean getMostrarFK_IdSucursalDetallePago() {
		return this.mostrarFK_IdSucursalDetallePago;
	}

	public void setMostrarFK_IdSucursalDetallePago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetallePago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoFormaPagoDetallePago=true;

	public Boolean getMostrarFK_IdTipoFormaPagoDetallePago() {
		return this.mostrarFK_IdTipoFormaPagoDetallePago;
	}

	public void setMostrarFK_IdTipoFormaPagoDetallePago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoFormaPagoDetallePago= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAsientoContableDetallePago=true;

	public Boolean getActivarFK_IdAsientoContableDetallePago() {
		return this.activarFK_IdAsientoContableDetallePago;
	}

	public void setActivarFK_IdAsientoContableDetallePago(Boolean habilitarResaltar) {
		this.activarFK_IdAsientoContableDetallePago= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioDetallePago=true;

	public Boolean getActivarFK_IdEjercicioDetallePago() {
		return this.activarFK_IdEjercicioDetallePago;
	}

	public void setActivarFK_IdEjercicioDetallePago(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetallePago= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetallePago=true;

	public Boolean getActivarFK_IdEmpresaDetallePago() {
		return this.activarFK_IdEmpresaDetallePago;
	}

	public void setActivarFK_IdEmpresaDetallePago(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetallePago= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDetallePago=true;

	public Boolean getActivarFK_IdPeriodoDetallePago() {
		return this.activarFK_IdPeriodoDetallePago;
	}

	public void setActivarFK_IdPeriodoDetallePago(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDetallePago= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetallePago=true;

	public Boolean getActivarFK_IdSucursalDetallePago() {
		return this.activarFK_IdSucursalDetallePago;
	}

	public void setActivarFK_IdSucursalDetallePago(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetallePago= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoFormaPagoDetallePago=true;

	public Boolean getActivarFK_IdTipoFormaPagoDetallePago() {
		return this.activarFK_IdTipoFormaPagoDetallePago;
	}

	public void setActivarFK_IdTipoFormaPagoDetallePago(Boolean habilitarResaltar) {
		this.activarFK_IdTipoFormaPagoDetallePago= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAsientoContableDetallePago=null;

	public Border getResaltarFK_IdAsientoContableDetallePago() {
		return this.resaltarFK_IdAsientoContableDetallePago;
	}

	public void setResaltarFK_IdAsientoContableDetallePago(Border borderResaltar) {
		this.resaltarFK_IdAsientoContableDetallePago= borderResaltar;
	}

	public void setResaltarFK_IdAsientoContableDetallePago(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoBeanSwingJInternalFrame detallepagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAsientoContableDetallePago= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioDetallePago=null;

	public Border getResaltarFK_IdEjercicioDetallePago() {
		return this.resaltarFK_IdEjercicioDetallePago;
	}

	public void setResaltarFK_IdEjercicioDetallePago(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetallePago= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetallePago(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoBeanSwingJInternalFrame detallepagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetallePago= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetallePago=null;

	public Border getResaltarFK_IdEmpresaDetallePago() {
		return this.resaltarFK_IdEmpresaDetallePago;
	}

	public void setResaltarFK_IdEmpresaDetallePago(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetallePago= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetallePago(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoBeanSwingJInternalFrame detallepagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetallePago= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDetallePago=null;

	public Border getResaltarFK_IdPeriodoDetallePago() {
		return this.resaltarFK_IdPeriodoDetallePago;
	}

	public void setResaltarFK_IdPeriodoDetallePago(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDetallePago= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDetallePago(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoBeanSwingJInternalFrame detallepagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDetallePago= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetallePago=null;

	public Border getResaltarFK_IdSucursalDetallePago() {
		return this.resaltarFK_IdSucursalDetallePago;
	}

	public void setResaltarFK_IdSucursalDetallePago(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetallePago= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetallePago(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoBeanSwingJInternalFrame detallepagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetallePago= borderResaltar;
	}

	public Border resaltarFK_IdTipoFormaPagoDetallePago=null;

	public Border getResaltarFK_IdTipoFormaPagoDetallePago() {
		return this.resaltarFK_IdTipoFormaPagoDetallePago;
	}

	public void setResaltarFK_IdTipoFormaPagoDetallePago(Border borderResaltar) {
		this.resaltarFK_IdTipoFormaPagoDetallePago= borderResaltar;
	}

	public void setResaltarFK_IdTipoFormaPagoDetallePago(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoBeanSwingJInternalFrame detallepagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoFormaPagoDetallePago= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}