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
package com.bydan.erp.produccion.util;

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


import com.bydan.erp.produccion.util.ParametroProduConstantesFunciones;
import com.bydan.erp.produccion.util.ParametroProduParameterReturnGeneral;
//import com.bydan.erp.produccion.util.ParametroProduParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.produccion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.produccion.business.dataaccess.*;
//import com.bydan.erp.produccion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ParametroProduConstantesFunciones extends ParametroProduConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ParametroProdu";
	public static final String SPATHOPCION="Produccion";	
	public static final String SPATHMODULO="produccion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ParametroProdu"+ParametroProduConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParametroProduHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParametroProduHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParametroProduConstantesFunciones.SCHEMA+"_"+ParametroProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParametroProduHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParametroProduConstantesFunciones.SCHEMA+"_"+ParametroProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParametroProduConstantesFunciones.SCHEMA+"_"+ParametroProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParametroProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParametroProduConstantesFunciones.SCHEMA+"_"+ParametroProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroProduHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParametroProduConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParametroProduConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParametroProduConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParametroProduConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parametro Producciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Parametro Produccion";
	public static final String SCLASSWEBTITULO_LOWER="Parametro Produ";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ParametroProdu";
	public static final String OBJECTNAME="parametroprodu";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PRODUCCION;	
	public static final String TABLENAME="parametro_produ";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parametroprodu from "+ParametroProduConstantesFunciones.SPERSISTENCENAME+" parametroprodu";
	public static String QUERYSELECTNATIVE="select "+ParametroProduConstantesFunciones.SCHEMA+"."+ParametroProduConstantesFunciones.TABLENAME+".id,"+ParametroProduConstantesFunciones.SCHEMA+"."+ParametroProduConstantesFunciones.TABLENAME+".version_row,"+ParametroProduConstantesFunciones.SCHEMA+"."+ParametroProduConstantesFunciones.TABLENAME+".id_empresa,"+ParametroProduConstantesFunciones.SCHEMA+"."+ParametroProduConstantesFunciones.TABLENAME+".id_sucursal,"+ParametroProduConstantesFunciones.SCHEMA+"."+ParametroProduConstantesFunciones.TABLENAME+".id_bodega,"+ParametroProduConstantesFunciones.SCHEMA+"."+ParametroProduConstantesFunciones.TABLENAME+".id_bodega_materia_prima,"+ParametroProduConstantesFunciones.SCHEMA+"."+ParametroProduConstantesFunciones.TABLENAME+".id_transaccion,"+ParametroProduConstantesFunciones.SCHEMA+"."+ParametroProduConstantesFunciones.TABLENAME+".id_transaccion_egreso,"+ParametroProduConstantesFunciones.SCHEMA+"."+ParametroProduConstantesFunciones.TABLENAME+".con_relacion_porcentaje,"+ParametroProduConstantesFunciones.SCHEMA+"."+ParametroProduConstantesFunciones.TABLENAME+".descripcion from "+ParametroProduConstantesFunciones.SCHEMA+"."+ParametroProduConstantesFunciones.TABLENAME;//+" as "+ParametroProduConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParametroProduConstantesFuncionesAdditional parametroproduConstantesFuncionesAdditional=null;
	
	public ParametroProduConstantesFuncionesAdditional getParametroProduConstantesFuncionesAdditional() {
		return this.parametroproduConstantesFuncionesAdditional;
	}
	
	public void setParametroProduConstantesFuncionesAdditional(ParametroProduConstantesFuncionesAdditional parametroproduConstantesFuncionesAdditional) {
		try {
			this.parametroproduConstantesFuncionesAdditional=parametroproduConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDBODEGAMATERIAPRIMA= "id_bodega_materia_prima";
    public static final String IDTRANSACCION= "id_transaccion";
    public static final String IDTRANSACCIONEGRESO= "id_transaccion_egreso";
    public static final String CONRELACIONPORCENTAJE= "con_relacion_porcentaje";
    public static final String DESCRIPCION= "descripcion";
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
    	public static final String LABEL_IDBODEGAMATERIAPRIMA= "Bodega Materia Prima";
		public static final String LABEL_IDBODEGAMATERIAPRIMA_LOWER= "Bodega Materia Prima";
    	public static final String LABEL_IDTRANSACCION= "Transaccion";
		public static final String LABEL_IDTRANSACCION_LOWER= "Transaccion";
    	public static final String LABEL_IDTRANSACCIONEGRESO= "Transaccion Egreso";
		public static final String LABEL_IDTRANSACCIONEGRESO_LOWER= "Transaccion Egreso";
    	public static final String LABEL_CONRELACIONPORCENTAJE= "Con Relacion Porcentaje";
		public static final String LABEL_CONRELACIONPORCENTAJE_LOWER= "Con Relacion Porcentaje";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getParametroProduLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParametroProduConstantesFunciones.IDEMPRESA)) {sLabelColumna=ParametroProduConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ParametroProduConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ParametroProduConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ParametroProduConstantesFunciones.IDBODEGA)) {sLabelColumna=ParametroProduConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ParametroProduConstantesFunciones.IDBODEGAMATERIAPRIMA)) {sLabelColumna=ParametroProduConstantesFunciones.LABEL_IDBODEGAMATERIAPRIMA;}
		if(sNombreColumna.equals(ParametroProduConstantesFunciones.IDTRANSACCION)) {sLabelColumna=ParametroProduConstantesFunciones.LABEL_IDTRANSACCION;}
		if(sNombreColumna.equals(ParametroProduConstantesFunciones.IDTRANSACCIONEGRESO)) {sLabelColumna=ParametroProduConstantesFunciones.LABEL_IDTRANSACCIONEGRESO;}
		if(sNombreColumna.equals(ParametroProduConstantesFunciones.CONRELACIONPORCENTAJE)) {sLabelColumna=ParametroProduConstantesFunciones.LABEL_CONRELACIONPORCENTAJE;}
		if(sNombreColumna.equals(ParametroProduConstantesFunciones.DESCRIPCION)) {sLabelColumna=ParametroProduConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
	
	public static String getParametroProduDescripcion(ParametroProdu parametroprodu) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parametroprodu !=null/* && parametroprodu.getId()!=0*/) {
			if(parametroprodu.getId()!=null) {
				sDescripcion=parametroprodu.getId().toString();
			}//parametroproduparametroprodu.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getParametroProduDescripcionDetallado(ParametroProdu parametroprodu) {
		String sDescripcion="";
			
		sDescripcion+=ParametroProduConstantesFunciones.ID+"=";
		sDescripcion+=parametroprodu.getId().toString()+",";
		sDescripcion+=ParametroProduConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parametroprodu.getVersionRow().toString()+",";
		sDescripcion+=ParametroProduConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=parametroprodu.getid_empresa().toString()+",";
		sDescripcion+=ParametroProduConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=parametroprodu.getid_sucursal().toString()+",";
		sDescripcion+=ParametroProduConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=parametroprodu.getid_bodega().toString()+",";
		sDescripcion+=ParametroProduConstantesFunciones.IDBODEGAMATERIAPRIMA+"=";
		sDescripcion+=parametroprodu.getid_bodega_materia_prima().toString()+",";
		sDescripcion+=ParametroProduConstantesFunciones.IDTRANSACCION+"=";
		sDescripcion+=parametroprodu.getid_transaccion().toString()+",";
		sDescripcion+=ParametroProduConstantesFunciones.IDTRANSACCIONEGRESO+"=";
		sDescripcion+=parametroprodu.getid_transaccion_egreso().toString()+",";
		sDescripcion+=ParametroProduConstantesFunciones.CONRELACIONPORCENTAJE+"=";
		sDescripcion+=parametroprodu.getcon_relacion_porcentaje().toString()+",";
		sDescripcion+=ParametroProduConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=parametroprodu.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setParametroProduDescripcion(ParametroProdu parametroprodu,String sValor) throws Exception {			
		if(parametroprodu !=null) {
			//parametroproduparametroprodu.getId().toString();
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

	public static String getBodegaMateriaPrimaDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
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

	public static String getTransaccionEgresoDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
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
		} else if(sNombreIndice.equals("FK_IdBodegaMateriaPrima")) {
			sNombreIndice="Tipo=  Por Bodega Materia Prima";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTransaccion")) {
			sNombreIndice="Tipo=  Por Transaccion";
		} else if(sNombreIndice.equals("FK_IdTransaccionEgreso")) {
			sNombreIndice="Tipo=  Por Transaccion Egreso";
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

	public static String getDetalleIndiceFK_IdBodegaMateriaPrima(Long id_bodega_materia_prima) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega_materia_prima!=null) {sDetalleIndice+=" Codigo Unico De Bodega Materia Prima="+id_bodega_materia_prima.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

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

	public static String getDetalleIndiceFK_IdTransaccionEgreso(Long id_transaccion_egreso) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_egreso!=null) {sDetalleIndice+=" Codigo Unico De Transaccion Egreso="+id_transaccion_egreso.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosParametroProdu(ParametroProdu parametroprodu,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		parametroprodu.setdescripcion(parametroprodu.getdescripcion().trim());
	}
	
	public static void quitarEspaciosParametroProdus(List<ParametroProdu> parametroprodus,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ParametroProdu parametroprodu: parametroprodus) {
			parametroprodu.setdescripcion(parametroprodu.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroProdu(ParametroProdu parametroprodu,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parametroprodu.getConCambioAuxiliar()) {
			parametroprodu.setIsDeleted(parametroprodu.getIsDeletedAuxiliar());	
			parametroprodu.setIsNew(parametroprodu.getIsNewAuxiliar());	
			parametroprodu.setIsChanged(parametroprodu.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parametroprodu.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parametroprodu.setIsDeletedAuxiliar(false);	
			parametroprodu.setIsNewAuxiliar(false);	
			parametroprodu.setIsChangedAuxiliar(false);
			
			parametroprodu.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroProdus(List<ParametroProdu> parametroprodus,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ParametroProdu parametroprodu : parametroprodus) {
			if(conAsignarBase && parametroprodu.getConCambioAuxiliar()) {
				parametroprodu.setIsDeleted(parametroprodu.getIsDeletedAuxiliar());	
				parametroprodu.setIsNew(parametroprodu.getIsNewAuxiliar());	
				parametroprodu.setIsChanged(parametroprodu.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parametroprodu.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parametroprodu.setIsDeletedAuxiliar(false);	
				parametroprodu.setIsNewAuxiliar(false);	
				parametroprodu.setIsChangedAuxiliar(false);
				
				parametroprodu.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParametroProdu(ParametroProdu parametroprodu,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			parametroprodu.setcon_relacion_porcentaje(0L);
		}
	}		
	
	public static void InicializarValoresParametroProdus(List<ParametroProdu> parametroprodus,Boolean conEnteros) throws Exception  {
		
		for(ParametroProdu parametroprodu: parametroprodus) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				parametroprodu.setcon_relacion_porcentaje(0L);
			}
		}				
	}
	
	public static void TotalizarValoresFilaParametroProdu(List<ParametroProdu> parametroprodus,ParametroProdu parametroproduAux) throws Exception  {
		ParametroProduConstantesFunciones.InicializarValoresParametroProdu(parametroproduAux,true);
		
		for(ParametroProdu parametroprodu: parametroprodus) {
			if(parametroprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			parametroproduAux.setcon_relacion_porcentaje(parametroproduAux.getcon_relacion_porcentaje()+parametroprodu.getcon_relacion_porcentaje());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParametroProduConstantesFunciones.getArrayColumnasGlobalesParametroProdu(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroProdu(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroProduConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroProduConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroProduConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroProduConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParametroProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ParametroProdu> parametroprodus,ParametroProdu parametroprodu,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ParametroProdu parametroproduAux: parametroprodus) {
			if(parametroproduAux!=null && parametroprodu!=null) {
				if((parametroproduAux.getId()==null && parametroprodu.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parametroproduAux.getId()!=null && parametroprodu.getId()!=null){
					if(parametroproduAux.getId().equals(parametroprodu.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParametroProdu(List<ParametroProdu> parametroprodus) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ParametroProdu parametroprodu: parametroprodus) {			
			if(parametroprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParametroProdu() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParametroProduConstantesFunciones.LABEL_ID, ParametroProduConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroProduConstantesFunciones.LABEL_VERSIONROW, ParametroProduConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroProduConstantesFunciones.LABEL_IDEMPRESA, ParametroProduConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroProduConstantesFunciones.LABEL_IDSUCURSAL, ParametroProduConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroProduConstantesFunciones.LABEL_IDBODEGA, ParametroProduConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroProduConstantesFunciones.LABEL_IDBODEGAMATERIAPRIMA, ParametroProduConstantesFunciones.IDBODEGAMATERIAPRIMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroProduConstantesFunciones.LABEL_IDTRANSACCION, ParametroProduConstantesFunciones.IDTRANSACCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroProduConstantesFunciones.LABEL_IDTRANSACCIONEGRESO, ParametroProduConstantesFunciones.IDTRANSACCIONEGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroProduConstantesFunciones.LABEL_CONRELACIONPORCENTAJE, ParametroProduConstantesFunciones.CONRELACIONPORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroProduConstantesFunciones.LABEL_DESCRIPCION, ParametroProduConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParametroProdu() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParametroProduConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroProduConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroProduConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroProduConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroProduConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroProduConstantesFunciones.IDBODEGAMATERIAPRIMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroProduConstantesFunciones.IDTRANSACCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroProduConstantesFunciones.IDTRANSACCIONEGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroProduConstantesFunciones.CONRELACIONPORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroProduConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroProdu() throws Exception  {
		return ParametroProduConstantesFunciones.getTiposSeleccionarParametroProdu(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroProdu(Boolean conFk) throws Exception  {
		return ParametroProduConstantesFunciones.getTiposSeleccionarParametroProdu(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroProdu(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroProduConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ParametroProduConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroProduConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ParametroProduConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroProduConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ParametroProduConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroProduConstantesFunciones.LABEL_IDBODEGAMATERIAPRIMA);
			reporte.setsDescripcion(ParametroProduConstantesFunciones.LABEL_IDBODEGAMATERIAPRIMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroProduConstantesFunciones.LABEL_IDTRANSACCION);
			reporte.setsDescripcion(ParametroProduConstantesFunciones.LABEL_IDTRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroProduConstantesFunciones.LABEL_IDTRANSACCIONEGRESO);
			reporte.setsDescripcion(ParametroProduConstantesFunciones.LABEL_IDTRANSACCIONEGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroProduConstantesFunciones.LABEL_CONRELACIONPORCENTAJE);
			reporte.setsDescripcion(ParametroProduConstantesFunciones.LABEL_CONRELACIONPORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroProduConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ParametroProduConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParametroProdu(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParametroProdu(ParametroProdu parametroproduAux) throws Exception {
		
			parametroproduAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametroproduAux.getEmpresa()));
			parametroproduAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametroproduAux.getSucursal()));
			parametroproduAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(parametroproduAux.getBodega()));
			parametroproduAux.setbodegamateriaprima_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(parametroproduAux.getBodegaMateriaPrima()));
			parametroproduAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametroproduAux.getTransaccion()));
			parametroproduAux.settransaccionegreso_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametroproduAux.getTransaccionEgreso()));		
	}
	
	public static void refrescarForeignKeysDescripcionesParametroProdu(List<ParametroProdu> parametroprodusTemp) throws Exception {
		for(ParametroProdu parametroproduAux:parametroprodusTemp) {
			
			parametroproduAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametroproduAux.getEmpresa()));
			parametroproduAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametroproduAux.getSucursal()));
			parametroproduAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(parametroproduAux.getBodega()));
			parametroproduAux.setbodegamateriaprima_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(parametroproduAux.getBodegaMateriaPrima()));
			parametroproduAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametroproduAux.getTransaccion()));
			parametroproduAux.settransaccionegreso_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametroproduAux.getTransaccionEgreso()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParametroProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Transaccion.class));
				
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
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParametroProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
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

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroProduConstantesFunciones.getClassesRelationshipsOfParametroProdu(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroProduConstantesFunciones.getClassesRelationshipsFromStringsOfParametroProdu(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ParametroProdu parametroprodu,List<ParametroProdu> parametroprodus,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ParametroProdu parametroproduEncontrado=null;
			
			for(ParametroProdu parametroproduLocal:parametroprodus) {
				if(parametroproduLocal.getId().equals(parametroprodu.getId())) {
					parametroproduEncontrado=parametroproduLocal;
					
					parametroproduLocal.setIsChanged(parametroprodu.getIsChanged());
					parametroproduLocal.setIsNew(parametroprodu.getIsNew());
					parametroproduLocal.setIsDeleted(parametroprodu.getIsDeleted());
					
					parametroproduLocal.setGeneralEntityOriginal(parametroprodu.getGeneralEntityOriginal());
					
					parametroproduLocal.setId(parametroprodu.getId());	
					parametroproduLocal.setVersionRow(parametroprodu.getVersionRow());	
					parametroproduLocal.setid_empresa(parametroprodu.getid_empresa());	
					parametroproduLocal.setid_sucursal(parametroprodu.getid_sucursal());	
					parametroproduLocal.setid_bodega(parametroprodu.getid_bodega());	
					parametroproduLocal.setid_bodega_materia_prima(parametroprodu.getid_bodega_materia_prima());	
					parametroproduLocal.setid_transaccion(parametroprodu.getid_transaccion());	
					parametroproduLocal.setid_transaccion_egreso(parametroprodu.getid_transaccion_egreso());	
					parametroproduLocal.setcon_relacion_porcentaje(parametroprodu.getcon_relacion_porcentaje());	
					parametroproduLocal.setdescripcion(parametroprodu.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!parametroprodu.getIsDeleted()) {
				if(!existe) {
					parametroprodus.add(parametroprodu);
				}
			} else {
				if(parametroproduEncontrado!=null && permiteQuitar)  {
					parametroprodus.remove(parametroproduEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ParametroProdu parametroprodu,List<ParametroProdu> parametroprodus) throws Exception {
		try	{			
			for(ParametroProdu parametroproduLocal:parametroprodus) {
				if(parametroproduLocal.getId().equals(parametroprodu.getId())) {
					parametroproduLocal.setIsSelected(parametroprodu.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParametroProdu(List<ParametroProdu> parametroprodusAux) throws Exception {
		//this.parametroprodusAux=parametroprodusAux;
		
		for(ParametroProdu parametroproduAux:parametroprodusAux) {
			if(parametroproduAux.getIsChanged()) {
				parametroproduAux.setIsChanged(false);
			}		
			
			if(parametroproduAux.getIsNew()) {
				parametroproduAux.setIsNew(false);
			}	
			
			if(parametroproduAux.getIsDeleted()) {
				parametroproduAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParametroProdu(ParametroProdu parametroproduAux) throws Exception {
		//this.parametroproduAux=parametroproduAux;
		
			if(parametroproduAux.getIsChanged()) {
				parametroproduAux.setIsChanged(false);
			}		
			
			if(parametroproduAux.getIsNew()) {
				parametroproduAux.setIsNew(false);
			}	
			
			if(parametroproduAux.getIsDeleted()) {
				parametroproduAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ParametroProdu parametroproduAsignar,ParametroProdu parametroprodu) throws Exception {
		parametroproduAsignar.setId(parametroprodu.getId());	
		parametroproduAsignar.setVersionRow(parametroprodu.getVersionRow());	
		parametroproduAsignar.setid_empresa(parametroprodu.getid_empresa());
		parametroproduAsignar.setempresa_descripcion(parametroprodu.getempresa_descripcion());	
		parametroproduAsignar.setid_sucursal(parametroprodu.getid_sucursal());
		parametroproduAsignar.setsucursal_descripcion(parametroprodu.getsucursal_descripcion());	
		parametroproduAsignar.setid_bodega(parametroprodu.getid_bodega());
		parametroproduAsignar.setbodega_descripcion(parametroprodu.getbodega_descripcion());	
		parametroproduAsignar.setid_bodega_materia_prima(parametroprodu.getid_bodega_materia_prima());
		parametroproduAsignar.setbodegamateriaprima_descripcion(parametroprodu.getbodegamateriaprima_descripcion());	
		parametroproduAsignar.setid_transaccion(parametroprodu.getid_transaccion());
		parametroproduAsignar.settransaccion_descripcion(parametroprodu.gettransaccion_descripcion());	
		parametroproduAsignar.setid_transaccion_egreso(parametroprodu.getid_transaccion_egreso());
		parametroproduAsignar.settransaccionegreso_descripcion(parametroprodu.gettransaccionegreso_descripcion());	
		parametroproduAsignar.setcon_relacion_porcentaje(parametroprodu.getcon_relacion_porcentaje());	
		parametroproduAsignar.setdescripcion(parametroprodu.getdescripcion());	
	}
	
	public static void inicializarParametroProdu(ParametroProdu parametroprodu) throws Exception {
		try {
				parametroprodu.setId(0L);	
					
				parametroprodu.setid_empresa(-1L);	
				parametroprodu.setid_sucursal(-1L);	
				parametroprodu.setid_bodega(-1L);	
				parametroprodu.setid_bodega_materia_prima(-1L);	
				parametroprodu.setid_transaccion(-1L);	
				parametroprodu.setid_transaccion_egreso(-1L);	
				parametroprodu.setcon_relacion_porcentaje(0L);	
				parametroprodu.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParametroProdu(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroProduConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroProduConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroProduConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroProduConstantesFunciones.LABEL_IDBODEGAMATERIAPRIMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroProduConstantesFunciones.LABEL_IDTRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroProduConstantesFunciones.LABEL_IDTRANSACCIONEGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroProduConstantesFunciones.LABEL_CONRELACIONPORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroProduConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParametroProdu(String sTipo,Row row,Workbook workbook,ParametroProdu parametroprodu,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroprodu.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroprodu.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroprodu.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroprodu.getbodegamateriaprima_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroprodu.gettransaccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroprodu.gettransaccionegreso_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroprodu.getcon_relacion_porcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroprodu.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParametroProdu=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParametroProdu() {
		return this.sFinalQueryParametroProdu;
	}
	
	public void setsFinalQueryParametroProdu(String sFinalQueryParametroProdu) {
		this.sFinalQueryParametroProdu= sFinalQueryParametroProdu;
	}
	
	public Border resaltarSeleccionarParametroProdu=null;
	
	public Border setResaltarSeleccionarParametroProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroProduBeanSwingJInternalFrame parametroproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parametroproduBeanSwingJInternalFrame.jTtoolBarParametroProdu.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParametroProdu= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParametroProdu() {
		return this.resaltarSeleccionarParametroProdu;
	}
	
	public void setResaltarSeleccionarParametroProdu(Border borderResaltarSeleccionarParametroProdu) {
		this.resaltarSeleccionarParametroProdu= borderResaltarSeleccionarParametroProdu;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParametroProdu=null;
	public Boolean mostraridParametroProdu=true;
	public Boolean activaridParametroProdu=true;

	public Border resaltarid_empresaParametroProdu=null;
	public Boolean mostrarid_empresaParametroProdu=true;
	public Boolean activarid_empresaParametroProdu=true;
	public Boolean cargarid_empresaParametroProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaParametroProdu=false;//ConEventDepend=true

	public Border resaltarid_sucursalParametroProdu=null;
	public Boolean mostrarid_sucursalParametroProdu=true;
	public Boolean activarid_sucursalParametroProdu=true;
	public Boolean cargarid_sucursalParametroProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalParametroProdu=false;//ConEventDepend=true

	public Border resaltarid_bodegaParametroProdu=null;
	public Boolean mostrarid_bodegaParametroProdu=true;
	public Boolean activarid_bodegaParametroProdu=true;
	public Boolean cargarid_bodegaParametroProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaParametroProdu=false;//ConEventDepend=true

	public Border resaltarid_bodega_materia_primaParametroProdu=null;
	public Boolean mostrarid_bodega_materia_primaParametroProdu=true;
	public Boolean activarid_bodega_materia_primaParametroProdu=true;
	public Boolean cargarid_bodega_materia_primaParametroProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodega_materia_primaParametroProdu=false;//ConEventDepend=true

	public Border resaltarid_transaccionParametroProdu=null;
	public Boolean mostrarid_transaccionParametroProdu=true;
	public Boolean activarid_transaccionParametroProdu=true;
	public Boolean cargarid_transaccionParametroProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccionParametroProdu=false;//ConEventDepend=true

	public Border resaltarid_transaccion_egresoParametroProdu=null;
	public Boolean mostrarid_transaccion_egresoParametroProdu=true;
	public Boolean activarid_transaccion_egresoParametroProdu=true;
	public Boolean cargarid_transaccion_egresoParametroProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_egresoParametroProdu=false;//ConEventDepend=true

	public Border resaltarcon_relacion_porcentajeParametroProdu=null;
	public Boolean mostrarcon_relacion_porcentajeParametroProdu=true;
	public Boolean activarcon_relacion_porcentajeParametroProdu=true;

	public Border resaltardescripcionParametroProdu=null;
	public Boolean mostrardescripcionParametroProdu=true;
	public Boolean activardescripcionParametroProdu=true;

	
	

	public Border setResaltaridParametroProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroProduBeanSwingJInternalFrame parametroproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroproduBeanSwingJInternalFrame.jTtoolBarParametroProdu.setBorder(borderResaltar);
		
		this.resaltaridParametroProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParametroProdu() {
		return this.resaltaridParametroProdu;
	}

	public void setResaltaridParametroProdu(Border borderResaltar) {
		this.resaltaridParametroProdu= borderResaltar;
	}

	public Boolean getMostraridParametroProdu() {
		return this.mostraridParametroProdu;
	}

	public void setMostraridParametroProdu(Boolean mostraridParametroProdu) {
		this.mostraridParametroProdu= mostraridParametroProdu;
	}

	public Boolean getActivaridParametroProdu() {
		return this.activaridParametroProdu;
	}

	public void setActivaridParametroProdu(Boolean activaridParametroProdu) {
		this.activaridParametroProdu= activaridParametroProdu;
	}

	public Border setResaltarid_empresaParametroProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroProduBeanSwingJInternalFrame parametroproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroproduBeanSwingJInternalFrame.jTtoolBarParametroProdu.setBorder(borderResaltar);
		
		this.resaltarid_empresaParametroProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaParametroProdu() {
		return this.resaltarid_empresaParametroProdu;
	}

	public void setResaltarid_empresaParametroProdu(Border borderResaltar) {
		this.resaltarid_empresaParametroProdu= borderResaltar;
	}

	public Boolean getMostrarid_empresaParametroProdu() {
		return this.mostrarid_empresaParametroProdu;
	}

	public void setMostrarid_empresaParametroProdu(Boolean mostrarid_empresaParametroProdu) {
		this.mostrarid_empresaParametroProdu= mostrarid_empresaParametroProdu;
	}

	public Boolean getActivarid_empresaParametroProdu() {
		return this.activarid_empresaParametroProdu;
	}

	public void setActivarid_empresaParametroProdu(Boolean activarid_empresaParametroProdu) {
		this.activarid_empresaParametroProdu= activarid_empresaParametroProdu;
	}

	public Boolean getCargarid_empresaParametroProdu() {
		return this.cargarid_empresaParametroProdu;
	}

	public void setCargarid_empresaParametroProdu(Boolean cargarid_empresaParametroProdu) {
		this.cargarid_empresaParametroProdu= cargarid_empresaParametroProdu;
	}

	public Border setResaltarid_sucursalParametroProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroProduBeanSwingJInternalFrame parametroproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroproduBeanSwingJInternalFrame.jTtoolBarParametroProdu.setBorder(borderResaltar);
		
		this.resaltarid_sucursalParametroProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalParametroProdu() {
		return this.resaltarid_sucursalParametroProdu;
	}

	public void setResaltarid_sucursalParametroProdu(Border borderResaltar) {
		this.resaltarid_sucursalParametroProdu= borderResaltar;
	}

	public Boolean getMostrarid_sucursalParametroProdu() {
		return this.mostrarid_sucursalParametroProdu;
	}

	public void setMostrarid_sucursalParametroProdu(Boolean mostrarid_sucursalParametroProdu) {
		this.mostrarid_sucursalParametroProdu= mostrarid_sucursalParametroProdu;
	}

	public Boolean getActivarid_sucursalParametroProdu() {
		return this.activarid_sucursalParametroProdu;
	}

	public void setActivarid_sucursalParametroProdu(Boolean activarid_sucursalParametroProdu) {
		this.activarid_sucursalParametroProdu= activarid_sucursalParametroProdu;
	}

	public Boolean getCargarid_sucursalParametroProdu() {
		return this.cargarid_sucursalParametroProdu;
	}

	public void setCargarid_sucursalParametroProdu(Boolean cargarid_sucursalParametroProdu) {
		this.cargarid_sucursalParametroProdu= cargarid_sucursalParametroProdu;
	}

	public Border setResaltarid_bodegaParametroProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroProduBeanSwingJInternalFrame parametroproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroproduBeanSwingJInternalFrame.jTtoolBarParametroProdu.setBorder(borderResaltar);
		
		this.resaltarid_bodegaParametroProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaParametroProdu() {
		return this.resaltarid_bodegaParametroProdu;
	}

	public void setResaltarid_bodegaParametroProdu(Border borderResaltar) {
		this.resaltarid_bodegaParametroProdu= borderResaltar;
	}

	public Boolean getMostrarid_bodegaParametroProdu() {
		return this.mostrarid_bodegaParametroProdu;
	}

	public void setMostrarid_bodegaParametroProdu(Boolean mostrarid_bodegaParametroProdu) {
		this.mostrarid_bodegaParametroProdu= mostrarid_bodegaParametroProdu;
	}

	public Boolean getActivarid_bodegaParametroProdu() {
		return this.activarid_bodegaParametroProdu;
	}

	public void setActivarid_bodegaParametroProdu(Boolean activarid_bodegaParametroProdu) {
		this.activarid_bodegaParametroProdu= activarid_bodegaParametroProdu;
	}

	public Boolean getCargarid_bodegaParametroProdu() {
		return this.cargarid_bodegaParametroProdu;
	}

	public void setCargarid_bodegaParametroProdu(Boolean cargarid_bodegaParametroProdu) {
		this.cargarid_bodegaParametroProdu= cargarid_bodegaParametroProdu;
	}

	public Border setResaltarid_bodega_materia_primaParametroProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroProduBeanSwingJInternalFrame parametroproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroproduBeanSwingJInternalFrame.jTtoolBarParametroProdu.setBorder(borderResaltar);
		
		this.resaltarid_bodega_materia_primaParametroProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodega_materia_primaParametroProdu() {
		return this.resaltarid_bodega_materia_primaParametroProdu;
	}

	public void setResaltarid_bodega_materia_primaParametroProdu(Border borderResaltar) {
		this.resaltarid_bodega_materia_primaParametroProdu= borderResaltar;
	}

	public Boolean getMostrarid_bodega_materia_primaParametroProdu() {
		return this.mostrarid_bodega_materia_primaParametroProdu;
	}

	public void setMostrarid_bodega_materia_primaParametroProdu(Boolean mostrarid_bodega_materia_primaParametroProdu) {
		this.mostrarid_bodega_materia_primaParametroProdu= mostrarid_bodega_materia_primaParametroProdu;
	}

	public Boolean getActivarid_bodega_materia_primaParametroProdu() {
		return this.activarid_bodega_materia_primaParametroProdu;
	}

	public void setActivarid_bodega_materia_primaParametroProdu(Boolean activarid_bodega_materia_primaParametroProdu) {
		this.activarid_bodega_materia_primaParametroProdu= activarid_bodega_materia_primaParametroProdu;
	}

	public Boolean getCargarid_bodega_materia_primaParametroProdu() {
		return this.cargarid_bodega_materia_primaParametroProdu;
	}

	public void setCargarid_bodega_materia_primaParametroProdu(Boolean cargarid_bodega_materia_primaParametroProdu) {
		this.cargarid_bodega_materia_primaParametroProdu= cargarid_bodega_materia_primaParametroProdu;
	}

	public Border setResaltarid_transaccionParametroProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroProduBeanSwingJInternalFrame parametroproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroproduBeanSwingJInternalFrame.jTtoolBarParametroProdu.setBorder(borderResaltar);
		
		this.resaltarid_transaccionParametroProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccionParametroProdu() {
		return this.resaltarid_transaccionParametroProdu;
	}

	public void setResaltarid_transaccionParametroProdu(Border borderResaltar) {
		this.resaltarid_transaccionParametroProdu= borderResaltar;
	}

	public Boolean getMostrarid_transaccionParametroProdu() {
		return this.mostrarid_transaccionParametroProdu;
	}

	public void setMostrarid_transaccionParametroProdu(Boolean mostrarid_transaccionParametroProdu) {
		this.mostrarid_transaccionParametroProdu= mostrarid_transaccionParametroProdu;
	}

	public Boolean getActivarid_transaccionParametroProdu() {
		return this.activarid_transaccionParametroProdu;
	}

	public void setActivarid_transaccionParametroProdu(Boolean activarid_transaccionParametroProdu) {
		this.activarid_transaccionParametroProdu= activarid_transaccionParametroProdu;
	}

	public Boolean getCargarid_transaccionParametroProdu() {
		return this.cargarid_transaccionParametroProdu;
	}

	public void setCargarid_transaccionParametroProdu(Boolean cargarid_transaccionParametroProdu) {
		this.cargarid_transaccionParametroProdu= cargarid_transaccionParametroProdu;
	}

	public Border setResaltarid_transaccion_egresoParametroProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroProduBeanSwingJInternalFrame parametroproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroproduBeanSwingJInternalFrame.jTtoolBarParametroProdu.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_egresoParametroProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_egresoParametroProdu() {
		return this.resaltarid_transaccion_egresoParametroProdu;
	}

	public void setResaltarid_transaccion_egresoParametroProdu(Border borderResaltar) {
		this.resaltarid_transaccion_egresoParametroProdu= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_egresoParametroProdu() {
		return this.mostrarid_transaccion_egresoParametroProdu;
	}

	public void setMostrarid_transaccion_egresoParametroProdu(Boolean mostrarid_transaccion_egresoParametroProdu) {
		this.mostrarid_transaccion_egresoParametroProdu= mostrarid_transaccion_egresoParametroProdu;
	}

	public Boolean getActivarid_transaccion_egresoParametroProdu() {
		return this.activarid_transaccion_egresoParametroProdu;
	}

	public void setActivarid_transaccion_egresoParametroProdu(Boolean activarid_transaccion_egresoParametroProdu) {
		this.activarid_transaccion_egresoParametroProdu= activarid_transaccion_egresoParametroProdu;
	}

	public Boolean getCargarid_transaccion_egresoParametroProdu() {
		return this.cargarid_transaccion_egresoParametroProdu;
	}

	public void setCargarid_transaccion_egresoParametroProdu(Boolean cargarid_transaccion_egresoParametroProdu) {
		this.cargarid_transaccion_egresoParametroProdu= cargarid_transaccion_egresoParametroProdu;
	}

	public Border setResaltarcon_relacion_porcentajeParametroProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroProduBeanSwingJInternalFrame parametroproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroproduBeanSwingJInternalFrame.jTtoolBarParametroProdu.setBorder(borderResaltar);
		
		this.resaltarcon_relacion_porcentajeParametroProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_relacion_porcentajeParametroProdu() {
		return this.resaltarcon_relacion_porcentajeParametroProdu;
	}

	public void setResaltarcon_relacion_porcentajeParametroProdu(Border borderResaltar) {
		this.resaltarcon_relacion_porcentajeParametroProdu= borderResaltar;
	}

	public Boolean getMostrarcon_relacion_porcentajeParametroProdu() {
		return this.mostrarcon_relacion_porcentajeParametroProdu;
	}

	public void setMostrarcon_relacion_porcentajeParametroProdu(Boolean mostrarcon_relacion_porcentajeParametroProdu) {
		this.mostrarcon_relacion_porcentajeParametroProdu= mostrarcon_relacion_porcentajeParametroProdu;
	}

	public Boolean getActivarcon_relacion_porcentajeParametroProdu() {
		return this.activarcon_relacion_porcentajeParametroProdu;
	}

	public void setActivarcon_relacion_porcentajeParametroProdu(Boolean activarcon_relacion_porcentajeParametroProdu) {
		this.activarcon_relacion_porcentajeParametroProdu= activarcon_relacion_porcentajeParametroProdu;
	}

	public Border setResaltardescripcionParametroProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroProduBeanSwingJInternalFrame parametroproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametroproduBeanSwingJInternalFrame.jTtoolBarParametroProdu.setBorder(borderResaltar);
		
		this.resaltardescripcionParametroProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionParametroProdu() {
		return this.resaltardescripcionParametroProdu;
	}

	public void setResaltardescripcionParametroProdu(Border borderResaltar) {
		this.resaltardescripcionParametroProdu= borderResaltar;
	}

	public Boolean getMostrardescripcionParametroProdu() {
		return this.mostrardescripcionParametroProdu;
	}

	public void setMostrardescripcionParametroProdu(Boolean mostrardescripcionParametroProdu) {
		this.mostrardescripcionParametroProdu= mostrardescripcionParametroProdu;
	}

	public Boolean getActivardescripcionParametroProdu() {
		return this.activardescripcionParametroProdu;
	}

	public void setActivardescripcionParametroProdu(Boolean activardescripcionParametroProdu) {
		this.activardescripcionParametroProdu= activardescripcionParametroProdu;
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
		
		
		this.setMostraridParametroProdu(esInicial);
		this.setMostrarid_empresaParametroProdu(esInicial);
		this.setMostrarid_sucursalParametroProdu(esInicial);
		this.setMostrarid_bodegaParametroProdu(esInicial);
		this.setMostrarid_bodega_materia_primaParametroProdu(esInicial);
		this.setMostrarid_transaccionParametroProdu(esInicial);
		this.setMostrarid_transaccion_egresoParametroProdu(esInicial);
		this.setMostrarcon_relacion_porcentajeParametroProdu(esInicial);
		this.setMostrardescripcionParametroProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroProduConstantesFunciones.ID)) {
				this.setMostraridParametroProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProduConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaParametroProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProduConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalParametroProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProduConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaParametroProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProduConstantesFunciones.IDBODEGAMATERIAPRIMA)) {
				this.setMostrarid_bodega_materia_primaParametroProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProduConstantesFunciones.IDTRANSACCION)) {
				this.setMostrarid_transaccionParametroProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProduConstantesFunciones.IDTRANSACCIONEGRESO)) {
				this.setMostrarid_transaccion_egresoParametroProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProduConstantesFunciones.CONRELACIONPORCENTAJE)) {
				this.setMostrarcon_relacion_porcentajeParametroProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProduConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionParametroProdu(esAsigna);
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
		
		
		this.setActivaridParametroProdu(esInicial);
		this.setActivarid_empresaParametroProdu(esInicial);
		this.setActivarid_sucursalParametroProdu(esInicial);
		this.setActivarid_bodegaParametroProdu(esInicial);
		this.setActivarid_bodega_materia_primaParametroProdu(esInicial);
		this.setActivarid_transaccionParametroProdu(esInicial);
		this.setActivarid_transaccion_egresoParametroProdu(esInicial);
		this.setActivarcon_relacion_porcentajeParametroProdu(esInicial);
		this.setActivardescripcionParametroProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroProduConstantesFunciones.ID)) {
				this.setActivaridParametroProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProduConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaParametroProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProduConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalParametroProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProduConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaParametroProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProduConstantesFunciones.IDBODEGAMATERIAPRIMA)) {
				this.setActivarid_bodega_materia_primaParametroProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProduConstantesFunciones.IDTRANSACCION)) {
				this.setActivarid_transaccionParametroProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProduConstantesFunciones.IDTRANSACCIONEGRESO)) {
				this.setActivarid_transaccion_egresoParametroProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProduConstantesFunciones.CONRELACIONPORCENTAJE)) {
				this.setActivarcon_relacion_porcentajeParametroProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProduConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionParametroProdu(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroProduBeanSwingJInternalFrame parametroproduBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParametroProdu(esInicial);
		this.setResaltarid_empresaParametroProdu(esInicial);
		this.setResaltarid_sucursalParametroProdu(esInicial);
		this.setResaltarid_bodegaParametroProdu(esInicial);
		this.setResaltarid_bodega_materia_primaParametroProdu(esInicial);
		this.setResaltarid_transaccionParametroProdu(esInicial);
		this.setResaltarid_transaccion_egresoParametroProdu(esInicial);
		this.setResaltarcon_relacion_porcentajeParametroProdu(esInicial);
		this.setResaltardescripcionParametroProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroProduConstantesFunciones.ID)) {
				this.setResaltaridParametroProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProduConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaParametroProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProduConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalParametroProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProduConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaParametroProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProduConstantesFunciones.IDBODEGAMATERIAPRIMA)) {
				this.setResaltarid_bodega_materia_primaParametroProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProduConstantesFunciones.IDTRANSACCION)) {
				this.setResaltarid_transaccionParametroProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProduConstantesFunciones.IDTRANSACCIONEGRESO)) {
				this.setResaltarid_transaccion_egresoParametroProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProduConstantesFunciones.CONRELACIONPORCENTAJE)) {
				this.setResaltarcon_relacion_porcentajeParametroProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroProduConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionParametroProdu(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroProduBeanSwingJInternalFrame parametroproduBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaParametroProdu=true;

	public Boolean getMostrarFK_IdBodegaParametroProdu() {
		return this.mostrarFK_IdBodegaParametroProdu;
	}

	public void setMostrarFK_IdBodegaParametroProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaParametroProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdBodegaMateriaPrimaParametroProdu=true;

	public Boolean getMostrarFK_IdBodegaMateriaPrimaParametroProdu() {
		return this.mostrarFK_IdBodegaMateriaPrimaParametroProdu;
	}

	public void setMostrarFK_IdBodegaMateriaPrimaParametroProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaMateriaPrimaParametroProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaParametroProdu=true;

	public Boolean getMostrarFK_IdEmpresaParametroProdu() {
		return this.mostrarFK_IdEmpresaParametroProdu;
	}

	public void setMostrarFK_IdEmpresaParametroProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaParametroProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalParametroProdu=true;

	public Boolean getMostrarFK_IdSucursalParametroProdu() {
		return this.mostrarFK_IdSucursalParametroProdu;
	}

	public void setMostrarFK_IdSucursalParametroProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalParametroProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionParametroProdu=true;

	public Boolean getMostrarFK_IdTransaccionParametroProdu() {
		return this.mostrarFK_IdTransaccionParametroProdu;
	}

	public void setMostrarFK_IdTransaccionParametroProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionParametroProdu= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionEgresoParametroProdu=true;

	public Boolean getMostrarFK_IdTransaccionEgresoParametroProdu() {
		return this.mostrarFK_IdTransaccionEgresoParametroProdu;
	}

	public void setMostrarFK_IdTransaccionEgresoParametroProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionEgresoParametroProdu= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaParametroProdu=true;

	public Boolean getActivarFK_IdBodegaParametroProdu() {
		return this.activarFK_IdBodegaParametroProdu;
	}

	public void setActivarFK_IdBodegaParametroProdu(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaParametroProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdBodegaMateriaPrimaParametroProdu=true;

	public Boolean getActivarFK_IdBodegaMateriaPrimaParametroProdu() {
		return this.activarFK_IdBodegaMateriaPrimaParametroProdu;
	}

	public void setActivarFK_IdBodegaMateriaPrimaParametroProdu(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaMateriaPrimaParametroProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaParametroProdu=true;

	public Boolean getActivarFK_IdEmpresaParametroProdu() {
		return this.activarFK_IdEmpresaParametroProdu;
	}

	public void setActivarFK_IdEmpresaParametroProdu(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaParametroProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalParametroProdu=true;

	public Boolean getActivarFK_IdSucursalParametroProdu() {
		return this.activarFK_IdSucursalParametroProdu;
	}

	public void setActivarFK_IdSucursalParametroProdu(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalParametroProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionParametroProdu=true;

	public Boolean getActivarFK_IdTransaccionParametroProdu() {
		return this.activarFK_IdTransaccionParametroProdu;
	}

	public void setActivarFK_IdTransaccionParametroProdu(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionParametroProdu= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionEgresoParametroProdu=true;

	public Boolean getActivarFK_IdTransaccionEgresoParametroProdu() {
		return this.activarFK_IdTransaccionEgresoParametroProdu;
	}

	public void setActivarFK_IdTransaccionEgresoParametroProdu(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionEgresoParametroProdu= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaParametroProdu=null;

	public Border getResaltarFK_IdBodegaParametroProdu() {
		return this.resaltarFK_IdBodegaParametroProdu;
	}

	public void setResaltarFK_IdBodegaParametroProdu(Border borderResaltar) {
		this.resaltarFK_IdBodegaParametroProdu= borderResaltar;
	}

	public void setResaltarFK_IdBodegaParametroProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroProduBeanSwingJInternalFrame parametroproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaParametroProdu= borderResaltar;
	}

	public Border resaltarFK_IdBodegaMateriaPrimaParametroProdu=null;

	public Border getResaltarFK_IdBodegaMateriaPrimaParametroProdu() {
		return this.resaltarFK_IdBodegaMateriaPrimaParametroProdu;
	}

	public void setResaltarFK_IdBodegaMateriaPrimaParametroProdu(Border borderResaltar) {
		this.resaltarFK_IdBodegaMateriaPrimaParametroProdu= borderResaltar;
	}

	public void setResaltarFK_IdBodegaMateriaPrimaParametroProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroProduBeanSwingJInternalFrame parametroproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaMateriaPrimaParametroProdu= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaParametroProdu=null;

	public Border getResaltarFK_IdEmpresaParametroProdu() {
		return this.resaltarFK_IdEmpresaParametroProdu;
	}

	public void setResaltarFK_IdEmpresaParametroProdu(Border borderResaltar) {
		this.resaltarFK_IdEmpresaParametroProdu= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaParametroProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroProduBeanSwingJInternalFrame parametroproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaParametroProdu= borderResaltar;
	}

	public Border resaltarFK_IdSucursalParametroProdu=null;

	public Border getResaltarFK_IdSucursalParametroProdu() {
		return this.resaltarFK_IdSucursalParametroProdu;
	}

	public void setResaltarFK_IdSucursalParametroProdu(Border borderResaltar) {
		this.resaltarFK_IdSucursalParametroProdu= borderResaltar;
	}

	public void setResaltarFK_IdSucursalParametroProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroProduBeanSwingJInternalFrame parametroproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalParametroProdu= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionParametroProdu=null;

	public Border getResaltarFK_IdTransaccionParametroProdu() {
		return this.resaltarFK_IdTransaccionParametroProdu;
	}

	public void setResaltarFK_IdTransaccionParametroProdu(Border borderResaltar) {
		this.resaltarFK_IdTransaccionParametroProdu= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionParametroProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroProduBeanSwingJInternalFrame parametroproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionParametroProdu= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionEgresoParametroProdu=null;

	public Border getResaltarFK_IdTransaccionEgresoParametroProdu() {
		return this.resaltarFK_IdTransaccionEgresoParametroProdu;
	}

	public void setResaltarFK_IdTransaccionEgresoParametroProdu(Border borderResaltar) {
		this.resaltarFK_IdTransaccionEgresoParametroProdu= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionEgresoParametroProdu(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroProduBeanSwingJInternalFrame parametroproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionEgresoParametroProdu= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}