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


import com.bydan.erp.facturacion.util.CuentaContableTipoConstantesFunciones;
import com.bydan.erp.facturacion.util.CuentaContableTipoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.CuentaContableTipoParameterGeneral;

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
final public class CuentaContableTipoConstantesFunciones extends CuentaContableTipoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CuentaContableTipo";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CuentaContableTipo"+CuentaContableTipoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CuentaContableTipoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CuentaContableTipoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CuentaContableTipoConstantesFunciones.SCHEMA+"_"+CuentaContableTipoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CuentaContableTipoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CuentaContableTipoConstantesFunciones.SCHEMA+"_"+CuentaContableTipoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CuentaContableTipoConstantesFunciones.SCHEMA+"_"+CuentaContableTipoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CuentaContableTipoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CuentaContableTipoConstantesFunciones.SCHEMA+"_"+CuentaContableTipoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaContableTipoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CuentaContableTipoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaContableTipoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaContableTipoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CuentaContableTipoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaContableTipoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CuentaContableTipoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CuentaContableTipoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CuentaContableTipoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CuentaContableTipoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cuenta Contable Tipos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Cuenta Contable Tipo";
	public static final String SCLASSWEBTITULO_LOWER="Cuenta Contable Tipo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CuentaContableTipo";
	public static final String OBJECTNAME="cuentacontabletipo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="cuenta_contable_tipo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cuentacontabletipo from "+CuentaContableTipoConstantesFunciones.SPERSISTENCENAME+" cuentacontabletipo";
	public static String QUERYSELECTNATIVE="select "+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME+".id,"+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME+".version_row,"+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME+".id_empresa,"+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME+".nombre,"+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME+".digito_verificador,"+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME+".id_tipo_cuenta_contable_tipo,"+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME+".id_tipo_producto_servicio,"+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME+".id_cuenta_contable_venta,"+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME+".id_cuenta_contable_descuento,"+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME+".id_cuenta_contable_devolucion,"+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME+".id_cuenta_contable_costo from "+CuentaContableTipoConstantesFunciones.SCHEMA+"."+CuentaContableTipoConstantesFunciones.TABLENAME;//+" as "+CuentaContableTipoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CuentaContableTipoConstantesFuncionesAdditional cuentacontabletipoConstantesFuncionesAdditional=null;
	
	public CuentaContableTipoConstantesFuncionesAdditional getCuentaContableTipoConstantesFuncionesAdditional() {
		return this.cuentacontabletipoConstantesFuncionesAdditional;
	}
	
	public void setCuentaContableTipoConstantesFuncionesAdditional(CuentaContableTipoConstantesFuncionesAdditional cuentacontabletipoConstantesFuncionesAdditional) {
		try {
			this.cuentacontabletipoConstantesFuncionesAdditional=cuentacontabletipoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRE= "nombre";
    public static final String DIGITOVERIFICADOR= "digito_verificador";
    public static final String IDTIPOCUENTACONTABLETIPO= "id_tipo_cuenta_contable_tipo";
    public static final String IDTIPOPRODUCTOSERVICIO= "id_tipo_producto_servicio";
    public static final String IDCUENTACONTABLEVENTA= "id_cuenta_contable_venta";
    public static final String IDCUENTACONTABLEDESCUENTO= "id_cuenta_contable_descuento";
    public static final String IDCUENTACONTABLEDEVOLUCION= "id_cuenta_contable_devolucion";
    public static final String IDCUENTACONTABLECOSTO= "id_cuenta_contable_costo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DIGITOVERIFICADOR= "Digito Verificador";
		public static final String LABEL_DIGITOVERIFICADOR_LOWER= "Digito Verificador";
    	public static final String LABEL_IDTIPOCUENTACONTABLETIPO= "T. Cuenta Contable Tipo";
		public static final String LABEL_IDTIPOCUENTACONTABLETIPO_LOWER= "Tipo Cuenta Contable Tipo";
    	public static final String LABEL_IDTIPOPRODUCTOSERVICIO= "T. Producto Servicio";
		public static final String LABEL_IDTIPOPRODUCTOSERVICIO_LOWER= "Tipo Producto Servicio";
    	public static final String LABEL_IDCUENTACONTABLEVENTA= "C. Contable Venta";
		public static final String LABEL_IDCUENTACONTABLEVENTA_LOWER= "Cuenta Contable Venta";
    	public static final String LABEL_IDCUENTACONTABLEDESCUENTO= "C. Contable Descuento";
		public static final String LABEL_IDCUENTACONTABLEDESCUENTO_LOWER= "Cuenta Contable Descuento";
    	public static final String LABEL_IDCUENTACONTABLEDEVOLUCION= "C. Contable Devolucion";
		public static final String LABEL_IDCUENTACONTABLEDEVOLUCION_LOWER= "Cuenta Contable Devolucion";
    	public static final String LABEL_IDCUENTACONTABLECOSTO= "C. Contable Costo";
		public static final String LABEL_IDCUENTACONTABLECOSTO_LOWER= "Cuenta Contable Costo";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	
	public static String getCuentaContableTipoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CuentaContableTipoConstantesFunciones.IDEMPRESA)) {sLabelColumna=CuentaContableTipoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CuentaContableTipoConstantesFunciones.NOMBRE)) {sLabelColumna=CuentaContableTipoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(CuentaContableTipoConstantesFunciones.DIGITOVERIFICADOR)) {sLabelColumna=CuentaContableTipoConstantesFunciones.LABEL_DIGITOVERIFICADOR;}
		if(sNombreColumna.equals(CuentaContableTipoConstantesFunciones.IDTIPOCUENTACONTABLETIPO)) {sLabelColumna=CuentaContableTipoConstantesFunciones.LABEL_IDTIPOCUENTACONTABLETIPO;}
		if(sNombreColumna.equals(CuentaContableTipoConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {sLabelColumna=CuentaContableTipoConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO;}
		if(sNombreColumna.equals(CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEVENTA)) {sLabelColumna=CuentaContableTipoConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA;}
		if(sNombreColumna.equals(CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEDESCUENTO)) {sLabelColumna=CuentaContableTipoConstantesFunciones.LABEL_IDCUENTACONTABLEDESCUENTO;}
		if(sNombreColumna.equals(CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION)) {sLabelColumna=CuentaContableTipoConstantesFunciones.LABEL_IDCUENTACONTABLEDEVOLUCION;}
		if(sNombreColumna.equals(CuentaContableTipoConstantesFunciones.IDCUENTACONTABLECOSTO)) {sLabelColumna=CuentaContableTipoConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getCuentaContableTipoDescripcion(CuentaContableTipo cuentacontabletipo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cuentacontabletipo !=null/* && cuentacontabletipo.getId()!=0*/) {
			sDescripcion=cuentacontabletipo.getnombre();//cuentacontabletipocuentacontabletipo.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getCuentaContableTipoDescripcionDetallado(CuentaContableTipo cuentacontabletipo) {
		String sDescripcion="";
			
		sDescripcion+=CuentaContableTipoConstantesFunciones.ID+"=";
		sDescripcion+=cuentacontabletipo.getId().toString()+",";
		sDescripcion+=CuentaContableTipoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cuentacontabletipo.getVersionRow().toString()+",";
		sDescripcion+=CuentaContableTipoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cuentacontabletipo.getid_empresa().toString()+",";
		sDescripcion+=CuentaContableTipoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=cuentacontabletipo.getnombre()+",";
		sDescripcion+=CuentaContableTipoConstantesFunciones.DIGITOVERIFICADOR+"=";
		sDescripcion+=cuentacontabletipo.getdigito_verificador().toString()+",";
		sDescripcion+=CuentaContableTipoConstantesFunciones.IDTIPOCUENTACONTABLETIPO+"=";
		sDescripcion+=cuentacontabletipo.getid_tipo_cuenta_contable_tipo().toString()+",";
		sDescripcion+=CuentaContableTipoConstantesFunciones.IDTIPOPRODUCTOSERVICIO+"=";
		sDescripcion+=cuentacontabletipo.getid_tipo_producto_servicio().toString()+",";
		sDescripcion+=CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEVENTA+"=";
		sDescripcion+=cuentacontabletipo.getid_cuenta_contable_venta().toString()+",";
		sDescripcion+=CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEDESCUENTO+"=";
		sDescripcion+=cuentacontabletipo.getid_cuenta_contable_descuento().toString()+",";
		sDescripcion+=CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION+"=";
		sDescripcion+=cuentacontabletipo.getid_cuenta_contable_devolucion().toString()+",";
		sDescripcion+=CuentaContableTipoConstantesFunciones.IDCUENTACONTABLECOSTO+"=";
		sDescripcion+=cuentacontabletipo.getid_cuenta_contable_costo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCuentaContableTipoDescripcion(CuentaContableTipo cuentacontabletipo,String sValor) throws Exception {			
		if(cuentacontabletipo !=null) {
			cuentacontabletipo.setnombre(sValor);//cuentacontabletipocuentacontabletipo.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getTipoCuentaContableTipoDescripcion(TipoCuentaContableTipo tipocuentacontabletipo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocuentacontabletipo!=null/*&&tipocuentacontabletipo.getId()>0*/) {
			sDescripcion=TipoCuentaContableTipoConstantesFunciones.getTipoCuentaContableTipoDescripcion(tipocuentacontabletipo);
		}

		return sDescripcion;
	}

	public static String getTipoProductoServicioDescripcion(TipoProductoServicio tipoproductoservicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoproductoservicio!=null/*&&tipoproductoservicio.getId()>0*/) {
			sDescripcion=TipoProductoServicioConstantesFunciones.getTipoProductoServicioDescripcion(tipoproductoservicio);
		}

		return sDescripcion;
	}

	public static String getCuentaContableVentaDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDescuentoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDevolucionDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableCostoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCosto")) {
			sNombreIndice="Tipo=  Por C. Contable Costo";
		} else if(sNombreIndice.equals("FK_IdCuentaContableDescuento")) {
			sNombreIndice="Tipo=  Por C. Contable Descuento";
		} else if(sNombreIndice.equals("FK_IdCuentaContableDevolucion")) {
			sNombreIndice="Tipo=  Por C. Contable Devolucion";
		} else if(sNombreIndice.equals("FK_IdCuentaContableVenta")) {
			sNombreIndice="Tipo=  Por C. Contable Venta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoCuentaContableTipo")) {
			sNombreIndice="Tipo=  Por T. Cuenta Contable Tipo";
		} else if(sNombreIndice.equals("FK_IdTipoProductoServicio")) {
			sNombreIndice="Tipo=  Por T. Producto Servicio";
		} else if(sNombreIndice.equals("PorIdEmpresaPorIdTipoCuentaPorIdTipoProdu")) {
			sNombreIndice="Tipo=  Por Empresa Por T. Cuenta Contable Tipo Por T. Producto Servicio";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableCosto(Long id_cuenta_contable_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_costo!=null) {sDetalleIndice+=" Codigo Unico De C. Contable Costo="+id_cuenta_contable_costo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableDescuento(Long id_cuenta_contable_descuento) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_descuento!=null) {sDetalleIndice+=" Codigo Unico De C. Contable Descuento="+id_cuenta_contable_descuento.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableDevolucion(Long id_cuenta_contable_devolucion) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_devolucion!=null) {sDetalleIndice+=" Codigo Unico De C. Contable Devolucion="+id_cuenta_contable_devolucion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableVenta(Long id_cuenta_contable_venta) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_venta!=null) {sDetalleIndice+=" Codigo Unico De C. Contable Venta="+id_cuenta_contable_venta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoCuentaContableTipo(Long id_tipo_cuenta_contable_tipo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_cuenta_contable_tipo!=null) {sDetalleIndice+=" Codigo Unico De T. Cuenta Contable Tipo="+id_tipo_cuenta_contable_tipo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoProductoServicio(Long id_tipo_producto_servicio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_producto_servicio!=null) {sDetalleIndice+=" Codigo Unico De T. Producto Servicio="+id_tipo_producto_servicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorIdEmpresaPorIdTipoCuentaPorIdTipoProdu(Long id_empresa,Long id_tipo_cuenta_contable_tipo,Long id_tipo_producto_servicio) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();}
		if(id_tipo_cuenta_contable_tipo!=null) {sDetalleIndice+=" Codigo Unico De T. Cuenta Contable Tipo="+id_tipo_cuenta_contable_tipo.toString();}
		if(id_tipo_producto_servicio!=null) {sDetalleIndice+=" Codigo Unico De T. Producto Servicio="+id_tipo_producto_servicio.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCuentaContableTipo(CuentaContableTipo cuentacontabletipo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cuentacontabletipo.setnombre(cuentacontabletipo.getnombre().trim());
	}
	
	public static void quitarEspaciosCuentaContableTipos(List<CuentaContableTipo> cuentacontabletipos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CuentaContableTipo cuentacontabletipo: cuentacontabletipos) {
			cuentacontabletipo.setnombre(cuentacontabletipo.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCuentaContableTipo(CuentaContableTipo cuentacontabletipo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cuentacontabletipo.getConCambioAuxiliar()) {
			cuentacontabletipo.setIsDeleted(cuentacontabletipo.getIsDeletedAuxiliar());	
			cuentacontabletipo.setIsNew(cuentacontabletipo.getIsNewAuxiliar());	
			cuentacontabletipo.setIsChanged(cuentacontabletipo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cuentacontabletipo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cuentacontabletipo.setIsDeletedAuxiliar(false);	
			cuentacontabletipo.setIsNewAuxiliar(false);	
			cuentacontabletipo.setIsChangedAuxiliar(false);
			
			cuentacontabletipo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCuentaContableTipos(List<CuentaContableTipo> cuentacontabletipos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CuentaContableTipo cuentacontabletipo : cuentacontabletipos) {
			if(conAsignarBase && cuentacontabletipo.getConCambioAuxiliar()) {
				cuentacontabletipo.setIsDeleted(cuentacontabletipo.getIsDeletedAuxiliar());	
				cuentacontabletipo.setIsNew(cuentacontabletipo.getIsNewAuxiliar());	
				cuentacontabletipo.setIsChanged(cuentacontabletipo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cuentacontabletipo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cuentacontabletipo.setIsDeletedAuxiliar(false);	
				cuentacontabletipo.setIsNewAuxiliar(false);	
				cuentacontabletipo.setIsChangedAuxiliar(false);
				
				cuentacontabletipo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCuentaContableTipo(CuentaContableTipo cuentacontabletipo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			cuentacontabletipo.setdigito_verificador(0);
		}
	}		
	
	public static void InicializarValoresCuentaContableTipos(List<CuentaContableTipo> cuentacontabletipos,Boolean conEnteros) throws Exception  {
		
		for(CuentaContableTipo cuentacontabletipo: cuentacontabletipos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				cuentacontabletipo.setdigito_verificador(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaCuentaContableTipo(List<CuentaContableTipo> cuentacontabletipos,CuentaContableTipo cuentacontabletipoAux) throws Exception  {
		CuentaContableTipoConstantesFunciones.InicializarValoresCuentaContableTipo(cuentacontabletipoAux,true);
		
		for(CuentaContableTipo cuentacontabletipo: cuentacontabletipos) {
			if(cuentacontabletipo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cuentacontabletipoAux.setdigito_verificador(cuentacontabletipoAux.getdigito_verificador()+cuentacontabletipo.getdigito_verificador());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCuentaContableTipo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CuentaContableTipoConstantesFunciones.getArrayColumnasGlobalesCuentaContableTipo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCuentaContableTipo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CuentaContableTipoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CuentaContableTipoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCuentaContableTipo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CuentaContableTipo> cuentacontabletipos,CuentaContableTipo cuentacontabletipo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CuentaContableTipo cuentacontabletipoAux: cuentacontabletipos) {
			if(cuentacontabletipoAux!=null && cuentacontabletipo!=null) {
				if((cuentacontabletipoAux.getId()==null && cuentacontabletipo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cuentacontabletipoAux.getId()!=null && cuentacontabletipo.getId()!=null){
					if(cuentacontabletipoAux.getId().equals(cuentacontabletipo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCuentaContableTipo(List<CuentaContableTipo> cuentacontabletipos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CuentaContableTipo cuentacontabletipo: cuentacontabletipos) {			
			if(cuentacontabletipo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCuentaContableTipo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CuentaContableTipoConstantesFunciones.LABEL_ID, CuentaContableTipoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableTipoConstantesFunciones.LABEL_VERSIONROW, CuentaContableTipoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableTipoConstantesFunciones.LABEL_IDEMPRESA, CuentaContableTipoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableTipoConstantesFunciones.LABEL_NOMBRE, CuentaContableTipoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableTipoConstantesFunciones.LABEL_DIGITOVERIFICADOR, CuentaContableTipoConstantesFunciones.DIGITOVERIFICADOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableTipoConstantesFunciones.LABEL_IDTIPOCUENTACONTABLETIPO, CuentaContableTipoConstantesFunciones.IDTIPOCUENTACONTABLETIPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableTipoConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO, CuentaContableTipoConstantesFunciones.IDTIPOPRODUCTOSERVICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableTipoConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA, CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableTipoConstantesFunciones.LABEL_IDCUENTACONTABLEDESCUENTO, CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableTipoConstantesFunciones.LABEL_IDCUENTACONTABLEDEVOLUCION, CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableTipoConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO, CuentaContableTipoConstantesFunciones.IDCUENTACONTABLECOSTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCuentaContableTipo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CuentaContableTipoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableTipoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableTipoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableTipoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableTipoConstantesFunciones.DIGITOVERIFICADOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableTipoConstantesFunciones.IDTIPOCUENTACONTABLETIPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableTipoConstantesFunciones.IDTIPOPRODUCTOSERVICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableTipoConstantesFunciones.IDCUENTACONTABLECOSTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuentaContableTipo() throws Exception  {
		return CuentaContableTipoConstantesFunciones.getTiposSeleccionarCuentaContableTipo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuentaContableTipo(Boolean conFk) throws Exception  {
		return CuentaContableTipoConstantesFunciones.getTiposSeleccionarCuentaContableTipo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuentaContableTipo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableTipoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CuentaContableTipoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableTipoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(CuentaContableTipoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableTipoConstantesFunciones.LABEL_DIGITOVERIFICADOR);
			reporte.setsDescripcion(CuentaContableTipoConstantesFunciones.LABEL_DIGITOVERIFICADOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableTipoConstantesFunciones.LABEL_IDTIPOCUENTACONTABLETIPO);
			reporte.setsDescripcion(CuentaContableTipoConstantesFunciones.LABEL_IDTIPOCUENTACONTABLETIPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableTipoConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO);
			reporte.setsDescripcion(CuentaContableTipoConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableTipoConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA);
			reporte.setsDescripcion(CuentaContableTipoConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableTipoConstantesFunciones.LABEL_IDCUENTACONTABLEDESCUENTO);
			reporte.setsDescripcion(CuentaContableTipoConstantesFunciones.LABEL_IDCUENTACONTABLEDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableTipoConstantesFunciones.LABEL_IDCUENTACONTABLEDEVOLUCION);
			reporte.setsDescripcion(CuentaContableTipoConstantesFunciones.LABEL_IDCUENTACONTABLEDEVOLUCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableTipoConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO);
			reporte.setsDescripcion(CuentaContableTipoConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCuentaContableTipo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCuentaContableTipo(CuentaContableTipo cuentacontabletipoAux) throws Exception {
		
			cuentacontabletipoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cuentacontabletipoAux.getEmpresa()));
			cuentacontabletipoAux.settipocuentacontabletipo_descripcion(TipoCuentaContableTipoConstantesFunciones.getTipoCuentaContableTipoDescripcion(cuentacontabletipoAux.getTipoCuentaContableTipo()));
			cuentacontabletipoAux.settipoproductoservicio_descripcion(TipoProductoServicioConstantesFunciones.getTipoProductoServicioDescripcion(cuentacontabletipoAux.getTipoProductoServicio()));
			cuentacontabletipoAux.setcuentacontableventa_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontabletipoAux.getCuentaContableVenta()));
			cuentacontabletipoAux.setcuentacontabledescuento_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontabletipoAux.getCuentaContableDescuento()));
			cuentacontabletipoAux.setcuentacontabledevolucion_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontabletipoAux.getCuentaContableDevolucion()));
			cuentacontabletipoAux.setcuentacontablecosto_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontabletipoAux.getCuentaContableCosto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCuentaContableTipo(List<CuentaContableTipo> cuentacontabletiposTemp) throws Exception {
		for(CuentaContableTipo cuentacontabletipoAux:cuentacontabletiposTemp) {
			
			cuentacontabletipoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cuentacontabletipoAux.getEmpresa()));
			cuentacontabletipoAux.settipocuentacontabletipo_descripcion(TipoCuentaContableTipoConstantesFunciones.getTipoCuentaContableTipoDescripcion(cuentacontabletipoAux.getTipoCuentaContableTipo()));
			cuentacontabletipoAux.settipoproductoservicio_descripcion(TipoProductoServicioConstantesFunciones.getTipoProductoServicioDescripcion(cuentacontabletipoAux.getTipoProductoServicio()));
			cuentacontabletipoAux.setcuentacontableventa_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontabletipoAux.getCuentaContableVenta()));
			cuentacontabletipoAux.setcuentacontabledescuento_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontabletipoAux.getCuentaContableDescuento()));
			cuentacontabletipoAux.setcuentacontabledevolucion_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontabletipoAux.getCuentaContableDevolucion()));
			cuentacontabletipoAux.setcuentacontablecosto_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontabletipoAux.getCuentaContableCosto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCuentaContableTipo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(TipoCuentaContableTipo.class));
				classes.add(new Classe(TipoProductoServicio.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCuentaContableTipo.class)) {
						classes.add(new Classe(TipoCuentaContableTipo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoProductoServicio.class)) {
						classes.add(new Classe(TipoProductoServicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCuentaContableTipo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoCuentaContableTipo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCuentaContableTipo.class)); continue;
					}

					if(TipoProductoServicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProductoServicio.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoCuentaContableTipo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCuentaContableTipo.class)); continue;
					}

					if(TipoProductoServicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoProductoServicio.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuentaContableTipo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CuentaContableTipoConstantesFunciones.getClassesRelationshipsOfCuentaContableTipo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuentaContableTipo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCuentaContableTipo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CuentaContableTipoConstantesFunciones.getClassesRelationshipsFromStringsOfCuentaContableTipo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCuentaContableTipo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CuentaContableTipo cuentacontabletipo,List<CuentaContableTipo> cuentacontabletipos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CuentaContableTipo cuentacontabletipoEncontrado=null;
			
			for(CuentaContableTipo cuentacontabletipoLocal:cuentacontabletipos) {
				if(cuentacontabletipoLocal.getId().equals(cuentacontabletipo.getId())) {
					cuentacontabletipoEncontrado=cuentacontabletipoLocal;
					
					cuentacontabletipoLocal.setIsChanged(cuentacontabletipo.getIsChanged());
					cuentacontabletipoLocal.setIsNew(cuentacontabletipo.getIsNew());
					cuentacontabletipoLocal.setIsDeleted(cuentacontabletipo.getIsDeleted());
					
					cuentacontabletipoLocal.setGeneralEntityOriginal(cuentacontabletipo.getGeneralEntityOriginal());
					
					cuentacontabletipoLocal.setId(cuentacontabletipo.getId());	
					cuentacontabletipoLocal.setVersionRow(cuentacontabletipo.getVersionRow());	
					cuentacontabletipoLocal.setid_empresa(cuentacontabletipo.getid_empresa());	
					cuentacontabletipoLocal.setnombre(cuentacontabletipo.getnombre());	
					cuentacontabletipoLocal.setdigito_verificador(cuentacontabletipo.getdigito_verificador());	
					cuentacontabletipoLocal.setid_tipo_cuenta_contable_tipo(cuentacontabletipo.getid_tipo_cuenta_contable_tipo());	
					cuentacontabletipoLocal.setid_tipo_producto_servicio(cuentacontabletipo.getid_tipo_producto_servicio());	
					cuentacontabletipoLocal.setid_cuenta_contable_venta(cuentacontabletipo.getid_cuenta_contable_venta());	
					cuentacontabletipoLocal.setid_cuenta_contable_descuento(cuentacontabletipo.getid_cuenta_contable_descuento());	
					cuentacontabletipoLocal.setid_cuenta_contable_devolucion(cuentacontabletipo.getid_cuenta_contable_devolucion());	
					cuentacontabletipoLocal.setid_cuenta_contable_costo(cuentacontabletipo.getid_cuenta_contable_costo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!cuentacontabletipo.getIsDeleted()) {
				if(!existe) {
					cuentacontabletipos.add(cuentacontabletipo);
				}
			} else {
				if(cuentacontabletipoEncontrado!=null && permiteQuitar)  {
					cuentacontabletipos.remove(cuentacontabletipoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CuentaContableTipo cuentacontabletipo,List<CuentaContableTipo> cuentacontabletipos) throws Exception {
		try	{			
			for(CuentaContableTipo cuentacontabletipoLocal:cuentacontabletipos) {
				if(cuentacontabletipoLocal.getId().equals(cuentacontabletipo.getId())) {
					cuentacontabletipoLocal.setIsSelected(cuentacontabletipo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCuentaContableTipo(List<CuentaContableTipo> cuentacontabletiposAux) throws Exception {
		//this.cuentacontabletiposAux=cuentacontabletiposAux;
		
		for(CuentaContableTipo cuentacontabletipoAux:cuentacontabletiposAux) {
			if(cuentacontabletipoAux.getIsChanged()) {
				cuentacontabletipoAux.setIsChanged(false);
			}		
			
			if(cuentacontabletipoAux.getIsNew()) {
				cuentacontabletipoAux.setIsNew(false);
			}	
			
			if(cuentacontabletipoAux.getIsDeleted()) {
				cuentacontabletipoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCuentaContableTipo(CuentaContableTipo cuentacontabletipoAux) throws Exception {
		//this.cuentacontabletipoAux=cuentacontabletipoAux;
		
			if(cuentacontabletipoAux.getIsChanged()) {
				cuentacontabletipoAux.setIsChanged(false);
			}		
			
			if(cuentacontabletipoAux.getIsNew()) {
				cuentacontabletipoAux.setIsNew(false);
			}	
			
			if(cuentacontabletipoAux.getIsDeleted()) {
				cuentacontabletipoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CuentaContableTipo cuentacontabletipoAsignar,CuentaContableTipo cuentacontabletipo) throws Exception {
		cuentacontabletipoAsignar.setId(cuentacontabletipo.getId());	
		cuentacontabletipoAsignar.setVersionRow(cuentacontabletipo.getVersionRow());	
		cuentacontabletipoAsignar.setid_empresa(cuentacontabletipo.getid_empresa());
		cuentacontabletipoAsignar.setempresa_descripcion(cuentacontabletipo.getempresa_descripcion());	
		cuentacontabletipoAsignar.setnombre(cuentacontabletipo.getnombre());	
		cuentacontabletipoAsignar.setdigito_verificador(cuentacontabletipo.getdigito_verificador());	
		cuentacontabletipoAsignar.setid_tipo_cuenta_contable_tipo(cuentacontabletipo.getid_tipo_cuenta_contable_tipo());
		cuentacontabletipoAsignar.settipocuentacontabletipo_descripcion(cuentacontabletipo.gettipocuentacontabletipo_descripcion());	
		cuentacontabletipoAsignar.setid_tipo_producto_servicio(cuentacontabletipo.getid_tipo_producto_servicio());
		cuentacontabletipoAsignar.settipoproductoservicio_descripcion(cuentacontabletipo.gettipoproductoservicio_descripcion());	
		cuentacontabletipoAsignar.setid_cuenta_contable_venta(cuentacontabletipo.getid_cuenta_contable_venta());
		cuentacontabletipoAsignar.setcuentacontableventa_descripcion(cuentacontabletipo.getcuentacontableventa_descripcion());	
		cuentacontabletipoAsignar.setid_cuenta_contable_descuento(cuentacontabletipo.getid_cuenta_contable_descuento());
		cuentacontabletipoAsignar.setcuentacontabledescuento_descripcion(cuentacontabletipo.getcuentacontabledescuento_descripcion());	
		cuentacontabletipoAsignar.setid_cuenta_contable_devolucion(cuentacontabletipo.getid_cuenta_contable_devolucion());
		cuentacontabletipoAsignar.setcuentacontabledevolucion_descripcion(cuentacontabletipo.getcuentacontabledevolucion_descripcion());	
		cuentacontabletipoAsignar.setid_cuenta_contable_costo(cuentacontabletipo.getid_cuenta_contable_costo());
		cuentacontabletipoAsignar.setcuentacontablecosto_descripcion(cuentacontabletipo.getcuentacontablecosto_descripcion());	
	}
	
	public static void inicializarCuentaContableTipo(CuentaContableTipo cuentacontabletipo) throws Exception {
		try {
				cuentacontabletipo.setId(0L);	
					
				cuentacontabletipo.setid_empresa(-1L);	
				cuentacontabletipo.setnombre("");	
				cuentacontabletipo.setdigito_verificador(0);	
				cuentacontabletipo.setid_tipo_cuenta_contable_tipo(-1L);	
				cuentacontabletipo.setid_tipo_producto_servicio(-1L);	
				cuentacontabletipo.setid_cuenta_contable_venta(null);	
				cuentacontabletipo.setid_cuenta_contable_descuento(null);	
				cuentacontabletipo.setid_cuenta_contable_devolucion(null);	
				cuentacontabletipo.setid_cuenta_contable_costo(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCuentaContableTipo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableTipoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableTipoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableTipoConstantesFunciones.LABEL_DIGITOVERIFICADOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableTipoConstantesFunciones.LABEL_IDTIPOCUENTACONTABLETIPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableTipoConstantesFunciones.LABEL_IDTIPOPRODUCTOSERVICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableTipoConstantesFunciones.LABEL_IDCUENTACONTABLEVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableTipoConstantesFunciones.LABEL_IDCUENTACONTABLEDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableTipoConstantesFunciones.LABEL_IDCUENTACONTABLEDEVOLUCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableTipoConstantesFunciones.LABEL_IDCUENTACONTABLECOSTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCuentaContableTipo(String sTipo,Row row,Workbook workbook,CuentaContableTipo cuentacontabletipo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacontabletipo.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacontabletipo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacontabletipo.getdigito_verificador());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacontabletipo.gettipocuentacontabletipo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacontabletipo.gettipoproductoservicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacontabletipo.getcuentacontableventa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacontabletipo.getcuentacontabledescuento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacontabletipo.getcuentacontabledevolucion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacontabletipo.getcuentacontablecosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCuentaContableTipo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCuentaContableTipo() {
		return this.sFinalQueryCuentaContableTipo;
	}
	
	public void setsFinalQueryCuentaContableTipo(String sFinalQueryCuentaContableTipo) {
		this.sFinalQueryCuentaContableTipo= sFinalQueryCuentaContableTipo;
	}
	
	public Border resaltarSeleccionarCuentaContableTipo=null;
	
	public Border setResaltarSeleccionarCuentaContableTipo(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableTipoBeanSwingJInternalFrame cuentacontabletipoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cuentacontabletipoBeanSwingJInternalFrame.jTtoolBarCuentaContableTipo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCuentaContableTipo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCuentaContableTipo() {
		return this.resaltarSeleccionarCuentaContableTipo;
	}
	
	public void setResaltarSeleccionarCuentaContableTipo(Border borderResaltarSeleccionarCuentaContableTipo) {
		this.resaltarSeleccionarCuentaContableTipo= borderResaltarSeleccionarCuentaContableTipo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCuentaContableTipo=null;
	public Boolean mostraridCuentaContableTipo=true;
	public Boolean activaridCuentaContableTipo=true;

	public Border resaltarid_empresaCuentaContableTipo=null;
	public Boolean mostrarid_empresaCuentaContableTipo=true;
	public Boolean activarid_empresaCuentaContableTipo=true;
	public Boolean cargarid_empresaCuentaContableTipo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCuentaContableTipo=false;//ConEventDepend=true

	public Border resaltarnombreCuentaContableTipo=null;
	public Boolean mostrarnombreCuentaContableTipo=true;
	public Boolean activarnombreCuentaContableTipo=true;

	public Border resaltardigito_verificadorCuentaContableTipo=null;
	public Boolean mostrardigito_verificadorCuentaContableTipo=true;
	public Boolean activardigito_verificadorCuentaContableTipo=true;

	public Border resaltarid_tipo_cuenta_contable_tipoCuentaContableTipo=null;
	public Boolean mostrarid_tipo_cuenta_contable_tipoCuentaContableTipo=true;
	public Boolean activarid_tipo_cuenta_contable_tipoCuentaContableTipo=true;
	public Boolean cargarid_tipo_cuenta_contable_tipoCuentaContableTipo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_cuenta_contable_tipoCuentaContableTipo=false;//ConEventDepend=true

	public Border resaltarid_tipo_producto_servicioCuentaContableTipo=null;
	public Boolean mostrarid_tipo_producto_servicioCuentaContableTipo=true;
	public Boolean activarid_tipo_producto_servicioCuentaContableTipo=true;
	public Boolean cargarid_tipo_producto_servicioCuentaContableTipo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_producto_servicioCuentaContableTipo=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_ventaCuentaContableTipo=null;
	public Boolean mostrarid_cuenta_contable_ventaCuentaContableTipo=true;
	public Boolean activarid_cuenta_contable_ventaCuentaContableTipo=true;
	public Boolean cargarid_cuenta_contable_ventaCuentaContableTipo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_ventaCuentaContableTipo=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_descuentoCuentaContableTipo=null;
	public Boolean mostrarid_cuenta_contable_descuentoCuentaContableTipo=true;
	public Boolean activarid_cuenta_contable_descuentoCuentaContableTipo=true;
	public Boolean cargarid_cuenta_contable_descuentoCuentaContableTipo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_descuentoCuentaContableTipo=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_devolucionCuentaContableTipo=null;
	public Boolean mostrarid_cuenta_contable_devolucionCuentaContableTipo=true;
	public Boolean activarid_cuenta_contable_devolucionCuentaContableTipo=true;
	public Boolean cargarid_cuenta_contable_devolucionCuentaContableTipo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_devolucionCuentaContableTipo=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_costoCuentaContableTipo=null;
	public Boolean mostrarid_cuenta_contable_costoCuentaContableTipo=true;
	public Boolean activarid_cuenta_contable_costoCuentaContableTipo=true;
	public Boolean cargarid_cuenta_contable_costoCuentaContableTipo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_costoCuentaContableTipo=false;//ConEventDepend=true

	
	

	public Border setResaltaridCuentaContableTipo(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableTipoBeanSwingJInternalFrame cuentacontabletipoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontabletipoBeanSwingJInternalFrame.jTtoolBarCuentaContableTipo.setBorder(borderResaltar);
		
		this.resaltaridCuentaContableTipo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCuentaContableTipo() {
		return this.resaltaridCuentaContableTipo;
	}

	public void setResaltaridCuentaContableTipo(Border borderResaltar) {
		this.resaltaridCuentaContableTipo= borderResaltar;
	}

	public Boolean getMostraridCuentaContableTipo() {
		return this.mostraridCuentaContableTipo;
	}

	public void setMostraridCuentaContableTipo(Boolean mostraridCuentaContableTipo) {
		this.mostraridCuentaContableTipo= mostraridCuentaContableTipo;
	}

	public Boolean getActivaridCuentaContableTipo() {
		return this.activaridCuentaContableTipo;
	}

	public void setActivaridCuentaContableTipo(Boolean activaridCuentaContableTipo) {
		this.activaridCuentaContableTipo= activaridCuentaContableTipo;
	}

	public Border setResaltarid_empresaCuentaContableTipo(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableTipoBeanSwingJInternalFrame cuentacontabletipoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontabletipoBeanSwingJInternalFrame.jTtoolBarCuentaContableTipo.setBorder(borderResaltar);
		
		this.resaltarid_empresaCuentaContableTipo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCuentaContableTipo() {
		return this.resaltarid_empresaCuentaContableTipo;
	}

	public void setResaltarid_empresaCuentaContableTipo(Border borderResaltar) {
		this.resaltarid_empresaCuentaContableTipo= borderResaltar;
	}

	public Boolean getMostrarid_empresaCuentaContableTipo() {
		return this.mostrarid_empresaCuentaContableTipo;
	}

	public void setMostrarid_empresaCuentaContableTipo(Boolean mostrarid_empresaCuentaContableTipo) {
		this.mostrarid_empresaCuentaContableTipo= mostrarid_empresaCuentaContableTipo;
	}

	public Boolean getActivarid_empresaCuentaContableTipo() {
		return this.activarid_empresaCuentaContableTipo;
	}

	public void setActivarid_empresaCuentaContableTipo(Boolean activarid_empresaCuentaContableTipo) {
		this.activarid_empresaCuentaContableTipo= activarid_empresaCuentaContableTipo;
	}

	public Boolean getCargarid_empresaCuentaContableTipo() {
		return this.cargarid_empresaCuentaContableTipo;
	}

	public void setCargarid_empresaCuentaContableTipo(Boolean cargarid_empresaCuentaContableTipo) {
		this.cargarid_empresaCuentaContableTipo= cargarid_empresaCuentaContableTipo;
	}

	public Border setResaltarnombreCuentaContableTipo(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableTipoBeanSwingJInternalFrame cuentacontabletipoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontabletipoBeanSwingJInternalFrame.jTtoolBarCuentaContableTipo.setBorder(borderResaltar);
		
		this.resaltarnombreCuentaContableTipo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreCuentaContableTipo() {
		return this.resaltarnombreCuentaContableTipo;
	}

	public void setResaltarnombreCuentaContableTipo(Border borderResaltar) {
		this.resaltarnombreCuentaContableTipo= borderResaltar;
	}

	public Boolean getMostrarnombreCuentaContableTipo() {
		return this.mostrarnombreCuentaContableTipo;
	}

	public void setMostrarnombreCuentaContableTipo(Boolean mostrarnombreCuentaContableTipo) {
		this.mostrarnombreCuentaContableTipo= mostrarnombreCuentaContableTipo;
	}

	public Boolean getActivarnombreCuentaContableTipo() {
		return this.activarnombreCuentaContableTipo;
	}

	public void setActivarnombreCuentaContableTipo(Boolean activarnombreCuentaContableTipo) {
		this.activarnombreCuentaContableTipo= activarnombreCuentaContableTipo;
	}

	public Border setResaltardigito_verificadorCuentaContableTipo(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableTipoBeanSwingJInternalFrame cuentacontabletipoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontabletipoBeanSwingJInternalFrame.jTtoolBarCuentaContableTipo.setBorder(borderResaltar);
		
		this.resaltardigito_verificadorCuentaContableTipo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardigito_verificadorCuentaContableTipo() {
		return this.resaltardigito_verificadorCuentaContableTipo;
	}

	public void setResaltardigito_verificadorCuentaContableTipo(Border borderResaltar) {
		this.resaltardigito_verificadorCuentaContableTipo= borderResaltar;
	}

	public Boolean getMostrardigito_verificadorCuentaContableTipo() {
		return this.mostrardigito_verificadorCuentaContableTipo;
	}

	public void setMostrardigito_verificadorCuentaContableTipo(Boolean mostrardigito_verificadorCuentaContableTipo) {
		this.mostrardigito_verificadorCuentaContableTipo= mostrardigito_verificadorCuentaContableTipo;
	}

	public Boolean getActivardigito_verificadorCuentaContableTipo() {
		return this.activardigito_verificadorCuentaContableTipo;
	}

	public void setActivardigito_verificadorCuentaContableTipo(Boolean activardigito_verificadorCuentaContableTipo) {
		this.activardigito_verificadorCuentaContableTipo= activardigito_verificadorCuentaContableTipo;
	}

	public Border setResaltarid_tipo_cuenta_contable_tipoCuentaContableTipo(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableTipoBeanSwingJInternalFrame cuentacontabletipoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontabletipoBeanSwingJInternalFrame.jTtoolBarCuentaContableTipo.setBorder(borderResaltar);
		
		this.resaltarid_tipo_cuenta_contable_tipoCuentaContableTipo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_cuenta_contable_tipoCuentaContableTipo() {
		return this.resaltarid_tipo_cuenta_contable_tipoCuentaContableTipo;
	}

	public void setResaltarid_tipo_cuenta_contable_tipoCuentaContableTipo(Border borderResaltar) {
		this.resaltarid_tipo_cuenta_contable_tipoCuentaContableTipo= borderResaltar;
	}

	public Boolean getMostrarid_tipo_cuenta_contable_tipoCuentaContableTipo() {
		return this.mostrarid_tipo_cuenta_contable_tipoCuentaContableTipo;
	}

	public void setMostrarid_tipo_cuenta_contable_tipoCuentaContableTipo(Boolean mostrarid_tipo_cuenta_contable_tipoCuentaContableTipo) {
		this.mostrarid_tipo_cuenta_contable_tipoCuentaContableTipo= mostrarid_tipo_cuenta_contable_tipoCuentaContableTipo;
	}

	public Boolean getActivarid_tipo_cuenta_contable_tipoCuentaContableTipo() {
		return this.activarid_tipo_cuenta_contable_tipoCuentaContableTipo;
	}

	public void setActivarid_tipo_cuenta_contable_tipoCuentaContableTipo(Boolean activarid_tipo_cuenta_contable_tipoCuentaContableTipo) {
		this.activarid_tipo_cuenta_contable_tipoCuentaContableTipo= activarid_tipo_cuenta_contable_tipoCuentaContableTipo;
	}

	public Boolean getCargarid_tipo_cuenta_contable_tipoCuentaContableTipo() {
		return this.cargarid_tipo_cuenta_contable_tipoCuentaContableTipo;
	}

	public void setCargarid_tipo_cuenta_contable_tipoCuentaContableTipo(Boolean cargarid_tipo_cuenta_contable_tipoCuentaContableTipo) {
		this.cargarid_tipo_cuenta_contable_tipoCuentaContableTipo= cargarid_tipo_cuenta_contable_tipoCuentaContableTipo;
	}

	public Border setResaltarid_tipo_producto_servicioCuentaContableTipo(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableTipoBeanSwingJInternalFrame cuentacontabletipoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontabletipoBeanSwingJInternalFrame.jTtoolBarCuentaContableTipo.setBorder(borderResaltar);
		
		this.resaltarid_tipo_producto_servicioCuentaContableTipo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_producto_servicioCuentaContableTipo() {
		return this.resaltarid_tipo_producto_servicioCuentaContableTipo;
	}

	public void setResaltarid_tipo_producto_servicioCuentaContableTipo(Border borderResaltar) {
		this.resaltarid_tipo_producto_servicioCuentaContableTipo= borderResaltar;
	}

	public Boolean getMostrarid_tipo_producto_servicioCuentaContableTipo() {
		return this.mostrarid_tipo_producto_servicioCuentaContableTipo;
	}

	public void setMostrarid_tipo_producto_servicioCuentaContableTipo(Boolean mostrarid_tipo_producto_servicioCuentaContableTipo) {
		this.mostrarid_tipo_producto_servicioCuentaContableTipo= mostrarid_tipo_producto_servicioCuentaContableTipo;
	}

	public Boolean getActivarid_tipo_producto_servicioCuentaContableTipo() {
		return this.activarid_tipo_producto_servicioCuentaContableTipo;
	}

	public void setActivarid_tipo_producto_servicioCuentaContableTipo(Boolean activarid_tipo_producto_servicioCuentaContableTipo) {
		this.activarid_tipo_producto_servicioCuentaContableTipo= activarid_tipo_producto_servicioCuentaContableTipo;
	}

	public Boolean getCargarid_tipo_producto_servicioCuentaContableTipo() {
		return this.cargarid_tipo_producto_servicioCuentaContableTipo;
	}

	public void setCargarid_tipo_producto_servicioCuentaContableTipo(Boolean cargarid_tipo_producto_servicioCuentaContableTipo) {
		this.cargarid_tipo_producto_servicioCuentaContableTipo= cargarid_tipo_producto_servicioCuentaContableTipo;
	}

	public Border setResaltarid_cuenta_contable_ventaCuentaContableTipo(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableTipoBeanSwingJInternalFrame cuentacontabletipoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontabletipoBeanSwingJInternalFrame.jTtoolBarCuentaContableTipo.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_ventaCuentaContableTipo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_ventaCuentaContableTipo() {
		return this.resaltarid_cuenta_contable_ventaCuentaContableTipo;
	}

	public void setResaltarid_cuenta_contable_ventaCuentaContableTipo(Border borderResaltar) {
		this.resaltarid_cuenta_contable_ventaCuentaContableTipo= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_ventaCuentaContableTipo() {
		return this.mostrarid_cuenta_contable_ventaCuentaContableTipo;
	}

	public void setMostrarid_cuenta_contable_ventaCuentaContableTipo(Boolean mostrarid_cuenta_contable_ventaCuentaContableTipo) {
		this.mostrarid_cuenta_contable_ventaCuentaContableTipo= mostrarid_cuenta_contable_ventaCuentaContableTipo;
	}

	public Boolean getActivarid_cuenta_contable_ventaCuentaContableTipo() {
		return this.activarid_cuenta_contable_ventaCuentaContableTipo;
	}

	public void setActivarid_cuenta_contable_ventaCuentaContableTipo(Boolean activarid_cuenta_contable_ventaCuentaContableTipo) {
		this.activarid_cuenta_contable_ventaCuentaContableTipo= activarid_cuenta_contable_ventaCuentaContableTipo;
	}

	public Boolean getCargarid_cuenta_contable_ventaCuentaContableTipo() {
		return this.cargarid_cuenta_contable_ventaCuentaContableTipo;
	}

	public void setCargarid_cuenta_contable_ventaCuentaContableTipo(Boolean cargarid_cuenta_contable_ventaCuentaContableTipo) {
		this.cargarid_cuenta_contable_ventaCuentaContableTipo= cargarid_cuenta_contable_ventaCuentaContableTipo;
	}

	public Border setResaltarid_cuenta_contable_descuentoCuentaContableTipo(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableTipoBeanSwingJInternalFrame cuentacontabletipoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontabletipoBeanSwingJInternalFrame.jTtoolBarCuentaContableTipo.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_descuentoCuentaContableTipo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_descuentoCuentaContableTipo() {
		return this.resaltarid_cuenta_contable_descuentoCuentaContableTipo;
	}

	public void setResaltarid_cuenta_contable_descuentoCuentaContableTipo(Border borderResaltar) {
		this.resaltarid_cuenta_contable_descuentoCuentaContableTipo= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_descuentoCuentaContableTipo() {
		return this.mostrarid_cuenta_contable_descuentoCuentaContableTipo;
	}

	public void setMostrarid_cuenta_contable_descuentoCuentaContableTipo(Boolean mostrarid_cuenta_contable_descuentoCuentaContableTipo) {
		this.mostrarid_cuenta_contable_descuentoCuentaContableTipo= mostrarid_cuenta_contable_descuentoCuentaContableTipo;
	}

	public Boolean getActivarid_cuenta_contable_descuentoCuentaContableTipo() {
		return this.activarid_cuenta_contable_descuentoCuentaContableTipo;
	}

	public void setActivarid_cuenta_contable_descuentoCuentaContableTipo(Boolean activarid_cuenta_contable_descuentoCuentaContableTipo) {
		this.activarid_cuenta_contable_descuentoCuentaContableTipo= activarid_cuenta_contable_descuentoCuentaContableTipo;
	}

	public Boolean getCargarid_cuenta_contable_descuentoCuentaContableTipo() {
		return this.cargarid_cuenta_contable_descuentoCuentaContableTipo;
	}

	public void setCargarid_cuenta_contable_descuentoCuentaContableTipo(Boolean cargarid_cuenta_contable_descuentoCuentaContableTipo) {
		this.cargarid_cuenta_contable_descuentoCuentaContableTipo= cargarid_cuenta_contable_descuentoCuentaContableTipo;
	}

	public Border setResaltarid_cuenta_contable_devolucionCuentaContableTipo(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableTipoBeanSwingJInternalFrame cuentacontabletipoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontabletipoBeanSwingJInternalFrame.jTtoolBarCuentaContableTipo.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_devolucionCuentaContableTipo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_devolucionCuentaContableTipo() {
		return this.resaltarid_cuenta_contable_devolucionCuentaContableTipo;
	}

	public void setResaltarid_cuenta_contable_devolucionCuentaContableTipo(Border borderResaltar) {
		this.resaltarid_cuenta_contable_devolucionCuentaContableTipo= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_devolucionCuentaContableTipo() {
		return this.mostrarid_cuenta_contable_devolucionCuentaContableTipo;
	}

	public void setMostrarid_cuenta_contable_devolucionCuentaContableTipo(Boolean mostrarid_cuenta_contable_devolucionCuentaContableTipo) {
		this.mostrarid_cuenta_contable_devolucionCuentaContableTipo= mostrarid_cuenta_contable_devolucionCuentaContableTipo;
	}

	public Boolean getActivarid_cuenta_contable_devolucionCuentaContableTipo() {
		return this.activarid_cuenta_contable_devolucionCuentaContableTipo;
	}

	public void setActivarid_cuenta_contable_devolucionCuentaContableTipo(Boolean activarid_cuenta_contable_devolucionCuentaContableTipo) {
		this.activarid_cuenta_contable_devolucionCuentaContableTipo= activarid_cuenta_contable_devolucionCuentaContableTipo;
	}

	public Boolean getCargarid_cuenta_contable_devolucionCuentaContableTipo() {
		return this.cargarid_cuenta_contable_devolucionCuentaContableTipo;
	}

	public void setCargarid_cuenta_contable_devolucionCuentaContableTipo(Boolean cargarid_cuenta_contable_devolucionCuentaContableTipo) {
		this.cargarid_cuenta_contable_devolucionCuentaContableTipo= cargarid_cuenta_contable_devolucionCuentaContableTipo;
	}

	public Border setResaltarid_cuenta_contable_costoCuentaContableTipo(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableTipoBeanSwingJInternalFrame cuentacontabletipoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontabletipoBeanSwingJInternalFrame.jTtoolBarCuentaContableTipo.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_costoCuentaContableTipo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_costoCuentaContableTipo() {
		return this.resaltarid_cuenta_contable_costoCuentaContableTipo;
	}

	public void setResaltarid_cuenta_contable_costoCuentaContableTipo(Border borderResaltar) {
		this.resaltarid_cuenta_contable_costoCuentaContableTipo= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_costoCuentaContableTipo() {
		return this.mostrarid_cuenta_contable_costoCuentaContableTipo;
	}

	public void setMostrarid_cuenta_contable_costoCuentaContableTipo(Boolean mostrarid_cuenta_contable_costoCuentaContableTipo) {
		this.mostrarid_cuenta_contable_costoCuentaContableTipo= mostrarid_cuenta_contable_costoCuentaContableTipo;
	}

	public Boolean getActivarid_cuenta_contable_costoCuentaContableTipo() {
		return this.activarid_cuenta_contable_costoCuentaContableTipo;
	}

	public void setActivarid_cuenta_contable_costoCuentaContableTipo(Boolean activarid_cuenta_contable_costoCuentaContableTipo) {
		this.activarid_cuenta_contable_costoCuentaContableTipo= activarid_cuenta_contable_costoCuentaContableTipo;
	}

	public Boolean getCargarid_cuenta_contable_costoCuentaContableTipo() {
		return this.cargarid_cuenta_contable_costoCuentaContableTipo;
	}

	public void setCargarid_cuenta_contable_costoCuentaContableTipo(Boolean cargarid_cuenta_contable_costoCuentaContableTipo) {
		this.cargarid_cuenta_contable_costoCuentaContableTipo= cargarid_cuenta_contable_costoCuentaContableTipo;
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
		
		
		this.setMostraridCuentaContableTipo(esInicial);
		this.setMostrarid_empresaCuentaContableTipo(esInicial);
		this.setMostrarnombreCuentaContableTipo(esInicial);
		this.setMostrardigito_verificadorCuentaContableTipo(esInicial);
		this.setMostrarid_tipo_cuenta_contable_tipoCuentaContableTipo(esInicial);
		this.setMostrarid_tipo_producto_servicioCuentaContableTipo(esInicial);
		this.setMostrarid_cuenta_contable_ventaCuentaContableTipo(esInicial);
		this.setMostrarid_cuenta_contable_descuentoCuentaContableTipo(esInicial);
		this.setMostrarid_cuenta_contable_devolucionCuentaContableTipo(esInicial);
		this.setMostrarid_cuenta_contable_costoCuentaContableTipo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuentaContableTipoConstantesFunciones.ID)) {
				this.setMostraridCuentaContableTipo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableTipoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCuentaContableTipo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableTipoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreCuentaContableTipo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableTipoConstantesFunciones.DIGITOVERIFICADOR)) {
				this.setMostrardigito_verificadorCuentaContableTipo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableTipoConstantesFunciones.IDTIPOCUENTACONTABLETIPO)) {
				this.setMostrarid_tipo_cuenta_contable_tipoCuentaContableTipo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableTipoConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {
				this.setMostrarid_tipo_producto_servicioCuentaContableTipo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEVENTA)) {
				this.setMostrarid_cuenta_contable_ventaCuentaContableTipo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEDESCUENTO)) {
				this.setMostrarid_cuenta_contable_descuentoCuentaContableTipo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION)) {
				this.setMostrarid_cuenta_contable_devolucionCuentaContableTipo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableTipoConstantesFunciones.IDCUENTACONTABLECOSTO)) {
				this.setMostrarid_cuenta_contable_costoCuentaContableTipo(esAsigna);
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
		
		
		this.setActivaridCuentaContableTipo(esInicial);
		this.setActivarid_empresaCuentaContableTipo(esInicial);
		this.setActivarnombreCuentaContableTipo(esInicial);
		this.setActivardigito_verificadorCuentaContableTipo(esInicial);
		this.setActivarid_tipo_cuenta_contable_tipoCuentaContableTipo(esInicial);
		this.setActivarid_tipo_producto_servicioCuentaContableTipo(esInicial);
		this.setActivarid_cuenta_contable_ventaCuentaContableTipo(esInicial);
		this.setActivarid_cuenta_contable_descuentoCuentaContableTipo(esInicial);
		this.setActivarid_cuenta_contable_devolucionCuentaContableTipo(esInicial);
		this.setActivarid_cuenta_contable_costoCuentaContableTipo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuentaContableTipoConstantesFunciones.ID)) {
				this.setActivaridCuentaContableTipo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableTipoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCuentaContableTipo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableTipoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreCuentaContableTipo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableTipoConstantesFunciones.DIGITOVERIFICADOR)) {
				this.setActivardigito_verificadorCuentaContableTipo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableTipoConstantesFunciones.IDTIPOCUENTACONTABLETIPO)) {
				this.setActivarid_tipo_cuenta_contable_tipoCuentaContableTipo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableTipoConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {
				this.setActivarid_tipo_producto_servicioCuentaContableTipo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEVENTA)) {
				this.setActivarid_cuenta_contable_ventaCuentaContableTipo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEDESCUENTO)) {
				this.setActivarid_cuenta_contable_descuentoCuentaContableTipo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION)) {
				this.setActivarid_cuenta_contable_devolucionCuentaContableTipo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableTipoConstantesFunciones.IDCUENTACONTABLECOSTO)) {
				this.setActivarid_cuenta_contable_costoCuentaContableTipo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CuentaContableTipoBeanSwingJInternalFrame cuentacontabletipoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCuentaContableTipo(esInicial);
		this.setResaltarid_empresaCuentaContableTipo(esInicial);
		this.setResaltarnombreCuentaContableTipo(esInicial);
		this.setResaltardigito_verificadorCuentaContableTipo(esInicial);
		this.setResaltarid_tipo_cuenta_contable_tipoCuentaContableTipo(esInicial);
		this.setResaltarid_tipo_producto_servicioCuentaContableTipo(esInicial);
		this.setResaltarid_cuenta_contable_ventaCuentaContableTipo(esInicial);
		this.setResaltarid_cuenta_contable_descuentoCuentaContableTipo(esInicial);
		this.setResaltarid_cuenta_contable_devolucionCuentaContableTipo(esInicial);
		this.setResaltarid_cuenta_contable_costoCuentaContableTipo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuentaContableTipoConstantesFunciones.ID)) {
				this.setResaltaridCuentaContableTipo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableTipoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCuentaContableTipo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableTipoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreCuentaContableTipo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableTipoConstantesFunciones.DIGITOVERIFICADOR)) {
				this.setResaltardigito_verificadorCuentaContableTipo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableTipoConstantesFunciones.IDTIPOCUENTACONTABLETIPO)) {
				this.setResaltarid_tipo_cuenta_contable_tipoCuentaContableTipo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableTipoConstantesFunciones.IDTIPOPRODUCTOSERVICIO)) {
				this.setResaltarid_tipo_producto_servicioCuentaContableTipo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEVENTA)) {
				this.setResaltarid_cuenta_contable_ventaCuentaContableTipo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEDESCUENTO)) {
				this.setResaltarid_cuenta_contable_descuentoCuentaContableTipo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION)) {
				this.setResaltarid_cuenta_contable_devolucionCuentaContableTipo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableTipoConstantesFunciones.IDCUENTACONTABLECOSTO)) {
				this.setResaltarid_cuenta_contable_costoCuentaContableTipo(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CuentaContableTipoBeanSwingJInternalFrame cuentacontabletipoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorNombreCuentaContableTipo=true;

	public Boolean getMostrarBusquedaPorNombreCuentaContableTipo() {
		return this.mostrarBusquedaPorNombreCuentaContableTipo;
	}

	public void setMostrarBusquedaPorNombreCuentaContableTipo(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreCuentaContableTipo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCuentaContableTipo=true;

	public Boolean getMostrarFK_IdEmpresaCuentaContableTipo() {
		return this.mostrarFK_IdEmpresaCuentaContableTipo;
	}

	public void setMostrarFK_IdEmpresaCuentaContableTipo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCuentaContableTipo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoCuentaContableTipoCuentaContableTipo=true;

	public Boolean getMostrarFK_IdTipoCuentaContableTipoCuentaContableTipo() {
		return this.mostrarFK_IdTipoCuentaContableTipoCuentaContableTipo;
	}

	public void setMostrarFK_IdTipoCuentaContableTipoCuentaContableTipo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoCuentaContableTipoCuentaContableTipo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoProductoServicioCuentaContableTipo=true;

	public Boolean getMostrarFK_IdTipoProductoServicioCuentaContableTipo() {
		return this.mostrarFK_IdTipoProductoServicioCuentaContableTipo;
	}

	public void setMostrarFK_IdTipoProductoServicioCuentaContableTipo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoProductoServicioCuentaContableTipo= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreCuentaContableTipo=true;

	public Boolean getActivarBusquedaPorNombreCuentaContableTipo() {
		return this.activarBusquedaPorNombreCuentaContableTipo;
	}

	public void setActivarBusquedaPorNombreCuentaContableTipo(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreCuentaContableTipo= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCuentaContableTipo=true;

	public Boolean getActivarFK_IdEmpresaCuentaContableTipo() {
		return this.activarFK_IdEmpresaCuentaContableTipo;
	}

	public void setActivarFK_IdEmpresaCuentaContableTipo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCuentaContableTipo= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoCuentaContableTipoCuentaContableTipo=true;

	public Boolean getActivarFK_IdTipoCuentaContableTipoCuentaContableTipo() {
		return this.activarFK_IdTipoCuentaContableTipoCuentaContableTipo;
	}

	public void setActivarFK_IdTipoCuentaContableTipoCuentaContableTipo(Boolean habilitarResaltar) {
		this.activarFK_IdTipoCuentaContableTipoCuentaContableTipo= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoProductoServicioCuentaContableTipo=true;

	public Boolean getActivarFK_IdTipoProductoServicioCuentaContableTipo() {
		return this.activarFK_IdTipoProductoServicioCuentaContableTipo;
	}

	public void setActivarFK_IdTipoProductoServicioCuentaContableTipo(Boolean habilitarResaltar) {
		this.activarFK_IdTipoProductoServicioCuentaContableTipo= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreCuentaContableTipo=null;

	public Border getResaltarBusquedaPorNombreCuentaContableTipo() {
		return this.resaltarBusquedaPorNombreCuentaContableTipo;
	}

	public void setResaltarBusquedaPorNombreCuentaContableTipo(Border borderResaltar) {
		this.resaltarBusquedaPorNombreCuentaContableTipo= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreCuentaContableTipo(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableTipoBeanSwingJInternalFrame cuentacontabletipoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreCuentaContableTipo= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCuentaContableTipo=null;

	public Border getResaltarFK_IdEmpresaCuentaContableTipo() {
		return this.resaltarFK_IdEmpresaCuentaContableTipo;
	}

	public void setResaltarFK_IdEmpresaCuentaContableTipo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCuentaContableTipo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCuentaContableTipo(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableTipoBeanSwingJInternalFrame cuentacontabletipoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCuentaContableTipo= borderResaltar;
	}

	public Border resaltarFK_IdTipoCuentaContableTipoCuentaContableTipo=null;

	public Border getResaltarFK_IdTipoCuentaContableTipoCuentaContableTipo() {
		return this.resaltarFK_IdTipoCuentaContableTipoCuentaContableTipo;
	}

	public void setResaltarFK_IdTipoCuentaContableTipoCuentaContableTipo(Border borderResaltar) {
		this.resaltarFK_IdTipoCuentaContableTipoCuentaContableTipo= borderResaltar;
	}

	public void setResaltarFK_IdTipoCuentaContableTipoCuentaContableTipo(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableTipoBeanSwingJInternalFrame cuentacontabletipoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoCuentaContableTipoCuentaContableTipo= borderResaltar;
	}

	public Border resaltarFK_IdTipoProductoServicioCuentaContableTipo=null;

	public Border getResaltarFK_IdTipoProductoServicioCuentaContableTipo() {
		return this.resaltarFK_IdTipoProductoServicioCuentaContableTipo;
	}

	public void setResaltarFK_IdTipoProductoServicioCuentaContableTipo(Border borderResaltar) {
		this.resaltarFK_IdTipoProductoServicioCuentaContableTipo= borderResaltar;
	}

	public void setResaltarFK_IdTipoProductoServicioCuentaContableTipo(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableTipoBeanSwingJInternalFrame cuentacontabletipoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoProductoServicioCuentaContableTipo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}